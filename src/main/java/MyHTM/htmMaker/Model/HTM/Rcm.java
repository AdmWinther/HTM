package MyHTM.htmMaker.Model.HTM;

import MyHTM.htmMaker.Model.Util.Util.ID;

public class Rcm {
    //This class is presenting the Risk Control Measures.
    private final String id;
    private final String projectId;
    private String RcmNumber;
    private RcmTypeEnum rcmType;
    private String description;
    private String implementation;
    private String verification;

    public Rcm(String projectId, String rcmNumber, RcmTypeEnum rcmType, String description, String implementation, String verification) {
        this.id = new ID().getId();
        this.projectId = projectId;
        this.RcmNumber = rcmNumber;
        this.rcmType = rcmType;
        this.description = description;
        this.implementation = implementation;
        this.verification = verification;
    }

    public String getRcmNumber() {
        return RcmNumber;
    }

    public void setRcmNumber(String rcmNumber) {
        RcmNumber = rcmNumber;
    }

    public RcmTypeEnum getRcmType() {
        return rcmType;
    }

    public void setRcmType(RcmTypeEnum rcmType) {
        this.rcmType = rcmType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImplementation() {
        return implementation;
    }

    public void setImplementation(String implementation) {
        this.implementation = implementation;
    }

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getId() {
        return id;
    }
}
