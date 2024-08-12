/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.PropertyReference
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KCallable
 *  kotlin.reflect.KProperty0
 *  kotlin.reflect.KProperty0$Getter
 */
package kotlin.jvm.internal;

import kotlin.jvm.internal.PropertyReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty0;

public abstract class PropertyReference0
extends PropertyReference
implements KProperty0 {
    public PropertyReference0() {
    }

    public PropertyReference0(Object object) {
        super(object);
    }

    public PropertyReference0(Object object, Class clazz, String string, String string2, int n) {
        super(object, clazz, string, string2, n);
    }

    protected KCallable computeReflected() {
        return Reflection.property0((PropertyReference0)this);
    }

    public Object getDelegate() {
        return ((KProperty0)this.getReflected()).getDelegate();
    }

    public KProperty0.Getter getGetter() {
        return ((KProperty0)this.getReflected()).getGetter();
    }

    public Object invoke() {
        return this.get();
    }
}
