/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaCodec$CryptoException
 *  android.media.MediaCrypto
 *  android.media.MediaCryptoException
 *  android.media.MediaFormat
 *  android.os.Bundle
 *  android.os.SystemClock
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzadv
 *  com.google.android.gms.internal.ads.zzadx
 *  com.google.android.gms.internal.ads.zzae
 *  com.google.android.gms.internal.ads.zzaeg
 *  com.google.android.gms.internal.ads.zzaf
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzafw
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzalw
 *  com.google.android.gms.internal.ads.zzamm
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzaz
 *  com.google.android.gms.internal.ads.zzba
 *  com.google.android.gms.internal.ads.zzfg
 *  com.google.android.gms.internal.ads.zzfj
 *  com.google.android.gms.internal.ads.zzfk
 *  com.google.android.gms.internal.ads.zzfl
 *  com.google.android.gms.internal.ads.zzfm
 *  com.google.android.gms.internal.ads.zzfn
 *  com.google.android.gms.internal.ads.zzfo
 *  com.google.android.gms.internal.ads.zzfp
 *  com.google.android.gms.internal.ads.zzfs
 *  com.google.android.gms.internal.ads.zzfy
 *  com.google.android.gms.internal.ads.zzgh
 */
package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zzadv;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzae;
import com.google.android.gms.internal.ads.zzaeg;
import com.google.android.gms.internal.ads.zzaf;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzafw;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzalw;
import com.google.android.gms.internal.ads.zzamm;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzaz;
import com.google.android.gms.internal.ads.zzba;
import com.google.android.gms.internal.ads.zzfg;
import com.google.android.gms.internal.ads.zzfj;
import com.google.android.gms.internal.ads.zzfk;
import com.google.android.gms.internal.ads.zzfl;
import com.google.android.gms.internal.ads.zzfm;
import com.google.android.gms.internal.ads.zzfn;
import com.google.android.gms.internal.ads.zzfo;
import com.google.android.gms.internal.ads.zzfp;
import com.google.android.gms.internal.ads.zzfs;
import com.google.android.gms.internal.ads.zzfy;
import com.google.android.gms.internal.ads.zzgh;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public abstract class zzfq
extends zzadv {
    private static final byte[] zzb = new byte[]{0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    private ArrayDeque<zzfo> zzA;
    private zzfp zzB;
    private zzfo zzC;
    private int zzD;
    private boolean zzE;
    private boolean zzF;
    private boolean zzG;
    private boolean zzH;
    private boolean zzI;
    private boolean zzJ;
    private boolean zzK;
    private boolean zzL;
    private boolean zzM;
    private boolean zzN;
    private zzfk zzO;
    private long zzP;
    private int zzQ;
    private int zzR;
    private ByteBuffer zzS;
    private boolean zzT;
    private boolean zzU;
    private boolean zzV;
    private boolean zzW;
    private boolean zzX;
    private boolean zzY;
    private int zzZ;
    protected zzaz zza;
    private int zzaa;
    private int zzab;
    private boolean zzac;
    private boolean zzad;
    private boolean zzae;
    private long zzaf;
    private long zzag;
    private boolean zzah;
    private boolean zzai;
    private boolean zzaj;
    private long zzak;
    private long zzal;
    private int zzam;
    private zzgh zzan;
    private zzfg zzao;
    private zzfg zzap;
    private final zzfm zzc;
    private final zzfs zzd;
    private final float zze;
    private final zzaf zzf;
    private final zzaf zzg;
    private final zzaf zzh;
    private final zzfj zzi;
    private final zzamm<zzafv> zzj;
    private final ArrayList<Long> zzk;
    private final MediaCodec.BufferInfo zzl;
    private final long[] zzm;
    private final long[] zzn;
    private final long[] zzo;
    private zzafv zzp;
    private zzafv zzq;
    private MediaCrypto zzr;
    private boolean zzs;
    private long zzt;
    private float zzu;
    private float zzv;
    private zzafv zzw;
    private MediaFormat zzx;
    private boolean zzy;
    private float zzz;

    public zzfq(int n, zzfm zzfm2, zzfs zzfs2, boolean bl, float f) {
        super(n);
        this.zzc = zzfm2;
        if (zzfs2 == null) throw null;
        this.zzd = zzfs2;
        this.zze = f;
        this.zzf = new zzaf(0, 0);
        this.zzg = new zzaf(0, 0);
        this.zzh = new zzaf(2, 0);
        this.zzi = new zzfj();
        this.zzj = new zzamm(10);
        this.zzk = new ArrayList();
        this.zzl = new MediaCodec.BufferInfo();
        this.zzu = 1.0f;
        this.zzv = 1.0f;
        this.zzt = -9223372036854775807L;
        this.zzm = new long[10];
        this.zzn = new long[10];
        this.zzo = new long[10];
        this.zzak = -9223372036854775807L;
        this.zzal = -9223372036854775807L;
        this.zzi.zzi(0);
        this.zzi.zzb.order(ByteOrder.nativeOrder());
        this.zzz = -1.0f;
        this.zzD = 0;
        this.zzZ = 0;
        this.zzQ = -1;
        this.zzR = -1;
        this.zzP = -9223372036854775807L;
        this.zzaf = -9223372036854775807L;
        this.zzag = -9223372036854775807L;
        this.zzaa = 0;
        this.zzab = 0;
    }

    private final void zzA() {
        this.zzQ = -1;
        this.zzg.zzb = null;
    }

    protected static boolean zzY(zzafv zzafv2) {
        if (zzafv2.zzE == 0) return true;
        return false;
    }

    private final void zza() {
        this.zzX = false;
        this.zzi.zza();
        this.zzh.zza();
        this.zzW = false;
        this.zzV = false;
    }

    private final boolean zzaA(zzafv zzafv2) throws zzaeg {
        if (zzamq.zza < 23) {
            return true;
        }
        if (this.zzan == null) return true;
        if (this.zzab == 3) return true;
        if (this.zzaf() == 0) return true;
        float f = this.zzz;
        float f2 = this.zzj(this.zzv, zzafv2, this.zzau());
        if (f == f2) {
            return true;
        }
        if (f2 == -1.0f) {
            this.zzaC();
            return false;
        }
        if (f == -1.0f) {
            if (!(f2 > this.zze)) return true;
        }
        zzafv2 = new Bundle();
        zzafv2.putFloat("operating-rate", f2);
        this.zzan.zzm((Bundle)zzafv2);
        this.zzz = f2;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    private final boolean zzaB() throws zzaeg {
        if (!this.zzac) {
            this.zzaE();
            return true;
        }
        this.zzaa = 1;
        if (!this.zzF && !this.zzH) {
            this.zzab = 2;
            return true;
        }
        this.zzab = 3;
        return false;
    }

    private final void zzaC() throws zzaeg {
        if (this.zzac) {
            this.zzaa = 1;
            this.zzab = 3;
            return;
        }
        this.zzN();
        this.zzI();
    }

    private final void zzaD() throws zzaeg {
        int n = this.zzab;
        if (n == 1) {
            this.zzb();
            return;
        }
        if (n == 2) {
            this.zzb();
            this.zzaE();
            return;
        }
        if (n != 3) {
            this.zzai = true;
            this.zzD();
            return;
        }
        this.zzN();
        this.zzI();
    }

    private final void zzaE() throws zzaeg {
        try {
            throw null;
        }
        catch (MediaCryptoException mediaCryptoException) {
            throw this.zzaw(mediaCryptoException, this.zzp, false, 6006);
        }
    }

    private final void zzaa() {
        this.zzR = -1;
        this.zzS = null;
    }

    /*
     * Unable to fully structure code
     */
    private final boolean zzab() throws zzaeg {
        var11_1 = this.zzan;
        if (var11_1 == null) return false;
        if (this.zzaa == 2) return false;
        if (this.zzah) {
            return false;
        }
        if (this.zzQ < 0) {
            this.zzQ = var1_5 = var11_1.zza();
            if (var1_5 < 0) {
                return false;
            }
            this.zzg.zzb = this.zzan.zzd(var1_5);
            this.zzg.zza();
        }
        if (this.zzaa == 1) {
            if (!this.zzN) {
                this.zzad = true;
                this.zzan.zzf(this.zzQ, 0, 0, 0L, 4);
                this.zzA();
            }
            this.zzaa = 2;
            return false;
        }
        if (this.zzL) {
            this.zzL = false;
            this.zzg.zzb.put(zzfq.zzb);
            this.zzan.zzf(this.zzQ, 0, 38, 0L, 0);
            this.zzA();
            this.zzac = true;
            return true;
        }
        if (this.zzZ == 1) {
            for (var1_5 = 0; var1_5 < this.zzw.zzn.size(); ++var1_5) {
                var11_1 = (byte[])this.zzw.zzn.get(var1_5);
                this.zzg.zzb.put((byte[])var11_1);
            }
            this.zzZ = 2;
        }
        var1_5 = this.zzg.zzb.position();
        var11_1 = this.zzat();
        try {
            var2_6 = this.zzax((zzafw)var11_1, this.zzg, 0);
        }
        catch (zzae var11_4) {
            this.zzm((Exception)var11_4);
            this.zzp(0);
            this.zzb();
            return true;
        }
        if (this.zzak()) {
            this.zzag = this.zzaf;
        }
        if (var2_6 == -3) {
            return false;
        }
        if (var2_6 == -5) {
            if (this.zzZ == 2) {
                this.zzg.zza();
                this.zzZ = 1;
            }
            this.zzn((zzafw)var11_1);
            return true;
        }
        if (this.zzg.zzc()) {
            if (this.zzZ == 2) {
                this.zzg.zza();
                this.zzZ = 1;
            }
            this.zzah = true;
            if (!this.zzac) {
                this.zzaD();
                return false;
            }
            try {
                if (this.zzN != false) return false;
                this.zzad = true;
                this.zzan.zzf(this.zzQ, 0, 0, 0L, 4);
                this.zzA();
                return false;
            }
            catch (MediaCodec.CryptoException var11_2) {
                throw this.zzaw(var11_2, this.zzp, false, zzadx.zze((int)var11_2.getErrorCode()));
            }
        }
        if (!this.zzac && !this.zzg.zzd()) {
            this.zzg.zza();
            if (this.zzZ != 2) return true;
            this.zzZ = 1;
            return true;
        }
        var8_7 = this.zzg.zzj();
        if (var8_7) {
            this.zzg.zza.zzc(var1_5);
        }
        if (this.zzE && !var8_7) {
            block36: {
                var11_1 = this.zzg.zzb;
                var12_8 = zzalw.zza;
                var7_9 = var11_1.position();
                var4_10 = 0;
                var1_5 = 0;
                while ((var5_12 = var4_10 + 1) < var7_9) {
                    var6_13 = var11_1.get(var4_10) & 255;
                    if (var1_5 == 3) {
                        var2_6 = var1_5;
                        var3_11 = var6_13;
                        if (var6_13 == 1) {
                            if ((var11_1.get(var5_12) & 31) == 7) {
                                var12_8 = var11_1.duplicate();
                                var12_8.position(var4_10 - 3);
                                var12_8.limit(var7_9);
                                var11_1.position(0);
                                var11_1.put((ByteBuffer)var12_8);
                                break block36;
                            }
                            var3_11 = 1;
                            var2_6 = var1_5;
                        }
                    } else {
                        var2_6 = var1_5;
                        var3_11 = var6_13;
                        if (var6_13 == 0) {
                            var2_6 = var1_5 + 1;
                            var3_11 = var6_13;
                        }
                    }
                    var1_5 = var2_6;
                    if (var3_11 != 0) {
                        var1_5 = 0;
                    }
                    var4_10 = var5_12;
                }
                var11_1.clear();
            }
            if (this.zzg.zzb.position() == 0) {
                return true;
            }
            this.zzE = false;
        }
        var11_1 = this.zzg;
        var9_14 = var11_1.zzd;
        var12_8 = this.zzO;
        if (var12_8 != null) {
            var9_14 = var12_8.zzb(this.zzp, (zzaf)var11_1);
            this.zzaf = Math.max(this.zzaf, this.zzO.zzc(this.zzp));
        }
        if (this.zzg.zzb()) {
            this.zzk.add(var9_14);
        }
        if (this.zzaj) {
            this.zzj.zza(var9_14, (Object)this.zzp);
            this.zzaj = false;
        }
        this.zzaf = Math.max(this.zzaf, var9_14);
        this.zzg.zzk();
        if (this.zzg.zze()) {
            this.zzU(this.zzg);
        }
        this.zzB(this.zzg);
        if (!var8_7) ** GOTO lbl144
        try {
            block37: {
                this.zzan.zzg(this.zzQ, 0, this.zzg.zza, var9_14, 0);
                break block37;
lbl144:
                // 1 sources

                this.zzan.zzf(this.zzQ, 0, this.zzg.zzb.limit(), var9_14, 0);
            }
            this.zzA();
            this.zzac = true;
            this.zzZ = 0;
            var11_1 = this.zza;
            ++var11_1.zzc;
            return true;
        }
        catch (MediaCodec.CryptoException var11_3) {
            throw this.zzaw(var11_3, this.zzp, false, zzadx.zze((int)var11_3.getErrorCode()));
        }
    }

    private final void zzb() {
        try {
            this.zzan.zzj();
            return;
        }
        finally {
            this.zzR();
        }
    }

    private final boolean zzp(int n) throws zzaeg {
        zzafw zzafw2 = this.zzat();
        this.zzf.zza();
        n = this.zzax(zzafw2, this.zzf, n | 4);
        if (n == -5) {
            this.zzn(zzafw2);
            return true;
        }
        if (n != -4) return false;
        if (!this.zzf.zzc()) return false;
        this.zzah = true;
        this.zzaD();
        return false;
    }

    private final boolean zzy(long l) {
        if (this.zzt == -9223372036854775807L) return true;
        if (SystemClock.elapsedRealtime() - l >= this.zzt) return false;
        return true;
    }

    private final boolean zzz() {
        if (this.zzR < 0) return false;
        return true;
    }

    protected void zzB(zzaf zzaf2) throws zzaeg {
        throw null;
    }

    protected void zzC() {
    }

    protected void zzD() throws zzaeg {
    }

    protected abstract boolean zzF(long var1, long var3, zzgh var5, ByteBuffer var6, int var7, int var8, int var9, long var10, boolean var12, boolean var13, zzafv var14) throws zzaeg;

    public final int zzG() {
        return 8;
    }

    public final int zzH(zzafv zzafv2) throws zzaeg {
        try {
            int n = this.zzd(this.zzd, zzafv2);
            return n;
        }
        catch (zzfy zzfy2) {
            throw this.zzaw(zzfy2, zzafv2, false, 4002);
        }
    }

    /*
     * Exception decompiling
     */
    protected final void zzI() throws zzaeg {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [12[CATCHBLOCK]], but top level block is 6[TRYBLOCK]
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

    protected boolean zzJ(zzfo zzfo2) {
        return true;
    }

    protected final zzfo zzK() {
        return this.zzC;
    }

    protected final void zzL(zzafv[] object, long l, long l2) throws zzaeg {
        long l3 = this.zzal;
        boolean bl = true;
        if (l3 == -9223372036854775807L) {
            if (this.zzak != -9223372036854775807L) {
                bl = false;
            }
            zzakt.zzd((boolean)bl);
            this.zzak = l;
            this.zzal = l2;
            return;
        }
        int n = this.zzam;
        if (n == 10) {
            l3 = this.zzn[9];
            object = new StringBuilder(65);
            ((StringBuilder)object).append("Too many stream changes, so dropping offset: ");
            ((StringBuilder)object).append(l3);
            Log.w((String)"MediaCodecRenderer", (String)((StringBuilder)object).toString());
        } else {
            this.zzam = n + 1;
        }
        object = this.zzm;
        n = this.zzam - 1;
        object[n] = l;
        this.zzn[n] = l2;
        this.zzo[n] = this.zzaf;
    }

    public void zzM(float f, float f2) throws zzaeg {
        this.zzu = f;
        this.zzv = f2;
        this.zzaA(this.zzw);
    }

    protected final void zzN() {
        try {
            zzgh zzgh2 = this.zzan;
            if (zzgh2 == null) return;
            zzgh2.zzk();
            zzgh2 = this.zza;
            ++zzgh2.zzb;
            this.zzl(this.zzC.zza);
            return;
        }
        finally {
            this.zzan = null;
            this.zzr = null;
            this.zzao = null;
            this.zzS();
        }
    }

    /*
     * Exception decompiling
     */
    public final void zzO(long var1_1, long var3_2) throws zzaeg {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 29[UNCONDITIONALDOLOOP]
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

    protected final boolean zzP() throws zzaeg {
        boolean bl = this.zzQ();
        if (!bl) return bl;
        this.zzI();
        return bl;
    }

    protected final boolean zzQ() {
        if (this.zzan == null) {
            return false;
        }
        if (!(this.zzab == 3 || this.zzF || this.zzG && !this.zzae || this.zzH && this.zzad)) {
            this.zzb();
            return false;
        }
        this.zzN();
        return true;
    }

    protected void zzR() {
        this.zzA();
        this.zzaa();
        this.zzP = -9223372036854775807L;
        this.zzad = false;
        this.zzac = false;
        this.zzL = false;
        this.zzM = false;
        this.zzT = false;
        this.zzU = false;
        this.zzk.clear();
        this.zzaf = -9223372036854775807L;
        this.zzag = -9223372036854775807L;
        zzfk zzfk2 = this.zzO;
        if (zzfk2 != null) {
            zzfk2.zza();
        }
        this.zzaa = 0;
        this.zzab = 0;
        this.zzZ = this.zzY ? 1 : 0;
    }

    protected final void zzS() {
        this.zzR();
        this.zzO = null;
        this.zzA = null;
        this.zzC = null;
        this.zzw = null;
        this.zzx = null;
        this.zzy = false;
        this.zzae = false;
        this.zzz = -1.0f;
        this.zzD = 0;
        this.zzE = false;
        this.zzF = false;
        this.zzG = false;
        this.zzH = false;
        this.zzI = false;
        this.zzJ = false;
        this.zzK = false;
        this.zzN = false;
        this.zzY = false;
        this.zzZ = 0;
        this.zzs = false;
    }

    protected zzfn zzT(Throwable throwable, zzfo zzfo2) {
        return new zzfn(throwable, zzfo2);
    }

    protected void zzU(zzaf zzaf2) throws zzaeg {
    }

    protected void zzV(long l) {
        int n;
        while ((n = this.zzam) != 0) {
            if (l < this.zzo[0]) return;
            long[] lArray = this.zzm;
            this.zzak = lArray[0];
            this.zzal = this.zzn[0];
            this.zzam = --n;
            System.arraycopy(lArray, 1, lArray, 0, n);
            lArray = this.zzn;
            System.arraycopy(lArray, 1, lArray, 0, this.zzam);
            lArray = this.zzo;
            System.arraycopy(lArray, 1, lArray, 0, this.zzam);
            this.zzC();
        }
    }

    protected final float zzW() {
        return this.zzu;
    }

    protected final long zzX() {
        return this.zzal;
    }

    protected final zzgh zzZ() {
        return this.zzan;
    }

    protected abstract int zzd(zzfs var1, zzafv var2) throws zzfy;

    protected abstract List<zzfo> zze(zzfs var1, zzafv var2, boolean var3) throws zzfy;

    protected boolean zzf(zzafv zzafv2) {
        return false;
    }

    protected abstract zzfl zzg(zzfo var1, zzafv var2, MediaCrypto var3, float var4);

    protected zzba zzh(zzfo zzfo2, zzafv zzafv2, zzafv zzafv3) {
        throw null;
    }

    protected float zzj(float f, zzafv zzafv2, zzafv[] zzafvArray) {
        throw null;
    }

    protected void zzk(String string, long l, long l2) {
        throw null;
    }

    protected void zzl(String string) {
        throw null;
    }

    protected void zzm(Exception exception) {
        throw null;
    }

    protected zzba zzn(zzafw zzafw2) throws zzaeg {
        zzfg zzfg2;
        zzafv zzafv2;
        zzfo zzfo2;
        zzfg zzfg3;
        zzafv zzafv3;
        block4: {
            int n;
            zzgh zzgh2;
            block12: {
                block9: {
                    block5: {
                        block10: {
                            block14: {
                                block13: {
                                    block11: {
                                        block8: {
                                            block6: {
                                                boolean bl;
                                                boolean bl2;
                                                block7: {
                                                    bl2 = true;
                                                    this.zzaj = true;
                                                    zzafv3 = zzafw2.zza;
                                                    if (zzafv3 == null) throw null;
                                                    if (zzafv3.zzl == null) throw this.zzaw(new IllegalArgumentException(), zzafv3, false, 4005);
                                                    this.zzap = zzfg3 = zzafw2.zzb;
                                                    this.zzp = zzafv3;
                                                    if (this.zzV) {
                                                        this.zzX = true;
                                                        return null;
                                                    }
                                                    zzgh2 = this.zzan;
                                                    if (zzgh2 == null) {
                                                        this.zzA = null;
                                                        this.zzI();
                                                        return null;
                                                    }
                                                    zzfo2 = this.zzC;
                                                    zzafv2 = this.zzw;
                                                    zzfg2 = this.zzao;
                                                    if (zzfg2 != zzfg3) break block4;
                                                    bl = zzfg3 == zzfg2 || zzamq.zza >= 23;
                                                    zzakt.zzd((boolean)bl);
                                                    zzafw2 = this.zzh(zzfo2, zzafv2, zzafv3);
                                                    n = zzafw2.zzd;
                                                    if (n == 0) break block5;
                                                    if (n == 1) break block6;
                                                    if (n == 2) break block7;
                                                    if (!this.zzaA(zzafv3)) break block8;
                                                    this.zzw = zzafv3;
                                                    if (zzfg3 == zzfg2 || this.zzaB()) break block9;
                                                    break block10;
                                                }
                                                if (!this.zzaA(zzafv3)) break block8;
                                                this.zzY = true;
                                                this.zzZ = 1;
                                                n = this.zzD;
                                                bl = bl2;
                                                if (n != 2) {
                                                    bl = n == 1 && zzafv3.zzq == zzafv2.zzq && zzafv3.zzr == zzafv2.zzr ? bl2 : false;
                                                }
                                                this.zzL = bl;
                                                this.zzw = zzafv3;
                                                if (zzfg3 == zzfg2 || this.zzaB()) break block9;
                                                break block10;
                                            }
                                            if (this.zzaA(zzafv3)) break block11;
                                        }
                                        n = 16;
                                        break block12;
                                    }
                                    this.zzw = zzafv3;
                                    if (zzfg3 == zzfg2) break block13;
                                    if (this.zzaB()) break block9;
                                    break block10;
                                }
                                if (!this.zzac) break block9;
                                this.zzaa = 1;
                                if (this.zzF || this.zzH) break block14;
                                this.zzab = 1;
                                break block9;
                            }
                            this.zzab = 3;
                        }
                        n = 2;
                        break block12;
                    }
                    this.zzaC();
                }
                n = 0;
            }
            if (zzafw2.zzd == 0) return zzafw2;
            if (this.zzan != zzgh2) return new zzba(zzfo2.zza, zzafv2, zzafv3, 0, n);
            if (this.zzab != 3) return zzafw2;
            return new zzba(zzfo2.zza, zzafv2, zzafv3, 0, n);
        }
        if (zzfg3 != null && zzfg2 != null && zzamq.zza >= 23 && !zzadx.zze.equals(zzadx.zza)) {
            zzadx.zze.equals(zzadx.zza);
        }
        this.zzaC();
        return new zzba(zzfo2.zza, zzafv2, zzafv3, 0, 128);
    }

    protected void zzo(zzafv zzafv2, MediaFormat mediaFormat) throws zzaeg {
        throw null;
    }

    protected void zzq(boolean bl, boolean bl2) throws zzaeg {
        this.zza = new zzaz();
    }

    protected void zzr(long l, boolean bl) throws zzaeg {
        this.zzah = false;
        this.zzai = false;
        if (this.zzV) {
            this.zzi.zza();
            this.zzh.zza();
            this.zzW = false;
        } else {
            this.zzP();
        }
        if (this.zzj.zzc() > 0) {
            this.zzaj = true;
        }
        this.zzj.zzb();
        int n = this.zzam;
        if (n == 0) return;
        this.zzal = this.zzn[--n];
        this.zzak = this.zzm[n];
        this.zzam = 0;
    }

    protected void zzu() {
        this.zzp = null;
        this.zzak = -9223372036854775807L;
        this.zzal = -9223372036854775807L;
        this.zzam = 0;
        this.zzQ();
    }

    protected void zzv() {
        try {
            this.zza();
            this.zzN();
            return;
        }
        finally {
            this.zzap = null;
        }
    }

    public boolean zzw() {
        return this.zzai;
    }

    public boolean zzx() {
        boolean bl;
        zzafv zzafv2 = this.zzp;
        boolean bl2 = true;
        if (zzafv2 != null) {
            bl = bl2;
            if (this.zzaz()) return bl;
            bl = bl2;
            if (this.zzz()) return bl;
            if (this.zzP != -9223372036854775807L) {
                if (SystemClock.elapsedRealtime() < this.zzP) return true;
            }
        }
        bl = false;
        return bl;
    }
}
