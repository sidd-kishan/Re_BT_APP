/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.ColorFilter
 *  android.graphics.ColorMatrix
 *  android.graphics.ColorMatrixColorFilter
 *  android.widget.ImageView
 */
package androidx.constraintlayout.utils.widget;

import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.ImageView;

static class ImageFilterView.ImageMatrix {
    float[] m = new float[20];
    float mBrightness = 1.0f;
    ColorMatrix mColorMatrix = new ColorMatrix();
    float mContrast = 1.0f;
    float mSaturation = 1.0f;
    ColorMatrix mTmpColorMatrix = new ColorMatrix();
    float mWarmth = 1.0f;

    ImageFilterView.ImageMatrix() {
    }

    private void brightness(float f) {
        float[] fArray = this.m;
        fArray[0] = f;
        fArray[1] = 0.0f;
        fArray[2] = 0.0f;
        fArray[3] = 0.0f;
        fArray[4] = 0.0f;
        fArray[5] = 0.0f;
        fArray[6] = f;
        fArray[7] = 0.0f;
        fArray[8] = 0.0f;
        fArray[9] = 0.0f;
        fArray[10] = 0.0f;
        fArray[11] = 0.0f;
        fArray[12] = f;
        fArray[13] = 0.0f;
        fArray[14] = 0.0f;
        fArray[15] = 0.0f;
        fArray[16] = 0.0f;
        fArray[17] = 0.0f;
        fArray[18] = 1.0f;
        fArray[19] = 0.0f;
    }

    private void saturation(float f) {
        float f2 = 1.0f - f;
        float f3 = 0.2999f * f2;
        float f4 = 0.587f * f2;
        float[] fArray = this.m;
        fArray[0] = f3 + f;
        fArray[1] = f4;
        fArray[2] = f2 *= 0.114f;
        fArray[3] = 0.0f;
        fArray[4] = 0.0f;
        fArray[5] = f3;
        fArray[6] = f4 + f;
        fArray[7] = f2;
        fArray[8] = 0.0f;
        fArray[9] = 0.0f;
        fArray[10] = f3;
        fArray[11] = f4;
        fArray[12] = f2 + f;
        fArray[13] = 0.0f;
        fArray[14] = 0.0f;
        fArray[15] = 0.0f;
        fArray[16] = 0.0f;
        fArray[17] = 0.0f;
        fArray[18] = 1.0f;
        fArray[19] = 0.0f;
    }

    private void warmth(float f) {
        float f2;
        float f3 = f;
        if (f <= 0.0f) {
            f3 = 0.01f;
        }
        if ((f = 5000.0f / f3 / 100.0f) > 66.0f) {
            double d = f - 60.0f;
            f2 = (float)Math.pow(d, -0.13320475816726685) * 329.69873f;
            f3 = (float)Math.pow(d, 0.07551484555006027) * 288.12216f;
        } else {
            f3 = (float)Math.log(f) * 99.4708f - 161.11957f;
            f2 = 255.0f;
        }
        f = f < 66.0f ? (f > 19.0f ? (float)Math.log(f - 10.0f) * 138.51773f - 305.0448f : 0.0f) : 255.0f;
        f2 = Math.min(255.0f, Math.max(f2, 0.0f));
        f3 = Math.min(255.0f, Math.max(f3, 0.0f));
        f = Math.min(255.0f, Math.max(f, 0.0f));
        float f4 = (float)Math.log(50.0f);
        float f5 = (float)Math.log(40.0f);
        float f6 = Math.min(255.0f, Math.max(255.0f, 0.0f));
        f4 = Math.min(255.0f, Math.max(f4 * 99.4708f - 161.11957f, 0.0f));
        f5 = Math.min(255.0f, Math.max(f5 * 138.51773f - 305.0448f, 0.0f));
        f3 /= f4;
        f /= f5;
        float[] fArray = this.m;
        fArray[0] = f2 /= f6;
        fArray[1] = 0.0f;
        fArray[2] = 0.0f;
        fArray[3] = 0.0f;
        fArray[4] = 0.0f;
        fArray[5] = 0.0f;
        fArray[6] = f3;
        fArray[7] = 0.0f;
        fArray[8] = 0.0f;
        fArray[9] = 0.0f;
        fArray[10] = 0.0f;
        fArray[11] = 0.0f;
        fArray[12] = f;
        fArray[13] = 0.0f;
        fArray[14] = 0.0f;
        fArray[15] = 0.0f;
        fArray[16] = 0.0f;
        fArray[17] = 0.0f;
        fArray[18] = 1.0f;
        fArray[19] = 0.0f;
    }

    void updateMatrix(ImageView imageView) {
        boolean bl;
        this.mColorMatrix.reset();
        float f = this.mSaturation;
        boolean bl2 = true;
        if (f != 1.0f) {
            this.saturation(f);
            this.mColorMatrix.set(this.m);
            bl = true;
        } else {
            bl = false;
        }
        f = this.mContrast;
        if (f != 1.0f) {
            this.mTmpColorMatrix.setScale(f, f, f, 1.0f);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            bl = true;
        }
        if ((f = this.mWarmth) != 1.0f) {
            this.warmth(f);
            this.mTmpColorMatrix.set(this.m);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            bl = true;
        }
        if ((f = this.mBrightness) != 1.0f) {
            this.brightness(f);
            this.mTmpColorMatrix.set(this.m);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            bl = bl2;
        }
        if (bl) {
            imageView.setColorFilter((ColorFilter)new ColorMatrixColorFilter(this.mColorMatrix));
        } else {
            imageView.clearColorFilter();
        }
    }
}
