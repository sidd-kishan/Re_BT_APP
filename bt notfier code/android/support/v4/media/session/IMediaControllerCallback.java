/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IInterface
 *  android.os.RemoteException
 *  android.support.v4.media.MediaMetadataCompat
 *  android.support.v4.media.session.MediaSessionCompat$QueueItem
 *  android.support.v4.media.session.ParcelableVolumeInfo
 *  android.support.v4.media.session.PlaybackStateCompat
 */
package android.support.v4.media.session;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import java.util.List;

public interface IMediaControllerCallback
extends IInterface {
    public void onCaptioningEnabledChanged(boolean var1) throws RemoteException;

    public void onEvent(String var1, Bundle var2) throws RemoteException;

    public void onExtrasChanged(Bundle var1) throws RemoteException;

    public void onMetadataChanged(MediaMetadataCompat var1) throws RemoteException;

    public void onPlaybackStateChanged(PlaybackStateCompat var1) throws RemoteException;

    public void onQueueChanged(List<MediaSessionCompat.QueueItem> var1) throws RemoteException;

    public void onQueueTitleChanged(CharSequence var1) throws RemoteException;

    public void onRepeatModeChanged(int var1) throws RemoteException;

    public void onSessionDestroyed() throws RemoteException;

    public void onSessionReady() throws RemoteException;

    public void onShuffleModeChanged(int var1) throws RemoteException;

    public void onShuffleModeChangedRemoved(boolean var1) throws RemoteException;

    public void onVolumeInfoChanged(ParcelableVolumeInfo var1) throws RemoteException;
}
