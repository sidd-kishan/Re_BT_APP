/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.Feature
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;

public final class UnsupportedApiCallException
extends UnsupportedOperationException {
    private final Feature zza;

    public UnsupportedApiCallException(Feature feature) {
        this.zza = feature;
    }

    @Override
    public String getMessage() {
        String string = String.valueOf(this.zza);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 8);
        stringBuilder.append("Missing ");
        stringBuilder.append(string);
        return stringBuilder.toString();
    }
}
