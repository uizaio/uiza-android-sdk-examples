package testlibuiza.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

import testlibuiza.app.R;
import uizacoresdk.util.UZUtil;
import uizacoresdk.view.rl.video.UZCallback;
import uizacoresdk.view.rl.video.UZTVCallback;
import uizacoresdk.view.rl.video.UZVideo;
import vn.uiza.core.base.BaseActivity;
import vn.uiza.core.common.Constants;
import vn.uiza.core.exception.UZException;
import vn.uiza.core.utilities.LLog;
import vn.uiza.restapi.uiza.model.v2.listallentity.Item;
import vn.uiza.restapi.uiza.model.v3.linkplay.getlinkplay.ResultGetLinkPlay;
import vn.uiza.restapi.uiza.model.v3.metadata.getdetailofmetadata.Data;
import vn.uiza.views.LToast;

public class PlayerActivity extends BaseActivity implements UZCallback, UZTVCallback {
    private UZVideo uzVideo;
    private ViewGroup rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        UZUtil.setCasty(this);

        //init skin
        //UZUtil.setCurrentPlayerId(R.layout.uz_player_skin_tv_custom);
        UZUtil.setCurrentPlayerId(R.layout.uz_player_skin_tv_0);
        //UZUtil.setCurrentPlayerId(R.layout.uz_player_skin_0);
        //UZUtil.setCurrentPlayerId(R.layout.uz_player_skin_1);
        //UZUtil.setCurrentPlayerId(R.layout.uz_player_skin_2);
        //UZUtil.setCurrentPlayerId(R.layout.uz_player_skin_3);

        super.onCreate(savedInstanceState);
        rootView = (ViewGroup) findViewById(R.id.root_view);
        uzVideo = (UZVideo) findViewById(R.id.uiza_video);
        uzVideo.setUZCallback(this);
        uzVideo.setUZTVCallback(this);

        //uzVideo.setUseController(false);
        String entityId = getIntent().getStringExtra(Constants.KEY_UIZA_ENTITY_ID);
        if (entityId == null) {
            String metadataId = getIntent().getStringExtra(Constants.KEY_UIZA_METADATA_ENTITY_ID);
            UZUtil.initPlaylistFolder(activity, uzVideo, metadataId);
        } else {
            UZUtil.initEntity(activity, uzVideo, entityId);
        }
    }

    @Override
    protected boolean setFullScreen() {
        return false;
    }

    @Override
    protected String setTag() {
        return "TAG" + getClass().getSimpleName();
    }

    @Override
    protected int setLayoutResourceId() {
        return R.layout.activity_player;
    }

    @Override
    public void isInitResult(boolean isInitSuccess, boolean isGetDataSuccess, ResultGetLinkPlay resultGetLinkPlay, Data data) {
        if (isInitSuccess) {
            uzVideo.setEventBusMsgFromActivityIsInitSuccess();
        }
    }

    @Override
    public void onClickListEntityRelation(Item item, int position) {
    }

    @Override
    public void onClickBack() {
        onBackPressed();
    }

    @Override
    public void onClickPip(Intent intent) {
    }

    @Override
    public void onClickPipVideoInitSuccess(boolean isInitSuccess) {

    }

    @Override
    public void onSkinChange() {
    }

    @Override
    public void onError(UZException e) {
        if (e == null) {
            return;
        }
        LLog.e(TAG, "onError: " + e.toString());
        /*LDialogUtil.showDialog1(activity, e.getMessage(), new LDialogUtil.Callback1() {
            @Override
            public void onClick1() {
                onBackPressed();
            }

            @Override
            public void onCancel() {
                onBackPressed();
            }
        });*/
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        uzVideo.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        uzVideo.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        uzVideo.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
        uzVideo.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        uzVideo.onStop();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.CODE_DRAW_OVER_OTHER_APP_PERMISSION) {
            if (resultCode == Activity.RESULT_OK) {
                uzVideo.initializePiP();
            } else {
                LToast.show(activity, "Draw over other app permission not available");
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //LLog.d(TAG, "onKeyUp " + keyCode);
        switch (keyCode) {
            case KeyEvent.KEYCODE_MEDIA_REWIND:
                LLog.d(TAG, "onKeyUp KEYCODE_MEDIA_REWIND");
                uzVideo.seekToBackward(uzVideo.getDefaultValueBackwardForward());
                return true;
            case KeyEvent.KEYCODE_MEDIA_FAST_FORWARD:
                LLog.d(TAG, "onKeyUp KEYCODE_MEDIA_FAST_FORWARD");
                uzVideo.seekToForward(uzVideo.getDefaultValueBackwardForward());
                return true;
            case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
                LLog.d(TAG, "onKeyUp KEYCODE_MEDIA_PLAY_PAUSE");
                uzVideo.togglePlayPause();
                return true;
            case KeyEvent.KEYCODE_MEDIA_STOP:
                LLog.d(TAG, "onKeyUp KEYCODE_MEDIA_STOP");
                uzVideo.pauseVideo();
                return true;
            case KeyEvent.KEYCODE_BACK:
                LLog.d(TAG, "onKeyUp KEYCODE_BACK");
                onBackPressed();
                return true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                LLog.d(TAG, "onKeyUp KEYCODE_VOLUME_UP");
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                LLog.d(TAG, "onKeyUp KEYCODE_VOLUME_DOWN");
                return true;
            case KeyEvent.KEYCODE_MENU:
                LLog.d(TAG, "onKeyUp KEYCODE_MENU");
                uzVideo.toggleShowHideController();
                return true;
            case KeyEvent.KEYCODE_DPAD_UP:
                LLog.d(TAG, "onKeyUp KEYCODE_DPAD_UP");
                return true;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                LLog.d(TAG, "onKeyUp KEYCODE_DPAD_LEFT");
                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                LLog.d(TAG, "onKeyUp KEYCODE_DPAD_RIGHT");
                return true;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                LLog.d(TAG, "onKeyUp KEYCODE_DPAD_DOWN");
                return true;
            case KeyEvent.KEYCODE_DPAD_CENTER:
                LLog.d(TAG, "onKeyUp KEYCODE_DPAD_CENTER");
                uzVideo.showController();
                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }
    }

    @Override
    public void onFocusChange(View view, boolean isFocus) {
        //LLog.d(TAG, "onFocusChange isFocus " + isFocus);
        /*if (isFocus) {
            if (view == uzVideo.getIbBackScreenIcon()) {
                LLog.d(TAG, "onFocusChange ibSettingIcon");
            } else if (view == uzVideo.getIbSettingIcon()) {
                LLog.d(TAG, "onFocusChange ibSettingIcon");
            } else if (view == uzVideo.getIbCcIcon()) {
                LLog.d(TAG, "onFocusChange ibCcIcon");
            } else if (view == uzVideo.getIbPlaylistRelationIcon()) {
                LLog.d(TAG, "onFocusChange ibPlaylistRelationIcon");
            } else if (view == uzVideo.getIbRewIcon()) {
                LLog.d(TAG, "onFocusChange ibRewIcon");
            } else if (view == uzVideo.getIbPlayIcon()) {
                LLog.d(TAG, "onFocusChange ibPlayIcon");
            } else if (view == uzVideo.getIbPauseIcon()) {
                LLog.d(TAG, "onFocusChange ibPauseIcon");
            } else if (view == uzVideo.getIbReplayIcon()) {
                LLog.d(TAG, "onFocusChange ibReplayIcon");
            } else if (view == uzVideo.getIbSkipNextIcon()) {
                LLog.d(TAG, "onFocusChange ibSkipNextIcon");
            } else if (view == uzVideo.getIbSkipPreviousIcon()) {
                LLog.d(TAG, "onFocusChange ibSkipPreviousIcon");
            } else if (view == uzVideo.getUZTimeBar()) {
                LLog.d(TAG, "onFocusChange uzTimebar");
            }
        }*/
        uzVideo.updateUIFocusChange(view, isFocus);
    }
}