/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.LinearSystem
 *  androidx.constraintlayout.solver.SolverVariable
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour
 *  androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
 *  androidx.constraintlayout.solver.widgets.Guideline$1
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import java.util.HashMap;

public class Guideline
extends ConstraintWidget {
    public static final int HORIZONTAL = 0;
    public static final int RELATIVE_BEGIN = 1;
    public static final int RELATIVE_END = 2;
    public static final int RELATIVE_PERCENT = 0;
    public static final int RELATIVE_UNKNWON = -1;
    public static final int VERTICAL = 1;
    private ConstraintAnchor mAnchor = this.mTop;
    private int mMinimumPosition;
    private int mOrientation;
    protected int mRelativeBegin = -1;
    protected int mRelativeEnd = -1;
    protected float mRelativePercent = -1.0f;
    private boolean resolved;

    public Guideline() {
        int n = 0;
        this.mOrientation = 0;
        this.mMinimumPosition = 0;
        this.mAnchors.clear();
        this.mAnchors.add(this.mAnchor);
        int n2 = this.mListAnchors.length;
        while (n < n2) {
            this.mListAnchors[n] = this.mAnchor;
            ++n;
        }
    }

    public void addToSolver(LinearSystem linearSystem, boolean bl) {
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer)this.getParent();
        if (constraintWidgetContainer == null) {
            return;
        }
        ConstraintAnchor constraintAnchor = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor constraintAnchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget constraintWidget = this.mParent;
        boolean bl2 = true;
        boolean bl3 = constraintWidget != null && this.mParent.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (this.mOrientation == 0) {
            constraintAnchor = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.TOP);
            constraintAnchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.BOTTOM);
            bl3 = this.mParent != null && this.mParent.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? bl2 : false;
        }
        if (this.resolved && this.mAnchor.hasFinalValue()) {
            constraintWidgetContainer = linearSystem.createObjectVariable((Object)this.mAnchor);
            linearSystem.addEquality((SolverVariable)constraintWidgetContainer, this.mAnchor.getFinalValue());
            if (this.mRelativeBegin != -1) {
                if (bl3) {
                    linearSystem.addGreaterThan(linearSystem.createObjectVariable((Object)constraintAnchor2), (SolverVariable)constraintWidgetContainer, 0, 5);
                }
            } else if (this.mRelativeEnd != -1 && bl3) {
                constraintAnchor2 = linearSystem.createObjectVariable((Object)constraintAnchor2);
                linearSystem.addGreaterThan((SolverVariable)constraintWidgetContainer, linearSystem.createObjectVariable((Object)constraintAnchor), 0, 5);
                linearSystem.addGreaterThan((SolverVariable)constraintAnchor2, (SolverVariable)constraintWidgetContainer, 0, 5);
            }
            this.resolved = false;
            return;
        }
        if (this.mRelativeBegin != -1) {
            constraintWidgetContainer = linearSystem.createObjectVariable((Object)this.mAnchor);
            linearSystem.addEquality((SolverVariable)constraintWidgetContainer, linearSystem.createObjectVariable((Object)constraintAnchor), this.mRelativeBegin, 8);
            if (!bl3) return;
            linearSystem.addGreaterThan(linearSystem.createObjectVariable((Object)constraintAnchor2), (SolverVariable)constraintWidgetContainer, 0, 5);
        } else if (this.mRelativeEnd != -1) {
            constraintWidgetContainer = linearSystem.createObjectVariable((Object)this.mAnchor);
            constraintAnchor2 = linearSystem.createObjectVariable((Object)constraintAnchor2);
            linearSystem.addEquality((SolverVariable)constraintWidgetContainer, (SolverVariable)constraintAnchor2, -this.mRelativeEnd, 8);
            if (!bl3) return;
            linearSystem.addGreaterThan((SolverVariable)constraintWidgetContainer, linearSystem.createObjectVariable((Object)constraintAnchor), 0, 5);
            linearSystem.addGreaterThan((SolverVariable)constraintAnchor2, (SolverVariable)constraintWidgetContainer, 0, 5);
        } else {
            if (this.mRelativePercent == -1.0f) return;
            linearSystem.addConstraint(LinearSystem.createRowDimensionPercent((LinearSystem)linearSystem, (SolverVariable)linearSystem.createObjectVariable((Object)this.mAnchor), (SolverVariable)linearSystem.createObjectVariable((Object)constraintAnchor2), (float)this.mRelativePercent));
        }
    }

    public boolean allowedInBarrier() {
        return true;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        constraintWidget = (Guideline)constraintWidget;
        this.mRelativePercent = constraintWidget.mRelativePercent;
        this.mRelativeBegin = constraintWidget.mRelativeBegin;
        this.mRelativeEnd = constraintWidget.mRelativeEnd;
        this.setOrientation(constraintWidget.mOrientation);
    }

    public void cyclePosition() {
        if (this.mRelativeBegin != -1) {
            this.inferRelativePercentPosition();
        } else if (this.mRelativePercent != -1.0f) {
            this.inferRelativeEndPosition();
        } else {
            if (this.mRelativeEnd == -1) return;
            this.inferRelativeBeginPosition();
        }
    }

    public ConstraintAnchor getAnchor() {
        return this.mAnchor;
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()]) {
            default: {
                break;
            }
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                return null;
            }
            case 3: 
            case 4: {
                if (this.mOrientation != 0) throw new AssertionError((Object)type.name());
                return this.mAnchor;
            }
            case 1: 
            case 2: {
                if (this.mOrientation != 1) throw new AssertionError((Object)type.name());
                return this.mAnchor;
            }
        }
        throw new AssertionError((Object)type.name());
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getRelativeBegin() {
        return this.mRelativeBegin;
    }

    public int getRelativeBehaviour() {
        if (this.mRelativePercent != -1.0f) {
            return 0;
        }
        if (this.mRelativeBegin != -1) {
            return 1;
        }
        if (this.mRelativeEnd == -1) return -1;
        return 2;
    }

    public int getRelativeEnd() {
        return this.mRelativeEnd;
    }

    public float getRelativePercent() {
        return this.mRelativePercent;
    }

    public String getType() {
        return "Guideline";
    }

    void inferRelativeBeginPosition() {
        int n = this.getX();
        if (this.mOrientation == 0) {
            n = this.getY();
        }
        this.setGuideBegin(n);
    }

    void inferRelativeEndPosition() {
        int n = this.getParent().getWidth() - this.getX();
        if (this.mOrientation == 0) {
            n = this.getParent().getHeight() - this.getY();
        }
        this.setGuideEnd(n);
    }

    void inferRelativePercentPosition() {
        float f = (float)this.getX() / (float)this.getParent().getWidth();
        if (this.mOrientation == 0) {
            f = (float)this.getY() / (float)this.getParent().getHeight();
        }
        this.setGuidePercent(f);
    }

    public boolean isPercent() {
        boolean bl = this.mRelativePercent != -1.0f && this.mRelativeBegin == -1 && this.mRelativeEnd == -1;
        return bl;
    }

    public boolean isResolvedHorizontally() {
        return this.resolved;
    }

    public boolean isResolvedVertically() {
        return this.resolved;
    }

    public void setFinalValue(int n) {
        this.mAnchor.setFinalValue(n);
        this.resolved = true;
    }

    public void setGuideBegin(int n) {
        if (n <= -1) return;
        this.mRelativePercent = -1.0f;
        this.mRelativeBegin = n;
        this.mRelativeEnd = -1;
    }

    public void setGuideEnd(int n) {
        if (n <= -1) return;
        this.mRelativePercent = -1.0f;
        this.mRelativeBegin = -1;
        this.mRelativeEnd = n;
    }

    public void setGuidePercent(float f) {
        if (!(f > -1.0f)) return;
        this.mRelativePercent = f;
        this.mRelativeBegin = -1;
        this.mRelativeEnd = -1;
    }

    public void setGuidePercent(int n) {
        this.setGuidePercent((float)n / 100.0f);
    }

    public void setMinimumPosition(int n) {
        this.mMinimumPosition = n;
    }

    public void setOrientation(int n) {
        if (this.mOrientation == n) {
            return;
        }
        this.mOrientation = n;
        this.mAnchors.clear();
        this.mAnchor = this.mOrientation == 1 ? this.mLeft : this.mTop;
        this.mAnchors.add(this.mAnchor);
        int n2 = this.mListAnchors.length;
        n = 0;
        while (n < n2) {
            this.mListAnchors[n] = this.mAnchor;
            ++n;
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, boolean bl) {
        if (this.getParent() == null) {
            return;
        }
        int n = linearSystem.getObjectVariableValue((Object)this.mAnchor);
        if (this.mOrientation == 1) {
            this.setX(n);
            this.setY(0);
            this.setHeight(this.getParent().getHeight());
            this.setWidth(0);
        } else {
            this.setX(0);
            this.setY(n);
            this.setWidth(this.getParent().getWidth());
            this.setHeight(0);
        }
    }
}
