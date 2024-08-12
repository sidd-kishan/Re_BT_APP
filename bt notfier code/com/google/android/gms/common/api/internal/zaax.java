/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  com.google.android.gms.common.api.internal.zaaz
 *  com.google.android.gms.internal.base.zap
 */
package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.internal.zaaz;
import com.google.android.gms.internal.base.zap;

final class zaax
extends zap {
    final zaaz zaa;

    zaax(zaaz zaaz2, Looper looper) {
        this.zaa = zaaz2;
        super(looper);
    }

    public final void handleMessage(Message object) {
        int n = ((Message)object).what;
        if (n == 1) {
            zaaz.zai((zaaz)this.zaa);
            return;
        }
        if (n != 2) {
            n = ((Message)object).what;
            object = new StringBuilder(31);
            ((StringBuilder)object).append("Unknown message id: ");
            ((StringBuilder)object).append(n);
            Log.w((String)"GoogleApiClientImpl", (String)((StringBuilder)object).toString());
            return;
        }
        zaaz.zah((zaaz)this.zaa);
    }
}
