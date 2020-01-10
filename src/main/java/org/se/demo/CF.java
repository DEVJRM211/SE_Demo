package org.se.demo;

import com.google.gson.*;
import java.sql.*;

public class CF
{

    public JsonArray SQL_Call(String vType, String  vQuery)
    {
        Connection con         =   null;
        JsonArray   retArray    =   null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con  =    DriverManager.getConnection("jdbc:mysql://codeos/4qs","root","jayesh@123");
            Statement stmt    =   (Statement) con.createStatement();
            ResultSet rs      =   null;
            JsonArray   oArray  =   null;
            ResultSetMetaData   rsmd    =   null;
            if(vType.equals("S"))
            {
                oArray      =   new JsonArray();
                JsonObject  node    =   new JsonObject();
                int         retInt  =   stmt.executeUpdate(vQuery);
                node.addProperty("Updated_rows",String.valueOf(retInt));
                retArray    =   oArray;
            }
            else
            {
                rs         =   stmt.executeQuery(vQuery);
                rsmd       =   rs.getMetaData();
                oArray     =   new JsonArray();
                JsonObject node    =    null;
                while (rs.next())
                {
                    node    =   new JsonObject();
                    for(int i=1;i<=rsmd.getColumnCount();i++)
                    {
                        node.addProperty(rsmd.getColumnName(i), rs.getString(i));
                    }
                    oArray.add(node);
                }
                retArray    =   oArray;
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("ERROR : "+e.getMessage());
        }
        return retArray;
    }


}
