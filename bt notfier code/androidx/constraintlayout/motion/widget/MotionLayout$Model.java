/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.TextView
 *  androidx.constraintlayout.motion.widget.Debug
 *  androidx.constraintlayout.motion.widget.MotionController
 *  androidx.constraintlayout.motion.widget.MotionLayout
 *  androidx.constraintlayout.solver.widgets.Barrier
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour
 *  androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
 *  androidx.constraintlayout.solver.widgets.Flow
 *  androidx.constraintlayout.solver.widgets.Guideline
 *  androidx.constraintlayout.solver.widgets.Helper
 *  androidx.constraintlayout.solver.widgets.HelperWidget
 *  androidx.constraintlayout.solver.widgets.VirtualLayout
 *  androidx.constraintlayout.widget.Barrier
 *  androidx.constraintlayout.widget.ConstraintHelper
 *  androidx.constraintlayout.widget.ConstraintLayout$LayoutParams
 *  androidx.constraintlayout.widget.ConstraintSet
 *  androidx.constraintlayout.widget.Constraints$LayoutParams
 */
package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * Exception performing whole class analysis ignored.
 */
class MotionLayout.Model {
    ConstraintSet mEnd;
    int mEndId;
    ConstraintWidgetContainer mLayoutEnd;
    ConstraintWidgetContainer mLayoutStart;
    ConstraintSet mStart;
    int mStartId;
    final MotionLayout this$0;

    MotionLayout.Model(MotionLayout motionLayout) {
        this.this$0 = motionLayout;
        this.mLayoutStart = new ConstraintWidgetContainer();
        this.mLayoutEnd = new ConstraintWidgetContainer();
        this.mStart = null;
        this.mEnd = null;
    }

    private void debugLayout(String charSequence, ConstraintWidgetContainer constraintWidgetContainer) {
        Object object = (View)constraintWidgetContainer.getCompanionWidget();
        CharSequence charSequence2 = new StringBuilder();
        charSequence2.append((String)charSequence);
        charSequence2.append(" ");
        charSequence2.append(Debug.getName((View)object));
        charSequence2 = charSequence2.toString();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append("  ========= ");
        ((StringBuilder)charSequence).append(constraintWidgetContainer);
        Log.v((String)"MotionLayout", (String)((StringBuilder)charSequence).toString());
        int n = constraintWidgetContainer.getChildren().size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)charSequence2);
                ((StringBuilder)charSequence).append(" done. ");
                Log.v((String)"MotionLayout", (String)((StringBuilder)charSequence).toString());
                return;
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)charSequence2);
            ((StringBuilder)charSequence).append("[");
            ((StringBuilder)charSequence).append(n2);
            ((StringBuilder)charSequence).append("] ");
            String string = ((StringBuilder)charSequence).toString();
            ConstraintWidget constraintWidget = (ConstraintWidget)constraintWidgetContainer.getChildren().get(n2);
            CharSequence charSequence3 = new StringBuilder();
            charSequence3.append("");
            charSequence = constraintWidget.mTop.mTarget;
            object = "_";
            charSequence = charSequence != null ? "T" : "_";
            charSequence3.append((String)charSequence);
            charSequence = charSequence3.toString();
            charSequence3 = new StringBuilder();
            charSequence3.append((String)charSequence);
            charSequence = constraintWidget.mBottom.mTarget != null ? "B" : "_";
            charSequence3.append((String)charSequence);
            charSequence = charSequence3.toString();
            charSequence3 = new StringBuilder();
            charSequence3.append((String)charSequence);
            charSequence = constraintWidget.mLeft.mTarget != null ? "L" : "_";
            charSequence3.append((String)charSequence);
            charSequence = charSequence3.toString();
            charSequence3 = new StringBuilder();
            charSequence3.append((String)charSequence);
            charSequence = object;
            if (constraintWidget.mRight.mTarget != null) {
                charSequence = "R";
            }
            charSequence3.append((String)charSequence);
            charSequence3 = charSequence3.toString();
            View view = (View)constraintWidget.getCompanionWidget();
            object = Debug.getName((View)view);
            charSequence = object;
            if (view instanceof TextView) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append("(");
                ((StringBuilder)charSequence).append((Object)((TextView)view).getText());
                ((StringBuilder)charSequence).append(")");
                charSequence = ((StringBuilder)charSequence).toString();
            }
            object = new StringBuilder();
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append("  ");
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append(" ");
            ((StringBuilder)object).append(constraintWidget);
            ((StringBuilder)object).append(" ");
            ((StringBuilder)object).append((String)charSequence3);
            Log.v((String)"MotionLayout", (String)((StringBuilder)object).toString());
            ++n2;
        }
    }

    private void debugLayoutParam(String string, ConstraintLayout.LayoutParams object) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append(" ");
        CharSequence charSequence2 = ((ConstraintLayout.LayoutParams)object).startToStart != -1 ? "SS" : "__";
        charSequence.append((String)charSequence2);
        charSequence2 = charSequence.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence2);
        int n = ((ConstraintLayout.LayoutParams)object).startToEnd;
        charSequence = "|__";
        charSequence2 = n != -1 ? "|SE" : "|__";
        stringBuilder.append((String)charSequence2);
        charSequence2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence2);
        charSequence2 = ((ConstraintLayout.LayoutParams)object).endToStart != -1 ? "|ES" : "|__";
        stringBuilder.append((String)charSequence2);
        charSequence2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence2);
        charSequence2 = ((ConstraintLayout.LayoutParams)object).endToEnd != -1 ? "|EE" : "|__";
        stringBuilder.append((String)charSequence2);
        charSequence2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence2);
        charSequence2 = ((ConstraintLayout.LayoutParams)object).leftToLeft != -1 ? "|LL" : "|__";
        stringBuilder.append((String)charSequence2);
        charSequence2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence2);
        charSequence2 = ((ConstraintLayout.LayoutParams)object).leftToRight != -1 ? "|LR" : "|__";
        stringBuilder.append((String)charSequence2);
        charSequence2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence2);
        charSequence2 = ((ConstraintLayout.LayoutParams)object).rightToLeft != -1 ? "|RL" : "|__";
        stringBuilder.append((String)charSequence2);
        charSequence2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence2);
        charSequence2 = ((ConstraintLayout.LayoutParams)object).rightToRight != -1 ? "|RR" : "|__";
        stringBuilder.append((String)charSequence2);
        charSequence2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence2);
        charSequence2 = ((ConstraintLayout.LayoutParams)object).topToTop != -1 ? "|TT" : "|__";
        stringBuilder.append((String)charSequence2);
        charSequence2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence2);
        charSequence2 = ((ConstraintLayout.LayoutParams)object).topToBottom != -1 ? "|TB" : "|__";
        stringBuilder.append((String)charSequence2);
        charSequence2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence2);
        charSequence2 = ((ConstraintLayout.LayoutParams)object).bottomToTop != -1 ? "|BT" : "|__";
        stringBuilder.append((String)charSequence2);
        charSequence2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence2);
        charSequence2 = charSequence;
        if (((ConstraintLayout.LayoutParams)object).bottomToBottom != -1) {
            charSequence2 = "|BB";
        }
        stringBuilder.append((String)charSequence2);
        charSequence2 = stringBuilder.toString();
        object = new StringBuilder();
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append((String)charSequence2);
        Log.v((String)"MotionLayout", (String)((StringBuilder)object).toString());
    }

    private void debugWidget(String string, ConstraintWidget constraintWidget) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(" ");
        Object object = constraintWidget.mTop.mTarget;
        String string2 = "B";
        CharSequence charSequence = "__";
        if (object != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("T");
            object = constraintWidget.mTop.mTarget.mType == ConstraintAnchor.Type.TOP ? "T" : "B";
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
        } else {
            object = "__";
        }
        stringBuilder2.append((String)object);
        object = stringBuilder2.toString();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append((String)object);
        if (constraintWidget.mBottom.mTarget != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("B");
            object = string2;
            if (constraintWidget.mBottom.mTarget.mType == ConstraintAnchor.Type.TOP) {
                object = "T";
            }
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
        } else {
            object = "__";
        }
        stringBuilder2.append((String)object);
        object = stringBuilder2.toString();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append((String)object);
        object = constraintWidget.mLeft.mTarget;
        string2 = "R";
        if (object != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("L");
            object = constraintWidget.mLeft.mTarget.mType == ConstraintAnchor.Type.LEFT ? "L" : "R";
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
        } else {
            object = "__";
        }
        stringBuilder2.append((String)object);
        object = stringBuilder2.toString();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append((String)object);
        object = charSequence;
        if (constraintWidget.mRight.mTarget != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("R");
            object = string2;
            if (constraintWidget.mRight.mTarget.mType == ConstraintAnchor.Type.LEFT) {
                object = "L";
            }
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
        }
        stringBuilder2.append((String)object);
        charSequence = stringBuilder2.toString();
        object = new StringBuilder();
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append((String)charSequence);
        ((StringBuilder)object).append(" ---  ");
        ((StringBuilder)object).append(constraintWidget);
        Log.v((String)"MotionLayout", (String)((StringBuilder)object).toString());
    }

    private void setupConstraintWidget(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet object) {
        ConstraintWidget constraintWidget2;
        SparseArray sparseArray = new SparseArray();
        Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
        sparseArray.clear();
        sparseArray.put(0, (Object)constraintWidgetContainer);
        sparseArray.put(this.this$0.getId(), (Object)constraintWidgetContainer);
        for (ConstraintWidget constraintWidget2 : constraintWidgetContainer.getChildren()) {
            sparseArray.put(((View)constraintWidget2.getCompanionWidget()).getId(), (Object)constraintWidget2);
        }
        for (ConstraintWidget constraintWidget3 : constraintWidgetContainer.getChildren()) {
            constraintWidget2 = (View)constraintWidget3.getCompanionWidget();
            object.applyToLayoutParams(constraintWidget2.getId(), (ConstraintLayout.LayoutParams)layoutParams);
            constraintWidget3.setWidth(object.getWidth(constraintWidget2.getId()));
            constraintWidget3.setHeight(object.getHeight(constraintWidget2.getId()));
            if (constraintWidget2 instanceof ConstraintHelper) {
                object.applyToHelper((ConstraintHelper)constraintWidget2, constraintWidget3, (ConstraintLayout.LayoutParams)layoutParams, sparseArray);
                if (constraintWidget2 instanceof Barrier) {
                    ((Barrier)constraintWidget2).validateParams();
                }
            }
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.resolveLayoutDirection(this.this$0.getLayoutDirection());
            } else {
                layoutParams.resolveLayoutDirection(0);
            }
            MotionLayout.access$800((MotionLayout)this.this$0, (boolean)false, (View)constraintWidget2, (ConstraintWidget)constraintWidget3, (ConstraintLayout.LayoutParams)layoutParams, (SparseArray)sparseArray);
            if (object.getVisibilityMode(constraintWidget2.getId()) == 1) {
                constraintWidget3.setVisibility(constraintWidget2.getVisibility());
                continue;
            }
            constraintWidget3.setVisibility(object.getVisibility(constraintWidget2.getId()));
        }
        object = constraintWidgetContainer.getChildren().iterator();
        while (object.hasNext()) {
            constraintWidget2 = (ConstraintWidget)object.next();
            if (!(constraintWidget2 instanceof VirtualLayout)) continue;
            layoutParams = (ConstraintHelper)constraintWidget2.getCompanionWidget();
            constraintWidget2 = (Helper)constraintWidget2;
            layoutParams.updatePreLayout(constraintWidgetContainer, (Helper)constraintWidget2, sparseArray);
            ((VirtualLayout)constraintWidget2).captureWidgets();
        }
    }

    public void build() {
        Object object;
        View view;
        int n;
        int n2 = this.this$0.getChildCount();
        this.this$0.mFrameArrayList.clear();
        int n3 = 0;
        int n4 = 0;
        while (true) {
            n = n3;
            if (n4 >= n2) break;
            view = this.this$0.getChildAt(n4);
            object = new MotionController(view);
            this.this$0.mFrameArrayList.put(view, object);
            ++n4;
        }
        while (n < n2) {
            view = this.this$0.getChildAt(n);
            object = (MotionController)this.this$0.mFrameArrayList.get(view);
            if (object != null) {
                Object object2;
                if (this.mStart != null) {
                    object2 = this.getWidget(this.mLayoutStart, view);
                    if (object2 != null) {
                        object.setStartState((ConstraintWidget)object2, this.mStart);
                    } else if (this.this$0.mDebugPath != 0) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append(Debug.getLocation());
                        ((StringBuilder)object2).append("no widget for  ");
                        ((StringBuilder)object2).append(Debug.getName((View)view));
                        ((StringBuilder)object2).append(" (");
                        ((StringBuilder)object2).append(view.getClass().getName());
                        ((StringBuilder)object2).append(")");
                        Log.e((String)"MotionLayout", (String)((StringBuilder)object2).toString());
                    }
                }
                if (this.mEnd != null) {
                    object2 = this.getWidget(this.mLayoutEnd, view);
                    if (object2 != null) {
                        object.setEndState((ConstraintWidget)object2, this.mEnd);
                    } else if (this.this$0.mDebugPath != 0) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append(Debug.getLocation());
                        ((StringBuilder)object).append("no widget for  ");
                        ((StringBuilder)object).append(Debug.getName((View)view));
                        ((StringBuilder)object).append(" (");
                        ((StringBuilder)object).append(view.getClass().getName());
                        ((StringBuilder)object).append(")");
                        Log.e((String)"MotionLayout", (String)((StringBuilder)object).toString());
                    }
                }
            }
            ++n;
        }
    }

    void copy(ConstraintWidgetContainer object, ConstraintWidgetContainer object2) {
        ArrayList arrayList = object.getChildren();
        HashMap<Object, ConstraintWidgetContainer> hashMap = new HashMap<Object, ConstraintWidgetContainer>();
        hashMap.put(object, (ConstraintWidgetContainer)object2);
        object2.getChildren().clear();
        object2.copy((ConstraintWidget)object, hashMap);
        for (ConstraintWidget constraintWidget : arrayList) {
            object = constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier ? new androidx.constraintlayout.solver.widgets.Barrier() : (constraintWidget instanceof Guideline ? new Guideline() : (constraintWidget instanceof Flow ? new Flow() : (constraintWidget instanceof Helper ? new HelperWidget() : new ConstraintWidget())));
            object2.add((ConstraintWidget)object);
            hashMap.put(constraintWidget, (ConstraintWidgetContainer)object);
        }
        object2 = arrayList.iterator();
        while (object2.hasNext()) {
            object = (ConstraintWidget)object2.next();
            ((ConstraintWidget)hashMap.get(object)).copy((ConstraintWidget)object, hashMap);
        }
    }

    ConstraintWidget getWidget(ConstraintWidgetContainer constraintWidgetContainer, View view) {
        if (constraintWidgetContainer.getCompanionWidget() == view) {
            return constraintWidgetContainer;
        }
        ArrayList arrayList = constraintWidgetContainer.getChildren();
        int n = arrayList.size();
        int n2 = 0;
        while (n2 < n) {
            constraintWidgetContainer = (ConstraintWidget)arrayList.get(n2);
            if (constraintWidgetContainer.getCompanionWidget() == view) {
                return constraintWidgetContainer;
            }
            ++n2;
        }
        return null;
    }

    void initFrom(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
        this.mStart = constraintSet;
        this.mEnd = constraintSet2;
        this.mLayoutStart = new ConstraintWidgetContainer();
        this.mLayoutEnd = new ConstraintWidgetContainer();
        this.mLayoutStart.setMeasurer(MotionLayout.access$200((MotionLayout)this.this$0).getMeasurer());
        this.mLayoutEnd.setMeasurer(MotionLayout.access$300((MotionLayout)this.this$0).getMeasurer());
        this.mLayoutStart.removeAllChildren();
        this.mLayoutEnd.removeAllChildren();
        this.copy(MotionLayout.access$400((MotionLayout)this.this$0), this.mLayoutStart);
        this.copy(MotionLayout.access$500((MotionLayout)this.this$0), this.mLayoutEnd);
        if ((double)this.this$0.mTransitionLastPosition > 0.5) {
            if (constraintSet != null) {
                this.setupConstraintWidget(this.mLayoutStart, constraintSet);
            }
            this.setupConstraintWidget(this.mLayoutEnd, constraintSet2);
        } else {
            this.setupConstraintWidget(this.mLayoutEnd, constraintSet2);
            if (constraintSet != null) {
                this.setupConstraintWidget(this.mLayoutStart, constraintSet);
            }
        }
        this.mLayoutStart.setRtl(MotionLayout.access$600((MotionLayout)this.this$0));
        this.mLayoutStart.updateHierarchy();
        this.mLayoutEnd.setRtl(MotionLayout.access$700((MotionLayout)this.this$0));
        this.mLayoutEnd.updateHierarchy();
        constraintWidgetContainer = this.this$0.getLayoutParams();
        if (constraintWidgetContainer == null) return;
        if (constraintWidgetContainer.width == -2) {
            this.mLayoutStart.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            this.mLayoutEnd.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
        }
        if (constraintWidgetContainer.height != -2) return;
        this.mLayoutStart.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
        this.mLayoutEnd.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    }

    public boolean isNotConfiguredWith(int n, int n2) {
        boolean bl = n != this.mStartId || n2 != this.mEndId;
        return bl;
    }

    public void measure(int n, int n2) {
        boolean bl;
        int n3;
        int n4 = View.MeasureSpec.getMode((int)n);
        int n5 = View.MeasureSpec.getMode((int)n2);
        this.this$0.mWidthMeasureMode = n4;
        this.this$0.mHeightMeasureMode = n5;
        int n6 = this.this$0.getOptimizationLevel();
        if (this.this$0.mCurrentState == this.this$0.getStartState()) {
            MotionLayout.access$1200((MotionLayout)this.this$0, (ConstraintWidgetContainer)this.mLayoutEnd, (int)n6, (int)n, (int)n2);
            if (this.mStart != null) {
                MotionLayout.access$1300((MotionLayout)this.this$0, (ConstraintWidgetContainer)this.mLayoutStart, (int)n6, (int)n, (int)n2);
            }
        } else {
            if (this.mStart != null) {
                MotionLayout.access$1400((MotionLayout)this.this$0, (ConstraintWidgetContainer)this.mLayoutStart, (int)n6, (int)n, (int)n2);
            }
            MotionLayout.access$1500((MotionLayout)this.this$0, (ConstraintWidgetContainer)this.mLayoutEnd, (int)n6, (int)n, (int)n2);
        }
        if ((n3 = this.this$0.getParent() instanceof MotionLayout && n4 == 0x40000000 && n5 == 0x40000000 ? 0 : 1) != 0) {
            this.this$0.mWidthMeasureMode = n4;
            this.this$0.mHeightMeasureMode = n5;
            if (this.this$0.mCurrentState == this.this$0.getStartState()) {
                MotionLayout.access$1600((MotionLayout)this.this$0, (ConstraintWidgetContainer)this.mLayoutEnd, (int)n6, (int)n, (int)n2);
                if (this.mStart != null) {
                    MotionLayout.access$1700((MotionLayout)this.this$0, (ConstraintWidgetContainer)this.mLayoutStart, (int)n6, (int)n, (int)n2);
                }
            } else {
                if (this.mStart != null) {
                    MotionLayout.access$1800((MotionLayout)this.this$0, (ConstraintWidgetContainer)this.mLayoutStart, (int)n6, (int)n, (int)n2);
                }
                MotionLayout.access$1900((MotionLayout)this.this$0, (ConstraintWidgetContainer)this.mLayoutEnd, (int)n6, (int)n, (int)n2);
            }
            this.this$0.mStartWrapWidth = this.mLayoutStart.getWidth();
            this.this$0.mStartWrapHeight = this.mLayoutStart.getHeight();
            this.this$0.mEndWrapWidth = this.mLayoutEnd.getWidth();
            this.this$0.mEndWrapHeight = this.mLayoutEnd.getHeight();
            MotionLayout motionLayout = this.this$0;
            bl = motionLayout.mStartWrapWidth != this.this$0.mEndWrapWidth || this.this$0.mStartWrapHeight != this.this$0.mEndWrapHeight;
            motionLayout.mMeasureDuringTransition = bl;
        }
        n3 = this.this$0.mStartWrapWidth;
        n6 = this.this$0.mStartWrapHeight;
        if (this.this$0.mWidthMeasureMode == Integer.MIN_VALUE || this.this$0.mWidthMeasureMode == 0) {
            n3 = (int)((float)this.this$0.mStartWrapWidth + this.this$0.mPostInterpolationPosition * (float)(this.this$0.mEndWrapWidth - this.this$0.mStartWrapWidth));
        }
        if (this.this$0.mHeightMeasureMode == Integer.MIN_VALUE || this.this$0.mHeightMeasureMode == 0) {
            n6 = (int)((float)this.this$0.mStartWrapHeight + this.this$0.mPostInterpolationPosition * (float)(this.this$0.mEndWrapHeight - this.this$0.mStartWrapHeight));
        }
        bl = this.mLayoutStart.isWidthMeasuredTooSmall() || this.mLayoutEnd.isWidthMeasuredTooSmall();
        boolean bl2 = this.mLayoutStart.isHeightMeasuredTooSmall() || this.mLayoutEnd.isHeightMeasuredTooSmall();
        MotionLayout.access$2000((MotionLayout)this.this$0, (int)n, (int)n2, (int)n3, (int)n6, (boolean)bl, (boolean)bl2);
    }

    public void reEvaluateState() {
        this.measure(MotionLayout.access$900((MotionLayout)this.this$0), MotionLayout.access$1000((MotionLayout)this.this$0));
        MotionLayout.access$1100((MotionLayout)this.this$0);
    }

    public void setMeasuredId(int n, int n2) {
        this.mStartId = n;
        this.mEndId = n2;
    }
}
