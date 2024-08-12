/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.reflect.KMutableProperty$Setter
 *  kotlin.reflect.KProperty
 */
package kotlin.reflect;

import kotlin.Metadata;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0007R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2={"Lkotlin/reflect/KMutableProperty;", "V", "Lkotlin/reflect/KProperty;", "setter", "Lkotlin/reflect/KMutableProperty$Setter;", "getSetter", "()Lkotlin/reflect/KMutableProperty$Setter;", "Setter", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public interface KMutableProperty<V>
extends KProperty<V> {
    public Setter<V> getSetter();
}
