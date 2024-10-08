/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.properties.ReadWriteProperty
 *  kotlin.reflect.KProperty
 */
package kotlin.properties;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0007\u001a\u00028\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u00022\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0096\u0002\u00a2\u0006\u0002\u0010\u000bJ,\u0010\f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0005\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u000eR\u0012\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\u000f"}, d2={"Lkotlin/properties/NotNullVar;", "T", "", "Lkotlin/properties/ReadWriteProperty;", "()V", "value", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class NotNullVar<T>
implements ReadWriteProperty<Object, T> {
    private T value;

    public T getValue(Object object, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, (String)"property");
        object = this.value;
        if (object != null) {
            return (T)object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Property ");
        ((StringBuilder)object).append(kProperty.getName());
        ((StringBuilder)object).append(" should be initialized before get.");
        throw (Throwable)new IllegalStateException(((StringBuilder)object).toString());
    }

    public void setValue(Object object, KProperty<?> kProperty, T t) {
        Intrinsics.checkNotNullParameter(kProperty, (String)"property");
        Intrinsics.checkNotNullParameter(t, (String)"value");
        this.value = t;
    }
}
