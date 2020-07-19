# Java Servlet简介

## 1. 概述
在本文中，我们将研究Java Web开发的一个核心方面-Servlets。

## 2. Servlet和容器
简而言之，Servlet是处理请求，处理业务逻辑并通过响应进行回复的类。

例如，我们可以使用Servlet通过HTML表单收集来自用户的输入，从数据库中查询记录，并动态创建网页。

Servlet受另一个称为Servlet容器的Java应用程序的控制。 当在Web服务器上运行的应用程序收到请求时，服务器会将请求移交给Servlet容器，然后由Servlet容器将其传递给目标Servlet。

## 3. Maven依赖
要在我们的Web应用程序中添加Servlet支持，需要javax.servlet-api依赖项：

```xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.1.0</version>
</dependency>
```
最新的Maven依赖关系可以[在这里](https://mvnrepository.com/artifact/javax.servlet/servlet-api)找到。

当然，我们还必须配置一个Servlet容器以将我们的应用程序部署到； [这是开始如何在Tomcat上部署WAR的好地方](../DevOps/1.如何将WAR文件部署到Tomcat.md)。

## 4. Servlet生命周期
让我们看一下定义Servlet生命周期的方法集。

### 4.1 `init()`
init方法设计为仅被调用一次。如果servlet实例不存在，则Web容器：

加载servlet类
创建servlet类的实例
通过调用init方法初始化它
init方法必须成功完成，然后servlet才能接收任何请求。如果init方法抛出ServletException或在Web服务器定义的时间段内未返回，则servlet容器无法将servlet投入使用。
```java
public void init() throws ServletException {
    // Initialization code like set up database etc....
}
```
### 4.2 `service()`
仅在servlet的init（）方法成功完成后才调用此方法。

容器调用service（）方法来处理来自客户端的请求，解释HTTP请求类型（GET，POST，PUT，DELETE等），并适当地调用doGet，doPost，doPut，doDelete等方法。
```java
public void service(ServletRequest request, ServletResponse response) 
  throws ServletException, IOException {
    // ...
}
```
### 4.3 `destroy()`
由Servlet容器调用以使Servlet退出服务。

仅当servlet的service方法中的所有线程都已退出或经过超时时间后，才调用此方法。容器调用此方法后，它将不再在Servlet上再次调用service方法。
```java
public void destroy() {
    // 
}
```
## 5. Servlet示例
现在，让我们设置一个使用表单处理信息的完整示例。

首先，让我们定义一个带有/ calculateServlet映射的servlet，它将捕获表单发布的信息，并使用RequestDispatcher返回结果：

```java
@WebServlet(name = "FormServlet", urlPatterns = "/calculateServlet")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

        String height = request.getParameter("height");
        String weight = request.getParameter("weight");

        try {
            double bmi = calculateBMI(Double.parseDouble(weight), Double.parseDouble(height));

            request.setAttribute("bmi", bmi);
            response.setHeader("Test", "Success");
            response.setHeader("BMI", String.valueOf(bmi));

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        // do something else here
    }

    private Double calculateBMI(Double weight, Double height) {
        return weight / (height * height);
    }
}
```
如上所示，用@WebServlet注释的类必须扩展javax.servlet.http.HttpServlet类。重要的是要注意，@ WebServlet批注仅从Java EE 6起可用。

@WebServlet批注在部署时由容器处理，并且相应的servlet在指定的URL模式下可用。值得注意的是，通过使用注释定义URL模式，我们可以避免在Servlet映射中使用名为web.xml的XML部署描述符。

如果我们希望映射不带注释的Servlet，则可以改用传统的web.xml：
```xml
    <web-app ...>
     
        <servlet>
           <servlet-name>FormServlet</servlet-name>
           <servlet-class>com.root.FormServlet</servlet-class>
        </servlet>
        <servlet-mapping>
            <servlet-name>FormServlet</servlet-name>
            <url-pattern>/calculateServlet</url-pattern>
        </servlet-mapping>
     
    </web-app>
```
接下来，让我们创建一个基本的HTML表单：
```html
<form name="bmiForm" action="calculateServlet" method="POST">

    <table>
        <tr>
            <td>Your Weight (kg) :</td>
            <td><input type="text" name="weight"/></td>
        </tr>
        <tr>
            <td>Your Height (m) :</td>
            <td><input type="text" name="height"/></td>
        </tr>
        <th><input type="submit" value="Submit" name="find"/></th>
        <th><input type="reset" value="Reset" name="reset" /></th>
    </table>
    <h2>${bmi}</h2>
</form>
```
最后–为了确保一切正常，我们还编写一个快速测试：
```java
public class FormServletLiveTest {
    @Test
    public void whenPostRequestUsingHttpClient_thenCorrect() throws Exception {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost method = new HttpPost("http://localhost:8080/calculateServlet");

        List<BasicNameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("height", String.valueOf(2)));
        nvps.add(new BasicNameValuePair("weight", String.valueOf(80)));

        method.setEntity(new UrlEncodedFormEntity(nvps));
        HttpResponse httpResponse = client.execute(method);

        assertEquals("Success", httpResponse.getHeaders("Test")[0].getValue());
        assertEquals("20.0", httpResponse.getHeaders("BMI")[0].getValue());
    }
}
```