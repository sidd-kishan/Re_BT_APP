/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zzav
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbgd
 *  com.google.android.gms.internal.ads.zzbgq
 *  com.google.android.gms.internal.ads.zzbim
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbrl
 *  com.google.android.gms.internal.ads.zzbrs
 *  com.google.android.gms.internal.ads.zzbva
 *  com.google.android.gms.internal.ads.zzbvb
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzcck
 *  com.google.android.gms.internal.ads.zzcfa
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcrc
 *  com.google.android.gms.internal.ads.zzcrd
 *  com.google.android.gms.internal.ads.zzdtf
 *  com.google.android.gms.internal.ads.zzdtk
 *  com.google.android.gms.internal.ads.zzdxk
 *  com.google.android.gms.internal.ads.zzdyb
 *  com.google.android.gms.internal.ads.zzdyc
 *  com.google.android.gms.internal.ads.zzeee
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzefz
 *  com.google.android.gms.internal.ads.zzeke
 *  com.google.android.gms.internal.ads.zzfaw
 *  com.google.android.gms.internal.ads.zzfbi
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzav;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbgd;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbim;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbrl;
import com.google.android.gms.internal.ads.zzbrs;
import com.google.android.gms.internal.ads.zzbva;
import com.google.android.gms.internal.ads.zzbvb;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzcck;
import com.google.android.gms.internal.ads.zzcfa;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcrc;
import com.google.android.gms.internal.ads.zzcrd;
import com.google.android.gms.internal.ads.zzdtf;
import com.google.android.gms.internal.ads.zzdtk;
import com.google.android.gms.internal.ads.zzdxk;
import com.google.android.gms.internal.ads.zzdyb;
import com.google.android.gms.internal.ads.zzdyc;
import com.google.android.gms.internal.ads.zzeee;
import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzefz;
import com.google.android.gms.internal.ads.zzeke;
import com.google.android.gms.internal.ads.zzfaw;
import com.google.android.gms.internal.ads.zzfbi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class zzcrf
extends zzbgd {
    private final Context zza;
    private final zzcgz zzb;
    private final zzdtf zzc;
    private final zzeee<zzfbi, zzefz> zzd;
    private final zzeke zze;
    private final zzdxk zzf;
    private final zzcfa zzg;
    private final zzdtk zzh;
    private final zzdyc zzi;
    private boolean zzj;

    zzcrf(Context context, zzcgz zzcgz2, zzdtf zzdtf2, zzeee<zzfbi, zzefz> zzeee2, zzeke zzeke2, zzdxk zzdxk2, zzcfa zzcfa2, zzdtk zzdtk2, zzdyc zzdyc2) {
        this.zza = context;
        this.zzb = zzcgz2;
        this.zzc = zzdtf2;
        this.zzd = zzeee2;
        this.zze = zzeke2;
        this.zzf = zzdxk2;
        this.zzg = zzcfa2;
        this.zzh = zzdtk2;
        this.zzi = zzdyc2;
        this.zzj = false;
    }

    final void zzb() {
        if (!zzt.zzg().zzp().zzI()) return;
        String string = zzt.zzg().zzp().zzK();
        if (zzt.zzm().zze(this.zza, string, this.zzb.zza)) return;
        zzt.zzg().zzp().zzJ(false);
        zzt.zzg().zzp().zzL("");
    }

    final void zzc(Runnable object) {
        Preconditions.checkMainThread((String)"Adapters must be initialized on the main thread.");
        Object object2 = zzt.zzg().zzp().zzn().zzf();
        if (object2.isEmpty()) {
            return;
        }
        if (object != null) {
            try {
                object.run();
            }
            catch (Throwable throwable) {
                com.google.android.gms.ads.internal.util.zze.zzj((String)"Could not initialize rewarded ads.", (Throwable)throwable);
                return;
            }
        }
        if (!this.zzc.zzd()) {
            return;
        }
        object = new HashMap();
        Iterator<Object> iterator = object2.values().iterator();
        while (iterator.hasNext()) {
            for (Object object32 : ((zzbvb)iterator.next()).zza) {
                object2 = ((zzbva)object32).zzk;
                for (Object object32 : ((zzbva)object32).zzc) {
                    if (!object.containsKey(object32)) {
                        object.put(object32, new ArrayList());
                    }
                    if (object2 == null) continue;
                    ((Collection)object.get(object32)).add(object2);
                }
            }
        }
        object2 = new JSONObject();
        iterator = object.entrySet().iterator();
        while (iterator.hasNext()) {
            Object object32;
            object32 = (Map.Entry)iterator.next();
            String string = (String)object32.getKey();
            try {
                zzeef zzeef2 = this.zzd.zza(string, (JSONObject)object2);
                if (zzeef2 == null || (object = (zzfbi)zzeef2.zzb).zzn() || !object.zzq()) continue;
                zzeef2 = (zzefz)zzeef2.zzc;
                object32 = (List)object32.getValue();
                object.zzr(this.zza, (zzcck)zzeef2, (List)object32);
                object = String.valueOf(string);
                object = ((String)object).length() != 0 ? "Initialized rewarded video mediation adapter ".concat((String)object) : new String("Initialized rewarded video mediation adapter ");
                com.google.android.gms.ads.internal.util.zze.zzd((String)object);
            }
            catch (zzfaw zzfaw2) {
                object = new StringBuilder(String.valueOf(string).length() + 56);
                ((StringBuilder)object).append("Failed to initialize rewarded video mediation adapter \"");
                ((StringBuilder)object).append(string);
                ((StringBuilder)object).append("\"");
                com.google.android.gms.ads.internal.util.zze.zzj((String)((StringBuilder)object).toString(), (Throwable)zzfaw2);
            }
        }
    }

    public final void zze() {
        synchronized (this) {
            if (this.zzj) {
                com.google.android.gms.ads.internal.util.zze.zzi((String)"Mobile ads is initialized already.");
                return;
            }
            zzbjl.zza((Context)this.zza);
            zzt.zzg().zzi(this.zza, this.zzb);
            zzt.zzi().zzd(this.zza);
            this.zzj = true;
            this.zzf.zzi();
            this.zze.zza();
            zzbjd zzbjd2 = zzbjl.zzcu;
            if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
                this.zzh.zza();
            }
            this.zzi.zza();
            zzbjd2 = zzbjl.zzgE;
            if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
            zzbjd2 = zzchg.zza;
            zzcrc zzcrc2 = new zzcrc(this);
            zzbjd2.execute((Runnable)zzcrc2);
            return;
        }
    }

    public final void zzf(float f) {
        synchronized (this) {
            zzt.zzh().zza(f);
            return;
        }
    }

    public final void zzg(String string) {
        synchronized (this) {
            zzbjl.zza((Context)this.zza);
            if (TextUtils.isEmpty((CharSequence)string)) return;
            zzbjd zzbjd2 = zzbjl.zzct;
            if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
            zzt.zzk().zza(this.zza, this.zzb, string, null);
            return;
        }
    }

    public final void zzh(boolean bl) {
        synchronized (this) {
            zzt.zzh().zzc(bl);
            return;
        }
    }

    public final void zzi(IObjectWrapper iObjectWrapper, String string) {
        if (iObjectWrapper == null) {
            com.google.android.gms.ads.internal.util.zze.zzf((String)"Wrapped context is null. Failed to open debug menu.");
            return;
        }
        if ((iObjectWrapper = (Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper)) == null) {
            com.google.android.gms.ads.internal.util.zze.zzf((String)"Context is null. Failed to open debug menu.");
            return;
        }
        iObjectWrapper = new zzav((Context)iObjectWrapper);
        iObjectWrapper.zzc(string);
        iObjectWrapper.zzd(this.zzb.zza);
        iObjectWrapper.zzb();
    }

    public final void zzj(String string, IObjectWrapper iObjectWrapper) {
        zzbjl.zza((Context)this.zza);
        Object object = zzbjl.zzcw;
        if (((Boolean)zzbet.zzc().zzc(object)).booleanValue()) {
            zzt.zzc();
            object = zzs.zzv((Context)this.zza);
        } else {
            object = "";
        }
        boolean bl = TextUtils.isEmpty((CharSequence)object);
        boolean bl2 = true;
        if (!bl) {
            string = object;
        }
        if (TextUtils.isEmpty((CharSequence)string)) {
            return;
        }
        object = zzbjl.zzct;
        boolean bl3 = (Boolean)zzbet.zzc().zzc(object);
        object = zzbjl.zzaB;
        bl = (Boolean)zzbet.zzc().zzc(object);
        object = zzbjl.zzaB;
        if (((Boolean)zzbet.zzc().zzc(object)).booleanValue()) {
            iObjectWrapper = new zzcrd(this, (Runnable)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper));
        } else {
            bl2 = bl3 | bl;
            iObjectWrapper = null;
        }
        if (!bl2) return;
        zzt.zzk().zza(this.zza, this.zzb, string, (Runnable)iObjectWrapper);
    }

    public final float zzk() {
        synchronized (this) {
            float f = zzt.zzh().zzb();
            return f;
        }
    }

    public final boolean zzl() {
        synchronized (this) {
            boolean bl = zzt.zzh().zzd();
            return bl;
        }
    }

    public final String zzm() {
        return this.zzb.zza;
    }

    public final void zzn(String string) {
        this.zze.zzd(string);
    }

    public final void zzo(zzbvg zzbvg2) throws RemoteException {
        this.zzc.zza(zzbvg2);
    }

    public final void zzp(zzbrs zzbrs2) throws RemoteException {
        this.zzf.zzh(zzbrs2);
    }

    public final List<zzbrl> zzq() throws RemoteException {
        return this.zzf.zzj();
    }

    public final void zzr(zzbim zzbim2) throws RemoteException {
        this.zzg.zzc(this.zza, zzbim2);
    }

    public final void zzs() {
        this.zzf.zzg();
    }

    public final void zzt(zzbgq zzbgq2) throws RemoteException {
        this.zzi.zzk(zzbgq2, zzdyb.zzb);
    }
}
