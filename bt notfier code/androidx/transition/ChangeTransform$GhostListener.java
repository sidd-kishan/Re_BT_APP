/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.transition.GhostView
 *  androidx.transition.GhostViewUtils
 *  androidx.transition.R$id
 *  androidx.transition.Transition
 *  androidx.transition.Transition$TransitionListener
 *  androidx.transition.TransitionListenerAdapter
 */
package androidx.transition;

import android.view.View;
import androidx.transition.GhostView;
import androidx.transition.GhostViewUtils;
import androidx.transition.R;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;

private static class ChangeTransform.GhostListener
extends TransitionListenerAdapter {
    private GhostView mGhostView;
    private View mView;

    ChangeTransform.GhostListener(View view, GhostView ghostView) {
        this.mView = view;
        this.mGhostView = ghostView;
    }

    public void onTransitionEnd(Transition transition) {
        transition.removeListener((Transition.TransitionListener)this);
        GhostViewUtils.removeGhost((View)this.mView);
        this.mView.setTag(R.id.transition_transform, null);
        this.mView.setTag(R.id.parent_matrix, null);
    }

    public void onTransitionPause(Transition transition) {
        this.mGhostView.setVisibility(4);
    }

    public void onTransitionResume(Transition transition) {
        this.mGhostView.setVisibility(0);
    }
}
