/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView$ScaleType
 *  com.google.android.gms.ads.MediaContent
 *  com.google.android.gms.ads.nativead.AdChoicesView
 *  com.google.android.gms.ads.nativead.MediaView
 *  com.google.android.gms.ads.nativead.NativeAd
 *  com.google.android.gms.ads.nativead.zzb
 *  com.google.android.gms.ads.nativead.zzc
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbhw
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbls
 *  com.google.android.gms.internal.ads.zzblu
 *  com.google.android.gms.internal.ads.zzbml
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.ads.nativead;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.nativead.AdChoicesView;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.zzb;
import com.google.android.gms.ads.nativead.zzc;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbhw;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbls;
import com.google.android.gms.internal.ads.zzblu;
import com.google.android.gms.internal.ads.zzbml;
import com.google.android.gms.internal.ads.zzcgt;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class NativeAdView
extends FrameLayout {
    @NotOnlyInitialized
    private final FrameLayout zza;
    @NotOnlyInitialized
    private final zzbml zzb;

    public NativeAdView(Context context) {
        super(context);
        this.zza = this.zze(context);
        this.zzb = this.zzf();
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zza = this.zze(context);
        this.zzb = this.zzf();
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.zza = this.zze(context);
        this.zzb = this.zzf();
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
        this.zza = this.zze(context);
        this.zzb = this.zzf();
    }

    private final void zzd(String string, View view) {
        zzbml zzbml2 = this.zzb;
        if (zzbml2 == null) return;
        try {
            zzbml2.zzb(string, ObjectWrapper.wrap((Object)view));
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Unable to call setAssetView on delegate", (Throwable)remoteException);
        }
    }

    private final FrameLayout zze(Context context) {
        context = new FrameLayout(context);
        context.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        this.addView((View)context);
        return context;
    }

    @RequiresNonNull(value={"overlayFrame"})
    private final zzbml zzf() {
        if (!this.isInEditMode()) return zzber.zzb().zzm(this.zza.getContext(), (FrameLayout)this, this.zza);
        return null;
    }

    public final void addView(View view, int n, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, n, layoutParams);
        super.bringChildToFront((View)this.zza);
    }

    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.zza;
        if (frameLayout == view) return;
        super.bringChildToFront((View)frameLayout);
    }

    public void destroy() {
        zzbml zzbml2 = this.zzb;
        if (zzbml2 == null) return;
        try {
            zzbml2.zze();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Unable to destroy native ad view", (Throwable)remoteException);
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        zzbjd zzbjd2 = zzbjl.zzbY;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return super.dispatchTouchEvent(motionEvent);
        zzbjd2 = this.zzb;
        if (zzbjd2 == null) return super.dispatchTouchEvent(motionEvent);
        try {
            zzbjd2.zzbv(ObjectWrapper.wrap((Object)motionEvent));
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Unable to call handleTouchEvent on delegate", (Throwable)remoteException);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public AdChoicesView getAdChoicesView() {
        View view = this.zza("3011");
        if (!(view instanceof AdChoicesView)) return null;
        return (AdChoicesView)view;
    }

    public final View getAdvertiserView() {
        return this.zza("3005");
    }

    public final View getBodyView() {
        return this.zza("3004");
    }

    public final View getCallToActionView() {
        return this.zza("3002");
    }

    public final View getHeadlineView() {
        return this.zza("3001");
    }

    public final View getIconView() {
        return this.zza("3003");
    }

    public final View getImageView() {
        return this.zza("3008");
    }

    public final MediaView getMediaView() {
        View view = this.zza("3010");
        if (view instanceof MediaView) {
            return (MediaView)view;
        }
        if (view == null) return null;
        zzcgt.zzd((String)"View is not an instance of MediaView");
        return null;
    }

    public final View getPriceView() {
        return this.zza("3007");
    }

    public final View getStarRatingView() {
        return this.zza("3009");
    }

    public final View getStoreView() {
        return this.zza("3006");
    }

    public final void onVisibilityChanged(View view, int n) {
        super.onVisibilityChanged(view, n);
        zzbml zzbml2 = this.zzb;
        if (zzbml2 == null) return;
        try {
            zzbml2.zzf(ObjectWrapper.wrap((Object)view), n);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Unable to call onVisibilityChanged on delegate", (Throwable)remoteException);
        }
    }

    public final void removeAllViews() {
        super.removeAllViews();
        super.addView((View)this.zza);
    }

    public final void removeView(View view) {
        if (this.zza == view) {
            return;
        }
        super.removeView(view);
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        this.zzd("3011", (View)adChoicesView);
    }

    public final void setAdvertiserView(View view) {
        this.zzd("3005", view);
    }

    public final void setBodyView(View view) {
        this.zzd("3004", view);
    }

    public final void setCallToActionView(View view) {
        this.zzd("3002", view);
    }

    public final void setClickConfirmingView(View view) {
        zzbml zzbml2 = this.zzb;
        if (zzbml2 == null) return;
        try {
            zzbml2.zzg(ObjectWrapper.wrap((Object)view));
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Unable to call setClickConfirmingView on delegate", (Throwable)remoteException);
        }
    }

    public final void setHeadlineView(View view) {
        this.zzd("3001", view);
    }

    public final void setIconView(View view) {
        this.zzd("3003", view);
    }

    public final void setImageView(View view) {
        this.zzd("3008", view);
    }

    public final void setMediaView(MediaView mediaView) {
        this.zzd("3010", (View)mediaView);
        if (mediaView == null) {
            return;
        }
        mediaView.zza((zzbls)new zzb(this));
        mediaView.zzb((zzblu)new zzc(this));
    }

    public void setNativeAd(NativeAd nativeAd) {
        zzbml zzbml2 = this.zzb;
        if (zzbml2 == null) return;
        try {
            zzbml2.zzd((IObjectWrapper)nativeAd.zza());
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Unable to call setNativeAd on delegate", (Throwable)remoteException);
        }
    }

    public final void setPriceView(View view) {
        this.zzd("3007", view);
    }

    public final void setStarRatingView(View view) {
        this.zzd("3009", view);
    }

    public final void setStoreView(View view) {
        this.zzd("3006", view);
    }

    protected final View zza(String string) {
        zzbml zzbml2 = this.zzb;
        if (zzbml2 == null) return null;
        try {
            string = zzbml2.zzc(string);
            if (string == null) return null;
            string = (View)ObjectWrapper.unwrap((IObjectWrapper)string);
            return string;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Unable to call getAssetView on delegate", (Throwable)remoteException);
        }
        return null;
    }

    final /* synthetic */ void zzb(ImageView.ScaleType scaleType) {
        zzbml zzbml2 = this.zzb;
        if (zzbml2 == null) {
            return;
        }
        if (scaleType == null) return;
        try {
            zzbml2.zzbu(ObjectWrapper.wrap((Object)scaleType));
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Unable to call setMediaViewImageScaleType on delegate", (Throwable)remoteException);
        }
    }

    final /* synthetic */ void zzc(MediaContent mediaContent) {
        zzbml zzbml2 = this.zzb;
        if (zzbml2 == null) {
            return;
        }
        try {
            if (mediaContent instanceof zzbhw) {
                zzbml2.zzbw(((zzbhw)mediaContent).zza());
                return;
            }
            if (mediaContent == null) {
                zzbml2.zzbw(null);
                return;
            }
            zzcgt.zzd((String)"Use MediaContent provided by NativeAd.getMediaContent");
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Unable to call setMediaContent on delegate", (Throwable)remoteException);
            return;
        }
    }
}
