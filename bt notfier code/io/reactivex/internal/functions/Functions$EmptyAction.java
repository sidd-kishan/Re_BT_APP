/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Action
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.Action;

static final class Functions.EmptyAction
implements Action {
    Functions.EmptyAction() {
    }

    public void run() {
    }

    public String toString() {
        return "EmptyAction";
    }
}
