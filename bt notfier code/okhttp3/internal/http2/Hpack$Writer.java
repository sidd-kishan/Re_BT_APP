/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.http2.Header
 *  okhttp3.internal.http2.Hpack
 *  okhttp3.internal.http2.Huffman
 *  okio.Buffer
 *  okio.BufferedSink
 *  okio.ByteString
 */
package okhttp3.internal.http2;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Header;
import okhttp3.internal.http2.Hpack;
import okhttp3.internal.http2.Huffman;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010\u001e\u001a\u00020\u00142\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0 J\u001e\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003R\u001c\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2={"Lokhttp3/internal/http2/Hpack$Writer;", "", "headerTableSizeSetting", "", "useCompression", "", "out", "Lokio/Buffer;", "(IZLokio/Buffer;)V", "dynamicTable", "", "Lokhttp3/internal/http2/Header;", "[Lokhttp3/internal/http2/Header;", "dynamicTableByteCount", "emitDynamicTableSizeUpdate", "headerCount", "maxDynamicTableByteCount", "nextHeaderIndex", "smallestHeaderTableSizeSetting", "adjustDynamicTableByteCount", "", "clearDynamicTable", "evictToRecoverBytes", "bytesToRecover", "insertIntoDynamicTable", "entry", "resizeHeaderTable", "writeByteString", "data", "Lokio/ByteString;", "writeHeaders", "headerBlock", "", "writeInt", "value", "prefixMask", "bits", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Hpack.Writer {
    public Header[] dynamicTable;
    public int dynamicTableByteCount;
    private boolean emitDynamicTableSizeUpdate;
    public int headerCount;
    public int headerTableSizeSetting;
    public int maxDynamicTableByteCount;
    private int nextHeaderIndex;
    private final Buffer out;
    private int smallestHeaderTableSizeSetting;
    private final boolean useCompression;

    public Hpack.Writer(int n, Buffer buffer) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"out");
        this(n, false, buffer, 2, null);
    }

    public Hpack.Writer(int n, boolean bl, Buffer headerArray) {
        Intrinsics.checkNotNullParameter((Object)headerArray, (String)"out");
        this.headerTableSizeSetting = n;
        this.useCompression = bl;
        this.out = headerArray;
        this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
        this.maxDynamicTableByteCount = n;
        headerArray = new Header[8];
        this.dynamicTable = headerArray;
        this.nextHeaderIndex = headerArray.length - 1;
    }

    public /* synthetic */ Hpack.Writer(int n, boolean bl, Buffer buffer, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            n = 4096;
        }
        if ((n2 & 2) != 0) {
            bl = true;
        }
        this(n, bl, buffer);
    }

    public Hpack.Writer(Buffer buffer) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"out");
        this(0, false, buffer, 3, null);
    }

    private final void adjustDynamicTableByteCount() {
        int n = this.maxDynamicTableByteCount;
        int n2 = this.dynamicTableByteCount;
        if (n >= n2) return;
        if (n == 0) {
            this.clearDynamicTable();
        } else {
            this.evictToRecoverBytes(n2 - n);
        }
    }

    private final void clearDynamicTable() {
        ArraysKt.fill$default((Object[])this.dynamicTable, null, (int)0, (int)0, (int)6, null);
        this.nextHeaderIndex = this.dynamicTable.length - 1;
        this.headerCount = 0;
        this.dynamicTableByteCount = 0;
    }

    private final int evictToRecoverBytes(int n) {
        Object[] objectArray;
        int n2 = 0;
        int n3 = 0;
        if (n <= 0) return n2;
        int n4 = n;
        n = n3;
        for (n2 = this.dynamicTable.length - 1; n2 >= this.nextHeaderIndex && n4 > 0; n4 -= objectArray.hpackSize, --this.headerCount, ++n, --n2) {
            objectArray = this.dynamicTable[n2];
            Intrinsics.checkNotNull((Object)objectArray);
            n3 = this.dynamicTableByteCount;
            objectArray = this.dynamicTable[n2];
            Intrinsics.checkNotNull((Object)objectArray);
            this.dynamicTableByteCount = n3 - objectArray.hpackSize;
        }
        objectArray = this.dynamicTable;
        n2 = this.nextHeaderIndex;
        System.arraycopy(objectArray, n2 + 1, objectArray, n2 + 1 + n, this.headerCount);
        objectArray = this.dynamicTable;
        n2 = this.nextHeaderIndex;
        Arrays.fill(objectArray, n2 + 1, n2 + 1 + n, null);
        this.nextHeaderIndex += n;
        n2 = n;
        return n2;
    }

    private final void insertIntoDynamicTable(Header header) {
        int n = header.hpackSize;
        int n2 = this.maxDynamicTableByteCount;
        if (n > n2) {
            this.clearDynamicTable();
            return;
        }
        this.evictToRecoverBytes(this.dynamicTableByteCount + n - n2);
        n2 = this.headerCount;
        Header[] headerArray = this.dynamicTable;
        if (n2 + 1 > headerArray.length) {
            Header[] headerArray2 = new Header[headerArray.length * 2];
            System.arraycopy(headerArray, 0, headerArray2, headerArray.length, headerArray.length);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.dynamicTable = headerArray2;
        }
        n2 = this.nextHeaderIndex;
        this.nextHeaderIndex = n2 - 1;
        this.dynamicTable[n2] = header;
        ++this.headerCount;
        this.dynamicTableByteCount += n;
    }

    public final void resizeHeaderTable(int n) {
        this.headerTableSizeSetting = n;
        n = this.maxDynamicTableByteCount;
        int n2 = Math.min(n, 16384);
        if (n == n2) {
            return;
        }
        if (n2 < n) {
            this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, n2);
        }
        this.emitDynamicTableSizeUpdate = true;
        this.maxDynamicTableByteCount = n2;
        this.adjustDynamicTableByteCount();
    }

    public final void writeByteString(ByteString byteString) throws IOException {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"data");
        if (this.useCompression && Huffman.INSTANCE.encodedLength(byteString) < byteString.size()) {
            Buffer buffer = new Buffer();
            Huffman.INSTANCE.encode(byteString, (BufferedSink)buffer);
            byteString = buffer.readByteString();
            this.writeInt(byteString.size(), 127, 128);
            this.out.write(byteString);
        } else {
            this.writeInt(byteString.size(), 127, 0);
            this.out.write(byteString);
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void writeHeaders(List<Header> var1_1) throws IOException {
        Intrinsics.checkNotNullParameter(var1_1, (String)"headerBlock");
        if (this.emitDynamicTableSizeUpdate) {
            var2_2 = this.smallestHeaderTableSizeSetting;
            if (var2_2 < this.maxDynamicTableByteCount) {
                this.writeInt(var2_2, 31, 32);
            }
            this.emitDynamicTableSizeUpdate = false;
            this.smallestHeaderTableSizeSetting = 0x7FFFFFFF;
            this.writeInt(this.maxDynamicTableByteCount, 31, 32);
        }
        if ((var8_3 = var1_1.size()) <= 0) return;
        var2_2 = 0;
        while (true) {
            block22: {
                block21: {
                    var6_7 = var2_2 + 1;
                    var11_11 = var1_1.get(var2_2);
                    var12_12 = var11_11.name.toAsciiLowercase();
                    var10_10 = var11_11.value;
                    var13_13 = (Integer)Hpack.INSTANCE.getNAME_TO_FIRST_INDEX().get(var12_12);
                    if (var13_13 == null) break block21;
                    var3_4 = var13_13 + 1;
                    var2_2 = 2 <= var3_4 && var3_4 <= 7 ? 1 : 0;
                    if (var2_2 == 0) ** GOTO lbl-1000
                    if (Intrinsics.areEqual((Object)Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[var3_4 - 1].value, (Object)var10_10)) {
                        var2_2 = var3_4;
                    } else if (Intrinsics.areEqual((Object)Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[var3_4].value, (Object)var10_10)) {
                        var2_2 = var3_4++;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var2_2 = var3_4;
                        var3_4 = -1;
                    }
                    break block22;
                }
                var3_4 = -1;
                var2_2 = -1;
            }
            var5_6 = var3_4;
            var4_5 = var2_2;
            if (var3_4 == -1) {
                var7_8 = this.nextHeaderIndex + 1;
                var9_9 = this.dynamicTable.length;
                var5_6 = var3_4;
                var4_5 = var2_2;
                if (var7_8 < var9_9) {
                    var5_6 = var7_8;
                    while (true) {
                        var7_8 = var5_6 + 1;
                        var13_13 = this.dynamicTable[var5_6];
                        Intrinsics.checkNotNull((Object)var13_13);
                        var4_5 = var2_2;
                        if (Intrinsics.areEqual((Object)var13_13.name, (Object)var12_12)) {
                            var13_13 = this.dynamicTable[var5_6];
                            Intrinsics.checkNotNull((Object)var13_13);
                            if (Intrinsics.areEqual((Object)var13_13.value, (Object)var10_10)) {
                                var3_4 = this.nextHeaderIndex;
                                var5_6 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (var5_6 - var3_4);
                                var4_5 = var2_2;
                                break;
                            }
                            var4_5 = var2_2;
                            if (var2_2 == -1) {
                                var4_5 = var5_6 - this.nextHeaderIndex + Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length;
                            }
                        }
                        if (var7_8 >= var9_9) {
                            var5_6 = var3_4;
                            break;
                        }
                        var5_6 = var7_8;
                        var2_2 = var4_5;
                    }
                }
            }
            if (var5_6 != -1) {
                this.writeInt(var5_6, 127, 128);
            } else if (var4_5 == -1) {
                this.out.writeByte(64);
                this.writeByteString(var12_12);
                this.writeByteString(var10_10);
                this.insertIntoDynamicTable(var11_11);
            } else if (var12_12.startsWith(Header.PSEUDO_PREFIX) && !Intrinsics.areEqual((Object)Header.TARGET_AUTHORITY, (Object)var12_12)) {
                this.writeInt(var4_5, 15, 0);
                this.writeByteString(var10_10);
            } else {
                this.writeInt(var4_5, 63, 64);
                this.writeByteString(var10_10);
                this.insertIntoDynamicTable(var11_11);
            }
            if (var6_7 >= var8_3) {
                return;
            }
            var2_2 = var6_7;
        }
    }

    public final void writeInt(int n, int n2, int n3) {
        if (n < n2) {
            this.out.writeByte(n | n3);
            return;
        }
        this.out.writeByte(n3 | n2);
        n -= n2;
        while (true) {
            if (n < 128) {
                this.out.writeByte(n);
                return;
            }
            this.out.writeByte(0x80 | n & 0x7F);
            n >>>= 7;
        }
    }
}
