/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.constraints.controllers;

import java.util.List;

public static interface ConstraintController.OnConstraintUpdatedCallback {
    public void onConstraintMet(List<String> var1);

    public void onConstraintNotMet(List<String> var1);
}
