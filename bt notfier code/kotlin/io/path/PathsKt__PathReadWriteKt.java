/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.internal.PlatformImplementationsKt
 *  kotlin.io.CloseableKt
 *  kotlin.io.TextStreamsKt
 *  kotlin.io.path.PathsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.Charsets
 */
package kotlin.io.path;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.io.path.PathsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

@Metadata(d1={"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u001e\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a:\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b\u00a2\u0006\u0002\u0010\u0015\u001a:\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b\u00a2\u0006\u0002\u0010\u0018\u001a=\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00010\u001bH\u0087\b\u00f8\u0001\u0000\u001a&\u0010 \u001a\u00020!*\u00020\u00022\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b\u00a2\u0006\u0002\u0010\"\u001a&\u0010#\u001a\u00020$*\u00020\u00022\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b\u00a2\u0006\u0002\u0010%\u001a\r\u0010&\u001a\u00020\u0004*\u00020\u0002H\u0087\b\u001a\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0016\u0010)\u001a\u00020\u001c*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a0\u0010*\u001a\u00020+*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b\u00a2\u0006\u0002\u0010,\u001a?\u0010-\u001a\u0002H.\"\u0004\b\u0000\u0010.*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0018\u0010/\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u000b\u0012\u0004\u0012\u0002H.0\u001bH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u00100\u001a.\u00101\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b\u00a2\u0006\u0002\u00102\u001a>\u00103\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b\u00a2\u0006\u0002\u00104\u001a>\u00103\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b\u00a2\u0006\u0002\u00105\u001a7\u00106\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007\u00a2\u0006\u0002\u00107\u001a0\u00108\u001a\u000209*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b\u00a2\u0006\u0002\u0010:\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006;"}, d2={"appendBytes", "", "Ljava/nio/file/Path;", "array", "", "appendLines", "lines", "", "", "charset", "Ljava/nio/charset/Charset;", "Lkotlin/sequences/Sequence;", "appendText", "text", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedReader;", "bufferedWriter", "Ljava/io/BufferedWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedWriter;", "forEachLine", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "line", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStream;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/InputStreamReader;", "useLines", "T", "block", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "(Ljava/nio/file/Path;[B[Ljava/nio/file/OpenOption;)V", "writeLines", "(Ljava/nio/file/Path;Ljava/lang/Iterable;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "(Ljava/nio/file/Path;Lkotlin/sequences/Sequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "writeText", "(Ljava/nio/file/Path;Ljava/lang/CharSequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)V", "writer", "Ljava/io/OutputStreamWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStreamWriter;", "kotlin-stdlib-jdk7"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/io/path/PathsKt")
class PathsKt__PathReadWriteKt {
    private static final void appendBytes(Path path, byte[] byArray) throws IOException {
        Files.write(path, byArray, StandardOpenOption.APPEND);
    }

    private static final Path appendLines(Path path, Iterable<? extends CharSequence> iterable, Charset charset) throws IOException {
        path = Files.write(path, iterable, charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.write(this, lines,\u2026tandardOpenOption.APPEND)");
        return path;
    }

    private static final Path appendLines(Path path, Sequence<? extends CharSequence> sequence, Charset charset) throws IOException {
        path = Files.write(path, (Iterable<? extends CharSequence>)SequencesKt.asIterable(sequence), charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.write(this, lines.\u2026tandardOpenOption.APPEND)");
        return path;
    }

    static /* synthetic */ Path appendLines$default(Path path, Iterable iterable, Charset charset, int n, Object object) throws IOException {
        if ((n & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        path = Files.write(path, (Iterable<? extends CharSequence>)iterable, charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.write(this, lines,\u2026tandardOpenOption.APPEND)");
        return path;
    }

    static /* synthetic */ Path appendLines$default(Path path, Sequence sequence, Charset charset, int n, Object object) throws IOException {
        if ((n & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        path = Files.write(path, (Iterable<? extends CharSequence>)SequencesKt.asIterable((Sequence)sequence), charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.write(this, lines.\u2026tandardOpenOption.APPEND)");
        return path;
    }

    public static final void appendText(Path object, CharSequence charSequence, Charset object2) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$appendText");
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"text");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"charset");
        object = Files.newOutputStream((Path)object, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Files.newOutputStream(th\u2026tandardOpenOption.APPEND)");
        object = new OutputStreamWriter((OutputStream)object, (Charset)object2);
        object2 = null;
        try {
            ((OutputStreamWriter)object).append(charSequence);
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
                throw throwable2;
            }
        }
        CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
    }

    public static /* synthetic */ void appendText$default(Path path, CharSequence charSequence, Charset charset, int n, Object object) throws IOException {
        if ((n & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        PathsKt.appendText((Path)path, (CharSequence)charSequence, (Charset)charset);
    }

    private static final BufferedReader bufferedReader(Path path, Charset charset, int n, OpenOption ... openOptionArray) throws IOException {
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, Arrays.copyOf(openOptionArray, openOptionArray.length)), charset), n);
    }

    static /* synthetic */ BufferedReader bufferedReader$default(Path path, Charset charset, int n, OpenOption[] openOptionArray, int n2, Object object) throws IOException {
        if ((n2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((n2 & 2) == 0) return new BufferedReader(new InputStreamReader(Files.newInputStream(path, Arrays.copyOf(openOptionArray, openOptionArray.length)), charset), n);
        n = 8192;
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, Arrays.copyOf(openOptionArray, openOptionArray.length)), charset), n);
    }

    private static final BufferedWriter bufferedWriter(Path path, Charset charset, int n, OpenOption ... openOptionArray) throws IOException {
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, Arrays.copyOf(openOptionArray, openOptionArray.length)), charset), n);
    }

    static /* synthetic */ BufferedWriter bufferedWriter$default(Path path, Charset charset, int n, OpenOption[] openOptionArray, int n2, Object object) throws IOException {
        if ((n2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((n2 & 2) == 0) return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, Arrays.copyOf(openOptionArray, openOptionArray.length)), charset), n);
        n = 8192;
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, Arrays.copyOf(openOptionArray, openOptionArray.length)), charset), n);
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    private static final void forEachLine(Path object, Charset object2, Function1<? super String, Unit> unit) throws IOException {
        object = Files.newBufferedReader((Path)object, (Charset)object2);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Files.newBufferedReader(this, charset)");
        object = (Reader)object;
        object = object instanceof BufferedReader ? (BufferedReader)object : new BufferedReader((Reader)object, 8192);
        object = (Closeable)object;
        object2 = null;
        try {
            Iterator iterator = TextStreamsKt.lineSequence((BufferedReader)((BufferedReader)object)).iterator();
            while (iterator.hasNext()) {
                unit.invoke(iterator.next());
            }
            unit = Unit.INSTANCE;
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                block10: {
                    InlineMarker.finallyStart((int)1);
                    if (!PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)1, (int)0)) {
                        object.close();
                    }
                    CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
                    break block10;
                    catch (Throwable throwable3) {}
                }
                InlineMarker.finallyEnd((int)1);
                throw throwable2;
            }
        }
        InlineMarker.finallyStart((int)1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)1, (int)0)) {
            CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        } else {
            object.close();
        }
        InlineMarker.finallyEnd((int)1);
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    static /* synthetic */ void forEachLine$default(Path object, Charset object2, Function1 function1, int n, Object object3) throws IOException {
        if ((n & 1) != 0) {
            object2 = Charsets.UTF_8;
        }
        object = Files.newBufferedReader((Path)object, (Charset)object2);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Files.newBufferedReader(this, charset)");
        object = (Reader)object;
        object = object instanceof BufferedReader ? (BufferedReader)object : new BufferedReader((Reader)object, 8192);
        object = (Closeable)object;
        object2 = null;
        try {
            object3 = TextStreamsKt.lineSequence((BufferedReader)((BufferedReader)object)).iterator();
            while (object3.hasNext()) {
                function1.invoke(object3.next());
            }
            function1 = Unit.INSTANCE;
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                block11: {
                    InlineMarker.finallyStart((int)1);
                    if (!PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)1, (int)0)) {
                        object.close();
                    }
                    CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
                    break block11;
                    catch (Throwable throwable3) {}
                }
                InlineMarker.finallyEnd((int)1);
                throw throwable2;
            }
        }
        InlineMarker.finallyStart((int)1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)1, (int)0)) {
            CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        } else {
            object.close();
        }
        InlineMarker.finallyEnd((int)1);
    }

    private static final InputStream inputStream(Path object, OpenOption ... openOptionArray) throws IOException {
        object = Files.newInputStream((Path)object, Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Files.newInputStream(this, *options)");
        return object;
    }

    private static final OutputStream outputStream(Path object, OpenOption ... openOptionArray) throws IOException {
        object = Files.newOutputStream((Path)object, Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Files.newOutputStream(this, *options)");
        return object;
    }

    private static final byte[] readBytes(Path object) throws IOException {
        object = Files.readAllBytes((Path)object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Files.readAllBytes(this)");
        return object;
    }

    private static final List<String> readLines(Path iterable, Charset charset) throws IOException {
        iterable = Files.readAllLines(iterable, charset);
        Intrinsics.checkNotNullExpressionValue((Object)iterable, (String)"Files.readAllLines(this, charset)");
        return iterable;
    }

    static /* synthetic */ List readLines$default(Path iterable, Charset charset, int n, Object object) throws IOException {
        if ((n & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        iterable = Files.readAllLines(iterable, charset);
        Intrinsics.checkNotNullExpressionValue((Object)iterable, (String)"Files.readAllLines(this, charset)");
        return iterable;
    }

    public static final String readText(Path object, Charset object2) throws IOException {
        String string;
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$readText");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"charset");
        object = new InputStreamReader(Files.newInputStream((Path)object, Arrays.copyOf(new OpenOption[0], 0)), (Charset)object2);
        object2 = null;
        try {
            string = TextStreamsKt.readText((Reader)((InputStreamReader)object));
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
                throw throwable2;
            }
        }
        CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        return string;
    }

    public static /* synthetic */ String readText$default(Path path, Charset charset, int n, Object object) throws IOException {
        if ((n & 1) == 0) return PathsKt.readText((Path)path, (Charset)charset);
        charset = Charsets.UTF_8;
        return PathsKt.readText((Path)path, (Charset)charset);
    }

    private static final InputStreamReader reader(Path path, Charset charset, OpenOption ... openOptionArray) throws IOException {
        return new InputStreamReader(Files.newInputStream(path, Arrays.copyOf(openOptionArray, openOptionArray.length)), charset);
    }

    static /* synthetic */ InputStreamReader reader$default(Path path, Charset charset, OpenOption[] openOptionArray, int n, Object object) throws IOException {
        if ((n & 1) == 0) return new InputStreamReader(Files.newInputStream(path, Arrays.copyOf(openOptionArray, openOptionArray.length)), charset);
        charset = Charsets.UTF_8;
        return new InputStreamReader(Files.newInputStream(path, Arrays.copyOf(openOptionArray, openOptionArray.length)), charset);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private static final <T> T useLines(Path object, Charset object2, Function1<? super Sequence<String>, ? extends T> object3) throws IOException {
        Object object4;
        object = Files.newBufferedReader((Path)object, (Charset)object2);
        object2 = null;
        try {
            BufferedReader bufferedReader = (BufferedReader)object;
            Intrinsics.checkNotNullExpressionValue((Object)bufferedReader, (String)"it");
            object4 = object3.invoke((Object)TextStreamsKt.lineSequence((BufferedReader)bufferedReader));
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                block10: {
                    block9: {
                        InlineMarker.finallyStart((int)1);
                        if (PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)1, (int)0)) break block9;
                        if (object == null) break block10;
                        try {
                            object.close();
                        }
                        catch (Throwable throwable3) {}
                    }
                    CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
                }
                InlineMarker.finallyEnd((int)1);
                throw throwable2;
            }
        }
        InlineMarker.finallyStart((int)1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)1, (int)0)) {
            CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        } else if (object != null) {
            object.close();
        }
        InlineMarker.finallyEnd((int)1);
        return (T)object4;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    static /* synthetic */ Object useLines$default(Path object, Charset object2, Function1 object3, int n, Object object4) throws IOException {
        Object object5;
        void var3_7;
        if ((var3_7 & 1) != 0) {
            object2 = Charsets.UTF_8;
        }
        object = Files.newBufferedReader((Path)object, (Charset)object2);
        object2 = null;
        try {
            BufferedReader bufferedReader = (BufferedReader)object;
            Intrinsics.checkNotNullExpressionValue((Object)bufferedReader, (String)"it");
            object5 = object3.invoke((Object)TextStreamsKt.lineSequence((BufferedReader)bufferedReader));
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                block11: {
                    block10: {
                        InlineMarker.finallyStart((int)1);
                        if (PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)1, (int)0)) break block10;
                        if (object == null) break block11;
                        try {
                            object.close();
                        }
                        catch (Throwable throwable3) {}
                    }
                    CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
                }
                InlineMarker.finallyEnd((int)1);
                throw throwable2;
            }
        }
        InlineMarker.finallyStart((int)1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)1, (int)0)) {
            CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        } else if (object != null) {
            object.close();
        }
        InlineMarker.finallyEnd((int)1);
        return object5;
    }

    private static final void writeBytes(Path path, byte[] byArray, OpenOption ... openOptionArray) throws IOException {
        Files.write(path, byArray, Arrays.copyOf(openOptionArray, openOptionArray.length));
    }

    private static final Path writeLines(Path path, Iterable<? extends CharSequence> iterable, Charset charset, OpenOption ... openOptionArray) throws IOException {
        path = Files.write(path, iterable, charset, Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.write(this, lines, charset, *options)");
        return path;
    }

    private static final Path writeLines(Path path, Sequence<? extends CharSequence> sequence, Charset charset, OpenOption ... openOptionArray) throws IOException {
        path = Files.write(path, (Iterable<? extends CharSequence>)SequencesKt.asIterable(sequence), charset, Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.write(this, lines.\u2026ble(), charset, *options)");
        return path;
    }

    static /* synthetic */ Path writeLines$default(Path path, Iterable iterable, Charset charset, OpenOption[] openOptionArray, int n, Object object) throws IOException {
        if ((n & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        path = Files.write(path, (Iterable<? extends CharSequence>)iterable, charset, Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.write(this, lines, charset, *options)");
        return path;
    }

    static /* synthetic */ Path writeLines$default(Path path, Sequence sequence, Charset charset, OpenOption[] openOptionArray, int n, Object object) throws IOException {
        if ((n & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        path = Files.write(path, (Iterable<? extends CharSequence>)SequencesKt.asIterable((Sequence)sequence), charset, Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.write(this, lines.\u2026ble(), charset, *options)");
        return path;
    }

    public static final void writeText(Path object, CharSequence charSequence, Charset object2, OpenOption ... openOptionArray) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$writeText");
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"text");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"charset");
        Intrinsics.checkNotNullParameter((Object)openOptionArray, (String)"options");
        object = Files.newOutputStream((Path)object, Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Files.newOutputStream(this, *options)");
        object = new OutputStreamWriter((OutputStream)object, (Charset)object2);
        object2 = null;
        try {
            ((OutputStreamWriter)object).append(charSequence);
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
                throw throwable2;
            }
        }
        CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
    }

    public static /* synthetic */ void writeText$default(Path path, CharSequence charSequence, Charset charset, OpenOption[] openOptionArray, int n, Object object) throws IOException {
        if ((n & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        PathsKt.writeText((Path)path, (CharSequence)charSequence, (Charset)charset, (OpenOption[])openOptionArray);
    }

    private static final OutputStreamWriter writer(Path path, Charset charset, OpenOption ... openOptionArray) throws IOException {
        return new OutputStreamWriter(Files.newOutputStream(path, Arrays.copyOf(openOptionArray, openOptionArray.length)), charset);
    }

    static /* synthetic */ OutputStreamWriter writer$default(Path path, Charset charset, OpenOption[] openOptionArray, int n, Object object) throws IOException {
        if ((n & 1) == 0) return new OutputStreamWriter(Files.newOutputStream(path, Arrays.copyOf(openOptionArray, openOptionArray.length)), charset);
        charset = Charsets.UTF_8;
        return new OutputStreamWriter(Files.newOutputStream(path, Arrays.copyOf(openOptionArray, openOptionArray.length)), charset);
    }
}
