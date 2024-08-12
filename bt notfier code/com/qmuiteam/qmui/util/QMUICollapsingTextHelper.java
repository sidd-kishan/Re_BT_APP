/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.os.Build$VERSION
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.text.TextUtils$TruncateAt
 *  android.view.View
 *  android.view.animation.Interpolator
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.core.text.TextDirectionHeuristicCompat
 *  androidx.core.text.TextDirectionHeuristicsCompat
 *  androidx.core.view.GravityCompat
 *  androidx.core.view.ViewCompat
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.util.QMUILangHelper
 */
package com.qmuiteam.qmui.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUILangHelper;

public final class QMUICollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;
    private static final Paint DEBUG_DRAW_PAINT;
    private static final boolean USE_SCALING_TEXTURE;
    private boolean mBoundsChanged;
    private final Rect mCollapsedBounds;
    private float mCollapsedDrawX;
    private float mCollapsedDrawY;
    private int mCollapsedShadowColor;
    private float mCollapsedShadowDx;
    private float mCollapsedShadowDy;
    private float mCollapsedShadowRadius;
    private ColorStateList mCollapsedTextColor;
    private int mCollapsedTextGravity = 16;
    private float mCollapsedTextSize = 15.0f;
    private Typeface mCollapsedTypeface;
    private final RectF mCurrentBounds;
    private float mCurrentDrawX;
    private float mCurrentDrawY;
    private float mCurrentTextSize;
    private Typeface mCurrentTypeface;
    private boolean mDrawTitle;
    private final Rect mExpandedBounds;
    private float mExpandedDrawX;
    private float mExpandedDrawY;
    private float mExpandedFraction;
    private int mExpandedShadowColor;
    private float mExpandedShadowDx;
    private float mExpandedShadowDy;
    private float mExpandedShadowRadius;
    private ColorStateList mExpandedTextColor;
    private int mExpandedTextGravity = 16;
    private float mExpandedTextSize = 15.0f;
    private Bitmap mExpandedTitleTexture;
    private Typeface mExpandedTypeface;
    private boolean mIsRtl;
    private Interpolator mPositionInterpolator;
    private float mScale;
    private int[] mState;
    private CharSequence mText;
    private final TextPaint mTextPaint;
    private Interpolator mTextSizeInterpolator;
    private CharSequence mTextToDraw;
    private float mTextureAscent;
    private float mTextureDescent;
    private Paint mTexturePaint;
    private boolean mUseTexture;
    private final View mView;

    static {
        boolean bl = Build.VERSION.SDK_INT < 18;
        USE_SCALING_TEXTURE = bl;
        DEBUG_DRAW_PAINT = null;
        if (!false) return;
        throw new NullPointerException();
    }

    public QMUICollapsingTextHelper(View view) {
        this.mView = view;
        this.mTextPaint = new TextPaint(129);
        this.mCollapsedBounds = new Rect();
        this.mExpandedBounds = new Rect();
        this.mCurrentBounds = new RectF();
    }

    private static int blendColors(int n, int n2, float f) {
        float f2 = 1.0f - f;
        float f3 = Color.alpha((int)n);
        float f4 = Color.alpha((int)n2);
        float f5 = Color.red((int)n);
        float f6 = Color.red((int)n2);
        float f7 = Color.green((int)n);
        float f8 = Color.green((int)n2);
        float f9 = Color.blue((int)n);
        float f10 = Color.blue((int)n2);
        return Color.argb((int)((int)(f3 * f2 + f4 * f)), (int)((int)(f5 * f2 + f6 * f)), (int)((int)(f7 * f2 + f8 * f)), (int)((int)(f9 * f2 + f10 * f)));
    }

    private void calculateBaseOffsets() {
        float f;
        float f2 = this.mCurrentTextSize;
        this.calculateUsingTextSize(this.mCollapsedTextSize);
        CharSequence charSequence = this.mTextToDraw;
        float f3 = 0.0f;
        float f4 = charSequence != null ? this.mTextPaint.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int n = GravityCompat.getAbsoluteGravity((int)this.mCollapsedTextGravity, (int)(this.mIsRtl ? 1 : 0));
        int n2 = n & 0x70;
        if (n2 != 48) {
            if (n2 != 80) {
                float f5 = (this.mTextPaint.descent() - this.mTextPaint.ascent()) / 2.0f;
                f = this.mTextPaint.descent();
                this.mCollapsedDrawY = (float)this.mCollapsedBounds.centerY() + (f5 - f);
            } else {
                this.mCollapsedDrawY = (float)this.mCollapsedBounds.bottom - this.mTextPaint.descent();
            }
        } else {
            this.mCollapsedDrawY = (float)this.mCollapsedBounds.top - this.mTextPaint.ascent();
        }
        n2 = n & 0x800007;
        this.mCollapsedDrawX = n2 != 1 ? (n2 != 5 ? (float)this.mCollapsedBounds.left : (float)this.mCollapsedBounds.right - f4) : (float)this.mCollapsedBounds.centerX() - f4 / 2.0f;
        this.calculateUsingTextSize(this.mExpandedTextSize);
        charSequence = this.mTextToDraw;
        f4 = f3;
        if (charSequence != null) {
            f4 = this.mTextPaint.measureText(charSequence, 0, charSequence.length());
        }
        if ((n = (n2 = GravityCompat.getAbsoluteGravity((int)this.mExpandedTextGravity, (int)(this.mIsRtl ? 1 : 0))) & 0x70) != 48) {
            if (n != 80) {
                f3 = (this.mTextPaint.descent() - this.mTextPaint.ascent()) / 2.0f;
                f = this.mTextPaint.descent();
                this.mExpandedDrawY = (float)this.mExpandedBounds.centerY() + (f3 - f);
            } else {
                this.mExpandedDrawY = (float)this.mExpandedBounds.bottom - this.mTextPaint.descent();
            }
        } else {
            this.mExpandedDrawY = (float)this.mExpandedBounds.top - this.mTextPaint.ascent();
        }
        this.mExpandedDrawX = (n2 &= 0x800007) != 1 ? (n2 != 5 ? (float)this.mExpandedBounds.left : (float)this.mExpandedBounds.right - f4) : (float)this.mExpandedBounds.centerX() - f4 / 2.0f;
        this.clearTexture();
        this.setInterpolatedTextSize(f2);
    }

    private void calculateCurrentOffsets() {
        this.calculateOffsets(this.mExpandedFraction);
    }

    private boolean calculateIsRtl(CharSequence charSequence) {
        int n = ViewCompat.getLayoutDirection((View)this.mView);
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = bl ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        return textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    private void calculateOffsets(float f) {
        this.interpolateBounds(f);
        this.mCurrentDrawX = QMUICollapsingTextHelper.lerp(this.mExpandedDrawX, this.mCollapsedDrawX, f, this.mPositionInterpolator);
        this.mCurrentDrawY = QMUICollapsingTextHelper.lerp(this.mExpandedDrawY, this.mCollapsedDrawY, f, this.mPositionInterpolator);
        this.setInterpolatedTextSize(QMUICollapsingTextHelper.lerp(this.mExpandedTextSize, this.mCollapsedTextSize, f, this.mTextSizeInterpolator));
        if (this.mCollapsedTextColor != this.mExpandedTextColor) {
            this.mTextPaint.setColor(QMUICollapsingTextHelper.blendColors(this.getCurrentExpandedTextColor(), this.getCurrentCollapsedTextColor(), f));
        } else {
            this.mTextPaint.setColor(this.getCurrentCollapsedTextColor());
        }
        this.mTextPaint.setShadowLayer(QMUICollapsingTextHelper.lerp(this.mExpandedShadowRadius, this.mCollapsedShadowRadius, f, null), QMUICollapsingTextHelper.lerp(this.mExpandedShadowDx, this.mCollapsedShadowDx, f, null), QMUICollapsingTextHelper.lerp(this.mExpandedShadowDy, this.mCollapsedShadowDy, f, null), QMUICollapsingTextHelper.blendColors(this.mExpandedShadowColor, this.mCollapsedShadowColor, f));
        ViewCompat.postInvalidateOnAnimation((View)this.mView);
    }

    private void calculateUsingTextSize(float f) {
        boolean bl;
        Object object;
        float f2;
        if (this.mText == null) {
            return;
        }
        float f3 = this.mCollapsedBounds.width();
        float f4 = this.mExpandedBounds.width();
        boolean bl2 = QMUICollapsingTextHelper.isClose(f, this.mCollapsedTextSize);
        boolean bl3 = true;
        if (bl2) {
            f2 = this.mCollapsedTextSize;
            this.mScale = 1.0f;
            object = this.mCurrentTypeface;
            Typeface typeface = this.mCollapsedTypeface;
            if (object != typeface) {
                this.mCurrentTypeface = typeface;
                bl = true;
                f = f3;
            } else {
                bl = false;
                f = f3;
            }
        } else {
            f2 = this.mExpandedTextSize;
            Typeface typeface = this.mCurrentTypeface;
            object = this.mExpandedTypeface;
            if (typeface != object) {
                this.mCurrentTypeface = object;
                bl = true;
            } else {
                bl = false;
            }
            this.mScale = QMUICollapsingTextHelper.isClose(f, this.mExpandedTextSize) ? 1.0f : f / this.mExpandedTextSize;
            f = this.mCollapsedTextSize / this.mExpandedTextSize;
            f = f4 * f > f3 ? Math.min(f3 / f, f4) : f4;
        }
        boolean bl4 = bl;
        if (f > 0.0f) {
            bl = this.mCurrentTextSize != f2 || this.mBoundsChanged || bl;
            this.mCurrentTextSize = f2;
            this.mBoundsChanged = false;
            bl4 = bl;
        }
        if (this.mTextToDraw != null) {
            if (!bl4) return;
        }
        this.mTextPaint.setTextSize(this.mCurrentTextSize);
        this.mTextPaint.setTypeface(this.mCurrentTypeface);
        object = this.mTextPaint;
        if (this.mScale == 1.0f) {
            bl3 = false;
        }
        object.setLinearText(bl3);
        object = TextUtils.ellipsize((CharSequence)this.mText, (TextPaint)this.mTextPaint, (float)f, (TextUtils.TruncateAt)TextUtils.TruncateAt.END);
        if (TextUtils.equals((CharSequence)object, (CharSequence)this.mTextToDraw)) return;
        this.mTextToDraw = object;
        this.mIsRtl = this.calculateIsRtl((CharSequence)object);
    }

    private void clearTexture() {
        Bitmap bitmap = this.mExpandedTitleTexture;
        if (bitmap == null) return;
        bitmap.recycle();
        this.mExpandedTitleTexture = null;
    }

    private void ensureExpandedTexture() {
        if (this.mExpandedTitleTexture != null) return;
        if (this.mExpandedBounds.isEmpty()) return;
        if (TextUtils.isEmpty((CharSequence)this.mTextToDraw)) return;
        this.calculateOffsets(0.0f);
        this.mTextureAscent = this.mTextPaint.ascent();
        this.mTextureDescent = this.mTextPaint.descent();
        TextPaint textPaint = this.mTextPaint;
        CharSequence charSequence = this.mTextToDraw;
        int n = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
        int n2 = Math.round(this.mTextureDescent - this.mTextureAscent);
        if (n <= 0) return;
        if (n2 <= 0) return;
        this.mExpandedTitleTexture = Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        textPaint = new Canvas(this.mExpandedTitleTexture);
        charSequence = this.mTextToDraw;
        textPaint.drawText(charSequence, 0, charSequence.length(), 0.0f, (float)n2 - this.mTextPaint.descent(), (Paint)this.mTextPaint);
        if (this.mTexturePaint != null) return;
        this.mTexturePaint = new Paint(3);
    }

    private int getCurrentCollapsedTextColor() {
        int[] nArray = this.mState;
        if (nArray == null) return this.mCollapsedTextColor.getDefaultColor();
        return this.mCollapsedTextColor.getColorForState(nArray, 0);
    }

    private int getCurrentExpandedTextColor() {
        int[] nArray = this.mState;
        if (nArray == null) return this.mExpandedTextColor.getDefaultColor();
        return this.mExpandedTextColor.getColorForState(nArray, 0);
    }

    private void interpolateBounds(float f) {
        this.mCurrentBounds.left = QMUICollapsingTextHelper.lerp(this.mExpandedBounds.left, this.mCollapsedBounds.left, f, this.mPositionInterpolator);
        this.mCurrentBounds.top = QMUICollapsingTextHelper.lerp(this.mExpandedDrawY, this.mCollapsedDrawY, f, this.mPositionInterpolator);
        this.mCurrentBounds.right = QMUICollapsingTextHelper.lerp(this.mExpandedBounds.right, this.mCollapsedBounds.right, f, this.mPositionInterpolator);
        this.mCurrentBounds.bottom = QMUICollapsingTextHelper.lerp(this.mExpandedBounds.bottom, this.mCollapsedBounds.bottom, f, this.mPositionInterpolator);
    }

    private static boolean isClose(float f, float f2) {
        boolean bl = Math.abs(f - f2) < 0.001f;
        return bl;
    }

    private static float lerp(float f, float f2, float f3, Interpolator interpolator) {
        float f4 = f3;
        if (interpolator == null) return f + (float)Math.round(f4 * (f2 - f));
        f4 = interpolator.getInterpolation(f3);
        return f + (float)Math.round(f4 * (f2 - f));
    }

    private Typeface readFontFamilyTypeface(int n) {
        TypedArray typedArray = this.mView.getContext().obtainStyledAttributes(n, new int[]{16843692});
        try {
            String string = typedArray.getString(0);
            if (string == null) return null;
            string = Typeface.create((String)string, (int)0);
            return string;
        }
        finally {
            typedArray.recycle();
        }
    }

    private static boolean rectEquals(Rect rect, int n, int n2, int n3, int n4) {
        boolean bl = rect.left == n && rect.top == n2 && rect.right == n3 && rect.bottom == n4;
        return bl;
    }

    private void setInterpolatedTextSize(float f) {
        this.calculateUsingTextSize(f);
        boolean bl = USE_SCALING_TEXTURE && this.mScale != 1.0f;
        this.mUseTexture = bl;
        if (bl) {
            this.ensureExpandedTexture();
        }
        ViewCompat.postInvalidateOnAnimation((View)this.mView);
    }

    public void draw(Canvas canvas) {
        int n = canvas.save();
        if (this.mTextToDraw != null && this.mDrawTitle) {
            float f;
            float f2 = this.mCurrentDrawX;
            float f3 = this.mCurrentDrawY;
            boolean bl = this.mUseTexture && this.mExpandedTitleTexture != null;
            if (bl) {
                f = this.mTextureAscent * this.mScale;
            } else {
                f = this.mTextPaint.ascent() * this.mScale;
                this.mTextPaint.descent();
            }
            float f4 = f3;
            if (bl) {
                f4 = f3 + f;
            }
            if ((f = this.mScale) != 1.0f) {
                canvas.scale(f, f, f2, f4);
            }
            if (bl) {
                canvas.drawBitmap(this.mExpandedTitleTexture, f2, f4, this.mTexturePaint);
            } else {
                CharSequence charSequence = this.mTextToDraw;
                canvas.drawText(charSequence, 0, charSequence.length(), f2, f4, (Paint)this.mTextPaint);
            }
        }
        canvas.restoreToCount(n);
    }

    ColorStateList getCollapsedTextColor() {
        return this.mCollapsedTextColor;
    }

    public int getCollapsedTextGravity() {
        return this.mCollapsedTextGravity;
    }

    public float getCollapsedTextSize() {
        return this.mCollapsedTextSize;
    }

    public Typeface getCollapsedTypeface() {
        Typeface typeface = this.mCollapsedTypeface;
        if (typeface != null) return typeface;
        typeface = Typeface.DEFAULT;
        return typeface;
    }

    ColorStateList getExpandedTextColor() {
        return this.mExpandedTextColor;
    }

    public int getExpandedTextGravity() {
        return this.mExpandedTextGravity;
    }

    public float getExpandedTextSize() {
        return this.mExpandedTextSize;
    }

    public Typeface getExpandedTypeface() {
        Typeface typeface = this.mExpandedTypeface;
        if (typeface != null) return typeface;
        typeface = Typeface.DEFAULT;
        return typeface;
    }

    public float getExpansionFraction() {
        return this.mExpandedFraction;
    }

    public CharSequence getText() {
        return this.mText;
    }

    public final boolean isStateful() {
        ColorStateList colorStateList = this.mCollapsedTextColor;
        boolean bl = colorStateList != null && colorStateList.isStateful() || (colorStateList = this.mExpandedTextColor) != null && colorStateList.isStateful();
        return bl;
    }

    void onBoundsChanged() {
        boolean bl = this.mCollapsedBounds.width() > 0 && this.mCollapsedBounds.height() > 0 && this.mExpandedBounds.width() > 0 && this.mExpandedBounds.height() > 0;
        this.mDrawTitle = bl;
    }

    public void recalculate() {
        if (this.mView.getHeight() <= 0) return;
        if (this.mView.getWidth() <= 0) return;
        this.calculateBaseOffsets();
        this.calculateCurrentOffsets();
    }

    public void setCollapsedBounds(int n, int n2, int n3, int n4) {
        if (QMUICollapsingTextHelper.rectEquals(this.mCollapsedBounds, n, n2, n3, n4)) return;
        this.mCollapsedBounds.set(n, n2, n3, n4);
        this.mBoundsChanged = true;
        this.onBoundsChanged();
    }

    public void setCollapsedTextAppearance(int n) {
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes((Context)this.mView.getContext(), (int)n, (int[])R.styleable.QMUITextAppearance);
        if (tintTypedArray.hasValue(R.styleable.QMUITextAppearance_android_textColor)) {
            this.mCollapsedTextColor = tintTypedArray.getColorStateList(R.styleable.QMUITextAppearance_android_textColor);
        }
        if (tintTypedArray.hasValue(R.styleable.QMUITextAppearance_android_textSize)) {
            this.mCollapsedTextSize = tintTypedArray.getDimensionPixelSize(R.styleable.QMUITextAppearance_android_textSize, (int)this.mCollapsedTextSize);
        }
        this.mCollapsedShadowColor = tintTypedArray.getInt(R.styleable.QMUITextAppearance_android_shadowColor, 0);
        this.mCollapsedShadowDx = tintTypedArray.getFloat(R.styleable.QMUITextAppearance_android_shadowDx, 0.0f);
        this.mCollapsedShadowDy = tintTypedArray.getFloat(R.styleable.QMUITextAppearance_android_shadowDy, 0.0f);
        this.mCollapsedShadowRadius = tintTypedArray.getFloat(R.styleable.QMUITextAppearance_android_shadowRadius, 0.0f);
        tintTypedArray.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.mCollapsedTypeface = this.readFontFamilyTypeface(n);
        }
        this.recalculate();
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.mCollapsedTextColor == colorStateList) return;
        this.mCollapsedTextColor = colorStateList;
        this.recalculate();
    }

    public void setCollapsedTextGravity(int n) {
        if (this.mCollapsedTextGravity == n) return;
        this.mCollapsedTextGravity = n;
        this.recalculate();
    }

    public void setCollapsedTextSize(float f) {
        if (this.mCollapsedTextSize == f) return;
        this.mCollapsedTextSize = f;
        this.recalculate();
    }

    public void setCollapsedTypeface(Typeface typeface) {
        if (this.mCollapsedTypeface == typeface) return;
        this.mCollapsedTypeface = typeface;
        this.recalculate();
    }

    public void setExpandedBounds(int n, int n2, int n3, int n4) {
        if (QMUICollapsingTextHelper.rectEquals(this.mExpandedBounds, n, n2, n3, n4)) return;
        this.mExpandedBounds.set(n, n2, n3, n4);
        this.mBoundsChanged = true;
        this.onBoundsChanged();
    }

    public void setExpandedTextAppearance(int n) {
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes((Context)this.mView.getContext(), (int)n, (int[])R.styleable.QMUITextAppearance);
        if (tintTypedArray.hasValue(R.styleable.QMUITextAppearance_android_textColor)) {
            this.mExpandedTextColor = tintTypedArray.getColorStateList(R.styleable.QMUITextAppearance_android_textColor);
        }
        if (tintTypedArray.hasValue(R.styleable.QMUITextAppearance_android_textSize)) {
            this.mExpandedTextSize = tintTypedArray.getDimensionPixelSize(R.styleable.QMUITextAppearance_android_textSize, (int)this.mExpandedTextSize);
        }
        this.mExpandedShadowColor = tintTypedArray.getInt(R.styleable.QMUITextAppearance_android_shadowColor, 0);
        this.mExpandedShadowDx = tintTypedArray.getFloat(R.styleable.QMUITextAppearance_android_shadowDx, 0.0f);
        this.mExpandedShadowDy = tintTypedArray.getFloat(R.styleable.QMUITextAppearance_android_shadowDy, 0.0f);
        this.mExpandedShadowRadius = tintTypedArray.getFloat(R.styleable.QMUITextAppearance_android_shadowRadius, 0.0f);
        tintTypedArray.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.mExpandedTypeface = this.readFontFamilyTypeface(n);
        }
        this.recalculate();
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.mExpandedTextColor == colorStateList) return;
        this.mExpandedTextColor = colorStateList;
        this.recalculate();
    }

    public void setExpandedTextGravity(int n) {
        if (this.mExpandedTextGravity == n) return;
        this.mExpandedTextGravity = n;
        this.recalculate();
    }

    public void setExpandedTextSize(float f) {
        if (this.mExpandedTextSize == f) return;
        this.mExpandedTextSize = f;
        this.recalculate();
    }

    public void setExpandedTypeface(Typeface typeface) {
        if (this.mExpandedTypeface == typeface) return;
        this.mExpandedTypeface = typeface;
        this.recalculate();
    }

    public void setExpansionFraction(float f) {
        if ((f = QMUILangHelper.constrain((float)f, (float)0.0f, (float)1.0f)) == this.mExpandedFraction) return;
        this.mExpandedFraction = f;
        this.calculateCurrentOffsets();
    }

    public void setPositionInterpolator(Interpolator interpolator) {
        this.mPositionInterpolator = interpolator;
        this.recalculate();
    }

    public final boolean setState(int[] nArray) {
        this.mState = nArray;
        if (!this.isStateful()) return false;
        this.recalculate();
        return true;
    }

    public void setText(CharSequence charSequence) {
        if (charSequence != null) {
            if (charSequence.equals(this.mText)) return;
        }
        this.mText = charSequence;
        this.mTextToDraw = null;
        this.clearTexture();
        this.recalculate();
    }

    public void setTextSizeInterpolator(Interpolator interpolator) {
        this.mTextSizeInterpolator = interpolator;
        this.recalculate();
    }

    public void setTypefaces(Typeface typeface) {
        this.mExpandedTypeface = typeface;
        this.mCollapsedTypeface = typeface;
        this.recalculate();
    }
}
