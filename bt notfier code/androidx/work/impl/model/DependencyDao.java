/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.model.Dependency
 */
package androidx.work.impl.model;

import androidx.work.impl.model.Dependency;
import java.util.List;

public interface DependencyDao {
    public List<String> getDependentWorkIds(String var1);

    public List<String> getPrerequisites(String var1);

    public boolean hasCompletedAllPrerequisites(String var1);

    public boolean hasDependents(String var1);

    public void insertDependency(Dependency var1);
}
