/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat
 *  androidx.customview.widget.ExploreByTouchHelper
 *  com.google.android.material.R$string
 *  com.google.android.material.chip.Chip
 */
package com.google.android.material.chip;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
private class Chip.ChipTouchHelper
extends ExploreByTouchHelper {
    final Chip this$0;

    Chip.ChipTouchHelper(Chip chip, Chip chip2) {
        this.this$0 = chip;
        super((View)chip2);
    }

    protected int getVirtualViewAt(float f, float f2) {
        int n = Chip.access$100((Chip)this.this$0) && Chip.access$200((Chip)this.this$0).contains(f, f2) ? 0 : -1;
        return n;
    }

    protected void getVisibleVirtualViews(List<Integer> list) {
        if (!Chip.access$100((Chip)this.this$0)) return;
        list.add(0);
    }

    protected boolean onPerformActionForVirtualView(int n, int n2, Bundle bundle) {
        if (n2 != 16) return false;
        if (n != 0) return false;
        return this.this$0.performCloseIconClick();
    }

    protected void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        boolean bl = Chip.access$000((Chip)this.this$0) != null && Chip.access$000((Chip)this.this$0).isCheckable();
        accessibilityNodeInfoCompat.setCheckable(bl);
        accessibilityNodeInfoCompat.setClassName((CharSequence)Chip.class.getName());
        CharSequence charSequence = this.this$0.getText();
        if (Build.VERSION.SDK_INT >= 23) {
            accessibilityNodeInfoCompat.setText(charSequence);
        } else {
            accessibilityNodeInfoCompat.setContentDescription(charSequence);
        }
    }

    protected void onPopulateNodeForVirtualView(int n, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        boolean bl = Chip.access$100((Chip)this.this$0);
        CharSequence charSequence = "";
        if (bl) {
            CharSequence charSequence2 = this.this$0.getCloseIconContentDescription();
            if (charSequence2 != null) {
                accessibilityNodeInfoCompat.setContentDescription(charSequence2);
            } else {
                charSequence2 = this.this$0.getText();
                Context context = this.this$0.getContext();
                n = R.string.mtrl_chip_close_icon_content_description;
                if (!TextUtils.isEmpty((CharSequence)charSequence2)) {
                    charSequence = charSequence2;
                }
                accessibilityNodeInfoCompat.setContentDescription((CharSequence)context.getString(n, new Object[]{charSequence}).trim());
            }
            accessibilityNodeInfoCompat.setBoundsInParent(Chip.access$300((Chip)this.this$0));
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            accessibilityNodeInfoCompat.setEnabled(this.this$0.isEnabled());
        } else {
            accessibilityNodeInfoCompat.setContentDescription((CharSequence)"");
            accessibilityNodeInfoCompat.setBoundsInParent(Chip.access$400());
        }
    }
}
