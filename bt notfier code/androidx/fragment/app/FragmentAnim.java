/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorInflater
 *  android.content.Context
 *  android.content.res.Resources$NotFoundException
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.AnimationUtils
 *  androidx.core.os.CancellationSignal
 *  androidx.core.os.CancellationSignal$OnCancelListener
 *  androidx.fragment.R$animator
 *  androidx.fragment.R$id
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentAnim$AnimationOrAnimator
 *  androidx.fragment.app.FragmentAnim$EndViewTransitionAnimation
 *  androidx.fragment.app.FragmentTransition$Callback
 */
package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.core.os.CancellationSignal;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.FragmentTransition;

class FragmentAnim {
    private FragmentAnim() {
    }

    static void animateRemoveFragment(Fragment fragment, AnimationOrAnimator animationOrAnimator, FragmentTransition.Callback callback) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        CancellationSignal cancellationSignal = new CancellationSignal();
        cancellationSignal.setOnCancelListener((CancellationSignal.OnCancelListener)new /* Unavailable Anonymous Inner Class!! */);
        callback.onStart(fragment, cancellationSignal);
        if (animationOrAnimator.animation != null) {
            animationOrAnimator = new EndViewTransitionAnimation(animationOrAnimator.animation, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            animationOrAnimator.setAnimationListener((Animation.AnimationListener)new /* Unavailable Anonymous Inner Class!! */);
            fragment.mView.startAnimation((Animation)animationOrAnimator);
        } else {
            Animator animator = animationOrAnimator.animator;
            fragment.setAnimator(animationOrAnimator.animator);
            animator.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
            animator.setTarget((Object)fragment.mView);
            animator.start();
        }
    }

    private static int getNextAnim(Fragment fragment, boolean bl, boolean bl2) {
        if (bl2) {
            if (!bl) return fragment.getPopExitAnim();
            return fragment.getPopEnterAnim();
        }
        if (!bl) return fragment.getExitAnim();
        return fragment.getEnterAnim();
    }

    static AnimationOrAnimator loadAnimation(Context context, Fragment fragment, boolean bl, boolean bl2) {
        int n = fragment.getNextTransition();
        int n2 = FragmentAnim.getNextAnim(fragment, bl, bl2);
        int n3 = 0;
        fragment.setAnimations(0, 0, 0, 0);
        if (fragment.mContainer != null && fragment.mContainer.getTag(R.id.visible_removing_fragment_view_tag) != null) {
            fragment.mContainer.setTag(R.id.visible_removing_fragment_view_tag, null);
        }
        if (fragment.mContainer != null && fragment.mContainer.getLayoutTransition() != null) {
            return null;
        }
        Animation animation = fragment.onCreateAnimation(n, bl, n2);
        if (animation != null) {
            return new AnimationOrAnimator(animation);
        }
        if ((fragment = fragment.onCreateAnimator(n, bl, n2)) != null) {
            return new AnimationOrAnimator((Animator)fragment);
        }
        int n4 = n2;
        if (n2 == 0) {
            n4 = n2;
            if (n != 0) {
                n4 = FragmentAnim.transitToAnimResourceId(n, bl);
            }
        }
        if (n4 == 0) return null;
        bl = "anim".equals(context.getResources().getResourceTypeName(n4));
        n2 = n3;
        if (bl) {
            try {
                fragment = AnimationUtils.loadAnimation((Context)context, (int)n4);
                if (fragment != null) {
                    fragment = new AnimationOrAnimator((Animation)fragment);
                    return fragment;
                }
                n2 = 1;
            }
            catch (RuntimeException runtimeException) {
                n2 = n3;
            }
            catch (Resources.NotFoundException notFoundException) {
                throw notFoundException;
            }
        }
        if (n2 != 0) return null;
        try {
            fragment = AnimatorInflater.loadAnimator((Context)context, (int)n4);
            if (fragment == null) return null;
            fragment = new AnimationOrAnimator((Animator)fragment);
            return fragment;
        }
        catch (RuntimeException runtimeException) {
            if (bl) throw runtimeException;
            if ((context = AnimationUtils.loadAnimation((Context)context, (int)n4)) == null) return null;
            return new AnimationOrAnimator((Animation)context);
        }
    }

    private static int transitToAnimResourceId(int n, boolean bl) {
        n = n != 4097 ? (n != 4099 ? (n != 8194 ? -1 : (bl ? R.animator.fragment_close_enter : R.animator.fragment_close_exit)) : (bl ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit)) : (bl ? R.animator.fragment_open_enter : R.animator.fragment_open_exit);
        return n;
    }
}
