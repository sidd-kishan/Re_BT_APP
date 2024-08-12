/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.util.Property
 *  android.widget.ImageView
 *  androidx.transition.ImageViewUtils
 */
package androidx.transition;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import androidx.transition.ImageViewUtils;

class ChangeImageTransform.2
extends Property<ImageView, Matrix> {
    ChangeImageTransform.2(Class clazz, String string) {
        super(clazz, string);
    }

    public Matrix get(ImageView imageView) {
        return null;
    }

    public void set(ImageView imageView, Matrix matrix) {
        ImageViewUtils.animateTransform((ImageView)imageView, (Matrix)matrix);
    }
}
