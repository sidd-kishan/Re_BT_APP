/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcir
 *  com.google.android.gms.internal.ads.zzcis
 *  com.google.android.gms.internal.ads.zzcja
 *  com.google.android.gms.internal.ads.zzcjb
 *  com.google.android.gms.internal.ads.zzcki
 *  com.google.android.gms.internal.ads.zzcks
 *  com.google.android.gms.internal.ads.zzcla
 *  com.google.android.gms.internal.ads.zzclh
 *  com.google.android.gms.internal.ads.zzcli
 *  com.google.android.gms.internal.ads.zzcmb
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcir;
import com.google.android.gms.internal.ads.zzcis;
import com.google.android.gms.internal.ads.zzcja;
import com.google.android.gms.internal.ads.zzcjb;
import com.google.android.gms.internal.ads.zzcki;
import com.google.android.gms.internal.ads.zzcks;
import com.google.android.gms.internal.ads.zzcla;
import com.google.android.gms.internal.ads.zzclh;
import com.google.android.gms.internal.ads.zzcli;
import com.google.android.gms.internal.ads.zzcmb;
import java.io.IOException;

public final class zzclj
extends zzcla
implements zzcir {
    public static final int zzd = 0;
    private zzcis zze;
    private String zzf;
    private boolean zzg;
    private boolean zzh;
    private zzcks zzi;
    private long zzj;
    private long zzk;

    public zzclj(zzcjb object, zzcja zzcja2) {
        super(object);
        object = object.getContext();
        object = zzcja2.zzm ? new zzcmb((Context)object, zzcja2, (zzcjb)this.zzc.get()) : new zzcki((Context)object, zzcja2, (zzcjb)this.zzc.get());
        this.zze = object;
        object.zzr((zzcir)this);
    }

    protected static final String zzt(String string) {
        string = (string = String.valueOf(zzcgm.zzd((String)string))).length() != 0 ? "cache:".concat(string) : new String("cache:");
        return string;
    }

    private final void zzw(long l) {
        zzs.zza.postDelayed((Runnable)new zzcli(this), l);
    }

    private static String zzx(String string, Exception object) {
        String string2 = object.getClass().getCanonicalName();
        object = ((Throwable)object).getMessage();
        int n = String.valueOf(string2).length();
        int n2 = String.valueOf(object).length();
        StringBuilder stringBuilder = new StringBuilder(string.length() + 2 + n + n2);
        stringBuilder.append(string);
        stringBuilder.append("/");
        stringBuilder.append(string2);
        stringBuilder.append(":");
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    public final void release() {
        zzcis zzcis2 = this.zze;
        if (zzcis2 == null) return;
        zzcis2.zzr(null);
        this.zze.zzs();
    }

    public final void zzC() {
        com.google.android.gms.ads.internal.util.zze.zzi((String)"Precache onRenderedFirstFrame");
    }

    public final void zza(boolean bl, long l) {
        zzcjb zzcjb2 = (zzcjb)this.zzc.get();
        if (zzcjb2 == null) return;
        zzchg.zze.execute((Runnable)new zzclh(zzcjb2, bl, l));
    }

    public final void zzb(int n) {
    }

    public final void zzc(int n, int n2) {
    }

    public final boolean zzd(String string) {
        return this.zze(string, new String[]{string});
    }

    /*
     * Exception decompiling
     */
    public final boolean zze(String var1_1, String[] var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 8[TRYBLOCK] [49 : 1298->1300)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final boolean zzf(String string, String[] object, zzcks object2) {
        Uri[] uriArray;
        this.zzf = string;
        this.zzi = object2;
        object2 = zzclj.zzt(string);
        try {
            uriArray = new Uri[((String[])object).length];
            for (int i = 0; i < ((String[])object).length; ++i) {
                uriArray[i] = Uri.parse((String)object[i]);
            }
        }
        catch (Exception exception) {
            String string2 = exception.getMessage();
            object = new StringBuilder(String.valueOf(string).length() + 34 + String.valueOf(string2).length());
            ((StringBuilder)object).append("Failed to preload url ");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(" Exception: ");
            ((StringBuilder)object).append(string2);
            com.google.android.gms.ads.internal.util.zze.zzi((String)((StringBuilder)object).toString());
            zzt.zzg().zzl((Throwable)exception, "VideoStreamExoPlayerCache.preload");
            this.release();
            this.zzr(string, (String)object2, "error", zzclj.zzx("error", exception));
            return false;
        }
        {
            this.zze.zzp(uriArray, this.zzb);
            object = (zzcjb)this.zzc.get();
            if (object != null) {
                object.zzu((String)object2, (zzcla)this);
            }
            this.zzj = zzt.zzj().currentTimeMillis();
            this.zzk = -1L;
            this.zzw(0L);
            return true;
        }
    }

    public final void zzg(int n) {
        this.zze.zzG(n);
    }

    public final void zzh(int n) {
        this.zze.zzF(n);
    }

    public final void zzi(int n) {
        this.zze.zzx(n);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final zzcis zzj() {
        synchronized (this) {
            this.zzh = true;
            ((Object)((Object)this)).notify();
        }
        this.zze.zzr(null);
        zzcis zzcis2 = this.zze;
        this.zze = null;
        return zzcis2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    final /* synthetic */ void zzk() {
        block25: {
            block31: {
                var17_1 = zzclj.zzt(this.zzf);
                var20_2 = "error";
                try {
                    var18_3 /* !! */  = zzbjl.zzs;
                    var3_4 = (Long)zzbet.zzc().zzc(var18_3 /* !! */ ) * 1000L;
                    var18_3 /* !! */  = zzbjl.zzr;
                    var9_5 = ((Integer)zzbet.zzc().zzc(var18_3 /* !! */ )).intValue();
                    var18_3 /* !! */  = zzbjl.zzbl;
                    var16_6 = (Boolean)zzbet.zzc().zzc(var18_3 /* !! */ );
                    ** synchronized (this)
                }
                catch (Exception var19_25) {
                    var18_3 /* !! */  = var17_1;
                    var17_1 = this;
                }
lbl-1000:
                // 1 sources

                {
                    block24: {
                        block26: {
                            block30: {
                                block29: {
                                    block28: {
                                        if (zzt.zzj().currentTimeMillis() - this.zzj > var3_4) break block24;
                                        if (this.zzg) ** GOTO lbl102
                                        if (this.zzh) {
                                            // MONITOREXIT @DISABLED, blocks:[1, 22, 12] lbl15 : MonitorExitStatement: MONITOREXIT : this
                                            var17_1 = this;
                                            break block25;
                                        }
                                        if (!this.zze.zzA()) break block26;
                                        var11_7 = this.zze.zzH();
                                        if (var11_7 <= 0L) ** GOTO lbl83
                                        var13_8 = this.zze.zzN();
                                        if (var13_8 == (var3_4 = this.zzk)) ** GOTO lbl50
                                        var15_9 = var13_8 > 0L;
                                        var18_3 /* !! */  = this.zzf;
                                        if (!var16_6) ** GOTO lbl30
                                        var3_4 = this.zze.zzI();
                                        break block28;
lbl30:
                                        // 1 sources

                                        var3_4 = -1L;
                                    }
                                    var5_10 = var16_6 != false ? this.zze.zzJ() : -1L;
                                    var7_11 = var16_6 != false ? this.zze.zzK() : -1L;
                                    var1_12 = zzcis.zzP();
                                    var2_13 = zzcis.zzQ();
                                    this.zzn((String)var18_3 /* !! */ , (String)var17_1, var13_8, var11_7, var15_9, var3_4, var5_10, var7_11, var1_12, var2_13);
                                    {
                                        catch (Throwable var19_14) {
                                            ** GOTO lbl67
                                        }
                                    }
                                    this.zzk = var13_8;
                                    break block29;
                                    catch (Throwable var19_15) {
                                        var18_3 /* !! */  = this;
                                        var21_27 /* !! */  = var17_1;
                                        var17_1 = var18_3 /* !! */ ;
                                        var18_3 /* !! */  = var21_27 /* !! */ ;
                                    }
                                    break block27;
                                }
                                var18_3 /* !! */  = this;
                                if (var13_8 < var11_7) ** GOTO lbl71
                                var19_16 = var18_3 /* !! */ .zzf;
                                var22_29 = var18_3 /* !! */ ;
                                var21_27 /* !! */  = var17_1;
                                var23_31 = var20_2;
                                var18_3 /* !! */ .zzq((String)var19_16, (String)var17_1, var11_7);
                                var22_29 = var18_3 /* !! */ ;
                                var21_27 /* !! */  = var17_1;
                                var23_31 = var20_2;
                                // MONITOREXIT @DISABLED, blocks:[7, 12] lbl61 : MonitorExitStatement: MONITOREXIT : this
                                var17_1 = var18_3 /* !! */ ;
                                break block25;
                                catch (Throwable var19_17) {
                                    // empty catch block
                                }
lbl67:
                                // 2 sources

                                var21_27 /* !! */  = this;
                                var18_3 /* !! */  = var17_1;
                                var17_1 = var21_27 /* !! */ ;
                                break block27;
lbl71:
                                // 1 sources

                                var19_18 = var17_1;
                                var22_30 = var18_3 /* !! */ ;
                                var21_28 /* !! */  = var19_18;
                                var23_32 = var20_2;
                                if (var18_3 /* !! */ .zze.zzO() >= var9_5 && var13_8 > 0L) {
                                    var22_30 = var18_3 /* !! */ ;
                                    var21_28 /* !! */  = var19_18;
                                    var23_32 = var20_2;
                                    // MONITOREXIT @DISABLED, blocks:[23, 7, 12] lbl78 : MonitorExitStatement: MONITOREXIT : this
                                    var17_1 = var18_3 /* !! */ ;
                                    break block25;
                                }
                                break block30;
lbl83:
                                // 1 sources

                                var18_3 /* !! */  = var17_1;
                            }
                            var21_28 /* !! */  = var17_1;
                            var22_30 = var17_1 = this;
                            var23_32 = var20_2;
                            // MONITOREXIT @DISABLED, blocks:[7, 12] lbl86 : MonitorExitStatement: MONITOREXIT : this
                            var18_3 /* !! */  = zzbjl.zzt;
                            super.zzw((Long)zzbet.zzc().zzc(var18_3 /* !! */ ));
                            return;
                        }
                        var18_3 /* !! */  = var17_1;
                        var18_3 /* !! */  = this;
                        var19_16 = "exoPlayerReleased";
                        var18_3 /* !! */  = var19_16;
                        try {
                            var18_3 /* !! */  = var19_16;
                            var20_2 = new IOException("ExoPlayer was released during preloading.");
                            var18_3 /* !! */  = var19_16;
                            throw var20_2;
lbl102:
                            // 1 sources

                            var18_3 /* !! */  = var17_1;
                            var18_3 /* !! */  = this;
                            var19_19 = "externalAbort";
                            var18_3 /* !! */  = var19_19;
                            var18_3 /* !! */  = var19_19;
                            var20_2 = new IOException("Abort requested before buffering finished. ");
                            var18_3 /* !! */  = var19_19;
                            throw var20_2;
                        }
                        catch (Throwable v0) {
                            var20_2 = var17_1;
                            var17_1 = this;
                            var19_16 = v0;
                            var21_27 /* !! */  = var18_3 /* !! */ ;
                            var18_3 /* !! */  = var20_2;
                            var20_2 = var21_27 /* !! */ ;
                        }
                        break block27;
                    }
                    var18_3 /* !! */  = var17_1;
                    var17_1 = this;
                    try {
                        var19_20 = new StringBuilder(47);
                        var19_20.append("Timeout reached. Limit: ");
                        var19_20.append(var3_4);
                        var19_20.append(" ms");
                        var20_2 = new IOException(var19_20.toString());
                        throw var20_2;
                    }
                    catch (Throwable var19_21) {
                        var20_2 = "downloadTimeout";
                    }
                    break block27;
                    catch (Throwable var19_23) {
                        var18_3 /* !! */  = var17_1;
                        var17_1 = this;
                    }
                    break block27;
                }
                break block31;
                {
                    block27: {
                        catch (Throwable var19_22) {
                            var17_1 = var22_29;
                            var18_3 /* !! */  = var21_27 /* !! */ ;
                            var20_2 = var23_31;
                        }
                    }
                    var22_29 = var17_1;
                    var21_27 /* !! */  = var18_3 /* !! */ ;
                    var23_31 = var20_2;
                }
                try {
                    throw var19_16;
                }
                catch (Exception var19_24) {}
            }
            var22_29 = var17_1.zzf;
            var23_31 = var19_26.getMessage();
            var21_27 /* !! */  = new StringBuilder(String.valueOf(var22_29).length() + 34 + String.valueOf(var23_31).length());
            var21_27 /* !! */ .append("Failed to preload url ");
            var21_27 /* !! */ .append(var22_29);
            var21_27 /* !! */ .append(" Exception: ");
            var21_27 /* !! */ .append((String)var23_31);
            com.google.android.gms.ads.internal.util.zze.zzi((String)var21_27 /* !! */ .toString());
            zzt.zzg().zzl((Throwable)var19_26, "VideoStreamExoPlayerCache.preload");
            this.release();
            var19_26 = zzclj.zzx((String)var20_2, (Exception)var19_26);
            var17_1.zzr(var17_1.zzf, (String)var18_3 /* !! */ , (String)var20_2, var19_26);
        }
        zzt.zzy().zzd(var17_1.zzi);
    }

    public final void zzl(int n) {
        this.zze.zzy(n);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzm() {
        synchronized (this) {
            this.zzg = true;
            ((Object)((Object)this)).notify();
            this.release();
        }
        String string = this.zzf;
        if (string == null) return;
        string = zzclj.zzt(string);
        this.zzr(this.zzf, string, "externalAbort", "Programmatic precache abort.");
    }

    public final void zzu(String string, Exception exception) {
        com.google.android.gms.ads.internal.util.zze.zzj((String)"Precache error", (Throwable)exception);
        zzt.zzg().zzl((Throwable)exception, "VideoStreamExoPlayerCache.onError");
    }

    public final void zzv(String string, Exception exception) {
        com.google.android.gms.ads.internal.util.zze.zzj((String)"Precache exception", (Throwable)exception);
        zzt.zzg().zzl((Throwable)exception, "VideoStreamExoPlayerCache.onException");
    }
}
