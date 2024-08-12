/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.ump;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.SOURCE)
public static @interface ConsentInformation.ConsentType {
    public static final int NON_PERSONALIZED = 1;
    public static final int PERSONALIZED = 2;
    public static final int UNKNOWN = 0;
}
