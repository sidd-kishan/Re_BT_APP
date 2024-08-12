/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.schedulers;

import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.TimeUnit;

public final class Timed<T> {
    final long time;
    final TimeUnit unit;
    final T value;

    public Timed(T t, long l, TimeUnit timeUnit) {
        this.value = t;
        this.time = l;
        this.unit = (TimeUnit)((Object)ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null"));
    }

    public boolean equals(Object object) {
        boolean bl;
        boolean bl2 = object instanceof Timed;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        object = (Timed)object;
        bl3 = bl;
        if (!ObjectHelper.equals(this.value, ((Timed)object).value)) return bl3;
        bl3 = bl;
        if (this.time != ((Timed)object).time) return bl3;
        bl3 = bl;
        if (!ObjectHelper.equals((Object)((Object)this.unit), (Object)((Object)((Timed)object).unit))) return bl3;
        bl3 = true;
        return bl3;
    }

    public int hashCode() {
        T t = this.value;
        int n = t != null ? t.hashCode() : 0;
        long l = this.time;
        return (n * 31 + (int)(l ^ l >>> 31)) * 31 + this.unit.hashCode();
    }

    public long time() {
        return this.time;
    }

    public long time(TimeUnit timeUnit) {
        return timeUnit.convert(this.time, this.unit);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Timed[time=");
        stringBuilder.append(this.time);
        stringBuilder.append(", unit=");
        stringBuilder.append((Object)this.unit);
        stringBuilder.append(", value=");
        stringBuilder.append(this.value);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public TimeUnit unit() {
        return this.unit;
    }

    public T value() {
        return this.value;
    }
}
