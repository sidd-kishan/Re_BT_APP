/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.MutablePropertyReference
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KCallable
 *  kotlin.reflect.KMutableProperty2
 *  kotlin.reflect.KMutableProperty2$Setter
 *  kotlin.reflect.KProperty2$Getter
 */
package kotlin.jvm.internal;

import kotlin.jvm.internal.MutablePropertyReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty2;

public abstract class MutablePropertyReference2
extends MutablePropertyReference
implements KMutableProperty2 {
    public MutablePropertyReference2() {
    }

    public MutablePropertyReference2(Class clazz, String string, String string2, int n) {
        super(NO_RECEIVER, clazz, string, string2, n);
    }

    protected KCallable computeReflected() {
        return Reflection.mutableProperty2((MutablePropertyReference2)this);
    }

    public Object getDelegate(Object object, Object object2) {
        return ((KMutableProperty2)this.getReflected()).getDelegate(object, object2);
    }

    public KProperty2.Getter getGetter() {
        return ((KMutableProperty2)this.getReflected()).getGetter();
    }

    public KMutableProperty2.Setter getSetter() {
        return ((KMutableProperty2)this.getReflected()).getSetter();
    }

    public Object invoke(Object object, Object object2) {
        return this.get(object, object2);
    }
}
