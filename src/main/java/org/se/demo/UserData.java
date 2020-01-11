package org.se.demo;


import com.google.gson.JsonArray;
import java.util.ArrayList;
import org.se.demo.WebUser;

import javax.lang.model.element.NestingKind;

public class UserData
{
    public  String    UserLogin(WebUser   oUser)
    {
        CF          oCF     =   new CF();
        String      query   =   "select * from Users where U_Name='"+oUser.WU_Name("G","")+"' and U_Password='"+oUser.WU_Password("G","")+"' ;";
        JsonArray rArray  =   oCF.SQL_Call("",query);
        return      (rArray.size()>0)  ?   "LS"    :   "LF";
    }

    public  String    UserReg(WebUser   oUser)
    {
        CF          oCF     =   new CF();
        String      query   =   "select * from Users where U_Name='"+oUser.WU_Name("G","")+"';";
        JsonArray   rArray  =   oCF.SQL_Call("",query);
        String      rValue  =   "";
        if(rArray.size()>0)
        {
            rValue  =   "UE";
        }
        else
        {
            query   =   "insert into Users(`U_ID`,   `U_Name`,  `U_Password`)  values (0,'"+oUser.WU_Name("G","")+"','"+oUser.WU_Password("G","")+"');";
            oCF.SQL_Call("S",query);
            rValue  =   "UC";
        }
        return  rValue;
    }

    public String AddContact(Contacts cts)
    {
        CF          oCF         =   new CF();
        String      query       =   "insert into Contacts(`C_ID`,`C_Name`,`C_Mobile`,`C_Type`,`U_ID`) values "+
                                    "(0,'"+cts.WC_Name("G","")+"',"+
                                    "'"+cts.WC_Mobile("G","")+"',"+
                                    "'"+cts.WC_Type("G","")+"',"+
                                    cts.WU_ID("G",0)+");";
        JsonArray   rArray      =   oCF.SQL_Call("S",query);
        String      rValue      =   "CC";
        return rValue;
    }

    public  String  DelAccount(String UID)
    {
        CF          oCF     =   new CF();
        String      query   =   "delete from Contacts where U_ID="+UID+" ;";
        JsonArray   rArray  =   oCF.SQL_Call("S",query);
                    query   =   "delete from Users where U_ID="+UID+" ;";
                    rArray  =   oCF.SQL_Call("S",query);
        return      "AC";
    }
}
