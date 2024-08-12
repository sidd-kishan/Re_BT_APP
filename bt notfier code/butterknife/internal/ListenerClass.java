/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  butterknife.internal.ListenerClass$NONE
 *  butterknife.internal.ListenerMethod
 */
package butterknife.internal;

import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.ANNOTATION_TYPE})
public @interface ListenerClass {
    public Class<? extends Enum<?>> callbacks() default NONE.class;

    public ListenerMethod[] method() default {};

    public String remover() default "";

    public String setter();

    public String targetType();

    public String type();
}
