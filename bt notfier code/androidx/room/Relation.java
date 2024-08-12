/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.Junction
 */
package androidx.room;

import androidx.room.Junction;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.CLASS)
@Target(value={ElementType.FIELD, ElementType.METHOD})
public @interface Relation {
    public Junction associateBy() default @Junction(value=Object.class);

    public Class<?> entity() default Object.class;

    public String entityColumn();

    public String parentColumn();

    public String[] projection() default {};
}
