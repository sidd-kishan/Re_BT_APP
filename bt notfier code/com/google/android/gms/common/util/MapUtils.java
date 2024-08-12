/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.common.util;

import java.util.HashMap;
import java.util.Iterator;

public class MapUtils {
    public static void writeStringMapToJson(StringBuilder stringBuilder, HashMap<String, String> hashMap) {
        stringBuilder.append("{");
        Iterator<String> iterator = hashMap.keySet().iterator();
        boolean bl = true;
        while (true) {
            if (!iterator.hasNext()) {
                stringBuilder.append("}");
                return;
            }
            String string = iterator.next();
            if (!bl) {
                stringBuilder.append(",");
            }
            String string2 = hashMap.get(string);
            stringBuilder.append("\"");
            stringBuilder.append(string);
            stringBuilder.append("\":");
            if (string2 == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append("\"");
                stringBuilder.append(string2);
                stringBuilder.append("\"");
            }
            bl = false;
        }
    }
}
