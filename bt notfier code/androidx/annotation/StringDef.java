/*
 * Decompiled with CFR 0.152.
 */
package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.SOURCE)
@Target(value={ElementType.ANNOTATION_TYPE})
public @interface StringDef {
    public boolean open() default false;

    public String[] value() default {};
}
