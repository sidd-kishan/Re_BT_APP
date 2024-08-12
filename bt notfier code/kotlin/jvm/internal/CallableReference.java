/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.KotlinReflectionNotSupportedError
 *  kotlin.jvm.internal.CallableReference$NoReceiver
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KCallable
 *  kotlin.reflect.KDeclarationContainer
 *  kotlin.reflect.KParameter
 *  kotlin.reflect.KType
 *  kotlin.reflect.KTypeParameter
 *  kotlin.reflect.KVisibility
 */
package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;

public abstract class CallableReference
implements KCallable,
Serializable {
    public static final Object NO_RECEIVER = NoReceiver.access$000();
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient KCallable reflected;
    private final String signature;

    public CallableReference() {
        this(NO_RECEIVER);
    }

    protected CallableReference(Object object) {
        this(object, null, null, null, false);
    }

    protected CallableReference(Object object, Class clazz, String string, String string2, boolean bl) {
        this.receiver = object;
        this.owner = clazz;
        this.name = string;
        this.signature = string2;
        this.isTopLevel = bl;
    }

    public Object call(Object ... objectArray) {
        return this.getReflected().call(objectArray);
    }

    public Object callBy(Map map) {
        return this.getReflected().callBy(map);
    }

    public KCallable compute() {
        KCallable kCallable;
        KCallable kCallable2 = kCallable = this.reflected;
        if (kCallable != null) return kCallable2;
        this.reflected = kCallable2 = this.computeReflected();
        return kCallable2;
    }

    protected abstract KCallable computeReflected();

    public List<Annotation> getAnnotations() {
        return this.getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public KDeclarationContainer getOwner() {
        Object object = this.owner;
        object = object == null ? null : (this.isTopLevel ? Reflection.getOrCreateKotlinPackage((Class)object) : Reflection.getOrCreateKotlinClass((Class)object));
        return object;
    }

    public List<KParameter> getParameters() {
        return this.getReflected().getParameters();
    }

    protected KCallable getReflected() {
        KCallable kCallable = this.compute();
        if (kCallable == this) throw new KotlinReflectionNotSupportedError();
        return kCallable;
    }

    public KType getReturnType() {
        return this.getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    public List<KTypeParameter> getTypeParameters() {
        return this.getReflected().getTypeParameters();
    }

    public KVisibility getVisibility() {
        return this.getReflected().getVisibility();
    }

    public boolean isAbstract() {
        return this.getReflected().isAbstract();
    }

    public boolean isFinal() {
        return this.getReflected().isFinal();
    }

    public boolean isOpen() {
        return this.getReflected().isOpen();
    }

    public boolean isSuspend() {
        return this.getReflected().isSuspend();
    }
}
