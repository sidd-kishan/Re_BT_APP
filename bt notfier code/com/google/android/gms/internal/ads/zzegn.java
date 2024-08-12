/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzbxe
 *  com.google.android.gms.internal.ads.zzbxn
 *  com.google.android.gms.internal.ads.zzdji
 *  com.google.android.gms.internal.ads.zzdkf
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzeek
 *  com.google.android.gms.internal.ads.zzefy
 *  com.google.android.gms.internal.ads.zzegl
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
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzbxe;
import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzdji;
import com.google.android.gms.internal.ads.zzdkf;
import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzeek;
import com.google.android.gms.internal.ads.zzefy;
import com.google.android.gms.internal.ads.zzegl;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfaw;

public final class zzegn
implements zzeek<zzdji, zzbxn, zzefy> {
    private final Context zza;
    private final zzdkf zzb;

    public zzegn(Context context, zzdkf zzdkf2) {
        this.zza = context;
        this.zzb = zzdkf2;
    }

    public final void zza(zzfal zzfal2, zzezz object, zzeef<zzbxn, zzefy> zzeef2) throws zzfaw {
        try {
            ((zzbxn)zzeef2.zzb).zzo(object.zzV);
            zzbxn zzbxn2 = (zzbxn)zzeef2.zzb;
            String string = object.zzQ;
            object = object.zzv.toString();
            zzfal2 = zzfal2.zza.zza.zzd;
            IObjectWrapper iObjectWrapper = ObjectWrapper.wrap((Object)this.zza);
            zzegl zzegl2 = new zzegl(this, zzeef2, null);
            zzbxn2.zzj(string, (String)object, (zzbdg)zzfal2, iObjectWrapper, (zzbxe)zzegl2, (zzbvm)zzeef2.zzc);
            return;
        }
        catch (RemoteException remoteException) {
            throw new zzfaw((Throwable)remoteException);
        }
    }
}
