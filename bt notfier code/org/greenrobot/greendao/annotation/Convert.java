/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.converter.PropertyConverter
 */
package org.greenrobot.greendao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.greenrobot.greendao.converter.PropertyConverter;

@Retention(value=RetentionPolicy.SOURCE)
@Target(value={ElementType.FIELD})
public @interface Convert {
    public Class columnType();

    public Class<? extends PropertyConverter> converter();
}
