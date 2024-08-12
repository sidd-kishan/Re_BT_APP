/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.formats.AdManagerAdViewOptions
 *  com.google.android.gms.ads.formats.PublisherAdViewOptions
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbdr
 *  com.google.android.gms.internal.ads.zzbfu
 *  com.google.android.gms.internal.ads.zzbfy
 *  com.google.android.gms.internal.ads.zzbis
 *  com.google.android.gms.internal.ads.zzblv
 *  com.google.android.gms.internal.ads.zzbrx
 *  com.google.android.gms.internal.ads.zzeli
 *  com.google.android.gms.internal.ads.zzfaf
 *  com.google.android.gms.internal.ads.zzfar
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbdr;
import com.google.android.gms.internal.ads.zzbfu;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzbis;
import com.google.android.gms.internal.ads.zzblv;
import com.google.android.gms.internal.ads.zzbrx;
import com.google.android.gms.internal.ads.zzeli;
import com.google.android.gms.internal.ads.zzfaf;
import com.google.android.gms.internal.ads.zzfar;
import java.util.ArrayList;

public final class zzfap {
    private zzbdg zza;
    private zzbdl zzb;
    private String zzc;
    private zzbis zzd;
    private boolean zze;
    private ArrayList<String> zzf;
    private ArrayList<String> zzg;
    private zzblv zzh;
    private zzbdr zzi;
    private AdManagerAdViewOptions zzj;
    private PublisherAdViewOptions zzk;
    private zzbfu zzl;
    private int zzm = 1;
    private zzbrx zzn;
    private final zzfaf zzo = new zzfaf();
    private boolean zzp = false;
    private zzeli zzq;
    private zzbfy zzr;

    static /* synthetic */ zzbfy zzN(zzfap zzfap2) {
        return zzfap2.zzr;
    }

    static /* synthetic */ zzbdg zza(zzfap zzfap2) {
        return zzfap2.zza;
    }

    static /* synthetic */ zzbdl zzb(zzfap zzfap2) {
        return zzfap2.zzb;
    }

    static /* synthetic */ String zzc(zzfap zzfap2) {
        return zzfap2.zzc;
    }

    static /* synthetic */ zzbis zzd(zzfap zzfap2) {
        return zzfap2.zzd;
    }

    static /* synthetic */ boolean zze(zzfap zzfap2) {
        return zzfap2.zze;
    }

    static /* synthetic */ ArrayList zzf(zzfap zzfap2) {
        return zzfap2.zzf;
    }

    static /* synthetic */ ArrayList zzg(zzfap zzfap2) {
        return zzfap2.zzg;
    }

    static /* synthetic */ zzblv zzh(zzfap zzfap2) {
        return zzfap2.zzh;
    }

    static /* synthetic */ zzbdr zzi(zzfap zzfap2) {
        return zzfap2.zzi;
    }

    static /* synthetic */ AdManagerAdViewOptions zzj(zzfap zzfap2) {
        return zzfap2.zzj;
    }

    static /* synthetic */ PublisherAdViewOptions zzk(zzfap zzfap2) {
        return zzfap2.zzk;
    }

    static /* synthetic */ zzbfu zzl(zzfap zzfap2) {
        return zzfap2.zzl;
    }

    static /* synthetic */ int zzm(zzfap zzfap2) {
        return zzfap2.zzm;
    }

    static /* synthetic */ zzbrx zzn(zzfap zzfap2) {
        return zzfap2.zzn;
    }

    static /* synthetic */ zzfaf zzo(zzfap zzfap2) {
        return zzfap2.zzo;
    }

    static /* synthetic */ boolean zzp(zzfap zzfap2) {
        return zzfap2.zzp;
    }

    static /* synthetic */ zzeli zzq(zzfap zzfap2) {
        return zzfap2.zzq;
    }

    public final zzfap zzA(boolean bl) {
        this.zze = bl;
        return this;
    }

    public final zzfap zzB(int n) {
        this.zzm = n;
        return this;
    }

    public final zzfap zzC(ArrayList<String> arrayList) {
        this.zzf = arrayList;
        return this;
    }

    public final zzfap zzD(ArrayList<String> arrayList) {
        this.zzg = arrayList;
        return this;
    }

    public final zzfap zzE(zzblv zzblv2) {
        this.zzh = zzblv2;
        return this;
    }

    public final zzfap zzF(zzbdr zzbdr2) {
        this.zzi = zzbdr2;
        return this;
    }

    public final zzfap zzG(zzbrx zzbrx2) {
        this.zzn = zzbrx2;
        this.zzd = new zzbis(false, true, false);
        return this;
    }

    public final zzfap zzH(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzk = publisherAdViewOptions;
        if (publisherAdViewOptions == null) return this;
        this.zze = publisherAdViewOptions.zza();
        this.zzl = publisherAdViewOptions.zzb();
        return this;
    }

    public final zzfap zzI(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzj = adManagerAdViewOptions;
        if (adManagerAdViewOptions == null) return this;
        this.zze = adManagerAdViewOptions.getManualImpressionsEnabled();
        return this;
    }

    public final zzfap zzJ(zzeli zzeli2) {
        this.zzq = zzeli2;
        return this;
    }

    public final zzfap zzK(zzfar zzfar2) {
        this.zzo.zzb(zzfar2.zzo.zza);
        this.zza = zzfar2.zzd;
        this.zzb = zzfar2.zze;
        this.zzr = zzfar2.zzq;
        this.zzc = zzfar2.zzf;
        this.zzd = zzfar2.zza;
        this.zzf = zzfar2.zzg;
        this.zzg = zzfar2.zzh;
        this.zzh = zzfar2.zzi;
        this.zzi = zzfar2.zzj;
        this.zzI(zzfar2.zzl);
        this.zzH(zzfar2.zzm);
        this.zzp = zzfar2.zzp;
        this.zzq = zzfar2.zzc;
        return this;
    }

    public final zzfar zzL() {
        Preconditions.checkNotNull((Object)this.zzc, (Object)"ad unit must not be null");
        Preconditions.checkNotNull((Object)this.zzb, (Object)"ad size must not be null");
        Preconditions.checkNotNull((Object)this.zza, (Object)"ad request must not be null");
        return new zzfar(this, null);
    }

    public final boolean zzM() {
        return this.zzp;
    }

    public final zzfap zzO(zzbfy zzbfy2) {
        this.zzr = zzbfy2;
        return this;
    }

    public final zzfap zzr(zzbdg zzbdg2) {
        this.zza = zzbdg2;
        return this;
    }

    public final zzbdg zzs() {
        return this.zza;
    }

    public final zzfap zzt(zzbdl zzbdl2) {
        this.zzb = zzbdl2;
        return this;
    }

    public final zzfap zzu(boolean bl) {
        this.zzp = bl;
        return this;
    }

    public final zzbdl zzv() {
        return this.zzb;
    }

    public final zzfap zzw(String string) {
        this.zzc = string;
        return this;
    }

    public final String zzx() {
        return this.zzc;
    }

    public final zzfap zzy(zzbis zzbis2) {
        this.zzd = zzbis2;
        return this;
    }

    public final zzfaf zzz() {
        return this.zzo;
    }
}
