/*
 * Decompiled with CFR 0.152.
 */
package androidx.room;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.CLASS)
@Target(value={ElementType.METHOD})
public @interface Insert {
    public Class<?> entity() default Object.class;

    public int onConflict() default 3;
}
