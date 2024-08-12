/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.lianhezhuli.btnotification.utils.SpUtils
 *  com.lianhezhuli.btnotification.utils.StringUtils
 *  com.lianhezhuli.btnotification.utils._$$Lambda$TEfSBt3hRUlBSSARfPEHsJesTtE
 */
package com.lianhezhuli.btnotification.utils;

import android.text.TextUtils;
import com.lianhezhuli.btnotification.utils.SpUtils;
import com.lianhezhuli.btnotification.utils.StringUtils;
import com.lianhezhuli.btnotification.utils._$;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public class SignUtils {
    public static String getSign(Map<String, String> map, boolean bl) {
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
        if (bl) {
            map.put("authcode", (String)SpUtils.getData((String)"anonymous_auth_code", (Object)""));
        }
        Object object = new ArrayList<String>(map.keySet());
        Collections.sort(object, _$.Lambda.TEfSBt3hRUlBSSARfPEHsJesTtE.INSTANCE);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = object.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                stringBuilder.append("key=192006250b4c09247ec02edce69f6a2d");
                return StringUtils.md5Encode32((String)stringBuilder.toString());
            }
            String string = (String)iterator.next();
            object = map.get(string);
            if (TextUtils.isEmpty((CharSequence)object) || "0".equals(object)) continue;
            stringBuilder.append(string);
            stringBuilder.append("=");
            stringBuilder.append((String)object);
            stringBuilder.append("&");
        }
    }
}
