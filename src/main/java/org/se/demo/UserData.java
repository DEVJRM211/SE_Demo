package org.se.demo;

import com.google.gson.JsonArray;

public class UserData
{
    public  String    UserLogin(String oType,WebUser   oUser)
    {
        CF          oCF     =   new CF();
        String      query   =   "select * from Users where U_Name='"+oUser.WU_Name("G","")+"' and U_Password='"+oUser.WU_Password("G","")+"' ;";
        JsonArray   rArray  =   oCF.SQL_Call("",query);
        return      (rArray!=null)  ?   "LS"    :   "LF";
    }

    public  String    UserReg(String oType,WebUser   oUser)
    {
        CF          oCF     =   new CF();
        String      query   =   "select * from Users where U_Name='"+oUser.WU_Name("G","")+"';";
        JsonArray   rArray  =   oCF.SQL_Call("",query);
        String      rValue  =   "";
        if(rArray!=null)
        {
            rValue  =   "UE";
        }
        else
        {
            query   =   "insert into Users(`U_ID`,   `U_Name`,  `U_Password`)  values (0,'"+oUser.WU_Name("G","")+"','"+oUser.WU_Password("G","")+"';";
            oCF.SQL_Call("",query);
            rValue  =   "UC";
        }
        return  rValue;
    }

}
