package com.tom.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/4/11
 */
@WebServlet("/hello")
@Slf4j
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("using SimpleServletHandlerAdapter as HandlerAdaptor for servlet");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/forwarded");
        dispatcher.forward(req, resp);
    }

}