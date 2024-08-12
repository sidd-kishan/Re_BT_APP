/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzzr
 *  com.google.android.gms.internal.ads.zzzs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzzr;
import com.google.android.gms.internal.ads.zzzs;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class zzzq
implements Runnable {
    private zzzq() {
    }

    /* synthetic */ zzzq(zzzr zzzr2) {
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public final void run() {
        try {
            zzzs.zza((MessageDigest)MessageDigest.getInstance("MD5"));
            var1_1 = zzzs.zzb;
lbl5:
            // 2 sources

            while (true) {
                var1_1.countDown();
                return;
            }
        }
        catch (Throwable var1_2) {
            zzzs.zzb.countDown();
            throw var1_2;
        }
        catch (NoSuchAlgorithmException var1_3) {
            var1_1 = zzzs.zzb;
            ** continue;
        }
    }
}
