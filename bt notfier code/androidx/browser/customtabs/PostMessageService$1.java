/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.support.customtabs.ICustomTabsCallback
 *  android.support.customtabs.IPostMessageService$Stub
 *  androidx.browser.customtabs.PostMessageService
 */
package androidx.browser.customtabs;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.IPostMessageService;
import androidx.browser.customtabs.PostMessageService;

class PostMessageService.1
extends IPostMessageService.Stub {
    final PostMessageService this$0;

    PostMessageService.1(PostMessageService postMessageService) {
        this.this$0 = postMessageService;
    }

    public void onMessageChannelReady(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) throws RemoteException {
        iCustomTabsCallback.onMessageChannelReady(bundle);
    }

    public void onPostMessage(ICustomTabsCallback iCustomTabsCallback, String string, Bundle bundle) throws RemoteException {
        iCustomTabsCallback.onPostMessage(string, bundle);
    }
}
