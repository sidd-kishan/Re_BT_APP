/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzaiu
 *  com.google.android.gms.internal.ads.zzaji
 *  com.google.android.gms.internal.ads.zzajq
 *  com.google.android.gms.internal.ads.zzajx
 *  com.google.android.gms.internal.ads.zzajz
 *  com.google.android.gms.internal.ads.zzakf
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzqx
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzaiu;
import com.google.android.gms.internal.ads.zzaji;
import com.google.android.gms.internal.ads.zzajq;
import com.google.android.gms.internal.ads.zzajx;
import com.google.android.gms.internal.ads.zzajz;
import com.google.android.gms.internal.ads.zzakf;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzqx;

final class zzrl {
    static final String[] zza = new String[]{"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    public static final int zzb = 0;

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public static zzaiu zza(zzamf var0) {
        block70: {
            block74: {
                block75: {
                    block73: {
                        block71: {
                            block72: {
                                block68: {
                                    var5_1 = var0.zzg() + var0.zzv();
                                    var1_2 = var0.zzv();
                                    var2_3 = var1_2 >> 24 & 255;
                                    var8_4 = null;
                                    var10_5 = null;
                                    var9_6 = null;
                                    var11_7 = null;
                                    if (var2_3 == 169 || var2_3 == 253) break block71;
                                    if (var1_2 == 1735291493) {
                                        block67: {
                                            var1_2 = zzrl.zze(var0);
                                            var7_8 = var1_2 > 0 && var1_2 <= 192 ? zzrl.zza[var1_2 - 1] : null;
                                            if (var7_8 != null) {
                                                var7_8 = new zzakf("TCON", null, var7_8);
                                                break block67;
                                            }
                                            Log.w((String)"MetadataUtil", (String)"Failed to parse standard genre code");
                                            var7_8 = var11_7;
                                        }
                                        var0.zzh(var5_1);
                                        return var7_8;
                                    }
                                    if (var1_2 == 1684632427) {
                                        var7_9 = zzrl.zzd(1684632427, "TPOS", var0);
                                        var0.zzh(var5_1);
                                        return var7_9;
                                    }
                                    if (var1_2 == 1953655662) {
                                        var7_10 = zzrl.zzd(1953655662, "TRCK", var0);
                                        var0.zzh(var5_1);
                                        return var7_10;
                                    }
                                    if (var1_2 == 1953329263) {
                                        var7_11 = zzrl.zzc(1953329263, "TBPM", var0, true, false);
                                        var0.zzh(var5_1);
                                        return var7_11;
                                    }
                                    if (var1_2 == 1668311404) {
                                        var7_12 = zzrl.zzc(1668311404, "TCMP", var0, true, true);
                                        var0.zzh(var5_1);
                                        return var7_12;
                                    }
                                    if (var1_2 != 1668249202) break block72;
                                    try {
                                        var2_3 = var0.zzv();
                                        if (var0.zzv() != 1684108385) ** GOTO lbl73
                                        var1_2 = var0.zzv() & 0xFFFFFF;
                                        if (var1_2 == 13) {
                                            var7_13 = "image/jpeg";
                                        } else if (var1_2 == 14) {
                                            var7_13 = "image/png";
                                            var1_2 = 14;
                                        } else {
                                            var7_13 = null;
                                        }
                                        if (var7_13 == null) {
                                            var7_13 = new StringBuilder(41);
                                            var7_13.append("Unrecognized cover art flags: ");
                                            var7_13.append(var1_2);
                                            Log.w((String)"MetadataUtil", (String)var7_13.toString());
                                            var7_13 = var8_4;
                                            break block68;
                                        }
                                        var0.zzk(4);
                                        var1_2 = var2_3 - 16;
                                    }
lbl67:
                                    // 29 sources

                                    catch (Throwable var7_25) {}
                                    var8_4 = new byte[var1_2];
                                    var0.zzm((byte[])var8_4, 0, var1_2);
                                    var7_13 = new zzaji((String)var7_13, null, 3, (byte[])var8_4);
                                    break block68;
lbl73:
                                    // 1 sources

                                    Log.w((String)"MetadataUtil", (String)"Failed to parse cover art attribute");
                                    var7_13 = var8_4;
                                }
                                var0.zzh(var5_1);
                                return var7_13;
                            }
                            if (var1_2 == 1631670868) {
                                var7_14 = zzrl.zzb(1631670868, "TPE2", var0);
                                var0.zzh(var5_1);
                                return var7_14;
                            }
                            if (var1_2 == 1936682605) {
                                var7_15 = zzrl.zzb(1936682605, "TSOT", var0);
                                var0.zzh(var5_1);
                                return var7_15;
                            }
                            if (var1_2 == 1936679276) {
                                var7_16 = zzrl.zzb(1936679276, "TSO2", var0);
                                var0.zzh(var5_1);
                                return var7_16;
                            }
                            if (var1_2 == 1936679282) {
                                var7_17 = zzrl.zzb(1936679282, "TSOA", var0);
                                var0.zzh(var5_1);
                                return var7_17;
                            }
                            if (var1_2 == 1936679265) {
                                var7_18 = zzrl.zzb(1936679265, "TSOP", var0);
                                var0.zzh(var5_1);
                                return var7_18;
                            }
                            if (var1_2 == 1936679791) {
                                var7_19 = zzrl.zzb(1936679791, "TSOC", var0);
                                var0.zzh(var5_1);
                                return var7_19;
                            }
                            if (var1_2 == 1920233063) {
                                var7_20 = zzrl.zzc(1920233063, "ITUNESADVISORY", var0, false, false);
                                var0.zzh(var5_1);
                                return var7_20;
                            }
                            if (var1_2 == 1885823344) {
                                var7_21 = zzrl.zzc(1885823344, "ITUNESGAPLESS", var0, false, true);
                                var0.zzh(var5_1);
                                return var7_21;
                            }
                            if (var1_2 == 1936683886) {
                                var7_22 = zzrl.zzb(1936683886, "TVSHOWSORT", var0);
                                var0.zzh(var5_1);
                                return var7_22;
                            }
                            if (var1_2 == 1953919848) {
                                var7_23 = zzrl.zzb(1953919848, "TVSHOW", var0);
                                var0.zzh(var5_1);
                                return var7_23;
                            }
                            if (var1_2 != 0x2D2D2D2D) break block73;
                            var8_4 = null;
                            var7_13 = null;
                            var1_2 = -1;
                            var2_3 = -1;
                            ** try [egrp 17[TRYBLOCK] [23 : 736->906)] { 
lbl136:
                            // 1 sources

                            ** GOTO lbl-1000
                        }
                        var2_3 = var1_2 & 0xFFFFFF;
                        if (var2_3 == 6516084) {
                            block69: {
                                var2_3 = var0.zzv();
                                if (var0.zzv() == 1684108385) {
                                    var0.zzk(8);
                                    var7_24 = var0.zzF(var2_3 - 16);
                                    var7_24 = new zzajq("und", var7_24, var7_24);
                                    break block69;
                                }
                                var7_24 = zzqx.zzf((int)var1_2);
                                var7_24 = var7_24.length() != 0 ? "Failed to parse comment attribute: ".concat(var7_24) : new String("Failed to parse comment attribute: ");
                                Log.w((String)"MetadataUtil", (String)var7_24);
                                var7_24 = var9_6;
                            }
                            var0.zzh(var5_1);
                            return var7_24;
                        }
                        if (var2_3 == 7233901 || var2_3 == 7631467) break block74;
                        if (var2_3 != 6516589 && var2_3 != 0x777274) {
                            if (var2_3 == 6578553) {
                                var7_26 = zzrl.zzb(var1_2, "TDRC", var0);
                                var0.zzh(var5_1);
                                return var7_26;
                            }
                            if (var2_3 == 4280916) {
                                var7_27 = zzrl.zzb(var1_2, "TPE1", var0);
                                var0.zzh(var5_1);
                                return var7_27;
                            }
                            if (var2_3 == 7630703) {
                                var7_28 = zzrl.zzb(var1_2, "TSSE", var0);
                                var0.zzh(var5_1);
                                return var7_28;
                            }
                            if (var2_3 == 6384738) {
                                var7_29 = zzrl.zzb(var1_2, "TALB", var0);
                                var0.zzh(var5_1);
                                return var7_29;
                            }
                            if (var2_3 == 7108978) {
                                var7_30 = zzrl.zzb(var1_2, "USLT", var0);
                                var0.zzh(var5_1);
                                return var7_30;
                            }
                            if (var2_3 == 6776174) {
                                var7_31 = zzrl.zzb(var1_2, "TCON", var0);
                                var0.zzh(var5_1);
                                return var7_31;
                            }
                            if (var2_3 == 6779504) {
                                var7_32 = zzrl.zzb(var1_2, "TIT1", var0);
                                var0.zzh(var5_1);
                                return var7_32;
                            } else {
                                ** GOTO lbl193
                            }
                        }
                        break block75;
                    }
                    var7_33 = zzqx.zzf((int)var1_2);
                    var7_33 = var7_33.length() != 0 ? "Skipped unknown metadata entry: ".concat(var7_33) : new String("Skipped unknown metadata entry: ");
                    Log.d((String)"MetadataUtil", (String)var7_33);
                    var0.zzh(var5_1);
                    return null;
                }
                var7_34 = zzrl.zzb(var1_2, "TCOM", var0);
                var0.zzh(var5_1);
                return var7_34;
            }
            var7_35 = zzrl.zzb(var1_2, "TIT2", var0);
            var0.zzh(var5_1);
            return var7_35;
lbl-1000:
            // 4 sources

            {
                while (var0.zzg() < var5_1) {
                    var4_37 = var0.zzg();
                    var3_36 = var0.zzv();
                    var6_38 = var0.zzv();
                    var0.zzk(4);
                    if (var6_38 == 1835360622) {
                        var8_4 = var0.zzF(var3_36 - 12);
                        continue;
                    }
                    if (var6_38 == 1851878757) {
                        var7_13 = var0.zzF(var3_36 - 12);
                        continue;
                    }
                    if (var6_38 == 1684108385) {
                        var2_3 = var3_36;
                    }
                    if (var6_38 == 1684108385) {
                        var1_2 = var4_37;
                    }
                    var0.zzk(var3_36 - 12);
                }
                var9_6 = var10_5;
                if (var8_4 == null) break block70;
                var9_6 = var10_5;
                if (var7_13 == null) break block70;
                if (var1_2 == -1) {
                    var9_6 = var10_5;
                    break block70;
                }
                var0.zzh(var1_2);
                var0.zzk(16);
                var9_6 = new zzajz((String)var8_4, (String)var7_13, var0.zzF(var2_3 - 16));
            }
        }
        var0.zzh(var5_1);
        return var9_6;
        var0.zzh(var5_1);
        throw var7_25;
    }

    private static zzakf zzb(int n, String string, zzamf zzamf2) {
        int n2 = zzamf2.zzv();
        if (zzamf2.zzv() == 1684108385) {
            zzamf2.zzk(8);
            return new zzakf(string, null, zzamf2.zzF(n2 - 16));
        }
        string = zzqx.zzf((int)n);
        string = string.length() != 0 ? "Failed to parse text attribute: ".concat(string) : new String("Failed to parse text attribute: ");
        Log.w((String)"MetadataUtil", (String)string);
        return null;
    }

    private static zzajx zzc(int n, String string, zzamf zzamf2, boolean bl, boolean bl2) {
        int n2;
        int n3 = n2 = zzrl.zze(zzamf2);
        if (bl2) {
            n3 = Math.min(1, n2);
        }
        if (n3 >= 0) {
            string = bl ? new zzakf(string, null, Integer.toString(n3)) : new zzajq("und", string, Integer.toString(n3));
            return string;
        }
        string = zzqx.zzf((int)n);
        string = string.length() != 0 ? "Failed to parse uint8 attribute: ".concat(string) : new String("Failed to parse uint8 attribute: ");
        Log.w((String)"MetadataUtil", (String)string);
        return null;
    }

    private static zzakf zzd(int n, String string, zzamf object) {
        int n2 = object.zzv();
        if (object.zzv() == 1684108385 && n2 >= 22) {
            object.zzk(10);
            n2 = object.zzo();
            if (n2 > 0) {
                CharSequence charSequence = new StringBuilder(11);
                ((StringBuilder)charSequence).append(n2);
                charSequence = ((StringBuilder)charSequence).toString();
                n = object.zzo();
                object = charSequence;
                if (n <= 0) return new zzakf(string, null, (String)object);
                object = new StringBuilder(((String)charSequence).length() + 12);
                ((StringBuilder)object).append((String)charSequence);
                ((StringBuilder)object).append("/");
                ((StringBuilder)object).append(n);
                object = ((StringBuilder)object).toString();
                return new zzakf(string, null, (String)object);
            }
        }
        string = (string = zzqx.zzf((int)n)).length() != 0 ? "Failed to parse index/count attribute: ".concat(string) : new String("Failed to parse index/count attribute: ");
        Log.w((String)"MetadataUtil", (String)string);
        return null;
    }

    private static int zze(zzamf zzamf2) {
        zzamf2.zzk(4);
        if (zzamf2.zzv() == 1684108385) {
            zzamf2.zzk(8);
            return zzamf2.zzn();
        }
        Log.w((String)"MetadataUtil", (String)"Failed to parse uint8 attribute value");
        return -1;
    }
}
