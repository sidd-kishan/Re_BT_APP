/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaCodec$CryptoException
 *  android.media.MediaCodec$CryptoInfo
 *  android.media.MediaCrypto
 *  android.media.MediaFormat
 *  android.os.SystemClock
 *  com.google.android.gms.internal.ads.zzamw
 *  com.google.android.gms.internal.ads.zzamy
 *  com.google.android.gms.internal.ads.zzanm
 *  com.google.android.gms.internal.ads.zzann
 *  com.google.android.gms.internal.ads.zzapf
 *  com.google.android.gms.internal.ads.zzapg
 *  com.google.android.gms.internal.ads.zzapk
 *  com.google.android.gms.internal.ads.zzapl
 *  com.google.android.gms.internal.ads.zzarg
 *  com.google.android.gms.internal.ads.zzarh
 *  com.google.android.gms.internal.ads.zzark
 *  com.google.android.gms.internal.ads.zzarm
 *  com.google.android.gms.internal.ads.zzarr
 *  com.google.android.gms.internal.ads.zzaup
 *  com.google.android.gms.internal.ads.zzauv
 *  com.google.android.gms.internal.ads.zzavc
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import com.google.android.gms.internal.ads.zzamw;
import com.google.android.gms.internal.ads.zzamy;
import com.google.android.gms.internal.ads.zzanm;
import com.google.android.gms.internal.ads.zzann;
import com.google.android.gms.internal.ads.zzapf;
import com.google.android.gms.internal.ads.zzapg;
import com.google.android.gms.internal.ads.zzapk;
import com.google.android.gms.internal.ads.zzapl;
import com.google.android.gms.internal.ads.zzarg;
import com.google.android.gms.internal.ads.zzarh;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzarm;
import com.google.android.gms.internal.ads.zzarr;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzauv;
import com.google.android.gms.internal.ads.zzavc;
import com.google.android.gms.internal.ads.zzave;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public abstract class zzari
extends zzamw {
    private static final byte[] zzb = zzave.zzm((String)"0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private boolean zzA;
    private int zzB;
    private int zzC;
    private boolean zzD;
    private boolean zzE;
    private boolean zzF;
    private boolean zzG;
    private boolean zzH;
    protected zzapf zza;
    private final zzark zzc;
    private final zzapg zzd;
    private final zzapg zze;
    private final zzann zzf;
    private final List<Long> zzg;
    private final MediaCodec.BufferInfo zzh;
    private zzanm zzi;
    private MediaCodec zzj;
    private zzarg zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private ByteBuffer[] zzu;
    private ByteBuffer[] zzv;
    private long zzw;
    private int zzx;
    private int zzy;
    private boolean zzz;

    public zzari(int n, zzark zzark2, zzapl zzapl2, boolean bl) {
        super(n);
        bl = zzave.zza >= 16;
        zzaup.zzd((boolean)bl);
        this.zzc = zzark2;
        this.zzd = new zzapg(0);
        this.zze = new zzapg(0);
        this.zzf = new zzann();
        this.zzg = new ArrayList<Long>();
        this.zzh = new MediaCodec.BufferInfo();
        this.zzB = 0;
        this.zzC = 0;
    }

    /*
     * WARNING - combined exceptions agressively - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    private final boolean zzH() throws zzamy {
        Object object;
        boolean bl;
        int n;
        Object object2;
        block31: {
            block30: {
                int n2;
                int n3;
                object2 = this.zzj;
                if (object2 == null) return false;
                if (this.zzC == 2) return false;
                if (this.zzF) {
                    return false;
                }
                if (this.zzx < 0) {
                    this.zzx = n3 = object2.dequeueInputBuffer(0L);
                    if (n3 < 0) {
                        return false;
                    }
                    object2 = this.zzd;
                    ((zzapg)object2).zzb = this.zzu[n3];
                    object2.zza();
                }
                if (this.zzC == 1) {
                    if (!this.zzo) {
                        this.zzE = true;
                        this.zzj.queueInputBuffer(this.zzx, 0, 0, 0L, 4);
                        this.zzx = -1;
                    }
                    this.zzC = 2;
                    return false;
                }
                if (this.zzs) {
                    this.zzs = false;
                    this.zzd.zzb.put(zzb);
                    object2 = this.zzj;
                    n3 = this.zzx;
                    int n4 = zzb.length;
                    object2.queueInputBuffer(n3, 0, 38, 0L, 0);
                    this.zzx = -1;
                    this.zzD = true;
                    return true;
                }
                if (this.zzB == 1) {
                    for (n3 = 0; n3 < this.zzi.zzh.size(); ++n3) {
                        object2 = (byte[])this.zzi.zzh.get(n3);
                        this.zzd.zzb.put((byte[])object2);
                    }
                    this.zzB = 2;
                }
                n = this.zzd.zzb.position();
                n3 = this.zzA(this.zzf, this.zzd, false);
                if (n3 == -3) {
                    return false;
                }
                if (n3 == -5) {
                    if (this.zzB == 2) {
                        this.zzd.zza();
                        this.zzB = 1;
                    }
                    this.zzN(this.zzf.zza);
                    return true;
                }
                if (this.zzd.zzc()) {
                    if (this.zzB == 2) {
                        this.zzd.zza();
                        this.zzB = 1;
                    }
                    this.zzF = true;
                    if (!this.zzD) {
                        this.zzI();
                        return false;
                    }
                    try {
                        if (this.zzo) return false;
                        this.zzE = true;
                        this.zzj.queueInputBuffer(this.zzx, 0, 0, 0L, 4);
                        this.zzx = -1;
                        return false;
                    }
                    catch (MediaCodec.CryptoException cryptoException) {
                        throw zzamy.zza((Exception)((Object)cryptoException), (int)this.zzz());
                    }
                }
                if (this.zzH && !this.zzd.zzd()) {
                    this.zzd.zza();
                    if (this.zzB != 2) return true;
                    this.zzB = 1;
                    return true;
                }
                this.zzH = false;
                bl = this.zzd.zzi();
                if (!this.zzl || bl) break block31;
                object2 = this.zzd.zzb;
                object = zzauv.zza;
                int n5 = ((Buffer)object2).position();
                int n6 = 0;
                n3 = 0;
                while ((n2 = n6 + 1) < n5) {
                    int n7;
                    int n8;
                    block33: {
                        int n9;
                        block32: {
                            n9 = ((ByteBuffer)object2).get(n6) & 0xFF;
                            if (n3 != 3) break block32;
                            n8 = n3;
                            n7 = n9;
                            if (n9 == 1) {
                                if ((((ByteBuffer)object2).get(n2) & 0x1F) == 7) {
                                    object = ((ByteBuffer)object2).duplicate();
                                    ((Buffer)object).position(n6 - 3);
                                    ((Buffer)object).limit(n5);
                                    ((Buffer)object2).position(0);
                                    ((ByteBuffer)object2).put((ByteBuffer)object);
                                    break block30;
                                }
                                n7 = 1;
                                n8 = n3;
                            }
                            break block33;
                        }
                        n8 = n3;
                        n7 = n9;
                        if (n9 == 0) {
                            n8 = n3 + 1;
                            n7 = n9;
                        }
                    }
                    n3 = n8;
                    if (n7 != 0) {
                        n3 = 0;
                    }
                    n6 = n2;
                }
                ((Buffer)object2).clear();
            }
            if (this.zzd.zzb.position() == 0) {
                return true;
            }
            this.zzl = false;
        }
        try {
            object2 = this.zzd;
            long l = ((zzapg)object2).zzc;
            if (object2.zzb()) {
                this.zzg.add(l);
            }
            this.zzd.zzb.flip();
            this.zzZ(this.zzd);
            if (bl) {
                object2 = this.zzd.zza.zzb();
                if (n != 0) {
                    if (((MediaCodec.CryptoInfo)object2).numBytesOfClearData == null) {
                        ((MediaCodec.CryptoInfo)object2).numBytesOfClearData = new int[1];
                    }
                    object = ((MediaCodec.CryptoInfo)object2).numBytesOfClearData;
                    object[0] = object[0] + n;
                }
                this.zzj.queueSecureInputBuffer(this.zzx, 0, (MediaCodec.CryptoInfo)object2, l, 0);
            } else {
                this.zzj.queueInputBuffer(this.zzx, 0, this.zzd.zzb.limit(), l, 0);
            }
            this.zzx = -1;
            this.zzD = true;
            this.zzB = 0;
            object2 = this.zza;
            ++((zzapf)object2).zzc;
            return true;
        }
        catch (MediaCodec.CryptoException cryptoException) {
            throw zzamy.zza((Exception)((Object)cryptoException), (int)this.zzz());
        }
    }

    private final void zzI() throws zzamy {
        if (this.zzC == 2) {
            this.zzY();
            this.zzU();
            return;
        }
        this.zzG = true;
        this.zzT();
    }

    public final void zzD(long l, long l2) throws zzamy {
        int n;
        if (this.zzG) {
            this.zzT();
            return;
        }
        if (this.zzi == null) {
            this.zze.zza();
            n = this.zzA(this.zzf, this.zze, true);
            if (n != -5) {
                if (n != -4) return;
                zzaup.zzd((boolean)this.zze.zzc());
                this.zzF = true;
                this.zzI();
                return;
            }
            this.zzN(this.zzf.zza);
        }
        this.zzU();
        if (this.zzj == null) {
            this.zzB(l);
            this.zze.zza();
            n = this.zzA(this.zzf, this.zze, false);
            if (n == -5) {
                this.zzN(this.zzf.zza);
            } else if (n == -4) {
                zzaup.zzd((boolean)this.zze.zzc());
                this.zzF = true;
                this.zzI();
            }
        } else {
            zzavc.zza((String)"drainAndFeed");
            while (true) {
                boolean bl;
                long l3;
                block29: {
                    ByteBuffer[] byteBufferArray;
                    Object object;
                    if (this.zzy < 0) {
                        block28: {
                            int n2;
                            block27: {
                                if (this.zzq && this.zzE) {
                                    try {
                                        this.zzy = n = this.zzj.dequeueOutputBuffer(this.zzh, 0L);
                                        break block27;
                                    }
                                    catch (IllegalStateException illegalStateException) {
                                        this.zzI();
                                        if (!this.zzG) break;
                                        this.zzY();
                                        break;
                                    }
                                }
                                this.zzy = n = this.zzj.dequeueOutputBuffer(this.zzh, 0L);
                            }
                            if (n >= 0) {
                                if (this.zzt) {
                                    this.zzt = false;
                                    this.zzj.releaseOutputBuffer(n, false);
                                    this.zzy = -1;
                                    continue;
                                }
                                if ((this.zzh.flags & 4) != 0) {
                                    this.zzI();
                                    this.zzy = -1;
                                    break;
                                }
                                object = this.zzv[this.zzy];
                                if (object != null) {
                                    ((Buffer)object).position(this.zzh.offset);
                                    ((Buffer)object).limit(this.zzh.offset + this.zzh.size);
                                }
                                l3 = this.zzh.presentationTimeUs;
                                n2 = this.zzg.size();
                            } else {
                                if (n == -2) {
                                    object = this.zzj.getOutputFormat();
                                    if (this.zzn && object.getInteger("width") == 32 && object.getInteger("height") == 32) {
                                        this.zzt = true;
                                        continue;
                                    }
                                    if (this.zzr) {
                                        object.setInteger("channel-count", 1);
                                    }
                                    this.zzO(this.zzj, (MediaFormat)object);
                                    continue;
                                }
                                if (n == -3) {
                                    this.zzv = this.zzj.getOutputBuffers();
                                    continue;
                                }
                                if (!this.zzo || !this.zzF && this.zzC != 2) break;
                                this.zzI();
                                break;
                            }
                            for (n = 0; n < n2; ++n) {
                                if (this.zzg.get(n) != l3) continue;
                                this.zzg.remove(n);
                                bl = true;
                                break block28;
                            }
                            bl = false;
                        }
                        this.zzz = bl;
                    }
                    if (this.zzq && this.zzE) {
                        try {
                            object = this.zzj;
                            byteBufferArray = this.zzv;
                            n = this.zzy;
                            bl = this.zzS(l, l2, (MediaCodec)object, byteBufferArray[n], n, this.zzh.flags, this.zzh.presentationTimeUs, this.zzz);
                            break block29;
                        }
                        catch (IllegalStateException illegalStateException) {
                            this.zzI();
                            if (!this.zzG) break;
                            this.zzY();
                            break;
                        }
                    }
                    byteBufferArray = this.zzj;
                    object = this.zzv;
                    n = this.zzy;
                    bl = this.zzS(l, l2, (MediaCodec)byteBufferArray, (ByteBuffer)object[n], n, this.zzh.flags, this.zzh.presentationTimeUs, this.zzz);
                }
                if (!bl) break;
                l3 = this.zzh.presentationTimeUs;
                this.zzy = -1;
            }
            while (this.zzH()) {
            }
            zzavc.zzb();
        }
        this.zza.zza();
    }

    public boolean zzE() {
        boolean bl;
        zzanm zzanm2 = this.zzi;
        boolean bl2 = true;
        if (zzanm2 != null) {
            bl = bl2;
            if (this.zzC()) return bl;
            bl = bl2;
            if (this.zzy >= 0) return bl;
            if (this.zzw != -9223372036854775807L) {
                if (SystemClock.elapsedRealtime() < this.zzw) return true;
            }
        }
        bl = false;
        return bl;
    }

    public boolean zzF() {
        return this.zzG;
    }

    public final int zzG(zzanm zzanm2) throws zzamy {
        try {
            int n = this.zzJ(this.zzc, zzanm2);
            return n;
        }
        catch (zzarm zzarm2) {
            throw zzamy.zza((Exception)((Object)zzarm2), (int)this.zzz());
        }
    }

    protected abstract int zzJ(zzark var1, zzanm var2) throws zzarm;

    protected zzarg zzK(zzark zzark2, zzanm zzanm2, boolean bl) throws zzarm {
        return zzarr.zza((String)zzanm2.zzf, (boolean)false);
    }

    protected abstract void zzL(zzarg var1, MediaCodec var2, zzanm var3, MediaCrypto var4) throws zzarm;

    protected void zzM(String string, long l, long l2) {
        throw null;
    }

    protected void zzN(zzanm object) throws zzamy {
        block5: {
            boolean bl;
            block7: {
                block6: {
                    zzanm zzanm2 = this.zzi;
                    this.zzi = object;
                    zzapk zzapk2 = object.zzi;
                    object = zzanm2 == null ? null : zzanm2.zzi;
                    if (!zzave.zza((Object)zzapk2, (Object)object)) {
                        if (this.zzi.zzi != null) throw zzamy.zza((Exception)new IllegalStateException("Media requires a DrmSessionManager"), (int)this.zzz());
                    }
                    object = this.zzj;
                    bl = true;
                    if (object == null || !this.zzaa((MediaCodec)object, this.zzk.zzb, zzanm2, this.zzi)) break block5;
                    this.zzA = true;
                    this.zzB = 1;
                    if (!this.zzn) break block6;
                    object = this.zzi;
                    if (object.zzj == zzanm2.zzj && object.zzk == zzanm2.zzk) break block7;
                }
                bl = false;
            }
            this.zzs = bl;
            return;
        }
        if (this.zzD) {
            this.zzC = 1;
            return;
        }
        this.zzY();
        this.zzU();
    }

    protected void zzO(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzamy {
        throw null;
    }

    protected abstract boolean zzS(long var1, long var3, MediaCodec var5, ByteBuffer var6, int var7, int var8, long var9, boolean var11) throws zzamy;

    protected void zzT() throws zzamy {
    }

    /*
     * Enabled unnecessary exception pruning
     */
    protected final void zzU() throws zzamy {
        long l;
        if (this.zzj != null) return;
        zzanm zzanm2 = this.zzi;
        if (zzanm2 == null) {
            return;
        }
        zzarg zzarg2 = this.zzk;
        Object object = zzarg2;
        if (zzarg2 == null) {
            try {
                object = this.zzK(this.zzc, zzanm2, false);
                this.zzk = object;
                if (object == null) throw zzamy.zza((Exception)new zzarh(this.zzi, null, false, -49999), (int)this.zzz());
            }
            catch (zzarm zzarm2) {
                throw zzamy.zza((Exception)new zzarh(this.zzi, (Throwable)zzarm2, false, -49998), (int)this.zzz());
            }
        }
        if (!this.zzV((zzarg)object)) {
            return;
        }
        String string = this.zzk.zza;
        object = this.zzi;
        boolean bl = zzave.zza < 21 && ((zzanm)object).zzh.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(string);
        this.zzl = bl;
        bl = zzave.zza < 18 || zzave.zza == 18 && ("OMX.SEC.avc.dec".equals(string) || "OMX.SEC.avc.dec.secure".equals(string)) || zzave.zza == 19 && zzave.zzd.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(string) || "OMX.Exynos.avc.dec.secure".equals(string));
        this.zzm = bl;
        bl = !(zzave.zza >= 24 || !"OMX.Nvidia.h264.decode".equals(string) && !"OMX.Nvidia.h264.decode.secure".equals(string) || !"flounder".equals(zzave.zzb) && !"flounder_lte".equals(zzave.zzb) && !"grouper".equals(zzave.zzb) && !"tilapia".equals(zzave.zzb));
        this.zzn = bl;
        bl = zzave.zza <= 17 && ("OMX.rk.video_decoder.avc".equals(string) || "OMX.allwinner.video.decoder.avc".equals(string));
        this.zzo = bl;
        bl = zzave.zza <= 23 && "OMX.google.vorbis.decoder".equals(string) || zzave.zza <= 19 && "hb2000".equals(zzave.zzb) && ("OMX.amlogic.avc.decoder.awesome".equals(string) || "OMX.amlogic.avc.decoder.awesome.secure".equals(string));
        this.zzp = bl;
        bl = zzave.zza == 21 && "OMX.google.aac.decoder".equals(string);
        this.zzq = bl;
        object = this.zzi;
        bl = zzave.zza <= 18 && ((zzanm)object).zzr == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(string);
        this.zzr = bl;
        try {
            l = SystemClock.elapsedRealtime();
            object = String.valueOf(string);
            object = ((String)object).length() != 0 ? "createCodec:".concat((String)object) : new String("createCodec:");
            zzavc.zza((String)object);
            this.zzj = MediaCodec.createByCodecName((String)string);
            zzavc.zzb();
            zzavc.zza((String)"configureCodec");
            this.zzL(this.zzk, this.zzj, this.zzi, null);
            zzavc.zzb();
            zzavc.zza((String)"startCodec");
            this.zzj.start();
            zzavc.zzb();
            long l2 = SystemClock.elapsedRealtime();
            this.zzM(string, l2, l2 - l);
            this.zzu = this.zzj.getInputBuffers();
            this.zzv = this.zzj.getOutputBuffers();
        }
        catch (Exception exception) {
            throw zzamy.zza((Exception)new zzarh(this.zzi, (Throwable)exception, false, string), (int)this.zzz());
        }
        l = this.zze() == 2 ? SystemClock.elapsedRealtime() + 1000L : -9223372036854775807L;
        this.zzw = l;
        this.zzx = -1;
        this.zzy = -1;
        this.zzH = true;
        object = this.zza;
        ++((zzapf)object).zza;
    }

    protected boolean zzV(zzarg zzarg2) {
        return true;
    }

    protected final MediaCodec zzW() {
        return this.zzj;
    }

    protected final zzarg zzX() {
        return this.zzk;
    }

    protected void zzY() {
        this.zzw = -9223372036854775807L;
        this.zzx = -1;
        this.zzy = -1;
        this.zzz = false;
        this.zzg.clear();
        this.zzu = null;
        this.zzv = null;
        this.zzk = null;
        this.zzA = false;
        this.zzD = false;
        this.zzl = false;
        this.zzm = false;
        this.zzn = false;
        this.zzo = false;
        this.zzp = false;
        this.zzr = false;
        this.zzs = false;
        this.zzt = false;
        this.zzE = false;
        this.zzB = 0;
        this.zzC = 0;
        this.zzd.zzb = null;
        MediaCodec mediaCodec = this.zzj;
        if (mediaCodec == null) return;
        zzapf zzapf2 = this.zza;
        ++zzapf2.zzb;
        try {
            mediaCodec.stop();
        }
        catch (Throwable throwable) {
            try {
                this.zzj.release();
                throw throwable;
            }
            finally {
                this.zzj = null;
            }
        }
        try {
            this.zzj.release();
            return;
        }
        finally {
            this.zzj = null;
        }
    }

    protected void zzZ(zzapg zzapg2) {
    }

    protected boolean zzaa(MediaCodec mediaCodec, boolean bl, zzanm zzanm2, zzanm zzanm3) {
        return false;
    }

    public final int zzq() {
        return 4;
    }

    protected void zzs(boolean bl) throws zzamy {
        this.zza = new zzapf();
    }

    protected void zzu(long l, boolean bl) throws zzamy {
        this.zzF = false;
        this.zzG = false;
        if (this.zzj == null) return;
        this.zzw = -9223372036854775807L;
        this.zzx = -1;
        this.zzy = -1;
        this.zzH = true;
        this.zzz = false;
        this.zzg.clear();
        this.zzs = false;
        this.zzt = false;
        if (!(this.zzm || this.zzp && this.zzE)) {
            if (this.zzC != 0) {
                this.zzY();
                this.zzU();
            } else {
                this.zzj.flush();
                this.zzD = false;
            }
        } else {
            this.zzY();
            this.zzU();
        }
        if (!this.zzA) return;
        if (this.zzi == null) return;
        this.zzB = 1;
    }

    protected void zzx() {
        this.zzi = null;
        this.zzY();
        return;
    }
}
