package inf.puc.rio.br.opus.model.smell;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import inf.puc.rio.br.opus.model.smell.organic.Metrics;
import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.Map;

public class CodeSmell {

    private String smellId;
    private String name;
    private String projectName;
    private String codeElement;
    private String detectorName;
    private String details;
    private String commit;
    private Metrics metrics;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public CodeSmell(String smellId,
                     String name,
                     String projectName,
                     String codeElement,
                     String commit,
                     String detectorName,
                     String details,
                     Metrics metrics) {
        this.smellId = smellId;
        this.name = name;
        this.projectName = projectName;
        this.codeElement = codeElement;
        this.commit = commit;
        this.detectorName = detectorName;
        this.details = details;
        this.metrics = metrics;
    }

    public CodeSmell(){

    }

    public String getSmellId() {
        return smellId;
    }

    public void setSmellId(String smellId) {
        this.smellId = smellId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCodeElement() {
        return codeElement;
    }

    public void setCodeElement(String codeElement) {
        this.codeElement = codeElement;
    }

    public String getDetectorName() {
        return detectorName;
    }

    public void setDetectorName(String detectorName) {
        this.detectorName = detectorName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCommit() {
        return commit;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }

    public Metrics getMetrics() {
        return metrics;
    }

    public void setMetrics(Metrics metrics) {
        this.metrics = metrics;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
