/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.os.Bundle
 *  android.text.TextUtils
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.android.gms.ads.mediation.MediationExtrasReceiver
 *  com.google.android.gms.ads.mediation.NetworkExtras
 *  com.google.android.gms.ads.mediation.admob.AdMobExtras
 *  com.google.android.gms.ads.mediation.customevent.CustomEvent
 *  com.google.android.gms.ads.query.AdInfo
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class zzbhi {
    private final HashSet<String> zza = new HashSet();
    private final Bundle zzb = new Bundle();
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzc = new HashMap();
    private final HashSet<String> zzd = new HashSet();
    private final Bundle zze = new Bundle();
    private final HashSet<String> zzf = new HashSet();
    private Date zzg;
    private String zzh;
    private final List<String> zzi = new ArrayList<String>();
    private int zzj = -1;
    private Location zzk;
    private String zzl;
    private String zzm;
    private int zzn = -1;
    private boolean zzo;
    private AdInfo zzp;
    private String zzq;
    private int zzr = 60000;

    static /* synthetic */ HashSet zza(zzbhi zzbhi2) {
        return zzbhi2.zza;
    }

    static /* synthetic */ Bundle zzb(zzbhi zzbhi2) {
        return zzbhi2.zzb;
    }

    static /* synthetic */ HashMap zzc(zzbhi zzbhi2) {
        return zzbhi2.zzc;
    }

    static /* synthetic */ HashSet zzd(zzbhi zzbhi2) {
        return zzbhi2.zzd;
    }

    static /* synthetic */ Bundle zze(zzbhi zzbhi2) {
        return zzbhi2.zze;
    }

    static /* synthetic */ HashSet zzf(zzbhi zzbhi2) {
        return zzbhi2.zzf;
    }

    static /* synthetic */ Date zzg(zzbhi zzbhi2) {
        return zzbhi2.zzg;
    }

    static /* synthetic */ String zzh(zzbhi zzbhi2) {
        return zzbhi2.zzh;
    }

    static /* synthetic */ List zzi(zzbhi zzbhi2) {
        return zzbhi2.zzi;
    }

    static /* synthetic */ int zzj(zzbhi zzbhi2) {
        return zzbhi2.zzj;
    }

    static /* synthetic */ Location zzk(zzbhi zzbhi2) {
        return zzbhi2.zzk;
    }

    static /* synthetic */ String zzl(zzbhi zzbhi2) {
        return zzbhi2.zzl;
    }

    static /* synthetic */ String zzm(zzbhi zzbhi2) {
        return zzbhi2.zzm;
    }

    static /* synthetic */ int zzn(zzbhi zzbhi2) {
        return zzbhi2.zzn;
    }

    static /* synthetic */ boolean zzo(zzbhi zzbhi2) {
        return zzbhi2.zzo;
    }

    static /* synthetic */ AdInfo zzp(zzbhi zzbhi2) {
        return zzbhi2.zzp;
    }

    static /* synthetic */ String zzq(zzbhi zzbhi2) {
        return zzbhi2.zzq;
    }

    static /* synthetic */ int zzr(zzbhi zzbhi2) {
        return zzbhi2.zzr;
    }

    public final void zzA(List<String> object) {
        this.zzi.clear();
        object = object.iterator();
        while (object.hasNext()) {
            String string = (String)object.next();
            if (TextUtils.isEmpty((CharSequence)string)) {
                zzcgt.zzi((String)"neighboring content URL should not be null or empty");
                continue;
            }
            this.zzi.add(string);
        }
    }

    @Deprecated
    public final void zzB(int n) {
        this.zzj = n;
    }

    public final void zzC(Location location) {
        this.zzk = location;
    }

    public final void zzD(String string) {
        this.zzl = string;
    }

    public final void zzE(String string) {
        this.zzm = string;
    }

    @Deprecated
    public final void zzF(boolean bl) {
        this.zzn = bl ? 1 : 0;
    }

    public final void zzG(String string, String string2) {
        this.zze.putString(string, string2);
    }

    public final void zzH(String string) {
        this.zzf.add(string);
    }

    @Deprecated
    public final void zzI(boolean bl) {
        this.zzo = bl;
    }

    public final void zzJ(AdInfo adInfo) {
        this.zzp = adInfo;
    }

    public final void zzK(String string) {
        this.zzq = string;
    }

    public final void zzL(int n) {
        this.zzr = n;
    }

    public final void zzs(String string) {
        this.zza.add(string);
    }

    @Deprecated
    public final void zzt(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            this.zzu(AdMobAdapter.class, ((AdMobExtras)networkExtras).getExtras());
            return;
        }
        this.zzc.put(networkExtras.getClass(), networkExtras);
    }

    public final void zzu(Class<? extends MediationExtrasReceiver> clazz, Bundle bundle) {
        this.zzb.putBundle(clazz.getName(), bundle);
    }

    public final void zzv(Class<? extends CustomEvent> clazz, Bundle bundle) {
        if (this.zzb.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.zzb.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        Bundle bundle2 = this.zzb.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        Preconditions.checkNotNull((Object)bundle2);
        bundle2.putBundle(clazz.getName(), bundle);
    }

    public final void zzw(String string) {
        this.zzd.add(string);
    }

    public final void zzx(String string) {
        this.zzd.remove("B3EEABB8EE11C2BE770B684D95219ECB");
    }

    @Deprecated
    public final void zzy(Date date) {
        this.zzg = date;
    }

    public final void zzz(String string) {
        this.zzh = string;
    }
}
