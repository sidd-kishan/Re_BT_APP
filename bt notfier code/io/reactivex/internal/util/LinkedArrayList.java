/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.util;

import java.util.ArrayList;

public class LinkedArrayList {
    final int capacityHint;
    Object[] head;
    int indexInTail;
    volatile int size;
    Object[] tail;

    public LinkedArrayList(int n) {
        this.capacityHint = n;
    }

    public void add(Object object) {
        if (this.size == 0) {
            Object[] objectArray = new Object[this.capacityHint + 1];
            this.head = objectArray;
            this.tail = objectArray;
            objectArray[0] = object;
            this.indexInTail = 1;
            this.size = 1;
        } else {
            int n = this.indexInTail;
            int n2 = this.capacityHint;
            if (n == n2) {
                Object[] objectArray = new Object[n2 + 1];
                objectArray[0] = object;
                this.tail[n2] = objectArray;
                this.tail = objectArray;
                this.indexInTail = 1;
                ++this.size;
            } else {
                this.tail[n] = object;
                this.indexInTail = n + 1;
                ++this.size;
            }
        }
    }

    public Object[] head() {
        return this.head;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        int n = this.capacityHint;
        int n2 = this.size;
        ArrayList<Object> arrayList = new ArrayList<Object>(n2 + 1);
        Object[] objectArray = this.head();
        int n3 = 0;
        while (true) {
            int n4;
            int n5;
            int n6 = 0;
            do {
                if (n3 >= n2) return ((Object)arrayList).toString();
                arrayList.add(objectArray[n6]);
                n4 = n3 + 1;
                n5 = n6 + 1;
                n3 = n4;
                n6 = n5;
            } while (n5 != n);
            objectArray = (Object[])objectArray[n];
            n3 = n4;
        }
    }
}
