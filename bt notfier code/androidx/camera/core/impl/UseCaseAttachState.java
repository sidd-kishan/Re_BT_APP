/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.Logger
 *  androidx.camera.core.impl.SessionConfig
 *  androidx.camera.core.impl.SessionConfig$ValidatingBuilder
 *  androidx.camera.core.impl.UseCaseAttachState$AttachStateFilter
 *  androidx.camera.core.impl.UseCaseAttachState$UseCaseAttachInfo
 *  androidx.camera.core.impl._$$Lambda$UseCaseAttachState$ECqc7D4wrT6_n5qu4JAviYvI7P8
 *  androidx.camera.core.impl._$$Lambda$UseCaseAttachState$LKtf6DM5i1yJ2B_bR_7MUvVVuV4
 */
package androidx.camera.core.impl;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseAttachState;
import androidx.camera.core.impl._$;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class UseCaseAttachState {
    private static final String TAG = "UseCaseAttachState";
    private final Map<String, UseCaseAttachInfo> mAttachedUseCasesToInfoMap = new HashMap<String, UseCaseAttachInfo>();
    private final String mCameraId;

    public UseCaseAttachState(String string) {
        this.mCameraId = string;
    }

    private UseCaseAttachInfo getOrCreateUseCaseAttachInfo(String string, SessionConfig sessionConfig) {
        UseCaseAttachInfo useCaseAttachInfo;
        UseCaseAttachInfo useCaseAttachInfo2 = useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(string);
        if (useCaseAttachInfo != null) return useCaseAttachInfo2;
        useCaseAttachInfo2 = new UseCaseAttachInfo(sessionConfig);
        this.mAttachedUseCasesToInfoMap.put(string, useCaseAttachInfo2);
        return useCaseAttachInfo2;
    }

    private Collection<SessionConfig> getSessionConfigs(AttachStateFilter attachStateFilter) {
        ArrayList<SessionConfig> arrayList = new ArrayList<SessionConfig>();
        Iterator<Map.Entry<String, UseCaseAttachInfo>> iterator = this.mAttachedUseCasesToInfoMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, UseCaseAttachInfo> entry = iterator.next();
            if (attachStateFilter != null && !attachStateFilter.filter(entry.getValue())) continue;
            arrayList.add(entry.getValue().getSessionConfig());
        }
        return arrayList;
    }

    static /* synthetic */ boolean lambda$getActiveAndAttachedSessionConfigs$1(UseCaseAttachInfo useCaseAttachInfo) {
        boolean bl = useCaseAttachInfo.getActive() && useCaseAttachInfo.getAttached();
        return bl;
    }

    static /* synthetic */ boolean lambda$getAttachedSessionConfigs$0(UseCaseAttachInfo useCaseAttachInfo) {
        return useCaseAttachInfo.getAttached();
    }

    public SessionConfig.ValidatingBuilder getActiveAndAttachedBuilder() {
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object = this.mAttachedUseCasesToInfoMap.entrySet().iterator();
        while (true) {
            if (!object.hasNext()) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Active and attached use case: ");
                ((StringBuilder)object).append(arrayList);
                ((StringBuilder)object).append(" for camera: ");
                ((StringBuilder)object).append(this.mCameraId);
                Logger.d((String)TAG, (String)((StringBuilder)object).toString());
                return validatingBuilder;
            }
            Map.Entry<String, UseCaseAttachInfo> entry = object.next();
            UseCaseAttachInfo useCaseAttachInfo = entry.getValue();
            if (!useCaseAttachInfo.getActive() || !useCaseAttachInfo.getAttached()) continue;
            entry = entry.getKey();
            validatingBuilder.add(useCaseAttachInfo.getSessionConfig());
            arrayList.add(entry);
        }
    }

    public Collection<SessionConfig> getActiveAndAttachedSessionConfigs() {
        return Collections.unmodifiableCollection(this.getSessionConfigs((AttachStateFilter)_$.Lambda.UseCaseAttachState.LKtf6DM5i1yJ2B_bR_7MUvVVuV4.INSTANCE));
    }

    public SessionConfig.ValidatingBuilder getAttachedBuilder() {
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        ArrayList<String> arrayList = new ArrayList<String>();
        Iterator<Map.Entry<String, UseCaseAttachInfo>> iterator = this.mAttachedUseCasesToInfoMap.entrySet().iterator();
        while (true) {
            Map.Entry<String, UseCaseAttachInfo> entry;
            if (!iterator.hasNext()) {
                entry = new StringBuilder();
                ((StringBuilder)((Object)entry)).append("All use case: ");
                ((StringBuilder)((Object)entry)).append(arrayList);
                ((StringBuilder)((Object)entry)).append(" for camera: ");
                ((StringBuilder)((Object)entry)).append(this.mCameraId);
                Logger.d((String)TAG, (String)((StringBuilder)((Object)entry)).toString());
                return validatingBuilder;
            }
            entry = iterator.next();
            UseCaseAttachInfo useCaseAttachInfo = (UseCaseAttachInfo)entry.getValue();
            if (!useCaseAttachInfo.getAttached()) continue;
            validatingBuilder.add(useCaseAttachInfo.getSessionConfig());
            arrayList.add((String)entry.getKey());
        }
    }

    public Collection<SessionConfig> getAttachedSessionConfigs() {
        return Collections.unmodifiableCollection(this.getSessionConfigs((AttachStateFilter)_$.Lambda.UseCaseAttachState.ECqc7D4wrT6_n5qu4JAviYvI7P8.INSTANCE));
    }

    public boolean isUseCaseAttached(String string) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(string)) return this.mAttachedUseCasesToInfoMap.get(string).getAttached();
        return false;
    }

    public void removeUseCase(String string) {
        this.mAttachedUseCasesToInfoMap.remove(string);
    }

    public void setUseCaseActive(String string, SessionConfig sessionConfig) {
        this.getOrCreateUseCaseAttachInfo(string, sessionConfig).setActive(true);
    }

    public void setUseCaseAttached(String string, SessionConfig sessionConfig) {
        this.getOrCreateUseCaseAttachInfo(string, sessionConfig).setAttached(true);
    }

    public void setUseCaseDetached(String string) {
        if (!this.mAttachedUseCasesToInfoMap.containsKey(string)) {
            return;
        }
        UseCaseAttachInfo useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(string);
        useCaseAttachInfo.setAttached(false);
        if (useCaseAttachInfo.getActive()) return;
        this.mAttachedUseCasesToInfoMap.remove(string);
    }

    public void setUseCaseInactive(String string) {
        if (!this.mAttachedUseCasesToInfoMap.containsKey(string)) {
            return;
        }
        UseCaseAttachInfo useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(string);
        useCaseAttachInfo.setActive(false);
        if (useCaseAttachInfo.getAttached()) return;
        this.mAttachedUseCasesToInfoMap.remove(string);
    }

    public void updateUseCase(String string, SessionConfig sessionConfig) {
        if (!this.mAttachedUseCasesToInfoMap.containsKey(string)) {
            return;
        }
        UseCaseAttachInfo useCaseAttachInfo = new UseCaseAttachInfo(sessionConfig);
        sessionConfig = this.mAttachedUseCasesToInfoMap.get(string);
        useCaseAttachInfo.setAttached(sessionConfig.getAttached());
        useCaseAttachInfo.setActive(sessionConfig.getActive());
        this.mAttachedUseCasesToInfoMap.put(string, useCaseAttachInfo);
    }
}
