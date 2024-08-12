/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.annotation.Index
 */
package org.greenrobot.greendao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.greenrobot.greendao.annotation.Index;

@Retention(value=RetentionPolicy.SOURCE)
@Target(value={ElementType.TYPE})
public @interface Entity {
    public boolean active() default false;

    public boolean createInDb() default true;

    public boolean generateConstructors() default true;

    public boolean generateGettersSetters() default true;

    public Index[] indexes() default {};

    public String nameInDb() default "";

    public Class protobuf() default void.class;

    public String schema() default "default";
}
