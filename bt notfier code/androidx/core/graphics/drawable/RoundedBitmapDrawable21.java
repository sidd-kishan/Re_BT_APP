/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Outline
 *  android.graphics.Rect
 *  android.view.Gravity
 *  androidx.core.graphics.drawable.RoundedBitmapDrawable
 */
package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;

class RoundedBitmapDrawable21
extends RoundedBitmapDrawable {
    protected RoundedBitmapDrawable21(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    public void getOutline(Outline outline) {
        this.updateDstRect();
        outline.setRoundRect(this.mDstRect, this.getCornerRadius());
    }

    void gravityCompatApply(int n, int n2, int n3, Rect rect, Rect rect2) {
        Gravity.apply((int)n, (int)n2, (int)n3, (Rect)rect, (Rect)rect2, (int)0);
    }

    public boolean hasMipMap() {
        boolean bl = this.mBitmap != null && this.mBitmap.hasMipMap();
        return bl;
    }

    public void setMipMap(boolean bl) {
        if (this.mBitmap == null) return;
        this.mBitmap.setHasMipMap(bl);
        this.invalidateSelf();
    }
}
