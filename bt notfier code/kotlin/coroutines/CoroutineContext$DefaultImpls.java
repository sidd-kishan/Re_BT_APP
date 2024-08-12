/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$plus$1
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k=3, mv={1, 5, 1})
public static final class CoroutineContext.DefaultImpls {
    public static CoroutineContext plus(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
        Intrinsics.checkNotNullParameter((Object)coroutineContext2, (String)"context");
        if (coroutineContext2 == EmptyCoroutineContext.INSTANCE) return coroutineContext;
        coroutineContext = (CoroutineContext)coroutineContext2.fold((Object)coroutineContext, (Function2)CoroutineContext.plus.1.INSTANCE);
        return coroutineContext;
    }
}
