/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfsx
 *  com.google.android.gms.internal.ads.zzfsy
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfsx;
import com.google.android.gms.internal.ads.zzfsy;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

final class zzfsv<V>
implements Runnable {
    @CheckForNull
    zzfsy<V> zza;

    zzfsv(zzfsy<V> zzfsy2) {
        this.zza = zzfsy2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public final void run() {
        block10: {
            var9_1 = this.zza;
            if (var9_1 == null) {
                return;
            }
            var8_2 = zzfsy.zza(var9_1);
            if (var8_2 == null) {
                return;
            }
            this.zza = null;
            if (var8_2.isDone()) {
                var9_1.zzr(var8_2);
                return;
            }
            var10_3 = zzfsy.zzb(var9_1);
            zzfsy.zzx(var9_1, null);
            var5_5 = var7_4 = "Timed out";
            if (var10_3 == null) break block10;
            var6_8 /* !! */  = var7_4;
            try {
                var3_9 = Math.abs(var10_3.getDelay(TimeUnit.MILLISECONDS));
                var5_5 = var7_4;
                if (var3_9 <= 10L) break block10;
                var6_8 /* !! */  = var7_4;
                var6_8 /* !! */  = var7_4;
                var5_5 = new StringBuilder(75);
                var6_8 /* !! */  = var7_4;
                var5_5.append("Timed out");
                var6_8 /* !! */  = var7_4;
                var5_5.append(" (timeout delayed by ");
                var6_8 /* !! */  = var7_4;
                var5_5.append(var3_9);
                var6_8 /* !! */  = var7_4;
                var5_5.append(" ms after scheduled time)");
                var6_8 /* !! */  = var7_4;
                var5_5 = var5_5.toString();
            }
            catch (Throwable var5_6) {
                ** GOTO lbl-1000
            }
        }
        var6_8 /* !! */  = var5_5;
        var10_3 = var8_2.toString();
        var6_8 /* !! */  = var5_5;
        var2_10 = var5_5.length();
        var6_8 /* !! */  = var5_5;
        var1_11 = var10_3.length();
        var6_8 /* !! */  = var5_5;
        var6_8 /* !! */  = var5_5;
        var7_4 = new StringBuilder(var2_10 + 2 + var1_11);
        var6_8 /* !! */  = var5_5;
        var7_4.append((String)var5_5);
        var6_8 /* !! */  = var5_5;
        var7_4.append(": ");
        var6_8 /* !! */  = var5_5;
        var7_4.append((String)var10_3);
        var6_8 /* !! */  = var5_5;
        var5_5 = var7_4.toString();
        ** try [egrp 2[TRYBLOCK] [18 : 293->314)] { 
lbl68:
        // 1 sources

        var6_8 /* !! */  = new zzfsx((String)var5_5, null);
        var9_1.zzq((Throwable)var6_8 /* !! */ );
        return;
lbl-1000:
        // 1 sources

        {
            var7_4 = new zzfsx(var6_8 /* !! */ , null);
            var9_1.zzq((Throwable)var7_4);
            throw var5_6;
        }
lbl76:
        // 1 sources

        finally {
            var8_2.cancel(true);
        }
    }
}
