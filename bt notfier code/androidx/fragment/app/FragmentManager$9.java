/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.activity.result.ActivityResult
 *  androidx.activity.result.ActivityResultCallback
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentManager$LaunchedFragmentInfo
 */
package androidx.fragment.app;

import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.FragmentManager;

/*
 * Exception performing whole class analysis ignored.
 */
class FragmentManager.9
implements ActivityResultCallback<ActivityResult> {
    final FragmentManager this$0;

    FragmentManager.9(FragmentManager fragmentManager) {
        this.this$0 = fragmentManager;
    }

    public void onActivityResult(ActivityResult object) {
        FragmentManager.LaunchedFragmentInfo launchedFragmentInfo = (FragmentManager.LaunchedFragmentInfo)this.this$0.mLaunchedFragments.pollFirst();
        if (launchedFragmentInfo == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("No Activities were started for result for ");
            ((StringBuilder)object).append(this);
            Log.w((String)"FragmentManager", (String)((StringBuilder)object).toString());
            return;
        }
        String string = launchedFragmentInfo.mWho;
        int n = launchedFragmentInfo.mRequestCode;
        launchedFragmentInfo = FragmentManager.access$200((FragmentManager)this.this$0).findFragmentByWho(string);
        if (launchedFragmentInfo == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Activity result delivered for unknown Fragment ");
            ((StringBuilder)object).append(string);
            Log.w((String)"FragmentManager", (String)((StringBuilder)object).toString());
            return;
        }
        launchedFragmentInfo.onActivityResult(n, object.getResultCode(), object.getData());
    }
}
