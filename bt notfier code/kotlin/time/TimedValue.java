/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.time.Duration
 */
package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0018\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00028\u0000H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000f\u0010\bJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0019\u0010\u0004\u001a\u00020\u0005\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u001a"}, d2={"Lkotlin/time/TimedValue;", "T", "", "value", "duration", "Lkotlin/time/Duration;", "(Ljava/lang/Object;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDuration-UwyO8pc", "()J", "J", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component2-UwyO8pc", "copy", "copy-RFiDyg4", "(Ljava/lang/Object;J)Lkotlin/time/TimedValue;", "equals", "", "other", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class TimedValue<T> {
    private final long duration;
    private final T value;

    private TimedValue(T t, long l) {
        this.value = t;
        this.duration = l;
    }

    public /* synthetic */ TimedValue(Object object, long l, DefaultConstructorMarker defaultConstructorMarker) {
        this(object, l);
    }

    public static /* synthetic */ TimedValue copy_RFiDyg4$default(TimedValue timedValue, Object object, long l, int n, Object object2) {
        if ((n & 1) != 0) {
            object = timedValue.value;
        }
        if ((n & 2) == 0) return timedValue.copy_RFiDyg4(object, l);
        l = timedValue.duration;
        return timedValue.copy_RFiDyg4(object, l);
    }

    public final T component1() {
        return this.value;
    }

    public final long component2_UwyO8pc() {
        return this.duration;
    }

    public final TimedValue<T> copy_RFiDyg4(T t, long l) {
        return new TimedValue<T>(t, l);
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof TimedValue)) return false;
        object = (TimedValue)object;
        if (!Intrinsics.areEqual(this.value, ((TimedValue)object).value)) return false;
        if (this.duration != ((TimedValue)object).duration) return false;
        return true;
    }

    public final long getDuration_UwyO8pc() {
        return this.duration;
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        T t = this.value;
        int n = t != null ? t.hashCode() : 0;
        long l = this.duration;
        return n * 31 + (int)(l ^ l >>> 32);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TimedValue(value=");
        stringBuilder.append(this.value);
        stringBuilder.append(", duration=");
        stringBuilder.append(Duration.toString_impl((long)this.duration));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
