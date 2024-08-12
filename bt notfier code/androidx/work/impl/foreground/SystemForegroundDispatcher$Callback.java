/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 */
package androidx.work.impl.foreground;

import android.app.Notification;

static interface SystemForegroundDispatcher.Callback {
    public void cancelNotification(int var1);

    public void notify(int var1, Notification var2);

    public void startForeground(int var1, int var2, Notification var3);

    public void stop();
}
