/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.annotation.RequiresPermission
 */
package androidx.annotation;

import androidx.annotation.RequiresPermission;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value={ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public static @interface RequiresPermission.Read {
    public RequiresPermission value() default @RequiresPermission;
}
