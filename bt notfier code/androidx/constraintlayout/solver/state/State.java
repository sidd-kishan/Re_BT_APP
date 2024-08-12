/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.state.ConstraintReference
 *  androidx.constraintlayout.solver.state.Dimension
 *  androidx.constraintlayout.solver.state.HelperReference
 *  androidx.constraintlayout.solver.state.Reference
 *  androidx.constraintlayout.solver.state.State$1
 *  androidx.constraintlayout.solver.state.State$Direction
 *  androidx.constraintlayout.solver.state.State$Helper
 *  androidx.constraintlayout.solver.state.helpers.AlignHorizontallyReference
 *  androidx.constraintlayout.solver.state.helpers.AlignVerticallyReference
 *  androidx.constraintlayout.solver.state.helpers.BarrierReference
 *  androidx.constraintlayout.solver.state.helpers.GuidelineReference
 *  androidx.constraintlayout.solver.state.helpers.HorizontalChainReference
 *  androidx.constraintlayout.solver.state.helpers.VerticalChainReference
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
 *  androidx.constraintlayout.solver.widgets.HelperWidget
 */
package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.Dimension;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.Reference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.helpers.AlignHorizontallyReference;
import androidx.constraintlayout.solver.state.helpers.AlignVerticallyReference;
import androidx.constraintlayout.solver.state.helpers.BarrierReference;
import androidx.constraintlayout.solver.state.helpers.GuidelineReference;
import androidx.constraintlayout.solver.state.helpers.HorizontalChainReference;
import androidx.constraintlayout.solver.state.helpers.VerticalChainReference;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.util.HashMap;
import java.util.Iterator;

public class State {
    static final int CONSTRAINT_RATIO = 2;
    static final int CONSTRAINT_SPREAD = 0;
    static final int CONSTRAINT_WRAP = 1;
    public static final Integer PARENT = 0;
    static final int UNKNOWN = -1;
    protected HashMap<Object, HelperReference> mHelperReferences;
    public final ConstraintReference mParent;
    protected HashMap<Object, Reference> mReferences = new HashMap();
    private int numHelpers;

    public State() {
        ConstraintReference constraintReference;
        this.mHelperReferences = new HashMap();
        this.mParent = constraintReference = new ConstraintReference(this);
        this.numHelpers = 0;
        this.mReferences.put(PARENT, (Reference)constraintReference);
    }

    private String createHelperKey() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("__HELPER_KEY_");
        int n = this.numHelpers;
        this.numHelpers = n + 1;
        stringBuilder.append(n);
        stringBuilder.append("__");
        return stringBuilder.toString();
    }

    /*
     * WARNING - void declaration
     */
    public void apply(ConstraintWidgetContainer object) {
        object.removeAllChildren();
        this.mParent.getWidth().apply(this, (ConstraintWidget)object, 0);
        this.mParent.getHeight().apply(this, (ConstraintWidget)object, 1);
        for (Object object2 : this.mHelperReferences.keySet()) {
            void helperReference2;
            Reference reference;
            HelperWidget helperWidget = this.mHelperReferences.get(object2).getHelperWidget();
            if (helperWidget == null) continue;
            Reference reference2 = reference = this.mReferences.get(object2);
            if (reference == null) {
                ConstraintReference constraintReference = this.constraints(object2);
            }
            helperReference2.setConstraintWidget((ConstraintWidget)helperWidget);
        }
        for (Object object3 : this.mReferences.keySet()) {
            Object object32 = this.mReferences.get(object3);
            if (object32 != this.mParent) {
                ConstraintWidget constraintWidget = object32.getConstraintWidget();
                constraintWidget.setParent(null);
                if (object32 instanceof GuidelineReference) {
                    object32.apply();
                }
                object.add(constraintWidget);
                continue;
            }
            object32.setConstraintWidget((ConstraintWidget)object);
        }
        for (Object e : this.mHelperReferences.keySet()) {
            HelperReference helperReference = this.mHelperReferences.get(e);
            if (helperReference.getHelperWidget() == null) continue;
            for (Object object32 : helperReference.mReferences) {
                object32 = this.mReferences.get(object32);
                helperReference.getHelperWidget().add(object32.getConstraintWidget());
            }
            helperReference.apply();
        }
        Iterator<Object> iterator = this.mReferences.keySet().iterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            this.mReferences.get(object).apply();
        }
    }

    public BarrierReference barrier(Object object, Direction direction) {
        object = (BarrierReference)this.helper(object, Helper.BARRIER);
        object.setBarrierDirection(direction);
        return object;
    }

    public AlignHorizontallyReference centerHorizontally(Object ... objectArray) {
        AlignHorizontallyReference alignHorizontallyReference = (AlignHorizontallyReference)this.helper(null, Helper.ALIGN_HORIZONTALLY);
        alignHorizontallyReference.add(objectArray);
        return alignHorizontallyReference;
    }

    public AlignVerticallyReference centerVertically(Object ... objectArray) {
        AlignVerticallyReference alignVerticallyReference = (AlignVerticallyReference)this.helper(null, Helper.ALIGN_VERTICALLY);
        alignVerticallyReference.add(objectArray);
        return alignVerticallyReference;
    }

    public ConstraintReference constraints(Object object) {
        Reference reference;
        Reference reference2 = reference = this.mReferences.get(object);
        if (reference == null) {
            reference2 = this.createConstraintReference(object);
            this.mReferences.put(object, reference2);
            reference2.setKey(object);
        }
        if (!(reference2 instanceof ConstraintReference)) return null;
        return (ConstraintReference)reference2;
    }

    public int convertDimension(Object object) {
        if (object instanceof Float) {
            return ((Float)object).intValue();
        }
        if (!(object instanceof Integer)) return 0;
        return (Integer)object;
    }

    public ConstraintReference createConstraintReference(Object object) {
        return new ConstraintReference(this);
    }

    public void directMapping() {
        Iterator<Object> iterator = this.mReferences.keySet().iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            this.constraints(object).setView(object);
        }
    }

    public GuidelineReference guideline(Object object, int n) {
        Reference reference;
        Reference reference2 = reference = this.mReferences.get(object);
        if (reference != null) return (GuidelineReference)reference2;
        reference2 = new GuidelineReference(this);
        reference2.setOrientation(n);
        reference2.setKey(object);
        this.mReferences.put(object, reference2);
        return (GuidelineReference)reference2;
    }

    public State height(Dimension dimension) {
        return this.setHeight(dimension);
    }

    public HelperReference helper(Object object, Helper helper) {
        Object object2 = object;
        if (object == null) {
            object2 = this.createHelperKey();
        }
        HelperReference helperReference = this.mHelperReferences.get(object2);
        object = helperReference;
        if (helperReference != null) return object;
        int n = 1.$SwitchMap$androidx$constraintlayout$solver$state$State$Helper[helper.ordinal()];
        object = n != 1 ? (n != 2 ? (n != 3 ? (n != 4 ? (n != 5 ? new HelperReference(this, helper) : new BarrierReference(this)) : new AlignVerticallyReference(this)) : new AlignHorizontallyReference(this)) : new VerticalChainReference(this)) : new HorizontalChainReference(this);
        this.mHelperReferences.put(object2, (HelperReference)object);
        return object;
    }

    public HorizontalChainReference horizontalChain(Object ... objectArray) {
        HorizontalChainReference horizontalChainReference = (HorizontalChainReference)this.helper(null, Helper.HORIZONTAL_CHAIN);
        horizontalChainReference.add(objectArray);
        return horizontalChainReference;
    }

    public GuidelineReference horizontalGuideline(Object object) {
        return this.guideline(object, 0);
    }

    public void map(Object object, Object object2) {
        this.constraints(object).setView(object2);
    }

    Reference reference(Object object) {
        return this.mReferences.get(object);
    }

    public void reset() {
        this.mHelperReferences.clear();
    }

    public State setHeight(Dimension dimension) {
        this.mParent.setHeight(dimension);
        return this;
    }

    public State setWidth(Dimension dimension) {
        this.mParent.setWidth(dimension);
        return this;
    }

    public VerticalChainReference verticalChain(Object ... objectArray) {
        VerticalChainReference verticalChainReference = (VerticalChainReference)this.helper(null, Helper.VERTICAL_CHAIN);
        verticalChainReference.add(objectArray);
        return verticalChainReference;
    }

    public GuidelineReference verticalGuideline(Object object) {
        return this.guideline(object, 1);
    }

    public State width(Dimension dimension) {
        return this.setWidth(dimension);
    }
}
