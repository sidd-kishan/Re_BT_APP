/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapShader
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.AnimationDrawable
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.ClipDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.ShapeDrawable
 *  android.graphics.drawable.shapes.RoundRectShape
 *  android.graphics.drawable.shapes.Shape
 *  android.widget.ProgressBar
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.core.graphics.drawable.WrappedDrawable
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.WrappedDrawable;

class AppCompatProgressBarHelper {
    private static final int[] TINT_ATTRS = new int[]{16843067, 16843068};
    private Bitmap mSampleTile;
    private final ProgressBar mView;

    AppCompatProgressBarHelper(ProgressBar progressBar) {
        this.mView = progressBar;
    }

    private Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    private Drawable tileify(Drawable drawable, boolean bl) {
        int n;
        int n2;
        LayerDrawable layerDrawable;
        int n3;
        if (drawable instanceof WrappedDrawable) {
            WrappedDrawable wrappedDrawable = (WrappedDrawable)drawable;
            Drawable drawable2 = wrappedDrawable.getWrappedDrawable();
            if (drawable2 == null) return drawable;
            wrappedDrawable.setWrappedDrawable(this.tileify(drawable2, bl));
            return drawable;
        }
        if (drawable instanceof LayerDrawable) {
            drawable = (LayerDrawable)drawable;
            n3 = drawable.getNumberOfLayers();
            layerDrawable = new Drawable[n3];
            n2 = 0;
        } else {
            if (!(drawable instanceof BitmapDrawable)) return drawable;
            drawable = (BitmapDrawable)drawable;
            Bitmap bitmap = drawable.getBitmap();
            if (this.mSampleTile == null) {
                this.mSampleTile = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(this.getDrawableShape());
            bitmap = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
            shapeDrawable.getPaint().setShader((Shader)bitmap);
            shapeDrawable.getPaint().setColorFilter(drawable.getPaint().getColorFilter());
            drawable = shapeDrawable;
            if (!bl) return drawable;
            drawable = new ClipDrawable((Drawable)shapeDrawable, 3, 1);
            return drawable;
        }
        for (n = 0; n < n3; ++n) {
            int n4 = drawable.getId(n);
            Drawable drawable3 = drawable.getDrawable(n);
            bl = n4 == 16908301 || n4 == 16908303;
            layerDrawable[n] = this.tileify(drawable3, bl);
        }
        layerDrawable = new LayerDrawable((Drawable[])layerDrawable);
        n = n2;
        while (n < n3) {
            layerDrawable.setId(n, drawable.getId(n));
            ++n;
        }
        return layerDrawable;
    }

    private Drawable tileifyIndeterminate(Drawable drawable) {
        Drawable drawable2 = drawable;
        if (!(drawable instanceof AnimationDrawable)) return drawable2;
        AnimationDrawable animationDrawable = (AnimationDrawable)drawable;
        int n = animationDrawable.getNumberOfFrames();
        drawable2 = new AnimationDrawable();
        drawable2.setOneShot(animationDrawable.isOneShot());
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                drawable2.setLevel(10000);
                return drawable2;
            }
            drawable = this.tileify(animationDrawable.getFrame(n2), true);
            drawable.setLevel(10000);
            drawable2.addFrame(drawable, animationDrawable.getDuration(n2));
            ++n2;
        }
    }

    Bitmap getSampleTile() {
        return this.mSampleTile;
    }

    void loadFromAttributes(AttributeSet attributeSet, int n) {
        attributeSet = TintTypedArray.obtainStyledAttributes((Context)this.mView.getContext(), (AttributeSet)attributeSet, (int[])TINT_ATTRS, (int)n, (int)0);
        Drawable drawable = attributeSet.getDrawableIfKnown(0);
        if (drawable != null) {
            this.mView.setIndeterminateDrawable(this.tileifyIndeterminate(drawable));
        }
        if ((drawable = attributeSet.getDrawableIfKnown(1)) != null) {
            this.mView.setProgressDrawable(this.tileify(drawable, false));
        }
        attributeSet.recycle();
    }
}
