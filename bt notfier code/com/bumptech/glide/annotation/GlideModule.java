/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.SOURCE)
@Target(value={ElementType.TYPE})
public @interface GlideModule {
    public String glideName() default "GlideApp";
}