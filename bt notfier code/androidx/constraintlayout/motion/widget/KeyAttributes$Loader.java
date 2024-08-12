/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.TypedArray
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.SparseIntArray
 *  androidx.constraintlayout.motion.widget.KeyAttributes
 *  androidx.constraintlayout.motion.widget.MotionLayout
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.os.Build;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.KeyAttributes;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;

/*
 * Exception performing whole class analysis ignored.
 */
private static class KeyAttributes.Loader {
    private static final int ANDROID_ALPHA = 1;
    private static final int ANDROID_ELEVATION = 2;
    private static final int ANDROID_PIVOT_X = 19;
    private static final int ANDROID_PIVOT_Y = 20;
    private static final int ANDROID_ROTATION = 4;
    private static final int ANDROID_ROTATION_X = 5;
    private static final int ANDROID_ROTATION_Y = 6;
    private static final int ANDROID_SCALE_X = 7;
    private static final int ANDROID_SCALE_Y = 14;
    private static final int ANDROID_TRANSLATION_X = 15;
    private static final int ANDROID_TRANSLATION_Y = 16;
    private static final int ANDROID_TRANSLATION_Z = 17;
    private static final int CURVE_FIT = 13;
    private static final int FRAME_POSITION = 12;
    private static final int PROGRESS = 18;
    private static final int TARGET_ID = 10;
    private static final int TRANSITION_EASING = 9;
    private static final int TRANSITION_PATH_ROTATE = 8;
    private static SparseIntArray mAttrMap;

    static {
        SparseIntArray sparseIntArray;
        mAttrMap = sparseIntArray = new SparseIntArray();
        sparseIntArray.append(R.styleable.KeyAttribute_android_alpha, 1);
        mAttrMap.append(R.styleable.KeyAttribute_android_elevation, 2);
        mAttrMap.append(R.styleable.KeyAttribute_android_rotation, 4);
        mAttrMap.append(R.styleable.KeyAttribute_android_rotationX, 5);
        mAttrMap.append(R.styleable.KeyAttribute_android_rotationY, 6);
        mAttrMap.append(R.styleable.KeyAttribute_android_transformPivotX, 19);
        mAttrMap.append(R.styleable.KeyAttribute_android_transformPivotY, 20);
        mAttrMap.append(R.styleable.KeyAttribute_android_scaleX, 7);
        mAttrMap.append(R.styleable.KeyAttribute_transitionPathRotate, 8);
        mAttrMap.append(R.styleable.KeyAttribute_transitionEasing, 9);
        mAttrMap.append(R.styleable.KeyAttribute_motionTarget, 10);
        mAttrMap.append(R.styleable.KeyAttribute_framePosition, 12);
        mAttrMap.append(R.styleable.KeyAttribute_curveFit, 13);
        mAttrMap.append(R.styleable.KeyAttribute_android_scaleY, 14);
        mAttrMap.append(R.styleable.KeyAttribute_android_translationX, 15);
        mAttrMap.append(R.styleable.KeyAttribute_android_translationY, 16);
        mAttrMap.append(R.styleable.KeyAttribute_android_translationZ, 17);
        mAttrMap.append(R.styleable.KeyAttribute_motionProgress, 18);
    }

    private KeyAttributes.Loader() {
    }

    public static void read(KeyAttributes keyAttributes, TypedArray typedArray) {
        int n = typedArray.getIndexCount();
        int n2 = 0;
        while (n2 < n) {
            int n3 = typedArray.getIndex(n2);
            switch (mAttrMap.get(n3)) {
                default: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("unused attribute 0x");
                    stringBuilder.append(Integer.toHexString(n3));
                    stringBuilder.append("   ");
                    stringBuilder.append(mAttrMap.get(n3));
                    Log.e((String)"KeyAttribute", (String)stringBuilder.toString());
                    break;
                }
                case 20: {
                    KeyAttributes.access$802((KeyAttributes)keyAttributes, (float)typedArray.getDimension(n3, KeyAttributes.access$800((KeyAttributes)keyAttributes)));
                    break;
                }
                case 19: {
                    KeyAttributes.access$702((KeyAttributes)keyAttributes, (float)typedArray.getDimension(n3, KeyAttributes.access$700((KeyAttributes)keyAttributes)));
                    break;
                }
                case 18: {
                    KeyAttributes.access$1502((KeyAttributes)keyAttributes, (float)typedArray.getFloat(n3, KeyAttributes.access$1500((KeyAttributes)keyAttributes)));
                    break;
                }
                case 17: {
                    if (Build.VERSION.SDK_INT < 21) break;
                    KeyAttributes.access$1402((KeyAttributes)keyAttributes, (float)typedArray.getDimension(n3, KeyAttributes.access$1400((KeyAttributes)keyAttributes)));
                    break;
                }
                case 16: {
                    KeyAttributes.access$1302((KeyAttributes)keyAttributes, (float)typedArray.getDimension(n3, KeyAttributes.access$1300((KeyAttributes)keyAttributes)));
                    break;
                }
                case 15: {
                    KeyAttributes.access$1202((KeyAttributes)keyAttributes, (float)typedArray.getDimension(n3, KeyAttributes.access$1200((KeyAttributes)keyAttributes)));
                    break;
                }
                case 14: {
                    KeyAttributes.access$1002((KeyAttributes)keyAttributes, (float)typedArray.getFloat(n3, KeyAttributes.access$1000((KeyAttributes)keyAttributes)));
                    break;
                }
                case 13: {
                    KeyAttributes.access$302((KeyAttributes)keyAttributes, (int)typedArray.getInteger(n3, KeyAttributes.access$300((KeyAttributes)keyAttributes)));
                    break;
                }
                case 12: {
                    keyAttributes.mFramePosition = typedArray.getInt(n3, keyAttributes.mFramePosition);
                    break;
                }
                case 10: {
                    if (MotionLayout.IS_IN_EDIT_MODE) {
                        keyAttributes.mTargetId = typedArray.getResourceId(n3, keyAttributes.mTargetId);
                        if (keyAttributes.mTargetId != -1) break;
                        keyAttributes.mTargetString = typedArray.getString(n3);
                        break;
                    }
                    if (typedArray.peekValue((int)n3).type == 3) {
                        keyAttributes.mTargetString = typedArray.getString(n3);
                        break;
                    }
                    keyAttributes.mTargetId = typedArray.getResourceId(n3, keyAttributes.mTargetId);
                    break;
                }
                case 9: {
                    KeyAttributes.access$902((KeyAttributes)keyAttributes, (String)typedArray.getString(n3));
                    break;
                }
                case 8: {
                    KeyAttributes.access$1102((KeyAttributes)keyAttributes, (float)typedArray.getFloat(n3, KeyAttributes.access$1100((KeyAttributes)keyAttributes)));
                    break;
                }
                case 7: {
                    KeyAttributes.access$402((KeyAttributes)keyAttributes, (float)typedArray.getFloat(n3, KeyAttributes.access$400((KeyAttributes)keyAttributes)));
                    break;
                }
                case 6: {
                    KeyAttributes.access$602((KeyAttributes)keyAttributes, (float)typedArray.getFloat(n3, KeyAttributes.access$600((KeyAttributes)keyAttributes)));
                    break;
                }
                case 5: {
                    KeyAttributes.access$502((KeyAttributes)keyAttributes, (float)typedArray.getFloat(n3, KeyAttributes.access$500((KeyAttributes)keyAttributes)));
                    break;
                }
                case 4: {
                    KeyAttributes.access$202((KeyAttributes)keyAttributes, (float)typedArray.getFloat(n3, KeyAttributes.access$200((KeyAttributes)keyAttributes)));
                    break;
                }
                case 2: {
                    KeyAttributes.access$102((KeyAttributes)keyAttributes, (float)typedArray.getDimension(n3, KeyAttributes.access$100((KeyAttributes)keyAttributes)));
                    break;
                }
                case 1: {
                    KeyAttributes.access$002((KeyAttributes)keyAttributes, (float)typedArray.getFloat(n3, KeyAttributes.access$000((KeyAttributes)keyAttributes)));
                }
            }
            ++n2;
        }
    }
}
