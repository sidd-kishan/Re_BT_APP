/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzalw
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zztb
 *  com.google.android.gms.internal.ads.zztl
 *  com.google.android.gms.internal.ads.zztq
 *  com.google.android.gms.internal.ads.zzuc
 *  com.google.android.gms.internal.ads.zzun
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzalw;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zztb;
import com.google.android.gms.internal.ads.zztl;
import com.google.android.gms.internal.ads.zztq;
import com.google.android.gms.internal.ads.zzuc;
import com.google.android.gms.internal.ads.zzun;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zztm
implements zztb {
    private final zzuc zza;
    private String zzb;
    private zzox zzc;
    private zztl zzd;
    private boolean zze;
    private final boolean[] zzf;
    private final zztq zzg;
    private final zztq zzh;
    private final zztq zzi;
    private final zztq zzj;
    private final zztq zzk;
    private long zzl;
    private long zzm;
    private final zzamf zzn;

    public zztm(zzuc zzuc2) {
        this.zza = zzuc2;
        this.zzf = new boolean[3];
        this.zzg = new zztq(32, 128);
        this.zzh = new zztq(33, 128);
        this.zzi = new zztq(34, 128);
        this.zzj = new zztq(39, 128);
        this.zzk = new zztq(40, 128);
        this.zzm = -9223372036854775807L;
        this.zzn = new zzamf();
    }

    @RequiresNonNull(value={"sampleReader"})
    private final void zzf(byte[] byArray, int n, int n2) {
        this.zzd.zzc(byArray, n, n2);
        if (!this.zze) {
            this.zzg.zzd(byArray, n, n2);
            this.zzh.zzd(byArray, n, n2);
            this.zzi.zzd(byArray, n, n2);
        }
        this.zzj.zzd(byArray, n, n2);
        this.zzk.zzd(byArray, n, n2);
    }

    public final void zza() {
        this.zzl = 0L;
        this.zzm = -9223372036854775807L;
        zzalw.zze((boolean[])this.zzf);
        this.zzg.zza();
        this.zzh.zza();
        this.zzi.zza();
        this.zzj.zza();
        this.zzk.zza();
        zztl zztl2 = this.zzd;
        if (zztl2 == null) return;
        zztl2.zza();
    }

    public final void zzb(zznx zznx2, zzun zzun2) {
        zzox zzox2;
        zzun2.zza();
        this.zzb = zzun2.zzc();
        this.zzc = zzox2 = zznx2.zzB(zzun2.zzb(), 2);
        this.zzd = new zztl(zzox2);
        this.zza.zza(zznx2, zzun2);
    }

    public final void zzc(long l, int n) {
        if (l == -9223372036854775807L) return;
        this.zzm = l;
    }

    /*
     * Exception decompiling
     */
    public final void zzd(zzamf var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[DOLOOP]], but top level block is 43[SIMPLE_IF_TAKEN]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
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

    public final void zze() {
    }
}
