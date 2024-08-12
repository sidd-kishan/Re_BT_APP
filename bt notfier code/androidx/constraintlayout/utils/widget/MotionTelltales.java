/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.MotionLayout
 *  androidx.constraintlayout.utils.widget.MockView
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.utils.widget.MockView;
import androidx.constraintlayout.widget.R;

public class MotionTelltales
extends MockView {
    private static final String TAG = "MotionTelltales";
    Matrix mInvertMatrix;
    MotionLayout mMotionLayout;
    private Paint mPaintTelltales = new Paint();
    int mTailColor = -65281;
    float mTailScale = 0.25f;
    int mVelocityMode = 0;
    float[] velocity = new float[2];

    public MotionTelltales(Context context) {
        super(context);
        this.mInvertMatrix = new Matrix();
        this.init(context, null);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInvertMatrix = new Matrix();
        this.init(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mInvertMatrix = new Matrix();
        this.init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            context = context.obtainStyledAttributes(attributeSet, R.styleable.MotionTelltales);
            int n = context.getIndexCount();
            for (int i = 0; i < n; ++i) {
                int n2 = context.getIndex(i);
                if (n2 == R.styleable.MotionTelltales_telltales_tailColor) {
                    this.mTailColor = context.getColor(n2, this.mTailColor);
                    continue;
                }
                if (n2 == R.styleable.MotionTelltales_telltales_velocityMode) {
                    this.mVelocityMode = context.getInt(n2, this.mVelocityMode);
                    continue;
                }
                if (n2 != R.styleable.MotionTelltales_telltales_tailScale) continue;
                this.mTailScale = context.getFloat(n2, this.mTailScale);
            }
            context.recycle();
        }
        this.mPaintTelltales.setColor(this.mTailColor);
        this.mPaintTelltales.setStrokeWidth(5.0f);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onDraw(Canvas canvas) {
        float[] fArray;
        super.onDraw(canvas);
        this.getMatrix().invert(this.mInvertMatrix);
        if (this.mMotionLayout == null) {
            canvas = this.getParent();
            if (!(canvas instanceof MotionLayout)) return;
            this.mMotionLayout = (MotionLayout)canvas;
            return;
        }
        int n = this.getWidth();
        int n2 = this.getHeight();
        float[] fArray2 = fArray = new float[5];
        fArray[0] = 0.1f;
        fArray2[1] = 0.25f;
        fArray2[2] = 0.5f;
        fArray2[3] = 0.75f;
        fArray2[4] = 0.9f;
        int n3 = 0;
        while (n3 < 5) {
            float f = fArray[n3];
            for (int i = 0; i < 5; ++i) {
                float f2 = fArray[i];
                this.mMotionLayout.getViewVelocity((View)this, f2, f, this.velocity, this.mVelocityMode);
                this.mInvertMatrix.mapVectors(this.velocity);
                float f3 = (float)n * f2;
                f2 = (float)n2 * f;
                float[] fArray3 = this.velocity;
                float f4 = fArray3[0];
                float f5 = this.mTailScale;
                float f6 = fArray3[1];
                this.mInvertMatrix.mapVectors(fArray3);
                canvas.drawLine(f3, f2, f3 - f4 * f5, f2 - f6 * f5, this.mPaintTelltales);
            }
            ++n3;
        }
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        this.postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.mText = charSequence.toString();
        this.requestLayout();
    }
}
