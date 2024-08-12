/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.RemoteException
 *  com.google.android.gms.ads.nativead.NativeAd$AdChoicesInfo
 *  com.google.android.gms.ads.nativead.NativeAd$Image
 *  com.google.android.gms.internal.ads.zzblz
 *  com.google.android.gms.internal.ads.zzbmg
 *  com.google.android.gms.internal.ads.zzbmh
 *  com.google.android.gms.internal.ads.zzbyt
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.internal.ads.zzblz;
import com.google.android.gms.internal.ads.zzbmg;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzbyt;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzbyr
extends NativeAd.AdChoicesInfo {
    private final List<NativeAd.Image> zza = new ArrayList<NativeAd.Image>();
    private String zzb;

    public zzbyr(zzblz object) {
        try {
            this.zzb = object.zzb();
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            this.zzb = "";
        }
        try {
            Iterator iterator = object.zzc().iterator();
            while (iterator.hasNext()) {
                object = iterator.next();
                object = object instanceof IBinder ? zzbmg.zzg((IBinder)((IBinder)object)) : null;
                if (object == null) continue;
                List<NativeAd.Image> list = this.zza;
                zzbyt zzbyt2 = new zzbyt((zzbmh)object);
                list.add((NativeAd.Image)zzbyt2);
            }
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zza;
    }

    public final CharSequence getText() {
        return this.zzb;
    }
}
