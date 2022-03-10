package homework7.weatherYandex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "district",
        "locality",
        "province",
        "country"
})

public class Geo_object {

    private GeoIdName district;
    private GeoIdName locality;
    private GeoIdName province;
    private GeoIdName country;

    public GeoIdName getDistrict() {
        return district;
    }
    public void setDistrict(GeoIdName value) {
        this.district = value;
    }

    public GeoIdName getLocality() {
        return locality;
    }
    public void setLocality(GeoIdName value) {
        this.locality = value;
    }

    public GeoIdName getProvince() {
        return province;
    }
    public void setProvince(GeoIdName value) {
        this.province = value;
    }

    public GeoIdName getCountry() {
        return country;
    }
    public void setCountry(GeoIdName value) {
        this.country = value;
    }
}
