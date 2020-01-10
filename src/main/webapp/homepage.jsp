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
        width               :   30%;
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
        width               :   65%;
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
        margin-Left         :   20px;
        width               :   400px;
        height              :   50px;
     }

</style>
<body>

   <div class="pageEntry">
        <h4> User Contacts </h4>
        <br>
        <form action="/ResponseData" method="POST">
             <input  placeholder="First Name" class="fname" type = "text" name = "fname">
             <input  placeholder="Last  Name" class="lname" type = "text" name = "lname"><br>
             <input  placeholder="Mobile Number" class="mobnum" type = "text" name = "mobnum">


        </form>
   </div>
    <div class="pageList">
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://codeos/seDemo"
        user="root" password="jayesh@123"
    />

    <sql:query var="listUsers"   dataSource="${myDS}">
        SELECT * FROM Users;
    </sql:query>

    <div >
        <table   cellpadding="5" >
            <tr >
                <th>Sr.No</th>
                <th>Name</th>
            </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                    <td><c:out value="${user.U_ID}" /></td>
                    <td><c:out value="${user.U_Name}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </div>
</body>
</html>