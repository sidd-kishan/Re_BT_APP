/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzanu
 *  com.google.android.gms.internal.ads.zzanv
 *  com.google.android.gms.internal.ads.zzanw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzanu;
import com.google.android.gms.internal.ads.zzanv;
import com.google.android.gms.internal.ads.zzanw;

public abstract class zzanx {
    public static final zzanx zza = new zzanu();

    public abstract int zza();

    public abstract zzanw zzb(int var1, zzanw var2, boolean var3, long var4);

    public abstract int zzc();

    public abstract zzanv zzd(int var1, zzanv var2, boolean var3);

    public abstract int zze(Object var1);

    public final boolean zzf() {
        if (this.zza() != 0) return false;
        return true;
    }

    public final zzanw zzg(int n, zzanw zzanw2, boolean bl) {
        return this.zzb(n, zzanw2, false, 0L);
    }

    public final int zzh(int n, zzanv zzanv2, zzanw zzanw2, int n2) {
        block6: {
            int n3;
            block4: {
                block5: {
                    this.zzd(n, zzanv2, false);
                    this.zzg(0, zzanw2, false);
                    n3 = 1;
                    if (n != 0) return n + 1;
                    if (n2 == 0) break block4;
                    if (n2 == 1) break block5;
                    if (n2 != 2) throw new IllegalStateException();
                    n = n3;
                    if (this.zza() - 1 != 0) break block6;
                }
                n = 0;
                break block6;
            }
            n = n3;
            if (this.zza() - 1 == 0) {
                n = -1;
            }
        }
        if (n == -1) {
            return -1;
        }
        this.zzg(n, zzanw2, false);
        return 0;
    }
}
