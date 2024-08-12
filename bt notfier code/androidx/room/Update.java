/*
 * Decompiled with CFR 0.152.
 */
package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.CLASS)
public @interface Update {
    public Class<?> entity() default Object.class;

    public int onConflict() default 3;
}
