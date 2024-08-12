/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.Cache
 *  androidx.constraintlayout.solver.SolverVariable
 *  androidx.constraintlayout.solver.SolverVariable$Type
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor$1
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.Guideline
 *  androidx.constraintlayout.solver.widgets.analyzer.Grouping
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.analyzer.Grouping;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ConstraintAnchor {
    private static final boolean ALLOW_BINARY = false;
    private static final int UNSET_GONE_MARGIN = -1;
    private HashSet<ConstraintAnchor> mDependents = null;
    private int mFinalValue;
    int mGoneMargin = -1;
    private boolean mHasFinalValue;
    public int mMargin = 0;
    public final ConstraintWidget mOwner;
    SolverVariable mSolverVariable;
    public ConstraintAnchor mTarget;
    public final Type mType;

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.mOwner = constraintWidget;
        this.mType = type;
    }

    private boolean isConnectionToMe(ConstraintWidget object, HashSet<ConstraintWidget> hashSet) {
        if (hashSet.contains(object)) {
            return false;
        }
        hashSet.add((ConstraintWidget)object);
        if (object == this.getOwner()) {
            return true;
        }
        ArrayList arrayList = object.getAnchors();
        int n = arrayList.size();
        int n2 = 0;
        while (n2 < n) {
            object = (ConstraintAnchor)arrayList.get(n2);
            if (((ConstraintAnchor)object).isSimilarDimensionConnection(this) && ((ConstraintAnchor)object).isConnected() && this.isConnectionToMe(((ConstraintAnchor)object).getTarget().getOwner(), hashSet)) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int n) {
        return this.connect(constraintAnchor, n, -1, false);
    }

    public boolean connect(ConstraintAnchor object, int n, int n2, boolean bl) {
        if (object == null) {
            this.reset();
            return true;
        }
        if (!bl && !this.isValidConnection((ConstraintAnchor)object)) {
            return false;
        }
        this.mTarget = object;
        if (((ConstraintAnchor)object).mDependents == null) {
            ((ConstraintAnchor)object).mDependents = new HashSet();
        }
        if ((object = this.mTarget.mDependents) != null) {
            ((HashSet)object).add(this);
        }
        this.mMargin = n > 0 ? n : 0;
        this.mGoneMargin = n2;
        return true;
    }

    public void copyFrom(ConstraintAnchor constraintAnchor, HashMap<ConstraintWidget, ConstraintWidget> object) {
        Object object2 = this.mTarget;
        if (object2 != null && (object2 = ((ConstraintAnchor)object2).mDependents) != null) {
            ((HashSet)object2).remove(this);
        }
        if ((object2 = constraintAnchor.mTarget) != null) {
            object2 = ((ConstraintAnchor)object2).getType();
            this.mTarget = ((HashMap)object).get(constraintAnchor.mTarget.mOwner).getAnchor((Type)object2);
        } else {
            this.mTarget = null;
        }
        object = this.mTarget;
        if (object != null) {
            if (((ConstraintAnchor)object).mDependents == null) {
                ((ConstraintAnchor)object).mDependents = new HashSet();
            }
            this.mTarget.mDependents.add(this);
        }
        this.mMargin = constraintAnchor.mMargin;
        this.mGoneMargin = constraintAnchor.mGoneMargin;
    }

    public void findDependents(int n, ArrayList<WidgetGroup> arrayList, WidgetGroup widgetGroup) {
        HashSet<ConstraintAnchor> hashSet = this.mDependents;
        if (hashSet == null) return;
        hashSet = hashSet.iterator();
        while (hashSet.hasNext()) {
            Grouping.findDependents((ConstraintWidget)((ConstraintAnchor)hashSet.next()).mOwner, (int)n, arrayList, (WidgetGroup)widgetGroup);
        }
    }

    public HashSet<ConstraintAnchor> getDependents() {
        return this.mDependents;
    }

    public int getFinalValue() {
        if (this.mHasFinalValue) return this.mFinalValue;
        return 0;
    }

    public int getMargin() {
        if (this.mOwner.getVisibility() == 8) {
            return 0;
        }
        if (this.mGoneMargin <= -1) return this.mMargin;
        ConstraintAnchor constraintAnchor = this.mTarget;
        if (constraintAnchor == null) return this.mMargin;
        if (constraintAnchor.mOwner.getVisibility() != 8) return this.mMargin;
        return this.mGoneMargin;
    }

    public final ConstraintAnchor getOpposite() {
        switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            default: {
                throw new AssertionError((Object)this.mType.name());
            }
            case 5: {
                return this.mOwner.mTop;
            }
            case 4: {
                return this.mOwner.mBottom;
            }
            case 3: {
                return this.mOwner.mLeft;
            }
            case 2: {
                return this.mOwner.mRight;
            }
            case 1: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
        }
        return null;
    }

    public ConstraintWidget getOwner() {
        return this.mOwner;
    }

    public SolverVariable getSolverVariable() {
        return this.mSolverVariable;
    }

    public ConstraintAnchor getTarget() {
        return this.mTarget;
    }

    public Type getType() {
        return this.mType;
    }

    public boolean hasCenteredDependents() {
        HashSet<ConstraintAnchor> hashSet = this.mDependents;
        if (hashSet == null) {
            return false;
        }
        hashSet = hashSet.iterator();
        do {
            if (!hashSet.hasNext()) return false;
        } while (!((ConstraintAnchor)hashSet.next()).getOpposite().isConnected());
        return true;
    }

    public boolean hasDependents() {
        HashSet<ConstraintAnchor> hashSet = this.mDependents;
        boolean bl = false;
        if (hashSet == null) {
            return false;
        }
        if (hashSet.size() <= 0) return bl;
        bl = true;
        return bl;
    }

    public boolean hasFinalValue() {
        return this.mHasFinalValue;
    }

    public boolean isConnected() {
        boolean bl = this.mTarget != null;
        return bl;
    }

    public boolean isConnectionAllowed(ConstraintWidget constraintWidget) {
        if (this.isConnectionToMe(constraintWidget, new HashSet<ConstraintWidget>())) {
            return false;
        }
        ConstraintWidget constraintWidget2 = this.getOwner().getParent();
        if (constraintWidget2 == constraintWidget) {
            return true;
        }
        if (constraintWidget.getParent() != constraintWidget2) return false;
        return true;
    }

    public boolean isConnectionAllowed(ConstraintWidget constraintWidget, ConstraintAnchor constraintAnchor) {
        return this.isConnectionAllowed(constraintWidget);
    }

    public boolean isSideAnchor() {
        switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            default: {
                throw new AssertionError((Object)this.mType.name());
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return true;
            }
            case 1: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
        }
        return false;
    }

    public boolean isSimilarDimensionConnection(ConstraintAnchor constraintAnchor) {
        Type type = constraintAnchor.getType();
        constraintAnchor = this.mType;
        boolean bl = true;
        boolean bl2 = true;
        boolean bl3 = true;
        if (type == constraintAnchor) {
            return true;
        }
        switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            default: {
                throw new AssertionError((Object)this.mType.name());
            }
            case 9: {
                return false;
            }
            case 4: 
            case 5: 
            case 6: 
            case 8: {
                bl2 = bl3;
                if (type == Type.TOP) return bl2;
                bl2 = bl3;
                if (type == Type.BOTTOM) return bl2;
                bl2 = bl3;
                if (type == Type.CENTER_Y) return bl2;
                bl2 = type == Type.BASELINE ? bl3 : false;
                return bl2;
            }
            case 2: 
            case 3: 
            case 7: {
                bl2 = bl;
                if (type == Type.LEFT) return bl2;
                bl2 = bl;
                if (type == Type.RIGHT) return bl2;
                bl2 = type == Type.CENTER_X ? bl : false;
                return bl2;
            }
            case 1: 
        }
        if (type != Type.BASELINE) return bl2;
        bl2 = false;
        return bl2;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean isValidConnection(ConstraintAnchor constraintAnchor) {
        Type type;
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        if (constraintAnchor == null) {
            return false;
        }
        Type type2 = constraintAnchor.getType();
        if (type2 == (type = this.mType)) {
            if (type != Type.BASELINE) return true;
            if (!constraintAnchor.getOwner().hasBaseline()) return false;
            if (this.getOwner().hasBaseline()) return true;
            return false;
        }
        switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            default: {
                throw new AssertionError((Object)this.mType.name());
            }
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                return false;
            }
            case 4: 
            case 5: {
                boolean bl4 = type2 == Type.TOP || type2 == Type.BOTTOM;
                bl2 = bl4;
                if (!(constraintAnchor.getOwner() instanceof Guideline)) return bl2;
                if (bl4) return true;
                bl4 = bl3;
                if (type2 != Type.CENTER_Y) return bl4;
                return true;
            }
            case 2: 
            case 3: {
                boolean bl5 = type2 == Type.LEFT || type2 == Type.RIGHT;
                bl2 = bl5;
                if (!(constraintAnchor.getOwner() instanceof Guideline)) return bl2;
                if (bl5) return true;
                bl5 = bl;
                if (type2 != Type.CENTER_X) return bl5;
                return true;
            }
            case 1: 
        }
        boolean bl6 = bl2;
        if (type2 == Type.BASELINE) return bl6;
        bl6 = bl2;
        if (type2 == Type.CENTER_X) return bl6;
        bl6 = bl2;
        if (type2 == Type.CENTER_Y) return bl6;
        return true;
    }

    public boolean isVerticalAnchor() {
        switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            default: {
                throw new AssertionError((Object)this.mType.name());
            }
            case 4: 
            case 5: 
            case 6: 
            case 8: 
            case 9: {
                return true;
            }
            case 1: 
            case 2: 
            case 3: 
            case 7: 
        }
        return false;
    }

    public void reset() {
        Object object = this.mTarget;
        if (object != null && (object = ((ConstraintAnchor)object).mDependents) != null) {
            ((HashSet)object).remove(this);
            if (this.mTarget.mDependents.size() == 0) {
                this.mTarget.mDependents = null;
            }
        }
        this.mDependents = null;
        this.mTarget = null;
        this.mMargin = 0;
        this.mGoneMargin = -1;
        this.mHasFinalValue = false;
        this.mFinalValue = 0;
    }

    public void resetFinalResolution() {
        this.mHasFinalValue = false;
        this.mFinalValue = 0;
    }

    public void resetSolverVariable(Cache cache) {
        cache = this.mSolverVariable;
        if (cache == null) {
            this.mSolverVariable = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        } else {
            cache.reset();
        }
    }

    public void setFinalValue(int n) {
        this.mFinalValue = n;
        this.mHasFinalValue = true;
    }

    public void setGoneMargin(int n) {
        if (!this.isConnected()) return;
        this.mGoneMargin = n;
    }

    public void setMargin(int n) {
        if (!this.isConnected()) return;
        this.mMargin = n;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mOwner.getDebugName());
        stringBuilder.append(":");
        stringBuilder.append(this.mType.toString());
        return stringBuilder.toString();
    }
}
