/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;

static class VerticalWidgetRun.1 {
    static final int[] $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[WidgetRun.RunType.values().length];
        $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType = nArray;
        try {
            nArray[WidgetRun.RunType.START.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            VerticalWidgetRun.1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.END.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            VerticalWidgetRun.1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.CENTER.ordinal()] = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
