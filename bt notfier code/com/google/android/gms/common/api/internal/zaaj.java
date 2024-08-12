/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.internal.zaal
 *  com.google.android.gms.common.api.internal.zaar
 *  com.google.android.gms.common.api.internal.zaba
 *  com.google.android.gms.common.api.internal.zabb
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zaal;
import com.google.android.gms.common.api.internal.zaar;
import com.google.android.gms.common.api.internal.zaba;
import com.google.android.gms.common.api.internal.zabb;

final class zaaj
extends zabb {
    final ConnectionResult zaa;
    final zaal zab;

    zaaj(zaal zaal2, zaba zaba2, ConnectionResult connectionResult) {
        this.zab = zaal2;
        this.zaa = connectionResult;
        super(zaba2);
    }

    public final void zaa() {
        zaar.zam((zaar)this.zab.zaa, (ConnectionResult)this.zaa);
    }
}
