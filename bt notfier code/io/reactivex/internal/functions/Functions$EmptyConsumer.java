/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Consumer
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.Consumer;

static final class Functions.EmptyConsumer
implements Consumer<Object> {
    Functions.EmptyConsumer() {
    }

    public void accept(Object object) {
    }

    public String toString() {
        return "EmptyConsumer";
    }
}
