/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.ClassBasedDeclarationContainer
 *  kotlin.jvm.internal.MutablePropertyReference2
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KDeclarationContainer
 */
package kotlin.jvm.internal;

import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.MutablePropertyReference2;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

public class MutablePropertyReference2Impl
extends MutablePropertyReference2 {
    public MutablePropertyReference2Impl(Class clazz, String string, String string2, int n) {
        super(clazz, string, string2, n);
    }

    public MutablePropertyReference2Impl(KDeclarationContainer kDeclarationContainer, String string, String string2) {
        super(((ClassBasedDeclarationContainer)kDeclarationContainer).getJClass(), string, string2, kDeclarationContainer instanceof KClass ^ 1);
    }

    public Object get(Object object, Object object2) {
        return this.getGetter().call(new Object[]{object, object2});
    }

    public void set(Object object, Object object2, Object object3) {
        this.getSetter().call(new Object[]{object, object2, object3});
    }
}
