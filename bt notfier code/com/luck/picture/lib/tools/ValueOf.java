/*
 * Decompiled with CFR 0.152.
 */
package com.luck.picture.lib.tools;

public class ValueOf {
    public static <T> T to(Object object, T t) {
        if (object != null) return (T)object;
        return t;
    }

    public static boolean toBoolean(Object object) {
        return ValueOf.toBoolean(object, false);
    }

    /*
     * Enabled force condition propagation
     */
    public static boolean toBoolean(Object object, boolean bl) {
        if (object == null) {
            return false;
        }
        try {
            boolean bl2 = "false".equals(object.toString().trim().trim());
            return bl2 ^ true;
        }
        catch (Exception exception) {
            return bl;
        }
    }

    public static double toDouble(Object object) {
        return ValueOf.toDouble(object, 0);
    }

    public static double toDouble(Object object, int n) {
        double d;
        if (object == null) {
            return n;
        }
        try {
            d = Double.valueOf(object.toString().trim());
        }
        catch (Exception exception) {
            d = n;
        }
        return d;
    }

    public static float toFloat(Object object) {
        return ValueOf.toFloat(object, 0L);
    }

    public static float toFloat(Object object, long l) {
        float f;
        if (object == null) {
            return l;
        }
        try {
            f = Float.valueOf(object.toString().trim()).floatValue();
        }
        catch (Exception exception) {
            f = l;
        }
        return f;
    }

    public static int toInt(Object object) {
        return ValueOf.toInt(object, 0);
    }

    /*
     * Enabled force condition propagation
     */
    public static int toInt(Object object, int n) {
        if (object == null) {
            return n;
        }
        try {
            object = object.toString().trim();
            if (!((String)object).contains(".")) int n2;
            return n2 = Integer.valueOf((String)object).intValue();
            int n3 = Integer.valueOf(((String)object).substring(0, ((String)object).lastIndexOf(".")));
            return n3;
        }
        catch (Exception exception) {
            return n;
        }
    }

    public static long toLong(Object object) {
        return ValueOf.toLong(object, 0L);
    }

    /*
     * Enabled force condition propagation
     */
    public static long toLong(Object object, long l) {
        if (object == null) {
            return l;
        }
        try {
            object = object.toString().trim();
            if (!((String)object).contains(".")) long l2;
            return l2 = Long.valueOf((String)object).longValue();
            long l3 = Long.valueOf(((String)object).substring(0, ((String)object).lastIndexOf(".")));
            return l3;
        }
        catch (Exception exception) {
            return l;
        }
    }

    public static String toString(Object object) {
        try {
            object = object.toString();
        }
        catch (Exception exception) {
            object = "";
        }
        return object;
    }
}
