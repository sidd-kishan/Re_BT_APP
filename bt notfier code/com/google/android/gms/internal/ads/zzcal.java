/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.RemoteException
 *  android.view.MotionEvent
 *  android.view.View
 *  com.google.android.gms.ads.query.UpdateClickUrlCallback
 *  com.google.android.gms.ads.query.UpdateImpressionUrlsCallback
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzcaf
 *  com.google.android.gms.internal.ads.zzcah
 *  com.google.android.gms.internal.ads.zzcai
 *  com.google.android.gms.internal.ads.zzcaj
 *  com.google.android.gms.internal.ads.zzcak
 *  com.google.android.gms.internal.ads.zzcam
 *  com.google.android.gms.internal.ads.zzcfn
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcah;
import com.google.android.gms.internal.ads.zzcai;
import com.google.android.gms.internal.ads.zzcaj;
import com.google.android.gms.internal.ads.zzcak;
import com.google.android.gms.internal.ads.zzcam;
import com.google.android.gms.internal.ads.zzcfn;
import com.google.android.gms.internal.ads.zzcgt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;

public final class zzcal {
    @Nonnull
    private final View zza;
    private final Map<String, WeakReference<View>> zzb;
    private final zzcfn zzc;

    public zzcal(zzcak zzcak2) {
        this.zza = zzcak.zza((zzcak)zzcak2);
        this.zzb = zzcak.zzb((zzcak)zzcak2);
        zzcak2 = zzcah.zza((Context)zzcak.zza((zzcak)zzcak2).getContext());
        this.zzc = zzcak2;
        if (zzcak2 == null) return;
        if (this.zzb.isEmpty()) return;
        try {
            zzcak2 = this.zzc;
            zzcam zzcam2 = new zzcam(ObjectWrapper.wrap((Object)this.zza).asBinder(), ObjectWrapper.wrap(this.zzb).asBinder());
            zzcak2.zzi(zzcam2);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzf((String)"Failed to call remote method.");
        }
    }

    public final void zza(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        if (this.zzc == null) {
            updateImpressionUrlsCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            zzcfn zzcfn2 = this.zzc;
            IObjectWrapper iObjectWrapper = ObjectWrapper.wrap((Object)this.zza);
            zzcai zzcai2 = new zzcai(this, updateImpressionUrlsCallback);
            zzcfn2.zzg(list, iObjectWrapper, (zzcaf)zzcai2);
            return;
        }
        catch (RemoteException remoteException) {
            updateImpressionUrlsCallback.onFailure("Internal error: ".concat(((Object)((Object)remoteException)).toString()));
            return;
        }
    }

    public final void zzb(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        if (this.zzc == null) {
            updateClickUrlCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            zzcfn zzcfn2 = this.zzc;
            ArrayList<Uri> arrayList = new ArrayList<Uri>(Arrays.asList(uri));
            IObjectWrapper iObjectWrapper = ObjectWrapper.wrap((Object)this.zza);
            uri = new zzcaj(this, updateClickUrlCallback);
            zzcfn2.zzh(arrayList, iObjectWrapper, (zzcaf)uri);
            return;
        }
        catch (RemoteException remoteException) {
            updateClickUrlCallback.onFailure("Internal error: ".concat(((Object)((Object)remoteException)).toString()));
            return;
        }
    }

    public final void zzc(MotionEvent motionEvent) {
        zzcfn zzcfn2 = this.zzc;
        if (zzcfn2 == null) {
            zzcgt.zzd((String)"Failed to get internal reporting info generator.");
            return;
        }
        try {
            zzcfn2.zzf(ObjectWrapper.wrap((Object)motionEvent));
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzf((String)"Failed to call remote method.");
            return;
        }
    }
}
