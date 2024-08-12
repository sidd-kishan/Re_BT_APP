/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzbxk
 *  com.google.android.gms.internal.ads.zzbxn
 *  com.google.android.gms.internal.ads.zzdrw
 *  com.google.android.gms.internal.ads.zzdsb
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzeek
 *  com.google.android.gms.internal.ads.zzefy
 *  com.google.android.gms.internal.ads.zzehz
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfaw
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzbxk;
import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzdrw;
import com.google.android.gms.internal.ads.zzdsb;
import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzeek;
import com.google.android.gms.internal.ads.zzefy;
import com.google.android.gms.internal.ads.zzehz;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfaw;

public final class zzeib
implements zzeek<zzdrw, zzbxn, zzefy> {
    private final Context zza;
    private final zzdsb zzb;

    public zzeib(Context context, zzdsb zzdsb2) {
        this.zza = context;
        this.zzb = zzdsb2;
    }

    public final void zza(zzfal zzfal2, zzezz object, zzeef<zzbxn, zzefy> zzeef2) throws zzfaw {
        try {
            ((zzbxn)zzeef2.zzb).zzo(object.zzV);
            if (zzfal2.zza.zza.zzo.zza == 3) {
                zzbxn zzbxn2 = (zzbxn)zzeef2.zzb;
                String string = object.zzQ;
                object = object.zzv.toString();
                zzbdg zzbdg2 = zzfal2.zza.zza.zzd;
                zzfal2 = ObjectWrapper.wrap((Object)this.zza);
                zzehz zzehz2 = new zzehz(this, zzeef2, null);
                zzbxn2.zzp(string, (String)object, zzbdg2, (IObjectWrapper)zzfal2, (zzbxk)zzehz2, (zzbvm)zzeef2.zzc);
                return;
            }
            zzbxn zzbxn3 = (zzbxn)zzeef2.zzb;
            String string = object.zzQ;
            object = object.zzv.toString();
            zzfal2 = zzfal2.zza.zza.zzd;
            IObjectWrapper iObjectWrapper = ObjectWrapper.wrap((Object)this.zza);
            zzehz zzehz3 = new zzehz(this, zzeef2, null);
            zzbxn3.zzl(string, (String)object, (zzbdg)zzfal2, iObjectWrapper, (zzbxk)zzehz3, (zzbvm)zzeef2.zzc);
            return;
        }
        catch (RemoteException remoteException) {
            zze.zzb((String)"Remote exception loading a rewarded RTB ad", (Throwable)remoteException);
            return;
        }
    }
}
