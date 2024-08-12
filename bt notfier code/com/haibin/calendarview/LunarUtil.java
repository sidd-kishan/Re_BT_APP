/*
 * Decompiled with CFR 0.152.
 */
package com.haibin.calendarview;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public final class LunarUtil {
    private static int[] LUNAR_MONTH_DAYS = LunarUtil.$d2j$hex$6da712c8$decode_I("5f07000094160000aa160000d54a0000b60a0000b7c40000ae040000560a00002ab500002a1d0000540d0000aa7500006a1500006d0901005c090000ae1400004daa00004c1a00002a1b0000558d0000d40a00005a1300005d4900005c0900009bd400009a1400004a1a0000a5ba0000a8160000d41a0000da520000b612000037e900002e090000961400004bb600004a0d0000a80d0000b59500006c050000ae1200002f4900002e09000096cc0000941a00004a1d0000a9ad00005a0b00006c0500006e7200005c1200002df900002a190000941a00004adb0000aa160000d40a00005b950000ba0400005a1200002b5900002a15000095f60000940d0000aa160000b5aa0000b4090000b6140000576a0000560a00002a1501002a1d0000540d0000aad500006a1500006c090000ae940000ae1400004c0a0000267d00002a1b000055eb0000d40a0000da1200005da900005a0900009a1400004d9a00004a1a0000a51a0100a8160000d4160000dad20000b61200003609000097940000961400004b5601004a0d0000a80d0000b4d500006c150000ae1200002fa900002e090000960c00004a6d00004a1d0000650d0100580b00006c1500006db200005c1200002c190000959a0000941a00004a1b0000554b0000d40a00005bf50000ba0400005a1200002bb900002a15000094160000aa960000aa150000b52a010074090000b614000057ca0000560a000026150000958e0000540d0000aa150000b54900006c090000aed400009c1400004c1a000026bd0000a61a0000540b00006a6d0000da1200005d6901005a0900009a1400004bda00004a1a0000a41a000054bb0000b4160000da0a00005b4900003609000097f40000961400004a150000a5b60000a40d0000b4150000b66a00006e1200002f0901002e090000960c00004acd00004a1d0000640d00006c9500005c1500005c1200002e7900002c19000095fa0000941a00004a1b000055ab0000d40a0000da1400005d8a00005a0a00002b1501002a15000094160000aad60000aa150000b40a0000ba940000b6140000560a000027750000260d000053ee0000540d0000aa150000b5a900006c090000ae1400004e8a00004c1a0000261d0100a41a0000541b00006acd0000da0a00005c0900009d9400009a1400002a1a0000255b0000a41a000052fb0000b4160000ba0a00005ba9000036090000961400004b9a00004a150000a5360100a40d0000ac150000");
    private static int[] SOLAR = LunarUtil.$d2j$hex$6da712c8$decode_I("5f0700004cc00e003fc20e0035c40e0049c60e003ec80e0051ca0e0046cc0e003ace0e004dd00e0042d20e0036d40e004ad60e003fd80e0053da0e0048dc0e003dde0e0050e00e0044e20e0039e40e004de60e0042e80e0036ea0e004aec0e003eee0e0052f00e0046f20e003af40e004ef60e0043f80e0037fa0e004bfc0e0041fe0e0054000f0048020f003c040f0050060f0045080f00380a0f004d0c0f00420e0f0037100f004a120f003e140f0051160f0046180f003a1a0f004e1c0f00441e0f0038200f004b220f003f240f0053260f0048280f003b2a0f004f2c0f00452e0f0039300f004d320f0042340f0036360f004a380f003d3a0f00513c0f00463e0f003b400f004e420f0043440f0038460f004c480f003f4a0f00524c0f00484e0f003c500f004f520f0045540f0039560f004d580f00425a0f00355c0f00495e0f003e600f0051620f0046640f003b660f004f680f00436a0f00376c0f004b6e0f003f700f0052720f0047740f003c760f0050780f00457a0f00397c0f004d7e0f0042800f0054820f0049840f003d860f0051880f00468a0f003b8c0f004f8e0f0044900f0037920f004a940f003f960f0053980f00479a0f003c9c0f00509e0f0045a00f0038a20f004ca40f0041a60f0036a80f0049aa0f003dac0f0052ae0f0047b00f003ab20f004eb40f0043b60f0037b80f004aba0f003fbc0f0053be0f0048c00f003cc20f0050c40f0045c60f0039c80f004cca0f0041cc0f0036ce0f004ad00f003dd20f0051d40f0046d60f003ad80f004dda0f0043dc0f0037de0f004be00f003fe20f0053e40f0048e60f003ce80f004fea0f0044ec0f0038ee0f004cf00f0041f20f0036f40f004af60f003ef80f0051fa0f0046fc0f003afe0f004e00100042021000370410004b06100041081000530a1000480c10003c0e10004f10100044121000381410004c16100042181000351a1000491c10003d1e100051201000452210003a2410004e26100043281000372a10004b2c10003f2e100053301000473210003b3410004f36100045381000383a10004c3c1000423e100036401000494210003d44100051461000464810003a4a10004e4c1000434e1000385010004a5210003e54100052561000475810003b5a10004f5c1000455e1000396010004c6210004164100035661000496810003d6a1000516c1000476e10003c7010004f72100044741000387610004c7810003f7a1000537c1000487e1000");

    private static int getBitInt(int n, int n2, int n3) {
        return (n & (1 << n2) - 1 << n3) >> n3;
    }

    public static int[] lunarToSolar(int n, int n2, int n3, boolean bl) {
        int n4;
        int n5;
        int n6;
        int[] nArray;
        block6: {
            block4: {
                block5: {
                    nArray = LUNAR_MONTH_DAYS;
                    n6 = nArray[n - nArray[0]];
                    n5 = LunarUtil.getBitInt(n6, 4, 13);
                    if (bl) break block4;
                    if (n2 <= n5) break block5;
                    n4 = n2;
                    if (n5 != 0) break block6;
                }
                n4 = n2 - 1;
                break block6;
            }
            n4 = n5;
        }
        n2 = 0;
        n5 = 0;
        while (true) {
            if (n2 >= n4) {
                nArray = SOLAR;
                n = nArray[n - nArray[0]];
                return LunarUtil.solarFromInt(LunarUtil.solarToInt(LunarUtil.getBitInt(n, 12, 9), LunarUtil.getBitInt(n, 4, 5), LunarUtil.getBitInt(n, 5, 0)) + (long)(n5 + n3) - 1L);
            }
            int n7 = LunarUtil.getBitInt(n6, 1, 12 - n2) == 1 ? 30 : 29;
            n5 += n7;
            ++n2;
        }
    }

    private static int[] solarFromInt(long l) {
        long l2 = (10000L * l + 14780L) / 3652425L;
        long l3 = l - (l2 * 365L + l2 / 4L - l2 / 100L + l2 / 400L);
        long l4 = l2;
        long l5 = l3;
        if (l3 < 0L) {
            l4 = l2 - 1L;
            l5 = l - (365L * l4 + l4 / 4L - l4 / 100L + l4 / 400L);
        }
        l3 = (100L * l5 + 52L) / 3060L;
        l2 = 2L + l3;
        l = l2 / 12L;
        l3 = (l3 * 306L + 5L) / 10L;
        int[] nArray = new int[4];
        nArray[0] = (int)(l4 + l);
        nArray[1] = (int)(l2 % 12L + 1L);
        nArray[2] = (int)(l5 - l3 + 1L);
        return nArray;
    }

    private static long solarToInt(int n, int n2, int n3) {
        n2 = (n2 + 9) % 12;
        return (n -= n2 / 10) * 365 + n / 4 - n / 100 + n / 400 + (n2 * 306 + 5) / 10 + (n3 - 1);
    }

    public static int[] solarToLunar(int n, int n2, int n3) {
        int n4;
        int[] nArray = new int[4];
        int[] nArray2 = SOLAR;
        int n5 = n4 = n - nArray2[0];
        if (nArray2[n4] > (n << 9 | n2 << 5 | n3)) {
            n5 = n4 - 1;
        }
        int n6 = SOLAR[n5];
        int n7 = LunarUtil.getBitInt(n6, 12, 9);
        n4 = LunarUtil.getBitInt(n6, 4, 5);
        n6 = LunarUtil.getBitInt(n6, 5, 0);
        long l = LunarUtil.solarToInt(n, n2, n3);
        long l2 = LunarUtil.solarToInt(n7, n4, n6);
        n6 = LUNAR_MONTH_DAYS[n5];
        n7 = LunarUtil.getBitInt(n6, 4, 13);
        n4 = SOLAR[0];
        l = l - l2 + 1L;
        n = 1;
        for (n2 = 0; n2 < 13 && l > (l2 = (long)(n3 = LunarUtil.getBitInt(n6, 1, 12 - n2) == 1 ? 30 : 29)); ++n, l -= l2, ++n2) {
        }
        n2 = (int)l;
        nArray[0] = n5 + n4;
        nArray[1] = n;
        nArray[3] = 0;
        if (n7 != 0 && n > n7) {
            nArray[1] = n - 1;
            if (n == n7 + 1) {
                nArray[3] = 1;
            }
        }
        nArray[2] = n2;
        return nArray;
    }

    private static long[] $d2j$hex$6da712c8$decode_J(String src) {
        byte[] d = LunarUtil.$d2j$hex$6da712c8$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s.get(data);
        return data;
    }

    private static int[] $d2j$hex$6da712c8$decode_I(String src) {
        byte[] d = LunarUtil.$d2j$hex$6da712c8$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s.get(data);
        return data;
    }

    private static short[] $d2j$hex$6da712c8$decode_S(String src) {
        byte[] d = LunarUtil.$d2j$hex$6da712c8$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s.get(data);
        return data;
    }

    private static byte[] $d2j$hex$6da712c8$decode_B(String src) {
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
