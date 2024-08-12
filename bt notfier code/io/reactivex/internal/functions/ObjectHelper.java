/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.BiPredicate
 *  io.reactivex.internal.functions.ObjectHelper$BiObjectPredicate
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.functions.ObjectHelper;

public final class ObjectHelper {
    static final BiPredicate<Object, Object> EQUALS = new BiObjectPredicate();

    private ObjectHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static int compare(int n, int n2) {
        n = n < n2 ? -1 : (n > n2 ? 1 : 0);
        return n;
    }

    public static int compare(long l, long l2) {
        int n = l < l2 ? -1 : (l > l2 ? 1 : 0);
        return n;
    }

    public static boolean equals(Object object, Object object2) {
        boolean bl = object == object2 || object != null && object.equals(object2);
        return bl;
    }

    public static <T> BiPredicate<T, T> equalsPredicate() {
        return EQUALS;
    }

    public static int hashCode(Object object) {
        int n = object != null ? object.hashCode() : 0;
        return n;
    }

    @Deprecated
    public static long requireNonNull(long l, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Null check on a primitive: ");
        stringBuilder.append(string);
        throw new InternalError(stringBuilder.toString());
    }

    public static <T> T requireNonNull(T t, String string) {
        if (t == null) throw new NullPointerException(string);
        return t;
    }

    public static int verifyPositive(int n, String string) {
        if (n > 0) {
            return n;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" > 0 required but it was ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static long verifyPositive(long l, String string) {
        if (l > 0L) {
            return l;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" > 0 required but it was ");
        stringBuilder.append(l);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
