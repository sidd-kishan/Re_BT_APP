/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.bigkoo.pickerview.utils;

import android.util.Log;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Date;
import java.util.GregorianCalendar;

public class LunarCalendar {
    private static final int[] DAYS_BEFORE_MONTH = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
    private static final int[] LUNAR_INFO = LunarCalendar.$d2j$hex$3af01d4f$decode_I("bfb6840053ae040048570a00bd26550050260d0044950d00b9aa46004d6a050042ad0900b6ae24004aae0400be4d6a00524d0a0046250d00ba525d004e540b00436a0d00376d29004b5b0900c19b740054970400484b0a00bc255b0050a5060045d40600b8da4a004db6020042570900b79724004a9704003e4b6600514a0d0046a50e00bad456004ead050044b60200383739004b2e0900bf967c0053950c00484a0d003ba56d004f550b00456a0500b9ad4a004d5d0200422d0900b6952c004a950a00bd4a7b0051ca060046550b00bb5a55004eda0400435b0a00b82b35004c2b05003f958a0052950e0048aa06003cd56a004fb50a0045b6040039574a004d570a004226050035933e0049950d00beaa7500516a0500466d0900bbae54004fad0400434d0a00b7264d004b250d00bf528d0052540b00476a0b003c6d6900505b0900459b0400b94b4a004d4b0a00c225ab0054a5060049d406003dda6a0051b60a0046570900bb9754004f970400444b060037a536004aa50e00bfb2860053ac050047b60a00bc365900502e090045960c00b84a4d004c4a0d0041a50d00b6aa2500496a0500bdad7a00525d0200472d0900ba955c004e950a00434a0b0037554b004ad50a00bf5a950053ba0400485b0a00bc2b6500502b050045930a00b94a47004caa060041d50a00b6da24004ab604003d576a00514e0a0046260d003a935e004d530d0043aa050037b536004b6d0900bfaeb40053ad0400484d0a00bc256d004f250d0044520d0038aa5d004c5a0b00416d0500b6ad24004a9b0400be4b7a00514b0a0046a50a00ba525b004ed2060042da0a00375b35004b370900c197840053970400484b06003ca566004fa50e0044aa060038b64a004cae0a00422e090035973c0049960c00bd4a7d00514a0d0045a50d00baaa55004e6a0500436d0a00b72e45004b2d0500bf958a0053950a00474a0b003b556b004fd50a00455a0500385d4a004c5b0a00422b0500b6933a0049930600bd29770051aa060046d50a00bada54004eb6040043570a00382745004a260d003e938e0052520d0047aa0d003bb566004f6d050045ae0400b94e4a004c4d0a0041150d00b5922d00");
    public static final int MAX_YEAR = 2099;
    public static final int MIN_YEAR = 1900;
    private static int[] lunar_month_days;
    private static int[] solar_1_1;

    static {
        solar_1_1 = LunarCalendar.$d2j$hex$3af01d4f$decode_I("5f0700004cc00e003fc20e0035c40e0049c60e003ec80e0051ca0e0046cc0e003ace0e004dd00e0042d20e0036d40e004ad60e003fd80e0053da0e0048dc0e003dde0e0050e00e0044e20e0039e40e004de60e0042e80e0036ea0e004aec0e003eee0e0052f00e0046f20e003af40e004ef60e0043f80e0037fa0e004bfc0e0041fe0e0054000f0048020f003c040f0050060f0045080f00380a0f004d0c0f00420e0f0037100f004a120f003e140f0051160f0046180f003a1a0f004e1c0f00441e0f0038200f004b220f003f240f0053260f0048280f003b2a0f004f2c0f00452e0f0039300f004d320f0042340f0036360f004a380f003d3a0f00513c0f00463e0f003b400f004e420f0043440f0038460f004c480f003f4a0f00524c0f00484e0f003c500f004f520f0045540f0039560f004d580f00425a0f00355c0f00495e0f003e600f0051620f0046640f003b660f004f680f00436a0f00376c0f004b6e0f003f700f0052720f0047740f003c760f0050780f00457a0f00397c0f004d7e0f0042800f0054820f0049840f003d860f0051880f00468a0f003b8c0f004f8e0f0044900f0037920f004a940f003f960f0053980f00479a0f003c9c0f00509e0f0045a00f0038a20f004ca40f0041a60f0036a80f0049aa0f003dac0f0052ae0f0047b00f003ab20f004eb40f0043b60f0037b80f004aba0f003fbc0f0053be0f0048c00f003cc20f0050c40f0045c60f0039c80f004cca0f0041cc0f0036ce0f004ad00f003dd20f0051d40f0046d60f003ad80f004dda0f0043dc0f0037de0f004be00f003fe20f0053e40f0048e60f003ce80f004fea0f0044ec0f0038ee0f004cf00f0041f20f0036f40f004af60f003ef80f0051fa0f0046fc0f003afe0f004e00100042021000370410004b06100041081000530a1000480c10003c0e10004f10100044121000381410004c16100042181000351a1000491c10003d1e100051201000452210003a2410004e26100043281000372a10004b2c10003f2e100053301000473210003b3410004f36100045381000383a10004c3c1000423e100036401000494210003d44100051461000464810003a4a10004e4c1000434e1000385010004a5210003e54100052561000475810003b5a10004f5c1000455e1000396010004c6210004164100035661000496810003d6a1000516c1000476e10003c7010004f72100044741000387610004c7810003f7a1000537c1000487e1000");
        lunar_month_days = LunarCalendar.$d2j$hex$3af01d4f$decode_I("5f07000094160000aa160000d54a0000b60a0000b7c40000ae040000560a00002ab500002a1d0000540d0000aa7500006a1500006d0901005c090000ae1400004daa00004c1a00002a1b0000558d0000d40a00005a1300005d4900005c0900009bd400009a1400004a1a0000a5ba0000a8160000d41a0000da520000b612000037e900002e090000961400004bb600004a0d0000a80d0000b59500006c050000ae1200002f4900002e09000096cc0000941a00004a1d0000a9ad00005a0b00006c0500006e7200005c1200002df900002a190000941a00004adb0000aa160000d40a00005b950000ba0400005a1200002b5900002a15000095f60000940d0000aa160000b5aa0000b4090000b6140000576a0000560a00002a1501002a1d0000540d0000aad500006a1500006c090000ae940000ae1400004c0a0000267d00002a1b000055eb0000d40a0000da1200005da900005a0900009a1400004d9a00004a1a0000a51a0100a8160000d4160000dad20000b61200003609000097940000961400004b5601004a0d0000a80d0000b4d500006c150000ae1200002fa900002e090000960c00004a6d00004a1d0000650d0100580b00006c1500006db200005c1200002c190000959a0000941a00004a1b0000554b0000d40a00005bf50000ba0400005a1200002bb900002a15000094160000aa960000aa150000b52a010074090000b614000057ca0000560a000026150000958e0000540d0000aa150000b54900006c090000aed400009c1400004c1a000026bd0000a61a0000540b00006a6d0000da1200005d6901005a0900009a1400004bda00004a1a0000a41a000054bb0000b4160000da0a00005b4900003609000097f40000961400004a150000a5b60000a40d0000b4150000b66a00006e1200002f0901002e090000960c00004acd00004a1d0000640d00006c9500005c1500005c1200002e7900002c19000095fa0000941a00004a1b000055ab0000d40a0000da1400005d8a00005a0a00002b1501002a15000094160000aad60000aa150000b40a0000ba940000b6140000560a000027750000260d000053ee0000540d0000aa150000b5a900006c090000ae1400004e8a00004c1a0000261d0100a41a0000541b00006acd0000da0a00005c0900009d9400009a1400002a1a0000255b0000a41a000052fb0000b4160000ba0a00005ba9000036090000961400004b9a00004a150000a5360100a40d0000ac150000");
    }

    private static int daysInLunarMonth(int n, int n2) {
        if ((LUNAR_INFO[n - 1900] & 0x100000 >> n2) != 0) return 30;
        return 29;
    }

    private static int daysInLunarYear(int n) {
        int n2 = LunarCalendar.leapMonth(n) != 0 ? 377 : 348;
        int n3 = LUNAR_INFO[n - 1900];
        n = 524288;
        int n4 = n2;
        while (n > 7) {
            n2 = n4;
            if ((n3 & 0xFFF80 & n) != 0) {
                n2 = n4 + 1;
            }
            n >>= 1;
            n4 = n2;
        }
        return n4;
    }

    public static final int daysInMonth(int n, int n2) {
        return LunarCalendar.daysInMonth(n, n2, false);
    }

    public static final int daysInMonth(int n, int n2, boolean bl) {
        int n3 = LunarCalendar.leapMonth(n);
        int n4 = n3 != 0 && n2 > n3 ? 1 : 0;
        if (!bl) {
            return LunarCalendar.daysInLunarMonth(n, n2 + n4);
        }
        if (n3 == 0) return 0;
        if (n3 != n2) return 0;
        return LunarCalendar.daysInLunarMonth(n, n2 + 1);
    }

    private static int getBitInt(int n, int n2, int n3) {
        return (n & (1 << n2) - 1 << n3) >> n3;
    }

    public static int leapMonth(int n) {
        return (LUNAR_INFO[n - 1900] & 0xF00000) >> 20;
    }

    public static final int[] lunarToSolar(int n, int n2, int n3, boolean bl) {
        int n4;
        int n5;
        int n6;
        int[] nArray;
        block25: {
            block24: {
                block22: {
                    block23: {
                        if (n >= 1900 && n <= 2099 && n2 >= 1 && n2 <= 12 && n3 >= 1 && n3 <= 30) {
                            nArray = LUNAR_INFO;
                            n6 = n - 1900;
                            n4 = n5 = (nArray[n6] & 0x1F) - 1;
                            if ((nArray[n6] & 0x60) >> 5 == 2) {
                                n4 = n5 + 31;
                            }
                        } else {
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Illegal lunar date, must be like that:\n\tyear : 1900~2099\n\tmonth : 1~12\n\tday : 1~30");
                            throw illegalArgumentException;
                        }
                        for (n5 = 1; n5 < n2; ++n5) {
                            if ((524288 >> n5 - 1 & LUNAR_INFO[n6]) == 0) {
                                n4 += 29;
                                continue;
                            }
                            n4 += 30;
                        }
                        n4 += n3;
                        n5 = (LUNAR_INFO[n6] & 0xF00000) >> 20;
                        n3 = n4;
                        if (n5 == 0) break block22;
                        if (n2 > n5) break block23;
                        n3 = n4;
                        if (n2 != n5) break block22;
                        n3 = n4;
                        if (!bl) break block22;
                    }
                    n3 = (524288 >> n2 - 1 & LUNAR_INFO[n6]) == 0 ? n4 + 29 : n4 + 30;
                }
                if (n3 > 366) break block24;
                n2 = n3;
                n4 = n;
                if (n % 4 == 0) break block25;
                n2 = n3;
                n4 = n;
                if (n3 <= 365) break block25;
            }
            n2 = (n4 = n + 1) % 4 == 1 ? n3 - 366 : n3 - 365;
        }
        nArray = new int[3];
        for (n = 1; n < 13; ++n) {
            n5 = DAYS_BEFORE_MONTH[n];
            n6 = n4 % 4;
            n3 = n5;
            if (n6 == 0) {
                n3 = n5;
                if (n > 2) {
                    n3 = n5 + 1;
                }
            }
            if (n6 == 0 && n == 2 && n3 + 1 == n2) {
                nArray[1] = n;
                nArray[2] = n2 - 31;
                break;
            }
            if (n3 < n2) continue;
            nArray[1] = n;
            int[] nArray2 = DAYS_BEFORE_MONTH;
            int n7 = n - 1;
            n3 = n5 = nArray2[n7];
            if (n6 == 0) {
                n3 = n5;
                if (n > 2) {
                    n3 = n5 + 1;
                }
            }
            if (n2 > n3) {
                nArray[2] = n2 - n3;
                break;
            }
            if (n2 == n3) {
                if (n6 == 0 && n == 2) {
                    nArray2 = DAYS_BEFORE_MONTH;
                    nArray[2] = nArray2[n] - nArray2[n7] + 1;
                    break;
                }
                nArray2 = DAYS_BEFORE_MONTH;
                nArray[2] = nArray2[n] - nArray2[n7];
                break;
            }
            nArray[2] = n2;
            break;
        }
        nArray[0] = n4;
        return nArray;
    }

    private static long solarToInt(int n, int n2, int n3) {
        n2 = (n2 + 9) % 12;
        return (n -= n2 / 10) * 365 + n / 4 - n / 100 + n / 400 + (n2 * 306 + 5) / 10 + (n3 - 1);
    }

    public static final int[] solarToLunar(int n, int n2, int n3) {
        int n4;
        int[] nArray = new int[4];
        int[] nArray2 = solar_1_1;
        int n5 = 0;
        int n6 = n4 = n - nArray2[0];
        if (nArray2[n4] > (n << 9 | n2 << 5 | n3)) {
            n6 = n4 - 1;
        }
        int n7 = solar_1_1[n6];
        n4 = LunarCalendar.getBitInt(n7, 12, 9);
        int n8 = LunarCalendar.getBitInt(n7, 4, 5);
        n7 = LunarCalendar.getBitInt(n7, 5, 0);
        long l = LunarCalendar.solarToInt(n, n2, n3);
        long l2 = LunarCalendar.solarToInt(n4, n8, n7);
        n7 = lunar_month_days[n6];
        n4 = LunarCalendar.getBitInt(n7, 4, 13);
        n8 = solar_1_1[0];
        l2 = l - l2 + 1L;
        n = 1;
        for (n2 = 0; n2 < 13 && l2 > (l = (long)(n3 = LunarCalendar.getBitInt(n7, 1, 12 - n2) == 1 ? 30 : 29)); ++n, l2 -= l, ++n2) {
        }
        n3 = (int)l2;
        nArray[0] = n6 + n8;
        nArray[1] = n;
        n2 = n5;
        if (n4 != 0) {
            n2 = n5;
            if (n > n4) {
                nArray[1] = n - 1;
                n2 = n5;
                if (n == n4 + 1) {
                    n2 = 1;
                }
            }
        }
        nArray[2] = n3;
        nArray[3] = n2;
        return nArray;
    }

    @Deprecated
    public static final int[] solarToLunarDeprecated(int n, int n2, int n3) {
        int n4;
        int n5 = 1900;
        int n6 = 0;
        Serializable serializable = new GregorianCalendar(1900, 0, 31).getTime();
        int n7 = 0;
        for (n4 = (int)((new GregorianCalendar(n, n2 - 1, n3).getTime().getTime() - ((Date)serializable).getTime()) / 86400000L); n5 <= 2099 && n4 > 0; n4 -= n7, ++n5) {
            n7 = LunarCalendar.daysInLunarYear(n5);
        }
        int n8 = n4;
        int n9 = n5;
        if (n4 < 0) {
            n8 = n4 + n7;
            n9 = n5 - 1;
        }
        int n10 = LunarCalendar.leapMonth(n9);
        n7 = 0;
        for (n4 = 1; n4 <= 13 && n8 > 0; n8 -= n7, ++n4) {
            n7 = LunarCalendar.daysInLunarMonth(n9, n4);
        }
        int n11 = n6;
        n5 = n4;
        if (n10 != 0) {
            n11 = n6;
            n5 = n4;
            if (n4 > n10) {
                --n4;
                serializable = new StringBuilder();
                ((StringBuilder)serializable).append(n);
                ((StringBuilder)serializable).append("-");
                ((StringBuilder)serializable).append(n2);
                ((StringBuilder)serializable).append("-");
                ((StringBuilder)serializable).append(n3);
                ((StringBuilder)serializable).append("====>");
                ((StringBuilder)serializable).append(n4);
                ((StringBuilder)serializable).append("-");
                ((StringBuilder)serializable).append(n10);
                Log.i((String)"----------->", (String)((StringBuilder)serializable).toString());
                n11 = n6;
                n5 = n4;
                if (n4 == n10) {
                    n11 = 1;
                    n5 = n4;
                }
            }
        }
        n2 = n8;
        n = n5;
        if (n8 >= 0) return new int[]{n9, n, n2 + 1, n11};
        n2 = n8 + n7;
        n = n5 - 1;
        return new int[]{n9, n, n2 + 1, n11};
    }

    private static long[] $d2j$hex$3af01d4f$decode_J(String src) {
        byte[] d = LunarCalendar.$d2j$hex$3af01d4f$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s.get(data);
        return data;
    }

    private static int[] $d2j$hex$3af01d4f$decode_I(String src) {
        byte[] d = LunarCalendar.$d2j$hex$3af01d4f$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s.get(data);
        return data;
    }

    private static short[] $d2j$hex$3af01d4f$decode_S(String src) {
        byte[] d = LunarCalendar.$d2j$hex$3af01d4f$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s.get(data);
        return data;
    }

    private static byte[] $d2j$hex$3af01d4f$decode_B(String src) {
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
