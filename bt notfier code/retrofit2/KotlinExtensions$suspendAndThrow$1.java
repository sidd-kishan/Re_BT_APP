/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.DebugMetadata
 *  retrofit2.KotlinExtensions
 */
package retrofit2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import retrofit2.KotlinExtensions;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(bv={1, 0, 3}, d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00060\u0002j\u0002`\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0080@"}, d2={"suspendAndThrow", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k=3, mv={1, 1, 15})
@DebugMetadata(c="retrofit2.KotlinExtensions", f="KotlinExtensions.kt", i={0}, l={113}, m="suspendAndThrow", n={"$this$suspendAndThrow"}, s={"L$0"})
static final class KotlinExtensions.suspendAndThrow.1
extends ContinuationImpl {
    Object L$0;
    int label;
    Object result;

    KotlinExtensions.suspendAndThrow.1(Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return KotlinExtensions.suspendAndThrow(null, (Continuation)this);
    }
}
