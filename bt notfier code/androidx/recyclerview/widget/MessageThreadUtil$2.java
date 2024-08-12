/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  androidx.recyclerview.widget.MessageThreadUtil
 *  androidx.recyclerview.widget.MessageThreadUtil$MessageQueue
 *  androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem
 *  androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
 *  androidx.recyclerview.widget.TileList$Tile
 */
package androidx.recyclerview.widget;

import android.os.AsyncTask;
import androidx.recyclerview.widget.MessageThreadUtil;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/*
 * Exception performing whole class analysis ignored.
 */
class MessageThreadUtil.2
implements ThreadUtil.BackgroundCallback<T> {
    static final int LOAD_TILE = 3;
    static final int RECYCLE_TILE = 4;
    static final int REFRESH = 1;
    static final int UPDATE_RANGE = 2;
    private Runnable mBackgroundRunnable;
    AtomicBoolean mBackgroundRunning;
    private final Executor mExecutor;
    final MessageThreadUtil.MessageQueue mQueue;
    final MessageThreadUtil this$0;
    final ThreadUtil.BackgroundCallback val$callback;

    MessageThreadUtil.2(MessageThreadUtil messageThreadUtil, ThreadUtil.BackgroundCallback backgroundCallback) {
        this.this$0 = messageThreadUtil;
        this.val$callback = backgroundCallback;
        this.mQueue = new MessageThreadUtil.MessageQueue();
        this.mExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
        this.mBackgroundRunning = new AtomicBoolean(false);
        this.mBackgroundRunnable = new /* Unavailable Anonymous Inner Class!! */;
    }

    private void maybeExecuteBackgroundRunnable() {
        if (!this.mBackgroundRunning.compareAndSet(false, true)) return;
        this.mExecutor.execute(this.mBackgroundRunnable);
    }

    private void sendMessage(MessageThreadUtil.SyncQueueItem syncQueueItem) {
        this.mQueue.sendMessage(syncQueueItem);
        this.maybeExecuteBackgroundRunnable();
    }

    private void sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem syncQueueItem) {
        this.mQueue.sendMessageAtFrontOfQueue(syncQueueItem);
        this.maybeExecuteBackgroundRunnable();
    }

    public void loadTile(int n, int n2) {
        this.sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage((int)3, (int)n, (int)n2));
    }

    public void recycleTile(TileList.Tile<T> tile) {
        this.sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage((int)4, (int)0, tile));
    }

    public void refresh(int n) {
        this.sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem.obtainMessage((int)1, (int)n, null));
    }

    public void updateRange(int n, int n2, int n3, int n4, int n5) {
        this.sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem.obtainMessage((int)2, (int)n, (int)n2, (int)n3, (int)n4, (int)n5, null));
    }
}
