/*
 * Decompiled with CFR 0.152.
 */
package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.CLASS)
@Target(value={})
public @interface Junction {
    public String entityColumn() default "";

    public String parentColumn() default "";

    public Class<?> value();
}
