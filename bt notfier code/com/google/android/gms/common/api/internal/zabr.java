/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  com.google.android.gms.common.api.internal.zabq
 */
package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.internal.zabq;

public final class zabr
extends BroadcastReceiver {
    Context zaa;
    private final zabq zab;

    public zabr(zabq zabq2) {
        this.zab = zabq2;
    }

    public final void onReceive(Context object, Intent intent) {
        object = intent.getData();
        object = object != null ? object.getSchemeSpecificPart() : null;
        if (!"com.google.android.gms".equals(object)) return;
        this.zab.zaa();
        this.zab();
    }

    public final void zaa(Context context) {
        this.zaa = context;
    }

    public final void zab() {
        synchronized (this) {
            Context context = this.zaa;
            if (context != null) {
                context.unregisterReceiver((BroadcastReceiver)this);
            }
            this.zaa = null;
            return;
        }
    }
}
