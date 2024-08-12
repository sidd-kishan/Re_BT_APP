/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.IntProgression
 *  kotlin.ranges.RangesKt
 *  okhttp3.internal.Util
 *  okhttp3.internal.http2.ErrorCode
 *  okhttp3.internal.http2.Header
 *  okhttp3.internal.http2.Hpack$Reader
 *  okhttp3.internal.http2.Http2
 *  okhttp3.internal.http2.Http2Reader$Companion
 *  okhttp3.internal.http2.Http2Reader$ContinuationSource
 *  okhttp3.internal.http2.Http2Reader$Handler
 *  okhttp3.internal.http2.Settings
 *  okio.BufferedSource
 *  okio.ByteString
 *  okio.Source
 */
package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Header;
import okhttp3.internal.http2.Hpack;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.http2.Settings;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 #2\u00020\u0001:\u0003#$%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J(\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J.\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010 \u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010!\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\"\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2={"Lokhttp3/internal/http2/Http2Reader;", "Ljava/io/Closeable;", "source", "Lokio/BufferedSource;", "client", "", "(Lokio/BufferedSource;Z)V", "continuation", "Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "hpackReader", "Lokhttp3/internal/http2/Hpack$Reader;", "close", "", "nextFrame", "requireSettings", "handler", "Lokhttp3/internal/http2/Http2Reader$Handler;", "readConnectionPreface", "readData", "length", "", "flags", "streamId", "readGoAway", "readHeaderBlock", "", "Lokhttp3/internal/http2/Header;", "padding", "readHeaders", "readPing", "readPriority", "readPushPromise", "readRstStream", "readSettings", "readWindowUpdate", "Companion", "ContinuationSource", "Handler", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Http2Reader
implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger;
    private final boolean client;
    private final ContinuationSource continuation;
    private final Hpack.Reader hpackReader;
    private final BufferedSource source;

    static {
        Logger logger = Logger.getLogger(Http2.class.getName());
        Intrinsics.checkNotNullExpressionValue((Object)logger, (String)"getLogger(Http2::class.java.name)");
        Http2Reader.logger = logger;
    }

    public Http2Reader(BufferedSource bufferedSource, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"source");
        this.source = bufferedSource;
        this.client = bl;
        bufferedSource = new ContinuationSource(bufferedSource);
        this.continuation = bufferedSource;
        this.hpackReader = new Hpack.Reader((Source)bufferedSource, 4096, 0, 4, null);
    }

    public static final /* synthetic */ Logger access$getLogger$cp() {
        return logger;
    }

    private final void readData(Handler handler, int n, int n2, int n3) throws IOException {
        if (n3 == 0) throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        int n4 = 0;
        int n5 = 1;
        boolean bl = (n2 & 1) != 0;
        if ((n2 & 0x20) == 0) {
            n5 = 0;
        }
        if (n5 != 0) throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        n5 = n4;
        if ((n2 & 8) != 0) {
            n5 = Util.and((byte)this.source.readByte(), (int)255);
        }
        n = Companion.lengthWithoutPadding(n, n2, n5);
        handler.data(bl, n3, this.source, n);
        this.source.skip((long)n5);
    }

    private final void readGoAway(Handler handler, int n, int n2, int n3) throws IOException {
        if (n < 8) throw new IOException(Intrinsics.stringPlus((String)"TYPE_GOAWAY length < 8: ", (Object)n));
        if (n3 != 0) throw new IOException("TYPE_GOAWAY streamId != 0");
        n2 = this.source.readInt();
        n3 = this.source.readInt();
        ErrorCode errorCode = ErrorCode.Companion.fromHttp2(n3);
        if (errorCode == null) throw new IOException(Intrinsics.stringPlus((String)"TYPE_GOAWAY unexpected error code: ", (Object)n3));
        ByteString byteString = ByteString.EMPTY;
        if ((n -= 8) > 0) {
            byteString = this.source.readByteString((long)n);
        }
        handler.goAway(n2, errorCode, byteString);
    }

    private final List<Header> readHeaderBlock(int n, int n2, int n3, int n4) throws IOException {
        this.continuation.setLeft(n);
        ContinuationSource continuationSource = this.continuation;
        continuationSource.setLength(continuationSource.getLeft());
        this.continuation.setPadding(n2);
        this.continuation.setFlags(n3);
        this.continuation.setStreamId(n4);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readHeaders(Handler handler, int n, int n2, int n3) throws IOException {
        if (n3 == 0) throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        int n4 = 0;
        boolean bl = (n2 & 1) != 0;
        if ((n2 & 8) != 0) {
            n4 = Util.and((byte)this.source.readByte(), (int)255);
        }
        int n5 = n;
        if ((n2 & 0x20) != 0) {
            this.readPriority(handler, n3);
            n5 = n - 5;
        }
        handler.headers(bl, n3, -1, this.readHeaderBlock(Companion.lengthWithoutPadding(n5, n2, n4), n4, n2, n3));
    }

    private final void readPing(Handler handler, int n, int n2, int n3) throws IOException {
        if (n != 8) throw new IOException(Intrinsics.stringPlus((String)"TYPE_PING length != 8: ", (Object)n));
        if (n3 != 0) throw new IOException("TYPE_PING streamId != 0");
        n = this.source.readInt();
        n3 = this.source.readInt();
        boolean bl = true;
        if ((n2 & 1) == 0) {
            bl = false;
        }
        handler.ping(bl, n, n3);
    }

    private final void readPriority(Handler handler, int n) throws IOException {
        int n2 = this.source.readInt();
        boolean bl = (Integer.MIN_VALUE & n2) != 0;
        handler.priority(n, n2 & Integer.MAX_VALUE, Util.and((byte)this.source.readByte(), (int)255) + 1, bl);
    }

    private final void readPriority(Handler object, int n, int n2, int n3) throws IOException {
        if (n == 5) {
            if (n3 == 0) throw new IOException("TYPE_PRIORITY streamId == 0");
            this.readPriority((Handler)object, n3);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("TYPE_PRIORITY length: ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" != 5");
        throw new IOException(((StringBuilder)object).toString());
    }

    private final void readPushPromise(Handler handler, int n, int n2, int n3) throws IOException {
        if (n3 == 0) throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        int n4 = (n2 & 8) != 0 ? Util.and((byte)this.source.readByte(), (int)255) : 0;
        handler.pushPromise(n3, this.source.readInt() & Integer.MAX_VALUE, this.readHeaderBlock(Companion.lengthWithoutPadding(n - 4, n2, n4), n4, n2, n3));
    }

    private final void readRstStream(Handler object, int n, int n2, int n3) throws IOException {
        if (n == 4) {
            if (n3 == 0) throw new IOException("TYPE_RST_STREAM streamId == 0");
            n = this.source.readInt();
            ErrorCode errorCode = ErrorCode.Companion.fromHttp2(n);
            if (errorCode == null) throw new IOException(Intrinsics.stringPlus((String)"TYPE_RST_STREAM unexpected error code: ", (Object)n));
            object.rstStream(n3, errorCode);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("TYPE_RST_STREAM length: ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" != 4");
        throw new IOException(((StringBuilder)object).toString());
    }

    private final void readSettings(Handler object, int n, int n2, int n3) throws IOException {
        Settings settings;
        block17: {
            int n4;
            int n5;
            block16: {
                block15: {
                    if (n3 != 0) {
                        object = new IOException("TYPE_SETTINGS streamId != 0");
                        throw object;
                    }
                    if ((n2 & 1) != 0) {
                        if (n != 0) throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
                        object.ackSettings();
                        return;
                    }
                    if (n % 6 != 0) throw new IOException(Intrinsics.stringPlus((String)"TYPE_SETTINGS length % 6 != 0: ", (Object)n));
                    settings = new Settings();
                    IntProgression intProgression = RangesKt.step((IntProgression)((IntProgression)RangesKt.until((int)0, (int)n)), (int)6);
                    n = intProgression.getFirst();
                    n5 = intProgression.getLast();
                    n4 = intProgression.getStep();
                    if (n4 <= 0) break block15;
                    n2 = n;
                    if (n <= n5) break block16;
                }
                if (n4 >= 0 || n5 > n) break block17;
                n2 = n;
            }
            while (true) {
                n3 = Util.and((short)this.source.readShort(), (int)65535);
                int n6 = this.source.readInt();
                if (n3 != 2) {
                    if (n3 != 3) {
                        if (n3 != 4) {
                            if (n3 != 5) {
                                n = n3;
                            } else {
                                if (n6 < 16384) throw new IOException(Intrinsics.stringPlus((String)"PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", (Object)n6));
                                if (n6 > 0xFFFFFF) throw new IOException(Intrinsics.stringPlus((String)"PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", (Object)n6));
                                n = n3;
                            }
                        } else {
                            n = 7;
                            if (n6 < 0) throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        }
                    } else {
                        n = 4;
                    }
                } else {
                    n = n3;
                    if (n6 != 0) {
                        if (n6 != 1) throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                        n = n3;
                    }
                }
                settings.set(n, n6);
                if (n2 == n5) break;
                n2 += n4;
            }
        }
        object.settings(false, settings);
    }

    private final void readWindowUpdate(Handler handler, int n, int n2, int n3) throws IOException {
        if (n != 4) throw new IOException(Intrinsics.stringPlus((String)"TYPE_WINDOW_UPDATE length !=4: ", (Object)n));
        long l = Util.and((int)this.source.readInt(), (long)Integer.MAX_VALUE);
        if (l == 0L) throw new IOException("windowSizeIncrement was 0");
        handler.windowUpdate(n3, l);
    }

    @Override
    public void close() throws IOException {
        this.source.close();
    }

    public final boolean nextFrame(boolean bl, Handler handler) throws IOException {
        Intrinsics.checkNotNullParameter((Object)handler, (String)"handler");
        try {
            this.source.require(9L);
        }
        catch (EOFException eOFException) {
            return false;
        }
        int n = Util.readMedium((BufferedSource)this.source);
        if (n > 16384) throw new IOException(Intrinsics.stringPlus((String)"FRAME_SIZE_ERROR: ", (Object)n));
        int n2 = Util.and((byte)this.source.readByte(), (int)255);
        int n3 = Util.and((byte)this.source.readByte(), (int)255);
        int n4 = this.source.readInt() & Integer.MAX_VALUE;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Http2.INSTANCE.frameLog(true, n4, n, n2, n3));
        }
        if (bl) {
            if (n2 != 4) throw new IOException(Intrinsics.stringPlus((String)"Expected a SETTINGS frame but was ", (Object)Http2.INSTANCE.formattedType$okhttp(n2)));
        }
        switch (n2) {
            default: {
                this.source.skip((long)n);
                break;
            }
            case 8: {
                this.readWindowUpdate(handler, n, n3, n4);
                break;
            }
            case 7: {
                this.readGoAway(handler, n, n3, n4);
                break;
            }
            case 6: {
                this.readPing(handler, n, n3, n4);
                break;
            }
            case 5: {
                this.readPushPromise(handler, n, n3, n4);
                break;
            }
            case 4: {
                this.readSettings(handler, n, n3, n4);
                break;
            }
            case 3: {
                this.readRstStream(handler, n, n3, n4);
                break;
            }
            case 2: {
                this.readPriority(handler, n, n3, n4);
                break;
            }
            case 1: {
                this.readHeaders(handler, n, n3, n4);
                break;
            }
            case 0: {
                this.readData(handler, n, n3, n4);
            }
        }
        return true;
    }

    public final void readConnectionPreface(Handler handler) throws IOException {
        Intrinsics.checkNotNullParameter((Object)handler, (String)"handler");
        if (this.client) {
            if (!this.nextFrame(true, handler)) throw new IOException("Required SETTINGS preface not received");
        } else {
            handler = this.source.readByteString((long)Http2.CONNECTION_PREFACE.size());
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format((String)Intrinsics.stringPlus((String)"<< CONNECTION ", (Object)handler.hex()), (Object[])new Object[0]));
            }
            if (!Intrinsics.areEqual((Object)Http2.CONNECTION_PREFACE, (Object)handler)) throw new IOException(Intrinsics.stringPlus((String)"Expected a connection header but was ", (Object)handler.utf8()));
        }
    }
}
