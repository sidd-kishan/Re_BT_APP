/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaoa
 *  com.google.android.gms.internal.ads.zzaob
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaoa;
import com.google.android.gms.internal.ads.zzaob;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class zzaou
implements zzaob {
    private int zzb = -1;
    private int zzc = -1;
    private int[] zzd;
    private boolean zze;
    private int[] zzf;
    private ByteBuffer zzg = zza;
    private ByteBuffer zzh = zza;
    private boolean zzi;

    public final boolean zza(int n, int n2, int n3) throws zzaoa {
        int n4 = Arrays.equals(this.zzd, this.zzf) ^ 1;
        Object object = this.zzd;
        this.zzf = object;
        if (object == null) {
            this.zze = false;
            return n4 != 0;
        }
        if (n3 != 2) {
            object = new zzaoa(n, n2, n3);
            throw object;
        }
        if (n4 == 0 && this.zzc == n) {
            if (this.zzb == n2) return false;
        }
        this.zzc = n;
        this.zzb = n2;
        n4 = n2 != ((int[])object).length ? 1 : 0;
        this.zze = n4;
        n3 = 0;
        while (n3 < ((int[])(object = this.zzf)).length) {
            int n5 = object[n3];
            if (n5 >= n2) throw new zzaoa(n, n2, 2);
            n4 = this.zze;
            n5 = n5 != n3 ? 1 : 0;
            this.zze = n5 | n4;
            ++n3;
        }
        return true;
    }

    public final boolean zzb() {
        return this.zze;
    }

    public final int zzc() {
        int[] nArray = this.zzf;
        int n = nArray == null ? this.zzb : nArray.length;
        return n;
    }

    public final int zzd() {
        return 2;
    }

    public final void zze(ByteBuffer byteBuffer) {
        int n = byteBuffer.position();
        int n2 = byteBuffer.limit();
        int n3 = this.zzb;
        n3 = (n2 - n) / (n3 + n3) * this.zzf.length;
        n3 += n3;
        if (this.zzg.capacity() < n3) {
            this.zzg = ByteBuffer.allocateDirect(n3).order(ByteOrder.nativeOrder());
        } else {
            this.zzg.clear();
        }
        while (true) {
            if (n >= n2) {
                byteBuffer.position(n2);
                this.zzg.flip();
                this.zzh = this.zzg;
                return;
            }
            for (int n4 : this.zzf) {
                this.zzg.putShort(byteBuffer.getShort(n4 + n4 + n));
            }
            n3 = this.zzb;
            n += n3 + n3;
        }
    }

    public final void zzf() {
        this.zzi = true;
    }

    public final ByteBuffer zzg() {
        ByteBuffer byteBuffer = this.zzh;
        this.zzh = zza;
        return byteBuffer;
    }

    public final boolean zzh() {
        if (!this.zzi) return false;
        if (this.zzh != zza) return false;
        return true;
    }

    public final void zzi() {
        this.zzh = zza;
        this.zzi = false;
    }

    public final void zzj() {
        this.zzi();
        this.zzg = zza;
        this.zzb = -1;
        this.zzc = -1;
        this.zzf = null;
        this.zze = false;
    }

    public final void zzk(int[] nArray) {
        this.zzd = nArray;
    }
}
