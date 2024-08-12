/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;

public final class zzame {
    public byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd;

    public zzame() {
        this.zza = zzamq.zzf;
    }

    public zzame(byte[] byArray, int n) {
        this.zza = byArray;
        this.zzd = n;
    }

    /*
     * Exception decompiling
     */
    private final void zzm() {
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

    public final void zza(byte[] byArray, int n) {
        this.zza = byArray;
        this.zzb = 0;
        this.zzc = 0;
        this.zzd = n;
    }

    public final int zzb() {
        return (this.zzd - this.zzb) * 8 - this.zzc;
    }

    public final int zzc() {
        return this.zzb * 8 + this.zzc;
    }

    public final void zzd(int n) {
        int n2;
        this.zzb = n2 = n / 8;
        this.zzc = n - n2 * 8;
        this.zzm();
    }

    public final void zze() {
        int n;
        this.zzc = n = this.zzc + 1;
        if (n == 8) {
            this.zzc = 0;
            ++this.zzb;
        }
        this.zzm();
    }

    public final void zzf(int n) {
        int n2;
        int n3 = n / 8;
        this.zzb = n2 = this.zzb + n3;
        this.zzc = n = this.zzc + (n - n3 * 8);
        if (n > 7) {
            this.zzb = n2 + 1;
            this.zzc = n - 8;
        }
        this.zzm();
    }

    public final boolean zzg() {
        boolean bl = (this.zza[this.zzb] & 128 >> this.zzc) != 0;
        this.zze();
        return bl;
    }

    public final int zzh(int n) {
        int n2;
        byte[] byArray;
        int n3;
        if (n == 0) {
            return 0;
        }
        this.zzc += n;
        int n4 = 0;
        while ((n3 = this.zzc) > 8) {
            this.zzc = n3 -= 8;
            byArray = this.zza;
            n2 = this.zzb;
            this.zzb = n2 + 1;
            n4 |= (byArray[n2] & 0xFF) << n3;
        }
        byArray = this.zza;
        int n5 = this.zzb;
        n2 = byArray[n5];
        if (n3 == 8) {
            this.zzc = 0;
            this.zzb = n5 + 1;
        }
        this.zzm();
        return -1 >>> 32 - n & (n4 | (n2 & 0xFF) >> 8 - n3);
    }

    public final void zzi(byte[] byArray, int n, int n2) {
        byte by;
        int n3;
        int n4;
        byte[] byArray2;
        int n5 = n2 >> 3;
        for (n = 0; n < n5; ++n) {
            byArray2 = this.zza;
            n4 = this.zzb;
            this.zzb = n3 = n4 + 1;
            n4 = byArray2[n4];
            int n6 = this.zzc;
            byArray[n] = by = (byte)(n4 << n6);
            byArray[n] = (byte)((0xFF & byArray2[n3]) >> 8 - n6 | by);
        }
        n3 = n2 & 7;
        if (n3 == 0) {
            return;
        }
        byArray[n5] = by = (byte)(byArray[n5] & 255 >> n3);
        n2 = this.zzc;
        n4 = by;
        n = n2;
        if (n2 + n3 > 8) {
            byArray2 = this.zza;
            n = this.zzb;
            this.zzb = n + 1;
            byArray[n5] = by = (byte)(by | (byArray2[n] & 0xFF) << n2);
            n = n2 - 8;
            n4 = by;
        }
        this.zzc = n2 = n + n3;
        byArray2 = this.zza;
        n = this.zzb;
        byArray[n5] = (byte)((byte)((0xFF & byArray2[n]) >> 8 - n2 << 8 - n3) | n4);
        if (n2 == 8) {
            this.zzc = 0;
            this.zzb = n + 1;
        }
        this.zzm();
    }

    public final void zzj() {
        if (this.zzc == 0) {
            return;
        }
        this.zzc = 0;
        ++this.zzb;
        this.zzm();
    }

    public final void zzk(int n) {
        boolean bl = this.zzc == 0;
        zzakt.zzd((boolean)bl);
        this.zzb += n;
        this.zzm();
    }

    public final void zzl(int n, int n2) {
        byte by;
        int n3 = n & 0x3FFF;
        int n4 = Math.min(8 - this.zzc, 14);
        n = this.zzc;
        n2 = 8 - n - n4;
        byte[] byArray = this.zza;
        int n5 = this.zzb;
        byArray[n5] = by = (byte)((65280 >> n | (1 << n2) - 1) & byArray[n5]);
        n = 14 - n4;
        byArray[n5] = (byte)(by | n3 >>> n << n2);
        n2 = n5 + 1;
        while (true) {
            if (n <= 8) {
                n5 = 8 - n;
                byArray = this.zza;
                byArray[n2] = by = (byte)(byArray[n2] & (1 << n5) - 1);
                byArray[n2] = (byte)((n3 & (1 << n) - 1) << n5 | by);
                this.zzf(14);
                this.zzm();
                return;
            }
            this.zza[n2] = (byte)(n3 >>> (n -= 8));
            ++n2;
        }
    }
}
