/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.RemoteException
 *  com.google.android.gms.ads.nativead.NativeAd$Image
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbmh
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzcgt;

public final class zzbyt
extends NativeAd.Image {
    private final zzbmh zza;
    private final Drawable zzb;
    private final Uri zzc;
    private final double zzd;

    public zzbyt(zzbmh zzbmh2) {
        double d;
        Object var4_7;
        block11: {
            block10: {
                this.zza = zzbmh2;
                var4_7 = null;
                try {
                    zzbmh2 = zzbmh2.zzb();
                    if (zzbmh2 == null) break block10;
                    zzbmh2 = (Drawable)ObjectWrapper.unwrap((IObjectWrapper)zzbmh2);
                    break block11;
                }
                catch (RemoteException remoteException) {
                    zzcgt.zzg((String)"", (Throwable)remoteException);
                }
            }
            zzbmh2 = null;
        }
        this.zzb = zzbmh2;
        try {
            zzbmh2 = this.zza.zzc();
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            zzbmh2 = var4_7;
        }
        this.zzc = zzbmh2;
        try {
            d = this.zza.zzd();
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            d = 1.0;
        }
        this.zzd = d;
        try {
            this.zza.zze();
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
        }
        try {
            this.zza.zzf();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }

    public final Drawable getDrawable() {
        return this.zzb;
    }

    public final double getScale() {
        return this.zzd;
    }

    public final Uri getUri() {
        return this.zzc;
    }
}
