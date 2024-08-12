/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.RadialGradient
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.shapes.OvalShape
 *  androidx.swiperefreshlayout.widget.CircleImageView
 */
package androidx.swiperefreshlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.shapes.OvalShape;
import androidx.swiperefreshlayout.widget.CircleImageView;

private class CircleImageView.OvalShadow
extends OvalShape {
    private RadialGradient mRadialGradient;
    private Paint mShadowPaint;
    final CircleImageView this$0;

    CircleImageView.OvalShadow(CircleImageView circleImageView, int n) {
        this.this$0 = circleImageView;
        this.mShadowPaint = new Paint();
        circleImageView.mShadowRadius = n;
        this.updateRadialGradient((int)this.rect().width());
    }

    private void updateRadialGradient(int n) {
        float f = n / 2;
        float f2 = this.this$0.mShadowRadius;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        tileMode = new RadialGradient(f, f, f2, new int[]{0x3D000000, 0}, null, tileMode);
        this.mRadialGradient = tileMode;
        this.mShadowPaint.setShader((Shader)tileMode);
    }

    public void draw(Canvas canvas, Paint paint) {
        int n = this.this$0.getWidth();
        int n2 = this.this$0.getHeight();
        float f = n /= 2;
        float f2 = n2 / 2;
        canvas.drawCircle(f, f2, f, this.mShadowPaint);
        canvas.drawCircle(f, f2, (float)(n - this.this$0.mShadowRadius), paint);
    }

    protected void onResize(float f, float f2) {
        super.onResize(f, f2);
        this.updateRadialGradient((int)f);
    }
}
