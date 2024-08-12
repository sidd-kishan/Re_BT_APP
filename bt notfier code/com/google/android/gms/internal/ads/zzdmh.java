/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  androidx.collection.ArrayMap
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzaao
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzawd
 *  com.google.android.gms.internal.ads.zzawe
 *  com.google.android.gms.internal.ads.zzawf
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbgi
 *  com.google.android.gms.internal.ads.zzbgm
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbob
 *  com.google.android.gms.internal.ads.zzbzl
 *  com.google.android.gms.internal.ads.zzbzm
 *  com.google.android.gms.internal.ads.zzcei
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcxf
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzdma
 *  com.google.android.gms.internal.ads.zzdmb
 *  com.google.android.gms.internal.ads.zzdmc
 *  com.google.android.gms.internal.ads.zzdmd
 *  com.google.android.gms.internal.ads.zzdme
 *  com.google.android.gms.internal.ads.zzdmf
 *  com.google.android.gms.internal.ads.zzdmg
 *  com.google.android.gms.internal.ads.zzdmj
 *  com.google.android.gms.internal.ads.zzdmm
 *  com.google.android.gms.internal.ads.zzdmr
 *  com.google.android.gms.internal.ads.zzdmu
 *  com.google.android.gms.internal.ads.zzdmx
 *  com.google.android.gms.internal.ads.zzdnf
 *  com.google.android.gms.internal.ads.zzdnl
 *  com.google.android.gms.internal.ads.zzdog
 *  com.google.android.gms.internal.ads.zzdqi
 *  com.google.android.gms.internal.ads.zzdqk
 *  com.google.android.gms.internal.ads.zzdqm
 *  com.google.android.gms.internal.ads.zzdqp
 *  com.google.android.gms.internal.ads.zzdqr
 *  com.google.android.gms.internal.ads.zzell
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzgku
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaao;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzawd;
import com.google.android.gms.internal.ads.zzawe;
import com.google.android.gms.internal.ads.zzawf;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbgi;
import com.google.android.gms.internal.ads.zzbgm;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbob;
import com.google.android.gms.internal.ads.zzbzl;
import com.google.android.gms.internal.ads.zzbzm;
import com.google.android.gms.internal.ads.zzcei;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcxf;
import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzdma;
import com.google.android.gms.internal.ads.zzdmb;
import com.google.android.gms.internal.ads.zzdmc;
import com.google.android.gms.internal.ads.zzdmd;
import com.google.android.gms.internal.ads.zzdme;
import com.google.android.gms.internal.ads.zzdmf;
import com.google.android.gms.internal.ads.zzdmg;
import com.google.android.gms.internal.ads.zzdmj;
import com.google.android.gms.internal.ads.zzdmm;
import com.google.android.gms.internal.ads.zzdmr;
import com.google.android.gms.internal.ads.zzdmu;
import com.google.android.gms.internal.ads.zzdmx;
import com.google.android.gms.internal.ads.zzdnf;
import com.google.android.gms.internal.ads.zzdnl;
import com.google.android.gms.internal.ads.zzdog;
import com.google.android.gms.internal.ads.zzdqi;
import com.google.android.gms.internal.ads.zzdqk;
import com.google.android.gms.internal.ads.zzdqm;
import com.google.android.gms.internal.ads.zzdqp;
import com.google.android.gms.internal.ads.zzdqr;
import com.google.android.gms.internal.ads.zzell;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzgku;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzdmh
extends zzcxg {
    private final Executor zzc;
    private final zzdmm zzd;
    private final zzdmu zze;
    private final zzdnl zzf;
    private final zzdmr zzg;
    private final zzdmx zzh;
    private final zzgku<zzdqm> zzi;
    private final zzgku<zzdqk> zzj;
    private final zzgku<zzdqr> zzk;
    private final zzgku<zzdqi> zzl;
    private final zzgku<zzdqp> zzm;
    private zzdog zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private final zzcei zzr;
    private final zzaas zzs;
    private final zzcgz zzt;
    private final Context zzu;
    private final zzdmj zzv;
    private final zzell zzw;
    private final Map<String, Boolean> zzx;
    private final List<zzawe> zzy;
    private final zzawf zzz;

    public zzdmh(zzcxf zzcxf2, Executor executor, zzdmm zzdmm2, zzdmu zzdmu2, zzdnl zzdnl2, zzdmr zzdmr2, zzdmx zzdmx2, zzgku<zzdqm> zzgku2, zzgku<zzdqk> zzgku3, zzgku<zzdqr> zzgku4, zzgku<zzdqi> zzgku5, zzgku<zzdqp> zzgku6, zzcei zzcei2, zzaas zzaas2, zzcgz zzcgz2, Context context, zzdmj zzdmj2, zzell zzell2, zzawf zzawf2) {
        super(zzcxf2);
        this.zzc = executor;
        this.zzd = zzdmm2;
        this.zze = zzdmu2;
        this.zzf = zzdnl2;
        this.zzg = zzdmr2;
        this.zzh = zzdmx2;
        this.zzi = zzgku2;
        this.zzj = zzgku3;
        this.zzk = zzgku4;
        this.zzl = zzgku5;
        this.zzm = zzgku6;
        this.zzr = zzcei2;
        this.zzs = zzaas2;
        this.zzt = zzcgz2;
        this.zzu = context;
        this.zzv = zzdmj2;
        this.zzw = zzell2;
        this.zzx = new HashMap<String, Boolean>();
        this.zzy = new ArrayList<zzawe>();
        this.zzz = zzawf2;
    }

    public static boolean zzC(View view) {
        zzbjd zzbjd2 = zzbjl.zzgS;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzc();
            long l = com.google.android.gms.ads.internal.util.zzs.zzA((View)view);
            if (!view.isShown()) return false;
            if (!view.getGlobalVisibleRect(new Rect(), null)) return false;
            view = zzbjl.zzgT;
            if (l < (long)((Integer)zzbet.zzc().zzc((zzbjd)view)).intValue()) return false;
            return true;
        }
        if (!view.isShown()) return false;
        if (!view.getGlobalVisibleRect(new Rect(), null)) return false;
        return true;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private final void zzQ(zzdog zzdog2) {
        synchronized (this) {
            zzaao zzaao2;
            boolean bl = this.zzo;
            if (bl) {
                return;
            }
            this.zzn = zzdog2;
            this.zzf.zza(zzdog2);
            this.zze.zzd(zzdog2.zzbx(), zzdog2.zzk(), zzdog2.zzl(), (View.OnTouchListener)zzdog2, (View.OnClickListener)zzdog2);
            zzbjd zzbjd2 = zzbjl.zzbK;
            if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue() && (zzaao2 = this.zzs.zzb()) != null) {
                zzaao2.zzn(zzdog2.zzbx());
            }
            zzbjd zzbjd3 = zzbjl.zzbg;
            if (((Boolean)zzbet.zzc().zzc(zzbjd3)).booleanValue()) {
                Iterator iterator;
                zzezz zzezz2 = this.zzb;
                if (zzezz2.zzah && (iterator = zzezz2.zzag.keys()) != null) {
                    while (iterator.hasNext()) {
                        View view;
                        String string = (String)iterator.next();
                        WeakReference weakReference = (WeakReference)this.zzn.zzj().get(string);
                        this.zzx.put(string, false);
                        if (weakReference == null || (view = (View)weakReference.get()) == null) continue;
                        Context context = this.zzu;
                        weakReference = new zzawe(context, view);
                        this.zzy.add((zzawe)weakReference);
                        view = new zzdmg(this, string);
                        weakReference.zza((zzawd)view);
                    }
                }
            }
            if (zzdog2.zzh() == null) return;
            zzdog2.zzh().zza((zzawd)this.zzr);
            return;
        }
    }

    private final void zzR(zzdog zzdog2) {
        this.zze.zze(zzdog2.zzbx(), zzdog2.zzj());
        if (zzdog2.zzbt() != null) {
            zzdog2.zzbt().setClickable(false);
            zzdog2.zzbt().removeAllViews();
        }
        if (zzdog2.zzh() != null) {
            zzdog2.zzh().zzb((zzawd)this.zzr);
        }
        this.zzn = null;
    }

    static /* synthetic */ zzdog zza(zzdmh zzdmh2) {
        return zzdmh2.zzn;
    }

    static /* synthetic */ Map zzb(zzdmh zzdmh2) {
        return zzdmh2.zzx;
    }

    public final void zzA() {
        synchronized (this) {
            Object object = this.zzn;
            if (object == null) {
                com.google.android.gms.ads.internal.util.zze.zzd((String)"Ad should be associated with an ad view before calling recordCustomClickGesture()");
                return;
            }
            boolean bl = object instanceof zzdnf;
            object = this.zzc;
            zzdmf zzdmf2 = new zzdmf(this, bl);
            object.execute((Runnable)zzdmf2);
            return;
        }
    }

    public final boolean zzB() {
        synchronized (this) {
            boolean bl = this.zze.zzk();
            return bl;
        }
    }

    public final boolean zzD() {
        return this.zzg.zzc();
    }

    public final String zzE() {
        return this.zzg.zzf();
    }

    public final void zzF(String string, boolean bl) {
        zzbzl zzbzl2;
        String string2;
        if (!this.zzg.zzd()) return;
        if (TextUtils.isEmpty((CharSequence)string)) return;
        zzcml zzcml2 = this.zzd.zzT();
        zzcml zzcml3 = this.zzd.zzR();
        if (zzcml2 == null) {
            if (zzcml3 == null) return;
        }
        if (zzcml2 != null) {
            string2 = null;
        } else {
            string2 = "javascript";
            zzcml2 = zzcml3;
        }
        if (!com.google.android.gms.ads.internal.zzt.zzr().zza(this.zzu)) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"Failed to initialize omid in InternalNativeAd");
            return;
        }
        Object object = this.zzt;
        int n = ((zzcgz)object).zzb;
        int n2 = ((zzcgz)object).zzc;
        object = new StringBuilder(23);
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(".");
        ((StringBuilder)object).append(n2);
        String string3 = ((StringBuilder)object).toString();
        if (zzcml3 != null) {
            zzbzl2 = zzbzl.zzc;
            object = zzbzm.zzb;
        } else {
            zzbzl2 = zzbzl.zzb;
            object = this.zzd.zzv() == 3 ? zzbzm.zzd : zzbzm.zzc;
        }
        string = com.google.android.gms.ads.internal.zzt.zzr().zze(string3, zzcml2.zzG(), "", "javascript", string2, string, (zzbzm)object, zzbzl2, this.zzb.zzai);
        if (string == null) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"Failed to create omid session in InternalNativeAd");
            return;
        }
        this.zzd.zzp((IObjectWrapper)string);
        zzcml2.zzak((IObjectWrapper)string);
        if (zzcml3 != null) {
            object = zzcml3.zzH();
            com.google.android.gms.ads.internal.zzt.zzr().zzh((IObjectWrapper)string, (View)object);
            this.zzq = true;
        }
        if (!bl) return;
        com.google.android.gms.ads.internal.zzt.zzr().zzf((IObjectWrapper)string);
        zzcml2.zze("onSdkLoaded", (Map)new ArrayMap());
    }

    public final boolean zzG() {
        return this.zzg.zzd();
    }

    public final void zzH(View view) {
        IObjectWrapper iObjectWrapper = this.zzd.zzU();
        zzcml zzcml2 = this.zzd.zzT();
        if (!this.zzg.zzd()) return;
        if (iObjectWrapper == null) return;
        if (zzcml2 == null) return;
        if (view == null) return;
        com.google.android.gms.ads.internal.zzt.zzr().zzh(iObjectWrapper, view);
    }

    public final void zzI(View view) {
        IObjectWrapper iObjectWrapper = this.zzd.zzU();
        if (!this.zzg.zzd()) return;
        if (iObjectWrapper == null) return;
        if (view == null) return;
        com.google.android.gms.ads.internal.zzt.zzr().zzi(iObjectWrapper, view);
    }

    public final zzdmj zzJ() {
        return this.zzv;
    }

    public final void zzK(zzbgw zzbgw2) {
        synchronized (this) {
            this.zzw.zza(zzbgw2);
            return;
        }
    }

    final /* synthetic */ void zzL(boolean bl) {
        this.zze.zzi(this.zzn.zzbx(), this.zzn.zzj(), this.zzn.zzk(), bl);
    }

    final /* synthetic */ void zzM(zzdog zzdog2) {
        this.zzR(zzdog2);
    }

    final /* synthetic */ void zzN(zzdog zzdog2) {
        this.zzQ(zzdog2);
    }

    final /* synthetic */ void zzO() {
        this.zze.zzA();
        this.zzd.zzZ();
    }

    public final void zzS() {
        this.zzc.execute((Runnable)new zzdma(this));
        if (this.zzd.zzv() != 7) {
            Executor executor = this.zzc;
            zzdmu zzdmu2 = this.zze;
            zzdmu2.getClass();
            executor.execute(zzdmb.zza((zzdmu)zzdmu2));
        }
        super.zzS();
    }

    public final void zzT() {
        synchronized (this) {
            this.zzo = true;
            Executor executor = this.zzc;
            zzdmc zzdmc2 = new zzdmc(this);
            executor.execute((Runnable)zzdmc2);
            super.zzT();
            return;
        }
    }

    public final void zzc(String string) {
        synchronized (this) {
            this.zze.zzg(string);
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zze() {
        synchronized (this) {
            boolean bl = this.zzp;
            if (bl) {
                return;
            }
            this.zze.zzq();
            return;
        }
    }

    public final void zzf(Bundle bundle) {
        synchronized (this) {
            this.zze.zzh(bundle);
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final boolean zzg(Bundle bundle) {
        synchronized (this) {
            boolean bl = this.zzp;
            if (bl) {
                return true;
            }
            this.zzp = bl = this.zze.zzz(bundle);
            return bl;
        }
    }

    public final void zzh(Bundle bundle) {
        synchronized (this) {
            this.zze.zzn(bundle);
            return;
        }
    }

    public final void zzj(zzdog zzdog2) {
        synchronized (this) {
            zzbjd zzbjd2 = zzbjl.zzbe;
            if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
                zzbjd2 = com.google.android.gms.ads.internal.util.zzs.zza;
                zzdmd zzdmd2 = new zzdmd(this, zzdog2);
                zzbjd2.post((Runnable)zzdmd2);
                return;
            }
            this.zzQ(zzdog2);
            return;
        }
    }

    public final void zzk(zzdog zzdog2) {
        synchronized (this) {
            zzbjd zzbjd2 = zzbjl.zzbe;
            if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
                zzbjd2 = com.google.android.gms.ads.internal.util.zzs.zza;
                zzdme zzdme2 = new zzdme(this, zzdog2);
                zzbjd2.post((Runnable)zzdme2);
                return;
            }
            this.zzR(zzdog2);
            return;
        }
    }

    public final void zzp(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean bl) {
        synchronized (this) {
            this.zzf.zzb(this.zzn);
            this.zze.zzf(view, view2, map, map2, bl);
            if (!this.zzq) return;
            if (this.zzd.zzR() == null) {
                return;
            }
            view2 = this.zzd.zzR();
            view = new ArrayMap();
            view2.zze("onSdkAdUserInteractionClick", (Map)view);
            return;
        }
    }

    public final void zzq(View view, MotionEvent motionEvent, View view2) {
        synchronized (this) {
            this.zze.zzm(view, motionEvent, view2);
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzr(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean bl) {
        synchronized (this) {
            String string2;
            boolean bl2 = this.zzp;
            if (bl2) {
                return;
            }
            Object object = zzbjl.zzbg;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue() && this.zzb.zzah) {
                for (String string2 : this.zzx.keySet()) {
                    bl2 = this.zzx.get(string2);
                    if (bl2) continue;
                    return;
                }
            }
            if (bl) {
                this.zzf.zzc(this.zzn);
                this.zze.zzx(view, map, map2);
                this.zzp = true;
                return;
            }
            object = zzbjl.zzcq;
            if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return;
            if (map == null) return;
            object = map.entrySet().iterator();
            do {
                if (!object.hasNext()) return;
            } while ((string2 = (View)((WeakReference)((Map.Entry)object.next()).getValue()).get()) == null || !zzdmh.zzC((View)string2));
            this.zzf.zzc(this.zzn);
            this.zze.zzx(view, map, map2);
            this.zzp = true;
            return;
        }
    }

    public final JSONObject zzs(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        synchronized (this) {
            view = this.zze.zzo(view, map, map2);
            return view;
        }
    }

    public final JSONObject zzt(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        synchronized (this) {
            view = this.zze.zzp(view, map, map2);
            return view;
        }
    }

    public final void zzu(View view) {
        synchronized (this) {
            this.zze.zzr(view);
            return;
        }
    }

    public final void zzv(zzbob zzbob2) {
        synchronized (this) {
            this.zze.zzs(zzbob2);
            return;
        }
    }

    public final void zzw() {
        synchronized (this) {
            this.zze.zzt();
            return;
        }
    }

    public final void zzx(zzbgm zzbgm2) {
        synchronized (this) {
            this.zze.zzu(zzbgm2);
            return;
        }
    }

    public final void zzy(zzbgi zzbgi2) {
        synchronized (this) {
            this.zze.zzv(zzbgi2);
            return;
        }
    }

    public final void zzz() {
        synchronized (this) {
            this.zze.zzj();
            return;
        }
    }
}
