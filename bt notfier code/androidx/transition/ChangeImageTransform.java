/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.ObjectAnimator
 *  android.animation.TypeEvaluator
 *  android.content.Context
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  androidx.transition.ChangeImageTransform$3
 *  androidx.transition.MatrixUtils
 *  androidx.transition.Transition
 *  androidx.transition.TransitionUtils$MatrixEvaluator
 *  androidx.transition.TransitionValues
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.ChangeImageTransform;
import androidx.transition.MatrixUtils;
import androidx.transition.Transition;
import androidx.transition.TransitionUtils;
import androidx.transition.TransitionValues;

public class ChangeImageTransform
extends Transition {
    private static final Property<ImageView, Matrix> ANIMATED_TRANSFORM_PROPERTY;
    private static final TypeEvaluator<Matrix> NULL_MATRIX_EVALUATOR;
    private static final String PROPNAME_BOUNDS = "android:changeImageTransform:bounds";
    private static final String PROPNAME_MATRIX = "android:changeImageTransform:matrix";
    private static final String[] sTransitionProperties;

    static {
        sTransitionProperties = new String[]{PROPNAME_MATRIX, PROPNAME_BOUNDS};
        NULL_MATRIX_EVALUATOR = new /* Unavailable Anonymous Inner Class!! */;
        ANIMATED_TRANSFORM_PROPERTY = new /* Unavailable Anonymous Inner Class!! */;
    }

    public ChangeImageTransform() {
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void captureValues(TransitionValues object) {
        View view = ((TransitionValues)object).view;
        if (!(view instanceof ImageView)) return;
        if (view.getVisibility() != 0) return;
        ImageView imageView = (ImageView)view;
        if (imageView.getDrawable() == null) {
            return;
        }
        object = ((TransitionValues)object).values;
        object.put(PROPNAME_BOUNDS, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        object.put(PROPNAME_MATRIX, ChangeImageTransform.copyImageMatrix(imageView));
    }

    private static Matrix centerCropMatrix(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int n = drawable.getIntrinsicWidth();
        float f = imageView.getWidth();
        float f2 = n;
        float f3 = f / f2;
        n = drawable.getIntrinsicHeight();
        float f4 = imageView.getHeight();
        float f5 = n;
        f3 = Math.max(f3, f4 / f5);
        int n2 = Math.round((f - f2 * f3) / 2.0f);
        n = Math.round((f4 - f5 * f3) / 2.0f);
        imageView = new Matrix();
        imageView.postScale(f3, f3);
        imageView.postTranslate((float)n2, (float)n);
        return imageView;
    }

    private static Matrix copyImageMatrix(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable.getIntrinsicWidth() <= 0) return new Matrix(imageView.getImageMatrix());
        if (drawable.getIntrinsicHeight() <= 0) return new Matrix(imageView.getImageMatrix());
        int n = 3.$SwitchMap$android$widget$ImageView$ScaleType[imageView.getScaleType().ordinal()];
        if (n == 1) return ChangeImageTransform.fitXYMatrix(imageView);
        if (n == 2) return ChangeImageTransform.centerCropMatrix(imageView);
        return new Matrix(imageView.getImageMatrix());
    }

    private ObjectAnimator createMatrixAnimator(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject((Object)imageView, ANIMATED_TRANSFORM_PROPERTY, (TypeEvaluator)new TransitionUtils.MatrixEvaluator(), (Object[])new Matrix[]{matrix, matrix2});
    }

    private ObjectAnimator createNullAnimator(ImageView imageView) {
        return ObjectAnimator.ofObject((Object)imageView, ANIMATED_TRANSFORM_PROPERTY, NULL_MATRIX_EVALUATOR, (Object[])new Matrix[]{MatrixUtils.IDENTITY_MATRIX, MatrixUtils.IDENTITY_MATRIX});
    }

    private static Matrix fitXYMatrix(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale((float)imageView.getWidth() / (float)drawable.getIntrinsicWidth(), (float)imageView.getHeight() / (float)drawable.getIntrinsicHeight());
        return matrix;
    }

    public void captureEndValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        Matrix matrix = null;
        viewGroup = matrix;
        if (transitionValues == null) return viewGroup;
        if (transitionValues2 == null) {
            viewGroup = matrix;
        } else {
            Rect rect = (Rect)transitionValues.values.get(PROPNAME_BOUNDS);
            Rect rect2 = (Rect)transitionValues2.values.get(PROPNAME_BOUNDS);
            viewGroup = matrix;
            if (rect == null) return viewGroup;
            if (rect2 == null) {
                viewGroup = matrix;
            } else {
                transitionValues = (Matrix)transitionValues.values.get(PROPNAME_MATRIX);
                matrix = (Matrix)transitionValues2.values.get(PROPNAME_MATRIX);
                int n = transitionValues == null && matrix == null || transitionValues != null && transitionValues.equals((Object)matrix) ? 1 : 0;
                if (rect.equals((Object)rect2) && n != 0) {
                    return null;
                }
                transitionValues2 = (ImageView)transitionValues2.view;
                viewGroup = transitionValues2.getDrawable();
                int n2 = viewGroup.getIntrinsicWidth();
                n = viewGroup.getIntrinsicHeight();
                if (n2 > 0 && n > 0) {
                    viewGroup = transitionValues;
                    if (transitionValues == null) {
                        viewGroup = MatrixUtils.IDENTITY_MATRIX;
                    }
                    transitionValues = matrix;
                    if (matrix == null) {
                        transitionValues = MatrixUtils.IDENTITY_MATRIX;
                    }
                    ANIMATED_TRANSFORM_PROPERTY.set((Object)transitionValues2, (Object)viewGroup);
                    viewGroup = this.createMatrixAnimator((ImageView)transitionValues2, (Matrix)viewGroup, (Matrix)transitionValues);
                } else {
                    viewGroup = this.createNullAnimator((ImageView)transitionValues2);
                }
            }
        }
        return viewGroup;
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }
}
