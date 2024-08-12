/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzalt
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzj
 *  com.google.android.gms.internal.ads.zzmx
 *  com.google.android.gms.internal.ads.zzn
 *  com.google.android.gms.internal.ads.zzne
 *  com.google.android.gms.internal.ads.zznr
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzok
 *  com.google.android.gms.internal.ads.zzow
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zzqf
 *  com.google.android.gms.internal.ads.zzqh
 *  com.google.android.gms.internal.ads.zzqi
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzalt;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzj;
import com.google.android.gms.internal.ads.zzmx;
import com.google.android.gms.internal.ads.zzn;
import com.google.android.gms.internal.ads.zzne;
import com.google.android.gms.internal.ads.zznr;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzok;
import com.google.android.gms.internal.ads.zzow;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzqf;
import com.google.android.gms.internal.ads.zzqh;
import com.google.android.gms.internal.ads.zzqi;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class zzqg {
    public int zzA = 1000;
    public int zzB = 200;
    public float zzC = -1.0f;
    public float zzD = -1.0f;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public float zzG = -1.0f;
    public float zzH = -1.0f;
    public float zzI = -1.0f;
    public float zzJ = -1.0f;
    public float zzK = -1.0f;
    public float zzL = -1.0f;
    public byte[] zzM;
    public int zzN = 1;
    public int zzO = -1;
    public int zzP = 8000;
    public long zzQ = 0L;
    public long zzR = 0L;
    public zzqh zzS;
    public boolean zzT;
    public boolean zzU = true;
    public zzox zzV;
    public int zzW;
    private int zzX;
    private String zzY = "eng";
    public String zza;
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public boolean zzg;
    public byte[] zzh;
    public zzow zzi;
    public byte[] zzj;
    public zzn zzk;
    public int zzl = -1;
    public int zzm = -1;
    public int zzn = -1;
    public int zzo = -1;
    public int zzp = 0;
    public int zzq = -1;
    public float zzr = 0.0f;
    public float zzs = 0.0f;
    public float zzt = 0.0f;
    public byte[] zzu = null;
    public int zzv = -1;
    public boolean zzw = false;
    public int zzx = -1;
    public int zzy = -1;
    public int zzz = -1;

    private zzqg() {
    }

    /* synthetic */ zzqg(zzqf zzqf2) {
    }

    static /* synthetic */ int zza(zzqg zzqg2, int n) {
        zzqg2.zzX = n;
        return n;
    }

    static /* synthetic */ int zzb(zzqg zzqg2) {
        return zzqg2.zzX;
    }

    static /* synthetic */ String zzc(zzqg zzqg2, String string) {
        zzqg2.zzY = string;
        return string;
    }

    static /* synthetic */ void zze(zzqg zzqg2) {
        if (zzqg2.zzV == null) throw null;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private static Pair<String, List<byte[]>> zzf(zzamf var0) throws zzaha {
        try {
            var0 /* !! */ .zzk(16);
            var3_3 = var0 /* !! */ .zzu();
            if (var3_3 == 1482049860L) {
                return new Pair((Object)"video/divx", null);
            }
            if (var3_3 == 859189832L) {
                return new Pair((Object)"video/3gpp", null);
            }
            if (var3_3 == 826496599L) {
                var1_4 = var0 /* !! */ .zzg() + 20;
                var0 /* !! */  = (zzamf)var0 /* !! */ .zzi();
            } else {
                Log.w((String)"MatroskaExtractor", (String)"Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair((Object)"video/x-unknown", null);
            }
            ** while (var1_4 < (var2_5 = ((zzamf)var0 /* !! */ ).length) - 4)
        }
        catch (ArrayIndexOutOfBoundsException var0_1) {
            var0_2 = zzaha.zzb((String)"Error parsing FourCC private data", null);
            throw var0_2;
        }
lbl-1000:
        // 1 sources

        {
            if (var0 /* !! */ [var1_4] == false && var0 /* !! */ [var1_4 + 1] == false && var0 /* !! */ [var1_4 + 2] == true && var0 /* !! */ [var1_4 + 3] == 15) {
                return new Pair((Object)"video/wvc1", Collections.singletonList(Arrays.copyOfRange((byte[])var0 /* !! */ , var1_4, var2_5)));
            }
            ++var1_4;
            continue;
        }
lbl25:
        // 2 sources

        throw zzaha.zzb((String)"Failed to find FourCC VC1 initialization data", null);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    private static List<byte[]> zzg(byte[] object) throws zzaha {
        byte[] byArray;
        int n;
        int n2;
        if (object[0] != 2) throw zzaha.zzb((String)"Error parsing vorbis codec private", null);
        int n3 = 1;
        int n4 = 0;
        while ((n2 = object[n3] & 0xFF) == 255) {
            n4 += 255;
            ++n3;
        }
        ++n3;
        n2 = n4 + n2;
        n4 = 0;
        while ((n = object[n3] & 0xFF) == 255) {
            n4 += 255;
            ++n3;
        }
        if (object[++n3] != 1) throw zzaha.zzb((String)"Error parsing vorbis codec private", null);
        try {
            byArray = new byte[n2];
            System.arraycopy(object, n3, byArray, 0, n2);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            zzaha zzaha2 = zzaha.zzb((String)"Error parsing vorbis codec private", null);
            throw zzaha2;
        }
        if (object[n3 += n2] != 3) throw zzaha.zzb((String)"Error parsing vorbis codec private", null);
        if (object[n4 = n3 + (n4 + n)] != 5) throw zzaha.zzb((String)"Error parsing vorbis codec private", null);
        {
            n3 = ((byte[])object).length - n4;
            byte[] byArray2 = new byte[n3];
            System.arraycopy(object, n4, byArray2, 0, n3);
            object = new ArrayList;
            ((ArrayList)object)(2);
            object.add(byArray);
            object.add(byArray2);
            return object;
        }
    }

    private static boolean zzh(zzamf zzamf2) throws zzaha {
        try {
            long l;
            int n = zzamf2.zzp();
            if (n == 1) {
                return true;
            }
            if (n != 65534) return false;
            zzamf2.zzh(24);
            if (zzamf2.zzx() != zzqi.zzf().getMostSignificantBits()) return false;
            long l2 = zzamf2.zzx();
            if (l2 != (l = zzqi.zzf().getLeastSignificantBits())) return false;
            return true;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw zzaha.zzb((String)"Error parsing MS/ACM codec private", null);
        }
    }

    @EnsuresNonNull(value={"codecPrivate"})
    private final byte[] zzi(String string) throws zzaha {
        byte[] byArray = this.zzj;
        if (byArray != null) return byArray;
        string = (string = String.valueOf(string)).length() != 0 ? "Missing CodecPrivate for codec ".concat(string) : new String("Missing CodecPrivate for codec ");
        throw zzaha.zzb((String)string, null);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @EnsuresNonNull(value={"this.output"})
    @RequiresNonNull(value={"codecId"})
    public final void zzd(zznx var1_1, int var2_2) throws zzaha {
        block101: {
            block102: {
                block99: {
                    block100: {
                        block98: {
                            var11_3 = this.zzb;
                            var4_4 = var11_3.hashCode();
                            var9_5 = 1;
                            var5_6 = 4;
                            var8_7 = 0;
                            switch (var4_4) {
                                default: {
                                    break;
                                }
                                case 1951062397: {
                                    if (!var11_3.equals("A_OPUS")) break;
                                    var4_4 = 12;
                                    break block98;
                                }
                                case 1950789798: {
                                    if (!var11_3.equals("A_FLAC")) break;
                                    var4_4 = 22;
                                    break block98;
                                }
                                case 1950749482: {
                                    if (!var11_3.equals("A_EAC3")) break;
                                    var4_4 = 17;
                                    break block98;
                                }
                                case 1809237540: {
                                    if (!var11_3.equals("V_MPEG2")) break;
                                    var4_4 = 3;
                                    break block98;
                                }
                                case 1422270023: {
                                    if (!var11_3.equals("S_TEXT/UTF8")) break;
                                    var4_4 = 27;
                                    break block98;
                                }
                                case 855502857: {
                                    if (!var11_3.equals("V_MPEGH/ISO/HEVC")) break;
                                    var4_4 = 8;
                                    break block98;
                                }
                                case 738597099: {
                                    if (!var11_3.equals("S_TEXT/ASS")) break;
                                    var4_4 = 28;
                                    break block98;
                                }
                                case 725957860: {
                                    if (!var11_3.equals("A_PCM/INT/LIT")) break;
                                    var4_4 = 24;
                                    break block98;
                                }
                                case 725948237: {
                                    if (!var11_3.equals("A_PCM/INT/BIG")) break;
                                    var4_4 = 25;
                                    break block98;
                                }
                                case 635596514: {
                                    if (!var11_3.equals("A_PCM/FLOAT/IEEE")) break;
                                    var4_4 = 26;
                                    break block98;
                                }
                                case 542569478: {
                                    if (!var11_3.equals("A_DTS/EXPRESS")) break;
                                    var4_4 = 20;
                                    break block98;
                                }
                                case 444813526: {
                                    if (!var11_3.equals("V_THEORA")) break;
                                    var4_4 = 10;
                                    break block98;
                                }
                                case 99146302: {
                                    if (!var11_3.equals("S_HDMV/PGS")) break;
                                    var4_4 = 30;
                                    break block98;
                                }
                                case 82338134: {
                                    if (!var11_3.equals("V_VP9")) break;
                                    var4_4 = 1;
                                    break block98;
                                }
                                case 82338133: {
                                    if (!var11_3.equals("V_VP8")) break;
                                    var4_4 = 0;
                                    break block98;
                                }
                                case 82318131: {
                                    if (!var11_3.equals("V_AV1")) break;
                                    var4_4 = 2;
                                    break block98;
                                }
                                case 62927045: {
                                    if (!var11_3.equals("A_DTS")) break;
                                    var4_4 = 19;
                                    break block98;
                                }
                                case 62923603: {
                                    if (!var11_3.equals("A_AC3")) break;
                                    var4_4 = 16;
                                    break block98;
                                }
                                case 62923557: {
                                    if (!var11_3.equals("A_AAC")) break;
                                    var4_4 = 13;
                                    break block98;
                                }
                                case -356037306: {
                                    if (!var11_3.equals("A_DTS/LOSSLESS")) break;
                                    var4_4 = 21;
                                    break block98;
                                }
                                case -425012669: {
                                    if (!var11_3.equals("S_VOBSUB")) break;
                                    var4_4 = 29;
                                    break block98;
                                }
                                case -538363109: {
                                    if (!var11_3.equals("V_MPEG4/ISO/AVC")) break;
                                    var4_4 = 7;
                                    break block98;
                                }
                                case -538363189: {
                                    if (!var11_3.equals("V_MPEG4/ISO/ASP")) break;
                                    var4_4 = 5;
                                    break block98;
                                }
                                case -933872740: {
                                    if (!var11_3.equals("S_DVBSUB")) break;
                                    var4_4 = 31;
                                    break block98;
                                }
                                case -1373388978: {
                                    if (!var11_3.equals("V_MS/VFW/FOURCC")) break;
                                    var4_4 = 9;
                                    break block98;
                                }
                                case -1482641357: {
                                    if (!var11_3.equals("A_MPEG/L3")) break;
                                    var4_4 = 15;
                                    break block98;
                                }
                                case -1482641358: {
                                    if (!var11_3.equals("A_MPEG/L2")) break;
                                    var4_4 = 14;
                                    break block98;
                                }
                                case -1730367663: {
                                    if (!var11_3.equals("A_VORBIS")) break;
                                    var4_4 = 11;
                                    break block98;
                                }
                                case -1784763192: {
                                    if (!var11_3.equals("A_TRUEHD")) break;
                                    var4_4 = 18;
                                    break block98;
                                }
                                case -1985379776: {
                                    if (!var11_3.equals("A_MS/ACM")) break;
                                    var4_4 = 23;
                                    break block98;
                                }
                                case -2095575984: {
                                    if (!var11_3.equals("V_MPEG4/ISO/SP")) break;
                                    var4_4 = 4;
                                    break block98;
                                }
                                case -2095576542: {
                                    if (!var11_3.equals("V_MPEG4/ISO/AP")) break;
                                    var4_4 = 6;
                                    break block98;
                                }
                            }
                            var4_4 = -1;
                        }
                        var13_8 = "audio/raw";
                        var17_9 = null;
                        var16_10 = null;
                        switch (var4_4) {
                            default: {
                                throw zzaha.zzb((String)"Unrecognized codec identifier.", null);
                            }
                            case 31: {
                                var12_11 /* !! */  = new byte[4];
                                System.arraycopy(this.zzi((String)var11_3), 0, var12_11 /* !! */ , 0, 4);
                                var11_3 = zzfoj.zzj((Object)var12_11 /* !! */ );
                                var13_8 = "application/dvbsubs";
                                ** GOTO lbl328
                            }
                            case 30: {
                                var11_3 = null;
                                var12_11 /* !! */  = null;
                                var13_8 = "application/pgs";
                                break block99;
                            }
                            case 29: {
                                var11_3 = zzfoj.zzj((Object)this.zzi((String)var11_3));
                                var12_11 /* !! */  = null;
                                var13_8 = "application/vobsub";
                                break block99;
                            }
                            case 28: {
                                var11_3 = zzfoj.zzk((Object)zzqi.zze(), (Object)this.zzi(this.zzb));
                                var12_11 /* !! */  = null;
                                var13_8 = "text/x-ssa";
                                break block99;
                            }
                            case 27: {
                                var11_3 = "application/x-subrip";
                                break block100;
                            }
                            case 26: {
                                var4_4 = this.zzO;
                                if (var4_4 != 32) ** GOTO lbl174
                                var4_4 = var5_6;
                                ** GOTO lbl234
lbl174:
                                // 1 sources

                                var11_3 = new StringBuilder(90);
                                var11_3.append("Unsupported floating point PCM bit depth: ");
                                var11_3.append(var4_4);
                                var11_3.append(". Setting mimeType to audio/x-unknown");
                                Log.w((String)"MatroskaExtractor", (String)var11_3.toString());
                                ** GOTO lbl241
                            }
                            case 25: {
                                var4_4 = this.zzO;
                                if (var4_4 != 8) ** GOTO lbl192
                                var11_3 = null;
                                var12_11 /* !! */  = null;
                                var5_6 = -1;
                                var6_12 = 3;
                                break block101;
lbl192:
                                // 1 sources

                                if (var4_4 != 16) ** GOTO lbl195
                                var4_4 = 0x10000000;
                                ** GOTO lbl234
lbl195:
                                // 1 sources

                                var11_3 = new StringBuilder(86);
                                var11_3.append("Unsupported big endian PCM bit depth: ");
                                var11_3.append(var4_4);
                                var11_3.append(". Setting mimeType to audio/x-unknown");
                                Log.w((String)"MatroskaExtractor", (String)var11_3.toString());
                                ** GOTO lbl241
                            }
                            case 24: {
                                var4_4 = var5_6 = zzamq.zzO((int)this.zzO);
                                if (var5_6 != 0) ** GOTO lbl234
                                var4_4 = this.zzO;
                                var11_3 = new StringBuilder(89);
                                var11_3.append("Unsupported little endian PCM bit depth: ");
                                var11_3.append(var4_4);
                                var11_3.append(". Setting mimeType to audio/x-unknown");
                                Log.w((String)"MatroskaExtractor", (String)var11_3.toString());
                                ** GOTO lbl241
                            }
                            case 23: {
                                if (!zzqg.zzh(new zzamf(this.zzi((String)var11_3)))) ** GOTO lbl239
                                var4_4 = var5_6 = zzamq.zzO((int)this.zzO);
                                if (var5_6 != 0) ** GOTO lbl234
                                var4_4 = this.zzO;
                                var11_3 = new StringBuilder(75);
                                var11_3.append("Unsupported PCM bit depth: ");
                                var11_3.append(var4_4);
                                var11_3.append(". Setting mimeType to audio/x-unknown");
                                Log.w((String)"MatroskaExtractor", (String)var11_3.toString());
                                ** GOTO lbl241
lbl234:
                                // 4 sources

                                var11_3 = null;
                                var12_11 /* !! */  = null;
                                var5_6 = -1;
                                var6_12 = var4_4;
                                break block101;
lbl239:
                                // 1 sources

                                Log.w((String)"MatroskaExtractor", (String)"Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
lbl241:
                                // 5 sources

                                var11_3 = null;
                                var12_11 /* !! */  = null;
                                var13_8 = "audio/x-unknown";
                                break block99;
                            }
                            case 22: {
                                var11_3 = Collections.singletonList(this.zzi((String)var11_3));
                                var13_8 = "audio/flac";
                                ** GOTO lbl328
                            }
                            case 21: {
                                var11_3 = "audio/vnd.dts.hd";
                                break block100;
                            }
                            case 19: 
                            case 20: {
                                var11_3 = "audio/vnd.dts";
                                break block100;
                            }
                            case 18: {
                                this.zzS = new zzqh();
                                var11_3 = "audio/true-hd";
                                break block100;
                            }
                            case 17: {
                                var11_3 = "audio/eac3";
                                break block100;
                            }
                            case 16: {
                                var11_3 = "audio/ac3";
                                break block100;
                            }
                            case 15: {
                                var13_8 = "audio/mpeg";
                                ** GOTO lbl270
                            }
                            case 14: {
                                var13_8 = "audio/mpeg-L2";
lbl270:
                                // 2 sources

                                var11_3 = null;
                                var12_11 /* !! */  = null;
                                var4_4 = 4096;
                                break block102;
                            }
                            case 13: {
                                var11_3 = Collections.singletonList(this.zzi((String)var11_3));
                                var12_11 /* !! */  = (byte[])zzmx.zza((byte[])this.zzj);
                                this.zzP = var12_11 /* !! */ .zza;
                                this.zzN = var12_11 /* !! */ .zzb;
                                var12_11 /* !! */  = (byte[])var12_11 /* !! */ .zzc;
                                var13_8 = "audio/mp4a-latm";
                                break block99;
                            }
                            case 12: {
                                var11_3 = new ArrayList<byte[]>(3);
                                var11_3.add(this.zzi(this.zzb));
                                var11_3.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzQ).array());
                                var11_3.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzR).array());
                                var13_8 = "audio/opus";
                                var12_11 /* !! */  = null;
                                var4_4 = 5760;
                                break block102;
                            }
                            case 11: {
                                var11_3 = zzqg.zzg(this.zzi((String)var11_3));
                                var13_8 = "audio/vorbis";
                                var12_11 /* !! */  = null;
                                var4_4 = 8192;
                                break block102;
                            }
                            case 10: {
                                var11_3 = "video/x-unknown";
                                break block100;
                            }
                            case 9: {
                                var11_3 = zzqg.zzf(new zzamf(this.zzi((String)var11_3)));
                                var13_8 = (String)var11_3.first;
                                var11_3 = (List)var11_3.second;
                                ** GOTO lbl328
                            }
                            case 8: {
                                var12_11 /* !! */  = (byte[])zzok.zza((zzamf)new zzamf(this.zzi((String)var11_3)));
                                var11_3 = var12_11 /* !! */ .zza;
                                this.zzW = var12_11 /* !! */ .zzb;
                                var12_11 /* !! */  = (byte[])var12_11 /* !! */ .zzc;
                                var13_8 = "video/hevc";
                                ** GOTO lbl321
                            }
                            case 7: {
                                var12_11 /* !! */  = (byte[])zzne.zza((zzamf)new zzamf(this.zzi((String)var11_3)));
                                var11_3 = var12_11 /* !! */ .zza;
                                this.zzW = var12_11 /* !! */ .zzb;
                                var12_11 /* !! */  = (byte[])var12_11 /* !! */ .zzf;
                                var13_8 = "video/avc";
lbl321:
                                // 2 sources

                                var5_6 = -1;
                                var6_12 = -1;
                                break block101;
                            }
                            case 4: 
                            case 5: 
                            case 6: {
                                var11_3 = this.zzj;
                                var11_3 = var11_3 == null ? null : Collections.singletonList(var11_3);
                                var13_8 = "video/mp4v-es";
lbl328:
                                // 4 sources

                                var12_11 /* !! */  = null;
                                break block99;
                            }
                            case 3: {
                                var11_3 = "video/mpeg2";
                                break block100;
                            }
                            case 2: {
                                var11_3 = "video/av01";
                                break block100;
                            }
                            case 1: {
                                var11_3 = "video/x-vnd.on2.vp9";
                                break block100;
                            }
                            case 0: 
                        }
                        var11_3 = "video/x-vnd.on2.vp8";
                    }
                    var14_13 = null;
                    var12_11 /* !! */  = null;
                    var13_8 = var11_3;
                    var11_3 = var14_13;
                }
                var4_4 = -1;
            }
            var6_12 = -1;
            var5_6 = var4_4;
        }
        var18_14 /* !! */  = this.zzM;
        var15_15 /* !! */  = var12_11 /* !! */ ;
        var14_13 = var13_8;
        if (var18_14 /* !! */  != null) {
            var18_14 /* !! */  = (byte[])zznr.zza((zzamf)new zzamf(var18_14 /* !! */ ));
            var15_15 /* !! */  = var12_11 /* !! */ ;
            var14_13 = var13_8;
            if (var18_14 /* !! */  != null) {
                var15_15 /* !! */  = (byte[])var18_14 /* !! */ .zza;
                var14_13 = "video/dolby-vision";
            }
        }
        var10_16 = this.zzU;
        var7_17 = true != this.zzT ? 0 : 2;
        var13_8 = new zzaft();
        if (zzalt.zza((String)var14_13)) {
            var13_8.zzaa(this.zzN);
            var13_8.zzab(this.zzP);
            var13_8.zzac(var6_12);
            var4_4 = var9_5;
        } else if (zzalt.zzb((String)var14_13)) {
            if (this.zzp == 0) {
                var4_4 = var6_12 = this.zzn;
                if (var6_12 == -1) {
                    var4_4 = this.zzl;
                }
                this.zzn = var4_4;
                var4_4 = var6_12 = this.zzo;
                if (var6_12 == -1) {
                    var4_4 = this.zzm;
                }
                this.zzo = var4_4;
            }
            var6_12 = -1;
            var4_4 = this.zzn;
            var3_18 = var4_4 != -1 && (var9_5 = this.zzo) != -1 ? (float)(this.zzm * var4_4) / (float)(this.zzl * var9_5) : -1.0f;
            var12_11 /* !! */  = var17_9;
            if (this.zzw) {
                var12_11 /* !! */  = var16_10;
                if (this.zzC != -1.0f) {
                    var12_11 /* !! */  = var16_10;
                    if (this.zzD != -1.0f) {
                        var12_11 /* !! */  = var16_10;
                        if (this.zzE != -1.0f) {
                            var12_11 /* !! */  = var16_10;
                            if (this.zzF != -1.0f) {
                                var12_11 /* !! */  = var16_10;
                                if (this.zzG != -1.0f) {
                                    var12_11 /* !! */  = var16_10;
                                    if (this.zzH != -1.0f) {
                                        var12_11 /* !! */  = var16_10;
                                        if (this.zzI != -1.0f) {
                                            var12_11 /* !! */  = var16_10;
                                            if (this.zzJ != -1.0f) {
                                                var12_11 /* !! */  = var16_10;
                                                if (this.zzK != -1.0f) {
                                                    if (this.zzL == -1.0f) {
                                                        var12_11 /* !! */  = var16_10;
                                                    } else {
                                                        var12_11 /* !! */  = new byte[25];
                                                        var16_10 = ByteBuffer.wrap(var12_11 /* !! */ ).order(ByteOrder.LITTLE_ENDIAN);
                                                        var16_10.put((byte)0);
                                                        var16_10.putShort((short)(this.zzC * 50000.0f + 0.5f));
                                                        var16_10.putShort((short)(this.zzD * 50000.0f + 0.5f));
                                                        var16_10.putShort((short)(this.zzE * 50000.0f + 0.5f));
                                                        var16_10.putShort((short)(this.zzF * 50000.0f + 0.5f));
                                                        var16_10.putShort((short)(this.zzG * 50000.0f + 0.5f));
                                                        var16_10.putShort((short)(this.zzH * 50000.0f + 0.5f));
                                                        var16_10.putShort((short)(this.zzI * 50000.0f + 0.5f));
                                                        var16_10.putShort((short)(this.zzJ * 50000.0f + 0.5f));
                                                        var16_10.putShort((short)(this.zzK + 0.5f));
                                                        var16_10.putShort((short)(this.zzL + 0.5f));
                                                        var16_10.putShort((short)this.zzA);
                                                        var16_10.putShort((short)this.zzB);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                var12_11 /* !! */  = (byte[])new zzj(this.zzx, this.zzz, this.zzy, var12_11 /* !! */ );
            }
            var4_4 = var6_12;
            if (this.zza != null) {
                var4_4 = var6_12;
                if (zzqi.zzg().containsKey(this.zza)) {
                    var4_4 = (Integer)zzqi.zzg().get(this.zza);
                }
            }
            if (this.zzq == 0 && Float.compare(this.zzr, 0.0f) == 0 && Float.compare(this.zzs, 0.0f) == 0) {
                if (Float.compare(this.zzt, 0.0f) == 0) {
                    var4_4 = var8_7;
                } else if (Float.compare(this.zzs, 90.0f) == 0) {
                    var4_4 = 90;
                } else if (Float.compare(this.zzs, -180.0f) != 0 && Float.compare(this.zzs, 180.0f) != 0) {
                    if (Float.compare(this.zzs, -90.0f) == 0) {
                        var4_4 = 270;
                    }
                } else {
                    var4_4 = 180;
                }
            }
            var13_8.zzS(this.zzl);
            var13_8.zzT(this.zzm);
            var13_8.zzW(var3_18);
            var13_8.zzV(var4_4);
            var13_8.zzX(this.zzu);
            var13_8.zzY(this.zzv);
            var13_8.zzZ((zzj)var12_11 /* !! */ );
            var4_4 = 2;
        } else {
            if (!("application/x-subrip".equals(var14_13) || "text/x-ssa".equals(var14_13) || "application/vobsub".equals(var14_13) || "application/pgs".equals(var14_13))) {
                if ("application/dvbsubs".equals(var14_13) == false) throw zzaha.zzb((String)"Unexpected MIME type.", null);
            }
            var4_4 = 3;
        }
        if (this.zza != null && !zzqi.zzg().containsKey(this.zza)) {
            var13_8.zzF(this.zza);
        }
        var13_8.zzE(var2_2);
        var13_8.zzN(var14_13);
        var13_8.zzO(var5_6);
        var13_8.zzG(this.zzY);
        var13_8.zzH(var10_16 | var7_17);
        var13_8.zzP((List)var11_3);
        var13_8.zzK((String)var15_15 /* !! */ );
        var13_8.zzQ(this.zzk);
        var11_3 = var13_8.zzah();
        var1_1 = var1_1.zzB(this.zzc, var4_4);
        this.zzV = var1_1;
        var1_1.zzs((zzafv)var11_3);
    }
}
