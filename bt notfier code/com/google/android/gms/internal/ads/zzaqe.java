/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzanm
 *  com.google.android.gms.internal.ads.zzanp
 *  com.google.android.gms.internal.ads.zzapk
 *  com.google.android.gms.internal.ads.zzapp
 *  com.google.android.gms.internal.ads.zzapw
 *  com.google.android.gms.internal.ads.zzapx
 *  com.google.android.gms.internal.ads.zzaqd
 *  com.google.android.gms.internal.ads.zzaqf
 *  com.google.android.gms.internal.ads.zzauu
 *  com.google.android.gms.internal.ads.zzaux
 *  com.google.android.gms.internal.ads.zzave
 *  com.google.android.gms.internal.ads.zzavf
 *  com.google.android.gms.internal.ads.zzavh
 *  com.google.android.gms.internal.ads.zzavl
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzanm;
import com.google.android.gms.internal.ads.zzanp;
import com.google.android.gms.internal.ads.zzapk;
import com.google.android.gms.internal.ads.zzapp;
import com.google.android.gms.internal.ads.zzapw;
import com.google.android.gms.internal.ads.zzapx;
import com.google.android.gms.internal.ads.zzaqd;
import com.google.android.gms.internal.ads.zzaqf;
import com.google.android.gms.internal.ads.zzauu;
import com.google.android.gms.internal.ads.zzaux;
import com.google.android.gms.internal.ads.zzave;
import com.google.android.gms.internal.ads.zzavf;
import com.google.android.gms.internal.ads.zzavh;
import com.google.android.gms.internal.ads.zzavl;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class zzaqe {
    public float zzA = -1.0f;
    public float zzB = -1.0f;
    public float zzC = -1.0f;
    public float zzD = -1.0f;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public int zzG = 1;
    public int zzH = -1;
    public int zzI = 8000;
    public long zzJ = 0L;
    public long zzK = 0L;
    public boolean zzL;
    public boolean zzM = true;
    public zzapx zzN;
    public int zzO;
    private String zzP = "eng";
    public String zza;
    public int zzb;
    public int zzc;
    public int zzd;
    public boolean zze;
    public byte[] zzf;
    public zzapw zzg;
    public byte[] zzh;
    public zzapk zzi;
    public int zzj = -1;
    public int zzk = -1;
    public int zzl = -1;
    public int zzm = -1;
    public int zzn = 0;
    public byte[] zzo = null;
    public int zzp = -1;
    public boolean zzq = false;
    public int zzr = -1;
    public int zzs = -1;
    public int zzt = -1;
    public int zzu = 1000;
    public int zzv = 200;
    public float zzw = -1.0f;
    public float zzx = -1.0f;
    public float zzy = -1.0f;
    public float zzz = -1.0f;

    private zzaqe() {
    }

    /* synthetic */ zzaqe(zzaqd zzaqd2) {
    }

    static /* synthetic */ String zza(zzaqe zzaqe2, String string) {
        zzaqe2.zzP = string;
        return string;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private static List<byte[]> zzc(zzaux var0) throws zzanp {
        try {
            var0 /* !! */ .zzj(16);
            if (var0 /* !! */ .zzq() != 826496599L) {
                return null;
            }
            var1_3 = var0 /* !! */ .zzg() + 20;
            var0 /* !! */  = (zzaux)var0 /* !! */ .zza;
            ** while (var1_3 < (var2_4 = ((zzaux)var0 /* !! */ ).length) - 4)
        }
        catch (ArrayIndexOutOfBoundsException var0_1) {
            var0_2 = new zzanp("Error parsing FourCC VC1 codec private");
            throw var0_2;
        }
lbl-1000:
        // 1 sources

        {
            if (var0 /* !! */ [var1_3] == false && var0 /* !! */ [var1_3 + 1] == false && var0 /* !! */ [var1_3 + 2] == true && var0 /* !! */ [var1_3 + 3] == 15) {
                return Collections.singletonList(Arrays.copyOfRange((byte[])var0 /* !! */ , var1_3, var2_4));
            }
            ++var1_3;
            continue;
        }
lbl17:
        // 2 sources

        var0 /* !! */  = new zzanp("Failed to find FourCC VC1 initialization data");
        throw var0 /* !! */ ;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    private static List<byte[]> zzd(byte[] var0) throws zzanp {
        if (var0[0] != 2) ** GOTO lbl44
        var2_3 = 1;
        var1_4 = 0;
        while ((var3_5 = var0[var2_3]) == -1) {
            var1_4 += 255;
            ++var2_3;
        }
        ++var2_3;
        var3_5 = var1_4 + var3_5;
        var1_4 = 0;
        while ((var4_6 = var0[var2_3]) == -1) {
            var1_4 += 255;
            ++var2_3;
        }
        if (var0[++var2_3] != 1) ** GOTO lbl41
        try {
            var5_7 = new byte[var3_5];
            System.arraycopy(var0, var2_3, var5_7, 0, var3_5);
        }
        catch (ArrayIndexOutOfBoundsException var0_1) {
            var0_2 = new zzanp("Error parsing vorbis codec private");
            throw var0_2;
        }
        if (var0[var2_3 += var3_5] != 3) ** GOTO lbl38
        if (var0[var2_3 += var1_4 + var4_6] != 5) ** GOTO lbl35
        {
            var1_4 = ((byte[])var0).length - var2_3;
            var6_8 = new byte[var1_4];
            System.arraycopy(var0, var2_3, var6_8, 0, var1_4);
            var0 = new ArrayList;
            var0(2);
            var0.add(var5_7);
            var0.add(var6_8);
            return var0;
lbl35:
            // 1 sources

            var0 = new zzanp;
            var0("Error parsing vorbis codec private");
            throw var0;
lbl38:
            // 1 sources

            var0 = new zzanp;
            var0("Error parsing vorbis codec private");
            throw var0;
lbl41:
            // 1 sources

            var0 = new zzanp;
            var0("Error parsing vorbis codec private");
            throw var0;
lbl44:
            // 1 sources

            var0 = new zzanp;
            var0("Error parsing vorbis codec private");
            throw var0;
        }
    }

    private static boolean zze(zzaux zzaux2) throws zzanp {
        try {
            long l;
            int n = zzaux2.zzn();
            if (n == 1) {
                return true;
            }
            if (n != 65534) return false;
            zzaux2.zzi(24);
            if (zzaux2.zzs() != zzaqf.zza().getMostSignificantBits()) return false;
            long l2 = zzaux2.zzs();
            if (l2 != (l = zzaqf.zza().getLeastSignificantBits())) return false;
            return true;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new zzanp("Error parsing MS/ACM codec private");
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zzb(zzapp var1_1, int var2_2) throws zzanp {
        block77: {
            block76: {
                block74: {
                    block75: {
                        block73: {
                            var9_3 = this.zza;
                            var4_4 = var9_3.hashCode();
                            var7_5 = 2;
                            switch (var4_4) {
                                default: {
                                    break;
                                }
                                case 1951062397: {
                                    if (!var9_3.equals("A_OPUS")) break;
                                    var4_4 = 11;
                                    break block73;
                                }
                                case 1950789798: {
                                    if (!var9_3.equals("A_FLAC")) break;
                                    var4_4 = 21;
                                    break block73;
                                }
                                case 1950749482: {
                                    if (!var9_3.equals("A_EAC3")) break;
                                    var4_4 = 16;
                                    break block73;
                                }
                                case 1809237540: {
                                    if (!var9_3.equals("V_MPEG2")) break;
                                    var4_4 = 2;
                                    break block73;
                                }
                                case 1422270023: {
                                    if (!var9_3.equals("S_TEXT/UTF8")) break;
                                    var4_4 = 24;
                                    break block73;
                                }
                                case 855502857: {
                                    if (!var9_3.equals("V_MPEGH/ISO/HEVC")) break;
                                    var4_4 = 7;
                                    break block73;
                                }
                                case 725957860: {
                                    if (!var9_3.equals("A_PCM/INT/LIT")) break;
                                    var4_4 = 23;
                                    break block73;
                                }
                                case 542569478: {
                                    if (!var9_3.equals("A_DTS/EXPRESS")) break;
                                    var4_4 = 19;
                                    break block73;
                                }
                                case 444813526: {
                                    if (!var9_3.equals("V_THEORA")) break;
                                    var4_4 = 9;
                                    break block73;
                                }
                                case 99146302: {
                                    if (!var9_3.equals("S_HDMV/PGS")) break;
                                    var4_4 = 26;
                                    break block73;
                                }
                                case 82338134: {
                                    if (!var9_3.equals("V_VP9")) break;
                                    var4_4 = 1;
                                    break block73;
                                }
                                case 82338133: {
                                    if (!var9_3.equals("V_VP8")) break;
                                    var4_4 = 0;
                                    break block73;
                                }
                                case 62927045: {
                                    if (!var9_3.equals("A_DTS")) break;
                                    var4_4 = 18;
                                    break block73;
                                }
                                case 62923603: {
                                    if (!var9_3.equals("A_AC3")) break;
                                    var4_4 = 15;
                                    break block73;
                                }
                                case 62923557: {
                                    if (!var9_3.equals("A_AAC")) break;
                                    var4_4 = 12;
                                    break block73;
                                }
                                case -356037306: {
                                    if (!var9_3.equals("A_DTS/LOSSLESS")) break;
                                    var4_4 = 20;
                                    break block73;
                                }
                                case -425012669: {
                                    if (!var9_3.equals("S_VOBSUB")) break;
                                    var4_4 = 25;
                                    break block73;
                                }
                                case -538363109: {
                                    if (!var9_3.equals("V_MPEG4/ISO/AVC")) break;
                                    var4_4 = 6;
                                    break block73;
                                }
                                case -538363189: {
                                    if (!var9_3.equals("V_MPEG4/ISO/ASP")) break;
                                    var4_4 = 4;
                                    break block73;
                                }
                                case -933872740: {
                                    if (!var9_3.equals("S_DVBSUB")) break;
                                    var4_4 = 27;
                                    break block73;
                                }
                                case -1373388978: {
                                    if (!var9_3.equals("V_MS/VFW/FOURCC")) break;
                                    var4_4 = 8;
                                    break block73;
                                }
                                case -1482641357: {
                                    if (!var9_3.equals("A_MPEG/L3")) break;
                                    var4_4 = 14;
                                    break block73;
                                }
                                case -1482641358: {
                                    if (!var9_3.equals("A_MPEG/L2")) break;
                                    var4_4 = 13;
                                    break block73;
                                }
                                case -1730367663: {
                                    if (!var9_3.equals("A_VORBIS")) break;
                                    var4_4 = 10;
                                    break block73;
                                }
                                case -1784763192: {
                                    if (!var9_3.equals("A_TRUEHD")) break;
                                    var4_4 = 17;
                                    break block73;
                                }
                                case -1985379776: {
                                    if (!var9_3.equals("A_MS/ACM")) break;
                                    var4_4 = 22;
                                    break block73;
                                }
                                case -2095575984: {
                                    if (!var9_3.equals("V_MPEG4/ISO/SP")) break;
                                    var4_4 = 3;
                                    break block73;
                                }
                                case -2095576542: {
                                    if (!var9_3.equals("V_MPEG4/ISO/AP")) break;
                                    var4_4 = 5;
                                    break block73;
                                }
                            }
                            var4_4 = -1;
                        }
                        var11_6 = "audio/raw";
                        switch (var4_4) {
                            default: {
                                throw new zzanp("Unrecognized codec identifier.");
                            }
                            case 27: {
                                var9_3 = this.zzh;
                                var10_7 = Collections.singletonList(new byte[]{(byte)var9_3[0], (byte)var9_3[1], (byte)var9_3[2], (byte)var9_3[3]});
                                var9_3 = "application/dvbsubs";
                                break block74;
                            }
                            case 26: {
                                var9_3 = "application/pgs";
                                break block75;
                            }
                            case 25: {
                                var10_7 = Collections.singletonList(this.zzh);
                                var9_3 = "application/vobsub";
                                break block74;
                            }
                            case 24: {
                                var9_3 = "application/x-subrip";
                                break block75;
                            }
                            case 23: {
                                var4_4 = var5_8 = zzave.zzo((int)this.zzH);
                                if (var5_8 != 0) ** GOTO lbl169
                                var4_4 = this.zzH;
                                var9_3 = new StringBuilder(75);
                                var9_3.append("Unsupported PCM bit depth: ");
                                var9_3.append(var4_4);
                                var9_3.append(". Setting mimeType to audio/x-unknown");
                                Log.w((String)"MatroskaExtractor", (String)var9_3.toString());
                                ** GOTO lbl174
                            }
                            case 22: {
                                if (!zzaqe.zze(new zzaux(this.zzh))) ** GOTO lbl172
                                var4_4 = var5_8 = zzave.zzo((int)this.zzH);
                                if (var5_8 != 0) ** GOTO lbl169
                                var4_4 = this.zzH;
                                var9_3 = new StringBuilder(75);
                                var9_3.append("Unsupported PCM bit depth: ");
                                var9_3.append(var4_4);
                                var9_3.append(". Setting mimeType to audio/x-unknown");
                                Log.w((String)"MatroskaExtractor", (String)var9_3.toString());
                                ** GOTO lbl174
lbl169:
                                // 2 sources

                                var9_3 = null;
                                var5_8 = var4_4;
                                break block76;
lbl172:
                                // 1 sources

                                Log.w((String)"MatroskaExtractor", (String)"Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
lbl174:
                                // 3 sources

                                var9_3 = "audio/x-unknown";
                                break block75;
                            }
                            case 21: {
                                var10_7 = Collections.singletonList(this.zzh);
                                var9_3 = "audio/x-flac";
                                break block74;
                            }
                            case 20: {
                                var9_3 = "audio/vnd.dts.hd";
                                break block75;
                            }
                            case 18: 
                            case 19: {
                                var9_3 = "audio/vnd.dts";
                                break block75;
                            }
                            case 17: {
                                var9_3 = "audio/true-hd";
                                break block75;
                            }
                            case 16: {
                                var9_3 = "audio/eac3";
                                break block75;
                            }
                            case 15: {
                                var9_3 = "audio/ac3";
                                break block75;
                            }
                            case 14: {
                                var10_7 = "audio/mpeg";
                                ** GOTO lbl200
                            }
                            case 13: {
                                var10_7 = "audio/mpeg-L2";
lbl200:
                                // 2 sources

                                var9_3 = null;
                                var5_8 = -1;
                                var4_4 = 4096;
                                break block77;
                            }
                            case 12: {
                                var10_7 = Collections.singletonList(this.zzh);
                                var9_3 = "audio/mp4a-latm";
                                break block74;
                            }
                            case 11: {
                                var9_3 = new ArrayList<byte[]>(3);
                                var9_3.add(this.zzh);
                                var9_3.add((byte[])ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.zzJ).array());
                                var9_3.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.zzK).array());
                                var10_7 = "audio/opus";
                                var5_8 = -1;
                                var4_4 = 5760;
                                break block77;
                            }
                            case 10: {
                                var9_3 = zzaqe.zzd(this.zzh);
                                var10_7 = "audio/vorbis";
                                var5_8 = -1;
                                var4_4 = 8192;
                                break block77;
                            }
                            case 9: {
                                var9_3 = "video/x-unknown";
                                break block75;
                            }
                            case 8: {
                                var10_7 = zzaqe.zzc(new zzaux(this.zzh));
                                if (var10_7 != null) {
                                    var9_3 = "video/wvc1";
                                } else {
                                    Log.w((String)"MatroskaExtractor", (String)"Unsupported FourCC. Setting mimeType to video/x-unknown");
                                    var9_3 = "video/x-unknown";
                                }
                                break block74;
                            }
                            case 7: {
                                var9_3 = zzavl.zza((zzaux)new zzaux(this.zzh));
                                var10_7 = var9_3.zza;
                                this.zzO = var9_3.zzb;
                                var9_3 = "video/hevc";
                                break block74;
                            }
                            case 6: {
                                var9_3 = zzavf.zza((zzaux)new zzaux(this.zzh));
                                var10_7 = var9_3.zza;
                                this.zzO = var9_3.zzb;
                                var9_3 = "video/avc";
                                break block74;
                            }
                            case 3: 
                            case 4: 
                            case 5: {
                                var9_3 = this.zzh;
                                var10_7 = var9_3 == null ? null : Collections.singletonList(var9_3);
                                var9_3 = "video/mp4v-es";
                                break block74;
                            }
                            case 2: {
                                var9_3 = "video/mpeg2";
                                break block75;
                            }
                            case 1: {
                                var9_3 = "video/x-vnd.on2.vp9";
                                break block75;
                            }
                            case 0: 
                        }
                        var9_3 = "video/x-vnd.on2.vp8";
                    }
                    var10_7 = null;
                }
                var5_8 = -1;
                var11_6 = var9_3;
                var9_3 = var10_7;
            }
            var4_4 = -1;
            var10_7 = var11_6;
        }
        var8_9 = this.zzM;
        var6_10 = true != this.zzL ? 0 : 2;
        var6_10 = var8_9 | var6_10;
        if (zzauu.zza((String)var10_7)) {
            var9_3 = zzanm.zzc((String)Integer.toString(var2_2), var10_7, null, (int)-1, (int)var4_4, (int)this.zzG, (int)this.zzI, (int)var5_8, (int)-1, (int)-1, (List)var9_3, (zzapk)this.zzi, (int)var6_10, (String)this.zzP, null);
            var2_2 = 1;
        } else if (zzauu.zzb((String)var10_7)) {
            if (this.zzn == 0) {
                var5_8 = var6_10 = this.zzl;
                if (var6_10 == -1) {
                    var5_8 = this.zzj;
                }
                this.zzl = var5_8;
                var5_8 = var6_10 = this.zzm;
                if (var6_10 == -1) {
                    var5_8 = this.zzk;
                }
                this.zzm = var5_8;
            }
            var3_11 = (var6_10 = this.zzl) != -1 && (var5_8 = this.zzm) != -1 ? (float)(this.zzk * var6_10) / (float)(this.zzj * var5_8) : -1.0f;
            if (this.zzq) {
                if (this.zzw != -1.0f && this.zzx != -1.0f && this.zzy != -1.0f && this.zzz != -1.0f && this.zzA != -1.0f && this.zzB != -1.0f && this.zzC != -1.0f && this.zzD != -1.0f && this.zzE != -1.0f && this.zzF != -1.0f) {
                    var11_6 = new byte[25];
                    var12_12 = ByteBuffer.wrap((byte[])var11_6);
                    var12_12.put((byte)0);
                    var12_12.putShort((short)(this.zzw * 50000.0f + 0.5f));
                    var12_12.putShort((short)(this.zzx * 50000.0f + 0.5f));
                    var12_12.putShort((short)(this.zzy * 50000.0f + 0.5f));
                    var12_12.putShort((short)(this.zzz * 50000.0f + 0.5f));
                    var12_12.putShort((short)(this.zzA * 50000.0f + 0.5f));
                    var12_12.putShort((short)(this.zzB * 50000.0f + 0.5f));
                    var12_12.putShort((short)(this.zzC * 50000.0f + 0.5f));
                    var12_12.putShort((short)(this.zzD * 50000.0f + 0.5f));
                    var12_12.putShort((short)(this.zzE + 0.5f));
                    var12_12.putShort((short)(this.zzF + 0.5f));
                    var12_12.putShort((short)this.zzu);
                    var12_12.putShort((short)this.zzv);
                } else {
                    var11_6 = null;
                }
                var11_6 = new zzavh(this.zzr, this.zzt, this.zzs, (byte[])var11_6);
            } else {
                var11_6 = null;
            }
            var9_3 = zzanm.zza((String)Integer.toString(var2_2), (String)var10_7, null, (int)-1, (int)var4_4, (int)this.zzj, (int)this.zzk, (float)-1.0f, (List)var9_3, (int)-1, (float)var3_11, (byte[])this.zzo, (int)this.zzp, (zzavh)var11_6, (zzapk)this.zzi);
            var2_2 = var7_5;
        } else {
            if ("application/x-subrip".equals(var10_7)) {
                var9_3 = zzanm.zzd((String)Integer.toString(var2_2), (String)var10_7, null, (int)-1, (int)var6_10, (String)this.zzP, (int)-1, (zzapk)this.zzi, (long)0x7FFFFFFFFFFFFFFFL, Collections.<T>emptyList());
            } else {
                if (!"application/vobsub".equals(var10_7) && !"application/pgs".equals(var10_7)) {
                    if ("application/dvbsubs".equals(var10_7) == false) throw new zzanp("Unexpected MIME type.");
                }
                var9_3 = zzanm.zze((String)Integer.toString(var2_2), (String)var10_7, null, (int)-1, (List)var9_3, (String)this.zzP, (zzapk)this.zzi);
            }
            var2_2 = 3;
        }
        var1_1 = var1_1.zzbf(this.zzb, var2_2);
        this.zzN = var1_1;
        var1_1.zza((zzanm)var9_3);
    }
}
