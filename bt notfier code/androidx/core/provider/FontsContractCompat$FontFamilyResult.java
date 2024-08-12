/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.provider.FontsContractCompat$FontInfo
 */
package androidx.core.provider;

import androidx.core.provider.FontsContractCompat;

public static class FontsContractCompat.FontFamilyResult {
    public static final int STATUS_OK = 0;
    public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
    public static final int STATUS_WRONG_CERTIFICATES = 1;
    private final FontsContractCompat.FontInfo[] mFonts;
    private final int mStatusCode;

    @Deprecated
    public FontsContractCompat.FontFamilyResult(int n, FontsContractCompat.FontInfo[] fontInfoArray) {
        this.mStatusCode = n;
        this.mFonts = fontInfoArray;
    }

    static FontsContractCompat.FontFamilyResult create(int n, FontsContractCompat.FontInfo[] fontInfoArray) {
        return new FontsContractCompat.FontFamilyResult(n, fontInfoArray);
    }

    public FontsContractCompat.FontInfo[] getFonts() {
        return this.mFonts;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }
}
