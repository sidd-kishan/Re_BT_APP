/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  androidx.work.BackoffPolicy
 *  androidx.work.ContentUriTriggers
 *  androidx.work.NetworkType
 *  androidx.work.OutOfQuotaPolicy
 *  androidx.work.WorkInfo$State
 *  androidx.work.impl.model.WorkTypeConverters$1
 */
package androidx.work.impl.model;

import android.net.Uri;
import android.os.Build;
import androidx.work.BackoffPolicy;
import androidx.work.ContentUriTriggers;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkTypeConverters;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WorkTypeConverters {
    private WorkTypeConverters() {
    }

    public static int backoffPolicyToInt(BackoffPolicy backoffPolicy) {
        int n = 1.$SwitchMap$androidx$work$BackoffPolicy[backoffPolicy.ordinal()];
        if (n == 1) return 0;
        if (n == 2) {
            return 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not convert ");
        stringBuilder.append(backoffPolicy);
        stringBuilder.append(" to int");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public static ContentUriTriggers byteArrayToContentUriTriggers(byte[] object) {
        void var2_11;
        ByteArrayInputStream byteArrayInputStream;
        block22: {
            ContentUriTriggers contentUriTriggers;
            block23: {
                void var3_15;
                ObjectInputStream objectInputStream;
                block21: {
                    contentUriTriggers = new ContentUriTriggers();
                    if (object == null) {
                        return contentUriTriggers;
                    }
                    byteArrayInputStream = new ByteArrayInputStream((byte[])object);
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    object = objectInputStream;
                    for (int i = objectInputStream.readInt(); i > 0; --i) {
                        object = objectInputStream;
                        contentUriTriggers.add(Uri.parse((String)objectInputStream.readUTF()), objectInputStream.readBoolean());
                    }
                    try {
                        objectInputStream.close();
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                    byteArrayInputStream.close();
                    return contentUriTriggers;
                    catch (IOException iOException) {
                        break block21;
                    }
                    catch (Throwable throwable) {
                        object = null;
                        break block22;
                    }
                    catch (IOException iOException) {
                        objectInputStream = null;
                    }
                }
                object = objectInputStream;
                var3_15.printStackTrace();
                if (objectInputStream == null) break block23;
                try {
                    objectInputStream.close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            try {
                byteArrayInputStream.close();
                return contentUriTriggers;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            return contentUriTriggers;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (object != null) {
            try {
                ((ObjectInputStream)object).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        try {
            byteArrayInputStream.close();
            throw var2_11;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            throw var2_11;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public static byte[] contentUriTriggersToByteArray(ContentUriTriggers object) {
        void var0_6;
        Object object2222222;
        ByteArrayOutputStream byteArrayOutputStream;
        block21: {
            block23: {
                Object object3;
                block22: {
                    int n = object.size();
                    Object var4_8 = null;
                    Object object4 = null;
                    if (n == 0) {
                        return null;
                    }
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    object2222222 = object4;
                    object2222222 = object4;
                    object3 = new ObjectOutputStream(byteArrayOutputStream);
                    ((ObjectOutputStream)object3).writeInt(object.size());
                    for (Object object2222222 : object.getTriggers()) {
                        ((ObjectOutputStream)object3).writeUTF(object2222222.getUri().toString());
                        ((ObjectOutputStream)object3).writeBoolean(object2222222.shouldTriggerForDescendants());
                    }
                    try {
                        ((ObjectOutputStream)object3).close();
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                    catch (Throwable throwable) {
                        object2222222 = object3;
                        break block21;
                    }
                    catch (IOException iOException) {
                        object = object3;
                        object3 = iOException;
                        break block22;
                    }
                    catch (Throwable throwable) {
                        break block21;
                    }
                    catch (IOException iOException) {
                        object = var4_8;
                    }
                }
                object2222222 = object;
                {
                    ((Throwable)object3).printStackTrace();
                    if (object == null) break block23;
                }
                try {
                    ((ObjectOutputStream)object).close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            try {
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }
        if (object2222222 != null) {
            try {
                ((ObjectOutputStream)object2222222).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        try {
            byteArrayOutputStream.close();
            throw var0_6;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            throw var0_6;
        }
    }

    public static BackoffPolicy intToBackoffPolicy(int n) {
        if (n == 0) return BackoffPolicy.EXPONENTIAL;
        if (n == 1) {
            return BackoffPolicy.LINEAR;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not convert ");
        stringBuilder.append(n);
        stringBuilder.append(" to BackoffPolicy");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static NetworkType intToNetworkType(int n) {
        if (n == 0) return NetworkType.NOT_REQUIRED;
        if (n == 1) return NetworkType.CONNECTED;
        if (n == 2) return NetworkType.UNMETERED;
        if (n == 3) return NetworkType.NOT_ROAMING;
        if (n == 4) return NetworkType.METERED;
        if (Build.VERSION.SDK_INT >= 30 && n == 5) {
            return NetworkType.TEMPORARILY_UNMETERED;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not convert ");
        stringBuilder.append(n);
        stringBuilder.append(" to NetworkType");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static OutOfQuotaPolicy intToOutOfQuotaPolicy(int n) {
        if (n == 0) return OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        if (n == 1) {
            return OutOfQuotaPolicy.DROP_WORK_REQUEST;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not convert ");
        stringBuilder.append(n);
        stringBuilder.append(" to OutOfQuotaPolicy");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static WorkInfo.State intToState(int n) {
        if (n == 0) return WorkInfo.State.ENQUEUED;
        if (n == 1) return WorkInfo.State.RUNNING;
        if (n == 2) return WorkInfo.State.SUCCEEDED;
        if (n == 3) return WorkInfo.State.FAILED;
        if (n == 4) return WorkInfo.State.BLOCKED;
        if (n == 5) {
            return WorkInfo.State.CANCELLED;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not convert ");
        stringBuilder.append(n);
        stringBuilder.append(" to State");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static int networkTypeToInt(NetworkType networkType) {
        int n = 1.$SwitchMap$androidx$work$NetworkType[networkType.ordinal()];
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 3;
        if (n == 5) return 4;
        if (Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
            return 5;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not convert ");
        stringBuilder.append(networkType);
        stringBuilder.append(" to int");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static int outOfQuotaPolicyToInt(OutOfQuotaPolicy outOfQuotaPolicy) {
        int n = 1.$SwitchMap$androidx$work$OutOfQuotaPolicy[outOfQuotaPolicy.ordinal()];
        if (n == 1) return 0;
        if (n == 2) {
            return 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not convert ");
        stringBuilder.append(outOfQuotaPolicy);
        stringBuilder.append(" to int");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static int stateToInt(WorkInfo.State state) {
        switch (1.$SwitchMap$androidx$work$WorkInfo$State[state.ordinal()]) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not convert ");
                stringBuilder.append(state);
                stringBuilder.append(" to int");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 6: {
                return 5;
            }
            case 5: {
                return 4;
            }
            case 4: {
                return 3;
            }
            case 3: {
                return 2;
            }
            case 2: {
                return 1;
            }
            case 1: 
        }
        return 0;
    }
}
