/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.annotation.InspectableProperty$EnumEntry
 *  androidx.annotation.InspectableProperty$FlagEntry
 *  androidx.annotation.InspectableProperty$ValueType
 */
package androidx.annotation;

import androidx.annotation.InspectableProperty;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.SOURCE)
@Target(value={ElementType.METHOD})
public @interface InspectableProperty {
    public int attributeId() default 0;

    public EnumEntry[] enumMapping() default {};

    public FlagEntry[] flagMapping() default {};

    public boolean hasAttributeId() default true;

    public String name() default "";

    public ValueType valueType() default ValueType.INFERRED;
}
