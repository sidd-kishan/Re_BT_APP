/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Join
 *  androidx.core.content.res.ComplexColorCompat
 *  androidx.core.content.res.TypedArrayUtils
 *  androidx.core.graphics.PathParser
 *  androidx.vectordrawable.graphics.drawable.AndroidResources
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPath
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.vectordrawable.graphics.drawable.AndroidResources;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import org.xmlpull.v1.XmlPullParser;

private static class VectorDrawableCompat.VFullPath
extends VectorDrawableCompat.VPath {
    float mFillAlpha = 1.0f;
    ComplexColorCompat mFillColor;
    float mStrokeAlpha = 1.0f;
    ComplexColorCompat mStrokeColor;
    Paint.Cap mStrokeLineCap = Paint.Cap.BUTT;
    Paint.Join mStrokeLineJoin = Paint.Join.MITER;
    float mStrokeMiterlimit = 4.0f;
    float mStrokeWidth = 0.0f;
    private int[] mThemeAttrs;
    float mTrimPathEnd = 1.0f;
    float mTrimPathOffset = 0.0f;
    float mTrimPathStart = 0.0f;

    VectorDrawableCompat.VFullPath() {
    }

    VectorDrawableCompat.VFullPath(VectorDrawableCompat.VFullPath vFullPath) {
        super((VectorDrawableCompat.VPath)vFullPath);
        this.mThemeAttrs = vFullPath.mThemeAttrs;
        this.mStrokeColor = vFullPath.mStrokeColor;
        this.mStrokeWidth = vFullPath.mStrokeWidth;
        this.mStrokeAlpha = vFullPath.mStrokeAlpha;
        this.mFillColor = vFullPath.mFillColor;
        this.mFillRule = vFullPath.mFillRule;
        this.mFillAlpha = vFullPath.mFillAlpha;
        this.mTrimPathStart = vFullPath.mTrimPathStart;
        this.mTrimPathEnd = vFullPath.mTrimPathEnd;
        this.mTrimPathOffset = vFullPath.mTrimPathOffset;
        this.mStrokeLineCap = vFullPath.mStrokeLineCap;
        this.mStrokeLineJoin = vFullPath.mStrokeLineJoin;
        this.mStrokeMiterlimit = vFullPath.mStrokeMiterlimit;
    }

    private Paint.Cap getStrokeLineCap(int n, Paint.Cap cap) {
        if (n == 0) return Paint.Cap.BUTT;
        if (n == 1) return Paint.Cap.ROUND;
        if (n == 2) return Paint.Cap.SQUARE;
        return cap;
    }

    private Paint.Join getStrokeLineJoin(int n, Paint.Join join) {
        if (n == 0) return Paint.Join.MITER;
        if (n == 1) return Paint.Join.ROUND;
        if (n == 2) return Paint.Join.BEVEL;
        return join;
    }

    private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        this.mThemeAttrs = null;
        if (!TypedArrayUtils.hasAttribute((XmlPullParser)xmlPullParser, (String)"pathData")) {
            return;
        }
        String string = typedArray.getString(0);
        if (string != null) {
            this.mPathName = string;
        }
        if ((string = typedArray.getString(2)) != null) {
            this.mNodes = PathParser.createNodesFromPathData((String)string);
        }
        this.mFillColor = TypedArrayUtils.getNamedComplexColor((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (Resources.Theme)theme, (String)"fillColor", (int)1, (int)0);
        this.mFillAlpha = TypedArrayUtils.getNamedFloat((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"fillAlpha", (int)12, (float)this.mFillAlpha);
        this.mStrokeLineCap = this.getStrokeLineCap(TypedArrayUtils.getNamedInt((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"strokeLineCap", (int)8, (int)-1), this.mStrokeLineCap);
        this.mStrokeLineJoin = this.getStrokeLineJoin(TypedArrayUtils.getNamedInt((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"strokeLineJoin", (int)9, (int)-1), this.mStrokeLineJoin);
        this.mStrokeMiterlimit = TypedArrayUtils.getNamedFloat((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"strokeMiterLimit", (int)10, (float)this.mStrokeMiterlimit);
        this.mStrokeColor = TypedArrayUtils.getNamedComplexColor((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (Resources.Theme)theme, (String)"strokeColor", (int)3, (int)0);
        this.mStrokeAlpha = TypedArrayUtils.getNamedFloat((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"strokeAlpha", (int)11, (float)this.mStrokeAlpha);
        this.mStrokeWidth = TypedArrayUtils.getNamedFloat((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"strokeWidth", (int)4, (float)this.mStrokeWidth);
        this.mTrimPathEnd = TypedArrayUtils.getNamedFloat((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"trimPathEnd", (int)6, (float)this.mTrimPathEnd);
        this.mTrimPathOffset = TypedArrayUtils.getNamedFloat((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"trimPathOffset", (int)7, (float)this.mTrimPathOffset);
        this.mTrimPathStart = TypedArrayUtils.getNamedFloat((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"trimPathStart", (int)5, (float)this.mTrimPathStart);
        this.mFillRule = TypedArrayUtils.getNamedInt((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"fillType", (int)13, (int)this.mFillRule);
    }

    public void applyTheme(Resources.Theme theme) {
        if (this.mThemeAttrs != null) return;
    }

    public boolean canApplyTheme() {
        boolean bl = this.mThemeAttrs != null;
        return bl;
    }

    float getFillAlpha() {
        return this.mFillAlpha;
    }

    int getFillColor() {
        return this.mFillColor.getColor();
    }

    float getStrokeAlpha() {
        return this.mStrokeAlpha;
    }

    int getStrokeColor() {
        return this.mStrokeColor.getColor();
    }

    float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    float getTrimPathEnd() {
        return this.mTrimPathEnd;
    }

    float getTrimPathOffset() {
        return this.mTrimPathOffset;
    }

    float getTrimPathStart() {
        return this.mTrimPathStart;
    }

    public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
        resources = TypedArrayUtils.obtainAttributes((Resources)resources, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])AndroidResources.STYLEABLE_VECTOR_DRAWABLE_PATH);
        this.updateStateFromTypedArray((TypedArray)resources, xmlPullParser, theme);
        resources.recycle();
    }

    public boolean isStateful() {
        boolean bl = this.mFillColor.isStateful() || this.mStrokeColor.isStateful();
        return bl;
    }

    public boolean onStateChanged(int[] nArray) {
        boolean bl = this.mFillColor.onStateChanged(nArray);
        return this.mStrokeColor.onStateChanged(nArray) | bl;
    }

    void setFillAlpha(float f) {
        this.mFillAlpha = f;
    }

    void setFillColor(int n) {
        this.mFillColor.setColor(n);
    }

    void setStrokeAlpha(float f) {
        this.mStrokeAlpha = f;
    }

    void setStrokeColor(int n) {
        this.mStrokeColor.setColor(n);
    }

    void setStrokeWidth(float f) {
        this.mStrokeWidth = f;
    }

    void setTrimPathEnd(float f) {
        this.mTrimPathEnd = f;
    }

    void setTrimPathOffset(float f) {
        this.mTrimPathOffset = f;
    }

    void setTrimPathStart(float f) {
        this.mTrimPathStart = f;
    }
}
