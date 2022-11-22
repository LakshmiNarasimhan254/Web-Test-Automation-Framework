package org.mln.utils;

public final class DynamicXPathUtil {
    private DynamicXPathUtil(){}

    /**
     * It takes a string and replaces the %s with the value passed in
     *
     * @param xpath The xpath of the element you want to find.
     * @param value The value that you want to replace in the xpath.
     * @return String.format(xpath,value)
     */
    public static String getDynamicXpath(String xpath,String value){
          return String.format(xpath,value) ;
    }


}
