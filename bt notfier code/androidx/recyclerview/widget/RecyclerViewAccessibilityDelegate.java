/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.accessibility.AccessibilityEvent
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate$ItemDelegate
 */
package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

public class RecyclerViewAccessibilityDelegate
extends AccessibilityDelegateCompat {
    private final ItemDelegate mItemDelegate;
    final RecyclerView mRecyclerView;

    public RecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        recyclerView = this.getItemDelegate();
        this.mItemDelegate = recyclerView != null && recyclerView instanceof ItemDelegate ? (ItemDelegate)recyclerView : new ItemDelegate(this);
    }

    public AccessibilityDelegateCompat getItemDelegate() {
        return this.mItemDelegate;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (!(view instanceof RecyclerView)) return;
        if (this.shouldIgnore()) return;
        if ((view = (RecyclerView)view).getLayoutManager() == null) return;
        view.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if (this.shouldIgnore()) return;
        if (this.mRecyclerView.getLayoutManager() == null) return;
        this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
    }

    public boolean performAccessibilityAction(View view, int n, Bundle bundle) {
        if (super.performAccessibilityAction(view, n, bundle)) {
            return true;
        }
        if (this.shouldIgnore()) return false;
        if (this.mRecyclerView.getLayoutManager() == null) return false;
        return this.mRecyclerView.getLayoutManager().performAccessibilityAction(n, bundle);
    }

    boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }
}
