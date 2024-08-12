/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.InputMerger
 */
package androidx.work;

import androidx.work.InputMerger;

public abstract class InputMergerFactory {
    public static InputMergerFactory getDefaultInputMergerFactory() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public abstract InputMerger createInputMerger(String var1);

    public final InputMerger createInputMergerWithDefaultFallback(String string) {
        InputMerger inputMerger;
        InputMerger inputMerger2 = inputMerger = this.createInputMerger(string);
        if (inputMerger != null) return inputMerger2;
        inputMerger2 = InputMerger.fromClassName((String)string);
        return inputMerger2;
    }
}
