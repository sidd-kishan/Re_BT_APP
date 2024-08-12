/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Call
 */
package retrofit2;

import java.util.concurrent.CompletableFuture;
import retrofit2.Call;

private static final class CompletableFutureCallAdapterFactory.CallCancelCompletableFuture<T>
extends CompletableFuture<T> {
    private final Call<?> call;

    CompletableFutureCallAdapterFactory.CallCancelCompletableFuture(Call<?> call) {
        this.call = call;
    }

    @Override
    public boolean cancel(boolean bl) {
        if (!bl) return super.cancel(bl);
        this.call.cancel();
        return super.cancel(bl);
    }
}
