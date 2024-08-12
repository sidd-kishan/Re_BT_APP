/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.view.ViewCompat
 *  androidx.transition.ChangeTransform
 */
package androidx.transition;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.transition.ChangeTransform;

/*
 * Exception performing whole class analysis ignored.
 */
private static class ChangeTransform.Transforms {
    final float mRotationX;
    final float mRotationY;
    final float mRotationZ;
    final float mScaleX;
    final float mScaleY;
    final float mTranslationX;
    final float mTranslationY;
    final float mTranslationZ;

    ChangeTransform.Transforms(View view) {
        this.mTranslationX = view.getTranslationX();
        this.mTranslationY = view.getTranslationY();
        this.mTranslationZ = ViewCompat.getTranslationZ((View)view);
        this.mScaleX = view.getScaleX();
        this.mScaleY = view.getScaleY();
        this.mRotationX = view.getRotationX();
        this.mRotationY = view.getRotationY();
        this.mRotationZ = view.getRotation();
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof ChangeTransform.Transforms;
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        object = (ChangeTransform.Transforms)object;
        bl = bl2;
        if (((ChangeTransform.Transforms)object).mTranslationX != this.mTranslationX) return bl;
        bl = bl2;
        if (((ChangeTransform.Transforms)object).mTranslationY != this.mTranslationY) return bl;
        bl = bl2;
        if (((ChangeTransform.Transforms)object).mTranslationZ != this.mTranslationZ) return bl;
        bl = bl2;
        if (((ChangeTransform.Transforms)object).mScaleX != this.mScaleX) return bl;
        bl = bl2;
        if (((ChangeTransform.Transforms)object).mScaleY != this.mScaleY) return bl;
        bl = bl2;
        if (((ChangeTransform.Transforms)object).mRotationX != this.mRotationX) return bl;
        bl = bl2;
        if (((ChangeTransform.Transforms)object).mRotationY != this.mRotationY) return bl;
        bl = bl2;
        if (((ChangeTransform.Transforms)object).mRotationZ != this.mRotationZ) return bl;
        bl = true;
        return bl;
    }

    public int hashCode() {
        float f = this.mTranslationX;
        int n = 0;
        int n2 = f != 0.0f ? Float.floatToIntBits(f) : 0;
        f = this.mTranslationY;
        int n3 = f != 0.0f ? Float.floatToIntBits(f) : 0;
        f = this.mTranslationZ;
        int n4 = f != 0.0f ? Float.floatToIntBits(f) : 0;
        f = this.mScaleX;
        int n5 = f != 0.0f ? Float.floatToIntBits(f) : 0;
        f = this.mScaleY;
        int n6 = f != 0.0f ? Float.floatToIntBits(f) : 0;
        f = this.mRotationX;
        int n7 = f != 0.0f ? Float.floatToIntBits(f) : 0;
        f = this.mRotationY;
        int n8 = f != 0.0f ? Float.floatToIntBits(f) : 0;
        f = this.mRotationZ;
        if (f == 0.0f) return ((((((n2 * 31 + n3) * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n7) * 31 + n8) * 31 + n;
        n = Float.floatToIntBits(f);
        return ((((((n2 * 31 + n3) * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n7) * 31 + n8) * 31 + n;
    }

    public void restore(View view) {
        ChangeTransform.setTransforms((View)view, (float)this.mTranslationX, (float)this.mTranslationY, (float)this.mTranslationZ, (float)this.mScaleX, (float)this.mScaleY, (float)this.mRotationX, (float)this.mRotationY, (float)this.mRotationZ);
    }
}
