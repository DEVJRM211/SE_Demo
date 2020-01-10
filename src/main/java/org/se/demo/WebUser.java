package org.se.demo;

public class WebUser
{
    private     int     U_ID;
    private     String  U_Name;
    private     String  U_Password;

    public  int WU_ID(String  oType, int oValue)
    {
        int rValue  =   0;
        rValue  =   (oType.equals("G")) ?   this.U_ID   :   (this.U_ID  =   oValue);
        return  rValue;
    }
    public  String  WU_Name(String  oType,  String  oValue)
    {
        String  rValue  =   "";
        rValue  =   (oType.equals("G")) ?   this.U_Name   :   (this.U_Name  =   oValue);
        return rValue;
    }

    public  String  WU_Password(String  oType,  String  oValue)
    {
        String  rValue  =   "";
        rValue  =   (oType.equals("G")) ?   this.U_Password   :   (this.U_Password  =   oValue);
        return rValue;
    }
}
