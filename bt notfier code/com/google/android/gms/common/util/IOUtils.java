/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.ParcelFileDescriptor
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.util;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

@Deprecated
public final class IOUtils {
    private IOUtils() {
    }

    /*
     * Enabled force condition propagation
     */
    public static void closeQuietly(@Nullable ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor == null) return;
        try {
            parcelFileDescriptor.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public static void closeQuietly(@Nullable Closeable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    @Deprecated
    public static long copyStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        return IOUtils.copyStream(inputStream, outputStream, false, 1024);
    }

    @Deprecated
    public static long copyStream(InputStream inputStream, OutputStream outputStream, boolean bl, int n) throws IOException {
        byte[] byArray = new byte[n];
        long l = 0L;
        try {
            int n2;
            while ((n2 = inputStream.read(byArray, 0, n)) != -1) {
                l += (long)n2;
                outputStream.write(byArray, 0, n2);
            }
            if (!bl) return l;
        }
        catch (Throwable throwable) {
            if (!bl) throw throwable;
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
            throw throwable;
        }
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);
        return l;
    }

    public static boolean isGzipByteBuffer(byte[] byArray) {
        if (byArray.length <= 1) return false;
        byte by = byArray[0];
        if (((byArray[1] & 0xFF) << 8 | by & 0xFF) != 35615) return false;
        return true;
    }

    @Deprecated
    public static byte[] readInputStreamFully(InputStream inputStream) throws IOException {
        return IOUtils.readInputStreamFully(inputStream, true);
    }

    @Deprecated
    public static byte[] readInputStreamFully(InputStream inputStream, boolean bl) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.copyStream(inputStream, byteArrayOutputStream, bl, 1024);
        return byteArrayOutputStream.toByteArray();
    }

    @Deprecated
    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Preconditions.checkNotNull((Object)inputStream);
        Preconditions.checkNotNull((Object)byteArrayOutputStream);
        byte[] byArray = new byte[4096];
        int n;
        while ((n = inputStream.read(byArray)) != -1) {
            ((OutputStream)byteArrayOutputStream).write(byArray, 0, n);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
