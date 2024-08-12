/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.CallableReference
 *  kotlin.jvm.internal.FunctionBase
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KCallable
 *  kotlin.reflect.KFunction
 */
package kotlin.jvm.internal;

import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

public class FunctionReference
extends CallableReference
implements FunctionBase,
KFunction {
    private final int arity;
    private final int flags;

    public FunctionReference(int n) {
        this(n, NO_RECEIVER, null, null, null, 0);
    }

    public FunctionReference(int n, Object object) {
        this(n, object, null, null, null, 0);
    }

    public FunctionReference(int n, Object object, Class clazz, String string, String string2, int n2) {
        boolean bl = (n2 & 1) == 1;
        super(object, clazz, string, string2, bl);
        this.arity = n;
        this.flags = n2 >> 1;
    }

    protected KCallable computeReflected() {
        return Reflection.function((FunctionReference)this);
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof FunctionReference)) {
            if (!(object instanceof KFunction)) return false;
            return object.equals(this.compute());
        }
        object = (FunctionReference)((Object)object);
        if (Intrinsics.areEqual((Object)this.getOwner(), (Object)object.getOwner()) && this.getName().equals(object.getName()) && this.getSignature().equals(object.getSignature()) && this.flags == ((FunctionReference)((Object)object)).flags && this.arity == ((FunctionReference)((Object)object)).arity && Intrinsics.areEqual((Object)this.getBoundReceiver(), (Object)object.getBoundReceiver())) return bl;
        bl = false;
        return bl;
    }

    public int getArity() {
        return this.arity;
    }

    protected KFunction getReflected() {
        return (KFunction)super.getReflected();
    }

    public int hashCode() {
        int n = this.getOwner() == null ? 0 : this.getOwner().hashCode() * 31;
        return (n + this.getName().hashCode()) * 31 + this.getSignature().hashCode();
    }

    public boolean isExternal() {
        return this.getReflected().isExternal();
    }

    public boolean isInfix() {
        return this.getReflected().isInfix();
    }

    public boolean isInline() {
        return this.getReflected().isInline();
    }

    public boolean isOperator() {
        return this.getReflected().isOperator();
    }

    public boolean isSuspend() {
        return this.getReflected().isSuspend();
    }

    public String toString() {
        Object object = this.compute();
        if (object != this) {
            return object.toString();
        }
        if ("<init>".equals(this.getName())) {
            object = "constructor (Kotlin reflection is not available)";
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append("function ");
            ((StringBuilder)object).append(this.getName());
            ((StringBuilder)object).append(" (Kotlin reflection is not available)");
            object = ((StringBuilder)object).toString();
        }
        return object;
    }
}
