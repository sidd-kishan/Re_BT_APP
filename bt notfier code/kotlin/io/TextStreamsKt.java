/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.internal.PlatformImplementationsKt
 *  kotlin.io.ByteStreamsKt
 *  kotlin.io.CloseableKt
 *  kotlin.io.LinesSequence
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.Charsets
 */
package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.LinesSequence;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

@Metadata(d1={"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r\u001a\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a\u0010\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015*\u00020\u0002\u001a\n\u0010\u0016\u001a\u00020\u000e*\u00020\u0002\u001a\u0017\u0010\u0016\u001a\u00020\u000e*\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u001a*\u00020\u000eH\u0087\b\u001a8\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c*\u00020\u00022\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0010\u0012\u0004\u0012\u0002H\u001c0\rH\u0086\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010\u001f\u0082\u0002\u000f\n\u0006\b\u0011(\u001e0\u0001\n\u0005\b\u009920\u0001\u00a8\u0006 "}, d2={"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "copyTo", "", "out", "forEachLine", "", "action", "Lkotlin/Function1;", "", "lineSequence", "Lkotlin/sequences/Sequence;", "readBytes", "", "Ljava/net/URL;", "readLines", "", "readText", "charset", "Ljava/nio/charset/Charset;", "reader", "Ljava/io/StringReader;", "useLines", "T", "block", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class TextStreamsKt {
    private static final BufferedReader buffered(Reader reader, int n) {
        reader = reader instanceof BufferedReader ? (BufferedReader)reader : new BufferedReader(reader, n);
        return reader;
    }

    private static final BufferedWriter buffered(Writer writer, int n) {
        writer = writer instanceof BufferedWriter ? (BufferedWriter)writer : new BufferedWriter(writer, n);
        return writer;
    }

    static /* synthetic */ BufferedReader buffered$default(Reader reader, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 8192;
        }
        reader = reader instanceof BufferedReader ? (BufferedReader)reader : new BufferedReader(reader, n);
        return reader;
    }

    static /* synthetic */ BufferedWriter buffered$default(Writer writer, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 8192;
        }
        writer = writer instanceof BufferedWriter ? (BufferedWriter)writer : new BufferedWriter(writer, n);
        return writer;
    }

    public static final long copyTo(Reader reader, Writer writer, int n) {
        Intrinsics.checkNotNullParameter((Object)reader, (String)"$this$copyTo");
        Intrinsics.checkNotNullParameter((Object)writer, (String)"out");
        char[] cArray = new char[n];
        n = reader.read(cArray);
        long l = 0L;
        while (n >= 0) {
            writer.write(cArray, 0, n);
            l += (long)n;
            n = reader.read(cArray);
        }
        return l;
    }

    public static /* synthetic */ long copyTo$default(Reader reader, Writer writer, int n, int n2, Object object) {
        if ((n2 & 2) == 0) return TextStreamsKt.copyTo(reader, writer, n);
        n = 8192;
        return TextStreamsKt.copyTo(reader, writer, n);
    }

    public static final void forEachLine(Reader closeable, Function1<? super String, Unit> unit) {
        Intrinsics.checkNotNullParameter((Object)closeable, (String)"$this$forEachLine");
        Intrinsics.checkNotNullParameter(unit, (String)"action");
        closeable = closeable instanceof BufferedReader ? (BufferedReader)closeable : new BufferedReader((Reader)closeable, 8192);
        closeable = closeable;
        Throwable throwable = null;
        try {
            Iterator iterator = TextStreamsKt.lineSequence((BufferedReader)closeable).iterator();
            while (iterator.hasNext()) {
                unit.invoke(iterator.next());
            }
            unit = Unit.INSTANCE;
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

    public static final Sequence<String> lineSequence(BufferedReader bufferedReader) {
        Intrinsics.checkNotNullParameter((Object)bufferedReader, (String)"$this$lineSequence");
        return SequencesKt.constrainOnce((Sequence)((Sequence)new LinesSequence(bufferedReader)));
    }

    public static final byte[] readBytes(URL object) {
        Object object2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$readBytes");
        object = ((URL)object).openStream();
        Throwable throwable = null;
        try {
            object2 = (InputStream)object;
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"it");
            object2 = ByteStreamsKt.readBytes((InputStream)object2);
        }
        catch (Throwable throwable2) {
            try {
                throw throwable2;
            }
            catch (Throwable throwable3) {
                CloseableKt.closeFinally((Closeable)object, (Throwable)throwable2);
                throw throwable3;
            }
        }
        CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
        return object2;
    }

    public static final List<String> readLines(Reader reader) {
        Intrinsics.checkNotNullParameter((Object)reader, (String)"$this$readLines");
        ArrayList arrayList = new ArrayList();
        TextStreamsKt.forEachLine(reader, (Function1<? super String, Unit>)((Function1)new /* Unavailable Anonymous Inner Class!! */));
        return arrayList;
    }

    public static final String readText(Reader object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$readText");
        StringWriter stringWriter = new StringWriter();
        TextStreamsKt.copyTo$default((Reader)object, stringWriter, 0, 2, null);
        object = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"buffer.toString()");
        return object;
    }

    private static final String readText(URL uRL, Charset charset) {
        return new String(TextStreamsKt.readBytes(uRL), charset);
    }

    static /* synthetic */ String readText$default(URL uRL, Charset charset, int n, Object object) {
        if ((n & 1) == 0) return new String(TextStreamsKt.readBytes(uRL), charset);
        charset = Charsets.UTF_8;
        return new String(TextStreamsKt.readBytes(uRL), charset);
    }

    private static final StringReader reader(String string) {
        return new StringReader(string);
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public static final <T> T useLines(Reader closeable, Function1<? super Sequence<String>, ? extends T> object) {
        Object object2;
        Intrinsics.checkNotNullParameter((Object)closeable, (String)"$this$useLines");
        Intrinsics.checkNotNullParameter(object, (String)"block");
        closeable = closeable instanceof BufferedReader ? (BufferedReader)closeable : new BufferedReader((Reader)closeable, 8192);
        Throwable throwable = null;
        try {
            object2 = object.invoke(TextStreamsKt.lineSequence((BufferedReader)closeable));
        }
        catch (Throwable throwable2) {
            try {
                throw throwable2;
            }
            catch (Throwable throwable3) {
                block9: {
                    InlineMarker.finallyStart((int)1);
                    if (!PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)1, (int)0)) {
                        closeable.close();
                    }
                    CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable2);
                    break block9;
                    catch (Throwable throwable4) {}
                }
                InlineMarker.finallyEnd((int)1);
                throw throwable3;
            }
        }
        InlineMarker.finallyStart((int)1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)1, (int)0)) {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        } else {
            closeable.close();
        }
        InlineMarker.finallyEnd((int)1);
        return (T)object2;
    }
}
