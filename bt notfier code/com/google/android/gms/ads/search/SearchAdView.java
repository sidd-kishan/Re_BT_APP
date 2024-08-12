/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  com.google.android.gms.ads.AdListener
 *  com.google.android.gms.ads.AdSize
 *  com.google.android.gms.ads.search.DynamicHeightSearchAdRequest
 *  com.google.android.gms.ads.search.SearchAdRequest
 *  com.google.android.gms.internal.ads.zzbhl
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.ads.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.search.DynamicHeightSearchAdRequest;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.ads.zzbhl;
import com.google.android.gms.internal.ads.zzcgt;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class SearchAdView
extends ViewGroup {
    @NotOnlyInitialized
    private final zzbhl zza;

    public SearchAdView(Context context) {
        super(context);
        this.zza = new zzbhl((ViewGroup)this);
    }

    public SearchAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zza = new zzbhl((ViewGroup)this, attributeSet, false);
    }

    public SearchAdView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.zza = new zzbhl((ViewGroup)this, attributeSet, false);
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

    public void loadAd(DynamicHeightSearchAdRequest dynamicHeightSearchAdRequest) {
        if (!AdSize.SEARCH.equals((Object)this.getAdSize())) throw new IllegalStateException("You must use AdSize.SEARCH for a DynamicHeightSearchAdRequest");
        this.zza.zzh(dynamicHeightSearchAdRequest.zza());
    }

    public void loadAd(SearchAdRequest searchAdRequest) {
        this.zza.zzh(searchAdRequest.zza());
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
    }

    public void setAdSize(AdSize adSize) {
        this.zza.zzn(new AdSize[]{adSize});
    }

    public void setAdUnitId(String string) {
        this.zza.zzp(string);
    }
}
