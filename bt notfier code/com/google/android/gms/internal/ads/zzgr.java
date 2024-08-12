/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zziw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zziw;

public final class zzgr
implements zziw {
    protected final zziw[] zza;

    public zzgr(zziw[] zziwArray) {
        this.zza = zziwArray;
    }

    public final void zzf(long l) {
        zziw[] zziwArray = this.zza;
        int n = zziwArray.length;
        int n2 = 0;
        while (n2 < n) {
            zziwArray[n2].zzf(l);
            ++n2;
        }
    }

    public final long zzh() {
        zziw[] zziwArray = this.zza;
        int n = zziwArray.length;
        int n2 = 0;
        long l = Long.MAX_VALUE;
        while (true) {
            if (n2 >= n) {
                if (l != Long.MAX_VALUE) return l;
                return Long.MIN_VALUE;
            }
            long l2 = zziwArray[n2].zzh();
            long l3 = l;
            if (l2 != Long.MIN_VALUE) {
                l3 = Math.min(l, l2);
            }
            ++n2;
            l = l3;
        }
    }

    public final long zzk() {
        zziw[] zziwArray = this.zza;
        int n = zziwArray.length;
        int n2 = 0;
        long l = Long.MAX_VALUE;
        while (true) {
            if (n2 >= n) {
                if (l != Long.MAX_VALUE) return l;
                return Long.MIN_VALUE;
            }
            long l2 = zziwArray[n2].zzk();
            long l3 = l;
            if (l2 != Long.MIN_VALUE) {
                l3 = Math.min(l, l2);
            }
            ++n2;
            l = l3;
        }
    }

    public final boolean zzl(long l) {
        long l2;
        boolean bl = false;
        while ((l2 = this.zzk()) != Long.MIN_VALUE) {
            boolean bl2;
            zziw[] zziwArray = this.zza;
            int n = zziwArray.length;
            boolean bl3 = false;
            for (int i = 0; i < n; ++i) {
                boolean bl4;
                block5: {
                    zziw zziw2;
                    block4: {
                        zziw2 = zziwArray[i];
                        long l3 = zziw2.zzk();
                        boolean bl5 = l3 != Long.MIN_VALUE && l3 <= l;
                        if (l3 == l2) break block4;
                        bl4 = bl3;
                        if (!bl5) break block5;
                    }
                    bl4 = bl3 | zziw2.zzl(l);
                }
                bl3 = bl4;
            }
            bl = bl2 = bl | bl3;
            if (bl3) continue;
            bl = bl2;
            break;
        }
        return bl;
    }

    public final boolean zzm() {
        zziw[] zziwArray = this.zza;
        int n = zziwArray.length;
        int n2 = 0;
        while (n2 < n) {
            if (zziwArray[n2].zzm()) {
                return true;
            }
            ++n2;
        }
        return false;
    }
}
