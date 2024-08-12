/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  com.google.android.gms.internal.ads.zzamx
 *  com.google.android.gms.internal.ads.zzanp
 *  com.google.android.gms.internal.ads.zzapj
 *  com.google.android.gms.internal.ads.zzapk
 *  com.google.android.gms.internal.ads.zzapm
 *  com.google.android.gms.internal.ads.zzapn
 *  com.google.android.gms.internal.ads.zzapo
 *  com.google.android.gms.internal.ads.zzapp
 *  com.google.android.gms.internal.ads.zzapq
 *  com.google.android.gms.internal.ads.zzapt
 *  com.google.android.gms.internal.ads.zzapu
 *  com.google.android.gms.internal.ads.zzapv
 *  com.google.android.gms.internal.ads.zzapw
 *  com.google.android.gms.internal.ads.zzapx
 *  com.google.android.gms.internal.ads.zzaqa
 *  com.google.android.gms.internal.ads.zzaqb
 *  com.google.android.gms.internal.ads.zzaqc
 *  com.google.android.gms.internal.ads.zzaqe
 *  com.google.android.gms.internal.ads.zzaqg
 *  com.google.android.gms.internal.ads.zzaqh
 *  com.google.android.gms.internal.ads.zzaus
 *  com.google.android.gms.internal.ads.zzauv
 *  com.google.android.gms.internal.ads.zzaux
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzamx;
import com.google.android.gms.internal.ads.zzanp;
import com.google.android.gms.internal.ads.zzapj;
import com.google.android.gms.internal.ads.zzapk;
import com.google.android.gms.internal.ads.zzapm;
import com.google.android.gms.internal.ads.zzapn;
import com.google.android.gms.internal.ads.zzapo;
import com.google.android.gms.internal.ads.zzapp;
import com.google.android.gms.internal.ads.zzapq;
import com.google.android.gms.internal.ads.zzapt;
import com.google.android.gms.internal.ads.zzapu;
import com.google.android.gms.internal.ads.zzapv;
import com.google.android.gms.internal.ads.zzapw;
import com.google.android.gms.internal.ads.zzapx;
import com.google.android.gms.internal.ads.zzaqa;
import com.google.android.gms.internal.ads.zzaqb;
import com.google.android.gms.internal.ads.zzaqc;
import com.google.android.gms.internal.ads.zzaqe;
import com.google.android.gms.internal.ads.zzaqg;
import com.google.android.gms.internal.ads.zzaqh;
import com.google.android.gms.internal.ads.zzaus;
import com.google.android.gms.internal.ads.zzauv;
import com.google.android.gms.internal.ads.zzaux;
import com.google.android.gms.internal.ads.zzave;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

public final class zzaqf
implements zzapo {
    public static final zzapq zza = new zzaqb();
    private static final byte[] zzb = new byte[]{49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzc = new byte[]{32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID zzd = new UUID(0x100000000001000L, -9223371306706625679L);
    private boolean zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private zzaus zzE;
    private zzaus zzF;
    private boolean zzG;
    private int zzH;
    private long zzI;
    private long zzJ;
    private int zzK;
    private int zzL;
    private int[] zzM;
    private int zzN;
    private int zzO;
    private int zzP;
    private int zzQ;
    private boolean zzR;
    private boolean zzS;
    private boolean zzT;
    private boolean zzU;
    private byte zzV;
    private int zzW;
    private int zzX;
    private int zzY;
    private boolean zzZ;
    private boolean zzaa;
    private zzapp zzab;
    private final zzaqa zzac;
    private final zzaqh zze;
    private final SparseArray<zzaqe> zzf;
    private final boolean zzg;
    private final zzaux zzh;
    private final zzaux zzi;
    private final zzaux zzj;
    private final zzaux zzk;
    private final zzaux zzl;
    private final zzaux zzm;
    private final zzaux zzn;
    private final zzaux zzo;
    private final zzaux zzp;
    private ByteBuffer zzq;
    private long zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private long zzv;
    private zzaqe zzw;
    private boolean zzx;
    private int zzy;
    private long zzz;

    public zzaqf() {
        this(0);
    }

    public zzaqf(int n) {
        zzaqa zzaqa2 = new zzaqa();
        this.zzs = -1L;
        this.zzt = -9223372036854775807L;
        this.zzu = -9223372036854775807L;
        this.zzv = -9223372036854775807L;
        this.zzB = -1L;
        this.zzC = -1L;
        this.zzD = -9223372036854775807L;
        this.zzac = zzaqa2;
        zzaqa2.zzb(new zzaqc(this, null));
        this.zzg = true;
        this.zze = new zzaqh();
        this.zzf = new SparseArray();
        this.zzj = new zzaux(4);
        this.zzk = new zzaux(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzl = new zzaux(4);
        this.zzh = new zzaux(zzauv.zza);
        this.zzi = new zzaux(4);
        this.zzm = new zzaux();
        this.zzn = new zzaux();
        this.zzo = new zzaux(8);
        this.zzp = new zzaux();
    }

    static /* synthetic */ UUID zza() {
        return zzd;
    }

    static final int zzl(int n) {
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
            case 21978: {
                return 5;
            }
            case 161: 
            case 163: 
            case 16981: 
            case 18402: 
            case 21419: 
            case 25506: 
            case 30322: {
                return 4;
            }
            case 160: 
            case 174: 
            case 183: 
            case 187: 
            case 224: 
            case 225: 
            case 18407: 
            case 19899: 
            case 20532: 
            case 20533: 
            case 21936: 
            case 21968: 
            case 25152: 
            case 28032: 
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
            case 241: 
            case 251: 
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
            case 22186: 
            case 22203: 
            case 25188: 
            case 2352003: 
            case 2807729: 
        }
        return 2;
    }

    static final boolean zzm(int n) {
        if (n == 357149030) return true;
        if (n == 524531317) return true;
        if (n == 475249515) return true;
        if (n != 374648427) return false;
        return true;
    }

    private final void zzn(zzaqe zzaqe2, long l) {
        if ("S_TEXT/UTF8".equals(zzaqe2.zza)) {
            Object object;
            Object object2 = this.zzn.zza;
            long l2 = this.zzJ;
            if (l2 == -9223372036854775807L) {
                object = zzc;
            } else {
                int n = (int)(l2 / 3600000000L);
                int n2 = (int)((l2 -= (long)n * 3600000000L) / 60000000L);
                int n3 = (int)((l2 -= (long)(60000000 * n2)) / 1000000L);
                object = zzave.zzd((String)String.format(Locale.US, "%02d:%02d:%02d,%03d", n, n2, n3, (int)((l2 - (long)(n3 * 1000000)) / 1000L)));
            }
            System.arraycopy(object, 0, object2, 19, 12);
            object = zzaqe2.zzN;
            object2 = this.zzn;
            object.zzb((zzaux)object2, object2.zze());
            this.zzY += this.zzn.zze();
        }
        zzaqe2.zzN.zzc(l, this.zzP, this.zzY, 0, zzaqe2.zzg);
        this.zzZ = true;
        this.zzo();
    }

    private final void zzo() {
        this.zzQ = 0;
        this.zzY = 0;
        this.zzX = 0;
        this.zzR = false;
        this.zzS = false;
        this.zzU = false;
        this.zzW = 0;
        this.zzV = 0;
        this.zzT = false;
        this.zzm.zzc();
    }

    private final long zzp(long l) throws zzanp {
        long l2 = this.zzt;
        if (l2 == -9223372036854775807L) throw new zzanp("Can't scale timecode prior to timecodeScale being set.");
        return zzave.zzj((long)l, (long)l2, (long)1000L);
    }

    private static int[] zzq(int[] nArray, int n) {
        if (nArray == null) {
            return new int[n];
        }
        int n2 = nArray.length;
        if (n2 < n) return new int[Math.max(n2 + n2, n)];
        return nArray;
    }

    private final void zzr(zzapn zzapn2, int n) throws IOException, InterruptedException {
        Object object;
        if (this.zzj.zze() >= n) {
            return;
        }
        if (this.zzj.zzh() < n) {
            zzaux zzaux2 = this.zzj;
            object = zzaux2.zza;
            int n2 = ((zzaux)object).length;
            zzaux2.zzb(Arrays.copyOf((byte[])object, Math.max(n2 + n2, n)), this.zzj.zze());
        }
        object = this.zzj;
        zzapn2.zzb(object.zza, object.zze(), n - this.zzj.zze(), false);
        this.zzj.zzf(n);
    }

    private final void zzs(zzapn zzapn2, zzaqe zzaqe2, int n) throws IOException, InterruptedException {
        int n2;
        Object object;
        int n3;
        int n4;
        zzapx zzapx2;
        block19: {
            block21: {
                int n5;
                block22: {
                    block20: {
                        if ("S_TEXT/UTF8".equals(zzaqe2.zza)) {
                            int n6 = n + 32;
                            if (this.zzn.zzh() < n6) {
                                this.zzn.zza = Arrays.copyOf(zzb, n6 + n);
                            }
                            zzapn2.zzb(this.zzn.zza, 32, n, false);
                            this.zzn.zzi(0);
                            this.zzn.zzf(n6);
                            return;
                        }
                        zzapx2 = zzaqe2.zzN;
                        if (this.zzR) break block19;
                        if (!zzaqe2.zze) break block20;
                        this.zzP &= 0xBFFFFFFF;
                        boolean bl = this.zzS;
                        n4 = 128;
                        if (!bl) {
                            zzapn2.zzb(this.zzj.zza, 0, 1, false);
                            ++this.zzQ;
                            byte by = this.zzj.zza[0];
                            if ((by & 0x80) == 128) throw new zzanp("Extension bit is set in signal byte");
                            this.zzV = by;
                            this.zzS = true;
                        }
                        if (((n3 = this.zzV) & 1) != 1) break block21;
                        n3 &= 2;
                        this.zzP |= 0x40000000;
                        if (!this.zzT) {
                            zzapn2.zzb(this.zzo.zza, 0, 8, false);
                            this.zzQ += 8;
                            this.zzT = true;
                            zzaux zzaux2 = this.zzj;
                            object = zzaux2.zza;
                            if (n3 != 2) {
                                n4 = 0;
                            }
                            object[0] = (byte)(n4 | 8);
                            zzaux2.zzi(0);
                            zzapx2.zzb(this.zzj, 1);
                            ++this.zzY;
                            this.zzo.zzi(0);
                            zzapx2.zzb(this.zzo, 8);
                            this.zzY += 8;
                        }
                        if (n3 != 2) break block21;
                        if (!this.zzU) {
                            zzapn2.zzb(this.zzj.zza, 0, 1, false);
                            ++this.zzQ;
                            this.zzj.zzi(0);
                            this.zzW = this.zzj.zzl();
                            this.zzU = true;
                        }
                        n4 = this.zzW * 4;
                        this.zzj.zza(n4);
                        zzapn2.zzb(this.zzj.zza, 0, n4, false);
                        this.zzQ += n4;
                        n4 = (this.zzW >> 1) + 1;
                        n5 = n4 * 6 + 2;
                        object = this.zzq;
                        if (object == null || object.capacity() < n5) {
                            this.zzq = ByteBuffer.allocate(n5);
                        }
                        this.zzq.position(0);
                        this.zzq.putShort((short)n4);
                        n3 = 0;
                        break block22;
                    }
                    object = zzaqe2.zzf;
                    if (object != null) {
                        this.zzm.zzb(object, ((byte[])object).length);
                    }
                    break block21;
                }
                for (n4 = 0; n4 < (n2 = this.zzW); ++n4) {
                    n2 = this.zzj.zzu();
                    if (n4 % 2 == 0) {
                        this.zzq.putShort((short)(n2 - n3));
                    } else {
                        this.zzq.putInt(n2 - n3);
                    }
                    n3 = n2;
                }
                n4 = n - this.zzQ - n3;
                if ((n2 & 1) == 1) {
                    this.zzq.putInt(n4);
                } else {
                    this.zzq.putShort((short)n4);
                    this.zzq.putInt(0);
                }
                this.zzp.zzb(this.zzq.array(), n5);
                zzapx2.zzb(this.zzp, n5);
                this.zzY += n5;
            }
            this.zzR = true;
        }
        n += this.zzm.zze();
        if (!"V_MPEG4/ISO/AVC".equals(zzaqe2.zza) && !"V_MPEGH/ISO/HEVC".equals(zzaqe2.zza)) {
            while ((n4 = this.zzQ) < n) {
                this.zzt(zzapn2, zzapx2, n - n4);
            }
        } else {
            object = this.zzi.zza;
            object[0] = 0;
            object[1] = 0;
            object[2] = 0;
            n4 = zzaqe2.zzO;
            n3 = 4 - n4;
            while (this.zzQ < n) {
                n2 = this.zzX;
                if (n2 == 0) {
                    n2 = Math.min(n4, this.zzm.zzd());
                    zzapn2.zzb(object, n3 + n2, n4 - n2, false);
                    if (n2 > 0) {
                        this.zzm.zzk(object, n3, n2);
                    }
                    this.zzQ += n4;
                    this.zzi.zzi(0);
                    this.zzX = this.zzi.zzu();
                    this.zzh.zzi(0);
                    zzapx2.zzb(this.zzh, 4);
                    this.zzY += 4;
                    continue;
                }
                this.zzX = n2 - this.zzt(zzapn2, zzapx2, n2);
            }
        }
        if (!"A_VORBIS".equals(zzaqe2.zza)) return;
        this.zzk.zzi(0);
        zzapx2.zzb(this.zzk, 4);
        this.zzY += 4;
    }

    private final int zzt(zzapn zzapn2, zzapx zzapx2, int n) throws IOException, InterruptedException {
        int n2 = this.zzm.zzd();
        if (n2 > 0) {
            n = Math.min(n, n2);
            zzapx2.zzb(this.zzm, n);
        } else {
            n = zzapx2.zzd(zzapn2, n, false);
        }
        this.zzQ += n;
        this.zzY += n;
        return n;
    }

    final void zzb(int n, long l, long l2) throws zzanp {
        if (n == 160) {
            this.zzaa = false;
            return;
        }
        if (n == 174) {
            this.zzw = new zzaqe(null);
            return;
        }
        if (n == 187) {
            this.zzG = false;
            return;
        }
        if (n == 19899) {
            this.zzy = -1;
            this.zzz = -1L;
            return;
        }
        if (n == 20533) {
            this.zzw.zze = true;
            return;
        }
        if (n == 21968) {
            this.zzw.zzq = true;
            return;
        }
        if (n != 408125543) {
            if (n == 475249515) {
                this.zzE = new zzaus(32);
                this.zzF = new zzaus(32);
                return;
            }
            if (n != 524531317) return;
            if (this.zzx) return;
            if (this.zzg && this.zzB != -1L) {
                this.zzA = true;
                return;
            }
            this.zzab.zzc((zzapv)new zzapu(this.zzv));
            this.zzx = true;
            return;
        }
        long l3 = this.zzs;
        if (l3 != -1L) {
            if (l3 != l) throw new zzanp("Multiple Segment elements not supported");
        }
        this.zzs = l;
        this.zzr = l2;
    }

    final void zzc(int n) throws zzanp {
        int n2 = 0;
        if (n != 160) {
            if (n != 174) {
                if (n != 19899) {
                    if (n == 25152) {
                        zzaqe zzaqe2 = this.zzw;
                        if (!zzaqe2.zze) return;
                        if (zzaqe2.zzg == null) throw new zzanp("Encrypted Track found but ContentEncKeyID was not found");
                        zzaqe2.zzi = new zzapk(new zzapj[]{new zzapj(zzamx.zzb, "video/webm", this.zzw.zzg.zzb, false)});
                        return;
                    }
                    if (n != 28032) {
                        long l;
                        if (n != 357149030) {
                            Object object;
                            if (n == 374648427) {
                                if (this.zzf.size() == 0) throw new zzanp("No valid tracks were found");
                                this.zzab.zzbg();
                                return;
                            }
                            if (n != 475249515) return;
                            if (this.zzx) return;
                            zzapp zzapp2 = this.zzab;
                            if (this.zzs != -1L && this.zzv != -9223372036854775807L && (object = this.zzE) != null && object.zzc() != 0 && (object = this.zzF) != null && object.zzc() == this.zzE.zzc()) {
                                int n3 = this.zzE.zzc();
                                int[] nArray = new int[n3];
                                object = new long[n3];
                                long[] lArray = new long[n3];
                                long[] lArray2 = new long[n3];
                                int n4 = 0;
                                while (true) {
                                    n = n2;
                                    if (n4 >= n3) break;
                                    lArray2[n4] = this.zzE.zzb(n4);
                                    object[n4] = (zzaus)(this.zzs + this.zzF.zzb(n4));
                                    ++n4;
                                }
                                while (n < (n4 = n3 - 1)) {
                                    n4 = n + 1;
                                    nArray[n] = (int)(object[n4] - object[n]);
                                    lArray[n] = lArray2[n4] - lArray2[n];
                                    n = n4;
                                }
                                nArray[n4] = (int)(this.zzs + this.zzr - object[n4]);
                                lArray[n4] = this.zzv - lArray2[n4];
                                this.zzE = null;
                                this.zzF = null;
                                object = new zzapm(nArray, (long[])object, lArray, lArray2);
                            } else {
                                this.zzE = null;
                                this.zzF = null;
                                object = new zzapu(this.zzv);
                            }
                            zzapp2.zzc((zzapv)object);
                            this.zzx = true;
                            return;
                        }
                        if (this.zzt == -9223372036854775807L) {
                            this.zzt = 1000000L;
                        }
                        if ((l = this.zzu) == -9223372036854775807L) return;
                        this.zzv = this.zzp(l);
                        return;
                    }
                    zzaqe zzaqe3 = this.zzw;
                    if (!zzaqe3.zze) return;
                    if (zzaqe3.zzf != null) throw new zzanp("Combining encryption and compression is not supported");
                } else {
                    n = this.zzy;
                    if (n == -1) throw new zzanp("Mandatory element SeekID or SeekPosition not found");
                    long l = this.zzz;
                    if (l == -1L) throw new zzanp("Mandatory element SeekID or SeekPosition not found");
                    if (n != 475249515) return;
                    this.zzB = l;
                }
                return;
            }
            SparseArray<zzaqe> sparseArray = this.zzw.zza;
            if ("V_VP8".equals(sparseArray) || "V_VP9".equals(sparseArray) || "V_MPEG2".equals(sparseArray) || "V_MPEG4/ISO/SP".equals(sparseArray) || "V_MPEG4/ISO/ASP".equals(sparseArray) || "V_MPEG4/ISO/AP".equals(sparseArray) || "V_MPEG4/ISO/AVC".equals(sparseArray) || "V_MPEGH/ISO/HEVC".equals(sparseArray) || "V_MS/VFW/FOURCC".equals(sparseArray) || "V_THEORA".equals(sparseArray) || "A_OPUS".equals(sparseArray) || "A_VORBIS".equals(sparseArray) || "A_AAC".equals(sparseArray) || "A_MPEG/L2".equals(sparseArray) || "A_MPEG/L3".equals(sparseArray) || "A_AC3".equals(sparseArray) || "A_EAC3".equals(sparseArray) || "A_TRUEHD".equals(sparseArray) || "A_DTS".equals(sparseArray) || "A_DTS/EXPRESS".equals(sparseArray) || "A_DTS/LOSSLESS".equals(sparseArray) || "A_FLAC".equals(sparseArray) || "A_MS/ACM".equals(sparseArray) || "A_PCM/INT/LIT".equals(sparseArray) || "S_TEXT/UTF8".equals(sparseArray) || "S_VOBSUB".equals(sparseArray) || "S_HDMV/PGS".equals(sparseArray) || "S_DVBSUB".equals(sparseArray)) {
                sparseArray = this.zzw;
                sparseArray.zzb(this.zzab, sparseArray.zzb);
                sparseArray = this.zzf;
                zzaqe zzaqe4 = this.zzw;
                sparseArray.put(zzaqe4.zzb, (Object)zzaqe4);
            }
            this.zzw = null;
            return;
        }
        if (this.zzH != 2) {
            return;
        }
        if (!this.zzaa) {
            this.zzP |= 1;
        }
        this.zzn((zzaqe)this.zzf.get(this.zzN), this.zzI);
        this.zzH = 0;
    }

    public final void zzd(zzapp zzapp2) {
        this.zzab = zzapp2;
    }

    public final void zze(long l, long l2) {
        this.zzD = -9223372036854775807L;
        this.zzH = 0;
        this.zzac.zza();
        this.zze.zza();
        this.zzo();
    }

    public final boolean zzf(zzapn zzapn2) throws IOException, InterruptedException {
        return new zzaqg().zza(zzapn2);
    }

    public final int zzg(zzapn zzapn2, zzapt zzapt2) throws IOException, InterruptedException {
        block1: {
            long l;
            this.zzZ = false;
            do {
                if (this.zzZ) return 0;
                if (!this.zzac.zzc(zzapn2)) return -1;
                l = zzapn2.zzh();
                if (!this.zzA) continue;
                this.zzC = l;
                zzapt2.zza = this.zzB;
                this.zzA = false;
                break block1;
            } while (!this.zzx || (l = this.zzC) == -1L);
            zzapt2.zza = l;
            this.zzC = -1L;
        }
        return 1;
    }

    final void zzh(int n, long l) throws zzanp {
        block49: {
            block47: {
                block48: {
                    if (n == 20529) break block47;
                    if (n == 20530) break block48;
                    boolean bl = false;
                    boolean bl2 = false;
                    switch (n) {
                        default: {
                            switch (n) {
                                default: {
                                    break block49;
                                }
                                case 21949: {
                                    this.zzw.zzv = (int)l;
                                    return;
                                }
                                case 21948: {
                                    this.zzw.zzu = (int)l;
                                    return;
                                }
                                case 21947: {
                                    zzaqe zzaqe2 = this.zzw;
                                    zzaqe2.zzq = true;
                                    n = (int)l;
                                    if (n == 1) {
                                        zzaqe2.zzr = 1;
                                        return;
                                    }
                                    if (n == 9) {
                                        zzaqe2.zzr = 6;
                                        return;
                                    }
                                    if (n != 4 && n != 5 && n != 6 && n != 7) return;
                                    zzaqe2.zzr = 2;
                                    return;
                                }
                                case 21946: {
                                    n = (int)l;
                                    if (n != 1) {
                                        if (n == 16) {
                                            this.zzw.zzs = 6;
                                            return;
                                        }
                                        if (n == 18) {
                                            this.zzw.zzs = 7;
                                            return;
                                        }
                                        if (n != 6 && n != 7) return;
                                    }
                                    this.zzw.zzs = 3;
                                    return;
                                }
                                case 21945: {
                                    n = (int)l;
                                    if (n == 1) {
                                        this.zzw.zzt = 2;
                                        return;
                                    }
                                    if (n != 2) return;
                                    this.zzw.zzt = 1;
                                    return;
                                }
                            }
                        }
                        case 2807729: {
                            this.zzt = l;
                            return;
                        }
                        case 2352003: {
                            this.zzw.zzd = (int)l;
                            return;
                        }
                        case 25188: {
                            this.zzw.zzH = (int)l;
                            return;
                        }
                        case 22203: {
                            this.zzw.zzK = l;
                            return;
                        }
                        case 22186: {
                            this.zzw.zzJ = l;
                            return;
                        }
                        case 21930: {
                            zzaqe zzaqe3 = this.zzw;
                            if (l == 1L) {
                                bl2 = true;
                            }
                            zzaqe3.zzM = bl2;
                            return;
                        }
                        case 21690: {
                            this.zzw.zzm = (int)l;
                            return;
                        }
                        case 21682: {
                            this.zzw.zzn = (int)l;
                            return;
                        }
                        case 21680: {
                            this.zzw.zzl = (int)l;
                            return;
                        }
                        case 21432: {
                            n = (int)l;
                            if (n == 0) {
                                this.zzw.zzp = 0;
                                return;
                            }
                            if (n == 1) {
                                this.zzw.zzp = 2;
                                return;
                            }
                            if (n == 3) {
                                this.zzw.zzp = 1;
                                return;
                            }
                            if (n != 15) return;
                            this.zzw.zzp = 3;
                            return;
                        }
                        case 21420: {
                            this.zzz = l + this.zzs;
                            return;
                        }
                        case 18408: {
                            if (l == 1L) return;
                            StringBuilder stringBuilder = new StringBuilder(56);
                            stringBuilder.append("AESSettingsCipherMode ");
                            stringBuilder.append(l);
                            stringBuilder.append(" not supported");
                            throw new zzanp(stringBuilder.toString());
                        }
                        case 18401: {
                            if (l == 5L) return;
                            StringBuilder stringBuilder = new StringBuilder(49);
                            stringBuilder.append("ContentEncAlgo ");
                            stringBuilder.append(l);
                            stringBuilder.append(" not supported");
                            throw new zzanp(stringBuilder.toString());
                        }
                        case 17143: {
                            if (l == 1L) return;
                            StringBuilder stringBuilder = new StringBuilder(50);
                            stringBuilder.append("EBMLReadVersion ");
                            stringBuilder.append(l);
                            stringBuilder.append(" not supported");
                            throw new zzanp(stringBuilder.toString());
                        }
                        case 17029: {
                            if (l >= 1L && l <= 2L) return;
                            StringBuilder stringBuilder = new StringBuilder(53);
                            stringBuilder.append("DocTypeReadVersion ");
                            stringBuilder.append(l);
                            stringBuilder.append(" not supported");
                            throw new zzanp(stringBuilder.toString());
                        }
                        case 16980: {
                            if (l == 3L) return;
                            StringBuilder stringBuilder = new StringBuilder(50);
                            stringBuilder.append("ContentCompAlgo ");
                            stringBuilder.append(l);
                            stringBuilder.append(" not supported");
                            throw new zzanp(stringBuilder.toString());
                        }
                        case 251: {
                            this.zzaa = true;
                            return;
                        }
                        case 241: {
                            if (this.zzG) return;
                            this.zzF.zza(l);
                            this.zzG = true;
                            return;
                        }
                        case 231: {
                            this.zzD = this.zzp(l);
                            return;
                        }
                        case 215: {
                            this.zzw.zzb = (int)l;
                            return;
                        }
                        case 186: {
                            this.zzw.zzk = (int)l;
                            return;
                        }
                        case 179: {
                            this.zzE.zza(this.zzp(l));
                            return;
                        }
                        case 176: {
                            this.zzw.zzj = (int)l;
                            return;
                        }
                        case 159: {
                            this.zzw.zzG = (int)l;
                            return;
                        }
                        case 155: {
                            this.zzJ = this.zzp(l);
                            return;
                        }
                        case 136: {
                            zzaqe zzaqe4 = this.zzw;
                            bl2 = bl;
                            if (l == 1L) {
                                bl2 = true;
                            }
                            zzaqe4.zzL = bl2;
                            return;
                        }
                        case 131: {
                            this.zzw.zzc = (int)l;
                            return;
                        }
                    }
                }
                if (l == 1L) return;
                StringBuilder stringBuilder = new StringBuilder(55);
                stringBuilder.append("ContentEncodingScope ");
                stringBuilder.append(l);
                stringBuilder.append(" not supported");
                throw new zzanp(stringBuilder.toString());
            }
            if (l == 0L) return;
            StringBuilder stringBuilder = new StringBuilder(55);
            stringBuilder.append("ContentEncodingOrder ");
            stringBuilder.append(l);
            stringBuilder.append(" not supported");
            throw new zzanp(stringBuilder.toString());
        }
    }

    final void zzi(int n, double d) {
        if (n == 181) {
            this.zzw.zzI = (int)d;
            return;
        }
        if (n == 17545) {
            this.zzu = (long)d;
            return;
        }
        switch (n) {
            default: {
                return;
            }
            case 21978: {
                this.zzw.zzF = (float)d;
                return;
            }
            case 21977: {
                this.zzw.zzE = (float)d;
                return;
            }
            case 21976: {
                this.zzw.zzD = (float)d;
                return;
            }
            case 21975: {
                this.zzw.zzC = (float)d;
                return;
            }
            case 21974: {
                this.zzw.zzB = (float)d;
                return;
            }
            case 21973: {
                this.zzw.zzA = (float)d;
                return;
            }
            case 21972: {
                this.zzw.zzz = (float)d;
                return;
            }
            case 21971: {
                this.zzw.zzy = (float)d;
                return;
            }
            case 21970: {
                this.zzw.zzx = (float)d;
                return;
            }
            case 21969: 
        }
        this.zzw.zzw = (float)d;
    }

    final void zzj(int n, String string) throws zzanp {
        if (n == 134) {
            this.zzw.zza = string;
            return;
        }
        if (n != 17026) {
            if (n != 2274716) return;
            zzaqe.zza((zzaqe)this.zzw, (String)string);
            return;
        }
        if ("webm".equals(string)) return;
        if ("matroska".equals(string)) return;
        StringBuilder stringBuilder = new StringBuilder(string.length() + 22);
        stringBuilder.append("DocType ");
        stringBuilder.append(string);
        stringBuilder.append(" not supported");
        throw new zzanp(stringBuilder.toString());
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    final void zzk(int var1_1, int var2_2, zzapn var3_3) throws IOException, InterruptedException {
        block19: {
            block22: {
                block21: {
                    block20: {
                        var4_4 = 4;
                        if (var1_1 != 161 && var1_1 != 163) {
                            if (var1_1 == 16981) {
                                var15_8 = this.zzw;
                                var15_8.zzf = new byte[var2_2];
                                var3_3.zzb(var15_8.zzf, 0, var2_2, false);
                                return;
                            }
                            if (var1_1 == 18402) {
                                var15_7 = new byte[var2_2];
                                var3_3.zzb(var15_7, 0, var2_2, false);
                                this.zzw.zzg = new zzapw(1, var15_7);
                                return;
                            }
                            if (var1_1 == 21419) {
                                Arrays.fill(this.zzl.zza, (byte)0);
                                var3_3.zzb(this.zzl.zza, 4 - var2_2, var2_2, false);
                                this.zzl.zzi(0);
                                this.zzy = (int)this.zzl.zzp();
                                return;
                            }
                            if (var1_1 == 25506) {
                                var15_6 = this.zzw;
                                var15_6.zzh = new byte[var2_2];
                                var3_3.zzb(var15_6.zzh, 0, var2_2, false);
                                return;
                            }
                            if (var1_1 == 30322) {
                                var15_5 = this.zzw;
                                var15_5.zzo = new byte[var2_2];
                                var3_3.zzb(var15_5.zzo, 0, var2_2, false);
                                return;
                            }
                            var3_3 = new StringBuilder(26);
                            var3_3.append("Unexpected id: ");
                            var3_3.append(var1_1);
                            throw new zzanp(var3_3.toString());
                        }
                        if (this.zzH == 0) {
                            this.zzN = (int)this.zze.zze((zzapn)var3_3, false, true, 8);
                            this.zzO = this.zze.zzb();
                            this.zzJ = -9223372036854775807L;
                            this.zzH = 1;
                            this.zzj.zzc();
                        }
                        if ((var15_9 = (zzaqe)this.zzf.get(this.zzN)) == null) {
                            var3_3.zzd(var2_2 - this.zzO, false);
                            this.zzH = 0;
                            return;
                        }
                        var5_10 = var1_1;
                        if (this.zzH != 1) break block19;
                        this.zzr((zzapn)var3_3, 3);
                        var5_10 = (this.zzj.zza[2] & 6) >> 1;
                        if (var5_10 != 0) break block20;
                        this.zzL = 1;
                        var16_11 /* !! */  = zzaqf.zzq(this.zzM, 1);
                        this.zzM = var16_11 /* !! */ ;
                        var16_11 /* !! */ [0] = var2_2 - this.zzO - 3;
                        ** GOTO lbl102
                    }
                    if (var1_1 != 163) throw new zzanp("Lacing only supported in SimpleBlocks.");
                    this.zzr((zzapn)var3_3, 4);
                    this.zzL = var6_12 = (this.zzj.zza[3] & 255) + 1;
                    var16_11 /* !! */  = zzaqf.zzq(this.zzM, var6_12);
                    this.zzM = var16_11 /* !! */ ;
                    if (var5_10 != 2) break block21;
                    var5_10 = this.zzO;
                    var4_4 = this.zzL;
                    Arrays.fill(var16_11 /* !! */ , 0, var4_4, (var2_2 - var5_10 - 4) / var4_4);
                    ** GOTO lbl102
                }
                if (var5_10 != 1) break block22;
                var6_12 = 0;
                for (var5_10 = 0; var5_10 < (var7_13 = this.zzL - 1); var6_12 += var8_14, ++var5_10) {
                    this.zzM[var5_10] = 0;
                    var7_13 = var4_4;
                    do {
                        var4_4 = var7_13 + 1;
                        this.zzr((zzapn)var3_3, var4_4);
                        var9_15 = this.zzj.zza[var4_4 - 1] & 255;
                        var16_11 /* !! */  = this.zzM;
                        var16_11 /* !! */ [var5_10] = var8_14 = var16_11 /* !! */ [var5_10] + var9_15;
                        var7_13 = var4_4;
                    } while (var9_15 == 255);
                }
                this.zzM[var7_13] = var2_2 - this.zzO - var4_4 - var6_12;
                ** GOTO lbl102
            }
            if (var5_10 != 3) throw new zzanp("Unexpected lacing value: 2");
            var6_12 = 0;
            var5_10 = 0;
            while (true) {
                block18: {
                    block24: {
                        block28: {
                            block25: {
                                block26: {
                                    block27: {
                                        block23: {
                                            if (var6_12 >= (var7_13 = this.zzL - 1)) break block23;
                                            this.zzM[var6_12] = 0;
                                            this.zzr((zzapn)var3_3, ++var4_4);
                                            var9_15 = var4_4 - 1;
                                            if (this.zzj.zza[var9_15] == 0) throw new zzanp("No valid varint length mask found");
                                            break block24;
                                        }
                                        this.zzM[var7_13] = var2_2 - this.zzO - var4_4 - var5_10;
lbl102:
                                        // 4 sources

                                        var16_11 /* !! */  = this.zzj.zza;
                                        var2_2 = var16_11 /* !! */ [0];
                                        var4_4 = var16_11 /* !! */ [1];
                                        this.zzI = this.zzD + this.zzp(var4_4 & 255 | var2_2 << 8);
                                        var5_10 = this.zzj.zza[2];
                                        var2_2 = var1_1;
                                        if (var15_9.zzc == 2) break block25;
                                        var2_2 = var1_1;
                                        if (var1_1 != 163) break block26;
                                        if ((var5_10 & 128) != 128) break block27;
                                        var2_2 = 163;
                                        break block25;
                                    }
                                    var2_2 = 163;
                                }
                                var4_4 = 0;
                                var1_1 = var2_2;
                                break block28;
                            }
                            var4_4 = 1;
                            var1_1 = var2_2;
                        }
                        var2_2 = (var5_10 & 8) == 8 ? -2147483648 : 0;
                        this.zzP = var4_4 | var2_2;
                        this.zzH = 2;
                        this.zzK = 0;
                        var5_10 = var1_1;
                        break;
                    }
                    for (var7_13 = 0; var7_13 < 8; ++var7_13) {
                        var10_16 = 1 << 7 - var7_13;
                        if ((this.zzj.zza[var9_15] & var10_16) == 0) continue;
                        var8_14 = var4_4 + var7_13;
                        this.zzr((zzapn)var3_3, var8_14);
                        var13_18 = this.zzj.zza[var9_15] & 255 & ~var10_16;
                        for (var4_4 = var9_15 + 1; var4_4 < var8_14; ++var4_4) {
                            var13_18 = var13_18 << 8 | (long)(this.zzj.zza[var4_4] & 255);
                        }
                        var4_4 = var8_14;
                        var11_17 = var13_18;
                        if (var6_12 > 0) {
                            var11_17 = var13_18 - ((1L << var7_13 * 7 + 6) - 1L);
                            var4_4 = var8_14;
                        }
                        break block18;
                    }
                    var11_17 = 0L;
                }
                if (var11_17 < -2147483648L) throw new zzanp("EBML lacing sample size out of range.");
                if (var11_17 > 0x7FFFFFFFL) throw new zzanp("EBML lacing sample size out of range.");
                var8_14 = (int)var11_17;
                var16_11 /* !! */  = this.zzM;
                var7_13 = var8_14;
                if (var6_12 != 0) {
                    var7_13 = var8_14 + var16_11 /* !! */ [var6_12 - 1];
                }
                var16_11 /* !! */ [var6_12] = var7_13;
                var5_10 += var7_13;
                ++var6_12;
            }
        }
        if (var5_10 != 163) {
            this.zzs((zzapn)var3_3, var15_9, this.zzM[0]);
            return;
        }
        while (true) {
            if ((var1_1 = ++this.zzK) >= this.zzL) {
                this.zzH = 0;
                return;
            }
            this.zzs((zzapn)var3_3, var15_9, this.zzM[var1_1]);
            this.zzn(var15_9, this.zzI + (long)(this.zzK * var15_9.zzd / 1000));
        }
    }
}
