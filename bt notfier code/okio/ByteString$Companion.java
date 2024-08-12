/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Charsets
 *  okio.ByteString
 *  okio._Base64Kt
 *  okio._JvmPlatformKt
 *  okio._UtilKt
 *  okio.internal._ByteStringKt
 */
package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.ByteString;
import okio._Base64Kt;
import okio._JvmPlatformKt;
import okio._UtilKt;
import okio.internal._ByteStringKt;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u00a2\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0007\u00a2\u0006\u0002\b\u0016J\u0014\u0010\u0013\u001a\u00020\u00042\n\u0010\u0017\u001a\u00020\u0018\"\u00020\u0019H\u0007J%\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007\u00a2\u0006\u0002\b\u0016J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007\u00a2\u0006\u0002\b!J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\tH\u0007J\f\u0010\u000b\u001a\u00020\u0004*\u00020\tH\u0007J\u001b\u0010\"\u001a\u00020\u0004*\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007\u00a2\u0006\u0002\b\rJ\f\u0010\u0011\u001a\u00020\u0004*\u00020\tH\u0007J\u0019\u0010#\u001a\u00020\u0004*\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007\u00a2\u0006\u0002\b\u001eJ\u0011\u0010$\u001a\u00020\u0004*\u00020\u0015H\u0007\u00a2\u0006\u0002\b\u0013J%\u0010$\u001a\u00020\u0004*\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007\u00a2\u0006\u0002\b\u0013R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2={"Lokio/ByteString$Companion;", "", "()V", "EMPTY", "Lokio/ByteString;", "serialVersionUID", "", "decodeBase64", "string", "", "-deprecated_decodeBase64", "decodeHex", "-deprecated_decodeHex", "encodeString", "charset", "Ljava/nio/charset/Charset;", "-deprecated_encodeString", "encodeUtf8", "-deprecated_encodeUtf8", "of", "buffer", "Ljava/nio/ByteBuffer;", "-deprecated_of", "data", "", "", "array", "offset", "", "byteCount", "read", "inputstream", "Ljava/io/InputStream;", "-deprecated_read", "encode", "readByteString", "toByteString", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public static final class ByteString.Companion {
    private ByteString.Companion() {
    }

    public /* synthetic */ ByteString.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ ByteString encodeString$default(ByteString.Companion companion, String string, Charset charset, int n, Object object) {
        if ((n & 1) == 0) return companion.encodeString(string, charset);
        charset = Charsets.UTF_8;
        return companion.encodeString(string, charset);
    }

    public static /* synthetic */ ByteString of$default(ByteString.Companion companion, byte[] byArray, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = 0;
        }
        if ((n3 & 2) == 0) return companion.of(byArray, n, n2);
        n2 = byArray.length;
        return companion.of(byArray, n, n2);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="string.decodeBase64()", imports={"okio.ByteString.Companion.decodeBase64"}))
    public final ByteString _deprecated_decodeBase64(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"string");
        return this.decodeBase64(string);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="string.decodeHex()", imports={"okio.ByteString.Companion.decodeHex"}))
    public final ByteString _deprecated_decodeHex(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"string");
        return this.decodeHex(string);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="string.encode(charset)", imports={"okio.ByteString.Companion.encode"}))
    public final ByteString _deprecated_encodeString(String string, Charset charset) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"string");
        Intrinsics.checkNotNullParameter((Object)charset, (String)"charset");
        return this.encodeString(string, charset);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="string.encodeUtf8()", imports={"okio.ByteString.Companion.encodeUtf8"}))
    public final ByteString _deprecated_encodeUtf8(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"string");
        return this.encodeUtf8(string);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="buffer.toByteString()", imports={"okio.ByteString.Companion.toByteString"}))
    public final ByteString _deprecated_of(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"buffer");
        return this.of(byteBuffer);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="array.toByteString(offset, byteCount)", imports={"okio.ByteString.Companion.toByteString"}))
    public final ByteString _deprecated_of(byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"array");
        return this.of(byArray, n, n2);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="inputstream.readByteString(byteCount)", imports={"okio.ByteString.Companion.readByteString"}))
    public final ByteString _deprecated_read(InputStream inputStream, int n) {
        Intrinsics.checkNotNullParameter((Object)inputStream, (String)"inputstream");
        return this.read(inputStream, n);
    }

    @JvmStatic
    public final ByteString decodeBase64(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        object = _Base64Kt.decodeBase64ToArray((String)object);
        object = object != null ? new ByteString((byte[])object) : null;
        return object;
    }

    @JvmStatic
    public final ByteString decodeHex(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        int n = ((String)object).length();
        int n2 = 0;
        n = n % 2 == 0 ? 1 : 0;
        if (n == 0) {
            object = new IllegalArgumentException(Intrinsics.stringPlus((String)"Unexpected hex string: ", (Object)object).toString());
            throw object;
        }
        n = ((String)object).length() / 2;
        byte[] byArray = new byte[n];
        int n3 = n - 1;
        if (n3 < 0) return new ByteString(byArray);
        n = n2;
        while (true) {
            n2 = n + 1;
            int n4 = n * 2;
            byArray[n] = (byte)((_ByteStringKt.access$decodeHexDigit((char)((String)object).charAt(n4)) << 4) + _ByteStringKt.access$decodeHexDigit((char)((String)object).charAt(n4 + 1)));
            if (n2 > n3) {
                return new ByteString(byArray);
            }
            n = n2;
        }
    }

    @JvmStatic
    public final ByteString encodeString(String object, Charset charset) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)charset, (String)"charset");
        object = ((String)object).getBytes(charset);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.String).getBytes(charset)");
        return new ByteString((byte[])object);
    }

    @JvmStatic
    public final ByteString encodeUtf8(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray((String)string));
        byteString.setUtf8$okio(string);
        return byteString;
    }

    @JvmStatic
    public final ByteString of(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"<this>");
        byte[] byArray = new byte[byteBuffer.remaining()];
        byteBuffer.get(byArray);
        return new ByteString(byArray);
    }

    @JvmStatic
    public final ByteString of(byte ... byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"data");
        byArray = Arrays.copyOf(byArray, byArray.length);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"java.util.Arrays.copyOf(this, size)");
        return new ByteString(byArray);
    }

    @JvmStatic
    public final ByteString of(byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"<this>");
        _UtilKt.checkOffsetAndCount((long)byArray.length, (long)n, (long)n2);
        return new ByteString(ArraysKt.copyOfRange((byte[])byArray, (int)n, (int)(n2 + n)));
    }

    @JvmStatic
    public final ByteString read(InputStream object, int n) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        int n2 = 0;
        int n3 = n >= 0 ? 1 : 0;
        if (n3 == 0) {
            object = new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount < 0: ", (Object)n).toString());
            throw object;
        }
        byte[] byArray = new byte[n];
        n3 = n2;
        while (n3 < n) {
            n2 = ((InputStream)object).read(byArray, n3, n - n3);
            if (n2 == -1) throw new EOFException();
            n3 += n2;
        }
        return new ByteString(byArray);
    }
}
