/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.internal.zaco
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zaco;

final class zacl
implements Runnable {
    final zaco zaa;

    zacl(zaco zaco2) {
        this.zaa = zaco2;
    }

    @Override
    public final void run() {
        zaco.zae((zaco)this.zaa).zaa(new ConnectionResult(4));
    }
}
