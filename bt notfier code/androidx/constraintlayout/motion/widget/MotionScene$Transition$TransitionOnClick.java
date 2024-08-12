/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.util.Xml
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.constraintlayout.motion.widget.MotionLayout
 *  androidx.constraintlayout.motion.widget.MotionScene
 *  androidx.constraintlayout.motion.widget.MotionScene$Transition
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.R;
import org.xmlpull.v1.XmlPullParser;

/*
 * Exception performing whole class analysis ignored.
 */
static class MotionScene.Transition.TransitionOnClick
implements View.OnClickListener {
    public static final int ANIM_TOGGLE = 17;
    public static final int ANIM_TO_END = 1;
    public static final int ANIM_TO_START = 16;
    public static final int JUMP_TO_END = 256;
    public static final int JUMP_TO_START = 4096;
    int mMode = 17;
    int mTargetId = -1;
    private final MotionScene.Transition mTransition;

    public MotionScene.Transition.TransitionOnClick(Context context, MotionScene.Transition transition, XmlPullParser xmlPullParser) {
        this.mTransition = transition;
        context = context.obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser)xmlPullParser), R.styleable.OnClick);
        int n = context.getIndexCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                context.recycle();
                return;
            }
            int n3 = context.getIndex(n2);
            if (n3 == R.styleable.OnClick_targetId) {
                this.mTargetId = context.getResourceId(n3, this.mTargetId);
            } else if (n3 == R.styleable.OnClick_clickAction) {
                this.mMode = context.getInt(n3, this.mMode);
            }
            ++n2;
        }
    }

    public void addOnClickListeners(MotionLayout object, int n, MotionScene.Transition transition) {
        int n2 = this.mTargetId;
        if (n2 != -1) {
            object = object.findViewById(n2);
        }
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("OnClick could not find id ");
            ((StringBuilder)object).append(this.mTargetId);
            Log.e((String)"MotionScene", (String)((StringBuilder)object).toString());
            return;
        }
        int n3 = MotionScene.Transition.access$100((MotionScene.Transition)transition);
        int n4 = MotionScene.Transition.access$000((MotionScene.Transition)transition);
        if (n3 == -1) {
            object.setOnClickListener((View.OnClickListener)this);
            return;
        }
        n2 = this.mMode;
        int n5 = 1;
        n2 = (n2 & 1) != 0 && n == n3 ? 1 : 0;
        int n6 = (this.mMode & 0x100) != 0 && n == n3 ? 1 : 0;
        n3 = (this.mMode & 1) != 0 && n == n3 ? 1 : 0;
        int n7 = (this.mMode & 0x10) != 0 && n == n4 ? 1 : 0;
        n = (this.mMode & 0x1000) != 0 && n == n4 ? n5 : 0;
        if ((n3 | (n2 | n6) | n7 | n) == 0) return;
        object.setOnClickListener((View.OnClickListener)this);
    }

    boolean isTransitionViable(MotionScene.Transition transition, MotionLayout motionLayout) {
        MotionScene.Transition transition2 = this.mTransition;
        boolean bl = true;
        boolean bl2 = true;
        if (transition2 == transition) {
            return true;
        }
        int n = MotionScene.Transition.access$000((MotionScene.Transition)transition2);
        int n2 = MotionScene.Transition.access$100((MotionScene.Transition)this.mTransition);
        if (n2 == -1) {
            if (motionLayout.mCurrentState != n) return bl2;
            bl2 = false;
            return bl2;
        }
        bl2 = bl;
        if (motionLayout.mCurrentState == n2) return bl2;
        bl2 = motionLayout.mCurrentState == n ? bl : false;
        return bl2;
    }

    public void onClick(View view) {
        int n;
        view = MotionScene.access$800((MotionScene)MotionScene.Transition.access$700((MotionScene.Transition)this.mTransition));
        if (!view.isInteractionEnabled()) {
            return;
        }
        if (MotionScene.Transition.access$100((MotionScene.Transition)this.mTransition) == -1) {
            int n2 = view.getCurrentState();
            if (n2 == -1) {
                view.transitionToState(MotionScene.Transition.access$000((MotionScene.Transition)this.mTransition));
                return;
            }
            MotionScene.Transition transition = new MotionScene.Transition(MotionScene.Transition.access$700((MotionScene.Transition)this.mTransition), this.mTransition);
            MotionScene.Transition.access$102((MotionScene.Transition)transition, (int)n2);
            MotionScene.Transition.access$002((MotionScene.Transition)transition, (int)MotionScene.Transition.access$000((MotionScene.Transition)this.mTransition));
            view.setTransition(transition);
            view.transitionToEnd();
            return;
        }
        MotionScene.Transition transition = MotionScene.Transition.access$700((MotionScene.Transition)this.mTransition).mCurrentTransition;
        int n3 = this.mMode;
        int n4 = 0;
        n3 = (n3 & 1) == 0 && (n3 & 0x100) == 0 ? 0 : 1;
        int n5 = this.mMode;
        n5 = (n5 & 0x10) == 0 && (n5 & 0x1000) == 0 ? 0 : 1;
        int n6 = n3 != 0 && n5 != 0 ? 1 : 0;
        if (n6 != 0) {
            MotionScene.Transition transition2 = MotionScene.Transition.access$700((MotionScene.Transition)this.mTransition).mCurrentTransition;
            MotionScene.Transition transition3 = this.mTransition;
            if (transition2 != transition3) {
                view.setTransition(transition3);
            }
            n = n5;
            n6 = n4;
            if (view.getCurrentState() != view.getEndState()) {
                if (view.getProgress() > 0.5f) {
                    n = n5;
                    n6 = n4;
                } else {
                    n = 0;
                    n6 = n3;
                }
            }
        } else {
            n6 = n3;
            n = n5;
        }
        if (!this.isTransitionViable(transition, (MotionLayout)view)) return;
        if (n6 != 0 && (this.mMode & 1) != 0) {
            view.setTransition(this.mTransition);
            view.transitionToEnd();
        } else if (n != 0 && (this.mMode & 0x10) != 0) {
            view.setTransition(this.mTransition);
            view.transitionToStart();
        } else if (n6 != 0 && (this.mMode & 0x100) != 0) {
            view.setTransition(this.mTransition);
            view.setProgress(1.0f);
        } else {
            if (n == 0) return;
            if ((this.mMode & 0x1000) == 0) return;
            view.setTransition(this.mTransition);
            view.setProgress(0.0f);
        }
    }

    public void removeOnClickListeners(MotionLayout object) {
        int n = this.mTargetId;
        if (n == -1) {
            return;
        }
        if ((object = object.findViewById(n)) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(" (*)  could not find id ");
            ((StringBuilder)object).append(this.mTargetId);
            Log.e((String)"MotionScene", (String)((StringBuilder)object).toString());
            return;
        }
        object.setOnClickListener(null);
    }
}
