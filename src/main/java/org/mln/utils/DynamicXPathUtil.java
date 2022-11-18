package org.mln.utils;

public final class DynamicXPathUtil {
    private DynamicXPathUtil(){}

    public static String getDynamicXpath(String xpath,String value){
          return String.format(xpath,value) ;
    }


}
