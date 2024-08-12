/*
 * Decompiled with CFR 0.152.
 */
package androidx.transition;

import java.util.ArrayList;

private static class Transition.ArrayListManager {
    private Transition.ArrayListManager() {
    }

    static <T> ArrayList<T> add(ArrayList<T> arrayList, T t) {
        ArrayList<Object> arrayList2 = arrayList;
        if (arrayList == null) {
            arrayList2 = new ArrayList();
        }
        if (arrayList2.contains(t)) return arrayList2;
        arrayList2.add(t);
        return arrayList2;
    }

    static <T> ArrayList<T> remove(ArrayList<T> arrayList, T t) {
        ArrayList<T> arrayList2 = arrayList;
        if (arrayList == null) return arrayList2;
        arrayList.remove(t);
        arrayList2 = arrayList;
        if (!arrayList.isEmpty()) return arrayList2;
        arrayList2 = null;
        return arrayList2;
    }
}
