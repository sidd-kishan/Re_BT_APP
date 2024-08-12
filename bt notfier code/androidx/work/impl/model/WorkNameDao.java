/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.model.WorkName
 */
package androidx.work.impl.model;

import androidx.work.impl.model.WorkName;
import java.util.List;

public interface WorkNameDao {
    public List<String> getNamesForWorkSpecId(String var1);

    public List<String> getWorkSpecIdsWithName(String var1);

    public void insert(WorkName var1);
}
