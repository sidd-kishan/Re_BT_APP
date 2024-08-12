/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NotImplementedError
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KType
 *  kotlin.reflect.KTypeParameter
 *  kotlin.reflect.TypeImpl
 *  kotlin.reflect.TypesJVMKt
 */
package kotlin.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.TypeImpl;
import kotlin.reflect.TypesJVMKt;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u0011\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\b\b\u0000\u0010\u0010*\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012\u00a2\u0006\u0002\u0010\u0013J\u0011\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0002\u0010\u000eJ\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\fH\u0016\u00a2\u0006\u0002\u0010\u0017J\u0011\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lkotlin/reflect/TypeVariableImpl;", "Ljava/lang/reflect/TypeVariable;", "Ljava/lang/reflect/GenericDeclaration;", "Lkotlin/reflect/TypeImpl;", "typeParameter", "Lkotlin/reflect/KTypeParameter;", "(Lkotlin/reflect/KTypeParameter;)V", "equals", "", "other", "", "getAnnotatedBounds", "", "", "()[Ljava/lang/annotation/Annotation;", "getAnnotation", "T", "annotationClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;", "getAnnotations", "getBounds", "Ljava/lang/reflect/Type;", "()[Ljava/lang/reflect/Type;", "getDeclaredAnnotations", "getGenericDeclaration", "getName", "", "getTypeName", "hashCode", "", "toString", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class TypeVariableImpl
implements TypeVariable<GenericDeclaration>,
TypeImpl {
    private final KTypeParameter typeParameter;

    public TypeVariableImpl(KTypeParameter kTypeParameter) {
        Intrinsics.checkNotNullParameter((Object)kTypeParameter, (String)"typeParameter");
        this.typeParameter = kTypeParameter;
    }

    public boolean equals(Object object) {
        String string;
        boolean bl = object instanceof TypeVariable && Intrinsics.areEqual((Object)(string = this.getName()), (Object)(object = (TypeVariable)object).getName()) && Intrinsics.areEqual((Object)this.getGenericDeclaration(), object.getGenericDeclaration());
        return bl;
    }

    public final Annotation[] getAnnotatedBounds() {
        return new Annotation[0];
    }

    @Override
    public final <T extends Annotation> T getAnnotation(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, (String)"annotationClass");
        return null;
    }

    @Override
    public final Annotation[] getAnnotations() {
        return new Annotation[0];
    }

    @Override
    public Type[] getBounds() {
        Object object = this.typeParameter.getUpperBounds();
        Object object2 = (Type[])new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object, (int)10));
        object = object.iterator();
        while (object.hasNext()) {
            object2.add(TypesJVMKt.access$computeJavaType((KType)((KType)object.next()), (boolean)true));
        }
        if ((object2 = ((Collection)((List)object2)).toArray(new Type[0])) != null) {
            return object2;
        }
        object2 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        throw object2;
    }

    @Override
    public final Annotation[] getDeclaredAnnotations() {
        return new Annotation[0];
    }

    @Override
    public GenericDeclaration getGenericDeclaration() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("getGenericDeclaration() is not yet supported for type variables created from KType: ");
        charSequence.append(this.typeParameter);
        charSequence = charSequence.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("An operation is not implemented: ");
        stringBuilder.append((String)charSequence);
        throw (Throwable)new NotImplementedError(stringBuilder.toString());
    }

    @Override
    public String getName() {
        return this.typeParameter.getName();
    }

    @Override
    public String getTypeName() {
        return this.getName();
    }

    public int hashCode() {
        return this.getName().hashCode() ^ this.getGenericDeclaration().hashCode();
    }

    public String toString() {
        return this.getTypeName();
    }
}
