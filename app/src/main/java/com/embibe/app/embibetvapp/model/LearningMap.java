
package com.embibe.app.embibetvapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LearningMap {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("goal_code")
    @Expose
    private String goalCode;
    @SerializedName("exam_code")
    @Expose
    private String examCode;
    @SerializedName("subject_code")
    @Expose
    private String subjectCode;
    @SerializedName("unit_code")
    @Expose
    private String unitCode;
    @SerializedName("chapter_code")
    @Expose
    private String chapterCode;
    @SerializedName("old_goal_id")
    @Expose
    private String oldGoalId;
    @SerializedName("old_exam_id")
    @Expose
    private String oldExamId;
    @SerializedName("old_subject_id")
    @Expose
    private String oldSubjectId;
    @SerializedName("old_unit_id")
    @Expose
    private String oldUnitId;
    @SerializedName("old_chapter_id")
    @Expose
    private String oldChapterId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGoalCode() {
        return goalCode;
    }

    public void setGoalCode(String goalCode) {
        this.goalCode = goalCode;
    }

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getChapterCode() {
        return chapterCode;
    }

    public void setChapterCode(String chapterCode) {
        this.chapterCode = chapterCode;
    }

    public String getOldGoalId() {
        return oldGoalId;
    }

    public void setOldGoalId(String oldGoalId) {
        this.oldGoalId = oldGoalId;
    }

    public String getOldExamId() {
        return oldExamId;
    }

    public void setOldExamId(String oldExamId) {
        this.oldExamId = oldExamId;
    }

    public String getOldSubjectId() {
        return oldSubjectId;
    }

    public void setOldSubjectId(String oldSubjectId) {
        this.oldSubjectId = oldSubjectId;
    }

    public String getOldUnitId() {
        return oldUnitId;
    }

    public void setOldUnitId(String oldUnitId) {
        this.oldUnitId = oldUnitId;
    }

    public String getOldChapterId() {
        return oldChapterId;
    }

    public void setOldChapterId(String oldChapterId) {
        this.oldChapterId = oldChapterId;
    }

}
