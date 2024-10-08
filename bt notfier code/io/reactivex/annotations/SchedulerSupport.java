/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.TYPE})
public @interface SchedulerSupport {
    public static final String COMPUTATION = "io.reactivex:computation";
    public static final String CUSTOM = "custom";
    public static final String IO = "io.reactivex:io";
    public static final String NEW_THREAD = "io.reactivex:new-thread";
    public static final String NONE = "none";
    public static final String SINGLE = "io.reactivex:single";
    public static final String TRAMPOLINE = "io.reactivex:trampoline";

    public String value();
}
