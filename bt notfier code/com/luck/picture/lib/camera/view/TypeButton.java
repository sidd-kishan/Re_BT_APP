/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.RectF
 *  android.view.View
 */
package com.luck.picture.lib.camera.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

public class TypeButton
extends View {
    public static final int TYPE_CANCEL = 1;
    public static final int TYPE_CONFIRM = 2;
    private float button_radius;
    private int button_size;
    private int button_type;
    private float center_X;
    private float center_Y;
    private float index;
    private Paint mPaint;
    private Path path;
    private RectF rectF;
    private float strokeWidth;

    public TypeButton(Context context) {
        super(context);
    }

    public TypeButton(Context context, int n, int n2) {
        super(context);
        float f;
        this.button_type = n;
        this.button_size = n2;
        float f2 = n2;
        this.button_radius = f = f2 / 2.0f;
        this.center_X = f;
        this.center_Y = f;
        this.mPaint = new Paint();
        this.path = new Path();
        this.strokeWidth = f2 / 50.0f;
        this.index = (float)this.button_size / 12.0f;
        f2 = this.center_X;
        f = this.center_Y;
        float f3 = this.index;
        this.rectF = new RectF(f2, f - f3, 2.0f * f3 + f2, f + f3);
    }

    protected void onDraw(Canvas canvas) {
        float f;
        Path path;
        super.onDraw(canvas);
        if (this.button_type == 1) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(-287515428);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(this.center_X, this.center_Y, this.button_radius, this.mPaint);
            this.mPaint.setColor(-16777216);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.strokeWidth);
            path = this.path;
            f = this.center_X;
            float f2 = this.index;
            path.moveTo(f - f2 / 7.0f, this.center_Y + f2);
            path = this.path;
            f2 = this.center_X;
            f = this.index;
            path.lineTo(f2 + f, this.center_Y + f);
            this.path.arcTo(this.rectF, 90.0f, -180.0f);
            path = this.path;
            f2 = this.center_X;
            f = this.index;
            path.lineTo(f2 - f, this.center_Y - f);
            canvas.drawPath(this.path, this.mPaint);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.path.reset();
            path = this.path;
            f = this.center_X;
            f2 = this.index;
            double d = this.center_Y;
            double d2 = f2;
            Double.isNaN(d2);
            Double.isNaN(d);
            path.moveTo(f - f2, (float)(d - d2 * 1.5));
            path = this.path;
            f = this.center_X;
            f2 = this.index;
            d = this.center_Y;
            d2 = f2;
            Double.isNaN(d2);
            Double.isNaN(d);
            path.lineTo(f - f2, (float)(d - (d2 /= 2.3)));
            path = this.path;
            d = this.center_X;
            f = this.index;
            d2 = f;
            Double.isNaN(d2);
            Double.isNaN(d);
            path.lineTo((float)(d - d2 * 1.6), this.center_Y - f);
            this.path.close();
            canvas.drawPath(this.path, this.mPaint);
        }
        if (this.button_type != 2) return;
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(-1);
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(this.center_X, this.center_Y, this.button_radius, this.mPaint);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(-16724992);
        this.mPaint.setStrokeWidth(this.strokeWidth);
        this.path.moveTo(this.center_X - (float)this.button_size / 6.0f, this.center_Y);
        path = this.path;
        f = this.center_X;
        int n = this.button_size;
        path.lineTo(f - (float)n / 21.2f, this.center_Y + (float)n / 7.7f);
        path = this.path;
        f = this.center_X;
        n = this.button_size;
        path.lineTo(f + (float)n / 4.0f, this.center_Y - (float)n / 8.5f);
        path = this.path;
        f = this.center_X;
        n = this.button_size;
        path.lineTo(f - (float)n / 21.2f, this.center_Y + (float)n / 9.4f);
        this.path.close();
        canvas.drawPath(this.path, this.mPaint);
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        n = this.button_size;
        this.setMeasuredDimension(n, n);
    }
}
