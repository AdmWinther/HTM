package MyHTM.htmMaker.Model.HTM;

import MyHTM.htmMaker.Model.Util.Util.ID;

public class Harm {
    private final String harmId;
    private final String projectId;
    private String harmName;
    private String harmDescription;
    private HarmSeverity harmSeverity;

    public Harm(String projectId, String harmName, String harmDescription, HarmSeverity harmSeverity) {
        this.projectId = projectId;
        this.harmId = new ID().getId();
        this.harmName = harmName;
        this.harmDescription = harmDescription;
        this.harmSeverity = harmSeverity;
    }


    public String getHarmDescription() {
        return harmDescription;
    }

    public void setHarmDescription(String harmDescription) {
        this.harmDescription = harmDescription;
    }

    public String getHarmName() {
        return harmName;
    }

    public void setHarmName(String harmName) {
        this.harmName = harmName;
    }

    public String getHarmId() {
        return harmId;
    }

    public String getProjectId() {
        return projectId;
    }

    public HarmSeverity getHarmSeverity() {
        return harmSeverity;
    }

    public void setHarmSeverity(HarmSeverity harmSeverity) {
        this.harmSeverity = harmSeverity;
    }
}
