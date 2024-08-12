/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.MediaType
 *  okhttp3.RequestBody
 *  okio.BufferedSink
 */
package retrofit2;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

private static class RequestBuilder.ContentTypeOverridingRequestBody
extends RequestBody {
    private final MediaType contentType;
    private final RequestBody delegate;

    RequestBuilder.ContentTypeOverridingRequestBody(RequestBody requestBody, MediaType mediaType) {
        this.delegate = requestBody;
        this.contentType = mediaType;
    }

    public long contentLength() throws IOException {
        return this.delegate.contentLength();
    }

    public MediaType contentType() {
        return this.contentType;
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        this.delegate.writeTo(bufferedSink);
    }
}
