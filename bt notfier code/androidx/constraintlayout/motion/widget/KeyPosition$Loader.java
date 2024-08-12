/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.TypedArray
 *  android.util.Log
 *  android.util.SparseIntArray
 *  androidx.constraintlayout.motion.utils.Easing
 *  androidx.constraintlayout.motion.widget.KeyPosition
 *  androidx.constraintlayout.motion.widget.MotionLayout
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.KeyPosition;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;

private static class KeyPosition.Loader {
    private static final int CURVE_FIT = 4;
    private static final int DRAW_PATH = 5;
    private static final int FRAME_POSITION = 2;
    private static final int PATH_MOTION_ARC = 10;
    private static final int PERCENT_HEIGHT = 12;
    private static final int PERCENT_WIDTH = 11;
    private static final int PERCENT_X = 6;
    private static final int PERCENT_Y = 7;
    private static final int SIZE_PERCENT = 8;
    private static final int TARGET_ID = 1;
    private static final int TRANSITION_EASING = 3;
    private static final int TYPE = 9;
    private static SparseIntArray mAttrMap;

    static {
        SparseIntArray sparseIntArray;
        mAttrMap = sparseIntArray = new SparseIntArray();
        sparseIntArray.append(R.styleable.KeyPosition_motionTarget, 1);
        mAttrMap.append(R.styleable.KeyPosition_framePosition, 2);
        mAttrMap.append(R.styleable.KeyPosition_transitionEasing, 3);
        mAttrMap.append(R.styleable.KeyPosition_curveFit, 4);
        mAttrMap.append(R.styleable.KeyPosition_drawPath, 5);
        mAttrMap.append(R.styleable.KeyPosition_percentX, 6);
        mAttrMap.append(R.styleable.KeyPosition_percentY, 7);
        mAttrMap.append(R.styleable.KeyPosition_keyPositionType, 9);
        mAttrMap.append(R.styleable.KeyPosition_sizePercent, 8);
        mAttrMap.append(R.styleable.KeyPosition_percentWidth, 11);
        mAttrMap.append(R.styleable.KeyPosition_percentHeight, 12);
        mAttrMap.append(R.styleable.KeyPosition_pathMotionArc, 10);
    }

    private KeyPosition.Loader() {
    }

    static /* synthetic */ void access$000(KeyPosition keyPosition, TypedArray typedArray) {
        KeyPosition.Loader.read(keyPosition, typedArray);
    }

    private static void read(KeyPosition keyPosition, TypedArray typedArray) {
        int n = typedArray.getIndexCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                if (keyPosition.mFramePosition != -1) return;
                Log.e((String)"KeyPosition", (String)"no frame position");
                return;
            }
            int n3 = typedArray.getIndex(n2);
            switch (mAttrMap.get(n3)) {
                default: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("unused attribute 0x");
                    stringBuilder.append(Integer.toHexString(n3));
                    stringBuilder.append("   ");
                    stringBuilder.append(mAttrMap.get(n3));
                    Log.e((String)"KeyPosition", (String)stringBuilder.toString());
                    break;
                }
                case 12: {
                    keyPosition.mPercentHeight = typedArray.getFloat(n3, keyPosition.mPercentHeight);
                    break;
                }
                case 11: {
                    keyPosition.mPercentWidth = typedArray.getFloat(n3, keyPosition.mPercentWidth);
                    break;
                }
                case 10: {
                    keyPosition.mPathMotionArc = typedArray.getInt(n3, keyPosition.mPathMotionArc);
                    break;
                }
                case 9: {
                    keyPosition.mPositionType = typedArray.getInt(n3, keyPosition.mPositionType);
                    break;
                }
                case 8: {
                    float f;
                    keyPosition.mPercentWidth = f = typedArray.getFloat(n3, keyPosition.mPercentHeight);
                    keyPosition.mPercentHeight = f;
                    break;
                }
                case 7: {
                    keyPosition.mPercentY = typedArray.getFloat(n3, keyPosition.mPercentY);
                    break;
                }
                case 6: {
                    keyPosition.mPercentX = typedArray.getFloat(n3, keyPosition.mPercentX);
                    break;
                }
                case 5: {
                    keyPosition.mDrawPath = typedArray.getInt(n3, keyPosition.mDrawPath);
                    break;
                }
                case 4: {
                    keyPosition.mCurveFit = typedArray.getInteger(n3, keyPosition.mCurveFit);
                    break;
                }
                case 3: {
                    if (typedArray.peekValue((int)n3).type == 3) {
                        keyPosition.mTransitionEasing = typedArray.getString(n3);
                        break;
                    }
                    keyPosition.mTransitionEasing = Easing.NAMED_EASING[typedArray.getInteger(n3, 0)];
                    break;
                }
                case 2: {
                    keyPosition.mFramePosition = typedArray.getInt(n3, keyPosition.mFramePosition);
                    break;
                }
                case 1: {
                    if (MotionLayout.IS_IN_EDIT_MODE) {
                        keyPosition.mTargetId = typedArray.getResourceId(n3, keyPosition.mTargetId);
                        if (keyPosition.mTargetId != -1) break;
                        keyPosition.mTargetString = typedArray.getString(n3);
                        break;
                    }
                    if (typedArray.peekValue((int)n3).type == 3) {
                        keyPosition.mTargetString = typedArray.getString(n3);
                        break;
                    }
                    keyPosition.mTargetId = typedArray.getResourceId(n3, keyPosition.mTargetId);
                }
            }
            ++n2;
        }
    }
}
