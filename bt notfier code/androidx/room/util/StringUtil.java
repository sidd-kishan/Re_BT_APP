/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.room.util;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    private StringUtil() {
    }

    public static void appendPlaceholders(StringBuilder stringBuilder, int n) {
        int n2 = 0;
        while (n2 < n) {
            stringBuilder.append("?");
            if (n2 < n - 1) {
                stringBuilder.append(",");
            }
            ++n2;
        }
    }

    public static String joinIntoString(List<Integer> list) {
        if (list == null) {
            return null;
        }
        int n = list.size();
        if (n == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        while (n2 < n) {
            stringBuilder.append(Integer.toString(list.get(n2)));
            if (n2 < n - 1) {
                stringBuilder.append(",");
            }
            ++n2;
        }
        return stringBuilder.toString();
    }

    public static StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    public static List<Integer> splitToIntList(String object) {
        if (object == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        object = new StringTokenizer((String)object, ",");
        while (((StringTokenizer)object).hasMoreElements()) {
            String string = ((StringTokenizer)object).nextToken();
            try {
                arrayList.add(Integer.parseInt(string));
            }
            catch (NumberFormatException numberFormatException) {
                Log.e((String)"ROOM", (String)"Malformed integer list", (Throwable)numberFormatException);
            }
        }
        return arrayList;
    }
}
