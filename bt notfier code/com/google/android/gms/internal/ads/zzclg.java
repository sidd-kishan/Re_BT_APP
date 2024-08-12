/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzatz
 *  com.google.android.gms.internal.ads.zzauo
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcis
 *  com.google.android.gms.internal.ads.zzcja
 *  com.google.android.gms.internal.ads.zzcjb
 *  com.google.android.gms.internal.ads.zzckl
 *  com.google.android.gms.internal.ads.zzcla
 *  com.google.android.gms.internal.ads.zzclf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzatz;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcis;
import com.google.android.gms.internal.ads.zzcja;
import com.google.android.gms.internal.ads.zzcjb;
import com.google.android.gms.internal.ads.zzckl;
import com.google.android.gms.internal.ads.zzcla;
import com.google.android.gms.internal.ads.zzclf;
import java.nio.ByteBuffer;

public final class zzclg
extends zzcla
implements zzauo<zzatz> {
    private String zzd;
    private final zzcja zze;
    private boolean zzf;
    private final zzclf zzg;
    private final zzckl zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private final Object zzk;
    private final String zzl;
    private final int zzm;
    private boolean zzn;

    public zzclg(zzcjb zzcjb2, zzcja object) {
        super(zzcjb2);
        this.zze = object;
        this.zzg = new zzclf();
        this.zzh = new zzckl();
        this.zzk = new Object();
        object = zzcjb2 != null ? zzcjb2.zzn() : "";
        this.zzl = object;
        int n = zzcjb2 != null ? zzcjb2.zzp() : 0;
        this.zzm = n;
    }

    protected static final String zzt(String string) {
        string = (string = String.valueOf(zzcgm.zzd((String)string))).length() != 0 ? "cache:".concat(string) : new String("cache:");
        return string;
    }

    private final void zzu() {
        int n;
        int n2 = (int)this.zzg.zza();
        int n3 = (int)this.zzh.zza(this.zzi);
        int n4 = Math.round((float)n3 * ((float)(n = this.zzi.position()) / (float)n2));
        boolean bl = n4 > 0;
        int n5 = zzcis.zzP();
        int n6 = zzcis.zzQ();
        String string = this.zzd;
        this.zzo(string, zzclg.zzt(string), n, n2, n4, n3, bl, n5, n6);
    }

    public final String zza() {
        return this.zzd;
    }

    public final boolean zzb() {
        return this.zzn;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final ByteBuffer zzc() {
        Object object = this.zzk;
        synchronized (object) {
            ByteBuffer byteBuffer = this.zzi;
            if (byteBuffer != null && !this.zzj) {
                byteBuffer.flip();
                this.zzj = true;
            }
            this.zzf = true;
            return this.zzi;
        }
    }

    /*
     * Exception decompiling
     */
    public final boolean zzd(String var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 6[TRYBLOCK] [51 : 767->770)] java.lang.Throwable
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

    public final void zzm() {
        this.zzf = true;
    }
}
