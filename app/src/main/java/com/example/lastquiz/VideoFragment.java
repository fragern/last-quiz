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
        videoView.setVideoPath("https://file-examples.com/storage/fe19e1a6e563854389e633c/2017/04/file_example_MP4_640_3MG.mp4");
        videoView.start();

        return view;
    }
}
