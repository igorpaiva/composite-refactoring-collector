
package inf.puc.rio.br.opus.model.smell.organic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "methods",
    "sourceFile",
    "metricsValues",
    "fullyQualifiedName",
    "smells"
})
public class OuputOrganic {

    @JsonProperty("methods")
    private List<MethodOrganic> methods = null;
    @JsonProperty("sourceFile")
    private SourceFileOrganicDTO sourceFile;
    @JsonProperty("metricsValues")
    private Metrics metricsValues;
    @JsonProperty("fullyQualifiedName")
    private String fullyQualifiedName;
    @JsonProperty("smells")
    private List<CodeSmellOrganic> smells = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("methods")
    public List<MethodOrganic> getMethods() {
        return methods;
    }

    @JsonProperty("methods")
    public void setMethods(List<MethodOrganic> methods) {
        this.methods = methods;
    }

    @JsonProperty("sourceFile")
    public SourceFileOrganicDTO getSourceFile() {
        return sourceFile;
    }

    @JsonProperty("sourceFile")
    public void setSourceFile(SourceFileOrganicDTO sourceFile) {
        this.sourceFile = sourceFile;
    }

    @JsonProperty("metricsValues")
    public Metrics getMetricsValues() {
        return metricsValues;
    }

    @JsonProperty("metricsValues")
    public void setMetricsValues(Metrics metricsValues) {
        this.metricsValues = metricsValues;
    }

    @JsonProperty("fullyQualifiedName")
    public String getFullyQualifiedName() {
        return fullyQualifiedName;
    }

    @JsonProperty("fullyQualifiedName")
    public void setFullyQualifiedName(String fullyQualifiedName) {
        this.fullyQualifiedName = fullyQualifiedName;
    }

    @JsonProperty("smells")
    public List<CodeSmellOrganic> getSmells() {
        return smells;
    }

    @JsonProperty("smells")
    public void setSmells(List<CodeSmellOrganic> smells) {
        this.smells = smells;
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
