/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.CancellableContinuation
 *  kotlinx.coroutines.CancellableContinuationImpl
 *  kotlinx.coroutines.Dispatchers
 *  retrofit2.Call
 *  retrofit2.Callback
 *  retrofit2.KotlinExtensions$suspendAndThrow$1
 *  retrofit2.Response
 *  retrofit2.Retrofit
 */
package retrofit2;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.KotlinExtensions;
import retrofit2.Response;
import retrofit2.Retrofit;

@Metadata(bv={1, 0, 3}, d1={"\u0000.\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004\u001a+\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0003H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0004\u001a'\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004\u001a\u001a\u0010\b\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\tH\u0086\b\u00a2\u0006\u0002\u0010\n\u001a\u0019\u0010\u000b\u001a\u00020\f*\u00060\rj\u0002`\u000eH\u0080@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2={"await", "T", "", "Lretrofit2/Call;", "(Lretrofit2/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitNullable", "awaitResponse", "Lretrofit2/Response;", "create", "Lretrofit2/Retrofit;", "(Lretrofit2/Retrofit;)Ljava/lang/Object;", "suspendAndThrow", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrofit"}, k=2, mv={1, 1, 15})
public final class KotlinExtensions {
    public static final <T> Object await(Call<T> object, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        CancellableContinuation cancellableContinuation = (CancellableContinuation)cancellableContinuationImpl;
        cancellableContinuation.invokeOnCancellation((Function1)new /* Unavailable Anonymous Inner Class!! */);
        object.enqueue((Callback)new /* Unavailable Anonymous Inner Class!! */);
        object = cancellableContinuationImpl.getResult();
        if (object != IntrinsicsKt.getCOROUTINE_SUSPENDED()) return object;
        DebugProbesKt.probeCoroutineSuspended(continuation);
        return object;
    }

    public static final <T> Object awaitNullable(Call<T> object, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        CancellableContinuation cancellableContinuation = (CancellableContinuation)cancellableContinuationImpl;
        cancellableContinuation.invokeOnCancellation((Function1)new /* Unavailable Anonymous Inner Class!! */);
        object.enqueue((Callback)new /* Unavailable Anonymous Inner Class!! */);
        object = cancellableContinuationImpl.getResult();
        if (object != IntrinsicsKt.getCOROUTINE_SUSPENDED()) return object;
        DebugProbesKt.probeCoroutineSuspended(continuation);
        return object;
    }

    public static final <T> Object awaitResponse(Call<T> object, Continuation<? super Response<T>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        CancellableContinuation cancellableContinuation = (CancellableContinuation)cancellableContinuationImpl;
        cancellableContinuation.invokeOnCancellation((Function1)new /* Unavailable Anonymous Inner Class!! */);
        object.enqueue((Callback)new /* Unavailable Anonymous Inner Class!! */);
        object = cancellableContinuationImpl.getResult();
        if (object != IntrinsicsKt.getCOROUTINE_SUSPENDED()) return object;
        DebugProbesKt.probeCoroutineSuspended(continuation);
        return object;
    }

    public static final /* synthetic */ <T> T create(Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull((Object)retrofit, (String)"$this$create");
        Intrinsics.reifiedOperationMarker((int)4, (String)"T");
        return (T)retrofit.create(Object.class);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final Object suspendAndThrow(Exception var0, Continuation<?> var1_1) {
        if (!(var1_1 instanceof suspendAndThrow.1)) ** GOTO lbl-1000
        var3_2 /* !! */  = var1_1;
        if ((var3_2 /* !! */ .label & -2147483648) != 0) {
            var3_2 /* !! */ .label += -2147483648;
            var1_1 = var3_2 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var1_1 = new /* Unavailable Anonymous Inner Class!! */;
        }
        var4_3 = var1_1.result;
        var3_2 /* !! */  = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        var2_4 = var1_1.label;
        if (var2_4 != 0) {
            if (var2_4 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            var0 = (Exception)var1_1.L$0;
            ResultKt.throwOnFailure((Object)var4_3);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure((Object)var4_3);
        var1_1.L$0 = var0;
        var1_1.label = 1;
        var1_1 = (Continuation)var1_1;
        Dispatchers.getDefault().dispatch(var1_1.getContext(), (Runnable)new /* Unavailable Anonymous Inner Class!! */);
        var0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (var0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended((Continuation)var1_1);
        }
        if (var0 != var3_2 /* !! */ ) return Unit.INSTANCE;
        return var3_2 /* !! */ ;
    }
}
