/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup$OnHierarchyChangeListener
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  com.google.android.material.chip.Chip
 *  com.google.android.material.chip.ChipGroup
 */
package com.google.android.material.chip;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

/*
 * Exception performing whole class analysis ignored.
 */
private class ChipGroup.PassThroughHierarchyChangeListener
implements ViewGroup.OnHierarchyChangeListener {
    private ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;
    final ChipGroup this$0;

    private ChipGroup.PassThroughHierarchyChangeListener(ChipGroup chipGroup) {
        this.this$0 = chipGroup;
    }

    static /* synthetic */ ViewGroup.OnHierarchyChangeListener access$202(ChipGroup.PassThroughHierarchyChangeListener passThroughHierarchyChangeListener, ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        passThroughHierarchyChangeListener.onHierarchyChangeListener = onHierarchyChangeListener;
        return onHierarchyChangeListener;
    }

    public void onChildViewAdded(View view, View view2) {
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;
        if (view == this.this$0 && view2 instanceof Chip) {
            if (view2.getId() == -1) {
                int n = Build.VERSION.SDK_INT >= 17 ? View.generateViewId() : view2.hashCode();
                view2.setId(n);
            }
            ((Chip)view2).setOnCheckedChangeListenerInternal((CompoundButton.OnCheckedChangeListener)ChipGroup.access$800((ChipGroup)this.this$0));
        }
        if ((onHierarchyChangeListener = this.onHierarchyChangeListener) == null) return;
        onHierarchyChangeListener.onChildViewAdded(view, view2);
    }

    public void onChildViewRemoved(View view, View view2) {
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;
        if (view == this.this$0 && view2 instanceof Chip) {
            ((Chip)view2).setOnCheckedChangeListenerInternal(null);
        }
        if ((onHierarchyChangeListener = this.onHierarchyChangeListener) == null) return;
        onHierarchyChangeListener.onChildViewRemoved(view, view2);
    }
}
