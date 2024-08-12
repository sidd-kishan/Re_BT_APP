/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.TypedArray
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.SparseIntArray
 *  androidx.constraintlayout.motion.widget.KeyTimeCycle
 *  androidx.constraintlayout.motion.widget.MotionLayout
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.os.Build;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.KeyTimeCycle;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;

/*
 * Exception performing whole class analysis ignored.
 */
private static class KeyTimeCycle.Loader {
    private static final int ANDROID_ALPHA = 1;
    private static final int ANDROID_ELEVATION = 2;
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
    private static final int WAVE_OFFSET = 21;
    private static final int WAVE_PERIOD = 20;
    private static final int WAVE_SHAPE = 19;
    private static SparseIntArray mAttrMap;

    static {
        SparseIntArray sparseIntArray;
        mAttrMap = sparseIntArray = new SparseIntArray();
        sparseIntArray.append(R.styleable.KeyTimeCycle_android_alpha, 1);
        mAttrMap.append(R.styleable.KeyTimeCycle_android_elevation, 2);
        mAttrMap.append(R.styleable.KeyTimeCycle_android_rotation, 4);
        mAttrMap.append(R.styleable.KeyTimeCycle_android_rotationX, 5);
        mAttrMap.append(R.styleable.KeyTimeCycle_android_rotationY, 6);
        mAttrMap.append(R.styleable.KeyTimeCycle_android_scaleX, 7);
        mAttrMap.append(R.styleable.KeyTimeCycle_transitionPathRotate, 8);
        mAttrMap.append(R.styleable.KeyTimeCycle_transitionEasing, 9);
        mAttrMap.append(R.styleable.KeyTimeCycle_motionTarget, 10);
        mAttrMap.append(R.styleable.KeyTimeCycle_framePosition, 12);
        mAttrMap.append(R.styleable.KeyTimeCycle_curveFit, 13);
        mAttrMap.append(R.styleable.KeyTimeCycle_android_scaleY, 14);
        mAttrMap.append(R.styleable.KeyTimeCycle_android_translationX, 15);
        mAttrMap.append(R.styleable.KeyTimeCycle_android_translationY, 16);
        mAttrMap.append(R.styleable.KeyTimeCycle_android_translationZ, 17);
        mAttrMap.append(R.styleable.KeyTimeCycle_motionProgress, 18);
        mAttrMap.append(R.styleable.KeyTimeCycle_wavePeriod, 20);
        mAttrMap.append(R.styleable.KeyTimeCycle_waveOffset, 21);
        mAttrMap.append(R.styleable.KeyTimeCycle_waveShape, 19);
    }

    private KeyTimeCycle.Loader() {
    }

    public static void read(KeyTimeCycle keyTimeCycle, TypedArray typedArray) {
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
                    Log.e((String)"KeyTimeCycle", (String)stringBuilder.toString());
                    break;
                }
                case 21: {
                    if (typedArray.peekValue((int)n3).type == 5) {
                        KeyTimeCycle.access$602((KeyTimeCycle)keyTimeCycle, (float)typedArray.getDimension(n3, KeyTimeCycle.access$600((KeyTimeCycle)keyTimeCycle)));
                        break;
                    }
                    KeyTimeCycle.access$602((KeyTimeCycle)keyTimeCycle, (float)typedArray.getFloat(n3, KeyTimeCycle.access$600((KeyTimeCycle)keyTimeCycle)));
                    break;
                }
                case 20: {
                    KeyTimeCycle.access$502((KeyTimeCycle)keyTimeCycle, (float)typedArray.getFloat(n3, KeyTimeCycle.access$500((KeyTimeCycle)keyTimeCycle)));
                    break;
                }
                case 19: {
                    KeyTimeCycle.access$402((KeyTimeCycle)keyTimeCycle, (int)typedArray.getInt(n3, KeyTimeCycle.access$400((KeyTimeCycle)keyTimeCycle)));
                    break;
                }
                case 18: {
                    KeyTimeCycle.access$1602((KeyTimeCycle)keyTimeCycle, (float)typedArray.getFloat(n3, KeyTimeCycle.access$1600((KeyTimeCycle)keyTimeCycle)));
                    break;
                }
                case 17: {
                    if (Build.VERSION.SDK_INT < 21) break;
                    KeyTimeCycle.access$1502((KeyTimeCycle)keyTimeCycle, (float)typedArray.getDimension(n3, KeyTimeCycle.access$1500((KeyTimeCycle)keyTimeCycle)));
                    break;
                }
                case 16: {
                    KeyTimeCycle.access$1402((KeyTimeCycle)keyTimeCycle, (float)typedArray.getDimension(n3, KeyTimeCycle.access$1400((KeyTimeCycle)keyTimeCycle)));
                    break;
                }
                case 15: {
                    KeyTimeCycle.access$1302((KeyTimeCycle)keyTimeCycle, (float)typedArray.getDimension(n3, KeyTimeCycle.access$1300((KeyTimeCycle)keyTimeCycle)));
                    break;
                }
                case 14: {
                    KeyTimeCycle.access$1102((KeyTimeCycle)keyTimeCycle, (float)typedArray.getFloat(n3, KeyTimeCycle.access$1100((KeyTimeCycle)keyTimeCycle)));
                    break;
                }
                case 13: {
                    KeyTimeCycle.access$302((KeyTimeCycle)keyTimeCycle, (int)typedArray.getInteger(n3, KeyTimeCycle.access$300((KeyTimeCycle)keyTimeCycle)));
                    break;
                }
                case 12: {
                    keyTimeCycle.mFramePosition = typedArray.getInt(n3, keyTimeCycle.mFramePosition);
                    break;
                }
                case 10: {
                    if (MotionLayout.IS_IN_EDIT_MODE) {
                        keyTimeCycle.mTargetId = typedArray.getResourceId(n3, keyTimeCycle.mTargetId);
                        if (keyTimeCycle.mTargetId != -1) break;
                        keyTimeCycle.mTargetString = typedArray.getString(n3);
                        break;
                    }
                    if (typedArray.peekValue((int)n3).type == 3) {
                        keyTimeCycle.mTargetString = typedArray.getString(n3);
                        break;
                    }
                    keyTimeCycle.mTargetId = typedArray.getResourceId(n3, keyTimeCycle.mTargetId);
                    break;
                }
                case 9: {
                    KeyTimeCycle.access$1002((KeyTimeCycle)keyTimeCycle, (String)typedArray.getString(n3));
                    break;
                }
                case 8: {
                    KeyTimeCycle.access$1202((KeyTimeCycle)keyTimeCycle, (float)typedArray.getFloat(n3, KeyTimeCycle.access$1200((KeyTimeCycle)keyTimeCycle)));
                    break;
                }
                case 7: {
                    KeyTimeCycle.access$702((KeyTimeCycle)keyTimeCycle, (float)typedArray.getFloat(n3, KeyTimeCycle.access$700((KeyTimeCycle)keyTimeCycle)));
                    break;
                }
                case 6: {
                    KeyTimeCycle.access$902((KeyTimeCycle)keyTimeCycle, (float)typedArray.getFloat(n3, KeyTimeCycle.access$900((KeyTimeCycle)keyTimeCycle)));
                    break;
                }
                case 5: {
                    KeyTimeCycle.access$802((KeyTimeCycle)keyTimeCycle, (float)typedArray.getFloat(n3, KeyTimeCycle.access$800((KeyTimeCycle)keyTimeCycle)));
                    break;
                }
                case 4: {
                    KeyTimeCycle.access$202((KeyTimeCycle)keyTimeCycle, (float)typedArray.getFloat(n3, KeyTimeCycle.access$200((KeyTimeCycle)keyTimeCycle)));
                    break;
                }
                case 2: {
                    KeyTimeCycle.access$102((KeyTimeCycle)keyTimeCycle, (float)typedArray.getDimension(n3, KeyTimeCycle.access$100((KeyTimeCycle)keyTimeCycle)));
                    break;
                }
                case 1: {
                    KeyTimeCycle.access$002((KeyTimeCycle)keyTimeCycle, (float)typedArray.getFloat(n3, KeyTimeCycle.access$000((KeyTimeCycle)keyTimeCycle)));
                }
            }
            ++n2;
        }
    }
}
