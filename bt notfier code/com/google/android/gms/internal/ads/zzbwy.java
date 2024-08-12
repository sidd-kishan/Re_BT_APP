/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  com.google.android.gms.ads.formats.NativeAd$Image
 *  com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzblr
 *  com.google.android.gms.internal.ads.zzblz
 *  com.google.android.gms.internal.ads.zzbmh
 *  com.google.android.gms.internal.ads.zzbvu
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzblr;
import com.google.android.gms.internal.ads.zzblz;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzbvu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzbwy
extends zzbvu {
    private final UnifiedNativeAdMapper zza;

    public zzbwy(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.zza = unifiedNativeAdMapper;
    }

    public final float zzA() {
        return this.zza.getDuration();
    }

    public final float zzB() {
        return this.zza.getCurrentTime();
    }

    public final String zze() {
        return this.zza.getHeadline();
    }

    public final List zzf() {
        List list = this.zza.getImages();
        ArrayList<zzblr> arrayList = new ArrayList<zzblr>();
        if (list == null) {
            return arrayList;
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            list = (NativeAd.Image)iterator.next();
            arrayList.add(new zzblr(list.getDrawable(), list.getUri(), list.getScale(), list.zza(), list.zzb()));
        }
        return arrayList;
    }

    public final String zzg() {
        return this.zza.getBody();
    }

    public final zzbmh zzh() {
        NativeAd.Image image = this.zza.getIcon();
        if (image == null) return null;
        return new zzblr(image.getDrawable(), image.getUri(), image.getScale(), image.zza(), image.zzb());
    }

    public final String zzi() {
        return this.zza.getCallToAction();
    }

    public final String zzj() {
        return this.zza.getAdvertiser();
    }

    public final double zzk() {
        if (this.zza.getStarRating() == null) return -1.0;
        return this.zza.getStarRating();
    }

    public final String zzl() {
        return this.zza.getStore();
    }

    public final String zzm() {
        return this.zza.getPrice();
    }

    public final zzbhc zzn() {
        if (this.zza.zzc() == null) return null;
        return this.zza.zzc().zzb();
    }

    public final zzblz zzo() {
        return null;
    }

    public final IObjectWrapper zzp() {
        View view = this.zza.getAdChoicesContent();
        if (view != null) return ObjectWrapper.wrap((Object)view);
        return null;
    }

    public final IObjectWrapper zzq() {
        View view = this.zza.zzd();
        if (view != null) return ObjectWrapper.wrap((Object)view);
        return null;
    }

    public final IObjectWrapper zzr() {
        Object object = this.zza.zze();
        if (object != null) return ObjectWrapper.wrap((Object)object);
        return null;
    }

    public final Bundle zzs() {
        return this.zza.getExtras();
    }

    public final boolean zzt() {
        return this.zza.getOverrideImpressionRecording();
    }

    public final boolean zzu() {
        return this.zza.getOverrideClickHandling();
    }

    public final void zzv() {
        this.zza.recordImpression();
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zza.handleClick((View)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper));
    }

    public final void zzx(IObjectWrapper iObjectWrapper, IObjectWrapper object, IObjectWrapper object2) {
        object = (HashMap)ObjectWrapper.unwrap((IObjectWrapper)object);
        object2 = (HashMap)ObjectWrapper.unwrap((IObjectWrapper)object2);
        this.zza.trackViews((View)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper), (Map)object, (Map)object2);
    }

    public final void zzy(IObjectWrapper iObjectWrapper) {
        this.zza.untrackView((View)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper));
    }

    public final float zzz() {
        return this.zza.getMediaContentAspectRatio();
    }
}
