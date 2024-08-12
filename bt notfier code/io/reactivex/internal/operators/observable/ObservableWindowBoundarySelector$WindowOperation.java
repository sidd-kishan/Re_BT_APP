/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.subjects.UnicastSubject
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.subjects.UnicastSubject;

static final class ObservableWindowBoundarySelector.WindowOperation<T, B> {
    final B open;
    final UnicastSubject<T> w;

    ObservableWindowBoundarySelector.WindowOperation(UnicastSubject<T> unicastSubject, B b) {
        this.w = unicastSubject;
        this.open = b;
    }
}
