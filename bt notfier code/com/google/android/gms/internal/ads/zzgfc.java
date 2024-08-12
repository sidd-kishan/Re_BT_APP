/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgey
 *  com.google.android.gms.internal.ads.zzgfa
 *  com.google.android.gms.internal.ads.zzgfd
 *  com.google.android.gms.internal.ads.zzggm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgey;
import com.google.android.gms.internal.ads.zzgfa;
import com.google.android.gms.internal.ads.zzgfd;
import com.google.android.gms.internal.ads.zzggm;
import java.io.IOException;

public abstract class zzgfc {
    public static final int zzd = 0;
    private static volatile int zze = 100;
    int zza;
    final int zzb = zze;
    zzgfd zzc;

    /* synthetic */ zzgfc(zzgfa zzgfa2) {
    }

    static zzgfc zzF(byte[] object, int n, int n2, boolean bl) {
        object = new zzgey(object, n, n2, bl, null);
        try {
            object.zzz(n2);
            return object;
        }
        catch (zzggm zzggm2) {
            throw new IllegalArgumentException(zzggm2);
        }
    }

    public static int zzG(int n) {
        return -(n & 1) ^ n >>> 1;
    }

    public static long zzH(long l) {
        return -(l & 1L) ^ l >>> 1;
    }

    public abstract void zzA(int var1);

    public abstract boolean zzB() throws IOException;

    public abstract int zzC();

    public abstract int zza() throws IOException;

    public abstract void zzb(int var1) throws zzggm;

    public abstract boolean zzc(int var1) throws IOException;

    public abstract double zzd() throws IOException;

    public abstract float zze() throws IOException;

    public abstract long zzf() throws IOException;

    public abstract long zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract long zzi() throws IOException;

    public abstract int zzj() throws IOException;

    public abstract boolean zzk() throws IOException;

    public abstract String zzl() throws IOException;

    public abstract String zzm() throws IOException;

    public abstract zzgex zzn() throws IOException;

    public abstract int zzo() throws IOException;

    public abstract int zzp() throws IOException;

    public abstract int zzq() throws IOException;

    public abstract long zzr() throws IOException;

    public abstract int zzs() throws IOException;

    public abstract long zzt() throws IOException;

    public abstract int zzz(int var1) throws zzggm;
}
