/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.ThreadMode
 */
package org.greenrobot.eventbus;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.greenrobot.eventbus.ThreadMode;

@Documented
@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD})
public @interface Subscribe {
    public int priority() default 0;

    public boolean sticky() default false;

    public ThreadMode threadMode() default ThreadMode.POSTING;
}
