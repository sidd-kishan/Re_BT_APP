/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.ump;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.SOURCE)
public static @interface ConsentInformation.ConsentStatus {
    public static final int NOT_REQUIRED = 1;
    public static final int OBTAINED = 3;
    public static final int REQUIRED = 2;
    public static final int UNKNOWN = 0;
}
