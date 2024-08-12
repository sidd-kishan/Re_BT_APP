/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  okio.BlackholeSink
 *  okio.BufferedSink
 *  okio.BufferedSource
 *  okio.RealBufferedSink
 *  okio.RealBufferedSource
 *  okio.Sink
 *  okio.Source
 */
package okio;

import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.BlackholeSink;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Source;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007\u00a2\u0006\u0002\b\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0005*\u00020\u0006\u001aA\u0010\u0007\u001a\u0002H\b\"\u0010\b\u0000\u0010\t*\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b\"\u0004\b\u0001\u0010\b*\u0002H\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\b0\rH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u000f"}, d2={"blackholeSink", "Lokio/Sink;", "blackhole", "buffer", "Lokio/BufferedSink;", "Lokio/BufferedSource;", "Lokio/Source;", "use", "R", "T", "Ljava/io/Closeable;", "Lokio/Closeable;", "block", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "okio"}, k=5, mv={1, 5, 1}, xi=48, xs="okio/Okio")
final class Okio__OkioKt {
    public static final Sink blackhole() {
        return (Sink)new BlackholeSink();
    }

    public static final BufferedSink buffer(Sink sink) {
        Intrinsics.checkNotNullParameter((Object)sink, (String)"<this>");
        return (BufferedSink)new RealBufferedSink(sink);
    }

    public static final BufferedSource buffer(Source source) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"<this>");
        return (BufferedSource)new RealBufferedSource(source);
    }

    public static final <T extends Closeable, R> R use(T object, Function1<? super T, ? extends R> function1) {
        Object object2;
        block6: {
            Intrinsics.checkNotNullParameter(function1, (String)"block");
            object2 = null;
            try {
                Object object3 = function1.invoke(object);
                function1 = object2;
                object2 = object3;
            }
            catch (Throwable throwable) {
                object2 = null;
            }
            if (object == null) {
                object = function1;
            } else {
                try {
                    object.close();
                    object = function1;
                }
                catch (Throwable throwable) {
                    if (function1 == null) break block6;
                    ExceptionsKt.addSuppressed(function1, (Throwable)throwable);
                    object = function1;
                }
            }
        }
        if (object != null) throw object;
        Intrinsics.checkNotNull((Object)object2);
        return (R)object2;
    }
}
