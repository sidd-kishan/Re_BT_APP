/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 *  kotlin.jvm.internal.TypeReference
 *  kotlin.reflect.KTypeProjection
 */
package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KTypeProjection;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2={"<anonymous>", "", "it", "Lkotlin/reflect/KTypeProjection;", "invoke"}, k=3, mv={1, 5, 1})
static final class TypeReference.asString.args.1
extends Lambda
implements Function1<KTypeProjection, CharSequence> {
    final TypeReference this$0;

    TypeReference.asString.args.1(TypeReference typeReference) {
        this.this$0 = typeReference;
        super(1);
    }

    public final CharSequence invoke(KTypeProjection kTypeProjection) {
        Intrinsics.checkNotNullParameter((Object)kTypeProjection, (String)"it");
        return TypeReference.access$asString((TypeReference)this.this$0, (KTypeProjection)kTypeProjection);
    }
}
