//package MyHTM.htmMaker.Model.HTM;
//
//import MyHTM.htmMaker.Model.Util.Util.ID;
//
//import java.util.ArrayList;
//import java.util.Objects;
//
//public class Risk {
//    private final String id;
//    private final String projectId;
//    private String riskNumber;
//    private String Scenario;
//    private String hazardousSituation;
//    private Harm harmBefore;  //Severity is identified based on Harm
//    private ProbOfOccurrence probOfOccurrenceBefore;
//    private RiskValue riskValueBefore; //if harmBefore or probOfOccurrenceBefore is changed, riskValueBefore should be updated
//    private String rcmRationale;
//    private ArrayList<String> rcmIds;
//    private Harm harmAfter;  //Severity is identified based on Harm
//    private ProbOfOccurrence probOfOccurrenceAfter;
//    private RiskValue riskValueAfter;   //if harmAfter or probOfOccurrenceAfter is changed, riskValueAfter should be updated
//    private boolean completed;
//
//    public Risk(String projectId) {
//        this.id = new ID().getId();
//        this.projectId = projectId;
//    }
//
//    public Risk(String projectId, String riskNumber) {
//        this(projectId);
//        this.riskNumber = riskNumber;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getProjectId() {
//        return projectId;
//    }
//
//    public String getRiskNumber() {
//        return riskNumber;
//    }
//
//    public void setRiskNumber(String riskNumber) {
//        this.riskNumber = riskNumber;
//    }
//
//    public String getScenario() {
//        return Scenario;
//    }
//
//    public void setScenario(String scenario) {
//        Scenario = scenario;
//    }
//
//    public String getHazardousSituation() {
//        return hazardousSituation;
//    }
//
//    public Harm getHarmBefore() {
//        return harmBefore;
//    }
//
//    public void setHarmBefore(Harm harmBefore) {
//        this.harmBefore = harmBefore;
//    }
//
//    public ProbOfOccurrence getProbOfOccurrenceBefore() {
//        return probOfOccurrenceBefore;
//    }
//
//    public void setProbOfOccurrenceBefore(ProbOfOccurrence probOfOccurrenceBefore) {
//        this.probOfOccurrenceBefore = probOfOccurrenceBefore;
//    }
//
//    public String getRcmRationale() {
//        return rcmRationale;
//    }
//
//    public void setRcmRationale(String rcmRationale) {
//        this.rcmRationale = rcmRationale;
//    }
//
//    public ArrayList<String> getRcmIds() {
//        return rcmIds;
//    }
//
//    public Harm getHarmAfter() {
//        return harmAfter;
//    }
//
//    public void setHarmAfter(Harm harmAfter) {
//        this.harmAfter = harmAfter;
//    }
//
//    public ProbOfOccurrence getProbOfOccurrenceAfter() {
//        return probOfOccurrenceAfter;
//    }
//
//    public void setProbOfOccurrenceAfter(ProbOfOccurrence probOfOccurrenceAfter) {
//        this.probOfOccurrenceAfter = probOfOccurrenceAfter;
//    }
//
//    public RiskValue getRiskValueAfter() {
//        return riskValueAfter;
//    }
//
//    public RiskValue getRiskValueBefore() {
//        return riskValueBefore;
//    }
//
//    public boolean isCompleted() {
//        return completed;
//    }
//
//    public void setCompleted(boolean completed) {
//        this.completed = completed;
//    }
//
//    public void addRCM(Rcm rcm) {
//        //add rcm to the risk
//        Objects.requireNonNull(rcm, "RCM cannot be null");
//        if(rcmIds == null) {
//            rcmIds = new ArrayList<String>();
//        }
//        rcmIds.add(rcm.getId());
//    }
//}
