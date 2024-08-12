/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzfem
extends Enum<zzfem> {
    public static final /* enum */ zzfem zza;
    public static final /* enum */ zzfem zzb;
    public static final /* enum */ zzfem zzc;
    public static final /* enum */ zzfem zzd;
    public static final /* enum */ zzfem zze;
    public static final /* enum */ zzfem zzf;
    public static final /* enum */ zzfem zzg;
    public static final /* enum */ zzfem zzh;
    public static final /* enum */ zzfem zzi;
    public static final /* enum */ zzfem zzj;
    public static final /* enum */ zzfem zzk;
    public static final /* enum */ zzfem zzl;
    public static final /* enum */ zzfem zzm;
    public static final /* enum */ zzfem zzn;
    public static final /* enum */ zzfem zzo;
    public static final /* enum */ zzfem zzp;
    public static final /* enum */ zzfem zzq;
    public static final /* enum */ zzfem zzr;
    public static final /* enum */ zzfem zzs;
    public static final /* enum */ zzfem zzt;
    public static final /* enum */ zzfem zzu;
    public static final /* enum */ zzfem zzv;
    public static final /* enum */ zzfem zzw;
    private static final zzfem[] zzy;
    private final String zzx;

    static {
        zzfem zzfem2;
        zza = new zzfem("signals");
        zzb = new zzfem("request-parcel");
        zzc = new zzfem("server-transaction");
        zzd = new zzfem("renderer");
        zze = new zzfem("gms-signals");
        zzf = new zzfem("ad_request");
        zzg = new zzfem("build-url");
        zzh = new zzfem("http");
        zzi = new zzfem("preprocess");
        zzj = new zzfem("get-signals");
        zzk = new zzfem("js-signals");
        zzl = new zzfem("render-config-init");
        zzm = new zzfem("render-config-waterfall");
        zzn = new zzfem("adapter-load-ad-syn");
        zzo = new zzfem("adapter-load-ad-ack");
        zzp = new zzfem("wrap-adapter");
        zzq = new zzfem("custom-render-syn");
        zzr = new zzfem("custom-render-ack");
        zzs = new zzfem("webview-cookie");
        zzt = new zzfem("generate-signals");
        zzu = new zzfem("get-cache-key");
        zzv = new zzfem("notify-cache-hit");
        zzw = zzfem2 = new zzfem("get-url-and-cache-key");
        zzy = new zzfem[]{zza, zzb, zzc, zzd, zze, zzf, zzg, zzh, zzi, zzj, zzk, zzl, zzm, zzn, zzo, zzp, zzq, zzr, zzs, zzt, zzu, zzv, zzfem2};
    }

    private zzfem(String string2) {
        this.zzx = string2;
    }

    public static zzfem[] values() {
        return (zzfem[])zzy.clone();
    }

    final String zza() {
        return this.zzx;
    }
}
