/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.MApplication
 *  com.lianhezhuli.btnotification.utils.StringUtils
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.utils;

import com.lianhezhuli.btnotification.MApplication;
import com.lianhezhuli.btnotification.utils.StringUtils;
import com.orhanobut.logger.Logger;
import java.util.ArrayList;

public class AlarmRepeatUtils {
    public static String getCommandRepeat(int n) {
        String string = StringUtils.hexStringToByte((int)n);
        if (string.length() == 7) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("%0");
        stringBuilder2.append(7 - string.length());
        stringBuilder2.append("d");
        stringBuilder.append(StringUtils.formatStr((String)stringBuilder2.toString(), (Object[])new Object[]{0}));
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public static int[] getRepeat(int n) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if ((n & 0x40) != 0) {
            arrayList.add(0);
        }
        if ((n & 0x20) != 0) {
            arrayList.add(1);
        }
        if ((n & 0x10) != 0) {
            arrayList.add(2);
        }
        if ((n & 8) != 0) {
            arrayList.add(3);
        }
        if ((n & 4) != 0) {
            arrayList.add(4);
        }
        if ((n & 2) != 0) {
            arrayList.add(5);
        }
        if ((n & 1) != 0) {
            arrayList.add(6);
        }
        int[] nArray = new int[arrayList.size()];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("repeat size == ");
        stringBuilder.append(arrayList.size());
        Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        n = 0;
        while (n < arrayList.size()) {
            nArray[n] = (Integer)arrayList.get(n);
            stringBuilder = new StringBuilder();
            stringBuilder.append("repeat output[i] == ");
            stringBuilder.append(nArray[n]);
            Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
            ++n;
        }
        return nArray;
    }

    public static String getRepeatStr(int n) {
        if (n == 0) {
            return MApplication.getInstance().getString(2131755203);
        }
        if (n == 127) {
            return MApplication.getInstance().getString(2131755202);
        }
        StringBuilder stringBuilder = new StringBuilder();
        if ((n & 0x40) != 0) {
            stringBuilder.append(MApplication.getInstance().getString(2131755263));
            stringBuilder.append("\u3001");
        }
        if ((n & 0x20) != 0) {
            stringBuilder.append(MApplication.getInstance().getString(2131755251));
            stringBuilder.append("\u3001");
        }
        if ((n & 0x10) != 0) {
            stringBuilder.append(MApplication.getInstance().getString(2131755267));
            stringBuilder.append("\u3001");
        }
        if ((n & 8) != 0) {
            stringBuilder.append(MApplication.getInstance().getString(2131755272));
            stringBuilder.append("\u3001");
        }
        if ((n & 4) != 0) {
            stringBuilder.append(MApplication.getInstance().getString(2131755266));
            stringBuilder.append("\u3001");
        }
        if ((n & 2) != 0) {
            stringBuilder.append(MApplication.getInstance().getString(2131755242));
            stringBuilder.append("\u3001");
        }
        if ((n & 1) == 0) return stringBuilder.substring(0, stringBuilder.length() - 1);
        stringBuilder.append(MApplication.getInstance().getString(2131755256));
        stringBuilder.append("\u3001");
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    public static int handleRepeat(int[] nArray) {
        int n = 0;
        int n2 = 0;
        while (n < nArray.length) {
            switch (nArray[n]) {
                default: {
                    break;
                }
                case 6: {
                    ++n2;
                    break;
                }
                case 5: {
                    n2 += 2;
                    break;
                }
                case 4: {
                    n2 += 4;
                    break;
                }
                case 3: {
                    n2 += 8;
                    break;
                }
                case 2: {
                    n2 += 16;
                    break;
                }
                case 1: {
                    n2 += 32;
                    break;
                }
                case 0: {
                    n2 += 64;
                }
            }
            ++n;
        }
        return n2;
    }
}
