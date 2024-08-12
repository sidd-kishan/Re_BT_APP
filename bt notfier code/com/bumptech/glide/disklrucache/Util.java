/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.disklrucache;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;

final class Util {
    static final Charset US_ASCII = Charset.forName("US-ASCII");
    static final Charset UTF_8 = Charset.forName("UTF-8");

    private Util() {
    }

    static void closeQuietly(Closeable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Exception exception) {
        }
    }

    static void deleteContents(File object) throws IOException {
        Object object2 = ((File)object).listFiles();
        if (object2 == null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("not a readable directory: ");
            ((StringBuilder)object2).append(object);
            object = new IOException(((StringBuilder)object2).toString());
            throw object;
        }
        int n = ((File[])object2).length;
        int n2 = 0;
        while (n2 < n) {
            object = object2[n2];
            if (((File)object).isDirectory()) {
                Util.deleteContents((File)object);
            }
            if (!((File)object).delete()) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("failed to delete file: ");
                ((StringBuilder)object2).append(object);
                throw new IOException(((StringBuilder)object2).toString());
            }
            ++n2;
        }
    }

    static String readFully(Reader reader) throws IOException {
        Object object;
        try {
            int n;
            object = new StringWriter();
            char[] cArray = new char[1024];
            while ((n = reader.read(cArray)) != -1) {
                ((StringWriter)object).write(cArray, 0, n);
            }
            object = ((StringWriter)object).toString();
        }
        finally {
            reader.close();
        }
        return object;
    }
}
