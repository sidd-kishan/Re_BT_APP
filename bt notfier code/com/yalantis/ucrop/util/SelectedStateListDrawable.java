/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.StateListDrawable
 *  androidx.core.graphics.BlendModeColorFilterCompat
 *  androidx.core.graphics.BlendModeCompat
 */
package com.yalantis.ucrop.util;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;

public class SelectedStateListDrawable
extends StateListDrawable {
    private final int mSelectionColor;

    public SelectedStateListDrawable(Drawable drawable, int n) {
        this.mSelectionColor = n;
        this.addState(new int[]{0x10100A1}, drawable);
        this.addState(new int[0], drawable);
    }

    public boolean isStateful() {
        return true;
    }

    protected boolean onStateChange(int[] nArray) {
        int n = nArray.length;
        boolean bl = false;
        for (int i = 0; i < n; ++i) {
            if (nArray[i] != 0x10100A1) continue;
            bl = true;
        }
        if (bl) {
            super.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat((int)this.mSelectionColor, (BlendModeCompat)BlendModeCompat.SRC_ATOP));
        } else {
            super.clearColorFilter();
        }
        return super.onStateChange(nArray);
    }
}
