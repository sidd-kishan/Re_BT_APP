/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  androidx.appcompat.widget.ActivityChooserModel$ActivityResolveInfo
 *  androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord
 */
package androidx.appcompat.widget;

import android.content.Intent;
import androidx.appcompat.widget.ActivityChooserModel;
import java.util.List;

public static interface ActivityChooserModel.ActivitySorter {
    public void sort(Intent var1, List<ActivityChooserModel.ActivityResolveInfo> var2, List<ActivityChooserModel.HistoricalRecord> var3);
}
