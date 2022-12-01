package com.example.lastquiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class VideoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video,container,false);

        VideoView videoView = view.findViewById(R.id.videoView);
        videoView.setVideoPath("https://dl8.webmfiles.org/big-buck-bunny_trailer.webm");
        videoView.start();

        return view;
    }
}
