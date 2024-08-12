/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.annotation.experimental.Experimental$Level
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.annotation.AnnotationRetention
 *  kotlin.annotation.AnnotationTarget
 *  kotlin.annotation.Retention
 *  kotlin.annotation.Target
 */
package androidx.annotation.experimental;

import androidx.annotation.experimental.Experimental;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Retention(value=RetentionPolicy.CLASS)
@Target(value={ElementType.ANNOTATION_TYPE})
@Deprecated(message="This annotation has been replaced by `@RequiresOptIn`", replaceWith=@ReplaceWith(expression="RequiresOptIn", imports={"androidx.annotation.RequiresOptIn"}))
@Metadata(bv={1, 0, 3}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\n\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004\u00a8\u0006\u0006"}, d2={"Landroidx/annotation/experimental/Experimental;", "", "level", "Landroidx/annotation/experimental/Experimental$Level;", "()Landroidx/annotation/experimental/Experimental$Level;", "Level", "annotation-experimental_release"}, k=1, mv={1, 4, 2})
@kotlin.annotation.Retention(value=AnnotationRetention.BINARY)
@kotlin.annotation.Target(allowedTargets={AnnotationTarget.ANNOTATION_CLASS})
public @interface Experimental {
    public Level level() default Level.ERROR;
}
