/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.PropertyReference
 *  kotlin.reflect.KMutableProperty
 */
package kotlin.jvm.internal;

import kotlin.jvm.internal.PropertyReference;
import kotlin.reflect.KMutableProperty;

public abstract class MutablePropertyReference
extends PropertyReference
implements KMutableProperty {
    public MutablePropertyReference() {
    }

    public MutablePropertyReference(Object object) {
        super(object);
    }

    public MutablePropertyReference(Object object, Class clazz, String string, String string2, int n) {
        super(object, clazz, string, string2, n);
    }
}
