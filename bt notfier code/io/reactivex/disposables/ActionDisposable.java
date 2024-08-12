/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.ReferenceDisposable
 *  io.reactivex.functions.Action
 *  io.reactivex.internal.util.ExceptionHelper
 */
package io.reactivex.disposables;

import io.reactivex.disposables.ReferenceDisposable;
import io.reactivex.functions.Action;
import io.reactivex.internal.util.ExceptionHelper;

final class ActionDisposable
extends ReferenceDisposable<Action> {
    private static final long serialVersionUID = -8219729196779211169L;

    ActionDisposable(Action action) {
        super((Object)action);
    }

    protected void onDisposed(Action action) {
        try {
            action.run();
            return;
        }
        catch (Throwable throwable) {
            throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
        }
    }
}
