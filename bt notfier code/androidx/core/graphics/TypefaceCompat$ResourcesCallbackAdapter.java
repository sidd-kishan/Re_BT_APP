/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  androidx.core.content.res.ResourcesCompat$FontCallback
 *  androidx.core.provider.FontsContractCompat$FontRequestCallback
 */
package androidx.core.graphics;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontsContractCompat;

public static class TypefaceCompat.ResourcesCallbackAdapter
extends FontsContractCompat.FontRequestCallback {
    private ResourcesCompat.FontCallback mFontCallback;

    public TypefaceCompat.ResourcesCallbackAdapter(ResourcesCompat.FontCallback fontCallback) {
        this.mFontCallback = fontCallback;
    }

    public void onTypefaceRequestFailed(int n) {
        ResourcesCompat.FontCallback fontCallback = this.mFontCallback;
        if (fontCallback == null) return;
        fontCallback.onFontRetrievalFailed(n);
    }

    public void onTypefaceRetrieved(Typeface typeface) {
        ResourcesCompat.FontCallback fontCallback = this.mFontCallback;
        if (fontCallback == null) return;
        fontCallback.onFontRetrieved(typeface);
    }
}
