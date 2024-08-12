/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.IInterface
 *  android.os.RemoteException
 *  android.support.v4.media.MediaDescriptionCompat
 *  android.support.v4.media.MediaMetadataCompat
 *  android.support.v4.media.RatingCompat
 *  android.support.v4.media.session.IMediaControllerCallback
 *  android.support.v4.media.session.MediaSessionCompat$QueueItem
 *  android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper
 *  android.support.v4.media.session.ParcelableVolumeInfo
 *  android.support.v4.media.session.PlaybackStateCompat
 *  android.view.KeyEvent
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import java.util.List;

public interface IMediaSession
extends IInterface {
    public void addQueueItem(MediaDescriptionCompat var1) throws RemoteException;

    public void addQueueItemAt(MediaDescriptionCompat var1, int var2) throws RemoteException;

    public void adjustVolume(int var1, int var2, String var3) throws RemoteException;

    public void fastForward() throws RemoteException;

    public Bundle getExtras() throws RemoteException;

    public long getFlags() throws RemoteException;

    public PendingIntent getLaunchPendingIntent() throws RemoteException;

    public MediaMetadataCompat getMetadata() throws RemoteException;

    public String getPackageName() throws RemoteException;

    public PlaybackStateCompat getPlaybackState() throws RemoteException;

    public List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException;

    public CharSequence getQueueTitle() throws RemoteException;

    public int getRatingType() throws RemoteException;

    public int getRepeatMode() throws RemoteException;

    public int getShuffleMode() throws RemoteException;

    public String getTag() throws RemoteException;

    public ParcelableVolumeInfo getVolumeAttributes() throws RemoteException;

    public boolean isCaptioningEnabled() throws RemoteException;

    public boolean isShuffleModeEnabledRemoved() throws RemoteException;

    public boolean isTransportControlEnabled() throws RemoteException;

    public void next() throws RemoteException;

    public void pause() throws RemoteException;

    public void play() throws RemoteException;

    public void playFromMediaId(String var1, Bundle var2) throws RemoteException;

    public void playFromSearch(String var1, Bundle var2) throws RemoteException;

    public void playFromUri(Uri var1, Bundle var2) throws RemoteException;

    public void prepare() throws RemoteException;

    public void prepareFromMediaId(String var1, Bundle var2) throws RemoteException;

    public void prepareFromSearch(String var1, Bundle var2) throws RemoteException;

    public void prepareFromUri(Uri var1, Bundle var2) throws RemoteException;

    public void previous() throws RemoteException;

    public void rate(RatingCompat var1) throws RemoteException;

    public void rateWithExtras(RatingCompat var1, Bundle var2) throws RemoteException;

    public void registerCallbackListener(IMediaControllerCallback var1) throws RemoteException;

    public void removeQueueItem(MediaDescriptionCompat var1) throws RemoteException;

    public void removeQueueItemAt(int var1) throws RemoteException;

    public void rewind() throws RemoteException;

    public void seekTo(long var1) throws RemoteException;

    public void sendCommand(String var1, Bundle var2, MediaSessionCompat.ResultReceiverWrapper var3) throws RemoteException;

    public void sendCustomAction(String var1, Bundle var2) throws RemoteException;

    public boolean sendMediaButton(KeyEvent var1) throws RemoteException;

    public void setCaptioningEnabled(boolean var1) throws RemoteException;

    public void setRepeatMode(int var1) throws RemoteException;

    public void setShuffleMode(int var1) throws RemoteException;

    public void setShuffleModeEnabledRemoved(boolean var1) throws RemoteException;

    public void setVolumeTo(int var1, int var2, String var3) throws RemoteException;

    public void skipToQueueItem(long var1) throws RemoteException;

    public void stop() throws RemoteException;

    public void unregisterCallbackListener(IMediaControllerCallback var1) throws RemoteException;
}
