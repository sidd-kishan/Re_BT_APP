/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.functions.BiPredicate
 *  io.reactivex.internal.util.AppendOnlyLinkedArrayList$NonThrowingPredicate
 *  io.reactivex.internal.util.NotificationLite
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import org.reactivestreams.Subscriber;

public class AppendOnlyLinkedArrayList<T> {
    final int capacity;
    final Object[] head;
    int offset;
    Object[] tail;

    public AppendOnlyLinkedArrayList(int n) {
        this.capacity = n;
        Object[] objectArray = new Object[n + 1];
        this.head = objectArray;
        this.tail = objectArray;
    }

    public <U> boolean accept(Observer<? super U> observer) {
        Object[] objectArray = this.head;
        int n = this.capacity;
        while (objectArray != null) {
            Object object;
            for (int i = 0; i < n && (object = objectArray[i]) != null; ++i) {
                if (!NotificationLite.acceptFull((Object)object, observer)) continue;
                return true;
            }
            objectArray = (Object[])objectArray[n];
        }
        return false;
    }

    public <U> boolean accept(Subscriber<? super U> subscriber) {
        Object[] objectArray = this.head;
        int n = this.capacity;
        while (objectArray != null) {
            Object object;
            for (int i = 0; i < n && (object = objectArray[i]) != null; ++i) {
                if (!NotificationLite.acceptFull((Object)object, subscriber)) continue;
                return true;
            }
            objectArray = (Object[])objectArray[n];
        }
        return false;
    }

    public void add(T t) {
        int n;
        int n2 = this.capacity;
        int n3 = n = this.offset;
        if (n == n2) {
            Object[] objectArray;
            this.tail[n2] = objectArray = new Object[n2 + 1];
            this.tail = objectArray;
            n3 = 0;
        }
        this.tail[n3] = t;
        this.offset = n3 + 1;
    }

    public void forEachWhile(NonThrowingPredicate<? super T> nonThrowingPredicate) {
        Object[] objectArray = this.head;
        int n = this.capacity;
        while (objectArray != null) {
            Object object;
            for (int i = 0; i < n && (object = objectArray[i]) != null; ++i) {
                if (!nonThrowingPredicate.test(object)) continue;
                return;
            }
            objectArray = (Object[])objectArray[n];
        }
    }

    public <S> void forEachWhile(S s, BiPredicate<? super S, ? super T> biPredicate) throws Exception {
        Object[] objectArray = this.head;
        int n = this.capacity;
        while (true) {
            for (int i = 0; i < n; ++i) {
                Object object = objectArray[i];
                if (object == null) {
                    return;
                }
                if (!biPredicate.test(s, object)) continue;
                return;
            }
            objectArray = (Object[])objectArray[n];
        }
    }

    public void setFirst(T t) {
        this.head[0] = t;
    }
}
