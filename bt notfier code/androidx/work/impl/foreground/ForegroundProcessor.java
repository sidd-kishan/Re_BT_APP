/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.ForegroundInfo
 */
package androidx.work.impl.foreground;

import androidx.work.ForegroundInfo;

public interface ForegroundProcessor {
    public void startForeground(String var1, ForegroundInfo var2);

    public void stopForeground(String var1);
}
