<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Demo-Homepage</title>

</head>
<style>
    html
    {
        background-color    :   #304FFE;
        padding             :   50px;
    }

    .pageList
    {
        float               :   right   !important;
        border-radius       :   8px 8px;
        background-color    :   #212121;
        width               :   40%;
        height              :   400px;
        padding             :   10px;
    }

    div
    {
        height              :   100%;
        width               :   100%;
        margin              :   0px 0px 0px 0px;
    }

    table
    {
        width               :   100%;
    }
    th, td
    {
        border-bottom       :   1px solid #eeeeee;
        text-align          :   center;
        color               :   #ffffff;
        font-size           :   18px;

    }
    tr:hover
    {
        background-color    :   #383838;
    }

    .pageEntry
    {
        float               :   left   !important;
        border-radius       :   8px 8px;
        background-color    :   #EEEEEE;
        width               :   55%;
        height              :   800px;
        padding             :   10px;
    }

    h4
    {
        text-align          :   center;
        font-size           :   18px;
        color               :   #212121;
    }

     input
     {
        margin-Top          :   20px;
        display             :   block;
        margin-left         :   auto;
        margin-right        :   auto;
        width               :   100%;
        height              :   60px;
     }

    form
    {
        width               :   80%;
        margin-Left         :   80px;
    }

    .addBtn
    {
        margin-Top          :   40px;
        margin-Left         :   10px;
        background-color    :   #304FFE;
        border              :   0px 0px;
        border-radius       :   8px 8px;
        color               :   #ffffff;
        font-size           :   20px;
    }
    .uid
    {
        display             :   none;
    }
    .uname
    {
        display             :   none;
    }

    .delAcc
    {
        margin-Top          :   40px;
        margin-Left         :   10px;
        background-color    :   #ff0000;
        border              :   0px 0px;
        border-radius       :   8px 8px;
        color               :   #ffffff;
        font-size           :   15px;
        float               :   right   !important;
        width               :   150px;
    }

</style>
<body>

   <div class="pageEntry">
      <sql:setDataSource
           var="myDS"
           driver="com.mysql.jdbc.Driver"
           url="jdbc:mysql://codeos/seDemo"
           user="root" password="jayesh@123"
       />

       <sql:query var="listUsers"   dataSource="${myDS}">
           SELECT * FROM Users WHERE U_Name='<%= session.getAttribute("CurrUser") %>';
       </sql:query>


        <h4 >Welcome, <%= session.getAttribute("CurrUser") %></h4>
           <h4>Add a contact to your list </h4>
        <br>
        <form action="/ResponseData" method="POST">
        <center>
             <input  placeholder="First Name" class="fname" type = "text" name = "fname"><br>
             <input  placeholder="Last  Name" class="lname" type = "text" name = "lname"><br>
             <input  placeholder="Mobile Number" class="mobnum" type = "text" name = "mobnum"><br>
             <input  placeholder="Work / Home"   class="mobtype" type = "text" name = "mobtype"><br>

        <c:forEach var="user" items="${listUsers.rows}">
             <input  class="uid" type = "text" name = "UID" value="${user.U_ID}"><br>
            <c:set var = "u_id" scope = "session" value = "${user.U_ID}"/>
        </c:forEach>
            <input  class="uname"   type = "text"    name = "uname" value="<%= session.getAttribute("CurrUser") %>"><br>
            <input  class="addBtn"  type = "submit"  name="dataadd" value = "Add To Contacts" /><br>
            <br>
            <input  class="delAcc"  type="submit"   name="DelAccount"   value="Delete Account"><br>
</center>

        </form>
   </div>
    <div class="pageList">
            <sql:query dataSource="${myDS}" var="result">
                    SELECT * from Contacts where U_ID =?
                    <sql:param value="${u_id}" />
            </sql:query>

    <div >
        <table   cellpadding="5" >
            <tr >
                <th>Name</th>
                <th>Mobile Number</th>
                <th>Type</th>
            </tr>
            <c:forEach var="user" items="${result.rows}">
                <tr>
                    <td><c:out value="${user.C_Name}" /></td>
                    <td><c:out value="${user.C_Mobile}" /></td>
                    <td><c:out value="${user.C_Type}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </div>
</body>
</html>