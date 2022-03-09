package homework7.yandex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "1",
        "3",
        "7"
})

public class Accum_prec {

    @JsonProperty("1")
    private float one;
    @JsonProperty("3")
    private float three;
    @JsonProperty("7")
    private float seven;

    @JsonProperty("1")
    public float get1() {
        return one;
    }
    @JsonProperty("1")
    public void set1(float one) {
        this.one = one;
    }

    @JsonProperty("3")
    public float get3() {
        return three;
    }
    @JsonProperty("3")
    public void set3(float three) {
        this.three = three;
    }

    @JsonProperty("7")
    public float get7() {
        return seven;
    }
    @JsonProperty("7")
    public void set7(float seven) {
        this.seven = seven;
    }
}
