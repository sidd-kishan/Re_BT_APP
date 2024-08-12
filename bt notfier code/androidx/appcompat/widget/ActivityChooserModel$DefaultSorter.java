/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Intent
 *  androidx.appcompat.widget.ActivityChooserModel$ActivityResolveInfo
 *  androidx.appcompat.widget.ActivityChooserModel$ActivitySorter
 *  androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord
 */
package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Intent;
import androidx.appcompat.widget.ActivityChooserModel;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

private static final class ActivityChooserModel.DefaultSorter
implements ActivityChooserModel.ActivitySorter {
    private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
    private final Map<ComponentName, ActivityChooserModel.ActivityResolveInfo> mPackageNameToActivityMap = new HashMap<ComponentName, ActivityChooserModel.ActivityResolveInfo>();

    ActivityChooserModel.DefaultSorter() {
    }

    public void sort(Intent object, List<ActivityChooserModel.ActivityResolveInfo> list, List<ActivityChooserModel.HistoricalRecord> list2) {
        ActivityChooserModel.ActivityResolveInfo activityResolveInfo;
        int n;
        object = this.mPackageNameToActivityMap;
        object.clear();
        int n2 = list.size();
        for (n = 0; n < n2; ++n) {
            activityResolveInfo = list.get(n);
            activityResolveInfo.weight = 0.0f;
            object.put(new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name), activityResolveInfo);
        }
        n = list2.size() - 1;
        float f = 1.0f;
        while (true) {
            if (n < 0) {
                Collections.sort(list);
                return;
            }
            ActivityChooserModel.HistoricalRecord historicalRecord = list2.get(n);
            activityResolveInfo = (ActivityChooserModel.ActivityResolveInfo)object.get(historicalRecord.activity);
            float f2 = f;
            if (activityResolveInfo != null) {
                activityResolveInfo.weight += historicalRecord.weight * f;
                f2 = f * 0.95f;
            }
            --n;
            f = f2;
        }
    }
}
