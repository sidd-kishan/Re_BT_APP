/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.orhanobut.logger.LogAdapter
 *  com.orhanobut.logger.LoggerPrinter
 *  com.orhanobut.logger.Printer
 *  com.orhanobut.logger.Utils
 */
package com.orhanobut.logger;

import com.orhanobut.logger.LogAdapter;
import com.orhanobut.logger.LoggerPrinter;
import com.orhanobut.logger.Printer;
import com.orhanobut.logger.Utils;

public final class Logger {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static Printer printer = new LoggerPrinter();

    private Logger() {
    }

    public static void addLogAdapter(LogAdapter logAdapter) {
        printer.addAdapter((LogAdapter)Utils.checkNotNull((Object)logAdapter));
    }

    public static void clearLogAdapters() {
        printer.clearLogAdapters();
    }

    public static void d(Object object) {
        printer.d(object);
    }

    public static void d(String string, Object ... objectArray) {
        printer.d(string, objectArray);
    }

    public static void e(String string, Object ... objectArray) {
        printer.e(null, string, objectArray);
    }

    public static void e(Throwable throwable, String string, Object ... objectArray) {
        printer.e(throwable, string, objectArray);
    }

    public static void i(String string, Object ... objectArray) {
        printer.i(string, objectArray);
    }

    public static void json(String string) {
        printer.json(string);
    }

    public static void log(int n, String string, String string2, Throwable throwable) {
        printer.log(n, string, string2, throwable);
    }

    public static void printer(Printer printer) {
        Logger.printer = (Printer)Utils.checkNotNull((Object)printer);
    }

    public static Printer t(String string) {
        return printer.t(string);
    }

    public static void v(String string, Object ... objectArray) {
        printer.v(string, objectArray);
    }

    public static void w(String string, Object ... objectArray) {
        printer.w(string, objectArray);
    }

    public static void wtf(String string, Object ... objectArray) {
        printer.wtf(string, objectArray);
    }

    public static void xml(String string) {
        printer.xml(string);
    }
}
