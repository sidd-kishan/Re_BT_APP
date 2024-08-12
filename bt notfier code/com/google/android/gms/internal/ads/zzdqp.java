/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.collection.ArrayMap
 *  androidx.collection.SimpleArrayMap
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzblt
 *  com.google.android.gms.internal.ads.zzbmh
 *  com.google.android.gms.internal.ads.zzbna
 *  com.google.android.gms.internal.ads.zzdmh
 *  com.google.android.gms.internal.ads.zzdmm
 *  com.google.android.gms.internal.ads.zzdnl
 *  com.google.android.gms.internal.ads.zzdqo
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzblt;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzbna;
import com.google.android.gms.internal.ads.zzdmh;
import com.google.android.gms.internal.ads.zzdmm;
import com.google.android.gms.internal.ads.zzdnl;
import com.google.android.gms.internal.ads.zzdqo;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class zzdqp
extends zzbna {
    private final Context zza;
    private final zzdmm zzb;
    private zzdnl zzc;
    private zzdmh zzd;

    public zzdqp(Context context, zzdmm zzdmm2, zzdnl zzdnl2, zzdmh zzdmh2) {
        this.zza = context;
        this.zzb = zzdmm2;
        this.zzc = zzdnl2;
        this.zzd = zzdmh2;
    }

    static /* synthetic */ zzdmh zzc(zzdqp zzdqp2) {
        return zzdqp2.zzd;
    }

    public final String zze(String string) {
        return (String)this.zzb.zzY().get((Object)string);
    }

    public final zzbmh zzf(String string) {
        return (zzbmh)this.zzb.zzV().get((Object)string);
    }

    public final List<String> zzg() {
        SimpleArrayMap simpleArrayMap = this.zzb.zzV();
        SimpleArrayMap simpleArrayMap2 = this.zzb.zzY();
        String[] stringArray = new String[simpleArrayMap.size() + simpleArrayMap2.size()];
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        while (true) {
            int n4 = n;
            int n5 = ++n3;
            if (n2 >= simpleArrayMap.size()) {
                while (n4 < simpleArrayMap2.size()) {
                    stringArray[n5] = (String)simpleArrayMap2.keyAt(n4);
                    ++n4;
                    ++n5;
                }
                return Arrays.asList(stringArray);
            }
            stringArray[n3] = (String)simpleArrayMap.keyAt(n2);
            ++n2;
        }
    }

    public final String zzh() {
        return this.zzb.zzQ();
    }

    public final void zzi(String string) {
        zzdmh zzdmh2 = this.zzd;
        if (zzdmh2 == null) return;
        zzdmh2.zzc(string);
    }

    public final void zzj() {
        zzdmh zzdmh2 = this.zzd;
        if (zzdmh2 == null) return;
        zzdmh2.zze();
    }

    public final zzbhc zzk() {
        return this.zzb.zzw();
    }

    public final void zzl() {
        zzdmh zzdmh2 = this.zzd;
        if (zzdmh2 != null) {
            zzdmh2.zzT();
        }
        this.zzd = null;
        this.zzc = null;
    }

    public final IObjectWrapper zzm() {
        return ObjectWrapper.wrap((Object)this.zza);
    }

    public final boolean zzn(IObjectWrapper object) {
        if (!((object = ObjectWrapper.unwrap((IObjectWrapper)object)) instanceof ViewGroup)) {
            return false;
        }
        zzdnl zzdnl2 = this.zzc;
        if (zzdnl2 == null) return false;
        if (!zzdnl2.zzd((ViewGroup)object)) return false;
        this.zzb.zzR().zzap((zzblt)new zzdqo(this));
        return true;
    }

    public final boolean zzo() {
        zzdmh zzdmh2 = this.zzd;
        if (zzdmh2 != null) {
            if (!zzdmh2.zzG()) return false;
        }
        if (this.zzb.zzT() == null) {
            return false;
        }
        if (this.zzb.zzR() == null) return true;
        return false;
    }

    public final boolean zzp() {
        IObjectWrapper iObjectWrapper = this.zzb.zzU();
        if (iObjectWrapper != null) {
            zzt.zzr().zzf(iObjectWrapper);
            if (this.zzb.zzT() == null) return true;
            this.zzb.zzT().zze("onSdkLoaded", (Map)new ArrayMap());
            return true;
        }
        zze.zzi((String)"Trying to start OMID session before creation.");
        return false;
    }

    public final void zzq(IObjectWrapper iObjectWrapper) {
        Object object = ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
        if (!(object instanceof View)) {
            return;
        }
        if (this.zzb.zzU() == null) {
            return;
        }
        iObjectWrapper = this.zzd;
        if (iObjectWrapper == null) return;
        iObjectWrapper.zzH((View)object);
    }

    public final void zzr() {
        String string = this.zzb.zzX();
        if ("Google".equals(string)) {
            zze.zzi((String)"Illegal argument specified for omid partner name.");
            return;
        }
        if (TextUtils.isEmpty((CharSequence)string)) {
            zze.zzi((String)"Not starting OMID session. OM partner name has not been configured.");
            return;
        }
        zzdmh zzdmh2 = this.zzd;
        if (zzdmh2 == null) return;
        zzdmh2.zzF(string, false);
    }
}
