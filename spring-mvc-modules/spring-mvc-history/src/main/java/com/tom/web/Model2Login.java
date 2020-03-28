package com.tom.web;

import com.tom.domain.UserBean;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/3/28
 */
public class Model2Login extends HttpServlet {
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
    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        final String username = req.getParameter("username");
        final String password = req.getParameter("password");
        final UserBean userBean = new UserBean(username, password);
        if (userBean.login()) {
            resp.sendRedirect(req.getContextPath() + "/mvc/success.jsp");
        } else {
            req.setAttribute("user", userBean);
            toLogin(req, resp);
        }
    }

    /**
     * 表现代码，页面展示直接放在我们的servlet里面
     *
     * @param req
     * @param resp
     * @throws IOException
     */
    private void toLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/mvc/login.jsp").forward(req, resp);
    }
}
