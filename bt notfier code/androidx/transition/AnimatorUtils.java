/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.Animator$AnimatorPauseListener
 *  android.animation.AnimatorListenerAdapter
 *  android.os.Build$VERSION
 *  androidx.transition.AnimatorUtils$AnimatorPauseListenerCompat
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import androidx.transition.AnimatorUtils;
import java.util.ArrayList;

class AnimatorUtils {
    private AnimatorUtils() {
    }

    static void addPauseListener(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        if (Build.VERSION.SDK_INT < 19) return;
        animator.addPauseListener((Animator.AnimatorPauseListener)animatorListenerAdapter);
    }

    static void pause(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.pause();
            return;
        }
        ArrayList arrayList = animator.getListeners();
        if (arrayList == null) return;
        int n = 0;
        int n2 = arrayList.size();
        while (n < n2) {
            Animator.AnimatorListener animatorListener = (Animator.AnimatorListener)arrayList.get(n);
            if (animatorListener instanceof AnimatorPauseListenerCompat) {
                ((AnimatorPauseListenerCompat)animatorListener).onAnimationPause(animator);
            }
            ++n;
        }
    }

    static void resume(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.resume();
            return;
        }
        ArrayList arrayList = animator.getListeners();
        if (arrayList == null) return;
        int n = 0;
        int n2 = arrayList.size();
        while (n < n2) {
            Animator.AnimatorListener animatorListener = (Animator.AnimatorListener)arrayList.get(n);
            if (animatorListener instanceof AnimatorPauseListenerCompat) {
                ((AnimatorPauseListenerCompat)animatorListener).onAnimationResume(animator);
            }
            ++n;
        }
    }
}
