/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.AdError
 */
package com.google.android.gms.ads;

import com.google.android.gms.ads.AdError;

public final class AdInspectorError
extends AdError {
    public static final int ERROR_CODE_ALREADY_OPEN = 3;
    public static final int ERROR_CODE_FAILED_TO_LOAD = 1;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_NOT_IN_TEST_MODE = 2;

    public AdInspectorError(int n, String string, String string2) {
        super(n, string, string2);
    }

    public int getCode() {
        return super.getCode();
    }
}
