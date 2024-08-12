/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.view.View
 *  androidx.collection.SimpleArrayMap
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbhu
 *  com.google.android.gms.internal.ads.zzblr
 *  com.google.android.gms.internal.ads.zzblz
 *  com.google.android.gms.internal.ads.zzbmg
 *  com.google.android.gms.internal.ads.zzbmh
 *  com.google.android.gms.internal.ads.zzbvr
 *  com.google.android.gms.internal.ads.zzbvs
 *  com.google.android.gms.internal.ads.zzbvv
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzdml
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhu;
import com.google.android.gms.internal.ads.zzblr;
import com.google.android.gms.internal.ads.zzblz;
import com.google.android.gms.internal.ads.zzbmg;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzbvr;
import com.google.android.gms.internal.ads.zzbvs;
import com.google.android.gms.internal.ads.zzbvv;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzdml;
import java.util.Collections;
import java.util.List;

public final class zzdmm {
    private int zza;
    private zzbhc zzb;
    private zzblz zzc;
    private View zzd;
    private List<?> zze;
    private List<zzbhu> zzf;
    private zzbhu zzg;
    private Bundle zzh;
    private zzcml zzi;
    private zzcml zzj;
    private zzcml zzk;
    private IObjectWrapper zzl;
    private View zzm;
    private View zzn;
    private IObjectWrapper zzo;
    private double zzp;
    private zzbmh zzq;
    private zzbmh zzr;
    private String zzs;
    private final SimpleArrayMap<String, zzblr> zzt = new SimpleArrayMap();
    private final SimpleArrayMap<String, String> zzu = new SimpleArrayMap();
    private float zzv;
    private String zzw;

    public zzdmm() {
        this.zzf = Collections.emptyList();
    }

    public static zzdmm zzaa(zzbvv object) {
        try {
            object = zzdmm.zzaf((zzbhc)zzdmm.zzah(object.zzn(), object), object.zzo(), (View)zzdmm.zzag(object.zzp()), object.zze(), object.zzf(), object.zzg(), object.zzs(), object.zzi(), (View)zzdmm.zzag(object.zzq()), object.zzr(), object.zzl(), object.zzm(), object.zzk(), object.zzh(), object.zzj(), object.zzz());
            return object;
        }
        catch (RemoteException remoteException) {
            com.google.android.gms.ads.internal.util.zze.zzj((String)"Failed to get native ad assets from unified ad mapper", (Throwable)remoteException);
            return null;
        }
    }

    public static zzdmm zzab(zzbvs object) {
        try {
            zzdml zzdml2 = zzdmm.zzah(object.zzs(), null);
            zzblz zzblz2 = object.zzt();
            View view = (View)zzdmm.zzag(object.zzr());
            String string = object.zze();
            List list = object.zzf();
            String string2 = object.zzg();
            Bundle bundle = object.zzp();
            String string3 = object.zzi();
            View view2 = (View)zzdmm.zzag(object.zzu());
            IObjectWrapper iObjectWrapper = object.zzv();
            String string4 = object.zzj();
            zzbmh zzbmh2 = object.zzh();
            object = new zzdmm();
            ((zzdmm)object).zza = 1;
            ((zzdmm)object).zzb = zzdml2;
            ((zzdmm)object).zzc = zzblz2;
            ((zzdmm)object).zzd = view;
            ((zzdmm)object).zzq("headline", string);
            ((zzdmm)object).zze = list;
            ((zzdmm)object).zzq("body", string2);
            ((zzdmm)object).zzh = bundle;
            ((zzdmm)object).zzq("call_to_action", string3);
            ((zzdmm)object).zzm = view2;
            ((zzdmm)object).zzo = iObjectWrapper;
            ((zzdmm)object).zzq("advertiser", string4);
            ((zzdmm)object).zzr = zzbmh2;
            return object;
        }
        catch (RemoteException remoteException) {
            com.google.android.gms.ads.internal.util.zze.zzj((String)"Failed to get native ad from content ad mapper", (Throwable)remoteException);
            return null;
        }
    }

    public static zzdmm zzac(zzbvr zzbvr2) {
        try {
            zzdml zzdml2 = zzdmm.zzah(zzbvr2.zzt(), null);
            zzblz zzblz2 = zzbvr2.zzv();
            View view = (View)zzdmm.zzag(zzbvr2.zzu());
            String string = zzbvr2.zze();
            List list = zzbvr2.zzf();
            String string2 = zzbvr2.zzg();
            Bundle bundle = zzbvr2.zzr();
            String string3 = zzbvr2.zzi();
            View view2 = (View)zzdmm.zzag(zzbvr2.zzw());
            IObjectWrapper iObjectWrapper = zzbvr2.zzx();
            String string4 = zzbvr2.zzk();
            String string5 = zzbvr2.zzl();
            double d = zzbvr2.zzj();
            zzbvr2 = zzbvr2.zzh();
            zzdmm zzdmm2 = new zzdmm();
            zzdmm2.zza = 2;
            zzdmm2.zzb = zzdml2;
            zzdmm2.zzc = zzblz2;
            zzdmm2.zzd = view;
            zzdmm2.zzq("headline", string);
            zzdmm2.zze = list;
            zzdmm2.zzq("body", string2);
            zzdmm2.zzh = bundle;
            zzdmm2.zzq("call_to_action", string3);
            zzdmm2.zzm = view2;
            zzdmm2.zzo = iObjectWrapper;
            zzdmm2.zzq("store", string4);
            zzdmm2.zzq("price", string5);
            zzdmm2.zzp = d;
            zzdmm2.zzq = zzbvr2;
            return zzdmm2;
        }
        catch (RemoteException remoteException) {
            com.google.android.gms.ads.internal.util.zze.zzj((String)"Failed to get native ad from app install ad mapper", (Throwable)remoteException);
            return null;
        }
    }

    public static zzdmm zzad(zzbvr object) {
        try {
            object = zzdmm.zzaf((zzbhc)zzdmm.zzah(object.zzt(), null), object.zzv(), (View)zzdmm.zzag(object.zzu()), object.zze(), object.zzf(), object.zzg(), object.zzr(), object.zzi(), (View)zzdmm.zzag(object.zzw()), object.zzx(), object.zzk(), object.zzl(), object.zzj(), object.zzh(), null, 0.0f);
            return object;
        }
        catch (RemoteException remoteException) {
            com.google.android.gms.ads.internal.util.zze.zzj((String)"Failed to get native ad assets from app install ad mapper", (Throwable)remoteException);
            return null;
        }
    }

    public static zzdmm zzae(zzbvs object) {
        try {
            object = zzdmm.zzaf((zzbhc)zzdmm.zzah(object.zzs(), null), object.zzt(), (View)zzdmm.zzag(object.zzr()), object.zze(), object.zzf(), object.zzg(), object.zzp(), object.zzi(), (View)zzdmm.zzag(object.zzu()), object.zzv(), null, null, -1.0, object.zzh(), object.zzj(), 0.0f);
            return object;
        }
        catch (RemoteException remoteException) {
            com.google.android.gms.ads.internal.util.zze.zzj((String)"Failed to get native ad assets from content ad mapper", (Throwable)remoteException);
            return null;
        }
    }

    private static zzdmm zzaf(zzbhc zzbhc2, zzblz zzblz2, View view, String string, List list, String string2, Bundle bundle, String string3, View view2, IObjectWrapper iObjectWrapper, String string4, String string5, double d, zzbmh zzbmh2, String string6, float f) {
        zzdmm zzdmm2 = new zzdmm();
        zzdmm2.zza = 6;
        zzdmm2.zzb = zzbhc2;
        zzdmm2.zzc = zzblz2;
        zzdmm2.zzd = view;
        zzdmm2.zzq("headline", string);
        zzdmm2.zze = list;
        zzdmm2.zzq("body", string2);
        zzdmm2.zzh = bundle;
        zzdmm2.zzq("call_to_action", string3);
        zzdmm2.zzm = view2;
        zzdmm2.zzo = iObjectWrapper;
        zzdmm2.zzq("store", string4);
        zzdmm2.zzq("price", string5);
        zzdmm2.zzp = d;
        zzdmm2.zzq = zzbmh2;
        zzdmm2.zzq("advertiser", string6);
        zzdmm2.zzs(f);
        return zzdmm2;
    }

    private static <T> T zzag(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) return (T)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
        return null;
    }

    private static zzdml zzah(zzbhc zzbhc2, zzbvv zzbvv2) {
        if (zzbhc2 != null) return new zzdml(zzbhc2, zzbvv2);
        return null;
    }

    public final List<?> zzA() {
        synchronized (this) {
            List<?> list = this.zze;
            return list;
        }
    }

    public final zzbmh zzB() {
        List<?> list = this.zze;
        if (list == null) return null;
        if (list.size() == 0) {
            return null;
        }
        list = this.zze.get(0);
        if (!(list instanceof IBinder)) return null;
        return zzbmg.zzg((IBinder)((IBinder)list));
    }

    public final List<zzbhu> zzC() {
        synchronized (this) {
            List<zzbhu> list = this.zzf;
            return list;
        }
    }

    public final zzbhu zzD() {
        synchronized (this) {
            zzbhu zzbhu2 = this.zzg;
            return zzbhu2;
        }
    }

    public final String zzE() {
        synchronized (this) {
            String string = this.zzu("body");
            return string;
        }
    }

    public final Bundle zzF() {
        synchronized (this) {
            Bundle bundle;
            if (this.zzh == null) {
                this.zzh = bundle = new Bundle();
            }
            bundle = this.zzh;
            return bundle;
        }
    }

    public final String zzG() {
        synchronized (this) {
            String string = this.zzu("call_to_action");
            return string;
        }
    }

    public final View zzH() {
        synchronized (this) {
            View view = this.zzm;
            return view;
        }
    }

    public final View zzI() {
        synchronized (this) {
            View view = this.zzn;
            return view;
        }
    }

    public final IObjectWrapper zzJ() {
        synchronized (this) {
            IObjectWrapper iObjectWrapper = this.zzo;
            return iObjectWrapper;
        }
    }

    public final String zzK() {
        synchronized (this) {
            String string = this.zzu("store");
            return string;
        }
    }

    public final String zzL() {
        synchronized (this) {
            String string = this.zzu("price");
            return string;
        }
    }

    public final double zzM() {
        synchronized (this) {
            double d = this.zzp;
            return d;
        }
    }

    public final zzbmh zzN() {
        synchronized (this) {
            zzbmh zzbmh2 = this.zzq;
            return zzbmh2;
        }
    }

    public final String zzO() {
        synchronized (this) {
            String string = this.zzu("advertiser");
            return string;
        }
    }

    public final zzbmh zzP() {
        synchronized (this) {
            zzbmh zzbmh2 = this.zzr;
            return zzbmh2;
        }
    }

    public final String zzQ() {
        synchronized (this) {
            String string = this.zzs;
            return string;
        }
    }

    public final zzcml zzR() {
        synchronized (this) {
            zzcml zzcml2 = this.zzi;
            return zzcml2;
        }
    }

    public final zzcml zzS() {
        synchronized (this) {
            zzcml zzcml2 = this.zzj;
            return zzcml2;
        }
    }

    public final zzcml zzT() {
        synchronized (this) {
            zzcml zzcml2 = this.zzk;
            return zzcml2;
        }
    }

    public final IObjectWrapper zzU() {
        synchronized (this) {
            IObjectWrapper iObjectWrapper = this.zzl;
            return iObjectWrapper;
        }
    }

    public final SimpleArrayMap<String, zzblr> zzV() {
        synchronized (this) {
            SimpleArrayMap<String, zzblr> simpleArrayMap = this.zzt;
            return simpleArrayMap;
        }
    }

    public final float zzW() {
        synchronized (this) {
            float f = this.zzv;
            return f;
        }
    }

    public final String zzX() {
        synchronized (this) {
            String string = this.zzw;
            return string;
        }
    }

    public final SimpleArrayMap<String, String> zzY() {
        synchronized (this) {
            SimpleArrayMap<String, String> simpleArrayMap = this.zzu;
            return simpleArrayMap;
        }
    }

    public final void zzZ() {
        synchronized (this) {
            zzcml zzcml2 = this.zzi;
            if (zzcml2 != null) {
                zzcml2.destroy();
                this.zzi = null;
            }
            if ((zzcml2 = this.zzj) != null) {
                zzcml2.destroy();
                this.zzj = null;
            }
            if ((zzcml2 = this.zzk) != null) {
                zzcml2.destroy();
                this.zzk = null;
            }
            this.zzl = null;
            this.zzt.clear();
            this.zzu.clear();
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzh = null;
            this.zzm = null;
            this.zzn = null;
            this.zzo = null;
            this.zzq = null;
            this.zzr = null;
            this.zzs = null;
            return;
        }
    }

    public final void zza(int n) {
        synchronized (this) {
            this.zza = n;
            return;
        }
    }

    public final void zzb(zzbhc zzbhc2) {
        synchronized (this) {
            this.zzb = zzbhc2;
            return;
        }
    }

    public final void zzc(zzblz zzblz2) {
        synchronized (this) {
            this.zzc = zzblz2;
            return;
        }
    }

    public final void zzd(List<zzblr> list) {
        synchronized (this) {
            this.zze = list;
            return;
        }
    }

    public final void zze(List<zzbhu> list) {
        synchronized (this) {
            this.zzf = list;
            return;
        }
    }

    public final void zzf(zzbhu zzbhu2) {
        synchronized (this) {
            this.zzg = zzbhu2;
            return;
        }
    }

    public final void zzg(View view) {
        synchronized (this) {
            this.zzm = view;
            return;
        }
    }

    public final void zzh(View view) {
        synchronized (this) {
            this.zzn = view;
            return;
        }
    }

    public final void zzi(double d) {
        synchronized (this) {
            this.zzp = d;
            return;
        }
    }

    public final void zzj(zzbmh zzbmh2) {
        synchronized (this) {
            this.zzq = zzbmh2;
            return;
        }
    }

    public final void zzk(zzbmh zzbmh2) {
        synchronized (this) {
            this.zzr = zzbmh2;
            return;
        }
    }

    public final void zzl(String string) {
        synchronized (this) {
            this.zzs = string;
            return;
        }
    }

    public final void zzm(zzcml zzcml2) {
        synchronized (this) {
            this.zzi = zzcml2;
            return;
        }
    }

    public final void zzn(zzcml zzcml2) {
        synchronized (this) {
            this.zzj = zzcml2;
            return;
        }
    }

    public final void zzo(zzcml zzcml2) {
        synchronized (this) {
            this.zzk = zzcml2;
            return;
        }
    }

    public final void zzp(IObjectWrapper iObjectWrapper) {
        synchronized (this) {
            this.zzl = iObjectWrapper;
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final void zzq(String string, String string2) {
        synchronized (this) {
            void var2_2;
            if (var2_2 == null) {
                this.zzu.remove((Object)string);
                return;
            }
            this.zzu.put((Object)string, (Object)var2_2);
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final void zzr(String string, zzblr zzblr2) {
        synchronized (this) {
            void var2_2;
            if (var2_2 == null) {
                this.zzt.remove((Object)string);
                return;
            }
            this.zzt.put((Object)string, (Object)var2_2);
            return;
        }
    }

    public final void zzs(float f) {
        synchronized (this) {
            this.zzv = f;
            return;
        }
    }

    public final void zzt(String string) {
        synchronized (this) {
            this.zzw = string;
            return;
        }
    }

    public final String zzu(String string) {
        synchronized (this) {
            string = (String)this.zzu.get((Object)string);
            return string;
        }
    }

    public final int zzv() {
        synchronized (this) {
            int n = this.zza;
            return n;
        }
    }

    public final zzbhc zzw() {
        synchronized (this) {
            zzbhc zzbhc2 = this.zzb;
            return zzbhc2;
        }
    }

    public final zzblz zzx() {
        synchronized (this) {
            zzblz zzblz2 = this.zzc;
            return zzblz2;
        }
    }

    public final View zzy() {
        synchronized (this) {
            View view = this.zzd;
            return view;
        }
    }

    public final String zzz() {
        synchronized (this) {
            String string = this.zzu("headline");
            return string;
        }
    }
}
