package com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.R;

/**
 * Created by oswaldosaldivar on 31/05/16.
 */
public class Comentarios extends Fragment {
    VideoView videoView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.comentarios, container, false);
        videoView = (VideoView)view.findViewById(R.id.video);
        //videoView = (VideoView)view.findViewById(R.id.video);
        Uri uri = Uri.parse("http://techslides.com/demos/sample-videos/small.mp4");

        videoView.setMediaController(new MediaController(getContext()));

        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
        return view;
    }
}
