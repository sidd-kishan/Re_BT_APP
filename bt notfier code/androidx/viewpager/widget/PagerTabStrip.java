/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.view.MotionEvent
 *  android.view.View$OnClickListener
 *  android.view.ViewConfiguration
 *  androidx.core.content.ContextCompat
 *  androidx.viewpager.widget.PagerTitleStrip
 */
package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerTitleStrip;

public class PagerTabStrip
extends PagerTitleStrip {
    private static final int FULL_UNDERLINE_HEIGHT = 1;
    private static final int INDICATOR_HEIGHT = 3;
    private static final int MIN_PADDING_BOTTOM = 6;
    private static final int MIN_STRIP_HEIGHT = 32;
    private static final int MIN_TEXT_SPACING = 64;
    private static final int TAB_PADDING = 16;
    private static final int TAB_SPACING = 32;
    private static final String TAG = "PagerTabStrip";
    private boolean mDrawFullUnderline = false;
    private boolean mDrawFullUnderlineSet = false;
    private int mFullUnderlineHeight;
    private boolean mIgnoreTap;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mMinPaddingBottom;
    private int mMinStripHeight;
    private int mMinTextSpacing;
    private int mTabAlpha = 255;
    private int mTabPadding;
    private final Paint mTabPaint = new Paint();
    private final Rect mTempRect = new Rect();
    private int mTouchSlop;

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int n;
        this.mIndicatorColor = n = this.mTextColor;
        this.mTabPaint.setColor(n);
        float f = context.getResources().getDisplayMetrics().density;
        this.mIndicatorHeight = (int)(3.0f * f + 0.5f);
        this.mMinPaddingBottom = (int)(6.0f * f + 0.5f);
        this.mMinTextSpacing = (int)(64.0f * f);
        this.mTabPadding = (int)(16.0f * f + 0.5f);
        this.mFullUnderlineHeight = (int)(1.0f * f + 0.5f);
        this.mMinStripHeight = (int)(f * 32.0f + 0.5f);
        this.mTouchSlop = ViewConfiguration.get((Context)context).getScaledTouchSlop();
        this.setPadding(this.getPaddingLeft(), this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        this.setTextSpacing(this.getTextSpacing());
        this.setWillNotDraw(false);
        this.mPrevText.setFocusable(true);
        this.mPrevText.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mNextText.setFocusable(true);
        this.mNextText.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        if (this.getBackground() != null) return;
        this.mDrawFullUnderline = true;
    }

    public boolean getDrawFullUnderline() {
        return this.mDrawFullUnderline;
    }

    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.mMinStripHeight);
    }

    public int getTabIndicatorColor() {
        return this.mIndicatorColor;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int n = this.getHeight();
        int n2 = this.mCurrText.getLeft();
        int n3 = this.mTabPadding;
        int n4 = this.mCurrText.getRight();
        int n5 = this.mTabPadding;
        int n6 = this.mIndicatorHeight;
        this.mTabPaint.setColor(this.mTabAlpha << 24 | this.mIndicatorColor & 0xFFFFFF);
        float f = n2 - n3;
        float f2 = n - n6;
        float f3 = n4 + n5;
        float f4 = n;
        canvas.drawRect(f, f2, f3, f4, this.mTabPaint);
        if (!this.mDrawFullUnderline) return;
        this.mTabPaint.setColor(0xFF000000 | this.mIndicatorColor & 0xFFFFFF);
        canvas.drawRect((float)this.getPaddingLeft(), (float)(n - this.mFullUnderlineHeight), (float)(this.getWidth() - this.getPaddingRight()), f4, this.mTabPaint);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n = motionEvent.getAction();
        if (n != 0 && this.mIgnoreTap) {
            return false;
        }
        float f = motionEvent.getX();
        float f2 = motionEvent.getY();
        if (n != 0) {
            if (n != 1) {
                if (n != 2) return true;
                if (!(Math.abs(f - this.mInitialMotionX) > (float)this.mTouchSlop)) {
                    if (!(Math.abs(f2 - this.mInitialMotionY) > (float)this.mTouchSlop)) return true;
                }
                this.mIgnoreTap = true;
            } else if (f < (float)(this.mCurrText.getLeft() - this.mTabPadding)) {
                this.mPager.setCurrentItem(this.mPager.getCurrentItem() - 1);
            } else {
                if (!(f > (float)(this.mCurrText.getRight() + this.mTabPadding))) return true;
                this.mPager.setCurrentItem(this.mPager.getCurrentItem() + 1);
            }
        } else {
            this.mInitialMotionX = f;
            this.mInitialMotionY = f2;
            this.mIgnoreTap = false;
        }
        return true;
    }

    public void setBackgroundColor(int n) {
        super.setBackgroundColor(n);
        if (this.mDrawFullUnderlineSet) return;
        boolean bl = (n & 0xFF000000) == 0;
        this.mDrawFullUnderline = bl;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.mDrawFullUnderlineSet) return;
        boolean bl = drawable == null;
        this.mDrawFullUnderline = bl;
    }

    public void setBackgroundResource(int n) {
        super.setBackgroundResource(n);
        if (this.mDrawFullUnderlineSet) return;
        boolean bl = n == 0;
        this.mDrawFullUnderline = bl;
    }

    public void setDrawFullUnderline(boolean bl) {
        this.mDrawFullUnderline = bl;
        this.mDrawFullUnderlineSet = true;
        this.invalidate();
    }

    public void setPadding(int n, int n2, int n3, int n4) {
        int n5 = this.mMinPaddingBottom;
        int n6 = n4;
        if (n4 < n5) {
            n6 = n5;
        }
        super.setPadding(n, n2, n3, n6);
    }

    public void setTabIndicatorColor(int n) {
        this.mIndicatorColor = n;
        this.mTabPaint.setColor(n);
        this.invalidate();
    }

    public void setTabIndicatorColorResource(int n) {
        this.setTabIndicatorColor(ContextCompat.getColor((Context)this.getContext(), (int)n));
    }

    public void setTextSpacing(int n) {
        int n2 = this.mMinTextSpacing;
        int n3 = n;
        if (n < n2) {
            n3 = n2;
        }
        super.setTextSpacing(n3);
    }

    void updateTextPositions(int n, float f, boolean bl) {
        Rect rect = this.mTempRect;
        int n2 = this.getHeight();
        int n3 = this.mCurrText.getLeft();
        int n4 = this.mTabPadding;
        int n5 = this.mCurrText.getRight();
        int n6 = this.mTabPadding;
        int n7 = n2 - this.mIndicatorHeight;
        rect.set(n3 - n4, n7, n5 + n6, n2);
        super.updateTextPositions(n, f, bl);
        this.mTabAlpha = (int)(Math.abs(f - 0.5f) * 2.0f * 255.0f);
        rect.union(this.mCurrText.getLeft() - this.mTabPadding, n7, this.mCurrText.getRight() + this.mTabPadding, n2);
        this.invalidate(rect);
    }
}
