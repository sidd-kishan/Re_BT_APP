/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.reflect.KAnnotatedElement
 *  kotlin.reflect.KParameter
 *  kotlin.reflect.KType
 *  kotlin.reflect.KTypeParameter
 *  kotlin.reflect.KVisibility
 */
package kotlin.reflect;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.reflect.KAnnotatedElement;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J%\u0010$\u001a\u00028\u00002\u0016\u0010%\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010'0&\"\u0004\u0018\u00010'H&\u00a2\u0006\u0002\u0010(J#\u0010)\u001a\u00028\u00002\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010'0*H&\u00a2\u0006\u0002\u0010+R\u001a\u0010\u0003\u001a\u00020\u00048&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00048&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0007R\u001a\u0010\n\u001a\u00020\u00048&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\n\u0010\u0007R\u001a\u0010\f\u001a\u00020\u00048&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\r\u0010\u0006\u001a\u0004\b\f\u0010\u0007R\u0012\u0010\u000e\u001a\u00020\u000fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00138&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001e\u0010\u0016R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010#\u00a8\u0006,"}, d2={"Lkotlin/reflect/KCallable;", "R", "Lkotlin/reflect/KAnnotatedElement;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isFinal", "isFinal$annotations", "isOpen", "isOpen$annotations", "isSuspend", "isSuspend$annotations", "name", "", "getName", "()Ljava/lang/String;", "parameters", "", "Lkotlin/reflect/KParameter;", "getParameters", "()Ljava/util/List;", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callBy", "", "(Ljava/util/Map;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public interface KCallable<R>
extends KAnnotatedElement {
    public R call(Object ... var1);

    public R callBy(Map<KParameter, ? extends Object> var1);

    public String getName();

    public List<KParameter> getParameters();

    public KType getReturnType();

    public List<KTypeParameter> getTypeParameters();

    public KVisibility getVisibility();

    public boolean isAbstract();

    public boolean isFinal();

    public boolean isOpen();

    public boolean isSuspend();
}
