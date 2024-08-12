/*
 * Decompiled with CFR 0.152.
 */
package org.greenrobot.greendao.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.SOURCE)
@Target(value={})
public @interface JoinProperty {
    public String name();

    public String referencedName();
}
