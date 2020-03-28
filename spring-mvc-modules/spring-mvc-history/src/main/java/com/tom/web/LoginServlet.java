
package com.tom.web;

import com.tom.domain.UserBean;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户登陆页
 *
 * @author TomLuo
 * @date 2020/3/28
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * 控制逻辑，根据请求参数选择要执行的功能方法
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String submitFlag = req.getParameter("submitFlag");
        if (StringUtils.equals(submitFlag, "toLogin")) {
            toLogin(req, resp);
            return;
        } else if (StringUtils.equals(submitFlag, "login")) {
            login(req, resp);
            return;
        }
        toLogin(req, resp);
    }

    /**
     * 调用业务对象javabean对象，进行登陆，即模型，不仅包含数据还有行为
     *
     * @param req
     * @param resp
     * @throws IOException
     */
    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String username = req.getParameter("username");
        final String password = req.getParameter("password");
        final UserBean userBean = new UserBean(username, password);
        if (userBean.login()) {
            resp.getWriter().write("login success");
        } else {
            resp.getWriter().write("login failed");
        }
    }

    /**
     * 表现代码，页面展示直接放在我们的servlet里面
     *
     * @param req
     * @param resp
     * @throws IOException
     */
    private void toLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        String loginPath = req.getContextPath() + "/servletLogin";
        final PrintWriter writer = resp.getWriter();
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<form action='" + loginPath + "' method='post'>");
        stringBuffer.append("<input type='hidden' name='submitFlag' value='login'/></br>");
        stringBuffer.append("Username: <input type='text' name='username'/></br>");
        stringBuffer.append("Password: <input type='password' name='password'/></br>");
        stringBuffer.append("<input type='submit' name='login'/></br>");
        stringBuffer.append("</form>");
        writer.write(stringBuffer.toString());
    }
}
