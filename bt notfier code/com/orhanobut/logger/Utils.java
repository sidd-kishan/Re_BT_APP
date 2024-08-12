/*
 * Decompiled with CFR 0.152.
 */
package com.orhanobut.logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.Arrays;

final class Utils {
    private Utils() {
    }

    static <T> T checkNotNull(T t) {
        if (t == null) throw null;
        return t;
    }

    static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null) return false;
        if (charSequence2 == null) return false;
        int n = charSequence.length();
        if (n != charSequence2.length()) return false;
        if (charSequence instanceof String && charSequence2 instanceof String) {
            return charSequence.equals(charSequence2);
        }
        int n2 = 0;
        while (n2 < n) {
            if (charSequence.charAt(n2) != charSequence2.charAt(n2)) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    static String getStackTraceString(Throwable throwable) {
        if (throwable == null) {
            return "";
        }
        Object object = throwable;
        while (true) {
            if (object == null) {
                StringWriter stringWriter = new StringWriter();
                object = new PrintWriter(stringWriter);
                throwable.printStackTrace((PrintWriter)object);
                ((PrintWriter)object).flush();
                return stringWriter.toString();
            }
            if (object instanceof UnknownHostException) {
                return "";
            }
            object = ((Throwable)object).getCause();
        }
    }

    static boolean isEmpty(CharSequence charSequence) {
        boolean bl = charSequence == null || charSequence.length() == 0;
        return bl;
    }

    static String logLevel(int n) {
        switch (n) {
            default: {
                return "UNKNOWN";
            }
            case 7: {
                return "ASSERT";
            }
            case 6: {
                return "ERROR";
            }
            case 5: {
                return "WARN";
            }
            case 4: {
                return "INFO";
            }
            case 3: {
                return "DEBUG";
            }
            case 2: 
        }
        return "VERBOSE";
    }

    public static String toString(Object object) {
        if (object == null) {
            return "null";
        }
        if (!object.getClass().isArray()) {
            return object.toString();
        }
        if (object instanceof boolean[]) {
            return Arrays.toString((boolean[])object);
        }
        if (object instanceof byte[]) {
            return Arrays.toString((byte[])object);
        }
        if (object instanceof char[]) {
            return Arrays.toString((char[])object);
        }
        if (object instanceof short[]) {
            return Arrays.toString((short[])object);
        }
        if (object instanceof int[]) {
            return Arrays.toString((int[])object);
        }
        if (object instanceof long[]) {
            return Arrays.toString((long[])object);
        }
        if (object instanceof float[]) {
            return Arrays.toString((float[])object);
        }
        if (object instanceof double[]) {
            return Arrays.toString((double[])object);
        }
        if (!(object instanceof Object[])) return "Couldn't find a correct type for the object";
        return Arrays.deepToString((Object[])object);
    }
}
