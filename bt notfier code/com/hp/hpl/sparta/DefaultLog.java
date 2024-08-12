/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.ParseLog
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.ParseLog;
import java.io.PrintStream;

class DefaultLog
implements ParseLog {
    DefaultLog() {
    }

    public void error(String string, String string2, int n) {
        PrintStream printStream = System.err;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string2);
        stringBuffer.append("(");
        stringBuffer.append(n);
        stringBuffer.append("): ");
        stringBuffer.append(string);
        stringBuffer.append(" (ERROR)");
        printStream.println(stringBuffer.toString());
    }

    public void note(String string, String string2, int n) {
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string2);
        stringBuffer.append("(");
        stringBuffer.append(n);
        stringBuffer.append("): ");
        stringBuffer.append(string);
        stringBuffer.append(" (NOTE)");
        printStream.println(stringBuffer.toString());
    }

    public void warning(String string, String string2, int n) {
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string2);
        stringBuffer.append("(");
        stringBuffer.append(n);
        stringBuffer.append("): ");
        stringBuffer.append(string);
        stringBuffer.append(" (WARNING)");
        printStream.println(stringBuffer.toString());
    }
}
