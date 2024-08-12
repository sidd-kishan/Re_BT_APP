/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.core.view.accessibility.AccessibilityNodeProviderCompat
 *  androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
 */
package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import java.util.Map;
import java.util.WeakHashMap;

public static class RecyclerViewAccessibilityDelegate.ItemDelegate
extends AccessibilityDelegateCompat {
    private Map<View, AccessibilityDelegateCompat> mOriginalItemDelegates = new WeakHashMap<View, AccessibilityDelegateCompat>();
    final RecyclerViewAccessibilityDelegate mRecyclerViewDelegate;

    public RecyclerViewAccessibilityDelegate.ItemDelegate(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.mRecyclerViewDelegate = recyclerViewAccessibilityDelegate;
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
        if (accessibilityDelegateCompat == null) return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        return accessibilityDelegateCompat.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
        if (accessibilityDelegateCompat == null) return super.getAccessibilityNodeProvider(view);
        return accessibilityDelegateCompat.getAccessibilityNodeProvider(view);
    }

    AccessibilityDelegateCompat getAndRemoveOriginalDelegateForItem(View view) {
        return this.mOriginalItemDelegates.remove(view);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
        if (accessibilityDelegateCompat != null) {
            accessibilityDelegateCompat.onInitializeAccessibilityEvent(view, accessibilityEvent);
        } else {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (!this.mRecyclerViewDelegate.shouldIgnore() && this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() != null) {
            this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            }
        } else {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        }
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
        if (accessibilityDelegateCompat != null) {
            accessibilityDelegateCompat.onPopulateAccessibilityEvent(view, accessibilityEvent);
        } else {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(viewGroup);
        if (accessibilityDelegateCompat == null) return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        return accessibilityDelegateCompat.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean performAccessibilityAction(View view, int n, Bundle bundle) {
        if (this.mRecyclerViewDelegate.shouldIgnore()) return super.performAccessibilityAction(view, n, bundle);
        if (this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() == null) return super.performAccessibilityAction(view, n, bundle);
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
        if (accessibilityDelegateCompat != null) {
            if (!accessibilityDelegateCompat.performAccessibilityAction(view, n, bundle)) return this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, n, bundle);
            return true;
        }
        if (!super.performAccessibilityAction(view, n, bundle)) return this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, n, bundle);
        return true;
    }

    void saveOriginalDelegate(View view) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = ViewCompat.getAccessibilityDelegate((View)view);
        if (accessibilityDelegateCompat == null) return;
        if (accessibilityDelegateCompat == this) return;
        this.mOriginalItemDelegates.put(view, accessibilityDelegateCompat);
    }

    public void sendAccessibilityEvent(View view, int n) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
        if (accessibilityDelegateCompat != null) {
            accessibilityDelegateCompat.sendAccessibilityEvent(view, n);
        } else {
            super.sendAccessibilityEvent(view, n);
        }
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
        if (accessibilityDelegateCompat != null) {
            accessibilityDelegateCompat.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        } else {
            super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }
}
