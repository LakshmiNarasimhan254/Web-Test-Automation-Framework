package org.mln.utils;

import java.util.Base64;

/**
 * DecodeUtil is a class that contains a method that decodes a base64 encoded string.
 */
public final class DecodeUtil {
    private DecodeUtil(){}
    public static String base64Decode(String encodedString){
        return new String(Base64.getDecoder().decode(encodedString.getBytes()));
    }
}
