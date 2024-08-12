/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.LocationManager
 */
package com.lianhezhuli.btnotification.utils;

import android.content.Context;
import android.location.LocationManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Properties;

public class UTIL {
    static double a = 6378245.0;
    static double ee = 0.006693421622965943;
    static double pi = Math.PI;
    public static final double x_pi = 52.35987755982988;

    public static boolean IsLeapYear(int n) {
        boolean bl = n % 400 == 0 || n % 4 == 0 && n % 100 != 0;
        return bl;
    }

    public static double decimalTo2(double d, int n) {
        return new BigDecimal(d).setScale(n, 4).doubleValue();
    }

    public static void delPre(Context context, String string, String string2) {
        context = context.getSharedPreferences(string, 0).edit();
        if (string2 != null && !"".equals(string2)) {
            context.remove(string2);
        } else {
            context.clear();
        }
        context.commit();
    }

    public static double[] gcj2bd(double d, double d2) {
        double d3 = Math.sqrt(d2 * d2 + d * d) + Math.sin(d * 52.35987755982988) * 2.0E-5;
        d2 = Math.atan2(d, d2) + Math.cos(d2 * 52.35987755982988) * 3.0E-6;
        d = Math.cos(d2);
        return new double[]{d3 * Math.sin(d2) + 0.006, d * d3 + 0.0065};
    }

    public static String get(String string) {
        InputStream inputStream = UTIL.class.getClassLoader().getResourceAsStream("com/szkct/funrun/util/configure.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        }
        catch (IOException iOException) {
            try {
                inputStream.close();
            }
            catch (IOException iOException2) {
                iOException2.printStackTrace();
            }
            iOException.printStackTrace();
        }
        return properties.getProperty(string);
    }

    public static String getAddDay(String object) {
        object = ((String)object).split("-");
        String[] stringArray = UTIL.getNextDay(Integer.parseInt(object[0]), Integer.parseInt(object[1]), Integer.parseInt(object[2])).split("-");
        CharSequence charSequence = stringArray[1];
        CharSequence charSequence2 = stringArray[2];
        object = charSequence;
        if (((String)charSequence).length() == 1) {
            object = new StringBuilder();
            ((StringBuilder)object).append("0");
            ((StringBuilder)object).append((String)charSequence);
            object = ((StringBuilder)object).toString();
        }
        charSequence = charSequence2;
        if (((String)charSequence2).length() == 1) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("0");
            ((StringBuilder)charSequence).append((String)charSequence2);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append(stringArray[0]);
        ((StringBuilder)charSequence2).append("-");
        ((StringBuilder)charSequence2).append((String)object);
        ((StringBuilder)charSequence2).append("-");
        ((StringBuilder)charSequence2).append((String)charSequence);
        return ((StringBuilder)charSequence2).toString();
    }

    public static String getCountry() {
        return Locale.getDefault().getCountry();
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static int getMaxDay(int n, int n2) {
        switch (n2) {
            default: {
                return -1;
            }
            case 4: 
            case 6: 
            case 9: 
            case 11: {
                return 30;
            }
            case 2: {
                n = UTIL.IsLeapYear(n) ? 29 : 28;
                return n;
            }
            case 1: 
            case 3: 
            case 5: 
            case 7: 
            case 8: 
            case 10: 
            case 12: 
        }
        return 31;
    }

    public static String getNextDay(int n, int n2, int n3) {
        int n4 = UTIL.getMaxDay(n, n2);
        int n5 = 1;
        if (n3 != n4) {
            ++n3;
        } else if (n2 != 12) {
            ++n2;
            n3 = n5;
        } else {
            ++n;
            n2 = 1;
            n3 = n5;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n);
        stringBuilder.append("-");
        stringBuilder.append(n2);
        stringBuilder.append("-");
        stringBuilder.append(n3);
        return stringBuilder.toString();
    }

    public static String getPreDay(int n, int n2, int n3) {
        if (n3 != 1) {
            int n4 = n3 - 1;
            n3 = n;
            n = n4;
        } else if (n2 != 1) {
            int n5 = UTIL.getMaxDay(n, --n2);
            n3 = n;
            n = n5;
        } else {
            n3 = n - 1;
            n2 = 12;
            n = 31;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n3);
        stringBuilder.append("-");
        stringBuilder.append(n2);
        stringBuilder.append("-");
        stringBuilder.append(n);
        return stringBuilder.toString();
    }

    public static String getSubtractDay(String object) {
        object = ((String)object).split("-");
        String[] stringArray = UTIL.getPreDay(Integer.parseInt(object[0]), Integer.parseInt(object[1]), Integer.parseInt(object[2])).split("-");
        CharSequence charSequence = stringArray[1];
        CharSequence charSequence2 = stringArray[2];
        object = charSequence;
        if (((String)charSequence).length() == 1) {
            object = new StringBuilder();
            ((StringBuilder)object).append("0");
            ((StringBuilder)object).append((String)charSequence);
            object = ((StringBuilder)object).toString();
        }
        charSequence = charSequence2;
        if (((String)charSequence2).length() == 1) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("0");
            ((StringBuilder)charSequence).append((String)charSequence2);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append(stringArray[0]);
        ((StringBuilder)charSequence2).append("-");
        ((StringBuilder)charSequence2).append((String)object);
        ((StringBuilder)charSequence2).append("-");
        ((StringBuilder)charSequence2).append((String)charSequence);
        return ((StringBuilder)charSequence2).toString();
    }

    public static boolean isGpsEnabled(LocationManager locationManager) {
        if (!locationManager.isProviderEnabled("gps")) return false;
        return true;
    }

    public static String null2String(String string) {
        String string2 = string;
        if (string != null) return string2;
        string2 = "";
        return string2;
    }

    public static byte[] read(InputStream object) {
        try {
            System.out.println(2);
            byte[] byArray = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int n;
                if ((n = ((InputStream)object).read(byArray)) == -1) {
                    ((InputStream)object).close();
                    object = byteArrayOutputStream.toByteArray();
                    return object;
                }
                byteArrayOutputStream.write(byArray, 0, n);
            }
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static String readPre(Context context, String string, String string2) {
        return context.getSharedPreferences(string, 0).getString(string2, "");
    }

    public static void savePre(Context context, String string, String string2, String string3) {
        context = context.getSharedPreferences(string, 0).edit();
        context.putString(string2, string3);
        context.commit();
    }

    private static double transformLat(double d, double d2) {
        double d3 = d * 2.0;
        return -100.0 + d3 + d2 * 3.0 + d2 * 0.2 * d2 + 0.1 * d * d2 + Math.sqrt(Math.abs(d)) * 0.2 + (Math.sin(d * 6.0 * pi) * 20.0 + Math.sin(d3 * pi) * 20.0) * 2.0 / 3.0 + (Math.sin(pi * d2) * 20.0 + Math.sin(d2 / 3.0 * pi) * 40.0) * 2.0 / 3.0 + (Math.sin(d2 / 12.0 * pi) * 160.0 + Math.sin(d2 * pi / 30.0) * 320.0) * 2.0 / 3.0;
    }

    private static double transformLon(double d, double d2) {
        double d3 = d * 0.1;
        return d + 300.0 + d2 * 2.0 + d3 * d + d3 * d2 + Math.sqrt(Math.abs(d)) * 0.1 + (Math.sin(6.0 * d * pi) * 20.0 + Math.sin(d * 2.0 * pi) * 20.0) * 2.0 / 3.0 + (Math.sin(pi * d) * 20.0 + Math.sin(d / 3.0 * pi) * 40.0) * 2.0 / 3.0 + (Math.sin(d / 12.0 * pi) * 150.0 + Math.sin(d / 30.0 * pi) * 300.0) * 2.0 / 3.0;
    }

    public static double[] wgs2bd(double d, double d2) {
        double[] dArray = UTIL.wgs2gcj(d, d2);
        return UTIL.gcj2bd(dArray[0], dArray[1]);
    }

    public static double[] wgs2gcj(double d, double d2) {
        double d3 = d2 - 105.0;
        double d4 = d - 35.0;
        double d5 = UTIL.transformLat(d3, d4);
        d4 = UTIL.transformLon(d3, d4);
        d3 = d / 180.0 * pi;
        double d6 = Math.sin(d3);
        d6 = 1.0 - ee * d6 * d6;
        double d7 = Math.sqrt(d6);
        double d8 = a;
        return new double[]{d + d5 * 180.0 / ((1.0 - ee) * d8 / (d6 * d7) * pi), d2 + d4 * 180.0 / (d8 / d7 * Math.cos(d3) * pi)};
    }
}
