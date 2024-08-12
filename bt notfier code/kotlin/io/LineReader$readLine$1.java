/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.io.LineReader
 *  kotlin.jvm.internal.MutablePropertyReference0Impl
 */
package kotlin.io;

import java.nio.charset.CharsetDecoder;
import kotlin.Metadata;
import kotlin.io.LineReader;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(k=3, mv={1, 5, 1})
final class LineReader$readLine$1
extends MutablePropertyReference0Impl {
    LineReader$readLine$1(LineReader lineReader) {
        super((Object)lineReader, LineReader.class, "decoder", "getDecoder()Ljava/nio/charset/CharsetDecoder;", 0);
    }

    public Object get() {
        return LineReader.access$getDecoder$p((LineReader)((LineReader)this.receiver));
    }

    public void set(Object object) {
        LineReader.access$setDecoder$p((LineReader)((LineReader)this.receiver), (CharsetDecoder)((CharsetDecoder)object));
    }
}
