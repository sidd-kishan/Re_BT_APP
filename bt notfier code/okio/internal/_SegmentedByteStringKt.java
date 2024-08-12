/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.ByteString
 *  okio.Segment
 *  okio.SegmentedByteString
 *  okio._UtilKt
 */
package okio.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio._UtilKt;

@Metadata(d1={"\u0000T\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a-\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u0017\u0010\u000e\u001a\u00020\u000f*\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0080\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\bH\u0080\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\bH\u0080\b\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u0017\u001a\u00020\u000f*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u0017\u001a\u00020\u000f*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u001d\u0010\u001a\u001a\u00020\u0019*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u000b*\u00020\bH\u0080\b\u001a%\u0010\u001e\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a]\u0010!\u001a\u00020\u0007*\u00020\b2K\u0010\"\u001aG\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070#H\u0080\b\u00f8\u0001\u0000\u001aj\u0010!\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00012K\u0010\"\u001aG\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070#H\u0082\b\u001a\u0014\u0010'\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006("}, d2={"binarySearch", "", "", "value", "fromIndex", "toIndex", "commonCopyInto", "", "Lokio/SegmentedByteString;", "offset", "target", "", "targetOffset", "byteCount", "commonEquals", "", "other", "", "commonGetSize", "commonHashCode", "commonInternalGet", "", "pos", "commonRangeEquals", "otherOffset", "Lokio/ByteString;", "commonSubstring", "beginIndex", "endIndex", "commonToByteArray", "commonWrite", "buffer", "Lokio/Buffer;", "forEachSegment", "action", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "data", "segment", "okio"}, k=2, mv={1, 5, 1}, xi=48)
public final class _SegmentedByteStringKt {
    public static final int binarySearch(int[] nArray, int n, int n2, int n3) {
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"<this>");
        --n3;
        while (n2 <= n3) {
            int n4 = n2 + n3 >>> 1;
            int n5 = nArray[n4];
            if (n5 < n) {
                n2 = n4 + 1;
                continue;
            }
            if (n5 <= n) return n4;
            n3 = n4 - 1;
        }
        return -n2 - 1;
    }

    public static final void commonCopyInto(SegmentedByteString segmentedByteString, int n, byte[] byArray, int n2, int n3) {
        Intrinsics.checkNotNullParameter((Object)segmentedByteString, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"target");
        long l = segmentedByteString.size();
        long l2 = n;
        long l3 = n3;
        _UtilKt.checkOffsetAndCount((long)l, (long)l2, (long)l3);
        _UtilKt.checkOffsetAndCount((long)byArray.length, (long)n2, (long)l3);
        int n4 = n3 + n;
        n3 = _SegmentedByteStringKt.segment(segmentedByteString, n);
        while (n < n4) {
            int n5 = n3 == 0 ? 0 : segmentedByteString.getDirectory$okio()[n3 - 1];
            int n6 = segmentedByteString.getDirectory$okio()[n3];
            int n7 = segmentedByteString.getDirectory$okio()[((Object[])segmentedByteString.getSegments$okio()).length + n3];
            n6 = Math.min(n4, n6 - n5 + n5) - n;
            n5 = n7 + (n - n5);
            ArraysKt.copyInto((byte[])segmentedByteString.getSegments$okio()[n3], (byte[])byArray, (int)n2, (int)n5, (int)(n5 + n6));
            n2 += n6;
            n += n6;
            ++n3;
        }
    }

    public static final boolean commonEquals(SegmentedByteString segmentedByteString, Object object) {
        Intrinsics.checkNotNullParameter((Object)segmentedByteString, (String)"<this>");
        boolean bl = true;
        if (object == segmentedByteString || object instanceof ByteString && (object = (ByteString)object).size() == segmentedByteString.size() && segmentedByteString.rangeEquals(0, (ByteString)object, 0, segmentedByteString.size())) return bl;
        bl = false;
        return bl;
    }

    public static final int commonGetSize(SegmentedByteString segmentedByteString) {
        Intrinsics.checkNotNullParameter((Object)segmentedByteString, (String)"<this>");
        return segmentedByteString.getDirectory$okio()[((Object[])segmentedByteString.getSegments$okio()).length - 1];
    }

    public static final int commonHashCode(SegmentedByteString segmentedByteString) {
        Intrinsics.checkNotNullParameter((Object)segmentedByteString, (String)"<this>");
        int n = segmentedByteString.getHashCode$okio();
        if (n != 0) {
            return n;
        }
        int n2 = ((Object[])segmentedByteString.getSegments$okio()).length;
        int n3 = 0;
        int n4 = 0;
        int n5 = 1;
        while (true) {
            if (n3 >= n2) {
                segmentedByteString.setHashCode$okio(n5);
                return n5;
            }
            int n6 = segmentedByteString.getDirectory$okio()[n2 + n3];
            int n7 = segmentedByteString.getDirectory$okio()[n3];
            byte[] byArray = segmentedByteString.getSegments$okio()[n3];
            for (n = n6; n < n7 - n4 + n6; ++n) {
                n5 = n5 * 31 + byArray[n];
            }
            ++n3;
            n4 = n7;
        }
    }

    public static final byte commonInternalGet(SegmentedByteString segmentedByteString, int n) {
        Intrinsics.checkNotNullParameter((Object)segmentedByteString, (String)"<this>");
        _UtilKt.checkOffsetAndCount((long)segmentedByteString.getDirectory$okio()[((Object[])segmentedByteString.getSegments$okio()).length - 1], (long)n, (long)1L);
        int n2 = _SegmentedByteStringKt.segment(segmentedByteString, n);
        int n3 = n2 == 0 ? 0 : segmentedByteString.getDirectory$okio()[n2 - 1];
        int n4 = segmentedByteString.getDirectory$okio()[((Object[])segmentedByteString.getSegments$okio()).length + n2];
        return segmentedByteString.getSegments$okio()[n2][n - n3 + n4];
    }

    public static final boolean commonRangeEquals(SegmentedByteString segmentedByteString, int n, ByteString byteString, int n2, int n3) {
        Intrinsics.checkNotNullParameter((Object)segmentedByteString, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"other");
        if (n < 0) return false;
        if (n > segmentedByteString.size() - n3) {
            return false;
        }
        int n4 = n3 + n;
        int n5 = _SegmentedByteStringKt.segment(segmentedByteString, n);
        n3 = n2;
        n2 = n;
        n = n5;
        while (n2 < n4) {
            n5 = n == 0 ? 0 : segmentedByteString.getDirectory$okio()[n - 1];
            int n6 = segmentedByteString.getDirectory$okio()[n];
            int n7 = segmentedByteString.getDirectory$okio()[((Object[])segmentedByteString.getSegments$okio()).length + n];
            n6 = Math.min(n4, n6 - n5 + n5) - n2;
            if (!byteString.rangeEquals(n3, segmentedByteString.getSegments$okio()[n], n7 + (n2 - n5), n6)) {
                return false;
            }
            n3 += n6;
            n2 += n6;
            ++n;
        }
        return true;
    }

    public static final boolean commonRangeEquals(SegmentedByteString segmentedByteString, int n, byte[] byArray, int n2, int n3) {
        Intrinsics.checkNotNullParameter((Object)segmentedByteString, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"other");
        if (n < 0) return false;
        if (n > segmentedByteString.size() - n3) return false;
        if (n2 < 0) return false;
        if (n2 > byArray.length - n3) {
            return false;
        }
        int n4 = n3 + n;
        int n5 = _SegmentedByteStringKt.segment(segmentedByteString, n);
        n3 = n;
        n = n5;
        while (n3 < n4) {
            n5 = n == 0 ? 0 : segmentedByteString.getDirectory$okio()[n - 1];
            int n6 = segmentedByteString.getDirectory$okio()[n];
            int n7 = segmentedByteString.getDirectory$okio()[((Object[])segmentedByteString.getSegments$okio()).length + n];
            n6 = Math.min(n4, n6 - n5 + n5) - n3;
            if (!_UtilKt.arrayRangeEquals((byte[])segmentedByteString.getSegments$okio()[n], (int)(n7 + (n3 - n5)), (byte[])byArray, (int)n2, (int)n6)) {
                return false;
            }
            n2 += n6;
            n3 += n6;
            ++n;
        }
        return true;
    }

    public static final ByteString commonSubstring(SegmentedByteString object, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Object object2 = (ByteString)object;
        int n3 = _UtilKt.resolveDefaultParameter((ByteString)object2, (int)n2);
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
        n2 = n3 <= object.size() ? 1 : 0;
        if (n2 == 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("endIndex=");
            ((StringBuilder)object2).append(n3);
            ((StringBuilder)object2).append(" > length(");
            ((StringBuilder)object2).append(object.size());
            ((StringBuilder)object2).append(')');
            throw (Throwable)new IllegalArgumentException(((StringBuilder)object2).toString().toString());
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
        if (n == 0 && n3 == object.size()) {
            return object2;
        }
        if (n == n3) {
            return ByteString.EMPTY;
        }
        int n6 = _SegmentedByteStringKt.segment((SegmentedByteString)object, n);
        int n7 = _SegmentedByteStringKt.segment((SegmentedByteString)object, n3 - 1);
        byte[][] byArray = (byte[][])ArraysKt.copyOfRange((Object[])((Object[])object.getSegments$okio()), (int)n6, (int)(n7 + 1));
        object2 = (Object[])byArray;
        int[] nArray = new int[((Object)object2).length * 2];
        if (n6 <= n7) {
            n3 = n6;
            n2 = 0;
            while (true) {
                nArray[n2] = Math.min(object.getDirectory$okio()[n3] - n, n5);
                nArray[n2 + ((Object)object2).length] = object.getDirectory$okio()[((Object[])object.getSegments$okio()).length + n3];
                if (n3 == n7) break;
                ++n3;
                ++n2;
            }
        }
        n2 = n6 == 0 ? n4 : object.getDirectory$okio()[n6 - 1];
        n3 = ((Object)object2).length;
        nArray[n3] = nArray[n3] + (n - n2);
        return (ByteString)new SegmentedByteString(byArray, nArray);
    }

    public static final byte[] commonToByteArray(SegmentedByteString segmentedByteString) {
        Intrinsics.checkNotNullParameter((Object)segmentedByteString, (String)"<this>");
        byte[] byArray = new byte[segmentedByteString.size()];
        int n = ((Object[])segmentedByteString.getSegments$okio()).length;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        while (n2 < n) {
            int n5 = segmentedByteString.getDirectory$okio()[n + n2];
            int n6 = segmentedByteString.getDirectory$okio()[n2];
            byte[] byArray2 = segmentedByteString.getSegments$okio()[n2];
            n3 = n6 - n3;
            ArraysKt.copyInto((byte[])byArray2, (byte[])byArray, (int)n4, (int)n5, (int)(n5 + n3));
            n4 += n3;
            ++n2;
            n3 = n6;
        }
        return byArray;
    }

    public static final void commonWrite(SegmentedByteString segmentedByteString, Buffer buffer, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)segmentedByteString, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        int n3 = n + n2;
        int n4 = _SegmentedByteStringKt.segment(segmentedByteString, n);
        while (true) {
            if (n >= n3) {
                buffer.setSize$okio(buffer.size() + (long)n2);
                return;
            }
            int n5 = n4 == 0 ? 0 : segmentedByteString.getDirectory$okio()[n4 - 1];
            int n6 = segmentedByteString.getDirectory$okio()[n4];
            int n7 = segmentedByteString.getDirectory$okio()[((Object[])segmentedByteString.getSegments$okio()).length + n4];
            n6 = Math.min(n3, n6 - n5 + n5) - n;
            n5 = n7 + (n - n5);
            Segment segment = new Segment(segmentedByteString.getSegments$okio()[n4], n5, n5 + n6, true, false);
            if (buffer.head == null) {
                buffer.head = segment.next = (segment.prev = segment);
            } else {
                Segment segment2 = buffer.head;
                Intrinsics.checkNotNull((Object)segment2);
                segment2 = segment2.prev;
                Intrinsics.checkNotNull((Object)segment2);
                segment2.push(segment);
            }
            n += n6;
            ++n4;
        }
    }

    private static final void forEachSegment(SegmentedByteString segmentedByteString, int n, int n2, Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        int n3 = _SegmentedByteStringKt.segment(segmentedByteString, n);
        int n4 = n;
        n = n3;
        while (n4 < n2) {
            n3 = n == 0 ? 0 : segmentedByteString.getDirectory$okio()[n - 1];
            int n5 = segmentedByteString.getDirectory$okio()[n];
            int n6 = segmentedByteString.getDirectory$okio()[((Object[])segmentedByteString.getSegments$okio()).length + n];
            n5 = Math.min(n2, n5 - n3 + n3) - n4;
            function3.invoke((Object)segmentedByteString.getSegments$okio()[n], (Object)(n6 + (n4 - n3)), (Object)n5);
            n4 += n5;
            ++n;
        }
    }

    public static final void forEachSegment(SegmentedByteString segmentedByteString, Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter((Object)segmentedByteString, (String)"<this>");
        Intrinsics.checkNotNullParameter(function3, (String)"action");
        int n = ((Object[])segmentedByteString.getSegments$okio()).length;
        int n2 = 0;
        int n3 = 0;
        while (n2 < n) {
            int n4 = segmentedByteString.getDirectory$okio()[n + n2];
            int n5 = segmentedByteString.getDirectory$okio()[n2];
            function3.invoke((Object)segmentedByteString.getSegments$okio()[n2], (Object)n4, (Object)(n5 - n3));
            ++n2;
            n3 = n5;
        }
    }

    public static final int segment(SegmentedByteString segmentedByteString, int n) {
        Intrinsics.checkNotNullParameter((Object)segmentedByteString, (String)"<this>");
        n = _SegmentedByteStringKt.binarySearch(segmentedByteString.getDirectory$okio(), n + 1, 0, ((Object[])segmentedByteString.getSegments$okio()).length);
        if (n >= 0) return n;
        n ^= 0xFFFFFFFF;
        return n;
    }
}
