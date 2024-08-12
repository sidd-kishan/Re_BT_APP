/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.RemoteException
 *  com.google.android.gms.ads.formats.NativeAd$AdChoicesInfo
 *  com.google.android.gms.ads.formats.NativeAd$Image
 *  com.google.android.gms.internal.ads.zzblz
 *  com.google.android.gms.internal.ads.zzbmf
 *  com.google.android.gms.internal.ads.zzbmh
 *  com.google.android.gms.internal.ads.zzbmi
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.internal.ads.zzblz;
import com.google.android.gms.internal.ads.zzbmf;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzbmi;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzbma
extends NativeAd.AdChoicesInfo {
    private final zzblz zza;
    private final List<NativeAd.Image> zzb = new ArrayList<NativeAd.Image>();
    private String zzc;

    public zzbma(zzblz object) {
        this.zza = object;
        try {
            this.zzc = object.zzb();
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            this.zzc = "";
        }
        try {
            Iterator iterator = object.zzc().iterator();
            while (iterator.hasNext()) {
                Object object2 = iterator.next();
                boolean bl = object2 instanceof IBinder;
                zzbmi zzbmi2 = null;
                object = zzbmi2;
                if (bl) {
                    object = (IBinder)object2;
                    object = object == null ? zzbmi2 : ((zzbmi2 = object.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage")) instanceof zzbmh ? (zzbmh)zzbmi2 : new zzbmf((IBinder)object));
                }
                if (object == null) continue;
                object2 = this.zzb;
                zzbmi2 = new zzbmi((zzbmh)object);
                object2.add((zzbmi)zzbmi2);
            }
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzb;
    }

    public final CharSequence getText() {
        return this.zzc;
    }
}
