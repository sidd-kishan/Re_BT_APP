/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.InsetDrawable
 *  android.os.Build$VERSION
 *  android.view.View
 *  androidx.core.view.ViewCompat
 *  androidx.legacy.app.ActionBarDrawerToggle
 */
package androidx.legacy.app;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.legacy.app.ActionBarDrawerToggle;

private class ActionBarDrawerToggle.SlideDrawable
extends InsetDrawable
implements Drawable.Callback {
    private final boolean mHasMirroring;
    private float mOffset;
    private float mPosition;
    private final Rect mTmpRect;
    final ActionBarDrawerToggle this$0;

    ActionBarDrawerToggle.SlideDrawable(ActionBarDrawerToggle actionBarDrawerToggle, Drawable drawable) {
        this.this$0 = actionBarDrawerToggle;
        boolean bl = false;
        super(drawable, 0);
        if (Build.VERSION.SDK_INT > 18) {
            bl = true;
        }
        this.mHasMirroring = bl;
        this.mTmpRect = new Rect();
    }

    public void draw(Canvas canvas) {
        this.copyBounds(this.mTmpRect);
        canvas.save();
        int n = ViewCompat.getLayoutDirection((View)this.this$0.mActivity.getWindow().getDecorView());
        int n2 = 1;
        n = n == 1 ? 1 : 0;
        if (n != 0) {
            n2 = -1;
        }
        int n3 = this.mTmpRect.width();
        float f = -this.mOffset;
        float f2 = n3;
        canvas.translate(f * f2 * this.mPosition * (float)n2, 0.0f);
        if (n != 0 && !this.mHasMirroring) {
            canvas.translate(f2, 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        super.draw(canvas);
        canvas.restore();
    }

    public float getPosition() {
        return this.mPosition;
    }

    public void setOffset(float f) {
        this.mOffset = f;
        this.invalidateSelf();
    }

    public void setPosition(float f) {
        this.mPosition = f;
        this.invalidateSelf();
    }
}
