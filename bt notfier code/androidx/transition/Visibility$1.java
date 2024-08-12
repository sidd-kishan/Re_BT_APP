/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.transition.R$id
 *  androidx.transition.Transition
 *  androidx.transition.Transition$TransitionListener
 *  androidx.transition.TransitionListenerAdapter
 *  androidx.transition.ViewGroupUtils
 *  androidx.transition.Visibility
 */
package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.R;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.ViewGroupUtils;
import androidx.transition.Visibility;

class Visibility.1
extends TransitionListenerAdapter {
    final Visibility this$0;
    final View val$finalOverlayView;
    final ViewGroup val$overlayHost;
    final View val$startView;

    Visibility.1(Visibility visibility, ViewGroup viewGroup, View view, View view2) {
        this.this$0 = visibility;
        this.val$overlayHost = viewGroup;
        this.val$finalOverlayView = view;
        this.val$startView = view2;
    }

    public void onTransitionEnd(Transition transition) {
        this.val$startView.setTag(R.id.save_overlay_view, null);
        ViewGroupUtils.getOverlay((ViewGroup)this.val$overlayHost).remove(this.val$finalOverlayView);
        transition.removeListener((Transition.TransitionListener)this);
    }

    public void onTransitionPause(Transition transition) {
        ViewGroupUtils.getOverlay((ViewGroup)this.val$overlayHost).remove(this.val$finalOverlayView);
    }

    public void onTransitionResume(Transition transition) {
        if (this.val$finalOverlayView.getParent() == null) {
            ViewGroupUtils.getOverlay((ViewGroup)this.val$overlayHost).add(this.val$finalOverlayView);
        } else {
            this.this$0.cancel();
        }
    }
}
