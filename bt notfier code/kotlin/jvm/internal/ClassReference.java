/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Function
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmClassMappingKt
 *  kotlin.jvm.KotlinReflectionNotSupportedError
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function10
 *  kotlin.jvm.functions.Function11
 *  kotlin.jvm.functions.Function12
 *  kotlin.jvm.functions.Function13
 *  kotlin.jvm.functions.Function14
 *  kotlin.jvm.functions.Function15
 *  kotlin.jvm.functions.Function16
 *  kotlin.jvm.functions.Function17
 *  kotlin.jvm.functions.Function18
 *  kotlin.jvm.functions.Function19
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function20
 *  kotlin.jvm.functions.Function21
 *  kotlin.jvm.functions.Function22
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.functions.Function5
 *  kotlin.jvm.functions.Function6
 *  kotlin.jvm.functions.Function7
 *  kotlin.jvm.functions.Function8
 *  kotlin.jvm.functions.Function9
 *  kotlin.jvm.internal.ClassBasedDeclarationContainer
 *  kotlin.jvm.internal.ClassReference$Companion
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KCallable
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KFunction
 *  kotlin.reflect.KType
 *  kotlin.reflect.KTypeParameter
 *  kotlin.reflect.KVisibility
 *  kotlin.text.StringsKt
 */
package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001OB\u0011\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\u0013\u0010F\u001a\u00020\u00122\b\u0010G\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010H\u001a\u00020IH\u0002J\b\u0010J\u001a\u00020KH\u0016J\u0012\u0010L\u001a\u00020\u00122\b\u0010M\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010N\u001a\u000201H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00128VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00128VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00128VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00128VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u00128VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010 \u001a\u00020\u00128VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b!\u0010\u0014\u001a\u0004\b \u0010\u0015R\u001a\u0010\"\u001a\u00020\u00128VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b#\u0010\u0014\u001a\u0004\b\"\u0010\u0015R\u001a\u0010$\u001a\u00020\u00128VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b%\u0010\u0014\u001a\u0004\b$\u0010\u0015R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010\u0010R\u001e\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010\u0010R\u0016\u0010-\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010/R\u0016\u00100\u001a\u0004\u0018\u0001018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u00103R(\u00104\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\b8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b5\u0010\u0014\u001a\u0004\b6\u0010\u000bR\u0016\u00107\u001a\u0004\u0018\u0001018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00103R \u00109\u001a\b\u0012\u0004\u0012\u00020:0\b8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b;\u0010\u0014\u001a\u0004\b<\u0010\u000bR \u0010=\u001a\b\u0012\u0004\u0012\u00020>0\b8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b?\u0010\u0014\u001a\u0004\b@\u0010\u000bR\u001c\u0010A\u001a\u0004\u0018\u00010B8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\bC\u0010\u0014\u001a\u0004\bD\u0010E\u00a8\u0006P"}, d2={"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isFun", "isFun$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "isValue", "isValue$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "error", "", "hashCode", "", "isInstance", "value", "toString", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class ClassReference
implements KClass<Object>,
ClassBasedDeclarationContainer {
    public static final Companion Companion;
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;
    private static final HashMap<String, String> classFqNames;
    private static final HashMap<String, String> primitiveFqNames;
    private static final HashMap<String, String> primitiveWrapperFqNames;
    private static final Map<String, String> simpleNames;
    private final Class<?> jClass;

    static {
        Object object;
        Companion = new Companion(null);
        int n = 0;
        Object object2 = CollectionsKt.listOf((Object[])new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        Map<Object, String> map = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object2, (int)10));
        object2 = object2.iterator();
        while (object2.hasNext()) {
            object = object2.next();
            if (n < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            map.add(TuplesKt.to((Object)((Class)object), (Object)n));
            ++n;
        }
        FUNCTION_CLASSES = MapsKt.toMap((Iterable)((List)((Object)map)));
        map = new HashMap();
        ((HashMap)map).put("boolean", "kotlin.Boolean");
        ((HashMap)map).put("char", "kotlin.Char");
        ((HashMap)map).put("byte", "kotlin.Byte");
        ((HashMap)map).put("short", "kotlin.Short");
        ((HashMap)map).put("int", "kotlin.Int");
        ((HashMap)map).put("float", "kotlin.Float");
        ((HashMap)map).put("long", "kotlin.Long");
        ((HashMap)map).put("double", "kotlin.Double");
        primitiveFqNames = map;
        map = new HashMap<String, String>();
        ((HashMap)map).put("java.lang.Boolean", "kotlin.Boolean");
        ((HashMap)map).put("java.lang.Character", "kotlin.Char");
        ((HashMap)map).put("java.lang.Byte", "kotlin.Byte");
        ((HashMap)map).put("java.lang.Short", "kotlin.Short");
        ((HashMap)map).put("java.lang.Integer", "kotlin.Int");
        ((HashMap)map).put("java.lang.Float", "kotlin.Float");
        ((HashMap)map).put("java.lang.Long", "kotlin.Long");
        ((HashMap)map).put("java.lang.Double", "kotlin.Double");
        primitiveWrapperFqNames = map;
        map = new HashMap();
        ((HashMap)map).put("java.lang.Object", "kotlin.Any");
        ((HashMap)map).put("java.lang.String", "kotlin.String");
        ((HashMap)map).put("java.lang.CharSequence", "kotlin.CharSequence");
        ((HashMap)map).put("java.lang.Throwable", "kotlin.Throwable");
        ((HashMap)map).put("java.lang.Cloneable", "kotlin.Cloneable");
        ((HashMap)map).put("java.lang.Number", "kotlin.Number");
        ((HashMap)map).put("java.lang.Comparable", "kotlin.Comparable");
        ((HashMap)map).put("java.lang.Enum", "kotlin.Enum");
        ((HashMap)map).put("java.lang.annotation.Annotation", "kotlin.Annotation");
        ((HashMap)map).put("java.lang.Iterable", "kotlin.collections.Iterable");
        ((HashMap)map).put("java.util.Iterator", "kotlin.collections.Iterator");
        ((HashMap)map).put("java.util.Collection", "kotlin.collections.Collection");
        ((HashMap)map).put("java.util.List", "kotlin.collections.List");
        ((HashMap)map).put("java.util.Set", "kotlin.collections.Set");
        ((HashMap)map).put("java.util.ListIterator", "kotlin.collections.ListIterator");
        ((HashMap)map).put("java.util.Map", "kotlin.collections.Map");
        ((HashMap)map).put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        ((HashMap)map).put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        ((HashMap)map).put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        ((HashMap)map).putAll((Map)primitiveFqNames);
        ((HashMap)map).putAll((Map)primitiveWrapperFqNames);
        object2 = primitiveFqNames.values();
        Intrinsics.checkNotNullExpressionValue(object2, (String)"primitiveFqNames.values");
        for (Object e : (Iterable)object2) {
            object = map;
            String string = (String)e;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("kotlin.jvm.internal.");
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"kotlinName");
            stringBuilder.append(StringsKt.substringAfterLast$default((String)string, (char)'.', null, (int)2, null));
            stringBuilder.append("CompanionObject");
            String string2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(".Companion");
            Pair object3 = TuplesKt.to((Object)string2, (Object)stringBuilder.toString());
            object.put(object3.getFirst(), object3.getSecond());
        }
        object2 = map;
        for (Map.Entry<Class<Function<?>>, Integer> entry : FUNCTION_CLASSES.entrySet()) {
            object = entry.getKey();
            n = ((Number)entry.getValue()).intValue();
            object = ((Class)object).getName();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("kotlin.Function");
            stringBuilder.append(n);
            ((HashMap)map).put(object, stringBuilder.toString());
        }
        classFqNames = map;
        object2 = map;
        map = new LinkedHashMap(MapsKt.mapCapacity((int)object2.size()));
        object = ((Iterable)object2.entrySet()).iterator();
        while (true) {
            if (!object.hasNext()) {
                simpleNames = map;
                return;
            }
            object2 = (Map.Entry)object.next();
            map.put(object2.getKey(), StringsKt.substringAfterLast$default((String)((String)object2.getValue()), (char)'.', null, (int)2, null));
        }
    }

    public ClassReference(Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, (String)"jClass");
        this.jClass = clazz;
    }

    public static final /* synthetic */ HashMap access$getClassFqNames$cp() {
        return classFqNames;
    }

    public static final /* synthetic */ Map access$getFUNCTION_CLASSES$cp() {
        return FUNCTION_CLASSES;
    }

    public static final /* synthetic */ Map access$getSimpleNames$cp() {
        return simpleNames;
    }

    private final Void error() {
        throw (Throwable)new KotlinReflectionNotSupportedError();
    }

    public static /* synthetic */ void getSealedSubclasses$annotations() {
    }

    public static /* synthetic */ void getSupertypes$annotations() {
    }

    public static /* synthetic */ void getTypeParameters$annotations() {
    }

    public static /* synthetic */ void getVisibility$annotations() {
    }

    public static /* synthetic */ void isAbstract$annotations() {
    }

    public static /* synthetic */ void isCompanion$annotations() {
    }

    public static /* synthetic */ void isData$annotations() {
    }

    public static /* synthetic */ void isFinal$annotations() {
    }

    public static /* synthetic */ void isFun$annotations() {
    }

    public static /* synthetic */ void isInner$annotations() {
    }

    public static /* synthetic */ void isOpen$annotations() {
    }

    public static /* synthetic */ void isSealed$annotations() {
    }

    public static /* synthetic */ void isValue$annotations() {
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof ClassReference && Intrinsics.areEqual((Object)JvmClassMappingKt.getJavaObjectType((KClass)this), (Object)JvmClassMappingKt.getJavaObjectType((KClass)((KClass)object)));
        return bl;
    }

    public List<Annotation> getAnnotations() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public Collection<KFunction<Object>> getConstructors() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public Class<?> getJClass() {
        return this.jClass;
    }

    public Collection<KCallable<?>> getMembers() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public Collection<KClass<?>> getNestedClasses() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public Object getObjectInstance() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public String getQualifiedName() {
        return Companion.getClassQualifiedName(this.getJClass());
    }

    public List<KClass<? extends Object>> getSealedSubclasses() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public String getSimpleName() {
        return Companion.getClassSimpleName(this.getJClass());
    }

    public List<KType> getSupertypes() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public List<KTypeParameter> getTypeParameters() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public KVisibility getVisibility() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType((KClass)this).hashCode();
    }

    public boolean isAbstract() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public boolean isCompanion() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public boolean isData() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public boolean isFinal() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public boolean isFun() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public boolean isInner() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public boolean isInstance(Object object) {
        return Companion.isInstance(object, this.getJClass());
    }

    public boolean isOpen() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public boolean isSealed() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public boolean isValue() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getJClass().toString());
        stringBuilder.append(" (Kotlin reflection is not available)");
        return stringBuilder.toString();
    }
}
