/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;

public static class SafeParcelReader.ParseException
extends RuntimeException {
    public SafeParcelReader.ParseException(String string, Parcel object) {
        int n = object.dataPosition();
        int n2 = object.dataSize();
        object = new StringBuilder(String.valueOf(string).length() + 41);
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(" Parcel: pos=");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" size=");
        ((StringBuilder)object).append(n2);
        super(((StringBuilder)object).toString());
    }
}
