/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzahz
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzgl
 *  com.google.android.gms.internal.ads.zzhd
 *  com.google.android.gms.internal.ads.zzhe
 *  com.google.android.gms.internal.ads.zziu
 *  com.google.android.gms.internal.ads.zzjg
 *  com.google.android.gms.internal.ads.zzs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzahz;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzgl;
import com.google.android.gms.internal.ads.zzhd;
import com.google.android.gms.internal.ads.zzhe;
import com.google.android.gms.internal.ads.zziu;
import com.google.android.gms.internal.ads.zzjg;
import com.google.android.gms.internal.ads.zzs;
import java.io.IOException;

public final class zzgm
implements zzhe,
zzhd {
    public final zzhe zza;
    long zzb;
    private zzhd zzc;
    private zzgl[] zzd;
    private long zze;

    public zzgm(zzhe zzhe2, boolean bl, long l, long l2) {
        this.zza = zzhe2;
        this.zzd = new zzgl[0];
        this.zze = 0L;
        this.zzb = l2;
    }

    public final void zza(long l, long l2) {
        this.zzb = l2;
    }

    public final void zzb(zzhd zzhd2, long l) {
        this.zzc = zzhd2;
        this.zza.zzb((zzhd)this, l);
    }

    public final void zzc() throws IOException {
        this.zza.zzc();
    }

    public final zzs zzd() {
        return this.zza.zzd();
    }

    public final void zze(long l, boolean bl) {
        this.zza.zze(l, false);
    }

    public final void zzf(long l) {
        this.zza.zzf(l);
    }

    public final long zzg() {
        boolean bl;
        long l;
        block6: {
            block5: {
                if (this.zzo()) {
                    long l2 = this.zze;
                    this.zze = -9223372036854775807L;
                    long l3 = this.zzg();
                    if (l3 == -9223372036854775807L) return l2;
                    return l3;
                }
                l = this.zza.zzg();
                if (l == -9223372036854775807L) {
                    return -9223372036854775807L;
                }
                boolean bl2 = false;
                bl = l >= 0L;
                zzakt.zzd((boolean)bl);
                long l4 = this.zzb;
                if (l4 == Long.MIN_VALUE) break block5;
                bl = bl2;
                if (l > l4) break block6;
            }
            bl = true;
        }
        zzakt.zzd((boolean)bl);
        return l;
    }

    public final long zzh() {
        long l = this.zza.zzh();
        if (l == Long.MIN_VALUE) return Long.MIN_VALUE;
        long l2 = this.zzb;
        if (l2 == Long.MIN_VALUE) return l;
        if (l < l2) return l;
        return Long.MIN_VALUE;
    }

    public final long zzi(long l) {
        boolean bl;
        long l2;
        block4: {
            block3: {
                this.zze = -9223372036854775807L;
                zzgl[] zzglArray = this.zzd;
                int n = zzglArray.length;
                boolean bl2 = false;
                for (int i = 0; i < n; ++i) {
                    zzgl zzgl2 = zzglArray[i];
                    if (zzgl2 == null) continue;
                    zzgl2.zza();
                }
                l2 = this.zza.zzi(l);
                if (l2 == l) break block3;
                bl = bl2;
                if (l2 < 0L) break block4;
                l = this.zzb;
                if (l == Long.MIN_VALUE) break block3;
                bl = bl2;
                if (l2 > l) break block4;
            }
            bl = true;
        }
        zzakt.zzd((boolean)bl);
        return l2;
    }

    public final long zzj(long l, zzahz zzahz2) {
        zzahz zzahz3;
        if (l == 0L) return 0L;
        long l2 = zzamq.zzy((long)zzahz2.zzf, (long)0L, (long)l);
        long l3 = zzahz2.zzg;
        long l4 = this.zzb;
        l4 = l4 == Long.MIN_VALUE ? Long.MAX_VALUE : (l4 -= l);
        l4 = zzamq.zzy((long)l3, (long)0L, (long)l4);
        if (l2 == zzahz2.zzf) {
            zzahz3 = zzahz2;
            if (l4 == zzahz2.zzg) return this.zza.zzj(l, zzahz3);
        }
        zzahz3 = new zzahz(l2, l4);
        return this.zza.zzj(l, zzahz3);
    }

    public final long zzk() {
        long l = this.zza.zzk();
        if (l == Long.MIN_VALUE) return Long.MIN_VALUE;
        long l2 = this.zzb;
        if (l2 == Long.MIN_VALUE) return l;
        if (l < l2) return l;
        return Long.MIN_VALUE;
    }

    public final boolean zzl(long l) {
        return this.zza.zzl(l);
    }

    public final boolean zzm() {
        return this.zza.zzm();
    }

    public final void zzn(zzhe zzhe2) {
        zzhe2 = this.zzc;
        if (zzhe2 == null) throw null;
        zzhe2.zzn((zzhe)this);
    }

    final boolean zzo() {
        if (this.zze == -9223372036854775807L) return false;
        return true;
    }

    /*
     * Exception decompiling
     */
    public final long zzq(zzjg[] var1_1, boolean[] var2_2, zziu[] var3_3, boolean[] var4_4, long var5_5) {
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
}
