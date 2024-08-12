/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.subjects.UnicastSubject
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.subjects.UnicastSubject;

static final class ObservableWindowTimed.WindowSkipObserver.SubjectWork<T> {
    final boolean open;
    final UnicastSubject<T> w;

    ObservableWindowTimed.WindowSkipObserver.SubjectWork(UnicastSubject<T> unicastSubject, boolean bl) {
        this.w = unicastSubject;
        this.open = bl;
    }
}
