/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.io;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2={"Lkotlin/io/LineReader;", "", "()V", "BUFFER_SIZE", "", "byteBuf", "Ljava/nio/ByteBuffer;", "bytes", "", "charBuf", "Ljava/nio/CharBuffer;", "chars", "", "decoder", "Ljava/nio/charset/CharsetDecoder;", "directEOL", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "compactBytes", "decode", "endOfInput", "decodeEndOfInput", "nBytes", "nChars", "readLine", "", "inputStream", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "resetAll", "", "trimStringBuilder", "updateCharset", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class LineReader {
    private static final int BUFFER_SIZE = 32;
    public static final LineReader INSTANCE = new LineReader();
    private static final ByteBuffer byteBuf;
    private static final byte[] bytes;
    private static final CharBuffer charBuf;
    private static final char[] chars;
    private static CharsetDecoder decoder;
    private static boolean directEOL;
    private static final StringBuilder sb;

    static {
        Object object = new byte[32];
        bytes = object;
        chars = new char[32];
        object = ByteBuffer.wrap(object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"ByteBuffer.wrap(bytes)");
        byteBuf = object;
        object = CharBuffer.wrap(chars);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"CharBuffer.wrap(chars)");
        charBuf = object;
        sb = new StringBuilder();
    }

    private LineReader() {
    }

    public static final /* synthetic */ CharsetDecoder access$getDecoder$p(LineReader object) {
        object = decoder;
        if (object != null) return object;
        Intrinsics.throwUninitializedPropertyAccessException((String)"decoder");
        return object;
    }

    public static final /* synthetic */ void access$setDecoder$p(LineReader lineReader, CharsetDecoder charsetDecoder) {
        decoder = charsetDecoder;
    }

    private final int compactBytes() {
        ByteBuffer byteBuffer = byteBuf;
        byteBuffer.compact();
        int n = byteBuffer.position();
        byteBuffer.position(0);
        return n;
    }

    private final int decode(boolean bl) {
        while (true) {
            Object object;
            if ((object = decoder) == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"decoder");
            }
            object = ((CharsetDecoder)object).decode(byteBuf, charBuf, bl);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"decoder.decode(byteBuf, charBuf, endOfInput)");
            if (((CoderResult)object).isError()) {
                this.resetAll();
                ((CoderResult)object).throwException();
            }
            int n = charBuf.position();
            if (!((CoderResult)object).isOverflow()) {
                return n;
            }
            object = sb;
            char[] cArray = chars;
            ((StringBuilder)object).append(cArray, 0, --n);
            charBuf.position(0);
            charBuf.limit(32);
            charBuf.put(chars[n]);
        }
    }

    private final int decodeEndOfInput(int n, int n2) {
        byteBuf.limit(n);
        charBuf.position(n2);
        n = this.decode(true);
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"decoder");
        }
        charsetDecoder.reset();
        byteBuf.position(0);
        return n;
    }

    private final void resetAll() {
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"decoder");
        }
        charsetDecoder.reset();
        byteBuf.position(0);
        sb.setLength(0);
    }

    private final void trimStringBuilder() {
        sb.setLength(32);
        sb.trimToSize();
    }

    private final void updateCharset(Charset object) {
        object = ((Charset)object).newDecoder();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"charset.newDecoder()");
        decoder = object;
        byteBuf.clear();
        charBuf.clear();
        byteBuf.put((byte)10);
        byteBuf.flip();
        object = decoder;
        if (object == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"decoder");
        }
        ByteBuffer byteBuffer = byteBuf;
        CharBuffer charBuffer = charBuf;
        boolean bl = false;
        ((CharsetDecoder)object).decode(byteBuffer, charBuffer, false);
        boolean bl2 = bl;
        if (charBuf.position() == 1) {
            bl2 = bl;
            if (charBuf.get(0) == '\n') {
                bl2 = true;
            }
        }
        directEOL = bl2;
        this.resetAll();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    public final String readLine(InputStream var1_1, Charset var2_3) {
        synchronized (this) {
            block18: {
                block17: {
                    Intrinsics.checkNotNullParameter((Object)var1_1, (String)"inputStream");
                    Intrinsics.checkNotNullParameter((Object)var2_3, (String)"charset");
                    var8_4 = LineReader.decoder;
                    var6_5 = 1;
                    if (var8_4 == null) break block17;
                    var8_4 = LineReader.decoder;
                    if (var8_4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException((String)"decoder");
                    }
                    if (!(Intrinsics.areEqual((Object)var8_4.charset(), (Object)var2_3) ^ true)) break block18;
                }
                this.updateCharset((Charset)var2_3);
            }
            var3_6 = 0;
            var4_7 = 0;
lbl17:
            // 3 sources

            while (true) {
                var7_9 = var1_1.read();
                if (var7_9 != -1) ** GOTO lbl30
                var5_8 = ((CharSequence)LineReader.sb).length();
                var5_8 = var5_8 == 0 ? 1 : 0;
                if (var5_8 != 0 && var3_6 == 0 && var4_7 == 0) {
                }
                ** GOTO lbl-1000
                break;
            }
            return null;
lbl-1000:
            // 1 sources

            {
                var4_7 = this.decodeEndOfInput(var3_6, var4_7);
                ** GOTO lbl45
lbl30:
                // 1 sources

                var2_3 = LineReader.bytes;
                var5_8 = var3_6 + 1;
            }
            var2_3[var3_6] = (byte)var7_9;
            {
                block19: {
                    if (var7_9 == 10 || var5_8 == 32 || !LineReader.directEOL) break block19;
                    var3_6 = var5_8;
                    ** GOTO lbl17
                }
                LineReader.byteBuf.limit(var5_8);
                LineReader.charBuf.position(var4_7);
                var4_7 = this.decode(false);
                if (var4_7 <= 0 || LineReader.chars[var4_7 - 1] != '\n') ** GOTO lbl65
                LineReader.byteBuf.position(0);
lbl45:
                // 2 sources

                var3_6 = var4_7;
                if (var4_7 <= 0) ** GOTO lbl-1000
                var3_6 = var4_7;
                if (LineReader.chars[var4_7 - 1] != '\n') ** GOTO lbl-1000
                var3_6 = --var4_7;
                if (var4_7 <= 0) ** GOTO lbl-1000
                var3_6 = var4_7;
            }
            {
                if (LineReader.chars[var4_7 - 1] != '\r') ** GOTO lbl-1000
                var3_6 = var4_7 - 1;
            }
lbl-1000:
            // 5 sources

            {
                if ((var4_7 = ((CharSequence)LineReader.sb).length() == 0 ? var6_5 : 0) != 0) {
                    var1_1 = new String(LineReader.chars, 0, var3_6);
                    return var1_1;
                }
                LineReader.sb.append(LineReader.chars, 0, var3_6);
                var1_1 = LineReader.sb.toString();
                Intrinsics.checkNotNullExpressionValue((Object)var1_1, (String)"sb.toString()");
                if (LineReader.sb.length() > 32) {
                    this.trimStringBuilder();
                }
                LineReader.sb.setLength(0);
                return var1_1;
lbl65:
                // 1 sources

                var3_6 = this.compactBytes();
                ** continue;
            }
        }
    }
}
