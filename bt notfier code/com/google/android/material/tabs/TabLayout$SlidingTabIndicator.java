/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.animation.AnimationUtils
 *  com.google.android.material.tabs.TabLayout
 *  com.google.android.material.tabs.TabLayout$TabView
 */
package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.tabs.TabLayout;

/*
 * Exception performing whole class analysis ignored.
 */
private class TabLayout.SlidingTabIndicator
extends LinearLayout {
    private final GradientDrawable defaultSelectionIndicator;
    private ValueAnimator indicatorAnimator;
    private int indicatorLeft;
    private int indicatorRight;
    private int layoutDirection;
    private int selectedIndicatorHeight;
    private final Paint selectedIndicatorPaint;
    int selectedPosition;
    float selectionOffset;
    final TabLayout this$0;

    TabLayout.SlidingTabIndicator(TabLayout tabLayout, Context context) {
        this.this$0 = tabLayout;
        super(context);
        this.selectedPosition = -1;
        this.layoutDirection = -1;
        this.indicatorLeft = -1;
        this.indicatorRight = -1;
        this.setWillNotDraw(false);
        this.selectedIndicatorPaint = new Paint();
        this.defaultSelectionIndicator = new GradientDrawable();
    }

    private void calculateTabViewContentBounds(TabLayout.TabView tabView, RectF rectF) {
        int n;
        int n2 = n = TabLayout.TabView.access$500((TabLayout.TabView)tabView);
        if (n < this.this$0.dpToPx(24)) {
            n2 = this.this$0.dpToPx(24);
        }
        n = (tabView.getLeft() + tabView.getRight()) / 2;
        rectF.set((float)(n - (n2 /= 2)), 0.0f, (float)(n + n2), 0.0f);
    }

    private void updateIndicatorPosition() {
        int n;
        int n2;
        View view = this.getChildAt(this.selectedPosition);
        if (view != null && view.getWidth() > 0) {
            n2 = view.getLeft();
            n = view.getRight();
            int n3 = n2;
            int n4 = n;
            if (!this.this$0.tabIndicatorFullWidth) {
                n3 = n2;
                n4 = n;
                if (view instanceof TabLayout.TabView) {
                    this.calculateTabViewContentBounds((TabLayout.TabView)view, TabLayout.access$400((TabLayout)this.this$0));
                    n3 = (int)TabLayout.access$400((TabLayout)this.this$0).left;
                    n4 = (int)TabLayout.access$400((TabLayout)this.this$0).right;
                }
            }
            n2 = n3;
            n = n4;
            if (this.selectionOffset > 0.0f) {
                n2 = n3;
                n = n4;
                if (this.selectedPosition < this.getChildCount() - 1) {
                    view = this.getChildAt(this.selectedPosition + 1);
                    int n5 = view.getLeft();
                    int n6 = view.getRight();
                    n2 = n5;
                    n = n6;
                    if (!this.this$0.tabIndicatorFullWidth) {
                        n2 = n5;
                        n = n6;
                        if (view instanceof TabLayout.TabView) {
                            this.calculateTabViewContentBounds((TabLayout.TabView)view, TabLayout.access$400((TabLayout)this.this$0));
                            n2 = (int)TabLayout.access$400((TabLayout)this.this$0).left;
                            n = (int)TabLayout.access$400((TabLayout)this.this$0).right;
                        }
                    }
                    float f = this.selectionOffset;
                    n2 = (int)((float)n2 * f + (1.0f - f) * (float)n3);
                    n = (int)((float)n * f + (1.0f - f) * (float)n4);
                }
            }
        } else {
            n2 = -1;
            n = -1;
        }
        this.setIndicatorPosition(n2, n);
    }

    void animateIndicatorToPosition(int n, int n2) {
        ValueAnimator valueAnimator = this.indicatorAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.indicatorAnimator.cancel();
        }
        if ((valueAnimator = this.getChildAt(n)) == null) {
            this.updateIndicatorPosition();
            return;
        }
        int n3 = valueAnimator.getLeft();
        int n4 = valueAnimator.getRight();
        int n5 = n3;
        int n6 = n4;
        if (!this.this$0.tabIndicatorFullWidth) {
            n5 = n3;
            n6 = n4;
            if (valueAnimator instanceof TabLayout.TabView) {
                this.calculateTabViewContentBounds((TabLayout.TabView)valueAnimator, TabLayout.access$400((TabLayout)this.this$0));
                n5 = (int)TabLayout.access$400((TabLayout)this.this$0).left;
                n6 = (int)TabLayout.access$400((TabLayout)this.this$0).right;
            }
        }
        n4 = this.indicatorLeft;
        n3 = this.indicatorRight;
        if (n4 == n5) {
            if (n3 == n6) return;
        }
        this.indicatorAnimator = valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimator.setDuration((long)n2);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
        valueAnimator.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        valueAnimator.start();
    }

    boolean childrenNeedLayout() {
        int n = this.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            if (this.getChildAt(n2).getWidth() <= 0) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public void draw(Canvas canvas) {
        int n;
        Object object = this.this$0.tabSelectedIndicator;
        int n2 = 0;
        int n3 = object != null ? this.this$0.tabSelectedIndicator.getIntrinsicHeight() : 0;
        int n4 = this.selectedIndicatorHeight;
        if (n4 >= 0) {
            n3 = n4;
        }
        if ((n = this.this$0.tabIndicatorGravity) != 0) {
            if (n != 1) {
                n4 = n2;
                if (n != 2) {
                    if (n != 3) {
                        n3 = 0;
                        n4 = n2;
                    } else {
                        n3 = this.getHeight();
                        n4 = n2;
                    }
                }
            } else {
                n4 = (this.getHeight() - n3) / 2;
                n3 = (this.getHeight() + n3) / 2;
            }
        } else {
            n4 = this.getHeight() - n3;
            n3 = this.getHeight();
        }
        if ((n2 = this.indicatorLeft) >= 0 && this.indicatorRight > n2) {
            object = this.this$0.tabSelectedIndicator != null ? this.this$0.tabSelectedIndicator : this.defaultSelectionIndicator;
            object = DrawableCompat.wrap((Drawable)object);
            object.setBounds(this.indicatorLeft, n4, this.indicatorRight, n3);
            if (this.selectedIndicatorPaint != null) {
                if (Build.VERSION.SDK_INT == 21) {
                    object.setColorFilter(this.selectedIndicatorPaint.getColor(), PorterDuff.Mode.SRC_IN);
                } else {
                    DrawableCompat.setTint((Drawable)object, (int)this.selectedIndicatorPaint.getColor());
                }
            }
            object.draw(canvas);
        }
        super.draw(canvas);
    }

    float getIndicatorPosition() {
        return (float)this.selectedPosition + this.selectionOffset;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        ValueAnimator valueAnimator = this.indicatorAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.indicatorAnimator.cancel();
            long l = this.indicatorAnimator.getDuration();
            this.animateIndicatorToPosition(this.selectedPosition, Math.round((1.0f - this.indicatorAnimator.getAnimatedFraction()) * (float)l));
        } else {
            this.updateIndicatorPosition();
        }
    }

    protected void onMeasure(int n, int n2) {
        View view;
        int n3;
        super.onMeasure(n, n2);
        if (View.MeasureSpec.getMode((int)n) != 0x40000000) {
            return;
        }
        int n4 = this.this$0.mode;
        int n5 = 1;
        if (n4 != 1) return;
        if (this.this$0.tabGravity != 1) return;
        int n6 = this.getChildCount();
        int n7 = 0;
        int n8 = 0;
        for (n3 = 0; n3 < n6; ++n3) {
            view = this.getChildAt(n3);
            n4 = n8;
            if (view.getVisibility() == 0) {
                n4 = Math.max(n8, view.getMeasuredWidth());
            }
            n8 = n4;
        }
        if (n8 <= 0) {
            return;
        }
        n4 = this.this$0.dpToPx(16);
        if (n8 * n6 <= this.getMeasuredWidth() - n4 * 2) {
            n4 = 0;
            for (n3 = n7; n3 < n6; ++n3) {
                view = (LinearLayout.LayoutParams)this.getChildAt(n3).getLayoutParams();
                if (view.width == n8 && view.weight == 0.0f) continue;
                view.width = n8;
                view.weight = 0.0f;
                n4 = 1;
            }
        } else {
            this.this$0.tabGravity = 0;
            this.this$0.updateTabViews(false);
            n4 = n5;
        }
        if (n4 == 0) return;
        super.onMeasure(n, n2);
    }

    public void onRtlPropertiesChanged(int n) {
        super.onRtlPropertiesChanged(n);
        if (Build.VERSION.SDK_INT >= 23) return;
        if (this.layoutDirection == n) return;
        this.requestLayout();
        this.layoutDirection = n;
    }

    void setIndicatorPosition(int n, int n2) {
        if (n == this.indicatorLeft) {
            if (n2 == this.indicatorRight) return;
        }
        this.indicatorLeft = n;
        this.indicatorRight = n2;
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    void setIndicatorPositionFromTabPosition(int n, float f) {
        ValueAnimator valueAnimator = this.indicatorAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.indicatorAnimator.cancel();
        }
        this.selectedPosition = n;
        this.selectionOffset = f;
        this.updateIndicatorPosition();
    }

    void setSelectedIndicatorColor(int n) {
        if (this.selectedIndicatorPaint.getColor() == n) return;
        this.selectedIndicatorPaint.setColor(n);
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    void setSelectedIndicatorHeight(int n) {
        if (this.selectedIndicatorHeight == n) return;
        this.selectedIndicatorHeight = n;
        ViewCompat.postInvalidateOnAnimation((View)this);
    }
}
