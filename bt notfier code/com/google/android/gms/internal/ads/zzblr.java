/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbmg
 */
package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbmg;

public final class zzblr
extends zzbmg {
    private final Drawable zza;
    private final Uri zzb;
    private final double zzc;
    private final int zzd;
    private final int zze;

    public zzblr(Drawable drawable, Uri uri, double d, int n, int n2) {
        this.zza = drawable;
        this.zzb = uri;
        this.zzc = d;
        this.zzd = n;
        this.zze = n2;
    }

    public final IObjectWrapper zzb() throws RemoteException {
        return ObjectWrapper.wrap((Object)this.zza);
    }

    public final Uri zzc() throws RemoteException {
        return this.zzb;
    }

    public final double zzd() {
        return this.zzc;
    }

    public final int zze() {
        return this.zzd;
    }

    public final int zzf() {
        return this.zze;
    }
}
