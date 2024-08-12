/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.ByteString
 *  okio.Segment
 *  okio._UtilKt
 *  okio.internal._SegmentedByteStringKt
 */
package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio._UtilKt;
import okio.internal._SegmentedByteStringKt;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0015\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0010\u00a2\u0006\u0002\b\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\r\u0010 \u001a\u00020\u0015H\u0010\u00a2\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0015H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\u001d\u0010$\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0001H\u0010\u00a2\u0006\u0002\b&J\u0018\u0010'\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H\u0016J\r\u0010)\u001a\u00020\u0004H\u0010\u00a2\u0006\u0002\b*J\u0015\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0015H\u0010\u00a2\u0006\u0002\b.J\u0018\u0010/\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H\u0016J(\u00100\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J(\u00100\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0015H\u0016J\b\u00108\u001a\u00020\u0001H\u0016J\b\u00109\u001a\u00020\u0001H\u0016J\b\u0010:\u001a\u00020\u0004H\u0016J\b\u0010;\u001a\u00020\u0001H\u0002J\b\u0010<\u001a\u00020\u0010H\u0016J\u0010\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020?H\u0016J%\u0010=\u001a\u00020\u00132\u0006\u0010@\u001a\u00020A2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0010\u00a2\u0006\u0002\bBJ\b\u0010C\u001a\u00020DH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b\u00a8\u0006E"}, d2={"Lokio/SegmentedByteString;", "Lokio/ByteString;", "segments", "", "", "directory", "", "([[B[I)V", "getDirectory$okio", "()[I", "getSegments$okio", "()[[B", "[[B", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "", "base64Url", "copyInto", "", "offset", "", "target", "targetOffset", "byteCount", "digest", "algorithm", "digest$okio", "equals", "", "other", "", "getSize", "getSize$okio", "hashCode", "hex", "hmac", "key", "hmac$okio", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "", "pos", "internalGet$okio", "lastIndexOf", "rangeEquals", "otherOffset", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toByteString", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeReplace", "Ljava/lang/Object;", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class SegmentedByteString
extends ByteString {
    private final transient int[] directory;
    private final transient byte[][] segments;

    public SegmentedByteString(byte[][] byArray, int[] nArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"segments");
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"directory");
        super(ByteString.EMPTY.getData$okio());
        this.segments = byArray;
        this.directory = nArray;
    }

    private final ByteString toByteString() {
        return new ByteString(this.toByteArray());
    }

    private final Object writeReplace() {
        return this.toByteString();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(this.toByteArray()).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue((Object)byteBuffer, (String)"wrap(toByteArray()).asReadOnlyBuffer()");
        return byteBuffer;
    }

    public String base64() {
        return this.toByteString().base64();
    }

    public String base64Url() {
        return this.toByteString().base64Url();
    }

    public void copyInto(int n, byte[] byArray, int n2, int n3) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"target");
        long l = this.size();
        long l2 = n;
        long l3 = n3;
        _UtilKt.checkOffsetAndCount((long)l, (long)l2, (long)l3);
        _UtilKt.checkOffsetAndCount((long)byArray.length, (long)n2, (long)l3);
        int n4 = n3 + n;
        int n5 = _SegmentedByteStringKt.segment((SegmentedByteString)this, (int)n);
        n3 = n;
        n = n5;
        while (n3 < n4) {
            n5 = n == 0 ? 0 : this.getDirectory$okio()[n - 1];
            int n6 = this.getDirectory$okio()[n];
            int n7 = this.getDirectory$okio()[((Object[])this.getSegments$okio()).length + n];
            n6 = Math.min(n4, n6 - n5 + n5) - n3;
            n5 = n7 + (n3 - n5);
            ArraysKt.copyInto((byte[])this.getSegments$okio()[n], (byte[])byArray, (int)n2, (int)n5, (int)(n5 + n6));
            n2 += n6;
            n3 += n6;
            ++n;
        }
    }

    public ByteString digest$okio(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"algorithm");
        object = MessageDigest.getInstance((String)object);
        int n = ((Object[])this.getSegments$okio()).length;
        int n2 = 0;
        int n3 = 0;
        while (true) {
            if (n2 >= n) {
                object = ((MessageDigest)object).digest();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"digestBytes");
                return new ByteString((byte[])object);
            }
            int n4 = this.getDirectory$okio()[n + n2];
            int n5 = this.getDirectory$okio()[n2];
            ((MessageDigest)object).update(this.getSegments$okio()[n2], n4, n5 - n3);
            ++n2;
            n3 = n5;
        }
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this || object instanceof ByteString && (object = (ByteString)object).size() == this.size() && this.rangeEquals(0, (ByteString)object, 0, this.size())) return bl;
        bl = false;
        return bl;
    }

    public final int[] getDirectory$okio() {
        return this.directory;
    }

    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    public int getSize$okio() {
        return this.getDirectory$okio()[((Object[])this.getSegments$okio()).length - 1];
    }

    public int hashCode() {
        int n = this.getHashCode$okio();
        if (n != 0) return n;
        int n2 = ((Object[])this.getSegments$okio()).length;
        n = 1;
        int n3 = 0;
        for (int i = 0; i < n2; ++i) {
            int n4 = this.getDirectory$okio()[n2 + i];
            int n5 = this.getDirectory$okio()[i];
            byte[] byArray = this.getSegments$okio()[i];
            for (int j = n4; j < n5 - n3 + n4; ++j) {
                n = n * 31 + byArray[j];
            }
            n3 = n5;
        }
        this.setHashCode$okio(n);
        return n;
    }

    public String hex() {
        return this.toByteString().hex();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public ByteString hmac$okio(String object, ByteString byteString) {
        Mac mac;
        Intrinsics.checkNotNullParameter((Object)object, (String)"algorithm");
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"key");
        try {
            mac = Mac.getInstance((String)object);
            SecretKeySpec secretKeySpec = new SecretKeySpec(byteString.toByteArray(), (String)object);
            mac.init(secretKeySpec);
            int n = ((Object[])this.getSegments$okio()).length;
            int n2 = 0;
            for (int i = 0; i < n; ++i) {
                int n3 = this.getDirectory$okio()[n + i];
                int n4 = this.getDirectory$okio()[i];
                mac.update(this.getSegments$okio()[i], n3, n4 - n2);
                n2 = n4;
            }
        }
        catch (InvalidKeyException invalidKeyException) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(invalidKeyException);
            throw illegalArgumentException;
        }
        {
            object = mac.doFinal();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"mac.doFinal()");
            object = new ByteString((byte[])object);
            return object;
        }
    }

    public int indexOf(byte[] byArray, int n) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"other");
        return this.toByteString().indexOf(byArray, n);
    }

    public byte[] internalArray$okio() {
        return this.toByteArray();
    }

    public byte internalGet$okio(int n) {
        _UtilKt.checkOffsetAndCount((long)this.getDirectory$okio()[((Object[])this.getSegments$okio()).length - 1], (long)n, (long)1L);
        int n2 = _SegmentedByteStringKt.segment((SegmentedByteString)this, (int)n);
        int n3 = n2 == 0 ? 0 : this.getDirectory$okio()[n2 - 1];
        int n4 = this.getDirectory$okio()[((Object[])this.getSegments$okio()).length + n2];
        return this.getSegments$okio()[n2][n - n3 + n4];
    }

    public int lastIndexOf(byte[] byArray, int n) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"other");
        return this.toByteString().lastIndexOf(byArray, n);
    }

    public boolean rangeEquals(int n, ByteString byteString, int n2, int n3) {
        boolean bl;
        block4: {
            boolean bl2;
            Intrinsics.checkNotNullParameter((Object)byteString, (String)"other");
            bl = bl2 = false;
            if (n < 0) return bl;
            if (n > this.size() - n3) {
                bl = bl2;
            } else {
                int n4 = n3 + n;
                int n5 = _SegmentedByteStringKt.segment((SegmentedByteString)this, (int)n);
                n3 = n2;
                n2 = n;
                n = n5;
                while (n2 < n4) {
                    n5 = n == 0 ? 0 : this.getDirectory$okio()[n - 1];
                    int n6 = this.getDirectory$okio()[n];
                    int n7 = this.getDirectory$okio()[((Object[])this.getSegments$okio()).length + n];
                    n6 = Math.min(n4, n6 - n5 + n5) - n2;
                    if (!byteString.rangeEquals(n3, this.getSegments$okio()[n], n7 + (n2 - n5), n6)) {
                        bl = bl2;
                        break block4;
                    }
                    n3 += n6;
                    n2 += n6;
                    ++n;
                }
                bl = true;
            }
        }
        return bl;
    }

    public boolean rangeEquals(int n, byte[] byArray, int n2, int n3) {
        boolean bl;
        block4: {
            boolean bl2;
            Intrinsics.checkNotNullParameter((Object)byArray, (String)"other");
            bl = bl2 = false;
            if (n < 0) return bl;
            bl = bl2;
            if (n > this.size() - n3) return bl;
            bl = bl2;
            if (n2 < 0) return bl;
            if (n2 > byArray.length - n3) {
                bl = bl2;
            } else {
                int n4 = n3 + n;
                n3 = _SegmentedByteStringKt.segment((SegmentedByteString)this, (int)n);
                while (n < n4) {
                    int n5 = n3 == 0 ? 0 : this.getDirectory$okio()[n3 - 1];
                    int n6 = this.getDirectory$okio()[n3];
                    int n7 = this.getDirectory$okio()[((Object[])this.getSegments$okio()).length + n3];
                    n6 = Math.min(n4, n6 - n5 + n5) - n;
                    if (!_UtilKt.arrayRangeEquals((byte[])this.getSegments$okio()[n3], (int)(n7 + (n - n5)), (byte[])byArray, (int)n2, (int)n6)) {
                        bl = bl2;
                        break block4;
                    }
                    n2 += n6;
                    n += n6;
                    ++n3;
                }
                bl = true;
            }
        }
        return bl;
    }

    public String string(Charset charset) {
        Intrinsics.checkNotNullParameter((Object)charset, (String)"charset");
        return this.toByteString().string(charset);
    }

    public ByteString substring(int n, int n2) {
        Object object = this;
        int n3 = _UtilKt.resolveDefaultParameter((ByteString)object, (int)n2);
        int n4 = 0;
        n2 = n >= 0 ? 1 : 0;
        if (n2 == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("beginIndex=");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(" < 0");
            object = new IllegalArgumentException(((StringBuilder)object).toString().toString());
            throw object;
        }
        n2 = n3 <= this.size() ? 1 : 0;
        if (n2 == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("endIndex=");
            ((StringBuilder)object).append(n3);
            ((StringBuilder)object).append(" > length(");
            ((StringBuilder)object).append(this.size());
            ((StringBuilder)object).append(')');
            throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString().toString());
        }
        int n5 = n3 - n;
        n2 = n5 >= 0 ? 1 : 0;
        if (n2 == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("endIndex=");
            ((StringBuilder)object).append(n3);
            ((StringBuilder)object).append(" < beginIndex=");
            ((StringBuilder)object).append(n);
            throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString().toString());
        }
        if (n == 0 && n3 == this.size()) return object;
        if (n == n3) {
            object = ByteString.EMPTY;
        } else {
            int n6 = _SegmentedByteStringKt.segment((SegmentedByteString)this, (int)n);
            int n7 = _SegmentedByteStringKt.segment((SegmentedByteString)this, (int)(n3 - 1));
            byte[][] byArray = (byte[][])ArraysKt.copyOfRange((Object[])((Object[])this.getSegments$okio()), (int)n6, (int)(n7 + 1));
            object = (Object[])byArray;
            int[] nArray = new int[((Object)object).length * 2];
            if (n6 <= n7) {
                n3 = n6;
                n2 = 0;
                while (true) {
                    nArray[n2] = Math.min(this.getDirectory$okio()[n3] - n, n5);
                    nArray[n2 + ((Object)object).length] = this.getDirectory$okio()[((Object[])this.getSegments$okio()).length + n3];
                    if (n3 == n7) break;
                    ++n3;
                    ++n2;
                }
            }
            n2 = n6 == 0 ? n4 : this.getDirectory$okio()[n6 - 1];
            n3 = ((Object)object).length;
            nArray[n3] = nArray[n3] + (n - n2);
            object = new SegmentedByteString(byArray, nArray);
        }
        return object;
    }

    public ByteString toAsciiLowercase() {
        return this.toByteString().toAsciiLowercase();
    }

    public ByteString toAsciiUppercase() {
        return this.toByteString().toAsciiUppercase();
    }

    public byte[] toByteArray() {
        byte[] byArray = new byte[this.size()];
        int n = ((Object[])this.getSegments$okio()).length;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        while (n2 < n) {
            int n5 = this.getDirectory$okio()[n + n2];
            int n6 = this.getDirectory$okio()[n2];
            byte[] byArray2 = this.getSegments$okio()[n2];
            n3 = n6 - n3;
            ArraysKt.copyInto((byte[])byArray2, (byte[])byArray, (int)n4, (int)n5, (int)(n5 + n3));
            n4 += n3;
            ++n2;
            n3 = n6;
        }
        return byArray;
    }

    public String toString() {
        return this.toByteString().toString();
    }

    public void write(OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter((Object)outputStream, (String)"out");
        int n = ((Object[])this.getSegments$okio()).length;
        int n2 = 0;
        int n3 = 0;
        while (n2 < n) {
            int n4 = this.getDirectory$okio()[n + n2];
            int n5 = this.getDirectory$okio()[n2];
            outputStream.write(this.getSegments$okio()[n2], n4, n5 - n3);
            ++n2;
            n3 = n5;
        }
    }

    public void write$okio(Buffer buffer, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        int n3 = n + n2;
        int n4 = _SegmentedByteStringKt.segment((SegmentedByteString)this, (int)n);
        int n5 = n;
        n = n4;
        while (true) {
            if (n5 >= n3) {
                buffer.setSize$okio(buffer.size() + (long)n2);
                return;
            }
            n4 = n == 0 ? 0 : this.getDirectory$okio()[n - 1];
            int n6 = this.getDirectory$okio()[n];
            int n7 = this.getDirectory$okio()[((Object[])this.getSegments$okio()).length + n];
            n6 = Math.min(n3, n6 - n4 + n4) - n5;
            n4 = n7 + (n5 - n4);
            Segment segment = new Segment(this.getSegments$okio()[n], n4, n4 + n6, true, false);
            if (buffer.head == null) {
                buffer.head = segment.next = (segment.prev = segment);
            } else {
                Segment segment2 = buffer.head;
                Intrinsics.checkNotNull((Object)segment2);
                segment2 = segment2.prev;
                Intrinsics.checkNotNull((Object)segment2);
                segment2.push(segment);
            }
            n5 += n6;
            ++n;
        }
    }
}
