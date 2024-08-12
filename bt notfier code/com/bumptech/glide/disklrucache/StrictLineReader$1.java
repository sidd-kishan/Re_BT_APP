/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.disklrucache.StrictLineReader
 */
package com.bumptech.glide.disklrucache;

import com.bumptech.glide.disklrucache.StrictLineReader;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/*
 * Exception performing whole class analysis ignored.
 */
class StrictLineReader.1
extends ByteArrayOutputStream {
    final StrictLineReader this$0;

    StrictLineReader.1(StrictLineReader strictLineReader, int n) {
        this.this$0 = strictLineReader;
        super(n);
    }

    @Override
    public String toString() {
        int n = this.count > 0 && this.buf[this.count - 1] == 13 ? this.count - 1 : this.count;
        try {
            String string = new String(this.buf, 0, n, StrictLineReader.access$000((StrictLineReader)this.this$0).name());
            return string;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new AssertionError((Object)unsupportedEncodingException);
        }
    }
}
