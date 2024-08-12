/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ObjectAnimator
 *  android.animation.PropertyValuesHolder
 *  android.animation.TypeEvaluator
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Matrix
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.os.Build$VERSION
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.core.content.res.TypedArrayUtils
 *  androidx.core.view.ViewCompat
 *  androidx.transition.AnimatorUtils
 *  androidx.transition.ChangeTransform$GhostListener
 *  androidx.transition.ChangeTransform$PathAnimatorMatrix
 *  androidx.transition.ChangeTransform$Transforms
 *  androidx.transition.FloatArrayEvaluator
 *  androidx.transition.GhostView
 *  androidx.transition.GhostViewUtils
 *  androidx.transition.MatrixUtils
 *  androidx.transition.PropertyValuesHolderUtils
 *  androidx.transition.R$id
 *  androidx.transition.Styleable
 *  androidx.transition.Transition
 *  androidx.transition.Transition$TransitionListener
 *  androidx.transition.TransitionValues
 *  androidx.transition.ViewUtils
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import androidx.transition.AnimatorUtils;
import androidx.transition.ChangeTransform;
import androidx.transition.FloatArrayEvaluator;
import androidx.transition.GhostView;
import androidx.transition.GhostViewUtils;
import androidx.transition.MatrixUtils;
import androidx.transition.PropertyValuesHolderUtils;
import androidx.transition.R;
import androidx.transition.Styleable;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import androidx.transition.ViewUtils;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform
extends Transition {
    private static final Property<PathAnimatorMatrix, float[]> NON_TRANSLATIONS_PROPERTY;
    private static final String PROPNAME_INTERMEDIATE_MATRIX = "android:changeTransform:intermediateMatrix";
    private static final String PROPNAME_INTERMEDIATE_PARENT_MATRIX = "android:changeTransform:intermediateParentMatrix";
    private static final String PROPNAME_MATRIX = "android:changeTransform:matrix";
    private static final String PROPNAME_PARENT = "android:changeTransform:parent";
    private static final String PROPNAME_PARENT_MATRIX = "android:changeTransform:parentMatrix";
    private static final String PROPNAME_TRANSFORMS = "android:changeTransform:transforms";
    private static final boolean SUPPORTS_VIEW_REMOVAL_SUPPRESSION;
    private static final Property<PathAnimatorMatrix, PointF> TRANSLATIONS_PROPERTY;
    private static final String[] sTransitionProperties;
    private boolean mReparent = true;
    private Matrix mTempMatrix = new Matrix();
    boolean mUseOverlay = true;

    static {
        sTransitionProperties = new String[]{PROPNAME_MATRIX, PROPNAME_TRANSFORMS, PROPNAME_PARENT_MATRIX};
        NON_TRANSLATIONS_PROPERTY = new /* Unavailable Anonymous Inner Class!! */;
        TRANSLATIONS_PROPERTY = new /* Unavailable Anonymous Inner Class!! */;
        boolean bl = Build.VERSION.SDK_INT >= 21;
        SUPPORTS_VIEW_REMOVAL_SUPPRESSION = bl;
    }

    public ChangeTransform() {
    }

    public ChangeTransform(Context context, AttributeSet object) {
        super(context, (AttributeSet)object);
        context = context.obtainStyledAttributes((AttributeSet)object, Styleable.CHANGE_TRANSFORM);
        object = (XmlPullParser)object;
        this.mUseOverlay = TypedArrayUtils.getNamedBoolean((TypedArray)context, (XmlPullParser)object, (String)"reparentWithOverlay", (int)1, (boolean)true);
        this.mReparent = TypedArrayUtils.getNamedBoolean((TypedArray)context, (XmlPullParser)object, (String)"reparent", (int)0, (boolean)true);
        context.recycle();
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.getVisibility() == 8) {
            return;
        }
        transitionValues.values.put(PROPNAME_PARENT, view.getParent());
        Object object = new Transforms(view);
        transitionValues.values.put(PROPNAME_TRANSFORMS, object);
        object = view.getMatrix();
        object = object != null && !object.isIdentity() ? new Matrix((Matrix)object) : null;
        transitionValues.values.put(PROPNAME_MATRIX, object);
        if (!this.mReparent) return;
        object = new Matrix();
        ViewGroup viewGroup = (ViewGroup)view.getParent();
        ViewUtils.transformMatrixToGlobal((View)viewGroup, (Matrix)object);
        object.preTranslate((float)(-viewGroup.getScrollX()), (float)(-viewGroup.getScrollY()));
        transitionValues.values.put(PROPNAME_PARENT_MATRIX, object);
        transitionValues.values.put(PROPNAME_INTERMEDIATE_MATRIX, view.getTag(R.id.transition_transform));
        transitionValues.values.put(PROPNAME_INTERMEDIATE_PARENT_MATRIX, view.getTag(R.id.parent_matrix));
    }

    private void createGhostView(ViewGroup object, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View view = transitionValues2.view;
        Matrix matrix = new Matrix((Matrix)transitionValues2.values.get(PROPNAME_PARENT_MATRIX));
        ViewUtils.transformMatrixToLocal((View)object, (Matrix)matrix);
        matrix = GhostViewUtils.addGhost((View)view, (ViewGroup)object, (Matrix)matrix);
        if (matrix == null) {
            return;
        }
        matrix.reserveEndViewTransition((ViewGroup)transitionValues.values.get(PROPNAME_PARENT), transitionValues.view);
        object = this;
        while (object.mParent != null) {
            object = object.mParent;
        }
        object.addListener((Transition.TransitionListener)new GhostListener(view, (GhostView)matrix));
        if (!SUPPORTS_VIEW_REMOVAL_SUPPRESSION) return;
        if (transitionValues.view != transitionValues2.view) {
            ViewUtils.setTransitionAlpha((View)transitionValues.view, (float)0.0f);
        }
        ViewUtils.setTransitionAlpha((View)view, (float)1.0f);
    }

    private ObjectAnimator createTransformAnimator(TransitionValues transitionValues, TransitionValues transitionValues2, boolean bl) {
        transitionValues = (Matrix)transitionValues.values.get(PROPNAME_MATRIX);
        Matrix matrix = (Matrix)transitionValues2.values.get(PROPNAME_MATRIX);
        TransitionValues transitionValues3 = transitionValues;
        if (transitionValues == null) {
            transitionValues3 = MatrixUtils.IDENTITY_MATRIX;
        }
        transitionValues = matrix;
        if (matrix == null) {
            transitionValues = MatrixUtils.IDENTITY_MATRIX;
        }
        if (transitionValues3.equals((Object)transitionValues)) {
            return null;
        }
        matrix = (Transforms)transitionValues2.values.get(PROPNAME_TRANSFORMS);
        transitionValues2 = transitionValues2.view;
        ChangeTransform.setIdentityTransforms((View)transitionValues2);
        Object object = new float[9];
        transitionValues3.getValues(object);
        float[] fArray = new float[9];
        transitionValues.getValues(fArray);
        transitionValues3 = new PathAnimatorMatrix((View)transitionValues2, object);
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofObject(NON_TRANSLATIONS_PROPERTY, (TypeEvaluator)new FloatArrayEvaluator(new float[9]), (Object[])new float[][]{object, fArray});
        object = this.getPathMotion().getPath(object[2], object[5], fArray[2], fArray[5]);
        propertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder((Object)transitionValues3, (PropertyValuesHolder[])new PropertyValuesHolder[]{propertyValuesHolder, PropertyValuesHolderUtils.ofPointF(TRANSLATIONS_PROPERTY, (Path)object)});
        transitionValues = new /* Unavailable Anonymous Inner Class!! */;
        propertyValuesHolder.addListener((Animator.AnimatorListener)transitionValues);
        AnimatorUtils.addPauseListener((Animator)propertyValuesHolder, (AnimatorListenerAdapter)transitionValues);
        return propertyValuesHolder;
    }

    /*
     * Enabled force condition propagation
     */
    private boolean parentsMatch(ViewGroup viewGroup, ViewGroup viewGroup2) {
        boolean bl = this.isValidTarget((View)viewGroup);
        boolean bl2 = true;
        boolean bl3 = false;
        if (bl && this.isValidTarget((View)viewGroup2)) {
            if ((viewGroup = this.getMatchedTransitionValues((View)viewGroup, true)) == null) return bl3;
            if (viewGroup2 != viewGroup.view) return false;
            return bl2;
        }
        if (viewGroup != viewGroup2) return false;
        return bl2;
    }

    static void setIdentityTransforms(View view) {
        ChangeTransform.setTransforms(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    private void setMatricesForParent(TransitionValues transitionValues, TransitionValues transitionValues2) {
        Matrix matrix = (Matrix)transitionValues2.values.get(PROPNAME_PARENT_MATRIX);
        transitionValues2.view.setTag(R.id.parent_matrix, (Object)matrix);
        Matrix matrix2 = this.mTempMatrix;
        matrix2.reset();
        matrix.invert(matrix2);
        matrix = (Matrix)transitionValues.values.get(PROPNAME_MATRIX);
        transitionValues2 = matrix;
        if (matrix == null) {
            transitionValues2 = new Matrix();
            transitionValues.values.put(PROPNAME_MATRIX, transitionValues2);
        }
        transitionValues2.postConcat((Matrix)transitionValues.values.get(PROPNAME_PARENT_MATRIX));
        transitionValues2.postConcat(matrix2);
    }

    static void setTransforms(View view, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        view.setTranslationX(f);
        view.setTranslationY(f2);
        ViewCompat.setTranslationZ((View)view, (float)f3);
        view.setScaleX(f4);
        view.setScaleY(f5);
        view.setRotationX(f6);
        view.setRotationY(f7);
        view.setRotation(f8);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
        if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION) return;
        ((ViewGroup)transitionValues.view.getParent()).startViewTransition(transitionValues.view);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null) return null;
        if (transitionValues2 == null) return null;
        if (!transitionValues.values.containsKey(PROPNAME_PARENT)) return null;
        if (!transitionValues2.values.containsKey(PROPNAME_PARENT)) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup)transitionValues.values.get(PROPNAME_PARENT);
        ViewGroup viewGroup3 = (ViewGroup)transitionValues2.values.get(PROPNAME_PARENT);
        boolean bl = this.mReparent && !this.parentsMatch(viewGroup2, viewGroup3);
        viewGroup3 = (Matrix)transitionValues.values.get(PROPNAME_INTERMEDIATE_MATRIX);
        if (viewGroup3 != null) {
            transitionValues.values.put(PROPNAME_MATRIX, viewGroup3);
        }
        if ((viewGroup3 = (Matrix)transitionValues.values.get(PROPNAME_INTERMEDIATE_PARENT_MATRIX)) != null) {
            transitionValues.values.put(PROPNAME_PARENT_MATRIX, viewGroup3);
        }
        if (bl) {
            this.setMatricesForParent(transitionValues, transitionValues2);
        }
        viewGroup3 = this.createTransformAnimator(transitionValues, transitionValues2, bl);
        if (bl && viewGroup3 != null && this.mUseOverlay) {
            this.createGhostView(viewGroup, transitionValues, transitionValues2);
        } else {
            if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION) return viewGroup3;
            viewGroup2.endViewTransition(transitionValues.view);
        }
        return viewGroup3;
    }

    public boolean getReparent() {
        return this.mReparent;
    }

    public boolean getReparentWithOverlay() {
        return this.mUseOverlay;
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setReparent(boolean bl) {
        this.mReparent = bl;
    }

    public void setReparentWithOverlay(boolean bl) {
        this.mUseOverlay = bl;
    }
}
