/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzbb
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzdym
 *  com.google.android.gms.internal.ads.zzeeg
 *  com.google.android.gms.internal.ads.zzeeh
 *  com.google.android.gms.internal.ads.zzfmi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbb;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzdym;
import com.google.android.gms.internal.ads.zzeeg;
import com.google.android.gms.internal.ads.zzeeh;
import com.google.android.gms.internal.ads.zzfmi;

public final class zzfbm {
    public static zzbcz zza(Throwable throwable) {
        if (throwable instanceof zzeeg) {
            throwable = (zzeeg)throwable;
            return zzfbm.zzc(throwable.zza(), throwable.zzb());
        }
        if (!(throwable instanceof zzdym)) {
            if (!(throwable instanceof zzbb)) return zzfbm.zzd(1, null, null);
            throwable = (zzbb)throwable;
            return new zzbcz(throwable.zza(), zzfmi.zza((String)throwable.getMessage()), "com.google.android.gms.ads", null, null);
        }
        throwable = throwable.getMessage() == null ? zzfbm.zzd(((zzdym)throwable).zza(), null, null) : zzfbm.zzd(((zzdym)throwable).zza(), throwable.getMessage(), null);
        return throwable;
    }

    public static zzbcz zzb(Throwable throwable, zzeeh zzeeh2) {
        zzbcz zzbcz2;
        throwable = zzfbm.zza(throwable);
        int n = ((zzbcz)throwable).zza;
        if (!(n != 3 && n != 0 || (zzbcz2 = ((zzbcz)throwable).zzd) == null || zzbcz2.zzc.equals("com.google.android.gms.ads"))) {
            ((zzbcz)throwable).zzd = null;
        }
        zzbcz2 = zzbjl.zzfX;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)zzbcz2) == false) return throwable;
        if (zzeeh2 == null) return throwable;
        ((zzbcz)throwable).zze = zzeeh2.zzd();
        return throwable;
    }

    public static zzbcz zzc(int n, zzbcz zzbcz2) {
        if (n == 0) throw null;
        int n2 = n;
        if (n != 8) return zzfbm.zzd(n2, null, zzbcz2);
        zzbjd zzbjd2 = zzbjl.zzfU;
        if ((Integer)zzbet.zzc().zzc(zzbjd2) > 0) return zzbcz2;
        n2 = 8;
        return zzfbm.zzd(n2, null, zzbcz2);
    }

    /*
     * Exception decompiling
     */
    public static zzbcz zzd(int var0, String var1_1, zzbcz var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [20[CASE]], but top level block is 30[SWITCH]
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
