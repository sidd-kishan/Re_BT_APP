/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.util.SparseArray
 *  com.google.android.gms.internal.ads.zzadx
 *  com.google.android.gms.internal.ads.zzah
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzalo
 *  com.google.android.gms.internal.ads.zzalw
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzj
 *  com.google.android.gms.internal.ads.zzm
 *  com.google.android.gms.internal.ads.zzn
 *  com.google.android.gms.internal.ads.zznn
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznu
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzoa
 *  com.google.android.gms.internal.ads.zzoq
 *  com.google.android.gms.internal.ads.zzos
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzov
 *  com.google.android.gms.internal.ads.zzow
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zzqb
 *  com.google.android.gms.internal.ads.zzqc
 *  com.google.android.gms.internal.ads.zzqd
 *  com.google.android.gms.internal.ads.zzqe
 *  com.google.android.gms.internal.ads.zzqg
 *  com.google.android.gms.internal.ads.zzqh
 *  com.google.android.gms.internal.ads.zzqj
 *  com.google.android.gms.internal.ads.zzqk
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzah;
import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzalo;
import com.google.android.gms.internal.ads.zzalw;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzj;
import com.google.android.gms.internal.ads.zzm;
import com.google.android.gms.internal.ads.zzn;
import com.google.android.gms.internal.ads.zznn;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznu;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzoa;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzos;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzow;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzqb;
import com.google.android.gms.internal.ads.zzqc;
import com.google.android.gms.internal.ads.zzqd;
import com.google.android.gms.internal.ads.zzqe;
import com.google.android.gms.internal.ads.zzqg;
import com.google.android.gms.internal.ads.zzqh;
import com.google.android.gms.internal.ads.zzqj;
import com.google.android.gms.internal.ads.zzqk;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzqi
implements zznu {
    public static final zzoa zza = zzqd.zza;
    private static final byte[] zzb = new byte[]{49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzc = zzamq.zzs((String)"Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] zzd = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final UUID zze = new UUID(0x100000000001000L, -9223371306706625679L);
    private static final Map<String, Integer> zzf;
    private boolean zzA;
    private int zzB;
    private long zzC;
    private boolean zzD;
    private long zzE;
    private long zzF;
    private long zzG;
    private zzalo zzH;
    private zzalo zzI;
    private boolean zzJ;
    private boolean zzK;
    private int zzL;
    private long zzM;
    private long zzN;
    private int zzO;
    private int zzP;
    private int[] zzQ;
    private int zzR;
    private int zzS;
    private int zzT;
    private int zzU;
    private boolean zzV;
    private int zzW;
    private int zzX;
    private int zzY;
    private boolean zzZ;
    private boolean zzaa;
    private boolean zzab;
    private int zzac;
    private byte zzad;
    private boolean zzae;
    private zznx zzaf;
    private final zzqb zzag;
    private final zzqk zzg;
    private final SparseArray<zzqg> zzh;
    private final boolean zzi;
    private final zzamf zzj;
    private final zzamf zzk;
    private final zzamf zzl;
    private final zzamf zzm;
    private final zzamf zzn;
    private final zzamf zzo;
    private final zzamf zzp;
    private final zzamf zzq;
    private final zzamf zzr;
    private final zzamf zzs;
    private ByteBuffer zzt;
    private long zzu;
    private long zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private zzqg zzz;

    static {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        zzf = Collections.unmodifiableMap(hashMap);
    }

    public zzqi() {
        this(0);
    }

    public zzqi(int n) {
        zzqb zzqb2 = new zzqb();
        this.zzv = -1L;
        this.zzw = -9223372036854775807L;
        this.zzx = -9223372036854775807L;
        this.zzy = -9223372036854775807L;
        this.zzE = -1L;
        this.zzF = -1L;
        this.zzG = -9223372036854775807L;
        this.zzag = zzqb2;
        zzqb2.zza((zzqc)new zzqe(this, null));
        this.zzi = true;
        this.zzg = new zzqk();
        this.zzh = new SparseArray();
        this.zzl = new zzamf(4);
        this.zzm = new zzamf(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzn = new zzamf(4);
        this.zzj = new zzamf(zzalw.zza);
        this.zzk = new zzamf(4);
        this.zzo = new zzamf();
        this.zzp = new zzamf();
        this.zzq = new zzamf(8);
        this.zzr = new zzamf();
        this.zzs = new zzamf();
        this.zzQ = new int[1];
    }

    static /* synthetic */ byte[] zze() {
        return zzc;
    }

    static /* synthetic */ UUID zzf() {
        return zze;
    }

    static /* synthetic */ Map zzg() {
        return zzf;
    }

    protected static final int zzn(int n) {
        switch (n) {
            default: {
                return 0;
            }
            case 181: 
            case 17545: 
            case 21969: 
            case 21970: 
            case 21971: 
            case 21972: 
            case 21973: 
            case 21974: 
            case 21975: 
            case 21976: 
            case 21977: 
            case 21978: 
            case 30323: 
            case 30324: 
            case 30325: {
                return 5;
            }
            case 161: 
            case 163: 
            case 165: 
            case 16877: 
            case 16981: 
            case 18402: 
            case 21419: 
            case 25506: 
            case 30322: {
                return 4;
            }
            case 160: 
            case 166: 
            case 174: 
            case 183: 
            case 187: 
            case 224: 
            case 225: 
            case 16868: 
            case 18407: 
            case 19899: 
            case 20532: 
            case 20533: 
            case 21936: 
            case 21968: 
            case 25152: 
            case 28032: 
            case 30113: 
            case 30320: 
            case 290298740: 
            case 357149030: 
            case 374648427: 
            case 408125543: 
            case 440786851: 
            case 475249515: 
            case 524531317: {
                return 1;
            }
            case 134: 
            case 17026: 
            case 21358: 
            case 2274716: {
                return 3;
            }
            case 131: 
            case 136: 
            case 155: 
            case 159: 
            case 176: 
            case 179: 
            case 186: 
            case 215: 
            case 231: 
            case 238: 
            case 241: 
            case 251: 
            case 16871: 
            case 16980: 
            case 17029: 
            case 17143: 
            case 18401: 
            case 18408: 
            case 20529: 
            case 20530: 
            case 21420: 
            case 21432: 
            case 21680: 
            case 21682: 
            case 21690: 
            case 21930: 
            case 21945: 
            case 21946: 
            case 21947: 
            case 21948: 
            case 21949: 
            case 21998: 
            case 22186: 
            case 22203: 
            case 25188: 
            case 30321: 
            case 2352003: 
            case 2807729: 
        }
        return 2;
    }

    protected static final boolean zzo(int n) {
        if (n == 357149030) return true;
        if (n == 524531317) return true;
        if (n == 475249515) return true;
        if (n != 374648427) return false;
        return true;
    }

    @EnsuresNonNull(value={"currentTrack"})
    private final void zzp(int n) throws zzaha {
        if (this.zzz != null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(43);
        stringBuilder.append("Element ");
        stringBuilder.append(n);
        stringBuilder.append(" must be in a TrackEntry");
        throw zzaha.zzb((String)stringBuilder.toString(), null);
    }

    @EnsuresNonNull(value={"cueTimesUs", "cueClusterPositions"})
    private final void zzq(int n) throws zzaha {
        if (this.zzH != null && this.zzI != null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append("Element ");
        stringBuilder.append(n);
        stringBuilder.append(" must be in a Cues");
        throw zzaha.zzb((String)stringBuilder.toString(), null);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @RequiresNonNull(value={"#1.output"})
    private final void zzr(zzqg var1_1, long var2_2, int var4_3, int var5_4, int var6_5) {
        block8: {
            block9: {
                block13: {
                    block12: {
                        block11: {
                            block10: {
                                block7: {
                                    var10_6 /* !! */  = var1_1.zzS;
                                    if (var10_6 /* !! */  == null) break block7;
                                    var10_6 /* !! */ .zzc(var1_1, var2_2, var4_3, var5_4, var6_5);
                                    break block8;
                                }
                                if (!"S_TEXT/UTF8".equals(var1_1.zzb) && !"S_TEXT/ASS".equals(var1_1.zzb)) break block9;
                                if (this.zzP <= 1) break block10;
                                Log.w((String)"MatroskaExtractor", (String)"Skipping subtitle sample in laced block.");
                                break block9;
                            }
                            var8_7 = this.zzN;
                            if (var8_7 != -9223372036854775807L) break block11;
                            Log.w((String)"MatroskaExtractor", (String)"Skipping subtitle sample with no duration.");
                            break block9;
                        }
                        var10_6 /* !! */  = var1_1.zzb;
                        var11_8 /* !! */  = this.zzp.zzi();
                        var7_9 = var10_6 /* !! */ .hashCode();
                        if (var7_9 == 738597099) break block12;
                        if (var7_9 != 1422270023 || !var10_6 /* !! */ .equals("S_TEXT/UTF8")) ** GOTO lbl-1000
                        var7_9 = 0;
                        break block13;
                    }
                    if (var10_6 /* !! */ .equals("S_TEXT/ASS")) {
                        var7_9 = 1;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var7_9 = -1;
                    }
                }
                if (var7_9 != 0) {
                    if (var7_9 != 1) throw new IllegalArgumentException();
                    var10_6 /* !! */  = (zzqh)zzqi.zzw(var8_7, "%01d:%02d:%02d:%02d", 10000L);
                    var7_9 = 21;
                } else {
                    var10_6 /* !! */  = (zzqh)zzqi.zzw(var8_7, "%02d:%02d:%02d,%03d", 1000L);
                    var7_9 = 19;
                }
                System.arraycopy(var10_6 /* !! */ , 0, var11_8 /* !! */ , var7_9, ((zzqh)var10_6 /* !! */ ).length);
                for (var7_9 = this.zzp.zzg(); var7_9 < this.zzp.zze(); ++var7_9) {
                    if (this.zzp.zzi()[var7_9] != 0) continue;
                    this.zzp.zzf(var7_9);
                    break;
                }
                var11_8 /* !! */  = (byte[])var1_1.zzV;
                var10_6 /* !! */  = this.zzp;
                zzov.zzb((zzox)var11_8 /* !! */ , (zzamf)var10_6 /* !! */ , (int)var10_6 /* !! */ .zze());
                var5_4 += this.zzp.zze();
            }
            var7_9 = var5_4;
            if ((var4_3 & 0x10000000) == 0) ** GOTO lbl56
            if (this.zzP > 1) {
                var4_3 &= -268435457;
            } else {
                var7_9 = this.zzs.zze();
                var1_1.zzV.zzu(this.zzs, var7_9, 2);
                var7_9 = var5_4 + var7_9;
lbl56:
                // 2 sources

                var5_4 = var7_9;
            }
            var1_1.zzV.zzv(var2_2, var4_3, var5_4, var6_5, var1_1.zzi);
        }
        this.zzK = true;
    }

    private final void zzs(zznv zznv2, int n) throws IOException {
        int n2;
        Object object;
        if (this.zzl.zze() >= n) {
            return;
        }
        if (this.zzl.zzj() < n) {
            object = this.zzl;
            n2 = object.zzj();
            object.zzc(Math.max(n2 + n2, n));
        }
        object = this.zzl.zzi();
        n2 = this.zzl.zze();
        int n3 = this.zzl.zze();
        ((zznp)zznv2).zza((byte[])object, n2, n - n3, false);
        this.zzl.zzf(n);
    }

    @RequiresNonNull(value={"#2.output"})
    private final int zzt(zznv zznv2, zzqg zzqg2, int n) throws IOException {
        int n2;
        int n3;
        Object object;
        int n4;
        boolean bl;
        zzox zzox2;
        block23: {
            block25: {
                int n5;
                block26: {
                    block24: {
                        if ("S_TEXT/UTF8".equals(zzqg2.zzb)) {
                            this.zzv(zznv2, zzb, n);
                            n = this.zzX;
                            this.zzu();
                            return n;
                        }
                        if ("S_TEXT/ASS".equals(zzqg2.zzb)) {
                            this.zzv(zznv2, zzd, n);
                            n = this.zzX;
                            this.zzu();
                            return n;
                        }
                        zzox2 = zzqg2.zzV;
                        boolean bl2 = this.zzZ;
                        bl = true;
                        if (bl2) break block23;
                        if (!zzqg2.zzg) break block24;
                        this.zzT &= 0xBFFFFFFF;
                        bl2 = this.zzaa;
                        n4 = 128;
                        if (!bl2) {
                            object = this.zzl.zzi();
                            ((zznp)zznv2).zza(object, 0, 1, false);
                            ++this.zzW;
                            if ((this.zzl.zzi()[0] & 0x80) == 128) throw zzaha.zzb((String)"Extension bit is set in signal byte", null);
                            this.zzad = this.zzl.zzi()[0];
                            this.zzaa = true;
                        }
                        if (((n3 = this.zzad) & 1) != 1) break block25;
                        n3 &= 2;
                        this.zzT |= 0x40000000;
                        if (!this.zzae) {
                            object = this.zzq.zzi();
                            ((zznp)zznv2).zza(object, 0, 8, false);
                            this.zzW += 8;
                            this.zzae = true;
                            object = this.zzl.zzi();
                            if (n3 != 2) {
                                n4 = 0;
                            }
                            object[0] = (byte)(n4 | 8);
                            this.zzl.zzh(0);
                            zzox2.zzu(this.zzl, 1, 1);
                            ++this.zzX;
                            this.zzq.zzh(0);
                            zzox2.zzu(this.zzq, 8, 1);
                            this.zzX += 8;
                        }
                        if (n3 != 2) break block25;
                        if (!this.zzab) {
                            object = this.zzl.zzi();
                            ((zznp)zznv2).zza(object, 0, 1, false);
                            ++this.zzW;
                            this.zzl.zzh(0);
                            this.zzac = this.zzl.zzn();
                            this.zzab = true;
                        }
                        n4 = this.zzac * 4;
                        this.zzl.zza(n4);
                        object = this.zzl.zzi();
                        ((zznp)zznv2).zza(object, 0, n4, false);
                        this.zzW += n4;
                        n4 = (this.zzac >> 1) + 1;
                        n5 = n4 * 6 + 2;
                        object = this.zzt;
                        if (object == null || object.capacity() < n5) {
                            this.zzt = ByteBuffer.allocate(n5);
                        }
                        this.zzt.position(0);
                        this.zzt.putShort((short)n4);
                        n4 = 0;
                        break block26;
                    }
                    object = zzqg2.zzh;
                    if (object != null) {
                        this.zzo.zzb(object, ((byte[])object).length);
                    }
                    break block25;
                }
                for (n3 = 0; n3 < (n2 = this.zzac); ++n3) {
                    n2 = this.zzl.zzB();
                    if (n3 % 2 == 0) {
                        this.zzt.putShort((short)(n2 - n4));
                    } else {
                        this.zzt.putInt(n2 - n4);
                    }
                    n4 = n2;
                }
                n4 = n - this.zzW - n4;
                if ((n2 & 1) == 1) {
                    this.zzt.putInt(n4);
                } else {
                    this.zzt.putShort((short)n4);
                    this.zzt.putInt(0);
                }
                this.zzr.zzb(this.zzt.array(), n5);
                zzox2.zzu(this.zzr, n5, 1);
                this.zzX += n5;
            }
            if (zzqg2.zzf > 0) {
                this.zzT |= 0x10000000;
                this.zzs.zza(0);
                this.zzl.zza(4);
                this.zzl.zzi()[0] = (byte)(n >> 24 & 0xFF);
                this.zzl.zzi()[1] = (byte)(n >> 16 & 0xFF);
                this.zzl.zzi()[2] = (byte)(n >> 8 & 0xFF);
                this.zzl.zzi()[3] = (byte)(n & 0xFF);
                zzox2.zzu(this.zzl, 4, 2);
                this.zzX += 4;
            }
            this.zzZ = true;
        }
        n += this.zzo.zze();
        if (!"V_MPEG4/ISO/AVC".equals(zzqg2.zzb) && !"V_MPEGH/ISO/HEVC".equals(zzqg2.zzb)) {
            if (zzqg2.zzS != null) {
                if (this.zzo.zze() != 0) {
                    bl = false;
                }
                zzakt.zzd((boolean)bl);
                zzqg2.zzS.zzb(zznv2);
            }
            while ((n4 = this.zzW) < n) {
                n4 = this.zzx(zznv2, zzox2, n - n4);
                this.zzW += n4;
                this.zzX += n4;
            }
        } else {
            object = this.zzk.zzi();
            object[0] = 0;
            object[1] = 0;
            object[2] = 0;
            n4 = zzqg2.zzW;
            n3 = 4 - n4;
            while (this.zzW < n) {
                n2 = this.zzY;
                if (n2 == 0) {
                    n2 = Math.min(n4, this.zzo.zzd());
                    ((zznp)zznv2).zza(object, n3 + n2, n4 - n2, false);
                    if (n2 > 0) {
                        this.zzo.zzm(object, n3, n2);
                    }
                    this.zzW += n4;
                    this.zzk.zzh(0);
                    this.zzY = this.zzk.zzB();
                    this.zzj.zzh(0);
                    zzov.zzb((zzox)zzox2, (zzamf)this.zzj, (int)4);
                    this.zzX += 4;
                    continue;
                }
                n2 = this.zzx(zznv2, zzox2, n2);
                this.zzW += n2;
                this.zzX += n2;
                this.zzY -= n2;
            }
        }
        if ("A_VORBIS".equals(zzqg2.zzb)) {
            this.zzm.zzh(0);
            zzov.zzb((zzox)zzox2, (zzamf)this.zzm, (int)4);
            this.zzX += 4;
        }
        n = this.zzX;
        this.zzu();
        return n;
    }

    private final void zzu() {
        this.zzW = 0;
        this.zzX = 0;
        this.zzY = 0;
        this.zzZ = false;
        this.zzaa = false;
        this.zzab = false;
        this.zzac = 0;
        this.zzad = 0;
        this.zzae = false;
        this.zzo.zza(0);
    }

    private final void zzv(zznv zznv2, byte[] byArray, int n) throws IOException {
        int n2 = byArray.length;
        n2 = n + 32;
        if (this.zzp.zzj() < n2) {
            zzamf zzamf2 = this.zzp;
            byArray = Arrays.copyOf(byArray, n2 + n);
            zzamf2.zzb(byArray, byArray.length);
        } else {
            System.arraycopy(byArray, 0, this.zzp.zzi(), 0, 32);
        }
        byArray = this.zzp.zzi();
        ((zznp)zznv2).zza(byArray, 32, n, false);
        this.zzp.zzh(0);
        this.zzp.zzf(n2);
    }

    private static byte[] zzw(long l, String string, long l2) {
        boolean bl = l != -9223372036854775807L;
        zzakt.zza((boolean)bl);
        int n = (int)(l / 3600000000L);
        int n2 = (int)((l -= (long)(n * 3600) * 1000000L) / 60000000L);
        int n3 = (int)((l -= (long)(n2 * 60) * 1000000L) / 1000000L);
        l = (l - (long)n3 * 1000000L) / l2;
        return zzamq.zzs((String)String.format(Locale.US, string, n, n2, n3, (int)l));
    }

    private final int zzx(zznv zznv2, zzox zzox2, int n) throws IOException {
        int n2 = this.zzo.zzd();
        if (n2 > 0) {
            n = Math.min(n, n2);
            zzov.zzb((zzox)zzox2, (zzamf)this.zzo, (int)n);
        } else {
            n = zzov.zza((zzox)zzox2, (zzah)zznv2, (int)n, (boolean)false);
        }
        return n;
    }

    private final long zzy(long l) throws zzaha {
        long l2 = this.zzw;
        if (l2 == -9223372036854775807L) throw zzaha.zzb((String)"Can't scale timecode prior to timecodeScale being set.", null);
        return zzamq.zzH((long)l, (long)l2, (long)1000L);
    }

    private static int[] zzz(int[] nArray, int n) {
        if (nArray == null) {
            return new int[n];
        }
        int n2 = nArray.length;
        if (n2 < n) return new int[Math.max(n2 + n2, n)];
        return nArray;
    }

    public final boolean zza(zznv zznv2) throws IOException {
        return new zzqj().zza(zznv2);
    }

    public final void zzb(zznx zznx2) {
        this.zzaf = zznx2;
    }

    public final int zzc(zznv zznv2, zzoq zzoq2) throws IOException {
        int n;
        block3: {
            block4: {
                long l;
                int n2 = 0;
                this.zzK = false;
                do {
                    if (this.zzK) return 0;
                    n = n2;
                    if (!this.zzag.zzc(zznv2)) break block3;
                    l = zznv2.zzn();
                    if (!this.zzD) continue;
                    this.zzF = l;
                    zzoq2.zza = this.zzE;
                    this.zzD = false;
                    break block4;
                } while (!this.zzA || (l = this.zzF) == -1L);
                zzoq2.zza = l;
                this.zzF = -1L;
            }
            return 1;
        }
        while (n < this.zzh.size()) {
            zznv2 = (zzqg)this.zzh.valueAt(n);
            zzqg.zze((zzqg)zznv2);
            zzoq2 = zznv2.zzS;
            if (zzoq2 != null) {
                zzoq2.zzd((zzqg)zznv2);
            }
            ++n;
        }
        return -1;
    }

    public final void zzd(long l, long l2) {
        this.zzG = -9223372036854775807L;
        int n = 0;
        this.zzL = 0;
        this.zzag.zzb();
        this.zzg.zza();
        this.zzu();
        while (n < this.zzh.size()) {
            zzqh zzqh2 = ((zzqg)this.zzh.valueAt((int)n)).zzS;
            if (zzqh2 != null) {
                zzqh2.zza();
            }
            ++n;
        }
    }

    protected final void zzh(int n, long l, long l2) throws zzaha {
        zzakt.zze((Object)this.zzaf);
        if (n == 160) {
            this.zzV = false;
            return;
        }
        if (n == 174) {
            this.zzz = new zzqg(null);
            return;
        }
        if (n == 187) {
            this.zzJ = false;
            return;
        }
        if (n == 19899) {
            this.zzB = -1;
            this.zzC = -1L;
            return;
        }
        if (n == 20533) {
            this.zzp(n);
            this.zzz.zzg = true;
            return;
        }
        if (n == 21968) {
            this.zzp(n);
            this.zzz.zzw = true;
            return;
        }
        if (n != 408125543) {
            if (n == 475249515) {
                this.zzH = new zzalo(32);
                this.zzI = new zzalo(32);
                return;
            }
            if (n != 524531317) return;
            if (this.zzA) return;
            if (this.zzi && this.zzE != -1L) {
                this.zzD = true;
                return;
            }
            this.zzaf.zzD((zzot)new zzos(this.zzy, 0L));
            this.zzA = true;
            return;
        }
        long l3 = this.zzv;
        if (l3 != -1L) {
            if (l3 != l) throw zzaha.zzb((String)"Multiple Segment elements not supported", null);
        }
        this.zzv = l;
        this.zzu = l2;
    }

    protected final void zzi(int n) throws zzaha {
        int n2;
        block57: {
            zzqg zzqg2;
            block58: {
                zzakt.zze((Object)this.zzaf);
                n2 = 2;
                if (n == 160) break block57;
                if (n != 174) {
                    if (n != 19899) {
                        if (n == 25152) {
                            this.zzp(n);
                            zzqg zzqg3 = this.zzz;
                            if (!zzqg3.zzg) return;
                            if (zzqg3.zzi == null) throw zzaha.zzb((String)"Encrypted Track found but ContentEncKeyID was not found", null);
                            zzqg3.zzk = new zzn(null, new zzm[]{new zzm(zzadx.zza, null, "video/webm", this.zzz.zzi.zzb)});
                            return;
                        }
                        if (n != 28032) {
                            long l;
                            if (n != 357149030) {
                                if (n == 374648427) {
                                    if (this.zzh.size() == 0) throw zzaha.zzb((String)"No valid tracks were found", null);
                                    this.zzaf.zzC();
                                    return;
                                }
                                if (n != 475249515) return;
                                if (!this.zzA) {
                                    zznx zznx2 = this.zzaf;
                                    Object object = this.zzH;
                                    Object object2 = this.zzI;
                                    if (this.zzv != -1L && this.zzy != -9223372036854775807L && object != null && object.zzc() != 0 && object2 != null && object2.zzc() == object.zzc()) {
                                        long l2;
                                        int n3 = object.zzc();
                                        int[] nArray = new int[n3];
                                        long[] lArray = new long[n3];
                                        long[] lArray2 = new long[n3];
                                        long[] lArray3 = new long[n3];
                                        for (n = 0; n < n3; ++n) {
                                            lArray3[n] = object.zzb(n);
                                            lArray[n] = this.zzv + object2.zzb(n);
                                        }
                                        n = 0;
                                        while (n < (n2 = n3 - 1)) {
                                            n2 = n + 1;
                                            nArray[n] = (int)(lArray[n2] - lArray[n]);
                                            lArray2[n] = lArray3[n2] - lArray3[n];
                                            n = n2;
                                        }
                                        nArray[n2] = (int)(this.zzv + this.zzu - lArray[n2]);
                                        lArray2[n2] = l2 = this.zzy - lArray3[n2];
                                        int[] nArray2 = nArray;
                                        long[] lArray4 = lArray;
                                        object2 = lArray2;
                                        object = lArray3;
                                        if (l2 <= 0L) {
                                            object = new StringBuilder(72);
                                            object.append("Discarding last cue point with unexpected duration: ");
                                            object.append(l2);
                                            Log.w((String)"MatroskaExtractor", (String)object.toString());
                                            nArray2 = Arrays.copyOf(nArray, n2);
                                            lArray4 = Arrays.copyOf(lArray, n2);
                                            object2 = Arrays.copyOf(lArray2, n2);
                                            object = Arrays.copyOf(lArray3, n2);
                                        }
                                        object = new zznn(nArray2, lArray4, (long[])object2, (long[])object);
                                    } else {
                                        object = new zzos(this.zzy, 0L);
                                    }
                                    zznx2.zzD((zzot)object);
                                    this.zzA = true;
                                }
                                this.zzH = null;
                                this.zzI = null;
                                return;
                            }
                            if (this.zzw == -9223372036854775807L) {
                                this.zzw = 1000000L;
                            }
                            if ((l = this.zzx) == -9223372036854775807L) return;
                            this.zzy = this.zzy(l);
                            return;
                        }
                        this.zzp(n);
                        zzqg zzqg4 = this.zzz;
                        if (!zzqg4.zzg) return;
                        if (zzqg4.zzh != null) throw zzaha.zzb((String)"Combining encryption and compression is not supported", null);
                    } else {
                        n = this.zzB;
                        if (n == -1) throw zzaha.zzb((String)"Mandatory element SeekID or SeekPosition not found", null);
                        long l = this.zzC;
                        if (l == -1L) throw zzaha.zzb((String)"Mandatory element SeekID or SeekPosition not found", null);
                        if (n != 475249515) return;
                        this.zzE = l;
                    }
                    return;
                }
                zzqg2 = this.zzz;
                zzakt.zze((Object)zzqg2);
                String string = zzqg2.zzb;
                if (string == null) throw zzaha.zzb((String)"CodecId is missing in TrackEntry element", null);
                switch (string.hashCode()) {
                    default: {
                        break;
                    }
                    case 1951062397: {
                        if (!string.equals("A_OPUS")) break;
                        n = 11;
                        break block58;
                    }
                    case 1950789798: {
                        if (!string.equals("A_FLAC")) break;
                        n = 22;
                        break block58;
                    }
                    case 1950749482: {
                        if (!string.equals("A_EAC3")) break;
                        n = 17;
                        break block58;
                    }
                    case 1809237540: {
                        if (!string.equals("V_MPEG2")) break;
                        n = 3;
                        break block58;
                    }
                    case 1422270023: {
                        if (!string.equals("S_TEXT/UTF8")) break;
                        n = 27;
                        break block58;
                    }
                    case 855502857: {
                        if (!string.equals("V_MPEGH/ISO/HEVC")) break;
                        n = 8;
                        break block58;
                    }
                    case 738597099: {
                        if (!string.equals("S_TEXT/ASS")) break;
                        n = 28;
                        break block58;
                    }
                    case 725957860: {
                        if (!string.equals("A_PCM/INT/LIT")) break;
                        n = 24;
                        break block58;
                    }
                    case 725948237: {
                        if (!string.equals("A_PCM/INT/BIG")) break;
                        n = 25;
                        break block58;
                    }
                    case 635596514: {
                        if (!string.equals("A_PCM/FLOAT/IEEE")) break;
                        n = 26;
                        break block58;
                    }
                    case 542569478: {
                        if (!string.equals("A_DTS/EXPRESS")) break;
                        n = 20;
                        break block58;
                    }
                    case 444813526: {
                        if (!string.equals("V_THEORA")) break;
                        n = 10;
                        break block58;
                    }
                    case 99146302: {
                        if (!string.equals("S_HDMV/PGS")) break;
                        n = 30;
                        break block58;
                    }
                    case 82338134: {
                        if (!string.equals("V_VP9")) break;
                        n = 1;
                        break block58;
                    }
                    case 82338133: {
                        if (!string.equals("V_VP8")) break;
                        n = 0;
                        break block58;
                    }
                    case 82318131: {
                        if (!string.equals("V_AV1")) break;
                        n = n2;
                        break block58;
                    }
                    case 62927045: {
                        if (!string.equals("A_DTS")) break;
                        n = 19;
                        break block58;
                    }
                    case 62923603: {
                        if (!string.equals("A_AC3")) break;
                        n = 16;
                        break block58;
                    }
                    case 62923557: {
                        if (!string.equals("A_AAC")) break;
                        n = 13;
                        break block58;
                    }
                    case -356037306: {
                        if (!string.equals("A_DTS/LOSSLESS")) break;
                        n = 21;
                        break block58;
                    }
                    case -425012669: {
                        if (!string.equals("S_VOBSUB")) break;
                        n = 29;
                        break block58;
                    }
                    case -538363109: {
                        if (!string.equals("V_MPEG4/ISO/AVC")) break;
                        n = 7;
                        break block58;
                    }
                    case -538363189: {
                        if (!string.equals("V_MPEG4/ISO/ASP")) break;
                        n = 5;
                        break block58;
                    }
                    case -933872740: {
                        if (!string.equals("S_DVBSUB")) break;
                        n = 31;
                        break block58;
                    }
                    case -1373388978: {
                        if (!string.equals("V_MS/VFW/FOURCC")) break;
                        n = 9;
                        break block58;
                    }
                    case -1482641357: {
                        if (!string.equals("A_MPEG/L3")) break;
                        n = 15;
                        break block58;
                    }
                    case -1482641358: {
                        if (!string.equals("A_MPEG/L2")) break;
                        n = 14;
                        break block58;
                    }
                    case -1730367663: {
                        if (!string.equals("A_VORBIS")) break;
                        n = 12;
                        break block58;
                    }
                    case -1784763192: {
                        if (!string.equals("A_TRUEHD")) break;
                        n = 18;
                        break block58;
                    }
                    case -1985379776: {
                        if (!string.equals("A_MS/ACM")) break;
                        n = 23;
                        break block58;
                    }
                    case -2095575984: {
                        if (!string.equals("V_MPEG4/ISO/SP")) break;
                        n = 4;
                        break block58;
                    }
                    case -2095576542: {
                        if (!string.equals("V_MPEG4/ISO/AP")) break;
                        n = 6;
                        break block58;
                    }
                }
                n = -1;
            }
            switch (n) {
                case 0: 
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 9: 
                case 10: 
                case 11: 
                case 12: 
                case 13: 
                case 14: 
                case 15: 
                case 16: 
                case 17: 
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 31: {
                    zzqg2.zzd(this.zzaf, zzqg2.zzc);
                    this.zzh.put(zzqg2.zzc, (Object)zzqg2);
                    break;
                }
            }
            this.zzz = null;
            return;
        }
        if (this.zzL != 2) return;
        n = 0;
        for (n2 = 0; n2 < this.zzP; n += this.zzQ[n2], ++n2) {
        }
        zzqg zzqg5 = (zzqg)this.zzh.get(this.zzR);
        zzqg.zze((zzqg)zzqg5);
        n2 = 0;
        int n4 = n;
        while (true) {
            if (n2 >= this.zzP) {
                this.zzL = 0;
                return;
            }
            long l = this.zzM;
            long l3 = zzqg5.zze * n2 / 1000;
            int n5 = this.zzT;
            if (n2 == 0) {
                n = n5;
                if (!this.zzV) {
                    n = n5 | 1;
                }
                n2 = 0;
            } else {
                n = n5;
            }
            n5 = this.zzQ[n2];
            this.zzr(zzqg5, l3 + l, n, n5, n4 -= n5);
            ++n2;
        }
    }

    protected final void zzj(int n, long l) throws zzaha {
        block51: {
            block49: {
                block50: {
                    if (n == 20529) break block49;
                    if (n == 20530) break block50;
                    boolean bl = false;
                    boolean bl2 = false;
                    switch (n) {
                        default: {
                            switch (n) {
                                default: {
                                    break block51;
                                }
                                case 21949: {
                                    this.zzp(n);
                                    this.zzz.zzB = (int)l;
                                    return;
                                }
                                case 21948: {
                                    this.zzp(n);
                                    this.zzz.zzA = (int)l;
                                    return;
                                }
                                case 21947: {
                                    this.zzp(n);
                                    this.zzz.zzw = true;
                                    n = com.google.android.gms.internal.ads.zzj.zza((int)((int)l));
                                    if (n == -1) return;
                                    this.zzz.zzx = n;
                                    return;
                                }
                                case 21946: {
                                    this.zzp(n);
                                    n = com.google.android.gms.internal.ads.zzj.zzb((int)((int)l));
                                    if (n == -1) return;
                                    this.zzz.zzy = n;
                                    return;
                                }
                                case 21945: {
                                    this.zzp(n);
                                    n = (int)l;
                                    if (n == 1) {
                                        this.zzz.zzz = 2;
                                        return;
                                    }
                                    if (n != 2) return;
                                    this.zzz.zzz = 1;
                                    return;
                                }
                            }
                        }
                        case 2807729: {
                            this.zzw = l;
                            return;
                        }
                        case 2352003: {
                            this.zzp(n);
                            this.zzz.zze = (int)l;
                            return;
                        }
                        case 30321: {
                            this.zzp(n);
                            n = (int)l;
                            if (n == 0) {
                                this.zzz.zzq = 0;
                                return;
                            }
                            if (n == 1) {
                                this.zzz.zzq = 1;
                                return;
                            }
                            if (n == 2) {
                                this.zzz.zzq = 2;
                                return;
                            }
                            if (n != 3) return;
                            this.zzz.zzq = 3;
                            return;
                        }
                        case 25188: {
                            this.zzp(n);
                            this.zzz.zzO = (int)l;
                            return;
                        }
                        case 22203: {
                            this.zzp(n);
                            this.zzz.zzR = l;
                            return;
                        }
                        case 22186: {
                            this.zzp(n);
                            this.zzz.zzQ = l;
                            return;
                        }
                        case 21998: {
                            this.zzp(n);
                            this.zzz.zzf = (int)l;
                            return;
                        }
                        case 21930: {
                            this.zzp(n);
                            zzqg zzqg2 = this.zzz;
                            bl = bl2;
                            if (l == 1L) {
                                bl = true;
                            }
                            zzqg2.zzT = bl;
                            return;
                        }
                        case 21690: {
                            this.zzp(n);
                            this.zzz.zzo = (int)l;
                            return;
                        }
                        case 21682: {
                            this.zzp(n);
                            this.zzz.zzp = (int)l;
                            return;
                        }
                        case 21680: {
                            this.zzp(n);
                            this.zzz.zzn = (int)l;
                            return;
                        }
                        case 21432: {
                            this.zzp(n);
                            n = (int)l;
                            if (n == 0) {
                                this.zzz.zzv = 0;
                                return;
                            }
                            if (n == 1) {
                                this.zzz.zzv = 2;
                                return;
                            }
                            if (n == 3) {
                                this.zzz.zzv = 1;
                                return;
                            }
                            if (n != 15) return;
                            this.zzz.zzv = 3;
                            return;
                        }
                        case 21420: {
                            this.zzC = l + this.zzv;
                            return;
                        }
                        case 18408: {
                            if (l == 1L) return;
                            StringBuilder stringBuilder = new StringBuilder(56);
                            stringBuilder.append("AESSettingsCipherMode ");
                            stringBuilder.append(l);
                            stringBuilder.append(" not supported");
                            throw zzaha.zzb((String)stringBuilder.toString(), null);
                        }
                        case 18401: {
                            if (l == 5L) return;
                            StringBuilder stringBuilder = new StringBuilder(49);
                            stringBuilder.append("ContentEncAlgo ");
                            stringBuilder.append(l);
                            stringBuilder.append(" not supported");
                            throw zzaha.zzb((String)stringBuilder.toString(), null);
                        }
                        case 17143: {
                            if (l == 1L) return;
                            StringBuilder stringBuilder = new StringBuilder(50);
                            stringBuilder.append("EBMLReadVersion ");
                            stringBuilder.append(l);
                            stringBuilder.append(" not supported");
                            throw zzaha.zzb((String)stringBuilder.toString(), null);
                        }
                        case 17029: {
                            if (l >= 1L && l <= 2L) return;
                            StringBuilder stringBuilder = new StringBuilder(53);
                            stringBuilder.append("DocTypeReadVersion ");
                            stringBuilder.append(l);
                            stringBuilder.append(" not supported");
                            throw zzaha.zzb((String)stringBuilder.toString(), null);
                        }
                        case 16980: {
                            if (l == 3L) return;
                            StringBuilder stringBuilder = new StringBuilder(50);
                            stringBuilder.append("ContentCompAlgo ");
                            stringBuilder.append(l);
                            stringBuilder.append(" not supported");
                            throw zzaha.zzb((String)stringBuilder.toString(), null);
                        }
                        case 16871: {
                            this.zzp(n);
                            zzqg.zza((zzqg)this.zzz, (int)((int)l));
                            return;
                        }
                        case 251: {
                            this.zzV = true;
                            return;
                        }
                        case 241: {
                            if (this.zzJ) return;
                            this.zzq(n);
                            this.zzI.zza(l);
                            this.zzJ = true;
                            return;
                        }
                        case 238: {
                            this.zzU = (int)l;
                            return;
                        }
                        case 231: {
                            this.zzG = this.zzy(l);
                            return;
                        }
                        case 215: {
                            this.zzp(n);
                            this.zzz.zzc = (int)l;
                            return;
                        }
                        case 186: {
                            this.zzp(n);
                            this.zzz.zzm = (int)l;
                            return;
                        }
                        case 179: {
                            this.zzq(n);
                            this.zzH.zza(this.zzy(l));
                            return;
                        }
                        case 176: {
                            this.zzp(n);
                            this.zzz.zzl = (int)l;
                            return;
                        }
                        case 159: {
                            this.zzp(n);
                            this.zzz.zzN = (int)l;
                            return;
                        }
                        case 155: {
                            this.zzN = this.zzy(l);
                            return;
                        }
                        case 136: {
                            this.zzp(n);
                            zzqg zzqg3 = this.zzz;
                            if (l == 1L) {
                                bl = true;
                            }
                            zzqg3.zzU = bl;
                            return;
                        }
                        case 131: {
                            this.zzp(n);
                            this.zzz.zzd = (int)l;
                            return;
                        }
                    }
                }
                if (l == 1L) return;
                StringBuilder stringBuilder = new StringBuilder(55);
                stringBuilder.append("ContentEncodingScope ");
                stringBuilder.append(l);
                stringBuilder.append(" not supported");
                throw zzaha.zzb((String)stringBuilder.toString(), null);
            }
            if (l == 0L) return;
            StringBuilder stringBuilder = new StringBuilder(55);
            stringBuilder.append("ContentEncodingOrder ");
            stringBuilder.append(l);
            stringBuilder.append(" not supported");
            throw zzaha.zzb((String)stringBuilder.toString(), null);
        }
    }

    protected final void zzk(int n, double d) throws zzaha {
        if (n == 181) {
            this.zzp(n);
            this.zzz.zzP = (int)d;
            return;
        }
        if (n == 17545) {
            this.zzx = (long)d;
            return;
        }
        switch (n) {
            default: {
                switch (n) {
                    default: {
                        return;
                    }
                    case 30325: {
                        this.zzp(n);
                        this.zzz.zzt = (float)d;
                        return;
                    }
                    case 30324: {
                        this.zzp(n);
                        this.zzz.zzs = (float)d;
                        return;
                    }
                    case 30323: 
                }
                this.zzp(n);
                this.zzz.zzr = (float)d;
                return;
            }
            case 21978: {
                this.zzp(n);
                this.zzz.zzL = (float)d;
                return;
            }
            case 21977: {
                this.zzp(n);
                this.zzz.zzK = (float)d;
                return;
            }
            case 21976: {
                this.zzp(n);
                this.zzz.zzJ = (float)d;
                return;
            }
            case 21975: {
                this.zzp(n);
                this.zzz.zzI = (float)d;
                return;
            }
            case 21974: {
                this.zzp(n);
                this.zzz.zzH = (float)d;
                return;
            }
            case 21973: {
                this.zzp(n);
                this.zzz.zzG = (float)d;
                return;
            }
            case 21972: {
                this.zzp(n);
                this.zzz.zzF = (float)d;
                return;
            }
            case 21971: {
                this.zzp(n);
                this.zzz.zzE = (float)d;
                return;
            }
            case 21970: {
                this.zzp(n);
                this.zzz.zzD = (float)d;
                return;
            }
            case 21969: 
        }
        this.zzp(n);
        this.zzz.zzC = (float)d;
    }

    protected final void zzl(int n, String string) throws zzaha {
        if (n == 134) {
            this.zzp(n);
            this.zzz.zzb = string;
            return;
        }
        if (n != 17026) {
            if (n == 21358) {
                this.zzp(n);
                this.zzz.zza = string;
                return;
            }
            if (n != 2274716) return;
            this.zzp(n);
            zzqg.zzc((zzqg)this.zzz, (String)string);
            return;
        }
        if ("webm".equals(string)) return;
        if ("matroska".equals(string)) return;
        StringBuilder stringBuilder = new StringBuilder(string.length() + 22);
        stringBuilder.append("DocType ");
        stringBuilder.append(string);
        stringBuilder.append(" not supported");
        throw zzaha.zzb((String)stringBuilder.toString(), null);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    protected final void zzm(int var1_1, int var2_2, zznv var3_3) throws IOException {
        block25: {
            block28: {
                block27: {
                    block26: {
                        var4_4 = var1_1;
                        if (var4_4 != 161 && var4_4 != 163) {
                            if (var4_4 != 165) {
                                if (var4_4 != 16877) {
                                    if (var4_4 == 16981) {
                                        this.zzp(var1_1);
                                        var15_9 /* !! */  = this.zzz;
                                        var15_9 /* !! */ .zzh = new byte[var2_2];
                                        var15_9 /* !! */  = (zzqg)var15_9 /* !! */ .zzh;
                                        ((zznp)var3_3).zza((byte[])var15_9 /* !! */ , 0, var2_2, false);
                                        return;
                                    }
                                    if (var4_4 == 18402) {
                                        var15_8 = new byte[var2_2];
                                        ((zznp)var3_3).zza(var15_8, 0, var2_2, false);
                                        this.zzp(var1_1);
                                        this.zzz.zzi = new zzow(1, var15_8, 0, 0);
                                        return;
                                    }
                                    if (var4_4 == 21419) {
                                        Arrays.fill(this.zzn.zzi(), (byte)0);
                                        var15_7 = this.zzn.zzi();
                                        ((zznp)var3_3).zza(var15_7, 4 - var2_2, var2_2, false);
                                        this.zzn.zzh(0);
                                        this.zzB = (int)this.zzn.zzt();
                                        return;
                                    }
                                    if (var4_4 == 25506) {
                                        this.zzp(var1_1);
                                        var15_6 /* !! */  = this.zzz;
                                        var15_6 /* !! */ .zzj = new byte[var2_2];
                                        var15_6 /* !! */  = (zzqg)var15_6 /* !! */ .zzj;
                                        ((zznp)var3_3).zza((byte[])var15_6 /* !! */ , 0, var2_2, false);
                                        return;
                                    }
                                    if (var4_4 == 30322) {
                                        this.zzp(var1_1);
                                        var15_5 /* !! */  = this.zzz;
                                        var15_5 /* !! */ .zzu = new byte[var2_2];
                                        var15_5 /* !! */  = (zzqg)var15_5 /* !! */ .zzu;
                                        ((zznp)var3_3).zza((byte[])var15_5 /* !! */ , 0, var2_2, false);
                                        return;
                                    }
                                    var3_3 = new StringBuilder(26);
                                    var3_3.append("Unexpected id: ");
                                    var3_3.append(var4_4);
                                    throw zzaha.zzb((String)var3_3.toString(), null);
                                }
                                this.zzp(var1_1);
                                var15_10 /* !! */  = this.zzz;
                                if (zzqg.zzb((zzqg)var15_10 /* !! */ ) != 1685485123 && zzqg.zzb((zzqg)var15_10 /* !! */ ) != 1685480259) {
                                    ((zznp)var3_3).zzd(var2_2, false);
                                    return;
                                }
                                var15_10 /* !! */ .zzM = new byte[var2_2];
                                var15_10 /* !! */  = (zzqg)var15_10 /* !! */ .zzM;
                                ((zznp)var3_3).zza((byte[])var15_10 /* !! */ , 0, var2_2, false);
                                return;
                            }
                            if (this.zzL != 2) {
                                return;
                            }
                            var15_11 /* !! */  = (zzqg)this.zzh.get(this.zzR);
                            if (this.zzU == 4 && "V_VP9".equals(var15_11 /* !! */ .zzb)) {
                                this.zzs.zza(var2_2);
                                var15_11 /* !! */  = (zzqg)this.zzs.zzi();
                                ((zznp)var3_3).zza((byte[])var15_11 /* !! */ , 0, var2_2, false);
                                return;
                            }
                            ((zznp)var3_3).zzd(var2_2, false);
                            return;
                        }
                        if (this.zzL == 0) {
                            this.zzR = (int)this.zzg.zzb((zznv)var3_3, false, true, 8);
                            this.zzS = this.zzg.zzc();
                            this.zzN = -9223372036854775807L;
                            this.zzL = 1;
                            this.zzl.zza(0);
                        }
                        if ((var15_12 = (zzqg)this.zzh.get(this.zzR)) == null) {
                            var1_1 = this.zzS;
                            ((zznp)var3_3).zzd(var2_2 - var1_1, false);
                            this.zzL = 0;
                            return;
                        }
                        zzqg.zze((zzqg)var15_12);
                        var1_1 = var4_4;
                        if (this.zzL != 1) break block25;
                        this.zzs((zznv)var3_3, 3);
                        var5_13 = (this.zzl.zzi()[2] & 6) >> 1;
                        if (var5_13 != 0) break block26;
                        this.zzP = 1;
                        this.zzQ = var16_14 = zzqi.zzz(this.zzQ, 1);
                        var16_14[0] = var2_2 - this.zzS - 3;
                        ** GOTO lbl136
                    }
                    this.zzs((zznv)var3_3, 4);
                    this.zzP = var1_1 = (this.zzl.zzi()[3] & 255) + 1;
                    this.zzQ = var16_14 = zzqi.zzz(this.zzQ, var1_1);
                    if (var5_13 != 2) break block27;
                    var1_1 = this.zzS;
                    var5_13 = this.zzP;
                    Arrays.fill(var16_14, 0, var5_13, (var2_2 - var1_1 - 4) / var5_13);
                    ** GOTO lbl136
                }
                if (var5_13 != 1) break block28;
                var6_15 = 0;
                var1_1 = 4;
                for (var5_13 = 0; var5_13 < (var7_16 = this.zzP - 1); var6_15 += var9_18, ++var5_13) {
                    this.zzQ[var5_13] = 0;
                    var7_16 = var1_1;
                    do {
                        var1_1 = var7_16 + 1;
                        this.zzs((zznv)var3_3, var1_1);
                        var8_17 = this.zzl.zzi()[var1_1 - 1] & 255;
                        var16_14 = this.zzQ;
                        var16_14[var5_13] = var9_18 = var16_14[var5_13] + var8_17;
                        var7_16 = var1_1;
                    } while (var8_17 == 255);
                }
                this.zzQ[var7_16] = var2_2 - this.zzS - var1_1 - var6_15;
                ** GOTO lbl136
            }
            if (var5_13 != 3) throw zzaha.zzb((String)"Unexpected lacing value: 2", null);
            var6_15 = 0;
            var1_1 = 4;
            var5_13 = 0;
            while (true) {
                block24: {
                    block30: {
                        block34: {
                            block31: {
                                block32: {
                                    block33: {
                                        block29: {
                                            if (var6_15 >= (var7_16 = this.zzP - 1)) break block29;
                                            this.zzQ[var6_15] = 0;
                                            this.zzs((zznv)var3_3, ++var1_1);
                                            var9_18 = var1_1 - 1;
                                            if (this.zzl.zzi()[var9_18] == 0) throw zzaha.zzb((String)"No valid varint length mask found", null);
                                            break block30;
                                        }
                                        this.zzQ[var7_16] = var2_2 - this.zzS - var1_1 - var5_13;
lbl136:
                                        // 4 sources

                                        var2_2 = this.zzl.zzi()[0];
                                        var1_1 = this.zzl.zzi()[1];
                                        this.zzM = this.zzG + this.zzy(var2_2 << 8 | var1_1 & 255);
                                        var1_1 = var4_4;
                                        if (var15_12.zzd == 2) break block31;
                                        var1_1 = var4_4;
                                        if (var4_4 != 163) break block32;
                                        if ((this.zzl.zzi()[2] & 128) != 128) break block33;
                                        var1_1 = 163;
                                        break block31;
                                    }
                                    var1_1 = 163;
                                }
                                var2_2 = 0;
                                break block34;
                            }
                            var2_2 = 1;
                        }
                        this.zzT = var2_2;
                        this.zzL = 2;
                        this.zzO = 0;
                        break;
                    }
                    for (var7_16 = 0; var7_16 < 8; ++var7_16) {
                        var10_19 = 1 << 7 - var7_16;
                        if ((this.zzl.zzi()[var9_18] & var10_19) == 0) continue;
                        var8_17 = var1_1 + var7_16;
                        this.zzs((zznv)var3_3, var8_17);
                        var13_21 = this.zzl.zzi()[var9_18] & 255 & ~var10_19;
                        for (var1_1 = var9_18 + 1; var1_1 < var8_17; ++var1_1) {
                            var13_21 = var13_21 << 8 | (long)(this.zzl.zzi()[var1_1] & 255);
                        }
                        var1_1 = var8_17;
                        var11_20 = var13_21;
                        if (var6_15 > 0) {
                            var11_20 = var13_21 - ((1L << var7_16 * 7 + 6) - 1L);
                            var1_1 = var8_17;
                        }
                        break block24;
                    }
                    var11_20 = 0L;
                }
                if (var11_20 < -2147483648L) throw zzaha.zzb((String)"EBML lacing sample size out of range.", null);
                if (var11_20 > 0x7FFFFFFFL) throw zzaha.zzb((String)"EBML lacing sample size out of range.", null);
                var8_17 = (int)var11_20;
                var16_14 = this.zzQ;
                var7_16 = var8_17;
                if (var6_15 != 0) {
                    var7_16 = var8_17 + var16_14[var6_15 - 1];
                }
                var16_14[var6_15] = var7_16;
                var5_13 += var7_16;
                ++var6_15;
            }
        }
        if (var1_1 != 163) {
            while ((var1_1 = this.zzO++) < this.zzP) {
                var16_14 = this.zzQ;
                var16_14[var1_1] = this.zzt((zznv)var3_3, var15_12, var16_14[var1_1]);
            }
            return;
        }
        while (true) {
            if ((var1_1 = this.zzO) >= this.zzP) {
                this.zzL = 0;
                return;
            }
            var1_1 = this.zzt((zznv)var3_3, var15_12, this.zzQ[var1_1]);
            var11_20 = this.zzM;
            this.zzr(var15_12, (long)(this.zzO * var15_12.zze / 1000) + var11_20, this.zzT, var1_1, 0);
            ++this.zzO;
        }
    }
}
