/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.async.AsyncOperation$OperationType
 */
package org.greenrobot.greendao.async;

import org.greenrobot.greendao.async.AsyncOperation;

static class AsyncOperationExecutor.1 {
    static final int[] $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[AsyncOperation.OperationType.values().length];
        $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType = nArray;
        try {
            nArray[AsyncOperation.OperationType.Delete.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.DeleteInTxIterable.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.DeleteInTxArray.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.Insert.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.InsertInTxIterable.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.InsertInTxArray.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.InsertOrReplace.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.InsertOrReplaceInTxIterable.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.InsertOrReplaceInTxArray.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.Update.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.UpdateInTxIterable.ordinal()] = 11;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.UpdateInTxArray.ordinal()] = 12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.TransactionRunnable.ordinal()] = 13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.TransactionCallable.ordinal()] = 14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.QueryList.ordinal()] = 15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.QueryUnique.ordinal()] = 16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.DeleteByKey.ordinal()] = 17;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.DeleteAll.ordinal()] = 18;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.Load.ordinal()] = 19;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.LoadAll.ordinal()] = 20;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.Count.ordinal()] = 21;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AsyncOperationExecutor.1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.Refresh.ordinal()] = 22;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
