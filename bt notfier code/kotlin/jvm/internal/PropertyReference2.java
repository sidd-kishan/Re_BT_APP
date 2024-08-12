/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.PropertyReference
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KCallable
 *  kotlin.reflect.KProperty2
 *  kotlin.reflect.KProperty2$Getter
 */
package kotlin.jvm.internal;

import kotlin.jvm.internal.PropertyReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty2;

public abstract class PropertyReference2
extends PropertyReference
implements KProperty2 {
    public PropertyReference2() {
    }

    public PropertyReference2(Class clazz, String string, String string2, int n) {
        super(NO_RECEIVER, clazz, string, string2, n);
    }

    protected KCallable computeReflected() {
        return Reflection.property2((PropertyReference2)this);
    }

    public Object getDelegate(Object object, Object object2) {
        return ((KProperty2)this.getReflected()).getDelegate(object, object2);
    }

    public KProperty2.Getter getGetter() {
        return ((KProperty2)this.getReflected()).getGetter();
    }

    public Object invoke(Object object, Object object2) {
        return this.get(object, object2);
    }
}
