/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.AbstractList
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 */
package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u001d\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\fJ\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0018\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0006H\u0096\u0002\u00a2\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0096\u0002J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0006J\u0015\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0014\u00a2\u0006\u0002\u0010#J'\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00010\t\"\u0004\b\u0001\u0010\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00010\tH\u0014\u00a2\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u0006*\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0082\bR\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@RX\u0096\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2={"Lkotlin/collections/RingBuffer;", "T", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "capacity", "", "(I)V", "buffer", "", "", "filledSize", "([Ljava/lang/Object;I)V", "[Ljava/lang/Object;", "<set-?>", "size", "getSize", "()I", "startIndex", "add", "", "element", "(Ljava/lang/Object;)V", "expanded", "maxCapacity", "get", "index", "(I)Ljava/lang/Object;", "isFull", "", "iterator", "", "removeFirst", "n", "toArray", "()[Ljava/lang/Object;", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "forward", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class RingBuffer<T>
extends AbstractList<T>
implements RandomAccess {
    private final Object[] buffer;
    private final int capacity;
    private int size;
    private int startIndex;

    public RingBuffer(int n) {
        this(new Object[n], 0);
    }

    public RingBuffer(Object[] object, int n) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"buffer");
        this.buffer = object;
        boolean bl = true;
        boolean bl2 = n >= 0;
        if (!bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("ring buffer filled size should not be negative but it is ");
            ((StringBuilder)object).append(n);
            throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString().toString());
        }
        bl2 = n <= this.buffer.length ? bl : false;
        if (bl2) {
            this.capacity = this.buffer.length;
            this.size = n;
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("ring buffer filled size: ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" cannot be larger than the buffer size: ");
        ((StringBuilder)object).append(this.buffer.length);
        throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString().toString());
    }

    public static final /* synthetic */ int access$forward(RingBuffer ringBuffer, int n, int n2) {
        return ringBuffer.forward(n, n2);
    }

    public static final /* synthetic */ Object[] access$getBuffer$p(RingBuffer ringBuffer) {
        return ringBuffer.buffer;
    }

    public static final /* synthetic */ int access$getSize$p(RingBuffer ringBuffer) {
        return ringBuffer.size();
    }

    public static final /* synthetic */ int access$getStartIndex$p(RingBuffer ringBuffer) {
        return ringBuffer.startIndex;
    }

    public static final /* synthetic */ void access$setSize$p(RingBuffer ringBuffer, int n) {
        ringBuffer.size = n;
    }

    public static final /* synthetic */ void access$setStartIndex$p(RingBuffer ringBuffer, int n) {
        ringBuffer.startIndex = n;
    }

    private final int forward(int n, int n2) {
        return (n + n2) % this.capacity;
    }

    public final void add(T t) {
        if (this.isFull()) throw (Throwable)new IllegalStateException("ring buffer is full");
        this.buffer[(this.startIndex + this.size()) % ((RingBuffer)this).capacity] = t;
        this.size = this.size() + 1;
    }

    public final RingBuffer<T> expanded(int n) {
        Object[] objectArray;
        int n2 = this.capacity;
        n = RangesKt.coerceAtMost((int)(n2 + (n2 >> 1) + 1), (int)n);
        if (this.startIndex == 0) {
            objectArray = Arrays.copyOf(this.buffer, n);
            Intrinsics.checkNotNullExpressionValue((Object)objectArray, (String)"java.util.Arrays.copyOf(this, newSize)");
        } else {
            objectArray = this.toArray(new Object[n]);
        }
        return new RingBuffer<T>(objectArray, this.size());
    }

    public T get(int n) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(n, this.size());
        return (T)this.buffer[(this.startIndex + n) % this.capacity];
    }

    public int getSize() {
        return this.size;
    }

    public final boolean isFull() {
        boolean bl = this.size() == this.capacity;
        return bl;
    }

    public Iterator<T> iterator() {
        return (Iterator)new /* Unavailable Anonymous Inner Class!! */;
    }

    public final void removeFirst(int n) {
        int n2 = 1;
        int n3 = n >= 0 ? 1 : 0;
        if (n3 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("n shouldn't be negative but it is ");
            stringBuilder.append(n);
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString().toString());
        }
        n3 = n <= this.size() ? n2 : 0;
        if (n3 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("n shouldn't be greater than the buffer size: n = ");
            stringBuilder.append(n);
            stringBuilder.append(", size = ");
            stringBuilder.append(this.size());
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString().toString());
        }
        if (n <= 0) return;
        n3 = this.startIndex;
        n2 = (n3 + n) % this.capacity;
        if (n3 > n2) {
            ArraysKt.fill((Object[])this.buffer, null, (int)n3, (int)this.capacity);
            ArraysKt.fill((Object[])this.buffer, null, (int)0, (int)n2);
        } else {
            ArraysKt.fill((Object[])this.buffer, null, (int)n3, (int)n2);
        }
        this.startIndex = n2;
        this.size = this.size() - n;
    }

    public Object[] toArray() {
        return this.toArray(new Object[this.size()]);
    }

    public <T> T[] toArray(T[] object) {
        int n;
        int n2;
        Intrinsics.checkNotNullParameter(object, (String)"array");
        T[] TArray = object;
        if (((T[])object).length < this.size()) {
            TArray = Arrays.copyOf(object, this.size());
            Intrinsics.checkNotNullExpressionValue(TArray, (String)"java.util.Arrays.copyOf(this, newSize)");
        }
        int n3 = this.size();
        int n4 = this.startIndex;
        int n5 = 0;
        int n6 = 0;
        while (true) {
            n2 = n5;
            n = n6;
            if (n6 >= n3) break;
            n2 = n5;
            n = n6;
            if (n4 >= this.capacity) break;
            TArray[n6] = this.buffer[n4];
            ++n6;
            ++n4;
        }
        while (n < n3) {
            TArray[n] = this.buffer[n2];
            ++n;
            ++n2;
        }
        if (TArray.length > this.size()) {
            TArray[this.size()] = null;
        }
        if (TArray != null) {
            return TArray;
        }
        object = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        throw object;
    }
}
