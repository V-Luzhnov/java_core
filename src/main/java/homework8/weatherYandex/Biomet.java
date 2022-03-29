package homework8.weatherYandex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "index",
        "condition"
})

public class Biomet {

    private long index;
    private String condition;

    public long getIndex() { return index; }
    public void setIndex(long value) { this.index = value; }

    public String getCondition() { return condition; }
    public void setCondition(String value) { this.condition = value; }
}
