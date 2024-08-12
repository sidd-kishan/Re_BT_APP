/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Matrix$ScaleToFit
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.util.Size
 */
package androidx.camera.view;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;

public class TransformUtils {
    public static final RectF NORMALIZED_RECT = new RectF(-1.0f, -1.0f, 1.0f, 1.0f);

    private TransformUtils() {
    }

    public static Matrix getExifTransform(int n, int n2, int n3) {
        RectF rectF;
        float f;
        float f2;
        Matrix matrix;
        block10: {
            matrix = new Matrix();
            f2 = n2;
            f = n3;
            rectF = new RectF(0.0f, 0.0f, f2, f);
            matrix.setRectToRect(rectF, NORMALIZED_RECT, Matrix.ScaleToFit.FILL);
            n2 = 1;
            switch (n) {
                default: {
                    break;
                }
                case 8: {
                    matrix.postRotate(270.0f);
                    n = n2;
                    break block10;
                }
                case 7: {
                    matrix.postScale(-1.0f, 1.0f);
                    matrix.postRotate(90.0f);
                    n = n2;
                    break block10;
                }
                case 6: {
                    matrix.postRotate(90.0f);
                    n = n2;
                    break block10;
                }
                case 5: {
                    matrix.postScale(-1.0f, 1.0f);
                    matrix.postRotate(270.0f);
                    n = n2;
                    break block10;
                }
                case 4: {
                    matrix.postScale(1.0f, -1.0f);
                    break;
                }
                case 3: {
                    matrix.postRotate(180.0f);
                    break;
                }
                case 2: {
                    matrix.postScale(-1.0f, 1.0f);
                }
            }
            n = 0;
        }
        if (n != 0) {
            rectF = new RectF(0.0f, 0.0f, f, f2);
        }
        Matrix matrix2 = new Matrix();
        matrix2.setRectToRect(NORMALIZED_RECT, rectF, Matrix.ScaleToFit.FILL);
        matrix.postConcat(matrix2);
        return matrix;
    }

    public static Matrix getNormalizedToBuffer(Rect rect) {
        return TransformUtils.getNormalizedToBuffer(new RectF(rect));
    }

    private static Matrix getNormalizedToBuffer(RectF rectF) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(NORMALIZED_RECT, rectF, Matrix.ScaleToFit.FILL);
        return matrix;
    }

    public static Matrix getRectToRect(RectF rectF, RectF rectF2, int n) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF, NORMALIZED_RECT, Matrix.ScaleToFit.FILL);
        matrix.postRotate((float)n);
        matrix.postConcat(TransformUtils.getNormalizedToBuffer(rectF2));
        return matrix;
    }

    public static boolean is90or270(int n) {
        if (n == 90) return true;
        if (n == 270) {
            return true;
        }
        if (n == 0) return false;
        if (n == 180) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid rotation degrees: ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static boolean isAspectRatioMatchingWithRoundingError(Size size, boolean bl, Size size2, boolean bl2) {
        float f;
        float f2;
        float f3;
        float f4;
        if (bl) {
            f3 = f4 = (float)size.getWidth() / (float)size.getHeight();
        } else {
            f4 = ((float)size.getWidth() + 1.0f) / ((float)size.getHeight() - 1.0f);
            f3 = ((float)size.getWidth() - 1.0f) / ((float)size.getHeight() + 1.0f);
        }
        if (bl2) {
            f = f2 = (float)size2.getWidth() / (float)size2.getHeight();
        } else {
            f = ((float)size2.getWidth() + 1.0f) / ((float)size2.getHeight() - 1.0f);
            f2 = ((float)size2.getWidth() - 1.0f) / ((float)size2.getHeight() + 1.0f);
        }
        bl = f4 >= f2 && f >= f3;
        return bl;
    }

    public static float max(float f, float f2, float f3, float f4) {
        return Math.max(Math.max(f, f2), Math.max(f3, f4));
    }

    public static float min(float f, float f2, float f3, float f4) {
        return Math.min(Math.min(f, f2), Math.min(f3, f4));
    }

    public static Size rectToSize(Rect rect) {
        return new Size(rect.width(), rect.height());
    }

    public static float[] rectToVertices(RectF rectF) {
        return new float[]{rectF.left, rectF.top, rectF.right, rectF.top, rectF.right, rectF.bottom, rectF.left, rectF.bottom};
    }

    public static float[] sizeToVertices(Size size) {
        return new float[]{0.0f, 0.0f, size.getWidth(), 0.0f, size.getWidth(), size.getHeight(), 0.0f, size.getHeight()};
    }

    public static int surfaceRotationToRotationDegrees(int n) {
        if (n == 0) return 0;
        if (n == 1) return 90;
        if (n == 2) return 180;
        if (n == 3) {
            return 270;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected rotation value ");
        stringBuilder.append(n);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public static RectF verticesToRect(float[] fArray) {
        return new RectF(TransformUtils.min(fArray[0], fArray[2], fArray[4], fArray[6]), TransformUtils.min(fArray[1], fArray[3], fArray[5], fArray[7]), TransformUtils.max(fArray[0], fArray[2], fArray[4], fArray[6]), TransformUtils.max(fArray[1], fArray[3], fArray[5], fArray[7]));
    }
}
