
package com.test.gen;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "FaultId",
    "fault"
})
public class Fault {

    @JsonProperty("FaultId")
    private String faultId;
    @JsonProperty("fault")
    private String fault;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("FaultId")
    public String getFaultId() {
        return faultId;
    }

    @JsonProperty("FaultId")
    public void setFaultId(String faultId) {
        this.faultId = faultId;
    }

    @JsonProperty("fault")
    public String getFault() {
        return fault;
    }

    @JsonProperty("fault")
    public void setFault(String fault) {
        this.fault = fault;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(faultId).append(fault).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Fault) == false) {
            return false;
        }
        Fault rhs = ((Fault) other);
        return new EqualsBuilder().append(faultId, rhs.faultId).append(fault, rhs.fault).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
