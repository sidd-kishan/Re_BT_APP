/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.LinearSystem
 *  androidx.constraintlayout.solver.Metrics
 *  androidx.constraintlayout.solver.SolverVariable
 *  androidx.constraintlayout.solver.widgets.Barrier
 *  androidx.constraintlayout.solver.widgets.Chain
 *  androidx.constraintlayout.solver.widgets.ChainHead
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour
 *  androidx.constraintlayout.solver.widgets.Guideline
 *  androidx.constraintlayout.solver.widgets.Optimizer
 *  androidx.constraintlayout.solver.widgets.VirtualLayout
 *  androidx.constraintlayout.solver.widgets.WidgetContainer
 *  androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure
 *  androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure
 *  androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer
 *  androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph
 *  androidx.constraintlayout.solver.widgets.analyzer.Direct
 *  androidx.constraintlayout.solver.widgets.analyzer.Grouping
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.Chain;
import androidx.constraintlayout.solver.widgets.ChainHead;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.solver.widgets.WidgetContainer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph;
import androidx.constraintlayout.solver.widgets.analyzer.Direct;
import androidx.constraintlayout.solver.widgets.analyzer.Grouping;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ConstraintWidgetContainer
extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    static int mycounter;
    private WeakReference<ConstraintAnchor> horizontalWrapMax = null;
    private WeakReference<ConstraintAnchor> horizontalWrapMin = null;
    BasicMeasure mBasicMeasureSolver = new BasicMeasure(this);
    int mDebugSolverPassCount = 0;
    public DependencyGraph mDependencyGraph = new DependencyGraph(this);
    public boolean mGroupsWrapOptimized = false;
    private boolean mHeightMeasuredTooSmall = false;
    ChainHead[] mHorizontalChainsArray;
    public int mHorizontalChainsSize = 0;
    public boolean mHorizontalWrapOptimized = false;
    private boolean mIsRtl = false;
    public BasicMeasure.Measure mMeasure;
    protected BasicMeasure.Measurer mMeasurer = null;
    public Metrics mMetrics;
    private int mOptimizationLevel = 257;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    public boolean mSkipSolver = false;
    protected LinearSystem mSystem = new LinearSystem();
    ChainHead[] mVerticalChainsArray = new ChainHead[4];
    public int mVerticalChainsSize = 0;
    public boolean mVerticalWrapOptimized = false;
    private boolean mWidthMeasuredTooSmall = false;
    public int mWrapFixedHeight = 0;
    public int mWrapFixedWidth = 0;
    private WeakReference<ConstraintAnchor> verticalWrapMax = null;
    private WeakReference<ConstraintAnchor> verticalWrapMin = null;

    public ConstraintWidgetContainer() {
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(int n, int n2) {
        super(n, n2);
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(int n, int n2, int n3, int n4) {
        super(n, n2, n3, n4);
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(String string, int n, int n2) {
        super(n, n2);
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mMeasure = new BasicMeasure.Measure();
        this.setDebugName(string);
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        int n = this.mHorizontalChainsSize;
        ChainHead[] chainHeadArray = this.mHorizontalChainsArray;
        if (n + 1 >= chainHeadArray.length) {
            this.mHorizontalChainsArray = Arrays.copyOf(chainHeadArray, chainHeadArray.length * 2);
        }
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, this.isRtl());
        ++this.mHorizontalChainsSize;
    }

    private void addMaxWrap(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        constraintAnchor = this.mSystem.createObjectVariable((Object)constraintAnchor);
        this.mSystem.addGreaterThan(solverVariable, (SolverVariable)constraintAnchor, 0, 5);
    }

    private void addMinWrap(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        constraintAnchor = this.mSystem.createObjectVariable((Object)constraintAnchor);
        this.mSystem.addGreaterThan((SolverVariable)constraintAnchor, solverVariable, 0, 5);
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        int n = this.mVerticalChainsSize;
        ChainHead[] chainHeadArray = this.mVerticalChainsArray;
        if (n + 1 >= chainHeadArray.length) {
            this.mVerticalChainsArray = Arrays.copyOf(chainHeadArray, chainHeadArray.length * 2);
        }
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, this.isRtl());
        ++this.mVerticalChainsSize;
    }

    public static boolean measure(ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, BasicMeasure.Measure measure, boolean bl) {
        if (measurer == null) {
            return false;
        }
        measure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        measure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        measure.horizontalDimension = constraintWidget.getWidth();
        measure.verticalDimension = constraintWidget.getHeight();
        measure.measuredNeedsSolverPass = false;
        measure.useCurrentDimensions = bl;
        int n = measure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
        int n2 = measure.verticalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
        boolean bl2 = n != 0 && constraintWidget.mDimensionRatio > 0.0f;
        boolean bl3 = n2 != 0 && constraintWidget.mDimensionRatio > 0.0f;
        int n3 = n;
        if (n != 0) {
            n3 = n;
            if (constraintWidget.hasDanglingDimension(0)) {
                n3 = n;
                if (constraintWidget.mMatchConstraintDefaultWidth == 0) {
                    n3 = n;
                    if (!bl2) {
                        measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        if (n2 != 0 && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                            measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                        }
                        n3 = 0;
                    }
                }
            }
        }
        n = n2;
        if (n2 != 0) {
            n = n2;
            if (constraintWidget.hasDanglingDimension(1)) {
                n = n2;
                if (constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    n = n2;
                    if (!bl3) {
                        measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        if (n3 != 0 && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                            measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                        }
                        n = 0;
                    }
                }
            }
        }
        if (constraintWidget.isResolvedHorizontally()) {
            measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            n3 = 0;
        }
        if (constraintWidget.isResolvedVertically()) {
            measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            n = 0;
        }
        if (bl2) {
            if (constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
                measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (n == 0) {
                if (measure.verticalBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    n = measure.verticalDimension;
                } else {
                    measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    measurer.measure(constraintWidget, measure);
                    n = measure.measuredHeight;
                }
                measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                measure.horizontalDimension = constraintWidget.mDimensionRatioSide != 0 && constraintWidget.mDimensionRatioSide != -1 ? (int)(constraintWidget.getDimensionRatio() / (float)n) : (int)(constraintWidget.getDimensionRatio() * (float)n);
            }
        }
        if (bl3) {
            if (constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
                measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (n3 == 0) {
                if (measure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    n = measure.horizontalDimension;
                } else {
                    measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    measurer.measure(constraintWidget, measure);
                    n = measure.measuredWidth;
                }
                measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                measure.verticalDimension = constraintWidget.mDimensionRatioSide != 0 && constraintWidget.mDimensionRatioSide != -1 ? (int)((float)n * constraintWidget.getDimensionRatio()) : (int)((float)n / constraintWidget.getDimensionRatio());
            }
        }
        measurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(measure.measuredWidth);
        constraintWidget.setHeight(measure.measuredHeight);
        constraintWidget.setHasBaseline(measure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(measure.measuredBaseline);
        measure.useCurrentDimensions = false;
        return measure.measuredNeedsSolverPass;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    void addChain(ConstraintWidget constraintWidget, int n) {
        if (n == 0) {
            this.addHorizontalChain(constraintWidget);
        } else {
            if (n != 1) return;
            this.addVerticalChain(constraintWidget);
        }
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        Object object;
        int n;
        boolean bl = this.optimizeFor(64);
        this.addToSolver(linearSystem, bl);
        int n2 = this.mChildren.size();
        boolean bl2 = false;
        for (n = 0; n < n2; ++n) {
            object = (ConstraintWidget)this.mChildren.get(n);
            object.setInBarrier(0, false);
            object.setInBarrier(1, false);
            if (!(object instanceof Barrier)) continue;
            bl2 = true;
        }
        if (bl2) {
            for (n = 0; n < n2; ++n) {
                object = (ConstraintWidget)this.mChildren.get(n);
                if (!(object instanceof Barrier)) continue;
                ((Barrier)object).markWidgets();
            }
        }
        for (n = 0; n < n2; ++n) {
            object = (ConstraintWidget)this.mChildren.get(n);
            if (!object.addFirst()) continue;
            object.addToSolver(linearSystem, bl);
        }
        if (LinearSystem.USE_DEPENDENCY_ORDERING) {
            ConstraintWidget constraintWidget2 = new HashSet();
            for (n = 0; n < n2; ++n) {
                object = (ConstraintWidget)this.mChildren.get(n);
                if (object.addFirst()) continue;
                constraintWidget2.add(object);
            }
            n = this.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 0 : 1;
            this.addChildrenToSolverByDependency(this, linearSystem, (HashSet)constraintWidget2, n, false);
            for (ConstraintWidget constraintWidget2 : constraintWidget2) {
                Optimizer.checkMatchParent((ConstraintWidgetContainer)this, (LinearSystem)linearSystem, (ConstraintWidget)constraintWidget2);
                constraintWidget2.addToSolver(linearSystem, bl);
            }
        } else {
            for (n = 0; n < n2; ++n) {
                object = (ConstraintWidget)this.mChildren.get(n);
                if (object instanceof ConstraintWidgetContainer) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ((ConstraintWidget)object).mListDimensionBehaviors[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ((ConstraintWidget)object).mListDimensionBehaviors[1];
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        object.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        object.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    object.addToSolver(linearSystem, bl);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        object.setHorizontalDimensionBehaviour(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) continue;
                    object.setVerticalDimensionBehaviour(dimensionBehaviour2);
                    continue;
                }
                Optimizer.checkMatchParent((ConstraintWidgetContainer)this, (LinearSystem)linearSystem, (ConstraintWidget)object);
                if (object.addFirst()) continue;
                object.addToSolver(linearSystem, bl);
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints((ConstraintWidgetContainer)this, (LinearSystem)linearSystem, null, (int)0);
        }
        if (this.mVerticalChainsSize <= 0) return true;
        Chain.applyChainConstraints((ConstraintWidgetContainer)this, (LinearSystem)linearSystem, null, (int)1);
        return true;
    }

    public void addHorizontalWrapMaxVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.horizontalWrapMax;
        if (weakReference != null && weakReference.get() != null) {
            if (constraintAnchor.getFinalValue() <= ((ConstraintAnchor)this.horizontalWrapMax.get()).getFinalValue()) return;
        }
        this.horizontalWrapMax = new WeakReference<ConstraintAnchor>(constraintAnchor);
    }

    public void addHorizontalWrapMinVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.horizontalWrapMin;
        if (weakReference != null && weakReference.get() != null) {
            if (constraintAnchor.getFinalValue() <= ((ConstraintAnchor)this.horizontalWrapMin.get()).getFinalValue()) return;
        }
        this.horizontalWrapMin = new WeakReference<ConstraintAnchor>(constraintAnchor);
    }

    void addVerticalWrapMaxVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.verticalWrapMax;
        if (weakReference != null && weakReference.get() != null) {
            if (constraintAnchor.getFinalValue() <= ((ConstraintAnchor)this.verticalWrapMax.get()).getFinalValue()) return;
        }
        this.verticalWrapMax = new WeakReference<ConstraintAnchor>(constraintAnchor);
    }

    void addVerticalWrapMinVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.verticalWrapMin;
        if (weakReference != null && weakReference.get() != null) {
            if (constraintAnchor.getFinalValue() <= ((ConstraintAnchor)this.verticalWrapMin.get()).getFinalValue()) return;
        }
        this.verticalWrapMin = new WeakReference<ConstraintAnchor>(constraintAnchor);
    }

    public void defineTerminalWidgets() {
        this.mDependencyGraph.defineTerminalWidgets(this.getHorizontalDimensionBehaviour(), this.getVerticalDimensionBehaviour());
    }

    public boolean directMeasure(boolean bl) {
        return this.mDependencyGraph.directMeasure(bl);
    }

    public boolean directMeasureSetup(boolean bl) {
        return this.mDependencyGraph.directMeasureSetup(bl);
    }

    public boolean directMeasureWithOrientation(boolean bl, int n) {
        return this.mDependencyGraph.directMeasureWithOrientation(bl, n);
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mSystem.fillMetrics(metrics);
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<Guideline>();
        int n = this.mChildren.size();
        int n2 = 0;
        while (n2 < n) {
            ConstraintWidget constraintWidget = (ConstraintWidget)this.mChildren.get(n2);
            if (constraintWidget instanceof Guideline && (constraintWidget = (Guideline)constraintWidget).getOrientation() == 0) {
                arrayList.add((Guideline)constraintWidget);
            }
            ++n2;
        }
        return arrayList;
    }

    public BasicMeasure.Measurer getMeasurer() {
        return this.mMeasurer;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<Guideline>();
        int n = this.mChildren.size();
        int n2 = 0;
        while (n2 < n) {
            ConstraintWidget constraintWidget = (ConstraintWidget)this.mChildren.get(n2);
            if (constraintWidget instanceof Guideline && (constraintWidget = (Guideline)constraintWidget).getOrientation() == 1) {
                arrayList.add((Guideline)constraintWidget);
            }
            ++n2;
        }
        return arrayList;
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public void invalidateGraph() {
        this.mDependencyGraph.invalidateGraph();
    }

    public void invalidateMeasures() {
        this.mDependencyGraph.invalidateMeasures();
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void layout() {
        this.mX = 0;
        this.mY = 0;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        var9_1 = this.mChildren.size();
        var2_2 = Math.max(0, this.getWidth());
        var3_3 = Math.max(0, this.getHeight());
        var15_4 = this.mListDimensionBehaviors[1];
        var14_5 = this.mListDimensionBehaviors[0];
        var16_6 /* !! */  = this.mMetrics;
        if (var16_6 /* !! */  != null) {
            ++var16_6 /* !! */ .layouts;
        }
        if (Optimizer.enabled((int)this.mOptimizationLevel, (int)1)) {
            Direct.solvingPass((ConstraintWidgetContainer)this, (BasicMeasure.Measurer)this.getMeasurer());
            for (var1_7 = 0; var1_7 < var9_1; ++var1_7) {
                var16_6 /* !! */  = (ConstraintWidget)this.mChildren.get(var1_7);
                if (!var16_6 /* !! */ .isMeasureRequested() || var16_6 /* !! */  instanceof Guideline || var16_6 /* !! */  instanceof Barrier || var16_6 /* !! */  instanceof VirtualLayout || var16_6 /* !! */ .isInVirtualLayout()) continue;
                var18_9 = var16_6 /* !! */ .getDimensionBehaviour(0);
                var17_8 = var16_6 /* !! */ .getDimensionBehaviour(1);
                var4_10 = var18_9 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && var16_6 /* !! */ .mMatchConstraintDefaultWidth != 1 && var17_8 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && var16_6 /* !! */ .mMatchConstraintDefaultHeight != 1 ? 1 : 0;
                if (var4_10 != 0) continue;
                var17_8 = new BasicMeasure.Measure();
                ConstraintWidgetContainer.measure((ConstraintWidget)var16_6 /* !! */ , this.mMeasurer, (BasicMeasure.Measure)var17_8, false);
            }
        }
        if (var9_1 > 2 && (var14_5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || var15_4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && Optimizer.enabled((int)this.mOptimizationLevel, (int)1024) && Grouping.simpleSolvingPass((ConstraintWidgetContainer)this, (BasicMeasure.Measurer)this.getMeasurer())) {
            var1_7 = var2_2;
            if (var14_5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                if (var2_2 < this.getWidth() && var2_2 > 0) {
                    this.setWidth(var2_2);
                    this.mWidthMeasuredTooSmall = true;
                    var1_7 = var2_2;
                } else {
                    var1_7 = this.getWidth();
                }
            }
            var2_2 = var3_3;
            if (var15_4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                if (var3_3 < this.getHeight() && var3_3 > 0) {
                    this.setHeight(var3_3);
                    this.mHeightMeasuredTooSmall = true;
                    var2_2 = var3_3;
                } else {
                    var2_2 = this.getHeight();
                }
            }
            var5_11 = var1_7;
            var1_7 = 1;
            var4_10 = var2_2;
        } else {
            var1_7 = 0;
            var4_10 = var3_3;
            var5_11 = var2_2;
        }
        var2_2 = !this.optimizeFor(64) && !this.optimizeFor(128) ? 0 : 1;
        this.mSystem.graphOptimizer = false;
        this.mSystem.newgraphOptimizer = false;
        if (this.mOptimizationLevel != 0 && var2_2 != 0) {
            this.mSystem.newgraphOptimizer = true;
        }
        var16_6 /* !! */  = this.mChildren;
        var6_12 = this.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || this.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        this.resetChains();
        for (var2_2 = 0; var2_2 < var9_1; ++var2_2) {
            var17_8 = (ConstraintWidget)this.mChildren.get(var2_2);
            if (!(var17_8 instanceof WidgetContainer)) continue;
            ((WidgetContainer)var17_8).layout();
        }
        var13_13 = this.optimizeFor(64);
        var2_2 = 0;
        var11_14 = true;
        while (var11_14) {
            block44: {
                var8_16 = var2_2 + 1;
                var10_17 = var11_14;
                try {
                    this.mSystem.reset();
                    var10_17 = var11_14;
                    this.resetChains();
                    var10_17 = var11_14;
                    this.createObjectVariables(this.mSystem);
                    for (var2_2 = 0; var2_2 < var9_1; ++var2_2) {
                        var10_17 = var11_14;
                        ((ConstraintWidget)this.mChildren.get(var2_2)).createObjectVariables(this.mSystem);
                    }
                    var10_17 = var11_14;
                }
                catch (Exception var19_19) {
                    var19_19.printStackTrace();
                    var18_9 = System.out;
                    var17_8 = new StringBuilder();
                    var17_8.append("EXCEPTION : ");
                    var17_8.append(var19_19);
                    var18_9.println(var17_8.toString());
                    break block44;
                }
                {
                    var10_17 = var11_14 = this.addChildrenToSolver(this.mSystem);
                    if (this.verticalWrapMin != null) {
                        var10_17 = var11_14;
                        if (this.verticalWrapMin.get() != null) {
                            var10_17 = var11_14;
                            this.addMinWrap((ConstraintAnchor)this.verticalWrapMin.get(), this.mSystem.createObjectVariable((Object)this.mTop));
                            var10_17 = var11_14;
                            this.verticalWrapMin = null;
                        }
                    }
                    var10_17 = var11_14;
                    if (this.verticalWrapMax != null) {
                        var10_17 = var11_14;
                        if (this.verticalWrapMax.get() != null) {
                            var10_17 = var11_14;
                            this.addMaxWrap((ConstraintAnchor)this.verticalWrapMax.get(), this.mSystem.createObjectVariable((Object)this.mBottom));
                            var10_17 = var11_14;
                            this.verticalWrapMax = null;
                        }
                    }
                    var10_17 = var11_14;
                    if (this.horizontalWrapMin != null) {
                        var10_17 = var11_14;
                        if (this.horizontalWrapMin.get() != null) {
                            var10_17 = var11_14;
                            this.addMinWrap((ConstraintAnchor)this.horizontalWrapMin.get(), this.mSystem.createObjectVariable((Object)this.mLeft));
                            var10_17 = var11_14;
                            this.horizontalWrapMin = null;
                        }
                    }
                    var10_17 = var11_14;
                    if (this.horizontalWrapMax != null) {
                        var10_17 = var11_14;
                        if (this.horizontalWrapMax.get() != null) {
                            var10_17 = var11_14;
                            this.addMaxWrap((ConstraintAnchor)this.horizontalWrapMax.get(), this.mSystem.createObjectVariable((Object)this.mRight));
                            var10_17 = var11_14;
                            this.horizontalWrapMax = null;
                        }
                    }
                    var10_17 = var11_14;
                    if (!var11_14) break block44;
                    var10_17 = var11_14;
                    this.mSystem.minimize();
                    var10_17 = var11_14;
                }
            }
            if (var10_17) {
                this.updateChildrenFromSolver(this.mSystem, Optimizer.flags);
            } else {
                this.updateFromSolver(this.mSystem, var13_13);
                for (var2_2 = 0; var2_2 < var9_1; ++var2_2) {
                    ((ConstraintWidget)this.mChildren.get(var2_2)).updateFromSolver(this.mSystem, var13_13);
                }
            }
            if (var6_12 && var8_16 < 8 && Optimizer.flags[2]) {
                var3_3 = 0;
                var2_2 = 0;
                for (var7_15 = 0; var7_15 < var9_1; ++var7_15) {
                    var17_8 = (ConstraintWidget)this.mChildren.get(var7_15);
                    var3_3 = Math.max(var3_3, var17_8.mX + var17_8.getWidth());
                    var2_2 = Math.max(var2_2, var17_8.mY + var17_8.getHeight());
                }
                var7_15 = Math.max(this.mMinWidth, var3_3);
                var3_3 = Math.max(this.mMinHeight, var2_2);
                if (var14_5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && this.getWidth() < var7_15) {
                    this.setWidth(var7_15);
                    this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    var11_14 = true;
                    var2_2 = 1;
                } else {
                    var11_14 = false;
                    var2_2 = var1_7;
                }
                var10_17 = var11_14;
                var1_7 = var2_2;
                if (var15_4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    var10_17 = var11_14;
                    var1_7 = var2_2;
                    if (this.getHeight() < var3_3) {
                        this.setHeight(var3_3);
                        this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        var10_17 = true;
                        var1_7 = 1;
                    }
                }
            } else {
                var10_17 = false;
            }
            if ((var2_2 = Math.max(this.mMinWidth, this.getWidth())) > this.getWidth()) {
                this.setWidth(var2_2);
                this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                var10_17 = true;
                var1_7 = 1;
            }
            if ((var2_2 = Math.max(this.mMinHeight, this.getHeight())) > this.getHeight()) {
                this.setHeight(var2_2);
                this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                var10_17 = true;
                var1_7 = 1;
            }
            var12_18 = var10_17;
            var3_3 = var1_7;
            if (var1_7 != 0) ** GOTO lbl-1000
            var11_14 = var10_17;
            var2_2 = var1_7;
            if (this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                var11_14 = var10_17;
                var2_2 = var1_7;
                if (var5_11 > 0) {
                    var11_14 = var10_17;
                    var2_2 = var1_7;
                    if (this.getWidth() > var5_11) {
                        this.mWidthMeasuredTooSmall = true;
                        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                        this.setWidth(var5_11);
                        var11_14 = true;
                        var2_2 = 1;
                    }
                }
            }
            var12_18 = var11_14;
            var3_3 = var2_2;
            if (this.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) ** GOTO lbl-1000
            var12_18 = var11_14;
            var3_3 = var2_2;
            if (var4_10 <= 0) ** GOTO lbl-1000
            var12_18 = var11_14;
            var3_3 = var2_2;
            if (this.getHeight() > var4_10) {
                this.mHeightMeasuredTooSmall = true;
                this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                this.setHeight(var4_10);
                var1_7 = 1;
                var11_14 = true;
            } else lbl-1000:
            // 4 sources

            {
                var11_14 = var12_18;
                var1_7 = var3_3;
            }
            var2_2 = var8_16;
        }
        this.mChildren = (ArrayList)var16_6 /* !! */ ;
        if (var1_7 != 0) {
            this.mListDimensionBehaviors[0] = var14_5;
            this.mListDimensionBehaviors[1] = var15_4;
        }
        this.resetSolverVariables(this.mSystem.getCache());
    }

    public long measure(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        this.mPaddingLeft = n8;
        this.mPaddingTop = n9;
        return this.mBasicMeasureSolver.solverMeasure(this, n, n8, n9, n2, n3, n4, n5, n6, n7);
    }

    public boolean optimizeFor(int n) {
        boolean bl = (this.mOptimizationLevel & n) == n;
        return bl;
    }

    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mSkipSolver = false;
        super.reset();
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.mMeasurer = measurer;
        this.mDependencyGraph.setMeasurer(measurer);
    }

    public void setOptimizationLevel(int n) {
        this.mOptimizationLevel = n;
        LinearSystem.USE_DEPENDENCY_ORDERING = this.optimizeFor(512);
    }

    public void setPadding(int n, int n2, int n3, int n4) {
        this.mPaddingLeft = n;
        this.mPaddingTop = n2;
        this.mPaddingRight = n3;
        this.mPaddingBottom = n4;
    }

    public void setRtl(boolean bl) {
        this.mIsRtl = bl;
    }

    public void updateChildrenFromSolver(LinearSystem linearSystem, boolean[] blArray) {
        int n = 0;
        blArray[2] = false;
        boolean bl = this.optimizeFor(64);
        this.updateFromSolver(linearSystem, bl);
        int n2 = this.mChildren.size();
        while (n < n2) {
            ((ConstraintWidget)this.mChildren.get(n)).updateFromSolver(linearSystem, bl);
            ++n;
        }
    }

    public void updateFromRuns(boolean bl, boolean bl2) {
        super.updateFromRuns(bl, bl2);
        int n = this.mChildren.size();
        int n2 = 0;
        while (n2 < n) {
            ((ConstraintWidget)this.mChildren.get(n2)).updateFromRuns(bl, bl2);
            ++n2;
        }
    }

    public void updateHierarchy() {
        this.mBasicMeasureSolver.updateHierarchy(this);
    }
}
