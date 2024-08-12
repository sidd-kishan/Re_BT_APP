/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 */
package androidx.core.provider;

import android.graphics.Typeface;

public static class FontsContractCompat.FontRequestCallback {
    public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
    public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
    public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
    public static final int FAIL_REASON_MALFORMED_QUERY = 3;
    public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
    public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
    public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
    @Deprecated
    public static final int RESULT_OK = 0;
    static final int RESULT_SUCCESS = 0;

    public void onTypefaceRequestFailed(int n) {
    }

    public void onTypefaceRetrieved(Typeface typeface) {
    }
}
