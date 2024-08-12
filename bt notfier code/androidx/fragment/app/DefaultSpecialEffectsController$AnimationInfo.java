/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.core.os.CancellationSignal
 *  androidx.fragment.app.DefaultSpecialEffectsController$SpecialEffectsInfo
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentAnim
 *  androidx.fragment.app.FragmentAnim$AnimationOrAnimator
 *  androidx.fragment.app.SpecialEffectsController$Operation
 *  androidx.fragment.app.SpecialEffectsController$Operation$State
 */
package androidx.fragment.app;

import android.content.Context;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;

private static class DefaultSpecialEffectsController.AnimationInfo
extends DefaultSpecialEffectsController.SpecialEffectsInfo {
    private FragmentAnim.AnimationOrAnimator mAnimation;
    private boolean mIsPop;
    private boolean mLoadedAnim = false;

    DefaultSpecialEffectsController.AnimationInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal, boolean bl) {
        super(operation, cancellationSignal);
        this.mIsPop = bl;
    }

    FragmentAnim.AnimationOrAnimator getAnimation(Context context) {
        if (this.mLoadedAnim) {
            return this.mAnimation;
        }
        Fragment fragment = this.getOperation().getFragment();
        boolean bl = this.getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE;
        context = FragmentAnim.loadAnimation((Context)context, (Fragment)fragment, (boolean)bl, (boolean)this.mIsPop);
        this.mAnimation = context;
        this.mLoadedAnim = true;
        return context;
    }
}
