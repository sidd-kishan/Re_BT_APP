/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.BaseAdView
 *  com.google.android.gms.ads.VideoController
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.common.internal.Preconditions;

public final class AdView
extends BaseAdView {
    public AdView(Context context) {
        super(context, 0);
        Preconditions.checkNotNull((Object)context, (Object)"Context cannot be null");
    }

    public AdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public AdView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n, 0);
    }

    public final VideoController zza() {
        return this.zza.zzw();
    }
}
