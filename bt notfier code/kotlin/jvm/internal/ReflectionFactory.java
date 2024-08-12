/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.ClassReference
 *  kotlin.jvm.internal.FunctionBase
 *  kotlin.jvm.internal.FunctionReference
 *  kotlin.jvm.internal.Lambda
 *  kotlin.jvm.internal.MutablePropertyReference0
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference2
 *  kotlin.jvm.internal.PackageReference
 *  kotlin.jvm.internal.PropertyReference0
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference2
 *  kotlin.jvm.internal.TypeParameterReference
 *  kotlin.jvm.internal.TypeReference
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KClassifier
 *  kotlin.reflect.KDeclarationContainer
 *  kotlin.reflect.KFunction
 *  kotlin.reflect.KMutableProperty0
 *  kotlin.reflect.KMutableProperty1
 *  kotlin.reflect.KMutableProperty2
 *  kotlin.reflect.KProperty0
 *  kotlin.reflect.KProperty1
 *  kotlin.reflect.KProperty2
 *  kotlin.reflect.KType
 *  kotlin.reflect.KTypeParameter
 *  kotlin.reflect.KTypeProjection
 *  kotlin.reflect.KVariance
 */
package kotlin.jvm.internal;

import java.util.List;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference2;
import kotlin.jvm.internal.PackageReference;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference2;
import kotlin.jvm.internal.TypeParameterReference;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

public class ReflectionFactory {
    private static final String KOTLIN_JVM_FUNCTIONS = "kotlin.jvm.functions.";

    public KClass createKotlinClass(Class clazz) {
        return new ClassReference(clazz);
    }

    public KClass createKotlinClass(Class clazz, String string) {
        return new ClassReference(clazz);
    }

    public KFunction function(FunctionReference functionReference) {
        return functionReference;
    }

    public KClass getOrCreateKotlinClass(Class clazz) {
        return new ClassReference(clazz);
    }

    public KClass getOrCreateKotlinClass(Class clazz, String string) {
        return new ClassReference(clazz);
    }

    public KDeclarationContainer getOrCreateKotlinPackage(Class clazz, String string) {
        return new PackageReference(clazz, string);
    }

    public KMutableProperty0 mutableProperty0(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public KMutableProperty1 mutableProperty1(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public KMutableProperty2 mutableProperty2(MutablePropertyReference2 mutablePropertyReference2) {
        return mutablePropertyReference2;
    }

    public KProperty0 property0(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public KProperty1 property1(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public KProperty2 property2(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }

    public String renderLambdaToString(FunctionBase object) {
        String string = object.getClass().getGenericInterfaces()[0].toString();
        object = string;
        if (!string.startsWith(KOTLIN_JVM_FUNCTIONS)) return object;
        object = string.substring(21);
        return object;
    }

    public String renderLambdaToString(Lambda lambda) {
        return this.renderLambdaToString((FunctionBase)lambda);
    }

    public void setUpperBounds(KTypeParameter kTypeParameter, List<KType> list) {
        ((TypeParameterReference)kTypeParameter).setUpperBounds(list);
    }

    public KType typeOf(KClassifier kClassifier, List<KTypeProjection> list, boolean bl) {
        return new TypeReference(kClassifier, list, bl);
    }

    public KTypeParameter typeParameter(Object object, String string, KVariance kVariance, boolean bl) {
        return new TypeParameterReference(object, string, kVariance, bl);
    }
}
