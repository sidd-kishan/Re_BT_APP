/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.MessageThreadUtil;

static class MessageThreadUtil.MessageQueue {
    private MessageThreadUtil.SyncQueueItem mRoot;

    MessageThreadUtil.MessageQueue() {
    }

    /*
     * Enabled unnecessary exception pruning
     */
    MessageThreadUtil.SyncQueueItem next() {
        synchronized (this) {
            MessageThreadUtil.SyncQueueItem syncQueueItem = this.mRoot;
            if (syncQueueItem == null) {
                return null;
            }
            syncQueueItem = this.mRoot;
            this.mRoot = this.mRoot.next;
            return syncQueueItem;
        }
    }

    void removeMessages(int n) {
        synchronized (this) {
            try {
                MessageThreadUtil.SyncQueueItem syncQueueItem;
                while (this.mRoot != null && this.mRoot.what == n) {
                    syncQueueItem = this.mRoot;
                    this.mRoot = this.mRoot.next;
                    syncQueueItem.recycle();
                }
                if (this.mRoot == null) return;
                MessageThreadUtil.SyncQueueItem syncQueueItem2 = this.mRoot;
                syncQueueItem = syncQueueItem2.next;
                while (syncQueueItem != null) {
                    MessageThreadUtil.SyncQueueItem syncQueueItem3 = syncQueueItem.next;
                    if (syncQueueItem.what == n) {
                        syncQueueItem2.next = syncQueueItem3;
                        syncQueueItem.recycle();
                    } else {
                        syncQueueItem2 = syncQueueItem;
                    }
                    syncQueueItem = syncQueueItem3;
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    void sendMessage(MessageThreadUtil.SyncQueueItem syncQueueItem) {
        synchronized (this) {
            try {
                if (this.mRoot == null) {
                    this.mRoot = syncQueueItem;
                    return;
                }
                MessageThreadUtil.SyncQueueItem syncQueueItem2 = this.mRoot;
                while (true) {
                    if (syncQueueItem2.next == null) {
                        syncQueueItem2.next = syncQueueItem;
                        return;
                    }
                    syncQueueItem2 = syncQueueItem2.next;
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    void sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem syncQueueItem) {
        synchronized (this) {
            syncQueueItem.next = this.mRoot;
            this.mRoot = syncQueueItem;
            return;
        }
    }
}
