/*
 * Decompiled with CFR 0.152.
 */
package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.CLASS)
@Target(value={})
public @interface Index {
    public String name() default "";

    public boolean unique() default false;

    public String[] value();
}
