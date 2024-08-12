/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  com.google.android.gms.ads.VideoController
 *  com.google.android.gms.ads.formats.NativeAd$Image
 */
package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;
import java.util.Map;

public abstract class UnifiedNativeAdMapper {
    private String zza;
    private List<NativeAd.Image> zzb;
    private String zzc;
    private NativeAd.Image zzd;
    private String zze;
    private String zzf;
    private Double zzg;
    private String zzh;
    private String zzi;
    private VideoController zzj;
    private boolean zzk;
    private View zzl;
    private View zzm;
    private Object zzn;
    private Bundle zzo = new Bundle();
    private boolean zzp;
    private boolean zzq;
    private float zzr;

    public View getAdChoicesContent() {
        return this.zzl;
    }

    public final String getAdvertiser() {
        return this.zzf;
    }

    public final String getBody() {
        return this.zzc;
    }

    public final String getCallToAction() {
        return this.zze;
    }

    public float getCurrentTime() {
        return 0.0f;
    }

    public float getDuration() {
        return 0.0f;
    }

    public final Bundle getExtras() {
        return this.zzo;
    }

    public final String getHeadline() {
        return this.zza;
    }

    public final NativeAd.Image getIcon() {
        return this.zzd;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzb;
    }

    public float getMediaContentAspectRatio() {
        return this.zzr;
    }

    public final boolean getOverrideClickHandling() {
        return this.zzq;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzp;
    }

    public final String getPrice() {
        return this.zzi;
    }

    public final Double getStarRating() {
        return this.zzg;
    }

    public final String getStore() {
        return this.zzh;
    }

    public void handleClick(View view) {
    }

    public boolean hasVideoContent() {
        return this.zzk;
    }

    public void recordImpression() {
    }

    public void setAdChoicesContent(View view) {
        this.zzl = view;
    }

    public final void setAdvertiser(String string) {
        this.zzf = string;
    }

    public final void setBody(String string) {
        this.zzc = string;
    }

    public final void setCallToAction(String string) {
        this.zze = string;
    }

    public final void setExtras(Bundle bundle) {
        this.zzo = bundle;
    }

    public void setHasVideoContent(boolean bl) {
        this.zzk = bl;
    }

    public final void setHeadline(String string) {
        this.zza = string;
    }

    public final void setIcon(NativeAd.Image image) {
        this.zzd = image;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzb = list;
    }

    public void setMediaContentAspectRatio(float f) {
        this.zzr = f;
    }

    public void setMediaView(View view) {
        this.zzm = view;
    }

    public final void setOverrideClickHandling(boolean bl) {
        this.zzq = bl;
    }

    public final void setOverrideImpressionRecording(boolean bl) {
        this.zzp = bl;
    }

    public final void setPrice(String string) {
        this.zzi = string;
    }

    public final void setStarRating(Double d) {
        this.zzg = d;
    }

    public final void setStore(String string) {
        this.zzh = string;
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
    }

    public void untrackView(View view) {
    }

    public final void zza(VideoController videoController) {
        this.zzj = videoController;
    }

    public final void zzb(Object object) {
        this.zzn = object;
    }

    public final VideoController zzc() {
        return this.zzj;
    }

    public final View zzd() {
        return this.zzm;
    }

    public final Object zze() {
        return this.zzn;
    }
}
