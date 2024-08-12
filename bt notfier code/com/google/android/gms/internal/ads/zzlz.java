/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.media.MediaCrypto
 *  android.media.MediaFormat
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.SystemClock
 *  android.util.Log
 *  android.util.Pair
 *  android.view.Surface
 *  com.google.android.gms.internal.ads.zzaeg
 *  com.google.android.gms.internal.ads.zzaf
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzafw
 *  com.google.android.gms.internal.ads.zzaln
 *  com.google.android.gms.internal.ads.zzalq
 *  com.google.android.gms.internal.ads.zzalt
 *  com.google.android.gms.internal.ads.zzamo
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzaz
 *  com.google.android.gms.internal.ads.zzba
 *  com.google.android.gms.internal.ads.zzfl
 *  com.google.android.gms.internal.ads.zzfm
 *  com.google.android.gms.internal.ads.zzfn
 *  com.google.android.gms.internal.ads.zzfo
 *  com.google.android.gms.internal.ads.zzfq
 *  com.google.android.gms.internal.ads.zzfs
 *  com.google.android.gms.internal.ads.zzfy
 *  com.google.android.gms.internal.ads.zzge
 *  com.google.android.gms.internal.ads.zzgh
 *  com.google.android.gms.internal.ads.zzj
 *  com.google.android.gms.internal.ads.zzlu
 *  com.google.android.gms.internal.ads.zzlx
 *  com.google.android.gms.internal.ads.zzly
 *  com.google.android.gms.internal.ads.zzma
 *  com.google.android.gms.internal.ads.zzmi
 *  com.google.android.gms.internal.ads.zzmt
 *  com.google.android.gms.internal.ads.zzmu
 *  com.google.android.gms.internal.ads.zzy
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import com.google.android.gms.internal.ads.zzaeg;
import com.google.android.gms.internal.ads.zzaf;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzafw;
import com.google.android.gms.internal.ads.zzaln;
import com.google.android.gms.internal.ads.zzalq;
import com.google.android.gms.internal.ads.zzalt;
import com.google.android.gms.internal.ads.zzamo;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzaz;
import com.google.android.gms.internal.ads.zzba;
import com.google.android.gms.internal.ads.zzfl;
import com.google.android.gms.internal.ads.zzfm;
import com.google.android.gms.internal.ads.zzfn;
import com.google.android.gms.internal.ads.zzfo;
import com.google.android.gms.internal.ads.zzfq;
import com.google.android.gms.internal.ads.zzfs;
import com.google.android.gms.internal.ads.zzfy;
import com.google.android.gms.internal.ads.zzge;
import com.google.android.gms.internal.ads.zzgh;
import com.google.android.gms.internal.ads.zzj;
import com.google.android.gms.internal.ads.zzlu;
import com.google.android.gms.internal.ads.zzlx;
import com.google.android.gms.internal.ads.zzly;
import com.google.android.gms.internal.ads.zzma;
import com.google.android.gms.internal.ads.zzmi;
import com.google.android.gms.internal.ads.zzmt;
import com.google.android.gms.internal.ads.zzmu;
import com.google.android.gms.internal.ads.zzy;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class zzlz
extends zzfq {
    private static final int[] zzb = new int[]{1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean zzc;
    private static boolean zzd;
    private long zzA;
    private int zzB;
    private int zzC;
    private int zzD;
    private int zzE;
    private float zzF;
    private zzy zzG;
    private int zzH;
    private zzma zzI;
    private final Context zze;
    private final zzmi zzf;
    private final zzmt zzg;
    private final boolean zzh;
    private zzly zzi;
    private boolean zzj;
    private boolean zzk;
    private Surface zzl;
    private zzlu zzm;
    private boolean zzn;
    private int zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private int zzv;
    private int zzw;
    private int zzx;
    private long zzy;
    private long zzz;

    public zzlz(Context context, zzfm zzfm2, zzfs zzfs2, long l, boolean bl, Handler handler, zzmu zzmu2, int n) {
        super(2, zzfm2, zzfs2, false, 30.0f);
        this.zze = context = context.getApplicationContext();
        this.zzf = new zzmi(context);
        this.zzg = new zzmt(handler, zzmu2);
        this.zzh = "NVIDIA".equals(zzamq.zzc);
        this.zzt = -9223372036854775807L;
        this.zzC = -1;
        this.zzD = -1;
        this.zzF = -1.0f;
        this.zzo = 1;
        this.zzH = 0;
        this.zzG = null;
    }

    private static List<zzfo> zzaA(zzfs object, zzafv zzafv2, boolean bl, boolean bl2) throws zzfy {
        String string = zzafv2.zzl;
        if (string == null) {
            return Collections.emptyList();
        }
        object = zzge.zzd((List)zzge.zzc((String)string, (boolean)bl, (boolean)bl2), (zzafv)zzafv2);
        if (!"video/dolby-vision".equals(string)) return Collections.unmodifiableList(object);
        if ((zzafv2 = zzge.zzf((zzafv)zzafv2)) == null) return Collections.unmodifiableList(object);
        int n = (Integer)zzafv2.first;
        if (n != 16 && n != 256) {
            if (n != 512) return Collections.unmodifiableList(object);
            object.addAll(zzge.zzc((String)"video/avc", (boolean)bl, (boolean)bl2));
        } else {
            object.addAll(zzge.zzc((String)"video/hevc", (boolean)bl, (boolean)bl2));
        }
        return Collections.unmodifiableList(object);
    }

    private final boolean zzaB(zzfo zzfo2) {
        int n = zzamq.zza;
        boolean bl = true;
        if (n >= 23 && !zzlz.zzab(zzfo2.zza)) {
            if (!zzfo2.zzf) return bl;
            if (zzlu.zza((Context)this.zze)) return true;
        }
        bl = false;
        return bl;
    }

    private final void zzaC() {
        zzy zzy2;
        int n;
        int n2 = n = this.zzC;
        if (n == -1) {
            if (this.zzD == -1) return;
            n2 = -1;
        }
        if ((zzy2 = this.zzG) != null && zzy2.zzb == n2 && zzy2.zzc == this.zzD && zzy2.zzd == this.zzE) {
            if (zzy2.zze == this.zzF) return;
        }
        this.zzG = zzy2 = new zzy(n2, this.zzD, this.zzE, this.zzF);
        this.zzg.zzf(zzy2);
    }

    private final void zzaD() {
        zzy zzy2 = this.zzG;
        if (zzy2 == null) return;
        this.zzg.zzf(zzy2);
    }

    private static boolean zzaE(long l) {
        if (l >= -30000L) return false;
        return true;
    }

    private static int zzaF(zzfo zzfo2, zzafv zzafv2) {
        int n;
        int n2;
        block16: {
            int n3;
            int n4;
            block14: {
                block15: {
                    block13: {
                        n4 = zzafv2.zzq;
                        n3 = zzafv2.zzr;
                        if (n4 == -1) return -1;
                        if (n3 == -1) {
                            return -1;
                        }
                        String string = zzafv2.zzl;
                        boolean bl = "video/dolby-vision".equals(string);
                        n2 = 2;
                        if (bl) {
                            string = (zzafv2 = zzge.zzf((zzafv)zzafv2)) != null && ((n = ((Integer)zzafv2.first).intValue()) == 512 || n == 1 || n == 2) ? "video/avc" : "video/hevc";
                        }
                        switch (string.hashCode()) {
                            default: {
                                break;
                            }
                            case 1599127257: {
                                if (!string.equals("video/x-vnd.on2.vp9")) break;
                                n = 5;
                                break block13;
                            }
                            case 1599127256: {
                                if (!string.equals("video/x-vnd.on2.vp8")) break;
                                n = 3;
                                break block13;
                            }
                            case 1331836730: {
                                if (!string.equals("video/avc")) break;
                                n = 2;
                                break block13;
                            }
                            case 1187890754: {
                                if (!string.equals("video/mp4v-es")) break;
                                n = 1;
                                break block13;
                            }
                            case -1662541442: {
                                if (!string.equals("video/hevc")) break;
                                n = 4;
                                break block13;
                            }
                            case -1664118616: {
                                if (!string.equals("video/3gpp")) break;
                                n = 0;
                                break block13;
                            }
                        }
                        n = -1;
                    }
                    if (n == 0 || n == 1) break block14;
                    if (n == 2) break block15;
                    if (n == 3) break block14;
                    if (n != 4 && n != 5) {
                        return -1;
                    }
                    n = n4 * n3;
                    n2 = 4;
                    break block16;
                }
                if ("BRAVIA 4K 2015".equals(zzamq.zzd)) return -1;
                if ("Amazon".equals(zzamq.zzc)) {
                    if ("KFSOWI".equals(zzamq.zzd)) return -1;
                    if ("AFTS".equals(zzamq.zzd)) {
                        if (zzfo2.zzf) return -1;
                    }
                }
                n = zzamq.zzw((int)n4, (int)16) * zzamq.zzw((int)n3, (int)16) * 256;
                break block16;
            }
            n = n4 * n3;
        }
        return n * 3 / (n2 + n2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    protected static final boolean zzab(String var0) {
        var4_2 = var0.startsWith("OMX.google");
        var5_3 = false;
        if (var4_2) {
            return false;
        }
        synchronized (zzlz.class) {
            try {
                if (zzlz.zzc != false) return zzlz.zzd;
                var1_4 = zzamq.zza;
                var3_5 = 4;
                var2_6 = -1;
                if (var1_4 > 28) ** GOTO lbl-1000
                var0 = zzamq.zzb;
                var1_4 = var0.hashCode();
                ** GOTO lbl17
            }
            catch (Throwable var0_1) {
                block174: {
                    block176: {
                        block175: {
lbl17:
                            // 1 sources

                            switch (var1_4) {
                                default: {
                                    break;
                                }
                                case 825323514: {
                                    if (!var0.equals("machuca")) break;
                                    var1_4 = 4;
                                    break block175;
                                }
                                case 3415681: {
                                    if (!var0.equals("once")) break;
                                    var1_4 = 5;
                                    break block175;
                                }
                                case -64886864: {
                                    if (!var0.equals("magnolia")) break;
                                    var1_4 = 3;
                                    break block175;
                                }
                                case -1012436106: {
                                    if (!var0.equals("oneday")) break;
                                    var1_4 = 6;
                                    break block175;
                                }
                                case -1220066608: {
                                    if (!var0.equals("dangalUHD")) break;
                                    var1_4 = 1;
                                    break block175;
                                }
                                case -1220081023: {
                                    if (!var0.equals("dangalFHD")) break;
                                    var1_4 = 2;
                                    break block175;
                                }
                                case -1339091551: {
                                    if (!var0.equals("dangal")) break;
                                    var1_4 = 0;
                                    break block175;
                                }
                            }
                            var1_4 = -1;
                        }
                        switch (var1_4) {
                            default: {
                                break;
                            }
                            case 0: 
                            case 1: 
                            case 2: 
                            case 3: 
                            case 4: 
                            case 5: 
                            case 6: lbl-1000:
                            // 4 sources

                            {
                                while (true) {
                                    var4_2 = true;
                                    break block174;
                                    break;
                                }
                            }
                        }
lbl-1000:
                        // 2 sources

                        {
                            if (zzamq.zza <= 27 && "HWEML".equals(zzamq.zzb)) ** GOTO lbl-1000
                            var4_2 = var5_3;
                            if (zzamq.zza > 26) break block174;
                            var0 = zzamq.zzb;
                            var1_4 = var0.hashCode();
                        }
                        switch (var1_4) {
                            default: {
                                break;
                            }
                            case 2048855701: {
                                if (!var0.equals("HWWAS-H")) break;
                                var1_4 = 66;
                                break block176;
                            }
                            case 2048319463: {
                                if (!var0.equals("HWVNS-H")) break;
                                var1_4 = 65;
                                break block176;
                            }
                            case 2047252157: {
                                if (!var0.equals("ELUGA_Prim")) break;
                                var1_4 = 33;
                                break block176;
                            }
                            case 2047190025: {
                                if (!var0.equals("ELUGA_Note")) break;
                                var1_4 = 32;
                                break block176;
                            }
                            case 2033393791: {
                                if (!var0.equals("ASUS_X00AD_2")) break;
                                var1_4 = 14;
                                break block176;
                            }
                            case 2030379515: {
                                if (!var0.equals("HWCAM-H")) break;
                                var1_4 = 64;
                                break block176;
                            }
                            case 2029784656: {
                                if (!var0.equals("HWBLN-H")) break;
                                var1_4 = 63;
                                break block176;
                            }
                            case 2019281702: {
                                if (!var0.equals("DM-01K")) break;
                                var1_4 = 29;
                                break block176;
                            }
                            case 2006372676: {
                                if (!var0.equals("BRAVIA_ATV3_4K")) break;
                                var1_4 = 19;
                                break block176;
                            }
                            case 1977196784: {
                                if (!var0.equals("Infinix-X572")) break;
                                var1_4 = 69;
                                break block176;
                            }
                            case 1906253259: {
                                if (!var0.equals("PB2-670M")) break;
                                var1_4 = 100;
                                break block176;
                            }
                            case 1865889110: {
                                if (!var0.equals("santoni")) break;
                                var1_4 = 117;
                                break block176;
                            }
                            case 1709443163: {
                                if (!var0.equals("iball8735_9806")) break;
                                var1_4 = 68;
                                break block176;
                            }
                            case 1691544261: {
                                if (!var0.equals("CPH1715")) break;
                                var1_4 = 24;
                                break block176;
                            }
                            case 1691543273: {
                                if (!var0.equals("CPH1609")) break;
                                var1_4 = 23;
                                break block176;
                            }
                            case 1522194893: {
                                if (!var0.equals("woods_f")) break;
                                var1_4 = 133;
                                break block176;
                            }
                            case 1349174697: {
                                if (!var0.equals("htc_e56ml_dtul")) break;
                                var1_4 = 61;
                                break block176;
                            }
                            case 1306947716: {
                                if (!var0.equals("EverStar_S")) break;
                                var1_4 = 35;
                                break block176;
                            }
                            case 1280332038: {
                                if (!var0.equals("hwALE-H")) break;
                                var1_4 = 62;
                                break block176;
                            }
                            case 1176899427: {
                                if (!var0.equals("itel_S41")) break;
                                var1_4 = 71;
                                break block176;
                            }
                            case 1150207623: {
                                if (!var0.equals("LS-5017")) break;
                                var1_4 = 78;
                                break block176;
                            }
                            case 1060579533: {
                                if (!var0.equals("panell_d")) break;
                                var1_4 = 96;
                                break block176;
                            }
                            case 958008161: {
                                if (!var0.equals("j2xlteins")) break;
                                var1_4 = 72;
                                break block176;
                            }
                            case 917340916: {
                                if (!var0.equals("A7000plus")) break;
                                var1_4 = 10;
                                break block176;
                            }
                            case 835649806: {
                                if (!var0.equals("manning")) break;
                                var1_4 = 81;
                                break block176;
                            }
                            case 794040393: {
                                if (!var0.equals("GIONEE_WBL7519")) break;
                                var1_4 = 59;
                                break block176;
                            }
                            case 794038622: {
                                if (!var0.equals("GIONEE_WBL7365")) break;
                                var1_4 = 58;
                                break block176;
                            }
                            case 793982701: {
                                if (!var0.equals("GIONEE_WBL5708")) break;
                                var1_4 = 57;
                                break block176;
                            }
                            case 507412548: {
                                if (!var0.equals("QM16XE_U")) break;
                                var1_4 = 114;
                                break block176;
                            }
                            case 407160593: {
                                if (!var0.equals("Pixi5-10_4G")) break;
                                var1_4 = 106;
                                break block176;
                            }
                            case 316246818: {
                                if (!var0.equals("TB3-850M")) break;
                                var1_4 = 125;
                                break block176;
                            }
                            case 316246811: {
                                if (!var0.equals("TB3-850F")) break;
                                var1_4 = 124;
                                break block176;
                            }
                            case 316215116: {
                                if (!var0.equals("TB3-730X")) break;
                                var1_4 = 123;
                                break block176;
                            }
                            case 316215098: {
                                if (!var0.equals("TB3-730F")) break;
                                var1_4 = 122;
                                break block176;
                            }
                            case 308517133: {
                                if (!var0.equals("A7020a48")) break;
                                var1_4 = 12;
                                break block176;
                            }
                            case 307593612: {
                                if (!var0.equals("A7010a48")) break;
                                var1_4 = 11;
                                break block176;
                            }
                            case 287431619: {
                                if (!var0.equals("griffin")) break;
                                var1_4 = 60;
                                break block176;
                            }
                            case 245388979: {
                                if (!var0.equals("marino_f")) break;
                                var1_4 = 82;
                                break block176;
                            }
                            case 182191441: {
                                if (!var0.equals("CPY83_I00")) break;
                                var1_4 = 25;
                                break block176;
                            }
                            case 165221241: {
                                if (!var0.equals("A2016a40")) break;
                                var1_4 = 8;
                                break block176;
                            }
                            case 102844228: {
                                if (!var0.equals("le_x6")) break;
                                var1_4 = 77;
                                break block176;
                            }
                            case 101370885: {
                                if (!var0.equals("l5460")) break;
                                var1_4 = 76;
                                break block176;
                            }
                            case 98715550: {
                                if (!var0.equals("i9031")) break;
                                var1_4 = 67;
                                break block176;
                            }
                            case 82882791: {
                                if (!var0.equals("X3_HK")) break;
                                var1_4 = 135;
                                break block176;
                            }
                            case 80963634: {
                                if (!var0.equals("V23GB")) break;
                                var1_4 = 128;
                                break block176;
                            }
                            case 76404911: {
                                if (!var0.equals("Q4310")) break;
                                var1_4 = 112;
                                break block176;
                            }
                            case 76404105: {
                                if (!var0.equals("Q4260")) break;
                                var1_4 = 110;
                                break block176;
                            }
                            case 76402249: {
                                if (!var0.equals("PRO7S")) break;
                                var1_4 = 108;
                                break block176;
                            }
                            case 66216390: {
                                if (!var0.equals("F3311")) break;
                                var1_4 = 48;
                                break block176;
                            }
                            case 66215433: {
                                if (!var0.equals("F3215")) break;
                                var1_4 = 47;
                                break block176;
                            }
                            case 66215431: {
                                if (!var0.equals("F3213")) break;
                                var1_4 = 46;
                                break block176;
                            }
                            case 66215429: {
                                if (!var0.equals("F3211")) break;
                                var1_4 = 45;
                                break block176;
                            }
                            case 66214473: {
                                if (!var0.equals("F3116")) break;
                                var1_4 = 44;
                                break block176;
                            }
                            case 66214470: {
                                if (!var0.equals("F3113")) break;
                                var1_4 = 43;
                                break block176;
                            }
                            case 66214468: {
                                if (!var0.equals("F3111")) break;
                                var1_4 = 42;
                                break block176;
                            }
                            case 65355429: {
                                if (!var0.equals("E5643")) break;
                                var1_4 = 30;
                                break block176;
                            }
                            case 61542055: {
                                if (!var0.equals("A1601")) break;
                                var1_4 = 7;
                                break block176;
                            }
                            case 55178625: {
                                if (!var0.equals("Aura_Note_2")) break;
                                var1_4 = 15;
                                break block176;
                            }
                            case 51350594: {
                                if (!var0.equals("602LV")) break;
                                var1_4 = var3_5;
                                break block176;
                            }
                            case 51349633: {
                                if (!var0.equals("601LV")) break;
                                var1_4 = 3;
                                break block176;
                            }
                            case 41325051: {
                                if (!var0.equals("MEIZU_M5")) break;
                                var1_4 = 83;
                                break block176;
                            }
                            case 3386211: {
                                if (!var0.equals("p212")) break;
                                var1_4 = 92;
                                break block176;
                            }
                            case 0x332327: {
                                if (!var0.equals("mido")) break;
                                var1_4 = 85;
                                break block176;
                            }
                            case 3284551: {
                                if (!var0.equals("kate")) break;
                                var1_4 = 75;
                                break block176;
                            }
                            case 3154429: {
                                if (!var0.equals("fugu")) break;
                                var1_4 = 50;
                                break block176;
                            }
                            case 2689555: {
                                if (!var0.equals("XE2X")) break;
                                var1_4 = 136;
                                break block176;
                            }
                            case 2464648: {
                                if (!var0.equals("Q427")) break;
                                var1_4 = 111;
                                break block176;
                            }
                            case 2463773: {
                                if (!var0.equals("Q350")) break;
                                var1_4 = 109;
                                break block176;
                            }
                            case 0x252F5F: {
                                if (!var0.equals("P681")) break;
                                var1_4 = 93;
                                break block176;
                            }
                            case 2133184: {
                                if (!var0.equals("F04J")) break;
                                var1_4 = 41;
                                break block176;
                            }
                            case 2133182: {
                                if (!var0.equals("F04H")) break;
                                var1_4 = 40;
                                break block176;
                            }
                            case 2133151: {
                                if (!var0.equals("F03H")) break;
                                var1_4 = 39;
                                break block176;
                            }
                            case 2133120: {
                                if (!var0.equals("F02H")) break;
                                var1_4 = 38;
                                break block176;
                            }
                            case 2133091: {
                                if (!var0.equals("F01J")) break;
                                var1_4 = 37;
                                break block176;
                            }
                            case 2133089: {
                                if (!var0.equals("F01H")) break;
                                var1_4 = 36;
                                break block176;
                            }
                            case 1514185: {
                                if (!var0.equals("1714")) break;
                                var1_4 = 2;
                                break block176;
                            }
                            case 1514184: {
                                if (!var0.equals("1713")) break;
                                var1_4 = 1;
                                break block176;
                            }
                            case 1513190: {
                                if (!var0.equals("1601")) break;
                                var1_4 = 0;
                                break block176;
                            }
                            case 101481: {
                                if (!var0.equals("flo")) break;
                                var1_4 = 49;
                                break block176;
                            }
                            case 99329: {
                                if (!var0.equals("deb")) break;
                                var1_4 = 28;
                                break block176;
                            }
                            case 98848: {
                                if (!var0.equals("cv3")) break;
                                var1_4 = 27;
                                break block176;
                            }
                            case 98846: {
                                if (!var0.equals("cv1")) break;
                                var1_4 = 26;
                                break block176;
                            }
                            case 88274: {
                                if (!var0.equals("Z80")) break;
                                var1_4 = 139;
                                break block176;
                            }
                            case 80618: {
                                if (!var0.equals("QX1")) break;
                                var1_4 = 115;
                                break block176;
                            }
                            case 79305: {
                                if (!var0.equals("PLE")) break;
                                var1_4 = 107;
                                break block176;
                            }
                            case 78669: {
                                if (!var0.equals("P85")) break;
                                var1_4 = 94;
                                break block176;
                            }
                            case 76779: {
                                if (!var0.equals("MX6")) break;
                                var1_4 = 86;
                                break block176;
                            }
                            case 75739: {
                                if (!var0.equals("M5c")) break;
                                var1_4 = 80;
                                break block176;
                            }
                            case 75537: {
                                if (!var0.equals("M04")) break;
                                var1_4 = 79;
                                break block176;
                            }
                            case 73405: {
                                if (!var0.equals("JGZ")) break;
                                var1_4 = 73;
                                break block176;
                            }
                            case 3483: {
                                if (!var0.equals("mh")) break;
                                var1_4 = 84;
                                break block176;
                            }
                            case 3091: {
                                if (!var0.equals("b5")) break;
                                var1_4 = 16;
                                break block176;
                            }
                            case 2719: {
                                if (!var0.equals("V5")) break;
                                var1_4 = 129;
                                break block176;
                            }
                            case 2715: {
                                if (!var0.equals("V1")) break;
                                var1_4 = 127;
                                break block176;
                            }
                            case 2564: {
                                if (!var0.equals("Q5")) break;
                                var1_4 = 113;
                                break block176;
                            }
                            case 2126: {
                                if (!var0.equals("C1")) break;
                                var1_4 = 20;
                                break block176;
                            }
                            case -56598463: {
                                if (!var0.equals("woods_fn")) break;
                                var1_4 = 134;
                                break block176;
                            }
                            case -173639913: {
                                if (!var0.equals("ELUGA_A3_Pro")) break;
                                var1_4 = 31;
                                break block176;
                            }
                            case -277133239: {
                                if (!var0.equals("Z12_PRO")) break;
                                var1_4 = 138;
                                break block176;
                            }
                            case -282781963: {
                                if (!var0.equals("BLACK-1X")) break;
                                var1_4 = 17;
                                break block176;
                            }
                            case -290434366: {
                                if (!var0.equals("taido_row")) break;
                                var1_4 = 121;
                                break block176;
                            }
                            case -430914369: {
                                if (!var0.equals("Pixi4-7_3G")) break;
                                var1_4 = 105;
                                break block176;
                            }
                            case -521118391: {
                                if (!var0.equals("GIONEE_GBL7360")) break;
                                var1_4 = 53;
                                break block176;
                            }
                            case -575125681: {
                                if (!var0.equals("GiONEE_CBL7513")) break;
                                var1_4 = 51;
                                break block176;
                            }
                            case -782144577: {
                                if (!var0.equals("OnePlus5T")) break;
                                var1_4 = 91;
                                break block176;
                            }
                            case -788334647: {
                                if (!var0.equals("whyred")) break;
                                var1_4 = 132;
                                break block176;
                            }
                            case -794946968: {
                                if (!var0.equals("watson")) break;
                                var1_4 = 131;
                                break block176;
                            }
                            case -797483286: {
                                if (!var0.equals("SVP-DTV15")) break;
                                var1_4 = 119;
                                break block176;
                            }
                            case -821392978: {
                                if (!var0.equals("A7000-a")) break;
                                var1_4 = 9;
                                break block176;
                            }
                            case -842500323: {
                                if (!var0.equals("nicklaus_f")) break;
                                var1_4 = 88;
                                break block176;
                            }
                            case -879245230: {
                                if (!var0.equals("tcl_eu")) break;
                                var1_4 = 126;
                                break block176;
                            }
                            case -958336948: {
                                if (!var0.equals("ELUGA_Ray_X")) break;
                                var1_4 = 34;
                                break block176;
                            }
                            case -965403638: {
                                if (!var0.equals("s905x018")) break;
                                var1_4 = 120;
                                break block176;
                            }
                            case -993250458: {
                                if (!var0.equals("A10-70L")) break;
                                var1_4 = 6;
                                break block176;
                            }
                            case -993250464: {
                                if (!var0.equals("A10-70F")) break;
                                var1_4 = 5;
                                break block176;
                            }
                            case -1052835013: {
                                if (!var0.equals("namath")) break;
                                var1_4 = 87;
                                break block176;
                            }
                            case -1139198265: {
                                if (!var0.equals("Slate_Pro")) break;
                                var1_4 = 118;
                                break block176;
                            }
                            case -1180384755: {
                                if (!var0.equals("iris60")) break;
                                var1_4 = 70;
                                break block176;
                            }
                            case -1217592143: {
                                if (!var0.equals("BRAVIA_ATV2")) break;
                                var1_4 = 18;
                                break block176;
                            }
                            case -1320080169: {
                                if (!var0.equals("GiONEE_GBL7319")) break;
                                var1_4 = 52;
                                break block176;
                            }
                            case -1481772729: {
                                if (!var0.equals("panell_dt")) break;
                                var1_4 = 99;
                                break block176;
                            }
                            case -1481772730: {
                                if (!var0.equals("panell_ds")) break;
                                var1_4 = 98;
                                break block176;
                            }
                            case -1481772737: {
                                if (!var0.equals("panell_dl")) break;
                                var1_4 = 97;
                                break block176;
                            }
                            case -1554255044: {
                                if (!var0.equals("vernee_M5")) break;
                                var1_4 = 130;
                                break block176;
                            }
                            case -1600724499: {
                                if (!var0.equals("pacificrim")) break;
                                var1_4 = 95;
                                break block176;
                            }
                            case -1615810839: {
                                if (!var0.equals("Phantom6")) break;
                                var1_4 = 104;
                                break block176;
                            }
                            case -1680025915: {
                                if (!var0.equals("ComioS1")) break;
                                var1_4 = 21;
                                break block176;
                            }
                            case -1696512866: {
                                if (!var0.equals("XT1663")) break;
                                var1_4 = 137;
                                break block176;
                            }
                            case -1885099851: {
                                if (!var0.equals("RAIJIN")) break;
                                var1_4 = 116;
                                break block176;
                            }
                            case -1931988508: {
                                if (!var0.equals("AquaPowerM")) break;
                                var1_4 = 13;
                                break block176;
                            }
                            case -1936688065: {
                                if (!var0.equals("PGN611")) break;
                                var1_4 = 103;
                                break block176;
                            }
                            case -1936688066: {
                                if (!var0.equals("PGN610")) break;
                                var1_4 = 102;
                                break block176;
                            }
                            case -1936688988: {
                                if (!var0.equals("PGN528")) break;
                                var1_4 = 101;
                                break block176;
                            }
                            case -1978990237: {
                                if (!var0.equals("NX573J")) break;
                                var1_4 = 90;
                                break block176;
                            }
                            case -1978993182: {
                                if (!var0.equals("NX541J")) break;
                                var1_4 = 89;
                                break block176;
                            }
                            case -2022874474: {
                                if (!var0.equals("CP8676_I02")) break;
                                var1_4 = 22;
                                break block176;
                            }
                            case -2097309513: {
                                if (!var0.equals("K50a40")) break;
                                var1_4 = 74;
                                break block176;
                            }
                            case -2144781160: {
                                if (!var0.equals("GIONEE_SWW1631")) break;
                                var1_4 = 56;
                                break block176;
                            }
                            case -2144781185: {
                                if (!var0.equals("GIONEE_SWW1627")) break;
                                var1_4 = 55;
                                break block176;
                            }
                            case -2144781245: {
                                if (!var0.equals("GIONEE_SWW1609")) break;
                                var1_4 = 54;
                                break block176;
                            }
                        }
                        var1_4 = -1;
                    }
                    switch (var1_4) {
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
                        case 31: 
                        case 32: 
                        case 33: 
                        case 34: 
                        case 35: 
                        case 36: 
                        case 37: 
                        case 38: 
                        case 39: 
                        case 40: 
                        case 41: 
                        case 42: 
                        case 43: 
                        case 44: 
                        case 45: 
                        case 46: 
                        case 47: 
                        case 48: 
                        case 49: 
                        case 50: 
                        case 51: 
                        case 52: 
                        case 53: 
                        case 54: 
                        case 55: 
                        case 56: 
                        case 57: 
                        case 58: 
                        case 59: 
                        case 60: 
                        case 61: 
                        case 62: 
                        case 63: 
                        case 64: 
                        case 65: 
                        case 66: 
                        case 67: 
                        case 68: 
                        case 69: 
                        case 70: 
                        case 71: 
                        case 72: 
                        case 73: 
                        case 74: 
                        case 75: 
                        case 76: 
                        case 77: 
                        case 78: 
                        case 79: 
                        case 80: 
                        case 81: 
                        case 82: 
                        case 83: 
                        case 84: 
                        case 85: 
                        case 86: 
                        case 87: 
                        case 88: 
                        case 89: 
                        case 90: 
                        case 91: 
                        case 92: 
                        case 93: 
                        case 94: 
                        case 95: 
                        case 96: 
                        case 97: 
                        case 98: 
                        case 99: 
                        case 100: 
                        case 101: 
                        case 102: 
                        case 103: 
                        case 104: 
                        case 105: 
                        case 106: 
                        case 107: 
                        case 108: 
                        case 109: 
                        case 110: 
                        case 111: 
                        case 112: 
                        case 113: 
                        case 114: 
                        case 115: 
                        case 116: 
                        case 117: 
                        case 118: 
                        case 119: 
                        case 120: 
                        case 121: 
                        case 122: 
                        case 123: 
                        case 124: 
                        case 125: 
                        case 126: 
                        case 127: 
                        case 128: 
                        case 129: 
                        case 130: 
                        case 131: 
                        case 132: 
                        case 133: 
                        case 134: 
                        case 135: 
                        case 136: 
                        case 137: 
                        case 138: 
                        case 139: {
                            ** GOTO lbl-1000
                        }
                    }
                    {
                        var0 = zzamq.zzd;
                        var1_4 = var0.hashCode();
                        if (var1_4 != -594534941) {
                            if (var1_4 != 2006354) {
                                if (var1_4 != 2006367) {
                                    var1_4 = var2_6;
                                } else {
                                    var1_4 = var2_6;
                                    if (var0.equals("AFTN")) {
                                        var1_4 = 1;
                                    }
                                }
                            } else {
                                var1_4 = var2_6;
                                if (var0.equals("AFTA")) {
                                    var1_4 = 0;
                                }
                            }
                        } else {
                            var1_4 = var2_6;
                            if (var0.equals("JSN-L21")) {
                                var1_4 = 2;
                            }
                        }
                        if (var1_4 != 0 && var1_4 != 1 && var1_4 != 2) ** break;
                        ** continue;
                        var4_2 = var5_3;
                    }
                }
                zzlz.zzd = var4_2;
                zzlz.zzc = true;
                return zzlz.zzd;
                throw var0_1;
            }
        }
    }

    protected static int zzy(zzfo zzfo2, zzafv zzafv2) {
        if (zzafv2.zzm == -1) return zzlz.zzaF(zzfo2, zzafv2);
        int n = zzafv2.zzn.size();
        int n2 = 0;
        int n3 = 0;
        while (n2 < n) {
            n3 += ((byte[])zzafv2.zzn.get(n2)).length;
            ++n2;
        }
        return zzafv2.zzm + n3;
    }

    protected final void zzA(zzgh zzgh2, int n, long l) {
        this.zzaC();
        zzamo.zza((String)"releaseOutputBuffer");
        zzgh2.zzh(n, true);
        zzamo.zzb();
        this.zzz = SystemClock.elapsedRealtime() * 1000L;
        zzgh2 = this.zza;
        ++zzgh2.zze;
        this.zzw = 0;
        this.zzp();
    }

    protected final void zzB(zzaf zzaf2) throws zzaeg {
        ++this.zzx;
        int n = zzamq.zza;
    }

    protected final void zzC() {
        this.zzp = false;
        int n = zzamq.zza;
    }

    public final void zzE(int n, Object object) throws zzaeg {
        if (n != 1) {
            if (n == 7) {
                this.zzI = (zzma)object;
                return;
            }
            if (n == 10) {
                n = (Integer)object;
                if (this.zzH == n) return;
                this.zzH = n;
                return;
            }
            if (n == 4) {
                this.zzo = (Integer)object;
                object = this.zzZ();
                if (object == null) return;
                object.zzn(this.zzo);
                return;
            }
            if (n != 5) return;
            this.zzf.zza(((Integer)object).intValue());
            return;
        }
        Surface surface = object instanceof Surface ? (Surface)object : null;
        object = surface;
        if (surface == null && (object = this.zzm) == null) {
            zzfo zzfo2 = this.zzK();
            object = surface;
            if (zzfo2 != null) {
                object = surface;
                if (this.zzaB(zzfo2)) {
                    object = zzlu.zzb((Context)this.zze, (boolean)zzfo2.zzf);
                    this.zzm = object;
                }
            }
        }
        if (this.zzl != object) {
            this.zzl = object;
            this.zzf.zzd((Surface)object);
            this.zzn = false;
            n = this.zzaf();
            surface = this.zzZ();
            if (surface != null) {
                if (zzamq.zza >= 23 && object != null && !this.zzj) {
                    surface.zzl((Surface)object);
                } else {
                    this.zzN();
                    this.zzI();
                }
            }
            if (object != null && object != this.zzm) {
                this.zzaD();
                this.zzp = false;
                int n2 = zzamq.zza;
                if (n != 2) return;
                this.zzt = -9223372036854775807L;
                return;
            }
            this.zzG = null;
            this.zzp = false;
            n = zzamq.zza;
            return;
        }
        if (object == null) return;
        if (object == this.zzm) return;
        this.zzaD();
        if (!this.zzn) return;
        this.zzg.zzg((Object)this.zzl);
    }

    protected final boolean zzF(long l, long l2, zzgh zzgh2, ByteBuffer byteBuffer, int n, int n2, int n3, long l3, boolean bl, boolean bl2, zzafv zzafv2) throws zzaeg {
        long l4;
        if (zzgh2 == null) throw null;
        if (this.zzs == -9223372036854775807L) {
            this.zzs = l;
        }
        if (l3 != this.zzy) {
            this.zzf.zzh(l3);
            this.zzy = l3;
        }
        long l5 = this.zzX();
        long l6 = l3 - l5;
        if (bl && !bl2) {
            this.zzz(zzgh2, n, l6);
            return true;
        }
        float f = this.zzW();
        n3 = this.zzaf();
        long l7 = SystemClock.elapsedRealtime() * 1000L;
        double d = l3 - l;
        double d2 = f;
        Double.isNaN(d);
        Double.isNaN(d2);
        l3 = l4 = (long)(d / d2);
        if (n3 == 2) {
            l3 = l4 - (l7 - l2);
        }
        if (this.zzl == this.zzm) {
            if (!zzlz.zzaE(l3)) return false;
            this.zzz(zzgh2, n, l6);
            this.zzb(l3);
            return true;
        }
        l2 = this.zzz;
        n2 = (!this.zzr ? n3 == 2 || this.zzq : !this.zzp) ? 1 : 0;
        if (this.zzt == -9223372036854775807L && l >= l5 && (n2 != 0 || n3 == 2 && zzlz.zzaE(l3) && l7 - l2 > 100000L)) {
            l = System.nanoTime();
            if (zzamq.zza >= 21) {
                this.zzaa(zzgh2, n, l6, l);
            } else {
                this.zzA(zzgh2, n, l6);
            }
            this.zzb(l3);
            return true;
        }
        if (n3 != 2) return false;
        if (l == this.zzs) {
            return false;
        }
        l4 = System.nanoTime();
        l2 = this.zzf.zzk(l3 * 1000L + l4);
        l3 = (l2 - l4) / 1000L;
        l4 = this.zzt;
        if (l3 < -500000L && !bl2 && (n2 = this.zzay(l)) != 0) {
            zzgh2 = this.zza;
            ++zzgh2.zzi;
            n = this.zzx + n2;
            if (l4 != -9223372036854775807L) {
                zzgh2.zzf += n;
            } else {
                this.zza(n);
            }
            this.zzP();
            return false;
        }
        if (zzlz.zzaE(l3) && !bl2) {
            if (l4 != -9223372036854775807L) {
                this.zzz(zzgh2, n, l6);
            } else {
                zzamo.zza((String)"dropVideoBuffer");
                zzgh2.zzh(n, false);
                zzamo.zzb();
                this.zza(1);
            }
            this.zzb(l3);
            return true;
        }
        if (zzamq.zza >= 21) {
            if (l3 >= 50000L) return false;
            this.zzaa(zzgh2, n, l6, l2);
            this.zzb(l3);
            return true;
        }
        if (l3 >= 30000L) return false;
        if (l3 > 11000L) {
            try {
                Thread.sleep((-10000L + l3) / 1000L);
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        this.zzA(zzgh2, n, l6);
        this.zzb(l3);
        return true;
    }

    protected final boolean zzJ(zzfo zzfo2) {
        if (this.zzl != null) return true;
        if (!this.zzaB(zzfo2)) return false;
        return true;
    }

    public final void zzM(float f, float f2) throws zzaeg {
        super.zzM(f, f2);
        this.zzf.zzf(f);
    }

    protected final void zzR() {
        super.zzR();
        this.zzx = 0;
    }

    protected final zzfn zzT(Throwable throwable, zzfo zzfo2) {
        return new zzlx(throwable, zzfo2, this.zzl);
    }

    protected final void zzU(zzaf object) throws zzaeg {
        if (!this.zzk) {
            return;
        }
        ByteBuffer byteBuffer = object.zze;
        if (byteBuffer == null) throw null;
        if (byteBuffer.remaining() < 7) return;
        byte by = byteBuffer.get();
        short s = byteBuffer.getShort();
        short s2 = byteBuffer.getShort();
        byte by2 = byteBuffer.get();
        byte by3 = byteBuffer.get();
        byteBuffer.position(0);
        if (by != -75) return;
        if (s != 60) return;
        if (s2 != 1) return;
        if (by2 != 4) return;
        if (by3 != 0) return;
        object = new byte[byteBuffer.remaining()];
        byteBuffer.get((byte[])object);
        byteBuffer.position(0);
        byteBuffer = this.zzZ();
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", (byte[])object);
        byteBuffer.zzm(bundle);
    }

    protected final void zzV(long l) {
        super.zzV(l);
        --this.zzx;
    }

    protected final void zza(int n) {
        zzaz zzaz2 = this.zza;
        zzaz2.zzg += n;
        this.zzv += n;
        this.zzw = n = this.zzw + n;
        zzaz2.zzh = Math.max(n, zzaz2.zzh);
    }

    protected final void zzaa(zzgh zzgh2, int n, long l, long l2) {
        this.zzaC();
        zzamo.zza((String)"releaseOutputBuffer");
        zzgh2.zzi(n, l2);
        zzamo.zzb();
        this.zzz = SystemClock.elapsedRealtime() * 1000L;
        zzgh2 = this.zza;
        ++zzgh2.zze;
        this.zzw = 0;
        this.zzp();
    }

    protected final void zzb(long l) {
        zzaz zzaz2 = this.zza;
        zzaz2.zzj += l;
        ++zzaz2.zzk;
        this.zzA += l;
        ++this.zzB;
    }

    public final String zzc() {
        return "MediaCodecVideoRenderer";
    }

    protected final int zzd(zzfs object, zzafv zzafv2) throws zzfy {
        zzfo zzfo2;
        boolean bl = zzalt.zzb((String)zzafv2.zzl);
        int n = 0;
        if (!bl) {
            return 0;
        }
        bl = zzafv2.zzo != null;
        zzfo zzfo3 = zzfo2 = zzlz.zzaA((zzfs)object, zzafv2, bl, false);
        if (bl) {
            zzfo3 = zzfo2;
            if (zzfo2.isEmpty()) {
                zzfo3 = zzlz.zzaA((zzfs)object, zzafv2, false, false);
            }
        }
        if (zzfo3.isEmpty()) {
            return 1;
        }
        if (!zzlz.zzY((zzafv)zzafv2)) {
            return 2;
        }
        zzfo3 = zzfo3.get(0);
        boolean bl2 = zzfo3.zzc(zzafv2);
        int n2 = true != zzfo3.zzd(zzafv2) ? 8 : 16;
        int n3 = n;
        if (bl2) {
            object = zzlz.zzaA((zzfs)object, zzafv2, bl, true);
            n3 = n;
            if (!object.isEmpty()) {
                object = (zzfo)object.get(0);
                n3 = n;
                if (object.zzc(zzafv2)) {
                    n3 = n;
                    if (object.zzd(zzafv2)) {
                        n3 = 32;
                    }
                }
            }
        }
        n = true != bl2 ? 3 : 4;
        return n | n2 | n3;
    }

    protected final List<zzfo> zze(zzfs zzfs2, zzafv zzafv2, boolean bl) throws zzfy {
        return zzlz.zzaA(zzfs2, zzafv2, false, false);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    protected final zzfl zzg(zzfo zzfo2, zzafv zzafv2, MediaCrypto object, float f) {
        Pair pair;
        float f2;
        object = this.zzm;
        if (object != null && ((zzlu)object).zza != zzfo2.zzf) {
            object.release();
            this.zzm = null;
        }
        String string = zzfo2.zzc;
        zzafv[] zzafvArray = this.zzau();
        int n = zzafv2.zzq;
        int n2 = zzafv2.zzr;
        int n3 = zzlz.zzy(zzfo2, zzafv2);
        int n4 = zzafvArray.length;
        if (n4 == 1) {
            int n5 = n3;
            if (n3 != -1) {
                int n6 = zzlz.zzaF(zzfo2, zzafv2);
                n5 = n3;
                if (n6 != -1) {
                    n5 = Math.min((int)((float)n3 * 1.5f), n6);
                }
            }
            object = new zzly(n, n2, n5);
        } else {
            int n7;
            int n8;
            int n9;
            Object object2;
            int n10 = 0;
            int n11 = n2;
            for (object2 = 0; object2 < n4; ++object2) {
                zzafv zzafv3 = zzafvArray[object2];
                object = zzafv3;
                if (zzafv2.zzx != null) {
                    object = zzafv3;
                    if (zzafv3.zzx == null) {
                        object = zzafv3.zza();
                        object.zzZ(zzafv2.zzx);
                        object = object.zzah();
                    }
                }
                n9 = n;
                n8 = n11;
                n7 = n3;
                n2 = n10;
                if (zzfo2.zze((zzafv)zzafv2, (zzafv)object).zzd != 0) {
                    n7 = ((zzafv)object).zzq;
                    n2 = n7 != -1 && ((zzafv)object).zzr != -1 ? 0 : 1;
                    n2 = n10 | n2;
                    n9 = Math.max(n, n7);
                    n8 = Math.max(n11, ((zzafv)object).zzr);
                    n7 = Math.max(n3, zzlz.zzy(zzfo2, (zzafv)object));
                }
                n = n9;
                n11 = n8;
                n3 = n7;
                n10 = n2;
            }
            if (n10 != 0) {
                String string2;
                block25: {
                    object = new StringBuilder(66);
                    ((StringBuilder)object).append("Resolutions unknown. Codec max resolution: ");
                    ((StringBuilder)object).append(n);
                    ((StringBuilder)object).append("x");
                    ((StringBuilder)object).append(n11);
                    object = ((StringBuilder)object).toString();
                    string2 = "MediaCodecVideoRenderer";
                    Log.w((String)"MediaCodecVideoRenderer", (String)object);
                    n2 = zzafv2.zzr;
                    n7 = zzafv2.zzq;
                    object2 = n2 > n7 ? n2 : n7;
                    n10 = n2 <= n7 ? n2 : n7;
                    float f3 = (float)n10 / (float)object2;
                    object = zzb;
                    for (n8 = 0; n8 < 9; ++n8) {
                        Object object3;
                        Object object4 = object[n8];
                        n9 = (int)((float)object4 * f3);
                        if (object4 <= object2 || n9 <= n10) break;
                        if (zzamq.zza >= 21) {
                            object3 = n2 <= n7 ? object4 : (Object)n9;
                            if (n2 <= n7) {
                                object4 = n9;
                            }
                            Point point = zzfo2.zzg((int)object3, (int)object4);
                            f2 = zzafv2.zzs;
                            if (!zzfo2.zzf(point.x, point.y, (double)f2)) continue;
                            object = point;
                            break block25;
                        }
                        try {
                            int n12;
                            object3 = zzamq.zzw((int)object4, (int)16) * 16;
                            n9 = zzamq.zzw((int)n9, (int)16) * 16;
                            if (object3 * n9 > zzge.zze()) continue;
                            object2 = n2 <= n7 ? (Object)object3 : n9;
                            if (n2 <= n7) {
                                n12 = n9;
                            }
                            object = new Point(object2, n12);
                        }
                        catch (zzfy zzfy2) {}
                        break;
                    }
                    object = null;
                }
                if (object != null) {
                    n = Math.max(n, ((Point)object).x);
                    n11 = Math.max(n11, ((Point)object).y);
                    object = zzafv2.zza();
                    object.zzS(n);
                    object.zzT(n11);
                    n3 = Math.max(n3, zzlz.zzaF(zzfo2, object.zzah()));
                    object = new StringBuilder(57);
                    ((StringBuilder)object).append("Codec max resolution adjusted to: ");
                    ((StringBuilder)object).append(n);
                    ((StringBuilder)object).append("x");
                    ((StringBuilder)object).append(n11);
                    Log.w((String)string2, (String)((StringBuilder)object).toString());
                }
            }
            object = new zzly(n, n11, n3);
        }
        this.zzi = object;
        boolean bl = this.zzh;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", string);
        mediaFormat.setInteger("width", zzafv2.zzq);
        mediaFormat.setInteger("height", zzafv2.zzr);
        zzalq.zza((MediaFormat)mediaFormat, (List)zzafv2.zzn);
        f2 = zzafv2.zzs;
        if (f2 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f2);
        }
        zzalq.zzb((MediaFormat)mediaFormat, (String)"rotation-degrees", (int)zzafv2.zzt);
        zzj zzj2 = zzafv2.zzx;
        if (zzj2 != null) {
            zzalq.zzb((MediaFormat)mediaFormat, (String)"color-transfer", (int)zzj2.zzc);
            zzalq.zzb((MediaFormat)mediaFormat, (String)"color-standard", (int)zzj2.zza);
            zzalq.zzb((MediaFormat)mediaFormat, (String)"color-range", (int)zzj2.zzb);
            byte[] byArray = zzj2.zzd;
            if (byArray != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(byArray));
            }
        }
        if ("video/dolby-vision".equals(zzafv2.zzl) && (pair = zzge.zzf((zzafv)zzafv2)) != null) {
            zzalq.zzb((MediaFormat)mediaFormat, (String)"profile", (int)((Integer)pair.first));
        }
        mediaFormat.setInteger("max-width", ((zzly)object).zza);
        mediaFormat.setInteger("max-height", ((zzly)object).zzb);
        zzalq.zzb((MediaFormat)mediaFormat, (String)"max-input-size", (int)((zzly)object).zzc);
        if (zzamq.zza >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (bl) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (this.zzl != null) return zzfl.zzb((zzfo)zzfo2, (MediaFormat)mediaFormat, (zzafv)zzafv2, (Surface)this.zzl, null);
        if (!this.zzaB(zzfo2)) throw new IllegalStateException();
        if (this.zzm == null) {
            this.zzm = zzlu.zzb((Context)this.zze, (boolean)zzfo2.zzf);
        }
        this.zzl = this.zzm;
        return zzfl.zzb((zzfo)zzfo2, (MediaFormat)mediaFormat, (zzafv)zzafv2, (Surface)this.zzl, null);
    }

    protected final zzba zzh(zzfo object, zzafv zzafv2, zzafv zzafv3) {
        int n;
        int n2;
        zzba zzba2;
        block7: {
            block6: {
                zzba2 = object.zze(zzafv2, zzafv3);
                n2 = zzba2.zze;
                n = zzafv3.zzq;
                zzly zzly2 = this.zzi;
                if (n > zzly2.zza) break block6;
                n = n2;
                if (zzafv3.zzr <= zzly2.zzb) break block7;
            }
            n = n2 | 0x100;
        }
        n2 = n;
        if (zzlz.zzy(object, zzafv3) > this.zzi.zzc) {
            n2 = n | 0x40;
        }
        object = object.zza;
        if (n2 != 0) {
            n = n2;
            n2 = 0;
        } else {
            n2 = zzba2.zzd;
            n = 0;
        }
        return new zzba((String)object, zzafv2, zzafv3, n2, n);
    }

    protected final float zzj(float f, zzafv zzafv2, zzafv[] zzafvArray) {
        int n = zzafvArray.length;
        int n2 = 0;
        float f2 = -1.0f;
        while (true) {
            if (n2 >= n) {
                if (f2 != -1.0f) return f2 * f;
                return -1.0f;
            }
            float f3 = zzafvArray[n2].zzs;
            float f4 = f2;
            if (f3 != -1.0f) {
                f4 = Math.max(f2, f3);
            }
            ++n2;
            f2 = f4;
        }
    }

    protected final void zzk(String codecProfileLevelArray, long l, long l2) {
        boolean bl;
        this.zzg.zzb((String)codecProfileLevelArray, l, l2);
        this.zzj = zzlz.zzab((String)codecProfileLevelArray);
        codecProfileLevelArray = this.zzK();
        if (codecProfileLevelArray == null) throw null;
        int n = zzamq.zza;
        boolean bl2 = bl = false;
        if (n >= 29) {
            bl2 = bl;
            if ("video/x-vnd.on2.vp9".equals(codecProfileLevelArray.zzb)) {
                codecProfileLevelArray = codecProfileLevelArray.zzb();
                int n2 = codecProfileLevelArray.length;
                n = 0;
                while (true) {
                    bl2 = bl;
                    if (n >= n2) break;
                    if (codecProfileLevelArray[n].profile == 16384) {
                        bl2 = true;
                        break;
                    }
                    ++n;
                }
            }
        }
        this.zzk = bl2;
    }

    protected final void zzl(String string) {
        this.zzg.zzh(string);
    }

    protected final void zzm(Exception exception) {
        zzaln.zzb((String)"MediaCodecVideoRenderer", (String)"Video codec error", (Throwable)exception);
        this.zzg.zzj(exception);
    }

    protected final zzba zzn(zzafw zzafw2) throws zzaeg {
        zzba zzba2 = super.zzn(zzafw2);
        this.zzg.zzc(zzafw2.zza, zzba2);
        return zzba2;
    }

    protected final void zzo(zzafv zzafv2, MediaFormat mediaFormat) {
        int n;
        zzgh zzgh2 = this.zzZ();
        if (zzgh2 != null) {
            zzgh2.zzn(this.zzo);
        }
        if (mediaFormat == null) throw null;
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
        this.zzC = n;
        n2 = n2 != 0 ? mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top") + 1 : mediaFormat.getInteger("height");
        this.zzD = n2;
        this.zzF = zzafv2.zzu;
        if (zzamq.zza >= 21) {
            n2 = zzafv2.zzt;
            if (n2 == 90 || n2 == 270) {
                n2 = this.zzC;
                this.zzC = this.zzD;
                this.zzD = n2;
                this.zzF = 1.0f / this.zzF;
            }
        } else {
            this.zzE = zzafv2.zzt;
        }
        this.zzf.zzg(zzafv2.zzs);
    }

    final void zzp() {
        this.zzr = true;
        if (this.zzp) return;
        this.zzp = true;
        this.zzg.zzg((Object)this.zzl);
        this.zzn = true;
    }

    protected final void zzq(boolean bl, boolean bl2) throws zzaeg {
        super.zzq(bl, bl2);
        this.zzav();
        this.zzg.zza(this.zza);
        this.zzf.zzb();
        this.zzq = bl2;
        this.zzr = false;
    }

    protected final void zzr(long l, boolean bl) throws zzaeg {
        super.zzr(l, bl);
        this.zzp = false;
        int n = zzamq.zza;
        this.zzf.zze();
        this.zzy = -9223372036854775807L;
        this.zzs = -9223372036854775807L;
        this.zzw = 0;
        this.zzt = -9223372036854775807L;
    }

    protected final void zzs() {
        this.zzv = 0;
        this.zzu = SystemClock.elapsedRealtime();
        this.zzz = SystemClock.elapsedRealtime() * 1000L;
        this.zzA = 0L;
        this.zzB = 0;
        this.zzf.zzc();
    }

    protected final void zzt() {
        int n;
        this.zzt = -9223372036854775807L;
        if (this.zzv > 0) {
            long l = SystemClock.elapsedRealtime();
            long l2 = this.zzu;
            this.zzg.zzd(this.zzv, l - l2);
            this.zzv = 0;
            this.zzu = l;
        }
        if ((n = this.zzB) != 0) {
            this.zzg.zze(this.zzA, n);
            this.zzA = 0L;
            this.zzB = 0;
        }
        this.zzf.zzi();
    }

    protected final void zzu() {
        this.zzG = null;
        this.zzp = false;
        int n = zzamq.zza;
        this.zzn = false;
        this.zzf.zzj();
        try {
            super.zzu();
            return;
        }
        finally {
            this.zzg.zzi(this.zza);
        }
    }

    protected final void zzv() {
        try {
            super.zzv();
            return;
        }
        finally {
            zzlu zzlu2 = this.zzm;
            if (zzlu2 != null) {
                if (this.zzl == zzlu2) {
                    this.zzl = null;
                }
                zzlu2.release();
                this.zzm = null;
            }
        }
    }

    public final boolean zzx() {
        zzlu zzlu2;
        if (super.zzx() && (this.zzp || (zzlu2 = this.zzm) != null && this.zzl == zzlu2 || this.zzZ() == null)) {
            this.zzt = -9223372036854775807L;
            return true;
        }
        if (this.zzt == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.zzt) {
            return true;
        }
        this.zzt = -9223372036854775807L;
        return false;
    }

    protected final void zzz(zzgh zzgh2, int n, long l) {
        zzamo.zza((String)"skipVideoBuffer");
        zzgh2.zzh(n, false);
        zzamo.zzb();
        zzgh2 = this.zza;
        ++zzgh2.zzf;
    }
}
