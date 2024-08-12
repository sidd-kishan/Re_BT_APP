/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.exceptions;

static final class CompositeException.CompositeExceptionCausalChain
extends RuntimeException {
    static final String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
    private static final long serialVersionUID = 3875212506787802066L;

    CompositeException.CompositeExceptionCausalChain() {
    }

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
