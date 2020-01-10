package org.se.demo;

public class Contacts
{
    private int     C_ID;
    private int     U_ID;
    private String  C_Name;
    private String  C_Mobile;
    private String  C_Type;

    public  int WC_ID(String  oType, int oValue)
    {
        int rValue  =   0;
        rValue  =   (oType.equals("G")) ?   this.C_ID   :   (this.C_ID  =   oValue);
        return  rValue;
    }

    public  int WU_ID(String  oType, int oValue)
    {
        int rValue  =   0;
        rValue  =   (oType.equals("G")) ?   this.U_ID   :   (this.U_ID  =   oValue);
        return  rValue;
    }


    public  String  WC_Name(String  oType,  String  oValue)
    {
        String  rValue  =   "";
        rValue  =   (oType.equals("G")) ?   this.C_Name   :   (this.C_Name  =   oValue);
        return rValue;
    }

    public  String  WC_Mobile(String  oType,  String  oValue)
    {
        String  rValue  =   "";
        rValue  =   (oType.equals("G")) ?   this.C_Mobile   :   (this.C_Mobile  =   oValue);
        return rValue;
    }

    public  String  WC_Type(String  oType,  String  oValue)
    {
        String  rValue  =   "";
        rValue  =   (oType.equals("G")) ?   this.C_Type   :   (this.C_Type  =   oValue);
        return rValue;
    }

}
