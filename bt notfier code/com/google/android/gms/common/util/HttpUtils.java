/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HttpUtils {
    private static final Pattern zza = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final Pattern zzb = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern zzc = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    private HttpUtils() {
    }

    public static Map<String, String> parse(URI object, String string) {
        String[] stringArray = Collections.emptyMap();
        Object object2 = object.getRawQuery();
        object = stringArray;
        if (object2 == null) return object;
        object = stringArray;
        if (((String)object2).length() <= 0) return object;
        stringArray = new HashMap<String, String>();
        object2 = new Scanner((String)object2);
        ((Scanner)object2).useDelimiter("&");
        while (true) {
            object = stringArray;
            if (!((Scanner)object2).hasNext()) return object;
            object = ((Scanner)object2).next().split("=");
            int n = ((String[])object).length;
            if (n == 0) throw new IllegalArgumentException("bad parameter");
            if (n > 2) throw new IllegalArgumentException("bad parameter");
            String string2 = HttpUtils.zza(object[0], string);
            object = n == 2 ? HttpUtils.zza(object[1], string) : null;
            stringArray.put(string2, object);
        }
    }

    private static String zza(String string, String string2) {
        String string3 = string2;
        if (string2 == null) {
            string3 = "ISO-8859-1";
        }
        try {
            string = URLDecoder.decode(string, string3);
            return string;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new IllegalArgumentException(unsupportedEncodingException);
        }
    }
}
