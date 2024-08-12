/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.graphics.Matrix
 *  android.view.View
 *  androidx.transition.ChangeTransform
 *  androidx.transition.ChangeTransform$PathAnimatorMatrix
 *  androidx.transition.ChangeTransform$Transforms
 *  androidx.transition.R$id
 *  androidx.transition.ViewUtils
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.view.View;
import androidx.transition.ChangeTransform;
import androidx.transition.R;
import androidx.transition.ViewUtils;

/*
 * Exception performing whole class analysis ignored.
 */
class ChangeTransform.3
extends AnimatorListenerAdapter {
    private boolean mIsCanceled;
    private Matrix mTempMatrix;
    final ChangeTransform this$0;
    final Matrix val$finalEndMatrix;
    final boolean val$handleParentChange;
    final ChangeTransform.PathAnimatorMatrix val$pathAnimatorMatrix;
    final ChangeTransform.Transforms val$transforms;
    final View val$view;

    ChangeTransform.3(ChangeTransform changeTransform, boolean bl, Matrix matrix, View view, ChangeTransform.Transforms transforms, ChangeTransform.PathAnimatorMatrix pathAnimatorMatrix) {
        this.this$0 = changeTransform;
        this.val$handleParentChange = bl;
        this.val$finalEndMatrix = matrix;
        this.val$view = view;
        this.val$transforms = transforms;
        this.val$pathAnimatorMatrix = pathAnimatorMatrix;
        this.mTempMatrix = new Matrix();
    }

    private void setCurrentMatrix(Matrix matrix) {
        this.mTempMatrix.set(matrix);
        this.val$view.setTag(R.id.transition_transform, (Object)this.mTempMatrix);
        this.val$transforms.restore(this.val$view);
    }

    public void onAnimationCancel(Animator animator) {
        this.mIsCanceled = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.mIsCanceled) {
            if (this.val$handleParentChange && this.this$0.mUseOverlay) {
                this.setCurrentMatrix(this.val$finalEndMatrix);
            } else {
                this.val$view.setTag(R.id.transition_transform, null);
                this.val$view.setTag(R.id.parent_matrix, null);
            }
        }
        ViewUtils.setAnimationMatrix((View)this.val$view, null);
        this.val$transforms.restore(this.val$view);
    }

    public void onAnimationPause(Animator animator) {
        this.setCurrentMatrix(this.val$pathAnimatorMatrix.getMatrix());
    }

    public void onAnimationResume(Animator animator) {
        ChangeTransform.setIdentityTransforms((View)this.val$view);
    }
}
