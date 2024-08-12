/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  androidx.core.util.Preconditions
 */
package androidx.core.provider;

import android.net.Uri;
import androidx.core.util.Preconditions;

public static class FontsContractCompat.FontInfo {
    private final boolean mItalic;
    private final int mResultCode;
    private final int mTtcIndex;
    private final Uri mUri;
    private final int mWeight;

    @Deprecated
    public FontsContractCompat.FontInfo(Uri uri, int n, int n2, boolean bl, int n3) {
        this.mUri = (Uri)Preconditions.checkNotNull((Object)uri);
        this.mTtcIndex = n;
        this.mWeight = n2;
        this.mItalic = bl;
        this.mResultCode = n3;
    }

    static FontsContractCompat.FontInfo create(Uri uri, int n, int n2, boolean bl, int n3) {
        return new FontsContractCompat.FontInfo(uri, n, n2, bl, n3);
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public int getTtcIndex() {
        return this.mTtcIndex;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public int getWeight() {
        return this.mWeight;
    }

    public boolean isItalic() {
        return this.mItalic;
    }
}
