/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzaj
 *  com.google.android.gms.internal.ads.zzakw
 *  com.google.android.gms.internal.ads.zzal
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzan
 *  com.google.android.gms.internal.ads.zzgv
 *  com.google.android.gms.internal.ads.zzgx
 *  com.google.android.gms.internal.ads.zzhx
 *  com.google.android.gms.internal.ads.zzig
 *  com.google.android.gms.internal.ads.zzlc
 *  com.google.android.gms.internal.ads.zzlp
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzoq
 *  com.google.android.gms.internal.ads.zzov
 *  com.google.android.gms.internal.ads.zzox
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzaj;
import com.google.android.gms.internal.ads.zzakw;
import com.google.android.gms.internal.ads.zzal;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzan;
import com.google.android.gms.internal.ads.zzgv;
import com.google.android.gms.internal.ads.zzgx;
import com.google.android.gms.internal.ads.zzhx;
import com.google.android.gms.internal.ads.zzig;
import com.google.android.gms.internal.ads.zzlc;
import com.google.android.gms.internal.ads.zzlp;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzox;
import java.io.IOException;

final class zzib
implements zzlc,
zzgv {
    final zzig zza;
    private final long zzb;
    private final Uri zzc;
    private final zzlp zzd;
    private final zzhx zze;
    private final zznx zzf;
    private final zzakw zzg;
    private final zzoq zzh;
    private volatile boolean zzi;
    private boolean zzj;
    private long zzk;
    private zzan zzl;
    private long zzm;
    private zzox zzn;
    private boolean zzo;

    public zzib(zzig zzig2, Uri uri, zzaj zzaj2, zzhx zzhx2, zznx zznx2, zzakw zzakw2) {
        this.zza = zzig2;
        this.zzc = uri;
        this.zzd = new zzlp(zzaj2);
        this.zze = zzhx2;
        this.zzf = zznx2;
        this.zzg = zzakw2;
        this.zzh = new zzoq();
        this.zzj = true;
        this.zzm = -1L;
        this.zzb = zzgx.zza();
        this.zzl = this.zzj(0L);
    }

    static /* synthetic */ long zzb(zzib zzib2) {
        return zzib2.zzb;
    }

    static /* synthetic */ zzlp zzc(zzib zzib2) {
        return zzib2.zzd;
    }

    static /* synthetic */ long zzd(zzib zzib2) {
        return zzib2.zzk;
    }

    static /* synthetic */ zzan zze(zzib zzib2) {
        return zzib2.zzl;
    }

    static /* synthetic */ long zzf(zzib zzib2) {
        return zzib2.zzm;
    }

    static /* synthetic */ void zzi(zzib zzib2, long l, long l2) {
        zzib2.zzh.zza = l;
        zzib2.zzk = l2;
        zzib2.zzj = true;
        zzib2.zzo = false;
    }

    private final zzan zzj(long l) {
        zzal zzal2 = new zzal();
        zzal2.zza(this.zzc);
        zzal2.zzc(l);
        zzal2.zzd(6);
        zzal2.zzb(zzig.zza());
        return zzal2.zze();
    }

    public final void zza(zzamf zzamf2) {
        long l = !this.zzo ? this.zzk : Math.max(zzig.zzG((zzig)this.zza), this.zzk);
        int n = zzamf2.zzd();
        zzox zzox2 = this.zzn;
        if (zzox2 == null) throw null;
        zzov.zzb((zzox)zzox2, (zzamf)zzamf2, (int)n);
        zzox2.zzv(l, 1, n, 0, null);
        this.zzo = true;
    }

    public final void zzg() {
        this.zzi = true;
    }

    /*
     * Exception decompiling
     */
    public final void zzh() throws IOException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [19[UNCONDITIONALDOLOOP]], but top level block is 6[TRYBLOCK]
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
