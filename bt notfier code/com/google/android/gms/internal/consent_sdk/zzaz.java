/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzau
 *  com.google.android.gms.internal.consent_sdk.zzbb
 *  com.google.android.gms.internal.consent_sdk.zzcd
 *  com.google.android.gms.internal.consent_sdk.zzct
 *  com.google.android.gms.internal.consent_sdk.zzk
 *  com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadFailureListener
 *  com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadSuccessListener
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzau;
import com.google.android.gms.internal.consent_sdk.zzbb;
import com.google.android.gms.internal.consent_sdk.zzcd;
import com.google.android.gms.internal.consent_sdk.zzct;
import com.google.android.gms.internal.consent_sdk.zzk;
import com.google.android.ump.UserMessagingPlatform;
import java.util.concurrent.atomic.AtomicReference;

public final class zzaz {
    private final zzct<zzau> zza;
    private final AtomicReference<zzbb> zzb = new AtomicReference();

    zzaz(zzct<zzau> zzct2) {
        this.zza = zzct2;
    }

    public final void zza(zzbb zzbb2) {
        this.zzb.set(zzbb2);
    }

    public final void zza(UserMessagingPlatform.OnConsentFormLoadSuccessListener onConsentFormLoadSuccessListener, UserMessagingPlatform.OnConsentFormLoadFailureListener onConsentFormLoadFailureListener) {
        zzcd.zza();
        zzbb zzbb2 = this.zzb.get();
        if (zzbb2 == null) {
            onConsentFormLoadFailureListener.onConsentFormLoadFailure(new zzk(3, "No available form can be built.").zza());
            return;
        }
        ((zzau)this.zza.zza()).zza(zzbb2).zza().zza().zza(onConsentFormLoadSuccessListener, onConsentFormLoadFailureListener);
    }

    public final boolean zza() {
        if (this.zzb.get() == null) return false;
        return true;
    }
}
