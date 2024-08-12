/*
 * Decompiled with CFR 0.152.
 */
package com.google.auto.value.extension.memoized;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(value=RetentionPolicy.SOURCE)
@Target(value={ElementType.METHOD})
public @interface Memoized {
}
