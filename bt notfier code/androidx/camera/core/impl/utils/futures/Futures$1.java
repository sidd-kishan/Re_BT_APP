/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.util.Function
 *  androidx.camera.core.impl.utils.futures.AsyncFunction
 *  androidx.camera.core.impl.utils.futures.Futures
 */
package androidx.camera.core.impl.utils.futures;

import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/*
 * Exception performing whole class analysis ignored.
 */
class Futures.1
implements AsyncFunction<I, O> {
    final Function val$function;

    Futures.1(Function function) {
        this.val$function = function;
    }

    public ListenableFuture<O> apply(I i) {
        return Futures.immediateFuture((Object)this.val$function.apply(i));
    }
}
