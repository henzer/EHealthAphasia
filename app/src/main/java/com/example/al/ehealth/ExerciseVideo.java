package com.example.al.ehealth;

import java.util.List;

public class ExerciseVideo {
    private String video;
    private String correct;
    private List<String> options;

    public ExerciseVideo(String video, String correct, List<String> options) {
        this.video = video;
        this.correct = correct;
        this.options = options;
    }

    public ExerciseVideo() {
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
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
