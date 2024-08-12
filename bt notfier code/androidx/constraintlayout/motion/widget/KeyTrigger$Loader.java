/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.Log
 *  android.util.SparseIntArray
 *  androidx.constraintlayout.motion.widget.KeyTrigger
 *  androidx.constraintlayout.motion.widget.MotionLayout
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.KeyTrigger;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;

/*
 * Exception performing whole class analysis ignored.
 */
private static class KeyTrigger.Loader {
    private static final int COLLISION = 9;
    private static final int CROSS = 4;
    private static final int FRAME_POS = 8;
    private static final int NEGATIVE_CROSS = 1;
    private static final int POSITIVE_CROSS = 2;
    private static final int POST_LAYOUT = 10;
    private static final int TARGET_ID = 7;
    private static final int TRIGGER_ID = 6;
    private static final int TRIGGER_RECEIVER = 11;
    private static final int TRIGGER_SLACK = 5;
    private static SparseIntArray mAttrMap;

    static {
        SparseIntArray sparseIntArray;
        mAttrMap = sparseIntArray = new SparseIntArray();
        sparseIntArray.append(R.styleable.KeyTrigger_framePosition, 8);
        mAttrMap.append(R.styleable.KeyTrigger_onCross, 4);
        mAttrMap.append(R.styleable.KeyTrigger_onNegativeCross, 1);
        mAttrMap.append(R.styleable.KeyTrigger_onPositiveCross, 2);
        mAttrMap.append(R.styleable.KeyTrigger_motionTarget, 7);
        mAttrMap.append(R.styleable.KeyTrigger_triggerId, 6);
        mAttrMap.append(R.styleable.KeyTrigger_triggerSlack, 5);
        mAttrMap.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
        mAttrMap.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
        mAttrMap.append(R.styleable.KeyTrigger_triggerReceiver, 11);
    }

    private KeyTrigger.Loader() {
    }

    public static void read(KeyTrigger keyTrigger, TypedArray typedArray, Context object) {
        int n = typedArray.getIndexCount();
        int n2 = 0;
        while (n2 < n) {
            block18: {
                int n3 = typedArray.getIndex(n2);
                switch (mAttrMap.get(n3)) {
                    default: {
                        break;
                    }
                    case 11: {
                        KeyTrigger.access$702((KeyTrigger)keyTrigger, (int)typedArray.getResourceId(n3, KeyTrigger.access$700((KeyTrigger)keyTrigger)));
                        break;
                    }
                    case 10: {
                        KeyTrigger.access$602((KeyTrigger)keyTrigger, (boolean)typedArray.getBoolean(n3, KeyTrigger.access$600((KeyTrigger)keyTrigger)));
                        break block18;
                    }
                    case 9: {
                        KeyTrigger.access$502((KeyTrigger)keyTrigger, (int)typedArray.getResourceId(n3, KeyTrigger.access$500((KeyTrigger)keyTrigger)));
                        break block18;
                    }
                    case 8: {
                        keyTrigger.mFramePosition = typedArray.getInteger(n3, keyTrigger.mFramePosition);
                        KeyTrigger.access$002((KeyTrigger)keyTrigger, (float)(((float)keyTrigger.mFramePosition + 0.5f) / 100.0f));
                        break block18;
                    }
                    case 7: {
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            keyTrigger.mTargetId = typedArray.getResourceId(n3, keyTrigger.mTargetId);
                            if (keyTrigger.mTargetId == -1) {
                                keyTrigger.mTargetString = typedArray.getString(n3);
                            }
                        } else if (typedArray.peekValue((int)n3).type == 3) {
                            keyTrigger.mTargetString = typedArray.getString(n3);
                        } else {
                            keyTrigger.mTargetId = typedArray.getResourceId(n3, keyTrigger.mTargetId);
                        }
                        break block18;
                    }
                    case 6: {
                        KeyTrigger.access$402((KeyTrigger)keyTrigger, (int)typedArray.getResourceId(n3, KeyTrigger.access$400((KeyTrigger)keyTrigger)));
                        break block18;
                    }
                    case 5: {
                        keyTrigger.mTriggerSlack = typedArray.getFloat(n3, keyTrigger.mTriggerSlack);
                        break block18;
                    }
                    case 4: {
                        KeyTrigger.access$302((KeyTrigger)keyTrigger, (String)typedArray.getString(n3));
                        break block18;
                    }
                    case 2: {
                        KeyTrigger.access$202((KeyTrigger)keyTrigger, (String)typedArray.getString(n3));
                        break block18;
                    }
                    case 1: {
                        KeyTrigger.access$102((KeyTrigger)keyTrigger, (String)typedArray.getString(n3));
                        break block18;
                    }
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("unused attribute 0x");
                ((StringBuilder)object).append(Integer.toHexString(n3));
                ((StringBuilder)object).append("   ");
                ((StringBuilder)object).append(mAttrMap.get(n3));
                Log.e((String)"KeyTrigger", (String)((StringBuilder)object).toString());
            }
            ++n2;
        }
    }
}
