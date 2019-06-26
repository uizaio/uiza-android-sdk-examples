package com.tungtt.sdktest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import vn.uiza.core.common.Constants;
import com.tungtt.sdktest.PlayerActivity;
import com.tungtt.sdktest.utube.CustomSkinCodeUZTimebarUTubeActivity;
import com.tungtt.sdktest.utube.CustomSkinCodeUZTimebarUTubeWithSlideActivity;
import com.tungtt.sdktest.customskin.CustomSkinCodeSeekbarActivity;
import com.tungtt.sdktest.customskin.CustomSkinCodeUZTimebarActivity;
import com.tungtt.sdktest.customskin.CustomSkinXMLActivity;
import com.tungtt.sdktest.fb.FBListVideoActivity;
import com.tungtt.sdktest.fb.FBVideoActivity;
import com.tungtt.sdktest.fb.MiniPlayerSettingActivity;
import com.tungtt.sdktest.slide.Slide0Activity;
import com.tungtt.sdktest.SlideCustomUZTime.SlideWithCustomUZTime;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_play_any_link).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, PlayerActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.bt_uiza_custom_skin_u_tube).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, CustomSkinCodeUZTimebarUTubeActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.bt_uiza_custom_skin_u_tube_with_slide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, CustomSkinCodeUZTimebarUTubeWithSlideActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.bt_uiza_custom_skin_xml).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, CustomSkinXMLActivity.class);
                intent.putExtra(Constants.KEY_UIZA_ENTITY_ID, LSApplication.entityIdDefaultVOD);
                startActivity(intent);
            }
        });
        findViewById(R.id.bt_uiza_custom_skin_code_seekbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, CustomSkinCodeSeekbarActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.bt_uiza_custom_skin_code_uz_timebar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, CustomSkinCodeUZTimebarActivity.class);
                intent.putExtra(Constants.KEY_UIZA_ENTITY_ID, LSApplication.entityIdDefaultVOD);
                //intent.putExtra(Constants.KEY_UIZA_THUMBNAIL, LSApplication.thumbEntityIdDefaultVOD);
                startActivity(intent);
            }
        });
        findViewById(R.id.bt_mini_fb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, FBListVideoActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.bt_slide_0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(activity, Slide0Activity.class);
                intent.putExtra(Constants.KEY_UIZA_ENTITY_ID, LSApplication.entityIdDefaultVOD);
                //intent.putExtra(Constants.KEY_UIZA_METADATA_ENTITY_ID, LSApplication.metadataDefault0);
                startActivity(intent);
            }
        });
//        findViewById(R.id.bt_slidetimebar).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final Intent intent = new Intent(activity, SlideWithCustomUZTimeentityIdDefaultVOD.class);
//                intent.putExtra(Constants.KEY_UIZA_ENTITY_ID, LSApplication.entityIdDefaultVOD);
//                //intent.putExtra(Constants.KEY_UIZA_METADATA_ENTITY_ID, LSApplication.metadataDefault0);
//                startActivity(intent);
//            }
//        });
        if (LSApplication.DF_DOMAIN_API.equals("input")) {
            showDialogInitWorkspace();
        }
    }

    private void showDialogInitWorkspace() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage("Please correct your workspace's information first..");
        builder.setCancelable(false);
        builder.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        onBackPressed();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
