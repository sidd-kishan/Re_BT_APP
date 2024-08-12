/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.model.WorkTag
 */
package androidx.work.impl.model;

import androidx.work.impl.model.WorkTag;
import java.util.List;

public interface WorkTagDao {
    public List<String> getTagsForWorkSpecId(String var1);

    public List<String> getWorkSpecIdsWithTag(String var1);

    public void insert(WorkTag var1);
}
