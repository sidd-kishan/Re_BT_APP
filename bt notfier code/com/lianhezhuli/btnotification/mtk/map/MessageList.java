/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.mtk.map.MessageListItem
 */
package com.lianhezhuli.btnotification.mtk.map;

import com.lianhezhuli.btnotification.mtk.map.MessageListItem;
import java.util.ArrayList;

public class MessageList {
    private ArrayList<MessageListItem> mMessageItems;
    private boolean mNewMessage;
    private int mSize;

    public MessageList() {
        this.reset();
    }

    public boolean addMessageItem(MessageListItem messageListItem) {
        synchronized (this) {
            if (messageListItem == null) return true;
            this.mMessageItems.add(messageListItem);
            return true;
        }
    }

    public boolean addSize(int n) {
        synchronized (this) {
            this.mSize += n;
            return true;
        }
    }

    public MessageListItem[] generateMessageItemArray() {
        synchronized (this) {
            MessageListItem[] messageListItemArray = this.mMessageItems.toArray(new MessageListItem[this.mMessageItems.size()]);
            return messageListItemArray;
        }
    }

    public int getCurrentSize() {
        return this.mSize;
    }

    void reset() {
        synchronized (this) {
            if (this.mMessageItems == null) {
                ArrayList arrayList = new ArrayList();
                this.mMessageItems = arrayList;
            } else {
                this.mMessageItems.clear();
            }
            this.mSize = 0;
            this.mNewMessage = false;
            return;
        }
    }

    public boolean setNewMessage() {
        synchronized (this) {
            if (this.mNewMessage) return true;
            this.mNewMessage = true;
            return true;
        }
    }
}
