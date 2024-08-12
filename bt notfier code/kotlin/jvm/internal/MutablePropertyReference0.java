/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.MutablePropertyReference
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KCallable
 *  kotlin.reflect.KMutableProperty0
 *  kotlin.reflect.KMutableProperty0$Setter
 *  kotlin.reflect.KProperty0$Getter
 */
package kotlin.jvm.internal;

import kotlin.jvm.internal.MutablePropertyReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty0;

public abstract class MutablePropertyReference0
extends MutablePropertyReference
implements KMutableProperty0 {
    public MutablePropertyReference0() {
    }

    public MutablePropertyReference0(Object object) {
        super(object);
    }

    public MutablePropertyReference0(Object object, Class clazz, String string, String string2, int n) {
        super(object, clazz, string, string2, n);
    }

    protected KCallable computeReflected() {
        return Reflection.mutableProperty0((MutablePropertyReference0)this);
    }

    public Object getDelegate() {
        return ((KMutableProperty0)this.getReflected()).getDelegate();
    }

    public KProperty0.Getter getGetter() {
        return ((KMutableProperty0)this.getReflected()).getGetter();
    }

    public KMutableProperty0.Setter getSetter() {
        return ((KMutableProperty0)this.getReflected()).getSetter();
    }

    public Object invoke() {
        return this.get();
    }
}
