/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.activity.result.ActivityResultCallback
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentManager$LaunchedFragmentInfo
 */
package androidx.fragment.app;

import android.util.Log;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.Map;

/*
 * Exception performing whole class analysis ignored.
 */
class FragmentManager.11
implements ActivityResultCallback<Map<String, Boolean>> {
    final FragmentManager this$0;

    FragmentManager.11(FragmentManager fragmentManager) {
        this.this$0 = fragmentManager;
    }

    public void onActivityResult(Map<String, Boolean> object) {
        int n;
        Object object2 = object.keySet().toArray(new String[0]);
        object = new ArrayList<Boolean>(object.values());
        int[] nArray = new int[((ArrayList)object).size()];
        for (n = 0; n < ((ArrayList)object).size(); ++n) {
            int n2 = (Boolean)((ArrayList)object).get(n) != false ? 0 : -1;
            nArray[n] = n2;
        }
        FragmentManager.LaunchedFragmentInfo launchedFragmentInfo = (FragmentManager.LaunchedFragmentInfo)this.this$0.mLaunchedFragments.pollFirst();
        if (launchedFragmentInfo == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("No permissions were requested for ");
            ((StringBuilder)object).append(this);
            Log.w((String)"FragmentManager", (String)((StringBuilder)object).toString());
            return;
        }
        object = launchedFragmentInfo.mWho;
        n = launchedFragmentInfo.mRequestCode;
        launchedFragmentInfo = FragmentManager.access$200((FragmentManager)this.this$0).findFragmentByWho((String)object);
        if (launchedFragmentInfo == null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Permission request result delivered for unknown Fragment ");
            ((StringBuilder)object2).append((String)object);
            Log.w((String)"FragmentManager", (String)((StringBuilder)object2).toString());
            return;
        }
        launchedFragmentInfo.onRequestPermissionsResult(n, (String[])object2, nArray);
    }
}
