package org.se.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class HomeServlet extends HttpServlet
{



    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

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
            HttpSession session=request.getSession();
            session.setAttribute("CurrUser",request.getParameter("uname"));
            String action   =   oData.UserLogin(oUser);
            if(action.equals("LS"))
            {
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

                    response.sendRedirect("index.jsp");
                }
                else
                {
//                  request.setAttribute("loginstat", " Login Failed!");
                    response.sendRedirect("signup_page.jsp");
                }
            }
        }
        else    if(request.getParameter("dataadd") != null)
        {
                Contacts    oCTS    =   new Contacts();
                oCTS.WC_ID("",0);
                oCTS.WU_ID("",Integer.parseInt(request.getParameter("UID")));
                oCTS.WC_Name("",request.getParameter("fname")+" "+request.getParameter("lname"));
                oCTS.WC_Mobile("",request.getParameter("mobnum"));
                oCTS.WC_Type("",request.getParameter("mobtype"));
                HttpSession session=request.getSession();
                session.setAttribute("CurrUser",request.getParameter("uname"));
                oData.AddContact(oCTS);
                response.sendRedirect("homepage.jsp");

        }
        else    if(request.getParameter("DelAccount")   !=    null)
        {
                String UserId   =   request.getParameter("UID");
                oData.DelAccount(UserId);
                response.sendRedirect("index.jsp");
        }

    }

}

