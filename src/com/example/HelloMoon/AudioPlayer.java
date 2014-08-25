package com.example.HelloMoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by lee on 2014/8/21.
 * 媒体播放类
 */
public class AudioPlayer {
    private MediaPlayer mPlayer;

    public void stop(){
        if (mPlayer!=null){
            //mPlayer.stop();
            mPlayer.release();
            mPlayer=null;
        }
    }

    //开始播放,如果不为空,则为是恢复播放
    public void play(Context c){

        if(mPlayer==null) {
            mPlayer = MediaPlayer.create(c, R.raw.one_small_step);

            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stop();
                }
            });
        }
        mPlayer.start();
    }

    public void pause(){
        if (mPlayer.isPlaying())
            mPlayer.pause();

    }


}
