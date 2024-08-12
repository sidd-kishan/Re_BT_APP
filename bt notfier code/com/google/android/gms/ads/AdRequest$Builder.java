/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.os.Bundle
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.android.gms.ads.AdRequest
 *  com.google.android.gms.ads.mediation.MediationExtrasReceiver
 *  com.google.android.gms.ads.mediation.NetworkExtras
 *  com.google.android.gms.ads.mediation.customevent.CustomEvent
 *  com.google.android.gms.ads.query.AdInfo
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzbhi
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbhi;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.Date;
import java.util.List;

public static class AdRequest.Builder {
    protected final zzbhi zza;

    public AdRequest.Builder() {
        zzbhi zzbhi2;
        this.zza = zzbhi2 = new zzbhi();
        zzbhi2.zzw("B3EEABB8EE11C2BE770B684D95219ECB");
    }

    public AdRequest.Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> clazz, Bundle bundle) {
        this.zza.zzv(clazz, bundle);
        return this;
    }

    public AdRequest.Builder addKeyword(String string) {
        this.zza.zzs(string);
        return this;
    }

    @Deprecated
    public AdRequest.Builder addNetworkExtras(NetworkExtras networkExtras) {
        this.zza.zzt(networkExtras);
        return this;
    }

    public AdRequest.Builder addNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> clazz, Bundle bundle) {
        this.zza.zzu(clazz, bundle);
        if (!clazz.equals(AdMobAdapter.class)) return this;
        if (!bundle.getBoolean("_emulatorLiveAds")) return this;
        this.zza.zzx("B3EEABB8EE11C2BE770B684D95219ECB");
        return this;
    }

    public AdRequest build() {
        return new AdRequest(this);
    }

    @Deprecated
    public AdRequest.Builder setAdInfo(AdInfo adInfo) {
        this.zza.zzJ(adInfo);
        return this;
    }

    public AdRequest.Builder setAdString(String string) {
        this.zza.zzK(string);
        return this;
    }

    public AdRequest.Builder setContentUrl(String string) {
        Preconditions.checkNotNull((Object)string, (Object)"Content URL must be non-null.");
        Preconditions.checkNotEmpty((String)string, (Object)"Content URL must be non-empty.");
        boolean bl = string.length() <= 512;
        Preconditions.checkArgument((boolean)bl, (String)"Content URL must not exceed %d in length.  Provided length was %d.", (Object[])new Object[]{512, string.length()});
        this.zza.zzz(string);
        return this;
    }

    public AdRequest.Builder setHttpTimeoutMillis(int n) {
        this.zza.zzL(n);
        return this;
    }

    public AdRequest.Builder setLocation(Location location) {
        this.zza.zzC(location);
        return this;
    }

    public AdRequest.Builder setNeighboringContentUrls(List<String> list) {
        if (list == null) {
            zzcgt.zzi((String)"neighboring content URLs list should not be null");
            return this;
        }
        this.zza.zzA(list);
        return this;
    }

    public AdRequest.Builder setRequestAgent(String string) {
        this.zza.zzE(string);
        return this;
    }

    @Deprecated
    public final AdRequest.Builder zza(String string) {
        this.zza.zzw(string);
        return this;
    }

    @Deprecated
    public final AdRequest.Builder zzb(Date date) {
        this.zza.zzy(date);
        return this;
    }

    @Deprecated
    public final AdRequest.Builder zzc(int n) {
        this.zza.zzB(n);
        return this;
    }

    @Deprecated
    public final AdRequest.Builder zzd(boolean bl) {
        this.zza.zzF(bl);
        return this;
    }

    @Deprecated
    public final AdRequest.Builder zze(boolean bl) {
        this.zza.zzI(bl);
        return this;
    }
}
