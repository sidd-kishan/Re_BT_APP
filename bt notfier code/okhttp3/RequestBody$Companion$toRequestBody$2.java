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
 */
package okhttp3;

import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;

@Metadata(d1={"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2={"okhttp3/RequestBody$Companion$toRequestBody$2", "Lokhttp3/RequestBody;", "contentType", "Lokhttp3/MediaType;", "isOneShot", "", "writeTo", "", "sink", "Lokio/BufferedSink;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class RequestBody.Companion.toRequestBody.2
extends RequestBody {
    final MediaType $contentType;
    final FileDescriptor $this_toRequestBody;

    RequestBody.Companion.toRequestBody.2(MediaType mediaType, FileDescriptor fileDescriptor) {
        this.$contentType = mediaType;
        this.$this_toRequestBody = fileDescriptor;
    }

    public MediaType contentType() {
        return this.$contentType;
    }

    public boolean isOneShot() {
        return true;
    }

    public void writeTo(BufferedSink bufferedSink) {
        Intrinsics.checkNotNullParameter((Object)bufferedSink, (String)"sink");
        Closeable closeable = new FileInputStream(this.$this_toRequestBody);
        Throwable throwable = null;
        try {
            FileInputStream fileInputStream = (FileInputStream)closeable;
            bufferedSink.getBuffer().writeAll(Okio.source((InputStream)fileInputStream));
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
