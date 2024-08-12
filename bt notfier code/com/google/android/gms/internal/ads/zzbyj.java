/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.PopupWindow
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.util.CollectionUtils
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbyi
 *  com.google.android.gms.internal.ads.zzbyp
 *  com.google.android.gms.internal.ads.zzbyq
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcob
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbyi;
import com.google.android.gms.internal.ads.zzbyp;
import com.google.android.gms.internal.ads.zzbyq;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcob;
import java.util.Map;
import java.util.Set;

public final class zzbyj
extends zzbyp {
    static final Set<String> zza = CollectionUtils.setOf((Object[])new String[]{"top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center"});
    private String zzb = "top-right";
    private boolean zzc = true;
    private int zzd = 0;
    private int zze = 0;
    private int zzf = -1;
    private int zzg = 0;
    private int zzh = 0;
    private int zzi = -1;
    private final Object zzj = new Object();
    private final zzcml zzk;
    private final Activity zzl;
    private zzcob zzm;
    private ImageView zzn;
    private LinearLayout zzo;
    private final zzbyq zzp;
    private PopupWindow zzq;
    private RelativeLayout zzr;
    private ViewGroup zzs;

    public zzbyj(zzcml zzcml2, zzbyq zzbyq2) {
        super(zzcml2, "resize");
        this.zzk = zzcml2;
        this.zzl = zzcml2.zzj();
        this.zzp = zzbyq2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zza(Map<String, String> var1_1) {
        var7_5 = this.zzj;
        synchronized (var7_5) {
            try {
                if (this.zzl == null) {
                    this.zzf("Not an activity context. Cannot resize.");
                    return;
                }
                if (this.zzk.zzP() == null) {
                    this.zzf("Webview is not yet available, size is not set.");
                    return;
                }
                if (this.zzk.zzP().zzg()) {
                    this.zzf("Is interstitial. Cannot resize an interstitial.");
                    return;
                }
                if (this.zzk.zzW()) ** GOTO lbl320
                if (!TextUtils.isEmpty((CharSequence)var1_1.get("width"))) {
                    zzt.zzc();
                    this.zzi = com.google.android.gms.ads.internal.util.zzs.zzQ((String)var1_1.get("width"));
                }
                if (!TextUtils.isEmpty((CharSequence)var1_1.get("height"))) {
                    zzt.zzc();
                    this.zzf = com.google.android.gms.ads.internal.util.zzs.zzQ((String)var1_1.get("height"));
                }
                if (!TextUtils.isEmpty((CharSequence)var1_1.get("offsetX"))) {
                    zzt.zzc();
                    this.zzg = com.google.android.gms.ads.internal.util.zzs.zzQ((String)var1_1.get("offsetX"));
                }
                if (!TextUtils.isEmpty((CharSequence)var1_1.get("offsetY"))) {
                    zzt.zzc();
                    this.zzh = com.google.android.gms.ads.internal.util.zzs.zzQ((String)var1_1.get("offsetY"));
                }
                if (!TextUtils.isEmpty((CharSequence)var1_1.get("allowOffscreen"))) {
                    this.zzc = Boolean.parseBoolean(var1_1.get("allowOffscreen"));
                }
                if (!TextUtils.isEmpty((CharSequence)(var1_1 = var1_1.get("customClosePosition")))) {
                    this.zzb = var1_1;
                }
                if (this.zzi < 0 || this.zzf < 0) ** GOTO lbl318
                var8_6 = this.zzl.getWindow();
                if (var8_6 == null || var8_6.getDecorView() == null) ** GOTO lbl316
                zzt.zzc();
                var9_7 /* !! */  = com.google.android.gms.ads.internal.util.zzs.zzY((Activity)this.zzl);
                zzt.zzc();
                var1_1 = com.google.android.gms.ads.internal.util.zzs.zzV((Activity)this.zzl);
                ** GOTO lbl46
            }
            catch (Throwable var1_4) {
                block50: {
                    block55: {
                        block49: {
                            block48: {
                                block52: {
lbl46:
                                    // 1 sources

                                    var4_8 = var9_7 /* !! */ [0];
                                    var2_9 /* !! */  = var9_7 /* !! */ [1];
                                    {
                                        block51: {
                                            var3_10 /* !! */  = this.zzi;
                                            if (var3_10 /* !! */  < 50 || var3_10 /* !! */  > var4_8) ** GOTO lbl158
                                            var5_11 /* !! */  = this.zzf;
                                            if (var5_11 /* !! */  < 50 || var5_11 /* !! */  > var2_9 /* !! */ ) ** GOTO lbl-1000
                                            if (var5_11 /* !! */  != var2_9 /* !! */  || var3_10 /* !! */  != var4_8) break block51;
                                            com.google.android.gms.ads.internal.util.zze.zzi((String)"Cannot resize to a full-screen ad.");
                                            ** GOTO lbl159
                                        }
                                        if (!this.zzc) ** GOTO lbl128
                                        var9_7 /* !! */  = (int[])this.zzb;
                                        var2_9 /* !! */  = var9_7 /* !! */ .hashCode();
                                    }
                                    switch (var2_9 /* !! */ ) {
                                        default: {
                                            break;
                                        }
                                        case 1755462605: {
                                            if (!var9_7 /* !! */ .equals("top-center")) break;
                                            var2_9 /* !! */  = 1;
                                            break block52;
                                        }
                                        case 1288627767: {
                                            if (!var9_7 /* !! */ .equals("bottom-center")) break;
                                            var2_9 /* !! */  = 4;
                                            break block52;
                                        }
                                        case 1163912186: {
                                            if (!var9_7 /* !! */ .equals("bottom-right")) break;
                                            var2_9 /* !! */  = 5;
                                            break block52;
                                        }
                                        case -655373719: {
                                            if (!var9_7 /* !! */ .equals("bottom-left")) break;
                                            var2_9 /* !! */  = 3;
                                            break block52;
                                        }
                                        case -1012429441: {
                                            if (!var9_7 /* !! */ .equals("top-left")) break;
                                            var2_9 /* !! */  = 0;
                                            break block52;
                                        }
                                        case -1364013995: {
                                            if (!var9_7 /* !! */ .equals("center")) break;
                                            var2_9 /* !! */  = 2;
                                            break block52;
                                        }
                                    }
                                    var2_9 /* !! */  = -1;
                                }
                                if (var2_9 /* !! */  == 0) ** GOTO lbl119
                                if (var2_9 /* !! */  == 1) ** GOTO lbl113
                                if (var2_9 /* !! */  == 2) ** GOTO lbl-1000
                                if (var2_9 /* !! */  == 3) ** GOTO lbl107
                                if (var2_9 /* !! */  == 4) ** GOTO lbl100
                                if (var2_9 /* !! */  == 5) ** GOTO lbl97
                                {
                                    block53: {
                                        var2_9 /* !! */  = this.zzd + this.zzg + var3_10 /* !! */  - 50;
                                        var3_10 /* !! */  = this.zze;
                                        ** GOTO lbl115
lbl97:
                                        // 1 sources

                                        var2_9 /* !! */  = this.zzd + this.zzg + var3_10 /* !! */  - 50;
                                        var3_10 /* !! */  = this.zze;
                                        break block53;
lbl100:
                                        // 1 sources

                                        var2_9 /* !! */  = this.zzd + this.zzg + (var3_10 /* !! */  >> 1) - 25;
                                        var3_10 /* !! */  = this.zze;
                                    }
lbl103:
                                    // 2 sources

                                    while (true) {
                                        var6_12 = this.zzh;
                                        var3_10 /* !! */  = var3_10 /* !! */  + var6_12 + var5_11 /* !! */  - 50;
                                        break block48;
                                        break;
                                    }
lbl107:
                                    // 1 sources

                                    var2_9 /* !! */  = this.zzd + this.zzg;
                                    var3_10 /* !! */  = this.zze;
                                    ** continue;
                                }
lbl-1000:
                                // 1 sources

                                {
                                    var2_9 /* !! */  = this.zzd + this.zzg + (var3_10 /* !! */  >> 1) - 25;
                                    var3_10 /* !! */  = this.zze + this.zzh + (var5_11 /* !! */  >> 1) - 25;
                                    break block48;
lbl113:
                                    // 1 sources

                                    var2_9 /* !! */  = this.zzd + this.zzg + (var3_10 /* !! */  >> 1) - 25;
                                    var3_10 /* !! */  = this.zze;
lbl115:
                                    // 3 sources

                                    while (true) {
                                        var5_11 /* !! */  = this.zzh;
                                        var3_10 /* !! */  += var5_11 /* !! */ ;
                                        break block48;
                                        break;
                                    }
lbl119:
                                    // 1 sources

                                    var2_9 /* !! */  = this.zzd + this.zzg;
                                    var3_10 /* !! */  = this.zze;
                                    ** continue;
                                }
                            }
                            if (var2_9 /* !! */  < 0 || var2_9 /* !! */  + 50 > var4_8 || var3_10 /* !! */  < var1_1[0] || var3_10 /* !! */  + 50 > var1_1[1]) ** GOTO lbl159
                            {
                                var1_1 = new int[2];
                                var1_1[0] = this.zzd + this.zzg;
                                var1_1[1] = this.zze + this.zzh;
                                ** GOTO lbl161
lbl128:
                                // 1 sources

                                zzt.zzc();
                                var1_1 = com.google.android.gms.ads.internal.util.zzs.zzY((Activity)this.zzl);
                                zzt.zzc();
                                var9_7 /* !! */  = com.google.android.gms.ads.internal.util.zzs.zzV((Activity)this.zzl);
                            }
                            var5_11 /* !! */  = (int)var1_1[0];
                            {
                                var3_10 /* !! */  = this.zzd + this.zzg;
                                var4_8 = this.zze + this.zzh;
                                if (var3_10 /* !! */  < 0) {
                                    var2_9 /* !! */  = 0;
                                    break block49;
                                }
                                var6_13 = this.zzi;
                                var2_9 /* !! */  = var3_10 /* !! */ ;
                                if (var3_10 /* !! */  + var6_13 <= var5_11 /* !! */ ) break block49;
                                var2_9 /* !! */  = var5_11 /* !! */  - var6_13;
                            }
                        }
                        var3_10 /* !! */  = var9_7 /* !! */ [0];
                        if (var4_8 < var3_10 /* !! */ ) ** GOTO lbl-1000
                        {
                            var5_11 /* !! */  = this.zzf;
                        }
                        var6_13 = var9_7 /* !! */ [1];
                        var3_10 /* !! */  = var4_8;
                        if (var4_8 + var5_11 /* !! */  <= var6_13) ** GOTO lbl-1000
                        var3_10 /* !! */  = var6_13 - var5_11 /* !! */ ;
lbl-1000:
                        // 3 sources

                        {
                            var1_1 = new int[2];
                        }
                        var1_1[0] = var2_9 /* !! */ ;
                        var1_1[1] = var3_10 /* !! */ ;
                        ** GOTO lbl161
lbl-1000:
                        // 1 sources

                        {
                            block54: {
                                com.google.android.gms.ads.internal.util.zze.zzi((String)"Height is too small or too large.");
                                break block54;
lbl158:
                                // 1 sources

                                com.google.android.gms.ads.internal.util.zze.zzi((String)"Width is too small or too large.");
                            }
                            var1_1 = null;
lbl161:
                            // 3 sources

                            if (var1_1 == null) {
                                this.zzf("Resize location out of screen or close button is not visible.");
                                return;
                            }
                            zzber.zza();
                            var4_8 = zzcgm.zzs((Context)this.zzl, (int)this.zzi);
                            zzber.zza();
                            var3_10 /* !! */  = zzcgm.zzs((Context)this.zzl, (int)this.zzf);
                            var9_7 /* !! */  = ((View)this.zzk).getParent();
                            if (var9_7 /* !! */  == null || !(var9_7 /* !! */  instanceof ViewGroup)) break block50;
                            var9_7 /* !! */  = (int[])((ViewGroup)var9_7 /* !! */ );
                            var9_7 /* !! */ .removeView((View)this.zzk);
                            var10_14 = this.zzq;
                            if (var10_14 == null) {
                                this.zzs = (ViewGroup)var9_7 /* !! */ ;
                                zzt.zzc();
                                var10_14 = this.zzk;
                                ((View)var10_14).setDrawingCacheEnabled(true);
                                var9_7 /* !! */  = (int[])Bitmap.createBitmap((Bitmap)((View)var10_14).getDrawingCache());
                                ((View)var10_14).setDrawingCacheEnabled(false);
                                var10_14 = new ImageView((Context)this.zzl);
                                this.zzn = var10_14;
                                var10_14.setImageBitmap((Bitmap)var9_7 /* !! */ );
                                this.zzm = this.zzk.zzP();
                                this.zzs.addView((View)this.zzn);
                            } else {
                                var10_14.dismiss();
                            }
                            var9_7 /* !! */  = (int[])new RelativeLayout;
                            var9_7 /* !! */ ((Context)this.zzl);
                            this.zzr = (RelativeLayout)var9_7 /* !! */ ;
                            var9_7 /* !! */ .setBackgroundColor(0);
                            var10_14 = this.zzr;
                            var9_7 /* !! */  = (int[])new ViewGroup.LayoutParams;
                            var9_7 /* !! */ (var4_8, var3_10 /* !! */ );
                            var10_14.setLayoutParams((ViewGroup.LayoutParams)var9_7 /* !! */ );
                            zzt.zzc();
                            var10_14 = this.zzr;
                            var9_7 /* !! */  = (int[])new PopupWindow;
                            var9_7 /* !! */ ((View)var10_14, var4_8, var3_10 /* !! */ , false);
                            this.zzq = (PopupWindow)var9_7 /* !! */ ;
                            var9_7 /* !! */ .setOutsideTouchable(false);
                            this.zzq.setTouchable(true);
                            this.zzq.setClippingEnabled(this.zzc ^ true);
                            this.zzr.addView((View)this.zzk, -1, -1);
                            var9_7 /* !! */  = (int[])new LinearLayout;
                            var9_7 /* !! */ ((Context)this.zzl);
                            this.zzo = (LinearLayout)var9_7 /* !! */ ;
                            var9_7 /* !! */  = (int[])new RelativeLayout.LayoutParams;
                            zzber.zza();
                            var2_9 /* !! */  = zzcgm.zzs((Context)this.zzl, (int)50);
                            zzber.zza();
                            var9_7 /* !! */ (var2_9 /* !! */ , zzcgm.zzs((Context)this.zzl, (int)50));
                            var10_14 = this.zzb;
                            var2_9 /* !! */  = var10_14.hashCode();
                        }
                        switch (var2_9 /* !! */ ) {
                            default: {
                                break;
                            }
                            case 1755462605: {
                                if (!var10_14.equals("top-center")) break;
                                var2_9 /* !! */  = 1;
                                break block55;
                            }
                            case 1288627767: {
                                if (!var10_14.equals("bottom-center")) break;
                                var2_9 /* !! */  = 4;
                                break block55;
                            }
                            case 1163912186: {
                                if (!var10_14.equals("bottom-right")) break;
                                var2_9 /* !! */  = 5;
                                break block55;
                            }
                            case -655373719: {
                                if (!var10_14.equals("bottom-left")) break;
                                var2_9 /* !! */  = 3;
                                break block55;
                            }
                            case -1012429441: {
                                if (!var10_14.equals("top-left")) break;
                                var2_9 /* !! */  = 0;
                                break block55;
                            }
                            case -1364013995: {
                                if (!var10_14.equals("center")) break;
                                var2_9 /* !! */  = 2;
                                break block55;
                            }
                        }
                        var2_9 /* !! */  = -1;
                    }
                    if (var2_9 /* !! */  == 0) ** GOTO lbl272
                    if (var2_9 /* !! */  == 1) ** GOTO lbl269
                    if (var2_9 /* !! */  == 2) ** GOTO lbl267
                    if (var2_9 /* !! */  == 3) ** GOTO lbl264
                    if (var2_9 /* !! */  == 4) ** GOTO lbl261
                    if (var2_9 /* !! */  == 5) ** GOTO lbl258
                    {
                        block56: {
                            var9_7 /* !! */ .addRule(10);
                            var9_7 /* !! */ .addRule(11);
                            break block56;
lbl258:
                            // 1 sources

                            var9_7 /* !! */ .addRule(12);
                            var9_7 /* !! */ .addRule(11);
                            break block56;
lbl261:
                            // 1 sources

                            var9_7 /* !! */ .addRule(12);
                            var9_7 /* !! */ .addRule(14);
                            break block56;
lbl264:
                            // 1 sources

                            var9_7 /* !! */ .addRule(12);
                            var9_7 /* !! */ .addRule(9);
                            break block56;
lbl267:
                            // 1 sources

                            var9_7 /* !! */ .addRule(13);
                            break block56;
lbl269:
                            // 1 sources

                            var9_7 /* !! */ .addRule(10);
                            var9_7 /* !! */ .addRule(14);
                            break block56;
lbl272:
                            // 1 sources

                            var9_7 /* !! */ .addRule(10);
                            var9_7 /* !! */ .addRule(9);
                        }
                        var10_14 = this.zzo;
                        var11_15 = new zzbyi(this);
                        var10_14.setOnClickListener((View.OnClickListener)var11_15);
                        this.zzo.setContentDescription((CharSequence)"Close button");
                        this.zzr.addView((View)this.zzo, (ViewGroup.LayoutParams)var9_7 /* !! */ );
                        try {
                            var9_7 /* !! */  = (int[])this.zzq;
                            var8_6 = var8_6.getDecorView();
                            zzber.zza();
                            var2_9 /* !! */  = zzcgm.zzs((Context)this.zzl, (int)var1_1[0]);
                            zzber.zza();
                            var9_7 /* !! */ .showAtLocation((View)var8_6, 0, var2_9 /* !! */ , zzcgm.zzs((Context)this.zzl, (int)var1_1[1]));
                        }
                        catch (RuntimeException var1_2) {
                            var1_3 = String.valueOf(var1_2.getMessage());
                            var1_3 = var1_3.length() != 0 ? "Cannot show popup window: ".concat(var1_3) : new String("Cannot show popup window: ");
                            this.zzf(var1_3);
                            this.zzr.removeView((View)this.zzk);
                            var1_3 = this.zzs;
                            if (var1_3 == null) return;
                            var1_3.removeView((View)this.zzn);
                            this.zzs.addView((View)this.zzk);
                            this.zzk.zzaf(this.zzm);
                            return;
                        }
                        var2_9 /* !! */  = (int)var1_1[0];
                        var5_11 /* !! */  = (int)var1_1[1];
                        {
                            var8_6 = this.zzp;
                            if (var8_6 != null) {
                                var8_6.zza(var2_9 /* !! */ , var5_11 /* !! */ , this.zzi, this.zzf);
                            }
                            this.zzk.zzaf(zzcob.zzc((int)var4_8, (int)var3_10 /* !! */ ));
                        }
                        var2_9 /* !! */  = (int)var1_1[0];
                        var3_10 /* !! */  = (int)var1_1[1];
                        zzt.zzc();
                        this.zzh(var2_9 /* !! */ , var3_10 /* !! */  - com.google.android.gms.ads.internal.util.zzs.zzV((Activity)this.zzl)[0], this.zzi, this.zzf);
                        this.zzj("resized");
                        return;
                    }
                }
                this.zzf("Webview is detached, probably in the middle of a resize or expand.");
                return;
lbl316:
                // 1 sources

                this.zzf("Activity context is not ready, cannot get window or decor view.");
                return;
lbl318:
                // 1 sources

                this.zzf("Invalid width and height options. Cannot resize.");
                return;
lbl320:
                // 1 sources

                this.zzf("Cannot resize an expanded banner.");
                return;
                throw var1_4;
            }
        }
    }

    public final void zzb(boolean bl) {
        Object object = this.zzj;
        synchronized (object) {
            PopupWindow popupWindow = this.zzq;
            if (popupWindow == null) return;
            popupWindow.dismiss();
            this.zzr.removeView((View)this.zzk);
            popupWindow = this.zzs;
            if (popupWindow != null) {
                popupWindow.removeView((View)this.zzn);
                this.zzs.addView((View)this.zzk);
                this.zzk.zzaf(this.zzm);
            }
            if (bl) {
                this.zzj("default");
                popupWindow = this.zzp;
                if (popupWindow != null) {
                    popupWindow.zzb();
                }
            }
            this.zzq = null;
            this.zzr = null;
            this.zzs = null;
            this.zzo = null;
            return;
        }
    }

    public final void zzc(int n, int n2, boolean bl) {
        Object object = this.zzj;
        synchronized (object) {
            this.zzd = n;
            this.zze = n2;
            return;
        }
    }

    public final boolean zzd() {
        Object object = this.zzj;
        synchronized (object) {
            boolean bl = this.zzq != null;
            return bl;
        }
    }

    public final void zze(int n, int n2) {
        this.zzd = n;
        this.zze = n2;
    }
}
