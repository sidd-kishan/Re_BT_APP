/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.common.internal.safeparcel;

public static @interface SafeParcelable.Class {
    public String creator();

    public boolean validate() default false;
}
