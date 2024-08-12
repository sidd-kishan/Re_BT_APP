/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.ClassBasedDeclarationContainer
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KDeclarationContainer
 */
package kotlin.jvm.internal;

import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

public class PropertyReference1Impl
extends PropertyReference1 {
    public PropertyReference1Impl(Class clazz, String string, String string2, int n) {
        super(NO_RECEIVER, clazz, string, string2, n);
    }

    public PropertyReference1Impl(Object object, Class clazz, String string, String string2, int n) {
        super(object, clazz, string, string2, n);
    }

    public PropertyReference1Impl(KDeclarationContainer kDeclarationContainer, String string, String string2) {
        super(NO_RECEIVER, ((ClassBasedDeclarationContainer)kDeclarationContainer).getJClass(), string, string2, kDeclarationContainer instanceof KClass ^ 1);
    }

    public Object get(Object object) {
        return this.getGetter().call(new Object[]{object});
    }
}
