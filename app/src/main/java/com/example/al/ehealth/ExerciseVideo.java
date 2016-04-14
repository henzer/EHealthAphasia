package com.example.al.ehealth;

import java.util.List;

public class ExerciseVideo {
    private int video;
    private String correct;
    private List<String> options;

    public ExerciseVideo(int video, String correct, List<String> options) {
        this.video = video;
        this.correct = correct;
        this.options = options;
    }

    public ExerciseVideo() {
    }

    public int getVideo() {
        return video;
    }

    public void setVideo(int video) {
        this.video = video;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
