/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import java.util.Comparator;

class LinkedHashTreeMap.1
implements Comparator<Comparable> {
    LinkedHashTreeMap.1() {
    }

    @Override
    public int compare(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }
}
