/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzakx
 *  com.google.android.gms.internal.ads.zzir
 *  com.google.android.gms.internal.ads.zzit
 *  com.google.android.gms.internal.ads.zziz
 */
package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzakx;
import com.google.android.gms.internal.ads.zzir;
import com.google.android.gms.internal.ads.zzit;
import com.google.android.gms.internal.ads.zziz;

final class zzja<V> {
    private int zza;
    private final SparseArray<V> zzb;
    private final zzakx<V> zzc;

    public zzja() {
        zzakx zzakx2 = zziz.zza;
        throw null;
    }

    public zzja(zzakx<V> zzakx2) {
        this.zzb = new SparseArray();
        this.zzc = zzakx2;
        this.zza = -1;
    }

    /*
     * Handled impossible loop by adding 'first' condition
     */
    public final V zza(int n) {
        boolean bl = true;
        while (true) {
            int n2;
            block4: {
                block3: {
                    if (!bl || (bl = false)) break block3;
                    if (this.zza != -1) break block4;
                    n2 = 0;
                }
                this.zza = n2;
            }
            n2 = this.zza;
            if (n2 <= 0 || n >= this.zzb.keyAt(n2)) break;
            n2 = this.zza - 1;
        }
        while (this.zza < this.zzb.size() - 1) {
            if (n < this.zzb.keyAt(this.zza + 1)) return (V)this.zzb.valueAt(this.zza);
            ++this.zza;
        }
        return (V)this.zzb.valueAt(this.zza);
    }

    public final void zzb(int n, V v) {
        boolean bl;
        int n2 = this.zza;
        boolean bl2 = true;
        if (n2 == -1) {
            bl = this.zzb.size() == 0;
            zzakt.zzd((boolean)bl);
            this.zza = 0;
        }
        if (this.zzb.size() > 0) {
            SparseArray<V> sparseArray = this.zzb;
            n2 = sparseArray.keyAt(sparseArray.size() - 1);
            bl = n >= n2 ? bl2 : false;
            zzakt.zza((boolean)bl);
            if (n2 == n) {
                sparseArray = this.zzb;
                zzit.zzw((zzir)((zzir)sparseArray.valueAt(sparseArray.size() - 1)));
            }
        }
        this.zzb.append(n, v);
    }

    public final V zzc() {
        SparseArray<V> sparseArray = this.zzb;
        return (V)sparseArray.valueAt(sparseArray.size() - 1);
    }

    public final void zzd(int n) {
        int n2 = 0;
        while (n2 < this.zzb.size() - 1) {
            int n3 = n2 + 1;
            if (n < this.zzb.keyAt(n3)) return;
            zzit.zzw((zzir)((zzir)this.zzb.valueAt(n2)));
            this.zzb.removeAt(n2);
            n2 = this.zza;
            if (n2 > 0) {
                this.zza = n2 - 1;
            }
            n2 = n3;
        }
    }

    public final void zze() {
        int n = 0;
        while (true) {
            if (n >= this.zzb.size()) {
                this.zza = -1;
                this.zzb.clear();
                return;
            }
            zzit.zzw((zzir)((zzir)this.zzb.valueAt(n)));
            ++n;
        }
    }

    public final boolean zzf() {
        if (this.zzb.size() != 0) return false;
        return true;
    }
}
