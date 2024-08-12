/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.FormBody$Companion
 *  okhttp3.HttpUrl
 *  okhttp3.HttpUrl$Companion
 *  okhttp3.MediaType
 *  okhttp3.RequestBody
 *  okhttp3.internal.Util
 *  okio.Buffer
 *  okio.BufferedSink
 */
package okhttp3;

import java.io.IOException;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB#\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bJ\r\u0010\u0007\u001a\u00020\bH\u0007\u00a2\u0006\u0002\b\u0012J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bJ\u001a\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8G\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\u001d"}, d2={"Lokhttp3/FormBody;", "Lokhttp3/RequestBody;", "encodedNames", "", "", "encodedValues", "(Ljava/util/List;Ljava/util/List;)V", "size", "", "()I", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "encodedName", "index", "encodedValue", "name", "-deprecated_size", "value", "writeOrCountBytes", "sink", "Lokio/BufferedSink;", "countBytes", "", "writeTo", "", "Builder", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class FormBody
extends RequestBody {
    private static final MediaType CONTENT_TYPE;
    public static final Companion Companion;
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    static {
        Companion = new Companion(null);
        CONTENT_TYPE = MediaType.Companion.get("application/x-www-form-urlencoded");
    }

    public FormBody(List<String> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(list, (String)"encodedNames");
        Intrinsics.checkNotNullParameter(list2, (String)"encodedValues");
        this.encodedNames = Util.toImmutableList(list);
        this.encodedValues = Util.toImmutableList(list2);
    }

    private final long writeOrCountBytes(BufferedSink bufferedSink, boolean bl) {
        long l;
        if (bl) {
            bufferedSink = new Buffer();
        } else {
            Intrinsics.checkNotNull((Object)bufferedSink);
            bufferedSink = bufferedSink.getBuffer();
        }
        int n = 0;
        int n2 = this.encodedNames.size();
        if (n2 > 0) {
            while (true) {
                int n3 = n + 1;
                if (n > 0) {
                    bufferedSink.writeByte(38);
                }
                bufferedSink.writeUtf8(this.encodedNames.get(n));
                bufferedSink.writeByte(61);
                bufferedSink.writeUtf8(this.encodedValues.get(n));
                if (n3 >= n2) break;
                n = n3;
            }
        }
        if (bl) {
            l = bufferedSink.size();
            bufferedSink.clear();
        } else {
            l = 0L;
        }
        return l;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="size", imports={}))
    public final int _deprecated_size() {
        return this.size();
    }

    public long contentLength() {
        return this.writeOrCountBytes(null, true);
    }

    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public final String encodedName(int n) {
        return this.encodedNames.get(n);
    }

    public final String encodedValue(int n) {
        return this.encodedValues.get(n);
    }

    public final String name(int n) {
        return HttpUrl.Companion.percentDecode$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)this.encodedName(n), (int)0, (int)0, (boolean)true, (int)3, null);
    }

    public final int size() {
        return this.encodedNames.size();
    }

    public final String value(int n) {
        return HttpUrl.Companion.percentDecode$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)this.encodedValue(n), (int)0, (int)0, (boolean)true, (int)3, null);
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Intrinsics.checkNotNullParameter((Object)bufferedSink, (String)"sink");
        this.writeOrCountBytes(bufferedSink, false);
    }
}
