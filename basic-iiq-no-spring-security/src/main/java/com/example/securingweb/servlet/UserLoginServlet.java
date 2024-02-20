package com.example.securingweb.servlet;

import com.example.securingweb.h2.*;
import com.example.securingweb.util.EncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "UserLoginServlet", urlPatterns = "/u_login")
public class UserLoginServlet extends HttpServlet {

    private DatabaseUserDetailsService databaseUserDetails;

    public UserLoginServlet(){
    }

    @Autowired
    public UserLoginServlet(DatabaseUserDetailsService databaseUserDetails){
        this.databaseUserDetails = databaseUserDetails;
    }

    @Override
    public void init() {
        // If not using constructor injection, obtain the Spring context manually
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        // Access the Spring-managed bean
        databaseUserDetails = context.getBean(DatabaseUserDetailsService.class);
        // ...
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            String encodedPwd = EncoderUtil.getSHA256(request.getParameter("password"));
            CustomUserDetails details = databaseUserDetails.loadUserByUsername(request.getParameter("userId").toString());
            session.setAttribute("principal",details);
            session.setAttribute("roles",details.getAuthorities().stream().map(Role::getRole).collect(Collectors.joining(", ")));
            if(!encodedPwd.equals(details.getPassword())){
                throw new BadPasswordException("Invalid Password for " + details.getUsername());
            }

        } catch (UsernameNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        session.setAttribute("userId", request.getParameter("userId"));


        request.setAttribute("id", session.getAttribute("userId"));

        request.getRequestDispatcher("/WEB-INF/jsp/userlogin.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("sampleKey", "Sample Value");

        String uiColor = request.getParameter("color");
        String userName = request.getParameter("name");

        Cookie uiColorCookie = new Cookie("uiColor", uiColor);
        response.addCookie(uiColorCookie);

        Cookie userNameCookie = new Cookie("userName", userName);
        response.addCookie(userNameCookie);

        response.sendRedirect("/welcome");
    }

}
