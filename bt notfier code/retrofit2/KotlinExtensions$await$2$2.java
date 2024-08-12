/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinNullPointerException
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
 *  retrofit2.Invocation
 *  retrofit2.Response
 */
package retrofit2;

import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Invocation;
import retrofit2.Response;

@Metadata(bv={1, 0, 3}, d1={"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016\u00a8\u0006\u000b"}, d2={"retrofit2/KotlinExtensions$await$2$2", "Lretrofit2/Callback;", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "retrofit"}, k=1, mv={1, 1, 15})
public static final class KotlinExtensions.await.2.2
implements Callback<T> {
    final CancellableContinuation $continuation;

    KotlinExtensions.await.2.2(CancellableContinuation cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public void onFailure(Call<T> continuation, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(continuation, (String)"call");
        Intrinsics.checkParameterIsNotNull((Object)throwable, (String)"t");
        continuation = (Continuation)this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.constructor_impl((Object)ResultKt.createFailure((Throwable)throwable)));
    }

    public void onResponse(Call<T> object, Response<T> object2) {
        Intrinsics.checkParameterIsNotNull(object, (String)"call");
        Intrinsics.checkParameterIsNotNull(object2, (String)"response");
        if (object2.isSuccessful()) {
            if ((object2 = object2.body()) == null) {
                if ((object = object.request().tag(Invocation.class)) == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull((Object)object, (String)"call.request().tag(Invocation::class.java)!!");
                object = ((Invocation)object).method();
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Response from ");
                Intrinsics.checkExpressionValueIsNotNull((Object)object, (String)"method");
                Result.Companion companion = ((Method)object).getDeclaringClass();
                Intrinsics.checkExpressionValueIsNotNull(companion, (String)"method.declaringClass");
                ((StringBuilder)object2).append(companion.getName());
                ((StringBuilder)object2).append('.');
                ((StringBuilder)object2).append(((Method)object).getName());
                ((StringBuilder)object2).append(" was null but response body type was declared as non-null");
                object2 = new KotlinNullPointerException(((StringBuilder)object2).toString());
                object = (Continuation)this.$continuation;
                companion = Result.Companion;
                object.resumeWith(Result.constructor_impl((Object)ResultKt.createFailure((Throwable)((Throwable)object2))));
            } else {
                Continuation continuation = (Continuation)this.$continuation;
                object = Result.Companion;
                continuation.resumeWith(Result.constructor_impl(object2));
            }
        } else {
            object = (Continuation)this.$continuation;
            object2 = (Throwable)new HttpException(object2);
            Result.Companion companion = Result.Companion;
            object.resumeWith(Result.constructor_impl((Object)ResultKt.createFailure(object2)));
        }
    }
}
