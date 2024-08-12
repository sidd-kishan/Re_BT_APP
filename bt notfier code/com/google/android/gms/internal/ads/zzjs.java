/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzfny
 *  com.google.android.gms.internal.ads.zzfpw
 *  com.google.android.gms.internal.ads.zzjn
 *  com.google.android.gms.internal.ads.zzjt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzfny;
import com.google.android.gms.internal.ads.zzfpw;
import com.google.android.gms.internal.ads.zzjn;
import com.google.android.gms.internal.ads.zzjt;
import java.util.Comparator;

public final class zzjs
implements Comparable<zzjs> {
    public final boolean zza;
    private final zzjn zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;

    /*
     * Exception decompiling
     */
    public zzjs(zzafv var1_1, zzjn var2_2, int var3_3, boolean var4_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.markFirstStatementInBlock(Op03SimpleStatement.java:461)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.markWholeBlock(Misc.java:251)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.considerAsSimpleIf(ConditionalRewriter.java:673)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.identifyNonjumpingConditionals(ConditionalRewriter.java:56)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:722)
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

    public final int zza(zzjs zzjs2) {
        zzfpw zzfpw2 = this.zza && this.zzd ? zzjt.zza() : zzjt.zza().zza();
        zzfny zzfny2 = zzfny.zzj().zzd(this.zzd, zzjs2.zzd).zzd(this.zza, zzjs2.zza).zzd(this.zzc, zzjs2.zzc).zza((Object)this.zzg, (Object)zzjs2.zzg, (Comparator)zzfpw.zzb().zza());
        int n = this.zze;
        int n2 = zzjs2.zze;
        boolean bl = this.zzb.zzw;
        return zzfny2.zza((Object)n, (Object)n2, (Comparator)zzjt.zzb()).zza((Object)this.zzf, (Object)zzjs2.zzf, (Comparator)zzfpw2).zza((Object)this.zze, (Object)zzjs2.zze, (Comparator)zzfpw2).zze();
    }
}
