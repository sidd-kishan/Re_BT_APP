/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.RemoteException
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  android.widget.RelativeLayout$LayoutParams
 *  com.google.android.gms.ads.formats.zza
 *  com.google.android.gms.ads.internal.util.zzca
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzblo
 *  com.google.android.gms.internal.ads.zzblp
 *  com.google.android.gms.internal.ads.zzblt
 *  com.google.android.gms.internal.ads.zzblv
 *  com.google.android.gms.internal.ads.zzcmw
 *  com.google.android.gms.internal.ads.zzdmj
 *  com.google.android.gms.internal.ads.zzdmm
 *  com.google.android.gms.internal.ads.zzdmr
 *  com.google.android.gms.internal.ads.zzdnh
 *  com.google.android.gms.internal.ads.zzdni
 *  com.google.android.gms.internal.ads.zzdnj
 *  com.google.android.gms.internal.ads.zzdnk
 *  com.google.android.gms.internal.ads.zzdnw
 *  com.google.android.gms.internal.ads.zzdoe
 *  com.google.android.gms.internal.ads.zzdog
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfar
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.formats.zza;
import com.google.android.gms.ads.internal.util.zzca;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzblo;
import com.google.android.gms.internal.ads.zzblp;
import com.google.android.gms.internal.ads.zzblt;
import com.google.android.gms.internal.ads.zzblv;
import com.google.android.gms.internal.ads.zzcmw;
import com.google.android.gms.internal.ads.zzdmj;
import com.google.android.gms.internal.ads.zzdmm;
import com.google.android.gms.internal.ads.zzdmr;
import com.google.android.gms.internal.ads.zzdnh;
import com.google.android.gms.internal.ads.zzdni;
import com.google.android.gms.internal.ads.zzdnj;
import com.google.android.gms.internal.ads.zzdnk;
import com.google.android.gms.internal.ads.zzdnw;
import com.google.android.gms.internal.ads.zzdoe;
import com.google.android.gms.internal.ads.zzdog;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfar;
import java.util.concurrent.Executor;

public final class zzdnl {
    private final zzg zza;
    private final zzfar zzb;
    private final zzdmr zzc;
    private final zzdmm zzd;
    private final zzdnw zze;
    private final zzdoe zzf;
    private final Executor zzg;
    private final Executor zzh;
    private final zzblv zzi;
    private final zzdmj zzj;

    public zzdnl(zzg zzg2, zzfar zzfar2, zzdmr zzdmr2, zzdmm zzdmm2, zzdnw zzdnw2, zzdoe zzdoe2, Executor executor, Executor executor2, zzdmj zzdmj2) {
        this.zza = zzg2;
        this.zzb = zzfar2;
        this.zzi = zzfar2.zzi;
        this.zzc = zzdmr2;
        this.zzd = zzdmm2;
        this.zze = zzdnw2;
        this.zzf = zzdoe2;
        this.zzg = executor;
        this.zzh = executor2;
        this.zzj = zzdmj2;
    }

    private static void zzg(RelativeLayout.LayoutParams layoutParams, int n) {
        if (n == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            return;
        }
        if (n == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            return;
        }
        if (n != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            return;
        }
        layoutParams.addRule(12);
        layoutParams.addRule(9);
    }

    private final boolean zzh(ViewGroup viewGroup, boolean bl) {
        View view = bl ? this.zzd.zzH() : this.zzd.zzI();
        if (view == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup)view.getParent()).removeView(view);
        }
        zzbjd zzbjd2 = zzbjl.zzco;
        zzbjd2 = (Boolean)zzbet.zzc().zzc(zzbjd2) != false ? new FrameLayout.LayoutParams(-1, -1, 17) : new FrameLayout.LayoutParams(-2, -2, 17);
        viewGroup.addView(view, (ViewGroup.LayoutParams)zzbjd2);
        return true;
    }

    public final void zza(zzdog zzdog2) {
        this.zzg.execute((Runnable)new zzdni(this, zzdog2));
    }

    public final void zzb(zzdog zzdog2) {
        if (zzdog2 == null) return;
        if (this.zze == null) return;
        if (zzdog2.zzbt() == null) return;
        if (!this.zzc.zzb()) {
            return;
        }
        try {
            zzdog2.zzbt().addView(this.zze.zza());
            return;
        }
        catch (zzcmw zzcmw2) {
            com.google.android.gms.ads.internal.util.zze.zzb((String)"web view can not be obtained", (Throwable)zzcmw2);
        }
    }

    public final void zzc(zzdog zzdog2) {
        if (zzdog2 == null) {
            return;
        }
        Context context = zzdog2.zzbx().getContext();
        if (!zzca.zzi((Context)context, (zzezz)this.zzc.zza)) {
            return;
        }
        if (!(context instanceof Activity)) {
            com.google.android.gms.ads.internal.util.zze.zzd((String)"Activity context is needed for policy validator.");
            return;
        }
        if (this.zzf == null) return;
        if (zzdog2.zzbt() == null) return;
        try {
            context = (WindowManager)context.getSystemService("window");
            zzdog2 = zzdog2.zzbt();
            context.addView(this.zzf.zza((View)zzdog2, (WindowManager)context), (ViewGroup.LayoutParams)zzca.zzj());
            return;
        }
        catch (zzcmw zzcmw2) {
            com.google.android.gms.ads.internal.util.zze.zzb((String)"web view can not be obtained", (Throwable)zzcmw2);
        }
    }

    public final boolean zzd(ViewGroup viewGroup) {
        return this.zzh(viewGroup, true);
    }

    final /* synthetic */ void zze(ViewGroup viewGroup) {
        boolean bl = viewGroup != null;
        if (this.zzd.zzH() == null) return;
        if (this.zzd.zzv() != 2 && this.zzd.zzv() != 1) {
            if (this.zzd.zzv() != 6) return;
            this.zza.zzw(this.zzb.zzf, "2", bl);
            this.zza.zzw(this.zzb.zzf, "1", bl);
            return;
        }
        this.zza.zzw(this.zzb.zzf, String.valueOf(this.zzd.zzv()), bl);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    final /* synthetic */ void zzf(zzdog var1_1) {
        block27: {
            block26: {
                var4_3 = this.zzc.zze();
                var7_4 = null;
                if (!var4_3 && !this.zzc.zzc()) {
                    while (true) {
                        var6_7 /* !! */  = null;
                        break;
                    }
                } else {
                    var2_5 = 0;
                    while (true) {
                        if (var2_5 >= 2) ** continue;
                        var5_6 = var1_1.zzm((new String[]{"1098", "3011"})[var2_5]);
                        if (var5_6 != null && var5_6 instanceof ViewGroup) {
                            var6_7 /* !! */  = (ViewGroup)var5_6;
                            break;
                        }
                        ++var2_5;
                    }
                }
                var8_8 = var1_1.zzbx().getContext();
                var9_9 = new RelativeLayout.LayoutParams(-2, -2);
                if (this.zzd.zzy() != null) {
                    var8_8 = this.zzd.zzy();
                    var10_10 = this.zzi;
                    if (var10_10 == null) {
                        var5_6 = var8_8;
                    } else {
                        var5_6 = var8_8;
                        if (var6_7 /* !! */  == null) {
                            zzdnl.zzg(var9_9, var10_10.zze);
                            var8_8.setLayoutParams((ViewGroup.LayoutParams)var9_9);
                            var5_6 = var8_8;
                        }
                    }
                } else if (!(this.zzd.zzx() instanceof zzblo)) {
                    var5_6 = null;
                } else {
                    var5_6 = (zzblo)this.zzd.zzx();
                    if (var6_7 /* !! */  == null) {
                        zzdnl.zzg(var9_9, var5_6.zzi());
                    }
                    var5_6 = new zzblp(var8_8, (zzblo)var5_6, var9_9);
                    var8_8 = zzbjl.zzcm;
                    var5_6.setContentDescription((CharSequence)zzbet.zzc().zzc((zzbjd)var8_8));
                }
                if (var5_6 != null) {
                    if (var5_6.getParent() instanceof ViewGroup) {
                        ((ViewGroup)var5_6.getParent()).removeView(var5_6);
                    }
                    if (var6_7 /* !! */  != null) {
                        var6_7 /* !! */ .removeAllViews();
                        var6_7 /* !! */ .addView(var5_6);
                    } else {
                        var6_7 /* !! */  = new zza(var1_1.zzbx().getContext());
                        var6_7 /* !! */ .setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
                        var6_7 /* !! */ .addView(var5_6);
                        var8_8 = var1_1.zzbt();
                        if (var8_8 != null) {
                            var8_8.addView((View)var6_7 /* !! */ );
                        }
                    }
                    var1_1.zzi(var1_1.zzn(), var5_6, true);
                }
                var6_7 /* !! */  = zzdnh.zza;
                var3_11 = var6_7 /* !! */ .size();
                for (var2_5 = 0; var2_5 < var3_11; ++var2_5) {
                    var5_6 = var1_1.zzm((String)var6_7 /* !! */ .get(var2_5));
                    if (!(var5_6 instanceof ViewGroup)) continue;
                    var5_6 = (ViewGroup)var5_6;
                    break block26;
                }
                var5_6 = null;
            }
            this.zzh.execute((Runnable)new zzdnj(this, (ViewGroup)var5_6));
            if (var5_6 == null) return;
            if (this.zzh((ViewGroup)var5_6, true)) {
                if (this.zzd.zzR() == null) return;
                this.zzd.zzR().zzap((zzblt)new zzdnk(var1_1, (ViewGroup)var5_6));
                return;
            }
            var6_7 /* !! */  = zzbjl.zzgO;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)var6_7 /* !! */ )).booleanValue() && this.zzh((ViewGroup)var5_6, false)) {
                if (this.zzd.zzS() == null) return;
                this.zzd.zzS().zzap((zzblt)new zzdnk(var1_1, (ViewGroup)var5_6));
                return;
            }
            var5_6.removeAllViews();
            var6_7 /* !! */  = var1_1.zzbx();
            var6_7 /* !! */  = var6_7 /* !! */  != null ? var6_7 /* !! */ .getContext() : null;
            if (var6_7 /* !! */  == null) return;
            var8_8 = this.zzj.zza();
            if (var8_8 == null) return;
            try {
                var8_8 = var8_8.zzg();
                if (var8_8 == null) return;
            }
            catch (RemoteException var1_2) {
                com.google.android.gms.ads.internal.util.zze.zzi((String)"Could not get main image drawable");
                break block27;
            }
            var9_9 = (Drawable)ObjectWrapper.unwrap((IObjectWrapper)var8_8);
            if (var9_9 == null) return;
            var8_8 = new ImageView((Context)var6_7 /* !! */ );
            var8_8.setImageDrawable((Drawable)var9_9);
            var6_7 /* !! */  = var7_4;
            if (var1_1 != null) {
                var6_7 /* !! */  = var1_1.zzo();
            }
            if (var6_7 /* !! */  == null) ** GOTO lbl-1000
            var1_1 = zzbjl.zzew;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)var1_1)).booleanValue()) {
                var8_8.setScaleType((ImageView.ScaleType)ObjectWrapper.unwrap((IObjectWrapper)var6_7 /* !! */ ));
            } else lbl-1000:
            // 2 sources

            {
                var8_8.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }
            var8_8.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
            var5_6.addView((View)var8_8);
            return;
        }
    }
}
