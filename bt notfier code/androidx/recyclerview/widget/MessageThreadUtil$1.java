/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  androidx.recyclerview.widget.MessageThreadUtil
 *  androidx.recyclerview.widget.MessageThreadUtil$MessageQueue
 *  androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem
 *  androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
 *  androidx.recyclerview.widget.TileList$Tile
 */
package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.MessageThreadUtil;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

/*
 * Exception performing whole class analysis ignored.
 */
class MessageThreadUtil.1
implements ThreadUtil.MainThreadCallback<T> {
    static final int ADD_TILE = 2;
    static final int REMOVE_TILE = 3;
    static final int UPDATE_ITEM_COUNT = 1;
    private final Handler mMainThreadHandler;
    private Runnable mMainThreadRunnable;
    final MessageThreadUtil.MessageQueue mQueue;
    final MessageThreadUtil this$0;
    final ThreadUtil.MainThreadCallback val$callback;

    MessageThreadUtil.1(MessageThreadUtil messageThreadUtil, ThreadUtil.MainThreadCallback mainThreadCallback) {
        this.this$0 = messageThreadUtil;
        this.val$callback = mainThreadCallback;
        this.mQueue = new MessageThreadUtil.MessageQueue();
        this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        this.mMainThreadRunnable = new /* Unavailable Anonymous Inner Class!! */;
    }

    private void sendMessage(MessageThreadUtil.SyncQueueItem syncQueueItem) {
        this.mQueue.sendMessage(syncQueueItem);
        this.mMainThreadHandler.post(this.mMainThreadRunnable);
    }

    public void addTile(int n, TileList.Tile<T> tile) {
        this.sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage((int)2, (int)n, tile));
    }

    public void removeTile(int n, int n2) {
        this.sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage((int)3, (int)n, (int)n2));
    }

    public void updateItemCount(int n, int n2) {
        this.sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage((int)1, (int)n, (int)n2));
    }
}
