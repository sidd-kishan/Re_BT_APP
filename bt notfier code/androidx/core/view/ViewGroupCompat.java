/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 *  androidx.core.R$id
 *  androidx.core.view.NestedScrollingParent
 *  androidx.core.view.ViewCompat
 */
package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.R;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ViewCompat;

public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    private ViewGroupCompat() {
    }

    public static int getLayoutMode(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT < 18) return 0;
        return viewGroup.getLayoutMode();
    }

    public static int getNestedScrollAxes(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.getNestedScrollAxes();
        }
        if (!(viewGroup instanceof NestedScrollingParent)) return 0;
        return ((NestedScrollingParent)viewGroup).getNestedScrollAxes();
    }

    public static boolean isTransitionGroup(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bl = (Boolean)viewGroup.getTag(R.id.tag_transition_group);
        boolean bl2 = bl != null && bl.booleanValue() || viewGroup.getBackground() != null || ViewCompat.getTransitionName((View)viewGroup) != null;
        return bl2;
    }

    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void setLayoutMode(ViewGroup viewGroup, int n) {
        if (Build.VERSION.SDK_INT < 18) return;
        viewGroup.setLayoutMode(n);
    }

    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean bl) {
        viewGroup.setMotionEventSplittingEnabled(bl);
    }

    public static void setTransitionGroup(ViewGroup viewGroup, boolean bl) {
        if (Build.VERSION.SDK_INT >= 21) {
            viewGroup.setTransitionGroup(bl);
        } else {
            viewGroup.setTag(R.id.tag_transition_group, (Object)bl);
        }
    }
}
