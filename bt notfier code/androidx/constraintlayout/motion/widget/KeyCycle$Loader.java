/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.TypedArray
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.SparseIntArray
 *  androidx.constraintlayout.motion.widget.KeyCycle
 *  androidx.constraintlayout.motion.widget.MotionLayout
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.os.Build;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.KeyCycle;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;

/*
 * Exception performing whole class analysis ignored.
 */
private static class KeyCycle.Loader {
    private static final int ANDROID_ALPHA = 9;
    private static final int ANDROID_ELEVATION = 10;
    private static final int ANDROID_ROTATION = 11;
    private static final int ANDROID_ROTATION_X = 12;
    private static final int ANDROID_ROTATION_Y = 13;
    private static final int ANDROID_SCALE_X = 15;
    private static final int ANDROID_SCALE_Y = 16;
    private static final int ANDROID_TRANSLATION_X = 17;
    private static final int ANDROID_TRANSLATION_Y = 18;
    private static final int ANDROID_TRANSLATION_Z = 19;
    private static final int CURVE_FIT = 4;
    private static final int FRAME_POSITION = 2;
    private static final int PROGRESS = 20;
    private static final int TARGET_ID = 1;
    private static final int TRANSITION_EASING = 3;
    private static final int TRANSITION_PATH_ROTATE = 14;
    private static final int WAVE_OFFSET = 7;
    private static final int WAVE_PERIOD = 6;
    private static final int WAVE_SHAPE = 5;
    private static final int WAVE_VARIES_BY = 8;
    private static SparseIntArray mAttrMap;

    static {
        SparseIntArray sparseIntArray;
        mAttrMap = sparseIntArray = new SparseIntArray();
        sparseIntArray.append(R.styleable.KeyCycle_motionTarget, 1);
        mAttrMap.append(R.styleable.KeyCycle_framePosition, 2);
        mAttrMap.append(R.styleable.KeyCycle_transitionEasing, 3);
        mAttrMap.append(R.styleable.KeyCycle_curveFit, 4);
        mAttrMap.append(R.styleable.KeyCycle_waveShape, 5);
        mAttrMap.append(R.styleable.KeyCycle_wavePeriod, 6);
        mAttrMap.append(R.styleable.KeyCycle_waveOffset, 7);
        mAttrMap.append(R.styleable.KeyCycle_waveVariesBy, 8);
        mAttrMap.append(R.styleable.KeyCycle_android_alpha, 9);
        mAttrMap.append(R.styleable.KeyCycle_android_elevation, 10);
        mAttrMap.append(R.styleable.KeyCycle_android_rotation, 11);
        mAttrMap.append(R.styleable.KeyCycle_android_rotationX, 12);
        mAttrMap.append(R.styleable.KeyCycle_android_rotationY, 13);
        mAttrMap.append(R.styleable.KeyCycle_transitionPathRotate, 14);
        mAttrMap.append(R.styleable.KeyCycle_android_scaleX, 15);
        mAttrMap.append(R.styleable.KeyCycle_android_scaleY, 16);
        mAttrMap.append(R.styleable.KeyCycle_android_translationX, 17);
        mAttrMap.append(R.styleable.KeyCycle_android_translationY, 18);
        mAttrMap.append(R.styleable.KeyCycle_android_translationZ, 19);
        mAttrMap.append(R.styleable.KeyCycle_motionProgress, 20);
    }

    private KeyCycle.Loader() {
    }

    static /* synthetic */ void access$000(KeyCycle keyCycle, TypedArray typedArray) {
        KeyCycle.Loader.read(keyCycle, typedArray);
    }

    private static void read(KeyCycle keyCycle, TypedArray typedArray) {
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
                    Log.e((String)"KeyCycle", (String)stringBuilder.toString());
                    break;
                }
                case 20: {
                    KeyCycle.access$1802((KeyCycle)keyCycle, (float)typedArray.getFloat(n3, KeyCycle.access$1800((KeyCycle)keyCycle)));
                    break;
                }
                case 19: {
                    if (Build.VERSION.SDK_INT < 21) break;
                    KeyCycle.access$1702((KeyCycle)keyCycle, (float)typedArray.getDimension(n3, KeyCycle.access$1700((KeyCycle)keyCycle)));
                    break;
                }
                case 18: {
                    KeyCycle.access$1602((KeyCycle)keyCycle, (float)typedArray.getDimension(n3, KeyCycle.access$1600((KeyCycle)keyCycle)));
                    break;
                }
                case 17: {
                    KeyCycle.access$1502((KeyCycle)keyCycle, (float)typedArray.getDimension(n3, KeyCycle.access$1500((KeyCycle)keyCycle)));
                    break;
                }
                case 16: {
                    KeyCycle.access$1402((KeyCycle)keyCycle, (float)typedArray.getFloat(n3, KeyCycle.access$1400((KeyCycle)keyCycle)));
                    break;
                }
                case 15: {
                    KeyCycle.access$1302((KeyCycle)keyCycle, (float)typedArray.getFloat(n3, KeyCycle.access$1300((KeyCycle)keyCycle)));
                    break;
                }
                case 14: {
                    KeyCycle.access$1202((KeyCycle)keyCycle, (float)typedArray.getFloat(n3, KeyCycle.access$1200((KeyCycle)keyCycle)));
                    break;
                }
                case 13: {
                    KeyCycle.access$1102((KeyCycle)keyCycle, (float)typedArray.getFloat(n3, KeyCycle.access$1100((KeyCycle)keyCycle)));
                    break;
                }
                case 12: {
                    KeyCycle.access$1002((KeyCycle)keyCycle, (float)typedArray.getFloat(n3, KeyCycle.access$1000((KeyCycle)keyCycle)));
                    break;
                }
                case 11: {
                    KeyCycle.access$902((KeyCycle)keyCycle, (float)typedArray.getFloat(n3, KeyCycle.access$900((KeyCycle)keyCycle)));
                    break;
                }
                case 10: {
                    KeyCycle.access$802((KeyCycle)keyCycle, (float)typedArray.getDimension(n3, KeyCycle.access$800((KeyCycle)keyCycle)));
                    break;
                }
                case 9: {
                    KeyCycle.access$702((KeyCycle)keyCycle, (float)typedArray.getFloat(n3, KeyCycle.access$700((KeyCycle)keyCycle)));
                    break;
                }
                case 8: {
                    KeyCycle.access$602((KeyCycle)keyCycle, (int)typedArray.getInt(n3, KeyCycle.access$600((KeyCycle)keyCycle)));
                    break;
                }
                case 7: {
                    if (typedArray.peekValue((int)n3).type == 5) {
                        KeyCycle.access$502((KeyCycle)keyCycle, (float)typedArray.getDimension(n3, KeyCycle.access$500((KeyCycle)keyCycle)));
                        break;
                    }
                    KeyCycle.access$502((KeyCycle)keyCycle, (float)typedArray.getFloat(n3, KeyCycle.access$500((KeyCycle)keyCycle)));
                    break;
                }
                case 6: {
                    KeyCycle.access$402((KeyCycle)keyCycle, (float)typedArray.getFloat(n3, KeyCycle.access$400((KeyCycle)keyCycle)));
                    break;
                }
                case 5: {
                    KeyCycle.access$302((KeyCycle)keyCycle, (int)typedArray.getInt(n3, KeyCycle.access$300((KeyCycle)keyCycle)));
                    break;
                }
                case 4: {
                    KeyCycle.access$202((KeyCycle)keyCycle, (int)typedArray.getInteger(n3, KeyCycle.access$200((KeyCycle)keyCycle)));
                    break;
                }
                case 3: {
                    KeyCycle.access$102((KeyCycle)keyCycle, (String)typedArray.getString(n3));
                    break;
                }
                case 2: {
                    keyCycle.mFramePosition = typedArray.getInt(n3, keyCycle.mFramePosition);
                    break;
                }
                case 1: {
                    if (MotionLayout.IS_IN_EDIT_MODE) {
                        keyCycle.mTargetId = typedArray.getResourceId(n3, keyCycle.mTargetId);
                        if (keyCycle.mTargetId != -1) break;
                        keyCycle.mTargetString = typedArray.getString(n3);
                        break;
                    }
                    if (typedArray.peekValue((int)n3).type == 3) {
                        keyCycle.mTargetString = typedArray.getString(n3);
                        break;
                    }
                    keyCycle.mTargetId = typedArray.getResourceId(n3, keyCycle.mTargetId);
                }
            }
            ++n2;
        }
    }
}
