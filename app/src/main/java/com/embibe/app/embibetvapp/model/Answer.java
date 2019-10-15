package com.embibe.app.embibetvapp.model;

import com.google.gson.annotations.SerializedName;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Answer implements Comparable<Answer> {

    @Id(assignable = true)
    public long id;

    @SerializedName("code")
    public String code;

    @SerializedName("correct")
    public Boolean correct;

    @SerializedName("position")
    public Integer position;

    @SerializedName("body")
    public String body;

    @SerializedName("explanation")
    public String explanation;

    public Answer() {
    }

    public Answer(String code) {
        this.code = code;
    }

    public Answer(String code, boolean correct, int position, String body, String explanation) {
        this.code = code;
        this.correct = correct;
        this.position = position;
        this.body = body;
        this.explanation = explanation;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Answer) {
            return this.code.equals(((Answer) obj).code);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "code='" + code + '\'' +
                ", correct=" + correct +
                ", position=" + position +
                ", body='" + body + '\'' +
                ", explanation='" + explanation + '\'' +
                '}';
    }

    @Override
    public int compareTo(Answer answer) {
        if (this.position < answer.position)
            return -1;
        else if (this.position > answer.position) {
            return 1;
        }
        return 0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
