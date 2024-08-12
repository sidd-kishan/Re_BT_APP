/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.Util
 *  okio.BufferedSource
 */
package okhttp3;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.BufferedSource;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lokhttp3/ResponseBody$BomAwareReader;", "Ljava/io/Reader;", "source", "Lokio/BufferedSource;", "charset", "Ljava/nio/charset/Charset;", "(Lokio/BufferedSource;Ljava/nio/charset/Charset;)V", "closed", "", "delegate", "close", "", "read", "", "cbuf", "", "off", "len", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class ResponseBody.BomAwareReader
extends Reader {
    private final Charset charset;
    private boolean closed;
    private Reader delegate;
    private final BufferedSource source;

    public ResponseBody.BomAwareReader(BufferedSource bufferedSource, Charset charset) {
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"source");
        Intrinsics.checkNotNullParameter((Object)charset, (String)"charset");
        this.source = bufferedSource;
        this.charset = charset;
    }

    @Override
    public void close() throws IOException {
        this.closed = true;
        Reader reader = this.delegate;
        if (reader == null) {
            reader = null;
        } else {
            reader.close();
            reader = Unit.INSTANCE;
        }
        if (reader != null) return;
        this.source.close();
    }

    @Override
    public int read(char[] cArray, int n, int n2) throws IOException {
        Reader reader;
        Intrinsics.checkNotNullParameter((Object)cArray, (String)"cbuf");
        if (this.closed) throw new IOException("Stream closed");
        Reader reader2 = reader = this.delegate;
        if (reader != null) return reader2.read(cArray, n, n2);
        this.delegate = reader2 = (Reader)new InputStreamReader(this.source.inputStream(), Util.readBomAsCharset((BufferedSource)this.source, (Charset)this.charset));
        return reader2.read(cArray, n, n2);
    }
}
