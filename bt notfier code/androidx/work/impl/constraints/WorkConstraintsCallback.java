/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.constraints;

import java.util.List;

public interface WorkConstraintsCallback {
    public void onAllConstraintsMet(List<String> var1);

    public void onAllConstraintsNotMet(List<String> var1);
}
