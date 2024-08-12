/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.yalantis.ucrop.util.ImageHeaderParser$Reader
 */
package com.yalantis.ucrop.util;

import com.yalantis.ucrop.util.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;

private static class ImageHeaderParser.StreamReader
implements ImageHeaderParser.Reader {
    private final InputStream is;

    public ImageHeaderParser.StreamReader(InputStream inputStream) {
        this.is = inputStream;
    }

    public int getUInt16() throws IOException {
        return this.is.read() << 8 & 0xFF00 | this.is.read() & 0xFF;
    }

    public short getUInt8() throws IOException {
        return (short)(this.is.read() & 0xFF);
    }

    public int read(byte[] byArray, int n) throws IOException {
        int n2 = n;
        while (n2 > 0) {
            int n3 = this.is.read(byArray, n - n2, n2);
            if (n3 == -1) return n - n2;
            n2 -= n3;
        }
        return n - n2;
    }

    public long skip(long l) throws IOException {
        if (l < 0L) {
            return 0L;
        }
        long l2 = l;
        while (l2 > 0L) {
            long l3 = this.is.skip(l2);
            if (l3 <= 0L) {
                if (this.is.read() == -1) {
                    return l - l2;
                }
                l3 = 1L;
            }
            l2 -= l3;
        }
        return l - l2;
    }
}
