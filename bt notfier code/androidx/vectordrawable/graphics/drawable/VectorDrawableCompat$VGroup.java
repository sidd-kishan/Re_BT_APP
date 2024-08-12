/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Matrix
 *  androidx.collection.ArrayMap
 *  androidx.core.content.res.TypedArrayUtils
 *  androidx.vectordrawable.graphics.drawable.AndroidResources
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VClipPath
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VFullPath
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VObject
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPath
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.util.AttributeSet;
import androidx.collection.ArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.vectordrawable.graphics.drawable.AndroidResources;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

private static class VectorDrawableCompat.VGroup
extends VectorDrawableCompat.VObject {
    int mChangingConfigurations;
    final ArrayList<VectorDrawableCompat.VObject> mChildren;
    private String mGroupName = null;
    final Matrix mLocalMatrix;
    private float mPivotX = 0.0f;
    private float mPivotY = 0.0f;
    float mRotate = 0.0f;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    final Matrix mStackedMatrix = new Matrix();
    private int[] mThemeAttrs;
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;

    public VectorDrawableCompat.VGroup() {
        super(null);
        this.mChildren = new ArrayList();
        this.mLocalMatrix = new Matrix();
    }

    public VectorDrawableCompat.VGroup(VectorDrawableCompat.VGroup vGroup, ArrayMap<String, Object> arrayMap) {
        super(null);
        this.mChildren = new ArrayList();
        this.mLocalMatrix = new Matrix();
        this.mRotate = vGroup.mRotate;
        this.mPivotX = vGroup.mPivotX;
        this.mPivotY = vGroup.mPivotY;
        this.mScaleX = vGroup.mScaleX;
        this.mScaleY = vGroup.mScaleY;
        this.mTranslateX = vGroup.mTranslateX;
        this.mTranslateY = vGroup.mTranslateY;
        this.mThemeAttrs = vGroup.mThemeAttrs;
        Object object = vGroup.mGroupName;
        this.mGroupName = object;
        this.mChangingConfigurations = vGroup.mChangingConfigurations;
        if (object != null) {
            arrayMap.put(object, (Object)this);
        }
        this.mLocalMatrix.set(vGroup.mLocalMatrix);
        object = vGroup.mChildren;
        int n = 0;
        while (n < ((ArrayList)object).size()) {
            vGroup = ((ArrayList)object).get(n);
            if (vGroup instanceof VectorDrawableCompat.VGroup) {
                this.mChildren.add(new VectorDrawableCompat.VGroup(vGroup, arrayMap));
            } else {
                if (vGroup instanceof VectorDrawableCompat.VFullPath) {
                    vGroup = new VectorDrawableCompat.VFullPath((VectorDrawableCompat.VFullPath)vGroup);
                } else {
                    if (!(vGroup instanceof VectorDrawableCompat.VClipPath)) throw new IllegalStateException("Unknown object in the tree!");
                    vGroup = new VectorDrawableCompat.VClipPath((VectorDrawableCompat.VClipPath)vGroup);
                }
                this.mChildren.add(vGroup);
                if (((VectorDrawableCompat.VPath)vGroup).mPathName != null) {
                    arrayMap.put((Object)((VectorDrawableCompat.VPath)vGroup).mPathName, (Object)vGroup);
                }
            }
            ++n;
        }
    }

    private void updateLocalMatrix() {
        this.mLocalMatrix.reset();
        this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
        this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
        this.mLocalMatrix.postRotate(this.mRotate, 0.0f, 0.0f);
        this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
    }

    private void updateStateFromTypedArray(TypedArray object, XmlPullParser xmlPullParser) {
        this.mThemeAttrs = null;
        this.mRotate = TypedArrayUtils.getNamedFloat((TypedArray)object, (XmlPullParser)xmlPullParser, (String)"rotation", (int)5, (float)this.mRotate);
        this.mPivotX = object.getFloat(1, this.mPivotX);
        this.mPivotY = object.getFloat(2, this.mPivotY);
        this.mScaleX = TypedArrayUtils.getNamedFloat((TypedArray)object, (XmlPullParser)xmlPullParser, (String)"scaleX", (int)3, (float)this.mScaleX);
        this.mScaleY = TypedArrayUtils.getNamedFloat((TypedArray)object, (XmlPullParser)xmlPullParser, (String)"scaleY", (int)4, (float)this.mScaleY);
        this.mTranslateX = TypedArrayUtils.getNamedFloat((TypedArray)object, (XmlPullParser)xmlPullParser, (String)"translateX", (int)6, (float)this.mTranslateX);
        this.mTranslateY = TypedArrayUtils.getNamedFloat((TypedArray)object, (XmlPullParser)xmlPullParser, (String)"translateY", (int)7, (float)this.mTranslateY);
        if ((object = object.getString(0)) != null) {
            this.mGroupName = object;
        }
        this.updateLocalMatrix();
    }

    public String getGroupName() {
        return this.mGroupName;
    }

    public Matrix getLocalMatrix() {
        return this.mLocalMatrix;
    }

    public float getPivotX() {
        return this.mPivotX;
    }

    public float getPivotY() {
        return this.mPivotY;
    }

    public float getRotation() {
        return this.mRotate;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
        resources = TypedArrayUtils.obtainAttributes((Resources)resources, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])AndroidResources.STYLEABLE_VECTOR_DRAWABLE_GROUP);
        this.updateStateFromTypedArray((TypedArray)resources, xmlPullParser);
        resources.recycle();
    }

    public boolean isStateful() {
        int n = 0;
        while (n < this.mChildren.size()) {
            if (this.mChildren.get(n).isStateful()) {
                return true;
            }
            ++n;
        }
        return false;
    }

    public boolean onStateChanged(int[] nArray) {
        int n = 0;
        boolean bl = false;
        while (n < this.mChildren.size()) {
            bl |= this.mChildren.get(n).onStateChanged(nArray);
            ++n;
        }
        return bl;
    }

    public void setPivotX(float f) {
        if (f == this.mPivotX) return;
        this.mPivotX = f;
        this.updateLocalMatrix();
    }

    public void setPivotY(float f) {
        if (f == this.mPivotY) return;
        this.mPivotY = f;
        this.updateLocalMatrix();
    }

    public void setRotation(float f) {
        if (f == this.mRotate) return;
        this.mRotate = f;
        this.updateLocalMatrix();
    }

    public void setScaleX(float f) {
        if (f == this.mScaleX) return;
        this.mScaleX = f;
        this.updateLocalMatrix();
    }

    public void setScaleY(float f) {
        if (f == this.mScaleY) return;
        this.mScaleY = f;
        this.updateLocalMatrix();
    }

    public void setTranslateX(float f) {
        if (f == this.mTranslateX) return;
        this.mTranslateX = f;
        this.updateLocalMatrix();
    }

    public void setTranslateY(float f) {
        if (f == this.mTranslateY) return;
        this.mTranslateY = f;
        this.updateLocalMatrix();
    }
}
