/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.MediaType
 *  okhttp3.ResponseBody
 *  okio.BufferedSource
 *  okio.Okio
 *  okio.Source
 */
package retrofit2;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

static final class OkHttpCall.ExceptionCatchingResponseBody
extends ResponseBody {
    private final ResponseBody delegate;
    private final BufferedSource delegateSource;
    @Nullable
    IOException thrownException;

    OkHttpCall.ExceptionCatchingResponseBody(ResponseBody responseBody) {
        this.delegate = responseBody;
        this.delegateSource = Okio.buffer((Source)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void close() {
        this.delegate.close();
    }

    public long contentLength() {
        return this.delegate.contentLength();
    }

    public MediaType contentType() {
        return this.delegate.contentType();
    }

    public BufferedSource source() {
        return this.delegateSource;
    }

    void throwIfCaught() throws IOException {
        IOException iOException = this.thrownException;
        if (iOException != null) throw iOException;
    }
}
