/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.futures.FutureChain
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;

class FutureChain.1
implements CallbackToFutureAdapter.Resolver<V> {
    final FutureChain this$0;

    FutureChain.1(FutureChain futureChain) {
        this.this$0 = futureChain;
    }

    public Object attachCompleter(CallbackToFutureAdapter.Completer<V> object) {
        boolean bl = this.this$0.mCompleter == null;
        Preconditions.checkState((boolean)bl, (String)"The result can only set once!");
        this.this$0.mCompleter = object;
        object = new StringBuilder();
        ((StringBuilder)object).append("FutureChain[");
        ((StringBuilder)object).append(this.this$0);
        ((StringBuilder)object).append("]");
        return ((StringBuilder)object).toString();
    }
}
