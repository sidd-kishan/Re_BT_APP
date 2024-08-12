/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.core.content.res.TypedArrayUtils
 *  androidx.transition.AnimatorUtils
 *  androidx.transition.R$id
 *  androidx.transition.Styleable
 *  androidx.transition.Transition
 *  androidx.transition.Transition$TransitionListener
 *  androidx.transition.TransitionUtils
 *  androidx.transition.TransitionValues
 *  androidx.transition.ViewGroupUtils
 *  androidx.transition.ViewUtils
 *  androidx.transition.Visibility$DisappearListener
 *  androidx.transition.Visibility$VisibilityInfo
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.AnimatorUtils;
import androidx.transition.R;
import androidx.transition.Styleable;
import androidx.transition.Transition;
import androidx.transition.TransitionUtils;
import androidx.transition.TransitionValues;
import androidx.transition.ViewGroupUtils;
import androidx.transition.ViewUtils;
import androidx.transition.Visibility;
import org.xmlpull.v1.XmlPullParser;

public abstract class Visibility
extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String[] sTransitionProperties = new String[]{"android:visibility:visibility", "android:visibility:parent"};
    private int mMode = 3;

    public Visibility() {
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, Styleable.VISIBILITY_TRANSITION);
        int n = TypedArrayUtils.getNamedInt((TypedArray)context, (XmlPullParser)((XmlResourceParser)attributeSet), (String)"transitionVisibilityMode", (int)0, (int)0);
        context.recycle();
        if (n == 0) return;
        this.setMode(n);
    }

    private void captureValues(TransitionValues transitionValues) {
        int n = transitionValues.view.getVisibility();
        transitionValues.values.put(PROPNAME_VISIBILITY, n);
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
        int[] nArray = new int[2];
        transitionValues.view.getLocationOnScreen(nArray);
        transitionValues.values.put(PROPNAME_SCREEN_LOCATION, nArray);
    }

    private VisibilityInfo getVisibilityChangeInfo(TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = new VisibilityInfo();
        visibilityInfo.mVisibilityChange = false;
        visibilityInfo.mFadeIn = false;
        if (transitionValues != null && transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.mStartVisibility = (Integer)transitionValues.values.get(PROPNAME_VISIBILITY);
            visibilityInfo.mStartParent = (ViewGroup)transitionValues.values.get(PROPNAME_PARENT);
        } else {
            visibilityInfo.mStartVisibility = -1;
            visibilityInfo.mStartParent = null;
        }
        if (transitionValues2 != null && transitionValues2.values.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.mEndVisibility = (Integer)transitionValues2.values.get(PROPNAME_VISIBILITY);
            visibilityInfo.mEndParent = (ViewGroup)transitionValues2.values.get(PROPNAME_PARENT);
        } else {
            visibilityInfo.mEndVisibility = -1;
            visibilityInfo.mEndParent = null;
        }
        if (transitionValues != null && transitionValues2 != null) {
            if (visibilityInfo.mStartVisibility == visibilityInfo.mEndVisibility && visibilityInfo.mStartParent == visibilityInfo.mEndParent) {
                return visibilityInfo;
            }
            if (visibilityInfo.mStartVisibility != visibilityInfo.mEndVisibility) {
                if (visibilityInfo.mStartVisibility == 0) {
                    visibilityInfo.mFadeIn = false;
                    visibilityInfo.mVisibilityChange = true;
                } else {
                    if (visibilityInfo.mEndVisibility != 0) return visibilityInfo;
                    visibilityInfo.mFadeIn = true;
                    visibilityInfo.mVisibilityChange = true;
                }
            } else if (visibilityInfo.mEndParent == null) {
                visibilityInfo.mFadeIn = false;
                visibilityInfo.mVisibilityChange = true;
            } else {
                if (visibilityInfo.mStartParent != null) return visibilityInfo;
                visibilityInfo.mFadeIn = true;
                visibilityInfo.mVisibilityChange = true;
            }
        } else if (transitionValues == null && visibilityInfo.mEndVisibility == 0) {
            visibilityInfo.mFadeIn = true;
            visibilityInfo.mVisibilityChange = true;
        } else {
            if (transitionValues2 != null) return visibilityInfo;
            if (visibilityInfo.mStartVisibility != 0) return visibilityInfo;
            visibilityInfo.mFadeIn = false;
            visibilityInfo.mVisibilityChange = true;
        }
        return visibilityInfo;
    }

    public void captureEndValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = this.getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (!visibilityInfo.mVisibilityChange) return null;
        if (visibilityInfo.mStartParent == null) {
            if (visibilityInfo.mEndParent == null) return null;
        }
        if (!visibilityInfo.mFadeIn) return this.onDisappear(viewGroup, transitionValues, visibilityInfo.mStartVisibility, transitionValues2, visibilityInfo.mEndVisibility);
        return this.onAppear(viewGroup, transitionValues, visibilityInfo.mStartVisibility, transitionValues2, visibilityInfo.mEndVisibility);
    }

    public int getMode() {
        return this.mMode;
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        boolean bl = false;
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.values.containsKey(PROPNAME_VISIBILITY) != transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
            return false;
        }
        transitionValues = this.getVisibilityChangeInfo(transitionValues, transitionValues2);
        boolean bl2 = bl;
        if (!transitionValues.mVisibilityChange) return bl2;
        if (transitionValues.mStartVisibility != 0) {
            bl2 = bl;
            if (transitionValues.mEndVisibility != 0) return bl2;
        }
        bl2 = true;
        return bl2;
    }

    public boolean isVisible(TransitionValues transitionValues) {
        boolean bl = false;
        if (transitionValues == null) {
            return false;
        }
        int n = (Integer)transitionValues.values.get(PROPNAME_VISIBILITY);
        transitionValues = (View)transitionValues.values.get(PROPNAME_PARENT);
        boolean bl2 = bl;
        if (n != 0) return bl2;
        bl2 = bl;
        if (transitionValues == null) return bl2;
        bl2 = true;
        return bl2;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int n, TransitionValues transitionValues2, int n2) {
        if ((this.mMode & 1) != 1) return null;
        if (transitionValues2 == null) {
            return null;
        }
        if (transitionValues != null) return this.onAppear(viewGroup, transitionValues2.view, transitionValues, transitionValues2);
        View view = (View)transitionValues2.view.getParent();
        if (!this.getVisibilityChangeInfo((TransitionValues)this.getMatchedTransitionValues((View)view, (boolean)false), (TransitionValues)this.getTransitionValues((View)view, (boolean)false)).mVisibilityChange) return this.onAppear(viewGroup, transitionValues2.view, transitionValues, transitionValues2);
        return null;
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public Animator onDisappear(ViewGroup var1_1, TransitionValues var2_2, int var3_3, TransitionValues var4_4, int var5_5) {
        block19: {
            block21: {
                block20: {
                    block18: {
                        if ((this.mMode & 2) != 2) {
                            return null;
                        }
                        if (var2_2 == null) {
                            return null;
                        }
                        var10_6 = var2_2.view;
                        var8_7 /* !! */  = var4_4 != null ? var4_4.view : null;
                        var7_8 = (View)var10_6.getTag(R.id.save_overlay_view);
                        if (var7_8 == null) break block18;
                        var8_7 /* !! */  = null;
                        var3_3 = 1;
                        break block19;
                    }
                    if (var8_7 /* !! */  == null || var8_7 /* !! */ .getParent() == null) break block20;
                    if (var5_5 /* !! */  != 4 && var10_6 != var8_7 /* !! */ ) ** GOTO lbl-1000
                    var7_8 = var8_7 /* !! */ ;
                    var3_3 = 0;
                    var8_7 /* !! */  = null;
                    break block21;
                }
                if (var8_7 /* !! */  != null) {
                    var7_8 = null;
                    var3_3 = 0;
                } else lbl-1000:
                // 2 sources

                {
                    var8_7 /* !! */  = null;
                    var7_8 = null;
                    var3_3 = 1;
                }
            }
            var9_9 = var8_7 /* !! */ ;
            if (var3_3 == 0) ** GOTO lbl-1000
            if (var10_6.getParent() == null) ** GOTO lbl-1000
            var9_9 = var8_7 /* !! */ ;
            if (var10_6.getParent() instanceof View) {
                var11_10 = (View)var10_6.getParent();
                if (!this.getVisibilityChangeInfo((TransitionValues)this.getTransitionValues((View)var11_10, (boolean)true), (TransitionValues)this.getMatchedTransitionValues((View)var11_10, (boolean)true)).mVisibilityChange) {
                    var9_9 = TransitionUtils.copyViewImage((ViewGroup)var1_1, (View)var10_6, (View)var11_10);
                } else {
                    var3_3 = var11_10.getId();
                    var9_9 = var8_7 /* !! */ ;
                    if (var11_10.getParent() == null) {
                        var9_9 = var8_7 /* !! */ ;
                        if (var3_3 != -1) {
                            var9_9 = var8_7 /* !! */ ;
                            if (var1_1.findViewById(var3_3) != null) {
                                var9_9 = var8_7 /* !! */ ;
                                ** if (!this.mCanRemoveViews) goto lbl-1000
                            }
                        }
                    }
                }
            }
            ** GOTO lbl-1000
lbl-1000:
            // 2 sources

            {
                var8_7 /* !! */  = var7_8;
                var3_3 = 0;
                var7_8 = var10_6;
                ** GOTO lbl55
            }
lbl-1000:
            // 4 sources

            {
                var3_3 = 0;
                var8_7 /* !! */  = var7_8;
                var7_8 = var9_9;
            }
        }
        if (var7_8 != null) {
            if (var3_3 == 0) {
                var8_7 /* !! */  = (View)((int[])var2_2.values.get("android:visibility:screenLocation"));
                var6_11 = var8_7 /* !! */ [0];
                var5_5 /* !! */  = (int)var8_7 /* !! */ [1];
                var8_7 /* !! */  = (View)new int[2];
                var1_1.getLocationOnScreen((int[])var8_7 /* !! */ );
                var7_8.offsetLeftAndRight((int)(var6_11 - var8_7 /* !! */ [0] - var7_8.getLeft()));
                var7_8.offsetTopAndBottom(var5_5 /* !! */  - var8_7 /* !! */ [1] - var7_8.getTop());
                ViewGroupUtils.getOverlay((ViewGroup)var1_1).add(var7_8);
            }
            var2_2 = this.onDisappear(var1_1, var7_8, var2_2, var4_4);
            if (var3_3 != 0) return var2_2;
            if (var2_2 == null) {
                ViewGroupUtils.getOverlay((ViewGroup)var1_1).remove(var7_8);
            } else {
                var10_6.setTag(R.id.save_overlay_view, (Object)var7_8);
                this.addListener((Transition.TransitionListener)new /* Unavailable Anonymous Inner Class!! */);
            }
            return var2_2;
        }
        if (var8_7 /* !! */  == null) return null;
        var3_3 = var8_7 /* !! */ .getVisibility();
        ViewUtils.setTransitionVisibility((View)var8_7 /* !! */ , (int)0);
        var1_1 = this.onDisappear(var1_1, var8_7 /* !! */ , var2_2, var4_4);
        if (var1_1 != null) {
            var2_2 = new DisappearListener(var8_7 /* !! */ , var5_5 /* !! */ , true);
            var1_1.addListener((Animator.AnimatorListener)var2_2);
            AnimatorUtils.addPauseListener((Animator)var1_1, (AnimatorListenerAdapter)var2_2);
            this.addListener((Transition.TransitionListener)var2_2);
        } else {
            ViewUtils.setTransitionVisibility((View)var8_7 /* !! */ , (int)var3_3);
        }
        return var1_1;
    }

    public void setMode(int n) {
        if ((n & 0xFFFFFFFC) != 0) throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        this.mMode = n;
    }
}
