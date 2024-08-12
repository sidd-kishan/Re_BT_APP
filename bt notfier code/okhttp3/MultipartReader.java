/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Headers
 *  okhttp3.MultipartReader$Companion
 *  okhttp3.MultipartReader$Part
 *  okhttp3.MultipartReader$PartSource
 *  okhttp3.ResponseBody
 *  okhttp3.internal.http1.HeadersReader
 *  okio.Buffer
 *  okio.BufferedSource
 *  okio.ByteString
 *  okio.Okio
 *  okio.Options
 *  okio.Source
 */
package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.MultipartReader;
import okhttp3.ResponseBody;
import okhttp3.internal.http1.HeadersReader;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.Source;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001c\u001d\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u0013\u0010\u0007\u001a\u00020\b8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0018\u00010\u0010R\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2={"Lokhttp3/MultipartReader;", "Ljava/io/Closeable;", "response", "Lokhttp3/ResponseBody;", "(Lokhttp3/ResponseBody;)V", "source", "Lokio/BufferedSource;", "boundary", "", "(Lokio/BufferedSource;Ljava/lang/String;)V", "()Ljava/lang/String;", "closed", "", "crlfDashDashBoundary", "Lokio/ByteString;", "currentPart", "Lokhttp3/MultipartReader$PartSource;", "dashDashBoundary", "noMoreParts", "partCount", "", "close", "", "currentPartBytesRemaining", "", "maxResult", "nextPart", "Lokhttp3/MultipartReader$Part;", "Companion", "Part", "PartSource", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class MultipartReader
implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Options afterBoundaryOptions = Options.Companion.of(new ByteString[]{ByteString.Companion.encodeUtf8("\r\n"), ByteString.Companion.encodeUtf8("--"), ByteString.Companion.encodeUtf8(" "), ByteString.Companion.encodeUtf8("\t")});
    private final String boundary;
    private boolean closed;
    private final ByteString crlfDashDashBoundary;
    private PartSource currentPart;
    private final ByteString dashDashBoundary;
    private boolean noMoreParts;
    private int partCount;
    private final BufferedSource source;

    public MultipartReader(ResponseBody object) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"response");
        BufferedSource bufferedSource = object.source();
        object = object.contentType();
        object = object == null ? null : object.parameter("boundary");
        if (object == null) throw new ProtocolException("expected the Content-Type to have a boundary parameter");
        this(bufferedSource, (String)object);
    }

    public MultipartReader(BufferedSource bufferedSource, String string) throws IOException {
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"source");
        Intrinsics.checkNotNullParameter((Object)string, (String)"boundary");
        this.source = bufferedSource;
        this.boundary = string;
        this.dashDashBoundary = new Buffer().writeUtf8("--").writeUtf8(this.boundary).readByteString();
        this.crlfDashDashBoundary = new Buffer().writeUtf8("\r\n--").writeUtf8(this.boundary).readByteString();
    }

    public static final /* synthetic */ long access$currentPartBytesRemaining(MultipartReader multipartReader, long l) {
        return multipartReader.currentPartBytesRemaining(l);
    }

    public static final /* synthetic */ Options access$getAfterBoundaryOptions$cp() {
        return afterBoundaryOptions;
    }

    public static final /* synthetic */ PartSource access$getCurrentPart$p(MultipartReader multipartReader) {
        return multipartReader.currentPart;
    }

    public static final /* synthetic */ BufferedSource access$getSource$p(MultipartReader multipartReader) {
        return multipartReader.source;
    }

    public static final /* synthetic */ void access$setCurrentPart$p(MultipartReader multipartReader, PartSource partSource) {
        multipartReader.currentPart = partSource;
    }

    private final long currentPartBytesRemaining(long l) {
        this.source.require((long)this.crlfDashDashBoundary.size());
        long l2 = this.source.getBuffer().indexOf(this.crlfDashDashBoundary);
        l = l2 == -1L ? Math.min(l, this.source.getBuffer().size() - (long)this.crlfDashDashBoundary.size() + 1L) : Math.min(l, l2);
        return l;
    }

    public final String boundary() {
        return this.boundary;
    }

    @Override
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.currentPart = null;
        this.source.close();
    }

    public final Part nextPart() throws IOException {
        int n;
        if (!(this.closed ^ true)) {
            Throwable throwable = new IllegalStateException("closed".toString());
            throw throwable;
        }
        if (this.noMoreParts) {
            return null;
        }
        if (this.partCount == 0 && this.source.rangeEquals(0L, this.dashDashBoundary)) {
            this.source.skip((long)this.dashDashBoundary.size());
        } else {
            while (true) {
                long l;
                if ((l = this.currentPartBytesRemaining(8192L)) == 0L) {
                    this.source.skip((long)this.crlfDashDashBoundary.size());
                    break;
                }
                this.source.skip(l);
            }
        }
        boolean bl = false;
        while ((n = this.source.select(afterBoundaryOptions)) != -1) {
            if (n == 0) {
                PartSource partSource;
                ++this.partCount;
                Headers headers = new HeadersReader(this.source).readHeaders();
                this.currentPart = partSource = new PartSource(this);
                return new Part(headers, Okio.buffer((Source)((Source)partSource)));
            }
            if (n == 1) {
                if (bl) throw new ProtocolException("unexpected characters after boundary");
                if (this.partCount == 0) throw new ProtocolException("expected at least 1 part");
                this.noMoreParts = true;
                return null;
            }
            if (n != 2 && n != 3) continue;
            bl = true;
        }
        throw new ProtocolException("unexpected characters after boundary");
    }
}
