/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzapt
 *  com.google.android.gms.internal.ads.zzasj
 *  com.google.android.gms.internal.ads.zzasl
 *  com.google.android.gms.internal.ads.zzatz
 *  com.google.android.gms.internal.ads.zzaul
 *  com.google.android.gms.internal.ads.zzaur
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzapt;
import com.google.android.gms.internal.ads.zzasj;
import com.google.android.gms.internal.ads.zzasl;
import com.google.android.gms.internal.ads.zzatz;
import com.google.android.gms.internal.ads.zzaul;
import com.google.android.gms.internal.ads.zzaur;
import java.io.IOException;

final class zzasi
implements zzaul {
    final zzasl zza;
    private final Uri zzb;
    private final zzatz zzc;
    private final zzasj zzd;
    private final zzaur zze;
    private final zzapt zzf;
    private volatile boolean zzg;
    private boolean zzh;
    private long zzi;
    private long zzj;

    public zzasi(zzasl zzasl2, Uri uri, zzatz zzatz2, zzasj zzasj2, zzaur zzaur2) {
        this.zza = zzasl2;
        if (uri == null) throw null;
        this.zzb = uri;
        if (zzatz2 == null) throw null;
        this.zzc = zzatz2;
        if (zzasj2 == null) throw null;
        this.zzd = zzasj2;
        this.zze = zzaur2;
        this.zzf = new zzapt();
        this.zzh = true;
        this.zzj = -1L;
    }

    static /* synthetic */ long zza(zzasi zzasi2) {
        return zzasi2.zzj;
    }

    public final void zzb(long l, long l2) {
        this.zzf.zza = l;
        this.zzi = l2;
        this.zzh = true;
    }

    public final void zzc() {
        this.zzg = true;
    }

    public final boolean zzd() {
        return this.zzg;
    }

    /*
     * Exception decompiling
     */
    public final void zze() throws IOException, InterruptedException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [7[UNCONDITIONALDOLOOP]], but top level block is 2[TRYBLOCK]
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
}
