/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.PropertyReference
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KCallable
 *  kotlin.reflect.KProperty1
 *  kotlin.reflect.KProperty1$Getter
 */
package kotlin.jvm.internal;

import kotlin.jvm.internal.PropertyReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty1;

public abstract class PropertyReference1
extends PropertyReference
implements KProperty1 {
    public PropertyReference1() {
    }

    public PropertyReference1(Object object) {
        super(object);
    }

    public PropertyReference1(Object object, Class clazz, String string, String string2, int n) {
        super(object, clazz, string, string2, n);
    }

    protected KCallable computeReflected() {
        return Reflection.property1((PropertyReference1)this);
    }

    public Object getDelegate(Object object) {
        return ((KProperty1)this.getReflected()).getDelegate(object);
    }

    public KProperty1.Getter getGetter() {
        return ((KProperty1)this.getReflected()).getGetter();
    }

    public Object invoke(Object object) {
        return this.get(object);
    }
}
