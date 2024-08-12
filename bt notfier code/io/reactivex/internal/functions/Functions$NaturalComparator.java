/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.functions;

import java.util.Comparator;

static final class Functions.NaturalComparator
extends Enum<Functions.NaturalComparator>
implements Comparator<Object> {
    private static final Functions.NaturalComparator[] $VALUES;
    public static final /* enum */ Functions.NaturalComparator INSTANCE;

    static {
        Functions.NaturalComparator naturalComparator;
        INSTANCE = naturalComparator = new Functions.NaturalComparator();
        $VALUES = new Functions.NaturalComparator[]{naturalComparator};
    }

    public static Functions.NaturalComparator valueOf(String string) {
        return Enum.valueOf(Functions.NaturalComparator.class, string);
    }

    public static Functions.NaturalComparator[] values() {
        return (Functions.NaturalComparator[])$VALUES.clone();
    }

    @Override
    public int compare(Object object, Object object2) {
        return ((Comparable)object).compareTo(object2);
    }
}
