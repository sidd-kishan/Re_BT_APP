/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.data.Freezable
 */
package com.google.android.gms.common.data;

import com.google.android.gms.common.data.Freezable;
import java.util.ArrayList;

public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        ArrayList<Object> arrayList2 = new ArrayList<Object>(arrayList.size());
        int n = arrayList.size();
        int n2 = 0;
        while (n2 < n) {
            arrayList2.add(((Freezable)arrayList.get(n2)).freeze());
            ++n2;
        }
        return arrayList2;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] EArray) {
        ArrayList<Object> arrayList = new ArrayList<Object>(EArray.length);
        int n = 0;
        while (n < EArray.length) {
            arrayList.add(EArray[n].freeze());
            ++n;
        }
        return arrayList;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> object) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = object.iterator();
        while (object.hasNext()) {
            arrayList.add(((Freezable)object.next()).freeze());
        }
        return arrayList;
    }
}
