/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaiv
 *  com.google.android.gms.internal.ads.zzaix
 *  com.google.android.gms.internal.ads.zzaju
 *  com.google.android.gms.internal.ads.zzajw
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaiv;
import com.google.android.gms.internal.ads.zzaix;
import com.google.android.gms.internal.ads.zzaju;
import com.google.android.gms.internal.ads.zzajw;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznv;
import java.io.EOFException;
import java.io.IOException;

public final class zzol {
    private final zzamf zza = new zzamf(10);

    public final zzaiv zza(zznv zznv2, zzaju zzaju2) throws IOException {
        Object object = null;
        int n = 0;
        while (true) {
            try {
                byte[] byArray = this.zza.zzi();
                ((zznp)zznv2).zzh(byArray, 0, 10, false);
            }
            catch (EOFException eOFException) {
                break;
            }
            this.zza.zzh(0);
            if (this.zza.zzr() != 0x494433) break;
            this.zza.zzk(3);
            int n2 = this.zza.zzA();
            int n3 = n2 + 10;
            if (object == null) {
                object = new byte[n3];
                System.arraycopy(this.zza.zzi(), 0, object, 0, 10);
                ((zznp)zznv2).zzh(object, 10, n2, false);
                object = zzajw.zza((byte[])object, (int)n3, (zzaju)zzaju2, (zzaix)new zzaix());
            } else {
                ((zznp)zznv2).zzj(n2, false);
            }
            n += n3;
        }
        zznv2.zzl();
        ((zznp)zznv2).zzj(n, false);
        return object;
    }
}
