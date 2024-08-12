/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzamg {
    private byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd;

    public zzamg(byte[] byArray, int n, int n2) {
        this.zza(byArray, n, n2);
    }

    private final int zzh() {
        int n = 0;
        int n2 = 0;
        while (true) {
            if (this.zzd()) {
                if (n2 <= 0) return (1 << n2) - 1 + n;
                n = this.zze(n2);
                return (1 << n2) - 1 + n;
            }
            ++n2;
        }
    }

    private final boolean zzi(int n) {
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
    private final void zzj() {
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

    public final void zza(byte[] byArray, int n, int n2) {
        this.zza = byArray;
        this.zzc = n;
        this.zzb = n2;
        this.zzd = 0;
        this.zzj();
    }

    public final void zzb() {
        int n = this.zzd;
        int n2 = 1;
        this.zzd = ++n;
        if (n == 8) {
            this.zzd = 0;
            n = this.zzc;
            if (this.zzi(n + 1)) {
                n2 = 2;
            }
            this.zzc = n + n2;
        }
        this.zzj();
    }

    public final void zzc(int n) {
        int n2;
        int n3 = this.zzc;
        int n4 = n / 8;
        this.zzc = n2 = n3 + n4;
        this.zzd = n4 = this.zzd + (n - n4 * 8);
        n = n3;
        if (n4 > 7) {
            this.zzc = n2 + 1;
            this.zzd = n4 - 8;
            n = n3;
        }
        while (true) {
            if ((n3 = n + 1) > this.zzc) {
                this.zzj();
                return;
            }
            n = n3;
            if (!this.zzi(n3)) continue;
            ++this.zzc;
            n = n3 + 2;
        }
    }

    public final boolean zzd() {
        boolean bl = (this.zza[this.zzc] & 128 >> this.zzd) != 0;
        this.zzb();
        return bl;
    }

    public final int zze(int n) {
        int n2;
        byte[] byArray;
        int n3;
        int n4;
        this.zzd += n;
        int n5 = 0;
        while (true) {
            n4 = this.zzd;
            n3 = 2;
            if (n4 <= 8) break;
            this.zzd = n4 -= 8;
            byArray = this.zza;
            n2 = this.zzc;
            n5 |= (byArray[n2] & 0xFF) << n4;
            if (!this.zzi(n2 + 1)) {
                n3 = 1;
            }
            this.zzc = n2 + n3;
        }
        byArray = this.zza;
        int n6 = this.zzc;
        n2 = byArray[n6];
        if (n4 == 8) {
            this.zzd = 0;
            if (!this.zzi(n6 + 1)) {
                n3 = 1;
            }
            this.zzc = n6 + n3;
        }
        this.zzj();
        return -1 >>> 32 - n & (n5 | (n2 & 0xFF) >> 8 - n4);
    }

    public final int zzf() {
        return this.zzh();
    }

    public final int zzg() {
        int n = this.zzh();
        int n2 = n % 2 == 0 ? -1 : 1;
        return n2 * ((n + 1) / 2);
    }
}
