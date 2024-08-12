/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  androidx.core.content.res.ResourcesCompat$FontCallback
 *  com.google.android.material.chip.Chip
 */
package com.google.android.material.chip;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.chip.Chip;

class Chip.1
extends ResourcesCompat.FontCallback {
    final Chip this$0;

    Chip.1(Chip chip) {
        this.this$0 = chip;
    }

    public void onFontRetrievalFailed(int n) {
    }

    public void onFontRetrieved(Typeface typeface) {
        typeface = this.this$0;
        typeface.setText(typeface.getText());
        this.this$0.requestLayout();
        this.this$0.invalidate();
    }
}
