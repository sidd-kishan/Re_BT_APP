/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.ump;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.SOURCE)
public static @interface ConsentDebugSettings.DebugGeography {
    public static final int DEBUG_GEOGRAPHY_DISABLED = 0;
    public static final int DEBUG_GEOGRAPHY_EEA = 1;
    public static final int DEBUG_GEOGRAPHY_NOT_EEA = 2;
}
