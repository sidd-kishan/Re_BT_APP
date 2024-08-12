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
 *  androidx.constraintlayout.solver.widgets.HelperWidget
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.util.HashMap;

public class Barrier
extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private static final boolean USE_RESOLUTION = true;
    private boolean mAllowsGoneWidget = true;
    private int mBarrierType = 0;
    private int mMargin = 0;
    boolean resolved = false;

    public Barrier() {
    }

    public Barrier(String string) {
        this.setDebugName(string);
    }

    public void addToSolver(LinearSystem linearSystem, boolean bl) {
        int n;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor;
        int n2;
        block17: {
            this.mListAnchors[0] = this.mLeft;
            this.mListAnchors[2] = this.mTop;
            this.mListAnchors[1] = this.mRight;
            this.mListAnchors[3] = this.mBottom;
            for (n2 = 0; n2 < this.mListAnchors.length; ++n2) {
                this.mListAnchors[n2].mSolverVariable = linearSystem.createObjectVariable((Object)this.mListAnchors[n2]);
            }
            n2 = this.mBarrierType;
            if (n2 < 0) return;
            if (n2 >= 4) return;
            constraintAnchor = this.mListAnchors[this.mBarrierType];
            if (!this.resolved) {
                this.allSolved();
            }
            if (this.resolved) {
                this.resolved = false;
                n2 = this.mBarrierType;
                if (n2 != 0 && n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) return;
                    }
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mY);
                    linearSystem.addEquality(this.mBottom.mSolverVariable, this.mY);
                } else {
                    linearSystem.addEquality(this.mLeft.mSolverVariable, this.mX);
                    linearSystem.addEquality(this.mRight.mSolverVariable, this.mX);
                }
                return;
            }
            for (n2 = 0; n2 < this.mWidgetsCount; ++n2) {
                constraintWidget = this.mWidgets[n2];
                if (!this.mAllowsGoneWidget && !constraintWidget.allowedInBarrier() || ((n = this.mBarrierType) != 0 && n != 1 || constraintWidget.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget == null) && ((n = this.mBarrierType) != 2 && n != 3 || constraintWidget.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mTop.mTarget == null || constraintWidget.mBottom.mTarget == null)) continue;
                bl = true;
                break block17;
            }
            bl = false;
        }
        n2 = !this.mLeft.hasCenteredDependents() && !this.mRight.hasCenteredDependents() ? 0 : 1;
        n = !this.mTop.hasCenteredDependents() && !this.mBottom.hasCenteredDependents() ? 0 : 1;
        n = !bl && (this.mBarrierType == 0 && n2 != 0 || this.mBarrierType == 2 && n != 0 || this.mBarrierType == 1 && n2 != 0 || this.mBarrierType == 3 && n != 0) ? 1 : 0;
        n2 = 5;
        if (n == 0) {
            n2 = 4;
        }
        for (n = 0; n < this.mWidgetsCount; ++n) {
            ConstraintWidget constraintWidget2 = this.mWidgets[n];
            if (!this.mAllowsGoneWidget && !constraintWidget2.allowedInBarrier()) continue;
            constraintWidget = linearSystem.createObjectVariable((Object)constraintWidget2.mListAnchors[this.mBarrierType]);
            constraintWidget2.mListAnchors[this.mBarrierType].mSolverVariable = constraintWidget;
            int n3 = constraintWidget2.mListAnchors[this.mBarrierType].mTarget != null && constraintWidget2.mListAnchors[this.mBarrierType].mTarget.mOwner == this ? constraintWidget2.mListAnchors[this.mBarrierType].mMargin + 0 : 0;
            int n4 = this.mBarrierType;
            if (n4 != 0 && n4 != 2) {
                linearSystem.addGreaterBarrier(constraintAnchor.mSolverVariable, (SolverVariable)constraintWidget, this.mMargin + n3, bl);
            } else {
                linearSystem.addLowerBarrier(constraintAnchor.mSolverVariable, (SolverVariable)constraintWidget, this.mMargin - n3, bl);
            }
            linearSystem.addEquality(constraintAnchor.mSolverVariable, (SolverVariable)constraintWidget, this.mMargin + n3, n2);
        }
        n2 = this.mBarrierType;
        if (n2 == 0) {
            linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
        } else if (n2 == 1) {
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
        } else if (n2 == 2) {
            linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
        } else {
            if (n2 != 3) return;
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
        }
    }

    public boolean allSolved() {
        int n;
        int n2;
        ConstraintWidget constraintWidget;
        int n3;
        int n4 = 0;
        int n5 = 1;
        for (n3 = 0; n3 < this.mWidgetsCount; ++n3) {
            block24: {
                block25: {
                    block26: {
                        block23: {
                            constraintWidget = this.mWidgets[n3];
                            if (this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) break block23;
                            n2 = n5;
                            break block24;
                        }
                        n2 = this.mBarrierType;
                        if ((n2 == 0 || n2 == 1) && !constraintWidget.isResolvedHorizontally()) break block25;
                        n = this.mBarrierType;
                        if (n == 2) break block26;
                        n2 = n5;
                        if (n != 3) break block24;
                    }
                    n2 = n5;
                    if (constraintWidget.isResolvedVertically()) break block24;
                }
                n2 = 0;
            }
            n5 = n2;
        }
        if (n5 == 0) return false;
        if (this.mWidgetsCount <= 0) return false;
        n5 = 0;
        n = 0;
        while (n4 < this.mWidgetsCount) {
            constraintWidget = this.mWidgets[n4];
            if (this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) {
                int n6;
                n2 = n5;
                n3 = n;
                if (n == 0) {
                    n3 = this.mBarrierType;
                    if (n3 == 0) {
                        n5 = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue();
                    } else if (n3 == 1) {
                        n5 = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue();
                    } else if (n3 == 2) {
                        n5 = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue();
                    } else if (n3 == 3) {
                        n5 = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue();
                    }
                    n3 = 1;
                    n2 = n5;
                }
                if ((n6 = this.mBarrierType) == 0) {
                    n5 = Math.min(n2, constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue());
                    n = n3;
                } else if (n6 == 1) {
                    n5 = Math.max(n2, constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue());
                    n = n3;
                } else if (n6 == 2) {
                    n5 = Math.min(n2, constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue());
                    n = n3;
                } else {
                    n5 = n2;
                    n = n3;
                    if (n6 == 3) {
                        n5 = Math.max(n2, constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue());
                        n = n3;
                    }
                }
            }
            ++n4;
        }
        n3 = n5 + this.mMargin;
        n5 = this.mBarrierType;
        if (n5 != 0 && n5 != 1) {
            this.setFinalVertical(n3, n3);
        } else {
            this.setFinalHorizontal(n3, n3);
        }
        this.resolved = true;
        return true;
    }

    public boolean allowedInBarrier() {
        return true;
    }

    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    public void copy(ConstraintWidget object, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(object, hashMap);
        object = (Barrier)((Object)object);
        this.mBarrierType = object.mBarrierType;
        this.mAllowsGoneWidget = object.mAllowsGoneWidget;
        this.mMargin = object.mMargin;
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public int getMargin() {
        return this.mMargin;
    }

    public int getOrientation() {
        int n = this.mBarrierType;
        if (n == 0) return 0;
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 1;
        return -1;
    }

    public boolean isResolvedHorizontally() {
        return this.resolved;
    }

    public boolean isResolvedVertically() {
        return this.resolved;
    }

    protected void markWidgets() {
        int n = 0;
        while (n < this.mWidgetsCount) {
            ConstraintWidget constraintWidget = this.mWidgets[n];
            int n2 = this.mBarrierType;
            if (n2 != 0 && n2 != 1) {
                if (n2 == 2 || n2 == 3) {
                    constraintWidget.setInBarrier(1, true);
                }
            } else {
                constraintWidget.setInBarrier(0, true);
            }
            ++n;
        }
    }

    public void setAllowsGoneWidget(boolean bl) {
        this.mAllowsGoneWidget = bl;
    }

    public void setBarrierType(int n) {
        this.mBarrierType = n;
    }

    public void setMargin(int n) {
        this.mMargin = n;
    }

    public String toString() {
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("[Barrier] ");
        ((StringBuilder)charSequence).append(this.getDebugName());
        ((StringBuilder)charSequence).append(" {");
        charSequence = ((StringBuilder)charSequence).toString();
        int n = 0;
        while (true) {
            CharSequence charSequence2;
            if (n >= this.mWidgetsCount) {
                charSequence2 = new StringBuilder();
                charSequence2.append((String)charSequence);
                charSequence2.append("}");
                return charSequence2.toString();
            }
            ConstraintWidget constraintWidget = this.mWidgets[n];
            charSequence2 = charSequence;
            if (n > 0) {
                charSequence2 = new StringBuilder();
                charSequence2.append((String)charSequence);
                charSequence2.append(", ");
                charSequence2 = charSequence2.toString();
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)charSequence2);
            ((StringBuilder)charSequence).append(constraintWidget.getDebugName());
            charSequence = ((StringBuilder)charSequence).toString();
            ++n;
        }
    }
}
