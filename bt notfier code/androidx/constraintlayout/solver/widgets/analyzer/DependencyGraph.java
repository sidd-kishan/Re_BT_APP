/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.widgets.Barrier
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour
 *  androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
 *  androidx.constraintlayout.solver.widgets.Guideline
 *  androidx.constraintlayout.solver.widgets.HelperWidget
 *  androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure
 *  androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer
 *  androidx.constraintlayout.solver.widgets.analyzer.ChainRun
 *  androidx.constraintlayout.solver.widgets.analyzer.Dependency
 *  androidx.constraintlayout.solver.widgets.analyzer.DependencyNode
 *  androidx.constraintlayout.solver.widgets.analyzer.GuidelineReference
 *  androidx.constraintlayout.solver.widgets.analyzer.HelperReferences
 *  androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun
 *  androidx.constraintlayout.solver.widgets.analyzer.RunGroup
 *  androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.GuidelineReference;
import androidx.constraintlayout.solver.widgets.analyzer.HelperReferences;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.RunGroup;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class DependencyGraph {
    private static final boolean USE_GROUPS = true;
    private ConstraintWidgetContainer container;
    private ConstraintWidgetContainer mContainer;
    ArrayList<RunGroup> mGroups;
    private BasicMeasure.Measure mMeasure;
    private BasicMeasure.Measurer mMeasurer = null;
    private boolean mNeedBuildGraph = true;
    private boolean mNeedRedoMeasures = true;
    private ArrayList<WidgetRun> mRuns = new ArrayList();
    private ArrayList<RunGroup> runGroups = new ArrayList();

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        this.mMeasure = new BasicMeasure.Measure();
        this.mGroups = new ArrayList();
        this.container = constraintWidgetContainer;
        this.mContainer = constraintWidgetContainer;
    }

    /*
     * Enabled force condition propagation
     */
    private void applyGroup(DependencyNode object, int n, int n2, DependencyNode dependencyNode, ArrayList<RunGroup> arrayList, RunGroup object22) {
        WidgetRun widgetRun = object.run;
        if (widgetRun.runGroup != null) return;
        if (widgetRun == this.container.horizontalRun) return;
        if (widgetRun == this.container.verticalRun) {
            return;
        }
        object = object22;
        if (object22 == null) {
            object = new RunGroup(widgetRun, n2);
            arrayList.add((RunGroup)object);
        }
        widgetRun.runGroup = object;
        object.add(widgetRun);
        for (Object object22 : widgetRun.start.dependencies) {
            if (!(object22 instanceof DependencyNode)) continue;
            this.applyGroup((DependencyNode)object22, n, 0, dependencyNode, arrayList, (RunGroup)object);
        }
        for (Object object22 : widgetRun.end.dependencies) {
            if (!(object22 instanceof DependencyNode)) continue;
            this.applyGroup((DependencyNode)object22, n, 1, dependencyNode, arrayList, (RunGroup)object);
        }
        if (n == 1 && widgetRun instanceof VerticalWidgetRun) {
            for (Object object22 : ((VerticalWidgetRun)widgetRun).baseline.dependencies) {
                if (!(object22 instanceof DependencyNode)) continue;
                this.applyGroup((DependencyNode)object22, n, 2, dependencyNode, arrayList, (RunGroup)object);
            }
        }
        for (DependencyNode dependencyNode2 : widgetRun.start.targets) {
            if (dependencyNode2 == dependencyNode) {
                object.dual = true;
            }
            this.applyGroup(dependencyNode2, n, 0, dependencyNode, arrayList, (RunGroup)object);
        }
        for (DependencyNode dependencyNode2 : widgetRun.end.targets) {
            if (dependencyNode2 == dependencyNode) {
                object.dual = true;
            }
            this.applyGroup(dependencyNode2, n, 1, dependencyNode, arrayList, (RunGroup)object);
        }
        if (n != 1) return;
        if (!(widgetRun instanceof VerticalWidgetRun)) return;
        object22 = ((VerticalWidgetRun)widgetRun).baseline.targets.iterator();
        while (object22.hasNext()) {
            widgetRun = (DependencyNode)object22.next();
            this.applyGroup((DependencyNode)widgetRun, n, 2, dependencyNode, arrayList, (RunGroup)object);
        }
    }

    private boolean basicMeasureWidgets(ConstraintWidgetContainer constraintWidgetContainer) {
        Iterator iterator = constraintWidgetContainer.mChildren.iterator();
        while (iterator.hasNext()) {
            int n;
            int n2;
            int n3;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3;
            ConstraintWidget constraintWidget;
            block37: {
                block38: {
                    constraintWidget = (ConstraintWidget)iterator.next();
                    dimensionBehaviour3 = constraintWidget.mListDimensionBehaviors[0];
                    dimensionBehaviour2 = constraintWidget.mListDimensionBehaviors[1];
                    if (constraintWidget.getVisibility() == 8) {
                        constraintWidget.measured = true;
                        continue;
                    }
                    if (constraintWidget.mMatchConstraintPercentWidth < 1.0f && dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        constraintWidget.mMatchConstraintDefaultWidth = 2;
                    }
                    if (constraintWidget.mMatchConstraintPercentHeight < 1.0f && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        constraintWidget.mMatchConstraintDefaultHeight = 2;
                    }
                    if (constraintWidget.getDimensionRatio() > 0.0f) {
                        if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                            constraintWidget.mMatchConstraintDefaultWidth = 3;
                        } else if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                            constraintWidget.mMatchConstraintDefaultHeight = 3;
                        } else if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            if (constraintWidget.mMatchConstraintDefaultWidth == 0) {
                                constraintWidget.mMatchConstraintDefaultWidth = 3;
                            }
                            if (constraintWidget.mMatchConstraintDefaultHeight == 0) {
                                constraintWidget.mMatchConstraintDefaultHeight = 3;
                            }
                        }
                    }
                    dimensionBehaviour = dimensionBehaviour3;
                    if (dimensionBehaviour3 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) break block37;
                    dimensionBehaviour = dimensionBehaviour3;
                    if (constraintWidget.mMatchConstraintDefaultWidth != 1) break block37;
                    if (constraintWidget.mLeft.mTarget == null) break block38;
                    dimensionBehaviour = dimensionBehaviour3;
                    if (constraintWidget.mRight.mTarget != null) break block37;
                }
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            }
            dimensionBehaviour3 = dimensionBehaviour;
            dimensionBehaviour = dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 1 && (constraintWidget.mTop.mTarget == null || constraintWidget.mBottom.mTarget == null) ? ConstraintWidget.DimensionBehaviour.WRAP_CONTENT : dimensionBehaviour2;
            constraintWidget.horizontalRun.dimensionBehavior = dimensionBehaviour3;
            constraintWidget.horizontalRun.matchConstraintsType = constraintWidget.mMatchConstraintDefaultWidth;
            constraintWidget.verticalRun.dimensionBehavior = dimensionBehaviour;
            constraintWidget.verticalRun.matchConstraintsType = constraintWidget.mMatchConstraintDefaultHeight;
            if (dimensionBehaviour3 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour3 != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour3 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                float f;
                float f2;
                if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED)) {
                    if (constraintWidget.mMatchConstraintDefaultWidth == 3) {
                        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                            this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                        }
                        n3 = constraintWidget.getHeight();
                        n2 = (int)((float)n3 * constraintWidget.mDimensionRatio + 0.5f);
                        this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, n2, ConstraintWidget.DimensionBehaviour.FIXED, n3);
                        constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                        constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                        constraintWidget.measured = true;
                        continue;
                    }
                    if (constraintWidget.mMatchConstraintDefaultWidth == 1) {
                        this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour, 0);
                        constraintWidget.horizontalRun.dimension.wrapValue = constraintWidget.getWidth();
                        continue;
                    }
                    if (constraintWidget.mMatchConstraintDefaultWidth == 2) {
                        if (constraintWidgetContainer.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidgetContainer.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                            n2 = (int)(constraintWidget.mMatchConstraintPercentWidth * (float)constraintWidgetContainer.getWidth() + 0.5f);
                            n3 = constraintWidget.getHeight();
                            this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, n2, dimensionBehaviour, n3);
                            constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                            constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                            constraintWidget.measured = true;
                            continue;
                        }
                    } else if (constraintWidget.mListAnchors[0].mTarget == null || constraintWidget.mListAnchors[1].mTarget == null) {
                        this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour, 0);
                        constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                        constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                        constraintWidget.measured = true;
                        continue;
                    }
                }
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                    if (constraintWidget.mMatchConstraintDefaultHeight == 3) {
                        if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                            this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                        }
                        n2 = constraintWidget.getWidth();
                        f = f2 = constraintWidget.mDimensionRatio;
                        if (constraintWidget.getDimensionRatioSide() == -1) {
                            f = 1.0f / f2;
                        }
                        n3 = (int)((float)n2 * f + 0.5f);
                        this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, n2, ConstraintWidget.DimensionBehaviour.FIXED, n3);
                        constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                        constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                        constraintWidget.measured = true;
                        continue;
                    }
                    if (constraintWidget.mMatchConstraintDefaultHeight == 1) {
                        this.measure(constraintWidget, dimensionBehaviour3, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                        constraintWidget.verticalRun.dimension.wrapValue = constraintWidget.getHeight();
                        continue;
                    }
                    if (constraintWidget.mMatchConstraintDefaultHeight == 2) {
                        if (constraintWidgetContainer.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidgetContainer.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                            f = constraintWidget.mMatchConstraintPercentHeight;
                            n3 = constraintWidget.getWidth();
                            n2 = (int)(f * (float)constraintWidgetContainer.getHeight() + 0.5f);
                            this.measure(constraintWidget, dimensionBehaviour3, n3, ConstraintWidget.DimensionBehaviour.FIXED, n2);
                            constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                            constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                            constraintWidget.measured = true;
                            continue;
                        }
                    } else if (constraintWidget.mListAnchors[2].mTarget == null || constraintWidget.mListAnchors[3].mTarget == null) {
                        this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour, 0);
                        constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                        constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                        constraintWidget.measured = true;
                        continue;
                    }
                }
                if (dimensionBehaviour3 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) continue;
                if (constraintWidget.mMatchConstraintDefaultWidth != 1 && constraintWidget.mMatchConstraintDefaultHeight != 1) {
                    if (constraintWidget.mMatchConstraintDefaultHeight != 2 || constraintWidget.mMatchConstraintDefaultWidth != 2 || constraintWidgetContainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.FIXED && constraintWidgetContainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.FIXED || constraintWidgetContainer.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.FIXED && constraintWidgetContainer.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.FIXED) continue;
                    f = constraintWidget.mMatchConstraintPercentWidth;
                    f2 = constraintWidget.mMatchConstraintPercentHeight;
                    n3 = (int)(f * (float)constraintWidgetContainer.getWidth() + 0.5f);
                    n2 = (int)(f2 * (float)constraintWidgetContainer.getHeight() + 0.5f);
                    this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, n3, ConstraintWidget.DimensionBehaviour.FIXED, n2);
                    constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                    constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                    constraintWidget.measured = true;
                    continue;
                }
                this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                constraintWidget.horizontalRun.dimension.wrapValue = constraintWidget.getWidth();
                constraintWidget.verticalRun.dimension.wrapValue = constraintWidget.getHeight();
                continue;
            }
            n2 = constraintWidget.getWidth();
            if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                n3 = constraintWidgetContainer.getWidth();
                n = constraintWidget.mLeft.mMargin;
                n2 = constraintWidget.mRight.mMargin;
                dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
                n2 = n3 - n - n2;
            }
            n3 = constraintWidget.getHeight();
            if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int n4 = constraintWidgetContainer.getHeight();
                n = constraintWidget.mTop.mMargin;
                n3 = constraintWidget.mBottom.mMargin;
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
                n3 = n4 - n - n3;
            }
            this.measure(constraintWidget, dimensionBehaviour3, n2, dimensionBehaviour, n3);
            constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
            constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
            constraintWidget.measured = true;
        }
        return false;
    }

    private int computeWrap(ConstraintWidgetContainer constraintWidgetContainer, int n) {
        int n2 = this.mGroups.size();
        long l = 0L;
        int n3 = 0;
        while (n3 < n2) {
            l = Math.max(l, this.mGroups.get(n3).computeWrapSize(constraintWidgetContainer, n));
            ++n3;
        }
        return (int)l;
    }

    private void displayGraph() {
        Object object = this.mRuns.iterator();
        String string = "digraph {\n";
        while (true) {
            if (!object.hasNext()) {
                object = new StringBuilder();
                ((StringBuilder)object).append(string);
                ((StringBuilder)object).append("\n}\n");
                string = ((StringBuilder)object).toString();
                object = System.out;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("content:<<\n");
                stringBuilder.append(string);
                stringBuilder.append("\n>>");
                ((PrintStream)object).println(stringBuilder.toString());
                return;
            }
            string = this.generateDisplayGraph(object.next(), string);
        }
    }

    private void findGroup(WidgetRun object, int n, ArrayList<RunGroup> arrayList) {
        for (Dependency dependency : ((WidgetRun)object).start.dependencies) {
            if (dependency instanceof DependencyNode) {
                this.applyGroup((DependencyNode)dependency, n, 0, ((WidgetRun)object).end, arrayList, null);
                continue;
            }
            if (!(dependency instanceof WidgetRun)) continue;
            this.applyGroup(((WidgetRun)dependency).start, n, 0, ((WidgetRun)object).end, arrayList, null);
        }
        for (Dependency dependency : ((WidgetRun)object).end.dependencies) {
            if (dependency instanceof DependencyNode) {
                this.applyGroup((DependencyNode)dependency, n, 1, ((WidgetRun)object).start, arrayList, null);
                continue;
            }
            if (!(dependency instanceof WidgetRun)) continue;
            this.applyGroup(((WidgetRun)dependency).end, n, 1, ((WidgetRun)object).start, arrayList, null);
        }
        if (n != 1) return;
        object = ((VerticalWidgetRun)object).baseline.dependencies.iterator();
        while (object.hasNext()) {
            Dependency dependency;
            dependency = (Dependency)object.next();
            if (!(dependency instanceof DependencyNode)) continue;
            this.applyGroup((DependencyNode)dependency, n, 2, null, arrayList, null);
        }
    }

    private String generateChainDisplayGraph(ChainRun object, String string) {
        CharSequence charSequence;
        int n = object.orientation;
        CharSequence charSequence2 = new StringBuilder();
        charSequence2.append("cluster_");
        charSequence2.append(object.widget.getDebugName());
        charSequence2 = charSequence2.toString();
        if (n == 0) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)charSequence2);
            ((StringBuilder)charSequence).append("_h");
            charSequence2 = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)charSequence2);
            ((StringBuilder)charSequence).append("_v");
            charSequence2 = ((StringBuilder)charSequence).toString();
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("subgraph ");
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append(" {\n");
        charSequence2 = ((StringBuilder)charSequence).toString();
        Iterator iterator = object.widgets.iterator();
        object = "";
        while (true) {
            StringBuilder stringBuilder;
            if (!iterator.hasNext()) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)charSequence2);
                ((StringBuilder)charSequence).append("}\n");
                charSequence2 = ((StringBuilder)charSequence).toString();
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string);
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append((String)charSequence2);
                return ((StringBuilder)charSequence).toString();
            }
            WidgetRun widgetRun = (WidgetRun)iterator.next();
            charSequence = widgetRun.widget.getDebugName();
            if (n == 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append((String)charSequence);
                stringBuilder.append("_HORIZONTAL");
                charSequence = stringBuilder.toString();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append((String)charSequence);
                stringBuilder.append("_VERTICAL");
                charSequence = stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)charSequence2);
            stringBuilder.append((String)charSequence);
            stringBuilder.append(";\n");
            charSequence2 = stringBuilder.toString();
            object = this.generateDisplayGraph(widgetRun, (String)object);
        }
    }

    private String generateDisplayGraph(WidgetRun widgetRun, String charSequence) {
        block22: {
            CharSequence charSequence2;
            DependencyNode dependencyNode;
            Object object;
            block20: {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour;
                block21: {
                    object = widgetRun.start;
                    dependencyNode = widgetRun.end;
                    if (!(widgetRun instanceof HelperReferences) && ((DependencyNode)object).dependencies.isEmpty() && dependencyNode.dependencies.isEmpty() & ((DependencyNode)object).targets.isEmpty() && dependencyNode.targets.isEmpty()) {
                        return charSequence;
                    }
                    charSequence2 = new StringBuilder();
                    charSequence2.append((String)charSequence);
                    charSequence2.append(this.nodeDefinition(widgetRun));
                    charSequence = charSequence2.toString();
                    boolean bl = this.isCenteredConnection((DependencyNode)object, dependencyNode);
                    charSequence = this.generateDisplayNode(dependencyNode, bl, this.generateDisplayNode((DependencyNode)object, bl, (String)charSequence));
                    boolean bl2 = widgetRun instanceof VerticalWidgetRun;
                    charSequence2 = charSequence;
                    if (bl2) {
                        charSequence2 = this.generateDisplayNode(((VerticalWidgetRun)widgetRun).baseline, bl, (String)charSequence);
                    }
                    if (widgetRun instanceof HorizontalWidgetRun || (bl = widgetRun instanceof ChainRun) && ((ChainRun)widgetRun).orientation == 0) break block20;
                    if (bl2) break block21;
                    charSequence = charSequence2;
                    if (!bl) break block22;
                    charSequence = charSequence2;
                    if (((ChainRun)widgetRun).orientation != 1) break block22;
                }
                if ((dimensionBehaviour = widgetRun.widget.getVerticalDimensionBehaviour()) != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    charSequence = charSequence2;
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        charSequence = charSequence2;
                        if (widgetRun.widget.getDimensionRatio() > 0.0f) {
                            widgetRun.widget.getDebugName();
                            charSequence = charSequence2;
                        }
                    }
                } else if (!((DependencyNode)object).targets.isEmpty() && dependencyNode.targets.isEmpty()) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("\n");
                    ((StringBuilder)charSequence).append(dependencyNode.name());
                    ((StringBuilder)charSequence).append(" -> ");
                    ((StringBuilder)charSequence).append(object.name());
                    ((StringBuilder)charSequence).append("\n");
                    charSequence = ((StringBuilder)charSequence).toString();
                    object = new StringBuilder();
                    ((StringBuilder)object).append((String)charSequence2);
                    ((StringBuilder)object).append((String)charSequence);
                    charSequence = ((StringBuilder)object).toString();
                } else {
                    charSequence = charSequence2;
                    if (((DependencyNode)object).targets.isEmpty()) {
                        charSequence = charSequence2;
                        if (!dependencyNode.targets.isEmpty()) {
                            charSequence = new StringBuilder();
                            ((StringBuilder)charSequence).append("\n");
                            ((StringBuilder)charSequence).append(object.name());
                            ((StringBuilder)charSequence).append(" -> ");
                            ((StringBuilder)charSequence).append(dependencyNode.name());
                            ((StringBuilder)charSequence).append("\n");
                            object = ((StringBuilder)charSequence).toString();
                            charSequence = new StringBuilder();
                            ((StringBuilder)charSequence).append((String)charSequence2);
                            ((StringBuilder)charSequence).append((String)object);
                            charSequence = ((StringBuilder)charSequence).toString();
                        }
                    }
                }
                break block22;
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun.widget.getHorizontalDimensionBehaviour();
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                charSequence = charSequence2;
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    charSequence = charSequence2;
                    if (widgetRun.widget.getDimensionRatio() > 0.0f) {
                        widgetRun.widget.getDebugName();
                        charSequence = charSequence2;
                    }
                }
            } else if (!((DependencyNode)object).targets.isEmpty() && dependencyNode.targets.isEmpty()) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("\n");
                ((StringBuilder)charSequence).append(dependencyNode.name());
                ((StringBuilder)charSequence).append(" -> ");
                ((StringBuilder)charSequence).append(object.name());
                ((StringBuilder)charSequence).append("\n");
                object = ((StringBuilder)charSequence).toString();
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)charSequence2);
                ((StringBuilder)charSequence).append((String)object);
                charSequence = ((StringBuilder)charSequence).toString();
            } else {
                charSequence = charSequence2;
                if (((DependencyNode)object).targets.isEmpty()) {
                    charSequence = charSequence2;
                    if (!dependencyNode.targets.isEmpty()) {
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append("\n");
                        ((StringBuilder)charSequence).append(object.name());
                        ((StringBuilder)charSequence).append(" -> ");
                        ((StringBuilder)charSequence).append(dependencyNode.name());
                        ((StringBuilder)charSequence).append("\n");
                        object = ((StringBuilder)charSequence).toString();
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append((String)charSequence2);
                        ((StringBuilder)charSequence).append((String)object);
                        charSequence = ((StringBuilder)charSequence).toString();
                    }
                }
            }
        }
        if (!(widgetRun instanceof ChainRun)) return charSequence;
        return this.generateChainDisplayGraph((ChainRun)widgetRun, (String)charSequence);
    }

    private String generateDisplayNode(DependencyNode dependencyNode, boolean bl, String charSequence) {
        Iterator iterator = dependencyNode.targets.iterator();
        String string = charSequence;
        while (iterator.hasNext()) {
            CharSequence charSequence2;
            block9: {
                block8: {
                    charSequence = (DependencyNode)iterator.next();
                    charSequence2 = new StringBuilder();
                    ((StringBuilder)charSequence2).append("\n");
                    ((StringBuilder)charSequence2).append(dependencyNode.name());
                    charSequence2 = ((StringBuilder)charSequence2).toString();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((String)charSequence2);
                    stringBuilder.append(" -> ");
                    stringBuilder.append(charSequence.name());
                    charSequence2 = stringBuilder.toString();
                    if (dependencyNode.margin > 0 || bl) break block8;
                    charSequence = charSequence2;
                    if (!(dependencyNode.run instanceof HelperReferences)) break block9;
                }
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)charSequence2);
                ((StringBuilder)charSequence).append("[");
                charSequence2 = ((StringBuilder)charSequence).toString();
                charSequence = charSequence2;
                if (dependencyNode.margin > 0) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    ((StringBuilder)charSequence).append("label=\"");
                    ((StringBuilder)charSequence).append(dependencyNode.margin);
                    ((StringBuilder)charSequence).append("\"");
                    charSequence2 = ((StringBuilder)charSequence).toString();
                    charSequence = charSequence2;
                    if (bl) {
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append((String)charSequence2);
                        ((StringBuilder)charSequence).append(",");
                        charSequence = ((StringBuilder)charSequence).toString();
                    }
                }
                charSequence2 = charSequence;
                if (bl) {
                    charSequence2 = new StringBuilder();
                    ((StringBuilder)charSequence2).append((String)charSequence);
                    ((StringBuilder)charSequence2).append(" style=dashed ");
                    charSequence2 = ((StringBuilder)charSequence2).toString();
                }
                charSequence = charSequence2;
                if (dependencyNode.run instanceof HelperReferences) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    ((StringBuilder)charSequence).append(" style=bold,color=gray ");
                    charSequence = ((StringBuilder)charSequence).toString();
                }
                charSequence2 = new StringBuilder();
                ((StringBuilder)charSequence2).append((String)charSequence);
                ((StringBuilder)charSequence2).append("]");
                charSequence = ((StringBuilder)charSequence2).toString();
            }
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append((String)charSequence);
            ((StringBuilder)charSequence2).append("\n");
            charSequence2 = ((StringBuilder)charSequence2).toString();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string);
            ((StringBuilder)charSequence).append((String)charSequence2);
            string = ((StringBuilder)charSequence).toString();
        }
        return string;
    }

    private boolean isCenteredConnection(DependencyNode dependencyNode, DependencyNode object) {
        Iterator iterator = dependencyNode.targets.iterator();
        boolean bl = false;
        int n = 0;
        while (iterator.hasNext()) {
            if ((DependencyNode)iterator.next() == object) continue;
            ++n;
        }
        object = ((DependencyNode)object).targets.iterator();
        int n2 = 0;
        while (true) {
            if (!object.hasNext()) {
                boolean bl2 = bl;
                if (n <= 0) return bl2;
                bl2 = bl;
                if (n2 <= 0) return bl2;
                bl2 = true;
                return bl2;
            }
            if ((DependencyNode)object.next() == dependencyNode) continue;
            ++n2;
        }
    }

    private void measure(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int n, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int n2) {
        this.mMeasure.horizontalBehavior = dimensionBehaviour;
        this.mMeasure.verticalBehavior = dimensionBehaviour2;
        this.mMeasure.horizontalDimension = n;
        this.mMeasure.verticalDimension = n2;
        this.mMeasurer.measure(constraintWidget, this.mMeasure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    private String nodeDefinition(WidgetRun object) {
        boolean bl = object instanceof VerticalWidgetRun;
        String string = ((WidgetRun)object).widget.getDebugName();
        Object object2 = ((WidgetRun)object).widget;
        Object object3 = !bl ? object2.getHorizontalDimensionBehaviour() : object2.getVerticalDimensionBehaviour();
        RunGroup runGroup = ((WidgetRun)object).runGroup;
        if (!bl) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string);
            ((StringBuilder)object2).append("_HORIZONTAL");
            object2 = ((StringBuilder)object2).toString();
        } else {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string);
            ((StringBuilder)object2).append("_VERTICAL");
            object2 = ((StringBuilder)object2).toString();
        }
        Object object4 = new StringBuilder();
        ((StringBuilder)object4).append((String)object2);
        ((StringBuilder)object4).append(" [shape=none, label=<");
        object4 = ((StringBuilder)object4).toString();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)object4);
        ((StringBuilder)object2).append("<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">");
        object4 = ((StringBuilder)object2).toString();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)object4);
        ((StringBuilder)object2).append("  <TR>");
        object2 = ((StringBuilder)object2).toString();
        if (!bl) {
            object4 = new StringBuilder();
            ((StringBuilder)object4).append((String)object2);
            ((StringBuilder)object4).append("    <TD ");
            object2 = object4 = ((StringBuilder)object4).toString();
            if (((WidgetRun)object).start.resolved) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object4);
                ((StringBuilder)object2).append(" BGCOLOR=\"green\"");
                object2 = ((StringBuilder)object2).toString();
            }
            object4 = new StringBuilder();
            ((StringBuilder)object4).append((String)object2);
            ((StringBuilder)object4).append(" PORT=\"LEFT\" BORDER=\"1\">L</TD>");
            object2 = ((StringBuilder)object4).toString();
        } else {
            object4 = new StringBuilder();
            ((StringBuilder)object4).append((String)object2);
            ((StringBuilder)object4).append("    <TD ");
            object2 = object4 = ((StringBuilder)object4).toString();
            if (((WidgetRun)object).start.resolved) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object4);
                ((StringBuilder)object2).append(" BGCOLOR=\"green\"");
                object2 = ((StringBuilder)object2).toString();
            }
            object4 = new StringBuilder();
            ((StringBuilder)object4).append((String)object2);
            ((StringBuilder)object4).append(" PORT=\"TOP\" BORDER=\"1\">T</TD>");
            object2 = ((StringBuilder)object4).toString();
        }
        object4 = new StringBuilder();
        ((StringBuilder)object4).append((String)object2);
        ((StringBuilder)object4).append("    <TD BORDER=\"1\" ");
        object4 = ((StringBuilder)object4).toString();
        if (((WidgetRun)object).dimension.resolved && !((WidgetRun)object).widget.measured) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object4);
            ((StringBuilder)object2).append(" BGCOLOR=\"green\" ");
            object2 = ((StringBuilder)object2).toString();
        } else if (((WidgetRun)object).dimension.resolved && ((WidgetRun)object).widget.measured) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object4);
            ((StringBuilder)object2).append(" BGCOLOR=\"lightgray\" ");
            object2 = ((StringBuilder)object2).toString();
        } else {
            object2 = object4;
            if (!((WidgetRun)object).dimension.resolved) {
                object2 = object4;
                if (((WidgetRun)object).widget.measured) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append((String)object4);
                    ((StringBuilder)object2).append(" BGCOLOR=\"yellow\" ");
                    object2 = ((StringBuilder)object2).toString();
                }
            }
        }
        object4 = object2;
        if (object3 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append("style=\"dashed\"");
            object4 = ((StringBuilder)object3).toString();
        }
        if (runGroup != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(" [");
            ((StringBuilder)object2).append(runGroup.groupIndex + 1);
            ((StringBuilder)object2).append("/");
            ((StringBuilder)object2).append(RunGroup.index);
            ((StringBuilder)object2).append("]");
            object2 = ((StringBuilder)object2).toString();
        } else {
            object2 = "";
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append((String)object4);
        ((StringBuilder)object3).append(">");
        ((StringBuilder)object3).append(string);
        ((StringBuilder)object3).append((String)object2);
        ((StringBuilder)object3).append(" </TD>");
        object2 = ((StringBuilder)object3).toString();
        if (!bl) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append("    <TD ");
            object2 = object3 = ((StringBuilder)object3).toString();
            if (((WidgetRun)object).end.resolved) {
                object = new StringBuilder();
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append(" BGCOLOR=\"green\"");
                object2 = ((StringBuilder)object).toString();
            }
            object = new StringBuilder();
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(" PORT=\"RIGHT\" BORDER=\"1\">R</TD>");
            object = ((StringBuilder)object).toString();
        } else {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append("    <TD ");
            object2 = object3 = ((StringBuilder)object3).toString();
            if (bl) {
                object2 = object3;
                if (((VerticalWidgetRun)object).baseline.resolved) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append((String)object3);
                    ((StringBuilder)object2).append(" BGCOLOR=\"green\"");
                    object2 = ((StringBuilder)object2).toString();
                }
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append(" PORT=\"BASELINE\" BORDER=\"1\">b</TD>");
            object3 = ((StringBuilder)object3).toString();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append("    <TD ");
            object2 = object3 = ((StringBuilder)object2).toString();
            if (((WidgetRun)object).end.resolved) {
                object = new StringBuilder();
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append(" BGCOLOR=\"green\"");
                object2 = ((StringBuilder)object).toString();
            }
            object = new StringBuilder();
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(" PORT=\"BOTTOM\" BORDER=\"1\">B</TD>");
            object = ((StringBuilder)object).toString();
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("  </TR></TABLE>");
        object2 = ((StringBuilder)object2).toString();
        object = new StringBuilder();
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(">];\n");
        return ((StringBuilder)object).toString();
    }

    public void buildGraph() {
        this.buildGraph(this.mRuns);
        this.mGroups.clear();
        RunGroup.index = 0;
        this.findGroup((WidgetRun)this.container.horizontalRun, 0, this.mGroups);
        this.findGroup((WidgetRun)this.container.verticalRun, 1, this.mGroups);
        this.mNeedBuildGraph = false;
    }

    public void buildGraph(ArrayList<WidgetRun> widgetRun) {
        widgetRun.clear();
        this.mContainer.horizontalRun.clear();
        this.mContainer.verticalRun.clear();
        widgetRun.add((WidgetRun)this.mContainer.horizontalRun);
        widgetRun.add((WidgetRun)this.mContainer.verticalRun);
        Iterator iterator = this.mContainer.mChildren.iterator();
        Object object = null;
        while (iterator.hasNext()) {
            Object object2;
            ConstraintWidget constraintWidget = (ConstraintWidget)iterator.next();
            if (constraintWidget instanceof Guideline) {
                widgetRun.add((WidgetRun)new GuidelineReference(constraintWidget));
                continue;
            }
            if (constraintWidget.isInHorizontalChain()) {
                if (constraintWidget.horizontalChainRun == null) {
                    constraintWidget.horizontalChainRun = new ChainRun(constraintWidget, 0);
                }
                object2 = object;
                if (object == null) {
                    object2 = new HashSet();
                }
                ((HashSet)object2).add((ChainRun)constraintWidget.horizontalChainRun);
                object = object2;
            } else {
                widgetRun.add((WidgetRun)constraintWidget.horizontalRun);
            }
            if (constraintWidget.isInVerticalChain()) {
                if (constraintWidget.verticalChainRun == null) {
                    constraintWidget.verticalChainRun = new ChainRun(constraintWidget, 1);
                }
                object2 = object;
                if (object == null) {
                    object2 = new HashSet();
                }
                ((HashSet)object2).add((ChainRun)constraintWidget.verticalChainRun);
            } else {
                widgetRun.add(constraintWidget.verticalRun);
                object2 = object;
            }
            object = object2;
            if (!(constraintWidget instanceof HelperWidget)) continue;
            widgetRun.add(new HelperReferences(constraintWidget));
            object = object2;
        }
        if (object != null) {
            widgetRun.addAll(object);
        }
        object = widgetRun.iterator();
        while (object.hasNext()) {
            object.next().clear();
        }
        object = widgetRun.iterator();
        while (object.hasNext()) {
            widgetRun = object.next();
            if (widgetRun.widget == this.mContainer) continue;
            widgetRun.apply();
        }
    }

    public void defineTerminalWidgets(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2) {
        Object object;
        if (!this.mNeedBuildGraph) return;
        this.buildGraph();
        RunGroup runGroup = this.container.mChildren.iterator();
        boolean bl = false;
        while (runGroup.hasNext()) {
            object = (ConstraintWidget)runGroup.next();
            ((ConstraintWidget)object).isTerminalWidget[0] = true;
            ((ConstraintWidget)object).isTerminalWidget[1] = true;
            if (!(object instanceof Barrier)) continue;
            bl = true;
        }
        if (bl) return;
        object = this.mGroups.iterator();
        while (object.hasNext()) {
            runGroup = (RunGroup)object.next();
            boolean bl2 = dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean bl3 = dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            runGroup.defineTerminalWidgets(bl2, bl3);
        }
    }

    public boolean directMeasure(boolean bl) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget constraintWidget2;
        block15: {
            WidgetRun widgetRun2;
            Object object;
            int n;
            boolean bl2 = true;
            int n2 = bl & 1;
            if (this.mNeedBuildGraph || this.mNeedRedoMeasures) {
                for (ConstraintWidget constraintWidget2 : this.container.mChildren) {
                    constraintWidget2.ensureWidgetRuns();
                    constraintWidget2.measured = false;
                    constraintWidget2.horizontalRun.reset();
                    constraintWidget2.verticalRun.reset();
                }
                this.container.ensureWidgetRuns();
                this.container.measured = false;
                this.container.horizontalRun.reset();
                this.container.verticalRun.reset();
                this.mNeedRedoMeasures = false;
            }
            if (this.basicMeasureWidgets(this.mContainer)) {
                return false;
            }
            this.container.setX(0);
            this.container.setY(0);
            dimensionBehaviour = this.container.getDimensionBehaviour(0);
            constraintWidget2 = this.container.getDimensionBehaviour(1);
            if (this.mNeedBuildGraph) {
                this.buildGraph();
            }
            int n3 = this.container.getX();
            int n4 = this.container.getY();
            this.container.horizontalRun.start.resolve(n3);
            this.container.verticalRun.start.resolve(n4);
            this.measureWidgets();
            if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || constraintWidget2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                block14: {
                    n = n2;
                    if (n2 != 0) {
                        object = this.mRuns.iterator();
                        do {
                            n = n2;
                            if (!object.hasNext()) break block14;
                        } while (object.next().supportsWrapComputation());
                        n = 0;
                    }
                }
                if (n != 0 && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    object = this.container;
                    object.setWidth(this.computeWrap((ConstraintWidgetContainer)object, 0));
                    this.container.horizontalRun.dimension.resolve(this.container.getWidth());
                }
                if (n != 0 && constraintWidget2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    object = this.container;
                    object.setHeight(this.computeWrap((ConstraintWidgetContainer)object, 1));
                    this.container.verticalRun.dimension.resolve(this.container.getHeight());
                }
            }
            if (this.container.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.FIXED && this.container.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                n = 0;
            } else {
                n = this.container.getWidth() + n3;
                this.container.horizontalRun.end.resolve(n);
                this.container.horizontalRun.dimension.resolve(n - n3);
                this.measureWidgets();
                if (this.container.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED || this.container.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                    n = this.container.getHeight() + n4;
                    this.container.verticalRun.end.resolve(n);
                    this.container.verticalRun.dimension.resolve(n - n4);
                }
                this.measureWidgets();
                n = 1;
            }
            for (WidgetRun widgetRun2 : this.mRuns) {
                if (widgetRun2.widget == this.container && !widgetRun2.resolved) continue;
                widgetRun2.applyToWidget();
            }
            object = this.mRuns.iterator();
            do {
                bl = bl2;
                if (!object.hasNext()) break block15;
                widgetRun2 = (WidgetRun)object.next();
            } while (n == 0 && widgetRun2.widget == this.container || widgetRun2.start.resolved && (widgetRun2.end.resolved || widgetRun2 instanceof GuidelineReference) && (widgetRun2.dimension.resolved || widgetRun2 instanceof ChainRun || widgetRun2 instanceof GuidelineReference));
            bl = false;
        }
        this.container.setHorizontalDimensionBehaviour(dimensionBehaviour);
        this.container.setVerticalDimensionBehaviour((ConstraintWidget.DimensionBehaviour)constraintWidget2);
        return bl;
    }

    public boolean directMeasureSetup(boolean bl) {
        if (this.mNeedBuildGraph) {
            for (ConstraintWidget constraintWidget : this.container.mChildren) {
                constraintWidget.ensureWidgetRuns();
                constraintWidget.measured = false;
                constraintWidget.horizontalRun.dimension.resolved = false;
                constraintWidget.horizontalRun.resolved = false;
                constraintWidget.horizontalRun.reset();
                constraintWidget.verticalRun.dimension.resolved = false;
                constraintWidget.verticalRun.resolved = false;
                constraintWidget.verticalRun.reset();
            }
            this.container.ensureWidgetRuns();
            this.container.measured = false;
            this.container.horizontalRun.dimension.resolved = false;
            this.container.horizontalRun.resolved = false;
            this.container.horizontalRun.reset();
            this.container.verticalRun.dimension.resolved = false;
            this.container.verticalRun.resolved = false;
            this.container.verticalRun.reset();
            this.buildGraph();
        }
        if (this.basicMeasureWidgets(this.mContainer)) {
            return false;
        }
        this.container.setX(0);
        this.container.setY(0);
        this.container.horizontalRun.start.resolve(0);
        this.container.verticalRun.start.resolve(0);
        return true;
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    public boolean directMeasureWithOrientation(boolean var1_1, int var2_2) {
        block11: {
            block12: {
                var7_3 = true;
                var4_4 = var1_1 & 1;
                var9_5 = this.container.getDimensionBehaviour(0);
                var8_6 = this.container.getDimensionBehaviour(1);
                var6_7 = this.container.getX();
                var5_8 = this.container.getY();
                if (var4_4 != 0 && (var9_5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || var8_6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                    block10: {
                        var10_9 = this.mRuns.iterator();
                        do {
                            var3_10 = var4_4;
                            if (!var10_9.hasNext()) break block10;
                            var11_11 = var10_9.next();
                        } while (var11_11.orientation != var2_2 || var11_11.supportsWrapComputation());
                        var3_10 = 0;
                    }
                    if (var2_2 == 0) {
                        if (var3_10 != 0 && var9_5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                            this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                            var10_9 = this.container;
                            var10_9.setWidth(this.computeWrap(var10_9, 0));
                            this.container.horizontalRun.dimension.resolve(this.container.getWidth());
                        }
                    } else if (var3_10 != 0 && var8_6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                        var10_9 = this.container;
                        var10_9.setHeight(this.computeWrap(var10_9, 1));
                        this.container.verticalRun.dimension.resolve(this.container.getHeight());
                    }
                }
                if (var2_2 != 0) break block12;
                if (this.container.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.FIXED && this.container.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) ** GOTO lbl-1000
                var3_10 = this.container.getWidth() + var6_7;
                this.container.horizontalRun.end.resolve(var3_10);
                this.container.horizontalRun.dimension.resolve(var3_10 - var6_7);
                ** GOTO lbl41
            }
            if (this.container.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.FIXED && this.container.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) lbl-1000:
            // 2 sources

            {
                var3_10 = 0;
            } else {
                var3_10 = this.container.getHeight() + var5_8;
                this.container.verticalRun.end.resolve(var3_10);
                this.container.verticalRun.dimension.resolve(var3_10 - var5_8);
lbl41:
                // 2 sources

                var3_10 = 1;
            }
            this.measureWidgets();
            for (Object var11_11 : this.mRuns) {
                if (var11_11.orientation != var2_2 || var11_11.widget == this.container && !var11_11.resolved) continue;
                var11_11.applyToWidget();
            }
            var11_11 = this.mRuns.iterator();
            do {
                var1_1 = var7_3;
                if (!var11_11.hasNext()) break block11;
                var10_9 = (WidgetRun)var11_11.next();
            } while (var10_9.orientation != var2_2 || var3_10 == 0 && var10_9.widget == this.container || var10_9.start.resolved && var10_9.end.resolved && (var10_9 instanceof ChainRun || var10_9.dimension.resolved));
            var1_1 = false;
        }
        this.container.setHorizontalDimensionBehaviour(var9_5);
        this.container.setVerticalDimensionBehaviour(var8_6);
        return var1_1;
    }

    public void invalidateGraph() {
        this.mNeedBuildGraph = true;
    }

    public void invalidateMeasures() {
        this.mNeedRedoMeasures = true;
    }

    public void measureWidgets() {
        Iterator iterator = this.container.mChildren.iterator();
        while (iterator.hasNext()) {
            boolean bl;
            int n;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
            ConstraintWidget constraintWidget;
            block14: {
                block13: {
                    constraintWidget = (ConstraintWidget)iterator.next();
                    if (constraintWidget.measured) continue;
                    dimensionBehaviour2 = constraintWidget.mListDimensionBehaviors;
                    boolean bl2 = false;
                    dimensionBehaviour = dimensionBehaviour2[0];
                    dimensionBehaviour2 = constraintWidget.mListDimensionBehaviors[1];
                    n = constraintWidget.mMatchConstraintDefaultWidth;
                    int n2 = constraintWidget.mMatchConstraintDefaultHeight;
                    n = dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || n != 1) ? 0 : 1;
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) break block13;
                    bl = bl2;
                    if (dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) break block14;
                    bl = bl2;
                    if (n2 != 1) break block14;
                }
                bl = true;
            }
            boolean bl3 = constraintWidget.horizontalRun.dimension.resolved;
            boolean bl4 = constraintWidget.verticalRun.dimension.resolved;
            if (bl3 && bl4) {
                this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, constraintWidget.horizontalRun.dimension.value, ConstraintWidget.DimensionBehaviour.FIXED, constraintWidget.verticalRun.dimension.value);
                constraintWidget.measured = true;
            } else if (bl3 && bl) {
                this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, constraintWidget.horizontalRun.dimension.value, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, constraintWidget.verticalRun.dimension.value);
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget.verticalRun.dimension.wrapValue = constraintWidget.getHeight();
                } else {
                    constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                    constraintWidget.measured = true;
                }
            } else if (bl4 && n != 0) {
                this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, constraintWidget.horizontalRun.dimension.value, ConstraintWidget.DimensionBehaviour.FIXED, constraintWidget.verticalRun.dimension.value);
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget.horizontalRun.dimension.wrapValue = constraintWidget.getWidth();
                } else {
                    constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                    constraintWidget.measured = true;
                }
            }
            if (!constraintWidget.measured || constraintWidget.verticalRun.baselineDimension == null) continue;
            constraintWidget.verticalRun.baselineDimension.resolve(constraintWidget.getBaselineDistance());
        }
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.mMeasurer = measurer;
    }
}
