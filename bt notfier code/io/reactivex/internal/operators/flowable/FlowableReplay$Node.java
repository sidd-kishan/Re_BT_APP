/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicReference;

static final class FlowableReplay.Node
extends AtomicReference<FlowableReplay.Node> {
    private static final long serialVersionUID = 245354315435971818L;
    final long index;
    final Object value;

    FlowableReplay.Node(Object object, long l) {
        this.value = object;
        this.index = l;
    }
}
