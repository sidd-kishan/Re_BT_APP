/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.ads;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.SOURCE)
public static @interface AdValue.PrecisionType {
    public static final int ESTIMATED = 1;
    public static final int PRECISE = 3;
    public static final int PUBLISHER_PROVIDED = 2;
    public static final int UNKNOWN = 0;
}
