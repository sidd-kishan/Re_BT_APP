/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

static final class ObservableReplay.Node
extends AtomicReference<ObservableReplay.Node> {
    private static final long serialVersionUID = 245354315435971818L;
    final Object value;

    ObservableReplay.Node(Object object) {
        this.value = object;
    }
}
