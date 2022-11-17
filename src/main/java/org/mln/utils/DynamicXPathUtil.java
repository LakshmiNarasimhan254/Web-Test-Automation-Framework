package org.mln.utils;

public final class DynamicXPathUtil {
    private DynamicXPathUtil(){}

    public static String getDynamicXpath(String xpath,String value){
        System.out.println(value +"myvalue");
       return String.format(xpath,value) ;
    }


}
