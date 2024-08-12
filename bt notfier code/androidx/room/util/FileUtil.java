/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package androidx.room.util;

import android.os.Build;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class FileUtil {
    private FileUtil() {
    }

    public static void copy(ReadableByteChannel readableByteChannel, FileChannel fileChannel) throws IOException {
        try {
            if (Build.VERSION.SDK_INT > 23) {
                fileChannel.transferFrom(readableByteChannel, 0L, Long.MAX_VALUE);
            } else {
                int n;
                InputStream inputStream = Channels.newInputStream(readableByteChannel);
                OutputStream outputStream = Channels.newOutputStream(fileChannel);
                byte[] byArray = new byte[4096];
                while ((n = inputStream.read(byArray)) > 0) {
                    outputStream.write(byArray, 0, n);
                }
            }
            fileChannel.force(false);
        }
        finally {
            readableByteChannel.close();
            fileChannel.close();
        }
    }
}
