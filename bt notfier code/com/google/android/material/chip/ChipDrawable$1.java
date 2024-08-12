/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  androidx.core.content.res.ResourcesCompat$FontCallback
 *  com.google.android.material.chip.ChipDrawable
 */
package com.google.android.material.chip;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.chip.ChipDrawable;

/*
 * Exception performing whole class analysis ignored.
 */
class ChipDrawable.1
extends ResourcesCompat.FontCallback {
    final ChipDrawable this$0;

    ChipDrawable.1(ChipDrawable chipDrawable) {
        this.this$0 = chipDrawable;
    }

    public void onFontRetrievalFailed(int n) {
    }

    public void onFontRetrieved(Typeface typeface) {
        ChipDrawable.access$002((ChipDrawable)this.this$0, (boolean)true);
        this.this$0.onSizeChange();
        this.this$0.invalidateSelf();
    }
}
