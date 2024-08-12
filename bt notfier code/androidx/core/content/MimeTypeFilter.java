/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.content;

import java.util.ArrayList;

public final class MimeTypeFilter {
    private MimeTypeFilter() {
    }

    public static String matches(String string, String[] stringArray) {
        if (string == null) {
            return null;
        }
        String[] stringArray2 = string.split("/");
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            string = stringArray[n2];
            if (MimeTypeFilter.mimeTypeAgainstFilter(stringArray2, string.split("/"))) {
                return string;
            }
            ++n2;
        }
        return null;
    }

    public static String matches(String[] stringArray, String string) {
        if (stringArray == null) {
            return null;
        }
        String[] stringArray2 = string.split("/");
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            string = stringArray[n2];
            if (MimeTypeFilter.mimeTypeAgainstFilter(string.split("/"), stringArray2)) {
                return string;
            }
            ++n2;
        }
        return null;
    }

    public static boolean matches(String string, String string2) {
        if (string != null) return MimeTypeFilter.mimeTypeAgainstFilter(string.split("/"), string2.split("/"));
        return false;
    }

    public static String[] matchesMany(String[] stringArray, String stringArray2) {
        int n = 0;
        if (stringArray == null) {
            return new String[0];
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        stringArray2 = stringArray2.split("/");
        int n2 = stringArray.length;
        while (n < n2) {
            String string = stringArray[n];
            if (MimeTypeFilter.mimeTypeAgainstFilter(string.split("/"), stringArray2)) {
                arrayList.add(string);
            }
            ++n;
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }

    private static boolean mimeTypeAgainstFilter(String[] stringArray, String[] stringArray2) {
        if (stringArray2.length != 2) throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
        if (stringArray2[0].isEmpty()) throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
        if (stringArray2[1].isEmpty()) throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
        if (stringArray.length != 2) {
            return false;
        }
        if (!"*".equals(stringArray2[0]) && !stringArray2[0].equals(stringArray[0])) {
            return false;
        }
        if ("*".equals(stringArray2[1])) return true;
        if (stringArray2[1].equals(stringArray[1])) return true;
        return false;
    }
}
