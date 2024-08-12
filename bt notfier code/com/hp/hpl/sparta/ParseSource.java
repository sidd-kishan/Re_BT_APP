/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.DefaultLog
 *  com.hp.hpl.sparta.ParseLog
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.DefaultLog;
import com.hp.hpl.sparta.ParseLog;

public interface ParseSource {
    public static final ParseLog DEFAULT_LOG = new DefaultLog();
    public static final int MAXLOOKAHEAD = 71;

    public int getLineNumber();

    public String getSystemId();

    public String toString();
}
