/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 */
package androidx.core.provider;

import android.graphics.Typeface;

static final class FontRequestWorker.TypefaceResult {
    final int mResult;
    final Typeface mTypeface;

    FontRequestWorker.TypefaceResult(int n) {
        this.mTypeface = null;
        this.mResult = n;
    }

    FontRequestWorker.TypefaceResult(Typeface typeface) {
        this.mTypeface = typeface;
        this.mResult = 0;
    }

    boolean isSuccess() {
        boolean bl = this.mResult == 0;
        return bl;
    }
}
