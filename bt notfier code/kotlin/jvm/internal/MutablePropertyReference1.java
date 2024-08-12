/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.MutablePropertyReference
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KCallable
 *  kotlin.reflect.KMutableProperty1
 *  kotlin.reflect.KMutableProperty1$Setter
 *  kotlin.reflect.KProperty1$Getter
 */
package kotlin.jvm.internal;

import kotlin.jvm.internal.MutablePropertyReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty1;

public abstract class MutablePropertyReference1
extends MutablePropertyReference
implements KMutableProperty1 {
    public MutablePropertyReference1() {
    }

    public MutablePropertyReference1(Object object) {
        super(object);
    }

    public MutablePropertyReference1(Object object, Class clazz, String string, String string2, int n) {
        super(object, clazz, string, string2, n);
    }

    protected KCallable computeReflected() {
        return Reflection.mutableProperty1((MutablePropertyReference1)this);
    }

    public Object getDelegate(Object object) {
        return ((KMutableProperty1)this.getReflected()).getDelegate(object);
    }

    public KProperty1.Getter getGetter() {
        return ((KMutableProperty1)this.getReflected()).getGetter();
    }

    public KMutableProperty1.Setter getSetter() {
        return ((KMutableProperty1)this.getReflected()).getSetter();
    }

    public Object invoke(Object object) {
        return this.get(object);
    }
}
