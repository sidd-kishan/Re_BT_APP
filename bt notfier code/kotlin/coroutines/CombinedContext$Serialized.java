/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CombinedContext$Serialized$Companion
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.coroutines;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.coroutines.CombinedContext;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \f2\u00060\u0001j\u0002`\u0002:\u0001\fB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2={"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "elements", "", "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
private static final class CombinedContext.Serialized
implements Serializable {
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 0L;
    private final CoroutineContext[] elements;

    public CombinedContext.Serialized(CoroutineContext[] coroutineContextArray) {
        Intrinsics.checkNotNullParameter((Object)coroutineContextArray, (String)"elements");
        this.elements = coroutineContextArray;
    }

    private final Object readResolve() {
        CoroutineContext[] coroutineContextArray = this.elements;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        int n = coroutineContextArray.length;
        int n2 = 0;
        while (n2 < n) {
            CoroutineContext coroutineContext = coroutineContextArray[n2];
            emptyCoroutineContext = ((CoroutineContext)emptyCoroutineContext).plus(coroutineContext);
            ++n2;
        }
        return emptyCoroutineContext;
    }

    public final CoroutineContext[] getElements() {
        return this.elements;
    }
}
