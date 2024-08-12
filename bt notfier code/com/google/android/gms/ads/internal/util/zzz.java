/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.view.WindowManager
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.util.zzx
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcgm
 */
package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.util.zzx;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcgm;

public class zzz
extends zzx {
    static final boolean zzp(int n, int n2, int n3) {
        if (Math.abs(n - n2) > n3) return false;
        return true;
    }

    public final boolean zzo(Activity activity, Configuration configuration) {
        zzbjd zzbjd2 = zzbjl.zzdk;
        boolean bl = (Boolean)zzbet.zzc().zzc(zzbjd2);
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        zzbjd2 = zzbjl.zzdm;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        zzber.zza();
        int n = zzcgm.zzs((Context)activity, (int)configuration.screenHeightDp);
        int n2 = zzcgm.zzs((Context)activity, (int)configuration.screenWidthDp);
        configuration = (WindowManager)activity.getApplicationContext().getSystemService("window");
        zzt.zzc();
        configuration = zzs.zzy((WindowManager)configuration);
        int n3 = configuration.heightPixels;
        int n4 = configuration.widthPixels;
        int n5 = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        n5 = n5 > 0 ? activity.getResources().getDimensionPixelSize(n5) : 0;
        double d = activity.getResources().getDisplayMetrics().density;
        Double.isNaN(d);
        long l = Math.round(d + 0.5);
        activity = zzbjl.zzdi;
        int n6 = (int)l * (Integer)zzbet.zzc().zzc((zzbjd)activity);
        if (zzz.zzp(n3, n + n5, n6)) {
            if (!zzz.zzp(n4, n2, n6)) return true;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}
