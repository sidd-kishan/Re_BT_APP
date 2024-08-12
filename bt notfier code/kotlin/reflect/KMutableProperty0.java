/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.reflect.KMutableProperty
 *  kotlin.reflect.KMutableProperty0$Setter
 *  kotlin.reflect.KProperty0
 */
package kotlin.reflect;

import kotlin.Metadata;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty0;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\fJ\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u000bR\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\r"}, d2={"Lkotlin/reflect/KMutableProperty0;", "V", "Lkotlin/reflect/KProperty0;", "Lkotlin/reflect/KMutableProperty;", "setter", "Lkotlin/reflect/KMutableProperty0$Setter;", "getSetter", "()Lkotlin/reflect/KMutableProperty0$Setter;", "set", "", "value", "(Ljava/lang/Object;)V", "Setter", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public interface KMutableProperty0<V>
extends KProperty0<V>,
KMutableProperty<V> {
    public Setter<V> getSetter();

    public void set(V var1);
}
