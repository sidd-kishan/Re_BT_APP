/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Charsets
 *  okio.Buffer$UnsafeCursor
 *  okio.BufferedSink
 *  okio.BufferedSource
 *  okio.ByteString
 *  okio.Okio
 *  okio.Options
 *  okio.PeekSource
 *  okio.Segment
 *  okio.SegmentPool
 *  okio.SegmentedByteString
 *  okio.Sink
 *  okio.Source
 *  okio.Timeout
 *  okio._UtilKt
 *  okio.internal._BufferKt
 */
package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import okio._UtilKt;
import okio.internal._BufferKt;

@Metadata(d1={"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0090\u0001B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0000H\u0016J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0000J$\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\fJ \u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0000H\u0016J\b\u0010!\u001a\u00020\u0000H\u0016J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\fH\u0087\u0002\u00a2\u0006\u0002\b+J\u0015\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\fH\u0007\u00a2\u0006\u0002\b-J\b\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001dH\u0002J\u000e\u00102\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00103\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00104\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)H\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\fH\u0016J \u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fH\u0016J\u0010\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\u0010\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001dH\u0016J\u0018\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020#H\u0016J\u0006\u0010?\u001a\u00020\u001dJ\b\u0010@\u001a\u00020\u0019H\u0016J\b\u0010A\u001a\u00020\u0001H\u0016J\u0018\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J(\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020GH\u0016J \u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010H\u001a\u00020\f2\u0006\u0010E\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010M\u001a\u00020)H\u0016J\b\u0010N\u001a\u00020GH\u0016J\u0010\u0010N\u001a\u00020G2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010O\u001a\u00020\u001dH\u0016J\u0010\u0010O\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010P\u001a\u00020\fH\u0016J\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=J\u0016\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\fJ \u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010S\u001a\u00020#H\u0002J\u0010\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020GH\u0016J\u0018\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010U\u001a\u00020\fH\u0016J\b\u0010V\u001a\u00020/H\u0016J\b\u0010W\u001a\u00020/H\u0016J\b\u0010X\u001a\u00020\fH\u0016J\b\u0010Y\u001a\u00020\fH\u0016J\b\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020[H\u0016J\u0010\u0010]\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J\u0018\u0010]\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010^\u001a\u00020_H\u0016J\u0012\u0010`\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010a\u001a\u00020\u001fH\u0016J\u0010\u0010a\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010b\u001a\u00020/H\u0016J\n\u0010c\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010d\u001a\u00020\u001fH\u0016J\u0010\u0010d\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020\fH\u0016J\u0010\u0010f\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010g\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00020jH\u0016J\u0006\u0010k\u001a\u00020\u001dJ\u0006\u0010l\u001a\u00020\u001dJ\u0006\u0010m\u001a\u00020\u001dJ\r\u0010\r\u001a\u00020\fH\u0007\u00a2\u0006\u0002\bnJ\u0010\u0010o\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0006\u0010p\u001a\u00020\u001dJ\u000e\u0010p\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020/J\b\u0010q\u001a\u00020rH\u0016J\b\u0010s\u001a\u00020\u001fH\u0016J\u0015\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020/H\u0000\u00a2\u0006\u0002\bvJ\u0010\u0010w\u001a\u00020/2\u0006\u0010x\u001a\u00020FH\u0016J\u0010\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020GH\u0016J \u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010w\u001a\u00020\u00122\u0006\u0010x\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010w\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u001dH\u0016J \u0010w\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020z2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010{\u001a\u00020\f2\u0006\u0010x\u001a\u00020zH\u0016J\u0010\u0010|\u001a\u00020\u00002\u0006\u00106\u001a\u00020/H\u0016J\u0010\u0010}\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0010\u0010\u007f\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0012\u0010\u0080\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0082\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020/H\u0016J\u0011\u0010\u0083\u0001\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0011\u0010\u0084\u0001\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0012\u0010\u0085\u0001\u001a\u00020\u00002\u0007\u0010\u0086\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0087\u0001\u001a\u00020\u00002\u0007\u0010\u0086\u0001\u001a\u00020/H\u0016J\u001a\u0010\u0088\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J,\u0010\u0088\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u001f2\u0007\u0010\u008a\u0001\u001a\u00020/2\u0007\u0010\u008b\u0001\u001a\u00020/2\u0006\u0010^\u001a\u00020_H\u0016J\u001b\u0010\u008c\u0001\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0012\u0010\u008d\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u001fH\u0016J$\u0010\u008d\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u001f2\u0007\u0010\u008a\u0001\u001a\u00020/2\u0007\u0010\u008b\u0001\u001a\u00020/H\u0016J\u0012\u0010\u008e\u0001\u001a\u00020\u00002\u0007\u0010\u008f\u0001\u001a\u00020/H\u0016R\u0014\u0010\u0006\u001a\u00020\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0002\n\u0000R&\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@@X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0091\u0001"}, d2={"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "()V", "buffer", "getBuffer", "()Lokio/Buffer;", "head", "Lokio/Segment;", "<set-?>", "", "size", "()J", "setSize$okio", "(J)V", "clear", "", "clone", "close", "completeSegmentByteCount", "copy", "copyTo", "out", "Ljava/io/OutputStream;", "offset", "byteCount", "digest", "Lokio/ByteString;", "algorithm", "", "emit", "emitCompleteSegments", "equals", "", "other", "", "exhausted", "flush", "get", "", "pos", "getByte", "index", "-deprecated_getByte", "hashCode", "", "hmac", "key", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "md5", "outputStream", "peek", "rangeEquals", "bytesOffset", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readAndWriteUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFrom", "input", "forever", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "charset", "Ljava/nio/charset/Charset;", "readUnsafe", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "sha1", "sha256", "sha512", "-deprecated_size", "skip", "snapshot", "timeout", "Lokio/Timeout;", "toString", "writableSegment", "minimumCapacity", "writableSegment$okio", "write", "source", "byteString", "Lokio/Source;", "writeAll", "writeByte", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "beginIndex", "endIndex", "writeTo", "writeUtf8", "writeUtf8CodePoint", "codePoint", "UnsafeCursor", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class Buffer
implements BufferedSource,
BufferedSink,
Cloneable,
ByteChannel {
    public Segment head;
    private long size;

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, OutputStream outputStream2, long l, long l2, int n, Object object) throws IOException {
        if ((n & 2) != 0) {
            l = 0L;
        }
        if ((n & 4) == 0) return buffer.copyTo(outputStream2, l, l2);
        l2 = buffer.size - l;
        return buffer.copyTo(outputStream2, l, l2);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long l, int n, Object object) {
        if ((n & 2) == 0) return buffer.copyTo(buffer2, l);
        l = 0L;
        return buffer.copyTo(buffer2, l);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long l, long l2, int n, Object object) {
        if ((n & 2) == 0) return buffer.copyTo(buffer2, l, l2);
        l = 0L;
        return buffer.copyTo(buffer2, l, l2);
    }

    private final ByteString digest(String object) {
        MessageDigest messageDigest = MessageDigest.getInstance((String)object);
        Segment segment = this.head;
        if (segment != null) {
            messageDigest.update(segment.data, segment.pos, segment.limit - segment.pos);
            object = segment.next;
            Intrinsics.checkNotNull((Object)object);
            while (object != segment) {
                messageDigest.update(((Segment)object).data, ((Segment)object).pos, ((Segment)object).limit - ((Segment)object).pos);
                object = ((Segment)object).next;
                Intrinsics.checkNotNull((Object)object);
            }
        }
        object = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"messageDigest.digest()");
        return new ByteString((byte[])object);
    }

    /*
     * Exception decompiling
     */
    private final ByteString hmac(String var1_1, ByteString var2_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int n, Object object) {
        if ((n & 1) == 0) return buffer.readAndWriteUnsafe(unsafeCursor);
        unsafeCursor = _UtilKt.getDEFAULT__new_UnsafeCursor();
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    private final void readFrom(InputStream inputStream2, long l, boolean bl) throws IOException {
        while (true) {
            if (l <= 0L) {
                if (!bl) return;
            }
            Segment segment = this.writableSegment$okio(1);
            int n = (int)Math.min(l, (long)(8192 - segment.limit));
            if ((n = inputStream2.read(segment.data, segment.limit, n)) == -1) {
                if (segment.pos == segment.limit) {
                    this.head = segment.pop();
                    SegmentPool.recycle((Segment)segment);
                }
                if (!bl) throw new EOFException();
                return;
            }
            segment.limit += n;
            long l2 = this.size;
            long l3 = n;
            this.size = l2 + l3;
            l -= l3;
        }
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int n, Object object) {
        if ((n & 1) == 0) return buffer.readUnsafe(unsafeCursor);
        unsafeCursor = _UtilKt.getDEFAULT__new_UnsafeCursor();
        return buffer.readUnsafe(unsafeCursor);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream2, long l, int n, Object object) throws IOException {
        if ((n & 2) == 0) return buffer.writeTo(outputStream2, l);
        l = buffer.size;
        return buffer.writeTo(outputStream2, l);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to operator function", replaceWith=@ReplaceWith(expression="this[index]", imports={}))
    public final byte _deprecated_getByte(long l) {
        return this.getByte(l);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="size", imports={}))
    public final long _deprecated_size() {
        return this.size;
    }

    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        this.skip(this.size());
    }

    public Buffer clone() {
        return this.copy();
    }

    @Override
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long l = this.size();
        long l2 = 0L;
        if (l == 0L) return l2;
        Segment segment = this.head;
        Intrinsics.checkNotNull((Object)segment);
        segment = segment.prev;
        Intrinsics.checkNotNull((Object)segment);
        l2 = l;
        if (segment.limit >= 8192) return l2;
        l2 = l;
        if (!segment.owner) return l2;
        l2 = l - (long)(segment.limit - segment.pos);
        return l2;
    }

    public final Buffer copy() {
        Segment segment;
        Buffer buffer = new Buffer();
        if (this.size() == 0L) return buffer;
        Segment segment2 = this.head;
        Intrinsics.checkNotNull((Object)segment2);
        buffer.head = segment = segment2.sharedCopy();
        segment.next = segment.prev = segment;
        Segment segment3 = segment2.next;
        while (segment3 != segment2) {
            Segment segment4 = segment.prev;
            Intrinsics.checkNotNull((Object)segment4);
            Intrinsics.checkNotNull((Object)segment3);
            segment4.push(segment3.sharedCopy());
            segment3 = segment3.next;
        }
        buffer.setSize$okio(this.size());
        return buffer;
    }

    public final Buffer copyTo(OutputStream outputStream2) throws IOException {
        Intrinsics.checkNotNullParameter((Object)outputStream2, (String)"out");
        return Buffer.copyTo$default(this, outputStream2, 0L, 0L, 6, null);
    }

    public final Buffer copyTo(OutputStream outputStream2, long l) throws IOException {
        Intrinsics.checkNotNullParameter((Object)outputStream2, (String)"out");
        return Buffer.copyTo$default(this, outputStream2, l, 0L, 4, null);
    }

    public final Buffer copyTo(OutputStream outputStream2, long l, long l2) throws IOException {
        Intrinsics.checkNotNullParameter((Object)outputStream2, (String)"out");
        _UtilKt.checkOffsetAndCount((long)this.size, (long)l, (long)l2);
        if (l2 == 0L) {
            return this;
        }
        Segment segment = this.head;
        while (true) {
            Intrinsics.checkNotNull((Object)segment);
            Segment segment2 = segment;
            long l3 = l;
            long l4 = l2;
            if (l < (long)(segment.limit - segment.pos)) {
                while (l4 > 0L) {
                    Intrinsics.checkNotNull((Object)segment2);
                    int n = (int)((long)segment2.pos + l3);
                    int n2 = (int)Math.min((long)(segment2.limit - n), l4);
                    outputStream2.write(segment2.data, n, n2);
                    l4 -= (long)n2;
                    segment2 = segment2.next;
                    l3 = 0L;
                }
                return this;
            }
            l -= (long)(segment.limit - segment.pos);
            segment = segment.next;
        }
    }

    public final Buffer copyTo(Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"out");
        return this.copyTo(buffer, l, this.size - l);
    }

    public final Buffer copyTo(Buffer buffer, long l, long l2) {
        long l3;
        long l4;
        Segment segment;
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"out");
        _UtilKt.checkOffsetAndCount((long)this.size(), (long)l, (long)l2);
        if (l2 == 0L) {
            return this;
        }
        buffer.setSize$okio(buffer.size() + l2);
        Segment segment2 = this.head;
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
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                buffer.head = segment2.next = (segment2.prev = segment2);
            } else {
                Intrinsics.checkNotNull((Object)segment3);
                segment3 = segment3.prev;
                Intrinsics.checkNotNull((Object)segment3);
                segment3.push(segment2);
            }
            l3 -= (long)(segment2.limit - segment2.pos);
            segment = segment.next;
            l4 = 0L;
        }
        return this;
    }

    public Buffer emit() {
        return this;
    }

    public Buffer emitCompleteSegments() {
        return this;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean equals(Object var1_1) {
        var6_2 = false;
        if (this == var1_1) ** GOTO lbl14
        if (!(var1_1 instanceof Buffer) || (var7_3 = this.size()) != (var1_1 = (Buffer)var1_1).size()) return var6_2;
        if (this.size() == 0L) ** GOTO lbl14
        var13_4 /* !! */  = this.head;
        Intrinsics.checkNotNull((Object)var13_4 /* !! */ );
        var1_1 = var1_1.head;
        Intrinsics.checkNotNull((Object)var1_1);
        var2_5 = var13_4 /* !! */ .pos;
        var3_6 = var1_1.pos;
        var7_3 = 0L;
        while (true) {
            block9: {
                if (var7_3 < this.size()) break block9;
lbl14:
                // 3 sources

                var6_2 = true;
                break;
            }
            var11_10 = Math.min(var13_4 /* !! */ .limit - var2_5, var1_1.limit - var3_6);
            var5_8 /* !! */  = var2_5;
            var4_7 = var3_6;
            if (0L < var11_10) {
                var9_9 = 0L;
                while (true) {
                    ++var9_9;
                    var14_11 /* !! */  = (Segment)var13_4 /* !! */ .data;
                    var4_7 = var2_5 + 1;
                    var5_8 /* !! */  = (int)var14_11 /* !! */ [var2_5];
                    var14_11 /* !! */  = (Segment)var1_1.data;
                    var2_5 = var3_6 + 1;
                    if (var5_8 /* !! */  != var14_11 /* !! */ [var3_6]) return var6_2;
                    if (var9_9 >= var11_10) {
                        var5_8 /* !! */  = var4_7;
                        var4_7 = var2_5;
                        break;
                    }
                    var3_6 = var2_5;
                    var2_5 = var4_7;
                }
            }
            var14_11 /* !! */  = var13_4 /* !! */ ;
            var2_5 = var5_8 /* !! */ ;
            if (var5_8 /* !! */  == var13_4 /* !! */ .limit) {
                var14_11 /* !! */  = var13_4 /* !! */ .next;
                Intrinsics.checkNotNull((Object)var14_11 /* !! */ );
                var2_5 = var14_11 /* !! */ .pos;
            }
            var13_4 /* !! */  = var1_1;
            var3_6 = var4_7;
            if (var4_7 == var1_1.limit) {
                var13_4 /* !! */  = var1_1.next;
                Intrinsics.checkNotNull((Object)var13_4 /* !! */ );
                var3_6 = var13_4 /* !! */ .pos;
            }
            var7_3 += var11_10;
            var1_1 = var13_4 /* !! */ ;
            var13_4 /* !! */  = var14_11 /* !! */ ;
        }
        return var6_2;
    }

    public boolean exhausted() {
        boolean bl = this.size == 0L;
        return bl;
    }

    public void flush() {
    }

    public Buffer getBuffer() {
        return this;
    }

    public final byte getByte(long l) {
        byte by;
        _UtilKt.checkOffsetAndCount((long)this.size(), (long)l, (long)1L);
        Segment segment = this.head;
        if (segment == null) {
            segment = null;
            Intrinsics.checkNotNull((Object)segment);
            by = segment.data[(int)((long)segment.pos + l + 1L)];
        } else if (this.size() - l < l) {
            long l2;
            for (l2 = this.size(); l2 > l; l2 -= (long)(segment.limit - segment.pos)) {
                segment = segment.prev;
                Intrinsics.checkNotNull((Object)segment);
            }
            Intrinsics.checkNotNull((Object)segment);
            by = segment.data[(int)((long)segment.pos + l - l2)];
        } else {
            long l3 = 0L;
            while (true) {
                long l4;
                if ((l4 = (long)(segment.limit - segment.pos) + l3) > l) {
                    Intrinsics.checkNotNull((Object)segment);
                    by = segment.data[(int)((long)segment.pos + l - l3)];
                    break;
                }
                segment = segment.next;
                Intrinsics.checkNotNull((Object)segment);
                l3 = l4;
            }
        }
        return by;
    }

    public int hashCode() {
        int n;
        Segment segment = this.head;
        if (segment == null) {
            n = 0;
        } else {
            Segment segment2;
            int n2 = 1;
            do {
                int n3 = segment.limit;
                n = n2;
                for (int i = segment.pos; i < n3; ++i) {
                    n = n * 31 + segment.data[i];
                }
                segment2 = segment.next;
                Intrinsics.checkNotNull((Object)segment2);
                segment = segment2;
                n2 = n;
            } while (segment2 != this.head);
        }
        return n;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"key");
        return this.hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"key");
        return this.hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"key");
        return this.hmac("HmacSHA512", byteString);
    }

    public long indexOf(byte by) {
        return this.indexOf(by, 0L, Long.MAX_VALUE);
    }

    public long indexOf(byte by, long l) {
        return this.indexOf(by, l, Long.MAX_VALUE);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     */
    public long indexOf(byte by, long l, long l2) {
        void var16_13;
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
            stringBuilder.append(this.size());
            stringBuilder.append(" fromIndex=");
            stringBuilder.append(l);
            stringBuilder.append(" toIndex=");
            stringBuilder.append(l2);
            Throwable throwable = new IllegalArgumentException(stringBuilder.toString().toString());
            throw throwable;
        }
        long l4 = l2;
        if (l2 > this.size()) {
            l4 = this.size();
        }
        long l5 = -1L;
        if (l == l4) {
            return l5;
        }
        Segment segment = this.head;
        if (segment == null) {
            Segment segment2 = null;
            return l5;
        }
        Segment segment3 = segment;
        l2 = l3;
        if (this.size() - l < l) {
            void var17_22;
            Segment segment4;
            Segment segment5 = segment;
            for (l2 = this.size(); l2 > l; l2 -= (long)(segment4.limit - segment4.pos)) {
                segment4 = var17_22.prev;
                Intrinsics.checkNotNull((Object)segment4);
            }
            long l6 = l;
            void var16_11 = var17_22;
            l = l2;
            if (var17_22 == null) {
                return l5;
            }
            while (true) {
                void var16_12;
                l3 = l5;
                if (l >= l4) return l3;
                byte[] byArray = var16_12.data;
                n = (int)Math.min((long)var16_12.limit, (long)var16_12.pos + l4 - l);
                for (n2 = (int)((long)var16_12.pos + l6 - l); n2 < n; ++n2) {
                    if (byArray[n2] == by) return (long)(n2 - var16_13.pos) + l;
                }
                Segment segment6 = var16_12.next;
                Intrinsics.checkNotNull((Object)segment6);
                l6 = l += (long)(var16_12.limit - var16_12.pos);
            }
        }
        while (true) {
            void var17_26;
            if ((l3 = (long)(var17_26.limit - var17_26.pos) + l2) > l) {
                void var16_15 = var17_26;
                if (var17_26 != null) break;
                return l5;
            }
            Segment segment7 = var17_26.next;
            Intrinsics.checkNotNull((Object)segment7);
            l2 = l3;
        }
        block4: while (true) {
            void var16_16;
            l3 = l5;
            if (l2 >= l4) return l3;
            byte[] byArray = var16_16.data;
            n = (int)Math.min((long)var16_16.limit, (long)var16_16.pos + l4 - l2);
            for (n2 = (int)((long)var16_16.pos + l - l2); n2 < n; ++n2) {
                if (byArray[n2] == by) break block4;
            }
            Segment segment8 = var16_16.next;
            Intrinsics.checkNotNull((Object)segment8);
            l = l2 += (long)(var16_16.limit - var16_16.pos);
        }
        l = l2;
        return (long)(n2 - var16_13.pos) + l;
    }

    public long indexOf(ByteString byteString) throws IOException {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"bytes");
        return this.indexOf(byteString, 0L);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public long indexOf(ByteString var1_1, long var2_2) throws IOException {
        block14: {
            block16: {
                block15: {
                    Intrinsics.checkNotNullParameter((Object)var1_1 /* !! */ , (String)"bytes");
                    var4_3 = var1_1 /* !! */ .size() > 0 ? 1 : 0;
                    if (var4_3 == 0) {
                        var1_1 /* !! */  = new IllegalArgumentException("bytes is empty".toString());
                        throw var1_1 /* !! */ ;
                    }
                    var9_4 = 0L;
                    var4_3 = var2_2 >= 0L ? 1 : 0;
                    if (var4_3 == 0) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"fromIndex < 0: ", (Object)var2_2).toString());
                    var16_5 /* !! */  = this.head;
                    if (var16_5 /* !! */  != null) break block15;
                    var1_1 /* !! */  = null;
                    ** GOTO lbl29
                }
                var15_6 /* !! */  = var16_5 /* !! */ ;
                if (this.size() - var2_2 >= var2_2) break block16;
                var15_6 /* !! */  = var16_5 /* !! */ ;
                for (var9_4 = this.size(); var9_4 > var2_2; var9_4 -= (long)(var15_6 /* !! */ .limit - var15_6 /* !! */ .pos)) {
                    var15_6 /* !! */  = var15_6 /* !! */ .prev;
                    Intrinsics.checkNotNull((Object)var15_6 /* !! */ );
                }
                if (var15_6 /* !! */  == null) ** GOTO lbl29
                var16_5 /* !! */  = (Segment)var1_1 /* !! */ .internalArray$okio();
                var6_7 = var16_5 /* !! */ [0];
                var7_9 = var1_1 /* !! */ .size();
                var11_11 = this.size() - (long)var7_9 + 1L;
                var1_1 /* !! */  = var15_6 /* !! */ ;
                while (true) {
                    block17: {
                        if (var9_4 < var11_11) break block17;
lbl29:
                        // 5 sources

                        while (true) {
                            var2_2 = -1L;
                            break block14;
                            break;
                        }
                    }
                    var15_6 /* !! */  = (Segment)var1_1 /* !! */ .data;
                    var4_3 = var1_1 /* !! */ .limit;
                    var4_3 = (int)((long)var1_1 /* !! */ .pos + var2_2 - var9_4);
                    var13_17 = var1_1 /* !! */ .pos;
                    var8_15 = (int)Math.min((long)var4_3, var13_17 + var11_11 - var9_4);
                    if (var4_3 < var8_15) {
                        while (true) {
                            var5_13 = var4_3 + 1;
                            if (var15_6 /* !! */ [var4_3] == var6_7 && _BufferKt.rangeEquals((Segment)var1_1 /* !! */ , (int)var5_13, (byte[])var16_5 /* !! */ , (int)1, (int)var7_9)) {
                                var2_2 = (long)(var4_3 - var1_1 /* !! */ .pos) + var9_4;
                                break block14;
                            }
                            if (var5_13 >= var8_15) break;
                            var4_3 = var5_13;
                        }
                    }
                    var1_1 /* !! */  = var1_1 /* !! */ .next;
                    Intrinsics.checkNotNull((Object)var1_1 /* !! */ );
                    var2_2 = var9_4 += (long)(var1_1 /* !! */ .limit - var1_1 /* !! */ .pos);
                }
            }
            while (true) {
                block18: {
                    if ((var11_12 = (long)(var15_6 /* !! */ .limit - var15_6 /* !! */ .pos) + var9_4) <= var2_2) break block18;
                    if (var15_6 /* !! */  == null) ** GOTO lbl29
                    break;
                }
                var15_6 /* !! */  = var15_6 /* !! */ .next;
                Intrinsics.checkNotNull((Object)var15_6 /* !! */ );
                var9_4 = var11_12;
            }
            var16_5 /* !! */  = (Segment)var1_1 /* !! */ .internalArray$okio();
            var7_10 = var16_5 /* !! */ [0];
            var6_8 = var1_1 /* !! */ .size();
            var13_18 = this.size() - (long)var6_8 + 1L;
            var11_12 = var9_4;
            var9_4 = var2_2;
            var2_2 = var13_18;
            block5: while (true) {
                if (var11_12 < var2_2) ** break;
                ** continue;
                var1_1 /* !! */  = (ByteString)var15_6 /* !! */ .data;
                var4_3 = var15_6 /* !! */ .limit;
                var4_3 = (int)((long)var15_6 /* !! */ .pos + var9_4 - var11_12);
                var13_18 = var15_6 /* !! */ .pos;
                var8_16 = (int)Math.min((long)var4_3, var13_18 + var2_2 - var11_12);
                if (var4_3 < var8_16) {
                    while (true) {
                        var5_14 = var4_3 + 1;
                        if (var1_1 /* !! */ [var4_3] == var7_10 && _BufferKt.rangeEquals((Segment)var15_6 /* !! */ , (int)var5_14, (byte[])var16_5 /* !! */ , (int)1, (int)var6_8)) {
                            var2_2 = (long)(var4_3 - var15_6 /* !! */ .pos) + var11_12;
                            break block5;
                        }
                        if (var5_14 >= var8_16) break;
                        var4_3 = var5_14;
                    }
                }
                var15_6 /* !! */  = var15_6 /* !! */ .next;
                Intrinsics.checkNotNull((Object)var15_6 /* !! */ );
                var9_4 = var11_12 += (long)(var15_6 /* !! */ .limit - var15_6 /* !! */ .pos);
            }
        }
        return var2_2;
    }

    public long indexOfElement(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"targetBytes");
        return this.indexOfElement(byteString, 0L);
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    public long indexOfElement(ByteString var1_1, long var2_2) {
        block19: {
            block20: {
                block22: {
                    block23: {
                        block21: {
                            Intrinsics.checkNotNullParameter((Object)var1_1 /* !! */ , (String)"targetBytes");
                            var10_3 = 0L;
                            var4_4 = var2_2 >= 0L ? 1 : 0;
                            if (var4_4 == 0) {
                                var1_1 /* !! */  = new IllegalArgumentException(Intrinsics.stringPlus((String)"fromIndex < 0: ", (Object)var2_2).toString());
                                throw var1_1 /* !! */ ;
                            }
                            var17_5 /* !! */  = this.head;
                            var14_6 = -1L;
                            if (var17_5 /* !! */  != null) break block21;
                            var1_1 /* !! */  = null;
                            var2_2 = var14_6;
                            break block19;
                        }
                        var16_7 = var17_5 /* !! */ ;
                        if (this.size() - var2_2 >= var2_2) break block22;
                        var16_7 = var17_5 /* !! */ ;
                        for (var10_3 = this.size(); var10_3 > var2_2; var10_3 -= (long)(var16_7.limit - var16_7.pos)) {
                            var16_7 = var16_7.prev;
                            Intrinsics.checkNotNull((Object)var16_7);
                        }
                        if (var16_7 != null) break block23;
                        var2_2 = var14_6;
                        break block19;
                    }
                    if (var1_1 /* !! */ .size() == 2) {
                        var6_8 = var1_1 /* !! */ .getByte(0);
                        var7_12 = var1_1 /* !! */ .getByte(1);
                        var12_16 = var2_2;
                        block1: while (true) {
                            var2_2 = var14_6;
                            if (var10_3 >= this.size()) return var2_2;
                            var17_5 /* !! */  = (Segment)var16_7.data;
                            var5_19 = (int)((long)var16_7.pos + var12_16 - var10_3);
                            var8_20 = var16_7.limit;
                            while (var5_19 < var8_20) {
                                var9_24 = var17_5 /* !! */ [var5_19];
                                var2_2 = var10_3;
                                var1_1 /* !! */  = var16_7;
                                var4_4 = var5_19++;
                                if (var9_24 == var6_8) break block1;
                                if (var9_24 != var7_12) continue;
                                var2_2 = var10_3;
                                var1_1 /* !! */  = var16_7;
                                var4_4 = var5_19;
                                break block1;
                            }
                            var16_7 = var16_7.next;
                            Intrinsics.checkNotNull((Object)var16_7);
                            var12_16 = var10_3 += (long)(var16_7.limit - var16_7.pos);
                        }
lbl50:
                        // 4 sources

                        while (true) {
                            var5_19 = var1_1 /* !! */ .pos;
lbl52:
                            // 2 sources

                            while (true) {
                                var2_2 = (long)(var4_4 - var5_19) + var2_2;
                                break block19;
                                break;
                            }
                            break;
                        }
                    }
                    var1_1 /* !! */  = (ByteString)var1_1 /* !! */ .internalArray$okio();
                    var12_17 = var2_2;
                    block5: while (true) {
                        var2_2 = var14_6;
                        if (var10_3 >= this.size()) return var2_2;
                        var17_5 /* !! */  = (Segment)var16_7.data;
                        var6_9 = var16_7.limit;
                        for (var4_4 = (int)((long)var16_7.pos + var12_17 - var10_3); var4_4 < var6_9; ++var4_4) {
                            var7_13 = var17_5 /* !! */ [var4_4];
                            for (ByteString var9_25 : var1_1 /* !! */ ) {
                                if (var7_13 != var9_25) continue;
                                break block5;
                            }
                        }
                        var16_7 = var16_7.next;
                        Intrinsics.checkNotNull((Object)var16_7);
                        var12_17 = var10_3 += (long)(var16_7.limit - var16_7.pos);
                    }
lbl72:
                    // 2 sources

                    while (true) {
                        var5_19 = var16_7.pos;
                        var2_2 = var10_3;
                        ** continue;
                        break;
                    }
                }
                while (true) {
                    if ((var12_18 = (long)(var16_7.limit - var16_7.pos) + var10_3) > var2_2) {
                        if (var16_7 == null) {
                            var2_2 = var14_6;
                            break block19;
                        }
                        if (var1_1 /* !! */ .size() == 2) break;
                        break block20;
                    }
                    var16_7 = var16_7.next;
                    Intrinsics.checkNotNull((Object)var16_7);
                    var10_3 = var12_18;
                }
                var7_14 = var1_1 /* !! */ .getByte(0);
                var8_22 = var1_1 /* !! */ .getByte(1);
                var12_18 = var2_2;
                while (true) {
                    var2_2 = var14_6;
                    if (var10_3 >= this.size()) return var2_2;
                    var17_5 /* !! */  = (Segment)var16_7.data;
                    var5_19 = (int)((long)var16_7.pos + var12_18 - var10_3);
                    var6_10 = var16_7.limit;
                    while (var5_19 < var6_10) {
                        var9_26 = var17_5 /* !! */ [var5_19];
                        var2_2 = var10_3;
                        var1_1 /* !! */  = var16_7;
                        var4_4 = var5_19++;
                        if (var9_26 == var7_14) ** GOTO lbl50
                        if (var9_26 != var8_22) continue;
                        var2_2 = var10_3;
                        var1_1 /* !! */  = var16_7;
                        var4_4 = var5_19;
                        ** continue;
lbl108:
                        // 1 sources

                        ** GOTO lbl50
                    }
                    var16_7 = var16_7.next;
                    Intrinsics.checkNotNull((Object)var16_7);
                    var12_18 = var10_3 += (long)(var16_7.limit - var16_7.pos);
                }
            }
            var1_1 /* !! */  = (ByteString)var1_1 /* !! */ .internalArray$okio();
            var12_18 = var2_2;
            while (true) {
                var2_2 = var14_6;
                if (var10_3 >= this.size()) return var2_2;
                var17_5 /* !! */  = (Segment)var16_7.data;
                var6_11 = var16_7.limit;
                for (var4_4 = (int)((long)var16_7.pos + var12_18 - var10_3); var4_4 < var6_11; ++var4_4) {
                    var8_23 = var17_5 /* !! */ [var4_4];
                    for (ByteString var9_27 : var1_1 /* !! */ ) {
                        if (var8_23 != var9_27) continue;
                        ** continue;
lbl126:
                        // 1 sources

                        ** GOTO lbl72
                    }
                }
                var16_7 = var16_7.next;
                Intrinsics.checkNotNull((Object)var16_7);
                var12_18 = var10_3 += (long)(var16_7.limit - var16_7.pos);
            }
        }
        return var2_2;
    }

    public InputStream inputStream() {
        return (InputStream)new /* Unavailable Anonymous Inner Class!! */;
    }

    @Override
    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return this.digest("MD5");
    }

    public OutputStream outputStream() {
        return (OutputStream)new /* Unavailable Anonymous Inner Class!! */;
    }

    public BufferedSource peek() {
        return Okio.buffer((Source)((Source)new PeekSource((BufferedSource)this)));
    }

    public boolean rangeEquals(long l, ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"bytes");
        return this.rangeEquals(l, byteString, 0, byteString.size());
    }

    public boolean rangeEquals(long l, ByteString byteString, int n, int n2) {
        boolean bl;
        block5: {
            boolean bl2;
            Intrinsics.checkNotNullParameter((Object)byteString, (String)"bytes");
            bl = bl2 = false;
            if (l < 0L) return bl;
            bl = bl2;
            if (n < 0) return bl;
            bl = bl2;
            if (n2 < 0) return bl;
            bl = bl2;
            if (this.size() - l < (long)n2) return bl;
            if (byteString.size() - n < n2) {
                bl = bl2;
            } else {
                if (n2 > 0) {
                    int n3 = 0;
                    while (true) {
                        int n4 = n3 + 1;
                        if (this.getByte((long)n3 + l) != byteString.getByte(n3 + n)) {
                            bl = bl2;
                            break block5;
                        }
                        if (n4 >= n2) break;
                        n3 = n4;
                    }
                }
                bl = true;
            }
        }
        return bl;
    }

    @Override
    public int read(ByteBuffer byteBuffer) throws IOException {
        Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"sink");
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int n = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, n);
        segment.pos += n;
        this.size -= (long)n;
        if (segment.pos != segment.limit) return n;
        this.head = segment.pop();
        SegmentPool.recycle((Segment)segment);
        return n;
    }

    public int read(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"sink");
        return this.read(byArray, 0, byArray.length);
    }

    public int read(byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"sink");
        _UtilKt.checkOffsetAndCount((long)byArray.length, (long)n, (long)n2);
        Segment segment = this.head;
        if (segment == null) {
            n = -1;
        } else {
            n2 = Math.min(n2, segment.limit - segment.pos);
            ArraysKt.copyInto((byte[])segment.data, (byte[])byArray, (int)n, (int)segment.pos, (int)(segment.pos + n2));
            segment.pos += n2;
            this.setSize$okio(this.size() - (long)n2);
            if (segment.pos == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle((Segment)segment);
            }
            n = n2;
        }
        return n;
    }

    public long read(Buffer buffer, long l) {
        long l2;
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"sink");
        boolean bl = l >= 0L;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount < 0: ", (Object)l).toString());
        if (this.size() == 0L) {
            l2 = -1L;
        } else {
            l2 = l;
            if (l > this.size()) {
                l2 = this.size();
            }
            buffer.write(this, l2);
        }
        return l2;
    }

    public long readAll(Sink sink) throws IOException {
        Intrinsics.checkNotNullParameter((Object)sink, (String)"sink");
        long l = this.size();
        if (l <= 0L) return l;
        sink.write(this, l);
        return l;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return Buffer.readAndWriteUnsafe$default(this, null, 1, null);
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter((Object)unsafeCursor, (String)"unsafeCursor");
        return _BufferKt.commonReadAndWriteUnsafe((Buffer)this, (UnsafeCursor)unsafeCursor);
    }

    public byte readByte() throws EOFException {
        if (this.size() == 0L) throw new EOFException();
        Segment segment = this.head;
        Intrinsics.checkNotNull((Object)segment);
        int n = segment.pos;
        int n2 = segment.limit;
        byte[] byArray = segment.data;
        int n3 = n + 1;
        byte by = byArray[n];
        this.setSize$okio(this.size() - 1L);
        if (n3 == n2) {
            this.head = segment.pop();
            SegmentPool.recycle((Segment)segment);
        } else {
            segment.pos = n3;
        }
        return by;
    }

    public byte[] readByteArray() {
        return this.readByteArray(this.size());
    }

    public byte[] readByteArray(long l) throws EOFException {
        boolean bl = l >= 0L && l <= Integer.MAX_VALUE;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount: ", (Object)l).toString());
        if (this.size() < l) throw new EOFException();
        byte[] byArray = new byte[(int)l];
        this.readFully(byArray);
        return byArray;
    }

    public ByteString readByteString() {
        return this.readByteString(this.size());
    }

    public ByteString readByteString(long l) throws EOFException {
        ByteString byteString;
        boolean bl = l >= 0L && l <= Integer.MAX_VALUE;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount: ", (Object)l).toString());
        if (this.size() < l) throw new EOFException();
        if (l >= 4096L) {
            byteString = this.snapshot((int)l);
            this.skip(l);
        } else {
            byteString = new ByteString(this.readByteArray(l));
        }
        return byteString;
    }

    public long readDecimalLong() throws EOFException {
        int n;
        Object object;
        boolean bl;
        long l;
        block9: {
            Object object2;
            if (this.size() == 0L) {
                EOFException eOFException = new EOFException();
                throw eOFException;
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
                    object = this.head;
                    Intrinsics.checkNotNull((Object)object);
                    object2 = ((Segment)object).data;
                    n5 = ((Segment)object).pos;
                    n4 = ((Segment)object).limit;
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
                    this.head = object.pop();
                    SegmentPool.recycle((Segment)object);
                } else {
                    ((Segment)object).pos = n5;
                }
                if (n != 0 || this.head == null) break;
                n3 = n;
            }
            this.setSize$okio(this.size() - (long)n2);
            n3 = bl ? 2 : 1;
            if (n2 < n3) {
                if (this.size() == 0L) throw new EOFException();
                object = bl ? "Expected a digit" : "Expected a digit or '-'";
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(" but was 0x");
                ((StringBuilder)object2).append(_UtilKt.toHexString((byte)this.getByte(0L)));
                throw new NumberFormatException(((StringBuilder)object2).toString());
            }
            if (bl) return l;
            l = -l;
            return l;
        }
        object = new Buffer().writeDecimalLong(l).writeByte(n);
        if (bl) throw new NumberFormatException(Intrinsics.stringPlus((String)"Number too large: ", (Object)((Buffer)object).readUtf8()));
        ((Buffer)object).readByte();
        throw new NumberFormatException(Intrinsics.stringPlus((String)"Number too large: ", (Object)((Buffer)object).readUtf8()));
    }

    public final Buffer readFrom(InputStream inputStream2) throws IOException {
        Intrinsics.checkNotNullParameter((Object)inputStream2, (String)"input");
        this.readFrom(inputStream2, Long.MAX_VALUE, true);
        return this;
    }

    public final Buffer readFrom(InputStream inputStream2, long l) throws IOException {
        Intrinsics.checkNotNullParameter((Object)inputStream2, (String)"input");
        boolean bl = l >= 0L;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount < 0: ", (Object)l).toString());
        this.readFrom(inputStream2, l, false);
        return this;
    }

    public void readFully(Buffer buffer, long l) throws EOFException {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"sink");
        if (this.size() >= l) {
            buffer.write(this, l);
            return;
        }
        buffer.write(this, this.size());
        throw new EOFException();
    }

    public void readFully(byte[] byArray) throws EOFException {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"sink");
        int n = 0;
        while (n < byArray.length) {
            int n2 = this.read(byArray, n, byArray.length - n);
            if (n2 == -1) throw new EOFException();
            n += n2;
        }
    }

    public long readHexadecimalUnsignedLong() throws EOFException {
        int n;
        long l;
        if (this.size() == 0L) {
            EOFException eOFException = new EOFException();
            throw eOFException;
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
                segment = this.head;
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
                    if ((0xF000000000000000L & l) != 0L) throw new NumberFormatException(Intrinsics.stringPlus((String)"Number too large: ", (Object)new Buffer().writeHexadecimalUnsignedLong(l).writeByte(by).readUtf8()));
                    l = l << 4 | (long)n2;
                    ++n4;
                    ++n;
                }
                if (n == 0) throw new NumberFormatException(Intrinsics.stringPlus((String)"Expected leading [0-9a-fA-F] character but was 0x", (Object)_UtilKt.toHexString((byte)by)));
                bl2 = true;
            }
            if (n4 == n3) {
                this.head = segment.pop();
                SegmentPool.recycle((Segment)segment);
            } else {
                segment.pos = n4;
            }
            if (bl2) break;
            n2 = n;
            bl = bl2;
            l2 = l;
        } while (this.head != null);
        this.setSize$okio(this.size() - (long)n);
        return l;
    }

    public int readInt() throws EOFException {
        if (this.size() < 4L) throw new EOFException();
        Segment segment = this.head;
        Intrinsics.checkNotNull((Object)segment);
        int n = segment.pos;
        int n2 = segment.limit;
        if ((long)(n2 - n) < 4L) {
            n2 = (this.readByte() & 0xFF) << 24 | (this.readByte() & 0xFF) << 16 | (this.readByte() & 0xFF) << 8 | this.readByte() & 0xFF;
        } else {
            byte[] byArray = segment.data;
            int n3 = n + 1;
            n = byArray[n];
            int n4 = n3 + 1;
            n3 = byArray[n3];
            int n5 = n4 + 1;
            n4 = byArray[n4];
            int n6 = n5 + 1;
            n5 = byArray[n5];
            this.setSize$okio(this.size() - 4L);
            if (n6 == n2) {
                this.head = segment.pop();
                SegmentPool.recycle((Segment)segment);
            } else {
                segment.pos = n6;
            }
            n2 = (n & 0xFF) << 24 | (n3 & 0xFF) << 16 | (n4 & 0xFF) << 8 | n5 & 0xFF;
        }
        return n2;
    }

    public int readIntLe() throws EOFException {
        return _UtilKt.reverseBytes((int)this.readInt());
    }

    public long readLong() throws EOFException {
        long l;
        if (this.size() < 8L) throw new EOFException();
        Segment segment = this.head;
        Intrinsics.checkNotNull((Object)segment);
        int n = segment.pos;
        int n2 = segment.limit;
        if ((long)(n2 - n) < 8L) {
            l = ((long)this.readInt() & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL & (long)this.readInt();
        } else {
            byte[] byArray = segment.data;
            int n3 = n + 1;
            long l2 = byArray[n];
            n = n3 + 1;
            long l3 = byArray[n3];
            n3 = n + 1;
            long l4 = byArray[n];
            n = n3 + 1;
            l = byArray[n3];
            n3 = n + 1;
            long l5 = byArray[n];
            n = n3 + 1;
            long l6 = byArray[n3];
            n3 = n + 1;
            long l7 = byArray[n];
            n = n3 + 1;
            long l8 = byArray[n3];
            this.setSize$okio(this.size() - 8L);
            if (n == n2) {
                this.head = segment.pop();
                SegmentPool.recycle((Segment)segment);
            } else {
                segment.pos = n;
            }
            l = (l & 0xFFL) << 32 | ((l2 & 0xFFL) << 56 | (l3 & 0xFFL) << 48 | (l4 & 0xFFL) << 40) | (l5 & 0xFFL) << 24 | (l6 & 0xFFL) << 16 | (l7 & 0xFFL) << 8 | l8 & 0xFFL;
        }
        return l;
    }

    public long readLongLe() throws EOFException {
        return _UtilKt.reverseBytes((long)this.readLong());
    }

    public short readShort() throws EOFException {
        short s;
        if (this.size() < 2L) throw new EOFException();
        Segment segment = this.head;
        Intrinsics.checkNotNull((Object)segment);
        int n = segment.pos;
        int n2 = segment.limit;
        if (n2 - n < 2) {
            s = (short)((this.readByte() & 0xFF) << 8 | this.readByte() & 0xFF);
        } else {
            byte[] byArray = segment.data;
            int n3 = n + 1;
            n = byArray[n];
            int n4 = n3 + 1;
            n3 = byArray[n3];
            this.setSize$okio(this.size() - 2L);
            if (n4 == n2) {
                this.head = segment.pop();
                SegmentPool.recycle((Segment)segment);
            } else {
                segment.pos = n4;
            }
            s = (short)((n & 0xFF) << 8 | n3 & 0xFF);
        }
        return s;
    }

    public short readShortLe() throws EOFException {
        return _UtilKt.reverseBytes((short)this.readShort());
    }

    public String readString(long l, Charset object) throws EOFException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"charset");
        int n = l >= 0L && l <= Integer.MAX_VALUE ? 1 : 0;
        if (n == 0) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount: ", (Object)l).toString());
        if (this.size < l) throw new EOFException();
        if (l == 0L) {
            return "";
        }
        Segment segment = this.head;
        Intrinsics.checkNotNull((Object)segment);
        if ((long)segment.pos + l > (long)segment.limit) {
            return new String(this.readByteArray(l), (Charset)object);
        }
        byte[] byArray = segment.data;
        n = segment.pos;
        int n2 = (int)l;
        object = new String(byArray, n, n2, (Charset)object);
        segment.pos += n2;
        this.size -= l;
        if (segment.pos != segment.limit) return object;
        this.head = segment.pop();
        SegmentPool.recycle((Segment)segment);
        return object;
    }

    public String readString(Charset charset) {
        Intrinsics.checkNotNullParameter((Object)charset, (String)"charset");
        return this.readString(this.size, charset);
    }

    public final UnsafeCursor readUnsafe() {
        return Buffer.readUnsafe$default(this, null, 1, null);
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter((Object)unsafeCursor, (String)"unsafeCursor");
        return _BufferKt.commonReadUnsafe((Buffer)this, (UnsafeCursor)unsafeCursor);
    }

    public String readUtf8() {
        return this.readString(this.size, Charsets.UTF_8);
    }

    public String readUtf8(long l) throws EOFException {
        return this.readString(l, Charsets.UTF_8);
    }

    public int readUtf8CodePoint() throws EOFException {
        int n;
        block15: {
            int n2;
            long l;
            int n3;
            int n4;
            int n5;
            block8: {
                long l2;
                int n6;
                block14: {
                    block13: {
                        byte by;
                        block10: {
                            block12: {
                                block11: {
                                    block9: {
                                        if (this.size() == 0L) {
                                            EOFException eOFException = new EOFException();
                                            throw eOFException;
                                        }
                                        by = this.getByte(0L);
                                        n5 = 0;
                                        n4 = 65533;
                                        if ((by & 0x80) != 0) break block9;
                                        n = by & 0x7F;
                                        n6 = 1;
                                        n3 = 0;
                                        break block10;
                                    }
                                    if ((by & 0xE0) != 192) break block11;
                                    n = by & 0x1F;
                                    n6 = 2;
                                    n3 = 128;
                                    break block10;
                                }
                                if ((by & 0xF0) != 224) break block12;
                                n = by & 0xF;
                                n6 = 3;
                                n3 = 2048;
                                break block10;
                            }
                            if ((by & 0xF8) != 240) break block13;
                            n = by & 7;
                            n6 = 4;
                            n3 = 65536;
                        }
                        l2 = this.size();
                        l = n6;
                        if (l2 < l) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("size < ");
                            stringBuilder.append(n6);
                            stringBuilder.append(": ");
                            stringBuilder.append(this.size());
                            stringBuilder.append(" (to read code point prefixed 0x");
                            stringBuilder.append(_UtilKt.toHexString((byte)by));
                            stringBuilder.append(')');
                            throw new EOFException(stringBuilder.toString());
                        }
                        n2 = n;
                        if (1 >= n6) break block8;
                        break block14;
                    }
                    this.skip(1L);
                    n = n4;
                    break block15;
                }
                n2 = 1;
                while (true) {
                    int n7 = n2 + 1;
                    l2 = n2;
                    if (((n2 = (int)this.getByte(l2)) & 0xC0) != 128) break;
                    n = n << 6 | n2 & 0x3F;
                    if (n7 >= n6) {
                        n2 = n;
                        break block8;
                    }
                    n2 = n7;
                }
                this.skip(l2);
                n = n4;
                break block15;
            }
            this.skip(l);
            if (n2 > 0x10FFFF) {
                n = n4;
            } else {
                n = n5;
                if (55296 <= n2) {
                    n = n5;
                    if (n2 <= 57343) {
                        n = 1;
                    }
                }
                n = n != 0 ? n4 : (n2 < n3 ? n4 : n2);
            }
        }
        return n;
    }

    public String readUtf8Line() throws EOFException {
        long l = this.indexOf((byte)10);
        String string = l != -1L ? _BufferKt.readUtf8Line((Buffer)this, (long)l) : (this.size() != 0L ? this.readUtf8(this.size()) : null);
        return string;
    }

    public String readUtf8LineStrict() throws EOFException {
        return this.readUtf8LineStrict(Long.MAX_VALUE);
    }

    public String readUtf8LineStrict(long l) throws EOFException {
        long l2;
        block6: {
            String string;
            block5: {
                byte by;
                block4: {
                    boolean bl = l >= 0L;
                    if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"limit < 0: ", (Object)l).toString());
                    l2 = Long.MAX_VALUE;
                    if (l != Long.MAX_VALUE) {
                        l2 = l + 1L;
                    }
                    by = (byte)10;
                    long l3 = this.indexOf(by, 0L, l2);
                    if (l3 == -1L) break block4;
                    string = _BufferKt.readUtf8Line((Buffer)this, (long)l3);
                    break block5;
                }
                if (l2 >= this.size() || this.getByte(l2 - 1L) != (byte)13 || this.getByte(l2) != by) break block6;
                string = _BufferKt.readUtf8Line((Buffer)this, (long)l2);
            }
            return string;
        }
        Buffer buffer = new Buffer();
        l2 = this.size();
        this.copyTo(buffer, 0L, Math.min((long)32, l2));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\\n not found: limit=");
        stringBuilder.append(Math.min(this.size(), l));
        stringBuilder.append(" content=");
        stringBuilder.append(buffer.readByteString().hex());
        stringBuilder.append('\u2026');
        throw new EOFException(stringBuilder.toString());
    }

    public boolean request(long l) {
        boolean bl = this.size >= l;
        return bl;
    }

    public void require(long l) throws EOFException {
        if (this.size < l) throw new EOFException();
    }

    public int select(Options options) {
        Intrinsics.checkNotNullParameter((Object)options, (String)"options");
        int n = _BufferKt.selectPrefix$default((Buffer)this, (Options)options, (boolean)false, (int)2, null);
        if (n == -1) {
            n = -1;
        } else {
            this.skip(options.getByteStrings$okio()[n].size());
        }
        return n;
    }

    public final void setSize$okio(long l) {
        this.size = l;
    }

    public final ByteString sha1() {
        return this.digest("SHA-1");
    }

    public final ByteString sha256() {
        return this.digest("SHA-256");
    }

    public final ByteString sha512() {
        return this.digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    public void skip(long l) throws EOFException {
        while (l > 0L) {
            Segment segment = this.head;
            if (segment == null) throw new EOFException();
            int n = (int)Math.min(l, (long)(segment.limit - segment.pos));
            long l2 = this.size();
            long l3 = n;
            this.setSize$okio(l2 - l3);
            l2 = l - l3;
            segment.pos += n;
            l = l2;
            if (segment.pos != segment.limit) continue;
            this.head = segment.pop();
            SegmentPool.recycle((Segment)segment);
            l = l2;
        }
    }

    public final ByteString snapshot() {
        boolean bl = this.size() <= Integer.MAX_VALUE;
        if (!bl) throw (Throwable)new IllegalStateException(Intrinsics.stringPlus((String)"size > Int.MAX_VALUE: ", (Object)this.size()).toString());
        return this.snapshot((int)this.size());
    }

    public final ByteString snapshot(int n) {
        ByteString byteString;
        if (n == 0) {
            byteString = ByteString.EMPTY;
        } else {
            int n2;
            _UtilKt.checkOffsetAndCount((long)this.size(), (long)0L, (long)n);
            byteString = this.head;
            int n3 = 0;
            int n4 = 0;
            for (n2 = 0; n2 < n; n2 += byteString.limit - byteString.pos, ++n4) {
                Intrinsics.checkNotNull((Object)byteString);
                if (byteString.limit == byteString.pos) throw new AssertionError((Object)"s.limit == s.pos");
                byteString = byteString.next;
            }
            byte[][] byArrayArray = new byte[n4][];
            int[] nArray = new int[n4 * 2];
            byteString = this.head;
            n4 = 0;
            n2 = n3;
            while (n2 < n) {
                Intrinsics.checkNotNull((Object)byteString);
                byArrayArray[n4] = byteString.data;
                nArray[n4] = Math.min(n2 += byteString.limit - byteString.pos, n);
                nArray[((Object[])byArrayArray).length + n4] = byteString.pos;
                byteString.shared = true;
                ++n4;
                byteString = byteString.next;
            }
            byteString = (ByteString)new SegmentedByteString((byte[][])byArrayArray, nArray);
        }
        return byteString;
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return this.snapshot().toString();
    }

    public final Segment writableSegment$okio(int n) {
        boolean bl = true;
        if (n < 1 || n > 8192) {
            bl = false;
        }
        if (!bl) throw (Throwable)new IllegalArgumentException("unexpected capacity".toString());
        Segment segment = this.head;
        if (segment == null) {
            this.head = segment = SegmentPool.take();
            segment.prev = segment;
            segment.next = segment;
        } else {
            Intrinsics.checkNotNull((Object)segment);
            segment = segment.prev;
            Intrinsics.checkNotNull((Object)segment);
            if (segment.limit + n <= 8192) {
                if (segment.owner) return segment;
            }
            segment = segment.push(SegmentPool.take());
        }
        return segment;
    }

    @Override
    public int write(ByteBuffer byteBuffer) throws IOException {
        int n;
        Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"source");
        int n2 = n = byteBuffer.remaining();
        while (true) {
            if (n2 <= 0) {
                this.size += (long)n;
                return n;
            }
            Segment segment = this.writableSegment$okio(1);
            int n3 = Math.min(n2, 8192 - segment.limit);
            byteBuffer.get(segment.data, segment.limit, n3);
            n2 -= n3;
            segment.limit += n3;
        }
    }

    public Buffer write(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    public Buffer write(ByteString byteString, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"byteString");
        byteString.write$okio(this, n, n2);
        return this;
    }

    public Buffer write(Source source, long l) throws IOException {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        while (l > 0L) {
            long l2 = source.read(this, l);
            if (l2 == -1L) throw new EOFException();
            l -= l2;
        }
        return this;
    }

    public Buffer write(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"source");
        return this.write(byArray, 0, byArray.length);
    }

    public Buffer write(byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"source");
        long l = byArray.length;
        long l2 = n;
        long l3 = n2;
        _UtilKt.checkOffsetAndCount((long)l, (long)l2, (long)l3);
        int n3 = n2 + n;
        while (true) {
            if (n >= n3) {
                this.setSize$okio(this.size() + l3);
                return this;
            }
            Segment segment = this.writableSegment$okio(1);
            int n4 = Math.min(n3 - n, 8192 - segment.limit);
            byte[] byArray2 = segment.data;
            int n5 = segment.limit;
            n2 = n + n4;
            ArraysKt.copyInto((byte[])byArray, (byte[])byArray2, (int)n5, (int)n, (int)n2);
            segment.limit += n4;
            n = n2;
        }
    }

    public void write(Buffer object, long l) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"source");
        int n = object != this ? 1 : 0;
        if (n == 0) {
            object = new IllegalArgumentException("source == this".toString());
            throw object;
        }
        _UtilKt.checkOffsetAndCount((long)((Buffer)object).size(), (long)0L, (long)l);
        while (l > 0L) {
            Segment segment;
            long l2;
            Segment segment2 = ((Buffer)object).head;
            Intrinsics.checkNotNull((Object)segment2);
            n = segment2.limit;
            segment2 = ((Buffer)object).head;
            Intrinsics.checkNotNull((Object)segment2);
            if (l < (long)(n - segment2.pos)) {
                segment2 = this.head;
                if (segment2 != null) {
                    Intrinsics.checkNotNull((Object)segment2);
                    segment2 = segment2.prev;
                } else {
                    segment2 = null;
                }
                if (segment2 != null && segment2.owner && (l2 = (long)segment2.limit) + l - (long)(n = segment2.shared ? 0 : segment2.pos) <= 8192L) {
                    segment = ((Buffer)object).head;
                    Intrinsics.checkNotNull((Object)segment);
                    segment.writeTo(segment2, (int)l);
                    ((Buffer)object).setSize$okio(((Buffer)object).size() - l);
                    this.setSize$okio(this.size() + l);
                    return;
                }
                segment2 = ((Buffer)object).head;
                Intrinsics.checkNotNull((Object)segment2);
                ((Buffer)object).head = segment2.split((int)l);
            }
            segment2 = ((Buffer)object).head;
            Intrinsics.checkNotNull((Object)segment2);
            l2 = segment2.limit - segment2.pos;
            ((Buffer)object).head = segment2.pop();
            segment = this.head;
            if (segment == null) {
                this.head = segment2;
                segment2.next = segment2.prev = segment2;
            } else {
                Intrinsics.checkNotNull((Object)segment);
                segment = segment.prev;
                Intrinsics.checkNotNull((Object)segment);
                segment.push(segment2).compact();
            }
            ((Buffer)object).setSize$okio(((Buffer)object).size() - l2);
            this.setSize$okio(this.size() + l2);
            l -= l2;
        }
    }

    public long writeAll(Source source) throws IOException {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        long l = 0L;
        long l2;
        while ((l2 = source.read(this, 8192L)) != -1L) {
            l += l2;
        }
        return l;
    }

    public Buffer writeByte(int n) {
        Segment segment = this.writableSegment$okio(1);
        byte[] byArray = segment.data;
        int n2 = segment.limit;
        segment.limit = n2 + 1;
        byArray[n2] = (byte)n;
        this.setSize$okio(this.size() + 1L);
        return this;
    }

    /*
     * Enabled force condition propagation
     */
    public Buffer writeDecimalLong(long l) {
        if (l == 0L) {
            return this.writeByte(48);
        }
        boolean bl = false;
        int n = 1;
        long l2 = l;
        if (l < 0L) {
            l2 = -l;
            if (l2 < 0L) {
                return this.writeUtf8("-9223372036854775808");
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
        Buffer buffer = this.writableSegment$okio(n2);
        byte[] byArray = ((Segment)buffer).data;
        n = ((Segment)buffer).limit + n2;
        while (l2 != 0L) {
            l = 10;
            int n3 = (int)(l2 % l);
            byArray[--n] = _BufferKt.getHEX_DIGIT_BYTES()[n3];
            l2 /= l;
        }
        if (bl) {
            byArray[n - 1] = (byte)45;
        }
        ((Segment)buffer).limit += n2;
        this.setSize$okio(this.size() + (long)n2);
        return this;
    }

    public Buffer writeHexadecimalUnsignedLong(long l) {
        Buffer buffer;
        if (l == 0L) {
            buffer = this.writeByte(48);
        } else {
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
            buffer = this.writableSegment$okio(n);
            byte[] byArray = ((Segment)buffer).data;
            int n2 = ((Segment)buffer).limit;
            for (int i = ((Segment)buffer).limit + n - 1; i >= n2; l >>>= 4, --i) {
                byArray[i] = _BufferKt.getHEX_DIGIT_BYTES()[(int)(0xFL & l)];
            }
            ((Segment)buffer).limit += n;
            this.setSize$okio(this.size() + (long)n);
            buffer = this;
        }
        return buffer;
    }

    public Buffer writeInt(int n) {
        Segment segment = this.writableSegment$okio(4);
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
        this.setSize$okio(this.size() + 4L);
        return this;
    }

    public Buffer writeIntLe(int n) {
        return this.writeInt(_UtilKt.reverseBytes((int)n));
    }

    public Buffer writeLong(long l) {
        Segment segment = this.writableSegment$okio(8);
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
        this.setSize$okio(this.size() + 8L);
        return this;
    }

    public Buffer writeLongLe(long l) {
        return this.writeLong(_UtilKt.reverseBytes((long)l));
    }

    public Buffer writeShort(int n) {
        Segment segment = this.writableSegment$okio(2);
        byte[] byArray = segment.data;
        int n2 = segment.limit;
        int n3 = n2 + 1;
        byArray[n2] = (byte)(n >>> 8 & 0xFF);
        byArray[n3] = (byte)(n & 0xFF);
        segment.limit = n3 + 1;
        this.setSize$okio(this.size() + 2L);
        return this;
    }

    public Buffer writeShortLe(int n) {
        return this.writeShort(_UtilKt.reverseBytes((short)((short)n)));
    }

    public Buffer writeString(String object, int n, int n2, Charset object2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"string");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"charset");
        boolean bl = true;
        boolean bl2 = n >= 0;
        if (!bl2) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"beginIndex < 0: ", (Object)n).toString());
        bl2 = n2 >= n;
        if (!bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("endIndex < beginIndex: ");
            ((StringBuilder)object).append(n2);
            ((StringBuilder)object).append(" < ");
            ((StringBuilder)object).append(n);
            throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString().toString());
        }
        bl2 = n2 <= ((String)object).length() ? bl : false;
        if (!bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("endIndex > string.length: ");
            ((StringBuilder)object2).append(n2);
            ((StringBuilder)object2).append(" > ");
            ((StringBuilder)object2).append(((String)object).length());
            throw (Throwable)new IllegalArgumentException(((StringBuilder)object2).toString().toString());
        }
        if (Intrinsics.areEqual((Object)object2, (Object)Charsets.UTF_8)) {
            return this.writeUtf8((String)object, n, n2);
        }
        object = ((String)object).substring(n, n2);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        if (object == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        object = ((String)object).getBytes((Charset)object2);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.String).getBytes(charset)");
        return this.write((byte[])object, 0, ((Object)object).length);
    }

    public Buffer writeString(String string, Charset charset) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"string");
        Intrinsics.checkNotNullParameter((Object)charset, (String)"charset");
        return this.writeString(string, 0, string.length(), charset);
    }

    public final Buffer writeTo(OutputStream outputStream2) throws IOException {
        Intrinsics.checkNotNullParameter((Object)outputStream2, (String)"out");
        return Buffer.writeTo$default(this, outputStream2, 0L, 2, null);
    }

    public final Buffer writeTo(OutputStream outputStream2, long l) throws IOException {
        Intrinsics.checkNotNullParameter((Object)outputStream2, (String)"out");
        _UtilKt.checkOffsetAndCount((long)this.size, (long)0L, (long)l);
        Segment segment = this.head;
        while (l > 0L) {
            Segment segment2;
            Intrinsics.checkNotNull((Object)segment);
            int n = (int)Math.min(l, (long)(segment.limit - segment.pos));
            outputStream2.write(segment.data, segment.pos, n);
            segment.pos += n;
            long l2 = this.size;
            long l3 = n;
            this.size = l2 - l3;
            l = l2 = l - l3;
            if (segment.pos != segment.limit) continue;
            this.head = segment2 = segment.pop();
            SegmentPool.recycle((Segment)segment);
            segment = segment2;
            l = l2;
        }
        return this;
    }

    public Buffer writeUtf8(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"string");
        return this.writeUtf8(string, 0, string.length());
    }

    public Buffer writeUtf8(String object, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"string");
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
        n3 = n2 <= ((String)object).length() ? 1 : 0;
        if (n3 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("endIndex > string.length: ");
            stringBuilder.append(n2);
            stringBuilder.append(" > ");
            stringBuilder.append(((String)object).length());
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString().toString());
        }
        while (n < n2) {
            int n4;
            int n5;
            Segment segment;
            char c = ((String)object).charAt(n);
            if (c < '\u0080') {
                segment = this.writableSegment$okio(1);
                byte[] byArray = segment.data;
                n5 = segment.limit - n;
                n4 = Math.min(n2, 8192 - n5);
                n3 = n + 1;
                byArray[n + n5] = (byte)c;
                n = n3;
            } else {
                if (c < '\u0800') {
                    segment = this.writableSegment$okio(2);
                    segment.data[segment.limit] = (byte)(c >> 6 | 0xC0);
                    segment.data[segment.limit + 1] = (byte)(c & 0x3F | 0x80);
                    segment.limit += 2;
                    this.setSize$okio(this.size() + 2L);
                } else {
                    if (c >= '\ud800' && c <= '\udfff') {
                        n5 = n + 1;
                        n3 = n5 < n2 ? ((String)object).charAt(n5) : 0;
                        if (c <= '\udbff' && (n4 = 56320 <= n3 && n3 <= 57343 ? 1 : 0) != 0) {
                            n3 = ((c & 0x3FF) << 10 | n3 & 0x3FF) + 65536;
                            segment = this.writableSegment$okio(4);
                            segment.data[segment.limit] = (byte)(n3 >> 18 | 0xF0);
                            segment.data[segment.limit + 1] = (byte)(n3 >> 12 & 0x3F | 0x80);
                            segment.data[segment.limit + 2] = (byte)(n3 >> 6 & 0x3F | 0x80);
                            segment.data[segment.limit + 3] = (byte)(n3 & 0x3F | 0x80);
                            segment.limit += 4;
                            this.setSize$okio(this.size() + 4L);
                            n += 2;
                            continue;
                        }
                        this.writeByte(63);
                        n = n5;
                        continue;
                    }
                    segment = this.writableSegment$okio(3);
                    segment.data[segment.limit] = (byte)(c >> 12 | 0xE0);
                    segment.data[segment.limit + 1] = (byte)(0x3F & c >> 6 | 0x80);
                    segment.data[segment.limit + 2] = (byte)(c & 0x3F | 0x80);
                    segment.limit += 3;
                    this.setSize$okio(this.size() + 3L);
                }
                ++n;
                continue;
            }
            while (n < n4 && (c = ((String)object).charAt(n)) < '\u0080') {
                n3 = n + 1;
                byArray[n + n5] = (byte)c;
                n = n3;
            }
            n3 = n5 + n - segment.limit;
            segment.limit += n3;
            this.setSize$okio(this.size() + (long)n3);
        }
        return this;
    }

    public Buffer writeUtf8CodePoint(int n) {
        if (n < 128) {
            this.writeByte(n);
        } else if (n < 2048) {
            Segment segment = this.writableSegment$okio(2);
            segment.data[segment.limit] = (byte)(n >> 6 | 0xC0);
            segment.data[segment.limit + 1] = (byte)(n & 0x3F | 0x80);
            segment.limit += 2;
            this.setSize$okio(this.size() + 2L);
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
                this.writeByte(63);
            } else if (n < 65536) {
                Segment segment = this.writableSegment$okio(3);
                segment.data[segment.limit] = (byte)(n >> 12 | 0xE0);
                segment.data[segment.limit + 1] = (byte)(n >> 6 & 0x3F | 0x80);
                segment.data[segment.limit + 2] = (byte)(n & 0x3F | 0x80);
                segment.limit += 3;
                this.setSize$okio(this.size() + 3L);
            } else {
                if (n > 0x10FFFF) throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Unexpected code point: 0x", (Object)_UtilKt.toHexString((int)n)));
                Segment segment = this.writableSegment$okio(4);
                segment.data[segment.limit] = (byte)(n >> 18 | 0xF0);
                segment.data[segment.limit + 1] = (byte)(n >> 12 & 0x3F | 0x80);
                segment.data[segment.limit + 2] = (byte)(n >> 6 & 0x3F | 0x80);
                segment.data[segment.limit + 3] = (byte)(n & 0x3F | 0x80);
                segment.limit += 4;
                this.setSize$okio(this.size() + 4L);
            }
        }
        return this;
    }
}
