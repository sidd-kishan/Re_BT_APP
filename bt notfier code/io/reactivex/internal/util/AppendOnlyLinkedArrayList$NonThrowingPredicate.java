/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Predicate
 */
package io.reactivex.internal.util;

import io.reactivex.functions.Predicate;

public static interface AppendOnlyLinkedArrayList.NonThrowingPredicate<T>
extends Predicate<T> {
    public boolean test(T var1);
}
