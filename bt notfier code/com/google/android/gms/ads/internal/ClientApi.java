/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.view.View
 *  android.widget.FrameLayout
 *  com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
 *  com.google.android.gms.ads.internal.overlay.zzaa
 *  com.google.android.gms.ads.internal.overlay.zzab
 *  com.google.android.gms.ads.internal.overlay.zzr
 *  com.google.android.gms.ads.internal.overlay.zzs
 *  com.google.android.gms.ads.internal.overlay.zzu
 *  com.google.android.gms.ads.internal.overlay.zzy
 *  com.google.android.gms.ads.internal.zzs
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbfj
 *  com.google.android.gms.internal.ads.zzbfn
 *  com.google.android.gms.internal.ads.zzbfw
 *  com.google.android.gms.internal.ads.zzbge
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbml
 *  com.google.android.gms.internal.ads.zzbmr
 *  com.google.android.gms.internal.ads.zzbqm
 *  com.google.android.gms.internal.ads.zzbqp
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzbze
 *  com.google.android.gms.internal.ads.zzbzq
 *  com.google.android.gms.internal.ads.zzccc
 *  com.google.android.gms.internal.ads.zzccs
 *  com.google.android.gms.internal.ads.zzcfn
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzdnf
 *  com.google.android.gms.internal.ads.zzdnh
 *  com.google.android.gms.internal.ads.zzekl
 */
package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzab;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbfw;
import com.google.android.gms.internal.ads.zzbge;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbml;
import com.google.android.gms.internal.ads.zzbmr;
import com.google.android.gms.internal.ads.zzbqm;
import com.google.android.gms.internal.ads.zzbqp;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzbze;
import com.google.android.gms.internal.ads.zzbzq;
import com.google.android.gms.internal.ads.zzccc;
import com.google.android.gms.internal.ads.zzccs;
import com.google.android.gms.internal.ads.zzcfn;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzdnf;
import com.google.android.gms.internal.ads.zzdnh;
import com.google.android.gms.internal.ads.zzekl;
import java.util.HashMap;

public class ClientApi
extends zzbfw {
    public final zzbfn zzb(IObjectWrapper iObjectWrapper, zzbdl zzbdl2, String string, zzbvg zzbvg2, int n) {
        iObjectWrapper = (Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
        zzbvg2 = zzcoj.zza((Context)iObjectWrapper, (zzbvg)zzbvg2, (int)n).zzl();
        zzbvg2.zzd((Context)iObjectWrapper);
        zzbvg2.zzb(zzbdl2);
        zzbvg2.zzc(string);
        return zzbvg2.zza().zza();
    }

    public final zzbfn zzc(IObjectWrapper iObjectWrapper, zzbdl zzbdl2, String string, zzbvg zzbvg2, int n) {
        iObjectWrapper = (Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
        zzbvg2 = zzcoj.zza((Context)iObjectWrapper, (zzbvg)zzbvg2, (int)n).zzq();
        zzbvg2.zzd((Context)iObjectWrapper);
        zzbvg2.zzb(zzbdl2);
        zzbvg2.zzc(string);
        return zzbvg2.zza().zza();
    }

    public final zzbfj zzd(IObjectWrapper iObjectWrapper, String string, zzbvg zzbvg2, int n) {
        iObjectWrapper = (Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
        return new zzekl(zzcoj.zza((Context)iObjectWrapper, (zzbvg)zzbvg2, (int)n), (Context)iObjectWrapper, string);
    }

    public final zzbml zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzdnh((FrameLayout)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper), (FrameLayout)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper2), 213806000);
    }

    public final zzccc zzf(IObjectWrapper iObjectWrapper, zzbvg zzbvg2, int n) {
        iObjectWrapper = (Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
        zzbvg2 = zzcoj.zza((Context)iObjectWrapper, (zzbvg)zzbvg2, (int)n).zzt();
        zzbvg2.zzc((Context)iObjectWrapper);
        return zzbvg2.zza().zza();
    }

    public final zzbzq zzg(IObjectWrapper object) {
        int n;
        AdOverlayInfoParcel adOverlayInfoParcel = AdOverlayInfoParcel.zza((Intent)(object = (Activity)ObjectWrapper.unwrap((IObjectWrapper)object)).getIntent());
        object = adOverlayInfoParcel == null ? new zzs((Activity)object) : ((n = adOverlayInfoParcel.zzk) != 1 ? (n != 2 ? (n != 3 ? (n != 4 ? (n != 5 ? new zzs((Activity)object) : new zzy((Activity)object)) : new zzu((Activity)object, adOverlayInfoParcel)) : new zzab((Activity)object)) : new zzaa((Activity)object)) : new zzr((Activity)object));
        return object;
    }

    public final zzbge zzh(IObjectWrapper iObjectWrapper, int n) {
        return zzcoj.zzb((Context)((Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper)), (int)n).zzj();
    }

    public final zzbfn zzi(IObjectWrapper iObjectWrapper, zzbdl zzbdl2, String string, int n) {
        return new com.google.android.gms.ads.internal.zzs((Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper), zzbdl2, string, new zzcgz(213806000, n, true, false));
    }

    public final zzbmr zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzdnf((View)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper), (HashMap)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper2), (HashMap)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper3));
    }

    public final zzccs zzk(IObjectWrapper iObjectWrapper, String string, zzbvg zzbvg2, int n) {
        iObjectWrapper = (Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
        zzbvg2 = zzcoj.zza((Context)iObjectWrapper, (zzbvg)zzbvg2, (int)n).zzt();
        zzbvg2.zzc((Context)iObjectWrapper);
        zzbvg2.zzb(string);
        return zzbvg2.zza().zzb();
    }

    public final zzbfn zzl(IObjectWrapper iObjectWrapper, zzbdl zzbdl2, String string, zzbvg zzbvg2, int n) {
        iObjectWrapper = (Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
        zzbdl2 = zzcoj.zza((Context)iObjectWrapper, (zzbvg)zzbvg2, (int)n).zzo();
        zzbdl2.zzb(string);
        zzbdl2.zzc((Context)iObjectWrapper);
        zzbdl2 = zzbdl2.zza();
        iObjectWrapper = zzbjl.zzdC;
        if (n < (Integer)zzbet.zzc().zzc((zzbjd)iObjectWrapper)) return zzbdl2.zza();
        return zzbdl2.zzb();
    }

    public final zzcfn zzm(IObjectWrapper iObjectWrapper, zzbvg zzbvg2, int n) {
        return zzcoj.zza((Context)((Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper)), (zzbvg)zzbvg2, (int)n).zzv();
    }

    public final zzbze zzn(IObjectWrapper iObjectWrapper, zzbvg zzbvg2, int n) {
        return zzcoj.zza((Context)((Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper)), (zzbvg)zzbvg2, (int)n).zzx();
    }

    public final zzbqp zzo(IObjectWrapper iObjectWrapper, zzbvg zzbvg2, int n, zzbqm zzbqm2) {
        iObjectWrapper = (Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
        zzbvg2 = zzcoj.zza((Context)iObjectWrapper, (zzbvg)zzbvg2, (int)n).zzC();
        zzbvg2.zzc((Context)iObjectWrapper);
        zzbvg2.zzb(zzbqm2);
        return zzbvg2.zza().zzc();
    }
}
