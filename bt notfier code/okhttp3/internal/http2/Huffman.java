/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.Util
 *  okhttp3.internal.http2.Huffman$Node
 *  okio.BufferedSink
 *  okio.BufferedSource
 *  okio.ByteString
 */
package okhttp3.internal.http2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Huffman;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lokhttp3/internal/http2/Huffman;", "", "()V", "CODES", "", "CODE_BIT_COUNTS", "", "root", "Lokhttp3/internal/http2/Huffman$Node;", "addCode", "", "symbol", "", "code", "codeBitCount", "decode", "source", "Lokio/BufferedSource;", "byteCount", "", "sink", "Lokio/BufferedSink;", "encode", "Lokio/ByteString;", "encodedLength", "bytes", "Node", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Huffman {
    private static final int[] CODES;
    private static final byte[] CODE_BIT_COUNTS;
    public static final Huffman INSTANCE;
    private static final Node root;

    static {
        INSTANCE = new Huffman();
        CODES = Huffman.$d2j$hex$580f9afb$decode_I("f81f0000d8ff7f00e2ffff0fe3ffff0fe4ffff0fe5ffff0fe6ffff0fe7ffff0fe8ffff0feaffff00fcffff3fe9ffff0feaffff0ffdffff3febffff0fecffff0fedffff0feeffff0fefffff0ff0ffff0ff1ffff0ff2ffff0ffeffff3ff3ffff0ff4ffff0ff5ffff0ff6ffff0ff7ffff0ff8ffff0ff9ffff0ffaffff0ffbffff0f14000000f8030000f9030000fa0f0000f91f000015000000f8000000fa070000fa030000fb030000f9000000fb070000fa000000160000001700000018000000000000000100000002000000190000001a0000001b0000001c0000001d0000001e0000001f0000005c000000fb000000fc7f000020000000fb0f0000fc030000fa1f0000210000005d0000005e0000005f000000600000006100000062000000630000006400000065000000660000006700000068000000690000006a0000006b0000006c0000006d0000006e0000006f000000700000007100000072000000fc00000073000000fd000000fb1f0000f0ff0700fc1f0000fc3f000022000000fd7f0000030000002300000004000000240000000500000025000000260000002700000006000000740000007500000028000000290000002a000000070000002b000000760000002c00000008000000090000002d0000007700000078000000790000007a0000007b000000fe7f0000fc070000fd3f0000fd1f0000fcffff0fe6ff0f00d2ff3f00e7ff0f00e8ff0f00d3ff3f00d4ff3f00d5ff3f00d9ff7f00d6ff3f00daff7f00dbff7f00dcff7f00ddff7f00deff7f00ebffff00dfff7f00ecffff00edffff00d7ff3f00e0ff7f00eeffff00e1ff7f00e2ff7f00e3ff7f00e4ff7f00dcff1f00d8ff3f00e5ff7f00d9ff3f00e6ff7f00e7ff7f00efffff00daff3f00ddff1f00e9ff0f00dbff3f00dcff3f00e8ff7f00e9ff7f00deff1f00eaff7f00ddff3f00deff3f00f0ffff00dfff1f00dfff3f00ebff7f00ecff7f00e0ff1f00e1ff1f00e0ff3f00e2ff1f00edff7f00e1ff3f00eeff7f00efff7f00eaff0f00e2ff3f00e3ff3f00e4ff3f00f0ff7f00e5ff3f00e6ff3f00f1ff7f00e0ffff03e1ffff03ebff0f00f1ff0700e7ff3f00f2ff7f00e8ff3f00ecffff01e2ffff03e3ffff03e4ffff03deffff07dfffff07e5ffff03f1ffff00edffff01f2ff0700e3ff1f00e6ffff03e0ffff07e1ffff07e7ffff03e2ffff07f2ffff00e4ff1f00e5ff1f00e8ffff03e9ffff03fdffff0fe3ffff07e4ffff07e5ffff07ecff0f00f3ffff00edff0f00e6ff1f00e9ff3f00e7ff1f00e8ff1f00f3ff7f00eaff3f00ebff3f00eeffff01efffff01f4ffff00f5ffff00eaffff03f4ff7f00ebffff03e6ffff07ecffff03edffff03e7ffff07e8ffff07e9ffff07eaffff07ebffff07feffff0fecffff07edffff07eeffff07efffff07f0ffff07eeffff03");
        CODE_BIT_COUNTS = new byte[]{13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
        root = new Node();
        int n = CODE_BIT_COUNTS.length - 1;
        if (n < 0) return;
        int n2 = 0;
        while (true) {
            int n3 = n2 + 1;
            INSTANCE.addCode(n2, CODES[n2], CODE_BIT_COUNTS[n2]);
            if (n3 > n) {
                return;
            }
            n2 = n3;
        }
    }

    private Huffman() {
    }

    private final void addCode(int n, int n2, int n3) {
        Node node = new Node(n, n3);
        Node node2 = root;
        while (true) {
            Node node3;
            if (n3 <= 8) {
                n = 8 - n3;
                n2 = n2 << n & 0xFF;
                node2 = node2.getChildren();
                Intrinsics.checkNotNull((Object)node2);
                ArraysKt.fill((Object[])node2, (Object)node, (int)n2, (int)((1 << n) + n2));
                return;
            }
            n = n2 >>> (n3 -= 8) & 0xFF;
            Node[] nodeArray = node2.getChildren();
            Intrinsics.checkNotNull((Object)nodeArray);
            node2 = node3 = nodeArray[n];
            if (node3 != null) continue;
            nodeArray[n] = node2 = new Node();
        }
    }

    public final void decode(BufferedSource node, long l, BufferedSink bufferedSink) {
        int n;
        Intrinsics.checkNotNullParameter((Object)node, (String)"source");
        Intrinsics.checkNotNullParameter((Object)bufferedSink, (String)"sink");
        Node node2 = root;
        int n2 = 0;
        int n3 = 0;
        if (0L >= l) {
            n = 0;
        } else {
            long l2;
            long l3 = 0L;
            int n4 = 0;
            Node node3 = node2;
            do {
                l2 = l3 + 1L;
                n = n3 << 8 | Util.and((byte)node.readByte(), (int)255);
                n2 = n4 + 8;
                node2 = node3;
                while (n2 >= 8) {
                    node2 = node2.getChildren();
                    Intrinsics.checkNotNull((Object)node2);
                    node2 = node2[n >>> n2 - 8 & 0xFF];
                    Intrinsics.checkNotNull((Object)node2);
                    if (node2.getChildren() == null) {
                        bufferedSink.writeByte(node2.getSymbol());
                        n2 -= node2.getTerminalBitCount();
                        node2 = root;
                        continue;
                    }
                    n2 -= 8;
                }
                node3 = node2;
                n3 = n;
                n4 = n2;
                l3 = l2;
            } while (l2 < l);
        }
        while (n2 > 0) {
            node = node2.getChildren();
            Intrinsics.checkNotNull((Object)node);
            node = node[n << 8 - n2 & 0xFF];
            Intrinsics.checkNotNull((Object)node);
            if (node.getChildren() != null) return;
            if (node.getTerminalBitCount() > n2) {
                return;
            }
            bufferedSink.writeByte(node.getSymbol());
            n2 -= node.getTerminalBitCount();
            node2 = root;
        }
    }

    public final void encode(ByteString byteString, BufferedSink bufferedSink) throws IOException {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"source");
        Intrinsics.checkNotNullParameter((Object)bufferedSink, (String)"sink");
        int n = byteString.size();
        int n2 = 0;
        int n3 = 0;
        long l = 0L;
        if (n > 0) {
            l = 0L;
            n2 = 0;
            while (true) {
                int n4 = n3 + 1;
                int n5 = Util.and((byte)byteString.getByte(n3), (int)255);
                n3 = CODES[n5];
                n5 = CODE_BIT_COUNTS[n5];
                l = l << n5 | (long)n3;
                n2 += n5;
                while (n2 >= 8) {
                    bufferedSink.writeByte((int)(l >> (n2 -= 8)));
                }
                if (n4 >= n) break;
                n3 = n4;
            }
        }
        if (n2 <= 0) return;
        bufferedSink.writeByte((int)(l << 8 - n2 | 255L >>> n2));
    }

    public final int encodedLength(ByteString byteString) {
        long l;
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"bytes");
        int n = byteString.size();
        long l2 = l = 0L;
        if (n <= 0) return (int)(l2 + (long)7 >> 3);
        int n2 = 0;
        while (true) {
            int n3 = n2 + 1;
            n2 = Util.and((byte)byteString.getByte(n2), (int)255);
            l2 = l + (long)CODE_BIT_COUNTS[n2];
            if (n3 >= n) {
                return (int)(l2 + (long)7 >> 3);
            }
            n2 = n3;
            l = l2;
        }
    }

    private static long[] $d2j$hex$580f9afb$decode_J(String src) {
        byte[] d = Huffman.$d2j$hex$580f9afb$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s.get(data);
        return data;
    }

    private static int[] $d2j$hex$580f9afb$decode_I(String src) {
        byte[] d = Huffman.$d2j$hex$580f9afb$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s.get(data);
        return data;
    }

    private static short[] $d2j$hex$580f9afb$decode_S(String src) {
        byte[] d = Huffman.$d2j$hex$580f9afb$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s.get(data);
        return data;
    }

    private static byte[] $d2j$hex$580f9afb$decode_B(String src) {
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
