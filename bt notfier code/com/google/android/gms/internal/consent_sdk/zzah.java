/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzaf
 *  com.google.android.gms.internal.consent_sdk.zzag
 *  com.google.android.gms.internal.consent_sdk.zzak
 *  com.google.android.gms.internal.consent_sdk.zzar
 *  com.google.android.gms.internal.consent_sdk.zzau
 *  com.google.android.gms.internal.consent_sdk.zzbb
 *  com.google.android.gms.internal.consent_sdk.zzcu
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzaf;
import com.google.android.gms.internal.consent_sdk.zzag;
import com.google.android.gms.internal.consent_sdk.zzak;
import com.google.android.gms.internal.consent_sdk.zzar;
import com.google.android.gms.internal.consent_sdk.zzau;
import com.google.android.gms.internal.consent_sdk.zzbb;
import com.google.android.gms.internal.consent_sdk.zzcu;

final class zzah
implements zzau {
    private zzbb zza;
    private final zzag zzb;

    private zzah(zzag zzag2) {
        this.zzb = zzag2;
    }

    /* synthetic */ zzah(zzag zzag2, zzaf zzaf2) {
        this(zzag2);
    }

    public final zzar zza() {
        zzcu.zza((Object)this.zza, zzbb.class);
        return new zzak(this.zzb, this.zza, null);
    }

    public final /* synthetic */ zzau zza(zzbb zzbb2) {
        this.zza = (zzbb)zzcu.zza((Object)zzbb2);
        return this;
    }
}
