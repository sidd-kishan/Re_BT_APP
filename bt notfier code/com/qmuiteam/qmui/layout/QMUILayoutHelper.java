/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.RectF
 *  android.graphics.Xfermode
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewOutlineProvider
 *  androidx.core.content.ContextCompat
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$color
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.layout.IQMUILayout
 *  com.qmuiteam.qmui.util.QMUIResHelper
 */
package com.qmuiteam.qmui.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.core.content.ContextCompat;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.IQMUILayout;
import com.qmuiteam.qmui.util.QMUIResHelper;
import java.lang.ref.WeakReference;

public class QMUILayoutHelper
implements IQMUILayout {
    private int mBorderColor;
    private RectF mBorderRect;
    private int mBorderWidth;
    private int mBottomDividerAlpha;
    private int mBottomDividerColor;
    private int mBottomDividerHeight;
    private int mBottomDividerInsetLeft;
    private int mBottomDividerInsetRight;
    private Paint mClipPaint;
    private Context mContext;
    private Paint mDividerPaint;
    private int mHeightLimit;
    private int mHeightMini;
    private int mHideRadiusSide;
    private boolean mIsOutlineExcludePadding;
    private boolean mIsShowBorderOnlyBeforeL;
    private int mLeftDividerAlpha;
    private int mLeftDividerColor;
    private int mLeftDividerInsetBottom;
    private int mLeftDividerInsetTop;
    private int mLeftDividerWidth;
    private PorterDuffXfermode mMode;
    private int mOuterNormalColor;
    private int mOutlineInsetBottom;
    private int mOutlineInsetLeft;
    private int mOutlineInsetRight;
    private int mOutlineInsetTop;
    private WeakReference<View> mOwner;
    private Path mPath;
    private int mRadius;
    private float[] mRadiusArray;
    private int mRightDividerAlpha;
    private int mRightDividerColor;
    private int mRightDividerInsetBottom;
    private int mRightDividerInsetTop;
    private int mRightDividerWidth;
    private float mShadowAlpha;
    private int mShadowColor;
    private int mShadowElevation;
    private int mTopDividerAlpha;
    private int mTopDividerColor;
    private int mTopDividerHeight;
    private int mTopDividerInsetLeft;
    private int mTopDividerInsetRight;
    private int mWidthLimit;
    private int mWidthMini;

    public QMUILayoutHelper(Context context, AttributeSet attributeSet, int n, View view) {
        boolean bl;
        int n2;
        int n3 = 0;
        this.mWidthLimit = 0;
        this.mHeightLimit = 0;
        this.mWidthMini = 0;
        this.mHeightMini = 0;
        this.mTopDividerHeight = 0;
        this.mTopDividerInsetLeft = 0;
        this.mTopDividerInsetRight = 0;
        this.mTopDividerAlpha = 255;
        this.mBottomDividerHeight = 0;
        this.mBottomDividerInsetLeft = 0;
        this.mBottomDividerInsetRight = 0;
        this.mBottomDividerAlpha = 255;
        this.mLeftDividerWidth = 0;
        this.mLeftDividerInsetTop = 0;
        this.mLeftDividerInsetBottom = 0;
        this.mLeftDividerAlpha = 255;
        this.mRightDividerWidth = 0;
        this.mRightDividerInsetTop = 0;
        this.mRightDividerInsetBottom = 0;
        this.mRightDividerAlpha = 255;
        this.mHideRadiusSide = 0;
        this.mBorderColor = 0;
        this.mBorderWidth = 1;
        this.mOuterNormalColor = 0;
        this.mIsOutlineExcludePadding = false;
        this.mPath = new Path();
        this.mIsShowBorderOnlyBeforeL = true;
        this.mShadowElevation = 0;
        this.mShadowColor = -16777216;
        this.mOutlineInsetLeft = 0;
        this.mOutlineInsetRight = 0;
        this.mOutlineInsetTop = 0;
        this.mOutlineInsetBottom = 0;
        this.mContext = context;
        this.mOwner = new WeakReference<View>(view);
        this.mTopDividerColor = n2 = ContextCompat.getColor((Context)context, (int)R.color.qmui_config_color_separator);
        this.mBottomDividerColor = n2;
        this.mMode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        view = new Paint();
        this.mClipPaint = view;
        view.setAntiAlias(true);
        this.mShadowAlpha = QMUIResHelper.getAttrFloatValue((Context)context, (int)R.attr.qmui_general_shadow_alpha);
        this.mBorderRect = new RectF();
        if (attributeSet == null && n == 0) {
            bl = false;
            n2 = 0;
            n = n3;
            n3 = n2;
        } else {
            attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.QMUILayout, n, 0);
            int n4 = attributeSet.getIndexCount();
            n3 = 0;
            bl = false;
            n = 0;
            for (n2 = 0; n2 < n4; ++n2) {
                int n5;
                boolean bl2;
                int n6;
                int n7 = attributeSet.getIndex(n2);
                if (n7 == R.styleable.QMUILayout_android_maxWidth) {
                    this.mWidthLimit = attributeSet.getDimensionPixelSize(n7, this.mWidthLimit);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_android_maxHeight) {
                    this.mHeightLimit = attributeSet.getDimensionPixelSize(n7, this.mHeightLimit);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_android_minWidth) {
                    this.mWidthMini = attributeSet.getDimensionPixelSize(n7, this.mWidthMini);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_android_minHeight) {
                    this.mHeightMini = attributeSet.getDimensionPixelSize(n7, this.mHeightMini);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_topDividerColor) {
                    this.mTopDividerColor = attributeSet.getColor(n7, this.mTopDividerColor);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_topDividerHeight) {
                    this.mTopDividerHeight = attributeSet.getDimensionPixelSize(n7, this.mTopDividerHeight);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_topDividerInsetLeft) {
                    this.mTopDividerInsetLeft = attributeSet.getDimensionPixelSize(n7, this.mTopDividerInsetLeft);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_topDividerInsetRight) {
                    this.mTopDividerInsetRight = attributeSet.getDimensionPixelSize(n7, this.mTopDividerInsetRight);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_bottomDividerColor) {
                    this.mBottomDividerColor = attributeSet.getColor(n7, this.mBottomDividerColor);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_bottomDividerHeight) {
                    this.mBottomDividerHeight = attributeSet.getDimensionPixelSize(n7, this.mBottomDividerHeight);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_bottomDividerInsetLeft) {
                    this.mBottomDividerInsetLeft = attributeSet.getDimensionPixelSize(n7, this.mBottomDividerInsetLeft);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_bottomDividerInsetRight) {
                    this.mBottomDividerInsetRight = attributeSet.getDimensionPixelSize(n7, this.mBottomDividerInsetRight);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_leftDividerColor) {
                    this.mLeftDividerColor = attributeSet.getColor(n7, this.mLeftDividerColor);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_leftDividerWidth) {
                    this.mLeftDividerWidth = attributeSet.getDimensionPixelSize(n7, this.mBottomDividerHeight);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_leftDividerInsetTop) {
                    this.mLeftDividerInsetTop = attributeSet.getDimensionPixelSize(n7, this.mLeftDividerInsetTop);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_leftDividerInsetBottom) {
                    this.mLeftDividerInsetBottom = attributeSet.getDimensionPixelSize(n7, this.mLeftDividerInsetBottom);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_rightDividerColor) {
                    this.mRightDividerColor = attributeSet.getColor(n7, this.mRightDividerColor);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_rightDividerWidth) {
                    this.mRightDividerWidth = attributeSet.getDimensionPixelSize(n7, this.mRightDividerWidth);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_rightDividerInsetTop) {
                    this.mRightDividerInsetTop = attributeSet.getDimensionPixelSize(n7, this.mRightDividerInsetTop);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_rightDividerInsetBottom) {
                    this.mRightDividerInsetBottom = attributeSet.getDimensionPixelSize(n7, this.mRightDividerInsetBottom);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_borderColor) {
                    this.mBorderColor = attributeSet.getColor(n7, this.mBorderColor);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_borderWidth) {
                    this.mBorderWidth = attributeSet.getDimensionPixelSize(n7, this.mBorderWidth);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_radius) {
                    n5 = attributeSet.getDimensionPixelSize(n7, 0);
                    n6 = n3;
                    bl2 = bl;
                } else if (n7 == R.styleable.QMUILayout_qmui_outerNormalColor) {
                    this.mOuterNormalColor = attributeSet.getColor(n7, this.mOuterNormalColor);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_hideRadiusSide) {
                    this.mHideRadiusSide = attributeSet.getColor(n7, this.mHideRadiusSide);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_showBorderOnlyBeforeL) {
                    this.mIsShowBorderOnlyBeforeL = attributeSet.getBoolean(n7, this.mIsShowBorderOnlyBeforeL);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_shadowElevation) {
                    n6 = attributeSet.getDimensionPixelSize(n7, n3);
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_shadowAlpha) {
                    this.mShadowAlpha = attributeSet.getFloat(n7, this.mShadowAlpha);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_useThemeGeneralShadowElevation) {
                    bl2 = attributeSet.getBoolean(n7, false);
                    n6 = n3;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_outlineInsetLeft) {
                    this.mOutlineInsetLeft = attributeSet.getDimensionPixelSize(n7, 0);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_outlineInsetRight) {
                    this.mOutlineInsetRight = attributeSet.getDimensionPixelSize(n7, 0);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_outlineInsetTop) {
                    this.mOutlineInsetTop = attributeSet.getDimensionPixelSize(n7, 0);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else if (n7 == R.styleable.QMUILayout_qmui_outlineInsetBottom) {
                    this.mOutlineInsetBottom = attributeSet.getDimensionPixelSize(n7, 0);
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                } else {
                    n6 = n3;
                    bl2 = bl;
                    n5 = n;
                    if (n7 == R.styleable.QMUILayout_qmui_outlineExcludePadding) {
                        this.mIsOutlineExcludePadding = attributeSet.getBoolean(n7, false);
                        n5 = n;
                        bl2 = bl;
                        n6 = n3;
                    }
                }
                n3 = n6;
                bl = bl2;
                n = n5;
            }
            attributeSet.recycle();
            n2 = n3;
            n3 = n;
            n = n2;
        }
        n2 = n;
        if (n == 0) {
            n2 = n;
            if (bl) {
                n2 = QMUIResHelper.getAttrDimen((Context)context, (int)R.attr.qmui_general_shadow_elevation);
            }
        }
        this.setRadiusAndShadow(n3, this.mHideRadiusSide, n2, this.mShadowAlpha);
    }

    static /* synthetic */ int access$000(QMUILayoutHelper qMUILayoutHelper) {
        return qMUILayoutHelper.mHideRadiusSide;
    }

    static /* synthetic */ int access$100(QMUILayoutHelper qMUILayoutHelper) {
        return qMUILayoutHelper.mRadius;
    }

    static /* synthetic */ int access$200(QMUILayoutHelper qMUILayoutHelper) {
        return qMUILayoutHelper.mOutlineInsetTop;
    }

    static /* synthetic */ int access$300(QMUILayoutHelper qMUILayoutHelper) {
        return qMUILayoutHelper.mOutlineInsetBottom;
    }

    static /* synthetic */ int access$400(QMUILayoutHelper qMUILayoutHelper) {
        return qMUILayoutHelper.mOutlineInsetLeft;
    }

    static /* synthetic */ int access$500(QMUILayoutHelper qMUILayoutHelper) {
        return qMUILayoutHelper.mOutlineInsetRight;
    }

    static /* synthetic */ boolean access$600(QMUILayoutHelper qMUILayoutHelper) {
        return qMUILayoutHelper.mIsOutlineExcludePadding;
    }

    static /* synthetic */ float access$700(QMUILayoutHelper qMUILayoutHelper) {
        return qMUILayoutHelper.mShadowAlpha;
    }

    static /* synthetic */ int access$800(QMUILayoutHelper qMUILayoutHelper) {
        return qMUILayoutHelper.mShadowElevation;
    }

    private void drawRoundRect(Canvas canvas, RectF rectF, float[] fArray, Paint paint) {
        this.mPath.reset();
        this.mPath.addRoundRect(rectF, fArray, Path.Direction.CW);
        canvas.drawPath(this.mPath, paint);
    }

    private void invalidate() {
        if (!QMUILayoutHelper.useFeature()) return;
        View view = (View)this.mOwner.get();
        if (view == null) {
            return;
        }
        int n = this.mShadowElevation;
        if (n == 0) {
            view.setElevation(0.0f);
        } else {
            view.setElevation((float)n);
        }
        view.invalidateOutline();
    }

    private void setShadowColorInner(int n) {
        if (Build.VERSION.SDK_INT < 28) return;
        View view = (View)this.mOwner.get();
        if (view == null) {
            return;
        }
        view.setOutlineAmbientShadowColor(n);
        view.setOutlineSpotShadowColor(n);
    }

    public static boolean useFeature() {
        boolean bl = Build.VERSION.SDK_INT >= 21;
        return bl;
    }

    public void dispatchRoundBorderDraw(Canvas canvas) {
        Object object = (View)this.mOwner.get();
        if (object == null) {
            return;
        }
        if (this.mBorderColor == 0) {
            if (this.mRadius == 0) return;
            if (this.mOuterNormalColor == 0) {
                return;
            }
        }
        if (this.mIsShowBorderOnlyBeforeL && QMUILayoutHelper.useFeature() && this.mShadowElevation != 0) {
            return;
        }
        int n = canvas.getWidth();
        int n2 = canvas.getHeight();
        if (this.mIsOutlineExcludePadding) {
            this.mBorderRect.set((float)(object.getPaddingLeft() + 1), (float)(object.getPaddingTop() + 1), (float)(n - 1 - object.getPaddingRight()), (float)(n2 - 1 - object.getPaddingBottom()));
        } else {
            this.mBorderRect.set(1.0f, 1.0f, (float)(n - 1), (float)(n2 - 1));
        }
        if (this.mRadius != 0 && (QMUILayoutHelper.useFeature() || this.mOuterNormalColor != 0)) {
            if (!QMUILayoutHelper.useFeature()) {
                n = canvas.saveLayer(0.0f, 0.0f, (float)n, (float)n2, null, 31);
                canvas.drawColor(this.mOuterNormalColor);
                this.mClipPaint.setColor(this.mOuterNormalColor);
                this.mClipPaint.setStyle(Paint.Style.FILL);
                this.mClipPaint.setXfermode((Xfermode)this.mMode);
                object = this.mRadiusArray;
                if (object == null) {
                    object = this.mBorderRect;
                    n2 = this.mRadius;
                    canvas.drawRoundRect((RectF)object, (float)n2, (float)n2, this.mClipPaint);
                } else {
                    this.drawRoundRect(canvas, this.mBorderRect, (float[])object, this.mClipPaint);
                }
                this.mClipPaint.setXfermode(null);
                canvas.restoreToCount(n);
            }
            this.mClipPaint.setColor(this.mBorderColor);
            this.mClipPaint.setStrokeWidth((float)this.mBorderWidth);
            this.mClipPaint.setStyle(Paint.Style.STROKE);
            object = this.mRadiusArray;
            if (object == null) {
                object = this.mBorderRect;
                n2 = this.mRadius;
                canvas.drawRoundRect((RectF)object, (float)n2, (float)n2, this.mClipPaint);
            } else {
                this.drawRoundRect(canvas, this.mBorderRect, (float[])object, this.mClipPaint);
            }
            return;
        }
        this.mClipPaint.setStyle(Paint.Style.STROKE);
        this.mClipPaint.setColor(this.mBorderColor);
        canvas.drawRect(this.mBorderRect, this.mClipPaint);
    }

    public void drawDividers(Canvas canvas, int n, int n2) {
        float f;
        int n3;
        if (this.mDividerPaint == null && (this.mTopDividerHeight > 0 || this.mBottomDividerHeight > 0 || this.mLeftDividerWidth > 0 || this.mRightDividerWidth > 0)) {
            this.mDividerPaint = new Paint();
        }
        if ((n3 = this.mTopDividerHeight) > 0) {
            this.mDividerPaint.setStrokeWidth((float)n3);
            this.mDividerPaint.setColor(this.mTopDividerColor);
            n3 = this.mTopDividerAlpha;
            if (n3 < 255) {
                this.mDividerPaint.setAlpha(n3);
            }
            f = (float)this.mTopDividerHeight * 1.0f / 2.0f;
            canvas.drawLine((float)this.mTopDividerInsetLeft, f, (float)(n - this.mTopDividerInsetRight), f, this.mDividerPaint);
        }
        if ((n3 = this.mBottomDividerHeight) > 0) {
            this.mDividerPaint.setStrokeWidth((float)n3);
            this.mDividerPaint.setColor(this.mBottomDividerColor);
            n3 = this.mBottomDividerAlpha;
            if (n3 < 255) {
                this.mDividerPaint.setAlpha(n3);
            }
            f = (float)Math.floor((float)n2 - (float)this.mBottomDividerHeight * 1.0f / 2.0f);
            canvas.drawLine((float)this.mBottomDividerInsetLeft, f, (float)(n - this.mBottomDividerInsetRight), f, this.mDividerPaint);
        }
        if ((n3 = this.mLeftDividerWidth) > 0) {
            this.mDividerPaint.setStrokeWidth((float)n3);
            this.mDividerPaint.setColor(this.mLeftDividerColor);
            n3 = this.mLeftDividerAlpha;
            if (n3 < 255) {
                this.mDividerPaint.setAlpha(n3);
            }
            canvas.drawLine(0.0f, (float)this.mLeftDividerInsetTop, 0.0f, (float)(n2 - this.mLeftDividerInsetBottom), this.mDividerPaint);
        }
        if ((n3 = this.mRightDividerWidth) <= 0) return;
        this.mDividerPaint.setStrokeWidth((float)n3);
        this.mDividerPaint.setColor(this.mRightDividerColor);
        n3 = this.mRightDividerAlpha;
        if (n3 < 255) {
            this.mDividerPaint.setAlpha(n3);
        }
        f = n;
        canvas.drawLine(f, (float)this.mRightDividerInsetTop, f, (float)(n2 - this.mRightDividerInsetBottom), this.mDividerPaint);
    }

    public int getHideRadiusSide() {
        return this.mHideRadiusSide;
    }

    public int getMeasuredHeightSpec(int n) {
        int n2 = n;
        if (this.mHeightLimit <= 0) return n2;
        n2 = n;
        if (View.MeasureSpec.getSize((int)n) <= this.mHeightLimit) return n2;
        n2 = View.MeasureSpec.getMode((int)n) == Integer.MIN_VALUE ? View.MeasureSpec.makeMeasureSpec((int)this.mWidthLimit, (int)Integer.MIN_VALUE) : View.MeasureSpec.makeMeasureSpec((int)this.mWidthLimit, (int)0x40000000);
        return n2;
    }

    public int getMeasuredWidthSpec(int n) {
        int n2 = n;
        if (this.mWidthLimit <= 0) return n2;
        n2 = n;
        if (View.MeasureSpec.getSize((int)n) <= this.mWidthLimit) return n2;
        n2 = View.MeasureSpec.getMode((int)n) == Integer.MIN_VALUE ? View.MeasureSpec.makeMeasureSpec((int)this.mWidthLimit, (int)Integer.MIN_VALUE) : View.MeasureSpec.makeMeasureSpec((int)this.mWidthLimit, (int)0x40000000);
        return n2;
    }

    public int getRadius() {
        return this.mRadius;
    }

    public float getShadowAlpha() {
        return this.mShadowAlpha;
    }

    public int getShadowColor() {
        return this.mShadowColor;
    }

    public int getShadowElevation() {
        return this.mShadowElevation;
    }

    public int handleMiniHeight(int n, int n2) {
        int n3 = n;
        if (View.MeasureSpec.getMode((int)n) == 0x40000000) return n3;
        int n4 = this.mHeightMini;
        n3 = n;
        if (n2 >= n4) return n3;
        n3 = View.MeasureSpec.makeMeasureSpec((int)n4, (int)0x40000000);
        return n3;
    }

    public int handleMiniWidth(int n, int n2) {
        int n3 = n;
        if (View.MeasureSpec.getMode((int)n) == 0x40000000) return n3;
        int n4 = this.mWidthMini;
        n3 = n;
        if (n2 >= n4) return n3;
        n3 = View.MeasureSpec.makeMeasureSpec((int)n4, (int)0x40000000);
        return n3;
    }

    public boolean isRadiusWithSideHidden() {
        boolean bl = this.mRadius > 0 && this.mHideRadiusSide != 0;
        return bl;
    }

    public void onlyShowBottomDivider(int n, int n2, int n3, int n4) {
        this.updateBottomDivider(n, n2, n3, n4);
        this.mLeftDividerWidth = 0;
        this.mRightDividerWidth = 0;
        this.mTopDividerHeight = 0;
    }

    public void onlyShowLeftDivider(int n, int n2, int n3, int n4) {
        this.updateLeftDivider(n, n2, n3, n4);
        this.mRightDividerWidth = 0;
        this.mTopDividerHeight = 0;
        this.mBottomDividerHeight = 0;
    }

    public void onlyShowRightDivider(int n, int n2, int n3, int n4) {
        this.updateRightDivider(n, n2, n3, n4);
        this.mLeftDividerWidth = 0;
        this.mTopDividerHeight = 0;
        this.mBottomDividerHeight = 0;
    }

    public void onlyShowTopDivider(int n, int n2, int n3, int n4) {
        this.updateTopDivider(n, n2, n3, n4);
        this.mLeftDividerWidth = 0;
        this.mRightDividerWidth = 0;
        this.mBottomDividerHeight = 0;
    }

    public void setBorderColor(int n) {
        this.mBorderColor = n;
    }

    public void setBorderWidth(int n) {
        this.mBorderWidth = n;
    }

    public void setBottomDividerAlpha(int n) {
        this.mBottomDividerAlpha = n;
    }

    public boolean setHeightLimit(int n) {
        if (this.mHeightLimit == n) return false;
        this.mHeightLimit = n;
        return true;
    }

    public void setHideRadiusSide(int n) {
        if (this.mHideRadiusSide == n) {
            return;
        }
        this.setRadiusAndShadow(this.mRadius, n, this.mShadowElevation, this.mShadowAlpha);
    }

    public void setLeftDividerAlpha(int n) {
        this.mLeftDividerAlpha = n;
    }

    public void setOuterNormalColor(int n) {
        this.mOuterNormalColor = n;
        View view = (View)this.mOwner.get();
        if (view == null) return;
        view.invalidate();
    }

    public void setOutlineExcludePadding(boolean bl) {
        if (!QMUILayoutHelper.useFeature()) return;
        View view = (View)this.mOwner.get();
        if (view == null) {
            return;
        }
        this.mIsOutlineExcludePadding = bl;
        view.invalidateOutline();
    }

    public void setOutlineInset(int n, int n2, int n3, int n4) {
        if (!QMUILayoutHelper.useFeature()) return;
        View view = (View)this.mOwner.get();
        if (view == null) {
            return;
        }
        this.mOutlineInsetLeft = n;
        this.mOutlineInsetRight = n3;
        this.mOutlineInsetTop = n2;
        this.mOutlineInsetBottom = n4;
        view.invalidateOutline();
    }

    public void setRadius(int n) {
        if (this.mRadius == n) return;
        this.setRadiusAndShadow(n, this.mShadowElevation, this.mShadowAlpha);
    }

    public void setRadius(int n, int n2) {
        if (this.mRadius == n && n2 == this.mHideRadiusSide) {
            return;
        }
        this.setRadiusAndShadow(n, n2, this.mShadowElevation, this.mShadowAlpha);
    }

    public void setRadiusAndShadow(int n, int n2, float f) {
        this.setRadiusAndShadow(n, this.mHideRadiusSide, n2, f);
    }

    public void setRadiusAndShadow(int n, int n2, int n3, float f) {
        this.setRadiusAndShadow(n, n2, n3, this.mShadowColor, f);
    }

    public void setRadiusAndShadow(int n, int n2, int n3, int n4, float f) {
        View view = (View)this.mOwner.get();
        if (view == null) {
            return;
        }
        this.mRadius = n;
        this.mHideRadiusSide = n2;
        boolean bl = false;
        if (n > 0) {
            this.mRadiusArray = n2 == 1 ? new float[]{0.0f, 0.0f, 0.0f, 0.0f, n, n, n, n} : (n2 == 2 ? new float[]{n, n, 0.0f, 0.0f, 0.0f, 0.0f, n, n} : (n2 == 3 ? new float[]{n, n, n, n, 0.0f, 0.0f, 0.0f, 0.0f} : (float[])(n2 == 4 ? new float[]{0.0f, 0.0f, n, n, n, n, 0.0f, 0.0f} : null)));
        }
        this.mShadowElevation = n3;
        this.mShadowAlpha = f;
        this.mShadowColor = n4;
        if (QMUILayoutHelper.useFeature()) {
            if (this.mShadowElevation != 0 && !this.isRadiusWithSideHidden()) {
                view.setElevation((float)this.mShadowElevation);
            } else {
                view.setElevation(0.0f);
            }
            this.setShadowColorInner(this.mShadowColor);
            view.setOutlineProvider((ViewOutlineProvider)new /* Unavailable Anonymous Inner Class!! */);
            if (this.mRadius > 0) {
                bl = true;
            }
            view.setClipToOutline(bl);
        }
        view.invalidate();
    }

    public void setRightDividerAlpha(int n) {
        this.mRightDividerAlpha = n;
    }

    public void setShadowAlpha(float f) {
        if (this.mShadowAlpha == f) {
            return;
        }
        this.mShadowAlpha = f;
        this.invalidate();
    }

    public void setShadowColor(int n) {
        if (this.mShadowColor == n) {
            return;
        }
        this.mShadowColor = n;
        this.setShadowColorInner(n);
    }

    public void setShadowElevation(int n) {
        if (this.mShadowElevation == n) {
            return;
        }
        this.mShadowElevation = n;
        this.invalidate();
    }

    public void setShowBorderOnlyBeforeL(boolean bl) {
        this.mIsShowBorderOnlyBeforeL = bl;
        this.invalidate();
    }

    public void setTopDividerAlpha(int n) {
        this.mTopDividerAlpha = n;
    }

    public void setUseThemeGeneralShadowElevation() {
        int n;
        this.mShadowElevation = n = QMUIResHelper.getAttrDimen((Context)this.mContext, (int)R.attr.qmui_general_shadow_elevation);
        this.setRadiusAndShadow(this.mRadius, this.mHideRadiusSide, n, this.mShadowAlpha);
    }

    public boolean setWidthLimit(int n) {
        if (this.mWidthLimit == n) return false;
        this.mWidthLimit = n;
        return true;
    }

    public void updateBottomDivider(int n, int n2, int n3, int n4) {
        this.mBottomDividerInsetLeft = n;
        this.mBottomDividerInsetRight = n2;
        this.mBottomDividerColor = n4;
        this.mBottomDividerHeight = n3;
    }

    public void updateLeftDivider(int n, int n2, int n3, int n4) {
        this.mLeftDividerInsetTop = n;
        this.mLeftDividerInsetBottom = n2;
        this.mLeftDividerWidth = n3;
        this.mLeftDividerColor = n4;
    }

    public void updateRightDivider(int n, int n2, int n3, int n4) {
        this.mRightDividerInsetTop = n;
        this.mRightDividerInsetBottom = n2;
        this.mRightDividerWidth = n3;
        this.mRightDividerColor = n4;
    }

    public void updateTopDivider(int n, int n2, int n3, int n4) {
        this.mTopDividerInsetLeft = n;
        this.mTopDividerInsetRight = n2;
        this.mTopDividerHeight = n3;
        this.mTopDividerColor = n4;
    }
}
