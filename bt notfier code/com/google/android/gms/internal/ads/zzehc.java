/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzbvv
 *  com.google.android.gms.internal.ads.zzbxh
 *  com.google.android.gms.internal.ads.zzbxn
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzdlb
 *  com.google.android.gms.internal.ads.zzdmh
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzeek
 *  com.google.android.gms.internal.ads.zzefy
 *  com.google.android.gms.internal.ads.zzeha
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfaw
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzbvv;
import com.google.android.gms.internal.ads.zzbxh;
import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzdlb;
import com.google.android.gms.internal.ads.zzdmh;
import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzeek;
import com.google.android.gms.internal.ads.zzefy;
import com.google.android.gms.internal.ads.zzeha;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfaw;

public final class zzehc
implements zzeek<zzdmh, zzbxn, zzefy> {
    private final Context zza;
    private final zzdlb zzb;
    private zzbvv zzc;
    private final zzcgz zzd;

    public zzehc(Context context, zzdlb zzdlb2, zzcgz zzcgz2) {
        this.zza = context;
        this.zzb = zzdlb2;
        this.zzd = zzcgz2;
    }

    static /* synthetic */ zzbvv zzc(zzehc zzehc2, zzbvv zzbvv2) {
        zzehc2.zzc = zzbvv2;
        return zzbvv2;
    }

    public final void zza(zzfal zzfal2, zzezz object, zzeef<zzbxn, zzefy> zzeef2) throws zzfaw {
        try {
            ((zzbxn)zzeef2.zzb).zzo(object.zzV);
            int n = this.zzd.zzc;
            Object object2 = zzbjl.zzbd;
            if (n < (Integer)zzbet.zzc().zzc(object2)) {
                zzbxn zzbxn2 = (zzbxn)zzeef2.zzb;
                object2 = object.zzQ;
                object = object.zzv.toString();
                zzbdg zzbdg2 = zzfal2.zza.zza.zzd;
                zzfal2 = ObjectWrapper.wrap((Object)this.zza);
                zzeha zzeha2 = new zzeha(this, zzeef2, null);
                zzbxn2.zzn((String)object2, (String)object, zzbdg2, (IObjectWrapper)zzfal2, (zzbxh)zzeha2, (zzbvm)zzeef2.zzc);
                return;
            }
            object2 = (zzbxn)zzeef2.zzb;
            String string = object.zzQ;
            String string2 = object.zzv.toString();
            zzbdg zzbdg3 = zzfal2.zza.zza.zzd;
            IObjectWrapper iObjectWrapper = ObjectWrapper.wrap((Object)this.zza);
            object = new zzeha(this, zzeef2, null);
            object2.zzr(string, string2, zzbdg3, iObjectWrapper, (zzbxh)object, (zzbvm)zzeef2.zzc, zzfal2.zza.zza.zzi);
            return;
        }
        catch (RemoteException remoteException) {
            throw new zzfaw((Throwable)remoteException);
        }
    }
}
