/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.media.AudioRecord
 *  android.media.CamcorderProfile
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaFormat
 *  android.media.MediaMuxer
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.ParcelFileDescriptor
 *  android.util.Size
 *  android.view.Surface
 *  androidx.camera.core.Logger
 *  androidx.camera.core.UseCase
 *  androidx.camera.core.VideoCapture$Builder
 *  androidx.camera.core.VideoCapture$Defaults
 *  androidx.camera.core.VideoCapture$Metadata
 *  androidx.camera.core.VideoCapture$OnVideoSavedCallback
 *  androidx.camera.core.VideoCapture$OutputFileOptions
 *  androidx.camera.core.VideoCapture$OutputFileResults
 *  androidx.camera.core.VideoCapture$VideoSavedListenerWrapper
 *  androidx.camera.core._$$Lambda$VideoCapture$5Thc_jl34dkc10u5dmeCfXccSQI
 *  androidx.camera.core._$$Lambda$VideoCapture$CtkdvPm9R_T2rWkFfmPoBN8pCVg
 *  androidx.camera.core._$$Lambda$VideoCapture$ER74H3wEjHOpv1ztEcCPnPwOyj8
 *  androidx.camera.core._$$Lambda$VideoCapture$MChuGRw3jKhH34Mz50N4JOp7jiM
 *  androidx.camera.core._$$Lambda$VideoCapture$Tho64enhuCvARi_3Xm5_vjHJk1k
 *  androidx.camera.core._$$Lambda$VideoCapture$lA6YXAVaPCGqufdCHl3fDcETyWQ
 *  androidx.camera.core._$$Lambda$VideoCapture$oP3cFjboQurpR7UylbkByT1ylCA
 *  androidx.camera.core._$$Lambda$VideoCapture$sWuEFWqiGVmDEh_KqMmeL3T_hpU
 *  androidx.camera.core._$$Lambda$bKhot3B1n1f2PgvvZExesMq2yMg
 *  androidx.camera.core.impl.CameraInternal
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.Config$_CC
 *  androidx.camera.core.impl.DeferrableSurface
 *  androidx.camera.core.impl.ImmediateSurface
 *  androidx.camera.core.impl.SessionConfig$Builder
 *  androidx.camera.core.impl.SessionConfig$ErrorListener
 *  androidx.camera.core.impl.UseCaseConfig
 *  androidx.camera.core.impl.UseCaseConfig$Builder
 *  androidx.camera.core.impl.UseCaseConfigFactory
 *  androidx.camera.core.impl.UseCaseConfigFactory$CaptureType
 *  androidx.camera.core.impl.VideoCaptureConfig
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.internal.utils.VideoUtil
 *  androidx.concurrent.futures.CallbackToFutureAdapter
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.media.AudioRecord;
import android.media.CamcorderProfile;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.VideoCapture;
import androidx.camera.core._$;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.VideoCaptureConfig;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.utils.VideoUtil;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/*
 * Exception performing whole class analysis ignored.
 */
public final class VideoCapture
extends UseCase {
    private static final String AUDIO_MIME_TYPE = "audio/mp4a-latm";
    private static final int[] CamcorderQuality;
    public static final Defaults DEFAULT_CONFIG;
    private static final int DEQUE_TIMEOUT_USEC = 10000;
    public static final int ERROR_ENCODER = 1;
    public static final int ERROR_FILE_IO = 4;
    public static final int ERROR_INVALID_CAMERA = 5;
    public static final int ERROR_MUXER = 2;
    public static final int ERROR_RECORDING_IN_PROGRESS = 3;
    public static final int ERROR_UNKNOWN = 0;
    private static final String TAG = "VideoCapture";
    private static final String VIDEO_MIME_TYPE = "video/avc";
    private static final short[] sAudioEncoding;
    private int mAudioBitRate;
    private final MediaCodec.BufferInfo mAudioBufferInfo;
    private int mAudioBufferSize;
    private int mAudioChannelCount;
    private MediaCodec mAudioEncoder;
    private Handler mAudioHandler;
    private HandlerThread mAudioHandlerThread;
    private AudioRecord mAudioRecorder;
    private int mAudioSampleRate;
    private int mAudioTrackIndex;
    Surface mCameraSurface;
    private DeferrableSurface mDeferrableSurface;
    private final AtomicBoolean mEndOfAudioStreamSignal;
    private final AtomicBoolean mEndOfAudioVideoSignal;
    private final AtomicBoolean mEndOfVideoStreamSignal;
    private final AtomicBoolean mIsFirstAudioSampleWrite;
    private final AtomicBoolean mIsFirstVideoSampleWrite;
    private boolean mIsRecording = false;
    private MediaMuxer mMuxer;
    private final Object mMuxerLock;
    private boolean mMuxerStarted = false;
    private ParcelFileDescriptor mParcelFileDescriptor;
    private ListenableFuture<Void> mRecordingFuture = null;
    Uri mSavedVideoUri;
    private final MediaCodec.BufferInfo mVideoBufferInfo = new MediaCodec.BufferInfo();
    MediaCodec mVideoEncoder;
    private Handler mVideoHandler;
    private HandlerThread mVideoHandlerThread;
    private int mVideoTrackIndex;

    static {
        DEFAULT_CONFIG = new Defaults();
        CamcorderQuality = new int[]{8, 6, 5, 4};
        sAudioEncoding = new short[]{2, 3, 4};
    }

    VideoCapture(VideoCaptureConfig videoCaptureConfig) {
        super((UseCaseConfig)videoCaptureConfig);
        this.mMuxerLock = new Object();
        this.mEndOfVideoStreamSignal = new AtomicBoolean(true);
        this.mEndOfAudioStreamSignal = new AtomicBoolean(true);
        this.mEndOfAudioVideoSignal = new AtomicBoolean(true);
        this.mAudioBufferInfo = new MediaCodec.BufferInfo();
        this.mIsFirstVideoSampleWrite = new AtomicBoolean(false);
        this.mIsFirstAudioSampleWrite = new AtomicBoolean(false);
    }

    private AudioRecord autoConfigAudioRecordSource(VideoCaptureConfig videoCaptureConfig) {
        short[] sArray = sAudioEncoding;
        int n = sArray.length;
        int n2 = 0;
        while (n2 < n) {
            short s = sArray[n2];
            int n3 = this.mAudioChannelCount == 1 ? 16 : 12;
            int n4 = videoCaptureConfig.getAudioRecordSource();
            try {
                AudioRecord audioRecord;
                int n5;
                int n6 = n5 = AudioRecord.getMinBufferSize((int)this.mAudioSampleRate, (int)n3, (int)s);
                if (n5 <= 0) {
                    n6 = videoCaptureConfig.getAudioMinBufferSize();
                }
                if ((audioRecord = new AudioRecord(n4, this.mAudioSampleRate, n3, (int)s, n6 * 2)).getState() == 1) {
                    this.mAudioBufferSize = n6;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("source: ");
                    stringBuilder.append(n4);
                    stringBuilder.append(" audioSampleRate: ");
                    stringBuilder.append(this.mAudioSampleRate);
                    stringBuilder.append(" channelConfig: ");
                    stringBuilder.append(n3);
                    stringBuilder.append(" audioFormat: ");
                    stringBuilder.append(s);
                    stringBuilder.append(" bufferSize: ");
                    stringBuilder.append(n6);
                    Logger.i((String)"VideoCapture", (String)stringBuilder.toString());
                    return audioRecord;
                }
            }
            catch (Exception exception) {
                Logger.e((String)"VideoCapture", (String)"Exception, keep trying.", (Throwable)exception);
            }
            ++n2;
        }
        return null;
    }

    private MediaFormat createAudioMediaFormat() {
        MediaFormat mediaFormat = MediaFormat.createAudioFormat((String)"audio/mp4a-latm", (int)this.mAudioSampleRate, (int)this.mAudioChannelCount);
        mediaFormat.setInteger("aac-profile", 2);
        mediaFormat.setInteger("bitrate", this.mAudioBitRate);
        return mediaFormat;
    }

    private static MediaFormat createMediaFormat(VideoCaptureConfig videoCaptureConfig, Size size) {
        size = MediaFormat.createVideoFormat((String)"video/avc", (int)size.getWidth(), (int)size.getHeight());
        size.setInteger("color-format", 2130708361);
        size.setInteger("bitrate", videoCaptureConfig.getBitRate());
        size.setInteger("frame-rate", videoCaptureConfig.getVideoFrameRate());
        size.setInteger("i-frame-interval", videoCaptureConfig.getIFrameInterval());
        return size;
    }

    private ByteBuffer getInputBuffer(MediaCodec mediaCodec, int n) {
        return mediaCodec.getInputBuffer(n);
    }

    private ByteBuffer getOutputBuffer(MediaCodec mediaCodec, int n) {
        return mediaCodec.getOutputBuffer(n);
    }

    private MediaMuxer initMediaMuxer(OutputFileOptions object) throws IOException {
        if (object.isSavingToFile()) {
            File file = object.getFile();
            this.mSavedVideoUri = Uri.fromFile((File)object.getFile());
            object = new MediaMuxer(file.getAbsolutePath(), 0);
        } else if (object.isSavingToFileDescriptor()) {
            if (Build.VERSION.SDK_INT < 26) throw new IllegalArgumentException("Using a FileDescriptor to record a video is only supported for Android 8.0 or above.");
            object = new MediaMuxer(object.getFileDescriptor(), 0);
        } else {
            if (!object.isSavingToMediaStore()) {
                object = new IllegalArgumentException("The OutputFileOptions should assign before recording");
                throw object;
            }
            Object object2 = object.getContentValues() != null ? new ContentValues(object.getContentValues()) : new ContentValues();
            object2 = object.getContentResolver().insert(object.getSaveCollection(), (ContentValues)object2);
            this.mSavedVideoUri = object2;
            if (object2 == null) throw new IOException("Invalid Uri!");
            try {
                if (Build.VERSION.SDK_INT < 26) {
                    object = VideoUtil.getAbsolutePathFromUri((ContentResolver)object.getContentResolver(), (Uri)this.mSavedVideoUri);
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Saved Location Path: ");
                    ((StringBuilder)object2).append((String)object);
                    Logger.i((String)"VideoCapture", (String)((StringBuilder)object2).toString());
                    object = new MediaMuxer((String)object, 0);
                } else {
                    this.mParcelFileDescriptor = object.getContentResolver().openFileDescriptor(this.mSavedVideoUri, "rw");
                    object = new MediaMuxer(this.mParcelFileDescriptor.getFileDescriptor(), 0);
                }
            }
            catch (IOException iOException) {
                this.mSavedVideoUri = null;
                throw iOException;
            }
        }
        return object;
    }

    static /* synthetic */ void lambda$releaseCameraSurface$7(boolean bl, MediaCodec mediaCodec) {
        if (!bl) return;
        if (mediaCodec == null) return;
        mediaCodec.release();
    }

    static /* synthetic */ Object lambda$startRecording$1(AtomicReference atomicReference, CallbackToFutureAdapter.Completer completer) throws Exception {
        atomicReference.set(completer);
        return "startRecording";
    }

    private void releaseCameraSurface(boolean bl) {
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface == null) {
            return;
        }
        MediaCodec mediaCodec = this.mVideoEncoder;
        deferrableSurface.close();
        this.mDeferrableSurface.getTerminationFuture().addListener((Runnable)new _$.Lambda.VideoCapture.5Thc_jl34dkc10u5dmeCfXccSQI(bl, mediaCodec), CameraXExecutors.mainThreadExecutor());
        if (bl) {
            this.mVideoEncoder = null;
        }
        this.mCameraSurface = null;
        this.mDeferrableSurface = null;
    }

    private void releaseResources() {
        this.mVideoHandlerThread.quitSafely();
        this.mAudioHandlerThread.quitSafely();
        MediaCodec mediaCodec = this.mAudioEncoder;
        if (mediaCodec != null) {
            mediaCodec.release();
            this.mAudioEncoder = null;
        }
        if ((mediaCodec = this.mAudioRecorder) != null) {
            mediaCodec.release();
            this.mAudioRecorder = null;
        }
        if (this.mCameraSurface == null) return;
        this.releaseCameraSurface(true);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    private void setAudioParametersByCamcorderProfile(Size size, String string) {
        int n;
        block6: {
            int n2;
            int n3;
            int[] nArray;
            int n4 = 0;
            try {
                nArray = CamcorderQuality;
                n3 = nArray.length;
                n2 = 0;
            }
            catch (NumberFormatException numberFormatException) {
                Logger.i((String)"VideoCapture", (String)"The camera Id is not an integer because the camera may be a removable device. Use the default values for the audio related settings.");
                n = n4;
                break block6;
            }
            while (true) {
                n = n4;
                if (n2 >= n3) break;
                n = nArray[n2];
                {
                    if (CamcorderProfile.hasProfile((int)Integer.parseInt(string), (int)n)) {
                        CamcorderProfile camcorderProfile = CamcorderProfile.get((int)Integer.parseInt(string), (int)n);
                        if (size.getWidth() == camcorderProfile.videoFrameWidth && size.getHeight() == camcorderProfile.videoFrameHeight) {
                            this.mAudioChannelCount = camcorderProfile.audioChannels;
                            this.mAudioSampleRate = camcorderProfile.audioSampleRate;
                            this.mAudioBitRate = camcorderProfile.audioBitRate;
                            n = 1;
                            break;
                        }
                    }
                    ++n2;
                    continue;
                }
                break;
            }
        }
        if (n != 0) return;
        size = (VideoCaptureConfig)this.getCurrentConfig();
        this.mAudioChannelCount = size.getAudioChannelCount();
        this.mAudioSampleRate = size.getAudioSampleRate();
        this.mAudioBitRate = size.getAudioBitRate();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private boolean writeAudioEncodedBuffer(int n) {
        boolean bl;
        block7: {
            ByteBuffer byteBuffer = this.getOutputBuffer(this.mAudioEncoder, n);
            byteBuffer.position(this.mAudioBufferInfo.offset);
            int n2 = this.mAudioTrackIndex;
            bl = true;
            if (n2 >= 0 && this.mVideoTrackIndex >= 0 && this.mAudioBufferInfo.size > 0 && this.mAudioBufferInfo.presentationTimeUs > 0L) {
                try {
                    Object object = this.mMuxerLock;
                    synchronized (object) {
                        if (this.mIsFirstAudioSampleWrite.get()) break block6;
                    }
                }
                catch (Exception throwable) {
                    StringBuilder object = new StringBuilder();
                    object.append("audio error:size=");
                    object.append(this.mAudioBufferInfo.size);
                    object.append("/offset=");
                    object.append(this.mAudioBufferInfo.offset);
                    object.append("/timeUs=");
                    object.append(this.mAudioBufferInfo.presentationTimeUs);
                    Logger.e((String)"VideoCapture", (String)object.toString());
                    throwable.printStackTrace();
                    break block7;
                }
                {
                    block6: {
                        Logger.i((String)"VideoCapture", (String)"First audio sample written.");
                        this.mIsFirstAudioSampleWrite.set(true);
                    }
                    this.mMuxer.writeSampleData(this.mAudioTrackIndex, byteBuffer, this.mAudioBufferInfo);
                }
            }
        }
        this.mAudioEncoder.releaseOutputBuffer(n, false);
        if ((this.mAudioBufferInfo.flags & 4) == 0) return false;
        return bl;
    }

    private boolean writeVideoEncodedBuffer(int n) {
        boolean bl = false;
        if (n < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Output buffer should not have negative index: ");
            stringBuilder.append(n);
            Logger.e((String)"VideoCapture", (String)stringBuilder.toString());
            return false;
        }
        ByteBuffer byteBuffer = this.mVideoEncoder.getOutputBuffer(n);
        if (byteBuffer == null) {
            Logger.d((String)"VideoCapture", (String)"OutputBuffer was null.");
            return false;
        }
        if (this.mAudioTrackIndex >= 0 && this.mVideoTrackIndex >= 0 && this.mVideoBufferInfo.size > 0) {
            byteBuffer.position(this.mVideoBufferInfo.offset);
            byteBuffer.limit(this.mVideoBufferInfo.offset + this.mVideoBufferInfo.size);
            this.mVideoBufferInfo.presentationTimeUs = System.nanoTime() / 1000L;
            Object object = this.mMuxerLock;
            synchronized (object) {
                if (!this.mIsFirstVideoSampleWrite.get()) {
                    Logger.i((String)"VideoCapture", (String)"First video sample written.");
                    this.mIsFirstVideoSampleWrite.set(true);
                }
                this.mMuxer.writeSampleData(this.mVideoTrackIndex, byteBuffer, this.mVideoBufferInfo);
            }
        }
        this.mVideoEncoder.releaseOutputBuffer(n, false);
        if ((this.mVideoBufferInfo.flags & 4) == 0) return bl;
        bl = true;
        return bl;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    boolean audioEncode(OnVideoSavedCallback onVideoSavedCallback) {
        long l = 0L;
        boolean bl = false;
        block6: while (true) {
            boolean bl2;
            int n;
            long l2;
            int n2;
            long l3;
            boolean bl3;
            Object object;
            block19: {
                block18: {
                    if (bl || !this.mIsRecording) break block18;
                    if (this.mEndOfAudioStreamSignal.get()) {
                        this.mEndOfAudioStreamSignal.set(false);
                        this.mIsRecording = false;
                    }
                    if ((object = this.mAudioEncoder) == null || this.mAudioRecorder == null) continue;
                    int n3 = object.dequeueInputBuffer(-1L);
                    bl3 = bl;
                    l3 = l;
                    if (n3 >= 0) {
                        object = this.getInputBuffer(this.mAudioEncoder, n3);
                        ((Buffer)object).clear();
                        n2 = this.mAudioRecorder.read((ByteBuffer)object, this.mAudioBufferSize);
                        bl3 = bl;
                        l3 = l;
                        if (n2 > 0) {
                            object = this.mAudioEncoder;
                            l2 = System.nanoTime() / 1000L;
                            n = this.mIsRecording ? 0 : 4;
                            object.queueInputBuffer(n3, 0, n2, l2, n);
                            l3 = l;
                            bl3 = bl;
                        }
                    }
                    break block19;
                }
                try {
                    Logger.i((String)"VideoCapture", (String)"audioRecorder stop");
                    this.mAudioRecorder.stop();
                }
                catch (IllegalStateException illegalStateException) {
                    onVideoSavedCallback.onError(1, "Audio recorder stop failed!", (Throwable)illegalStateException);
                }
                try {
                    this.mAudioEncoder.stop();
                }
                catch (IllegalStateException illegalStateException) {
                    onVideoSavedCallback.onError(1, "Audio encoder stop failed!", (Throwable)illegalStateException);
                }
                Logger.i((String)"VideoCapture", (String)"Audio encode thread end");
                this.mEndOfVideoStreamSignal.set(true);
                return false;
            }
            do {
                if ((n2 = this.mAudioEncoder.dequeueOutputBuffer(this.mAudioBufferInfo, 0L)) != -2) {
                    bl2 = bl3;
                    l2 = l3;
                    if (n2 != -1) {
                        if (this.mAudioBufferInfo.presentationTimeUs > l3) {
                            bl2 = this.writeAudioEncodedBuffer(n2);
                            l2 = this.mAudioBufferInfo.presentationTimeUs;
                        } else {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("Drops frame, current frame's timestamp ");
                            ((StringBuilder)object).append(this.mAudioBufferInfo.presentationTimeUs);
                            ((StringBuilder)object).append(" is earlier that last frame ");
                            ((StringBuilder)object).append(l3);
                            Logger.w((String)"VideoCapture", (String)((StringBuilder)object).toString());
                            this.mAudioEncoder.releaseOutputBuffer(n2, false);
                            bl2 = bl3;
                            l2 = l3;
                        }
                    }
                } else {
                    object = this.mMuxerLock;
                    synchronized (object) {
                        this.mAudioTrackIndex = n = this.mMuxer.addTrack(this.mAudioEncoder.getOutputFormat());
                        if (n >= 0 && this.mVideoTrackIndex >= 0) {
                            this.mMuxerStarted = true;
                            this.mMuxer.start();
                        }
                    }
                    l2 = l3;
                    bl2 = bl3;
                }
                bl = bl2;
                l = l2;
                if (n2 < 0) continue block6;
                bl3 = bl2;
                l3 = l2;
            } while (!bl2);
            bl = bl2;
            l = l2;
        }
    }

    public UseCaseConfig<?> getDefaultConfig(boolean bl, UseCaseConfigFactory object) {
        Config config = object.getConfig(UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE);
        object = config;
        if (bl) {
            object = Config._CC.mergeConfigs((Config)config, (Config)DEFAULT_CONFIG.getConfig());
        }
        object = object == null ? null : this.getUseCaseConfigBuilder((Config)object).getUseCaseConfig();
        return object;
    }

    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config config) {
        return Builder.fromConfig((Config)config);
    }

    public /* synthetic */ void lambda$onDetached$6$VideoCapture() {
        this.releaseResources();
    }

    public /* synthetic */ void lambda$startRecording$0$VideoCapture(OutputFileOptions outputFileOptions, Executor executor, OnVideoSavedCallback onVideoSavedCallback) {
        this.startRecording(outputFileOptions, executor, onVideoSavedCallback);
    }

    public /* synthetic */ void lambda$startRecording$2$VideoCapture() {
        this.mRecordingFuture = null;
        if (this.getCamera() == null) return;
        this.setupEncoder(this.getCameraId(), this.getAttachedSurfaceResolution());
        this.notifyReset();
    }

    public /* synthetic */ void lambda$startRecording$3$VideoCapture(OnVideoSavedCallback onVideoSavedCallback) {
        this.audioEncode(onVideoSavedCallback);
    }

    public /* synthetic */ void lambda$startRecording$4$VideoCapture(OnVideoSavedCallback onVideoSavedCallback, String string, Size size, CallbackToFutureAdapter.Completer completer) {
        if (!this.videoEncode(onVideoSavedCallback, string, size)) {
            onVideoSavedCallback.onVideoSaved(new OutputFileResults(this.mSavedVideoUri));
            this.mSavedVideoUri = null;
        }
        completer.set(null);
    }

    public /* synthetic */ void lambda$stopRecording$5$VideoCapture() {
        this.stopRecording();
    }

    public void onAttached() {
        this.mVideoHandlerThread = new HandlerThread("CameraX-video encoding thread");
        this.mAudioHandlerThread = new HandlerThread("CameraX-audio encoding thread");
        this.mVideoHandlerThread.start();
        this.mVideoHandler = new Handler(this.mVideoHandlerThread.getLooper());
        this.mAudioHandlerThread.start();
        this.mAudioHandler = new Handler(this.mAudioHandlerThread.getLooper());
    }

    public void onDetached() {
        this.stopRecording();
        ListenableFuture<Void> listenableFuture = this.mRecordingFuture;
        if (listenableFuture != null) {
            listenableFuture.addListener((Runnable)new _$.Lambda.VideoCapture.MChuGRw3jKhH34Mz50N4JOp7jiM(this), CameraXExecutors.mainThreadExecutor());
        } else {
            this.releaseResources();
        }
    }

    public void onStateDetached() {
        this.stopRecording();
    }

    protected Size onSuggestedResolutionUpdated(Size size) {
        if (this.mCameraSurface != null) {
            this.mVideoEncoder.stop();
            this.mVideoEncoder.release();
            this.mAudioEncoder.stop();
            this.mAudioEncoder.release();
            this.releaseCameraSurface(false);
        }
        try {
            this.mVideoEncoder = MediaCodec.createEncoderByType((String)"video/avc");
            this.mAudioEncoder = MediaCodec.createEncoderByType((String)"audio/mp4a-latm");
            this.setupEncoder(this.getCameraId(), size);
            return size;
        }
        catch (IOException iOException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to create MediaCodec due to: ");
            stringBuilder.append(iOException.getCause());
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public void setTargetRotation(int n) {
        this.setTargetRotationInternal(n);
    }

    void setupEncoder(String string, Size size) {
        Surface surface;
        VideoCaptureConfig videoCaptureConfig = (VideoCaptureConfig)this.getCurrentConfig();
        this.mVideoEncoder.reset();
        this.mVideoEncoder.configure(VideoCapture.createMediaFormat(videoCaptureConfig, size), null, null, 1);
        if (this.mCameraSurface != null) {
            this.releaseCameraSurface(false);
        }
        this.mCameraSurface = surface = this.mVideoEncoder.createInputSurface();
        SessionConfig.Builder builder = SessionConfig.Builder.createFrom((UseCaseConfig)videoCaptureConfig);
        Object object = this.mDeferrableSurface;
        if (object != null) {
            object.close();
        }
        object = new ImmediateSurface(this.mCameraSurface);
        this.mDeferrableSurface = object;
        object = object.getTerminationFuture();
        Objects.requireNonNull(surface);
        object.addListener((Runnable)new _$.Lambda.bKhot3B1n1f2PgvvZExesMq2yMg(surface), CameraXExecutors.mainThreadExecutor());
        builder.addSurface(this.mDeferrableSurface);
        builder.addErrorListener((SessionConfig.ErrorListener)new /* Unavailable Anonymous Inner Class!! */);
        this.updateSessionConfig(builder.build());
        this.setAudioParametersByCamcorderProfile(size, string);
        this.mAudioEncoder.reset();
        this.mAudioEncoder.configure(this.createAudioMediaFormat(), null, null, 1);
        string = this.mAudioRecorder;
        if (string != null) {
            string.release();
        }
        string = this.autoConfigAudioRecordSource(videoCaptureConfig);
        this.mAudioRecorder = string;
        if (string == null) {
            Logger.e((String)"VideoCapture", (String)"AudioRecord object cannot initialized correctly!");
        }
        this.mVideoTrackIndex = -1;
        this.mAudioTrackIndex = -1;
        this.mIsRecording = false;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void startRecording(OutputFileOptions object, Executor executor, OnVideoSavedCallback object2) {
        Object object3;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute((Runnable)new _$.Lambda.VideoCapture.CtkdvPm9R_T2rWkFfmPoBN8pCVg(this, (OutputFileOptions)object, executor, (OnVideoSavedCallback)object2));
            return;
        }
        Logger.i((String)"VideoCapture", (String)"startRecording");
        this.mIsFirstVideoSampleWrite.set(false);
        this.mIsFirstAudioSampleWrite.set(false);
        executor = new VideoSavedListenerWrapper(executor, (OnVideoSavedCallback)object2);
        CameraInternal cameraInternal = this.getCamera();
        if (cameraInternal == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Not bound to a Camera [");
            ((StringBuilder)object).append((Object)this);
            ((StringBuilder)object).append("]");
            executor.onError(5, ((StringBuilder)object).toString(), null);
            return;
        }
        if (!this.mEndOfAudioVideoSignal.get()) {
            executor.onError(3, "It is still in video recording!", null);
            return;
        }
        try {
            this.mAudioRecorder.startRecording();
        }
        catch (IllegalStateException illegalStateException) {
            executor.onError(1, "AudioRecorder start fail", illegalStateException);
            return;
        }
        object2 = new AtomicReference();
        this.mRecordingFuture = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new _$.Lambda.VideoCapture.sWuEFWqiGVmDEh_KqMmeL3T_hpU((AtomicReference)object2));
        object2 = (CallbackToFutureAdapter.Completer)Preconditions.checkNotNull((Object)((CallbackToFutureAdapter.Completer)((AtomicReference)object2).get()));
        this.mRecordingFuture.addListener((Runnable)new _$.Lambda.VideoCapture.ER74H3wEjHOpv1ztEcCPnPwOyj8(this), CameraXExecutors.mainThreadExecutor());
        try {
            Logger.i((String)"VideoCapture", (String)"videoEncoder start");
            this.mVideoEncoder.start();
            Logger.i((String)"VideoCapture", (String)"audioEncoder start");
            this.mAudioEncoder.start();
        }
        catch (IllegalStateException illegalStateException) {
            object2.set(null);
            executor.onError(1, "Audio/Video encoder start fail", illegalStateException);
            return;
        }
        try {
            object3 = this.mMuxerLock;
            synchronized (object3) {
            }
        }
        catch (IOException iOException) {
            object2.set(null);
            executor.onError(2, "MediaMuxer creation failed!", iOException);
            return;
        }
        {
            MediaMuxer mediaMuxer;
            this.mMuxer = mediaMuxer = this.initMediaMuxer((OutputFileOptions)object);
            Preconditions.checkNotNull((Object)mediaMuxer);
            this.mMuxer.setOrientationHint(this.getRelativeRotation(cameraInternal));
            object = object.getMetadata();
            if (object != null && ((Metadata)object).location != null) {
                this.mMuxer.setLocation((float)((Metadata)object).location.getLatitude(), (float)((Metadata)object).location.getLongitude());
            }
        }
        this.mEndOfVideoStreamSignal.set(false);
        this.mEndOfAudioStreamSignal.set(false);
        this.mEndOfAudioVideoSignal.set(false);
        this.mIsRecording = true;
        this.notifyActive();
        this.mAudioHandler.post((Runnable)new _$.Lambda.VideoCapture.oP3cFjboQurpR7UylbkByT1ylCA(this, (OnVideoSavedCallback)executor));
        object = this.getCameraId();
        object3 = this.getAttachedSurfaceResolution();
        this.mVideoHandler.post((Runnable)new _$.Lambda.VideoCapture.lA6YXAVaPCGqufdCHl3fDcETyWQ(this, (OnVideoSavedCallback)executor, (String)object, (Size)object3, (CallbackToFutureAdapter.Completer)object2));
    }

    public void stopRecording() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute((Runnable)new _$.Lambda.VideoCapture.Tho64enhuCvARi_3Xm5_vjHJk1k(this));
            return;
        }
        Logger.i((String)"VideoCapture", (String)"stopRecording");
        this.notifyInactive();
        if (this.mEndOfAudioVideoSignal.get()) return;
        if (!this.mIsRecording) return;
        this.mEndOfAudioStreamSignal.set(true);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    boolean videoEncode(OnVideoSavedCallback onVideoSavedCallback, String object3, Size size) {
        Object object2;
        boolean bl;
        boolean bl2;
        block17: {
            bl2 = false;
            bl = false;
            while (!bl2 && !bl) {
                int n;
                if (this.mEndOfVideoStreamSignal.get()) {
                    this.mVideoEncoder.signalEndOfInputStream();
                    this.mEndOfVideoStreamSignal.set(false);
                }
                if ((n = this.mVideoEncoder.dequeueOutputBuffer(this.mVideoBufferInfo, 10000L)) != -2) {
                    if (n == -1) continue;
                    bl2 = this.writeVideoEncodedBuffer(n);
                    continue;
                }
                if (this.mMuxerStarted) {
                    onVideoSavedCallback.onError(1, "Unexpected change in video encoding format.", null);
                    bl = true;
                }
                object2 = this.mMuxerLock;
                synchronized (object2) {
                    this.mVideoTrackIndex = n = this.mMuxer.addTrack(this.mVideoEncoder.getOutputFormat());
                    if (this.mAudioTrackIndex >= 0 && n >= 0) {
                        this.mMuxerStarted = true;
                        Logger.i((String)"VideoCapture", (String)"media mMuxer start");
                        this.mMuxer.start();
                    }
                }
            }
            try {
                Logger.i((String)"VideoCapture", (String)"videoEncoder stop");
                this.mVideoEncoder.stop();
            }
            catch (IllegalStateException object3) {
                onVideoSavedCallback.onError(1, "Video encoder stop failed!", (Throwable)object3);
                bl = true;
            }
            try {
                object2 = this.mMuxerLock;
                synchronized (object2) {
                    if (this.mMuxer == null) break block17;
                    if (!this.mMuxerStarted) break block18;
                }
            }
            catch (IllegalStateException illegalStateException) {
                onVideoSavedCallback.onError(2, "Muxer stop failed!", (Throwable)illegalStateException);
                bl = true;
                break block17;
            }
            {
                block18: {
                    this.mMuxer.stop();
                }
                this.mMuxer.release();
                this.mMuxer = null;
            }
        }
        object2 = this.mParcelFileDescriptor;
        bl2 = bl;
        if (object2 != null) {
            try {
                object2.close();
                this.mParcelFileDescriptor = null;
                bl2 = bl;
            }
            catch (IOException illegalStateException) {
                onVideoSavedCallback.onError(2, "File descriptor close failed!", (Throwable)illegalStateException);
                bl2 = true;
            }
        }
        this.mMuxerStarted = false;
        this.mEndOfAudioVideoSignal.set(true);
        Logger.i((String)"VideoCapture", (String)"Video encode thread end.");
        return bl2;
    }
}
