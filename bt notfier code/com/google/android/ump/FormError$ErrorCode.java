/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.ump;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.SOURCE)
public static @interface FormError.ErrorCode {
    public static final int INTERNAL_ERROR = 1;
    public static final int INTERNET_ERROR = 2;
    public static final int INVALID_OPERATION = 3;
    public static final int TIME_OUT = 4;
}
