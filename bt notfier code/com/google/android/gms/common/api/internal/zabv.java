/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.os.Message
 *  com.google.android.gms.common.api.internal.ListenerHolder
 *  com.google.android.gms.common.api.internal.ListenerHolder$Notifier
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.base.zap
 */
package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;

final class zabv
extends zap {
    final ListenerHolder zaa;

    public zabv(ListenerHolder listenerHolder, Looper looper) {
        this.zaa = listenerHolder;
        super(looper);
    }

    public final void handleMessage(Message message) {
        int n = message.what;
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        Preconditions.checkArgument((boolean)bl);
        message = (ListenerHolder.Notifier)message.obj;
        this.zaa.notifyListenerInternal((ListenerHolder.Notifier)message);
    }
}
