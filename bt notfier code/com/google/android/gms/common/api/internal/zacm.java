/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.internal.zaco
 *  com.google.android.gms.signin.internal.zak
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zaco;
import com.google.android.gms.signin.internal.zak;

final class zacm
implements Runnable {
    final zak zaa;
    final zaco zab;

    zacm(zaco zaco2, zak zak2) {
        this.zab = zaco2;
        this.zaa = zak2;
    }

    @Override
    public final void run() {
        zaco.zaf((zaco)this.zab, (zak)this.zaa);
    }
}
