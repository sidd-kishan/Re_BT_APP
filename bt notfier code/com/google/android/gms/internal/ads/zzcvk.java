/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcob
 *  com.google.android.gms.internal.ads.zzcvh
 *  com.google.android.gms.internal.ads.zzcvj
 *  com.google.android.gms.internal.ads.zzcxe
 *  com.google.android.gms.internal.ads.zzcxf
 *  com.google.android.gms.internal.ads.zzdiq
 *  com.google.android.gms.internal.ads.zzdmx
 *  com.google.android.gms.internal.ads.zzekj
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfaa
 *  com.google.android.gms.internal.ads.zzfav
 *  com.google.android.gms.internal.ads.zzfaw
 *  com.google.android.gms.internal.ads.zzgku
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcob;
import com.google.android.gms.internal.ads.zzcvh;
import com.google.android.gms.internal.ads.zzcvj;
import com.google.android.gms.internal.ads.zzcxe;
import com.google.android.gms.internal.ads.zzcxf;
import com.google.android.gms.internal.ads.zzdiq;
import com.google.android.gms.internal.ads.zzdmx;
import com.google.android.gms.internal.ads.zzekj;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfaa;
import com.google.android.gms.internal.ads.zzfav;
import com.google.android.gms.internal.ads.zzfaw;
import com.google.android.gms.internal.ads.zzgku;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

final class zzcvk
extends zzcvh {
    private final Context zzc;
    private final View zzd;
    private final zzcml zze;
    private final zzfaa zzf;
    private final zzcxe zzg;
    private final zzdmx zzh;
    private final zzdiq zzi;
    private final zzgku<zzekj> zzj;
    private final Executor zzk;
    private zzbdl zzl;

    zzcvk(zzcxf zzcxf2, Context context, zzfaa zzfaa2, View view, zzcml zzcml2, zzcxe zzcxe2, zzdmx zzdmx2, zzdiq zzdiq2, zzgku<zzekj> zzgku2, Executor executor) {
        super(zzcxf2);
        this.zzc = context;
        this.zzd = view;
        this.zze = zzcml2;
        this.zzf = zzfaa2;
        this.zzg = zzcxe2;
        this.zzh = zzdmx2;
        this.zzi = zzdiq2;
        this.zzj = zzgku2;
        this.zzk = executor;
    }

    public final void zzS() {
        this.zzk.execute((Runnable)new zzcvj(this));
        super.zzS();
    }

    public final View zza() {
        return this.zzd;
    }

    public final void zzb(ViewGroup viewGroup, zzbdl zzbdl2) {
        if (viewGroup == null) return;
        zzcml zzcml2 = this.zze;
        if (zzcml2 == null) return;
        zzcml2.zzaf(zzcob.zza((zzbdl)zzbdl2));
        viewGroup.setMinimumHeight(zzbdl2.zzc);
        viewGroup.setMinimumWidth(zzbdl2.zzf);
        this.zzl = zzbdl2;
    }

    public final zzbhc zzc() {
        try {
            zzbhc zzbhc2 = this.zzg.zza();
            return zzbhc2;
        }
        catch (zzfaw zzfaw2) {
            return null;
        }
    }

    public final zzfaa zze() {
        Object object = this.zzl;
        if (object != null) {
            return zzfav.zzc((zzbdl)object);
        }
        object = this.zzb;
        if (!((zzezz)object).zzY) return zzfav.zza((List)this.zzb.zzr, (zzfaa)this.zzf);
        Iterator iterator = ((zzezz)object).zza.iterator();
        do {
            if (!iterator.hasNext()) return new zzfaa(this.zzd.getWidth(), this.zzd.getHeight(), false);
        } while ((object = (String)iterator.next()) == null || !((String)object).contains("FirstParty"));
        return zzfav.zza((List)this.zzb.zzr, (zzfaa)this.zzf);
    }

    public final zzfaa zzf() {
        return this.zzf;
    }

    public final int zzg() {
        zzbjd zzbjd2 = zzbjl.zzfB;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return this.zza.zzb.zzb.zzc;
        if (!this.zzb.zzad) return this.zza.zzb.zzb.zzc;
        zzbjd2 = zzbjl.zzfC;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) != false) return this.zza.zzb.zzb.zzc;
        return 0;
    }

    public final void zzh() {
        this.zzi.zza();
    }
}
