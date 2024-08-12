/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.AudioTrack
 *  android.os.ConditionVariable
 *  android.os.SystemClock
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzamx
 *  com.google.android.gms.internal.ads.zzanq
 *  com.google.android.gms.internal.ads.zzany
 *  com.google.android.gms.internal.ads.zzanz
 *  com.google.android.gms.internal.ads.zzaob
 *  com.google.android.gms.internal.ads.zzaok
 *  com.google.android.gms.internal.ads.zzaol
 *  com.google.android.gms.internal.ads.zzaom
 *  com.google.android.gms.internal.ads.zzaon
 *  com.google.android.gms.internal.ads.zzaoo
 *  com.google.android.gms.internal.ads.zzaop
 *  com.google.android.gms.internal.ads.zzaor
 *  com.google.android.gms.internal.ads.zzaos
 *  com.google.android.gms.internal.ads.zzaou
 *  com.google.android.gms.internal.ads.zzaov
 *  com.google.android.gms.internal.ads.zzaox
 *  com.google.android.gms.internal.ads.zzaoy
 *  com.google.android.gms.internal.ads.zzapa
 *  com.google.android.gms.internal.ads.zzaup
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zzamx;
import com.google.android.gms.internal.ads.zzanq;
import com.google.android.gms.internal.ads.zzany;
import com.google.android.gms.internal.ads.zzanz;
import com.google.android.gms.internal.ads.zzaob;
import com.google.android.gms.internal.ads.zzaok;
import com.google.android.gms.internal.ads.zzaol;
import com.google.android.gms.internal.ads.zzaom;
import com.google.android.gms.internal.ads.zzaon;
import com.google.android.gms.internal.ads.zzaoo;
import com.google.android.gms.internal.ads.zzaop;
import com.google.android.gms.internal.ads.zzaor;
import com.google.android.gms.internal.ads.zzaos;
import com.google.android.gms.internal.ads.zzaou;
import com.google.android.gms.internal.ads.zzaov;
import com.google.android.gms.internal.ads.zzaox;
import com.google.android.gms.internal.ads.zzaoy;
import com.google.android.gms.internal.ads.zzapa;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzave;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;

public final class zzaot {
    private Method zzA;
    private int zzB;
    private long zzC;
    private long zzD;
    private int zzE;
    private long zzF;
    private long zzG;
    private int zzH;
    private int zzI;
    private long zzJ;
    private long zzK;
    private long zzL;
    private float zzM;
    private zzaob[] zzN;
    private ByteBuffer[] zzO;
    private ByteBuffer zzP;
    private ByteBuffer zzQ;
    private byte[] zzR;
    private int zzS;
    private int zzT;
    private boolean zzU;
    private boolean zzV;
    private int zzW;
    private boolean zzX;
    private long zzY;
    private final zzaou zza;
    private final zzapa zzb;
    private final zzaob[] zzc;
    private final zzaop zzd;
    private final ConditionVariable zze;
    private final long[] zzf;
    private final zzaol zzg;
    private final LinkedList<zzaor> zzh;
    private AudioTrack zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private boolean zzn;
    private int zzo;
    private long zzp;
    private zzanq zzq;
    private zzanq zzr;
    private long zzs;
    private long zzt;
    private int zzu;
    private int zzv;
    private long zzw;
    private long zzx;
    private boolean zzy;
    private long zzz;

    public zzaot(zzanz zzaobArray, zzaob[] zzaobArray2, zzaop zzaop2) {
        this.zzd = zzaop2;
        this.zze = new ConditionVariable(true);
        if (zzave.zza >= 18) {
            try {
                this.zzA = AudioTrack.class.getMethod("getLatency", null);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                // empty catch block
            }
        }
        this.zzg = zzave.zza >= 19 ? new zzaom() : new zzaol(null);
        this.zza = new zzaou();
        this.zzb = new zzapa();
        zzaobArray = new zzaob[3];
        this.zzc = zzaobArray;
        zzaobArray[0] = new zzaoy();
        zzaobArray = this.zzc;
        zzaobArray[1] = this.zza;
        System.arraycopy(zzaobArray2, 0, zzaobArray, 2, 0);
        this.zzc[2] = this.zzb;
        this.zzf = new long[10];
        this.zzM = 1.0f;
        this.zzI = 0;
        this.zzW = 0;
        this.zzr = zzanq.zza;
        this.zzT = -1;
        this.zzN = new zzaob[0];
        this.zzO = new ByteBuffer[0];
        this.zzh = new LinkedList();
    }

    static /* synthetic */ ConditionVariable zza(zzaot zzaot2) {
        return zzaot2.zze;
    }

    private final void zzp() {
        zzaob zzaob2;
        int n;
        ArrayList<zzaob> arrayList = new ArrayList<zzaob>();
        zzaob[] zzaobArray = this.zzc;
        int n2 = 0;
        for (n = 0; n < 3; ++n) {
            zzaob2 = zzaobArray[n];
            if (zzaob2.zzb()) {
                arrayList.add(zzaob2);
                continue;
            }
            zzaob2.zzi();
        }
        int n3 = arrayList.size();
        this.zzN = arrayList.toArray(new zzaob[n3]);
        this.zzO = new ByteBuffer[n3];
        n = n2;
        while (n < n3) {
            zzaob2 = this.zzN[n];
            zzaob2.zzi();
            this.zzO[n] = zzaob2.zzg();
            ++n;
        }
    }

    private final void zzq(long l) throws zzaos {
        int n;
        int n2 = n = this.zzN.length;
        while (n2 >= 0) {
            ByteBuffer byteBuffer;
            ByteBuffer byteBuffer2;
            if (n2 > 0) {
                byteBuffer2 = this.zzO[n2 - 1];
            } else {
                byteBuffer2 = byteBuffer = this.zzP;
                if (byteBuffer == null) {
                    byteBuffer2 = zzaob.zza;
                }
            }
            if (n2 == n) {
                this.zzr(byteBuffer2, l);
            } else {
                byteBuffer = this.zzN[n2];
                byteBuffer.zze(byteBuffer2);
                this.zzO[n2] = byteBuffer = byteBuffer.zzg();
                if (byteBuffer.hasRemaining()) {
                    ++n2;
                    continue;
                }
            }
            if (byteBuffer2.hasRemaining()) {
                return;
            }
            --n2;
        }
    }

    private final boolean zzr(ByteBuffer byteBuffer, long l) throws zzaos {
        int n;
        int n2;
        boolean bl;
        if (!byteBuffer.hasRemaining()) {
            return true;
        }
        Object object = this.zzQ;
        if (object != null) {
            bl = object == byteBuffer;
            zzaup.zza((boolean)bl);
        } else {
            this.zzQ = byteBuffer;
            if (zzave.zza < 21) {
                n2 = byteBuffer.remaining();
                object = this.zzR;
                if (object == null || ((Object)object).length < n2) {
                    this.zzR = new byte[n2];
                }
                n = byteBuffer.position();
                byteBuffer.get(this.zzR, 0, n2);
                byteBuffer.position(n);
                this.zzS = 0;
            }
        }
        int n3 = byteBuffer.remaining();
        if (zzave.zza < 21) {
            l = this.zzF;
            long l2 = this.zzg.zzd();
            n2 = this.zzE;
            if ((n2 = this.zzo - (int)(l - l2 * (long)n2)) > 0) {
                n2 = Math.min(n3, n2);
                n2 = n = this.zzi.write(this.zzR, this.zzS, n2);
                if (n > 0) {
                    this.zzS += n;
                    byteBuffer.position(byteBuffer.position() + n);
                    n2 = n;
                }
            } else {
                n2 = 0;
            }
        } else {
            n2 = this.zzi.write(byteBuffer, n3, 1);
        }
        this.zzY = SystemClock.elapsedRealtime();
        if (n2 < 0) throw new zzaos(n2);
        bl = this.zzn;
        if (!bl) {
            this.zzF += (long)n2;
        }
        if (n2 != n3) return false;
        if (bl) {
            this.zzG += (long)this.zzH;
        }
        this.zzQ = null;
        return true;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final boolean zzs() throws zzaos {
        block4: {
            block5: {
                if (this.zzT == -1) break block5;
                var1_1 = 0;
                ** GOTO lbl9
            }
            var1_1 = this.zzn != false ? this.zzN.length : 0;
            this.zzT = var1_1;
            do {
                var1_1 = 1;
lbl9:
                // 2 sources

                var2_2 = ++this.zzT;
                var3_3 /* !! */  = this.zzN;
                if (var2_2 >= ((zzaob[])var3_3 /* !! */ ).length) break block4;
                var3_3 /* !! */  = var3_3 /* !! */ [var2_2];
                if (var1_1 != 0) {
                    var3_3 /* !! */ .zzf();
                }
                this.zzq(-9223372036854775807L);
            } while (var3_3 /* !! */ .zzh());
            return false;
        }
        var3_3 /* !! */  = this.zzQ;
        if (var3_3 /* !! */  != null) {
            this.zzr((ByteBuffer)var3_3 /* !! */ , -9223372036854775807L);
            if (this.zzQ != null) {
                return false;
            }
        }
        this.zzT = -1;
        return true;
    }

    private final void zzt() {
        if (!this.zzu()) {
            return;
        }
        if (zzave.zza >= 21) {
            this.zzi.setVolume(this.zzM);
            return;
        }
        AudioTrack audioTrack = this.zzi;
        float f = this.zzM;
        audioTrack.setStereoVolume(f, f);
    }

    private final boolean zzu() {
        if (this.zzi == null) return false;
        return true;
    }

    private final long zzv(long l) {
        return l * 1000000L / (long)this.zzj;
    }

    private final long zzw(long l) {
        return l * (long)this.zzj / 1000000L;
    }

    private final long zzx() {
        long l = this.zzn ? this.zzG : this.zzF / (long)this.zzE;
        return l;
    }

    private final void zzy() {
        this.zzw = 0L;
        this.zzv = 0;
        this.zzu = 0;
        this.zzx = 0L;
        this.zzy = false;
        this.zzz = 0L;
    }

    private final boolean zzz() {
        int n = zzave.zza;
        boolean bl = true;
        if (n < 23) {
            n = this.zzm;
            if (n == 5) return bl;
            if (n == 6) return true;
        }
        bl = false;
        return bl;
    }

    public final long zzb(boolean bl) {
        long l;
        long l2;
        Object object;
        long l3;
        long l4;
        if (!this.zzu()) return Long.MIN_VALUE;
        if (this.zzI == 0) return Long.MIN_VALUE;
        if (this.zzi.getPlayState() == 3 && (l4 = this.zzg.zze()) != 0L) {
            l3 = System.nanoTime() / 1000L;
            if (l3 - this.zzx >= 30000L) {
                int n;
                object = this.zzf;
                int n2 = this.zzu;
                object[n2] = l4 - l3;
                this.zzu = (n2 + 1) % 10;
                n2 = this.zzv;
                if (n2 < 10) {
                    this.zzv = n2 + 1;
                }
                this.zzx = l3;
                this.zzw = 0L;
                for (n2 = 0; n2 < (n = this.zzv); this.zzw += this.zzf[n2] / (long)n, ++n2) {
                }
            }
            if (!this.zzz() && l3 - this.zzz >= 500000L) {
                boolean bl2;
                this.zzy = bl2 = this.zzg.zzf();
                if (bl2) {
                    l2 = this.zzg.zzg() / 1000L;
                    l = this.zzg.zzh();
                    if (l2 < this.zzK) {
                        this.zzy = false;
                    } else if (Math.abs(l2 - l3) > 5000000L) {
                        object = new StringBuilder(136);
                        ((StringBuilder)object).append("Spurious audio timestamp (system clock mismatch): ");
                        ((StringBuilder)object).append(l);
                        ((StringBuilder)object).append(", ");
                        ((StringBuilder)object).append(l2);
                        ((StringBuilder)object).append(", ");
                        ((StringBuilder)object).append(l3);
                        ((StringBuilder)object).append(", ");
                        ((StringBuilder)object).append(l4);
                        Log.w((String)"AudioTrack", (String)((StringBuilder)object).toString());
                        this.zzy = false;
                    } else if (Math.abs(this.zzv(l) - l4) > 5000000L) {
                        object = new StringBuilder(138);
                        ((StringBuilder)object).append("Spurious audio timestamp (frame position mismatch): ");
                        ((StringBuilder)object).append(l);
                        ((StringBuilder)object).append(", ");
                        ((StringBuilder)object).append(l2);
                        ((StringBuilder)object).append(", ");
                        ((StringBuilder)object).append(l3);
                        ((StringBuilder)object).append(", ");
                        ((StringBuilder)object).append(l4);
                        Log.w((String)"AudioTrack", (String)((StringBuilder)object).toString());
                        this.zzy = false;
                    }
                }
                if ((object = (Object)this.zzA) != null && !this.zzn) {
                    try {
                        this.zzL = l4 = (long)((Integer)((Method)object).invoke(this.zzi, null)).intValue() * 1000L - this.zzp;
                        this.zzL = l4 = Math.max(l4, 0L);
                        if (l4 > 5000000L) {
                            object = new StringBuilder(61);
                            ((StringBuilder)object).append("Ignoring impossibly large audio latency: ");
                            ((StringBuilder)object).append(l4);
                            Log.w((String)"AudioTrack", (String)((StringBuilder)object).toString());
                            this.zzL = 0L;
                        }
                    }
                    catch (Exception exception) {
                        this.zzA = null;
                    }
                }
                this.zzz = l3;
            }
        }
        l3 = System.nanoTime() / 1000L;
        if (this.zzy) {
            l3 = this.zzw(l3 - this.zzg.zzg() / 1000L);
            l3 = this.zzv(this.zzg.zzh() + l3);
        } else {
            l4 = this.zzv == 0 ? this.zzg.zze() : l3 + this.zzw;
            l3 = l4;
            if (!bl) {
                l3 = l4 - this.zzL;
            }
        }
        l = this.zzJ;
        while (!this.zzh.isEmpty() && l3 >= zzaor.zzc((zzaor)this.zzh.getFirst())) {
            object = this.zzh.remove();
            this.zzr = zzaor.zza((zzaor)object);
            this.zzt = zzaor.zzc((zzaor)object);
            this.zzs = zzaor.zzb((zzaor)object) - this.zzJ;
        }
        if (this.zzr.zzb == 1.0f) {
            l3 = l3 + this.zzs - this.zzt;
        } else {
            if (this.zzh.isEmpty() && this.zzb.zzn() >= 1024L) {
                l2 = this.zzs;
                l4 = zzave.zzj((long)(l3 - this.zzt), (long)this.zzb.zzm(), (long)this.zzb.zzn());
                l3 = l2;
            } else {
                l4 = this.zzs;
                double d = this.zzr.zzb;
                double d2 = l3 - this.zzt;
                Double.isNaN(d);
                Double.isNaN(d2);
                l2 = (long)(d * d2);
                l3 = l4;
                l4 = l2;
            }
            l3 = l4 + l3;
        }
        return l + l3;
    }

    /*
     * Exception decompiling
     */
    public final void zzc(String var1_1, int var2_3, int var3_4, int var4_5, int var5_6, int[] var6_7) throws zzaon {
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

    public final void zzd() {
        this.zzV = true;
        if (!this.zzu()) return;
        this.zzK = System.nanoTime() / 1000L;
        this.zzi.play();
    }

    public final void zze() {
        if (this.zzI != 1) return;
        this.zzI = 2;
    }

    public final boolean zzf(ByteBuffer object, long l) throws zzaoo, zzaos {
        long l2;
        long l3;
        int n;
        Object object2 = this.zzP;
        boolean bl = object2 == null || object == object2;
        zzaup.zza((boolean)bl);
        if (!this.zzu()) {
            this.zze.block();
            n = this.zzW;
            this.zzi = n == 0 ? new AudioTrack(3, this.zzj, this.zzk, this.zzm, this.zzo, 1) : new AudioTrack(3, this.zzj, this.zzk, this.zzm, this.zzo, 1, n);
            n = this.zzi.getState();
            if (n == 1) {
                n = this.zzi.getAudioSessionId();
                if (this.zzW != n) {
                    this.zzW = n;
                    zzaox.zzH((zzaox)((zzaov)this.zzd).zza).zzg(n);
                }
                this.zzg.zza(this.zzi, this.zzz());
                this.zzt();
                this.zzX = false;
                if (this.zzV) {
                    this.zzd();
                }
            } else {
                try {
                    this.zzi.release();
                }
                catch (Exception exception) {
                    this.zzi = null;
                }
                finally {
                    this.zzi = null;
                }
                throw new zzaoo(n, this.zzj, this.zzk, this.zzo);
            }
        }
        if (this.zzz()) {
            if (this.zzi.getPlayState() == 2) {
                this.zzX = false;
                return false;
            }
            if (this.zzi.getPlayState() == 1) {
                if (this.zzg.zzd() != 0L) return false;
            }
        }
        boolean bl2 = this.zzX;
        this.zzX = bl = this.zzi();
        if (bl2 && !bl && this.zzi.getPlayState() != 1) {
            l3 = SystemClock.elapsedRealtime();
            long l4 = this.zzY;
            object2 = this.zzd;
            n = this.zzo;
            l2 = zzamx.zza((long)this.zzp);
            zzaox.zzH((zzaox)((zzaov)object2).zza).zze(n, l2, l3 - l4);
        }
        if (this.zzP == null) {
            if (!((Buffer)object).hasRemaining()) {
                return true;
            }
            if (this.zzn && this.zzH == 0) {
                n = this.zzm;
                if (n != 7 && n != 8) {
                    if (n == 5) {
                        n = zzany.zza;
                        n = 1536;
                    } else {
                        if (n != 6) {
                            object = new StringBuilder(38);
                            ((StringBuilder)object).append("Unexpected audio encoding: ");
                            ((StringBuilder)object).append(n);
                            throw new IllegalStateException(((StringBuilder)object).toString());
                        }
                        n = zzany.zzc((ByteBuffer)object);
                    }
                } else {
                    int n2 = ((Buffer)object).position();
                    n = ((ByteBuffer)object).get(n2 + 4);
                    n = (((((ByteBuffer)object).get(n2 + 5) & 0xFC) >> 2 | (n & 1) << 6) + 1) * 32;
                }
                this.zzH = n;
            }
            if (this.zzq != null) {
                if (!this.zzs()) {
                    return false;
                }
                this.zzh.add(new zzaor(this.zzq, Math.max(0L, l), this.zzv(this.zzx()), null));
                this.zzq = null;
                this.zzp();
            }
            if (this.zzI == 0) {
                this.zzJ = Math.max(0L, l);
                this.zzI = 1;
            } else {
                l2 = this.zzJ;
                l3 = this.zzn ? this.zzD : this.zzC / (long)this.zzB;
                l3 = l2 + this.zzv(l3);
                if (this.zzI == 1 && Math.abs(l3 - l) > 200000L) {
                    object2 = new StringBuilder(80);
                    ((StringBuilder)object2).append("Discontinuity detected [expected ");
                    ((StringBuilder)object2).append(l3);
                    ((StringBuilder)object2).append(", got ");
                    ((StringBuilder)object2).append(l);
                    ((StringBuilder)object2).append("]");
                    Log.e((String)"AudioTrack", (String)((StringBuilder)object2).toString());
                    this.zzI = 2;
                }
                if (this.zzI == 2) {
                    this.zzJ += l - l3;
                    this.zzI = 1;
                    zzaox.zzI((zzaox)((zzaov)this.zzd).zza, (boolean)true);
                }
            }
            if (this.zzn) {
                this.zzD += (long)this.zzH;
            } else {
                this.zzC += (long)((Buffer)object).remaining();
            }
            this.zzP = object;
        }
        if (this.zzn) {
            this.zzr(this.zzP, l);
        } else {
            this.zzq(l);
        }
        if (this.zzP.hasRemaining()) return false;
        this.zzP = null;
        return true;
    }

    public final void zzg() throws zzaos {
        if (this.zzU) return;
        if (!this.zzu()) return;
        if (!this.zzs()) return;
        this.zzg.zzb(this.zzx());
        this.zzU = true;
    }

    public final boolean zzh() {
        boolean bl = this.zzu();
        boolean bl2 = false;
        if (bl) {
            if (!this.zzU) return bl2;
            if (this.zzi()) return false;
        }
        bl2 = true;
        return bl2;
    }

    public final boolean zzi() {
        boolean bl = this.zzu();
        boolean bl2 = true;
        if (bl) {
            if (this.zzx() > this.zzg.zzd()) return bl2;
            if (this.zzz() && this.zzi.getPlayState() == 2) {
                if (this.zzi.getPlaybackHeadPosition() == 0) return true;
            }
        }
        bl2 = false;
        return bl2;
    }

    public final zzanq zzj(zzanq zzanq2) {
        if (this.zzn) {
            this.zzr = zzanq2 = zzanq.zza;
            return zzanq2;
        }
        float f = this.zzb.zzk(zzanq2.zzb);
        zzapa zzapa2 = this.zzb;
        float f2 = zzanq2.zzc;
        zzapa2.zzl(1.0f);
        zzanq zzanq3 = new zzanq(f, 1.0f);
        zzapa2 = this.zzq;
        zzanq2 = zzapa2;
        if (zzapa2 == null) {
            zzanq2 = !this.zzh.isEmpty() ? zzaor.zza((zzaor)this.zzh.getLast()) : this.zzr;
        }
        if (zzanq3.equals((Object)zzanq2)) return this.zzr;
        if (this.zzu()) {
            this.zzq = zzanq3;
        } else {
            this.zzr = zzanq3;
        }
        return this.zzr;
    }

    public final zzanq zzk() {
        return this.zzr;
    }

    public final void zzl(float f) {
        if (this.zzM == f) return;
        this.zzM = f;
        this.zzt();
    }

    public final void zzm() {
        this.zzV = false;
        if (!this.zzu()) return;
        this.zzy();
        this.zzg.zzc();
    }

    public final void zzn() {
        if (!this.zzu()) return;
        this.zzC = 0L;
        this.zzD = 0L;
        this.zzF = 0L;
        this.zzG = 0L;
        this.zzH = 0;
        zzaob zzaob2 = this.zzq;
        if (zzaob2 != null) {
            this.zzr = zzaob2;
            this.zzq = null;
        } else if (!this.zzh.isEmpty()) {
            this.zzr = zzaor.zza((zzaor)this.zzh.getLast());
        }
        this.zzh.clear();
        this.zzs = 0L;
        this.zzt = 0L;
        this.zzP = null;
        this.zzQ = null;
        for (int i = 0; i < ((zzaob[])(zzaob2 = this.zzN)).length; ++i) {
            zzaob2 = zzaob2[i];
            zzaob2.zzi();
            this.zzO[i] = zzaob2.zzg();
        }
        this.zzU = false;
        this.zzT = -1;
        this.zzI = 0;
        this.zzL = 0L;
        this.zzy();
        if (this.zzi.getPlayState() == 3) {
            this.zzi.pause();
        }
        zzaob2 = this.zzi;
        this.zzi = null;
        this.zzg.zza(null, false);
        this.zze.close();
        new zzaok(this, (AudioTrack)zzaob2).start();
    }

    public final void zzo() {
        this.zzn();
        zzaob[] zzaobArray = this.zzc;
        int n = 0;
        while (true) {
            if (n >= 3) {
                this.zzW = 0;
                this.zzV = false;
                return;
            }
            zzaobArray[n].zzj();
            ++n;
        }
    }
}
