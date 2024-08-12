/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.model.SystemIdInfo
 */
package androidx.work.impl.model;

import androidx.work.impl.model.SystemIdInfo;
import java.util.List;

public interface SystemIdInfoDao {
    public SystemIdInfo getSystemIdInfo(String var1);

    public List<String> getWorkSpecIds();

    public void insertSystemIdInfo(SystemIdInfo var1);

    public void removeSystemIdInfo(String var1);
}
