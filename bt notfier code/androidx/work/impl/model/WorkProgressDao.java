/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Data
 *  androidx.work.impl.model.WorkProgress
 */
package androidx.work.impl.model;

import androidx.work.Data;
import androidx.work.impl.model.WorkProgress;
import java.util.List;

public interface WorkProgressDao {
    public void delete(String var1);

    public void deleteAll();

    public Data getProgressForWorkSpecId(String var1);

    public List<Data> getProgressForWorkSpecIds(List<String> var1);

    public void insert(WorkProgress var1);
}
