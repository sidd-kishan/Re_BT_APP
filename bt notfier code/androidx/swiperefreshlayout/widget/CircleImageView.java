/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.ShapeDrawable
 *  android.graphics.drawable.shapes.OvalShape
 *  android.graphics.drawable.shapes.Shape
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.animation.Animation$AnimationListener
 *  android.widget.ImageView
 *  androidx.core.content.ContextCompat
 *  androidx.core.view.ViewCompat
 *  androidx.swiperefreshlayout.widget.CircleImageView$OvalShadow
 */
package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.swiperefreshlayout.widget.CircleImageView;

class CircleImageView
extends ImageView {
    private static final int FILL_SHADOW_COLOR = 0x3D000000;
    private static final int KEY_SHADOW_COLOR = 0x1E000000;
    private static final int SHADOW_ELEVATION = 4;
    private static final float SHADOW_RADIUS = 3.5f;
    private static final float X_OFFSET = 0.0f;
    private static final float Y_OFFSET = 1.75f;
    private Animation.AnimationListener mListener;
    int mShadowRadius;

    CircleImageView(Context context, int n) {
        super(context);
        float f = this.getContext().getResources().getDisplayMetrics().density;
        int n2 = (int)(1.75f * f);
        int n3 = (int)(0.0f * f);
        this.mShadowRadius = (int)(3.5f * f);
        if (this.elevationSupported()) {
            context = new ShapeDrawable((Shape)new OvalShape());
            ViewCompat.setElevation((View)this, (float)(f * 4.0f));
        } else {
            context = new ShapeDrawable((Shape)new OvalShadow(this, this.mShadowRadius));
            this.setLayerType(1, context.getPaint());
            context.getPaint().setShadowLayer((float)this.mShadowRadius, (float)n3, (float)n2, 0x1E000000);
            n2 = this.mShadowRadius;
            this.setPadding(n2, n2, n2, n2);
        }
        context.getPaint().setColor(n);
        ViewCompat.setBackground((View)this, (Drawable)context);
    }

    private boolean elevationSupported() {
        boolean bl = Build.VERSION.SDK_INT >= 21;
        return bl;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener == null) return;
        animationListener.onAnimationEnd(this.getAnimation());
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener == null) return;
        animationListener.onAnimationStart(this.getAnimation());
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        if (this.elevationSupported()) return;
        this.setMeasuredDimension(this.getMeasuredWidth() + this.mShadowRadius * 2, this.getMeasuredHeight() + this.mShadowRadius * 2);
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.mListener = animationListener;
    }

    public void setBackgroundColor(int n) {
        if (!(this.getBackground() instanceof ShapeDrawable)) return;
        ((ShapeDrawable)this.getBackground()).getPaint().setColor(n);
    }

    public void setBackgroundColorRes(int n) {
        this.setBackgroundColor(ContextCompat.getColor((Context)this.getContext(), (int)n));
    }
}
