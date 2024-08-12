/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.view.View
 *  androidx.core.app.SharedElementCallback
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.Fragment$OnStartEnterTransitionListener
 */
package androidx.fragment.app;

import android.animation.Animator;
import android.view.View;
import androidx.core.app.SharedElementCallback;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

static class Fragment.AnimationInfo {
    Boolean mAllowEnterTransitionOverlap;
    Boolean mAllowReturnTransitionOverlap;
    View mAnimatingAway;
    Animator mAnimator;
    int mEnterAnim;
    Object mEnterTransition = null;
    SharedElementCallback mEnterTransitionCallback = null;
    boolean mEnterTransitionPostponed;
    int mExitAnim;
    Object mExitTransition = null;
    SharedElementCallback mExitTransitionCallback = null;
    View mFocusedView = null;
    boolean mIsHideReplaced;
    boolean mIsPop;
    int mNextTransition;
    int mPopEnterAnim;
    int mPopExitAnim;
    float mPostOnViewCreatedAlpha = 1.0f;
    Object mReenterTransition;
    Object mReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
    Object mSharedElementEnterTransition = null;
    Object mSharedElementReturnTransition;
    ArrayList<String> mSharedElementSourceNames;
    ArrayList<String> mSharedElementTargetNames;
    Fragment.OnStartEnterTransitionListener mStartEnterTransitionListener;

    Fragment.AnimationInfo() {
        this.mReenterTransition = Fragment.USE_DEFAULT_TRANSITION;
        this.mSharedElementReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
    }
}
