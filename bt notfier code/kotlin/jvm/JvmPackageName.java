/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.annotation.AnnotationRetention
 *  kotlin.annotation.AnnotationTarget
 *  kotlin.annotation.MustBeDocumented
 *  kotlin.annotation.Retention
 *  kotlin.annotation.Target
 */
package kotlin.jvm;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;

@Documented
@Retention(value=RetentionPolicy.SOURCE)
@Target(value={})
@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/jvm/JvmPackageName;", "", "name", "", "()Ljava/lang/String;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
@MustBeDocumented
@kotlin.annotation.Retention(value=AnnotationRetention.SOURCE)
@kotlin.annotation.Target(allowedTargets={AnnotationTarget.FILE})
public @interface JvmPackageName {
    public String name();
}
