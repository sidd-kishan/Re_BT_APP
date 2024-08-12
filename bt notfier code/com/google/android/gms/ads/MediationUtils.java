/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.AdSize
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 */
package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import java.util.List;

public class MediationUtils {
    protected static final double MIN_HEIGHT_RATIO = 0.7;
    protected static final double MIN_WIDTH_RATIO = 0.5;

    public static AdSize findClosestSize(Context context, AdSize adSize, List<AdSize> object) {
        AdSize adSize2 = null;
        Object var12_4 = null;
        AdSize adSize3 = adSize2;
        if (object == null) return adSize3;
        if (adSize == null) {
            adSize3 = adSize2;
            return adSize3;
        }
        adSize2 = adSize;
        if (!adSize.zzb()) {
            adSize2 = adSize;
            if (!adSize.zzf()) {
                float f = context.getResources().getDisplayMetrics().density;
                adSize2 = new AdSize(Math.round((float)adSize.getWidthInPixels(context) / f), Math.round((float)adSize.getHeightInPixels(context) / f));
            }
        }
        object = object.iterator();
        context = var12_4;
        while (true) {
            adSize3 = context;
            if (!object.hasNext()) return adSize3;
            adSize = (AdSize)object.next();
            if (adSize == null) continue;
            int n = adSize2.getWidth();
            int n2 = adSize.getWidth();
            int n3 = adSize2.getHeight();
            int n4 = adSize.getHeight();
            double d = n;
            Double.isNaN(d);
            if (d * 0.5 > (double)n2 || n < n2) continue;
            if (adSize2.zzf()) {
                n3 = adSize2.zzh();
                adSize3 = zzbjl.zzfD;
                if ((Integer)zzbet.zzc().zzc((zzbjd)adSize3) > n2) continue;
                adSize3 = zzbjl.zzfE;
                if ((Integer)zzbet.zzc().zzc((zzbjd)adSize3) > n4 || n3 < n4) continue;
            } else if (adSize2.zzb()) {
                if (adSize2.zze() < n4) continue;
            } else {
                d = n3;
                Double.isNaN(d);
                if (d * 0.7 > (double)n4 || n3 < n4) continue;
            }
            if (context != null && context.getWidth() * context.getHeight() > adSize.getWidth() * adSize.getHeight()) continue;
            context = adSize;
        }
    }
}
