/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.annotation.AnnotationTarget
 *  kotlin.annotation.MustBeDocumented
 *  kotlin.annotation.Target
 */
package kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Target;

@Documented
@Retention(value=RetentionPolicy.RUNTIME)
@java.lang.annotation.Target(value={})
@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/ParameterName;", "", "name", "", "()Ljava/lang/String;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
@MustBeDocumented
@Target(allowedTargets={AnnotationTarget.TYPE})
public @interface ParameterName {
    public String name();
}
