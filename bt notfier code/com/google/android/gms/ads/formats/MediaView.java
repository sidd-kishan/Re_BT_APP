/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.FrameLayout
 *  android.widget.ImageView$ScaleType
 *  com.google.android.gms.ads.MediaContent
 */
package com.google.android.gms.ads.formats;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;

@Deprecated
public class MediaView
extends FrameLayout {
    private MediaContent zza;
    private ImageView.ScaleType zzb;

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
        this.zzb = scaleType;
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.zza = mediaContent;
    }
}
