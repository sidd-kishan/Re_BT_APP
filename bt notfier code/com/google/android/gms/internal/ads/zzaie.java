/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.media.AudioTrack
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.Surface
 *  com.google.android.gms.internal.ads.zzado
 *  com.google.android.gms.internal.ads.zzadp
 *  com.google.android.gms.internal.ads.zzads
 *  com.google.android.gms.internal.ads.zzadt
 *  com.google.android.gms.internal.ads.zzadu
 *  com.google.android.gms.internal.ads.zzadx
 *  com.google.android.gms.internal.ads.zzadz
 *  com.google.android.gms.internal.ads.zzaee
 *  com.google.android.gms.internal.ads.zzaeg
 *  com.google.android.gms.internal.ads.zzaeh
 *  com.google.android.gms.internal.ads.zzafe
 *  com.google.android.gms.internal.ads.zzafr
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzafy
 *  com.google.android.gms.internal.ads.zzahi
 *  com.google.android.gms.internal.ads.zzahj
 *  com.google.android.gms.internal.ads.zzahl
 *  com.google.android.gms.internal.ads.zzahp
 *  com.google.android.gms.internal.ads.zzahr
 *  com.google.android.gms.internal.ads.zzahs
 *  com.google.android.gms.internal.ads.zzahv
 *  com.google.android.gms.internal.ads.zzahy
 *  com.google.android.gms.internal.ads.zzahz
 *  com.google.android.gms.internal.ads.zzaia
 *  com.google.android.gms.internal.ads.zzaib
 *  com.google.android.gms.internal.ads.zzaic
 *  com.google.android.gms.internal.ads.zzaif
 *  com.google.android.gms.internal.ads.zzaij
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzair
 *  com.google.android.gms.internal.ads.zzais
 *  com.google.android.gms.internal.ads.zzaiw
 *  com.google.android.gms.internal.ads.zzakr
 *  com.google.android.gms.internal.ads.zzaku
 *  com.google.android.gms.internal.ads.zzakw
 *  com.google.android.gms.internal.ads.zzaln
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzaz
 *  com.google.android.gms.internal.ads.zzcy
 *  com.google.android.gms.internal.ads.zzda
 *  com.google.android.gms.internal.ads.zzdq
 *  com.google.android.gms.internal.ads.zzg
 *  com.google.android.gms.internal.ads.zzhh
 *  com.google.android.gms.internal.ads.zzhq
 *  com.google.android.gms.internal.ads.zzjz
 *  com.google.android.gms.internal.ads.zzki
 *  com.google.android.gms.internal.ads.zzmu
 *  com.google.android.gms.internal.ads.zzy
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.google.android.gms.internal.ads.zzado;
import com.google.android.gms.internal.ads.zzadp;
import com.google.android.gms.internal.ads.zzads;
import com.google.android.gms.internal.ads.zzadt;
import com.google.android.gms.internal.ads.zzadu;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzadz;
import com.google.android.gms.internal.ads.zzaee;
import com.google.android.gms.internal.ads.zzaeg;
import com.google.android.gms.internal.ads.zzaeh;
import com.google.android.gms.internal.ads.zzafe;
import com.google.android.gms.internal.ads.zzafr;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzafy;
import com.google.android.gms.internal.ads.zzahi;
import com.google.android.gms.internal.ads.zzahj;
import com.google.android.gms.internal.ads.zzahl;
import com.google.android.gms.internal.ads.zzahp;
import com.google.android.gms.internal.ads.zzahr;
import com.google.android.gms.internal.ads.zzahs;
import com.google.android.gms.internal.ads.zzahv;
import com.google.android.gms.internal.ads.zzahy;
import com.google.android.gms.internal.ads.zzahz;
import com.google.android.gms.internal.ads.zzaia;
import com.google.android.gms.internal.ads.zzaib;
import com.google.android.gms.internal.ads.zzaic;
import com.google.android.gms.internal.ads.zzaif;
import com.google.android.gms.internal.ads.zzaij;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzair;
import com.google.android.gms.internal.ads.zzais;
import com.google.android.gms.internal.ads.zzaiw;
import com.google.android.gms.internal.ads.zzakr;
import com.google.android.gms.internal.ads.zzaku;
import com.google.android.gms.internal.ads.zzakw;
import com.google.android.gms.internal.ads.zzaln;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzaz;
import com.google.android.gms.internal.ads.zzcy;
import com.google.android.gms.internal.ads.zzda;
import com.google.android.gms.internal.ads.zzdq;
import com.google.android.gms.internal.ads.zzg;
import com.google.android.gms.internal.ads.zzhh;
import com.google.android.gms.internal.ads.zzhq;
import com.google.android.gms.internal.ads.zzjz;
import com.google.android.gms.internal.ads.zzki;
import com.google.android.gms.internal.ads.zzmu;
import com.google.android.gms.internal.ads.zzy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

public final class zzaie
extends zzadu
implements zzahp {
    private float zzA;
    private boolean zzB;
    private List zzC;
    private boolean zzD;
    private boolean zzE;
    private zzaee zzF;
    private zzy zzG;
    protected final zzahv[] zzb;
    private final zzakw zzc;
    private final Context zzd;
    private final zzafe zze;
    private final zzaib zzf;
    private final zzaic zzg;
    private final CopyOnWriteArraySet<zzahl> zzh;
    private final zzcy zzi;
    private final zzadp zzj;
    private final zzadt zzk;
    private final zzaij zzl;
    private final zzair zzm;
    private final zzais zzn;
    private zzafv zzo;
    private zzafv zzp;
    private AudioTrack zzq;
    private Object zzr;
    private Surface zzs;
    private int zzt;
    private int zzu;
    private int zzv;
    private zzaz zzw;
    private zzaz zzx;
    private int zzy;
    private zzg zzz;

    /*
     * WARNING - void declaration
     */
    protected zzaie(zzaia zzaia2) {
        void var1_5;
        block10: {
            zzafe zzafe2;
            Looper looper;
            zzaku zzaku2;
            zzadz zzadz2;
            zzahz zzahz2;
            zzcy zzcy2;
            zzafy zzafy2;
            zzhq zzhq2;
            zzjz zzjz2;
            zzahv[] zzahvArray;
            zzaib zzaib2;
            zzahy zzahy2;
            Object object;
            this.zzc = new zzakw(zzaku.zza);
            try {
                this.zzd = zzaia.zza((zzaia)zzaia2).getApplicationContext();
                this.zzi = zzaia.zzh((zzaia)zzaia2);
                this.zzz = zzaia.zzj((zzaia)zzaia2);
                this.zzt = 1;
                this.zzB = false;
                this.zzf = object = new zzaib(this, null);
                super(null);
                this.zzg = object;
                super();
                this.zzh = object;
                super(zzaia.zzi((zzaia)zzaia2));
                zzahy2 = zzaia.zzb((zzaia)zzaia2);
                zzaib2 = this.zzf;
                this.zzb = zzahy2.zza((Handler)object, (zzmu)zzaib2, (zzdq)zzaib2, (zzakr)zzaib2, (zzaiw)zzaib2);
                this.zzA = 1.0f;
                if (zzamq.zza < 21) {
                    zzahy2 = this.zzq;
                    if (zzahy2 != null && zzahy2.getAudioSessionId() != 0) {
                        this.zzq.release();
                        this.zzq = null;
                    }
                    if (this.zzq == null) {
                        super(3, 4000, 4, 2, 2, 0, 0);
                        this.zzq = zzahy2;
                    }
                    this.zzy = this.zzq.getAudioSessionId();
                } else {
                    this.zzy = zzadx.zzc((Context)this.zzd);
                }
                this.zzC = Collections.emptyList();
                this.zzD = true;
                super();
                zzahy2.zzc(new int[]{20, 21, 22, 23, 24, 25, 26, 27});
                zzaib2 = zzahy2.zze();
                zzahvArray = this.zzb;
                zzjz2 = zzaia.zzd((zzaia)zzaia2);
                zzhq2 = zzaia.zze((zzaia)zzaia2);
                zzafy2 = zzaia.zzf((zzaia)zzaia2);
                zzahy2 = zzaia.zzg((zzaia)zzaia2);
                zzcy2 = this.zzi;
                zzahz2 = zzaia.zzk((zzaia)zzaia2);
                zzadz2 = zzaia.zzo((zzaia)zzaia2);
                zzaku2 = zzaia.zzc((zzaia)zzaia2);
                looper = zzaia.zzi((zzaia)zzaia2);
            }
            catch (Throwable throwable) {
                // empty catch block
                break block10;
            }
            try {
                zzafe2 = new zzafe(zzahvArray, zzjz2, zzhq2, zzafy2, (zzki)zzahy2, zzcy2, true, zzahz2, 5000L, 15000L, zzadz2, 500L, false, zzaku2, looper, (zzahp)this, (zzahi)zzaib2, null);
            }
            catch (Throwable throwable) {
                break block10;
            }
            try {
                this.zze = zzafe2;
                zzafe2.zzg((zzahj)this.zzf);
                this.zze.zzh((zzaeh)this.zzf);
                super(zzaia.zza((zzaia)zzaia2), (Handler)object, (zzado)this.zzf);
                this.zzj = zzahy2;
                super(zzaia.zza((zzaia)zzaia2), (Handler)object, (zzads)this.zzf);
                this.zzk = zzahy2;
                zzamq.zzc(null, null);
                super(zzaia.zza((zzaia)zzaia2), (Handler)object, (zzaif)this.zzf);
                this.zzl = zzahy2;
                int n = this.zzz.zzb;
                zzahy2.zzb(3);
                super(zzaia.zza((zzaia)zzaia2));
                this.zzm = object;
                super(zzaia.zza((zzaia)zzaia2));
                this.zzn = object;
                this.zzF = zzaie.zzah(this.zzl);
                this.zzG = com.google.android.gms.internal.ads.zzy.zza;
                this.zzag(1, 10, this.zzy);
                this.zzag(2, 10, this.zzy);
                this.zzag(1, 3, this.zzz);
                this.zzag(2, 4, this.zzt);
                this.zzag(2, 5, 0);
                this.zzag(1, 9, this.zzB);
                this.zzag(2, 7, this.zzg);
                this.zzag(6, 8, this.zzg);
            }
            catch (Throwable throwable) {
                break block10;
            }
            this.zzc.zza();
            return;
        }
        this.zzc.zza();
        throw var1_5;
    }

    static /* synthetic */ void zzS(zzaie zzaie2, SurfaceTexture surfaceTexture) {
        surfaceTexture = new Surface(surfaceTexture);
        zzaie2.zzab(surfaceTexture);
        zzaie2.zzs = surfaceTexture;
    }

    static /* synthetic */ void zzT(zzaie zzaie2, Object object) {
        zzaie2.zzab(null);
    }

    static /* synthetic */ void zzU(zzaie zzaie2, int n, int n2) {
        zzaie2.zzac(n, n2);
    }

    static /* synthetic */ void zzV(zzaie zzaie2) {
        zzaie2.zzad();
    }

    static /* synthetic */ void zzW(zzaie zzaie2) {
        zzaie2.zzi.zzn(zzaie2.zzB);
        Iterator<zzahl> iterator = zzaie2.zzh.iterator();
        while (iterator.hasNext()) {
            iterator.next().zzn(zzaie2.zzB);
        }
    }

    static /* synthetic */ void zzX(zzaie zzaie2, boolean bl, int n, int n2) {
        zzaie2.zzae(bl, n, n2);
    }

    static /* synthetic */ void zzY(zzaie zzaie2) {
        int n = zzaie2.zzI();
        if (n != 2 && n != 3) {
            return;
        }
        zzaie2.zzaf();
        zzaie2.zze.zze();
        zzaie2.zzM();
        zzaie2.zzM();
    }

    static /* synthetic */ zzaee zzZ(zzaij zzaij2) {
        return zzaie.zzah(zzaij2);
    }

    static /* synthetic */ int zzaa(boolean bl, int n) {
        return zzaie.zzai(bl, n);
    }

    private final void zzab(Object object) {
        int n;
        Object object2 = new ArrayList();
        Object object3 = this.zzb;
        int n2 = ((zzahv[])object3).length;
        n2 = 0;
        while (true) {
            n = 1;
            if (n2 >= 2) break;
            zzahv zzahv2 = object3[n2];
            if (zzahv2.zzac() == 2) {
                zzahv2 = this.zze.zzt((zzahr)zzahv2);
                zzahv2.zzb(1);
                zzahv2.zzd(object);
                zzahv2.zzg();
                object2.add(zzahv2);
            }
            ++n2;
        }
        object3 = this.zzr;
        if (object3 != null && object3 != object) {
            block9: {
                try {
                    object2 = object2.iterator();
                    while (object2.hasNext()) {
                        ((zzahs)object2.next()).zzj(2000L);
                    }
                }
                catch (TimeoutException timeoutException) {
                    n2 = n;
                    break block9;
                }
                catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                }
                n2 = 0;
            }
            object3 = this.zzr;
            object2 = this.zzs;
            n = n2;
            if (object3 == object2) {
                object2.release();
                this.zzs = null;
                n = n2;
            }
        } else {
            n = 0;
        }
        this.zzr = object;
        if (n == 0) return;
        this.zze.zzr(false, zzaeg.zzc((RuntimeException)new zzafr(3), (int)1003));
    }

    private final void zzac(int n, int n2) {
        if (n == this.zzu) {
            if (n2 == this.zzv) return;
        }
        this.zzu = n;
        this.zzv = n2;
        this.zzi.zzB(n, n2);
        Iterator<zzahl> iterator = this.zzh.iterator();
        while (iterator.hasNext()) {
            iterator.next().zzB(n, n2);
        }
    }

    private final void zzad() {
        this.zzag(1, 2, Float.valueOf(this.zzA * this.zzk.zza()));
    }

    private final void zzae(boolean bl, int n, int n2) {
        int n3 = 1;
        bl = bl && n != -1;
        n = bl && n != 1 ? n3 : 0;
        this.zze.zzl(bl, n, n2);
    }

    private final void zzaf() {
        this.zzc.zzd();
        if (Thread.currentThread() == this.zze.zzf().getThread()) return;
        String string = zzamq.zzv((String)"Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", (Object[])new Object[]{Thread.currentThread().getName(), this.zze.zzf().getThread().getName()});
        if (this.zzD) throw new IllegalStateException(string);
        IllegalStateException illegalStateException = this.zzE ? null : new IllegalStateException();
        zzaln.zza((String)"SimpleExoPlayer", (String)string, (Throwable)illegalStateException);
        this.zzE = true;
    }

    private final void zzag(int n, int n2, Object object) {
        zzahv[] zzahvArray = this.zzb;
        int n3 = zzahvArray.length;
        n3 = 0;
        while (n3 < 2) {
            zzahv zzahv2 = zzahvArray[n3];
            if (zzahv2.zzac() == n) {
                zzahv2 = this.zze.zzt((zzahr)zzahv2);
                zzahv2.zzb(n2);
                zzahv2.zzd(object);
                zzahv2.zzg();
            }
            ++n3;
        }
    }

    private static zzaee zzah(zzaij zzaij2) {
        return new zzaee(0, zzaij2.zzc(), zzaij2.zzd());
    }

    private static int zzai(boolean bl, int n) {
        if (!bl) return 1;
        if (n == 1) return 1;
        return 2;
    }

    static /* synthetic */ CopyOnWriteArraySet zze(zzaie zzaie2) {
        return zzaie2.zzh;
    }

    static /* synthetic */ zzcy zzf(zzaie zzaie2) {
        return zzaie2.zzi;
    }

    static /* synthetic */ zzaij zzg(zzaie zzaie2) {
        return zzaie2.zzl;
    }

    static /* synthetic */ zzafv zzh(zzaie zzaie2, zzafv zzafv2) {
        zzaie2.zzo = zzafv2;
        return zzafv2;
    }

    static /* synthetic */ zzafv zzi(zzaie zzaie2, zzafv zzafv2) {
        zzaie2.zzp = zzafv2;
        return zzafv2;
    }

    static /* synthetic */ Object zzj(zzaie zzaie2) {
        return zzaie2.zzr;
    }

    static /* synthetic */ zzaz zzk(zzaie zzaie2, zzaz zzaz2) {
        zzaie2.zzw = zzaz2;
        return zzaz2;
    }

    static /* synthetic */ zzaz zzl(zzaie zzaie2, zzaz zzaz2) {
        zzaie2.zzx = zzaz2;
        return zzaz2;
    }

    static /* synthetic */ boolean zzm(zzaie zzaie2) {
        return zzaie2.zzB;
    }

    static /* synthetic */ boolean zzr(zzaie zzaie2, boolean bl) {
        zzaie2.zzB = bl;
        return bl;
    }

    static /* synthetic */ zzaee zzs(zzaie zzaie2) {
        return zzaie2.zzF;
    }

    static /* synthetic */ zzaee zzt(zzaie zzaie2, zzaee zzaee2) {
        zzaie2.zzF = zzaee2;
        return zzaee2;
    }

    static /* synthetic */ zzy zzw(zzaie zzaie2, zzy zzy2) {
        zzaie2.zzG = zzy2;
        return zzy2;
    }

    public final boolean zzA() {
        this.zzaf();
        return this.zze.zzA();
    }

    public final int zzB() {
        this.zzaf();
        return this.zze.zzB();
    }

    public final int zzC() {
        this.zzaf();
        return this.zze.zzC();
    }

    public final long zzD() {
        this.zzaf();
        return this.zze.zzD();
    }

    public final void zzE(float f) {
        this.zzaf();
        f = zzamq.zzz((float)f, (float)0.0f, (float)1.0f);
        if (this.zzA == f) {
            return;
        }
        this.zzA = f;
        this.zzad();
        this.zzi.zzq(f);
        Iterator<zzahl> iterator = this.zzh.iterator();
        while (iterator.hasNext()) {
            iterator.next().zzq(f);
        }
    }

    public final zzaiq zzF() {
        this.zzaf();
        return this.zze.zzF();
    }

    public final void zzG(zzda zzda2) {
        this.zzi.zza(zzda2);
    }

    public final void zzH(zzda zzda2) {
        this.zzi.zzb(zzda2);
    }

    public final int zzI() {
        this.zzaf();
        return this.zze.zzi();
    }

    public final void zzJ() {
        this.zzaf();
        boolean bl = this.zzM();
        int n = this.zzk.zzb(bl, 2);
        this.zzae(bl, n, zzaie.zzai(bl, n));
        this.zze.zzj();
    }

    public final void zzK(zzhh zzhh2) {
        this.zzaf();
        this.zze.zzk(Collections.singletonList(zzhh2), true);
    }

    public final void zzL(boolean bl) {
        this.zzaf();
        int n = this.zzk.zzb(bl, this.zzI());
        this.zzae(bl, n, zzaie.zzai(bl, n));
    }

    public final boolean zzM() {
        this.zzaf();
        return this.zze.zzm();
    }

    public final void zzN() {
        AudioTrack audioTrack;
        this.zzaf();
        if (zzamq.zza < 21 && (audioTrack = this.zzq) != null) {
            audioTrack.release();
            this.zzq = null;
        }
        this.zzl.zze();
        this.zzk.zzc();
        this.zze.zzs();
        this.zzi.zzd();
        audioTrack = this.zzs;
        if (audioTrack != null) {
            audioTrack.release();
            this.zzs = null;
        }
        this.zzC = Collections.emptyList();
    }

    public final int zzO() {
        this.zzaf();
        this.zze.zzE();
        return 2;
    }

    public final long zzP() {
        this.zzaf();
        return this.zze.zzw();
    }

    public final long zzQ() {
        this.zzaf();
        return this.zze.zzy();
    }

    @Deprecated
    public final void zzR(boolean bl) {
        this.zzD = false;
    }

    public final int zzn() {
        this.zzaf();
        return 0;
    }

    public final boolean zzo() {
        this.zzaf();
        return false;
    }

    public final void zzp(int n, long l) {
        this.zzaf();
        this.zzi.zzf();
        this.zze.zzp(n, l);
    }

    @Deprecated
    public final void zzq(boolean bl) {
        this.zzaf();
        this.zzk.zzb(this.zzM(), 1);
        this.zze.zzr(false, null);
        this.zzC = Collections.emptyList();
    }

    public final int zzu() {
        this.zzaf();
        return this.zze.zzu();
    }

    public final int zzv() {
        this.zzaf();
        return this.zze.zzv();
    }

    public final long zzx() {
        this.zzaf();
        return this.zze.zzx();
    }

    public final void zzy(Surface surface) {
        this.zzaf();
        this.zzab(surface);
        int n = surface == null ? 0 : -1;
        this.zzac(n, n);
    }

    public final long zzz() {
        this.zzaf();
        return this.zze.zzz();
    }
}
