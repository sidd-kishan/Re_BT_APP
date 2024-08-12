/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.ClassBasedDeclarationContainer
 *  kotlin.jvm.internal.MutablePropertyReference0
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KDeclarationContainer
 */
package kotlin.jvm.internal;

import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

public class MutablePropertyReference0Impl
extends MutablePropertyReference0 {
    public MutablePropertyReference0Impl(Class clazz, String string, String string2, int n) {
        super(NO_RECEIVER, clazz, string, string2, n);
    }

    public MutablePropertyReference0Impl(Object object, Class clazz, String string, String string2, int n) {
        super(object, clazz, string, string2, n);
    }

    public MutablePropertyReference0Impl(KDeclarationContainer kDeclarationContainer, String string, String string2) {
        super(NO_RECEIVER, ((ClassBasedDeclarationContainer)kDeclarationContainer).getJClass(), string, string2, kDeclarationContainer instanceof KClass ^ 1);
    }

    public Object get() {
        return this.getGetter().call(new Object[0]);
    }

    public void set(Object object) {
        this.getSetter().call(new Object[]{object});
    }
}
