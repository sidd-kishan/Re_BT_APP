/*
 * Decompiled with CFR 0.152.
 */
package com.google.ads.mediation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.FIELD})
protected static @interface MediationServerParameters.Parameter {
    public String name();

    public boolean required() default true;
}
