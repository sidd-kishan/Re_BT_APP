/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewParent
 *  androidx.transition.R$id
 */
package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import androidx.transition.R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewUtilsBase {
    private static final String TAG = "ViewUtilsBase";
    private static final int VISIBILITY_MASK = 12;
    private static boolean sSetFrameFetched;
    private static Method sSetFrameMethod;
    private static Field sViewFlagsField;
    private static boolean sViewFlagsFieldFetched;
    private float[] mMatrixValues;

    ViewUtilsBase() {
    }

    private void fetchSetFrame() {
        if (sSetFrameFetched) return;
        try {
            Method method;
            sSetFrameMethod = method = View.class.getDeclaredMethod("setFrame", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            method.setAccessible(true);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Log.i((String)TAG, (String)"Failed to retrieve setFrame method", (Throwable)noSuchMethodException);
        }
        sSetFrameFetched = true;
    }

    public void clearNonTransitionAlpha(View view) {
        if (view.getVisibility() != 0) return;
        view.setTag(R.id.save_non_transition_alpha, null);
    }

    public float getTransitionAlpha(View view) {
        Float f = (Float)view.getTag(R.id.save_non_transition_alpha);
        if (f == null) return view.getAlpha();
        return view.getAlpha() / f.floatValue();
    }

    public void saveNonTransitionAlpha(View view) {
        if (view.getTag(R.id.save_non_transition_alpha) != null) return;
        view.setTag(R.id.save_non_transition_alpha, (Object)Float.valueOf(view.getAlpha()));
    }

    public void setAnimationMatrix(View view, Matrix matrix) {
        if (matrix != null && !matrix.isIdentity()) {
            float[] fArray;
            float[] fArray2 = fArray = this.mMatrixValues;
            if (fArray == null) {
                this.mMatrixValues = fArray2 = new float[9];
            }
            matrix.getValues(fArray2);
            float f = fArray2[3];
            float f2 = (float)Math.sqrt(1.0f - f * f);
            int n = fArray2[0] < 0.0f ? -1 : 1;
            float f3 = f2 * (float)n;
            f = (float)Math.toDegrees(Math.atan2(f, f3));
            f2 = fArray2[0] / f3;
            float f4 = fArray2[4] / f3;
            float f5 = fArray2[2];
            f3 = fArray2[5];
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setTranslationX(f5);
            view.setTranslationY(f3);
            view.setRotation(f);
            view.setScaleX(f2);
            view.setScaleY(f4);
        } else {
            view.setPivotX((float)(view.getWidth() / 2));
            view.setPivotY((float)(view.getHeight() / 2));
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
        }
    }

    public void setLeftTopRightBottom(View view, int n, int n2, int n3, int n4) {
        this.fetchSetFrame();
        Method method = sSetFrameMethod;
        if (method == null) return;
        try {
            method.invoke(view, n, n2, n3, n4);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException(invocationTargetException.getCause());
        }
        catch (IllegalAccessException illegalAccessException) {
        }
    }

    public void setTransitionAlpha(View view, float f) {
        Float f2 = (Float)view.getTag(R.id.save_non_transition_alpha);
        if (f2 != null) {
            view.setAlpha(f2.floatValue() * f);
        } else {
            view.setAlpha(f);
        }
    }

    /*
     * Enabled force condition propagation
     */
    public void setTransitionVisibility(View view, int n) {
        Field field;
        if (!sViewFlagsFieldFetched) {
            try {
                sViewFlagsField = field = View.class.getDeclaredField("mViewFlags");
                field.setAccessible(true);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                Log.i((String)TAG, (String)"fetchViewFlagsField: ");
            }
            sViewFlagsFieldFetched = true;
        }
        if ((field = sViewFlagsField) == null) return;
        try {
            int n2 = field.getInt(view);
            sViewFlagsField.setInt(view, n | n2 & 0xFFFFFFF3);
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            return;
        }
    }

    public void transformMatrixToGlobal(View view, Matrix matrix) {
        ViewParent viewParent = view.getParent();
        if (viewParent instanceof View) {
            viewParent = (View)viewParent;
            this.transformMatrixToGlobal((View)viewParent, matrix);
            matrix.preTranslate((float)(-viewParent.getScrollX()), (float)(-viewParent.getScrollY()));
        }
        matrix.preTranslate((float)view.getLeft(), (float)view.getTop());
        view = view.getMatrix();
        if (view.isIdentity()) return;
        matrix.preConcat((Matrix)view);
    }

    public void transformMatrixToLocal(View view, Matrix matrix) {
        ViewParent viewParent = view.getParent();
        if (viewParent instanceof View) {
            viewParent = (View)viewParent;
            this.transformMatrixToLocal((View)viewParent, matrix);
            matrix.postTranslate((float)viewParent.getScrollX(), (float)viewParent.getScrollY());
        }
        matrix.postTranslate((float)(-view.getLeft()), (float)(-view.getTop()));
        viewParent = view.getMatrix();
        if (viewParent.isIdentity()) return;
        view = new Matrix();
        if (!viewParent.invert((Matrix)view)) return;
        matrix.postConcat((Matrix)view);
    }
}
