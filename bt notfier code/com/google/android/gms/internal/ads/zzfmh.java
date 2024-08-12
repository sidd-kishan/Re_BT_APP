/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

public final class zzfmh
extends Enum<zzfmh> {
    public static final /* enum */ zzfmh zzA;
    public static final /* enum */ zzfmh zzB;
    private static final zzfmh[] zzD;
    public static final /* enum */ zzfmh zza;
    public static final /* enum */ zzfmh zzb;
    public static final /* enum */ zzfmh zzc;
    public static final /* enum */ zzfmh zzd;
    public static final /* enum */ zzfmh zze;
    public static final /* enum */ zzfmh zzf;
    public static final /* enum */ zzfmh zzg;
    public static final /* enum */ zzfmh zzh;
    public static final /* enum */ zzfmh zzi;
    public static final /* enum */ zzfmh zzj;
    public static final /* enum */ zzfmh zzk;
    public static final /* enum */ zzfmh zzl;
    public static final /* enum */ zzfmh zzm;
    public static final /* enum */ zzfmh zzn;
    public static final /* enum */ zzfmh zzo;
    public static final /* enum */ zzfmh zzp;
    public static final /* enum */ zzfmh zzq;
    public static final /* enum */ zzfmh zzr;
    @Deprecated
    public static final /* enum */ zzfmh zzs;
    public static final /* enum */ zzfmh zzt;
    public static final /* enum */ zzfmh zzu;
    public static final /* enum */ zzfmh zzv;
    public static final /* enum */ zzfmh zzw;
    public static final /* enum */ zzfmh zzx;
    public static final /* enum */ zzfmh zzy;
    public static final /* enum */ zzfmh zzz;
    private final String zzC;

    static {
        zzfmh zzfmh2;
        zza = new zzfmh("java.version");
        zzb = new zzfmh("java.vendor");
        zzc = new zzfmh("java.vendor.url");
        zzd = new zzfmh("java.home");
        zze = new zzfmh("java.vm.specification.version");
        zzf = new zzfmh("java.vm.specification.vendor");
        zzg = new zzfmh("java.vm.specification.name");
        zzh = new zzfmh("java.vm.version");
        zzi = new zzfmh("java.vm.vendor");
        zzj = new zzfmh("java.vm.name");
        zzk = new zzfmh("java.specification.version");
        zzl = new zzfmh("java.specification.vendor");
        zzm = new zzfmh("java.specification.name");
        zzn = new zzfmh("java.class.version");
        zzo = new zzfmh("java.class.path");
        zzp = new zzfmh("java.library.path");
        zzq = new zzfmh("java.io.tmpdir");
        zzr = new zzfmh("java.compiler");
        zzs = new zzfmh("java.ext.dirs");
        zzt = new zzfmh("os.name");
        zzu = new zzfmh("os.arch");
        zzv = new zzfmh("os.version");
        zzw = new zzfmh("file.separator");
        zzx = new zzfmh("path.separator");
        zzy = new zzfmh("line.separator");
        zzz = new zzfmh("user.name");
        zzA = new zzfmh("user.home");
        zzB = zzfmh2 = new zzfmh("user.dir");
        zzD = new zzfmh[]{zza, zzb, zzc, zzd, zze, zzf, zzg, zzh, zzi, zzj, zzk, zzl, zzm, zzn, zzo, zzp, zzq, zzr, zzs, zzt, zzu, zzv, zzw, zzx, zzy, zzz, zzA, zzfmh2};
    }

    private zzfmh(String string2) {
        this.zzC = string2;
    }

    public static zzfmh[] values() {
        return (zzfmh[])zzD.clone();
    }

    public final String toString() {
        String string = this.zzC;
        String string2 = System.getProperty(string);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 1 + String.valueOf(string2).length());
        stringBuilder.append(string);
        stringBuilder.append("=");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    @CheckForNull
    public final String zza() {
        return System.getProperty(this.zzC);
    }
}
