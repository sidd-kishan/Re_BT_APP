/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey
 *  com.google.android.gms.common.api.internal.ListenerHolder$Notifier
 *  com.google.android.gms.common.api.internal.zabv
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.zabv;
import com.google.android.gms.common.internal.Preconditions;

public final class ListenerHolder<L> {
    private final zabv zaa;
    private volatile L zab;
    private volatile ListenerKey<L> zac;

    ListenerHolder(Looper looper, L l, String string) {
        this.zaa = new zabv(this, looper);
        this.zab = Preconditions.checkNotNull(l, (Object)"Listener must not be null");
        this.zac = new ListenerKey(l, Preconditions.checkNotEmpty((String)string));
    }

    public void clear() {
        this.zab = null;
        this.zac = null;
    }

    public ListenerKey<L> getListenerKey() {
        return this.zac;
    }

    public boolean hasListener() {
        if (this.zab == null) return false;
        return true;
    }

    public void notifyListener(Notifier<? super L> message) {
        Preconditions.checkNotNull(message, (Object)"Notifier must not be null");
        message = this.zaa.obtainMessage(1, message);
        this.zaa.sendMessage(message);
    }

    void notifyListenerInternal(Notifier<? super L> notifier) {
        L l = this.zab;
        if (l == null) {
            notifier.onNotifyListenerFailed();
            return;
        }
        try {
            notifier.notifyListener(l);
            return;
        }
        catch (RuntimeException runtimeException) {
            notifier.onNotifyListenerFailed();
            throw runtimeException;
        }
    }
}
