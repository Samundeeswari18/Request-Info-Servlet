package com.sam.requestinfoservelets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "requestInfoServlet", value = "/request-info")
public class RequestInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Set the response content type
        response.setContentType("text/html");

        //Get the write to send response back to the client
        PrintWriter out = response.getWriter();

        //Get and print request method
        String method=request.getMethod();
        out.println("<h3>Request Method"+method+"</h3>");

        //get and print request url
        String url=request.getRequestURI().toString();
        out.println("<h3>Request Url"+url+"</h3>");

        //get and print request headers
        out.println("<h3>Request Headers</h3>");
        Enumeration<String> headerNames=request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName=headerNames.nextElement();
            String headerValue=request.getHeader(headerName);
            out.println("<h3>"+headerName+":"+headerValue+"</h3>");
        }

        out.println("<h3>Request Parameters</h3>");
        Enumeration<String> parameterNames=request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String parameterName=parameterNames.nextElement();
            String parameterValue=request.getParameter(parameterName);
            out.println("<h3>"+parameterName+":"+parameterValue+"</h3>");
        }

        out.println("<h3>Request Body</h3>");
        StringBuilder body=new StringBuilder();
        String line;
        while((line=request.getReader().readLine())!=null){
            body.append(line);

        }
    }
}
