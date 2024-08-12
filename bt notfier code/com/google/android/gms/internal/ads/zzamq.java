/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.UiModeManager
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.hardware.display.DisplayManager
 *  android.media.AudioManager
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Parcel
 *  android.os.SystemClock
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.WindowManager
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzaj
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzaln
 *  com.google.android.gms.internal.ads.zzamp
 *  com.google.android.gms.internal.ads.zzflf
 *  com.google.android.gms.internal.ads.zzfll
 */
package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManager;
import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzaj;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzaln;
import com.google.android.gms.internal.ads.zzamp;
import com.google.android.gms.internal.ads.zzflf;
import com.google.android.gms.internal.ads.zzfll;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class zzamq {
    public static final int zza;
    public static final String zzb;
    public static final String zzc;
    public static final String zzd;
    public static final String zze;
    public static final byte[] zzf;
    private static final Pattern zzg;
    private static final Pattern zzh;
    private static final Pattern zzi;
    private static final Pattern zzj;
    private static HashMap<String, String> zzk;
    private static final String[] zzl;
    private static final String[] zzm;
    private static final int[] zzn;
    private static final int[] zzo;

    static {
        String string;
        zza = Build.VERSION.SDK_INT;
        zzb = Build.DEVICE;
        zzc = Build.MANUFACTURER;
        zzd = string = Build.MODEL;
        String string2 = zzb;
        String string3 = zzc;
        int n = zza;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string2).length() + 17 + String.valueOf(string).length() + String.valueOf(string3).length());
        stringBuilder.append(string2);
        stringBuilder.append(", ");
        stringBuilder.append(string);
        stringBuilder.append(", ");
        stringBuilder.append(string3);
        stringBuilder.append(", ");
        stringBuilder.append(n);
        zze = stringBuilder.toString();
        zzf = new byte[0];
        zzg = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        zzh = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        zzi = Pattern.compile("%([A-Fa-f0-9]{2})");
        zzj = Pattern.compile(".*\\.isml?(?:/(manifest(.*))?)?");
        zzl = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        zzm = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        zzn = zzamq.$d2j$hex$b770e98c$decode_I("00000000b71dc1046e3b8209d926430ddc7604136b6bc517b24d861a0550471eb8ed08260ff0c922d6d68a2f61cb4b2b649b0c35d386cd310aa08e3cbdbd4f3870db114cc7c6d0481ee09345a9fd5241acad155f1bb0d45bc2969756758b5652c836196a7f2bd86ea60d9b6311105a6714401d79a35ddc7d7a7b9f70cd665e74e0b6239857abe29c8e8da191399060953cc0278b8bdde68f52fba582e5e66486585b2bbeef46eaba3660a9b7817d68b3842d2fad3330eea9ea16ada45d0b6ca0906d32d42770f3d0fe56b0dd494b71d94c1b36c7fb06f7c32220b4ce953d75ca28803af29f9dfbf646bbb8fbf1a679fff4f63ee143ebffe59acdbce82dd07dec77708634c06d4730194b043dae56c539ab0682271c1b4323c53d002e7220c12acf9d8e1278804f16a1a60c1b16bbcd1f13eb8a01a4f64b057dd00808cacdc90c07ab9778b0b6567c69901571de8dd475dbdd936b6cc0526fb5e6116202fbd066bf469f5e085b5e5ad17d1d576660dc5363309b4dd42d5a490d0b1944ba16d84097c6a5ac20db64a8f9fd27a54ee0e6a14bb0a1bffcad60bb258b23b69296e2b22f2bad8a98366c8e41102f83f60dee87f35da9994440689d9d662b902a7bea94e71db4e0500075e4892636e93e3bf7ed3b6bb0f38c7671f7555032fae24df3fe5ff0bcc6e8ed7dc231cb3ecf86d6ffcb8386b8d5349b79d1edbd3adc5aa0fbd8eee00c6959fdcd6d80db8e6037c64f643296087a858bc97e5cad8a73ebb04b77560d044fe110c54b383686468f2b47428a7b005c3d66c158e4408255535d43519e3b1d252926dc21f0009f2c471d5e28424d1936f550d8322c769b3f9b6b5a3b26d6150391cbd40748ed970afff0560efaa011104dbdd014949b93192386521d0e562ff1b94beef5606dadf8d7706cfcd2202be2653deae6bc1ba9eb0b0668efb6bb27d701a6e6d3d880a5de6f9d64da6acd23c4ddd0e2c004f6a1cdb3eb60c97e8d3ebdc990ffb910b6bcb4a7ab7db0a2fb3aae15e6fbaaccc0b8a77bdd79a3c660369b717df79fa85bb4921f4675961a163288ad0bf38c742db081c330718599908a5d2e8d4b59f7ab085440b6c95045e68e4ef2fb4f4a2bdd0c479cc0cd43217d827b9660437f4f460072f85bc176fd0b86684a16476c93300461242dc565e94b9b115e565a1587701918306dd81c353d9f0282205e065b061d0bec1bdc0f51a69337e6bb52333f9d113e8880d03a8dd097243acd5620e3eb152d54f6d4297926a9c5ce3b68c1171d2bcca000eac8a550add6124d6cd2cb6b2fdf7c76eedbc1cba1e376d660e7aff023ea18ede2ee1dbda5f0aaa064f4738627f9c49be6fd09fdb889bee0798d67c63a80d0dbfb84d58bbc9a62967d9ebbb03e930cadff97b110b0af060d71abdf2b32a66836f3a26d66b4bcda7b75b8035d36b5b440f7b1");
        zzo = zzamq.$d2j$hex$b770e98c$decode_I("00000000070000000e000000090000001c0000001b0000001200000015000000380000003f000000360000003100000024000000230000002a0000002d00000070000000770000007e000000790000006c0000006b0000006200000065000000480000004f000000460000004100000054000000530000005a0000005d000000e0000000e7000000ee000000e9000000fc000000fb000000f2000000f5000000d8000000df000000d6000000d1000000c4000000c3000000ca000000cd00000090000000970000009e000000990000008c0000008b0000008200000085000000a8000000af000000a6000000a1000000b4000000b3000000ba000000bd000000c7000000c0000000c9000000ce000000db000000dc000000d5000000d2000000ff000000f8000000f1000000f6000000e3000000e4000000ed000000ea000000b7000000b0000000b9000000be000000ab000000ac000000a5000000a20000008f00000088000000810000008600000093000000940000009d0000009a0000002700000020000000290000002e0000003b0000003c00000035000000320000001f00000018000000110000001600000003000000040000000d0000000a0000005700000050000000590000005e0000004b0000004c00000045000000420000006f00000068000000610000006600000073000000740000007d0000007a000000890000008e000000870000008000000095000000920000009b0000009c000000b1000000b6000000bf000000b8000000ad000000aa000000a3000000a4000000f9000000fe000000f7000000f0000000e5000000e2000000eb000000ec000000c1000000c6000000cf000000c8000000dd000000da000000d3000000d4000000690000006e000000670000006000000075000000720000007b0000007c00000051000000560000005f000000580000004d0000004a0000004300000044000000190000001e000000170000001000000005000000020000000b0000000c00000021000000260000002f000000280000003d0000003a00000033000000340000004e00000049000000400000004700000052000000550000005c0000005b0000007600000071000000780000007f0000006a0000006d00000064000000630000003e00000039000000300000003700000022000000250000002c0000002b0000000600000001000000080000000f0000001a0000001d0000001400000013000000ae000000a9000000a0000000a7000000b2000000b5000000bc000000bb0000009600000091000000980000009f0000008a0000008d0000008400000083000000de000000d9000000d0000000d7000000c2000000c5000000cc000000cb000000e6000000e1000000e8000000ef000000fa000000fd000000f4000000f3000000");
    }

    public static long zzA(long l, long l2, long l3) {
        l3 = l + l2;
        if (((l ^ l3) & (l2 ^ l3)) >= 0L) return l3;
        return Long.MAX_VALUE;
    }

    public static long zzB(long l, long l2, long l3) {
        l3 = l - l2;
        if (((l ^ l3) & (l2 ^ l)) >= 0L) return l3;
        return Long.MIN_VALUE;
    }

    public static int zzC(int[] nArray, int n, boolean bl, boolean bl2) {
        int n2;
        int n3 = n2 = Arrays.binarySearch(nArray, n);
        if (n2 < 0) {
            n = -(n2 + 2);
        } else {
            while ((n2 = n3 - 1) >= 0) {
                n3 = n2;
                if (nArray[n2] == n) continue;
            }
            n = n2;
        }
        return n;
    }

    public static int zzD(long[] lArray, long l, boolean bl, boolean bl2) {
        int n;
        int n2 = n = Arrays.binarySearch(lArray, l);
        if (n < 0) {
            n2 = -(n + 2);
        } else {
            while ((n = n2 - 1) >= 0) {
                n2 = n;
                if (lArray[n] == l) continue;
            }
            n2 = n + 1;
        }
        n = n2;
        if (!bl2) return n;
        n = Math.max(0, n2);
        return n;
    }

    public static int zzE(long[] lArray, long l, boolean bl, boolean bl2) {
        int n;
        int n2 = n = Arrays.binarySearch(lArray, l);
        if (n < 0) {
            n ^= 0xFFFFFFFF;
        } else {
            while ((n = n2 + 1) < lArray.length) {
                n2 = n;
                if (lArray[n] == l) continue;
            }
            if (bl) return n - 1;
        }
        return n;
    }

    public static long zzF(long l) {
        long l2 = l;
        if (l == -9223372036854775807L) return l2;
        l2 = l == Long.MIN_VALUE ? l : l / 1000L;
        return l2;
    }

    public static long zzG(long l) {
        long l2 = l;
        if (l == -9223372036854775807L) return l2;
        l2 = l == Long.MIN_VALUE ? l : l * 1000L;
        return l2;
    }

    public static long zzH(long l, long l2, long l3) {
        if (l3 >= l2) {
            if (l3 % l2 == 0L) return l / (l3 / l2);
        }
        if (l3 < l2 && l2 % l3 == 0L) {
            return l * (l2 / l3);
        }
        double d = l;
        double d2 = l2;
        double d3 = l3;
        Double.isNaN(d2);
        Double.isNaN(d3);
        Double.isNaN(d);
        return (long)(d * (d2 /= d3));
    }

    public static void zzI(long[] lArray, long l, long l2) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        if (l2 >= 1000000L && l2 % 1000000L == 0L) {
            l = l2 / 1000000L;
            while (n3 < lArray.length) {
                lArray[n3] = lArray[n3] / l;
                ++n3;
            }
            return;
        }
        if (l2 < 1000000L && 1000000L % l2 == 0L) {
            l = 1000000L / l2;
            n3 = n;
            while (n3 < lArray.length) {
                lArray[n3] = lArray[n3] * l;
                ++n3;
            }
            return;
        }
        double d = l2;
        Double.isNaN(d);
        d = 1000000.0 / d;
        n3 = n2;
        while (n3 < lArray.length) {
            double d2 = lArray[n3];
            Double.isNaN(d2);
            lArray[n3] = (long)(d2 * d);
            ++n3;
        }
    }

    public static long zzJ(long l, float f) {
        if (f == 1.0f) {
            return l;
        }
        double d = l;
        double d2 = f;
        Double.isNaN(d);
        Double.isNaN(d2);
        return Math.round(d * d2);
    }

    public static long zzK(long l, float f) {
        if (f == 1.0f) {
            return l;
        }
        double d = l;
        double d2 = f;
        Double.isNaN(d);
        Double.isNaN(d2);
        return Math.round(d / d2);
    }

    public static long zzL(int n, int n2) {
        long l = n;
        return (long)n2 & 0xFFFFFFFFL | (l & 0xFFFFFFFFL) << 32;
    }

    public static String zzM(Object[] objectArray) {
        int n;
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        while (n2 < (n = objectArray.length)) {
            stringBuilder.append(objectArray[n2].getClass().getSimpleName());
            if (n2 < n - 1) {
                stringBuilder.append(", ");
            }
            ++n2;
        }
        return stringBuilder.toString();
    }

    public static zzafv zzN(int n, int n2, int n3) {
        zzaft zzaft2 = new zzaft();
        zzaft2.zzN("audio/raw");
        zzaft2.zzaa(n2);
        zzaft2.zzab(n3);
        zzaft2.zzac(n);
        return zzaft2.zzah();
    }

    public static int zzO(int n) {
        if (n == 8) return 3;
        if (n == 16) return 2;
        if (n == 24) return 0x20000000;
        if (n == 32) return 0x30000000;
        return 0;
    }

    public static boolean zzP(int n) {
        if (n == 3) return true;
        if (n == 2) return true;
        if (n == 0x10000000) return true;
        if (n == 0x20000000) return true;
        if (n == 0x30000000) return true;
        if (n != 4) return false;
        return true;
    }

    public static boolean zzQ(int n) {
        if (n == 0x20000000) return true;
        if (n == 0x30000000) return true;
        if (n != 4) return false;
        return true;
    }

    public static int zzR(int n) {
        switch (n) {
            default: {
                return 0;
            }
            case 8: {
                n = zza;
                if (n >= 23) {
                    return 6396;
                }
                if (n < 21) return 0;
                return 6396;
            }
            case 7: {
                return 1276;
            }
            case 6: {
                return 252;
            }
            case 5: {
                return 220;
            }
            case 4: {
                return 204;
            }
            case 3: {
                return 28;
            }
            case 2: {
                return 12;
            }
            case 1: 
        }
        return 4;
    }

    public static int zzS(int n, int n2) {
        if (n == 2) return n2 + n2;
        int n3 = n2;
        if (n == 3) return n3;
        if (n != 4) {
            if (n == 0x10000000) return n2 + n2;
            if (n == 0x20000000) return n2 * 3;
            if (n != 0x30000000) throw new IllegalArgumentException();
        }
        n3 = n2 * 4;
        return n3;
    }

    public static int zzT(Context context) {
        if ((context = (AudioManager)context.getSystemService("audio")) != null) return context.generateAudioSessionId();
        return -1;
    }

    public static int zzU(int n) {
        if (n == 2) return 6005;
        if (n == 4) return 6005;
        if (n == 10) return 6004;
        if (n == 7) return 6005;
        if (n == 8) return 6003;
        switch (n) {
            default: {
                switch (n) {
                    default: {
                        return 6006;
                    }
                    case 24: 
                    case 25: 
                    case 26: 
                    case 27: 
                    case 28: 
                }
                return 6002;
            }
            case 15: {
                return 6003;
            }
            case 17: 
            case 19: 
            case 20: 
            case 21: 
            case 22: {
                return 6004;
            }
            case 16: 
            case 18: 
        }
        return 6005;
    }

    public static int zzV(byte[] byArray, int n, int n2, int n3) {
        n3 = -1;
        n = 0;
        while (n < n2) {
            n3 = zzn[n3 >>> 24 ^ byArray[n] & 0xFF] ^ n3 << 8;
            ++n;
        }
        return n3;
    }

    public static int zzW(byte[] byArray, int n, int n2, int n3) {
        n3 = 0;
        while (n < n2) {
            n3 = zzo[n3 ^ byArray[n] & 0xFF];
            ++n;
        }
        return n3;
    }

    public static String zzX(Context object) {
        if (object == null) return zzflf.zzb((String)Locale.getDefault().getCountry());
        if ((object = (TelephonyManager)object.getSystemService("phone")) == null) return zzflf.zzb((String)Locale.getDefault().getCountry());
        if (TextUtils.isEmpty((CharSequence)(object = object.getNetworkCountryIso()))) return zzflf.zzb((String)Locale.getDefault().getCountry());
        return zzflf.zzb((String)object);
    }

    public static String[] zzY() {
        String[] stringArray = Resources.getSystem().getConfiguration();
        int n = zza;
        int n2 = 0;
        stringArray = n >= 24 ? stringArray.getLocales().toLanguageTags().split(",", -1) : new String[]{zzamq.zzp(stringArray.locale)};
        while (n2 < stringArray.length) {
            stringArray[n2] = zzamq.zzq(stringArray[n2]);
            ++n2;
        }
        return stringArray;
    }

    public static boolean zzZ(Context context) {
        if ((context = (UiModeManager)context.getApplicationContext().getSystemService("uimode")) == null) return false;
        if (context.getCurrentModeType() != 4) return false;
        return true;
    }

    public static byte[] zza(InputStream inputStream) throws IOException {
        int n;
        byte[] byArray = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((n = inputStream.read(byArray)) != -1) {
            byteArrayOutputStream.write(byArray, 0, n);
        }
        return byteArrayOutputStream.toByteArray();
    }

    /*
     * Enabled force condition propagation
     */
    public static Point zzaa(Context context) {
        int n;
        Object object;
        object = zza >= 17 && (object = (DisplayManager)context.getSystemService("display")) != null ? object.getDisplay(0) : null;
        DisplayManager displayManager = object;
        if (object == null) {
            object = (WindowManager)context.getSystemService("window");
            if (object == null) throw null;
            displayManager = object.getDefaultDisplay();
        }
        if (displayManager.getDisplayId() == 0 && zzamq.zzZ(context)) {
            object = zza < 28 ? zzamq.zzad("sys.display-size") : zzamq.zzad("vendor.display-size");
            if (!TextUtils.isEmpty((CharSequence)object)) {
                try {
                    Point point = ((String)object).trim().split("x", -1);
                    if (((String[])point).length == 2) {
                        n = Integer.parseInt(point[0]);
                        int n2 = Integer.parseInt(point[1]);
                        if (n > 0 && n2 > 0) {
                            point = new Point(n, n2);
                            return point;
                        }
                    }
                }
                catch (NumberFormatException numberFormatException) {
                    // empty catch block
                }
                object = ((String)(object = String.valueOf(object))).length() != 0 ? "Invalid display size: ".concat((String)object) : new String("Invalid display size: ");
                Log.e((String)"Util", (String)object);
            }
            if ("Sony".equals(zzc) && zzd.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        context = new Point();
        n = zza;
        if (n >= 23) {
            object = displayManager.getMode();
            context.x = object.getPhysicalWidth();
            context.y = object.getPhysicalHeight();
            return context;
        }
        if (n >= 17) {
            displayManager.getRealSize((Point)context);
            return context;
        }
        displayManager.getSize((Point)context);
        return context;
    }

    public static long zzab(long l) {
        l = l == -9223372036854775807L ? System.currentTimeMillis() : (l += SystemClock.elapsedRealtime());
        return l;
    }

    public static String zzac(int n) {
        if (n == 0) return "NO";
        if (n == 1) return "NO_UNSUPPORTED_TYPE";
        if (n == 2) return "NO_UNSUPPORTED_DRM";
        if (n == 3) return "NO_EXCEEDS_CAPABILITIES";
        if (n != 4) throw new IllegalStateException();
        return "YES";
    }

    private static String zzad(String string) {
        try {
            Object object = Class.forName("android.os.SystemProperties");
            object = (String)((Class)object).getMethod("get", String.class).invoke(object, string);
            return object;
        }
        catch (Exception exception) {
            string = string.length() != 0 ? "Failed to read system property ".concat(string) : new String("Failed to read system property ");
            zzaln.zzb((String)"Util", (String)string, (Throwable)exception);
            return null;
        }
    }

    /*
     * Unable to fully structure code
     */
    private static HashMap<String, String> zzae() {
        var5 = Locale.getISOLanguages();
        var3_1 = var5.length;
        var0_2 = zzamq.zzl.length;
        var4_3 = new HashMap<String, String>(var3_1 + 86);
        var2_4 = 0;
        var1_5 = 0;
        block2: while (true) {
            var0_2 = var2_4;
            if (var1_5 >= var3_1) {
                while (true) {
                    var5 = zzamq.zzl;
                    var1_5 = var5.length;
                    if (var0_2 >= 86) return var4_3;
                    var4_3.put(var5[var0_2], var5[var0_2 + 1]);
                    var0_2 += 2;
                }
            }
            var6_6 = var5[var1_5];
            try {
                var7_8 = new Locale(var6_6);
                var7_8 = var7_8.getISO3Language();
                if (!TextUtils.isEmpty((CharSequence)var7_8)) {
                    var4_3.put((String)var7_8, var6_6);
                }
lbl25:
                // 4 sources

                while (true) {
                    ++var1_5;
                    continue block2;
                    break;
                }
            }
            catch (MissingResourceException var6_7) {
                ** continue;
            }
        }
    }

    public static boolean zzb(Uri object) {
        if (TextUtils.isEmpty((CharSequence)(object = object.getScheme()))) return true;
        if (!"file".equals(object)) return false;
        return true;
    }

    public static boolean zzc(Object object, Object object2) {
        boolean bl;
        if (object == null) {
            if (object2 == null) return true;
            bl = false;
        } else {
            bl = object.equals(object2);
        }
        return bl;
    }

    @EnsuresNonNull(value={"#1"})
    public static <T> T zzd(T t) {
        return t;
    }

    @EnsuresNonNull(value={"#1"})
    public static <T> T[] zze(T[] TArray) {
        return TArray;
    }

    public static <T> T[] zzf(T[] TArray, int n) {
        boolean bl = n <= TArray.length;
        zzakt.zza((boolean)bl);
        return Arrays.copyOf(TArray, n);
    }

    public static <T> T[] zzg(T[] TArray, T[] TArray2) {
        int n = TArray.length;
        int n2 = TArray2.length;
        TArray = Arrays.copyOf(TArray, n + n2);
        System.arraycopy(TArray2, 0, TArray, n, n2);
        return TArray;
    }

    public static Handler zzh(Handler.Callback callback) {
        callback = Looper.myLooper();
        zzakt.zze((Object)callback);
        return new Handler((Looper)callback, null);
    }

    public static Handler zzi(Looper looper, Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static boolean zzj(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() != Looper.myLooper()) return handler.post(runnable);
        runnable.run();
        return true;
    }

    public static Looper zzk() {
        Looper looper = Looper.myLooper();
        if (looper == null) return Looper.getMainLooper();
        return looper;
    }

    public static ExecutorService zzl(String string) {
        return Executors.newSingleThreadExecutor((ThreadFactory)new zzamp("ExoPlayer:Loader:ProgressiveMediaPeriod"));
    }

    /*
     * Enabled force condition propagation
     */
    public static void zzm(zzaj zzaj2) {
        try {
            zzaj2.zzj();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public static boolean zzn(Parcel parcel) {
        if (parcel.readInt() == 0) return false;
        return true;
    }

    public static void zzo(Parcel parcel, boolean bl) {
        parcel.writeInt(bl ? 1 : 0);
    }

    public static String zzp(Locale object) {
        object = zza >= 21 ? ((Locale)object).toLanguageTag() : ((Locale)object).toString();
        return object;
    }

    public static String zzq(String object) {
        if (object == null) {
            return null;
        }
        String[] stringArray = ((String)object).replace('_', '-');
        Object object2 = object;
        if (!stringArray.isEmpty()) {
            object2 = object;
            if (!stringArray.equals("und")) {
                object2 = stringArray;
            }
        }
        String string = zzflf.zza((String)object2);
        object = string.split("-", 2);
        int n = 0;
        String string2 = object[0];
        if (zzk == null) {
            zzk = zzamq.zzae();
        }
        stringArray = zzk.get(string2);
        object2 = string2;
        object = string;
        if (stringArray != null) {
            object = String.valueOf(string.substring(string2.length()));
            object = ((String)object).length() != 0 ? stringArray.concat((String)object) : new String((String)stringArray);
            object2 = stringArray;
        }
        int n2 = n;
        if (!"no".equals(object2)) {
            n2 = n;
            if (!"i".equals(object2)) {
                if (!"zh".equals(object2)) return object;
                n2 = n;
            }
        }
        while (true) {
            stringArray = zzm;
            n = stringArray.length;
            object2 = object;
            if (n2 >= 18) return object2;
            if (((String)object).startsWith(stringArray[n2])) {
                object2 = String.valueOf(zzm[n2 + 1]);
                if (((String)(object = String.valueOf(((String)object).substring(zzm[n2].length())))).length() != 0) {
                    object2 = ((String)object2).concat((String)object);
                    break;
                }
                object2 = new String((String)object2);
                break;
            }
            n2 += 2;
        }
        return object2;
    }

    public static String zzr(byte[] byArray, int n, int n2) {
        return new String(byArray, n, n2, zzfll.zzc);
    }

    public static byte[] zzs(String string) {
        return string.getBytes(zzfll.zzc);
    }

    public static String[] zzt(String string, String string2) {
        return string.split(string2, -1);
    }

    public static String[] zzu(String string, String string2) {
        return string.split(string2, 2);
    }

    public static String zzv(String string, Object ... objectArray) {
        return String.format(Locale.US, string, objectArray);
    }

    public static int zzw(int n, int n2) {
        return (n + n2 - 1) / n2;
    }

    public static int zzx(int n, int n2, int n3) {
        return Math.max(n2, Math.min(n, n3));
    }

    public static long zzy(long l, long l2, long l3) {
        return Math.max(l2, Math.min(l, l3));
    }

    public static float zzz(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f, f3));
    }

    private static long[] $d2j$hex$b770e98c$decode_J(String src) {
        byte[] d = zzamq.$d2j$hex$b770e98c$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s.get(data);
        return data;
    }

    private static int[] $d2j$hex$b770e98c$decode_I(String src) {
        byte[] d = zzamq.$d2j$hex$b770e98c$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s.get(data);
        return data;
    }

    private static short[] $d2j$hex$b770e98c$decode_S(String src) {
        byte[] d = zzamq.$d2j$hex$b770e98c$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s.get(data);
        return data;
    }

    private static byte[] $d2j$hex$b770e98c$decode_B(String src) {
        char[] d = src.toCharArray();
        byte[] ret = new byte[src.length() / 2];
        int i = 0;
        while (i < ret.length) {
            int ll;
            int hh;
            char h = d[2 * i];
            char l = d[2 * i + 1];
            if (h >= '0' && h <= '9') {
                hh = h - 48;
            } else if (h >= 'a' && h <= 'f') {
                hh = h - 97 + 10;
            } else {
                if (h < 'A') throw new RuntimeException();
                if (h > 'F') throw new RuntimeException();
                hh = h - 65 + 10;
            }
            if (l >= '0' && l <= '9') {
                ll = l - 48;
            } else if (l >= 'a' && l <= 'f') {
                ll = l - 97 + 10;
            } else {
                if (l < 'A') throw new RuntimeException();
                if (l > 'F') throw new RuntimeException();
                ll = l - 65 + 10;
            }
            ret[i] = (byte)(hh << 4 | ll);
            ++i;
        }
        return ret;
    }
}
