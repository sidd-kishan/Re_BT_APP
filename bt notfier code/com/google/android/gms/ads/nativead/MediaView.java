/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.FrameLayout
 *  android.widget.ImageView$ScaleType
 *  com.google.android.gms.ads.MediaContent
 *  com.google.android.gms.internal.ads.zzbls
 *  com.google.android.gms.internal.ads.zzblu
 */
package com.google.android.gms.ads.nativead;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.internal.ads.zzbls;
import com.google.android.gms.internal.ads.zzblu;

public class MediaView
extends FrameLayout {
    private MediaContent zza;
    private boolean zzb;
    private zzbls zzc;
    private ImageView.ScaleType zzd;
    private boolean zze;
    private zzblu zzf;

    public MediaView(Context context) {
        super(context);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    public MediaView(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
    }

    public void setImageScaleType(ImageView.ScaleType scaleType) {
        this.zze = true;
        this.zzd = scaleType;
        zzblu zzblu2 = this.zzf;
        if (zzblu2 == null) return;
        zzblu2.zza(scaleType);
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.zzb = true;
        this.zza = mediaContent;
        zzbls zzbls2 = this.zzc;
        if (zzbls2 == null) return;
        zzbls2.zza(mediaContent);
    }

    protected final void zza(zzbls zzbls2) {
        synchronized (this) {
            this.zzc = zzbls2;
            if (!this.zzb) return;
            zzbls2.zza(this.zza);
            return;
        }
    }

    protected final void zzb(zzblu zzblu2) {
        synchronized (this) {
            this.zzf = zzblu2;
            if (!this.zze) return;
            zzblu2.zza(this.zzd);
            return;
        }
    }
}
