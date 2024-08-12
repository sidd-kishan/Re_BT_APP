/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.job.JobInfo
 *  android.app.job.JobInfo$Builder
 *  android.app.job.JobInfo$TriggerContentUri
 *  android.content.ComponentName
 *  android.content.Context
 *  android.net.NetworkRequest$Builder
 *  android.os.Build$VERSION
 *  android.os.PersistableBundle
 *  androidx.core.os.BuildCompat
 *  androidx.work.BackoffPolicy
 *  androidx.work.Constraints
 *  androidx.work.ContentUriTriggers$Trigger
 *  androidx.work.Logger
 *  androidx.work.NetworkType
 *  androidx.work.impl.background.systemjob.SystemJobInfoConverter$1
 *  androidx.work.impl.background.systemjob.SystemJobService
 *  androidx.work.impl.model.WorkSpec
 */
package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.os.BuildCompat;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ContentUriTriggers;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.background.systemjob.SystemJobInfoConverter;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkSpec;
import java.util.Iterator;

class SystemJobInfoConverter {
    static final String EXTRA_IS_PERIODIC = "EXTRA_IS_PERIODIC";
    static final String EXTRA_WORK_SPEC_ID = "EXTRA_WORK_SPEC_ID";
    private static final String TAG = Logger.tagWithPrefix((String)"SystemJobInfoConverter");
    private final ComponentName mWorkServiceComponent;

    SystemJobInfoConverter(Context context) {
        this.mWorkServiceComponent = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }

    private static JobInfo.TriggerContentUri convertContentUriTrigger(ContentUriTriggers.Trigger trigger) {
        int n = trigger.shouldTriggerForDescendants();
        return new JobInfo.TriggerContentUri(trigger.getUri(), n);
    }

    static int convertNetworkType(NetworkType networkType) {
        int n = 1.$SwitchMap$androidx$work$NetworkType[networkType.ordinal()];
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n != 4) {
            if (n == 5 && Build.VERSION.SDK_INT >= 26) {
                return 4;
            }
        } else if (Build.VERSION.SDK_INT >= 24) {
            return 3;
        }
        Logger.get().debug(TAG, String.format("API version too low. Cannot convert network type value %s", networkType), new Throwable[0]);
        return 1;
    }

    static void setRequiredNetwork(JobInfo.Builder builder, NetworkType networkType) {
        if (Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
            builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        } else {
            builder.setRequiredNetworkType(SystemJobInfoConverter.convertNetworkType(networkType));
        }
    }

    JobInfo convert(WorkSpec workSpec, int n) {
        Constraints constraints = workSpec.constraints;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(EXTRA_WORK_SPEC_ID, workSpec.id);
        persistableBundle.putBoolean(EXTRA_IS_PERIODIC, workSpec.isPeriodic());
        persistableBundle = new JobInfo.Builder(n, this.mWorkServiceComponent).setRequiresCharging(constraints.requiresCharging()).setRequiresDeviceIdle(constraints.requiresDeviceIdle()).setExtras(persistableBundle);
        SystemJobInfoConverter.setRequiredNetwork((JobInfo.Builder)persistableBundle, constraints.getRequiredNetworkType());
        boolean bl = constraints.requiresDeviceIdle();
        int n2 = 0;
        if (!bl) {
            n = workSpec.backoffPolicy == BackoffPolicy.LINEAR ? 0 : 1;
            persistableBundle.setBackoffCriteria(workSpec.backoffDelayDuration, n);
        }
        long l = Math.max(workSpec.calculateNextRunTime() - System.currentTimeMillis(), 0L);
        if (Build.VERSION.SDK_INT <= 28) {
            persistableBundle.setMinimumLatency(l);
        } else if (l > 0L) {
            persistableBundle.setMinimumLatency(l);
        } else if (!workSpec.expedited) {
            persistableBundle.setImportantWhileForeground(true);
        }
        if (Build.VERSION.SDK_INT >= 24 && constraints.hasContentUriTriggers()) {
            Iterator iterator = constraints.getContentUriTriggers().getTriggers().iterator();
            while (iterator.hasNext()) {
                persistableBundle.addTriggerContentUri(SystemJobInfoConverter.convertContentUriTrigger((ContentUriTriggers.Trigger)iterator.next()));
            }
            persistableBundle.setTriggerContentUpdateDelay(constraints.getTriggerContentUpdateDelay());
            persistableBundle.setTriggerContentMaxDelay(constraints.getTriggerMaxContentDelay());
        }
        persistableBundle.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            persistableBundle.setRequiresBatteryNotLow(constraints.requiresBatteryNotLow());
            persistableBundle.setRequiresStorageNotLow(constraints.requiresStorageNotLow());
        }
        n = n2;
        if (workSpec.runAttemptCount > 0) {
            n = 1;
        }
        if (!BuildCompat.isAtLeastS()) return persistableBundle.build();
        if (!workSpec.expedited) return persistableBundle.build();
        if (n != 0) return persistableBundle.build();
        persistableBundle.setExpedited(true);
        return persistableBundle.build();
    }
}
