/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzauy {
    private final byte[] zza;
    private final int zzb;
    private int zzc;
    private int zzd;

    public zzauy(byte[] byArray, int n, int n2) {
        this.zza = byArray;
        this.zzc = n;
        this.zzb = n2;
        this.zzd = 0;
        this.zzh();
    }

    private final int zzf() {
        int n = 0;
        int n2 = 0;
        while (true) {
            if (this.zzb()) {
                if (n2 <= 0) return (1 << n2) - 1 + n;
                n = this.zzc(n2);
                return (1 << n2) - 1 + n;
            }
            ++n2;
        }
    }

    private final boolean zzg(int n) {
        if (n < 2) return false;
        if (n >= this.zzb) return false;
        byte[] byArray = this.zza;
        if (byArray[n] != 3) return false;
        if (byArray[n - 2] != 0) return false;
        if (byArray[n - 1] != 0) return false;
        return true;
    }

    /*
     * Exception decompiling
     */
    private final void zzh() {
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

    public final void zza(int n) {
        int n2;
        int n3;
        int n4 = this.zzc;
        this.zzc = n3 = (n >> 3) + n4;
        this.zzd = n2 = this.zzd + (n & 7);
        n = n4;
        if (n2 > 7) {
            this.zzc = n3 + 1;
            this.zzd = n2 - 8;
            n = n4;
        }
        while (true) {
            if ((n4 = n + 1) > this.zzc) {
                this.zzh();
                return;
            }
            n = n4;
            if (!this.zzg(n4)) continue;
            ++this.zzc;
            n = n4 + 2;
        }
    }

    public final boolean zzb() {
        if (this.zzc(1) != 1) return false;
        return true;
    }

    public final int zzc(int n) {
        byte[] byArray;
        int n2;
        int n3;
        int n4 = 0;
        int n5 = 0;
        int n6 = n;
        while (true) {
            n3 = n6;
            if (n4 >= n >> 3) break;
            n6 = this.zzg(this.zzc + 1) ? this.zzc + 2 : this.zzc + 1;
            n2 = this.zzd;
            if (n2 != 0) {
                byArray = this.zza;
                byte by = byArray[this.zzc];
                n2 = (byArray[n6] & 0xFF) >>> 8 - n2 | (by & 0xFF) << n2;
            } else {
                n2 = this.zza[this.zzc];
            }
            n5 |= (n2 & 0xFF) << (n3 -= 8);
            this.zzc = n6;
            ++n4;
            n6 = n3;
        }
        n = n5;
        if (n3 > 0) {
            n4 = this.zzd + n3;
            n = (byte)(255 >> 8 - n3);
            n6 = this.zzg(this.zzc + 1) ? this.zzc + 2 : this.zzc + 1;
            if (n4 > 8) {
                byArray = this.zza;
                n2 = byArray[this.zzc];
                n = n & ((0xFF & byArray[n6]) >> 16 - n4 | (n2 & 0xFF) << n4 - 8) | n5;
                this.zzc = n6;
            } else {
                n = n5 = n & (0xFF & this.zza[this.zzc]) >> 8 - n4 | n5;
                if (n4 == 8) {
                    this.zzc = n6;
                    n = n5;
                }
            }
            this.zzd = n4 % 8;
        }
        this.zzh();
        return n;
    }

    public final int zzd() {
        return this.zzf();
    }

    public final int zze() {
        int n = this.zzf();
        int n2 = n % 2 == 0 ? -1 : 1;
        return n2 * ((n + 1) / 2);
    }
}
