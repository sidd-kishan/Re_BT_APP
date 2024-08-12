/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.transition.ViewGroupOverlayApi14
 *  androidx.transition.ViewOverlayApi14$OverlayViewGroup
 *  androidx.transition.ViewOverlayImpl
 */
package androidx.transition;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.ViewGroupOverlayApi14;
import androidx.transition.ViewOverlayApi14;
import androidx.transition.ViewOverlayImpl;

class ViewOverlayApi14
implements ViewOverlayImpl {
    protected OverlayViewGroup mOverlayViewGroup;

    ViewOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        this.mOverlayViewGroup = new OverlayViewGroup(context, viewGroup, view, this);
    }

    static ViewOverlayApi14 createFrom(View view) {
        ViewGroup viewGroup = ViewOverlayApi14.getContentView(view);
        if (viewGroup == null) return null;
        int n = viewGroup.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            View view2 = viewGroup.getChildAt(n2);
            if (view2 instanceof OverlayViewGroup) {
                return ((OverlayViewGroup)view2).mViewOverlay;
            }
            ++n2;
        }
        return new ViewGroupOverlayApi14(viewGroup.getContext(), viewGroup, view);
    }

    static ViewGroup getContentView(View view) {
        while (view != null) {
            if (view.getId() == 0x1020002 && view instanceof ViewGroup) {
                return (ViewGroup)view;
            }
            if (!(view.getParent() instanceof ViewGroup)) continue;
            view = (ViewGroup)view.getParent();
        }
        return null;
    }

    public void add(Drawable drawable) {
        this.mOverlayViewGroup.add(drawable);
    }

    public void remove(Drawable drawable) {
        this.mOverlayViewGroup.remove(drawable);
    }
}
