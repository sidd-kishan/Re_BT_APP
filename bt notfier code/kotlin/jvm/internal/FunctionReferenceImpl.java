/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.ClassBasedDeclarationContainer
 *  kotlin.jvm.internal.FunctionReference
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KDeclarationContainer
 */
package kotlin.jvm.internal;

import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.FunctionReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

public class FunctionReferenceImpl
extends FunctionReference {
    public FunctionReferenceImpl(int n, Class clazz, String string, String string2, int n2) {
        super(n, NO_RECEIVER, clazz, string, string2, n2);
    }

    public FunctionReferenceImpl(int n, Object object, Class clazz, String string, String string2, int n2) {
        super(n, object, clazz, string, string2, n2);
    }

    public FunctionReferenceImpl(int n, KDeclarationContainer kDeclarationContainer, String string, String string2) {
        super(n, NO_RECEIVER, ((ClassBasedDeclarationContainer)kDeclarationContainer).getJClass(), string, string2, kDeclarationContainer instanceof KClass ^ 1);
    }
}
