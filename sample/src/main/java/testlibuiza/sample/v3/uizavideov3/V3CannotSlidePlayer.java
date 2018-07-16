package testlibuiza.sample.v3.uizavideov3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Surface;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.gson.Gson;

import java.util.List;

import testlibuiza.R;
import vn.loitp.core.base.BaseActivity;
import vn.loitp.restapi.uiza.model.v2.listallentity.Item;
import vn.loitp.restapi.uiza.model.v3.linkplay.getlinkplay.ResultGetLinkPlay;
import vn.loitp.restapi.uiza.model.v3.metadata.getdetailofmetadata.Data;
import vn.loitp.restapi.uiza.model.v3.videoondeman.retrieveanentity.ResultRetrieveAnEntity;
import vn.loitp.uizavideo.listerner.ProgressCallback;
import vn.loitp.uizavideo.view.rl.video.UizaIMAVideo;
import vn.loitp.uizavideov3.view.rl.video.UizaIMAVideoV3;
import vn.loitp.uizavideov3.view.util.UizaDataV3;
import vn.loitp.uizavideov3.view.util.UizaInputV3;
import vn.loitp.views.LToast;

/**
 * Created by loitp on 7/16/2018.
 */

public class V3CannotSlidePlayer extends BaseActivity implements UizaIMAVideoV3.Callback {
    private UizaIMAVideoV3 uizaIMAVideoV3;

    @Override
    protected boolean setFullScreen() {
        return false;
    }

    @Override
    protected String setTag() {
        return getClass().getSimpleName();
    }

    @Override
    protected int setLayoutResourceId() {
        return R.layout.v3_cannot_slide_player;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uizaIMAVideoV3 = (UizaIMAVideoV3) findViewById(R.id.uiza_video);

        String entityId = getIntent().getStringExtra("entityId");

        //String urlIMAAd = activity.getString(loitp.core.R.string.ad_tag_url);
        String urlIMAAd = null;
        //String urlThumnailsPreviewSeekbar = activity.getString(loitp.core.R.string.url_thumbnails);
        String urlThumnailsPreviewSeekbar = null;

        Data data = getDummyData();
        setupVideo(data, urlIMAAd, urlThumnailsPreviewSeekbar, false);
    }

    private Data getDummyData() {
        Gson gson = new Gson();
        String json = "{\n" +
                "            \"id\": \"b7297b29-c6c4-4bd6-a74f-b60d0118d275\",\n" +
                "            \"name\": \"[FMV Vietsub] Là Tự Em Đa Tình 多情种 // Vũ Văn Nguyệt x Sở Kiều // Sở Kiều truyện 楚乔传 【星玥】\",\n" +
                "            \"description\": null,\n" +
                "            \"shortDescription\": null,\n" +
                "            \"view\": 0,\n" +
                "            \"poster\": \"http://android-static.uizacdn.net/16f8e65d8e2643ffa3ff5ee9f4f9ba03-static/2018/07/16/blob-1531724245175\",\n" +
                "            \"thumbnail\": \"http://android-static.uizacdn.net/16f8e65d8e2643ffa3ff5ee9f4f9ba03-static/2018/07/16/blob-1531724245175\",\n" +
                "            \"type\": \"vod\",\n" +
                "            \"duration\": \"300.466213\",\n" +
                "            \"embedMetadata\": null,\n" +
                "            \"extendMetadata\": null,\n" +
                "            \"createdAt\": \"2018-07-16T05:03:46.000Z\",\n" +
                "            \"updatedAt\": \"2018-07-16T06:57:26.000Z\"\n" +
                "        }";
        return gson.fromJson(json, Data.class);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        uizaIMAVideoV3.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        uizaIMAVideoV3.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        uizaIMAVideoV3.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
        uizaIMAVideoV3.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        uizaIMAVideoV3.onStop();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == UizaIMAVideo.CODE_DRAW_OVER_OTHER_APP_PERMISSION) {
            //Check if the permission is granted or not.
            if (resultCode == Activity.RESULT_OK) {
                //LLog.d(TAG, "onActivityResult RESULT_OK");
                uizaIMAVideoV3.initializePiP();
            } else {
                LToast.show(activity, "Draw over other app permission not available");
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void setListener() {
        //LLog.d(TAG, TAG + " addListener");
        if (uizaIMAVideoV3 == null || uizaIMAVideoV3.getPlayer() == null) {
            return;
        }
        uizaIMAVideoV3.getPlayer().addListener(new Player.EventListener() {
            @Override
            public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {
                //LLog.d(TAG, "onTimelineChanged");
            }

            @Override
            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
                //LLog.d(TAG, "onTimelineChanged");
            }

            @Override
            public void onLoadingChanged(boolean isLoading) {
                //LLog.d(TAG, "onTimelineChanged");
            }

            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                //LLog.d(TAG, "onTimelineChanged");
            }

            @Override
            public void onRepeatModeChanged(int repeatMode) {
                //LLog.d(TAG, "onTimelineChanged");
            }

            @Override
            public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
                //LLog.d(TAG, "onTimelineChanged");
            }

            @Override
            public void onPlayerError(ExoPlaybackException error) {
                //LLog.d(TAG, "onTimelineChanged");
            }

            @Override
            public void onPositionDiscontinuity(int reason) {
                //LLog.d(TAG, "onTimelineChanged");
            }

            @Override
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                //LLog.d(TAG, "onTimelineChanged");
            }

            @Override
            public void onSeekProcessed() {
                //LLog.d(TAG, "onTimelineChanged");
            }
        });
        uizaIMAVideoV3.getPlayer().addAudioDebugListener(new AudioRendererEventListener() {
            @Override
            public void onAudioEnabled(DecoderCounters counters) {
                //LLog.d(TAG, "onAudioEnabled");
            }

            @Override
            public void onAudioSessionId(int audioSessionId) {
                //LLog.d(TAG, "onAudioSessionId");
            }

            @Override
            public void onAudioDecoderInitialized(String decoderName, long initializedTimestampMs, long initializationDurationMs) {
                //LLog.d(TAG, "onAudioDecoderInitialized");
            }

            @Override
            public void onAudioInputFormatChanged(Format format) {
                //LLog.d(TAG, "onAudioInputFormatChanged");
            }

            @Override
            public void onAudioSinkUnderrun(int bufferSize, long bufferSizeMs, long elapsedSinceLastFeedMs) {
                //LLog.d(TAG, "onAudioSinkUnderrun");
            }

            @Override
            public void onAudioDisabled(DecoderCounters counters) {
                //LLog.d(TAG, "onAudioDisabled");
            }
        });
        uizaIMAVideoV3.setProgressCallback(new ProgressCallback() {
            @Override
            public void onAdProgress(float currentMls, int s, float duration, int percent) {
                //LLog.d(TAG, TAG + " ad progress: " + currentMls + "/" + duration + " -> " + percent + "%");
            }

            @Override
            public void onVideoProgress(float currentMls, int s, float duration, int percent) {
                //LLog.d(TAG, TAG + " video progress: " + currentMls + "/" + duration + " -> " + percent + "%");
            }
        });
        uizaIMAVideoV3.getPlayer().addVideoDebugListener(new VideoRendererEventListener() {
            @Override
            public void onVideoEnabled(DecoderCounters counters) {
                //LLog.d(TAG, "onVideoEnabled");
            }

            @Override
            public void onVideoDecoderInitialized(String decoderName, long initializedTimestampMs, long initializationDurationMs) {
                //LLog.d(TAG, "onVideoDecoderInitialized");
            }

            @Override
            public void onVideoInputFormatChanged(Format format) {
                //LLog.d(TAG, "onVideoInputFormatChanged");
            }

            @Override
            public void onDroppedFrames(int count, long elapsedMs) {
                //LLog.d(TAG, "onDroppedFrames");
            }

            @Override
            public void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
                //LLog.d(TAG, "onAudioDisabled");
            }

            @Override
            public void onRenderedFirstFrame(Surface surface) {
                //LLog.d(TAG, "onRenderedFirstFrame");
            }

            @Override
            public void onVideoDisabled(DecoderCounters counters) {
                //LLog.d(TAG, "onVideoDisabled");
            }
        });
        uizaIMAVideoV3.getPlayer().addMetadataOutput(new MetadataOutput() {
            @Override
            public void onMetadata(Metadata metadata) {
                //LLog.d(TAG, "onMetadata");
            }
        });
        uizaIMAVideoV3.getPlayer().addTextOutput(new TextOutput() {
            @Override
            public void onCues(List<Cue> cues) {
                //LLog.d(TAG, "onCues");
            }
        });
    }

    private void setupVideo(Data data, String urlIMAAd, String urlThumnailsPreviewSeekbar, boolean isTryToPlayPreviousUizaInputIfPlayCurrentUizaInputFailed) {
        //LLog.d(TAG, "setupVideo");
        if (data == null) {
            return;
        }
        if (UizaDataV3.getInstance().isSettingPlayer()) {
            //LLog.d(TAG, "setupVideo isSettingPlayer -> return");
            return;
        }
        UizaInputV3 uizaInputV3 = new UizaInputV3();
        uizaInputV3.setData(data);
        uizaInputV3.setUrlIMAAd(urlIMAAd);
        uizaInputV3.setUrlThumnailsPreviewSeekbar(urlThumnailsPreviewSeekbar);
        UizaDataV3.getInstance().setUizaInput(uizaInputV3, isTryToPlayPreviousUizaInputIfPlayCurrentUizaInputFailed);

        //LLog.d(TAG, "setupVideo entityId " + entityId + ", entityTitle: " + entityTitle + ", entityCover: " + entityCover);
        //LLog.d(TAG, "setupVideo init with entityId " + entityId);
        uizaIMAVideoV3.post(new Runnable() {
            @Override
            public void run() {
                uizaIMAVideoV3.init(V3CannotSlidePlayer.this);
            }
        });
    }

    @Override
    public void isInitResult(boolean isInitSuccess, ResultGetLinkPlay resultGetLinkPlay, ResultRetrieveAnEntity resultRetrieveAnEntity) {

    }

    @Override
    public void onClickListEntityRelation(Item item, int position) {

    }

    @Override
    public void onClickBack() {

    }

    @Override
    public void onClickPip(Intent intent) {

    }

    @Override
    public void onClickPipVideoInitSuccess(boolean isInitSuccess) {

    }

    @Override
    public void onError(Exception e) {

    }
}
