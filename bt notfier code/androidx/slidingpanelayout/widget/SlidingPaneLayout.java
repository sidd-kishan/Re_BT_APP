/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  androidx.core.content.ContextCompat
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.ViewCompat
 *  androidx.customview.widget.ViewDragHelper
 *  androidx.customview.widget.ViewDragHelper$Callback
 *  androidx.slidingpanelayout.widget.SlidingPaneLayout$AccessibilityDelegate
 *  androidx.slidingpanelayout.widget.SlidingPaneLayout$DisableLayerRunnable
 *  androidx.slidingpanelayout.widget.SlidingPaneLayout$DragHelperCallback
 *  androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams
 *  androidx.slidingpanelayout.widget.SlidingPaneLayout$PanelSlideListener
 *  androidx.slidingpanelayout.widget.SlidingPaneLayout$SavedState
 */
package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout
extends ViewGroup {
    private static final int DEFAULT_FADE_COLOR = -858993460;
    private static final int DEFAULT_OVERHANG_SIZE = 32;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "SlidingPaneLayout";
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    private boolean mDisplayListReflectionLoaded;
    final ViewDragHelper mDragHelper;
    private boolean mFirstLayout = true;
    private Method mGetDisplayList;
    private float mInitialMotionX;
    private float mInitialMotionY;
    boolean mIsUnableToDrag;
    private final int mOverhangSize;
    private PanelSlideListener mPanelSlideListener;
    private int mParallaxBy;
    private float mParallaxOffset;
    final ArrayList<DisableLayerRunnable> mPostedRunnables;
    boolean mPreservedOpenState;
    private Field mRecreateDisplayList;
    private Drawable mShadowDrawableLeft;
    private Drawable mShadowDrawableRight;
    float mSlideOffset;
    int mSlideRange;
    View mSlideableView;
    private int mSliderFadeColor = -858993460;
    private final Rect mTmpRect = new Rect();

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mPostedRunnables = new ArrayList();
        float f = context.getResources().getDisplayMetrics().density;
        this.mOverhangSize = (int)(32.0f * f + 0.5f);
        this.setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate((View)this, (AccessibilityDelegateCompat)new AccessibilityDelegate(this));
        ViewCompat.setImportantForAccessibility((View)this, (int)1);
        context = ViewDragHelper.create((ViewGroup)this, (float)0.5f, (ViewDragHelper.Callback)new DragHelperCallback(this));
        this.mDragHelper = context;
        context.setMinVelocity(f * 400.0f);
    }

    private boolean closePane(View view, int n) {
        if (!this.mFirstLayout) {
            if (!this.smoothSlideTo(0.0f, n)) return false;
        }
        this.mPreservedOpenState = false;
        return true;
    }

    private void dimChildView(View view, float f, int n) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (f > 0.0f && n != 0) {
            int n2 = (int)((float)((0xFF000000 & n) >>> 24) * f);
            if (layoutParams.dimPaint == null) {
                layoutParams.dimPaint = new Paint();
            }
            layoutParams.dimPaint.setColorFilter((ColorFilter)new PorterDuffColorFilter(n2 << 24 | n & 0xFFFFFF, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.dimPaint);
            }
            this.invalidateChildRegion(view);
        } else {
            if (view.getLayerType() == 0) return;
            if (layoutParams.dimPaint != null) {
                layoutParams.dimPaint.setColorFilter(null);
            }
            view = new DisableLayerRunnable(this, view);
            this.mPostedRunnables.add((DisableLayerRunnable)view);
            ViewCompat.postOnAnimation((View)this, (Runnable)view);
        }
    }

    private boolean openPane(View view, int n) {
        if (!this.mFirstLayout) {
            if (!this.smoothSlideTo(1.0f, n)) return false;
        }
        this.mPreservedOpenState = true;
        return true;
    }

    private void parallaxOtherViews(float f) {
        int n;
        boolean bl = this.isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams)this.mSlideableView.getLayoutParams();
        boolean bl2 = layoutParams.dimWhenOffset;
        int n2 = 0;
        n = bl2 && (n = bl ? layoutParams.rightMargin : layoutParams.leftMargin) <= 0 ? 1 : 0;
        int n3 = this.getChildCount();
        while (n2 < n3) {
            layoutParams = this.getChildAt(n2);
            if (layoutParams != this.mSlideableView) {
                float f2 = this.mParallaxOffset;
                int n4 = this.mParallaxBy;
                int n5 = (int)((1.0f - f2) * (float)n4);
                this.mParallaxOffset = f;
                n5 -= (int)((1.0f - f) * (float)n4);
                n4 = n5;
                if (bl) {
                    n4 = -n5;
                }
                layoutParams.offsetLeftAndRight(n4);
                if (n != 0) {
                    f2 = this.mParallaxOffset;
                    f2 = bl ? (f2 -= 1.0f) : 1.0f - f2;
                    this.dimChildView((View)layoutParams, f2, this.mCoveredFadeColor);
                }
            }
            ++n2;
        }
    }

    private static boolean viewIsOpaque(View view) {
        boolean bl = view.isOpaque();
        boolean bl2 = true;
        if (bl) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            return false;
        }
        if ((view = view.getBackground()) == null) return false;
        if (view.getOpacity() == -1) return bl2;
        bl2 = false;
        return bl2;
    }

    /*
     * Enabled force condition propagation
     */
    protected boolean canScroll(View view, boolean bl, int n, int n2, int n3) {
        boolean bl2 = view instanceof ViewGroup;
        boolean bl3 = true;
        if (bl2) {
            ViewGroup viewGroup = (ViewGroup)view;
            int n4 = view.getScrollX();
            int n5 = view.getScrollY();
            for (int i = viewGroup.getChildCount() - 1; i >= 0; --i) {
                int n6;
                int n7 = n2 + n4;
                View view2 = viewGroup.getChildAt(i);
                if (n7 < view2.getLeft() || n7 >= view2.getRight() || (n6 = n3 + n5) < view2.getTop() || n6 >= view2.getBottom() || !this.canScroll(view2, true, n, n7 - view2.getLeft(), n6 - view2.getTop())) continue;
                return true;
            }
        }
        if (!bl) return false;
        if (!this.isLayoutRtlSupport()) {
            n = -n;
        }
        if (!view.canScrollHorizontally(n)) return false;
        return bl3;
    }

    @Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean bl = layoutParams instanceof LayoutParams && super.checkLayoutParams(layoutParams);
        return bl;
    }

    public boolean closePane() {
        return this.closePane(this.mSlideableView, 0);
    }

    public void computeScroll() {
        if (!this.mDragHelper.continueSettling(true)) return;
        if (!this.mCanSlide) {
            this.mDragHelper.abort();
            return;
        }
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    void dispatchOnPanelClosed(View view) {
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelClosed(view);
        }
        this.sendAccessibilityEvent(32);
    }

    void dispatchOnPanelOpened(View view) {
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelOpened(view);
        }
        this.sendAccessibilityEvent(32);
    }

    void dispatchOnPanelSlide(View view) {
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener == null) return;
        panelSlideListener.onPanelSlide(view, this.mSlideOffset);
    }

    public void draw(Canvas canvas) {
        int n;
        int n2;
        super.draw(canvas);
        Drawable drawable = this.isLayoutRtlSupport() ? this.mShadowDrawableRight : this.mShadowDrawableLeft;
        View view = this.getChildCount() > 1 ? this.getChildAt(1) : null;
        if (view == null) return;
        if (drawable == null) return;
        int n3 = view.getTop();
        int n4 = view.getBottom();
        int n5 = drawable.getIntrinsicWidth();
        if (this.isLayoutRtlSupport()) {
            n2 = view.getRight();
            n = n5 + n2;
        } else {
            n = n2 = view.getLeft();
            n2 -= n5;
        }
        drawable.setBounds(n2, n3, n, n4);
        drawable.draw(canvas);
    }

    protected boolean drawChild(Canvas canvas, View view, long l) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        int n = canvas.save();
        if (this.mCanSlide && !layoutParams.slideable && this.mSlideableView != null) {
            canvas.getClipBounds(this.mTmpRect);
            if (this.isLayoutRtlSupport()) {
                layoutParams = this.mTmpRect;
                layoutParams.left = Math.max(layoutParams.left, this.mSlideableView.getRight());
            } else {
                layoutParams = this.mTmpRect;
                layoutParams.right = Math.min(layoutParams.right, this.mSlideableView.getLeft());
            }
            canvas.clipRect(this.mTmpRect);
        }
        boolean bl = super.drawChild(canvas, view, l);
        canvas.restoreToCount(n);
        return bl;
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this.getContext(), attributeSet);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        layoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams)layoutParams) : new LayoutParams(layoutParams);
        return layoutParams;
    }

    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    void invalidateChildRegion(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            ViewCompat.setLayerPaint((View)view, (Paint)((LayoutParams)view.getLayoutParams()).dimPaint);
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            Field field;
            if (!this.mDisplayListReflectionLoaded) {
                try {
                    this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", null);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    Log.e((String)TAG, (String)"Couldn't fetch getDisplayList method; dimming won't work right.", (Throwable)noSuchMethodException);
                }
                try {
                    this.mRecreateDisplayList = field = View.class.getDeclaredField("mRecreateDisplayList");
                    field.setAccessible(true);
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    Log.e((String)TAG, (String)"Couldn't fetch mRecreateDisplayList field; dimming will be slow.", (Throwable)noSuchFieldException);
                }
                this.mDisplayListReflectionLoaded = true;
            }
            if (this.mGetDisplayList != null && (field = this.mRecreateDisplayList) != null) {
                try {
                    field.setBoolean(view, true);
                    this.mGetDisplayList.invoke(view, null);
                }
                catch (Exception exception) {
                    Log.e((String)TAG, (String)"Error refreshing display list state", (Throwable)exception);
                }
            } else {
                view.invalidate();
                return;
            }
        }
        ViewCompat.postInvalidateOnAnimation((View)this, (int)view.getLeft(), (int)view.getTop(), (int)view.getRight(), (int)view.getBottom());
    }

    boolean isDimmed(View view) {
        boolean bl = false;
        if (view == null) {
            return false;
        }
        view = (LayoutParams)view.getLayoutParams();
        boolean bl2 = bl;
        if (!this.mCanSlide) return bl2;
        bl2 = bl;
        if (!view.dimWhenOffset) return bl2;
        bl2 = bl;
        if (!(this.mSlideOffset > 0.0f)) return bl2;
        bl2 = true;
        return bl2;
    }

    boolean isLayoutRtlSupport() {
        int n = ViewCompat.getLayoutDirection((View)this);
        boolean bl = true;
        if (n == 1) return bl;
        bl = false;
        return bl;
    }

    public boolean isOpen() {
        boolean bl = !this.mCanSlide || this.mSlideOffset == 1.0f;
        return bl;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        int n = this.mPostedRunnables.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.mPostedRunnables.clear();
                return;
            }
            this.mPostedRunnables.get(n2).run();
            ++n2;
        }
    }

    /*
     * Unable to fully structure code
     */
    public boolean onInterceptTouchEvent(MotionEvent var1_1) {
        block5: {
            block6: {
                block7: {
                    var4_2 = var1_1.getActionMasked();
                    var5_3 = this.mCanSlide;
                    var6_4 = true;
                    if (!var5_3 && var4_2 == 0 && this.getChildCount() > 1 && (var7_5 = this.getChildAt(1)) != null) {
                        this.mPreservedOpenState = this.mDragHelper.isViewUnder(var7_5, (int)var1_1.getX(), (int)var1_1.getY()) ^ true;
                    }
                    if (!this.mCanSlide || this.mIsUnableToDrag && var4_2 != 0) break block5;
                    if (var4_2 == 3 || var4_2 == 1) break block6;
                    if (var4_2 == 0) break block7;
                    if (var4_2 == 2) {
                        var2_6 = var1_1.getX();
                        var3_8 = var1_1.getY();
                        var2_6 = Math.abs(var2_6 - this.mInitialMotionX);
                        var3_8 = Math.abs(var3_8 - this.mInitialMotionY);
                        if (var2_6 > (float)this.mDragHelper.getTouchSlop() && var3_8 > var2_6) {
                            this.mDragHelper.cancel();
                            this.mIsUnableToDrag = true;
                            return false;
                        }
                    }
                    ** GOTO lbl-1000
                }
                this.mIsUnableToDrag = false;
                var3_9 = var1_1.getX();
                var2_7 = var1_1.getY();
                this.mInitialMotionX = var3_9;
                this.mInitialMotionY = var2_7;
                if (this.mDragHelper.isViewUnder(this.mSlideableView, (int)var3_9, (int)var2_7) && this.isDimmed(this.mSlideableView)) {
                    var4_2 = 1;
                } else lbl-1000:
                // 2 sources

                {
                    var4_2 = 0;
                }
                var5_3 = var6_4;
                if (this.mDragHelper.shouldInterceptTouchEvent(var1_1) != false) return var5_3;
                var5_3 = var4_2 != 0 ? var6_4 : false;
                return var5_3;
            }
            this.mDragHelper.cancel();
            return false;
        }
        this.mDragHelper.cancel();
        return super.onInterceptTouchEvent(var1_1);
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        boolean bl2 = this.isLayoutRtlSupport();
        if (bl2) {
            this.mDragHelper.setEdgeTrackingEnabled(2);
        } else {
            this.mDragHelper.setEdgeTrackingEnabled(1);
        }
        int n5 = n3 - n;
        n = bl2 ? this.getPaddingRight() : this.getPaddingLeft();
        n4 = bl2 ? this.getPaddingLeft() : this.getPaddingRight();
        int n6 = this.getPaddingTop();
        int n7 = this.getChildCount();
        if (this.mFirstLayout) {
            float f = this.mCanSlide && this.mPreservedOpenState ? 1.0f : 0.0f;
            this.mSlideOffset = f;
        }
        n2 = n;
        for (int i = 0; i < n7; ++i) {
            int n8;
            View view = this.getChildAt(i);
            if (view.getVisibility() == 8) continue;
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            int n9 = view.getMeasuredWidth();
            if (layoutParams.slideable) {
                n3 = layoutParams.leftMargin;
                int n10 = layoutParams.rightMargin;
                n8 = n5 - n4;
                this.mSlideRange = n10 = Math.min(n, n8 - this.mOverhangSize) - n2 - (n3 + n10);
                n3 = bl2 ? layoutParams.rightMargin : layoutParams.leftMargin;
                bl = n2 + n3 + n10 + n9 / 2 > n8;
                layoutParams.dimWhenOffset = bl;
                n8 = (int)((float)n10 * this.mSlideOffset);
                n2 += n3 + n8;
                this.mSlideOffset = (float)n8 / (float)this.mSlideRange;
                n3 = 0;
            } else if (this.mCanSlide && (n2 = this.mParallaxBy) != 0) {
                n3 = (int)((1.0f - this.mSlideOffset) * (float)n2);
                n2 = n;
            } else {
                n2 = n;
                n3 = 0;
            }
            if (bl2) {
                n3 = n5 - n2 + n3;
                n8 = n3 - n9;
            } else {
                n8 = n2 - n3;
                n3 = n8 + n9;
            }
            view.layout(n8, n6, n3, view.getMeasuredHeight() + n6);
            n += view.getWidth();
        }
        if (this.mFirstLayout) {
            if (this.mCanSlide) {
                if (this.mParallaxBy != 0) {
                    this.parallaxOtherViews(this.mSlideOffset);
                }
                if (((LayoutParams)this.mSlideableView.getLayoutParams()).dimWhenOffset) {
                    this.dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
                }
            } else {
                for (n = 0; n < n7; ++n) {
                    this.dimChildView(this.getChildAt(n), 0.0f, this.mSliderFadeColor);
                }
            }
            this.updateObscuredViewsVisibility(this.mSlideableView);
        }
        this.mFirstLayout = false;
    }

    protected void onMeasure(int n, int n2) {
        int n3;
        LayoutParams layoutParams;
        View view;
        int n4;
        int n5;
        int n6;
        int n7 = View.MeasureSpec.getMode((int)n);
        int n8 = View.MeasureSpec.getSize((int)n);
        int n9 = View.MeasureSpec.getMode((int)n2);
        n2 = View.MeasureSpec.getSize((int)n2);
        if (n7 != 0x40000000) {
            if (!this.isInEditMode()) throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            if (n7 == Integer.MIN_VALUE) {
                n6 = n8;
                n5 = n9;
                n = n2;
            } else {
                n6 = n8;
                n5 = n9;
                n = n2;
                if (n7 == 0) {
                    n6 = 300;
                    n5 = n9;
                    n = n2;
                }
            }
        } else {
            n6 = n8;
            n5 = n9;
            n = n2;
            if (n9 == 0) {
                if (!this.isInEditMode()) throw new IllegalStateException("Height must not be UNSPECIFIED");
                n6 = n8;
                n5 = n9;
                n = n2;
                if (n9 == 0) {
                    n5 = Integer.MIN_VALUE;
                    n = 300;
                    n6 = n8;
                }
            }
        }
        if (n5 != Integer.MIN_VALUE) {
            if (n5 != 0x40000000) {
                n = 0;
                n2 = 0;
            } else {
                n2 = n = n - this.getPaddingTop() - this.getPaddingBottom();
            }
        } else {
            n2 = n - this.getPaddingTop() - this.getPaddingBottom();
            n = 0;
        }
        int n10 = n6 - this.getPaddingLeft() - this.getPaddingRight();
        int n11 = this.getChildCount();
        if (n11 > 2) {
            Log.e((String)TAG, (String)"onMeasure: More than two child views are not supported.");
        }
        this.mSlideableView = null;
        n7 = n10;
        boolean bl = false;
        float f = 0.0f;
        n8 = n;
        for (n4 = 0; n4 < n11; ++n4) {
            view = this.getChildAt(n4);
            layoutParams = (LayoutParams)view.getLayoutParams();
            if (view.getVisibility() == 8) {
                layoutParams.dimWhenOffset = false;
                continue;
            }
            float f2 = f;
            if (layoutParams.weight > 0.0f) {
                f2 = f += layoutParams.weight;
                if (layoutParams.width == 0) continue;
            }
            n = layoutParams.leftMargin + layoutParams.rightMargin;
            n = layoutParams.width == -2 ? View.MeasureSpec.makeMeasureSpec((int)(n10 - n), (int)Integer.MIN_VALUE) : (layoutParams.width == -1 ? View.MeasureSpec.makeMeasureSpec((int)(n10 - n), (int)0x40000000) : View.MeasureSpec.makeMeasureSpec((int)layoutParams.width, (int)0x40000000));
            n9 = layoutParams.height == -2 ? View.MeasureSpec.makeMeasureSpec((int)n2, (int)Integer.MIN_VALUE) : (layoutParams.height == -1 ? View.MeasureSpec.makeMeasureSpec((int)n2, (int)0x40000000) : View.MeasureSpec.makeMeasureSpec((int)layoutParams.height, (int)0x40000000));
            view.measure(n, n9);
            n9 = view.getMeasuredWidth();
            n3 = view.getMeasuredHeight();
            n = n8;
            if (n5 == Integer.MIN_VALUE) {
                n = n8;
                if (n3 > n8) {
                    n = Math.min(n3, n2);
                }
            }
            boolean bl2 = (n9 = n7 - n9) < 0;
            layoutParams.slideable = bl2;
            bl2 = bl | bl2;
            n8 = n;
            bl = bl2;
            f = f2;
            n7 = n9;
            if (!layoutParams.slideable) continue;
            this.mSlideableView = view;
            n7 = n9;
            f = f2;
            bl = bl2;
            n8 = n;
        }
        if (bl || f > 0.0f) {
            n9 = n10 - this.mOverhangSize;
            for (n5 = 0; n5 < n11; ++n5) {
                layoutParams = this.getChildAt(n5);
                if (layoutParams.getVisibility() == 8) continue;
                view = (LayoutParams)layoutParams.getLayoutParams();
                if (layoutParams.getVisibility() == 8) continue;
                n = view.width == 0 && view.weight > 0.0f ? 1 : 0;
                n4 = n != 0 ? 0 : layoutParams.getMeasuredWidth();
                if (bl && layoutParams != this.mSlideableView) {
                    if (view.width >= 0 || n4 <= n9 && !(view.weight > 0.0f)) continue;
                    n = n != 0 ? (view.height == -2 ? View.MeasureSpec.makeMeasureSpec((int)n2, (int)Integer.MIN_VALUE) : (view.height == -1 ? View.MeasureSpec.makeMeasureSpec((int)n2, (int)0x40000000) : View.MeasureSpec.makeMeasureSpec((int)view.height, (int)0x40000000))) : View.MeasureSpec.makeMeasureSpec((int)layoutParams.getMeasuredHeight(), (int)0x40000000);
                    layoutParams.measure(View.MeasureSpec.makeMeasureSpec((int)n9, (int)0x40000000), n);
                    continue;
                }
                if (!(view.weight > 0.0f)) continue;
                n = view.width == 0 ? (view.height == -2 ? View.MeasureSpec.makeMeasureSpec((int)n2, (int)Integer.MIN_VALUE) : (view.height == -1 ? View.MeasureSpec.makeMeasureSpec((int)n2, (int)0x40000000) : View.MeasureSpec.makeMeasureSpec((int)view.height, (int)0x40000000))) : View.MeasureSpec.makeMeasureSpec((int)layoutParams.getMeasuredHeight(), (int)0x40000000);
                if (bl) {
                    int n12 = n10 - (view.leftMargin + view.rightMargin);
                    n3 = View.MeasureSpec.makeMeasureSpec((int)n12, (int)0x40000000);
                    if (n4 == n12) continue;
                    layoutParams.measure(n3, n);
                    continue;
                }
                n3 = Math.max(0, n7);
                layoutParams.measure(View.MeasureSpec.makeMeasureSpec((int)(n4 + (int)(view.weight * (float)n3 / f)), (int)0x40000000), n);
            }
        }
        this.setMeasuredDimension(n6, n8 + this.getPaddingTop() + this.getPaddingBottom());
        this.mCanSlide = bl;
        if (this.mDragHelper.getViewDragState() == 0) return;
        if (bl) return;
        this.mDragHelper.abort();
    }

    void onPanelDragged(int n) {
        float f;
        if (this.mSlideableView == null) {
            this.mSlideOffset = 0.0f;
            return;
        }
        boolean bl = this.isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams)this.mSlideableView.getLayoutParams();
        int n2 = this.mSlideableView.getWidth();
        int n3 = n;
        if (bl) {
            n3 = this.getWidth() - n - n2;
        }
        n = bl ? this.getPaddingRight() : this.getPaddingLeft();
        n2 = bl ? layoutParams.rightMargin : layoutParams.leftMargin;
        this.mSlideOffset = f = (float)(n3 - (n + n2)) / (float)this.mSlideRange;
        if (this.mParallaxBy != 0) {
            this.parallaxOtherViews(f);
        }
        if (layoutParams.dimWhenOffset) {
            this.dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
        }
        this.dispatchOnPanelSlide(this.mSlideableView);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        if (parcelable.isOpen) {
            this.openPane();
        } else {
            this.closePane();
        }
        this.mPreservedOpenState = parcelable.isOpen;
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        boolean bl = this.isSlideable() ? this.isOpen() : this.mPreservedOpenState;
        savedState.isOpen = bl;
        return savedState;
    }

    protected void onSizeChanged(int n, int n2, int n3, int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        if (n == n3) return;
        this.mFirstLayout = true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(motionEvent);
        }
        this.mDragHelper.processTouchEvent(motionEvent);
        int n = motionEvent.getActionMasked();
        if (n != 0) {
            float f;
            float f2;
            if (n != 1) return true;
            if (!this.isDimmed(this.mSlideableView)) return true;
            float f3 = motionEvent.getX();
            float f4 = f3 - this.mInitialMotionX;
            if (!(f4 * f4 + (f2 = (f = motionEvent.getY()) - this.mInitialMotionY) * f2 < (float)((n = this.mDragHelper.getTouchSlop()) * n))) return true;
            if (!this.mDragHelper.isViewUnder(this.mSlideableView, (int)f3, (int)f)) return true;
            this.closePane(this.mSlideableView, 0);
        } else {
            float f = motionEvent.getX();
            float f5 = motionEvent.getY();
            this.mInitialMotionX = f;
            this.mInitialMotionY = f5;
        }
        return true;
    }

    public boolean openPane() {
        return this.openPane(this.mSlideableView, 0);
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (this.isInTouchMode()) return;
        if (this.mCanSlide) return;
        boolean bl = view == this.mSlideableView;
        this.mPreservedOpenState = bl;
    }

    void setAllChildrenVisible() {
        int n = this.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            View view = this.getChildAt(n2);
            if (view.getVisibility() == 4) {
                view.setVisibility(0);
            }
            ++n2;
        }
    }

    public void setCoveredFadeColor(int n) {
        this.mCoveredFadeColor = n;
    }

    public void setPanelSlideListener(PanelSlideListener panelSlideListener) {
        this.mPanelSlideListener = panelSlideListener;
    }

    public void setParallaxDistance(int n) {
        this.mParallaxBy = n;
        this.requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        this.setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.mShadowDrawableLeft = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.mShadowDrawableRight = drawable;
    }

    @Deprecated
    public void setShadowResource(int n) {
        this.setShadowDrawable(this.getResources().getDrawable(n));
    }

    public void setShadowResourceLeft(int n) {
        this.setShadowDrawableLeft(ContextCompat.getDrawable((Context)this.getContext(), (int)n));
    }

    public void setShadowResourceRight(int n) {
        this.setShadowDrawableRight(ContextCompat.getDrawable((Context)this.getContext(), (int)n));
    }

    public void setSliderFadeColor(int n) {
        this.mSliderFadeColor = n;
    }

    @Deprecated
    public void smoothSlideClosed() {
        this.closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        this.openPane();
    }

    boolean smoothSlideTo(float f, int n) {
        if (!this.mCanSlide) {
            return false;
        }
        boolean bl = this.isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams)this.mSlideableView.getLayoutParams();
        if (bl) {
            n = this.getPaddingRight();
            int n2 = layoutParams.rightMargin;
            int n3 = this.mSlideableView.getWidth();
            n = (int)((float)this.getWidth() - ((float)(n + n2) + f * (float)this.mSlideRange + (float)n3));
        } else {
            n = (int)((float)(this.getPaddingLeft() + layoutParams.leftMargin) + f * (float)this.mSlideRange);
        }
        ViewDragHelper viewDragHelper = this.mDragHelper;
        layoutParams = this.mSlideableView;
        if (!viewDragHelper.smoothSlideViewTo((View)layoutParams, n, layoutParams.getTop())) return false;
        this.setAllChildrenVisible();
        ViewCompat.postInvalidateOnAnimation((View)this);
        return true;
    }

    void updateObscuredViewsVisibility(View view) {
        int n;
        int n2;
        int n3;
        int n4;
        boolean bl = this.isLayoutRtlSupport();
        int n5 = bl ? this.getWidth() - this.getPaddingRight() : this.getPaddingLeft();
        int n6 = bl ? this.getPaddingLeft() : this.getWidth() - this.getPaddingRight();
        int n7 = this.getPaddingTop();
        int n8 = this.getHeight();
        int n9 = this.getPaddingBottom();
        if (view != null && SlidingPaneLayout.viewIsOpaque(view)) {
            n4 = view.getLeft();
            n3 = view.getRight();
            n2 = view.getTop();
            n = view.getBottom();
        } else {
            n4 = 0;
            n3 = 0;
            n2 = 0;
            n = 0;
        }
        int n10 = this.getChildCount();
        int n11 = 0;
        while (n11 < n10) {
            View view2 = this.getChildAt(n11);
            if (view2 == view) {
                return;
            }
            if (view2.getVisibility() != 8) {
                int n12 = bl ? n6 : n5;
                int n13 = Math.max(n12, view2.getLeft());
                int n14 = Math.max(n7, view2.getTop());
                n12 = bl ? n5 : n6;
                n12 = Math.min(n12, view2.getRight());
                int n15 = Math.min(n8 - n9, view2.getBottom());
                n12 = n13 >= n4 && n14 >= n2 && n12 <= n3 && n15 <= n ? 4 : 0;
                view2.setVisibility(n12);
            }
            ++n11;
        }
    }
}
