/*
 * Decompiled with CFR 0.152.
 */
package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.SOURCE)
@Target(value={ElementType.TYPE})
public static @interface InspectableProperty.FlagEntry {
    public int mask() default 0;

    public String name();

    public int target();
}
