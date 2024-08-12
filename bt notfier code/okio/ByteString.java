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
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okio.Buffer
 *  okio.ByteString$Companion
 *  okio._Base64Kt
 *  okio._JvmPlatformKt
 *  okio._UtilKt
 *  okio.internal._ByteStringKt
 */
package okio;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.ByteString;
import okio._Base64Kt;
import okio._JvmPlatformKt;
import okio._UtilKt;
import okio.internal._ByteStringKt;

@Metadata(d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 ]2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001]B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0011\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002J,\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J\u0015\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0010H\u0010\u00a2\u0006\u0002\b#J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0000J\u0013\u0010'\u001a\u00020%2\b\u0010\u001a\u001a\u0004\u0018\u00010(H\u0096\u0002J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\tH\u0087\u0002\u00a2\u0006\u0002\b,J\u0015\u0010,\u001a\u00020*2\u0006\u0010+\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b-J\r\u0010.\u001a\u00020\tH\u0010\u00a2\u0006\u0002\b/J\b\u0010\b\u001a\u00020\tH\u0016J\b\u00100\u001a\u00020\u0010H\u0016J\u001d\u00101\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u0000H\u0010\u00a2\u0006\u0002\b3J\u0010\u00104\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0016J\u0010\u00105\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0016J\u0010\u00106\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0016J\u001a\u00107\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\tH\u0017J\u001a\u00107\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00108\u001a\u00020\tH\u0007J\r\u00109\u001a\u00020\u0004H\u0010\u00a2\u0006\u0002\b:J\u0015\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020\tH\u0010\u00a2\u0006\u0002\b=J\u001a\u0010>\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\tH\u0017J\u001a\u0010>\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00108\u001a\u00020\tH\u0007J\u0006\u0010?\u001a\u00020\u0000J(\u0010@\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J(\u0010@\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J\u0010\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020DH\u0002J\u0006\u0010E\u001a\u00020\u0000J\u0006\u0010F\u001a\u00020\u0000J\u0006\u0010G\u001a\u00020\u0000J\r\u0010\u000e\u001a\u00020\tH\u0007\u00a2\u0006\u0002\bHJ\u000e\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020\u0004J\u000e\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020\u0000J\u0010\u0010K\u001a\u00020\u00102\u0006\u0010L\u001a\u00020MH\u0016J\u001c\u0010N\u001a\u00020\u00002\b\b\u0002\u0010O\u001a\u00020\t2\b\b\u0002\u0010P\u001a\u00020\tH\u0017J\b\u0010Q\u001a\u00020\u0000H\u0016J\b\u0010R\u001a\u00020\u0000H\u0016J\b\u0010S\u001a\u00020\u0004H\u0016J\b\u0010T\u001a\u00020\u0010H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010U\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020WH\u0016J%\u0010U\u001a\u00020\u001c2\u0006\u0010X\u001a\u00020Y2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0010\u00a2\u0006\u0002\bZJ\u0010\u0010[\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020\\H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\t8G\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006^"}, d2={"Lokio/ByteString;", "Ljava/io/Serializable;", "", "data", "", "([B)V", "getData$okio", "()[B", "hashCode", "", "getHashCode$okio", "()I", "setHashCode$okio", "(I)V", "size", "utf8", "", "getUtf8$okio", "()Ljava/lang/String;", "setUtf8$okio", "(Ljava/lang/String;)V", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "base64Url", "compareTo", "other", "copyInto", "", "offset", "target", "targetOffset", "byteCount", "digest", "algorithm", "digest$okio", "endsWith", "", "suffix", "equals", "", "get", "", "index", "getByte", "-deprecated_getByte", "getSize", "getSize$okio", "hex", "hmac", "key", "hmac$okio", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "pos", "internalGet$okio", "lastIndexOf", "md5", "rangeEquals", "otherOffset", "readObject", "in", "Ljava/io/ObjectInputStream;", "sha1", "sha256", "sha512", "-deprecated_size", "startsWith", "prefix", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeObject", "Ljava/io/ObjectOutputStream;", "Companion", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public class ByteString
implements Serializable,
Comparable<ByteString> {
    public static final Companion Companion = new Companion(null);
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1L;
    private final byte[] data;
    private transient int hashCode;
    private transient String utf8;

    public ByteString(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"data");
        this.data = byArray;
    }

    public static /* synthetic */ void copyInto$default(ByteString byteString, int n, byte[] byArray, int n2, int n3, int n4, Object object) {
        if (object != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
        if ((n4 & 1) != 0) {
            n = 0;
        }
        if ((n4 & 4) != 0) {
            n2 = 0;
        }
        byteString.copyInto(n, byArray, n2, n3);
    }

    @JvmStatic
    public static final ByteString decodeBase64(String string) {
        return Companion.decodeBase64(string);
    }

    @JvmStatic
    public static final ByteString decodeHex(String string) {
        return Companion.decodeHex(string);
    }

    @JvmStatic
    public static final ByteString encodeString(String string, Charset charset) {
        return Companion.encodeString(string, charset);
    }

    @JvmStatic
    public static final ByteString encodeUtf8(String string) {
        return Companion.encodeUtf8(string);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int n, int n2, Object object) {
        if (object != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        if ((n2 & 2) == 0) return byteString.indexOf(byteString2, n);
        n = 0;
        return byteString.indexOf(byteString2, n);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] byArray, int n, int n2, Object object) {
        if (object != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        if ((n2 & 2) == 0) return byteString.indexOf(byArray, n);
        n = 0;
        return byteString.indexOf(byArray, n);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int n, int n2, Object object) {
        if (object != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        if ((n2 & 2) == 0) return byteString.lastIndexOf(byteString2, n);
        n = _UtilKt.getDEFAULT__ByteString_size();
        return byteString.lastIndexOf(byteString2, n);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] byArray, int n, int n2, Object object) {
        if (object != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        if ((n2 & 2) == 0) return byteString.lastIndexOf(byArray, n);
        n = _UtilKt.getDEFAULT__ByteString_size();
        return byteString.lastIndexOf(byArray, n);
    }

    @JvmStatic
    public static final ByteString of(ByteBuffer byteBuffer) {
        return Companion.of(byteBuffer);
    }

    @JvmStatic
    public static final ByteString of(byte ... byArray) {
        return Companion.of(byArray);
    }

    @JvmStatic
    public static final ByteString of(byte[] byArray, int n, int n2) {
        return Companion.of(byArray, n, n2);
    }

    @JvmStatic
    public static final ByteString read(InputStream inputStream, int n) throws IOException {
        return Companion.read(inputStream, n);
    }

    private final void readObject(ObjectInputStream object) throws IOException {
        int n = ((ObjectInputStream)object).readInt();
        object = Companion.read((InputStream)object, n);
        Field field = ByteString.class.getDeclaredField("data");
        field.setAccessible(true);
        field.set(this, ((ByteString)object).data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int n, int n2, int n3, Object object) {
        if (object != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        if ((n3 & 1) != 0) {
            n = 0;
        }
        if ((n3 & 2) == 0) return byteString.substring(n, n2);
        n2 = _UtilKt.getDEFAULT__ByteString_size();
        return byteString.substring(n, n2);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to operator function", replaceWith=@ReplaceWith(expression="this[index]", imports={}))
    public final byte _deprecated_getByte(int n) {
        return this.getByte(n);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="size", imports={}))
    public final int _deprecated_size() {
        return this.size();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue((Object)byteBuffer, (String)"wrap(data).asReadOnlyBuffer()");
        return byteBuffer;
    }

    public String base64() {
        return _Base64Kt.encodeBase64$default((byte[])this.getData$okio(), null, (int)1, null);
    }

    public String base64Url() {
        return _Base64Kt.encodeBase64((byte[])this.getData$okio(), (byte[])_Base64Kt.getBASE64_URL_SAFE());
    }

    /*
     * Enabled force condition propagation
     */
    @Override
    public int compareTo(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"other");
        int n = this.size();
        int n2 = byteString.size();
        int n3 = Math.min(n, n2);
        int n4 = 0;
        for (int i = 0; i < n3; ++i) {
            int n5;
            int n6 = this.getByte(i) & 0xFF;
            if (n6 == (n5 = byteString.getByte(i) & 0xFF)) {
                continue;
            }
            if (n6 >= n5) return 1;
            return -1;
        }
        if (n == n2) {
            return n4;
        }
        if (n >= n2) return 1;
        return -1;
    }

    public void copyInto(int n, byte[] byArray, int n2, int n3) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"target");
        ArraysKt.copyInto((byte[])this.getData$okio(), (byte[])byArray, (int)n2, (int)n, (int)(n3 + n));
    }

    public ByteString digest$okio(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"algorithm");
        object = MessageDigest.getInstance((String)object);
        ((MessageDigest)object).update(this.getData$okio(), 0, this.size());
        object = ((MessageDigest)object).digest();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"digestBytes");
        return new ByteString((byte[])object);
    }

    public final boolean endsWith(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"suffix");
        return this.rangeEquals(this.size() - byteString.size(), byteString, 0, byteString.size());
    }

    public final boolean endsWith(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"suffix");
        return this.rangeEquals(this.size() - byArray.length, byArray, 0, byArray.length);
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this || object instanceof ByteString && ((ByteString)(object = (ByteString)object)).size() == this.getData$okio().length && ((ByteString)object).rangeEquals(0, this.getData$okio(), 0, this.getData$okio().length)) return bl;
        bl = false;
        return bl;
    }

    public final byte getByte(int n) {
        return this.internalGet$okio(n);
    }

    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return this.getData$okio().length;
    }

    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int n = this.getHashCode$okio();
        if (n != 0) return n;
        n = Arrays.hashCode(this.getData$okio());
        this.setHashCode$okio(n);
        return n;
    }

    public String hex() {
        char[] cArray = new char[this.getData$okio().length * 2];
        byte[] byArray = this.getData$okio();
        int n = byArray.length;
        int n2 = 0;
        int n3 = 0;
        while (n2 < n) {
            byte by = byArray[n2];
            ++n2;
            int n4 = n3 + 1;
            cArray[n3] = _ByteStringKt.getHEX_DIGIT_CHARS()[by >> 4 & 0xF];
            n3 = n4 + 1;
            cArray[n4] = _ByteStringKt.getHEX_DIGIT_CHARS()[by & 0xF];
        }
        return StringsKt.concatToString((char[])cArray);
    }

    public ByteString hmac$okio(String object, ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"algorithm");
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"key");
        try {
            Mac mac = Mac.getInstance((String)object);
            SecretKeySpec secretKeySpec = new SecretKeySpec(byteString.toByteArray(), (String)object);
            mac.init(secretKeySpec);
            object = mac.doFinal(this.data);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"mac.doFinal(data)");
            object = new ByteString((byte[])object);
            return object;
        }
        catch (InvalidKeyException invalidKeyException) {
            throw new IllegalArgumentException(invalidKeyException);
        }
    }

    public ByteString hmacSha1(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"key");
        return this.hmac$okio("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"key");
        return this.hmac$okio("HmacSHA256", byteString);
    }

    public ByteString hmacSha512(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"key");
        return this.hmac$okio("HmacSHA512", byteString);
    }

    public final int indexOf(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"other");
        return ByteString.indexOf$default(this, byteString, 0, 2, null);
    }

    public final int indexOf(ByteString byteString, int n) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"other");
        return this.indexOf(byteString.internalArray$okio(), n);
    }

    public final int indexOf(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"other");
        return ByteString.indexOf$default(this, byArray, 0, 2, null);
    }

    /*
     * Enabled force condition propagation
     */
    public int indexOf(byte[] byArray, int n) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"other");
        int n2 = this.getData$okio().length - byArray.length;
        n = Math.max(n, 0);
        if (n > n2) return -1;
        while (!_UtilKt.arrayRangeEquals((byte[])this.getData$okio(), (int)n, (byte[])byArray, (int)0, (int)byArray.length)) {
            if (n == n2) return -1;
            ++n;
        }
        return n;
    }

    public byte[] internalArray$okio() {
        return this.getData$okio();
    }

    public byte internalGet$okio(int n) {
        return this.getData$okio()[n];
    }

    public final int lastIndexOf(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"other");
        return ByteString.lastIndexOf$default(this, byteString, 0, 2, null);
    }

    public final int lastIndexOf(ByteString byteString, int n) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"other");
        return this.lastIndexOf(byteString.internalArray$okio(), n);
    }

    public final int lastIndexOf(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"other");
        return ByteString.lastIndexOf$default(this, byArray, 0, 2, null);
    }

    public int lastIndexOf(byte[] byArray, int n) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"other");
        n = Math.min(_UtilKt.resolveDefaultParameter((ByteString)this, (int)n), this.getData$okio().length - byArray.length);
        if (n >= 0) {
            while (true) {
                int n2 = n - 1;
                if (_UtilKt.arrayRangeEquals((byte[])this.getData$okio(), (int)n, (byte[])byArray, (int)0, (int)byArray.length)) return n;
                if (n2 < 0) break;
                n = n2;
            }
        }
        n = -1;
        return n;
    }

    public final ByteString md5() {
        return this.digest$okio("MD5");
    }

    public boolean rangeEquals(int n, ByteString byteString, int n2, int n3) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"other");
        return byteString.rangeEquals(n2, this.getData$okio(), n, n3);
    }

    public boolean rangeEquals(int n, byte[] byArray, int n2, int n3) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"other");
        boolean bl = n >= 0 && n <= this.getData$okio().length - n3 && n2 >= 0 && n2 <= byArray.length - n3 && _UtilKt.arrayRangeEquals((byte[])this.getData$okio(), (int)n, (byte[])byArray, (int)n2, (int)n3);
        return bl;
    }

    public final void setHashCode$okio(int n) {
        this.hashCode = n;
    }

    public final void setUtf8$okio(String string) {
        this.utf8 = string;
    }

    public final ByteString sha1() {
        return this.digest$okio("SHA-1");
    }

    public final ByteString sha256() {
        return this.digest$okio("SHA-256");
    }

    public final ByteString sha512() {
        return this.digest$okio("SHA-512");
    }

    public final int size() {
        return this.getSize$okio();
    }

    public final boolean startsWith(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"prefix");
        return this.rangeEquals(0, byteString, 0, byteString.size());
    }

    public final boolean startsWith(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"prefix");
        return this.rangeEquals(0, byArray, 0, byArray.length);
    }

    public String string(Charset charset) {
        Intrinsics.checkNotNullParameter((Object)charset, (String)"charset");
        return new String(this.data, charset);
    }

    public final ByteString substring() {
        return ByteString.substring$default(this, 0, 0, 3, null);
    }

    public final ByteString substring(int n) {
        return ByteString.substring$default(this, n, 0, 2, null);
    }

    public ByteString substring(int n, int n2) {
        int n3 = _UtilKt.resolveDefaultParameter((ByteString)this, (int)n2);
        int n4 = 1;
        n2 = n >= 0 ? 1 : 0;
        if (n2 == 0) throw (Throwable)new IllegalArgumentException("beginIndex < 0".toString());
        n2 = n3 <= this.getData$okio().length ? 1 : 0;
        if (n2 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("endIndex > length(");
            stringBuilder.append(this.getData$okio().length);
            stringBuilder.append(')');
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString().toString());
        }
        n2 = n3 - n >= 0 ? n4 : 0;
        if (n2 == 0) throw (Throwable)new IllegalArgumentException("endIndex < beginIndex".toString());
        ByteString byteString = n == 0 && n3 == this.getData$okio().length ? this : new ByteString(ArraysKt.copyOfRange((byte[])this.getData$okio(), (int)n, (int)n3));
        return byteString;
    }

    public ByteString toAsciiLowercase() {
        Object object;
        block3: {
            Object object2;
            byte by;
            byte by2;
            int n;
            block2: {
                for (n = 0; n < this.getData$okio().length; ++n) {
                    byte by3 = this.getData$okio()[n];
                    if (by3 < (by2 = (byte)65) || by3 > (by = (byte)90)) continue;
                    object = this.getData$okio();
                    object = Arrays.copyOf((byte[])object, ((Object)object).length);
                    Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.util.Arrays.copyOf(this, size)");
                    object2 = n + 1;
                    object[n] = (byte)(by3 + 32);
                    break block2;
                }
                object = this;
                break block3;
            }
            for (n = object2; n < ((Object)object).length; ++n) {
                object2 = object[n];
                if (object2 < by2 || object2 > by) continue;
                object[n] = (byte)(object2 + 32);
            }
            object = new ByteString((byte[])object);
        }
        return object;
    }

    public ByteString toAsciiUppercase() {
        Object object;
        block3: {
            Object object2;
            byte by;
            byte by2;
            int n;
            block2: {
                for (n = 0; n < this.getData$okio().length; ++n) {
                    byte by3 = this.getData$okio()[n];
                    if (by3 < (by2 = (byte)97) || by3 > (by = (byte)122)) continue;
                    object = this.getData$okio();
                    object = Arrays.copyOf((byte[])object, ((Object)object).length);
                    Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.util.Arrays.copyOf(this, size)");
                    object2 = n + 1;
                    object[n] = (byte)(by3 - 32);
                    break block2;
                }
                object = this;
                break block3;
            }
            for (n = object2; n < ((Object)object).length; ++n) {
                object2 = object[n];
                if (object2 < by2 || object2 > by) continue;
                object[n] = (byte)(object2 - 32);
            }
            object = new ByteString((byte[])object);
        }
        return object;
    }

    public byte[] toByteArray() {
        byte[] byArray = this.getData$okio();
        byArray = Arrays.copyOf(byArray, byArray.length);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"java.util.Arrays.copyOf(this, size)");
        return byArray;
    }

    public String toString() {
        Object object;
        int n = this.getData$okio().length;
        int n2 = 1;
        if ((n = n == 0 ? 1 : 0) != 0) {
            object = "[size=0]";
        } else {
            n = _ByteStringKt.access$codePointIndexToCharIndex((byte[])this.getData$okio(), (int)64);
            if (n == -1) {
                if (this.getData$okio().length <= 64) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("[hex=");
                    ((StringBuilder)object).append(this.hex());
                    ((StringBuilder)object).append(']');
                    object = ((StringBuilder)object).toString();
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("[size=");
                    stringBuilder.append(this.getData$okio().length);
                    stringBuilder.append(" hex=");
                    int n3 = _UtilKt.resolveDefaultParameter((ByteString)this, (int)64);
                    n = n3 <= this.getData$okio().length ? 1 : 0;
                    if (n == 0) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("endIndex > length(");
                        stringBuilder2.append(this.getData$okio().length);
                        stringBuilder2.append(')');
                        throw (Throwable)new IllegalArgumentException(stringBuilder2.toString().toString());
                    }
                    n = n3 + 0 >= 0 ? n2 : 0;
                    if (n == 0) throw (Throwable)new IllegalArgumentException("endIndex < beginIndex".toString());
                    object = n3 == this.getData$okio().length ? this : new ByteString(ArraysKt.copyOfRange((byte[])this.getData$okio(), (int)0, (int)n3));
                    stringBuilder.append(((ByteString)object).hex());
                    stringBuilder.append("\u2026]");
                    object = stringBuilder.toString();
                }
            } else {
                CharSequence charSequence = this.utf8();
                if (charSequence == null) {
                    NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    throw nullPointerException;
                }
                object = ((String)charSequence).substring(0, n);
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                object = StringsKt.replace$default((String)StringsKt.replace$default((String)StringsKt.replace$default((String)object, (String)"\\", (String)"\\\\", (boolean)false, (int)4, null), (String)"\n", (String)"\\n", (boolean)false, (int)4, null), (String)"\r", (String)"\\r", (boolean)false, (int)4, null);
                if (n < ((String)charSequence).length()) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("[size=");
                    ((StringBuilder)charSequence).append(this.getData$okio().length);
                    ((StringBuilder)charSequence).append(" text=");
                    ((StringBuilder)charSequence).append((String)object);
                    ((StringBuilder)charSequence).append("\u2026]");
                    object = ((StringBuilder)charSequence).toString();
                } else {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("[text=");
                    ((StringBuilder)charSequence).append((String)object);
                    ((StringBuilder)charSequence).append(']');
                    object = ((StringBuilder)charSequence).toString();
                }
            }
        }
        return object;
    }

    public String utf8() {
        String string;
        String string2 = string = this.getUtf8$okio();
        if (string != null) return string2;
        string2 = _JvmPlatformKt.toUtf8String((byte[])this.internalArray$okio());
        this.setUtf8$okio(string2);
        return string2;
    }

    public void write(OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter((Object)outputStream, (String)"out");
        outputStream.write(this.data);
    }

    public void write$okio(Buffer buffer, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        _ByteStringKt.commonWrite((ByteString)this, (Buffer)buffer, (int)n, (int)n2);
    }
}
