/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ResolveInfo
 *  android.database.DataSetObservable
 *  android.os.AsyncTask
 *  android.text.TextUtils
 *  android.util.Log
 *  android.util.Xml
 *  androidx.appcompat.widget.ActivityChooserModel$ActivityResolveInfo
 *  androidx.appcompat.widget.ActivityChooserModel$ActivitySorter
 *  androidx.appcompat.widget.ActivityChooserModel$DefaultSorter
 *  androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord
 *  androidx.appcompat.widget.ActivityChooserModel$OnChooseActivityListener
 *  androidx.appcompat.widget.ActivityChooserModel$PersistHistoryAsyncTask
 */
package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.widget.ActivityChooserModel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

class ActivityChooserModel
extends DataSetObservable {
    static final String ATTRIBUTE_ACTIVITY = "activity";
    static final String ATTRIBUTE_TIME = "time";
    static final String ATTRIBUTE_WEIGHT = "weight";
    static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = -1;
    static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
    static final String TAG_HISTORICAL_RECORD = "historical-record";
    static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private static final Map<String, ActivityChooserModel> sDataModelRegistry;
    private static final Object sRegistryLock;
    private final List<ActivityResolveInfo> mActivities;
    private OnChooseActivityListener mActivityChoserModelPolicy;
    private ActivitySorter mActivitySorter;
    boolean mCanReadHistoricalData = true;
    final Context mContext;
    private final List<HistoricalRecord> mHistoricalRecords;
    private boolean mHistoricalRecordsChanged = true;
    final String mHistoryFileName;
    private int mHistoryMaxSize = 50;
    private final Object mInstanceLock = new Object();
    private Intent mIntent;
    private boolean mReadShareHistoryCalled = false;
    private boolean mReloadActivities = false;

    static {
        sRegistryLock = new Object();
        sDataModelRegistry = new HashMap<String, ActivityChooserModel>();
    }

    private ActivityChooserModel(Context object, String string) {
        this.mActivities = new ArrayList<ActivityResolveInfo>();
        this.mHistoricalRecords = new ArrayList<HistoricalRecord>();
        this.mActivitySorter = new DefaultSorter();
        this.mContext = object.getApplicationContext();
        if (!TextUtils.isEmpty((CharSequence)string) && !string.endsWith(HISTORY_FILE_EXTENSION)) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(HISTORY_FILE_EXTENSION);
            this.mHistoryFileName = ((StringBuilder)object).toString();
        } else {
            this.mHistoryFileName = string;
        }
    }

    private boolean addHistoricalRecord(HistoricalRecord historicalRecord) {
        boolean bl = this.mHistoricalRecords.add(historicalRecord);
        if (!bl) return bl;
        this.mHistoricalRecordsChanged = true;
        this.pruneExcessiveHistoricalRecordsIfNeeded();
        this.persistHistoricalDataIfNeeded();
        this.sortActivitiesIfNeeded();
        this.notifyChanged();
        return bl;
    }

    private void ensureConsistentState() {
        boolean bl = this.loadActivitiesIfNeeded();
        boolean bl2 = this.readHistoricalDataIfNeeded();
        this.pruneExcessiveHistoricalRecordsIfNeeded();
        if (!(bl | bl2)) return;
        this.sortActivitiesIfNeeded();
        this.notifyChanged();
    }

    public static ActivityChooserModel get(Context context, String string) {
        Object object = sRegistryLock;
        synchronized (object) {
            ActivityChooserModel activityChooserModel;
            ActivityChooserModel activityChooserModel2 = activityChooserModel = sDataModelRegistry.get(string);
            if (activityChooserModel != null) return activityChooserModel2;
            activityChooserModel2 = new ActivityChooserModel(context, string);
            sDataModelRegistry.put(string, activityChooserModel2);
            return activityChooserModel2;
        }
    }

    private boolean loadActivitiesIfNeeded() {
        boolean bl = this.mReloadActivities;
        int n = 0;
        if (!bl) return false;
        if (this.mIntent == null) return false;
        this.mReloadActivities = false;
        this.mActivities.clear();
        List list = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int n2 = list.size();
        while (n < n2) {
            ResolveInfo resolveInfo = (ResolveInfo)list.get(n);
            this.mActivities.add(new ActivityResolveInfo(resolveInfo));
            ++n;
        }
        return true;
    }

    private void persistHistoricalDataIfNeeded() {
        if (!this.mReadShareHistoryCalled) throw new IllegalStateException("No preceding call to #readHistoricalData");
        if (!this.mHistoricalRecordsChanged) {
            return;
        }
        this.mHistoricalRecordsChanged = false;
        if (TextUtils.isEmpty((CharSequence)this.mHistoryFileName)) return;
        new PersistHistoryAsyncTask(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList<HistoricalRecord>(this.mHistoricalRecords), this.mHistoryFileName});
    }

    private void pruneExcessiveHistoricalRecordsIfNeeded() {
        int n = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
        if (n <= 0) {
            return;
        }
        this.mHistoricalRecordsChanged = true;
        int n2 = 0;
        while (n2 < n) {
            HistoricalRecord historicalRecord = this.mHistoricalRecords.remove(0);
            ++n2;
        }
    }

    private boolean readHistoricalDataIfNeeded() {
        if (!this.mCanReadHistoricalData) return false;
        if (!this.mHistoricalRecordsChanged) return false;
        if (TextUtils.isEmpty((CharSequence)this.mHistoryFileName)) return false;
        this.mCanReadHistoricalData = false;
        this.mReadShareHistoryCalled = true;
        this.readHistoricalDataImpl();
        return true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    private void readHistoricalDataImpl() {
        var5_1 = this.mContext.openFileInput(this.mHistoryFileName);
        try {}
        catch (IOException var7_6) {
            var6_11 = ActivityChooserModel.LOG_TAG;
            var8_15 = new StringBuilder();
            var8_15.append("Error reading historical recrod file: ");
            var8_15.append(this.mHistoryFileName);
            Log.e((String)var6_11, (String)var8_15.toString(), (Throwable)var7_6);
            if (var5_1 == null) return;
        }
        catch (XmlPullParserException var6_14) {
            var7_5 = ActivityChooserModel.LOG_TAG;
            var8_15 = new StringBuilder();
            var8_15.append("Error reading historical recrod file: ");
            var8_15.append(this.mHistoryFileName);
            Log.e((String)var7_5, (String)var8_15.toString(), (Throwable)var6_14);
            if (var5_1 == null) return;
        }
        while (var2_7 == 3 || var2_7 == 4) lbl-1000:
        // 3 sources

        {
            while ((var2_7 = var7_5.next()) == 1) {
                if (var5_1 == null) return;
                ** GOTO lbl-1000
            }
        }
        {
            if (!"historical-record".equals(var7_5.getName())) {
                var6_11 = new XmlPullParserException("Share records file not well-formed.");
                throw var6_11;
            }
            var6_11 = var7_5.getAttributeValue(null, "activity");
            var3_10 = Long.parseLong(var7_5.getAttributeValue(null, "time"));
            var1_9 = Float.parseFloat(var7_5.getAttributeValue(null, "weight"));
            var8_15 = new HistoricalRecord((String)var6_11, var3_10, var1_9);
            var9_8.add((HistoricalRecord)var8_15);
            ** GOTO lbl-1000
        }
        finally {
            ** GOTO lbl46
        }
lbl-1000:
        // 1 sources

        {
            block17: {
                var5_1.close();
                catch (FileNotFoundException var5_2) {
                    return;
                }
lbl46:
                // 1 sources

                var7_5 = Xml.newPullParser();
                var7_5.setInput(var5_1, "UTF-8");
                var2_7 = 0;
                while (var2_7 != 1 && var2_7 != 2) {
                    var2_7 = var7_5.next();
                }
                if (!"historical-records".equals(var7_5.getName())) break block17;
                var9_8 = this.mHistoricalRecords;
                var9_8.clear();
                ** GOTO lbl-1000
            }
            var6_12 = new XmlPullParserException("Share records file does not start with historical-records tag.");
            throw var6_12;
        }
        catch (IOException var5_3) {}
    }

    private boolean sortActivitiesIfNeeded() {
        if (this.mActivitySorter == null) return false;
        if (this.mIntent == null) return false;
        if (this.mActivities.isEmpty()) return false;
        if (this.mHistoricalRecords.isEmpty()) return false;
        this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
        return true;
    }

    public Intent chooseActivity(int n) {
        Object object = this.mInstanceLock;
        synchronized (object) {
            Intent intent;
            if (this.mIntent == null) {
                return null;
            }
            this.ensureConsistentState();
            ActivityResolveInfo activityResolveInfo = this.mActivities.get(n);
            ComponentName componentName = new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name);
            activityResolveInfo = new Intent(this.mIntent);
            activityResolveInfo.setComponent(componentName);
            if (this.mActivityChoserModelPolicy != null && this.mActivityChoserModelPolicy.onChooseActivity(this, intent = new Intent((Intent)activityResolveInfo))) {
                return null;
            }
            intent = new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f);
            this.addHistoricalRecord((HistoricalRecord)intent);
            return activityResolveInfo;
        }
    }

    public ResolveInfo getActivity(int n) {
        Object object = this.mInstanceLock;
        synchronized (object) {
            this.ensureConsistentState();
            ResolveInfo resolveInfo = this.mActivities.get((int)n).resolveInfo;
            return resolveInfo;
        }
    }

    public int getActivityCount() {
        Object object = this.mInstanceLock;
        synchronized (object) {
            this.ensureConsistentState();
            int n = this.mActivities.size();
            return n;
        }
    }

    public int getActivityIndex(ResolveInfo resolveInfo) {
        Object object = this.mInstanceLock;
        synchronized (object) {
            this.ensureConsistentState();
            List<ActivityResolveInfo> list = this.mActivities;
            int n = list.size();
            int n2 = 0;
            while (n2 < n) {
                if (list.get((int)n2).resolveInfo == resolveInfo) {
                    return n2;
                }
                ++n2;
            }
            return -1;
        }
    }

    public ResolveInfo getDefaultActivity() {
        Object object = this.mInstanceLock;
        synchronized (object) {
            this.ensureConsistentState();
            if (this.mActivities.isEmpty()) return null;
            ResolveInfo resolveInfo = this.mActivities.get((int)0).resolveInfo;
            return resolveInfo;
        }
    }

    public int getHistoryMaxSize() {
        Object object = this.mInstanceLock;
        synchronized (object) {
            int n = this.mHistoryMaxSize;
            return n;
        }
    }

    public int getHistorySize() {
        Object object = this.mInstanceLock;
        synchronized (object) {
            this.ensureConsistentState();
            int n = this.mHistoricalRecords.size();
            return n;
        }
    }

    public Intent getIntent() {
        Object object = this.mInstanceLock;
        synchronized (object) {
            Intent intent = this.mIntent;
            return intent;
        }
    }

    public void setActivitySorter(ActivitySorter activitySorter) {
        Object object = this.mInstanceLock;
        synchronized (object) {
            if (this.mActivitySorter == activitySorter) {
                return;
            }
            this.mActivitySorter = activitySorter;
            if (!this.sortActivitiesIfNeeded()) return;
            this.notifyChanged();
            return;
        }
    }

    public void setDefaultActivity(int n) {
        Object object = this.mInstanceLock;
        synchronized (object) {
            this.ensureConsistentState();
            ActivityResolveInfo activityResolveInfo = this.mActivities.get(n);
            ActivityResolveInfo activityResolveInfo2 = this.mActivities.get(0);
            float f = activityResolveInfo2 != null ? activityResolveInfo2.weight - activityResolveInfo.weight + 5.0f : 1.0f;
            activityResolveInfo2 = new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name);
            activityResolveInfo = new HistoricalRecord((ComponentName)activityResolveInfo2, System.currentTimeMillis(), f);
            this.addHistoricalRecord((HistoricalRecord)activityResolveInfo);
            return;
        }
    }

    public void setHistoryMaxSize(int n) {
        Object object = this.mInstanceLock;
        synchronized (object) {
            if (this.mHistoryMaxSize == n) {
                return;
            }
            this.mHistoryMaxSize = n;
            this.pruneExcessiveHistoricalRecordsIfNeeded();
            if (!this.sortActivitiesIfNeeded()) return;
            this.notifyChanged();
            return;
        }
    }

    public void setIntent(Intent intent) {
        Object object = this.mInstanceLock;
        synchronized (object) {
            if (this.mIntent == intent) {
                return;
            }
            this.mIntent = intent;
            this.mReloadActivities = true;
            this.ensureConsistentState();
            return;
        }
    }

    public void setOnChooseActivityListener(OnChooseActivityListener onChooseActivityListener) {
        Object object = this.mInstanceLock;
        synchronized (object) {
            this.mActivityChoserModelPolicy = onChooseActivityListener;
            return;
        }
    }
}
