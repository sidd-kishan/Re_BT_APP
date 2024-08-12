/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.CalendarUtil
 *  com.haibin.calendarview.LunarUtil
 *  com.haibin.calendarview.R$array
 *  com.haibin.calendarview.SolarTermUtil
 *  com.haibin.calendarview.TrunkBranchAnnals
 */
package com.haibin.calendarview;

import android.content.Context;
import android.text.TextUtils;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarUtil;
import com.haibin.calendarview.LunarUtil;
import com.haibin.calendarview.R;
import com.haibin.calendarview.SolarTermUtil;
import com.haibin.calendarview.TrunkBranchAnnals;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.Map;

public final class LunarCalendar {
    private static String[] DAY_STR;
    private static final int[] LUNAR_INFO;
    private static String[] MONTH_STR;
    private static String[] SOLAR_CALENDAR;
    private static final Map<Integer, String[]> SOLAR_TERMS;
    private static final Map<Integer, String[]> SPECIAL_FESTIVAL;
    private static String[] SPECIAL_FESTIVAL_STR;
    private static String[] TRADITION_FESTIVAL_STR;

    static {
        SPECIAL_FESTIVAL = new HashMap<Integer, String[]>();
        SOLAR_CALENDAR = null;
        SOLAR_TERMS = new HashMap<Integer, String[]>();
        LUNAR_INFO = LunarCalendar.$d2j$hex$3ebaf898$decode_I("d84b0000e04a000070a50000d554000060d2000050d9000054650100a0560000d09a0000d2550000e04a0000b6a50000d0a4000050d2000055d2010040b50000a0d60000a2ad0000b09500007749010070490000b0a40000b5b40000506a0000406d000054ab0100602b000070950000f25200007049000066650000a0d4000050ea0000956e0000d05a0000602b0000e3860100e0920000d7c8010050c90000a0d40000a6d8010050b50000a0560000b4a50100d0250000d0920000b2d2000050a9000057b50000a06c000050b5000055530100a04d0000d0a5000073450100d0520000a8a9000050e90000a06a0000a6ae000050ab0000604b0000e4aa000070a500006052000063f2000050d90000575b0000a0560000d0960000d54d0000d04a0000d0a40000d4d4000050d2000058d5000040b50000a0b50000a6950100b0950000b049000074a90000b0a400007ab20000506a0000406d000046af000060ab000070950000f54a000070490000b0640000a374000050ea0000586b0000c055000060ab0000d5960000e092000060c9000054d90000a0d4000050da000052750000a0560000b7ab0000d0250000d0920000b5ca000050a90000a0b40000a4ba000050ad0000d9550000a04b0000b0a5000076510100b052000030a9000054790000a06a000050ad0000525b0000604b0000e6a60000e0a4000060d2000065ea000030d50000a05a0000a3760000d0960000d74b0000d04a0000d0a40000b6d0010050d2000020d5000045dd0000a0b50000d0560000b2550000b049000077a50000b0a4000050aa000055b20100206d0000a0ad0000");
    }

    private static String dateToString(int n, int n2, int n3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n);
        stringBuilder.append(LunarCalendar.getString(n2, n3));
        return stringBuilder.toString();
    }

    public static int daysInLunarMonth(int n, int n2) {
        if ((LUNAR_INFO[n - 1900] & 65536 >> n2) != 0) return 30;
        return 29;
    }

    public static String getLunarText(int n, int n2, int n3) {
        String string = LunarCalendar.getSolarTerm(n, n2, n3);
        Object object = LunarCalendar.gregorianFestival(n2, n3);
        if (!TextUtils.isEmpty((CharSequence)object)) {
            return object;
        }
        if (!TextUtils.isEmpty((CharSequence)string)) {
            return string;
        }
        object = LunarUtil.solarToLunar((int)n, (int)n2, (int)n3);
        string = LunarCalendar.getTraditionFestival((int)object[0], (int)object[1], (int)object[2]);
        if (TextUtils.isEmpty((CharSequence)string)) return LunarCalendar.numToChinese((int)object[1], (int)object[2], (int)object[3]);
        return string;
    }

    public static String getLunarText(Calendar calendar) {
        return LunarCalendar.getLunarText(calendar.getYear(), calendar.getMonth(), calendar.getDay());
    }

    private static String getSolarTerm(int n, int n2, int n3) {
        if (!SOLAR_TERMS.containsKey(n)) {
            SOLAR_TERMS.put(n, SolarTermUtil.getSolarTerms((int)n));
        }
        String[] stringArray = SOLAR_TERMS.get(n);
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(n);
        ((StringBuilder)charSequence).append(LunarCalendar.getString(n2, n3));
        String string = ((StringBuilder)charSequence).toString();
        n2 = stringArray.length;
        n = 0;
        while (true) {
            charSequence = "";
            if (n >= n2) return charSequence;
            charSequence = stringArray[n];
            if (((String)charSequence).contains(string)) {
                charSequence = ((String)charSequence).replace(string, "");
                return charSequence;
            }
            ++n;
        }
    }

    private static String getSpecialFestival(int n, int n2, int n3) {
        if (!SPECIAL_FESTIVAL.containsKey(n)) {
            SPECIAL_FESTIVAL.put(n, LunarCalendar.getSpecialFestivals(n));
        }
        String[] stringArray = SPECIAL_FESTIVAL.get(n);
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(n);
        ((StringBuilder)charSequence).append(LunarCalendar.getString(n2, n3));
        String string = ((StringBuilder)charSequence).toString();
        n2 = stringArray.length;
        n = 0;
        while (true) {
            charSequence = "";
            if (n >= n2) return charSequence;
            charSequence = stringArray[n];
            if (((String)charSequence).contains(string)) {
                charSequence = ((String)charSequence).replace(string, "");
                return charSequence;
            }
            ++n;
        }
    }

    private static String[] getSpecialFestivals(int n) {
        StringBuilder stringBuilder;
        String[] stringArray = new String[3];
        Serializable serializable = java.util.Calendar.getInstance();
        ((java.util.Calendar)serializable).set(n, 4, 1);
        int n2 = 7 - ((java.util.Calendar)serializable).get(7) + 1;
        if (n2 == 7) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(LunarCalendar.dateToString(n, 5, n2 + 1));
            stringBuilder.append(SPECIAL_FESTIVAL_STR[0]);
            stringArray[0] = stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(LunarCalendar.dateToString(n, 5, n2 + 7 + 1));
            stringBuilder.append(SPECIAL_FESTIVAL_STR[0]);
            stringArray[0] = stringBuilder.toString();
        }
        ((java.util.Calendar)serializable).set(n, 5, 1);
        n2 = 7 - ((java.util.Calendar)serializable).get(7) + 1;
        if (n2 == 7) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(LunarCalendar.dateToString(n, 6, n2 + 7 + 1));
            stringBuilder.append(SPECIAL_FESTIVAL_STR[1]);
            stringArray[1] = stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(LunarCalendar.dateToString(n, 6, n2 + 7 + 7 + 1));
            stringBuilder.append(SPECIAL_FESTIVAL_STR[1]);
            stringArray[1] = stringBuilder.toString();
        }
        ((java.util.Calendar)serializable).set(n, 10, 1);
        n2 = 7 - ((java.util.Calendar)serializable).get(7) + 1;
        if (n2 <= 2) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append(LunarCalendar.dateToString(n, 11, n2 + 21 + 5));
            ((StringBuilder)serializable).append(SPECIAL_FESTIVAL_STR[2]);
            stringArray[2] = ((StringBuilder)serializable).toString();
        } else {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append(LunarCalendar.dateToString(n, 11, n2 + 14 + 5));
            ((StringBuilder)serializable).append(SPECIAL_FESTIVAL_STR[2]);
            stringArray[2] = ((StringBuilder)serializable).toString();
        }
        return stringArray;
    }

    private static String getString(int n, int n2) {
        Object object;
        StringBuilder stringBuilder = new StringBuilder();
        if (n >= 10) {
            object = String.valueOf(n);
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append("0");
            ((StringBuilder)object).append(n);
            object = ((StringBuilder)object).toString();
        }
        stringBuilder.append((String)object);
        if (n2 >= 10) {
            object = n2;
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append("0");
            ((StringBuilder)object).append(n2);
            object = ((StringBuilder)object).toString();
        }
        stringBuilder.append(object);
        return stringBuilder.toString();
    }

    private static String getTraditionFestival(int n, int n2, int n3) {
        int n4 = 0;
        if (n2 == 12 && n3 == LunarCalendar.daysInLunarMonth(n, n2)) {
            return TRADITION_FESTIVAL_STR[0];
        }
        String string = LunarCalendar.getString(n2, n3);
        String[] stringArray = TRADITION_FESTIVAL_STR;
        n2 = stringArray.length;
        n = n4;
        while (true) {
            String string2 = "";
            if (n >= n2) return string2;
            string2 = stringArray[n];
            if (string2.contains(string)) {
                string2 = string2.replace(string, "");
                return string2;
            }
            ++n;
        }
    }

    private static String gregorianFestival(int n, int n2) {
        String string = LunarCalendar.getString(n, n2);
        String[] stringArray = SOLAR_CALENDAR;
        n2 = stringArray.length;
        n = 0;
        while (true) {
            String string2 = "";
            if (n >= n2) return string2;
            string2 = stringArray[n];
            if (string2.contains(string)) {
                string2 = string2.replace(string, "");
                return string2;
            }
            ++n;
        }
    }

    static void init(Context context) {
        if (MONTH_STR != null) {
            return;
        }
        TrunkBranchAnnals.init((Context)context);
        SolarTermUtil.init((Context)context);
        MONTH_STR = context.getResources().getStringArray(R.array.lunar_first_of_month);
        TRADITION_FESTIVAL_STR = context.getResources().getStringArray(R.array.tradition_festival);
        DAY_STR = context.getResources().getStringArray(R.array.lunar_str);
        SPECIAL_FESTIVAL_STR = context.getResources().getStringArray(R.array.special_festivals);
        SOLAR_CALENDAR = context.getResources().getStringArray(R.array.solar_festival);
    }

    private static String numToChinese(int n, int n2, int n3) {
        if (n2 != 1) return DAY_STR[n2 - 1];
        return LunarCalendar.numToChineseMonth(n, n3);
    }

    private static String numToChineseMonth(int n, int n2) {
        if (n2 != 1) return MONTH_STR[n - 1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\u95f0");
        stringBuilder.append(MONTH_STR[n - 1]);
        return stringBuilder.toString();
    }

    public static void setupLunarCalendar(Calendar calendar) {
        int n = calendar.getYear();
        int n2 = calendar.getMonth();
        int n3 = calendar.getDay();
        calendar.setWeekend(CalendarUtil.isWeekend((Calendar)calendar));
        calendar.setWeek(CalendarUtil.getWeekFormCalendar((Calendar)calendar));
        Calendar calendar2 = new Calendar();
        calendar.setLunarCalendar(calendar2);
        Object object = LunarUtil.solarToLunar((int)n, (int)n2, (int)n3);
        calendar2.setYear(object[0]);
        calendar2.setMonth(object[1]);
        calendar2.setDay(object[2]);
        calendar.setLeapYear(CalendarUtil.isLeapYear((int)n));
        if (object[3] == 1) {
            calendar.setLeapMonth(object[1]);
            calendar2.setLeapMonth(object[1]);
        }
        String string = LunarCalendar.getSolarTerm(n, n2, n3);
        String string2 = LunarCalendar.gregorianFestival(n2, n3);
        String string3 = LunarCalendar.getTraditionFestival(object[0], object[1], object[2]);
        String string4 = LunarCalendar.numToChinese(object[1], object[2], object[3]);
        object = string2;
        if (TextUtils.isEmpty((CharSequence)string2)) {
            object = LunarCalendar.getSpecialFestival(n, n2, n3);
        }
        calendar.setSolarTerm(string);
        calendar.setGregorianFestival((String)object);
        calendar.setTraditionFestival(string3);
        calendar2.setTraditionFestival(string3);
        calendar2.setSolarTerm(string);
        if (!TextUtils.isEmpty((CharSequence)string)) {
            calendar.setLunar(string);
        } else if (!TextUtils.isEmpty((CharSequence)object)) {
            calendar.setLunar((String)object);
        } else if (!TextUtils.isEmpty((CharSequence)string3)) {
            calendar.setLunar(string3);
        } else {
            calendar.setLunar(string4);
        }
        calendar2.setLunar(string4);
    }

    private static long[] $d2j$hex$3ebaf898$decode_J(String src) {
        byte[] d = LunarCalendar.$d2j$hex$3ebaf898$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s.get(data);
        return data;
    }

    private static int[] $d2j$hex$3ebaf898$decode_I(String src) {
        byte[] d = LunarCalendar.$d2j$hex$3ebaf898$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s.get(data);
        return data;
    }

    private static short[] $d2j$hex$3ebaf898$decode_S(String src) {
        byte[] d = LunarCalendar.$d2j$hex$3ebaf898$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s.get(data);
        return data;
    }

    private static byte[] $d2j$hex$3ebaf898$decode_B(String src) {
        char[] d = src.toCharArray();
        byte[] ret = new byte[src.length() / 2];
        int i = 0;
        while (i < ret.length) {
            int ll;
            int hh;
            char h = d[2 * i];
            char l = d[2 * i + 1];
            if (h >= '0' && h <= '9') {
                hh = h - 48;
            } else if (h >= 'a' && h <= 'f') {
                hh = h - 97 + 10;
            } else {
                if (h < 'A') throw new RuntimeException();
                if (h > 'F') throw new RuntimeException();
                hh = h - 65 + 10;
            }
            if (l >= '0' && l <= '9') {
                ll = l - 48;
            } else if (l >= 'a' && l <= 'f') {
                ll = l - 97 + 10;
            } else {
                if (l < 'A') throw new RuntimeException();
                if (l > 'F') throw new RuntimeException();
                ll = l - 65 + 10;
            }
            ret[i] = (byte)(hh << 4 | ll);
            ++i;
        }
        return ret;
    }
}
