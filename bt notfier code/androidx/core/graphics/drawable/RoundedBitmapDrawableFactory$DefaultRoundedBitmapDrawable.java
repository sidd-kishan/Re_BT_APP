/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Rect
 *  androidx.core.graphics.BitmapCompat
 *  androidx.core.graphics.drawable.RoundedBitmapDrawable
 *  androidx.core.view.GravityCompat
 */
package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.core.graphics.BitmapCompat;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.view.GravityCompat;

private static class RoundedBitmapDrawableFactory.DefaultRoundedBitmapDrawable
extends RoundedBitmapDrawable {
    RoundedBitmapDrawableFactory.DefaultRoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    void gravityCompatApply(int n, int n2, int n3, Rect rect, Rect rect2) {
        GravityCompat.apply((int)n, (int)n2, (int)n3, (Rect)rect, (Rect)rect2, (int)0);
    }

    public boolean hasMipMap() {
        boolean bl = this.mBitmap != null && BitmapCompat.hasMipMap((Bitmap)this.mBitmap);
        return bl;
    }

    public void setMipMap(boolean bl) {
        if (this.mBitmap == null) return;
        BitmapCompat.setHasMipMap((Bitmap)this.mBitmap, (boolean)bl);
        this.invalidateSelf();
    }
}
