/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.internal.PlatformImplementations
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.internal.jdk7;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.internal.PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2={"Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "Lkotlin/internal/PlatformImplementations;", "()V", "addSuppressed", "", "cause", "", "exception", "getSuppressed", "", "kotlin-stdlib-jdk7"}, k=1, mv={1, 5, 1})
public class JDK7PlatformImplementations
extends PlatformImplementations {
    public void addSuppressed(Throwable throwable, Throwable throwable2) {
        Intrinsics.checkNotNullParameter((Object)throwable, (String)"cause");
        Intrinsics.checkNotNullParameter((Object)throwable2, (String)"exception");
        throwable.addSuppressed(throwable2);
    }

    public List<Throwable> getSuppressed(Throwable objectArray) {
        Intrinsics.checkNotNullParameter((Object)objectArray, (String)"exception");
        objectArray = objectArray.getSuppressed();
        Intrinsics.checkNotNullExpressionValue((Object)objectArray, (String)"exception.suppressed");
        return ArraysKt.asList((Object[])objectArray);
    }
}
