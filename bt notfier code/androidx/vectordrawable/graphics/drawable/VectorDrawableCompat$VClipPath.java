/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  androidx.core.content.res.TypedArrayUtils
 *  androidx.core.graphics.PathParser
 *  androidx.vectordrawable.graphics.drawable.AndroidResources
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPath
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.vectordrawable.graphics.drawable.AndroidResources;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import org.xmlpull.v1.XmlPullParser;

private static class VectorDrawableCompat.VClipPath
extends VectorDrawableCompat.VPath {
    VectorDrawableCompat.VClipPath() {
    }

    VectorDrawableCompat.VClipPath(VectorDrawableCompat.VClipPath vClipPath) {
        super((VectorDrawableCompat.VPath)vClipPath);
    }

    private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
        String string = typedArray.getString(0);
        if (string != null) {
            this.mPathName = string;
        }
        if ((string = typedArray.getString(1)) != null) {
            this.mNodes = PathParser.createNodesFromPathData((String)string);
        }
        this.mFillRule = TypedArrayUtils.getNamedInt((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"fillType", (int)2, (int)0);
    }

    public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
        if (!TypedArrayUtils.hasAttribute((XmlPullParser)xmlPullParser, (String)"pathData")) {
            return;
        }
        resources = TypedArrayUtils.obtainAttributes((Resources)resources, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])AndroidResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH);
        this.updateStateFromTypedArray((TypedArray)resources, xmlPullParser);
        resources.recycle();
    }

    public boolean isClipPath() {
        return true;
    }
}
