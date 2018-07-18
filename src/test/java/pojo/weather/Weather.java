
package pojo.weather;

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
    private String City;
    @JsonProperty("Temperature")
    private String Temperature;
    @JsonProperty("Humidity")
    private String Humidity;
    @JsonProperty("WeatherDescription")
    private String WeatherDescription;
    @JsonProperty("WindSpeed")
    private String WindSpeed;
    @JsonProperty("WindDirectionDegree")
    private String WindDirectionDegree;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("City")
    public String getCity() {
        return City;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.City = city;
    }

    @JsonProperty("Temperature")
    public String getTemperature() {
        return Temperature;
    }

    @JsonProperty("Temperature")
    public void setTemperature(String temperature) {
        this.Temperature = temperature;
    }

    @JsonProperty("Humidity")
    public String getHumidity() {
        return Humidity;
    }

    @JsonProperty("Humidity")
    public void setHumidity(String humidity) {
        this.Humidity = humidity;
    }

    @JsonProperty("WeatherDescription")
    public String getWeatherDescription() {
        return WeatherDescription;
    }

    @JsonProperty("WeatherDescription")
    public void setWeatherDescription(String weatherDescription) {
        this.WeatherDescription = weatherDescription;
    }

    @JsonProperty("WindSpeed")
    public String getWindSpeed() {
        return WindSpeed;
    }

    @JsonProperty("WindSpeed")
    public void setWindSpeed(String windSpeed) {
        this.WindSpeed = windSpeed;
    }

    @JsonProperty("WindDirectionDegree")
    public String getWindDirectionDegree() {
        return WindDirectionDegree;
    }

    @JsonProperty("WindDirectionDegree")
    public void setWindDirectionDegree(String windDirectionDegree) {
        this.WindDirectionDegree = windDirectionDegree;
    }

    @Override
    public String toString() {
        //return ToStringBuilder.reflectionToString(this);
    	return "Weather: [City=" + City + ", Temperature=" + Temperature + ", Humidity=" + Humidity + ", WeatherDescription=" + WeatherDescription +
        ", WindSpeed=" + WindSpeed + ", WindDirectionDegree=" + WindDirectionDegree + ", additionalProperties" + additionalProperties + "]";
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
        return new HashCodeBuilder().append(City).append(Temperature).append(Humidity).append(WeatherDescription).append(WindSpeed).append(WindDirectionDegree).append(additionalProperties).toHashCode();
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
        return new EqualsBuilder().append(City, rhs.City).append(Temperature, rhs.Temperature).append(Humidity, rhs.Humidity).append(WeatherDescription, rhs.WeatherDescription).append(WindSpeed, rhs.WindSpeed).append(WindDirectionDegree, rhs.WindDirectionDegree).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
