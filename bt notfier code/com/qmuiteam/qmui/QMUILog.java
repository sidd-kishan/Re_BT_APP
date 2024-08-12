/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.QMUILog$QMUILogDelegate
 */
package com.qmuiteam.qmui;

import com.qmuiteam.qmui.QMUILog;

public class QMUILog {
    private static QMUILogDelegate sDelegete;

    public static void d(String string, String string2, Object ... objectArray) {
        QMUILogDelegate qMUILogDelegate = sDelegete;
        if (qMUILogDelegate == null) return;
        qMUILogDelegate.d(string, string2, objectArray);
    }

    public static void e(String string, String string2, Object ... objectArray) {
        QMUILogDelegate qMUILogDelegate = sDelegete;
        if (qMUILogDelegate == null) return;
        qMUILogDelegate.e(string, string2, objectArray);
    }

    public static void i(String string, String string2, Object ... objectArray) {
        QMUILogDelegate qMUILogDelegate = sDelegete;
        if (qMUILogDelegate == null) return;
        qMUILogDelegate.i(string, string2, objectArray);
    }

    public static void printErrStackTrace(String string, Throwable throwable, String string2, Object ... objectArray) {
        QMUILogDelegate qMUILogDelegate = sDelegete;
        if (qMUILogDelegate == null) return;
        qMUILogDelegate.printErrStackTrace(string, throwable, string2, objectArray);
    }

    public static void setDelegete(QMUILogDelegate qMUILogDelegate) {
        sDelegete = qMUILogDelegate;
    }

    public static void w(String string, String string2, Object ... objectArray) {
        QMUILogDelegate qMUILogDelegate = sDelegete;
        if (qMUILogDelegate == null) return;
        qMUILogDelegate.w(string, string2, objectArray);
    }
}
