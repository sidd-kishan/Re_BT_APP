/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

public final class JavaVersion {
    private static final int majorJavaVersion = JavaVersion.determineMajorJavaVersion();

    private JavaVersion() {
    }

    private static int determineMajorJavaVersion() {
        return JavaVersion.getMajorJavaVersion(System.getProperty("java.version"));
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    private static int extractBeginningInt(String string) {
        int n;
        StringBuilder stringBuilder;
        try {
            char c;
            stringBuilder = new StringBuilder();
            for (n = 0; n < string.length() && Character.isDigit(c = string.charAt(n)); ++n) {
                stringBuilder.append(c);
            }
        }
        catch (NumberFormatException numberFormatException) {
            return -1;
        }
        {
            n = Integer.parseInt(stringBuilder.toString());
            return n;
        }
    }

    public static int getMajorJavaVersion() {
        return majorJavaVersion;
    }

    static int getMajorJavaVersion(String string) {
        int n;
        int n2 = n = JavaVersion.parseDotted(string);
        if (n == -1) {
            n2 = JavaVersion.extractBeginningInt(string);
        }
        if (n2 != -1) return n2;
        return 6;
    }

    public static boolean isJava9OrLater() {
        boolean bl = majorJavaVersion >= 9;
        return bl;
    }

    private static int parseDotted(String stringArray) {
        try {
            stringArray = stringArray.split("[._]");
            int n = Integer.parseInt(stringArray[0]);
            if (n != 1) return n;
            if (stringArray.length <= 1) return n;
            n = Integer.parseInt(stringArray[1]);
            return n;
        }
        catch (NumberFormatException numberFormatException) {
            return -1;
        }
    }
}
