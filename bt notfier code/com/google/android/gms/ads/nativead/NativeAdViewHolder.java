/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  android.view.View
 *  com.google.android.gms.ads.nativead.NativeAd
 *  com.google.android.gms.ads.nativead.NativeAdView
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbmr
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.ads.nativead;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbmr;
import com.google.android.gms.internal.ads.zzcgt;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class NativeAdViewHolder {
    public static WeakHashMap<View, NativeAdViewHolder> zza = new WeakHashMap();
    @NotOnlyInitialized
    private zzbmr zzb;
    private WeakReference<View> zzc;

    public NativeAdViewHolder(View view, Map<String, View> map, Map<String, View> map2) {
        Preconditions.checkNotNull((Object)view, (Object)"ContainerView must not be null");
        if (view instanceof NativeAdView) {
            zzcgt.zzf((String)"The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
            return;
        }
        if (zza.get(view) != null) {
            zzcgt.zzf((String)"The provided containerView is already in use with another NativeAdViewHolder.");
            return;
        }
        zza.put(view, this);
        this.zzc = new WeakReference<View>(view);
        map = NativeAdViewHolder.zza(map);
        map2 = NativeAdViewHolder.zza(map2);
        this.zzb = zzber.zzb().zzn(view, map, map2);
    }

    private static final HashMap<String, View> zza(Map<String, View> map) {
        if (map != null) return new HashMap<String, View>(map);
        return new HashMap<String, View>();
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzb.zzd(ObjectWrapper.wrap((Object)view));
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Unable to call setClickConfirmingView on delegate", (Throwable)remoteException);
            return;
        }
    }

    public void setNativeAd(NativeAd object) {
        Object object2 = object.zza();
        object = this.zzc;
        object = object != null ? (View)((Reference)object).get() : null;
        if (object == null) {
            zzcgt.zzi((String)"NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!zza.containsKey(object)) {
            zza.put((View)object, this);
        }
        if ((object = this.zzb) == null) return;
        try {
            object.zzb((IObjectWrapper)object2);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Unable to call setNativeAd on delegate", (Throwable)remoteException);
        }
    }

    public void unregisterNativeAd() {
        Object object = this.zzb;
        if (object != null) {
            try {
                object.zzc();
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"Unable to call unregisterNativeAd on delegate", (Throwable)remoteException);
            }
        }
        object = (object = this.zzc) != null ? (View)((Reference)object).get() : null;
        if (object == null) return;
        zza.remove(object);
    }
}
