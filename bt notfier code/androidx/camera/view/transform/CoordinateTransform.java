/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.util.Size
 *  androidx.camera.core.Logger
 *  androidx.camera.view.TransformUtils
 *  androidx.camera.view.transform.OutputTransform
 */
package androidx.camera.view.transform;

import android.graphics.Matrix;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.view.TransformUtils;
import androidx.camera.view.transform.OutputTransform;

public class CoordinateTransform {
    private static final String MISMATCH_MSG = "The source viewport (%s) does not match the target viewport (%s). Please make sure they are from the same UseCaseGroup.";
    private static final String TAG = "CoordinateTransform";
    private final Matrix mMatrix;

    public CoordinateTransform(OutputTransform outputTransform, OutputTransform outputTransform2) {
        if (!TransformUtils.isAspectRatioMatchingWithRoundingError((Size)outputTransform.getViewPortSize(), (boolean)false, (Size)outputTransform2.getViewPortSize(), (boolean)false)) {
            Logger.w((String)TAG, (String)String.format(MISMATCH_MSG, outputTransform.getViewPortSize(), outputTransform2.getViewPortSize()));
        }
        this.mMatrix = new Matrix();
        outputTransform.getMatrix().invert(this.mMatrix);
        this.mMatrix.postConcat(outputTransform2.getMatrix());
    }

    public void getTransform(Matrix matrix) {
        matrix.set(this.mMatrix);
    }

    public void mapPoints(float[] fArray) {
        this.mMatrix.mapPoints(fArray);
    }
}
