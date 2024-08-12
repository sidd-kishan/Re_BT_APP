/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ArgbEvaluator
 *  android.animation.ObjectAnimator
 *  android.animation.TypeEvaluator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.LightingColorFilter
 *  android.graphics.Rect
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.ViewStub
 *  android.view.Window
 *  android.view.animation.AlphaAnimation
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.view.animation.TranslateAnimation
 *  android.widget.ImageView
 *  android.widget.ListView
 *  androidx.appcompat.R$attr
 *  androidx.core.content.ContextCompat
 *  com.qmuiteam.qmui.util.QMUIDirection
 *  com.qmuiteam.qmui.util.QMUIViewHelper$7
 *  com.qmuiteam.qmui.util.QMUIViewHelper$ViewGroupHelper
 *  com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout
 */
package com.qmuiteam.qmui.util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.R;
import androidx.core.content.ContextCompat;
import com.qmuiteam.qmui.util.QMUIDirection;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Exception performing whole class analysis ignored.
 */
public class QMUIViewHelper {
    private static final int[] APPCOMPAT_CHECK_ATTRS;
    private static final AtomicInteger sNextGeneratedId;

    static {
        sNextGeneratedId = new AtomicInteger(1);
        APPCOMPAT_CHECK_ATTRS = new int[]{R.attr.colorPrimary};
    }

    public static Rect calcViewScreenLocation(View view) {
        int[] nArray = new int[2];
        view.getLocationOnScreen(nArray);
        return new Rect(nArray[0], nArray[1], nArray[0] + view.getWidth(), nArray[1] + view.getHeight());
    }

    public static void checkAppCompatTheme(Context context) {
        context = context.obtainStyledAttributes(APPCOMPAT_CHECK_ATTRS);
        boolean bl = context.hasValue(0);
        context.recycle();
        if (bl ^ true) throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
    }

    public static void clearValueAnimator(Animator animator) {
        if (animator == null) return;
        animator.removeAllListeners();
        if (animator instanceof ValueAnimator) {
            ((ValueAnimator)animator).removeAllUpdateListeners();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            animator.pause();
        }
        animator.cancel();
    }

    public static void expendTouchArea(View view, int n) {
        if (view == null) return;
        View view2 = (View)view.getParent();
        view2.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public static AlphaAnimation fadeIn(View view, int n, Animation.AnimationListener animationListener, boolean bl) {
        if (view == null) {
            return null;
        }
        if (!bl) {
            view.setAlpha(1.0f);
            view.setVisibility(0);
            return null;
        }
        view.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator((Interpolator)new DecelerateInterpolator());
        alphaAnimation.setDuration((long)n);
        alphaAnimation.setFillAfter(true);
        if (animationListener != null) {
            alphaAnimation.setAnimationListener(animationListener);
        }
        view.startAnimation((Animation)alphaAnimation);
        return alphaAnimation;
    }

    public static AlphaAnimation fadeOut(View view, int n, Animation.AnimationListener animationListener, boolean bl) {
        if (view == null) {
            return null;
        }
        if (bl) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setInterpolator((Interpolator)new DecelerateInterpolator());
            alphaAnimation.setDuration((long)n);
            alphaAnimation.setAnimationListener((Animation.AnimationListener)new /* Unavailable Anonymous Inner Class!! */);
            view.startAnimation((Animation)alphaAnimation);
            return alphaAnimation;
        }
        view.setVisibility(8);
        return null;
    }

    public static View findViewFromViewStub(View view, int n, int n2) {
        View view2;
        if (view == null) {
            return null;
        }
        View view3 = view2 = view.findViewById(n2);
        if (view2 != null) return view3;
        if ((view = (ViewStub)view.findViewById(n)) == null) {
            return null;
        }
        view3 = view = view.inflate();
        if (view == null) return view3;
        view3 = view.findViewById(n2);
        return view3;
    }

    public static View findViewFromViewStub(View view, int n, int n2, int n3) {
        View view2;
        if (view == null) {
            return null;
        }
        View view3 = view2 = view.findViewById(n2);
        if (view2 != null) return view3;
        if ((view = (ViewStub)view.findViewById(n)) == null) {
            return null;
        }
        if (view.getLayoutResource() < 1 && n3 > 0) {
            view.setLayoutResource(n3);
        }
        view3 = view = view.inflate();
        if (view == null) return view3;
        view3 = view.findViewById(n2);
        return view3;
    }

    public static int generateViewId() {
        int n;
        int n2;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            int n3;
            n2 = sNextGeneratedId.get();
            n = n3 = n2 + 1;
            if (n3 <= 0xFFFFFF) continue;
            n = 1;
        } while (!sNextGeneratedId.compareAndSet(n2, n));
        return n2;
    }

    public static View getActivityRoot(Activity activity) {
        return ((ViewGroup)activity.findViewById(0x1020002)).getChildAt(0);
    }

    public static void getDescendantRect(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ViewGroupHelper.offsetDescendantRect((ViewGroup)viewGroup, (View)view, (Rect)rect);
    }

    public static boolean getIsLastLineSpacingExtraError() {
        boolean bl = Build.VERSION.SDK_INT < 21;
        return bl;
    }

    public static boolean isListViewAlreadyAtBottom(ListView listView) {
        if (listView.getAdapter() == null) return false;
        if (listView.getHeight() == 0) {
            return false;
        }
        if (listView.getLastVisiblePosition() != listView.getAdapter().getCount() - 1) return false;
        View view = listView.getChildAt(listView.getChildCount() - 1);
        if (view == null) return false;
        if (view.getBottom() != listView.getHeight()) return false;
        return true;
    }

    public static void playBackgroundBlinkAnimation(View view, int n) {
        if (view == null) {
            return;
        }
        QMUIViewHelper.playViewBackgroundAnimation(view, n, new int[]{0, 255, 0}, 300);
    }

    public static Animator playViewBackgroundAnimation(View view, int n, int[] object, int n2, Runnable runnable) {
        int n3 = ((int[])object).length;
        Object object2 = new ColorDrawable(n);
        Drawable drawable = view.getBackground();
        QMUIViewHelper.setBackgroundKeepingPadding(view, (Drawable)object2);
        object2 = new ArrayList();
        n = 0;
        while (true) {
            if (n >= n3 - 1) {
                object = new AnimatorSet();
                object.setDuration((long)n2);
                object.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
                object.playSequentially((List)object2);
                object.start();
                return object;
            }
            Drawable drawable2 = view.getBackground();
            int n4 = object[n];
            object2.add(ObjectAnimator.ofInt((Object)drawable2, (String)"alpha", (int[])new int[]{n4, object[++n]}));
        }
    }

    public static void playViewBackgroundAnimation(View view, int n, int n2, long l) {
        QMUIViewHelper.playViewBackgroundAnimation(view, n, n2, l, 0, 0, null);
    }

    public static void playViewBackgroundAnimation(View view, int n, int n2, long l, int n3, int n4, Runnable runnable) {
        Drawable drawable = view.getBackground();
        QMUIViewHelper.setBackgroundColorKeepPadding(view, n);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{n, n2});
        valueAnimator.setDuration(l / (long)(n3 + 1));
        valueAnimator.setRepeatCount(n3);
        valueAnimator.setRepeatMode(2);
        valueAnimator.setEvaluator((TypeEvaluator)new ArgbEvaluator());
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
        if (n4 != 0) {
            view.setTag(n4, (Object)valueAnimator);
        }
        valueAnimator.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        valueAnimator.start();
    }

    public static void playViewBackgroundAnimation(View view, int n, int[] nArray, int n2) {
        QMUIViewHelper.playViewBackgroundAnimation(view, n, nArray, n2, null);
    }

    public static void requestApplyInsets(Window window) {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            window.getDecorView().requestFitSystemWindows();
        } else {
            if (Build.VERSION.SDK_INT < 21) return;
            window.getDecorView().requestApplyInsets();
        }
    }

    public static void safeRequestDisallowInterceptTouchEvent(View view, boolean bl) {
        ViewParent viewParent = view.getParent();
        if (viewParent == null) return;
        view = viewParent;
        while (true) {
            if (view == null) {
                viewParent.requestDisallowInterceptTouchEvent(bl);
                return;
            }
            if (view instanceof QMUIPullRefreshLayout) {
                ((QMUIPullRefreshLayout)view).openSafeDisallowInterceptTouchEvent();
            }
            view = view.getParent();
        }
    }

    public static void safeSetImageViewSelected(ImageView imageView, boolean bl) {
        Drawable drawable = imageView.getDrawable();
        if (drawable == null) {
            return;
        }
        int n = drawable.getIntrinsicWidth();
        int n2 = drawable.getIntrinsicHeight();
        imageView.setSelected(bl);
        if (drawable.getIntrinsicWidth() == n) {
            if (drawable.getIntrinsicHeight() == n2) return;
        }
        imageView.requestLayout();
    }

    public static void setBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void setBackgroundColorKeepPadding(View view, int n) {
        int[] nArray = new int[]{view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
        view.setBackgroundColor(n);
        view.setPadding(nArray[0], nArray[1], nArray[2], nArray[3]);
    }

    public static void setBackgroundKeepingPadding(View view, int n) {
        QMUIViewHelper.setBackgroundKeepingPadding(view, ContextCompat.getDrawable((Context)view.getContext(), (int)n));
    }

    public static void setBackgroundKeepingPadding(View view, Drawable drawable) {
        int[] nArray = new int[]{view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
        QMUIViewHelper.setBackground(view, drawable);
        view.setPadding(nArray[0], nArray[1], nArray[2], nArray[3]);
    }

    public static ColorFilter setImageViewTintColor(ImageView imageView, int n) {
        LightingColorFilter lightingColorFilter = new LightingColorFilter(Color.argb((int)255, (int)0, (int)0, (int)0), n);
        imageView.setColorFilter((ColorFilter)lightingColorFilter);
        return lightingColorFilter;
    }

    public static void setPaddingBottom(View view, int n) {
        if (n == view.getPaddingBottom()) return;
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), n);
    }

    public static void setPaddingLeft(View view, int n) {
        if (n == view.getPaddingLeft()) return;
        view.setPadding(n, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static void setPaddingRight(View view, int n) {
        if (n == view.getPaddingRight()) return;
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), n, view.getPaddingBottom());
    }

    public static void setPaddingTop(View view, int n) {
        if (n == view.getPaddingTop()) return;
        view.setPadding(view.getPaddingLeft(), n, view.getPaddingRight(), view.getPaddingBottom());
    }

    public static TranslateAnimation slideIn(View view, int n, Animation.AnimationListener animationListener, boolean bl, QMUIDirection object) {
        Object var6_5 = null;
        if (view == null) {
            return null;
        }
        if (!bl) {
            view.clearAnimation();
            view.setVisibility(0);
            return null;
        }
        int n2 = 7.$SwitchMap$com$qmuiteam$qmui$util$QMUIDirection[object.ordinal()];
        object = n2 != 1 ? (n2 != 2 ? (n2 != 3 ? (n2 != 4 ? var6_5 : new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f)) : new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f)) : new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f)) : new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        object.setInterpolator((Interpolator)new DecelerateInterpolator());
        object.setDuration((long)n);
        object.setFillAfter(true);
        if (animationListener != null) {
            object.setAnimationListener(animationListener);
        }
        view.setVisibility(0);
        view.startAnimation((Animation)object);
        return object;
    }

    public static TranslateAnimation slideOut(View view, int n, Animation.AnimationListener animationListener, boolean bl, QMUIDirection object) {
        Object var6_5 = null;
        if (view == null) {
            return null;
        }
        if (!bl) {
            view.clearAnimation();
            view.setVisibility(8);
            return null;
        }
        int n2 = 7.$SwitchMap$com$qmuiteam$qmui$util$QMUIDirection[object.ordinal()];
        object = n2 != 1 ? (n2 != 2 ? (n2 != 3 ? (n2 != 4 ? var6_5 : new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f)) : new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f)) : new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f)) : new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
        object.setInterpolator((Interpolator)new DecelerateInterpolator());
        object.setDuration((long)n);
        object.setAnimationListener((Animation.AnimationListener)new /* Unavailable Anonymous Inner Class!! */);
        view.startAnimation((Animation)object);
        return object;
    }
}
