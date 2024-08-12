/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzws
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzws;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class zzwt {
    protected static final Comparator<byte[]> zza = new zzws();
    private final List<byte[]> zzb = new ArrayList<byte[]>();
    private final List<byte[]> zzc = new ArrayList<byte[]>(64);
    private int zzd = 0;

    public zzwt(int n) {
    }

    private final void zzc() {
        synchronized (this) {
            try {
                while (this.zzd > 4096) {
                    byte[] byArray = this.zzb.remove(0);
                    this.zzc.remove(byArray);
                    this.zzd -= byArray.length;
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final byte[] zza(int n) {
        synchronized (this) {
            byte[] byArray;
            for (int i = 0; i < this.zzc.size(); ++i) {
                byArray = this.zzc.get(i);
                int n2 = byArray.length;
                if (n2 < n) continue;
                this.zzd -= n2;
                this.zzc.remove(i);
                this.zzb.remove(byArray);
                return byArray;
            }
            {
                byArray = new byte[n];
                return byArray;
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzb(byte[] byArray) {
        synchronized (this) {
            int n;
            if (byArray == null) return;
            int n2 = byArray.length;
            if (n2 > 4096) {
                return;
            }
            this.zzb.add(byArray);
            int n3 = n = Collections.binarySearch(this.zzc, byArray, zza);
            if (n < 0) {
                n3 = -n - 1;
            }
            this.zzc.add(n3, byArray);
            this.zzd += n2;
            this.zzc();
            return;
        }
    }
}
