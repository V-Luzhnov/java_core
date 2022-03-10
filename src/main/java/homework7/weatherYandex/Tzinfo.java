package homework7.weatherYandex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "abbr",
        "dst",
        "offset"
})

public class Tzinfo {

    private String name;
    private String abbr;
    private boolean dst;
    private float offset;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }
    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public boolean getDst() {
        return dst;
    }
    public void setDst(boolean dst) {
        this.dst = dst;
    }

    public float getOffset() {
        return offset;
    }
    public void setOffset(float offset) {
        this.offset = offset;
    }
}
