/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.ClassBasedDeclarationContainer
 *  kotlin.jvm.internal.PropertyReference2
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KDeclarationContainer
 */
package kotlin.jvm.internal;

import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.PropertyReference2;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

public class PropertyReference2Impl
extends PropertyReference2 {
    public PropertyReference2Impl(Class clazz, String string, String string2, int n) {
        super(clazz, string, string2, n);
    }

    public PropertyReference2Impl(KDeclarationContainer kDeclarationContainer, String string, String string2) {
        super(((ClassBasedDeclarationContainer)kDeclarationContainer).getJClass(), string, string2, kDeclarationContainer instanceof KClass ^ 1);
    }

    public Object get(Object object, Object object2) {
        return this.getGetter().call(new Object[]{object, object2});
    }
}
