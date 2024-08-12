/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  com.google.android.gms.ads.AdListener
 *  com.google.android.gms.ads.AdRequest
 *  com.google.android.gms.ads.AdSize
 *  com.google.android.gms.ads.OnPaidEventListener
 *  com.google.android.gms.ads.ResponseInfo
 *  com.google.android.gms.ads.admanager.AppEventListener
 *  com.google.android.gms.internal.ads.zzbcv
 *  com.google.android.gms.internal.ads.zzbhl
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbhl;
import com.google.android.gms.internal.ads.zzcgt;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public abstract class BaseAdView
extends ViewGroup {
    @NotOnlyInitialized
    protected final zzbhl zza;

    protected BaseAdView(Context context, int n) {
        super(context);
        this.zza = new zzbhl((ViewGroup)this, n);
    }

    protected BaseAdView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet);
        this.zza = new zzbhl((ViewGroup)this, attributeSet, false, n);
    }

    protected BaseAdView(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n);
        this.zza = new zzbhl((ViewGroup)this, attributeSet, false, n2);
    }

    protected BaseAdView(Context context, AttributeSet attributeSet, int n, int n2, boolean bl) {
        super(context, attributeSet, n);
        this.zza = new zzbhl((ViewGroup)this, attributeSet, bl, n2);
    }

    protected BaseAdView(Context context, AttributeSet attributeSet, boolean bl) {
        super(context, attributeSet);
        this.zza = new zzbhl((ViewGroup)this, attributeSet, bl);
    }

    public void destroy() {
        this.zza.zzb();
    }

    public AdListener getAdListener() {
        return this.zza.zzc();
    }

    public AdSize getAdSize() {
        return this.zza.zzd();
    }

    public String getAdUnitId() {
        return this.zza.zzf();
    }

    public OnPaidEventListener getOnPaidEventListener() {
        return this.zza.zzv();
    }

    public ResponseInfo getResponseInfo() {
        return this.zza.zzt();
    }

    public boolean isLoading() {
        return this.zza.zzs();
    }

    public void loadAd(AdRequest adRequest) {
        this.zza.zzh(adRequest.zza());
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        View view = this.getChildAt(0);
        if (view == null) return;
        if (view.getVisibility() == 8) return;
        int n5 = view.getMeasuredWidth();
        int n6 = view.getMeasuredHeight();
        n = (n3 - n - n5) / 2;
        n2 = (n4 - n2 - n6) / 2;
        view.layout(n, n2, n5 + n, n6 + n2);
    }

    protected void onMeasure(int n, int n2) {
        int n3;
        int n4 = 0;
        View view = this.getChildAt(0);
        if (view != null && view.getVisibility() != 8) {
            this.measureChild(view, n, n2);
            n4 = view.getMeasuredWidth();
            n3 = view.getMeasuredHeight();
        } else {
            try {
                view = this.getAdSize();
            }
            catch (NullPointerException nullPointerException) {
                zzcgt.zzg((String)"Unable to retrieve ad size.", (Throwable)nullPointerException);
                view = null;
            }
            if (view != null) {
                Context context = this.getContext();
                n4 = view.getWidthInPixels(context);
                n3 = view.getHeightInPixels(context);
            } else {
                n3 = 0;
            }
        }
        n4 = Math.max(n4, this.getSuggestedMinimumWidth());
        n3 = Math.max(n3, this.getSuggestedMinimumHeight());
        this.setMeasuredDimension(View.resolveSize((int)n4, (int)n), View.resolveSize((int)n3, (int)n2));
    }

    public void pause() {
        this.zza.zzi();
    }

    public void resume() {
        this.zza.zzk();
    }

    public void setAdListener(AdListener adListener) {
        this.zza.zzl(adListener);
        if (adListener == null) {
            this.zza.zzm(null);
            return;
        }
        if (adListener instanceof zzbcv) {
            this.zza.zzm((zzbcv)adListener);
        }
        if (!(adListener instanceof AppEventListener)) return;
        this.zza.zzq((AppEventListener)adListener);
    }

    public void setAdSize(AdSize adSize) {
        this.zza.zzn(new AdSize[]{adSize});
    }

    public void setAdUnitId(String string) {
        this.zza.zzp(string);
    }

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zza.zzu(onPaidEventListener);
    }
}
