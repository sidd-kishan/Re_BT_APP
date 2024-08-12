/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okhttp3.MediaType
 *  okhttp3.ResponseBody
 *  okio.BufferedSource
 */
package okhttp3;

import kotlin.Metadata;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

@Metadata(d1={"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2={"okhttp3/ResponseBody$Companion$asResponseBody$1", "Lokhttp3/ResponseBody;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "source", "Lokio/BufferedSource;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class ResponseBody.Companion.asResponseBody.1
extends ResponseBody {
    final long $contentLength;
    final MediaType $contentType;
    final BufferedSource $this_asResponseBody;

    ResponseBody.Companion.asResponseBody.1(MediaType mediaType, long l, BufferedSource bufferedSource) {
        this.$contentType = mediaType;
        this.$contentLength = l;
        this.$this_asResponseBody = bufferedSource;
    }

    public long contentLength() {
        return this.$contentLength;
    }

    public MediaType contentType() {
        return this.$contentType;
    }

    public BufferedSource source() {
        return this.$this_asResponseBody;
    }
}
