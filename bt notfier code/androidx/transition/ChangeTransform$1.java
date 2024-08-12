/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Property
 *  androidx.transition.ChangeTransform$PathAnimatorMatrix
 */
package androidx.transition;

import android.util.Property;
import androidx.transition.ChangeTransform;

class ChangeTransform.1
extends Property<ChangeTransform.PathAnimatorMatrix, float[]> {
    ChangeTransform.1(Class clazz, String string) {
        super(clazz, string);
    }

    public float[] get(ChangeTransform.PathAnimatorMatrix pathAnimatorMatrix) {
        return null;
    }

    public void set(ChangeTransform.PathAnimatorMatrix pathAnimatorMatrix, float[] fArray) {
        pathAnimatorMatrix.setValues(fArray);
    }
}
