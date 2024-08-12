/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.Buffer$UnsafeCursor
 *  okio.ByteString
 *  okio.Options
 *  okio.Segment
 *  okio.SegmentPool
 *  okio.SegmentedByteString
 *  okio.Sink
 *  okio.Source
 *  okio._JvmPlatformKt
 *  okio._UtilKt
 *  okio.internal._Utf8Kt
 */
package okio.internal;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio._JvmPlatformKt;
import okio._UtilKt;
import okio.internal._Utf8Kt;

@Metadata(d1={"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0000\u001a\r\u0010\u0013\u001a\u00020\u0014*\u00020\u0015H\u0080\b\u001a\r\u0010\u0016\u001a\u00020\u0014*\u00020\u0017H\u0080\b\u001a\r\u0010\u0018\u001a\u00020\u0007*\u00020\u0015H\u0080\b\u001a\r\u0010\u0019\u001a\u00020\u0015*\u00020\u0015H\u0080\b\u001a%\u0010\u001a\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\u0017\u0010\u001e\u001a\u00020\f*\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0080\b\u001a\u0015\u0010!\u001a\u00020\u0007*\u00020\u00172\u0006\u0010\"\u001a\u00020\nH\u0080\b\u001a\u0015\u0010#\u001a\u00020$*\u00020\u00152\u0006\u0010%\u001a\u00020\u0007H\u0080\b\u001a\r\u0010&\u001a\u00020\n*\u00020\u0015H\u0080\b\u001a%\u0010'\u001a\u00020\u0007*\u00020\u00152\u0006\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0080\b\u001a\u001d\u0010'\u001a\u00020\u0007*\u00020\u00152\u0006\u0010\u0010\u001a\u00020+2\u0006\u0010)\u001a\u00020\u0007H\u0080\b\u001a\u001d\u0010,\u001a\u00020\u0007*\u00020\u00152\u0006\u0010-\u001a\u00020+2\u0006\u0010)\u001a\u00020\u0007H\u0080\b\u001a\r\u0010.\u001a\u00020\n*\u00020\u0017H\u0080\b\u001a-\u0010/\u001a\u00020\f*\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0080\b\u001a\u0015\u00100\u001a\u00020\n*\u00020\u00152\u0006\u00101\u001a\u00020\u0001H\u0080\b\u001a%\u00100\u001a\u00020\n*\u00020\u00152\u0006\u00101\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0080\b\u001a\u001d\u00100\u001a\u00020\u0007*\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\u0015\u00102\u001a\u00020\u0007*\u00020\u00152\u0006\u00101\u001a\u000203H\u0080\b\u001a\u0014\u00104\u001a\u00020\u0017*\u00020\u00152\u0006\u00105\u001a\u00020\u0017H\u0000\u001a\r\u00106\u001a\u00020$*\u00020\u0015H\u0080\b\u001a\r\u00107\u001a\u00020\u0001*\u00020\u0015H\u0080\b\u001a\u0015\u00107\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\r\u00108\u001a\u00020+*\u00020\u0015H\u0080\b\u001a\u0015\u00108\u001a\u00020+*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\r\u00109\u001a\u00020\u0007*\u00020\u0015H\u0080\b\u001a\u0015\u0010:\u001a\u00020\u0014*\u00020\u00152\u0006\u00101\u001a\u00020\u0001H\u0080\b\u001a\u001d\u0010:\u001a\u00020\u0014*\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\r\u0010;\u001a\u00020\u0007*\u00020\u0015H\u0080\b\u001a\r\u0010<\u001a\u00020\n*\u00020\u0015H\u0080\b\u001a\r\u0010=\u001a\u00020\u0007*\u00020\u0015H\u0080\b\u001a\r\u0010>\u001a\u00020?*\u00020\u0015H\u0080\b\u001a\u0014\u0010@\u001a\u00020\u0017*\u00020\u00152\u0006\u00105\u001a\u00020\u0017H\u0000\u001a\u0015\u0010A\u001a\u00020B*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\r\u0010C\u001a\u00020\n*\u00020\u0015H\u0080\b\u001a\u000f\u0010D\u001a\u0004\u0018\u00010B*\u00020\u0015H\u0080\b\u001a\u0015\u0010E\u001a\u00020B*\u00020\u00152\u0006\u0010F\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010G\u001a\u00020\u0007*\u00020\u00172\u0006\u0010H\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010I\u001a\u00020\n*\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010J\u001a\u00020\n*\u00020\u00152\u0006\u0010K\u001a\u00020LH\u0080\b\u001a\u0015\u0010M\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\r\u0010N\u001a\u00020+*\u00020\u0015H\u0080\b\u001a\u0015\u0010N\u001a\u00020+*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\nH\u0080\b\u001a\u0015\u0010O\u001a\u00020\u000e*\u00020\u00152\u0006\u0010P\u001a\u00020\nH\u0080\b\u001a\u0015\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020\u0001H\u0080\b\u001a%\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0080\b\u001a\u001d\u0010Q\u001a\u00020\u0014*\u00020\u00152\u0006\u0010R\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a)\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010S\u001a\u00020+2\b\b\u0002\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\nH\u0080\b\u001a\u001d\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020T2\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010U\u001a\u00020\u0007*\u00020\u00152\u0006\u0010R\u001a\u00020TH\u0080\b\u001a\u0015\u0010V\u001a\u00020\u0015*\u00020\u00152\u0006\u0010(\u001a\u00020\nH\u0080\b\u001a\u0015\u0010W\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010Y\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010Z\u001a\u00020\u0015*\u00020\u00152\u0006\u0010[\u001a\u00020\nH\u0080\b\u001a\u0015\u0010\\\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010]\u001a\u00020\u0015*\u00020\u00152\u0006\u0010^\u001a\u00020\nH\u0080\b\u001a%\u0010_\u001a\u00020\u0015*\u00020\u00152\u0006\u0010`\u001a\u00020B2\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\nH\u0080\b\u001a\u0015\u0010c\u001a\u00020\u0015*\u00020\u00152\u0006\u0010d\u001a\u00020\nH\u0080\b\u001a\u0014\u0010e\u001a\u00020B*\u00020\u00152\u0006\u0010f\u001a\u00020\u0007H\u0000\u001a?\u0010g\u001a\u0002Hh\"\u0004\b\u0000\u0010h*\u00020\u00152\u0006\u0010)\u001a\u00020\u00072\u001a\u0010i\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002Hh0jH\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010k\u001a\u001e\u0010l\u001a\u00020\n*\u00020\u00152\u0006\u0010K\u001a\u00020L2\b\b\u0002\u0010m\u001a\u00020\fH\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0080T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006n"}, d2={"HEX_DIGIT_BYTES", "", "getHEX_DIGIT_BYTES$annotations", "()V", "getHEX_DIGIT_BYTES", "()[B", "OVERFLOW_DIGIT_START", "", "OVERFLOW_ZONE", "SEGMENTING_THRESHOLD", "", "rangeEquals", "", "segment", "Lokio/Segment;", "segmentPos", "bytes", "bytesOffset", "bytesLimit", "commonClear", "", "Lokio/Buffer;", "commonClose", "Lokio/Buffer$UnsafeCursor;", "commonCompleteSegmentByteCount", "commonCopy", "commonCopyTo", "out", "offset", "byteCount", "commonEquals", "other", "", "commonExpandBuffer", "minByteCount", "commonGet", "", "pos", "commonHashCode", "commonIndexOf", "b", "fromIndex", "toIndex", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonNext", "commonRangeEquals", "commonRead", "sink", "commonReadAll", "Lokio/Sink;", "commonReadAndWriteUnsafe", "unsafeCursor", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadLong", "commonReadShort", "", "commonReadUnsafe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonResizeBuffer", "newSize", "commonSeek", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonSnapshot", "commonWritableSegment", "minimumCapacity", "commonWrite", "source", "byteString", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", "i", "commonWriteLong", "commonWriteShort", "s", "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "readUtf8Line", "newline", "seek", "T", "lambda", "Lkotlin/Function2;", "(Lokio/Buffer;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "selectPrefix", "selectTruncated", "okio"}, k=2, mv={1, 5, 1}, xi=48)
public final class _BufferKt {
    private static final byte[] HEX_DIGIT_BYTES = _JvmPlatformKt.asUtf8ToByteArray((String)"0123456789abcdef");
    public static final long OVERFLOW_DIGIT_START = -7L;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    public static final void commonClear(Buffer buffer) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        buffer.skip(buffer.size());
    }

    public static final void commonClose(Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter((Object)unsafeCursor, (String)"<this>");
        boolean bl = unsafeCursor.buffer != null;
        if (!bl) throw (Throwable)new IllegalStateException("not attached to a buffer".toString());
        unsafeCursor.buffer = null;
        unsafeCursor.setSegment$okio(null);
        unsafeCursor.offset = -1L;
        unsafeCursor.data = null;
        unsafeCursor.start = -1;
        unsafeCursor.end = -1;
    }

    public static final long commonCompleteSegmentByteCount(Buffer buffer) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        long l = buffer.size();
        if (l == 0L) {
            return 0L;
        }
        buffer = buffer.head;
        Intrinsics.checkNotNull((Object)buffer);
        buffer = buffer.prev;
        Intrinsics.checkNotNull((Object)buffer);
        long l2 = l;
        if (buffer.limit >= 8192) return l2;
        l2 = l;
        if (!buffer.owner) return l2;
        l2 = l - (long)(buffer.limit - buffer.pos);
        return l2;
    }

    public static final Buffer commonCopy(Buffer buffer) {
        Segment segment;
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Buffer buffer2 = new Buffer();
        if (buffer.size() == 0L) {
            return buffer2;
        }
        Segment segment2 = buffer.head;
        Intrinsics.checkNotNull((Object)segment2);
        segment.next = segment.prev = (buffer2.head = (segment = segment2.sharedCopy()));
        Segment segment3 = segment2.next;
        while (true) {
            if (segment3 == segment2) {
                buffer2.setSize$okio(buffer.size());
                return buffer2;
            }
            Segment segment4 = segment.prev;
            Intrinsics.checkNotNull((Object)segment4);
            Intrinsics.checkNotNull((Object)segment3);
            segment4.push(segment3.sharedCopy());
            segment3 = segment3.next;
        }
    }

    public static final Buffer commonCopyTo(Buffer buffer, Buffer buffer2, long l, long l2) {
        long l3;
        long l4;
        Segment segment;
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)buffer2, (String)"out");
        _UtilKt.checkOffsetAndCount((long)buffer.size(), (long)l, (long)l2);
        if (l2 == 0L) {
            return buffer;
        }
        buffer2.setSize$okio(buffer2.size() + l2);
        Segment segment2 = buffer.head;
        while (true) {
            Intrinsics.checkNotNull((Object)segment2);
            segment = segment2;
            l4 = l;
            l3 = l2;
            if (l < (long)(segment2.limit - segment2.pos)) break;
            l -= (long)(segment2.limit - segment2.pos);
            segment2 = segment2.next;
        }
        while (l3 > 0L) {
            Intrinsics.checkNotNull((Object)segment);
            segment2 = segment.sharedCopy();
            segment2.pos += (int)l4;
            segment2.limit = Math.min(segment2.pos + (int)l3, segment2.limit);
            if (buffer2.head == null) {
                buffer2.head = segment2.next = (segment2.prev = segment2);
            } else {
                Segment segment3 = buffer2.head;
                Intrinsics.checkNotNull((Object)segment3);
                segment3 = segment3.prev;
                Intrinsics.checkNotNull((Object)segment3);
                segment3.push(segment2);
            }
            l3 -= (long)(segment2.limit - segment2.pos);
            segment = segment.next;
            l4 = 0L;
        }
        return buffer;
    }

    public static final boolean commonEquals(Buffer buffer, Object object) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        if (buffer == object) {
            return true;
        }
        if (!(object instanceof Buffer)) {
            return false;
        }
        long l = buffer.size();
        if (l != (object = (Buffer)object).size()) {
            return false;
        }
        if (buffer.size() == 0L) {
            return true;
        }
        Object object2 = buffer.head;
        Intrinsics.checkNotNull((Object)object2);
        object = ((Buffer)object).head;
        Intrinsics.checkNotNull((Object)object);
        int n = object2.pos;
        Object object3 = ((Segment)object).pos;
        l = 0L;
        while (l < buffer.size()) {
            Object object4;
            long l2 = Math.min(object2.limit - n, ((Segment)object).limit - object3);
            Object object5 = n;
            Object object6 = object3;
            if (0L < l2) {
                long l3 = 0L;
                while (true) {
                    ++l3;
                    object4 = object2.data;
                    object6 = n + 1;
                    object5 = object4[n];
                    object4 = ((Segment)object).data;
                    n = object3 + 1;
                    if (object5 != object4[object3]) {
                        return false;
                    }
                    if (l3 >= l2) {
                        object5 = object6;
                        object6 = n;
                        break;
                    }
                    object3 = n;
                    n = object6;
                }
            }
            object4 = object2;
            n = object5;
            if (object5 == object2.limit) {
                object4 = object2.next;
                Intrinsics.checkNotNull((Object)object4);
                n = object4.pos;
            }
            object2 = object;
            object3 = object6;
            if (object6 == ((Segment)object).limit) {
                object2 = ((Segment)object).next;
                Intrinsics.checkNotNull((Object)object2);
                object3 = object2.pos;
            }
            l += l2;
            object = object2;
            object2 = object4;
        }
        return true;
    }

    public static final long commonExpandBuffer(Buffer.UnsafeCursor unsafeCursor, int n) {
        Intrinsics.checkNotNullParameter((Object)unsafeCursor, (String)"<this>");
        boolean bl = true;
        boolean bl2 = n > 0;
        if (!bl2) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"minByteCount <= 0: ", (Object)n).toString());
        bl2 = n <= 8192 ? bl : false;
        if (!bl2) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"minByteCount > Segment.SIZE: ", (Object)n).toString());
        Buffer buffer = unsafeCursor.buffer;
        if (buffer == null) throw (Throwable)new IllegalStateException("not attached to a buffer".toString());
        if (!unsafeCursor.readWrite) throw (Throwable)new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
        long l = buffer.size();
        Segment segment = buffer.writableSegment$okio(n);
        n = 8192 - segment.limit;
        segment.limit = 8192;
        long l2 = n;
        buffer.setSize$okio(l + l2);
        unsafeCursor.setSegment$okio(segment);
        unsafeCursor.offset = l;
        unsafeCursor.data = segment.data;
        unsafeCursor.start = 8192 - n;
        unsafeCursor.end = 8192;
        return l2;
    }

    public static final byte commonGet(Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        _UtilKt.checkOffsetAndCount((long)buffer.size(), (long)l, (long)1L);
        Segment segment = buffer.head;
        if (segment == null) {
            buffer = null;
            Intrinsics.checkNotNull((Object)buffer);
            return buffer.data[(int)((long)buffer.pos + l + 1L)];
        }
        if (buffer.size() - l < l) {
            long l2 = buffer.size();
            while (true) {
                if (l2 <= l) {
                    Intrinsics.checkNotNull((Object)segment);
                    return segment.data[(int)((long)segment.pos + l - l2)];
                }
                segment = segment.prev;
                Intrinsics.checkNotNull((Object)segment);
                l2 -= (long)(segment.limit - segment.pos);
            }
        }
        long l3 = 0L;
        while (true) {
            long l4;
            if ((l4 = (long)(segment.limit - segment.pos) + l3) > l) {
                Intrinsics.checkNotNull((Object)segment);
                return segment.data[(int)((long)segment.pos + l - l3)];
            }
            segment = segment.next;
            Intrinsics.checkNotNull((Object)segment);
            l3 = l4;
        }
    }

    public static final int commonHashCode(Buffer buffer) {
        int n;
        Segment segment;
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Segment segment2 = buffer.head;
        if (segment2 == null) {
            return 0;
        }
        int n2 = 1;
        do {
            int n3 = segment2.limit;
            n = n2;
            for (int i = segment2.pos; i < n3; ++i) {
                n = n * 31 + segment2.data[i];
            }
            segment = segment2.next;
            Intrinsics.checkNotNull((Object)segment);
            segment2 = segment;
            n2 = n;
        } while (segment != buffer.head);
        return n;
    }

    public static final long commonIndexOf(Buffer object, byte by, long l, long l2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        int n = 0;
        long l3 = 0L;
        int n2 = n;
        if (0L <= l) {
            n2 = n;
            if (l <= l2) {
                n2 = 1;
            }
        }
        if (n2 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("size=");
            stringBuilder.append(object.size());
            stringBuilder.append(" fromIndex=");
            stringBuilder.append(l);
            stringBuilder.append(" toIndex=");
            stringBuilder.append(l2);
            object = new IllegalArgumentException(stringBuilder.toString().toString());
            throw object;
        }
        long l4 = l2;
        if (l2 > object.size()) {
            l4 = object.size();
        }
        if (l == l4) {
            return -1L;
        }
        Segment segment = object.head;
        if (segment == null) {
            object = null;
            return -1L;
        }
        Object object2 = segment;
        l2 = l3;
        if (object.size() - l < l) {
            l2 = object.size();
            object = segment;
            while (l2 > l) {
                object = object.prev;
                Intrinsics.checkNotNull((Object)object);
                l2 -= (long)(object.limit - object.pos);
            }
            object2 = object;
            if (object == null) {
                return -1L;
            }
            while (l2 < l4) {
                object = object2.data;
                n = (int)Math.min((long)object2.limit, (long)object2.pos + l4 - l2);
                for (n2 = (int)((long)object2.pos + l - l2); n2 < n; ++n2) {
                    if (object[n2] != by) continue;
                    return (long)(n2 - object2.pos) + l2;
                }
                object2 = object2.next;
                Intrinsics.checkNotNull((Object)object2);
                l = l2 += (long)(object2.limit - object2.pos);
            }
            return -1L;
        }
        while (true) {
            if ((l3 = (long)(object2.limit - object2.pos) + l2) > l) {
                object = object2;
                if (object2 != null) break;
                return -1L;
            }
            object2 = object2.next;
            Intrinsics.checkNotNull((Object)object2);
            l2 = l3;
        }
        while (l2 < l4) {
            object2 = object.data;
            n = (int)Math.min((long)object.limit, (long)object.pos + l4 - l2);
            for (n2 = (int)((long)object.pos + l - l2); n2 < n; ++n2) {
                if (object2[n2] != by) continue;
                return (long)(n2 - object.pos) + l2;
            }
            object = object.next;
            Intrinsics.checkNotNull((Object)object);
            l = l2 += (long)(object.limit - object.pos);
        }
        return -1L;
    }

    public static final long commonIndexOf(Buffer object, ByteString object2, long l) {
        long l2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"bytes");
        int n = object2.size() > 0 ? 1 : 0;
        if (n == 0) {
            object = new IllegalArgumentException("bytes is empty".toString());
            throw object;
        }
        long l3 = 0L;
        n = l >= 0L ? 1 : 0;
        if (n == 0) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"fromIndex < 0: ", (Object)l).toString());
        Object object3 = object.head;
        long l4 = -1L;
        if (object3 == null) {
            object = null;
            return -1L;
        }
        Segment segment = object3;
        if (object.size() - l < l) {
            segment = object3;
            for (l3 = object.size(); l3 > l; l3 -= (long)(segment.limit - segment.pos)) {
                segment = segment.prev;
                Intrinsics.checkNotNull((Object)segment);
            }
            if (segment == null) {
                return -1L;
            }
            object3 = object2.internalArray$okio();
            Segment segment2 = object3[0];
            int n2 = object2.size();
            l4 = object.size() - (long)n2 + 1L;
            object = segment;
            while (l3 < l4) {
                object2 = object.data;
                n = object.limit;
                n = (int)((long)object.pos + l - l3);
                long l5 = object.pos;
                int n3 = (int)Math.min((long)n, l5 + l4 - l3);
                if (n < n3) {
                    while (true) {
                        int n4 = n + 1;
                        if (object2[n] == segment2 && _BufferKt.rangeEquals((Segment)object, n4, (byte[])object3, 1, n2)) {
                            return (long)(n - object.pos) + l3;
                        }
                        if (n4 >= n3) break;
                        n = n4;
                    }
                }
                object = object.next;
                Intrinsics.checkNotNull((Object)object);
                l = l3 += (long)(object.limit - object.pos);
            }
            return -1L;
        }
        while (true) {
            if ((l2 = (long)(segment.limit - segment.pos) + l3) > l) {
                if (segment == null) {
                    return l4;
                }
                break;
            }
            segment = segment.next;
            Intrinsics.checkNotNull((Object)segment);
            l3 = l2;
        }
        object3 = object2.internalArray$okio();
        Segment segment3 = object3[0];
        int n5 = object2.size();
        l2 = object.size() - (long)n5 + 1L;
        l4 = l3;
        object = segment;
        l3 = l;
        l = l2;
        while (l4 < l) {
            object2 = object.data;
            n = object.limit;
            n = (int)((long)object.pos + l3 - l4);
            l2 = object.pos;
            int n6 = (int)Math.min((long)n, l2 + l - l4);
            if (n < n6) {
                while (true) {
                    int n7 = n + 1;
                    if (object2[n] == segment3 && _BufferKt.rangeEquals((Segment)object, n7, (byte[])object3, 1, n5)) {
                        return (long)(n - object.pos) + l4;
                    }
                    if (n7 >= n6) break;
                    n = n7;
                }
            }
            object = object.next;
            Intrinsics.checkNotNull((Object)object);
            l3 = l4 += (long)(object.limit - object.pos);
        }
        return -1L;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     */
    public static final long commonIndexOfElement(Buffer object, ByteString object2, long l) {
        int n;
        Segment segment;
        int n2;
        long l2;
        long l3;
        block22: {
            void var1_3;
            block23: {
                void var1_7;
                block21: {
                    Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
                    Intrinsics.checkNotNullParameter((Object)var1_3, (String)"targetBytes");
                    l3 = 0L;
                    n2 = l2 >= 0L ? 1 : 0;
                    if (n2 == 0) {
                        Throwable throwable = new IllegalArgumentException(Intrinsics.stringPlus((String)"fromIndex < 0: ", (Object)l2).toString());
                        throw throwable;
                    }
                    Segment segment2 = object.head;
                    if (segment2 == null) {
                        Segment segment3 = null;
                        return -1L;
                    }
                    segment = segment2;
                    if (object.size() - l2 < l2) {
                        segment = segment2;
                        for (l3 = object.size(); l3 > l2; l3 -= (long)(segment.limit - segment.pos)) {
                            segment = segment.prev;
                            Intrinsics.checkNotNull((Object)segment);
                        }
                        if (segment == null) {
                            return -1L;
                        }
                        if (var1_3.size() == 2) {
                            byte by = var1_3.getByte(0);
                            byte by2 = var1_3.getByte(1);
                            while (l3 < object.size()) {
                                byte[] byArray = segment.data;
                                n = (int)((long)segment.pos + l2 - l3);
                                int n3 = segment.limit;
                                while (n < n3) {
                                    byte by3 = byArray[n];
                                    l2 = l3;
                                    Segment segment4 = segment;
                                    n2 = n++;
                                    if (by3 != by) {
                                        if (by3 != by2) continue;
                                        l2 = l3;
                                        Segment segment5 = segment;
                                        n2 = n;
                                    }
                                    break block21;
                                }
                                segment = segment.next;
                                Intrinsics.checkNotNull((Object)segment);
                                l2 = l3 += (long)(segment.limit - segment.pos);
                            }
                            return -1L;
                        }
                        byte[] byArray = var1_3.internalArray$okio();
                        while (l3 < object.size()) {
                            byte[] byArray2 = segment.data;
                            int n4 = segment.limit;
                            for (n2 = (int)((long)segment.pos + l2 - l3); n2 < n4; ++n2) {
                                byte by = byArray2[n2];
                                for (byte by4 : byArray) {
                                    if (by != by4) continue;
                                    break block22;
                                }
                            }
                            segment = segment.next;
                            Intrinsics.checkNotNull((Object)segment);
                            l2 = l3 += (long)(segment.limit - segment.pos);
                        }
                        return -1L;
                    }
                    while (true) {
                        long l4;
                        if ((l4 = (long)(segment.limit - segment.pos) + l3) > l2) {
                            if (segment == null) {
                                return -1L;
                            }
                            if (var1_3.size() == 2) break;
                            break block23;
                        }
                        segment = segment.next;
                        Intrinsics.checkNotNull((Object)segment);
                        l3 = l4;
                    }
                    byte by = var1_3.getByte(0);
                    byte by5 = var1_3.getByte(1);
                    while (l3 < object.size()) {
                        byte[] byArray = segment.data;
                        n = (int)((long)segment.pos + l2 - l3);
                        int n5 = segment.limit;
                        while (n < n5) {
                            byte by6 = byArray[n];
                            l2 = l3;
                            Segment segment6 = segment;
                            n2 = n++;
                            if (by6 != by) {
                                if (by6 != by5) continue;
                                l2 = l3;
                                Segment segment7 = segment;
                                n2 = n;
                            }
                            break block21;
                        }
                        segment = segment.next;
                        Intrinsics.checkNotNull((Object)segment);
                        l2 = l3 += (long)(segment.limit - segment.pos);
                    }
                    return -1L;
                }
                n = var1_7.pos;
                return (long)(n2 - n) + l2;
            }
            byte[] byArray = var1_3.internalArray$okio();
            while (l3 < object.size()) {
                byte[] byArray3 = segment.data;
                int n6 = segment.limit;
                for (n2 = (int)((long)segment.pos + l2 - l3); n2 < n6; ++n2) {
                    byte by = byArray3[n2];
                    for (byte by7 : byArray) {
                        if (by != by7) continue;
                        break block22;
                    }
                }
                segment = segment.next;
                Intrinsics.checkNotNull((Object)segment);
                l2 = l3 += (long)(segment.limit - segment.pos);
            }
            return -1L;
        }
        n = segment.pos;
        l2 = l3;
        return (long)(n2 - n) + l2;
    }

    public static final int commonNext(Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter((Object)unsafeCursor, (String)"<this>");
        long l = unsafeCursor.offset;
        Buffer buffer = unsafeCursor.buffer;
        Intrinsics.checkNotNull((Object)buffer);
        boolean bl = l != buffer.size();
        if (!bl) throw (Throwable)new IllegalStateException("no more bytes".toString());
        l = unsafeCursor.offset == -1L ? 0L : unsafeCursor.offset + (long)(unsafeCursor.end - unsafeCursor.start);
        return unsafeCursor.seek(l);
    }

    public static final boolean commonRangeEquals(Buffer buffer, long l, ByteString byteString, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"bytes");
        if (l < 0L) return false;
        if (n < 0) return false;
        if (n2 < 0) return false;
        if (buffer.size() - l < (long)n2) return false;
        if (byteString.size() - n < n2) {
            return false;
        }
        if (n2 <= 0) return true;
        int n3 = 0;
        while (true) {
            int n4 = n3 + 1;
            if (buffer.getByte((long)n3 + l) != byteString.getByte(n3 + n)) {
                return false;
            }
            if (n4 >= n2) {
                return true;
            }
            n3 = n4;
        }
    }

    public static final int commonRead(Buffer buffer, byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"sink");
        return buffer.read(byArray, 0, byArray.length);
    }

    public static final int commonRead(Buffer buffer, byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"sink");
        _UtilKt.checkOffsetAndCount((long)byArray.length, (long)n, (long)n2);
        Segment segment = buffer.head;
        if (segment == null) {
            return -1;
        }
        n2 = Math.min(n2, segment.limit - segment.pos);
        ArraysKt.copyInto((byte[])segment.data, (byte[])byArray, (int)n, (int)segment.pos, (int)(segment.pos + n2));
        segment.pos += n2;
        buffer.setSize$okio(buffer.size() - (long)n2);
        if (segment.pos != segment.limit) return n2;
        buffer.head = segment.pop();
        SegmentPool.recycle((Segment)segment);
        return n2;
    }

    public static final long commonRead(Buffer buffer, Buffer buffer2, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)buffer2, (String)"sink");
        boolean bl = l >= 0L;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount < 0: ", (Object)l).toString());
        if (buffer.size() == 0L) {
            return -1L;
        }
        long l2 = l;
        if (l > buffer.size()) {
            l2 = buffer.size();
        }
        buffer2.write(buffer, l2);
        return l2;
    }

    public static final long commonReadAll(Buffer buffer, Sink sink) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)sink, (String)"sink");
        long l = buffer.size();
        if (l <= 0L) return l;
        sink.write(buffer, l);
        return l;
    }

    public static final Buffer.UnsafeCursor commonReadAndWriteUnsafe(Buffer buffer, Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)unsafeCursor, (String)"unsafeCursor");
        unsafeCursor = _UtilKt.resolveDefaultParameter((Buffer.UnsafeCursor)unsafeCursor);
        boolean bl = unsafeCursor.buffer == null;
        if (!bl) throw (Throwable)new IllegalStateException("already attached to a buffer".toString());
        unsafeCursor.buffer = buffer;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    public static final byte commonReadByte(Buffer buffer) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        if (buffer.size() == 0L) throw new EOFException();
        Segment segment = buffer.head;
        Intrinsics.checkNotNull((Object)segment);
        int n = segment.pos;
        int n2 = segment.limit;
        byte[] byArray = segment.data;
        int n3 = n + 1;
        byte by = byArray[n];
        buffer.setSize$okio(buffer.size() - 1L);
        if (n3 == n2) {
            buffer.head = segment.pop();
            SegmentPool.recycle((Segment)segment);
        } else {
            segment.pos = n3;
        }
        return by;
    }

    public static final byte[] commonReadByteArray(Buffer buffer) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        return buffer.readByteArray(buffer.size());
    }

    public static final byte[] commonReadByteArray(Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        boolean bl = l >= 0L && l <= Integer.MAX_VALUE;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount: ", (Object)l).toString());
        if (buffer.size() < l) throw new EOFException();
        byte[] byArray = new byte[(int)l];
        buffer.readFully(byArray);
        return byArray;
    }

    public static final ByteString commonReadByteString(Buffer buffer) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        return buffer.readByteString(buffer.size());
    }

    public static final ByteString commonReadByteString(Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        boolean bl = l >= 0L && l <= Integer.MAX_VALUE;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount: ", (Object)l).toString());
        if (buffer.size() < l) throw new EOFException();
        if (l < 4096L) return new ByteString(buffer.readByteArray(l));
        ByteString byteString = buffer.snapshot((int)l);
        buffer.skip(l);
        return byteString;
    }

    public static final long commonReadDecimalLong(Buffer object) {
        int n;
        boolean bl;
        long l;
        block9: {
            Object object2;
            Object object3;
            Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
            if (object.size() == 0L) {
                object = new EOFException();
                throw object;
            }
            long l2 = -7L;
            int n2 = 0;
            l = 0L;
            bl = false;
            int n3 = 0;
            while (true) {
                int n4;
                int n5;
                block8: {
                    object3 = object.head;
                    Intrinsics.checkNotNull((Object)object3);
                    object2 = object3.data;
                    n5 = object3.pos;
                    n4 = object3.limit;
                    while (true) {
                        n = n3;
                        if (n5 >= n4) break block8;
                        n = object2[n5];
                        int n6 = 48;
                        if (n >= n6 && n <= (byte)57) {
                            if (l < -922337203685477580L || l == -922337203685477580L && (long)(n6 -= n) < l2) break block9;
                            l = l * 10L + (long)n6;
                        } else {
                            if (n != (byte)45 || n2 != 0) break;
                            --l2;
                            bl = true;
                        }
                        ++n5;
                        ++n2;
                    }
                    n = 1;
                }
                if (n5 == n4) {
                    object.head = object3.pop();
                    SegmentPool.recycle((Segment)object3);
                } else {
                    object3.pos = n5;
                }
                if (n != 0 || object.head == null) break;
                n3 = n;
            }
            object.setSize$okio(object.size() - (long)n2);
            n3 = bl ? 2 : 1;
            if (n2 < n3) {
                if (object.size() == 0L) throw new EOFException();
                object3 = bl ? "Expected a digit" : "Expected a digit or '-'";
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append(" but was 0x");
                ((StringBuilder)object2).append(_UtilKt.toHexString((byte)object.getByte(0L)));
                throw new NumberFormatException(((StringBuilder)object2).toString());
            }
            if (bl) return l;
            l = -l;
            return l;
        }
        object = new Buffer().writeDecimalLong(l).writeByte(n);
        if (bl) throw new NumberFormatException(Intrinsics.stringPlus((String)"Number too large: ", (Object)object.readUtf8()));
        object.readByte();
        throw new NumberFormatException(Intrinsics.stringPlus((String)"Number too large: ", (Object)object.readUtf8()));
    }

    public static final void commonReadFully(Buffer buffer, Buffer buffer2, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)buffer2, (String)"sink");
        if (buffer.size() >= l) {
            buffer2.write(buffer, l);
            return;
        }
        buffer2.write(buffer, buffer.size());
        throw new EOFException();
    }

    public static final void commonReadFully(Buffer buffer, byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"sink");
        int n = 0;
        while (n < byArray.length) {
            int n2 = buffer.read(byArray, n, byArray.length - n);
            if (n2 == -1) throw new EOFException();
            n += n2;
        }
    }

    public static final long commonReadHexadecimalUnsignedLong(Buffer object) {
        int n;
        long l;
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        if (object.size() == 0L) {
            object = new EOFException();
            throw object;
        }
        int n2 = 0;
        long l2 = 0L;
        boolean bl = false;
        do {
            boolean bl2;
            int n3;
            int n4;
            Segment segment;
            block7: {
                byte by;
                segment = object.head;
                Intrinsics.checkNotNull((Object)segment);
                byte[] byArray = segment.data;
                n4 = segment.pos;
                n3 = segment.limit;
                l = l2;
                n = n2;
                while (true) {
                    bl2 = bl;
                    if (n4 >= n3) break block7;
                    by = byArray[n4];
                    n2 = 48;
                    if (by >= n2 && by <= (byte)57) {
                        n2 = by - n2;
                    } else {
                        n2 = (byte)97;
                        if ((by < n2 || by > (byte)102) && (by < (n2 = (byte)65) || by > (byte)70)) break;
                        n2 = by - n2 + 10;
                    }
                    if ((0xF000000000000000L & l) != 0L) throw new NumberFormatException(Intrinsics.stringPlus((String)"Number too large: ", (Object)new Buffer().writeHexadecimalUnsignedLong(l).writeByte((int)by).readUtf8()));
                    l = l << 4 | (long)n2;
                    ++n4;
                    ++n;
                }
                if (n == 0) throw new NumberFormatException(Intrinsics.stringPlus((String)"Expected leading [0-9a-fA-F] character but was 0x", (Object)_UtilKt.toHexString((byte)by)));
                bl2 = true;
            }
            if (n4 == n3) {
                object.head = segment.pop();
                SegmentPool.recycle((Segment)segment);
            } else {
                segment.pos = n4;
            }
            if (bl2) break;
            n2 = n;
            bl = bl2;
            l2 = l;
        } while (object.head != null);
        object.setSize$okio(object.size() - (long)n);
        return l;
    }

    public static final int commonReadInt(Buffer buffer) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        if (buffer.size() < 4L) throw new EOFException();
        Segment segment = buffer.head;
        Intrinsics.checkNotNull((Object)segment);
        int n = segment.pos;
        int n2 = segment.limit;
        if ((long)(n2 - n) < 4L) {
            byte by = buffer.readByte();
            n = buffer.readByte();
            n2 = buffer.readByte();
            return buffer.readByte() & 0xFF | ((by & 0xFF) << 24 | (n & 0xFF) << 16 | (n2 & 0xFF) << 8);
        }
        byte[] byArray = segment.data;
        int n3 = n + 1;
        n = byArray[n];
        int n4 = n3 + 1;
        n3 = byArray[n3];
        int n5 = n4 + 1;
        byte by = byArray[n4];
        n4 = n5 + 1;
        n5 = byArray[n5];
        buffer.setSize$okio(buffer.size() - 4L);
        if (n4 == n2) {
            buffer.head = segment.pop();
            SegmentPool.recycle((Segment)segment);
        } else {
            segment.pos = n4;
        }
        return (n & 0xFF) << 24 | (n3 & 0xFF) << 16 | (by & 0xFF) << 8 | n5 & 0xFF;
    }

    public static final long commonReadLong(Buffer buffer) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        if (buffer.size() < 8L) throw new EOFException();
        Segment segment = buffer.head;
        Intrinsics.checkNotNull((Object)segment);
        int n = segment.pos;
        int n2 = segment.limit;
        if ((long)(n2 - n) < 8L) {
            return ((long)buffer.readInt() & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL & (long)buffer.readInt();
        }
        byte[] byArray = segment.data;
        int n3 = n + 1;
        long l = byArray[n];
        n = n3 + 1;
        long l2 = byArray[n3];
        n3 = n + 1;
        long l3 = byArray[n];
        n = n3 + 1;
        long l4 = byArray[n3];
        n3 = n + 1;
        long l5 = byArray[n];
        n = n3 + 1;
        long l6 = byArray[n3];
        n3 = n + 1;
        long l7 = byArray[n];
        n = n3 + 1;
        long l8 = byArray[n3];
        buffer.setSize$okio(buffer.size() - 8L);
        if (n == n2) {
            buffer.head = segment.pop();
            SegmentPool.recycle((Segment)segment);
        } else {
            segment.pos = n;
        }
        return (l4 & 0xFFL) << 32 | ((l & 0xFFL) << 56 | (l2 & 0xFFL) << 48 | (l3 & 0xFFL) << 40) | (l5 & 0xFFL) << 24 | (l6 & 0xFFL) << 16 | (l7 & 0xFFL) << 8 | l8 & 0xFFL;
    }

    public static final short commonReadShort(Buffer buffer) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        if (buffer.size() < 2L) throw new EOFException();
        Segment segment = buffer.head;
        Intrinsics.checkNotNull((Object)segment);
        int n = segment.pos;
        int n2 = segment.limit;
        if (n2 - n < 2) {
            n2 = buffer.readByte();
            return (short)(buffer.readByte() & 0xFF | (n2 & 0xFF) << 8);
        }
        byte[] byArray = segment.data;
        int n3 = n + 1;
        byte by = byArray[n];
        n = n3 + 1;
        n3 = byArray[n3];
        buffer.setSize$okio(buffer.size() - 2L);
        if (n == n2) {
            buffer.head = segment.pop();
            SegmentPool.recycle((Segment)segment);
        } else {
            segment.pos = n;
        }
        return (short)((by & 0xFF) << 8 | n3 & 0xFF);
    }

    public static final Buffer.UnsafeCursor commonReadUnsafe(Buffer buffer, Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)unsafeCursor, (String)"unsafeCursor");
        unsafeCursor = _UtilKt.resolveDefaultParameter((Buffer.UnsafeCursor)unsafeCursor);
        boolean bl = unsafeCursor.buffer == null;
        if (!bl) throw (Throwable)new IllegalStateException("already attached to a buffer".toString());
        unsafeCursor.buffer = buffer;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    public static final String commonReadUtf8(Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        int n = l >= 0L && l <= Integer.MAX_VALUE ? 1 : 0;
        if (n == 0) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount: ", (Object)l).toString());
        if (buffer.size() < l) throw new EOFException();
        if (l == 0L) {
            return "";
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull((Object)segment);
        if ((long)segment.pos + l > (long)segment.limit) {
            return _Utf8Kt.commonToUtf8String$default((byte[])buffer.readByteArray(l), (int)0, (int)0, (int)3, null);
        }
        Object object = segment.data;
        n = segment.pos;
        int n2 = segment.pos;
        int n3 = (int)l;
        object = _Utf8Kt.commonToUtf8String((byte[])object, (int)n, (int)(n2 + n3));
        segment.pos += n3;
        buffer.setSize$okio(buffer.size() - l);
        if (segment.pos != segment.limit) return object;
        buffer.head = segment.pop();
        SegmentPool.recycle((Segment)segment);
        return object;
    }

    public static final int commonReadUtf8CodePoint(Buffer object) {
        int n;
        int n2;
        int n3;
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        if (object.size() == 0L) {
            object = new EOFException();
            throw object;
        }
        byte by = object.getByte(0L);
        int n4 = 0;
        int n5 = 65533;
        if ((by & 0x80) == 0) {
            n3 = by & 0x7F;
            n2 = 1;
            n = 0;
        } else if ((by & 0xE0) == 192) {
            n3 = by & 0x1F;
            n2 = 2;
            n = 128;
        } else if ((by & 0xF0) == 224) {
            n3 = by & 0xF;
            n2 = 3;
            n = 2048;
        } else {
            if ((by & 0xF8) != 240) {
                object.skip(1L);
                return 65533;
            }
            n3 = by & 7;
            n2 = 4;
            n = 65536;
        }
        long l = object.size();
        long l2 = n2;
        if (l < l2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("size < ");
            stringBuilder.append(n2);
            stringBuilder.append(": ");
            stringBuilder.append(object.size());
            stringBuilder.append(" (to read code point prefixed 0x");
            stringBuilder.append(_UtilKt.toHexString((byte)by));
            stringBuilder.append(')');
            throw new EOFException(stringBuilder.toString());
        }
        int n6 = n3;
        if (1 < n2) {
            n6 = 1;
            while (true) {
                int n7 = n6 + 1;
                l = n6;
                if (((n6 = (int)object.getByte(l)) & 0xC0) != 128) {
                    object.skip(l);
                    return 65533;
                }
                n3 = n3 << 6 | n6 & 0x3F;
                if (n7 >= n2) {
                    n6 = n3;
                    break;
                }
                n6 = n7;
            }
        }
        object.skip(l2);
        if (n6 > 0x10FFFF) {
            n3 = n5;
        } else {
            n3 = n4;
            if (55296 <= n6) {
                n3 = n4;
                if (n6 <= 57343) {
                    n3 = 1;
                }
            }
            n3 = n3 != 0 ? n5 : (n6 < n ? n5 : n6);
        }
        return n3;
    }

    public static final String commonReadUtf8Line(Buffer object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        long l = object.indexOf((byte)10);
        object = l != -1L ? _BufferKt.readUtf8Line(object, l) : (object.size() != 0L ? object.readUtf8(object.size()) : null);
        return object;
    }

    public static final String commonReadUtf8LineStrict(Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        boolean bl = l >= 0L;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"limit < 0: ", (Object)l).toString());
        long l2 = Long.MAX_VALUE;
        if (l != Long.MAX_VALUE) {
            l2 = l + 1L;
        }
        byte by = (byte)10;
        long l3 = buffer.indexOf(by, 0L, l2);
        if (l3 != -1L) {
            return _BufferKt.readUtf8Line(buffer, l3);
        }
        if (l2 < buffer.size() && buffer.getByte(l2 - 1L) == (byte)13 && buffer.getByte(l2) == by) {
            return _BufferKt.readUtf8Line(buffer, l2);
        }
        Buffer buffer2 = new Buffer();
        l2 = buffer.size();
        buffer.copyTo(buffer2, 0L, Math.min((long)32, l2));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\\n not found: limit=");
        stringBuilder.append(Math.min(buffer.size(), l));
        stringBuilder.append(" content=");
        stringBuilder.append(buffer2.readByteString().hex());
        stringBuilder.append('\u2026');
        throw new EOFException(stringBuilder.toString());
    }

    public static final long commonResizeBuffer(Buffer.UnsafeCursor object, long l) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Buffer buffer = object.buffer;
        if (buffer == null) {
            object = new IllegalStateException("not attached to a buffer".toString());
            throw object;
        }
        if (!object.readWrite) throw (Throwable)new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
        long l2 = buffer.size();
        if (l <= l2) {
            long l3;
            boolean bl = l >= 0L;
            if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"newSize < 0: ", (Object)l).toString());
            for (long i = l2 - l; i > 0L; i -= l3) {
                Segment segment = buffer.head;
                Intrinsics.checkNotNull((Object)segment);
                segment = segment.prev;
                Intrinsics.checkNotNull((Object)segment);
                l3 = segment.limit - segment.pos;
                if (l3 <= i) {
                    buffer.head = segment.pop();
                    SegmentPool.recycle((Segment)segment);
                    continue;
                }
                segment.limit -= (int)i;
                break;
            }
            object.setSegment$okio(null);
            object.offset = l;
            object.data = null;
            object.start = -1;
            object.end = -1;
        } else if (l > l2) {
            int n;
            boolean bl = true;
            for (long i = l - l2; i > 0L; segment.limit += n, i -= (long)n) {
                Segment segment = buffer.writableSegment$okio(1);
                n = (int)Math.min(i, (long)(8192 - segment.limit));
                if (!bl) continue;
                object.setSegment$okio(segment);
                object.offset = l2;
                object.data = segment.data;
                object.start = segment.limit - n;
                object.end = segment.limit;
                bl = false;
            }
        }
        buffer.setSize$okio(l);
        return l2;
    }

    public static final int commonSeek(Buffer.UnsafeCursor object, long l) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Buffer buffer = ((Buffer.UnsafeCursor)object).buffer;
        if (buffer == null) {
            object = new IllegalStateException("not attached to a buffer".toString());
            throw object;
        }
        if (l >= -1L && l <= buffer.size()) {
            if (l != -1L && l != buffer.size()) {
                long l2 = 0L;
                long l3 = buffer.size();
                Segment segment = buffer.head;
                Segment segment2 = buffer.head;
                long l4 = l2;
                long l5 = l3;
                Segment segment3 = segment;
                Segment segment4 = segment2;
                if (object.getSegment$okio() != null) {
                    l5 = ((Buffer.UnsafeCursor)object).offset;
                    int n = ((Buffer.UnsafeCursor)object).start;
                    segment3 = object.getSegment$okio();
                    Intrinsics.checkNotNull((Object)segment3);
                    if ((l5 -= (long)(n - segment3.pos)) > l) {
                        segment4 = object.getSegment$okio();
                        l4 = l2;
                        segment3 = segment;
                    } else {
                        segment3 = object.getSegment$okio();
                        l4 = l5;
                        segment4 = segment2;
                        l5 = l3;
                    }
                }
                if (l5 - l > l - l4) {
                    segment4 = segment3;
                    while (true) {
                        Intrinsics.checkNotNull((Object)segment4);
                        l5 = l4;
                        segment3 = segment4;
                        if (l >= (long)(segment4.limit - segment4.pos) + l4) {
                            l4 += (long)(segment4.limit - segment4.pos);
                            segment4 = segment4.next;
                            continue;
                        }
                        break;
                    }
                } else {
                    for (l2 = l5; l2 > l; l2 -= (long)(segment4.limit - segment4.pos)) {
                        Intrinsics.checkNotNull((Object)segment4);
                        segment4 = segment4.prev;
                        Intrinsics.checkNotNull((Object)segment4);
                    }
                    l5 = l2;
                    segment3 = segment4;
                }
                segment4 = segment3;
                if (((Buffer.UnsafeCursor)object).readWrite) {
                    Intrinsics.checkNotNull((Object)segment3);
                    segment4 = segment3;
                    if (segment3.shared) {
                        segment4 = segment3.unsharedCopy();
                        if (buffer.head == segment3) {
                            buffer.head = segment4;
                        }
                        segment4 = segment3.push(segment4);
                        segment3 = segment4.prev;
                        Intrinsics.checkNotNull((Object)segment3);
                        segment3.pop();
                    }
                }
                object.setSegment$okio(segment4);
                ((Buffer.UnsafeCursor)object).offset = l;
                Intrinsics.checkNotNull((Object)segment4);
                ((Buffer.UnsafeCursor)object).data = segment4.data;
                ((Buffer.UnsafeCursor)object).start = segment4.pos + (int)(l - l5);
                ((Buffer.UnsafeCursor)object).end = segment4.limit;
                return ((Buffer.UnsafeCursor)object).end - ((Buffer.UnsafeCursor)object).start;
            }
            object.setSegment$okio(null);
            ((Buffer.UnsafeCursor)object).offset = l;
            ((Buffer.UnsafeCursor)object).data = null;
            ((Buffer.UnsafeCursor)object).start = -1;
            ((Buffer.UnsafeCursor)object).end = -1;
            return -1;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("offset=");
        ((StringBuilder)object).append(l);
        ((StringBuilder)object).append(" > size=");
        ((StringBuilder)object).append(buffer.size());
        throw new ArrayIndexOutOfBoundsException(((StringBuilder)object).toString());
    }

    public static final int commonSelect(Buffer buffer, Options options) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)options, (String)"options");
        int n = _BufferKt.selectPrefix$default(buffer, options, false, 2, null);
        if (n == -1) {
            return -1;
        }
        buffer.skip((long)options.getByteStrings$okio()[n].size());
        return n;
    }

    public static final void commonSkip(Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        while (l > 0L) {
            Segment segment = buffer.head;
            if (segment == null) throw new EOFException();
            int n = (int)Math.min(l, (long)(segment.limit - segment.pos));
            long l2 = buffer.size();
            long l3 = n;
            buffer.setSize$okio(l2 - l3);
            l2 = l - l3;
            segment.pos += n;
            l = l2;
            if (segment.pos != segment.limit) continue;
            buffer.head = segment.pop();
            SegmentPool.recycle((Segment)segment);
            l = l2;
        }
    }

    public static final ByteString commonSnapshot(Buffer buffer) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        boolean bl = buffer.size() <= Integer.MAX_VALUE;
        if (!bl) throw (Throwable)new IllegalStateException(Intrinsics.stringPlus((String)"size > Int.MAX_VALUE: ", (Object)buffer.size()).toString());
        return buffer.snapshot((int)buffer.size());
    }

    public static final ByteString commonSnapshot(Buffer buffer, int n) {
        int n2;
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        if (n == 0) {
            return ByteString.EMPTY;
        }
        _UtilKt.checkOffsetAndCount((long)buffer.size(), (long)0L, (long)n);
        Object object = buffer.head;
        int n3 = 0;
        int n4 = 0;
        for (n2 = 0; n2 < n; n2 += object.limit - object.pos, ++n4) {
            Intrinsics.checkNotNull((Object)object);
            if (object.limit == object.pos) throw new AssertionError((Object)"s.limit == s.pos");
            object = object.next;
        }
        object = new byte[n4][];
        int[] nArray = new int[n4 * 2];
        buffer = buffer.head;
        n4 = 0;
        n2 = n3;
        while (n2 < n) {
            Intrinsics.checkNotNull((Object)buffer);
            object[n4] = (Segment)buffer.data;
            nArray[n4] = Math.min(n2 += buffer.limit - buffer.pos, n);
            nArray[((Object[])object).length + n4] = buffer.pos;
            buffer.shared = true;
            ++n4;
            buffer = buffer.next;
        }
        return (ByteString)new SegmentedByteString((byte[][])object, nArray);
    }

    public static final Segment commonWritableSegment(Buffer buffer, int n) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        boolean bl = true;
        if (n < 1 || n > 8192) {
            bl = false;
        }
        if (!bl) throw (Throwable)new IllegalArgumentException("unexpected capacity".toString());
        if (buffer.head == null) {
            Segment segment;
            buffer.head = segment = SegmentPool.take();
            segment.prev = segment;
            segment.next = segment;
            return segment;
        }
        buffer = buffer.head;
        Intrinsics.checkNotNull((Object)buffer);
        Segment segment = buffer.prev;
        Intrinsics.checkNotNull((Object)segment);
        if (segment.limit + n <= 8192) {
            buffer = segment;
            if (segment.owner) return buffer;
        }
        buffer = segment.push(SegmentPool.take());
        return buffer;
    }

    public static final Buffer commonWrite(Buffer buffer, ByteString byteString, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"byteString");
        byteString.write$okio(buffer, n, n2);
        return buffer;
    }

    public static final Buffer commonWrite(Buffer buffer, Source source, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        while (l > 0L) {
            long l2 = source.read(buffer, l);
            if (l2 == -1L) throw new EOFException();
            l -= l2;
        }
        return buffer;
    }

    public static final Buffer commonWrite(Buffer buffer, byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"source");
        return buffer.write(byArray, 0, byArray.length);
    }

    public static final Buffer commonWrite(Buffer buffer, byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"source");
        long l = byArray.length;
        long l2 = n;
        long l3 = n2;
        _UtilKt.checkOffsetAndCount((long)l, (long)l2, (long)l3);
        int n3 = n2 + n;
        while (true) {
            if (n >= n3) {
                buffer.setSize$okio(buffer.size() + l3);
                return buffer;
            }
            Segment segment = buffer.writableSegment$okio(1);
            int n4 = Math.min(n3 - n, 8192 - segment.limit);
            byte[] byArray2 = segment.data;
            int n5 = segment.limit;
            n2 = n + n4;
            ArraysKt.copyInto((byte[])byArray, (byte[])byArray2, (int)n5, (int)n, (int)n2);
            segment.limit += n4;
            n = n2;
        }
    }

    public static final void commonWrite(Buffer object, Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"source");
        int n = buffer != object ? 1 : 0;
        if (n == 0) {
            object = new IllegalArgumentException("source == this".toString());
            throw object;
        }
        _UtilKt.checkOffsetAndCount((long)buffer.size(), (long)0L, (long)l);
        while (l > 0L) {
            Segment segment;
            long l2;
            Segment segment2 = buffer.head;
            Intrinsics.checkNotNull((Object)segment2);
            n = segment2.limit;
            segment2 = buffer.head;
            Intrinsics.checkNotNull((Object)segment2);
            if (l < (long)(n - segment2.pos)) {
                if (object.head != null) {
                    segment2 = object.head;
                    Intrinsics.checkNotNull((Object)segment2);
                    segment2 = segment2.prev;
                } else {
                    segment2 = null;
                }
                if (segment2 != null && segment2.owner && (l2 = (long)segment2.limit) + l - (long)(n = segment2.shared ? 0 : segment2.pos) <= 8192L) {
                    segment = buffer.head;
                    Intrinsics.checkNotNull((Object)segment);
                    segment.writeTo(segment2, (int)l);
                    buffer.setSize$okio(buffer.size() - l);
                    object.setSize$okio(object.size() + l);
                    return;
                }
                segment2 = buffer.head;
                Intrinsics.checkNotNull((Object)segment2);
                buffer.head = segment2.split((int)l);
            }
            segment2 = buffer.head;
            Intrinsics.checkNotNull((Object)segment2);
            l2 = segment2.limit - segment2.pos;
            buffer.head = segment2.pop();
            if (object.head == null) {
                object.head = segment2;
                segment2.next = segment2.prev = segment2;
            } else {
                segment = object.head;
                Intrinsics.checkNotNull((Object)segment);
                segment = segment.prev;
                Intrinsics.checkNotNull((Object)segment);
                segment.push(segment2).compact();
            }
            buffer.setSize$okio(buffer.size() - l2);
            object.setSize$okio(object.size() + l2);
            l -= l2;
        }
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer buffer, ByteString byteString, int n, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n = 0;
        }
        if ((n3 & 4) != 0) {
            n2 = byteString.size();
        }
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"byteString");
        byteString.write$okio(buffer, n, n2);
        return buffer;
    }

    public static final long commonWriteAll(Buffer buffer, Source source) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        long l = 0L;
        long l2;
        while ((l2 = source.read(buffer, 8192L)) != -1L) {
            l += l2;
        }
        return l;
    }

    public static final Buffer commonWriteByte(Buffer buffer, int n) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Segment segment = buffer.writableSegment$okio(1);
        byte[] byArray = segment.data;
        int n2 = segment.limit;
        segment.limit = n2 + 1;
        byArray[n2] = (byte)n;
        buffer.setSize$okio(buffer.size() + 1L);
        return buffer;
    }

    public static final Buffer commonWriteDecimalLong(Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        if (l == 0L) {
            return buffer.writeByte(48);
        }
        boolean bl = false;
        int n = 1;
        long l2 = l;
        if (l < 0L) {
            l2 = -l;
            if (l2 < 0L) {
                return buffer.writeUtf8("-9223372036854775808");
            }
            bl = true;
        }
        if (l2 < 100000000L) {
            if (l2 < 10000L) {
                if (l2 < 100L) {
                    if (l2 >= 10L) {
                        n = 2;
                    }
                } else {
                    n = l2 < 1000L ? 3 : 4;
                }
            } else {
                n = l2 < 1000000L ? (l2 < 100000L ? 5 : 6) : (l2 < 10000000L ? 7 : 8);
            }
        } else {
            n = l2 < 1000000000000L ? (l2 < 10000000000L ? (l2 < 1000000000L ? 9 : 10) : (l2 < 100000000000L ? 11 : 12)) : (l2 < 1000000000000000L ? (l2 < 10000000000000L ? 13 : (l2 < 100000000000000L ? 14 : 15)) : (l2 < 100000000000000000L ? (l2 < 10000000000000000L ? 16 : 17) : (l2 < 1000000000000000000L ? 18 : 19)));
        }
        int n2 = n;
        if (bl) {
            n2 = n + 1;
        }
        Segment segment = buffer.writableSegment$okio(n2);
        byte[] byArray = segment.data;
        n = segment.limit + n2;
        while (l2 != 0L) {
            l = 10;
            int n3 = (int)(l2 % l);
            byArray[--n] = _BufferKt.getHEX_DIGIT_BYTES()[n3];
            l2 /= l;
        }
        if (bl) {
            byArray[n - 1] = (byte)45;
        }
        segment.limit += n2;
        buffer.setSize$okio(buffer.size() + (long)n2);
        return buffer;
    }

    public static final Buffer commonWriteHexadecimalUnsignedLong(Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        if (l == 0L) {
            return buffer.writeByte(48);
        }
        long l2 = l >>> 1 | l;
        l2 |= l2 >>> 2;
        l2 |= l2 >>> 4;
        l2 |= l2 >>> 8;
        l2 |= l2 >>> 16;
        l2 |= l2 >>> 32;
        l2 -= l2 >>> 1 & 0x5555555555555555L;
        l2 = (l2 >>> 2 & 0x3333333333333333L) + (l2 & 0x3333333333333333L);
        l2 = (l2 >>> 4) + l2 & 0xF0F0F0F0F0F0F0FL;
        l2 += l2 >>> 8;
        l2 += l2 >>> 16;
        int n = (int)(((l2 & 0x3FL) + (l2 >>> 32 & 0x3FL) + (long)3) / (long)4);
        Segment segment = buffer.writableSegment$okio(n);
        byte[] byArray = segment.data;
        int n2 = segment.limit + n - 1;
        int n3 = segment.limit;
        while (true) {
            if (n2 < n3) {
                segment.limit += n;
                buffer.setSize$okio(buffer.size() + (long)n);
                return buffer;
            }
            byArray[n2] = _BufferKt.getHEX_DIGIT_BYTES()[(int)(0xFL & l)];
            l >>>= 4;
            --n2;
        }
    }

    public static final Buffer commonWriteInt(Buffer buffer, int n) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Segment segment = buffer.writableSegment$okio(4);
        byte[] byArray = segment.data;
        int n2 = segment.limit;
        int n3 = n2 + 1;
        byArray[n2] = (byte)(n >>> 24 & 0xFF);
        n2 = n3 + 1;
        byArray[n3] = (byte)(n >>> 16 & 0xFF);
        n3 = n2 + 1;
        byArray[n2] = (byte)(n >>> 8 & 0xFF);
        byArray[n3] = (byte)(n & 0xFF);
        segment.limit = n3 + 1;
        buffer.setSize$okio(buffer.size() + 4L);
        return buffer;
    }

    public static final Buffer commonWriteLong(Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Segment segment = buffer.writableSegment$okio(8);
        byte[] byArray = segment.data;
        int n = segment.limit;
        int n2 = n + 1;
        byArray[n] = (byte)(l >>> 56 & 0xFFL);
        n = n2 + 1;
        byArray[n2] = (byte)(l >>> 48 & 0xFFL);
        n2 = n + 1;
        byArray[n] = (byte)(l >>> 40 & 0xFFL);
        n = n2 + 1;
        byArray[n2] = (byte)(l >>> 32 & 0xFFL);
        n2 = n + 1;
        byArray[n] = (byte)(l >>> 24 & 0xFFL);
        n = n2 + 1;
        byArray[n2] = (byte)(l >>> 16 & 0xFFL);
        n2 = n + 1;
        byArray[n] = (byte)(l >>> 8 & 0xFFL);
        byArray[n2] = (byte)(l & 0xFFL);
        segment.limit = n2 + 1;
        buffer.setSize$okio(buffer.size() + 8L);
        return buffer;
    }

    public static final Buffer commonWriteShort(Buffer buffer, int n) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Segment segment = buffer.writableSegment$okio(2);
        byte[] byArray = segment.data;
        int n2 = segment.limit;
        int n3 = n2 + 1;
        byArray[n2] = (byte)(n >>> 8 & 0xFF);
        byArray[n3] = (byte)(n & 0xFF);
        segment.limit = n3 + 1;
        buffer.setSize$okio(buffer.size() + 2L);
        return buffer;
    }

    public static final Buffer commonWriteUtf8(Buffer object, String string, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)string, (String)"string");
        int n3 = n >= 0 ? 1 : 0;
        if (n3 == 0) {
            object = new IllegalArgumentException(Intrinsics.stringPlus((String)"beginIndex < 0: ", (Object)n).toString());
            throw object;
        }
        n3 = n2 >= n ? 1 : 0;
        if (n3 == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("endIndex < beginIndex: ");
            ((StringBuilder)object).append(n2);
            ((StringBuilder)object).append(" < ");
            ((StringBuilder)object).append(n);
            throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString().toString());
        }
        n3 = n2 <= string.length() ? 1 : 0;
        if (n3 == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("endIndex > string.length: ");
            ((StringBuilder)object).append(n2);
            ((StringBuilder)object).append(" > ");
            ((StringBuilder)object).append(string.length());
            throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString().toString());
        }
        while (n < n2) {
            int n4;
            int n5;
            Segment segment;
            char c = string.charAt(n);
            if (c < '\u0080') {
                segment = object.writableSegment$okio(1);
                byte[] byArray = segment.data;
                n5 = segment.limit - n;
                n4 = Math.min(n2, 8192 - n5);
                n3 = n + 1;
                byArray[n + n5] = (byte)c;
                n = n3;
            } else {
                if (c < '\u0800') {
                    segment = object.writableSegment$okio(2);
                    segment.data[segment.limit] = (byte)(c >> 6 | 0xC0);
                    segment.data[segment.limit + 1] = (byte)(c & 0x3F | 0x80);
                    segment.limit += 2;
                    object.setSize$okio(object.size() + 2L);
                } else {
                    if (c >= '\ud800' && c <= '\udfff') {
                        n4 = n + 1;
                        n3 = n4 < n2 ? string.charAt(n4) : 0;
                        if (c <= '\udbff' && (n5 = 56320 <= n3 && n3 <= 57343 ? 1 : 0) != 0) {
                            n3 = ((c & 0x3FF) << 10 | n3 & 0x3FF) + 65536;
                            segment = object.writableSegment$okio(4);
                            segment.data[segment.limit] = (byte)(n3 >> 18 | 0xF0);
                            segment.data[segment.limit + 1] = (byte)(n3 >> 12 & 0x3F | 0x80);
                            segment.data[segment.limit + 2] = (byte)(n3 >> 6 & 0x3F | 0x80);
                            segment.data[segment.limit + 3] = (byte)(n3 & 0x3F | 0x80);
                            segment.limit += 4;
                            object.setSize$okio(object.size() + 4L);
                            n += 2;
                            continue;
                        }
                        object.writeByte(63);
                        n = n4;
                        continue;
                    }
                    segment = object.writableSegment$okio(3);
                    segment.data[segment.limit] = (byte)(c >> 12 | 0xE0);
                    segment.data[segment.limit + 1] = (byte)(0x3F & c >> 6 | 0x80);
                    segment.data[segment.limit + 2] = (byte)(c & 0x3F | 0x80);
                    segment.limit += 3;
                    object.setSize$okio(object.size() + 3L);
                }
                ++n;
                continue;
            }
            while (n < n4 && (c = string.charAt(n)) < '\u0080') {
                n3 = n + 1;
                byArray[n + n5] = (byte)c;
                n = n3;
            }
            n3 = n5 + n - segment.limit;
            segment.limit += n3;
            object.setSize$okio(object.size() + (long)n3);
        }
        return object;
    }

    public static final Buffer commonWriteUtf8CodePoint(Buffer buffer, int n) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        if (n < 128) {
            buffer.writeByte(n);
        } else if (n < 2048) {
            Segment segment = buffer.writableSegment$okio(2);
            segment.data[segment.limit] = (byte)(n >> 6 | 0xC0);
            segment.data[segment.limit + 1] = (byte)(n & 0x3F | 0x80);
            segment.limit += 2;
            buffer.setSize$okio(buffer.size() + 2L);
        } else {
            boolean bl;
            boolean bl2 = bl = false;
            if (55296 <= n) {
                bl2 = bl;
                if (n <= 57343) {
                    bl2 = true;
                }
            }
            if (bl2) {
                buffer.writeByte(63);
            } else if (n < 65536) {
                Segment segment = buffer.writableSegment$okio(3);
                segment.data[segment.limit] = (byte)(n >> 12 | 0xE0);
                segment.data[segment.limit + 1] = (byte)(n >> 6 & 0x3F | 0x80);
                segment.data[segment.limit + 2] = (byte)(n & 0x3F | 0x80);
                segment.limit += 3;
                buffer.setSize$okio(buffer.size() + 3L);
            } else {
                if (n > 0x10FFFF) throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Unexpected code point: 0x", (Object)_UtilKt.toHexString((int)n)));
                Segment segment = buffer.writableSegment$okio(4);
                segment.data[segment.limit] = (byte)(n >> 18 | 0xF0);
                segment.data[segment.limit + 1] = (byte)(n >> 12 & 0x3F | 0x80);
                segment.data[segment.limit + 2] = (byte)(n >> 6 & 0x3F | 0x80);
                segment.data[segment.limit + 3] = (byte)(n & 0x3F | 0x80);
                segment.limit += 4;
                buffer.setSize$okio(buffer.size() + 4L);
            }
        }
        return buffer;
    }

    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static /* synthetic */ void getHEX_DIGIT_BYTES$annotations() {
    }

    public static final boolean rangeEquals(Segment object, int n, byte[] byArray, int n2, int n3) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"segment");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"bytes");
        int n4 = object.limit;
        Object object2 = object.data;
        while (n2 < n3) {
            int n5 = n4;
            Segment segment = object;
            int n6 = n;
            if (n == n4) {
                segment = object.next;
                Intrinsics.checkNotNull((Object)segment);
                object = segment.data;
                n6 = segment.pos;
                n5 = segment.limit;
                object2 = object;
            }
            if (object2[n6] != byArray[n2]) {
                return false;
            }
            n = n6 + 1;
            ++n2;
            n4 = n5;
            object = segment;
        }
        return true;
    }

    public static final String readUtf8Line(Buffer object, long l) {
        long l2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        if (l > 0L && object.getByte(l2 = l - 1L) == (byte)13) {
            String string = object.readUtf8(l2);
            object.skip(2L);
            object = string;
        } else {
            String string = object.readUtf8(l);
            object.skip(1L);
            object = string;
        }
        return object;
    }

    public static final <T> T seek(Buffer buffer, long l, Function2<? super Segment, ? super Long, ? extends T> function2) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Intrinsics.checkNotNullParameter(function2, (String)"lambda");
        Segment segment = buffer.head;
        if (segment == null) {
            return (T)function2.invoke(null, (Object)-1L);
        }
        if (buffer.size() - l < l) {
            long l2 = buffer.size();
            while (l2 > l) {
                segment = segment.prev;
                Intrinsics.checkNotNull((Object)segment);
                l2 -= (long)(segment.limit - segment.pos);
            }
            return (T)function2.invoke((Object)segment, (Object)l2);
        }
        long l3 = 0L;
        long l4;
        while ((l4 = (long)(segment.limit - segment.pos) + l3) <= l) {
            segment = segment.next;
            Intrinsics.checkNotNull((Object)segment);
            l3 = l4;
        }
        return (T)function2.invoke((Object)segment, (Object)l3);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final int selectPrefix(Buffer var0, Options var1_1, boolean var2_2) {
        Intrinsics.checkNotNullParameter((Object)var0 /* !! */ , (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)var1_1 /* !! */ , (String)"options");
        var12_3 = var0 /* !! */ .head;
        var3_4 = -2;
        if (var12_3 == null) {
            if (var2_2) return var3_4;
            var3_4 = -1;
            return var3_4;
        }
        var0 /* !! */  = (Buffer)var12_3.data;
        var3_4 = var12_3.pos;
        var4_5 = var12_3.limit;
        var14_6 = var1_1 /* !! */ .getTrie$okio();
        var11_7 /* !! */  = var12_3;
        var5_8 /* !! */  = 0;
        var6_9 = -1;
        var1_1 /* !! */  = var0 /* !! */ ;
        block0: while (true) {
            block18: {
                block17: {
                    var8_11 = var5_8 /* !! */  + 1;
                    var10_13 = var14_6[var5_8 /* !! */ ];
                    var7_10 = var8_11 + 1;
                    var5_8 /* !! */  = var14_6[var8_11];
                    if (var5_8 /* !! */  != -1) {
                        var6_9 = var5_8 /* !! */ ;
                    }
                    if (var11_7 /* !! */  == null) break block17;
                    if (var10_13 >= 0) break block18;
                    var5_8 /* !! */  = var7_10;
                    while (true) {
                        block19: {
                            var8_11 = var3_4 + 1;
                            var3_4 = (int)var1_1 /* !! */ [var3_4];
                            var9_12 = var5_8 /* !! */  + 1;
                            if ((var3_4 & 255) != var14_6[var5_8 /* !! */ ]) {
                                return var6_9;
                            }
                            var5_8 /* !! */  = var9_12 == var7_10 + var10_13 * -1 ? 1 : 0;
                            if (var8_11 == var4_5) {
                                Intrinsics.checkNotNull((Object)var11_7 /* !! */ );
                                var0 /* !! */  = var11_7 /* !! */ .next;
                                Intrinsics.checkNotNull((Object)var0 /* !! */ );
                                var4_5 = var0 /* !! */ .pos;
                                var1_1 /* !! */  = (Options)var0 /* !! */ .data;
                                var3_4 = var0 /* !! */ .limit;
                                if (var0 /* !! */  == var12_3) {
                                    if (var5_8 /* !! */  == 0) break;
                                    var0 /* !! */  = null;
                                }
                            } else {
                                var3_4 = var4_5;
                                var4_5 = var8_11;
                                var0 /* !! */  = var11_7 /* !! */ ;
                            }
                            if (var5_8 /* !! */  == 0) break block19;
                            var7_10 = var14_6[var9_12];
                            var5_8 /* !! */  = var3_4;
                            var3_4 = var4_5;
                            ** GOTO lbl92
                        }
                        var8_11 = var4_5;
                        var4_5 = var3_4;
                        var5_8 /* !! */  = var9_12;
                        var3_4 = var8_11;
                        var11_7 /* !! */  = var0 /* !! */ ;
                    }
                }
                if (var2_2 == false) return var6_9;
                return -2;
            }
            var8_11 = var3_4 + 1;
            var5_8 /* !! */  = (int)var1_1 /* !! */ [var3_4];
            var3_4 = var7_10;
            while (true) {
                block20: {
                    if (var3_4 == var7_10 + var10_13) {
                        return var6_9;
                    }
                    if ((var5_8 /* !! */  & 255) != var14_6[var3_4]) break block20;
                    var7_10 = var9_12 = var14_6[var3_4 + var10_13];
                    var5_8 /* !! */  = var4_5;
                    var0 /* !! */  = var11_7 /* !! */ ;
                    var3_4 = var8_11;
                    if (var8_11 == var4_5) {
                        var13_14 = var11_7 /* !! */ .next;
                        Intrinsics.checkNotNull((Object)var13_14);
                        var4_5 = var13_14.pos;
                        var11_7 /* !! */  = (Segment)var13_14.data;
                        var8_11 = var13_14.limit;
                        var1_1 /* !! */  = var11_7 /* !! */ ;
                        var7_10 = var9_12;
                        var5_8 /* !! */  = var8_11;
                        var0 /* !! */  = var13_14;
                        var3_4 = var4_5;
                        if (var13_14 == var12_3) {
                            var0 /* !! */  = null;
                            var3_4 = var4_5;
                            var5_8 /* !! */  = var8_11;
                            var7_10 = var9_12;
                            var1_1 /* !! */  = var11_7 /* !! */ ;
                        }
                    }
lbl92:
                    // 6 sources

                    if (var7_10 >= 0) {
                        return var7_10;
                    }
                    var7_10 = -var7_10;
                    var4_5 = var5_8 /* !! */ ;
                    var5_8 /* !! */  = var7_10;
                    var11_7 /* !! */  = var0 /* !! */ ;
                    continue block0;
                }
                ++var3_4;
            }
            break;
        }
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean bl, int n, Object object) {
        if ((n & 2) == 0) return _BufferKt.selectPrefix(buffer, options, bl);
        bl = false;
        return _BufferKt.selectPrefix(buffer, options, bl);
    }
}
