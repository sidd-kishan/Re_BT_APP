/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.Logger
 */
package org.greenrobot.eventbus;

import java.io.PrintStream;
import java.util.logging.Level;
import org.greenrobot.eventbus.Logger;

public static class Logger.SystemOutLogger
implements Logger {
    public void log(Level level, String string) {
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(level);
        stringBuilder.append("] ");
        stringBuilder.append(string);
        printStream.println(stringBuilder.toString());
    }

    public void log(Level level, String string, Throwable throwable) {
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(level);
        stringBuilder.append("] ");
        stringBuilder.append(string);
        printStream.println(stringBuilder.toString());
        throwable.printStackTrace(System.out);
    }
}
