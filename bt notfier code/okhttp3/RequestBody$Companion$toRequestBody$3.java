/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.MediaType
 *  okhttp3.RequestBody
 *  okio.BufferedSink
 */
package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

@Metadata(d1={"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2={"okhttp3/RequestBody$Companion$toRequestBody$3", "Lokhttp3/RequestBody;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "writeTo", "", "sink", "Lokio/BufferedSink;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class RequestBody.Companion.toRequestBody.3
extends RequestBody {
    final int $byteCount;
    final MediaType $contentType;
    final int $offset;
    final byte[] $this_toRequestBody;

    RequestBody.Companion.toRequestBody.3(MediaType mediaType, int n, byte[] byArray, int n2) {
        this.$contentType = mediaType;
        this.$byteCount = n;
        this.$this_toRequestBody = byArray;
        this.$offset = n2;
    }

    public long contentLength() {
        return this.$byteCount;
    }

    public MediaType contentType() {
        return this.$contentType;
    }

    public void writeTo(BufferedSink bufferedSink) {
        Intrinsics.checkNotNullParameter((Object)bufferedSink, (String)"sink");
        bufferedSink.write(this.$this_toRequestBody, this.$offset, this.$byteCount);
    }
}
