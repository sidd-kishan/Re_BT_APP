/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.MediaType
 *  okhttp3.RequestBody
 *  okio.BufferedSink
 *  okio.Okio
 *  okio.Source
 */
package okhttp3;

import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

@Metadata(d1={"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2={"okhttp3/RequestBody$Companion$asRequestBody$1", "Lokhttp3/RequestBody;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "writeTo", "", "sink", "Lokio/BufferedSink;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class RequestBody.Companion.asRequestBody.1
extends RequestBody {
    final MediaType $contentType;
    final File $this_asRequestBody;

    RequestBody.Companion.asRequestBody.1(MediaType mediaType, File file) {
        this.$contentType = mediaType;
        this.$this_asRequestBody = file;
    }

    public long contentLength() {
        return this.$this_asRequestBody.length();
    }

    public MediaType contentType() {
        return this.$contentType;
    }

    public void writeTo(BufferedSink bufferedSink) {
        Intrinsics.checkNotNullParameter((Object)bufferedSink, (String)"sink");
        Closeable closeable = (Closeable)Okio.source((File)this.$this_asRequestBody);
        Throwable throwable = null;
        try {
            bufferedSink.writeAll((Source)closeable);
        }
        catch (Throwable throwable2) {
            try {
                throw throwable2;
            }
            catch (Throwable throwable3) {
                CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable2);
                throw throwable3;
            }
        }
        CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
    }
}
