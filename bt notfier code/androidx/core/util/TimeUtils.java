/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.util;

import java.io.PrintWriter;

public final class TimeUtils {
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static char[] sFormatStr;
    private static final Object sFormatSync;

    static {
        sFormatSync = new Object();
        sFormatStr = new char[24];
    }

    private TimeUtils() {
    }

    private static int accumField(int n, int n2, boolean bl, int n3) {
        if (n > 99) return n2 + 3;
        if (bl && n3 >= 3) {
            return n2 + 3;
        }
        if (n > 9) return n2 + 2;
        if (bl && n3 >= 2) {
            return n2 + 2;
        }
        if (bl) return n2 + 1;
        if (n <= 0) return 0;
        return n2 + 1;
    }

    public static void formatDuration(long l, long l2, PrintWriter printWriter) {
        if (l == 0L) {
            printWriter.print("--");
            return;
        }
        TimeUtils.formatDuration(l - l2, printWriter, 0);
    }

    public static void formatDuration(long l, PrintWriter printWriter) {
        TimeUtils.formatDuration(l, printWriter, 0);
    }

    public static void formatDuration(long l, PrintWriter printWriter, int n) {
        Object object = sFormatSync;
        synchronized (object) {
            n = TimeUtils.formatDurationLocked(l, n);
            String string = new String(sFormatStr, 0, n);
            printWriter.print(string);
            return;
        }
    }

    public static void formatDuration(long l, StringBuilder stringBuilder) {
        Object object = sFormatSync;
        synchronized (object) {
            int n = TimeUtils.formatDurationLocked(l, 0);
            stringBuilder.append(sFormatStr, 0, n);
            return;
        }
    }

    private static int formatDurationLocked(long l, int n) {
        int n2;
        int n3;
        boolean bl;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        if (sFormatStr.length < n) {
            sFormatStr = new char[n];
        }
        char[] cArray = sFormatStr;
        if (l == 0L) {
            while (true) {
                if (n - 1 <= 0) {
                    cArray[0] = 48;
                    return 1;
                }
                cArray[0] = 32;
            }
        }
        if (l > 0L) {
            n8 = 43;
        } else {
            n8 = 45;
            l = -l;
        }
        int n9 = (int)(l % 1000L);
        int n10 = (int)Math.floor(l / 1000L);
        if (n10 > 86400) {
            n7 = n10 / 86400;
            n10 -= 86400 * n7;
        } else {
            n7 = 0;
        }
        if (n10 > 3600) {
            n6 = n10 / 3600;
            n10 -= n6 * 3600;
        } else {
            n6 = 0;
        }
        if (n10 > 60) {
            n5 = n10 / 60;
            n4 = n10 - n5 * 60;
        } else {
            n5 = 0;
            n4 = n10;
        }
        if (n != 0) {
            n10 = TimeUtils.accumField(n7, 1, false, 0);
            bl = n10 > 0;
            bl = (n10 += TimeUtils.accumField(n6, 1, bl, 2)) > 0;
            bl = (n10 += TimeUtils.accumField(n5, 1, bl, 2)) > 0;
            n3 = n10 + TimeUtils.accumField(n4, 1, bl, 2);
            n10 = n3 > 0 ? 3 : 0;
            n3 += TimeUtils.accumField(n9, 2, true, n10) + 1;
            n10 = 0;
            while (true) {
                n2 = ++n10;
                if (n3 < n) {
                    cArray[n10] = 32;
                    ++n3;
                    continue;
                }
                break;
            }
        } else {
            n2 = 0;
        }
        cArray[n2] = n8;
        n3 = n2 + 1;
        n = n != 0 ? 1 : 0;
        n7 = TimeUtils.printField(cArray, n7, 'd', n3, false, 0);
        bl = n7 != n3;
        n10 = n != 0 ? 2 : 0;
        n7 = TimeUtils.printField(cArray, n6, 'h', n7, bl, n10);
        bl = n7 != n3;
        n10 = n != 0 ? 2 : 0;
        n7 = TimeUtils.printField(cArray, n5, 'm', n7, bl, n10);
        bl = n7 != n3;
        n10 = n != 0 ? 2 : 0;
        n10 = TimeUtils.printField(cArray, n4, 's', n7, bl, n10);
        n = n != 0 && n10 != n3 ? 3 : 0;
        n = TimeUtils.printField(cArray, n9, 'm', n10, true, n);
        cArray[n] = 115;
        return n + 1;
    }

    private static int printField(char[] cArray, int n, char c, int n2, boolean bl, int n3) {
        int n4;
        int n5;
        block7: {
            block6: {
                if (!bl) {
                    n5 = n2;
                    if (n <= 0) return n5;
                }
                if (bl && n3 >= 3 || n > 99) {
                    n4 = n / 100;
                    cArray[n2] = (char)(n4 + 48);
                    n5 = n2 + 1;
                    n -= n4 * 100;
                } else {
                    n5 = n2;
                }
                if (bl && n3 >= 2 || n > 9) break block6;
                n4 = n5;
                n3 = n;
                if (n2 == n5) break block7;
            }
            n2 = n / 10;
            cArray[n5] = (char)(n2 + 48);
            n4 = n5 + 1;
            n3 = n - n2 * 10;
        }
        cArray[n4] = (char)(n3 + 48);
        n = n4 + 1;
        cArray[n] = c;
        n5 = n + 1;
        return n5;
    }
}
