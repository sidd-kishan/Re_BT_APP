/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.SparseIntArray
 *  com.google.android.gms.common.GoogleApiAvailability
 *  com.google.android.gms.common.GoogleApiAvailabilityLight
 *  com.google.android.gms.common.api.Api$Client
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;

public final class zal {
    private final SparseIntArray zaa = new SparseIntArray();
    private GoogleApiAvailabilityLight zab;

    public zal() {
        this((GoogleApiAvailabilityLight)GoogleApiAvailability.getInstance());
    }

    public zal(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        Preconditions.checkNotNull((Object)googleApiAvailabilityLight);
        this.zab = googleApiAvailabilityLight;
    }

    public final int zaa(Context context, Api.Client client) {
        int n;
        int n2;
        block3: {
            Preconditions.checkNotNull((Object)context);
            Preconditions.checkNotNull((Object)client);
            boolean bl = client.requiresGooglePlayServices();
            int n3 = 0;
            if (!bl) {
                return 0;
            }
            n2 = client.getMinApkVersion();
            n = this.zab(context, n2);
            if (n != -1) return n;
            for (n = 0; n < this.zaa.size(); ++n) {
                int n4 = this.zaa.keyAt(n);
                if (n4 <= n2 || this.zaa.get(n4) != 0) continue;
                n = n3;
                break block3;
            }
            n = -1;
        }
        if (n == -1) {
            n = this.zab.isGooglePlayServicesAvailable(context, n2);
        }
        this.zaa.put(n2, n);
        return n;
    }

    public final int zab(Context context, int n) {
        return this.zaa.get(n, -1);
    }

    public final void zac() {
        this.zaa.clear();
    }
}
