/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  com.google.android.gms.common.api.internal.zabq
 *  com.google.android.gms.common.api.internal.zao
 *  com.google.android.gms.common.api.internal.zap
 */
package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zao;
import com.google.android.gms.common.api.internal.zap;

final class zan
extends zabq {
    final Dialog zaa;
    final zao zab;

    zan(zao zao2, Dialog dialog) {
        this.zab = zao2;
        this.zaa = dialog;
    }

    public final void zaa() {
        zap.zag((zap)this.zab.zaa);
        if (!this.zaa.isShowing()) return;
        this.zaa.dismiss();
    }
}
