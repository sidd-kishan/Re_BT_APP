/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.MediaType
 *  okhttp3.ResponseBody
 *  okio.BufferedSource
 */
package retrofit2;

import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

static final class OkHttpCall.NoContentResponseBody
extends ResponseBody {
    private final long contentLength;
    @Nullable
    private final MediaType contentType;

    OkHttpCall.NoContentResponseBody(@Nullable MediaType mediaType, long l) {
        this.contentType = mediaType;
        this.contentLength = l;
    }

    public long contentLength() {
        return this.contentLength;
    }

    public MediaType contentType() {
        return this.contentType;
    }

    public BufferedSource source() {
        throw new IllegalStateException("Cannot read raw response body of a converted body.");
    }
}
