package com.example.HelloMoon;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by lee on 2014/8/21.
 * 用户界面
 */
public class HelloMoonFragment extends Fragment {

    private AudioPlayer mPlayer=new AudioPlayer();
    private Button mPlayButton;
    private Button mStopButton;
    private Button mPauseButton;
    //private VideoView mVideoView;
    //播放视频要用mp4格式
    //private Uri uri= Uri.parse("android.resource://" + "com.example.HelloMoon/raw/apollo_17_stroll");

    //public static final String TAG="HelloMoonFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //保存Fragment实例
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v=inflater.inflate(R.layout.hellomoon_fragment,container,false);
        mPlayButton =(Button)v.findViewById(R.id.playButton);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.play(getActivity());
                //mVideoView.requestFocus();
                //mVideoView.start();
            }
        });

        mPauseButton=(Button)v.findViewById(R.id.pauseButton);
        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayer.pause();
            }
        });

        mStopButton =(Button)v.findViewById(R.id.stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
            }
        });
        /*
        播放视频
        mVideoView=(VideoView)v.findViewById(R.id.moon_VideoView);
        MediaController mMediaController=new MediaController(getActivity());
        mVideoView.setMediaController(mMediaController);
        mVideoView.setVideoURI(uri);
        */



        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }
}
