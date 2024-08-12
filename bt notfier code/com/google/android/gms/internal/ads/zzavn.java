/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaCodec
 *  android.media.MediaCrypto
 *  android.media.MediaFormat
 *  android.os.Handler
 *  android.os.SystemClock
 *  android.util.Log
 *  android.view.Surface
 *  com.google.android.gms.internal.ads.zzamy
 *  com.google.android.gms.internal.ads.zzanm
 *  com.google.android.gms.internal.ads.zzapg
 *  com.google.android.gms.internal.ads.zzarg
 *  com.google.android.gms.internal.ads.zzari
 *  com.google.android.gms.internal.ads.zzark
 *  com.google.android.gms.internal.ads.zzarm
 *  com.google.android.gms.internal.ads.zzarr
 *  com.google.android.gms.internal.ads.zzaup
 *  com.google.android.gms.internal.ads.zzauu
 *  com.google.android.gms.internal.ads.zzavc
 *  com.google.android.gms.internal.ads.zzave
 *  com.google.android.gms.internal.ads.zzavk
 *  com.google.android.gms.internal.ads.zzavm
 *  com.google.android.gms.internal.ads.zzavp
 *  com.google.android.gms.internal.ads.zzavx
 *  com.google.android.gms.internal.ads.zzavy
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.google.android.gms.internal.ads.zzamy;
import com.google.android.gms.internal.ads.zzanm;
import com.google.android.gms.internal.ads.zzapg;
import com.google.android.gms.internal.ads.zzarg;
import com.google.android.gms.internal.ads.zzari;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzarm;
import com.google.android.gms.internal.ads.zzarr;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzauu;
import com.google.android.gms.internal.ads.zzavc;
import com.google.android.gms.internal.ads.zzave;
import com.google.android.gms.internal.ads.zzavk;
import com.google.android.gms.internal.ads.zzavm;
import com.google.android.gms.internal.ads.zzavp;
import com.google.android.gms.internal.ads.zzavx;
import com.google.android.gms.internal.ads.zzavy;
import java.nio.ByteBuffer;

public final class zzavn
extends zzari {
    private int zzA;
    private final Context zzb;
    private final zzavp zzc;
    private final zzavx zzd;
    private final boolean zze;
    private final long[] zzf;
    private zzanm[] zzg;
    private zzavm zzh;
    private Surface zzi;
    private Surface zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private float zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private float zzu;
    private int zzv;
    private int zzw;
    private int zzx;
    private float zzy;
    private long zzz;

    public zzavn(Context context, zzark zzark2, long l, Handler handler, zzavy zzavy2, int n) {
        boolean bl = false;
        super(2, zzark2, null, false);
        this.zzb = context.getApplicationContext();
        this.zzc = new zzavp(context);
        this.zzd = new zzavx(handler, zzavy2);
        boolean bl2 = bl;
        if (zzave.zza <= 22) {
            bl2 = bl;
            if ("foster".equals(zzave.zzb)) {
                bl2 = bl;
                if ("NVIDIA".equals(zzave.zzc)) {
                    bl2 = true;
                }
            }
        }
        this.zze = bl2;
        this.zzf = new long[10];
        this.zzz = -9223372036854775807L;
        this.zzl = -9223372036854775807L;
        this.zzr = -1;
        this.zzs = -1;
        this.zzu = -1.0f;
        this.zzq = -1.0f;
        this.zzab();
    }

    private final boolean zzR(boolean bl) {
        int n = zzave.zza;
        boolean bl2 = true;
        if (n >= 23) {
            if (!bl) return bl2;
            if (zzavk.zza((Context)this.zzb)) return true;
        }
        bl2 = false;
        return bl2;
    }

    private final void zzab() {
        this.zzv = -1;
        this.zzw = -1;
        this.zzy = -1.0f;
        this.zzx = -1;
    }

    private final void zzac() {
        int n = this.zzv;
        int n2 = this.zzr;
        if (n == n2 && this.zzw == this.zzs && this.zzx == this.zzt) {
            if (this.zzy == this.zzu) return;
        }
        this.zzd.zzf(n2, this.zzs, this.zzt, this.zzu);
        this.zzv = this.zzr;
        this.zzw = this.zzs;
        this.zzx = this.zzt;
        this.zzy = this.zzu;
    }

    private final void zzad() {
        if (this.zzv == -1) {
            if (this.zzw == -1) return;
        }
        this.zzd.zzf(this.zzr, this.zzs, this.zzt, this.zzu);
    }

    private final void zzae() {
        if (this.zzn <= 0) return;
        long l = SystemClock.elapsedRealtime();
        long l2 = this.zzm;
        this.zzd.zze(this.zzn, l - l2);
        this.zzn = 0;
        this.zzm = l;
    }

    private static boolean zzaf(long l) {
        if (l >= -30000L) return false;
        return true;
    }

    private static int zzag(zzanm zzanm2) {
        int n;
        int n2 = n = zzanm2.zzm;
        if (n != -1) return n2;
        n2 = 0;
        return n2;
    }

    public final boolean zzE() {
        Surface surface;
        if (super.zzE() && (this.zzk || (surface = this.zzj) != null && this.zzi == surface || this.zzW() == null)) {
            this.zzl = -9223372036854775807L;
            return true;
        }
        if (this.zzl == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.zzl) {
            return true;
        }
        this.zzl = -9223372036854775807L;
        return false;
    }

    protected final void zzH(MediaCodec mediaCodec, int n, long l) {
        zzavc.zza((String)"skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(n, false);
        zzavc.zzb();
        mediaCodec = this.zza;
        ++mediaCodec.zze;
    }

    protected final void zzI(MediaCodec mediaCodec, int n, long l) {
        this.zzac();
        zzavc.zza((String)"releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(n, true);
        zzavc.zzb();
        mediaCodec = this.zza;
        ++mediaCodec.zzd;
        this.zzo = 0;
        this.zzQ();
    }

    protected final int zzJ(zzark zzark2, zzanm object) throws zzarm {
        int n;
        boolean bl;
        int n2;
        String string = ((zzanm)object).zzf;
        boolean bl2 = zzauu.zzb((String)string);
        int n3 = 0;
        if (!bl2) {
            return 0;
        }
        zzark2 = ((zzanm)object).zzi;
        if (zzark2 != null) {
            n2 = 0;
            bl2 = false;
            while (true) {
                bl = bl2;
                if (n2 < zzark2.zza) {
                    bl2 |= zzark2.zza((int)n2).zzc;
                    ++n2;
                    continue;
                }
                break;
            }
        } else {
            bl = false;
        }
        if ((zzark2 = zzarr.zza((String)string, (boolean)bl)) == null) {
            return 1;
        }
        bl2 = bl = zzark2.zzd(((zzanm)object).zzc);
        if (bl) {
            bl2 = bl;
            if (((zzanm)object).zzj > 0) {
                bl2 = bl;
                if (((zzanm)object).zzk > 0) {
                    if (zzave.zza >= 21) {
                        bl2 = zzark2.zze(((zzanm)object).zzj, ((zzanm)object).zzk, (double)((zzanm)object).zzl);
                    } else {
                        bl = ((zzanm)object).zzj * ((zzanm)object).zzk <= zzarr.zzc();
                        bl2 = bl;
                        if (!bl) {
                            n2 = ((zzanm)object).zzj;
                            n = ((zzanm)object).zzk;
                            string = zzave.zze;
                            object = new StringBuilder(String.valueOf(string).length() + 56);
                            ((StringBuilder)object).append("FalseCheck [legacyFrameSize, ");
                            ((StringBuilder)object).append(n2);
                            ((StringBuilder)object).append("x");
                            ((StringBuilder)object).append(n);
                            ((StringBuilder)object).append("] [");
                            ((StringBuilder)object).append(string);
                            ((StringBuilder)object).append("]");
                            Log.d((String)"MediaCodecVideoRenderer", (String)((StringBuilder)object).toString());
                            bl2 = bl;
                        }
                    }
                }
            }
        }
        n2 = true != zzark2.zzb ? 4 : 8;
        if (zzark2.zzc) {
            n3 = 16;
        }
        n = true != bl2 ? 2 : 3;
        return n | (n2 | n3);
    }

    protected final void zzL(zzarg zzarg2, MediaCodec mediaCodec, zzanm zzanm2, MediaCrypto zzavm2) throws zzarm {
        int n;
        int n2;
        int n3;
        int n4;
        block12: {
            block13: {
                block17: {
                    block18: {
                        block15: {
                            block16: {
                                block14: {
                                    zzavm2 = this.zzg;
                                    n4 = zzanm2.zzj;
                                    n3 = zzanm2.zzk;
                                    n = n2 = zzanm2.zzg;
                                    if (n2 != -1) break block12;
                                    String string = zzanm2.zzf;
                                    if (n4 == -1 || n3 == -1) break block13;
                                    n = string.hashCode();
                                    n2 = 4;
                                    switch (n) {
                                        default: {
                                            break;
                                        }
                                        case 1599127257: {
                                            if (!string.equals("video/x-vnd.on2.vp9")) break;
                                            n = 5;
                                            break block14;
                                        }
                                        case 1599127256: {
                                            if (!string.equals("video/x-vnd.on2.vp8")) break;
                                            n = 3;
                                            break block14;
                                        }
                                        case 1331836730: {
                                            if (!string.equals("video/avc")) break;
                                            n = 2;
                                            break block14;
                                        }
                                        case 1187890754: {
                                            if (!string.equals("video/mp4v-es")) break;
                                            n = 1;
                                            break block14;
                                        }
                                        case -1662541442: {
                                            if (!string.equals("video/hevc")) break;
                                            n = 4;
                                            break block14;
                                        }
                                        case -1664118616: {
                                            if (!string.equals("video/3gpp")) break;
                                            n = 0;
                                            break block14;
                                        }
                                    }
                                    n = -1;
                                }
                                if (n == 0 || n == 1) break block15;
                                if (n == 2) break block16;
                                if (n == 3) break block15;
                                if (n != 4 && n != 5) break block13;
                                n = n4 * n3;
                                break block17;
                            }
                            if ("BRAVIA 4K 2015".equals(zzave.zzd)) break block13;
                            n = zzave.zze((int)n4, (int)16) * zzave.zze((int)n3, (int)16) * 256;
                            break block18;
                        }
                        n = n4 * n3;
                    }
                    n2 = 2;
                }
                n = n * 3 / (n2 + n2);
                break block12;
            }
            n = -1;
        }
        n2 = ((zzanm[])zzavm2).length;
        this.zzh = zzavm2 = new zzavm(n4, n3, n);
        boolean bl = this.zze;
        zzanm2 = zzanm2.zzl();
        zzanm2.setInteger("max-width", zzavm2.zza);
        zzanm2.setInteger("max-height", zzavm2.zzb);
        n = zzavm2.zzc;
        if (n != -1) {
            zzanm2.setInteger("max-input-size", n);
        }
        if (bl) {
            zzanm2.setInteger("auto-frc", 0);
        }
        if (this.zzi == null) {
            zzaup.zzd((boolean)this.zzR(zzarg2.zzd));
            if (this.zzj == null) {
                this.zzj = zzavk.zzb((Context)this.zzb, (boolean)zzarg2.zzd);
            }
            this.zzi = this.zzj;
        }
        mediaCodec.configure((MediaFormat)zzanm2, this.zzi, null, 0);
        n = zzave.zza;
    }

    protected final void zzM(String string, long l, long l2) {
        this.zzd.zzc(string, l, l2);
    }

    protected final void zzN(zzanm zzanm2) throws zzamy {
        float f;
        super.zzN(zzanm2);
        this.zzd.zzd(zzanm2);
        float f2 = f = zzanm2.zzn;
        if (f == -1.0f) {
            f2 = 1.0f;
        }
        this.zzq = f2;
        this.zzp = zzavn.zzag(zzanm2);
    }

    protected final void zzO(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int n;
        boolean bl = mediaFormat.containsKey("crop-right");
        int n2 = n = 0;
        if (bl) {
            n2 = n;
            if (mediaFormat.containsKey("crop-left")) {
                n2 = n;
                if (mediaFormat.containsKey("crop-bottom")) {
                    n2 = n;
                    if (mediaFormat.containsKey("crop-top")) {
                        n2 = 1;
                    }
                }
            }
        }
        n = n2 != 0 ? mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left") + 1 : mediaFormat.getInteger("width");
        this.zzr = n;
        n2 = n2 != 0 ? mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top") + 1 : mediaFormat.getInteger("height");
        this.zzs = n2;
        this.zzu = this.zzq;
        if (zzave.zza >= 21) {
            n2 = this.zzp;
            if (n2 == 90 || n2 == 270) {
                n2 = this.zzr;
                this.zzr = this.zzs;
                this.zzs = n2;
                this.zzu = 1.0f / this.zzu;
            }
        } else {
            this.zzt = this.zzp;
        }
        mediaCodec.setVideoScalingMode(1);
    }

    protected final void zzP(MediaCodec mediaCodec, int n, long l, long l2) {
        this.zzac();
        zzavc.zza((String)"releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(n, l2);
        zzavc.zzb();
        mediaCodec = this.zza;
        ++mediaCodec.zzd;
        this.zzo = 0;
        this.zzQ();
    }

    final void zzQ() {
        if (this.zzk) return;
        this.zzk = true;
        this.zzd.zzg(this.zzi);
    }

    protected final boolean zzS(long l, long l2, MediaCodec mediaCodec, ByteBuffer object, int n, int n2, long l3, boolean bl) {
        Object object2;
        while ((n2 = this.zzA) != 0 && l3 >= (object2 = (Object)(object = (Object)this.zzf)[0])) {
            this.zzz = object2;
            this.zzA = --n2;
            System.arraycopy(object, 1, object, 0, n2);
        }
        object2 = l3 - this.zzz;
        if (bl) {
            this.zzH(mediaCodec, n, (long)object2);
            return true;
        }
        long l4 = l3 - l;
        if (this.zzi == this.zzj) {
            if (!zzavn.zzaf(l4)) return false;
            this.zzH(mediaCodec, n, (long)object2);
            return true;
        }
        if (!this.zzk) {
            if (zzave.zza >= 21) {
                this.zzP(mediaCodec, n, (long)object2, System.nanoTime());
            } else {
                this.zzI(mediaCodec, n, (long)object2);
            }
            return true;
        }
        if (this.zze() != 2) {
            return false;
        }
        long l5 = SystemClock.elapsedRealtime();
        l = System.nanoTime();
        if (zzavn.zzaf(l = ((l2 = this.zzc.zzc(l3, (l4 - (l5 * 1000L - l2)) * 1000L + l)) - l) / 1000L)) {
            zzavc.zza((String)"dropVideoBuffer");
            mediaCodec.releaseOutputBuffer(n, false);
            zzavc.zzb();
            mediaCodec = this.zza;
            ++mediaCodec.zzf;
            ++this.zzn;
            this.zzo = n = this.zzo + 1;
            mediaCodec.zzg = Math.max(n, mediaCodec.zzg);
            if (this.zzn != -1) return true;
            this.zzae();
            return true;
        }
        if (zzave.zza >= 21) {
            if (l >= 50000L) return false;
            this.zzP(mediaCodec, n, (long)object2, l2);
            return true;
        }
        if (l >= 30000L) return false;
        if (l > 11000L) {
            try {
                Thread.sleep((l - 10000L) / 1000L);
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
        this.zzI(mediaCodec, n, (long)object2);
        return true;
    }

    protected final boolean zzV(zzarg zzarg2) {
        if (this.zzi != null) return true;
        if (!this.zzR(zzarg2.zzd)) return false;
        return true;
    }

    protected final void zzY() {
        try {
            super.zzY();
            return;
        }
        finally {
            Surface surface = this.zzj;
            if (surface != null) {
                if (this.zzi == surface) {
                    this.zzi = null;
                }
                surface.release();
                this.zzj = null;
            }
        }
    }

    protected final void zzZ(zzapg zzapg2) {
        int n = zzave.zza;
    }

    protected final boolean zzaa(MediaCodec mediaCodec, boolean bl, zzanm zzanm2, zzanm zzanm3) {
        if (!zzanm2.zzf.equals(zzanm3.zzf)) return false;
        if (zzavn.zzag(zzanm2) != zzavn.zzag(zzanm3)) return false;
        if (!bl) {
            if (zzanm2.zzj != zzanm3.zzj) return false;
            if (zzanm2.zzk != zzanm3.zzk) return false;
        }
        int n = zzanm3.zzj;
        mediaCodec = this.zzh;
        if (n > mediaCodec.zza) return false;
        if (zzanm3.zzk > mediaCodec.zzb) return false;
        if (zzanm3.zzg > mediaCodec.zzc) return false;
        return true;
    }

    public final void zzr(int n, Object object) throws zzamy {
        if (n != 1) return;
        Surface surface = (Surface)object;
        object = surface;
        if (surface == null && (object = this.zzj) == null) {
            zzarg zzarg2 = this.zzX();
            object = surface;
            if (zzarg2 != null) {
                object = surface;
                if (this.zzR(zzarg2.zzd)) {
                    object = zzavk.zzb((Context)this.zzb, (boolean)zzarg2.zzd);
                    this.zzj = object;
                }
            }
        }
        if (this.zzi == object) {
            if (object == null) return;
            if (object == this.zzj) return;
            this.zzad();
            if (!this.zzk) return;
            this.zzd.zzg(this.zzi);
            return;
        }
        this.zzi = object;
        int n2 = this.zze();
        if (n2 == 1 || n2 == 2) {
            surface = this.zzW();
            if (zzave.zza >= 23 && surface != null && object != null) {
                surface.setOutputSurface((Surface)object);
            } else {
                this.zzY();
                this.zzU();
            }
        }
        if (object != null && object != this.zzj) {
            this.zzad();
            this.zzk = false;
            n = zzave.zza;
            if (n2 != 2) return;
            this.zzl = -9223372036854775807L;
            return;
        }
        this.zzab();
        this.zzk = false;
        n = zzave.zza;
    }

    protected final void zzs(boolean bl) throws zzamy {
        super.zzs(bl);
        int n = this.zzy().zzb;
        this.zzd.zzb(this.zza);
        this.zzc.zza();
    }

    protected final void zzt(zzanm[] object, long l) throws zzamy {
        this.zzg = object;
        if (this.zzz == -9223372036854775807L) {
            this.zzz = l;
            return;
        }
        int n = this.zzA;
        if (n == 10) {
            long l2 = this.zzf[9];
            object = new StringBuilder(65);
            ((StringBuilder)object).append("Too many stream changes, so dropping offset: ");
            ((StringBuilder)object).append(l2);
            Log.w((String)"MediaCodecVideoRenderer", (String)((StringBuilder)object).toString());
        } else {
            this.zzA = n + 1;
        }
        this.zzf[this.zzA - 1] = l;
    }

    protected final void zzu(long l, boolean bl) throws zzamy {
        super.zzu(l, bl);
        this.zzk = false;
        int n = zzave.zza;
        this.zzo = 0;
        n = this.zzA;
        if (n != 0) {
            this.zzz = this.zzf[n - 1];
            this.zzA = 0;
        }
        this.zzl = -9223372036854775807L;
    }

    protected final void zzv() {
        this.zzn = 0;
        this.zzm = SystemClock.elapsedRealtime();
        this.zzl = -9223372036854775807L;
    }

    protected final void zzw() {
        this.zzae();
    }

    protected final void zzx() {
        this.zzr = -1;
        this.zzs = -1;
        this.zzu = -1.0f;
        this.zzq = -1.0f;
        this.zzz = -9223372036854775807L;
        this.zzA = 0;
        this.zzab();
        this.zzk = false;
        int n = zzave.zza;
        this.zzc.zzb();
        try {
            super.zzx();
            return;
        }
        finally {
            this.zza.zza();
            this.zzd.zzh(this.zza);
        }
    }
}
