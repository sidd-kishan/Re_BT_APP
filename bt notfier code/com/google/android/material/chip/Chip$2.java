/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Outline
 *  android.view.View
 *  android.view.ViewOutlineProvider
 *  com.google.android.material.chip.Chip
 */
package com.google.android.material.chip;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;

/*
 * Exception performing whole class analysis ignored.
 */
class Chip.2
extends ViewOutlineProvider {
    final Chip this$0;

    Chip.2(Chip chip) {
        this.this$0 = chip;
    }

    public void getOutline(View view, Outline outline) {
        if (Chip.access$000((Chip)this.this$0) != null) {
            Chip.access$000((Chip)this.this$0).getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}
