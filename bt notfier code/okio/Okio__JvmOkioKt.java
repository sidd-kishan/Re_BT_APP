/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okio.CipherSink
 *  okio.CipherSource
 *  okio.FileSystem
 *  okio.HashingSink
 *  okio.HashingSource
 *  okio.InputStreamSource
 *  okio.Okio
 *  okio.OutputStreamSink
 *  okio.Path
 *  okio.Sink
 *  okio.SocketAsyncTimeout
 *  okio.Source
 *  okio.Timeout
 *  okio.internal.ResourceFileSystem
 *  okio.internal.ZipKt
 */
package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.CipherSink;
import okio.CipherSource;
import okio.FileSystem;
import okio.HashingSink;
import okio.HashingSource;
import okio.InputStreamSource;
import okio.Okio;
import okio.OutputStreamSink;
import okio.Path;
import okio.Sink;
import okio.SocketAsyncTimeout;
import okio.Source;
import okio.Timeout;
import okio.internal.ResourceFileSystem;
import okio.internal.ZipKt;

@Metadata(d1={"\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\b\u001a\u00020\t*\u00020\n\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\r\u001a\u0012\u0010\u000e\u001a\u00020\u000f*\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0012\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0012\u0010\u0015\u001a\u00020\u0016*\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0012\u0010\u0015\u001a\u00020\u0016*\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a\u001a\u0012\u0010\u001b\u001a\u00020\u001c*\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0012\u0010\u001b\u001a\u00020\u001c*\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a\u001a\u0012\u0010\u001d\u001a\u00020\f*\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f\u001a\u0016\u0010 \u001a\u00020\t*\u00020\n2\b\b\u0002\u0010!\u001a\u00020\u0004H\u0007\u001a\n\u0010 \u001a\u00020\t*\u00020\"\u001a\n\u0010 \u001a\u00020\t*\u00020#\u001a%\u0010 \u001a\u00020\t*\u00020$2\u0012\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0&\"\u00020'H\u0007\u00a2\u0006\u0002\u0010(\u001a\n\u0010)\u001a\u00020\u0014*\u00020\n\u001a\n\u0010)\u001a\u00020\u0014*\u00020*\u001a\n\u0010)\u001a\u00020\u0014*\u00020#\u001a%\u0010)\u001a\u00020\u0014*\u00020$2\u0012\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0&\"\u00020'H\u0007\u00a2\u0006\u0002\u0010+\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u001c\u0010\u0003\u001a\u00020\u0004*\u00060\u0005j\u0002`\u00068@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0007\u00a8\u0006,"}, d2={"logger", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "isAndroidGetsocknameError", "", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "(Ljava/lang/AssertionError;)Z", "appendingSink", "Lokio/Sink;", "Ljava/io/File;", "asResourceFileSystem", "Lokio/FileSystem;", "Ljava/lang/ClassLoader;", "cipherSink", "Lokio/CipherSink;", "cipher", "Ljavax/crypto/Cipher;", "cipherSource", "Lokio/CipherSource;", "Lokio/Source;", "hashingSink", "Lokio/HashingSink;", "digest", "Ljava/security/MessageDigest;", "mac", "Ljavax/crypto/Mac;", "hashingSource", "Lokio/HashingSource;", "openZip", "zipPath", "Lokio/Path;", "sink", "append", "Ljava/io/OutputStream;", "Ljava/net/Socket;", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "source", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "okio"}, k=5, mv={1, 5, 1}, xi=48, xs="okio/Okio")
final class Okio__JvmOkioKt {
    private static final Logger logger = Logger.getLogger("okio.Okio");

    public static final /* synthetic */ Logger access$getLogger$p() {
        return logger;
    }

    public static final Sink appendingSink(File file) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter((Object)file, (String)"<this>");
        return Okio.sink((OutputStream)new FileOutputStream(file, true));
    }

    public static final FileSystem asResourceFileSystem(ClassLoader classLoader) {
        Intrinsics.checkNotNullParameter((Object)classLoader, (String)"<this>");
        return (FileSystem)new ResourceFileSystem(classLoader, true);
    }

    public static final CipherSink cipherSink(Sink sink, Cipher cipher) {
        Intrinsics.checkNotNullParameter((Object)sink, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)cipher, (String)"cipher");
        return new CipherSink(Okio.buffer((Sink)sink), cipher);
    }

    public static final CipherSource cipherSource(Source source, Cipher cipher) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)cipher, (String)"cipher");
        return new CipherSource(Okio.buffer((Source)source), cipher);
    }

    public static final HashingSink hashingSink(Sink sink, MessageDigest messageDigest) {
        Intrinsics.checkNotNullParameter((Object)sink, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)messageDigest, (String)"digest");
        return new HashingSink(sink, messageDigest);
    }

    public static final HashingSink hashingSink(Sink sink, Mac mac) {
        Intrinsics.checkNotNullParameter((Object)sink, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)mac, (String)"mac");
        return new HashingSink(sink, mac);
    }

    public static final HashingSource hashingSource(Source source, MessageDigest messageDigest) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)messageDigest, (String)"digest");
        return new HashingSource(source, messageDigest);
    }

    public static final HashingSource hashingSource(Source source, Mac mac) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)mac, (String)"mac");
        return new HashingSource(source, mac);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError object) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Throwable throwable = ((Throwable)object).getCause();
        boolean bl2 = bl = false;
        if (throwable == null) return bl2;
        boolean bl3 = (object = ((Throwable)object).getMessage()) == null ? false : StringsKt.contains$default((CharSequence)((CharSequence)object), (CharSequence)"getsockname failed", (boolean)false, (int)2, null);
        bl2 = bl;
        if (!bl3) return bl2;
        bl2 = true;
        return bl2;
    }

    public static final FileSystem openZip(FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.checkNotNullParameter((Object)fileSystem, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)path, (String)"zipPath");
        return (FileSystem)ZipKt.openZip$default((Path)path, (FileSystem)fileSystem, null, (int)4, null);
    }

    public static final Sink sink(File file) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter((Object)file, (String)"<this>");
        return Okio.sink$default((File)file, (boolean)false, (int)1, null);
    }

    public static final Sink sink(File file, boolean bl) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter((Object)file, (String)"<this>");
        return Okio.sink((OutputStream)new FileOutputStream(file, bl));
    }

    public static final Sink sink(OutputStream outputStream) {
        Intrinsics.checkNotNullParameter((Object)outputStream, (String)"<this>");
        return (Sink)new OutputStreamSink(outputStream, new Timeout());
    }

    public static final Sink sink(Socket closeable) throws IOException {
        Intrinsics.checkNotNullParameter((Object)closeable, (String)"<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(closeable);
        closeable = closeable.getOutputStream();
        Intrinsics.checkNotNullExpressionValue((Object)closeable, (String)"getOutputStream()");
        return socketAsyncTimeout.sink((Sink)new OutputStreamSink((OutputStream)closeable, (Timeout)socketAsyncTimeout));
    }

    public static final Sink sink(java.nio.file.Path object, OpenOption ... openOptionArray) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)openOptionArray, (String)"options");
        object = Files.newOutputStream((java.nio.file.Path)object, Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"newOutputStream(this, *options)");
        return Okio.sink((OutputStream)object);
    }

    public static /* synthetic */ Sink sink$default(File file, boolean bl, int n, Object object) throws FileNotFoundException {
        if ((n & 1) == 0) return Okio.sink((File)file, (boolean)bl);
        bl = false;
        return Okio.sink((File)file, (boolean)bl);
    }

    public static final Source source(File file) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter((Object)file, (String)"<this>");
        return (Source)new InputStreamSource((InputStream)new FileInputStream(file), Timeout.NONE);
    }

    public static final Source source(InputStream inputStream) {
        Intrinsics.checkNotNullParameter((Object)inputStream, (String)"<this>");
        return (Source)new InputStreamSource(inputStream, new Timeout());
    }

    public static final Source source(Socket closeable) throws IOException {
        Intrinsics.checkNotNullParameter((Object)closeable, (String)"<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(closeable);
        closeable = closeable.getInputStream();
        Intrinsics.checkNotNullExpressionValue((Object)closeable, (String)"getInputStream()");
        return socketAsyncTimeout.source((Source)new InputStreamSource((InputStream)closeable, (Timeout)socketAsyncTimeout));
    }

    public static final Source source(java.nio.file.Path object, OpenOption ... openOptionArray) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)openOptionArray, (String)"options");
        object = Files.newInputStream((java.nio.file.Path)object, Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"newInputStream(this, *options)");
        return Okio.source((InputStream)object);
    }
}
