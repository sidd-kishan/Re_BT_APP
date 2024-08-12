/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.common.internal.safeparcel;

public static @interface SafeParcelable.Field {
    public String defaultValue() default "SAFE_PARCELABLE_NULL_STRING";

    public String defaultValueUnchecked() default "SAFE_PARCELABLE_NULL_STRING";

    public String getter() default "SAFE_PARCELABLE_NULL_STRING";

    public int id();

    public String type() default "SAFE_PARCELABLE_NULL_STRING";
}
