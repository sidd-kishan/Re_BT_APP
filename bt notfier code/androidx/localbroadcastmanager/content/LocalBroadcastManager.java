/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.net.Uri
 *  android.os.Handler
 *  android.util.Log
 *  androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord
 *  androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord
 */
package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock;
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions;
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList<BroadcastRecord> mPendingBroadcasts;
    private final HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> mReceivers = new HashMap();

    static {
        mLock = new Object();
    }

    private LocalBroadcastManager(Context context) {
        this.mActions = new HashMap();
        this.mPendingBroadcasts = new ArrayList();
        this.mAppContext = context;
        this.mHandler = new /* Unavailable Anonymous Inner Class!! */;
    }

    public static LocalBroadcastManager getInstance(Context object) {
        Object object2 = mLock;
        synchronized (object2) {
            if (mInstance == null) {
                LocalBroadcastManager localBroadcastManager;
                mInstance = localBroadcastManager = new LocalBroadcastManager(object.getApplicationContext());
            }
            object = mInstance;
            return object;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    void executePendingBroadcasts() {
        block4: while (true) {
            int n;
            BroadcastRecord[] broadcastRecordArray;
            int n2;
            ReceiverRecord receiverRecord = this.mReceivers;
            synchronized (receiverRecord) {
                n2 = this.mPendingBroadcasts.size();
                if (n2 <= 0) {
                    return;
                }
                broadcastRecordArray = new BroadcastRecord[n2];
                this.mPendingBroadcasts.toArray(broadcastRecordArray);
                this.mPendingBroadcasts.clear();
                // MONITOREXIT @DISABLED, blocks:[0, 2, 4] lbl13 : MonitorExitStatement: MONITOREXIT : var6_7
                n = 0;
                {
                    catch (Throwable throwable) {}
                    {
                        throw throwable;
                    }
                }
            }
            while (true) {
                if (n >= n2) continue block4;
                BroadcastRecord broadcastRecord = broadcastRecordArray[n];
                int n3 = broadcastRecord.receivers.size();
                for (int i = 0; i < n3; ++i) {
                    receiverRecord = (ReceiverRecord)broadcastRecord.receivers.get(i);
                    if (receiverRecord.dead) continue;
                    receiverRecord.receiver.onReceive(this.mAppContext, broadcastRecord.intent);
                }
                ++n;
            }
            break;
        }
    }

    public void registerReceiver(BroadcastReceiver object, IntentFilter intentFilter) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> hashMap = this.mReceivers;
        synchronized (hashMap) {
            ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, object);
            Object object2 = this.mReceivers.get(object);
            ArrayList<ReceiverRecord> arrayList = object2;
            if (object2 == null) {
                arrayList = new ArrayList<ReceiverRecord>(1);
                this.mReceivers.put((BroadcastReceiver)object, arrayList);
            }
            arrayList.add(receiverRecord);
            int n = 0;
            while (n < intentFilter.countActions()) {
                object2 = intentFilter.getAction(n);
                arrayList = this.mActions.get(object2);
                object = arrayList;
                if (arrayList == null) {
                    object = new ArrayList(1);
                    this.mActions.put((String)object2, (ArrayList<ReceiverRecord>)object);
                }
                object.add(receiverRecord);
                ++n;
            }
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public boolean sendBroadcast(Intent intent) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> hashMap = this.mReceivers;
        synchronized (hashMap) {
            ArrayList<ReceiverRecord> arrayList;
            Object object;
            String string = intent.getAction();
            String string2 = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            Uri uri = intent.getData();
            String string3 = intent.getScheme();
            Set set = intent.getCategories();
            int n = (intent.getFlags() & 8) != 0 ? 1 : 0;
            if (n != 0) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Resolving type ");
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(" scheme ");
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append(" of intent ");
                ((StringBuilder)object).append(intent);
                Log.v((String)TAG, (String)((StringBuilder)object).toString());
            }
            if ((arrayList = this.mActions.get(intent.getAction())) == null) return false;
            if (n != 0) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Action list: ");
                ((StringBuilder)object).append(arrayList);
                Log.v((String)TAG, (String)((StringBuilder)object).toString());
            }
            ArrayList<Serializable> arrayList2 = null;
            for (int i = 0; i < arrayList.size(); ++i) {
                StringBuilder stringBuilder;
                object = arrayList.get(i);
                if (n != 0) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Matching against filter ");
                    stringBuilder.append(((ReceiverRecord)object).filter);
                    Log.v((String)TAG, (String)stringBuilder.toString());
                }
                if (((ReceiverRecord)object).broadcasting) {
                    if (n == 0) continue;
                    Log.v((String)TAG, (String)"  Filter's target already added");
                    continue;
                }
                stringBuilder = ((ReceiverRecord)object).filter;
                int n2 = stringBuilder.match(string, string2, string3, uri, set, TAG);
                if (n2 >= 0) {
                    if (n != 0) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("  Filter matched!  match=0x");
                        stringBuilder.append(Integer.toHexString(n2));
                        Log.v((String)TAG, (String)stringBuilder.toString());
                    }
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<Serializable>();
                    }
                    arrayList2.add((Serializable)object);
                    ((ReceiverRecord)object).broadcasting = true;
                    continue;
                }
                if (n == 0) continue;
                object = n2 != -4 ? (n2 != -3 ? (n2 != -2 ? (n2 != -1 ? "unknown reason" : "type") : "data") : "action") : "category";
                stringBuilder = new StringBuilder();
                stringBuilder.append("  Filter did not match: ");
                stringBuilder.append((String)object);
                Log.v((String)TAG, (String)stringBuilder.toString());
            }
            if (arrayList2 == null) return false;
            {
                for (n = 0; n < arrayList2.size(); ++n) {
                    ((ReceiverRecord)arrayList2.get((int)n)).broadcasting = false;
                }
            }
            object = this.mPendingBroadcasts;
            string2 = new BroadcastRecord(intent, (ArrayList)arrayList2);
            ((ArrayList)object).add(string2);
            if (this.mHandler.hasMessages(1)) return true;
            this.mHandler.sendEmptyMessage(1);
            return true;
        }
    }

    public void sendBroadcastSync(Intent intent) {
        if (!this.sendBroadcast(intent)) return;
        this.executePendingBroadcasts();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> hashMap = this.mReceivers;
        synchronized (hashMap) {
            ArrayList<ReceiverRecord> arrayList = this.mReceivers.remove(broadcastReceiver);
            if (arrayList == null) {
                return;
            }
            int n = arrayList.size() - 1;
            while (n >= 0) {
                ReceiverRecord receiverRecord = arrayList.get(n);
                receiverRecord.dead = true;
                for (int i = 0; i < receiverRecord.filter.countActions(); ++i) {
                    String string = receiverRecord.filter.getAction(i);
                    ArrayList<ReceiverRecord> arrayList2 = this.mActions.get(string);
                    if (arrayList2 == null) continue;
                    for (int j = arrayList2.size() - 1; j >= 0; --j) {
                        ReceiverRecord receiverRecord2 = arrayList2.get(j);
                        if (receiverRecord2.receiver != broadcastReceiver) continue;
                        receiverRecord2.dead = true;
                        arrayList2.remove(j);
                    }
                    if (arrayList2.size() > 0) continue;
                    this.mActions.remove(string);
                }
                --n;
            }
            return;
        }
    }
}
