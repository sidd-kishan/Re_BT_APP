/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.Util
 *  okhttp3.internal.http2.Header
 *  okhttp3.internal.http2.Hpack
 *  okhttp3.internal.http2.Huffman
 *  okio.Buffer
 *  okio.BufferedSink
 *  okio.BufferedSource
 *  okio.ByteString
 *  okio.Okio
 *  okio.Source
 */
package okhttp3.internal.http2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Header;
import okhttp3.internal.http2.Hpack;
import okhttp3.internal.http2.Huffman;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\nH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010!\u001a\u00020\u0005H\u0002J\u0006\u0010\"\u001a\u00020\u001cJ\u0006\u0010#\u001a\u00020\u0013J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0016\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0005H\u0002J\b\u0010*\u001a\u00020\u0013H\u0002J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010,\u001a\u00020\u0013H\u0002R\u001c\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2={"Lokhttp3/internal/http2/Hpack$Reader;", "", "source", "Lokio/Source;", "headerTableSizeSetting", "", "maxDynamicTableByteCount", "(Lokio/Source;II)V", "dynamicTable", "", "Lokhttp3/internal/http2/Header;", "[Lokhttp3/internal/http2/Header;", "dynamicTableByteCount", "headerCount", "headerList", "", "nextHeaderIndex", "Lokio/BufferedSource;", "adjustDynamicTableByteCount", "", "clearDynamicTable", "dynamicTableIndex", "index", "evictToRecoverBytes", "bytesToRecover", "getAndResetHeaderList", "", "getName", "Lokio/ByteString;", "insertIntoDynamicTable", "entry", "isStaticHeader", "", "readByte", "readByteString", "readHeaders", "readIndexedHeader", "readInt", "firstByte", "prefixMask", "readLiteralHeaderWithIncrementalIndexingIndexedName", "nameIndex", "readLiteralHeaderWithIncrementalIndexingNewName", "readLiteralHeaderWithoutIndexingIndexedName", "readLiteralHeaderWithoutIndexingNewName", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Hpack.Reader {
    public Header[] dynamicTable;
    public int dynamicTableByteCount;
    public int headerCount;
    private final List<Header> headerList;
    private final int headerTableSizeSetting;
    private int maxDynamicTableByteCount;
    private int nextHeaderIndex;
    private final BufferedSource source;

    public Hpack.Reader(Source source, int n) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        this(source, n, 0, 4, null);
    }

    public Hpack.Reader(Source headerArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)headerArray, (String)"source");
        this.headerTableSizeSetting = n;
        this.maxDynamicTableByteCount = n2;
        this.headerList = new ArrayList();
        this.source = Okio.buffer((Source)headerArray);
        headerArray = new Header[8];
        this.dynamicTable = headerArray;
        this.nextHeaderIndex = headerArray.length - 1;
    }

    public /* synthetic */ Hpack.Reader(Source source, int n, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 4) != 0) {
            n2 = n;
        }
        this(source, n, n2);
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

    private final int dynamicTableIndex(int n) {
        return this.nextHeaderIndex + 1 + n;
    }

    private final int evictToRecoverBytes(int n) {
        Header header;
        int n2 = 0;
        int n3 = 0;
        if (n <= 0) return n2;
        int n4 = n;
        n = n3;
        for (n2 = this.dynamicTable.length - 1; n2 >= this.nextHeaderIndex && n4 > 0; n4 -= header.hpackSize, this.dynamicTableByteCount -= header.hpackSize, --this.headerCount, ++n, --n2) {
            header = this.dynamicTable[n2];
            Intrinsics.checkNotNull((Object)header);
        }
        header = this.dynamicTable;
        n2 = this.nextHeaderIndex;
        System.arraycopy(header, n2 + 1, header, n2 + 1 + n, this.headerCount);
        this.nextHeaderIndex += n;
        n2 = n;
        return n2;
    }

    private final ByteString getName(int n) throws IOException {
        Header header;
        if (this.isStaticHeader(n)) {
            header = Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[n].name;
        } else {
            int n2 = this.dynamicTableIndex(n - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (n2 < 0) throw new IOException(Intrinsics.stringPlus((String)"Header index too large ", (Object)(n + 1)));
            header = this.dynamicTable;
            if (n2 >= ((Header[])header).length) throw new IOException(Intrinsics.stringPlus((String)"Header index too large ", (Object)(n + 1)));
            header = header[n2];
            Intrinsics.checkNotNull((Object)header);
            header = header.name;
        }
        return header;
    }

    private final void insertIntoDynamicTable(int n, Header header) {
        Header[] headerArray;
        int n2;
        this.headerList.add(header);
        int n3 = n2 = header.hpackSize;
        if (n != -1) {
            headerArray = this.dynamicTable[this.dynamicTableIndex(n)];
            Intrinsics.checkNotNull((Object)headerArray);
            n3 = n2 - headerArray.hpackSize;
        }
        if (n3 > (n2 = this.maxDynamicTableByteCount)) {
            this.clearDynamicTable();
            return;
        }
        int n4 = this.evictToRecoverBytes(this.dynamicTableByteCount + n3 - n2);
        if (n == -1) {
            n = this.headerCount;
            headerArray = this.dynamicTable;
            if (n + 1 > headerArray.length) {
                Header[] headerArray2 = new Header[headerArray.length * 2];
                System.arraycopy(headerArray, 0, headerArray2, headerArray.length, headerArray.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArray2;
            }
            n = this.nextHeaderIndex;
            this.nextHeaderIndex = n - 1;
            this.dynamicTable[n] = header;
            ++this.headerCount;
        } else {
            n2 = this.dynamicTableIndex(n);
            this.dynamicTable[n + (n2 + n4)] = header;
        }
        this.dynamicTableByteCount += n3;
    }

    private final boolean isStaticHeader(int n) {
        boolean bl = true;
        if (n >= 0 && n <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1) return bl;
        bl = false;
        return bl;
    }

    private final int readByte() throws IOException {
        return Util.and((byte)this.source.readByte(), (int)255);
    }

    private final void readIndexedHeader(int n) throws IOException {
        if (this.isStaticHeader(n)) {
            Header header = Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[n];
            this.headerList.add(header);
        } else {
            int n2 = this.dynamicTableIndex(n - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (n2 < 0) throw new IOException(Intrinsics.stringPlus((String)"Header index too large ", (Object)(n + 1)));
            Header header = this.dynamicTable;
            if (n2 >= ((Header[])header).length) throw new IOException(Intrinsics.stringPlus((String)"Header index too large ", (Object)(n + 1)));
            Collection collection = this.headerList;
            header = header[n2];
            Intrinsics.checkNotNull((Object)header);
            collection.add(header);
        }
    }

    private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int n) throws IOException {
        this.insertIntoDynamicTable(-1, new Header(this.getName(n), this.readByteString()));
    }

    private final void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
        this.insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(this.readByteString()), this.readByteString()));
    }

    private final void readLiteralHeaderWithoutIndexingIndexedName(int n) throws IOException {
        ByteString byteString = this.getName(n);
        ByteString byteString2 = this.readByteString();
        this.headerList.add(new Header(byteString, byteString2));
    }

    private final void readLiteralHeaderWithoutIndexingNewName() throws IOException {
        ByteString byteString = Hpack.INSTANCE.checkLowercase(this.readByteString());
        ByteString byteString2 = this.readByteString();
        this.headerList.add(new Header(byteString, byteString2));
    }

    public final List<Header> getAndResetHeaderList() {
        List list = CollectionsKt.toList((Iterable)this.headerList);
        this.headerList.clear();
        return list;
    }

    public final int maxDynamicTableByteCount() {
        return this.maxDynamicTableByteCount;
    }

    public final ByteString readByteString() throws IOException {
        Buffer buffer;
        int n = this.readByte();
        boolean bl = (n & 0x80) == 128;
        long l = this.readInt(n, 127);
        if (bl) {
            buffer = new Buffer();
            Huffman.INSTANCE.decode(this.source, l, (BufferedSink)buffer);
            buffer = buffer.readByteString();
        } else {
            buffer = this.source.readByteString(l);
        }
        return buffer;
    }

    public final void readHeaders() throws IOException {
        while (!this.source.exhausted()) {
            int n = Util.and((byte)this.source.readByte(), (int)255);
            if (n == 128) throw new IOException("index == 0");
            if ((n & 0x80) == 128) {
                this.readIndexedHeader(this.readInt(n, 127) - 1);
                continue;
            }
            if (n == 64) {
                this.readLiteralHeaderWithIncrementalIndexingNewName();
                continue;
            }
            if ((n & 0x40) == 64) {
                this.readLiteralHeaderWithIncrementalIndexingIndexedName(this.readInt(n, 63) - 1);
                continue;
            }
            if ((n & 0x20) == 32) {
                this.maxDynamicTableByteCount = n = this.readInt(n, 31);
                if (n < 0) throw new IOException(Intrinsics.stringPlus((String)"Invalid dynamic table size update ", (Object)this.maxDynamicTableByteCount));
                if (n > this.headerTableSizeSetting) throw new IOException(Intrinsics.stringPlus((String)"Invalid dynamic table size update ", (Object)this.maxDynamicTableByteCount));
                this.adjustDynamicTableByteCount();
                continue;
            }
            if (n != 16 && n != 0) {
                this.readLiteralHeaderWithoutIndexingIndexedName(this.readInt(n, 15) - 1);
                continue;
            }
            this.readLiteralHeaderWithoutIndexingNewName();
        }
    }

    public final int readInt(int n, int n2) throws IOException {
        int n3;
        if ((n &= n2) < n2) {
            return n;
        }
        n = 0;
        while (((n3 = this.readByte()) & 0x80) != 0) {
            n2 += (n3 & 0x7F) << n;
            n += 7;
        }
        return n2 + (n3 << n);
    }
}
