/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

final class zam {
    private final int zaa;
    private final ConnectionResult zab;

    zam(ConnectionResult connectionResult, int n) {
        Preconditions.checkNotNull((Object)connectionResult);
        this.zab = connectionResult;
        this.zaa = n;
    }

    final int zaa() {
        return this.zaa;
    }

    final ConnectionResult zab() {
        return this.zab;
    }
}
