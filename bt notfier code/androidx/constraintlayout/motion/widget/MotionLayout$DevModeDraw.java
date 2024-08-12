/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.DashPathEffect
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PathEffect
 *  android.graphics.Rect
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.MotionController
 *  androidx.constraintlayout.motion.widget.MotionLayout
 */
package androidx.constraintlayout.motion.widget;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.HashMap;

/*
 * Exception performing whole class analysis ignored.
 */
private class MotionLayout.DevModeDraw {
    private static final int DEBUG_PATH_TICKS_PER_MS = 16;
    final int DIAMOND_SIZE;
    final int GRAPH_COLOR;
    final int KEYFRAME_COLOR;
    final int RED_COLOR;
    final int SHADOW_COLOR;
    Rect mBounds;
    DashPathEffect mDashPathEffect;
    Paint mFillPaint;
    int mKeyFrameCount;
    float[] mKeyFramePoints;
    Paint mPaint;
    Paint mPaintGraph;
    Paint mPaintKeyframes;
    Path mPath;
    int[] mPathMode;
    float[] mPoints;
    boolean mPresentationMode;
    private float[] mRectangle;
    int mShadowTranslate;
    Paint mTextPaint;
    final MotionLayout this$0;

    public MotionLayout.DevModeDraw(MotionLayout motionLayout) {
        Paint paint;
        this.this$0 = motionLayout;
        this.RED_COLOR = -21965;
        this.KEYFRAME_COLOR = -2067046;
        this.GRAPH_COLOR = -13391360;
        this.SHADOW_COLOR = 0x77000000;
        this.DIAMOND_SIZE = 10;
        this.mBounds = new Rect();
        this.mPresentationMode = false;
        this.mShadowTranslate = 1;
        this.mPaint = paint = new Paint();
        paint.setAntiAlias(true);
        this.mPaint.setColor(-21965);
        this.mPaint.setStrokeWidth(2.0f);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaintKeyframes = paint = new Paint();
        paint.setAntiAlias(true);
        this.mPaintKeyframes.setColor(-2067046);
        this.mPaintKeyframes.setStrokeWidth(2.0f);
        this.mPaintKeyframes.setStyle(Paint.Style.STROKE);
        this.mPaintGraph = paint = new Paint();
        paint.setAntiAlias(true);
        this.mPaintGraph.setColor(-13391360);
        this.mPaintGraph.setStrokeWidth(2.0f);
        this.mPaintGraph.setStyle(Paint.Style.STROKE);
        this.mTextPaint = paint = new Paint();
        paint.setAntiAlias(true);
        this.mTextPaint.setColor(-13391360);
        this.mTextPaint.setTextSize(motionLayout.getContext().getResources().getDisplayMetrics().density * 12.0f);
        this.mRectangle = new float[8];
        motionLayout = new Paint();
        this.mFillPaint = motionLayout;
        motionLayout.setAntiAlias(true);
        motionLayout = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.mDashPathEffect = motionLayout;
        this.mPaintGraph.setPathEffect((PathEffect)motionLayout);
        this.mKeyFramePoints = new float[100];
        this.mPathMode = new int[50];
        if (!this.mPresentationMode) return;
        this.mPaint.setStrokeWidth(8.0f);
        this.mFillPaint.setStrokeWidth(8.0f);
        this.mPaintKeyframes.setStrokeWidth(8.0f);
        this.mShadowTranslate = 4;
    }

    private void drawBasicPath(Canvas canvas) {
        canvas.drawLines(this.mPoints, this.mPaint);
    }

    private void drawPathAsConfigured(Canvas canvas) {
        boolean bl = false;
        boolean bl2 = false;
        for (int i = 0; i < this.mKeyFrameCount; ++i) {
            if (this.mPathMode[i] == 1) {
                bl = true;
            }
            if (this.mPathMode[i] != 2) continue;
            bl2 = true;
        }
        if (bl) {
            this.drawPathRelative(canvas);
        }
        if (!bl2) return;
        this.drawPathCartesian(canvas);
    }

    private void drawPathCartesian(Canvas canvas) {
        float[] fArray = this.mPoints;
        float f = fArray[0];
        float f2 = fArray[1];
        float f3 = fArray[fArray.length - 2];
        float f4 = fArray[fArray.length - 1];
        canvas.drawLine(Math.min(f, f3), Math.max(f2, f4), Math.max(f, f3), Math.max(f2, f4), this.mPaintGraph);
        canvas.drawLine(Math.min(f, f3), Math.min(f2, f4), Math.min(f, f3), Math.max(f2, f4), this.mPaintGraph);
    }

    private void drawPathCartesianTicks(Canvas canvas, float f, float f2) {
        Object object = this.mPoints;
        float f3 = object[0];
        float f4 = object[1];
        float f5 = object[((float[])object).length - 2];
        float f6 = object[((float[])object).length - 1];
        float f7 = Math.min(f3, f5);
        float f8 = Math.max(f4, f6);
        float f9 = f - Math.min(f3, f5);
        float f10 = Math.max(f4, f6) - f2;
        object = new StringBuilder();
        ((StringBuilder)object).append("");
        double d = f9 * 100.0f / Math.abs(f5 - f3);
        Double.isNaN(d);
        ((StringBuilder)object).append((float)((int)(d + 0.5)) / 100.0f);
        object = ((StringBuilder)object).toString();
        this.getTextBounds((String)object, this.mTextPaint);
        canvas.drawText((String)object, f9 / 2.0f - (float)(this.mBounds.width() / 2) + f7, f2 - 20.0f, this.mTextPaint);
        canvas.drawLine(f, f2, Math.min(f3, f5), f2, this.mPaintGraph);
        object = new StringBuilder();
        ((StringBuilder)object).append("");
        d = f10 * 100.0f / Math.abs(f6 - f4);
        Double.isNaN(d);
        ((StringBuilder)object).append((float)((int)(d + 0.5)) / 100.0f);
        object = ((StringBuilder)object).toString();
        this.getTextBounds((String)object, this.mTextPaint);
        canvas.drawText((String)object, f + 5.0f, f8 - (f10 / 2.0f - (float)(this.mBounds.height() / 2)), this.mTextPaint);
        canvas.drawLine(f, f2, f, Math.max(f4, f6), this.mPaintGraph);
    }

    private void drawPathRelative(Canvas canvas) {
        float[] fArray = this.mPoints;
        canvas.drawLine(fArray[0], fArray[1], fArray[fArray.length - 2], fArray[fArray.length - 1], this.mPaintGraph);
    }

    private void drawPathRelativeTicks(Canvas canvas, float f, float f2) {
        Object object = this.mPoints;
        float f3 = object[0];
        float f4 = object[1];
        float f5 = object[((float[])object).length - 2];
        float f6 = object[((float[])object).length - 1];
        float f7 = (float)Math.hypot(f3 - f5, f4 - f6);
        float f8 = f5 - f3;
        f5 = f6 - f4;
        f6 = ((f - f3) * f8 + (f2 - f4) * f5) / (f7 * f7);
        object = new Path();
        object.moveTo(f, f2);
        object.lineTo(f3 += f8 * f6, f4 += f6 * f5);
        f6 = (float)Math.hypot(f3 - f, f4 - f2);
        CharSequence charSequence = new StringBuilder();
        charSequence.append("");
        charSequence.append((float)((int)(f6 * 100.0f / f7)) / 100.0f);
        charSequence = charSequence.toString();
        this.getTextBounds((String)charSequence, this.mTextPaint);
        canvas.drawTextOnPath((String)charSequence, (Path)object, f6 / 2.0f - (float)(this.mBounds.width() / 2), -20.0f, this.mTextPaint);
        canvas.drawLine(f, f2, f3, f4, this.mPaintGraph);
    }

    private void drawPathScreenTicks(Canvas canvas, float f, float f2, int n, int n2) {
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("");
        double d = (f - (float)(n / 2)) * 100.0f / (float)(this.this$0.getWidth() - n);
        Double.isNaN(d);
        ((StringBuilder)charSequence).append((float)((int)(d + 0.5)) / 100.0f);
        charSequence = ((StringBuilder)charSequence).toString();
        this.getTextBounds((String)charSequence, this.mTextPaint);
        canvas.drawText((String)charSequence, f / 2.0f - (float)(this.mBounds.width() / 2) + 0.0f, f2 - 20.0f, this.mTextPaint);
        canvas.drawLine(f, f2, Math.min(0.0f, 1.0f), f2, this.mPaintGraph);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("");
        d = (f2 - (float)(n2 / 2)) * 100.0f / (float)(this.this$0.getHeight() - n2);
        Double.isNaN(d);
        ((StringBuilder)charSequence).append((float)((int)(d + 0.5)) / 100.0f);
        charSequence = ((StringBuilder)charSequence).toString();
        this.getTextBounds((String)charSequence, this.mTextPaint);
        canvas.drawText((String)charSequence, f + 5.0f, 0.0f - (f2 / 2.0f - (float)(this.mBounds.height() / 2)), this.mTextPaint);
        canvas.drawLine(f, f2, f, Math.max(0.0f, 1.0f), this.mPaintGraph);
    }

    private void drawRectangle(Canvas canvas, MotionController motionController) {
        this.mPath.reset();
        int n = 0;
        while (true) {
            if (n > 50) {
                this.mPaint.setColor(0x44000000);
                canvas.translate(2.0f, 2.0f);
                canvas.drawPath(this.mPath, this.mPaint);
                canvas.translate(-2.0f, -2.0f);
                this.mPaint.setColor(-65536);
                canvas.drawPath(this.mPath, this.mPaint);
                return;
            }
            motionController.buildRect((float)n / (float)50, this.mRectangle, 0);
            Object object = this.mPath;
            Object object2 = this.mRectangle;
            object.moveTo(object2[0], object2[1]);
            object = this.mPath;
            object2 = this.mRectangle;
            object.lineTo(object2[2], object2[3]);
            object = this.mPath;
            object2 = this.mRectangle;
            object.lineTo(object2[4], object2[5]);
            object2 = this.mPath;
            object = this.mRectangle;
            object2.lineTo((float)object[6], (float)object[7]);
            this.mPath.close();
            ++n;
        }
    }

    private void drawTicks(Canvas canvas, int n, int n2, MotionController object) {
        int n3;
        int n4;
        if (object.mView != null) {
            n4 = object.mView.getWidth();
            n3 = object.mView.getHeight();
        } else {
            n4 = 0;
            n3 = 0;
        }
        int n5 = 1;
        while (true) {
            if (n5 >= n2 - 1) {
                object = this.mPoints;
                if (((MotionController)object).length <= 1) return;
                canvas.drawCircle((float)object[0], (float)object[1], 8.0f, this.mPaintKeyframes);
                object = this.mPoints;
                canvas.drawCircle((float)object[((MotionController)object).length - 2], (float)object[((MotionController)object).length - 1], 8.0f, this.mPaintKeyframes);
                return;
            }
            if (n != 4 || this.mPathMode[n5 - 1] != 0) {
                Object[] objectArray = this.mKeyFramePoints;
                int n6 = n5 * 2;
                float f = objectArray[n6];
                float f2 = objectArray[n6 + 1];
                this.mPath.reset();
                this.mPath.moveTo(f, f2 + 10.0f);
                this.mPath.lineTo(f + 10.0f, f2);
                this.mPath.lineTo(f, f2 - 10.0f);
                this.mPath.lineTo(f - 10.0f, f2);
                this.mPath.close();
                n6 = n5 - 1;
                object.getKeyFrame(n6);
                if (n == 4) {
                    objectArray = this.mPathMode;
                    if (objectArray[n6] == true) {
                        this.drawPathRelativeTicks(canvas, f - 0.0f, f2 - 0.0f);
                    } else if (objectArray[n6] == 2) {
                        this.drawPathCartesianTicks(canvas, f - 0.0f, f2 - 0.0f);
                    } else if (objectArray[n6] == 3) {
                        this.drawPathScreenTicks(canvas, f - 0.0f, f2 - 0.0f, n4, n3);
                    }
                    canvas.drawPath(this.mPath, this.mFillPaint);
                }
                if (n == 2) {
                    this.drawPathRelativeTicks(canvas, f - 0.0f, f2 - 0.0f);
                }
                if (n == 3) {
                    this.drawPathCartesianTicks(canvas, f - 0.0f, f2 - 0.0f);
                }
                if (n == 6) {
                    this.drawPathScreenTicks(canvas, f - 0.0f, f2 - 0.0f, n4, n3);
                }
                canvas.drawPath(this.mPath, this.mFillPaint);
            }
            ++n5;
        }
    }

    private void drawTranslation(Canvas canvas, float f, float f2, float f3, float f4) {
        canvas.drawRect(f, f2, f3, f4, this.mPaintGraph);
        canvas.drawLine(f, f2, f3, f4, this.mPaintGraph);
    }

    public void draw(Canvas canvas, HashMap<View, MotionController> object, int n, int n2) {
        if (object == null) return;
        if (((HashMap)object).size() == 0) return;
        canvas.save();
        if (!this.this$0.isInEditMode() && (n2 & 1) == 2) {
            StringBuilder charSequence = new StringBuilder();
            charSequence.append(this.this$0.getContext().getResources().getResourceName(MotionLayout.access$000((MotionLayout)this.this$0)));
            charSequence.append(":");
            charSequence.append(this.this$0.getProgress());
            String string = charSequence.toString();
            canvas.drawText(string, 10.0f, (float)(this.this$0.getHeight() - 30), this.mTextPaint);
            canvas.drawText(string, 11.0f, (float)(this.this$0.getHeight() - 29), this.mPaint);
        }
        for (MotionController motionController : ((HashMap)object).values()) {
            int n3;
            int n4 = n3 = motionController.getDrawPath();
            if (n2 > 0) {
                n4 = n3;
                if (n3 == 0) {
                    n4 = 1;
                }
            }
            if (n4 == 0) continue;
            this.mKeyFrameCount = motionController.buildKeyFrames(this.mKeyFramePoints, this.mPathMode);
            if (n4 < 1) continue;
            int n5 = n / 16;
            object = this.mPoints;
            if (object == null || ((Object)object).length != n5 * 2) {
                this.mPoints = new float[n5 * 2];
                this.mPath = new Path();
            }
            n3 = this.mShadowTranslate;
            canvas.translate((float)n3, (float)n3);
            this.mPaint.setColor(0x77000000);
            this.mFillPaint.setColor(0x77000000);
            this.mPaintKeyframes.setColor(0x77000000);
            this.mPaintGraph.setColor(0x77000000);
            motionController.buildPath(this.mPoints, n5);
            this.drawAll(canvas, n4, this.mKeyFrameCount, motionController);
            this.mPaint.setColor(-21965);
            this.mPaintKeyframes.setColor(-2067046);
            this.mFillPaint.setColor(-2067046);
            this.mPaintGraph.setColor(-13391360);
            n3 = this.mShadowTranslate;
            canvas.translate((float)(-n3), (float)(-n3));
            this.drawAll(canvas, n4, this.mKeyFrameCount, motionController);
            if (n4 != 5) continue;
            this.drawRectangle(canvas, motionController);
        }
        canvas.restore();
    }

    public void drawAll(Canvas canvas, int n, int n2, MotionController motionController) {
        if (n == 4) {
            this.drawPathAsConfigured(canvas);
        }
        if (n == 2) {
            this.drawPathRelative(canvas);
        }
        if (n == 3) {
            this.drawPathCartesian(canvas);
        }
        this.drawBasicPath(canvas);
        this.drawTicks(canvas, n, n2, motionController);
    }

    void getTextBounds(String string, Paint paint) {
        paint.getTextBounds(string, 0, string.length(), this.mBounds);
    }
}
