/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.view.View
 */
package com.luck.picture.lib.camera.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class ReturnButton
extends View {
    private int center_X;
    private int center_Y;
    private Paint paint;
    Path path;
    private int size;
    private float strokeWidth;

    public ReturnButton(Context context) {
        super(context);
    }

    public ReturnButton(Context context, int n) {
        this(context);
        int n2;
        this.size = n;
        this.center_X = n2 = n / 2;
        this.center_Y = n2;
        this.strokeWidth = (float)n / 15.0f;
        context = new Paint();
        this.paint = context;
        context.setAntiAlias(true);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.strokeWidth);
        this.path = new Path();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = this.path;
        float f = this.strokeWidth;
        path.moveTo(f, f / 2.0f);
        this.path.lineTo((float)this.center_X, (float)this.center_Y - this.strokeWidth / 2.0f);
        path = this.path;
        f = this.size;
        float f2 = this.strokeWidth;
        path.lineTo(f - f2, f2 / 2.0f);
        canvas.drawPath(this.path, this.paint);
    }

    protected void onMeasure(int n, int n2) {
        n = this.size;
        this.setMeasuredDimension(n, n / 2);
    }
}
