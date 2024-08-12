/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzget
 *  com.google.android.gms.internal.ads.zzgex
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzget;
import com.google.android.gms.internal.ads.zzgex;
import java.io.OutputStream;
import java.util.ArrayList;

public final class zzgev
extends OutputStream {
    private static final byte[] zza = new byte[0];
    private final int zzb;
    private final ArrayList<zzgex> zzc = new ArrayList();
    private int zzd;
    private byte[] zze = new byte[128];
    private int zzf;

    zzgev(int n) {
        this.zzb = 128;
    }

    private final void zzc(int n) {
        int n2;
        this.zzc.add((zzgex)new zzget(this.zze));
        this.zzd = n2 = this.zzd + this.zze.length;
        this.zze = new byte[Math.max(this.zzb, Math.max(n, n2 >>> 1))];
        this.zzf = 0;
    }

    public final String toString() {
        return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), this.zzb());
    }

    @Override
    public final void write(int n) {
        synchronized (this) {
            if (this.zzf == this.zze.length) {
                this.zzc(1);
            }
            byte[] byArray = this.zze;
            int n2 = this.zzf;
            this.zzf = n2 + 1;
            byArray[n2] = (byte)n;
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    @Override
    public final void write(byte[] byArray, int n, int n2) {
        synchronized (this) {
            void var2_2;
            void var3_3;
            byte[] byArray2 = this.zze;
            int n3 = byArray2.length;
            int n4 = this.zzf;
            if (var3_3 <= (n3 -= n4)) {
                System.arraycopy(byArray, (int)var2_2, byArray2, n4, (int)var3_3);
                this.zzf += var3_3;
                return;
            }
            System.arraycopy(byArray, (int)var2_2, byArray2, n4, n3);
            this.zzc((int)(var3_3 -= n3));
            System.arraycopy(byArray, (int)(var2_2 + n3), this.zze, 0, (int)var3_3);
            this.zzf = var3_3;
            return;
        }
    }

    public final zzgex zza() {
        synchronized (this) {
            Object object;
            int n = this.zzf;
            Object object2 = this.zze;
            int n2 = ((byte[])object2).length;
            if (n < n2) {
                if (n > 0) {
                    object = new byte[n];
                    System.arraycopy(object2, 0, object, 0, Math.min(n2, n));
                    ArrayList<zzgex> arrayList = this.zzc;
                    object2 = new zzget;
                    object2((byte[])object);
                    arrayList.add((zzgex)object2);
                }
            } else {
                object = this.zzc;
                zzget zzget2 = new zzget(object2);
                ((ArrayList)object).add(zzget2);
                this.zze = zza;
            }
            this.zzd += this.zzf;
            this.zzf = 0;
            object = zzgex.zzx(this.zzc);
            return object;
        }
    }

    public final int zzb() {
        synchronized (this) {
            int n = this.zzd;
            int n2 = this.zzf;
            return n + n2;
        }
    }
}
