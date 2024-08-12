/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  androidx.work.Data
 *  androidx.work.WorkInfo$State
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.model.WorkSpec$IdAndState
 *  androidx.work.impl.model.WorkSpec$WorkInfoPojo
 */
package androidx.work.impl.model;

import androidx.lifecycle.LiveData;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

public interface WorkSpecDao {
    public void delete(String var1);

    public List<WorkSpec> getAllEligibleWorkSpecsForScheduling(int var1);

    public List<String> getAllUnfinishedWork();

    public List<String> getAllWorkSpecIds();

    public LiveData<List<String>> getAllWorkSpecIdsLiveData();

    public List<WorkSpec> getEligibleWorkForScheduling(int var1);

    public List<Data> getInputsFromPrerequisites(String var1);

    public List<WorkSpec> getRecentlyCompletedWork(long var1);

    public List<WorkSpec> getRunningWork();

    public LiveData<Long> getScheduleRequestedAtLiveData(String var1);

    public List<WorkSpec> getScheduledWork();

    public WorkInfo.State getState(String var1);

    public List<String> getUnfinishedWorkWithName(String var1);

    public List<String> getUnfinishedWorkWithTag(String var1);

    public WorkSpec getWorkSpec(String var1);

    public List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(String var1);

    public WorkSpec[] getWorkSpecs(List<String> var1);

    public WorkSpec.WorkInfoPojo getWorkStatusPojoForId(String var1);

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForIds(List<String> var1);

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForName(String var1);

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForTag(String var1);

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForIds(List<String> var1);

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForName(String var1);

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForTag(String var1);

    public boolean hasUnfinishedWork();

    public int incrementWorkSpecRunAttemptCount(String var1);

    public void insertWorkSpec(WorkSpec var1);

    public int markWorkSpecScheduled(String var1, long var2);

    public void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast();

    public int resetScheduledState();

    public int resetWorkSpecRunAttemptCount(String var1);

    public void setOutput(String var1, Data var2);

    public void setPeriodStartTime(String var1, long var2);

    public int setState(WorkInfo.State var1, String ... var2);
}
