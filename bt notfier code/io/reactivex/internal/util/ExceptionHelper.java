/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.internal.util.ExceptionHelper$Termination
 */
package io.reactivex.internal.util;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ExceptionHelper {
    public static final Throwable TERMINATED = new Termination();

    private ExceptionHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> boolean addThrowable(AtomicReference<Throwable> atomicReference, Throwable throwable) {
        Throwable throwable2;
        Throwable throwable3;
        do {
            if ((throwable3 = atomicReference.get()) != TERMINATED) continue;
            return false;
        } while (!atomicReference.compareAndSet(throwable3, throwable2 = throwable3 == null ? throwable : new CompositeException(new Throwable[]{throwable3, throwable})));
        return true;
    }

    public static List<Throwable> flatten(Throwable object) {
        ArrayList<Throwable> arrayList = new ArrayList<Throwable>();
        ArrayDeque<Throwable> arrayDeque = new ArrayDeque<Throwable>();
        arrayDeque.offer((Throwable)object);
        block0: while (!arrayDeque.isEmpty()) {
            object = (Throwable)arrayDeque.removeFirst();
            if (object instanceof CompositeException) {
                object = ((CompositeException)object).getExceptions();
                int n = object.size() - 1;
                while (true) {
                    if (n < 0) continue block0;
                    arrayDeque.offerFirst((Throwable)object.get(n));
                    --n;
                }
            }
            arrayList.add((Throwable)object);
        }
        return arrayList;
    }

    public static <T> Throwable terminate(AtomicReference<Throwable> atomicReference) {
        Throwable throwable = atomicReference.get();
        Throwable throwable2 = TERMINATED;
        Throwable throwable3 = throwable;
        if (throwable == throwable2) return throwable3;
        throwable3 = atomicReference.getAndSet(throwable2);
        return throwable3;
    }

    public static <E extends Throwable> Exception throwIfThrowable(Throwable throwable) throws E {
        if (!(throwable instanceof Exception)) throw throwable;
        return (Exception)throwable;
    }

    public static String timeoutMessage(long l, TimeUnit timeUnit) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The source did not signal an event for ");
        stringBuilder.append(l);
        stringBuilder.append(" ");
        stringBuilder.append(timeUnit.toString().toLowerCase());
        stringBuilder.append(" and has been terminated.");
        return stringBuilder.toString();
    }

    public static RuntimeException wrapOrThrow(Throwable throwable) {
        if (throwable instanceof Error) throw (Error)throwable;
        if (!(throwable instanceof RuntimeException)) return new RuntimeException(throwable);
        return (RuntimeException)throwable;
    }
}
