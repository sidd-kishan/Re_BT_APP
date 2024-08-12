/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Message
 *  android.os.SystemClock
 *  android.util.Log
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.zzamy
 *  com.google.android.gms.internal.ads.zzanb
 *  com.google.android.gms.internal.ads.zzanc
 *  com.google.android.gms.internal.ads.zzang
 *  com.google.android.gms.internal.ads.zzanh
 *  com.google.android.gms.internal.ads.zzani
 *  com.google.android.gms.internal.ads.zzanj
 *  com.google.android.gms.internal.ads.zzanm
 *  com.google.android.gms.internal.ads.zzano
 *  com.google.android.gms.internal.ads.zzanq
 *  com.google.android.gms.internal.ads.zzanr
 *  com.google.android.gms.internal.ads.zzans
 *  com.google.android.gms.internal.ads.zzant
 *  com.google.android.gms.internal.ads.zzanv
 *  com.google.android.gms.internal.ads.zzanw
 *  com.google.android.gms.internal.ads.zzanx
 *  com.google.android.gms.internal.ads.zzaso
 *  com.google.android.gms.internal.ads.zzasp
 *  com.google.android.gms.internal.ads.zzasq
 *  com.google.android.gms.internal.ads.zzasr
 *  com.google.android.gms.internal.ads.zzatk
 *  com.google.android.gms.internal.ads.zzatt
 *  com.google.android.gms.internal.ads.zzatu
 *  com.google.android.gms.internal.ads.zzaup
 *  com.google.android.gms.internal.ads.zzaut
 *  com.google.android.gms.internal.ads.zzava
 *  com.google.android.gms.internal.ads.zzcjy
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzamy;
import com.google.android.gms.internal.ads.zzanb;
import com.google.android.gms.internal.ads.zzanc;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzanh;
import com.google.android.gms.internal.ads.zzani;
import com.google.android.gms.internal.ads.zzanj;
import com.google.android.gms.internal.ads.zzanm;
import com.google.android.gms.internal.ads.zzano;
import com.google.android.gms.internal.ads.zzanq;
import com.google.android.gms.internal.ads.zzanr;
import com.google.android.gms.internal.ads.zzans;
import com.google.android.gms.internal.ads.zzant;
import com.google.android.gms.internal.ads.zzanv;
import com.google.android.gms.internal.ads.zzanw;
import com.google.android.gms.internal.ads.zzanx;
import com.google.android.gms.internal.ads.zzaso;
import com.google.android.gms.internal.ads.zzasp;
import com.google.android.gms.internal.ads.zzasq;
import com.google.android.gms.internal.ads.zzasr;
import com.google.android.gms.internal.ads.zzatk;
import com.google.android.gms.internal.ads.zzatt;
import com.google.android.gms.internal.ads.zzatu;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzaut;
import com.google.android.gms.internal.ads.zzava;
import com.google.android.gms.internal.ads.zzcjy;
import java.io.IOException;

final class zzank
implements Handler.Callback,
zzaso,
zzatt,
zzasq {
    private zzani zzA;
    private long zzB;
    private zzang zzC;
    private zzang zzD;
    private zzang zzE;
    private zzanx zzF;
    private boolean zzG;
    private volatile int zzH;
    private volatile int zzI;
    private final zzcjy zzJ;
    private final zzanr[] zza;
    private final zzans[] zzb;
    private final zzatu zzc;
    private final zzava zzd;
    private final Handler zze;
    private final HandlerThread zzf;
    private final Handler zzg;
    private final zzanc zzh;
    private final zzanw zzi;
    private final zzanv zzj;
    private zzanh zzk;
    private zzanq zzl;
    private zzanr zzm;
    private zzaut zzn;
    private zzasr zzo;
    private zzanr[] zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private int zzu;
    private int zzv;
    private int zzw;
    private int zzx;
    private long zzy;
    private int zzz;

    public zzank(zzanr[] handlerThread, zzatu zzatu2, zzcjy zzcjy2, boolean bl, int n, Handler handler, zzanh zzanh2, zzanc zzanc2, byte[] byArray) {
        this.zza = handlerThread;
        this.zzc = zzatu2;
        this.zzJ = zzcjy2;
        this.zzr = bl;
        this.zzv = 0;
        this.zzg = handler;
        this.zzu = 1;
        this.zzk = zzanh2;
        this.zzh = zzanc2;
        this.zzb = new zzans[2];
        n = 0;
        while (true) {
            if (n >= 2) {
                this.zzd = new zzava();
                this.zzp = new zzanr[0];
                this.zzi = new zzanw();
                this.zzj = new zzanv();
                zzatu2.zzf((zzatt)this);
                this.zzl = zzanq.zza;
                this.zzf = handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
                handlerThread.start();
                this.zze = new Handler(this.zzf.getLooper(), (Handler.Callback)this);
                return;
            }
            handlerThread[n].zzc(n);
            this.zzb[n] = handlerThread[n].zzb();
            ++n;
        }
    }

    private final void zzA(Object object, int n) {
        this.zzk = new zzanh(0, 0L);
        this.zzB(object, n);
        this.zzk = new zzanh(0, -9223372036854775807L);
        this.zzo(4);
        this.zzx(false);
    }

    private final void zzB(Object object, int n) {
        this.zzg.obtainMessage(6, (Object)new zzanj(this.zzF, object, this.zzk, n)).sendToTarget();
    }

    private final int zzC(int n, zzanx zzanx2, zzanx zzanx3) {
        int n2 = zzanx2.zzc();
        int n3 = 0;
        int n4 = -1;
        int n5 = n;
        n = n4;
        while (n3 < n2) {
            if (n != -1) return n;
            n5 = zzanx2.zzh(n5, this.zzj, this.zzi, this.zzv);
            n = zzanx3.zze(zzanx2.zzd((int)n5, (zzanv)this.zzj, (boolean)true).zzb);
            ++n3;
        }
        return n;
    }

    private final boolean zzD(int n) {
        this.zzF.zzd(n, this.zzj, false);
        this.zzF.zzg(0, this.zzi, false);
        if (this.zzF.zzh(n, this.zzj, this.zzi, this.zzv) != -1) return false;
        return true;
    }

    private final Pair<Integer, Long> zzE(zzani zzani2) {
        Pair<Integer, Long> pair;
        Pair<Integer, Long> pair2 = pair = zzani2.zza;
        if (pair.zzf()) {
            pair2 = this.zzF;
        }
        try {
            int n = zzani2.zzb;
            pair = this.zzG((zzanx)pair2, 0, zzani2.zzc);
            zzani2 = this.zzF;
            if (zzani2 == pair2) {
                return pair;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            zzanx zzanx2 = this.zzF;
            int n = zzani2.zzb;
            throw new zzano(zzanx2, 0, zzani2.zzc);
        }
        if (zzani2.zze(pair2.zzd((int)((Integer)pair.first).intValue(), (zzanv)this.zzj, (boolean)true).zzb) != -1) {
            return Pair.create((Object)0, (Object)((Long)pair.second));
        }
        if (this.zzC((Integer)pair.first, (zzanx)pair2, this.zzF) == -1) return null;
        this.zzF.zzd(0, this.zzj, false);
        return this.zzF(0, -9223372036854775807L);
    }

    private final Pair<Integer, Long> zzF(int n, long l) {
        return this.zzG(this.zzF, 0, -9223372036854775807L);
    }

    private final Pair<Integer, Long> zzG(zzanx zzanx2, int n, long l) {
        return this.zzH(zzanx2, 0, l, 0L);
    }

    private final Pair<Integer, Long> zzH(zzanx zzanx2, int n, long l, long l2) {
        zzaup.zzc((int)0, (int)0, (int)zzanx2.zza());
        zzanx2.zzb(0, this.zzi, false, l2);
        l2 = l;
        if (l == -9223372036854775807L) {
            l2 = 0L;
        }
        if ((l = zzanx2.zzd((int)0, (zzanv)this.zzj, (boolean)false).zzc) == -9223372036854775807L) return Pair.create((Object)0, (Object)l2);
        return Pair.create((Object)0, (Object)l2);
    }

    private final void zzI() {
        zzang zzang2 = this.zzC;
        long l = !zzang2.zzj ? 0L : zzang2.zza.zza();
        if (l == Long.MIN_VALUE) {
            this.zzp(false);
            return;
        }
        zzang2 = this.zzC;
        long l2 = this.zzB - (zzang2.zzf - zzang2.zzh);
        boolean bl = this.zzJ.zzf(l - l2);
        this.zzp(bl);
        if (!bl) return;
        this.zzC.zza.zzb(l2);
    }

    private final void zzJ(zzang zzang2) throws zzamy {
        if (this.zzE == zzang2) {
            return;
        }
        boolean[] blArray = new boolean[2];
        int n = 0;
        int n2 = 0;
        while (true) {
            if (n >= 2) {
                this.zzE = zzang2;
                this.zzg.obtainMessage(3, (Object)zzang2.zzm).sendToTarget();
                this.zzK(blArray, n2);
                return;
            }
            zzanr zzanr2 = this.zza[n];
            boolean bl = zzanr2.zze() != 0;
            blArray[n] = bl;
            zzatk zzatk2 = zzang2.zzm.zzb.zza(n);
            int n3 = n2;
            if (zzatk2 != null) {
                n3 = n2 + 1;
            }
            if (blArray[n] && (zzatk2 == null || zzanr2.zzl() && zzanr2.zzi() == this.zzE.zzd[n])) {
                if (zzanr2 == this.zzm) {
                    this.zzd.zzd(this.zzn);
                    this.zzn = null;
                    this.zzm = null;
                }
                zzank.zzL(zzanr2);
                zzanr2.zzp();
            }
            ++n;
            n2 = n3;
        }
    }

    private final void zzK(boolean[] blArray, int n) throws zzamy {
        this.zzp = new zzanr[n];
        n = 0;
        int n2 = 0;
        while (n < 2) {
            zzanr zzanr2 = this.zza[n];
            zzatk zzatk2 = this.zzE.zzm.zzb.zza(n);
            if (zzatk2 != null) {
                this.zzp[n2] = zzanr2;
                if (zzanr2.zze() == 0) {
                    zzant zzant2 = this.zzE.zzm.zzd[n];
                    boolean bl = this.zzr && this.zzu == 3;
                    boolean bl2 = !blArray[n] && bl;
                    zzatk2.zzb();
                    zzanm[] zzanmArray = new zzanm[1];
                    for (int i = 0; i <= 0; ++i) {
                        zzanmArray[i] = zzatk2.zzc(i);
                    }
                    zzatk2 = this.zzE;
                    zzanr2.zzf(zzant2, zzanmArray, zzatk2.zzd[n], this.zzB, bl2, zzatk2.zzf - zzatk2.zzh);
                    zzant2 = zzanr2.zzd();
                    if (zzant2 != null) {
                        if (this.zzn != null) throw zzamy.zzc((RuntimeException)new IllegalStateException("Multiple renderer media clocks enabled."));
                        this.zzn = zzant2;
                        this.zzm = zzanr2;
                        zzant2.zzQ(this.zzl);
                    }
                    if (bl) {
                        zzanr2.zzg();
                    }
                }
                ++n2;
            }
            ++n;
        }
    }

    private static final void zzL(zzanr zzanr2) throws zzamy {
        if (zzanr2.zze() != 2) return;
        zzanr2.zzo();
    }

    private static final void zzM(zzang zzang2) {
        while (zzang2 != null) {
            zzang2.zze();
            zzang2 = zzang2.zzl;
        }
    }

    private final void zzo(int n) {
        if (this.zzu == n) return;
        this.zzu = n;
        this.zzg.obtainMessage(1, n, 0).sendToTarget();
    }

    private final void zzp(boolean bl) {
        if (this.zzt == bl) return;
        this.zzt = bl;
        this.zzg.obtainMessage(2, bl ? 1 : 0, 0).sendToTarget();
    }

    private final void zzq() throws zzamy {
        int n = 0;
        this.zzs = false;
        this.zzd.zza();
        zzanr[] zzanrArray = this.zzp;
        int n2 = zzanrArray.length;
        while (n < n2) {
            zzanrArray[n].zzg();
            ++n;
        }
    }

    private final void zzr() throws zzamy {
        this.zzd.zzb();
        zzanr[] zzanrArray = this.zzp;
        int n = zzanrArray.length;
        int n2 = 0;
        while (n2 < n) {
            zzank.zzL(zzanrArray[n2]);
            ++n2;
        }
    }

    private final void zzs() throws zzamy {
        zzang zzang2 = this.zzE;
        if (zzang2 == null) {
            return;
        }
        long l = zzang2.zza.zzp();
        if (l != -9223372036854775807L) {
            this.zzv(l);
        } else {
            zzang2 = this.zzm;
            if (zzang2 != null && !zzang2.zzF()) {
                this.zzB = l = this.zzn.zzP();
                this.zzd.zzc(l);
            } else {
                this.zzB = this.zzd.zzP();
            }
            zzang2 = this.zzE;
            l = this.zzB - (zzang2.zzf - zzang2.zzh);
        }
        this.zzk.zzc = l;
        this.zzy = SystemClock.elapsedRealtime() * 1000L;
        l = this.zzp.length == 0 ? Long.MIN_VALUE : this.zzE.zza.zzq();
        zzang2 = this.zzk;
        long l2 = l;
        if (l == Long.MIN_VALUE) {
            l2 = this.zzF.zzd((int)this.zzE.zzg, (zzanv)this.zzj, (boolean)false).zzc;
        }
        zzang2.zzd = l2;
    }

    private final void zzt(long l, long l2) {
        this.zze.removeMessages(2);
        l = l + l2 - SystemClock.elapsedRealtime();
        if (l <= 0L) {
            this.zze.sendEmptyMessage(2);
            return;
        }
        this.zze.sendEmptyMessageDelayed(2, l);
    }

    private final long zzu(int n, long l) throws zzamy {
        zzang zzang2;
        this.zzr();
        this.zzs = false;
        this.zzo(2);
        zzang zzang3 = this.zzE;
        if (zzang3 == null) {
            zzang3 = this.zzC;
            if (zzang3 != null) {
                zzang3.zze();
            }
            zzang2 = null;
        } else {
            zzang zzang4 = null;
            while (true) {
                zzang2 = zzang4;
                if (zzang3 == null) break;
                if (zzang3.zzg == n && zzang3.zzj) {
                    zzang4 = zzang3;
                } else {
                    zzang3.zze();
                }
                zzang3 = zzang3.zzl;
            }
        }
        zzang3 = this.zzE;
        if (zzang3 != zzang2 || zzang3 != this.zzD) {
            zzang3 = this.zzp;
            int n2 = ((zzanr[])zzang3).length;
            for (n = 0; n < n2; ++n) {
                zzang3[n].zzp();
            }
            this.zzp = new zzanr[0];
            this.zzn = null;
            this.zzm = null;
            this.zzE = null;
        }
        if (zzang2 != null) {
            zzang2.zzl = null;
            this.zzC = zzang2;
            this.zzD = zzang2;
            this.zzJ(zzang2);
            zzang3 = this.zzE;
            long l2 = l;
            if (zzang3.zzk) {
                l2 = zzang3.zza.zzr(l);
            }
            this.zzv(l2);
            this.zzI();
            l = l2;
        } else {
            this.zzC = null;
            this.zzD = null;
            this.zzE = null;
            this.zzv(l);
        }
        this.zze.sendEmptyMessage(2);
        return l;
    }

    private final void zzv(long l) throws zzamy {
        zzanr[] zzanrArray = this.zzE;
        l = zzanrArray == null ? (l += 60000000L) : (l += zzanrArray.zzf - zzanrArray.zzh);
        this.zzB = l;
        this.zzd.zzc(l);
        zzanrArray = this.zzp;
        int n = zzanrArray.length;
        int n2 = 0;
        while (n2 < n) {
            zzanrArray[n2].zzn(this.zzB);
            ++n2;
        }
    }

    private final void zzw() {
        this.zzx(true);
        this.zzJ.zzc();
        this.zzo(1);
    }

    private final void zzx(boolean bl) {
        zzanr zzanr22;
        this.zze.removeMessages(2);
        this.zzs = false;
        this.zzd.zzb();
        this.zzn = null;
        this.zzm = null;
        this.zzB = 60000000L;
        for (zzanr zzanr22 : this.zzp) {
            try {
                zzank.zzL(zzanr22);
                zzanr22.zzp();
                continue;
            }
            catch (RuntimeException runtimeException) {
            }
            catch (zzamy zzamy2) {
                // empty catch block
            }
            Log.e((String)"ExoPlayerImplInternal", (String)"Stop failed.", (Throwable)zzanr22);
        }
        this.zzp = new zzanr[0];
        zzang zzang2 = this.zzE;
        zzanr22 = zzang2;
        if (zzang2 == null) {
            zzanr22 = this.zzC;
        }
        zzank.zzM((zzang)zzanr22);
        this.zzC = null;
        this.zzD = null;
        this.zzE = null;
        this.zzp(false);
        if (!bl) return;
        zzanr22 = this.zzo;
        if (zzanr22 != null) {
            zzanr22.zzd();
            this.zzo = null;
        }
        this.zzF = null;
    }

    private final boolean zzy(long l) {
        boolean bl = false;
        if (l != -9223372036854775807L && this.zzk.zzc >= l) {
            zzang zzang2 = this.zzE.zzl;
            if (zzang2 == null) return bl;
            if (!zzang2.zzj) return false;
        }
        bl = true;
        return bl;
    }

    private final void zzz() throws IOException {
        zzang zzang2 = this.zzC;
        if (zzang2 == null) return;
        if (zzang2.zzj) return;
        zzanr[] zzanrArray = this.zzD;
        if (zzanrArray != null) {
            if (zzanrArray.zzl != zzang2) return;
        }
        zzanrArray = this.zzp;
        int n = zzanrArray.length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.zzC.zza.zzm();
                return;
            }
            if (!zzanrArray[n2].zzj()) {
                return;
            }
            ++n2;
        }
    }

    /*
     * Exception decompiling
     */
    public final boolean handleMessage(Message var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 10[TRYBLOCK] [75 : 492->494)] java.lang.Throwable
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

    public final void zza() {
        this.zzG = true;
    }

    public final void zzb(zzasr zzasr2, boolean bl) {
        this.zze.obtainMessage(0, 1, 0, (Object)zzasr2).sendToTarget();
    }

    public final void zzc(boolean bl) {
        this.zze.obtainMessage(1, bl ? 1 : 0, 0).sendToTarget();
    }

    public final void zzd(zzanx zzanx2, int n, long l) {
        this.zze.obtainMessage(3, (Object)new zzani(zzanx2, 0, l)).sendToTarget();
    }

    public final void zze() {
        this.zze.sendEmptyMessage(5);
    }

    public final void zzf(zzanb ... zzanbArray) {
        if (this.zzq) {
            Log.w((String)"ExoPlayerImplInternal", (String)"Ignoring messages sent after release.");
            return;
        }
        ++this.zzw;
        this.zze.obtainMessage(11, (Object)zzanbArray).sendToTarget();
    }

    public final void zzg(zzanb ... zzanbArray) {
        synchronized (this) {
            try {
                int n;
                if (this.zzq) {
                    Log.w((String)"ExoPlayerImplInternal", (String)"Ignoring messages sent after release.");
                    return;
                }
                int n2 = this.zzw;
                this.zzw = n2 + 1;
                this.zze.obtainMessage(11, (Object)zzanbArray).sendToTarget();
                while ((n = this.zzx) <= n2) {
                    try {
                        this.wait();
                    }
                    catch (InterruptedException interruptedException) {
                        Thread.currentThread().interrupt();
                    }
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzh() {
        synchronized (this) {
            boolean bl = this.zzq;
            if (bl) {
                return;
            }
            this.zze.sendEmptyMessage(6);
            while (true) {
                if (bl = this.zzq) {
                    this.zzf.quit();
                    return;
                }
                try {
                    this.wait();
                }
                catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public final void zzi(zzanx zzanx2, Object object) {
        this.zze.obtainMessage(7, (Object)Pair.create((Object)zzanx2, null)).sendToTarget();
    }

    public final void zzj(zzasp zzasp2) {
        this.zze.obtainMessage(8, (Object)zzasp2).sendToTarget();
    }

    public final void zzk() {
        this.zze.sendEmptyMessage(10);
    }

    public final void zzl(int n) {
        this.zzH = n;
    }

    public final void zzm(int n) {
        this.zzI = n;
    }
}
