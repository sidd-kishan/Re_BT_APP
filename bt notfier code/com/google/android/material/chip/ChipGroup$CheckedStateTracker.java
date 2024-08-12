/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  com.google.android.material.chip.ChipGroup
 */
package com.google.android.material.chip;

import android.widget.CompoundButton;
import com.google.android.material.chip.ChipGroup;

/*
 * Exception performing whole class analysis ignored.
 */
private class ChipGroup.CheckedStateTracker
implements CompoundButton.OnCheckedChangeListener {
    final ChipGroup this$0;

    private ChipGroup.CheckedStateTracker(ChipGroup chipGroup) {
        this.this$0 = chipGroup;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
        if (ChipGroup.access$300((ChipGroup)this.this$0)) {
            return;
        }
        int n = compoundButton.getId();
        if (bl) {
            if (ChipGroup.access$400((ChipGroup)this.this$0) != -1 && ChipGroup.access$400((ChipGroup)this.this$0) != n && ChipGroup.access$500((ChipGroup)this.this$0)) {
                compoundButton = this.this$0;
                ChipGroup.access$600((ChipGroup)compoundButton, (int)ChipGroup.access$400((ChipGroup)compoundButton), (boolean)false);
            }
            ChipGroup.access$700((ChipGroup)this.this$0, (int)n);
        } else {
            if (ChipGroup.access$400((ChipGroup)this.this$0) != n) return;
            ChipGroup.access$700((ChipGroup)this.this$0, (int)-1);
        }
    }
}
