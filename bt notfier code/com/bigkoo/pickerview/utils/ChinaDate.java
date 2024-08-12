/*
 * Decompiled with CFR 0.152.
 */
package com.bigkoo.pickerview.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class ChinaDate {
    private static final String[] Animals;
    private static final String[] Gan;
    private static final String[] Zhi;
    private static final long[] lunarInfo;
    private static final String[] nStr1;
    private static SimpleDateFormat sdf;

    static {
        lunarInfo = ChinaDate.$d2j$hex$f6c92da3$decode_J("d84b000000000000e04a00000000000070a5000000000000d55400000000000060d200000000000050d90000000000005465010000000000a056000000000000d09a000000000000d255000000000000e04a000000000000b6a5000000000000d0a400000000000050d200000000000055d201000000000040b5000000000000a0d6000000000000a2ad000000000000b09500000000000077490100000000007049000000000000b0a4000000000000b5b4000000000000506a000000000000406d00000000000054ab010000000000602b0000000000007095000000000000f25200000000000070490000000000006665000000000000a0d400000000000050ea000000000000956e000000000000d05a000000000000602b000000000000e386010000000000e092000000000000d7c801000000000050c9000000000000a0d4000000000000a6d801000000000050b5000000000000a056000000000000b4a5010000000000d025000000000000d092000000000000b2d200000000000050a900000000000057b5000000000000a06c00000000000050b50000000000005553010000000000a04d000000000000b0a50000000000007345010000000000b052000000000000a8a900000000000050e9000000000000a06a000000000000a6ae00000000000050ab000000000000604b000000000000e4aa00000000000070a5000000000000605200000000000063f200000000000050d9000000000000575b000000000000a056000000000000d096000000000000d54d000000000000d04a000000000000d0a4000000000000d4d400000000000050d200000000000058d500000000000040b5000000000000a0b6000000000000a695010000000000b095000000000000b04900000000000074a9000000000000b0a40000000000007ab2000000000000506a000000000000406d00000000000046af00000000000060ab0000000000007095000000000000f54a0000000000007049000000000000b064000000000000a37400000000000050ea000000000000586b000000000000c05500000000000060ab000000000000d596000000000000e09200000000000060c900000000000054d9000000000000a0d400000000000050da0000000000005275000000000000a056000000000000b7ab000000000000d025000000000000d092000000000000b5ca00000000000050a9000000000000a0b4000000000000a4ba00000000000050ad000000000000d955000000000000a04b000000000000b0a50000000000007651010000000000b05200000000000030a90000000000005479000000000000a06a00000000000050ad000000000000525b000000000000604b000000000000e6a6000000000000e0a400000000000060d200000000000065ea00000000000030d5000000000000a05a000000000000a376000000000000d096000000000000fb4a000000000000d04a000000000000d0a4000000000000b6d001000000000050d200000000000020d500000000000045dd000000000000a0b5000000000000d056000000000000b255000000000000b04900000000000077a5000000000000b0a400000000000050aa00000000000055b2010000000000206d000000000000a0ad000000000000634b0100000000007093000000000000f8490000000000007049000000000000b064000000000000a66801000000000050ea000000000000206b000000000000c4a6010000000000e0aa000000000000e0a2000000000000e3d200000000000060c900000000000057d5000000000000a0d400000000000050da000000000000555d000000000000a056000000000000d0a6000000000000d455000000000000d052000000000000b8a900000000000050a9000000000000a0b4000000000000a6b600000000000050ad000000000000a055000000000000a4ab000000000000b0a5000000000000b05200000000000073b200000000000030690000000000003773000000000000a06a00000000000050ad000000000000554b010000000000604b00000000000070a5000000000000e45400000000000060d100000000000068e900000000000020d5000000000000a0da000000000000a66a010000000000d056000000000000e04a000000000000d4a9000000000000d0a200000000000050d100000000000052f200000000000020d5000000000000");
        nStr1 = new String[]{"", "\u6b63", "\u4e8c", "\u4e09", "\u56db", "\u4e94", "\u516d", "\u4e03", "\u516b", "\u4e5d", "\u5341", "\u51ac", "\u814a"};
        Gan = new String[]{"\u7532", "\u4e59", "\u4e19", "\u4e01", "\u620a", "\u5df1", "\u5e9a", "\u8f9b", "\u58ec", "\u7678"};
        Zhi = new String[]{"\u5b50", "\u4e11", "\u5bc5", "\u536f", "\u8fb0", "\u5df3", "\u5348", "\u672a", "\u7533", "\u9149", "\u620c", "\u4ea5"};
        Animals = new String[]{"\u9f20", "\u725b", "\u864e", "\u5154", "\u9f99", "\u86c7", "\u9a6c", "\u7f8a", "\u7334", "\u9e21", "\u72d7", "\u732a"};
        sdf = new SimpleDateFormat("yyyy\u5e74M\u6708d\u65e5 EEEEE");
    }

    public static final String AnimalsYear(int n) {
        return Animals[(n - 4) % 12];
    }

    public static final long[] calElement(int n, int n2, int n3) {
        long[] lArray = new long[7];
        int n4 = 1900;
        Date date = new GregorianCalendar(1900, 0, 31).getTime();
        long l = (new GregorianCalendar(n, n2 - 1, n3).getTime().getTime() - date.getTime()) / 86400000L;
        lArray[5] = 40L + l;
        lArray[4] = 14L;
        n2 = 0;
        for (n = n4; n < 2100 && l > 0L; l -= (long)n2, ++n) {
            n2 = ChinaDate.lYearDays(n);
            lArray[4] = lArray[4] + 12L;
        }
        n3 = n;
        long l2 = l;
        if (l < 0L) {
            l2 = l + (long)n2;
            n3 = n - 1;
            lArray[4] = lArray[4] - 12L;
        }
        lArray[0] = n3;
        lArray[3] = n3 - 1864;
        n4 = ChinaDate.leapMonth(n3);
        lArray[6] = 0L;
        n = 1;
        n3 = n2;
        while (n < 13 && l2 > 0L) {
            if (n4 > 0 && n == n4 + 1 && lArray[6] == 0L) {
                n2 = n - 1;
                lArray[6] = 1L;
                n = ChinaDate.leapDays((int)lArray[0]);
            } else {
                n3 = ChinaDate.monthDays((int)lArray[0], n);
                n2 = n;
                n = n3;
            }
            if (lArray[6] == 1L && n2 == n4 + 1) {
                lArray[6] = 0L;
            }
            l = n;
            if (lArray[6] == 0L) {
                lArray[4] = lArray[4] + 1L;
            }
            l2 -= l;
            n3 = n;
            n = ++n2;
        }
        n2 = n;
        if (l2 == 0L) {
            n2 = n;
            if (n4 > 0) {
                n2 = n;
                if (n == n4 + 1) {
                    if (lArray[6] == 1L) {
                        lArray[6] = 0L;
                        n2 = n;
                    } else {
                        lArray[6] = 1L;
                        n2 = n - 1;
                        lArray[4] = lArray[4] - 1L;
                    }
                }
            }
        }
        if (l2 < 0L) {
            l2 += (long)n3;
            --n2;
            lArray[4] = lArray[4] - 1L;
        }
        lArray[1] = n2;
        lArray[2] = l2 + 1L;
        return lArray;
    }

    public static final String cyclical(int n) {
        return ChinaDate.cyclicalm(n - 1900 + 36);
    }

    private static final String cyclicalm(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Gan[n % 10]);
        stringBuilder.append(Zhi[n % 12]);
        return stringBuilder.toString();
    }

    public static final String getChinaDate(int n) {
        if (n == 10) {
            return "\u521d\u5341";
        }
        if (n == 20) {
            return "\u4e8c\u5341";
        }
        if (n == 30) {
            return "\u4e09\u5341";
        }
        int n2 = n / 10;
        String string = n2 == 0 ? "\u521d" : "";
        if (n2 == 1) {
            string = "\u5341";
        }
        if (n2 == 2) {
            string = "\u5eff";
        }
        if (n2 == 3) {
            string = "\u4e09";
        }
        switch (n % 10) {
            default: {
                break;
            }
            case 9: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append("\u4e5d");
                string = stringBuilder.toString();
                break;
            }
            case 8: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append("\u516b");
                string = stringBuilder.toString();
                break;
            }
            case 7: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append("\u4e03");
                string = stringBuilder.toString();
                break;
            }
            case 6: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append("\u516d");
                string = stringBuilder.toString();
                break;
            }
            case 5: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append("\u4e94");
                string = stringBuilder.toString();
                break;
            }
            case 4: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append("\u56db");
                string = stringBuilder.toString();
                break;
            }
            case 3: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append("\u4e09");
                string = stringBuilder.toString();
                break;
            }
            case 2: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append("\u4e8c");
                string = stringBuilder.toString();
                break;
            }
            case 1: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append("\u4e00");
                string = stringBuilder.toString();
            }
        }
        return string;
    }

    public static String getCurrentLunarDate() {
        Calendar calendar = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
        int n = calendar.get(1);
        Object object = ChinaDate.calElement(n, calendar.get(2) + 1, calendar.get(5));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(sdf.format(calendar.getTime()));
        stringBuffer.append(" \u519c\u5386");
        stringBuffer.append(ChinaDate.cyclical(n));
        stringBuffer.append('(');
        stringBuffer.append(ChinaDate.AnimalsYear(n));
        stringBuffer.append(")\u5e74");
        stringBuffer.append(nStr1[(int)object[1]]);
        stringBuffer.append("\u6708");
        stringBuffer.append(ChinaDate.getChinaDate((int)object[2]));
        object = stringBuffer.toString();
        return object;
    }

    public static ArrayList<String> getLunarDays(int n) {
        ArrayList<String> arrayList = new ArrayList<String>();
        int n2 = 1;
        while (n2 <= n) {
            arrayList.add(ChinaDate.getChinaDate(n2));
            ++n2;
        }
        return arrayList;
    }

    public static String getLunarYearText(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] stringArray = Gan;
        stringBuilder.append(stringArray[(n -= 4) % 10]);
        stringBuilder.append(Zhi[n % 12]);
        stringBuilder.append("\u5e74");
        return stringBuilder.toString();
    }

    public static ArrayList<String> getMonths(int n) {
        ArrayList<String> arrayList = new ArrayList<String>();
        int n2 = 1;
        while (true) {
            StringBuilder stringBuilder;
            if (n2 >= nStr1.length) {
                if (ChinaDate.leapMonth(n) == 0) return arrayList;
                n2 = ChinaDate.leapMonth(n);
                stringBuilder = new StringBuilder();
                stringBuilder.append("\u95f0");
                stringBuilder.append(nStr1[ChinaDate.leapMonth(n)]);
                stringBuilder.append("\u6708");
                arrayList.add(n2, stringBuilder.toString());
                return arrayList;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(nStr1[n2]);
            stringBuilder.append("\u6708");
            arrayList.add(stringBuilder.toString());
            ++n2;
        }
    }

    public static ArrayList<String> getYears(int n, int n2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        while (n < n2) {
            arrayList.add(String.format("%s(%d)", ChinaDate.getLunarYearText(n), n));
            ++n;
        }
        return arrayList;
    }

    private static final int lYearDays(int n) {
        int n2 = 348;
        int n3 = 32768;
        while (n3 > 8) {
            int n4 = n2;
            if ((lunarInfo[n - 1900] & (long)n3) != 0L) {
                n4 = n2 + 1;
            }
            n3 >>= 1;
            n2 = n4;
        }
        return n2 + ChinaDate.leapDays(n);
    }

    public static final int leapDays(int n) {
        if (ChinaDate.leapMonth(n) == 0) return 0;
        if ((lunarInfo[n - 1900] & 0x10000L) == 0L) return 29;
        return 30;
    }

    public static final int leapMonth(int n) {
        return (int)(lunarInfo[n - 1900] & 0xFL);
    }

    public static final int monthDays(int n, int n2) {
        long l = lunarInfo[n - 1900];
        if (((long)(65536 >> n2) & l) != 0L) return 30;
        return 29;
    }

    public static String oneDay(int n, int n2, int n3) {
        Object object = ChinaDate.calElement(n, n2, n3);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" \u519c\u5386");
        stringBuffer.append(ChinaDate.cyclical(n));
        stringBuffer.append('(');
        stringBuffer.append(ChinaDate.AnimalsYear(n));
        stringBuffer.append(")\u5e74");
        stringBuffer.append(nStr1[(int)object[1]]);
        stringBuffer.append("\u6708");
        stringBuffer.append(ChinaDate.getChinaDate((int)object[2]));
        object = stringBuffer.toString();
        return object;
    }

    private static long[] $d2j$hex$f6c92da3$decode_J(String src) {
        byte[] d = ChinaDate.$d2j$hex$f6c92da3$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s.get(data);
        return data;
    }

    private static int[] $d2j$hex$f6c92da3$decode_I(String src) {
        byte[] d = ChinaDate.$d2j$hex$f6c92da3$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s.get(data);
        return data;
    }

    private static short[] $d2j$hex$f6c92da3$decode_S(String src) {
        byte[] d = ChinaDate.$d2j$hex$f6c92da3$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s.get(data);
        return data;
    }

    private static byte[] $d2j$hex$f6c92da3$decode_B(String src) {
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
