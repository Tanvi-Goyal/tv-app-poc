
package com.embibe.app.embibetvapp.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetSearchResponse {

    @SerializedName("count_all_widgets")
    @Expose
    private Integer countAllWidgets;
    @SerializedName("count_overall")
    @Expose
    private Integer countOverall;
    @SerializedName("count_results")
    @Expose
    private Integer countResults;
    @SerializedName("count_suggestions")
    @Expose
    private Integer countSuggestions;
    @SerializedName("current_exam")
    @Expose
    private String currentExam;
    @SerializedName("current_goal")
    @Expose
    private String currentGoal;
    @SerializedName("disambiguation")
    @Expose
    private Disambiguation disambiguation;
    @SerializedName("dym")
    @Expose
    private Dym dym;
    @SerializedName("related_searches")
    @Expose
    private List<Object> relatedSearches = null;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("suggestions")
    @Expose
    private List<Suggestion> suggestions = null;
    @SerializedName("valid_exams")
    @Expose
    private List<String> validExams = null;
    @SerializedName("valid_goals")
    @Expose
    private List<String> validGoals = null;
    @SerializedName("test_practice_xpaths")
    @Expose
    private TestPracticeXpaths testPracticeXpaths;
    @SerializedName("gsv")
    @Expose
    private String gsv;
    @SerializedName("search_query")
    @Expose
    private String searchQuery;

    public Integer getCountAllWidgets() {
        return countAllWidgets;
    }

    public void setCountAllWidgets(Integer countAllWidgets) {
        this.countAllWidgets = countAllWidgets;
    }

    public Integer getCountOverall() {
        return countOverall;
    }

    public void setCountOverall(Integer countOverall) {
        this.countOverall = countOverall;
    }

    public Integer getCountResults() {
        return countResults;
    }

    public void setCountResults(Integer countResults) {
        this.countResults = countResults;
    }

    public Integer getCountSuggestions() {
        return countSuggestions;
    }

    public void setCountSuggestions(Integer countSuggestions) {
        this.countSuggestions = countSuggestions;
    }

    public String getCurrentExam() {
        return currentExam;
    }

    public void setCurrentExam(String currentExam) {
        this.currentExam = currentExam;
    }

    public String getCurrentGoal() {
        return currentGoal;
    }

    public void setCurrentGoal(String currentGoal) {
        this.currentGoal = currentGoal;
    }

    public Disambiguation getDisambiguation() {
        return disambiguation;
    }

    public void setDisambiguation(Disambiguation disambiguation) {
        this.disambiguation = disambiguation;
    }

    public Dym getDym() {
        return dym;
    }

    public void setDym(Dym dym) {
        this.dym = dym;
    }

    public List<Object> getRelatedSearches() {
        return relatedSearches;
    }

    public void setRelatedSearches(List<Object> relatedSearches) {
        this.relatedSearches = relatedSearches;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Suggestion> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }

    public List<String> getValidExams() {
        return validExams;
    }

    public void setValidExams(List<String> validExams) {
        this.validExams = validExams;
    }

    public List<String> getValidGoals() {
        return validGoals;
    }

    public void setValidGoals(List<String> validGoals) {
        this.validGoals = validGoals;
    }

    public TestPracticeXpaths getTestPracticeXpaths() {
        return testPracticeXpaths;
    }

    public void setTestPracticeXpaths(TestPracticeXpaths testPracticeXpaths) {
        this.testPracticeXpaths = testPracticeXpaths;
    }

    public String getGsv() {
        return gsv;
    }

    public void setGsv(String gsv) {
        this.gsv = gsv;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

}
