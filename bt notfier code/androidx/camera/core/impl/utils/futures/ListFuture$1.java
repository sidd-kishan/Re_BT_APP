/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.futures.ListFuture
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.futures.ListFuture;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import java.util.List;

class ListFuture.1
implements CallbackToFutureAdapter.Resolver<List<V>> {
    final ListFuture this$0;

    ListFuture.1(ListFuture listFuture) {
        this.this$0 = listFuture;
    }

    public Object attachCompleter(CallbackToFutureAdapter.Completer<List<V>> object) {
        boolean bl = this.this$0.mResultNotifier == null;
        Preconditions.checkState((boolean)bl, (String)"The result can only set once!");
        this.this$0.mResultNotifier = object;
        object = new StringBuilder();
        ((StringBuilder)object).append("ListFuture[");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append("]");
        return ((StringBuilder)object).toString();
    }
}
