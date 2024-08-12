/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzalt
 *  com.google.android.gms.internal.ads.zznu
 *  com.google.android.gms.internal.ads.zzoa
 *  com.google.android.gms.internal.ads.zzpe
 *  com.google.android.gms.internal.ads.zzpk
 *  com.google.android.gms.internal.ads.zzpn
 *  com.google.android.gms.internal.ads.zzps
 *  com.google.android.gms.internal.ads.zzqi
 *  com.google.android.gms.internal.ads.zzqq
 *  com.google.android.gms.internal.ads.zzrk
 *  com.google.android.gms.internal.ads.zzrp
 *  com.google.android.gms.internal.ads.zzse
 *  com.google.android.gms.internal.ads.zzsq
 *  com.google.android.gms.internal.ads.zzst
 *  com.google.android.gms.internal.ads.zzsw
 *  com.google.android.gms.internal.ads.zztz
 *  com.google.android.gms.internal.ads.zzuj
 *  com.google.android.gms.internal.ads.zzuv
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzalt;
import com.google.android.gms.internal.ads.zznu;
import com.google.android.gms.internal.ads.zzoa;
import com.google.android.gms.internal.ads.zzpe;
import com.google.android.gms.internal.ads.zzpk;
import com.google.android.gms.internal.ads.zzpn;
import com.google.android.gms.internal.ads.zzps;
import com.google.android.gms.internal.ads.zzqi;
import com.google.android.gms.internal.ads.zzqq;
import com.google.android.gms.internal.ads.zzrk;
import com.google.android.gms.internal.ads.zzrp;
import com.google.android.gms.internal.ads.zzse;
import com.google.android.gms.internal.ads.zzsq;
import com.google.android.gms.internal.ads.zzst;
import com.google.android.gms.internal.ads.zzsw;
import com.google.android.gms.internal.ads.zztz;
import com.google.android.gms.internal.ads.zzuj;
import com.google.android.gms.internal.ads.zzuv;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class zznq
implements zzoa {
    private static final int[] zza;
    private static final Constructor<? extends zznu> zzc;

    static {
        Constructor<zznu> constructor;
        zza = new int[]{5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 14};
        Constructor<zznu> constructor2 = constructor = null;
        try {
            if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
                constructor2 = Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(zznu.class).getConstructor(Integer.TYPE);
            }
        }
        catch (Exception exception) {
            throw new RuntimeException("Error instantiating FLAC extension", exception);
        }
        catch (ClassNotFoundException classNotFoundException) {
            constructor2 = constructor;
        }
        zzc = constructor2;
    }

    private static final void zzb(int n, List<zznu> list) {
        switch (n) {
            default: {
                return;
            }
            case 14: {
                list.add((zznu)new zzps());
                return;
            }
            case 12: {
                list.add((zznu)new zzuv());
                return;
            }
            case 11: {
                list.add((zznu)new zzuj(1, 0, 112800));
                return;
            }
            case 10: {
                list.add((zznu)new zztz());
                return;
            }
            case 9: {
                list.add((zznu)new zzse());
                return;
            }
            case 8: {
                list.add((zznu)new zzrk(0, null));
                list.add((zznu)new zzrp(0));
                return;
            }
            case 7: {
                list.add((zznu)new zzqq(0));
                return;
            }
            case 6: {
                list.add((zznu)new zzqi(0));
                return;
            }
            case 5: {
                list.add((zznu)new zzpn());
                return;
            }
            case 4: {
                Constructor<? extends zznu> constructor = zzc;
                if (constructor == null) {
                    list.add((zznu)new zzpk(0));
                    return;
                }
                try {
                    list.add(constructor.newInstance(0));
                    return;
                }
                catch (Exception exception) {
                    throw new IllegalStateException("Unexpected error creating FLAC extractor", exception);
                }
            }
            case 3: {
                list.add((zznu)new zzpe(0));
                return;
            }
            case 2: {
                list.add((zznu)new zzsw(0));
                return;
            }
            case 1: {
                list.add((zznu)new zzst());
                return;
            }
            case 0: 
        }
        list.add((zznu)new zzsq());
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    public final zznu[] zza(Uri var1_1, Map<String, List<String>> var2_3) {
        synchronized (this) {
            block87: {
                block88: {
                    var8_4 = new ArrayList<zznu>(14);
                    var9_5 = var2_3.get("Content-Type");
                    var7_6 = null;
                    var2_3 = var7_6;
                    if (var9_5 != null) {
                        var2_3 = var9_5.isEmpty() != false ? var7_6 : var9_5.get(0);
                    }
                    var5_7 = 10;
                    if (var2_3 == null) lbl-1000:
                    // 2 sources

                    {
                        while (true) {
                            var4_9 = -1;
                            break block87;
                            break;
                        }
                    }
                    var2_3 = zzalt.zzg(var2_3);
                    switch (var2_3.hashCode()) {
                        default: {
                            break;
                        }
                        case 2039520277: {
                            if (!var2_3.equals("video/x-matroska")) break;
                            var3_8 = 9;
                            break block88;
                        }
                        case 1505118770: {
                            if (!var2_3.equals("audio/webm")) break;
                            var3_8 = 12;
                            break block88;
                        }
                        case 1504831518: {
                            if (!var2_3.equals("audio/mpeg")) break;
                            var3_8 = 14;
                            break block88;
                        }
                        case 1504619009: {
                            if (!var2_3.equals("audio/flac")) break;
                            var3_8 = 7;
                            break block88;
                        }
                        case 1504578661: {
                            if (!var2_3.equals("audio/eac3")) break;
                            var3_8 = 1;
                            break block88;
                        }
                        case 1503095341: {
                            if (!var2_3.equals("audio/3gpp")) break;
                            var3_8 = 5;
                            break block88;
                        }
                        case 1331848029: {
                            if (!var2_3.equals("video/mp4")) break;
                            var3_8 = 15;
                            break block88;
                        }
                        case 187099443: {
                            if (!var2_3.equals("audio/wav")) break;
                            var3_8 = 21;
                            break block88;
                        }
                        case 187091926: {
                            if (!var2_3.equals("audio/ogg")) break;
                            var3_8 = 18;
                            break block88;
                        }
                        case 187090232: {
                            if (!var2_3.equals("audio/mp4")) break;
                            var3_8 = 16;
                            break block88;
                        }
                        case 187078669: {
                            if (!var2_3.equals("audio/amr")) break;
                            var3_8 = 4;
                            break block88;
                        }
                        case 187078297: {
                            if (!var2_3.equals("audio/ac4")) break;
                            var3_8 = 3;
                            break block88;
                        }
                        case 187078296: {
                            if (!var2_3.equals("audio/ac3")) break;
                            var3_8 = 0;
                            break block88;
                        }
                        case 13915911: {
                            if (!var2_3.equals("video/x-flv")) break;
                            var3_8 = 8;
                            break block88;
                        }
                        case -43467528: {
                            if (!var2_3.equals("application/webm")) break;
                            var3_8 = 13;
                            break block88;
                        }
                        case -387023398: {
                            if (!var2_3.equals("audio/x-matroska")) break;
                            var3_8 = 10;
                            break block88;
                        }
                        case -1004728940: {
                            if (!var2_3.equals("text/vtt")) break;
                            var3_8 = 22;
                            break block88;
                        }
                        case -1248337486: {
                            if (!var2_3.equals("application/mp4")) break;
                            var3_8 = 17;
                            break block88;
                        }
                        case -1487394660: {
                            if (!var2_3.equals("image/jpeg")) break;
                            var3_8 = 23;
                            break block88;
                        }
                        case -1606874997: {
                            if (!var2_3.equals("audio/amr-wb")) break;
                            var3_8 = 6;
                            break block88;
                        }
                        case -1662095187: {
                            if (!var2_3.equals("video/webm")) break;
                            var3_8 = 11;
                            break block88;
                        }
                        case -1662384007: {
                            if (!var2_3.equals("video/mp2t")) break;
                            var3_8 = 20;
                            break block88;
                        }
                        case -1662384011: {
                            if (!var2_3.equals("video/mp2p")) break;
                            var3_8 = 19;
                            break block88;
                        }
                        case -2123537834: {
                            if (!var2_3.equals("audio/eac3-joc")) break;
                            var3_8 = 2;
                            break block88;
                        }
                    }
                    var3_8 = -1;
                }
                switch (var3_8) {
                    default: {
                        ** continue;
                    }
                    case 23: {
                        var4_9 = 14;
                        break;
                    }
                    case 22: {
                        var4_9 = 13;
                        break;
                    }
                    case 21: {
                        var4_9 = 12;
                        break;
                    }
                    case 20: {
                        var4_9 = 11;
                        break;
                    }
                    case 19: {
                        var4_9 = 10;
                        break;
                    }
                    case 18: {
                        var4_9 = 9;
                        break;
                    }
                    case 15: 
                    case 16: 
                    case 17: {
                        var4_9 = 8;
                        break;
                    }
                    case 14: {
                        var4_9 = 7;
                        break;
                    }
                    case 9: 
                    case 10: 
                    case 11: 
                    case 12: 
                    case 13: {
                        var4_9 = 6;
                        break;
                    }
                    case 8: {
                        var4_9 = 5;
                        break;
                    }
                    case 7: {
                        var4_9 = 4;
                        break;
                    }
                    case 4: 
                    case 5: 
                    case 6: {
                        var4_9 = 3;
                        break;
                    }
                    case 3: {
                        var4_9 = 1;
                        break;
                    }
                    case 0: 
                    case 1: 
                    case 2: {
                        var4_9 = 0;
                    }
                }
            }
            if (var4_9 == -1) ** GOTO lbl166
            {
                zznq.zzb(var4_9, var8_4);
lbl166:
                // 2 sources

                if ((var1_1 = var1_1.getLastPathSegment()) == null) {
                    while (true) {
                        var3_8 = -1;
                        break;
                    }
                } else if (!var1_1.endsWith(".ac3") && !var1_1.endsWith(".ec3")) {
                    if (var1_1.endsWith(".ac4")) {
                        var3_8 = 1;
                    } else if (!var1_1.endsWith(".adts") && !var1_1.endsWith(".aac")) {
                        if (var1_1.endsWith(".amr")) {
                            var3_8 = 3;
                        } else if (var1_1.endsWith(".flac")) {
                            var3_8 = 4;
                        } else if (var1_1.endsWith(".flv")) {
                            var3_8 = 5;
                        } else if (!var1_1.startsWith(".mk", var1_1.length() - 4) && !var1_1.endsWith(".webm")) {
                            if (var1_1.endsWith(".mp3")) {
                                var3_8 = 7;
                            } else if (!(var1_1.endsWith(".mp4") || var1_1.startsWith(".m4", var1_1.length() - 4) || var1_1.startsWith(".mp4", var1_1.length() - 5) || var1_1.startsWith(".cmf", var1_1.length() - 5))) {
                                if (!var1_1.startsWith(".og", var1_1.length() - 4) && !var1_1.endsWith(".opus")) {
                                    var3_8 = var5_7;
                                    if (!var1_1.endsWith(".ps")) {
                                        var3_8 = var5_7;
                                        if (!var1_1.endsWith(".mpeg")) {
                                            var3_8 = var5_7;
                                            if (!var1_1.endsWith(".mpg")) {
                                                if (var1_1.endsWith(".m2p")) {
                                                    var3_8 = var5_7;
                                                } else if (!var1_1.endsWith(".ts") && !var1_1.startsWith(".ts", var1_1.length() - 4)) {
                                                    if (!var1_1.endsWith(".wav") && !var1_1.endsWith(".wave")) {
                                                        if (!var1_1.endsWith(".vtt") && !var1_1.endsWith(".webvtt")) {
                                                            if (!var1_1.endsWith(".jpg") && !var1_1.endsWith(".jpeg")) ** continue;
                                                            var3_8 = 14;
                                                        } else {
                                                            var3_8 = 13;
                                                        }
                                                    } else {
                                                        var3_8 = 12;
                                                    }
                                                } else {
                                                    var3_8 = 11;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    var3_8 = 9;
                                }
                            } else {
                                var3_8 = 8;
                            }
                        } else {
                            var3_8 = 6;
                        }
                    } else {
                        var3_8 = 2;
                    }
                } else {
                    var3_8 = 0;
                }
                if (var3_8 != -1 && var3_8 != var4_9) {
                    zznq.zzb(var3_8, var8_4);
                }
                var1_1 = zznq.zza;
            }
            for (var5_7 = 0; var5_7 < 14; ++var5_7) {
                var6_10 = var1_1[var5_7];
                if (var6_10 == var4_9 || var6_10 == var3_8) continue;
                {
                    zznq.zzb((int)var6_10, var8_4);
                }
            }
            {
                var1_1 = var8_4.toArray(new zznu[var8_4.size()]);
                return var1_1;
            }
        }
    }
}
