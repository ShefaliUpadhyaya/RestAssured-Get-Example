
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
    "City",
    "Temperature",
    "Humidity",
    "WeatherDescription",
    "WindSpeed",
    "WindDirectionDegree"
})
public class Weather {

    @JsonProperty("City")
    private String city;
    @JsonProperty("Temperature")
    private String temperature;
    @JsonProperty("Humidity")
    private String humidity;
    @JsonProperty("WeatherDescription")
    private String weatherDescription;
    @JsonProperty("WindSpeed")
    private String windSpeed;
    @JsonProperty("WindDirectionDegree")
    private String windDirectionDegree;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("Temperature")
    public String getTemperature() {
        return temperature;
    }

    @JsonProperty("Temperature")
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("Humidity")
    public String getHumidity() {
        return humidity;
    }

    @JsonProperty("Humidity")
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("WeatherDescription")
    public String getWeatherDescription() {
        return weatherDescription;
    }

    @JsonProperty("WeatherDescription")
    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    @JsonProperty("WindSpeed")
    public String getWindSpeed() {
        return windSpeed;
    }

    @JsonProperty("WindSpeed")
    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    @JsonProperty("WindDirectionDegree")
    public String getWindDirectionDegree() {
        return windDirectionDegree;
    }

    @JsonProperty("WindDirectionDegree")
    public void setWindDirectionDegree(String windDirectionDegree) {
        this.windDirectionDegree = windDirectionDegree;
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
        return new HashCodeBuilder().append(city).append(temperature).append(humidity).append(weatherDescription).append(windSpeed).append(windDirectionDegree).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Weather) == false) {
            return false;
        }
        Weather rhs = ((Weather) other);
        return new EqualsBuilder().append(city, rhs.city).append(temperature, rhs.temperature).append(humidity, rhs.humidity).append(weatherDescription, rhs.weatherDescription).append(windSpeed, rhs.windSpeed).append(windDirectionDegree, rhs.windDirectionDegree).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
