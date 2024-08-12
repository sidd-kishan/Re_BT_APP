/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.util.NotificationLite
 */
package io.reactivex;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;

public final class Notification<T> {
    static final Notification<Object> COMPLETE = new Notification(null);
    final Object value;

    private Notification(Object object) {
        this.value = object;
    }

    public static <T> Notification<T> createOnComplete() {
        return COMPLETE;
    }

    public static <T> Notification<T> createOnError(Throwable throwable) {
        ObjectHelper.requireNonNull((Object)throwable, (String)"error is null");
        return new Notification<T>(NotificationLite.error((Throwable)throwable));
    }

    public static <T> Notification<T> createOnNext(T t) {
        ObjectHelper.requireNonNull(t, (String)"value is null");
        return new Notification<T>(t);
    }

    public boolean equals(Object object) {
        if (!(object instanceof Notification)) return false;
        object = (Notification)object;
        return ObjectHelper.equals((Object)this.value, (Object)((Notification)object).value);
    }

    public Throwable getError() {
        Object object = this.value;
        if (!NotificationLite.isError((Object)object)) return null;
        return NotificationLite.getError((Object)object);
    }

    public T getValue() {
        Object object = this.value;
        if (object == null) return null;
        if (NotificationLite.isError((Object)object)) return null;
        return (T)this.value;
    }

    public int hashCode() {
        Object object = this.value;
        int n = object != null ? object.hashCode() : 0;
        return n;
    }

    public boolean isOnComplete() {
        boolean bl = this.value == null;
        return bl;
    }

    public boolean isOnError() {
        return NotificationLite.isError((Object)this.value);
    }

    public boolean isOnNext() {
        Object object = this.value;
        boolean bl = object != null && !NotificationLite.isError((Object)object);
        return bl;
    }

    public String toString() {
        Object object = this.value;
        if (object == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError((Object)object)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("OnErrorNotification[");
            stringBuilder.append(NotificationLite.getError((Object)object));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OnNextNotification[");
        stringBuilder.append(this.value);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
