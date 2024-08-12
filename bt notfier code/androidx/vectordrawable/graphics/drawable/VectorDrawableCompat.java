/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.Xml
 *  androidx.core.content.res.ResourcesCompat
 *  androidx.core.content.res.TypedArrayUtils
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.vectordrawable.graphics.drawable.AndroidResources
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCommon
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VClipPath
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VFullPath
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VGroup
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VObject
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPath
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPathRenderer
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableDelegateState
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AndroidResources;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCommon;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import java.util.ArrayDeque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorDrawableCompat
extends VectorDrawableCommon {
    private static final boolean DBG_VECTOR_DRAWABLE = false;
    static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    static final String LOGTAG = "VectorDrawableCompat";
    private static final int MAX_CACHED_BITMAP_SIZE = 2048;
    private static final String SHAPE_CLIP_PATH = "clip-path";
    private static final String SHAPE_GROUP = "group";
    private static final String SHAPE_PATH = "path";
    private static final String SHAPE_VECTOR = "vector";
    private boolean mAllowCaching = true;
    private Drawable.ConstantState mCachedConstantStateDelegate;
    private ColorFilter mColorFilter;
    private boolean mMutated;
    private PorterDuffColorFilter mTintFilter;
    private final Rect mTmpBounds;
    private final float[] mTmpFloats = new float[9];
    private final Matrix mTmpMatrix = new Matrix();
    private VectorDrawableCompatState mVectorState;

    VectorDrawableCompat() {
        this.mTmpBounds = new Rect();
        this.mVectorState = new VectorDrawableCompatState();
    }

    VectorDrawableCompat(VectorDrawableCompatState vectorDrawableCompatState) {
        this.mTmpBounds = new Rect();
        this.mVectorState = vectorDrawableCompatState;
        this.mTintFilter = this.updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
    }

    static int applyAlpha(int n, float f) {
        return n & 0xFFFFFF | (int)((float)Color.alpha((int)n) * f) << 24;
    }

    public static VectorDrawableCompat create(Resources object, int n, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 24) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = ResourcesCompat.getDrawable((Resources)object, (int)n, (Resources.Theme)theme);
            vectorDrawableCompat.mCachedConstantStateDelegate = new VectorDrawableDelegateState(vectorDrawableCompat.mDelegateDrawable.getConstantState());
            return vectorDrawableCompat;
        }
        try {
            XmlResourceParser xmlResourceParser = object.getXml(n);
            AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
            while ((n = xmlResourceParser.next()) != 2 && n != 1) {
            }
            if (n == 2) {
                return VectorDrawableCompat.createFromXmlInner(object, xmlResourceParser, attributeSet, theme);
            }
            object = new XmlPullParserException("No start tag found");
            throw object;
        }
        catch (IOException iOException) {
            Log.e((String)LOGTAG, (String)"parser error", (Throwable)iOException);
        }
        catch (XmlPullParserException xmlPullParserException) {
            Log.e((String)LOGTAG, (String)"parser error", (Throwable)xmlPullParserException);
        }
        return null;
    }

    public static VectorDrawableCompat createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    private void inflateInternal(Resources object, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.mVPathRenderer;
        ArrayDeque<Object> arrayDeque = new ArrayDeque<Object>();
        arrayDeque.push(vPathRenderer.mRootGroup);
        int n = xmlPullParser.getEventType();
        int n2 = xmlPullParser.getDepth();
        int n3 = 1;
        while (n != 1 && (xmlPullParser.getDepth() >= n2 + 1 || n != 3)) {
            int n4;
            if (n == 2) {
                String string = xmlPullParser.getName();
                VGroup vGroup = (VGroup)arrayDeque.peek();
                if (SHAPE_PATH.equals(string)) {
                    string = new VFullPath();
                    string.inflate(object, attributeSet, theme, xmlPullParser);
                    vGroup.mChildren.add(string);
                    if (string.getPathName() != null) {
                        vPathRenderer.mVGTargetsMap.put((Object)string.getPathName(), (Object)string);
                    }
                    n4 = 0;
                    n3 = vectorDrawableCompatState.mChangingConfigurations;
                    vectorDrawableCompatState.mChangingConfigurations = ((VFullPath)string).mChangingConfigurations | n3;
                } else if (SHAPE_CLIP_PATH.equals(string)) {
                    string = new VClipPath();
                    string.inflate(object, attributeSet, theme, xmlPullParser);
                    vGroup.mChildren.add(string);
                    if (string.getPathName() != null) {
                        vPathRenderer.mVGTargetsMap.put((Object)string.getPathName(), (Object)string);
                    }
                    n4 = vectorDrawableCompatState.mChangingConfigurations;
                    vectorDrawableCompatState.mChangingConfigurations = ((VClipPath)string).mChangingConfigurations | n4;
                    n4 = n3;
                } else {
                    n4 = n3;
                    if (SHAPE_GROUP.equals(string)) {
                        string = new VGroup();
                        string.inflate(object, attributeSet, theme, xmlPullParser);
                        vGroup.mChildren.add(string);
                        arrayDeque.push(string);
                        if (string.getGroupName() != null) {
                            vPathRenderer.mVGTargetsMap.put((Object)string.getGroupName(), (Object)string);
                        }
                        n4 = vectorDrawableCompatState.mChangingConfigurations;
                        vectorDrawableCompatState.mChangingConfigurations = ((VGroup)string).mChangingConfigurations | n4;
                        n4 = n3;
                    }
                }
            } else {
                n4 = n3;
                if (n == 3) {
                    n4 = n3;
                    if (SHAPE_GROUP.equals(xmlPullParser.getName())) {
                        arrayDeque.pop();
                        n4 = n3;
                    }
                }
            }
            n = xmlPullParser.next();
            n3 = n4;
        }
        if (n3 == 0) {
            return;
        }
        object = new XmlPullParserException("no path defined");
        throw object;
    }

    private boolean needMirroring() {
        boolean bl;
        int n = Build.VERSION.SDK_INT;
        boolean bl2 = bl = false;
        if (n < 17) return bl2;
        bl2 = bl;
        if (!this.isAutoMirrored()) return bl2;
        bl2 = bl;
        if (DrawableCompat.getLayoutDirection((Drawable)this) != 1) return bl2;
        bl2 = true;
        return bl2;
    }

    private static PorterDuff.Mode parseTintModeCompat(int n, PorterDuff.Mode mode) {
        if (n == 3) return PorterDuff.Mode.SRC_OVER;
        if (n == 5) return PorterDuff.Mode.SRC_IN;
        if (n == 9) return PorterDuff.Mode.SRC_ATOP;
        switch (n) {
            default: {
                return mode;
            }
            case 16: {
                return PorterDuff.Mode.ADD;
            }
            case 15: {
                return PorterDuff.Mode.SCREEN;
            }
            case 14: 
        }
        return PorterDuff.Mode.MULTIPLY;
    }

    private void printGroupTree(VGroup vGroup, int n) {
        StringBuilder stringBuilder;
        int n2;
        int n3 = 0;
        String string = "";
        for (n2 = 0; n2 < n; ++n2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("    ");
            string = stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("current group is :");
        stringBuilder.append(vGroup.getGroupName());
        stringBuilder.append(" rotation is ");
        stringBuilder.append(vGroup.mRotate);
        Log.v((String)LOGTAG, (String)stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("matrix is :");
        stringBuilder.append(vGroup.getLocalMatrix().toString());
        Log.v((String)LOGTAG, (String)stringBuilder.toString());
        n2 = n3;
        while (n2 < vGroup.mChildren.size()) {
            string = (VObject)vGroup.mChildren.get(n2);
            if (string instanceof VGroup) {
                this.printGroupTree((VGroup)string, n + 1);
            } else {
                ((VPath)string).printVPath(n + 1);
            }
            ++n2;
        }
    }

    private void updateStateFromTypedArray(TypedArray object, XmlPullParser object2, Resources.Theme theme) throws XmlPullParserException {
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.mVPathRenderer;
        vectorDrawableCompatState.mTintMode = VectorDrawableCompat.parseTintModeCompat(TypedArrayUtils.getNamedInt((TypedArray)object, (XmlPullParser)object2, (String)"tintMode", (int)6, (int)-1), PorterDuff.Mode.SRC_IN);
        if ((theme = TypedArrayUtils.getNamedColorStateList((TypedArray)object, (XmlPullParser)object2, (Resources.Theme)theme, (String)"tint", (int)1)) != null) {
            vectorDrawableCompatState.mTint = theme;
        }
        vectorDrawableCompatState.mAutoMirrored = TypedArrayUtils.getNamedBoolean((TypedArray)object, (XmlPullParser)object2, (String)"autoMirrored", (int)5, (boolean)vectorDrawableCompatState.mAutoMirrored);
        vPathRenderer.mViewportWidth = TypedArrayUtils.getNamedFloat((TypedArray)object, (XmlPullParser)object2, (String)"viewportWidth", (int)7, (float)vPathRenderer.mViewportWidth);
        vPathRenderer.mViewportHeight = TypedArrayUtils.getNamedFloat((TypedArray)object, (XmlPullParser)object2, (String)"viewportHeight", (int)8, (float)vPathRenderer.mViewportHeight);
        if (vPathRenderer.mViewportWidth <= 0.0f) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(object.getPositionDescription());
            ((StringBuilder)object2).append("<vector> tag requires viewportWidth > 0");
            throw new XmlPullParserException(((StringBuilder)object2).toString());
        }
        if (vPathRenderer.mViewportHeight <= 0.0f) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(object.getPositionDescription());
            ((StringBuilder)object2).append("<vector> tag requires viewportHeight > 0");
            throw new XmlPullParserException(((StringBuilder)object2).toString());
        }
        vPathRenderer.mBaseWidth = object.getDimension(3, vPathRenderer.mBaseWidth);
        vPathRenderer.mBaseHeight = object.getDimension(2, vPathRenderer.mBaseHeight);
        if (vPathRenderer.mBaseWidth <= 0.0f) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(object.getPositionDescription());
            ((StringBuilder)object2).append("<vector> tag requires width > 0");
            throw new XmlPullParserException(((StringBuilder)object2).toString());
        }
        if (!(vPathRenderer.mBaseHeight <= 0.0f)) {
            vPathRenderer.setAlpha(TypedArrayUtils.getNamedFloat((TypedArray)object, (XmlPullParser)object2, (String)"alpha", (int)4, (float)vPathRenderer.getAlpha()));
            object = object.getString(0);
            if (object == null) return;
            vPathRenderer.mRootName = object;
            vPathRenderer.mVGTargetsMap.put(object, (Object)vPathRenderer);
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(object.getPositionDescription());
        ((StringBuilder)object2).append("<vector> tag requires height > 0");
        throw new XmlPullParserException(((StringBuilder)object2).toString());
    }

    public boolean canApplyTheme() {
        if (this.mDelegateDrawable == null) return false;
        DrawableCompat.canApplyTheme((Drawable)this.mDelegateDrawable);
        return false;
    }

    public void draw(Canvas canvas) {
        ColorFilter colorFilter;
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.draw(canvas);
            return;
        }
        this.copyBounds(this.mTmpBounds);
        if (this.mTmpBounds.width() <= 0) return;
        if (this.mTmpBounds.height() <= 0) return;
        ColorFilter colorFilter2 = colorFilter = this.mColorFilter;
        if (colorFilter == null) {
            colorFilter2 = this.mTintFilter;
        }
        canvas.getMatrix(this.mTmpMatrix);
        this.mTmpMatrix.getValues(this.mTmpFloats);
        float f = Math.abs(this.mTmpFloats[0]);
        float f2 = Math.abs(this.mTmpFloats[4]);
        float f3 = Math.abs(this.mTmpFloats[1]);
        float f4 = Math.abs(this.mTmpFloats[3]);
        if (f3 != 0.0f || f4 != 0.0f) {
            f = 1.0f;
            f2 = 1.0f;
        }
        int n = (int)((float)this.mTmpBounds.width() * f);
        int n2 = (int)((float)this.mTmpBounds.height() * f2);
        n = Math.min(2048, n);
        n2 = Math.min(2048, n2);
        if (n <= 0) return;
        if (n2 <= 0) return;
        int n3 = canvas.save();
        canvas.translate((float)this.mTmpBounds.left, (float)this.mTmpBounds.top);
        if (this.needMirroring()) {
            canvas.translate((float)this.mTmpBounds.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.mTmpBounds.offsetTo(0, 0);
        this.mVectorState.createCachedBitmapIfNeeded(n, n2);
        if (!this.mAllowCaching) {
            this.mVectorState.updateCachedBitmap(n, n2);
        } else if (!this.mVectorState.canReuseCache()) {
            this.mVectorState.updateCachedBitmap(n, n2);
            this.mVectorState.updateCacheStates();
        }
        this.mVectorState.drawCachedBitmapWithRootAlpha(canvas, colorFilter2, this.mTmpBounds);
        canvas.restoreToCount(n3);
    }

    public int getAlpha() {
        if (this.mDelegateDrawable == null) return this.mVectorState.mVPathRenderer.getRootAlpha();
        return DrawableCompat.getAlpha((Drawable)this.mDelegateDrawable);
    }

    public int getChangingConfigurations() {
        if (this.mDelegateDrawable == null) return super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations();
        return this.mDelegateDrawable.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        if (this.mDelegateDrawable == null) return this.mColorFilter;
        return DrawableCompat.getColorFilter((Drawable)this.mDelegateDrawable);
    }

    public Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable != null && Build.VERSION.SDK_INT >= 24) {
            return new VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
        }
        this.mVectorState.mChangingConfigurations = this.getChangingConfigurations();
        return this.mVectorState;
    }

    public int getIntrinsicHeight() {
        if (this.mDelegateDrawable == null) return (int)this.mVectorState.mVPathRenderer.mBaseHeight;
        return this.mDelegateDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        if (this.mDelegateDrawable == null) return (int)this.mVectorState.mVPathRenderer.mBaseWidth;
        return this.mDelegateDrawable.getIntrinsicWidth();
    }

    public int getOpacity() {
        if (this.mDelegateDrawable == null) return -3;
        return this.mDelegateDrawable.getOpacity();
    }

    public float getPixelSize() {
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState == null) return 1.0f;
        if (vectorDrawableCompatState.mVPathRenderer == null) return 1.0f;
        if (this.mVectorState.mVPathRenderer.mBaseWidth == 0.0f) return 1.0f;
        if (this.mVectorState.mVPathRenderer.mBaseHeight == 0.0f) return 1.0f;
        if (this.mVectorState.mVPathRenderer.mViewportHeight == 0.0f) return 1.0f;
        if (this.mVectorState.mVPathRenderer.mViewportWidth == 0.0f) {
            return 1.0f;
        }
        float f = this.mVectorState.mVPathRenderer.mBaseWidth;
        float f2 = this.mVectorState.mVPathRenderer.mBaseHeight;
        float f3 = this.mVectorState.mVPathRenderer.mViewportWidth;
        float f4 = this.mVectorState.mVPathRenderer.mViewportHeight;
        return Math.min(f3 / f, f4 / f2);
    }

    Object getTargetByName(String string) {
        return this.mVectorState.mVPathRenderer.mVGTargetsMap.get((Object)string);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.inflate(resources, xmlPullParser, attributeSet);
            return;
        }
        this.inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.inflate((Drawable)this.mDelegateDrawable, (Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        vectorDrawableCompatState.mVPathRenderer = new VPathRenderer();
        TypedArray typedArray = TypedArrayUtils.obtainAttributes((Resources)resources, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])AndroidResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY);
        this.updateStateFromTypedArray(typedArray, xmlPullParser, theme);
        typedArray.recycle();
        vectorDrawableCompatState.mChangingConfigurations = this.getChangingConfigurations();
        vectorDrawableCompatState.mCacheDirty = true;
        this.inflateInternal(resources, xmlPullParser, attributeSet, theme);
        this.mTintFilter = this.updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
    }

    public void invalidateSelf() {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.invalidateSelf();
            return;
        }
        super.invalidateSelf();
    }

    public boolean isAutoMirrored() {
        if (this.mDelegateDrawable == null) return this.mVectorState.mAutoMirrored;
        return DrawableCompat.isAutoMirrored((Drawable)this.mDelegateDrawable);
    }

    public boolean isStateful() {
        VectorDrawableCompatState vectorDrawableCompatState;
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.isStateful();
        }
        boolean bl = super.isStateful() || (vectorDrawableCompatState = this.mVectorState) != null && (vectorDrawableCompatState.isStateful() || this.mVectorState.mTint != null && this.mVectorState.mTint.isStateful());
        return bl;
    }

    public Drawable mutate() {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.mutate();
            return this;
        }
        if (this.mMutated) return this;
        if (super.mutate() != this) return this;
        this.mVectorState = new VectorDrawableCompatState(this.mVectorState);
        this.mMutated = true;
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.mDelegateDrawable == null) return;
        this.mDelegateDrawable.setBounds(rect);
    }

    protected boolean onStateChange(int[] nArray) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setState(nArray);
        }
        boolean bl = false;
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        ColorStateList colorStateList = vectorDrawableCompatState.mTint;
        boolean bl2 = true;
        boolean bl3 = bl;
        if (colorStateList != null) {
            bl3 = bl;
            if (vectorDrawableCompatState.mTintMode != null) {
                this.mTintFilter = this.updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
                this.invalidateSelf();
                bl3 = true;
            }
        }
        if (!vectorDrawableCompatState.isStateful()) return bl3;
        if (!vectorDrawableCompatState.onStateChanged(nArray)) return bl3;
        this.invalidateSelf();
        bl3 = bl2;
        return bl3;
    }

    public void scheduleSelf(Runnable runnable, long l) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.scheduleSelf(runnable, l);
            return;
        }
        super.scheduleSelf(runnable, l);
    }

    void setAllowCaching(boolean bl) {
        this.mAllowCaching = bl;
    }

    public void setAlpha(int n) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setAlpha(n);
            return;
        }
        if (this.mVectorState.mVPathRenderer.getRootAlpha() == n) return;
        this.mVectorState.mVPathRenderer.setRootAlpha(n);
        this.invalidateSelf();
    }

    public void setAutoMirrored(boolean bl) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setAutoMirrored((Drawable)this.mDelegateDrawable, (boolean)bl);
            return;
        }
        this.mVectorState.mAutoMirrored = bl;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setColorFilter(colorFilter);
            return;
        }
        this.mColorFilter = colorFilter;
        this.invalidateSelf();
    }

    public void setTint(int n) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTint((Drawable)this.mDelegateDrawable, (int)n);
            return;
        }
        this.setTintList(ColorStateList.valueOf((int)n));
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTintList((Drawable)this.mDelegateDrawable, (ColorStateList)colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState.mTint == colorStateList) return;
        vectorDrawableCompatState.mTint = colorStateList;
        this.mTintFilter = this.updateTintFilter(this.mTintFilter, colorStateList, vectorDrawableCompatState.mTintMode);
        this.invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTintMode((Drawable)this.mDelegateDrawable, (PorterDuff.Mode)mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState.mTintMode == mode) return;
        vectorDrawableCompatState.mTintMode = mode;
        this.mTintFilter = this.updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, mode);
        this.invalidateSelf();
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        if (this.mDelegateDrawable == null) return super.setVisible(bl, bl2);
        return this.mDelegateDrawable.setVisible(bl, bl2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.unscheduleSelf(runnable);
            return;
        }
        super.unscheduleSelf(runnable);
    }

    PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null) return null;
        if (mode != null) return new PorterDuffColorFilter(colorStateList.getColorForState(this.getState(), 0), mode);
        return null;
    }
}
