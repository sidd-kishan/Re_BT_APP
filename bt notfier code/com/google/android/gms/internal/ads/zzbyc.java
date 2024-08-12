/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.ads.mediation.MediationInterstitialAdapter
 *  com.google.android.gms.internal.ads.zzbye
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.internal.ads.zzbye;
import com.google.android.gms.internal.ads.zzcgt;

final class zzbyc
implements zzo {
    final zzbye zza;

    zzbyc(zzbye zzbye2) {
        this.zza = zzbye2;
    }

    public final void zzbp() {
        zzcgt.zzd((String)"Opening AdMobCustomTabsAdapter overlay.");
        zzbye.zzb((zzbye)this.zza).onAdOpened((MediationInterstitialAdapter)this.zza);
    }

    public final void zzbq() {
        zzcgt.zzd((String)"AdMobCustomTabsAdapter overlay is paused.");
    }

    public final void zzbr() {
        zzcgt.zzd((String)"AdMobCustomTabsAdapter overlay is resumed.");
    }

    public final void zzbs(int n) {
        zzcgt.zzd((String)"AdMobCustomTabsAdapter overlay is closed.");
        zzbye.zzb((zzbye)this.zza).onAdClosed((MediationInterstitialAdapter)this.zza);
    }

    public final void zzd() {
        zzcgt.zzd((String)"Delay close AdMobCustomTabsAdapter overlay.");
    }

    public final void zze() {
    }
}
