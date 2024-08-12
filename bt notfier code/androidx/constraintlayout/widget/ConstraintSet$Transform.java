/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.SparseIntArray
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R;

public static class ConstraintSet.Transform {
    private static final int ELEVATION = 11;
    private static final int ROTATION = 1;
    private static final int ROTATION_X = 2;
    private static final int ROTATION_Y = 3;
    private static final int SCALE_X = 4;
    private static final int SCALE_Y = 5;
    private static final int TRANSFORM_PIVOT_X = 6;
    private static final int TRANSFORM_PIVOT_Y = 7;
    private static final int TRANSLATION_X = 8;
    private static final int TRANSLATION_Y = 9;
    private static final int TRANSLATION_Z = 10;
    private static SparseIntArray mapToConstant;
    public boolean applyElevation = false;
    public float elevation = 0.0f;
    public boolean mApply = false;
    public float rotation = 0.0f;
    public float rotationX = 0.0f;
    public float rotationY = 0.0f;
    public float scaleX = 1.0f;
    public float scaleY = 1.0f;
    public float transformPivotX = Float.NaN;
    public float transformPivotY = Float.NaN;
    public float translationX = 0.0f;
    public float translationY = 0.0f;
    public float translationZ = 0.0f;

    static {
        SparseIntArray sparseIntArray;
        mapToConstant = sparseIntArray = new SparseIntArray();
        sparseIntArray.append(R.styleable.Transform_android_rotation, 1);
        mapToConstant.append(R.styleable.Transform_android_rotationX, 2);
        mapToConstant.append(R.styleable.Transform_android_rotationY, 3);
        mapToConstant.append(R.styleable.Transform_android_scaleX, 4);
        mapToConstant.append(R.styleable.Transform_android_scaleY, 5);
        mapToConstant.append(R.styleable.Transform_android_transformPivotX, 6);
        mapToConstant.append(R.styleable.Transform_android_transformPivotY, 7);
        mapToConstant.append(R.styleable.Transform_android_translationX, 8);
        mapToConstant.append(R.styleable.Transform_android_translationY, 9);
        mapToConstant.append(R.styleable.Transform_android_translationZ, 10);
        mapToConstant.append(R.styleable.Transform_android_elevation, 11);
    }

    public void copyFrom(ConstraintSet.Transform transform) {
        this.mApply = transform.mApply;
        this.rotation = transform.rotation;
        this.rotationX = transform.rotationX;
        this.rotationY = transform.rotationY;
        this.scaleX = transform.scaleX;
        this.scaleY = transform.scaleY;
        this.transformPivotX = transform.transformPivotX;
        this.transformPivotY = transform.transformPivotY;
        this.translationX = transform.translationX;
        this.translationY = transform.translationY;
        this.translationZ = transform.translationZ;
        this.applyElevation = transform.applyElevation;
        this.elevation = transform.elevation;
    }

    void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        context = context.obtainStyledAttributes(attributeSet, R.styleable.Transform);
        this.mApply = true;
        int n = context.getIndexCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                context.recycle();
                return;
            }
            int n3 = context.getIndex(n2);
            switch (mapToConstant.get(n3)) {
                default: {
                    break;
                }
                case 11: {
                    if (Build.VERSION.SDK_INT < 21) break;
                    this.applyElevation = true;
                    this.elevation = context.getDimension(n3, this.elevation);
                    break;
                }
                case 10: {
                    if (Build.VERSION.SDK_INT < 21) break;
                    this.translationZ = context.getDimension(n3, this.translationZ);
                    break;
                }
                case 9: {
                    this.translationY = context.getDimension(n3, this.translationY);
                    break;
                }
                case 8: {
                    this.translationX = context.getDimension(n3, this.translationX);
                    break;
                }
                case 7: {
                    this.transformPivotY = context.getDimension(n3, this.transformPivotY);
                    break;
                }
                case 6: {
                    this.transformPivotX = context.getDimension(n3, this.transformPivotX);
                    break;
                }
                case 5: {
                    this.scaleY = context.getFloat(n3, this.scaleY);
                    break;
                }
                case 4: {
                    this.scaleX = context.getFloat(n3, this.scaleX);
                    break;
                }
                case 3: {
                    this.rotationY = context.getFloat(n3, this.rotationY);
                    break;
                }
                case 2: {
                    this.rotationX = context.getFloat(n3, this.rotationX);
                    break;
                }
                case 1: {
                    this.rotation = context.getFloat(n3, this.rotation);
                }
            }
            ++n2;
        }
    }
}
