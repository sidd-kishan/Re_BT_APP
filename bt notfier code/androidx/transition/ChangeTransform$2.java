/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.util.Property
 *  androidx.transition.ChangeTransform$PathAnimatorMatrix
 */
package androidx.transition;

import android.graphics.PointF;
import android.util.Property;
import androidx.transition.ChangeTransform;

class ChangeTransform.2
extends Property<ChangeTransform.PathAnimatorMatrix, PointF> {
    ChangeTransform.2(Class clazz, String string) {
        super(clazz, string);
    }

    public PointF get(ChangeTransform.PathAnimatorMatrix pathAnimatorMatrix) {
        return null;
    }

    public void set(ChangeTransform.PathAnimatorMatrix pathAnimatorMatrix, PointF pointF) {
        pathAnimatorMatrix.setTranslation(pointF);
    }
}
