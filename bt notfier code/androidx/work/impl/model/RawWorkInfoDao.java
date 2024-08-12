/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  androidx.sqlite.db.SupportSQLiteQuery
 *  androidx.work.impl.model.WorkSpec$WorkInfoPojo
 */
package androidx.work.impl.model;

import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

public interface RawWorkInfoDao {
    public List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(SupportSQLiteQuery var1);

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(SupportSQLiteQuery var1);
}
