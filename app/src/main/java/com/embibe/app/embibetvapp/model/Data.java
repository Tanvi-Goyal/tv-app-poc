
package com.embibe.app.embibetvapp.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("status_code")
    @Expose
    private String statusCode;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("clean_title")
    @Expose
    private String cleanTitle;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("relevant_exams")
    @Expose
    private List<String> relevantExams = null;
    @SerializedName("relevant_skills")
    @Expose
    private List<String> relevantSkills = null;
    @SerializedName("cheat_sheets")
    @Expose
    private Object cheatSheets;
    @SerializedName("breadcrumb")
    @Expose
    private List<Breadcrumb> breadcrumb = null;
    @SerializedName("learning_map")
    @Expose
    private LearningMap learningMap;
    @SerializedName("siblings_data")
    @Expose
    private List<SiblingsDatum> siblingsData = null;
    @SerializedName("questions_rankers_got_wrong")
    @Expose
    private QuestionsRankersGotWrong questionsRankersGotWrong;
    @SerializedName("top_prev_year_question")
    @Expose
    private TopPrevYearQuestion topPrevYearQuestion;
    @SerializedName("challenging_questions")
    @Expose
    private ChallengingQuestions challengingQuestions;
    @SerializedName("chapters_in_unit")
    @Expose
    private List<ChaptersInUnit> chaptersInUnit = null;
    @SerializedName("available_tests")
    @Expose
    private AvailableTests availableTests;
    @SerializedName("available_practice")
    @Expose
    private Object availablePractice;
    @SerializedName("seo_subject_name")
    @Expose
    private String seoSubjectName;
    @SerializedName("wiki_friendly_name")
    @Expose
    private String wikiFriendlyName;
    @SerializedName("kt_data")
    @Expose
    private KtData ktData;
    @SerializedName("video_data")
    @Expose
    private List<VideoDatum> videoData = null;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCleanTitle() {
        return cleanTitle;
    }

    public void setCleanTitle(String cleanTitle) {
        this.cleanTitle = cleanTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getRelevantExams() {
        return relevantExams;
    }

    public void setRelevantExams(List<String> relevantExams) {
        this.relevantExams = relevantExams;
    }

    public List<String> getRelevantSkills() {
        return relevantSkills;
    }

    public void setRelevantSkills(List<String> relevantSkills) {
        this.relevantSkills = relevantSkills;
    }

    public Object getCheatSheets() {
        return cheatSheets;
    }

    public void setCheatSheets(Object cheatSheets) {
        this.cheatSheets = cheatSheets;
    }

    public List<Breadcrumb> getBreadcrumb() {
        return breadcrumb;
    }

    public void setBreadcrumb(List<Breadcrumb> breadcrumb) {
        this.breadcrumb = breadcrumb;
    }

    public LearningMap getLearningMap() {
        return learningMap;
    }

    public void setLearningMap(LearningMap learningMap) {
        this.learningMap = learningMap;
    }

    public List<SiblingsDatum> getSiblingsData() {
        return siblingsData;
    }

    public void setSiblingsData(List<SiblingsDatum> siblingsData) {
        this.siblingsData = siblingsData;
    }

    public QuestionsRankersGotWrong getQuestionsRankersGotWrong() {
        return questionsRankersGotWrong;
    }

    public void setQuestionsRankersGotWrong(QuestionsRankersGotWrong questionsRankersGotWrong) {
        this.questionsRankersGotWrong = questionsRankersGotWrong;
    }

    public TopPrevYearQuestion getTopPrevYearQuestion() {
        return topPrevYearQuestion;
    }

    public void setTopPrevYearQuestion(TopPrevYearQuestion topPrevYearQuestion) {
        this.topPrevYearQuestion = topPrevYearQuestion;
    }

    public ChallengingQuestions getChallengingQuestions() {
        return challengingQuestions;
    }

    public void setChallengingQuestions(ChallengingQuestions challengingQuestions) {
        this.challengingQuestions = challengingQuestions;
    }

    public List<ChaptersInUnit> getChaptersInUnit() {
        return chaptersInUnit;
    }

    public void setChaptersInUnit(List<ChaptersInUnit> chaptersInUnit) {
        this.chaptersInUnit = chaptersInUnit;
    }

    public AvailableTests getAvailableTests() {
        return availableTests;
    }

    public void setAvailableTests(AvailableTests availableTests) {
        this.availableTests = availableTests;
    }

    public Object getAvailablePractice() {
        return availablePractice;
    }

    public void setAvailablePractice(Object availablePractice) {
        this.availablePractice = availablePractice;
    }

    public String getSeoSubjectName() {
        return seoSubjectName;
    }

    public void setSeoSubjectName(String seoSubjectName) {
        this.seoSubjectName = seoSubjectName;
    }

    public String getWikiFriendlyName() {
        return wikiFriendlyName;
    }

    public void setWikiFriendlyName(String wikiFriendlyName) {
        this.wikiFriendlyName = wikiFriendlyName;
    }

    public KtData getKtData() {
        return ktData;
    }

    public void setKtData(KtData ktData) {
        this.ktData = ktData;
    }

    public List<VideoDatum> getVideoData() {
        return videoData;
    }

    public void setVideoData(List<VideoDatum> videoData) {
        this.videoData = videoData;
    }

}
