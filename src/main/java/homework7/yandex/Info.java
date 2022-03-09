package homework7.yandex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "n",
        "geoid",
        "url",
        "lat",
        "lon",
        "tzinfo",
        "def_pressure_mm",
        "def_pressure_pa",
        "slug",
        "zoom",
        "nr",
        "ns",
        "nsr",
        "p",
        "f",
        "_h"
})

public class Info {

    private boolean n;
    private float geoid;
    private String url;
    private float lat;
    private float lon;
    private Tzinfo tzinfo;
    private float def_pressure_mm;
    private float def_pressure_pa;
    private String slug;
    private float zoom;
    private boolean nr;
    private boolean ns;
    private boolean nsr;
    private boolean p;
    private boolean f;
    private boolean _h;

    public boolean getN() {
        return n;
    }
    public void setN(boolean n) {
        this.n = n;
    }

    public float getGeoid() {
        return geoid;
    }
    public void setGeoid(float geoid) {
        this.geoid = geoid;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public float getLat() {
        return lat;
    }
    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }
    public void setLon(float lon) {
        this.lon = lon;
    }

    public Tzinfo getTzinfo() {
        return tzinfo;
    }
    public void setTzinfo(Tzinfo tzinfo) {
        this.tzinfo = tzinfo;
    }

    public float getDef_pressure_mm() {
        return def_pressure_mm;
    }
    public void setDef_pressure_mm(float def_pressure_mm) {
        this.def_pressure_mm = def_pressure_mm;
    }

    public float getDef_pressure_pa() {
        return def_pressure_pa;
    }
    public void setDef_pressure_pa(float def_pressure_pa) {
        this.def_pressure_pa = def_pressure_pa;
    }

    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }

    public float getZoom() {
        return zoom;
    }
    public void setZoom(float zoom) {
        this.zoom = zoom;
    }

    public boolean getNr() {
        return nr;
    }
    public void setNr(boolean nr) {
        this.nr = nr;
    }

    public boolean getNs() {
        return ns;
    }
    public void setNs(boolean ns) {
        this.ns = ns;
    }

    public boolean getNsr() {
        return nsr;
    }
    public void setNsr(boolean nsr) {
        this.nsr = nsr;
    }

    public boolean getP() {
        return p;
    }
    public void setP(boolean p) {
        this.p = p;
    }

    public boolean getF() {
        return f;
    }
    public void setF(boolean f) {
        this.f = f;
    }

    public boolean get_h() {
        return _h;
    }
    public void set_h(boolean _h) {
        this._h = _h;
    }
}
