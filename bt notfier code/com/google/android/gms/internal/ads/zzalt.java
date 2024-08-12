/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzalr
 *  com.google.android.gms.internal.ads.zzals
 *  com.google.android.gms.internal.ads.zzflf
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzalr;
import com.google.android.gms.internal.ads.zzals;
import com.google.android.gms.internal.ads.zzflf;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzalt {
    private static final ArrayList<zzalr> zza = new ArrayList();
    private static final Pattern zzb = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    public static boolean zza(String string) {
        return "audio".equals(zzalt.zzi(string));
    }

    public static boolean zzb(String string) {
        return "video".equals(zzalt.zzi(string));
    }

    public static boolean zzc(String string, String string2) {
        int n;
        int n2;
        block21: {
            if (string == null) {
                return false;
            }
            n2 = string.hashCode();
            n = 10;
            switch (n2) {
                default: {
                    break;
                }
                case 1903589369: {
                    if (!string.equals("audio/g711-mlaw")) break;
                    n2 = 5;
                    break block21;
                }
                case 1903231877: {
                    if (!string.equals("audio/g711-alaw")) break;
                    n2 = 4;
                    break block21;
                }
                case 1504831518: {
                    if (!string.equals("audio/mpeg")) break;
                    n2 = 0;
                    break block21;
                }
                case 1504619009: {
                    if (!string.equals("audio/flac")) break;
                    n2 = 6;
                    break block21;
                }
                case 1504578661: {
                    if (!string.equals("audio/eac3")) break;
                    n2 = 8;
                    break block21;
                }
                case 187094639: {
                    if (!string.equals("audio/raw")) break;
                    n2 = 3;
                    break block21;
                }
                case 187078296: {
                    if (!string.equals("audio/ac3")) break;
                    n2 = 7;
                    break block21;
                }
                case -53558318: {
                    if (!string.equals("audio/mp4a-latm")) break;
                    n2 = 10;
                    break block21;
                }
                case -432837259: {
                    if (!string.equals("audio/mpeg-L2")) break;
                    n2 = 2;
                    break block21;
                }
                case -432837260: {
                    if (!string.equals("audio/mpeg-L1")) break;
                    n2 = 1;
                    break block21;
                }
                case -2123537834: {
                    if (!string.equals("audio/eac3-joc")) break;
                    n2 = 9;
                    break block21;
                }
            }
            n2 = -1;
        }
        switch (n2) {
            default: {
                return false;
            }
            case 10: {
                if (string2 == null) {
                    return false;
                }
                string = zzalt.zzh(string2);
                if (string == null) {
                    return false;
                }
                int n3 = ((zzals)string).zzb;
                n2 = n;
                if (n3 != 2) {
                    n2 = n3 != 5 ? (n3 != 29 ? (n3 != 42 ? (n3 != 22 ? (n3 != 23 ? 0 : 15) : 0x40000000) : 16) : 12) : 11;
                }
                if (n2 == 0) return false;
                if (n2 == 16) return false;
                return true;
            }
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
        }
        return true;
    }

    public static String zzd(String string) {
        String string2 = zzflf.zza((String)string.trim());
        if (string2.startsWith("avc1")) return "video/avc";
        if (string2.startsWith("avc3")) {
            return "video/avc";
        }
        if (string2.startsWith("hev1")) return "video/hevc";
        if (string2.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (string2.startsWith("dvav")) return "video/dolby-vision";
        if (string2.startsWith("dva1")) return "video/dolby-vision";
        if (string2.startsWith("dvhe")) return "video/dolby-vision";
        if (string2.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (string2.startsWith("av01")) {
            return "video/av01";
        }
        if (string2.startsWith("vp9")) return "video/x-vnd.on2.vp9";
        if (string2.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (string2.startsWith("vp8")) return "video/x-vnd.on2.vp8";
        if (string2.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        boolean bl = string2.startsWith("mp4a");
        zzalr zzalr2 = null;
        if (bl) {
            string = zzalr2;
            if (string2.startsWith("mp4a.")) {
                string2 = zzalt.zzh(string2);
                string = zzalr2;
                if (string2 != null) {
                    string = zzalt.zze(((zzals)string2).zza);
                }
            }
            if (string != null) return string;
            return "audio/mp4a-latm";
        }
        if (string2.startsWith("mha1")) {
            return "audio/mha1";
        }
        if (string2.startsWith("mhm1")) {
            return "audio/mhm1";
        }
        if (string2.startsWith("ac-3")) return "audio/ac3";
        if (string2.startsWith("dac3")) {
            return "audio/ac3";
        }
        if (string2.startsWith("ec-3")) return "audio/eac3";
        if (string2.startsWith("dec3")) {
            return "audio/eac3";
        }
        if (string2.startsWith("ec+3")) {
            return "audio/eac3-joc";
        }
        if (string2.startsWith("ac-4")) return "audio/ac4";
        if (string2.startsWith("dac4")) {
            return "audio/ac4";
        }
        if (string2.startsWith("dtsc")) {
            return "audio/vnd.dts";
        }
        if (string2.startsWith("dtse")) {
            return "audio/vnd.dts.hd;profile=lbr";
        }
        if (string2.startsWith("dtsh")) return "audio/vnd.dts.hd";
        if (string2.startsWith("dtsl")) {
            return "audio/vnd.dts.hd";
        }
        if (string2.startsWith("dtsx")) {
            return "audio/vnd.dts.uhd";
        }
        if (string2.startsWith("opus")) {
            return "audio/opus";
        }
        if (string2.startsWith("vorbis")) {
            return "audio/vorbis";
        }
        if (string2.startsWith("flac")) {
            return "audio/flac";
        }
        if (string2.startsWith("stpp")) {
            return "application/ttml+xml";
        }
        if (string2.startsWith("wvtt")) {
            return "text/vtt";
        }
        if (string2.contains("cea708")) {
            return "application/cea-708";
        }
        if (string2.contains("eia608")) return "application/cea-608";
        if (string2.contains("cea608")) {
            return "application/cea-608";
        }
        int n = zza.size();
        int n2 = 0;
        while (n2 < n) {
            zzalr2 = zza.get(n2);
            string = zzalr2.zzb;
            if (string2.startsWith(null)) {
                string = zzalr2.zza;
                return null;
            }
            ++n2;
        }
        return null;
    }

    public static String zze(int n) {
        if (n == 32) return "video/mp4v-es";
        if (n == 33) return "video/avc";
        if (n == 35) return "video/hevc";
        if (n == 64) return "audio/mp4a-latm";
        if (n == 163) return "video/wvc1";
        if (n == 177) return "video/x-vnd.on2.vp9";
        if (n == 165) return "audio/ac3";
        if (n == 166) return "audio/eac3";
        switch (n) {
            default: {
                switch (n) {
                    default: {
                        return null;
                    }
                    case 174: {
                        return "audio/ac4";
                    }
                    case 173: {
                        return "audio/opus";
                    }
                    case 170: 
                    case 171: {
                        return "audio/vnd.dts.hd";
                    }
                    case 169: 
                    case 172: 
                }
                return "audio/vnd.dts";
            }
            case 106: {
                return "video/mpeg";
            }
            case 105: 
            case 107: {
                return "audio/mpeg";
            }
            case 96: 
            case 97: 
            case 98: 
            case 99: 
            case 100: 
            case 101: {
                return "video/mpeg2";
            }
            case 102: 
            case 103: 
            case 104: 
        }
        return "audio/mp4a-latm";
    }

    public static int zzf(String string) {
        boolean bl = TextUtils.isEmpty((CharSequence)string);
        int n = -1;
        if (bl) {
            return -1;
        }
        if (zzalt.zza(string)) {
            return 1;
        }
        if (zzalt.zzb(string)) return 2;
        if ("text".equals(zzalt.zzi(string))) return 3;
        if ("application/cea-608".equals(string)) return 3;
        if ("application/cea-708".equals(string)) return 3;
        if ("application/x-mp4-cea-608".equals(string)) return 3;
        if ("application/x-subrip".equals(string)) return 3;
        if ("application/ttml+xml".equals(string)) return 3;
        if ("application/x-quicktime-tx3g".equals(string)) return 3;
        if ("application/x-mp4-vtt".equals(string)) return 3;
        if ("application/x-rawcc".equals(string)) return 3;
        if ("application/vobsub".equals(string)) return 3;
        if ("application/pgs".equals(string)) return 3;
        if ("application/dvbsubs".equals(string)) {
            return 3;
        }
        if ("application/id3".equals(string)) return 5;
        if ("application/x-emsg".equals(string)) return 5;
        if ("application/x-scte35".equals(string)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(string)) return 6;
        int n2 = zza.size();
        int n3 = 0;
        while (true) {
            int n4 = n;
            if (n3 >= n2) return n4;
            zzalr zzalr2 = zza.get(n3);
            String string2 = zzalr2.zza;
            if (string.equals(null)) {
                n3 = zzalr2.zzc;
                n4 = 0;
                return n4;
            }
            ++n3;
        }
    }

    /*
     * Unable to fully structure code
     */
    public static String zzg(String var0) {
        block4: {
            block2: {
                block3: {
                    var1_1 = var0.hashCode();
                    if (var1_1 == -1007807498) break block2;
                    if (var1_1 == -586683234) break block3;
                    if (var1_1 != 187090231 || !var0.equals("audio/mp3")) ** GOTO lbl-1000
                    var1_1 = 1;
                    break block4;
                }
                if (!var0.equals("audio/x-wav")) ** GOTO lbl-1000
                var1_1 = 2;
                break block4;
            }
            if (var0.equals("audio/x-flac")) {
                var1_1 = 0;
            } else lbl-1000:
            // 3 sources

            {
                var1_1 = -1;
            }
        }
        if (var1_1 == 0) return "audio/flac";
        if (var1_1 == 1) return "audio/mpeg";
        if (var1_1 == 2) return "audio/wav";
        return var0;
    }

    static zzals zzh(String string) {
        block3: {
            int n;
            int n2;
            Object object = zzb.matcher(string);
            boolean bl = ((Matcher)object).matches();
            string = null;
            if (!bl) {
                return null;
            }
            String string2 = ((Matcher)object).group(1);
            if (string2 == null) throw null;
            object = ((Matcher)object).group(2);
            try {
                n2 = Integer.parseInt(string2, 16);
                n = object != null ? Integer.parseInt((String)object) : 0;
            }
            catch (NumberFormatException numberFormatException) {
                break block3;
            }
            string = new zzals(n2, n);
        }
        return string;
    }

    private static String zzi(String string) {
        if (string == null) {
            return null;
        }
        int n = string.indexOf(47);
        if (n != -1) return string.substring(0, n);
        return null;
    }
}
