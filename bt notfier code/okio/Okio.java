/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  okio.BufferedSink
 *  okio.BufferedSource
 *  okio.CipherSink
 *  okio.CipherSource
 *  okio.FileSystem
 *  okio.HashingSink
 *  okio.HashingSource
 *  okio.Okio__JvmOkioKt
 *  okio.Okio__OkioKt
 *  okio.Path
 *  okio.Sink
 *  okio.Source
 */
package okio;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.CipherSink;
import okio.CipherSource;
import okio.FileSystem;
import okio.HashingSink;
import okio.HashingSource;
import okio.Okio__JvmOkioKt;
import okio.Okio__OkioKt;
import okio.Path;
import okio.Sink;
import okio.Source;

@Metadata(d1={"okio/Okio__JvmOkioKt", "okio/Okio__OkioKt"}, k=4, mv={1, 5, 1}, xi=48)
public final class Okio {
    public static final Sink appendingSink(File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.appendingSink((File)file);
    }

    public static final FileSystem asResourceFileSystem(ClassLoader classLoader) {
        return Okio__JvmOkioKt.asResourceFileSystem((ClassLoader)classLoader);
    }

    public static final Sink blackhole() {
        return Okio__OkioKt.blackhole();
    }

    public static final BufferedSink buffer(Sink sink) {
        return Okio__OkioKt.buffer((Sink)sink);
    }

    public static final BufferedSource buffer(Source source) {
        return Okio__OkioKt.buffer((Source)source);
    }

    public static final CipherSink cipherSink(Sink sink, Cipher cipher) {
        return Okio__JvmOkioKt.cipherSink((Sink)sink, (Cipher)cipher);
    }

    public static final CipherSource cipherSource(Source source, Cipher cipher) {
        return Okio__JvmOkioKt.cipherSource((Source)source, (Cipher)cipher);
    }

    public static final HashingSink hashingSink(Sink sink, MessageDigest messageDigest) {
        return Okio__JvmOkioKt.hashingSink((Sink)sink, (MessageDigest)messageDigest);
    }

    public static final HashingSink hashingSink(Sink sink, Mac mac) {
        return Okio__JvmOkioKt.hashingSink((Sink)sink, (Mac)mac);
    }

    public static final HashingSource hashingSource(Source source, MessageDigest messageDigest) {
        return Okio__JvmOkioKt.hashingSource((Source)source, (MessageDigest)messageDigest);
    }

    public static final HashingSource hashingSource(Source source, Mac mac) {
        return Okio__JvmOkioKt.hashingSource((Source)source, (Mac)mac);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return Okio__JvmOkioKt.isAndroidGetsocknameError((AssertionError)assertionError);
    }

    public static final FileSystem openZip(FileSystem fileSystem, Path path) throws IOException {
        return Okio__JvmOkioKt.openZip((FileSystem)fileSystem, (Path)path);
    }

    public static final Sink sink(File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink((File)file);
    }

    public static final Sink sink(File file, boolean bl) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink((File)file, (boolean)bl);
    }

    public static final Sink sink(OutputStream outputStream) {
        return Okio__JvmOkioKt.sink((OutputStream)outputStream);
    }

    public static final Sink sink(Socket socket) throws IOException {
        return Okio__JvmOkioKt.sink((Socket)socket);
    }

    public static final Sink sink(java.nio.file.Path path, OpenOption ... openOptionArray) throws IOException {
        return Okio__JvmOkioKt.sink((java.nio.file.Path)path, (OpenOption[])openOptionArray);
    }

    public static /* synthetic */ Sink sink$default(File file, boolean bl, int n, Object object) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink$default((File)file, (boolean)bl, (int)n, (Object)object);
    }

    public static final Source source(File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.source((File)file);
    }

    public static final Source source(InputStream inputStream) {
        return Okio__JvmOkioKt.source((InputStream)inputStream);
    }

    public static final Source source(Socket socket) throws IOException {
        return Okio__JvmOkioKt.source((Socket)socket);
    }

    public static final Source source(java.nio.file.Path path, OpenOption ... openOptionArray) throws IOException {
        return Okio__JvmOkioKt.source((java.nio.file.Path)path, (OpenOption[])openOptionArray);
    }

    public static final <T extends Closeable, R> R use(T t, Function1<? super T, ? extends R> function1) {
        return (R)Okio__OkioKt.use(t, function1);
    }
}
