/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.AudioAttributes$Builder
 *  android.os.Build$VERSION
 *  android.util.Log
 *  androidx.media.AudioAttributesCompat
 *  androidx.media.AudioAttributesImpl
 *  androidx.media.AudioAttributesImplApi21
 *  androidx.media.AudioAttributesImplBase
 */
package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.util.Log;
import androidx.media.AudioAttributesCompat;
import androidx.media.AudioAttributesImpl;
import androidx.media.AudioAttributesImplApi21;
import androidx.media.AudioAttributesImplBase;

/*
 * Exception performing whole class analysis ignored.
 */
public static class AudioAttributesCompat.Builder {
    private int mContentType = 0;
    private int mFlags = 0;
    private int mLegacyStream = -1;
    private int mUsage = 0;

    public AudioAttributesCompat.Builder() {
    }

    public AudioAttributesCompat.Builder(AudioAttributesCompat audioAttributesCompat) {
        this.mUsage = audioAttributesCompat.getUsage();
        this.mContentType = audioAttributesCompat.getContentType();
        this.mFlags = audioAttributesCompat.getFlags();
        this.mLegacyStream = audioAttributesCompat.getRawLegacyStreamType();
    }

    public AudioAttributesCompat build() {
        AudioAttributesImplBase audioAttributesImplBase;
        if (!AudioAttributesCompat.sForceLegacyBehavior && Build.VERSION.SDK_INT >= 21) {
            audioAttributesImplBase = new AudioAttributes.Builder().setContentType(this.mContentType).setFlags(this.mFlags).setUsage(this.mUsage);
            int n = this.mLegacyStream;
            if (n != -1) {
                audioAttributesImplBase.setLegacyStreamType(n);
            }
            audioAttributesImplBase = new AudioAttributesImplApi21(audioAttributesImplBase.build(), this.mLegacyStream);
        } else {
            audioAttributesImplBase = new AudioAttributesImplBase(this.mContentType, this.mFlags, this.mUsage, this.mLegacyStream);
        }
        return new AudioAttributesCompat((AudioAttributesImpl)audioAttributesImplBase);
    }

    public AudioAttributesCompat.Builder setContentType(int n) {
        if (n != 0 && n != 1 && n != 2 && n != 3 && n != 4) {
            this.mUsage = 0;
        } else {
            this.mContentType = n;
        }
        return this;
    }

    public AudioAttributesCompat.Builder setFlags(int n) {
        this.mFlags = n & 0x3FF | this.mFlags;
        return this;
    }

    /*
     * Handled duff style switch with additional control
     */
    AudioAttributesCompat.Builder setInternalLegacyStreamType(int n) {
        int n2 = Integer.MIN_VALUE;
        block13: do {
            switch (n2 == Integer.MIN_VALUE ? n : n2) {
                default: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid stream type ");
                    stringBuilder.append(n);
                    stringBuilder.append(" for AudioAttributesCompat");
                    Log.e((String)"AudioAttributesCompat", (String)stringBuilder.toString());
                    break;
                }
                case 10: {
                    this.mContentType = 1;
                    break;
                }
                case 9: {
                    this.mContentType = 4;
                    break;
                }
                case 8: {
                    this.mContentType = 4;
                    break;
                }
                case 7: {
                    this.mFlags = 1 | this.mFlags;
                    n2 = 1;
                    continue block13;
                }
                case 6: {
                    this.mContentType = 1;
                    this.mFlags |= 4;
                    break;
                }
                case 5: {
                    this.mContentType = 4;
                    break;
                }
                case 4: {
                    this.mContentType = 4;
                    break;
                }
                case 3: {
                    this.mContentType = 2;
                    break;
                }
                case 2: {
                    this.mContentType = 4;
                    break;
                }
                case 1: {
                    this.mContentType = 4;
                    break;
                }
                case 0: {
                    this.mContentType = 1;
                }
            }
            break;
        } while (true);
        this.mUsage = AudioAttributesCompat.usageForStreamType((int)n);
        return this;
    }

    public AudioAttributesCompat.Builder setLegacyStreamType(int n) {
        if (n == 10) throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
        this.mLegacyStream = n;
        if (Build.VERSION.SDK_INT < 21) return this;
        return this.setInternalLegacyStreamType(n);
    }

    public AudioAttributesCompat.Builder setUsage(int n) {
        switch (n) {
            default: {
                this.mUsage = 0;
                break;
            }
            case 16: {
                if (!AudioAttributesCompat.sForceLegacyBehavior && Build.VERSION.SDK_INT > 25) {
                    this.mUsage = n;
                    break;
                }
                this.mUsage = 12;
                break;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                this.mUsage = n;
            }
        }
        return this;
    }
}
