/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.disklrucache.Util
 */
package com.bumptech.glide.disklrucache;

import com.bumptech.glide.disklrucache.Util;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

class StrictLineReader
implements Closeable {
    private static final byte CR = 13;
    private static final byte LF = 10;
    private byte[] buf;
    private final Charset charset;
    private int end;
    private final InputStream in;
    private int pos;

    public StrictLineReader(InputStream inputStream, int n, Charset charset) {
        if (inputStream == null) throw null;
        if (charset == null) throw null;
        if (n < 0) throw new IllegalArgumentException("capacity <= 0");
        if (!charset.equals(Util.US_ASCII)) throw new IllegalArgumentException("Unsupported encoding");
        this.in = inputStream;
        this.charset = charset;
        this.buf = new byte[n];
    }

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    static /* synthetic */ Charset access$000(StrictLineReader strictLineReader) {
        return strictLineReader.charset;
    }

    private void fillBuf() throws IOException {
        InputStream inputStream = this.in;
        byte[] byArray = this.buf;
        int n = inputStream.read(byArray, 0, byArray.length);
        if (n == -1) throw new EOFException();
        this.pos = 0;
        this.end = n;
    }

    @Override
    public void close() throws IOException {
        InputStream inputStream = this.in;
        synchronized (inputStream) {
            if (this.buf == null) return;
            this.buf = null;
            this.in.close();
            return;
        }
    }

    public boolean hasUnterminatedLine() {
        boolean bl = this.end == -1;
        return bl;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public String readLine() throws IOException {
        var3_1 = this.in;
        synchronized (var3_1) {
            try {
                if (this.buf == null) ** GOTO lbl34
                if (this.pos < this.end) ** GOTO lbl10
                this.fillBuf();
                ** GOTO lbl10
            }
            catch (Throwable var4_6) {
lbl10:
                // 3 sources

                for (var1_2 = this.pos; var1_2 != this.end; ++var1_2) {
                    if (this.buf[var1_2] != 10) continue;
                    if (var1_2 != this.pos && (var4_3 /* !! */  = this.buf)[var2_7 = var1_2 - 1] == 13) ** GOTO lbl-1000
                    var2_7 = var1_2;
lbl-1000:
                    // 2 sources

                    {
                        var4_3 /* !! */  = (byte[])new String;
                        var4_3 /* !! */ (this.buf, this.pos, var2_7 - this.pos, this.charset.name());
                        this.pos = var1_2 + 1;
                        return var4_3 /* !! */ ;
                    }
                }
                {
                    var4_4 /* !! */  = new /* Unavailable Anonymous Inner Class!! */;
                    block7: while (true) {
                        var4_4 /* !! */ .write(this.buf, this.pos, this.end - this.pos);
                        this.end = -1;
                        this.fillBuf();
                        var1_2 = this.pos;
                        while (true) {
                            if (var1_2 == this.end) continue block7;
                            if (this.buf[var1_2] == 10) {
                                if (var1_2 != this.pos) {
                                    var4_4 /* !! */ .write(this.buf, this.pos, var1_2 - this.pos);
                                }
                                this.pos = var1_2 + 1;
                                var4_4 /* !! */  = var4_4 /* !! */ .toString();
                                return var4_4 /* !! */ ;
                            }
                            ++var1_2;
                        }
                        break;
                    }
                }
lbl34:
                // 1 sources

                var4_5 = new IOException("LineReader is closed");
                throw var4_5;
                throw var4_6;
            }
        }
    }
}
