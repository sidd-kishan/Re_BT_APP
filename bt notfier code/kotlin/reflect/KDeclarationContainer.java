/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.reflect.KCallable
 */
package kotlin.reflect;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.reflect.KCallable;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lkotlin/reflect/KDeclarationContainer;", "", "members", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public interface KDeclarationContainer {
    public Collection<KCallable<?>> getMembers();
}
