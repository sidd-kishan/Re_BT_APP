/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzaqk
 *  com.google.android.gms.internal.ads.zzart
 *  com.google.android.gms.internal.ads.zzarw
 *  com.google.android.gms.internal.ads.zzary
 *  com.google.android.gms.internal.ads.zzasa
 *  com.google.android.gms.internal.ads.zzasc
 *  com.google.android.gms.internal.ads.zzaux
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzaqk;
import com.google.android.gms.internal.ads.zzart;
import com.google.android.gms.internal.ads.zzarw;
import com.google.android.gms.internal.ads.zzary;
import com.google.android.gms.internal.ads.zzasa;
import com.google.android.gms.internal.ads.zzasc;
import com.google.android.gms.internal.ads.zzaux;
import com.google.android.gms.internal.ads.zzave;

final class zzaqx {
    private static final int zzA;
    private static final int zzB;
    private static final int zzC;
    private static final String[] zzD;
    private static final int zza;
    private static final int zzb;
    private static final int zzc;
    private static final int zzd;
    private static final int zze;
    private static final int zzf;
    private static final int zzg;
    private static final int zzh;
    private static final int zzi;
    private static final int zzj;
    private static final int zzk;
    private static final int zzl;
    private static final int zzm;
    private static final int zzn;
    private static final int zzo;
    private static final int zzp;
    private static final int zzq;
    private static final int zzr;
    private static final int zzs;
    private static final int zzt;
    private static final int zzu;
    private static final int zzv;
    private static final int zzw;
    private static final int zzx;
    private static final int zzy;
    private static final int zzz;

    static {
        zza = zzave.zzl((String)"nam");
        zzb = zzave.zzl((String)"trk");
        zzc = zzave.zzl((String)"cmt");
        zzd = zzave.zzl((String)"day");
        zze = zzave.zzl((String)"ART");
        zzf = zzave.zzl((String)"too");
        zzg = zzave.zzl((String)"alb");
        zzh = zzave.zzl((String)"com");
        zzi = zzave.zzl((String)"wrt");
        zzj = zzave.zzl((String)"lyr");
        zzk = zzave.zzl((String)"gen");
        zzl = zzave.zzl((String)"covr");
        zzm = zzave.zzl((String)"gnre");
        zzn = zzave.zzl((String)"grp");
        zzo = zzave.zzl((String)"disk");
        zzp = zzave.zzl((String)"trkn");
        zzq = zzave.zzl((String)"tmpo");
        zzr = zzave.zzl((String)"cpil");
        zzs = zzave.zzl((String)"aART");
        zzt = zzave.zzl((String)"sonm");
        zzu = zzave.zzl((String)"soal");
        zzv = zzave.zzl((String)"soar");
        zzw = zzave.zzl((String)"soaa");
        zzx = zzave.zzl((String)"soco");
        zzy = zzave.zzl((String)"rtng");
        zzz = zzave.zzl((String)"pgap");
        zzA = zzave.zzl((String)"sosn");
        zzB = zzave.zzl((String)"tvsh");
        zzC = zzave.zzl((String)"----");
        zzD = new String[]{"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public static zzart zza(zzaux var0) {
        block47: {
            block50: {
                block49: {
                    block48: {
                        var5_1 = var0.zzg() + var0.zzr();
                        var1_2 = var0.zzr();
                        var9_3 = null;
                        var11_4 = null;
                        var10_5 = null;
                        var12_6 = null;
                        if ((var1_2 >> 24 & 255) == 169) ** GOTO lbl-1000
                        try {
                            if (var1_2 != zzaqx.zzm) ** GOTO lbl-1000
                            var2_7 = zzaqx.zze(var0);
                            if (var2_7 <= 0) ** GOTO lbl-1000
                            var1_2 = zzaqx.zzD.length;
                            if (var2_7 <= 148) {
                                var8_11 /* !! */  = zzaqx.zzD[var2_7 - 1];
                            } else lbl-1000:
                            // 2 sources

                            {
                                var8_11 /* !! */  = null;
                            }
                            if (var8_11 /* !! */  != null) {
                                var8_11 /* !! */  = new zzasc("TCON", null, var8_11 /* !! */ );
                            } else {
                                Log.w((String)"MetadataUtil", (String)"Failed to parse standard genre code");
                                var8_11 /* !! */  = var12_6;
                            }
                        }
                        catch (Throwable var8_28) {
                            break block47;
                        }
                        var0.zzi(var5_1);
                        return var8_11 /* !! */ ;
lbl-1000:
                        // 1 sources

                        {
                            if (var1_2 != zzaqx.zzo) ** GOTO lbl-1000
                            var8_12 = zzaqx.zzd(var1_2, "TPOS", var0);
                        }
                        var0.zzi(var5_1);
                        return var8_12;
lbl-1000:
                        // 1 sources

                        {
                            if (var1_2 != zzaqx.zzp) ** GOTO lbl-1000
                            var8_13 = zzaqx.zzd(var1_2, "TRCK", var0);
                        }
                        var0.zzi(var5_1);
                        return var8_13;
lbl-1000:
                        // 1 sources

                        {
                            if (var1_2 != zzaqx.zzq) ** GOTO lbl-1000
                            var8_14 = zzaqx.zzc(var1_2, "TBPM", var0, true, false);
                        }
                        var0.zzi(var5_1);
                        return var8_14;
lbl-1000:
                        // 1 sources

                        {
                            if (var1_2 != zzaqx.zzr) ** GOTO lbl-1000
                            var8_15 = zzaqx.zzc(var1_2, "TCMP", var0, true, true);
                        }
                        var0.zzi(var5_1);
                        return var8_15;
lbl-1000:
                        // 1 sources

                        {
                            if (var1_2 != zzaqx.zzl) ** GOTO lbl-1000
                            var2_8 = var0.zzr();
                            if (var0.zzr() != zzaqk.zzaH) ** GOTO lbl73
                            var1_2 = zzaqk.zzf((int)var0.zzr());
                            if (var1_2 == 13) {
                                var8_16 = "image/jpeg";
                            } else if (var1_2 == 14) {
                                var8_16 = "image/png";
                                var1_2 = 14;
                            } else {
                                var8_16 = null;
                            }
                            if (var8_16 == null) {
                                var8_16 = new StringBuilder(41);
                                var8_16.append("Unrecognized cover art flags: ");
                                var8_16.append(var1_2);
                                Log.w((String)"MetadataUtil", (String)var8_16.toString());
                                var8_16 = var9_3;
                                break block48;
                            }
                            var0.zzj(4);
                            var1_2 = var2_8 - 16;
                        }
                        {
                            var9_3 = new byte[var1_2];
                            var0.zzk((byte[])var9_3, 0, var1_2);
                            var8_16 = new zzarw((String)var8_16, null, 3, (byte[])var9_3);
                            break block48;
lbl73:
                            // 1 sources

                            Log.w((String)"MetadataUtil", (String)"Failed to parse cover art attribute");
                            var8_16 = var9_3;
                        }
                    }
                    var0.zzi(var5_1);
                    return var8_16;
lbl-1000:
                    // 1 sources

                    {
                        if (var1_2 != zzaqx.zzs) ** GOTO lbl-1000
                        var8_17 = zzaqx.zzb(var1_2, "TPE2", var0);
                    }
                    var0.zzi(var5_1);
                    return var8_17;
lbl-1000:
                    // 1 sources

                    {
                        if (var1_2 != zzaqx.zzt) ** GOTO lbl-1000
                        var8_18 = zzaqx.zzb(var1_2, "TSOT", var0);
                    }
                    var0.zzi(var5_1);
                    return var8_18;
lbl-1000:
                    // 1 sources

                    {
                        if (var1_2 != zzaqx.zzu) ** GOTO lbl-1000
                        var8_19 = zzaqx.zzb(var1_2, "TSO2", var0);
                    }
                    var0.zzi(var5_1);
                    return var8_19;
lbl-1000:
                    // 1 sources

                    {
                        if (var1_2 != zzaqx.zzv) ** GOTO lbl-1000
                        var8_20 = zzaqx.zzb(var1_2, "TSOA", var0);
                    }
                    var0.zzi(var5_1);
                    return var8_20;
lbl-1000:
                    // 1 sources

                    {
                        if (var1_2 != zzaqx.zzw) ** GOTO lbl-1000
                        var8_21 = zzaqx.zzb(var1_2, "TSOP", var0);
                    }
                    var0.zzi(var5_1);
                    return var8_21;
lbl-1000:
                    // 1 sources

                    {
                        if (var1_2 != zzaqx.zzx) ** GOTO lbl-1000
                        var8_22 = zzaqx.zzb(var1_2, "TSOC", var0);
                    }
                    var0.zzi(var5_1);
                    return var8_22;
lbl-1000:
                    // 1 sources

                    {
                        if (var1_2 != zzaqx.zzy) ** GOTO lbl-1000
                        var8_23 = zzaqx.zzc(var1_2, "ITUNESADVISORY", var0, false, false);
                    }
                    var0.zzi(var5_1);
                    return var8_23;
lbl-1000:
                    // 1 sources

                    {
                        if (var1_2 != zzaqx.zzz) ** GOTO lbl-1000
                        var8_24 = zzaqx.zzc(var1_2, "ITUNESGAPLESS", var0, false, true);
                    }
                    var0.zzi(var5_1);
                    return var8_24;
lbl-1000:
                    // 1 sources

                    {
                        if (var1_2 != zzaqx.zzA) ** GOTO lbl-1000
                        var8_25 = zzaqx.zzb(var1_2, "TVSHOWSORT", var0);
                    }
                    var0.zzi(var5_1);
                    return var8_25;
lbl-1000:
                    // 1 sources

                    {
                        if (var1_2 != zzaqx.zzB) ** GOTO lbl-1000
                        var8_26 = zzaqx.zzb(var1_2, "TVSHOW", var0);
                    }
                    var0.zzi(var5_1);
                    return var8_26;
lbl-1000:
                    // 1 sources

                    {
                        if (var1_2 != zzaqx.zzC) ** GOTO lbl-1000
                        var9_3 = null;
                        var8_27 = null;
                        var2_9 = -1;
                        var1_2 = -1;
                        while (var0.zzg() < var5_1) {
                            var4_41 = var0.zzg();
                            var3_40 = var0.zzr();
                            var7_43 = var0.zzr();
                            var0.zzj(4);
                            if (var7_43 == zzaqk.zzaF) {
                                var9_3 = var0.zzw(var3_40 - 12);
                                continue;
                            }
                            if (var7_43 == zzaqk.zzaG) {
                                var8_27 = var0.zzw(var3_40 - 12);
                                continue;
                            }
                            var6_42 = zzaqk.zzaH;
                            if (var7_43 == var6_42) {
                                var1_2 = var3_40;
                            }
                            if (var7_43 == var6_42) {
                                var2_9 = var4_41;
                            }
                            var0.zzj(var3_40 - 12);
                        }
                        var10_5 = var11_4;
                        if (!"com.apple.iTunes".equals(var9_3)) break block49;
                        var10_5 = var11_4;
                        if (!"iTunSMPB".equals(var8_27)) break block49;
                        if (var2_9 == -1) {
                            var10_5 = var11_4;
                            break block49;
                        }
                        var0.zzi(var2_9);
                        var0.zzj(16);
                        var10_5 = new zzary("und", var8_27, var0.zzw(var1_2 - 16));
                    }
                }
                var0.zzi(var5_1);
                return var10_5;
lbl-1000:
                // 1 sources

                {
                    var2_10 = 0xFFFFFF & var1_2;
                    if (var2_10 != zzaqx.zzc) ** GOTO lbl-1000
                    var2_10 = var0.zzr();
                    if (var0.zzr() == zzaqk.zzaH) {
                        var0.zzj(8);
                        var8_29 = var0.zzw(var2_10 - 16);
                        var8_29 = new zzary("und", var8_29, var8_29);
                        break block50;
                    }
                    var8_29 = zzaqk.zzg((int)var1_2);
                    var8_29 = var8_29.length() != 0 ? "Failed to parse comment attribute: ".concat(var8_29) : new String("Failed to parse comment attribute: ");
                    Log.w((String)"MetadataUtil", (String)var8_29);
                    var8_29 = var10_5;
                }
            }
            var0.zzi(var5_1);
            return var8_29;
lbl-1000:
            // 1 sources

            {
                if (var2_10 == zzaqx.zza || var2_10 == zzaqx.zzb) ** GOTO lbl-1000
                if (var2_10 == zzaqx.zzh || var2_10 == zzaqx.zzi) ** GOTO lbl-1000
                if (var2_10 != zzaqx.zzd) ** GOTO lbl-1000
                var8_30 = zzaqx.zzb(var1_2, "TDRC", var0);
            }
            var0.zzi(var5_1);
            return var8_30;
lbl-1000:
            // 1 sources

            {
                if (var2_10 != zzaqx.zze) ** GOTO lbl-1000
                var8_31 = zzaqx.zzb(var1_2, "TPE1", var0);
            }
            var0.zzi(var5_1);
            return var8_31;
lbl-1000:
            // 1 sources

            {
                if (var2_10 != zzaqx.zzf) ** GOTO lbl-1000
                var8_32 = zzaqx.zzb(var1_2, "TSSE", var0);
            }
            var0.zzi(var5_1);
            return var8_32;
lbl-1000:
            // 1 sources

            {
                if (var2_10 != zzaqx.zzg) ** GOTO lbl-1000
                var8_33 = zzaqx.zzb(var1_2, "TALB", var0);
            }
            var0.zzi(var5_1);
            return var8_33;
lbl-1000:
            // 1 sources

            {
                if (var2_10 != zzaqx.zzj) ** GOTO lbl-1000
                var8_34 = zzaqx.zzb(var1_2, "USLT", var0);
            }
            var0.zzi(var5_1);
            return var8_34;
lbl-1000:
            // 1 sources

            {
                if (var2_10 != zzaqx.zzk) ** GOTO lbl-1000
                var8_35 = zzaqx.zzb(var1_2, "TCON", var0);
            }
            var0.zzi(var5_1);
            return var8_35;
lbl-1000:
            // 1 sources

            {
                if (var2_10 != zzaqx.zzn) ** GOTO lbl-1000
                var8_36 = zzaqx.zzb(var1_2, "TIT1", var0);
            }
            var0.zzi(var5_1);
            return var8_36;
lbl-1000:
            // 2 sources

            {
                var8_37 = (var8_37 = zzaqk.zzg((int)var1_2)).length() != 0 ? "Skipped unknown metadata entry: ".concat(var8_37) : new String("Skipped unknown metadata entry: ");
                Log.d((String)"MetadataUtil", (String)var8_37);
            }
            var0.zzi(var5_1);
            return null;
lbl-1000:
            // 1 sources

            {
                var8_38 = zzaqx.zzb(var1_2, "TCOM", var0);
            }
            var0.zzi(var5_1);
            return var8_38;
lbl-1000:
            // 1 sources

            {
                var8_39 = zzaqx.zzb(var1_2, "TIT2", var0);
            }
            var0.zzi(var5_1);
            return var8_39;
        }
        var0.zzi(var5_1);
        throw var8_28;
    }

    private static zzasc zzb(int n, String string, zzaux zzaux2) {
        int n2 = zzaux2.zzr();
        if (zzaux2.zzr() == zzaqk.zzaH) {
            zzaux2.zzj(8);
            return new zzasc(string, null, zzaux2.zzw(n2 - 16));
        }
        string = zzaqk.zzg((int)n);
        string = string.length() != 0 ? "Failed to parse text attribute: ".concat(string) : new String("Failed to parse text attribute: ");
        Log.w((String)"MetadataUtil", (String)string);
        return null;
    }

    private static zzasa zzc(int n, String string, zzaux zzaux2, boolean bl, boolean bl2) {
        int n2;
        int n3 = n2 = zzaqx.zze(zzaux2);
        if (bl2) {
            n3 = Math.min(1, n2);
        }
        if (n3 >= 0) {
            string = bl ? new zzasc(string, null, Integer.toString(n3)) : new zzary("und", string, Integer.toString(n3));
            return string;
        }
        string = zzaqk.zzg((int)n);
        string = string.length() != 0 ? "Failed to parse uint8 attribute: ".concat(string) : new String("Failed to parse uint8 attribute: ");
        Log.w((String)"MetadataUtil", (String)string);
        return null;
    }

    private static zzasc zzd(int n, String string, zzaux object) {
        int n2 = object.zzr();
        if (object.zzr() == zzaqk.zzaH && n2 >= 22) {
            object.zzj(10);
            n2 = object.zzm();
            if (n2 > 0) {
                CharSequence charSequence = new StringBuilder(11);
                ((StringBuilder)charSequence).append(n2);
                charSequence = ((StringBuilder)charSequence).toString();
                n = object.zzm();
                object = charSequence;
                if (n <= 0) return new zzasc(string, null, (String)object);
                object = new StringBuilder(((String)charSequence).length() + 12);
                ((StringBuilder)object).append((String)charSequence);
                ((StringBuilder)object).append("/");
                ((StringBuilder)object).append(n);
                object = ((StringBuilder)object).toString();
                return new zzasc(string, null, (String)object);
            }
        }
        string = (string = zzaqk.zzg((int)n)).length() != 0 ? "Failed to parse index/count attribute: ".concat(string) : new String("Failed to parse index/count attribute: ");
        Log.w((String)"MetadataUtil", (String)string);
        return null;
    }

    private static int zze(zzaux zzaux2) {
        zzaux2.zzj(4);
        if (zzaux2.zzr() == zzaqk.zzaH) {
            zzaux2.zzj(8);
            return zzaux2.zzl();
        }
        Log.w((String)"MetadataUtil", (String)"Failed to parse uint8 attribute value");
        return -1;
    }
}
