package org.se.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HomeServlet extends HttpServlet
{
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException {
         }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserData    oData   =   new UserData();
        WebUser     oUser   =   null;
        if (request.getParameter("datalg") != null)
        {
            oUser = new WebUser();
            oUser.WU_ID("",0);
            oUser.WU_Name("",request.getParameter("uname"));
            oUser.WU_Password("",request.getParameter("upass"));
            String action   =   oData.UserLogin(oUser);
            if(action.equals("LS"))
            {
//                response.sendRedirect("index.jsp");
                response.sendRedirect("homepage.jsp");
            }
            else
            {
//                request.setAttribute("loginstat", " Login Failed!");
                response.sendRedirect("index.jsp");
            }

        }
        else    if(request.getParameter("datasgn") != null)
        {
            if(request.getParameter("upass").equals(request.getParameter("ucnfpass")))
            {
                oUser = new WebUser();
                oUser.WU_ID("",0);
                oUser.WU_Name("",request.getParameter("uname"));
                oUser.WU_Password("",request.getParameter("upass"));
                String action   =   oData.UserReg(oUser);
                if(action.equals("UC"))
                {
//                  response.sendRedirect("index.jsp");
                    response.sendRedirect("result.jsp");
                }
                else
                {
//                  request.setAttribute("loginstat", " Login Failed!");
                    response.sendRedirect("signup_page.jsp");
                }
            }
        }

    }

}

