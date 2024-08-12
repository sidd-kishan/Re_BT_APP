/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.orhanobut.logger.LogAdapter
 */
package com.orhanobut.logger;

import com.orhanobut.logger.LogAdapter;

public interface Printer {
    public void addAdapter(LogAdapter var1);

    public void clearLogAdapters();

    public void d(Object var1);

    public void d(String var1, Object ... var2);

    public void e(String var1, Object ... var2);

    public void e(Throwable var1, String var2, Object ... var3);

    public void i(String var1, Object ... var2);

    public void json(String var1);

    public void log(int var1, String var2, String var3, Throwable var4);

    public Printer t(String var1);

    public void v(String var1, Object ... var2);

    public void w(String var1, Object ... var2);

    public void wtf(String var1, Object ... var2);

    public void xml(String var1);
}
