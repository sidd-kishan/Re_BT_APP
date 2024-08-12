/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.view;

public static final class PreviewView.StreamState
extends Enum<PreviewView.StreamState> {
    private static final PreviewView.StreamState[] $VALUES;
    public static final /* enum */ PreviewView.StreamState IDLE;
    public static final /* enum */ PreviewView.StreamState STREAMING;

    static {
        PreviewView.StreamState streamState;
        IDLE = new PreviewView.StreamState();
        STREAMING = streamState = new PreviewView.StreamState();
        $VALUES = new PreviewView.StreamState[]{IDLE, streamState};
    }

    public static PreviewView.StreamState valueOf(String string) {
        return Enum.valueOf(PreviewView.StreamState.class, string);
    }

    public static PreviewView.StreamState[] values() {
        return (PreviewView.StreamState[])$VALUES.clone();
    }
}
