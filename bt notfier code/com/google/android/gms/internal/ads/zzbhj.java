/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.os.Bundle
 *  com.google.android.gms.ads.RequestConfiguration
 *  com.google.android.gms.ads.mediation.MediationExtrasReceiver
 *  com.google.android.gms.ads.mediation.NetworkExtras
 *  com.google.android.gms.ads.mediation.customevent.CustomEvent
 *  com.google.android.gms.ads.query.AdInfo
 *  com.google.android.gms.ads.search.SearchAdRequest
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbhi
 *  com.google.android.gms.internal.ads.zzbhs
 *  com.google.android.gms.internal.ads.zzcgm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbhi;
import com.google.android.gms.internal.ads.zzbhs;
import com.google.android.gms.internal.ads.zzcgm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zzbhj {
    private final Date zza;
    private final String zzb;
    private final List<String> zzc;
    private final int zzd;
    private final Set<String> zze;
    private final Location zzf;
    private final Bundle zzg;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzh;
    private final String zzi;
    private final String zzj;
    @NotOnlyInitialized
    private final SearchAdRequest zzk;
    private final int zzl;
    private final Set<String> zzm;
    private final Bundle zzn;
    private final Set<String> zzo;
    private final boolean zzp;
    private final AdInfo zzq;
    private final String zzr;
    private final int zzs;

    public zzbhj(zzbhi zzbhi2, SearchAdRequest searchAdRequest) {
        this.zza = zzbhi.zzg((zzbhi)zzbhi2);
        this.zzb = zzbhi.zzh((zzbhi)zzbhi2);
        this.zzc = zzbhi.zzi((zzbhi)zzbhi2);
        this.zzd = zzbhi.zzj((zzbhi)zzbhi2);
        this.zze = Collections.unmodifiableSet(zzbhi.zza((zzbhi)zzbhi2));
        this.zzf = zzbhi.zzk((zzbhi)zzbhi2);
        this.zzg = zzbhi.zzb((zzbhi)zzbhi2);
        this.zzh = Collections.unmodifiableMap(zzbhi.zzc((zzbhi)zzbhi2));
        this.zzi = zzbhi.zzl((zzbhi)zzbhi2);
        this.zzj = zzbhi.zzm((zzbhi)zzbhi2);
        this.zzk = searchAdRequest;
        this.zzl = zzbhi.zzn((zzbhi)zzbhi2);
        this.zzm = Collections.unmodifiableSet(zzbhi.zzd((zzbhi)zzbhi2));
        this.zzn = zzbhi.zze((zzbhi)zzbhi2);
        this.zzo = Collections.unmodifiableSet(zzbhi.zzf((zzbhi)zzbhi2));
        this.zzp = zzbhi.zzo((zzbhi)zzbhi2);
        this.zzq = zzbhi.zzp((zzbhi)zzbhi2);
        this.zzr = zzbhi.zzq((zzbhi)zzbhi2);
        this.zzs = zzbhi.zzr((zzbhi)zzbhi2);
    }

    @Deprecated
    public final Date zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final List<String> zzc() {
        return new ArrayList<String>(this.zzc);
    }

    @Deprecated
    public final int zzd() {
        return this.zzd;
    }

    public final Set<String> zze() {
        return this.zze;
    }

    public final Location zzf() {
        return this.zzf;
    }

    @Deprecated
    public final <T extends NetworkExtras> T zzg(Class<T> clazz) {
        return (T)this.zzh.get(clazz);
    }

    public final Bundle zzh(Class<? extends MediationExtrasReceiver> clazz) {
        return this.zzg.getBundle(clazz.getName());
    }

    public final Bundle zzi(Class<? extends CustomEvent> clazz) {
        Bundle bundle = this.zzg.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle == null) return null;
        return bundle.getBundle(clazz.getName());
    }

    public final String zzj() {
        return this.zzi;
    }

    public final String zzk() {
        return this.zzj;
    }

    public final SearchAdRequest zzl() {
        return this.zzk;
    }

    public final boolean zzm(Context object) {
        RequestConfiguration requestConfiguration = zzbhs.zze().zzr();
        zzber.zza();
        object = zzcgm.zzt((Context)object);
        if (this.zzm.contains(object)) return true;
        if (!requestConfiguration.getTestDeviceIds().contains(object)) return false;
        return true;
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzn() {
        return this.zzh;
    }

    public final Bundle zzo() {
        return this.zzg;
    }

    public final int zzp() {
        return this.zzl;
    }

    public final Bundle zzq() {
        return this.zzn;
    }

    public final Set<String> zzr() {
        return this.zzo;
    }

    @Deprecated
    public final boolean zzs() {
        return this.zzp;
    }

    public final AdInfo zzt() {
        return this.zzq;
    }

    public final String zzu() {
        return this.zzr;
    }

    public final int zzv() {
        return this.zzs;
    }
}
