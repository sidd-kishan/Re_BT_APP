/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.jvm.internal.RestrictedContinuationImpl
 *  kotlin.coroutines.jvm.internal.SuspendFunction
 *  kotlin.jvm.internal.FunctionBase
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 */
package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b!\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u00020\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2={"Lkotlin/coroutines/jvm/internal/RestrictedSuspendLambda;", "Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "Lkotlin/jvm/internal/FunctionBase;", "", "Lkotlin/coroutines/jvm/internal/SuspendFunction;", "arity", "", "(I)V", "completion", "Lkotlin/coroutines/Continuation;", "(ILkotlin/coroutines/Continuation;)V", "getArity", "()I", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class RestrictedSuspendLambda
extends RestrictedContinuationImpl
implements FunctionBase<Object>,
SuspendFunction {
    private final int arity;

    public RestrictedSuspendLambda(int n) {
        this(n, null);
    }

    public RestrictedSuspendLambda(int n, Continuation<Object> continuation) {
        super(continuation);
        this.arity = n;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String string;
        if (this.getCompletion() == null) {
            string = Reflection.renderLambdaToString((FunctionBase)this);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"Reflection.renderLambdaToString(this)");
        } else {
            string = super.toString();
        }
        return string;
    }
}
