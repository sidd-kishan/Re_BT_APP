/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCrypto
 *  android.media.MediaFormat
 *  android.os.Handler
 *  com.google.android.gms.internal.ads.zzamy
 *  com.google.android.gms.internal.ads.zzanm
 *  com.google.android.gms.internal.ads.zzanq
 *  com.google.android.gms.internal.ads.zzaob
 *  com.google.android.gms.internal.ads.zzaoi
 *  com.google.android.gms.internal.ads.zzaoj
 *  com.google.android.gms.internal.ads.zzaon
 *  com.google.android.gms.internal.ads.zzaoo
 *  com.google.android.gms.internal.ads.zzaop
 *  com.google.android.gms.internal.ads.zzaos
 *  com.google.android.gms.internal.ads.zzaot
 *  com.google.android.gms.internal.ads.zzaov
 *  com.google.android.gms.internal.ads.zzapl
 *  com.google.android.gms.internal.ads.zzarg
 *  com.google.android.gms.internal.ads.zzari
 *  com.google.android.gms.internal.ads.zzark
 *  com.google.android.gms.internal.ads.zzarm
 *  com.google.android.gms.internal.ads.zzarr
 *  com.google.android.gms.internal.ads.zzaut
 *  com.google.android.gms.internal.ads.zzauu
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.gms.internal.ads.zzamy;
import com.google.android.gms.internal.ads.zzanm;
import com.google.android.gms.internal.ads.zzanq;
import com.google.android.gms.internal.ads.zzaob;
import com.google.android.gms.internal.ads.zzaoi;
import com.google.android.gms.internal.ads.zzaoj;
import com.google.android.gms.internal.ads.zzaon;
import com.google.android.gms.internal.ads.zzaoo;
import com.google.android.gms.internal.ads.zzaop;
import com.google.android.gms.internal.ads.zzaos;
import com.google.android.gms.internal.ads.zzaot;
import com.google.android.gms.internal.ads.zzaov;
import com.google.android.gms.internal.ads.zzapl;
import com.google.android.gms.internal.ads.zzarg;
import com.google.android.gms.internal.ads.zzari;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzarm;
import com.google.android.gms.internal.ads.zzarr;
import com.google.android.gms.internal.ads.zzaut;
import com.google.android.gms.internal.ads.zzauu;
import com.google.android.gms.internal.ads.zzave;
import java.nio.ByteBuffer;

public final class zzaox
extends zzari
implements zzaut {
    private final zzaoi zzb;
    private final zzaot zzc;
    private boolean zzd;
    private int zze;
    private int zzf;
    private long zzg;
    private boolean zzh;

    public zzaox(zzark zzark2, zzapl zzapl2, boolean bl, Handler handler, zzaoj zzaoj2) {
        super(1, zzark2, null, true);
        zzark2 = new zzaov(this, null);
        this.zzc = new zzaot(null, new zzaob[0], (zzaop)zzark2);
        this.zzb = new zzaoi(handler, zzaoj2);
    }

    static /* synthetic */ zzaoi zzH(zzaox zzaox2) {
        return zzaox2.zzb;
    }

    static /* synthetic */ boolean zzI(zzaox zzaox2, boolean bl) {
        zzaox2.zzh = true;
        return true;
    }

    public final boolean zzE() {
        if (this.zzc.zzi()) return true;
        if (!super.zzE()) return false;
        return true;
    }

    public final boolean zzF() {
        if (!super.zzF()) return false;
        if (!this.zzc.zzh()) return false;
        return true;
    }

    protected final int zzJ(zzark object, zzanm zzanm2) throws zzarm {
        object = zzanm2.zzf;
        if (!zzauu.zza((String)object)) {
            return 0;
        }
        int n = zzave.zza >= 21 ? 16 : 0;
        if ((object = zzarr.zza((String)object, (boolean)false)) == null) {
            return 1;
        }
        int n2 = zzave.zza;
        int n3 = 2;
        if (n2 >= 21) {
            int n4 = zzanm2.zzs;
            if (n4 != -1) {
                n2 = n3;
                if (!object.zzf(n4)) return n | 4 | n2;
            }
            if ((n4 = zzanm2.zzr) != -1) {
                n2 = n3;
                if (!object.zzg(n4)) return n | 4 | n2;
            }
        }
        n2 = 3;
        return n | 4 | n2;
    }

    protected final zzarg zzK(zzark zzark2, zzanm zzanm2, boolean bl) throws zzarm {
        return super.zzK(zzark2, zzanm2, false);
    }

    /*
     * Exception decompiling
     */
    protected final void zzL(zzarg var1_1, MediaCodec var2_2, zzanm var3_3, MediaCrypto var4_4) {
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

    protected final void zzM(String string, long l, long l2) {
        this.zzb.zzc(string, l, l2);
    }

    protected final void zzN(zzanm zzanm2) throws zzamy {
        super.zzN(zzanm2);
        this.zzb.zzd(zzanm2);
        int n = "audio/raw".equals(zzanm2.zzf) ? zzanm2.zzt : 2;
        this.zze = n;
        this.zzf = zzanm2.zzr;
    }

    protected final void zzO(MediaCodec object, MediaFormat mediaFormat) throws zzamy {
        int n = mediaFormat.getInteger("channel-count");
        int n2 = mediaFormat.getInteger("sample-rate");
        if (this.zzd && n == 6) {
            n = this.zzf;
            if (n < 6) {
                object = new int[n];
                for (n = 0; n < this.zzf; ++n) {
                    object[n] = (MediaCodec)n;
                }
            } else {
                object = null;
            }
            n = 6;
        } else {
            object = null;
        }
        try {
            this.zzc.zzc("audio/raw", n, n2, this.zze, 0, (int[])object);
            return;
        }
        catch (zzaon zzaon2) {
            zzamy zzamy2 = zzamy.zza((Exception)((Object)zzaon2), (int)this.zzz());
            throw zzamy2;
        }
    }

    public final long zzP() {
        long l = this.zzc.zzb(this.zzF());
        if (l == Long.MIN_VALUE) return this.zzg;
        if (!this.zzh) {
            l = Math.max(this.zzg, l);
        }
        this.zzg = l;
        this.zzh = false;
        return this.zzg;
    }

    public final zzanq zzQ(zzanq zzanq2) {
        return this.zzc.zzj(zzanq2);
    }

    public final zzanq zzR() {
        return this.zzc.zzk();
    }

    /*
     * WARNING - void declaration
     */
    protected final boolean zzS(long l, long l2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int n, int n2, long l3, boolean bl) throws zzamy {
        void var5_6;
        if (bl) {
            mediaCodec.releaseOutputBuffer(n, false);
            mediaCodec = this.zza;
            ++mediaCodec.zze;
            this.zzc.zze();
            return true;
        }
        try {
            if (!this.zzc.zzf(byteBuffer, l3)) return false;
            mediaCodec.releaseOutputBuffer(n, false);
            mediaCodec = this.zza;
            ++mediaCodec.zzd;
            return true;
        }
        catch (zzaos zzaos2) {
        }
        catch (zzaoo zzaoo2) {
            // empty catch block
        }
        throw zzamy.zza((Exception)var5_6, (int)this.zzz());
    }

    protected final void zzT() throws zzamy {
        try {
            this.zzc.zzg();
            return;
        }
        catch (zzaos zzaos2) {
            throw zzamy.zza((Exception)((Object)zzaos2), (int)this.zzz());
        }
    }

    public final zzaut zzd() {
        return this;
    }

    public final void zzr(int n, Object object) throws zzamy {
        if (n != 2) {
            return;
        }
        this.zzc.zzl(((Float)object).floatValue());
    }

    protected final void zzs(boolean bl) throws zzamy {
        super.zzs(bl);
        this.zzb.zzb(this.zza);
        int n = this.zzy().zzb;
    }

    protected final void zzu(long l, boolean bl) throws zzamy {
        super.zzu(l, bl);
        this.zzc.zzn();
        this.zzg = l;
        this.zzh = true;
    }

    protected final void zzv() {
        this.zzc.zzd();
    }

    protected final void zzw() {
        this.zzc.zzm();
    }

    protected final void zzx() {
        try {
            this.zzc.zzo();
        }
        catch (Throwable throwable) {
            try {
                super.zzx();
                throw throwable;
            }
            finally {
                this.zza.zza();
                this.zzb.zzf(this.zza);
            }
        }
        try {
            super.zzx();
            return;
        }
        finally {
            this.zza.zza();
            this.zzb.zzf(this.zza);
        }
    }
}
