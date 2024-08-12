/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.PropertyValuesHolder
 *  android.animation.TypeEvaluator
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.core.content.res.TypedArrayUtils
 *  androidx.core.view.ViewCompat
 *  androidx.transition.ChangeBounds$ViewBounds
 *  androidx.transition.ObjectAnimatorUtils
 *  androidx.transition.PropertyValuesHolderUtils
 *  androidx.transition.RectEvaluator
 *  androidx.transition.Styleable
 *  androidx.transition.Transition
 *  androidx.transition.Transition$TransitionListener
 *  androidx.transition.TransitionUtils
 *  androidx.transition.TransitionValues
 *  androidx.transition.ViewGroupUtils
 *  androidx.transition.ViewUtils
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import androidx.transition.ChangeBounds;
import androidx.transition.ObjectAnimatorUtils;
import androidx.transition.PropertyValuesHolderUtils;
import androidx.transition.RectEvaluator;
import androidx.transition.Styleable;
import androidx.transition.Transition;
import androidx.transition.TransitionUtils;
import androidx.transition.TransitionValues;
import androidx.transition.ViewGroupUtils;
import androidx.transition.ViewUtils;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class ChangeBounds
extends Transition {
    private static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY;
    private static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY;
    private static final Property<Drawable, PointF> DRAWABLE_ORIGIN_PROPERTY;
    private static final Property<View, PointF> POSITION_PROPERTY;
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_CLIP = "android:changeBounds:clip";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY;
    private static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY;
    private static RectEvaluator sRectEvaluator;
    private static final String[] sTransitionProperties;
    private boolean mReparent = false;
    private boolean mResizeClip = false;
    private int[] mTempLocation = new int[2];

    static {
        sTransitionProperties = new String[]{PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
        DRAWABLE_ORIGIN_PROPERTY = new /* Unavailable Anonymous Inner Class!! */;
        TOP_LEFT_PROPERTY = new /* Unavailable Anonymous Inner Class!! */;
        BOTTOM_RIGHT_PROPERTY = new /* Unavailable Anonymous Inner Class!! */;
        BOTTOM_RIGHT_ONLY_PROPERTY = new /* Unavailable Anonymous Inner Class!! */;
        TOP_LEFT_ONLY_PROPERTY = new /* Unavailable Anonymous Inner Class!! */;
        POSITION_PROPERTY = new /* Unavailable Anonymous Inner Class!! */;
        sRectEvaluator = new RectEvaluator();
    }

    public ChangeBounds() {
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, Styleable.CHANGE_BOUNDS);
        boolean bl = TypedArrayUtils.getNamedBoolean((TypedArray)context, (XmlPullParser)((XmlResourceParser)attributeSet), (String)"resizeClip", (int)0, (boolean)false);
        context.recycle();
        this.setResizeClip(bl);
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (!ViewCompat.isLaidOut((View)view) && view.getWidth() == 0) {
            if (view.getHeight() == 0) return;
        }
        transitionValues.values.put(PROPNAME_BOUNDS, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
        if (this.mReparent) {
            transitionValues.view.getLocationInWindow(this.mTempLocation);
            transitionValues.values.put(PROPNAME_WINDOW_X, this.mTempLocation[0]);
            transitionValues.values.put(PROPNAME_WINDOW_Y, this.mTempLocation[1]);
        }
        if (!this.mResizeClip) return;
        transitionValues.values.put(PROPNAME_CLIP, ViewCompat.getClipBounds((View)view));
    }

    /*
     * Enabled force condition propagation
     */
    private boolean parentMatches(View view, View view2) {
        boolean bl;
        boolean bl2 = this.mReparent;
        boolean bl3 = bl = true;
        if (!bl2) return bl3;
        TransitionValues transitionValues = this.getMatchedTransitionValues(view, true);
        if (transitionValues == null) {
            if (view != view2) return false;
            return bl;
        }
        if (view2 == transitionValues.view) return bl;
        return false;
    }

    public void captureEndValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues object) {
        Map map;
        Object object2;
        block22: {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            block27: {
                int n14;
                block26: {
                    block25: {
                        block23: {
                            block24: {
                                if (transitionValues == null) return null;
                                if (object == null) {
                                    return null;
                                }
                                object2 = transitionValues.values;
                                map = object.values;
                                object2 = (ViewGroup)object2.get(PROPNAME_PARENT);
                                ViewGroup viewGroup2 = (ViewGroup)map.get(PROPNAME_PARENT);
                                if (object2 == null) return null;
                                if (viewGroup2 == null) {
                                    return null;
                                }
                                map = object.view;
                                if (!this.parentMatches((View)object2, (View)viewGroup2)) break block22;
                                object2 = (Rect)transitionValues.values.get(PROPNAME_BOUNDS);
                                viewGroup = (Rect)object.values.get(PROPNAME_BOUNDS);
                                n13 = ((Rect)object2).left;
                                n12 = viewGroup.left;
                                n11 = ((Rect)object2).top;
                                n10 = viewGroup.top;
                                n9 = ((Rect)object2).right;
                                n8 = viewGroup.right;
                                n7 = ((Rect)object2).bottom;
                                n6 = viewGroup.bottom;
                                n5 = n9 - n13;
                                n4 = n7 - n11;
                                n3 = n8 - n12;
                                n2 = n6 - n10;
                                transitionValues = (Rect)transitionValues.values.get(PROPNAME_CLIP);
                                object2 = (Rect)object.values.get(PROPNAME_CLIP);
                                if ((n5 == 0 || n4 == 0) && (n3 == 0 || n2 == 0)) break block23;
                                n = n13 == n12 && n11 == n10 ? 0 : 1;
                                if (n9 != n8) break block24;
                                n14 = n;
                                if (n7 == n6) break block25;
                            }
                            n14 = n + 1;
                            break block25;
                        }
                        n14 = 0;
                    }
                    if (transitionValues != null && !transitionValues.equals(object2)) break block26;
                    n = n14;
                    if (transitionValues != null) break block27;
                    n = n14;
                    if (object2 == null) break block27;
                }
                n = n14 + 1;
            }
            if (n <= 0) return null;
            if (!this.mResizeClip) {
                ViewUtils.setLeftTopRightBottom((View)map, (int)n13, (int)n11, (int)n9, (int)n7);
                if (n == 2) {
                    if (n5 == n3 && n4 == n2) {
                        viewGroup = this.getPathMotion().getPath((float)n13, (float)n11, (float)n12, (float)n10);
                        viewGroup = ObjectAnimatorUtils.ofPointF((Object)map, POSITION_PROPERTY, (Path)viewGroup);
                    } else {
                        transitionValues = new ViewBounds((View)map);
                        viewGroup = this.getPathMotion().getPath((float)n13, (float)n11, (float)n12, (float)n10);
                        object = ObjectAnimatorUtils.ofPointF((Object)transitionValues, TOP_LEFT_PROPERTY, (Path)viewGroup);
                        viewGroup = this.getPathMotion().getPath((float)n9, (float)n7, (float)n8, (float)n6);
                        object2 = ObjectAnimatorUtils.ofPointF((Object)transitionValues, BOTTOM_RIGHT_PROPERTY, (Path)viewGroup);
                        viewGroup = new AnimatorSet();
                        viewGroup.playTogether(new Animator[]{object, object2});
                        viewGroup.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
                    }
                } else if (n13 == n12 && n11 == n10) {
                    viewGroup = this.getPathMotion().getPath((float)n9, (float)n7, (float)n8, (float)n6);
                    viewGroup = ObjectAnimatorUtils.ofPointF((Object)map, BOTTOM_RIGHT_ONLY_PROPERTY, (Path)viewGroup);
                } else {
                    viewGroup = this.getPathMotion().getPath((float)n13, (float)n11, (float)n12, (float)n10);
                    viewGroup = ObjectAnimatorUtils.ofPointF((Object)map, TOP_LEFT_ONLY_PROPERTY, (Path)viewGroup);
                }
            } else {
                ViewUtils.setLeftTopRightBottom((View)map, (int)n13, (int)n11, (int)(Math.max(n5, n3) + n13), (int)(Math.max(n4, n2) + n11));
                if (n13 == n12 && n11 == n10) {
                    viewGroup = null;
                } else {
                    viewGroup = this.getPathMotion().getPath((float)n13, (float)n11, (float)n12, (float)n10);
                    viewGroup = ObjectAnimatorUtils.ofPointF((Object)map, POSITION_PROPERTY, (Path)viewGroup);
                }
                if (transitionValues == null) {
                    transitionValues = new Rect(0, 0, n5, n4);
                }
                if (!transitionValues.equals(object = object2 == null ? new Rect(0, 0, n3, n2) : object2)) {
                    ViewCompat.setClipBounds((View)map, (Rect)transitionValues);
                    transitionValues = ObjectAnimator.ofObject((Object)map, (String)"clipBounds", (TypeEvaluator)sRectEvaluator, (Object[])new Object[]{transitionValues, object});
                    transitionValues.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
                } else {
                    transitionValues = null;
                }
                viewGroup = TransitionUtils.mergeAnimators((Animator)viewGroup, (Animator)transitionValues);
            }
            if (!(map.getParent() instanceof ViewGroup)) return viewGroup;
            transitionValues = (ViewGroup)map.getParent();
            ViewGroupUtils.suppressLayout((ViewGroup)transitionValues, (boolean)true);
            this.addListener((Transition.TransitionListener)new /* Unavailable Anonymous Inner Class!! */);
            return viewGroup;
        }
        int n = (Integer)transitionValues.values.get(PROPNAME_WINDOW_X);
        int n15 = (Integer)transitionValues.values.get(PROPNAME_WINDOW_Y);
        int n16 = (Integer)object.values.get(PROPNAME_WINDOW_X);
        int n17 = (Integer)object.values.get(PROPNAME_WINDOW_Y);
        if (n == n16) {
            if (n15 == n17) return null;
        }
        viewGroup.getLocationInWindow(this.mTempLocation);
        transitionValues = Bitmap.createBitmap((int)map.getWidth(), (int)map.getHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
        map.draw(new Canvas((Bitmap)transitionValues));
        transitionValues = new BitmapDrawable((Bitmap)transitionValues);
        float f = ViewUtils.getTransitionAlpha((View)map);
        ViewUtils.setTransitionAlpha((View)map, (float)0.0f);
        ViewUtils.getOverlay((View)viewGroup).add((Drawable)transitionValues);
        object = this.getPathMotion();
        object2 = this.mTempLocation;
        object = object.getPath((float)(n - object2[0]), (float)(n15 - object2[1]), (float)(n16 - object2[0]), (float)(n17 - object2[1]));
        object = ObjectAnimator.ofPropertyValuesHolder((Object)transitionValues, (PropertyValuesHolder[])new PropertyValuesHolder[]{PropertyValuesHolderUtils.ofPointF(DRAWABLE_ORIGIN_PROPERTY, (Path)object)});
        object.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        return object;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setResizeClip(boolean bl) {
        this.mResizeClip = bl;
    }
}
