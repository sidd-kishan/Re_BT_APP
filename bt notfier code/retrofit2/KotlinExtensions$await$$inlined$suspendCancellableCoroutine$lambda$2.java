/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Lambda
 *  retrofit2.Call
 */
package retrofit2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import retrofit2.Call;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n\u00a2\u0006\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"<anonymous>", "", "T", "", "it", "", "invoke", "retrofit2/KotlinExtensions$await$4$1"}, k=3, mv={1, 1, 15})
static final class KotlinExtensions$await$.inlined.suspendCancellableCoroutine.lambda.2
extends Lambda
implements Function1<Throwable, Unit> {
    final Call $this_await$inlined;

    KotlinExtensions$await$.inlined.suspendCancellableCoroutine.lambda.2(Call call) {
        this.$this_await$inlined = call;
        super(1);
    }

    public final void invoke(Throwable throwable) {
        this.$this_await$inlined.cancel();
    }
}
