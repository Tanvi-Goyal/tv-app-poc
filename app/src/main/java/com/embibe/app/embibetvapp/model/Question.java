package com.embibe.app.embibetvapp.model;

import com.embibe.app.embibetvapp.model.convertor.AnswerConverter;
import com.embibe.app.embibetvapp.model.convertor.HintsConverter;
import com.embibe.app.embibetvapp.model.convertor.TipsConverter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.NameInDb;
import io.objectbox.relation.ToOne;

@Entity
public class Question {
    @Id
    public long q_id = 0;

    @NameInDb("question_id")
    @SerializedName("question_id")
    public Integer questionId;

    @NameInDb("test_id")
    public Integer testId;

    @NameInDb("practice_id")
    public Integer practiceId;

    @NameInDb("question_code")
    @SerializedName("question_code")
    public String questionCode;

    @NameInDb("locale")
    @SerializedName("locale")
    public String locale;

    @NameInDb("version")
    @SerializedName("version")
    public Integer version;

    @NameInDb("category")
    @SerializedName("category")
    public String category;

    @NameInDb("purpose")
    @SerializedName("purpose")
    public String purpose;

    @NameInDb("difficulty")
    @SerializedName("difficulty")
    public Integer difficulty;

    @NameInDb("ideal_time")
    @SerializedName("ideal_time")
    public Integer idealTime;

    @NameInDb("section_id")
    @SerializedName("section_id")
    public Integer sectionId;

    @NameInDb("sequence_number")
    @SerializedName("sequence_number")
    public Integer sequenceNumber;

    @NameInDb("skill_type")
    @SerializedName("skill_type")
    public String skillType;

    @NameInDb("jumbled_sequence")
    @SerializedName("jumbled_sequence")
    public Integer jumbledSequence;

    @NameInDb("body")
    @SerializedName("body")
    public String body;

    @NameInDb("answers")
    @Convert(converter = AnswerConverter.class, dbType = String.class)
    public List<Answer> answers;

    @NameInDb("hints")
    @Convert(converter = HintsConverter.class, dbType = String.class)
    public List<Hint> hints;

    @NameInDb("tips")
    @Convert(converter = TipsConverter.class, dbType = String.class)
    public List<Tips> tips;

    @NameInDb("explanation")
    @SerializedName("explanation")
    public String explanation;

    @NameInDb("video_url")
    @SerializedName("video_url")
    public String videoURL;

    @NameInDb("pmarks")
    @SerializedName("pmarks")
    public Double pmarks = 0.0;

    @NameInDb("nmarks")
    @SerializedName("nmarks")
    public Double nmarks = 0.0;

    @NameInDb("chapter")
    @SerializedName("chapter")
    public String chapter;

    public ToOne<Anotation> anotation;

    public Question() {
    }


    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(Integer practiceId) {
        this.practiceId = practiceId;
    }

    public String getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getIdealTime() {
        return idealTime;
    }

    public void setIdealTime(Integer idealTime) {
        this.idealTime = idealTime;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Hint> getHints() {
        return hints;
    }

    public void setHints(List<Hint> hints) {
        this.hints = hints;
    }

    public List<Tips> getTips() {
        return tips;
    }

    public void setTips(List<Tips> tips) {
        this.tips = tips;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public Double getPmarks() {
        return pmarks;
    }

    public void setPmarks(Double pmarks) {
        this.pmarks = pmarks;
    }

    public Double getNmarks() {
        return nmarks;
    }

    public void setNmarks(Double nmarks) {
        this.nmarks = nmarks;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public Integer getJumbledSequence() {
        return jumbledSequence;
    }

    public void setJumbledSequence(Integer jumbledSequence) {
        this.jumbledSequence = jumbledSequence;
    }
}
