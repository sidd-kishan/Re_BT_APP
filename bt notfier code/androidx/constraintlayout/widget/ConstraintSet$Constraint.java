/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  androidx.constraintlayout.widget.Barrier
 *  androidx.constraintlayout.widget.ConstraintAttribute
 *  androidx.constraintlayout.widget.ConstraintAttribute$AttributeType
 *  androidx.constraintlayout.widget.ConstraintHelper
 *  androidx.constraintlayout.widget.ConstraintLayout$LayoutParams
 *  androidx.constraintlayout.widget.ConstraintSet$Layout
 *  androidx.constraintlayout.widget.ConstraintSet$Motion
 *  androidx.constraintlayout.widget.ConstraintSet$PropertySet
 *  androidx.constraintlayout.widget.ConstraintSet$Transform
 *  androidx.constraintlayout.widget.Constraints$LayoutParams
 */
package androidx.constraintlayout.widget;

import android.os.Build;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import java.util.HashMap;

public static class ConstraintSet.Constraint {
    public final ConstraintSet.Layout layout;
    public HashMap<String, ConstraintAttribute> mCustomConstraints;
    int mViewId;
    public final ConstraintSet.Motion motion;
    public final ConstraintSet.PropertySet propertySet = new ConstraintSet.PropertySet();
    public final ConstraintSet.Transform transform;

    public ConstraintSet.Constraint() {
        this.motion = new ConstraintSet.Motion();
        this.layout = new ConstraintSet.Layout();
        this.transform = new ConstraintSet.Transform();
        this.mCustomConstraints = new HashMap();
    }

    static /* synthetic */ void access$000(ConstraintSet.Constraint constraint, int n, ConstraintLayout.LayoutParams layoutParams) {
        constraint.fillFrom(n, layoutParams);
    }

    static /* synthetic */ void access$300(ConstraintSet.Constraint constraint, ConstraintHelper constraintHelper, int n, Constraints.LayoutParams layoutParams) {
        constraint.fillFromConstraints(constraintHelper, n, layoutParams);
    }

    static /* synthetic */ void access$400(ConstraintSet.Constraint constraint, int n, Constraints.LayoutParams layoutParams) {
        constraint.fillFromConstraints(n, layoutParams);
    }

    static /* synthetic */ void access$500(ConstraintSet.Constraint constraint, String string, int n) {
        constraint.setIntValue(string, n);
    }

    static /* synthetic */ void access$600(ConstraintSet.Constraint constraint, String string, int n) {
        constraint.setColorValue(string, n);
    }

    static /* synthetic */ void access$700(ConstraintSet.Constraint constraint, String string, float f) {
        constraint.setFloatValue(string, f);
    }

    static /* synthetic */ void access$800(ConstraintSet.Constraint constraint, String string, String string2) {
        constraint.setStringValue(string, string2);
    }

    private void fillFrom(int n, ConstraintLayout.LayoutParams layoutParams) {
        this.mViewId = n;
        this.layout.leftToLeft = layoutParams.leftToLeft;
        this.layout.leftToRight = layoutParams.leftToRight;
        this.layout.rightToLeft = layoutParams.rightToLeft;
        this.layout.rightToRight = layoutParams.rightToRight;
        this.layout.topToTop = layoutParams.topToTop;
        this.layout.topToBottom = layoutParams.topToBottom;
        this.layout.bottomToTop = layoutParams.bottomToTop;
        this.layout.bottomToBottom = layoutParams.bottomToBottom;
        this.layout.baselineToBaseline = layoutParams.baselineToBaseline;
        this.layout.startToEnd = layoutParams.startToEnd;
        this.layout.startToStart = layoutParams.startToStart;
        this.layout.endToStart = layoutParams.endToStart;
        this.layout.endToEnd = layoutParams.endToEnd;
        this.layout.horizontalBias = layoutParams.horizontalBias;
        this.layout.verticalBias = layoutParams.verticalBias;
        this.layout.dimensionRatio = layoutParams.dimensionRatio;
        this.layout.circleConstraint = layoutParams.circleConstraint;
        this.layout.circleRadius = layoutParams.circleRadius;
        this.layout.circleAngle = layoutParams.circleAngle;
        this.layout.editorAbsoluteX = layoutParams.editorAbsoluteX;
        this.layout.editorAbsoluteY = layoutParams.editorAbsoluteY;
        this.layout.orientation = layoutParams.orientation;
        this.layout.guidePercent = layoutParams.guidePercent;
        this.layout.guideBegin = layoutParams.guideBegin;
        this.layout.guideEnd = layoutParams.guideEnd;
        this.layout.mWidth = layoutParams.width;
        this.layout.mHeight = layoutParams.height;
        this.layout.leftMargin = layoutParams.leftMargin;
        this.layout.rightMargin = layoutParams.rightMargin;
        this.layout.topMargin = layoutParams.topMargin;
        this.layout.bottomMargin = layoutParams.bottomMargin;
        this.layout.verticalWeight = layoutParams.verticalWeight;
        this.layout.horizontalWeight = layoutParams.horizontalWeight;
        this.layout.verticalChainStyle = layoutParams.verticalChainStyle;
        this.layout.horizontalChainStyle = layoutParams.horizontalChainStyle;
        this.layout.constrainedWidth = layoutParams.constrainedWidth;
        this.layout.constrainedHeight = layoutParams.constrainedHeight;
        this.layout.widthDefault = layoutParams.matchConstraintDefaultWidth;
        this.layout.heightDefault = layoutParams.matchConstraintDefaultHeight;
        this.layout.widthMax = layoutParams.matchConstraintMaxWidth;
        this.layout.heightMax = layoutParams.matchConstraintMaxHeight;
        this.layout.widthMin = layoutParams.matchConstraintMinWidth;
        this.layout.heightMin = layoutParams.matchConstraintMinHeight;
        this.layout.widthPercent = layoutParams.matchConstraintPercentWidth;
        this.layout.heightPercent = layoutParams.matchConstraintPercentHeight;
        this.layout.mConstraintTag = layoutParams.constraintTag;
        this.layout.goneTopMargin = layoutParams.goneTopMargin;
        this.layout.goneBottomMargin = layoutParams.goneBottomMargin;
        this.layout.goneLeftMargin = layoutParams.goneLeftMargin;
        this.layout.goneRightMargin = layoutParams.goneRightMargin;
        this.layout.goneStartMargin = layoutParams.goneStartMargin;
        this.layout.goneEndMargin = layoutParams.goneEndMargin;
        if (Build.VERSION.SDK_INT < 17) return;
        this.layout.endMargin = layoutParams.getMarginEnd();
        this.layout.startMargin = layoutParams.getMarginStart();
    }

    private void fillFromConstraints(int n, Constraints.LayoutParams layoutParams) {
        this.fillFrom(n, (ConstraintLayout.LayoutParams)layoutParams);
        this.propertySet.alpha = layoutParams.alpha;
        this.transform.rotation = layoutParams.rotation;
        this.transform.rotationX = layoutParams.rotationX;
        this.transform.rotationY = layoutParams.rotationY;
        this.transform.scaleX = layoutParams.scaleX;
        this.transform.scaleY = layoutParams.scaleY;
        this.transform.transformPivotX = layoutParams.transformPivotX;
        this.transform.transformPivotY = layoutParams.transformPivotY;
        this.transform.translationX = layoutParams.translationX;
        this.transform.translationY = layoutParams.translationY;
        this.transform.translationZ = layoutParams.translationZ;
        this.transform.elevation = layoutParams.elevation;
        this.transform.applyElevation = layoutParams.applyElevation;
    }

    private void fillFromConstraints(ConstraintHelper constraintHelper, int n, Constraints.LayoutParams layoutParams) {
        this.fillFromConstraints(n, layoutParams);
        if (!(constraintHelper instanceof Barrier)) return;
        this.layout.mHelperType = 1;
        constraintHelper = (Barrier)constraintHelper;
        this.layout.mBarrierDirection = constraintHelper.getType();
        this.layout.mReferenceIds = constraintHelper.getReferencedIds();
        this.layout.mBarrierMargin = constraintHelper.getMargin();
    }

    private ConstraintAttribute get(String string, ConstraintAttribute.AttributeType object) {
        if (this.mCustomConstraints.containsKey(string)) {
            if ((string = this.mCustomConstraints.get(string)).getType() == object) return string;
            object = new StringBuilder();
            ((StringBuilder)object).append("ConstraintAttribute is already a ");
            ((StringBuilder)object).append(string.getType().name());
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        object = new ConstraintAttribute(string, (ConstraintAttribute.AttributeType)object);
        this.mCustomConstraints.put(string, (ConstraintAttribute)object);
        string = object;
        return string;
    }

    private void setColorValue(String string, int n) {
        this.get(string, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(n);
    }

    private void setFloatValue(String string, float f) {
        this.get(string, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(f);
    }

    private void setIntValue(String string, int n) {
        this.get(string, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(n);
    }

    private void setStringValue(String string, String string2) {
        this.get(string, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(string2);
    }

    public void applyTo(ConstraintLayout.LayoutParams layoutParams) {
        layoutParams.leftToLeft = this.layout.leftToLeft;
        layoutParams.leftToRight = this.layout.leftToRight;
        layoutParams.rightToLeft = this.layout.rightToLeft;
        layoutParams.rightToRight = this.layout.rightToRight;
        layoutParams.topToTop = this.layout.topToTop;
        layoutParams.topToBottom = this.layout.topToBottom;
        layoutParams.bottomToTop = this.layout.bottomToTop;
        layoutParams.bottomToBottom = this.layout.bottomToBottom;
        layoutParams.baselineToBaseline = this.layout.baselineToBaseline;
        layoutParams.startToEnd = this.layout.startToEnd;
        layoutParams.startToStart = this.layout.startToStart;
        layoutParams.endToStart = this.layout.endToStart;
        layoutParams.endToEnd = this.layout.endToEnd;
        layoutParams.leftMargin = this.layout.leftMargin;
        layoutParams.rightMargin = this.layout.rightMargin;
        layoutParams.topMargin = this.layout.topMargin;
        layoutParams.bottomMargin = this.layout.bottomMargin;
        layoutParams.goneStartMargin = this.layout.goneStartMargin;
        layoutParams.goneEndMargin = this.layout.goneEndMargin;
        layoutParams.goneTopMargin = this.layout.goneTopMargin;
        layoutParams.goneBottomMargin = this.layout.goneBottomMargin;
        layoutParams.horizontalBias = this.layout.horizontalBias;
        layoutParams.verticalBias = this.layout.verticalBias;
        layoutParams.circleConstraint = this.layout.circleConstraint;
        layoutParams.circleRadius = this.layout.circleRadius;
        layoutParams.circleAngle = this.layout.circleAngle;
        layoutParams.dimensionRatio = this.layout.dimensionRatio;
        layoutParams.editorAbsoluteX = this.layout.editorAbsoluteX;
        layoutParams.editorAbsoluteY = this.layout.editorAbsoluteY;
        layoutParams.verticalWeight = this.layout.verticalWeight;
        layoutParams.horizontalWeight = this.layout.horizontalWeight;
        layoutParams.verticalChainStyle = this.layout.verticalChainStyle;
        layoutParams.horizontalChainStyle = this.layout.horizontalChainStyle;
        layoutParams.constrainedWidth = this.layout.constrainedWidth;
        layoutParams.constrainedHeight = this.layout.constrainedHeight;
        layoutParams.matchConstraintDefaultWidth = this.layout.widthDefault;
        layoutParams.matchConstraintDefaultHeight = this.layout.heightDefault;
        layoutParams.matchConstraintMaxWidth = this.layout.widthMax;
        layoutParams.matchConstraintMaxHeight = this.layout.heightMax;
        layoutParams.matchConstraintMinWidth = this.layout.widthMin;
        layoutParams.matchConstraintMinHeight = this.layout.heightMin;
        layoutParams.matchConstraintPercentWidth = this.layout.widthPercent;
        layoutParams.matchConstraintPercentHeight = this.layout.heightPercent;
        layoutParams.orientation = this.layout.orientation;
        layoutParams.guidePercent = this.layout.guidePercent;
        layoutParams.guideBegin = this.layout.guideBegin;
        layoutParams.guideEnd = this.layout.guideEnd;
        layoutParams.width = this.layout.mWidth;
        layoutParams.height = this.layout.mHeight;
        if (this.layout.mConstraintTag != null) {
            layoutParams.constraintTag = this.layout.mConstraintTag;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(this.layout.startMargin);
            layoutParams.setMarginEnd(this.layout.endMargin);
        }
        layoutParams.validate();
    }

    public ConstraintSet.Constraint clone() {
        ConstraintSet.Constraint constraint = new ConstraintSet.Constraint();
        constraint.layout.copyFrom(this.layout);
        constraint.motion.copyFrom(this.motion);
        constraint.propertySet.copyFrom(this.propertySet);
        constraint.transform.copyFrom(this.transform);
        constraint.mViewId = this.mViewId;
        return constraint;
    }
}
