/*
 * Decompiled with CFR 0.152.
 */
package com.mediatek.wearable;

public class LoadJniFunction {
    public static final int CMD_1 = 1;
    public static final int CMD_2 = 2;
    public static final int CMD_3 = 3;
    public static final int CMD_4 = 4;
    public static final int CMD_5 = 5;
    public static final int CMD_6 = 6;
    public static final int CMD_7 = 7;
    public static final int CMD_8 = 8;
    private static final String LIB_NAME = "Command";

    static {
        System.loadLibrary(LIB_NAME);
    }

    public int getCmdType(byte[] byArray, int n) {
        return this.getCmdTypeFromJni(byArray, n);
    }

    public native int getCmdTypeFromJni(byte[] var1, int var2);

    public byte[] getDataCmd(int n, String string) {
        return this.getDataCmdFromJni(n, string);
    }

    public native byte[] getDataCmdFromJni(int var1, String var2);

    public int getDataLenth(byte[] byArray, int n) {
        return this.getDataLenthFromJni(byArray, n);
    }

    public native int getDataLenthFromJni(byte[] var1, int var2);
}
