/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Result$Companion
 *  kotlin.ResultKt
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.CancellableContinuation
 *  retrofit2.Call
 *  retrofit2.Callback
 *  retrofit2.HttpException
 *  retrofit2.Response
 */
package retrofit2;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

@Metadata(bv={1, 0, 3}, d1={"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001J \u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J(\u0010\b\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\nH\u0016\u00a8\u0006\u000b"}, d2={"retrofit2/KotlinExtensions$await$4$2", "Lretrofit2/Callback;", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "retrofit"}, k=1, mv={1, 1, 15})
public static final class KotlinExtensions.await.4.2
implements Callback<T> {
    final CancellableContinuation $continuation;

    KotlinExtensions.await.4.2(CancellableContinuation cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public void onFailure(Call<T> companion, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(companion, (String)"call");
        Intrinsics.checkParameterIsNotNull((Object)throwable, (String)"t");
        Continuation continuation = (Continuation)this.$continuation;
        companion = Result.Companion;
        continuation.resumeWith(Result.constructor_impl((Object)ResultKt.createFailure((Throwable)throwable)));
    }

    public void onResponse(Call<T> continuation, Response<T> companion) {
        Intrinsics.checkParameterIsNotNull(continuation, (String)"call");
        Intrinsics.checkParameterIsNotNull(companion, (String)"response");
        if (companion.isSuccessful()) {
            continuation = (Continuation)this.$continuation;
            companion = companion.body();
            Result.Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.constructor_impl(companion));
        } else {
            continuation = (Continuation)this.$continuation;
            Throwable throwable = (Throwable)new HttpException(companion);
            companion = Result.Companion;
            continuation.resumeWith(Result.constructor_impl((Object)ResultKt.createFailure((Throwable)throwable)));
        }
    }
}
