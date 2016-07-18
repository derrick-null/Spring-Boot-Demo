package com.derrick.util;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Created by ccc on 2016/7/11.
 */
public class Base64EncryptorUtils {

    public static String encoderBASE64(String s) {
        if (s == null) {
            return null;
        } else {
            try {
                return Base64.encodeBase64String(s.getBytes("utf-8"));
            } catch (UnsupportedEncodingException var2) {
                var2.printStackTrace();
                return null;
            }
        }
    }

    public static String decoderBASE64(String s) {
        String str = null;

        try {
            byte[] e = Base64.decodeBase64(s);
            str = new String(e, "UTF-8");
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return str;
    }
}
