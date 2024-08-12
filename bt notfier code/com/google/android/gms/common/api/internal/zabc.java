/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  com.google.android.gms.common.api.internal.zabb
 *  com.google.android.gms.common.api.internal.zabd
 *  com.google.android.gms.internal.base.zap
 */
package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.internal.zabb;
import com.google.android.gms.common.api.internal.zabd;
import com.google.android.gms.internal.base.zap;

final class zabc
extends zap {
    final zabd zaa;

    zabc(zabd zabd2, Looper looper) {
        this.zaa = zabd2;
        super(looper);
    }

    public final void handleMessage(Message object) {
        int n = ((Message)object).what;
        if (n != 1) {
            if (n == 2) throw (RuntimeException)((Message)object).obj;
            n = ((Message)object).what;
            object = new StringBuilder(31);
            ((StringBuilder)object).append("Unknown message id: ");
            ((StringBuilder)object).append(n);
            Log.w((String)"GACStateManager", (String)((StringBuilder)object).toString());
            return;
        }
        ((zabb)((Message)object).obj).zab(this.zaa);
    }
}
