/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.internal.PlatformImplementationsKt
 *  kotlin.io.ByteStreamsKt
 *  kotlin.io.CloseableKt
 *  kotlin.io.ExposingBufferByteArrayOutputStream
 *  kotlin.io.FilesKt
 *  kotlin.io.FilesKt__FilePathComponentsKt
 *  kotlin.io.TextStreamsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 *  kotlin.sequences.Sequence
 *  kotlin.text.Charsets
 */
package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.ExposingBufferByteArrayOutputStream;
import kotlin.io.FilesKt;
import kotlin.io.FilesKt__FilePathComponentsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;

@Metadata(d1={"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a!\u0010\n\u001a\u00020\u000b*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u0087\b\u001a!\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u0087\b\u001aB\u0010\u0010\u001a\u00020\u0001*\u00020\u000226\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00010\u0012\u001aJ\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\r26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00010\u0012\u001a7\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00010\u0019\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0002H\u0087\b\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u0002H\u0087\b\u001a\u0017\u0010\u001f\u001a\u00020 *\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\u0087\b\u001a\n\u0010!\u001a\u00020\u0004*\u00020\u0002\u001a\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070#*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0014\u0010$\u001a\u00020\u0007*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0017\u0010%\u001a\u00020&*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\u0087\b\u001aB\u0010'\u001a\u0002H(\"\u0004\b\u0000\u0010(*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\u0018\u0010)\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070*\u0012\u0004\u0012\u0002H(0\u0019H\u0086\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010,\u001a\u0012\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010.\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0017\u0010/\u001a\u000200*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\u0087\b\u0082\u0002\u000f\n\u0006\b\u0011(+0\u0001\n\u0005\b\u009920\u0001\u00a8\u00061"}, d2={"appendBytes", "", "Ljava/io/File;", "array", "", "appendText", "text", "", "charset", "Ljava/nio/charset/Charset;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "bufferedWriter", "Ljava/io/BufferedWriter;", "forEachBlock", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buffer", "bytesRead", "blockSize", "forEachLine", "Lkotlin/Function1;", "line", "inputStream", "Ljava/io/FileInputStream;", "outputStream", "Ljava/io/FileOutputStream;", "printWriter", "Ljava/io/PrintWriter;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "useLines", "T", "block", "Lkotlin/sequences/Sequence;", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "writeText", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/io/FilesKt")
class FilesKt__FileReadWriteKt
extends FilesKt__FilePathComponentsKt {
    public static final void appendBytes(File object, byte[] object2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$appendBytes");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"array");
        object = new FileOutputStream((File)object, true);
        Throwable throwable = null;
        try {
            ((FileOutputStream)object).write((byte[])object2);
            object2 = Unit.INSTANCE;
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
    }

    public static final void appendText(File file, String object, Charset charset) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"$this$appendText");
        Intrinsics.checkNotNullParameter((Object)object, (String)"text");
        Intrinsics.checkNotNullParameter((Object)charset, (String)"charset");
        object = ((String)object).getBytes(charset);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.String).getBytes(charset)");
        FilesKt.appendBytes((File)file, (byte[])object);
    }

    public static /* synthetic */ void appendText$default(File file, String string, Charset charset, int n, Object object) {
        if ((n & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        FilesKt.appendText((File)file, (String)string, (Charset)charset);
    }

    private static final BufferedReader bufferedReader(File object, Charset charset, int n) {
        object = (object = (Reader)new InputStreamReader((InputStream)new FileInputStream((File)object), charset)) instanceof BufferedReader ? (BufferedReader)object : new BufferedReader((Reader)object, n);
        return object;
    }

    static /* synthetic */ BufferedReader bufferedReader$default(File object, Charset charset, int n, int n2, Object object2) {
        if ((n2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((n2 & 2) != 0) {
            n = 8192;
        }
        object = (object = (Reader)new InputStreamReader((InputStream)new FileInputStream((File)object), charset)) instanceof BufferedReader ? (BufferedReader)object : new BufferedReader((Reader)object, n);
        return object;
    }

    private static final BufferedWriter bufferedWriter(File object, Charset charset, int n) {
        object = (object = (Writer)new OutputStreamWriter((OutputStream)new FileOutputStream((File)object), charset)) instanceof BufferedWriter ? (BufferedWriter)object : new BufferedWriter((Writer)object, n);
        return object;
    }

    static /* synthetic */ BufferedWriter bufferedWriter$default(File object, Charset charset, int n, int n2, Object object2) {
        if ((n2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((n2 & 2) != 0) {
            n = 8192;
        }
        object = (object = (Writer)new OutputStreamWriter((OutputStream)new FileOutputStream((File)object), charset)) instanceof BufferedWriter ? (BufferedWriter)object : new BufferedWriter((Writer)object, n);
        return object;
    }

    public static final void forEachBlock(File object, int n, Function2<? super byte[], ? super Integer, Unit> unit) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$forEachBlock");
        Intrinsics.checkNotNullParameter(unit, (String)"action");
        byte[] byArray = new byte[RangesKt.coerceAtLeast((int)n, (int)512)];
        object = new FileInputStream((File)object);
        Throwable throwable = null;
        try {
            FileInputStream fileInputStream = (FileInputStream)object;
            while (true) {
                if ((n = fileInputStream.read(byArray)) > 0) break block6;
                unit = Unit.INSTANCE;
                break;
            }
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
        {
            block6: {
                CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
                return;
            }
            unit.invoke((Object)byArray, (Object)n);
            continue;
        }
    }

    public static final void forEachBlock(File file, Function2<? super byte[], ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"$this$forEachBlock");
        Intrinsics.checkNotNullParameter(function2, (String)"action");
        FilesKt.forEachBlock((File)file, (int)4096, function2);
    }

    public static final void forEachLine(File file, Charset charset, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"$this$forEachLine");
        Intrinsics.checkNotNullParameter((Object)charset, (String)"charset");
        Intrinsics.checkNotNullParameter(function1, (String)"action");
        TextStreamsKt.forEachLine((Reader)new BufferedReader(new InputStreamReader((InputStream)new FileInputStream(file), charset)), function1);
    }

    public static /* synthetic */ void forEachLine$default(File file, Charset charset, Function1 function1, int n, Object object) {
        if ((n & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        FilesKt.forEachLine((File)file, (Charset)charset, (Function1)function1);
    }

    private static final FileInputStream inputStream(File file) {
        return new FileInputStream(file);
    }

    private static final FileOutputStream outputStream(File file) {
        return new FileOutputStream(file);
    }

    private static final PrintWriter printWriter(File object, Charset charset) {
        object = (object = (Writer)new OutputStreamWriter((OutputStream)new FileOutputStream((File)object), charset)) instanceof BufferedWriter ? (BufferedWriter)object : new BufferedWriter((Writer)object, 8192);
        return new PrintWriter((Writer)object);
    }

    static /* synthetic */ PrintWriter printWriter$default(File object, Charset charset, int n, Object object2) {
        if ((n & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        object = (object = (Writer)new OutputStreamWriter((OutputStream)new FileOutputStream((File)object), charset)) instanceof BufferedWriter ? (BufferedWriter)object : new BufferedWriter((Writer)object, 8192);
        return new PrintWriter((Writer)object);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static final byte[] readBytes(File object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$readBytes");
        Closeable closeable = new FileInputStream((File)object);
        Throwable throwable = null;
        try {
            Object object2;
            block15: {
                block13: {
                    int n;
                    int n2;
                    FileInputStream fileInputStream;
                    block14: {
                        block12: {
                            int n3;
                            int n4;
                            fileInputStream = (FileInputStream)closeable;
                            long l = ((File)object).length();
                            if (l <= (long)Integer.MAX_VALUE) {
                                n2 = (int)l;
                                object2 = new byte[n2];
                                n = 0;
                            } else {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("File ");
                                stringBuilder.append(object);
                                stringBuilder.append(" is too big (");
                                stringBuilder.append(l);
                                stringBuilder.append(" bytes) to fit in memory.");
                                throwable = new OutOfMemoryError(stringBuilder.toString());
                                throw throwable;
                            }
                            for (n3 = n2; n3 > 0 && (n4 = fileInputStream.read((byte[])object2, n, n3)) >= 0; n3 -= n4, n += n4) {
                            }
                            if (n3 <= 0) break block12;
                            object = Arrays.copyOf((byte[])object2, n);
                            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.util.Arrays.copyOf(this, newSize)");
                            break block13;
                        }
                        n = fileInputStream.read();
                        if (n != -1) break block14;
                        object = object2;
                        break block13;
                    }
                    ExposingBufferByteArrayOutputStream exposingBufferByteArrayOutputStream = new ExposingBufferByteArrayOutputStream(8193);
                    exposingBufferByteArrayOutputStream.write(n);
                    ByteStreamsKt.copyTo$default((InputStream)fileInputStream, (OutputStream)((OutputStream)exposingBufferByteArrayOutputStream), (int)0, (int)2, null);
                    n = exposingBufferByteArrayOutputStream.size() + n2;
                    if (n < 0) break block15;
                    object = exposingBufferByteArrayOutputStream.getBuffer();
                    object2 = Arrays.copyOf((byte[])object2, n);
                    Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"java.util.Arrays.copyOf(this, newSize)");
                    object = ArraysKt.copyInto((byte[])object, (byte[])object2, (int)n2, (int)0, (int)exposingBufferByteArrayOutputStream.size());
                }
                CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
                return object;
            }
            object2 = new StringBuilder;
            ((StringBuilder)object2)();
            ((StringBuilder)object2).append("File ");
            ((StringBuilder)object2).append(object);
            ((StringBuilder)object2).append(" is too big to fit in memory.");
            throwable = new OutOfMemoryError(((StringBuilder)object2).toString());
            throw throwable;
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
    }

    public static final List<String> readLines(File file, Charset charset) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"$this$readLines");
        Intrinsics.checkNotNullParameter((Object)charset, (String)"charset");
        ArrayList arrayList = new ArrayList();
        FilesKt.forEachLine((File)file, (Charset)charset, (Function1)((Function1)new /* Unavailable Anonymous Inner Class!! */));
        return arrayList;
    }

    public static /* synthetic */ List readLines$default(File file, Charset charset, int n, Object object) {
        if ((n & 1) == 0) return FilesKt.readLines((File)file, (Charset)charset);
        charset = Charsets.UTF_8;
        return FilesKt.readLines((File)file, (Charset)charset);
    }

    public static final String readText(File object, Charset object2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$readText");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"charset");
        object = new InputStreamReader((InputStream)new FileInputStream((File)object), (Charset)object2);
        Throwable throwable = null;
        try {
            object2 = TextStreamsKt.readText((Reader)((InputStreamReader)object));
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

    public static /* synthetic */ String readText$default(File file, Charset charset, int n, Object object) {
        if ((n & 1) == 0) return FilesKt.readText((File)file, (Charset)charset);
        charset = Charsets.UTF_8;
        return FilesKt.readText((File)file, (Charset)charset);
    }

    private static final InputStreamReader reader(File file, Charset charset) {
        return new InputStreamReader((InputStream)new FileInputStream(file), charset);
    }

    static /* synthetic */ InputStreamReader reader$default(File file, Charset charset, int n, Object object) {
        if ((n & 1) == 0) return new InputStreamReader((InputStream)new FileInputStream(file), charset);
        charset = Charsets.UTF_8;
        return new InputStreamReader((InputStream)new FileInputStream(file), charset);
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public static final <T> T useLines(File object, Charset object2, Function1<? super Sequence<String>, ? extends T> object3) {
        Object object4;
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$useLines");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"charset");
        Intrinsics.checkNotNullParameter(object3, (String)"block");
        object = new InputStreamReader((InputStream)new FileInputStream((File)object), (Charset)object2);
        object = object instanceof BufferedReader ? (BufferedReader)object : new BufferedReader((Reader)object, 8192);
        object = (Closeable)object;
        object2 = null;
        try {
            object4 = object3.invoke((Object)TextStreamsKt.lineSequence((BufferedReader)((BufferedReader)object)));
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                block9: {
                    InlineMarker.finallyStart((int)1);
                    if (!PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)1, (int)0)) {
                        object.close();
                    }
                    CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
                    break block9;
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
        return (T)object4;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public static /* synthetic */ Object useLines$default(File object, Charset object2, Function1 object3, int n, Object object4) {
        Object object5;
        void var3_7;
        if ((var3_7 & 1) != 0) {
            object2 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$useLines");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"charset");
        Intrinsics.checkNotNullParameter((Object)object3, (String)"block");
        object = new InputStreamReader((InputStream)new FileInputStream((File)object), (Charset)object2);
        object = object instanceof BufferedReader ? (BufferedReader)object : new BufferedReader((Reader)object, 8192);
        object = (Closeable)object;
        object2 = null;
        try {
            object5 = object3.invoke((Object)TextStreamsKt.lineSequence((BufferedReader)((BufferedReader)object)));
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
        return object5;
    }

    public static final void writeBytes(File object, byte[] object2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$writeBytes");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"array");
        object = new FileOutputStream((File)object);
        Throwable throwable = null;
        try {
            ((FileOutputStream)object).write((byte[])object2);
            object2 = Unit.INSTANCE;
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
    }

    public static final void writeText(File file, String object, Charset charset) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"$this$writeText");
        Intrinsics.checkNotNullParameter((Object)object, (String)"text");
        Intrinsics.checkNotNullParameter((Object)charset, (String)"charset");
        object = ((String)object).getBytes(charset);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.String).getBytes(charset)");
        FilesKt.writeBytes((File)file, (byte[])object);
    }

    public static /* synthetic */ void writeText$default(File file, String string, Charset charset, int n, Object object) {
        if ((n & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        FilesKt.writeText((File)file, (String)string, (Charset)charset);
    }

    private static final OutputStreamWriter writer(File file, Charset charset) {
        return new OutputStreamWriter((OutputStream)new FileOutputStream(file), charset);
    }

    static /* synthetic */ OutputStreamWriter writer$default(File file, Charset charset, int n, Object object) {
        if ((n & 1) == 0) return new OutputStreamWriter((OutputStream)new FileOutputStream(file), charset);
        charset = Charsets.UTF_8;
        return new OutputStreamWriter((OutputStream)new FileOutputStream(file), charset);
    }
}
