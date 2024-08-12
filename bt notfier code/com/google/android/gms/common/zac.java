/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  com.google.android.gms.common.GoogleApiAvailability
 *  com.google.android.gms.internal.base.zap
 */
package com.google.android.gms.common;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.internal.base.zap;

final class zac
extends zap {
    final GoogleApiAvailability zaa;
    private final Context zab;

    public zac(GoogleApiAvailability googleApiAvailability, Context context) {
        this.zaa = googleApiAvailability;
        googleApiAvailability = Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper();
        super((Looper)googleApiAvailability);
        this.zab = context.getApplicationContext();
    }

    public final void handleMessage(Message object) {
        if (((Message)object).what != 1) {
            int n = ((Message)object).what;
            object = new StringBuilder(50);
            ((StringBuilder)object).append("Don't know how to handle this message: ");
            ((StringBuilder)object).append(n);
            Log.w((String)"GoogleApiAvailability", (String)((StringBuilder)object).toString());
            return;
        }
        int n = this.zaa.isGooglePlayServicesAvailable(this.zab);
        if (!this.zaa.isUserResolvableError(n)) return;
        this.zaa.showErrorNotification(this.zab, n);
    }
}
