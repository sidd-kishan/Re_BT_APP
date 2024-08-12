/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageButton
 *  com.google.android.gms.ads.internal.overlay.zzp
 *  com.google.android.gms.ads.internal.overlay.zzz
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzcgm
 */
package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzcgm;

public final class zzq
extends FrameLayout
implements View.OnClickListener {
    private final ImageButton zza;
    private final zzz zzb;

    public zzq(Context context, zzp zzp2, zzz zzz2) {
        super(context);
        this.zzb = zzz2;
        this.setOnClickListener(this);
        zzz2 = new ImageButton(context);
        this.zza = zzz2;
        zzz2.setImageResource(17301527);
        this.zza.setBackgroundColor(0);
        this.zza.setOnClickListener((View.OnClickListener)this);
        zzz2 = this.zza;
        zzber.zza();
        int n = zzcgm.zzs((Context)context, (int)zzp2.zza);
        zzber.zza();
        int n2 = zzcgm.zzs((Context)context, (int)0);
        zzber.zza();
        int n3 = zzcgm.zzs((Context)context, (int)zzp2.zzb);
        zzber.zza();
        zzz2.setPadding(n, n2, n3, zzcgm.zzs((Context)context, (int)zzp2.zzc));
        this.zza.setContentDescription((CharSequence)"Interstitial close button");
        zzz2 = this.zza;
        zzber.zza();
        n = zzcgm.zzs((Context)context, (int)(zzp2.zzd + zzp2.zza + zzp2.zzb));
        zzber.zza();
        this.addView((View)zzz2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(n, zzcgm.zzs((Context)context, (int)(zzp2.zzd + zzp2.zzc)), 17));
    }

    public final void onClick(View view) {
        view = this.zzb;
        if (view == null) return;
        view.zzd();
    }

    public final void zza(boolean bl) {
        if (bl) {
            this.zza.setVisibility(8);
            return;
        }
        this.zza.setVisibility(0);
    }
}
