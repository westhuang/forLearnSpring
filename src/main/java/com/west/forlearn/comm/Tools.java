package com.west.forlearn.comm;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Tools {

    // map转字符串
    public static String MapToString(Map mapParams) throws UnsupportedEncodingException {
        if (mapParams.isEmpty()){
            return "";
        }

        StringBuilder result = new StringBuilder();
        Iterator iterator = mapParams.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            result.append(URLEncoder.encode(entry.getKey().toString(), "utf-8"));
            result.append("=");
            result.append(entry.getValue().toString().isEmpty() ? "" : URLEncoder.encode(entry.getValue().toString(), "utf-8"));
            result.append(iterator.hasNext() ? "&" : "");
        }

        return result.toString();
    }

    // 字符串转map
    public static Map StringToMap(String strParams) throws UnsupportedEncodingException {
        Map result = new HashMap();

        StringTokenizer outStrToken = new StringTokenizer(strParams, "&");
        while (outStrToken.hasMoreTokens()){
            StringTokenizer innerStrToken = new StringTokenizer(outStrToken.nextToken(), "=");
            result.put(URLDecoder.decode(innerStrToken.nextToken(), "utf-8") ,
                    innerStrToken.hasMoreTokens() ? URLDecoder.decode(innerStrToken.nextToken(), "utf-8") : "");
        }

        return result;
    }
}

