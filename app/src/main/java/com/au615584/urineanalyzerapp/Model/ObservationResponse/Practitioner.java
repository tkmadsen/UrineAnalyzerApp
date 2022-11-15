
package com.au615584.urineanalyzerapp.Model.ObservationResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Practitioner {

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("meta")
    @Expose
    private Meta__3 meta;
    @SerializedName("identifier")
    @Expose
    private List<Identifier__1> identifier = null;
    @SerializedName("name")
    @Expose
    private Name name;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Meta__3 getMeta() {
        return meta;
    }

    public void setMeta(Meta__3 meta) {
        this.meta = meta;
    }

    public List<Identifier__1> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(List<Identifier__1> identifier) {
        this.identifier = identifier;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

}
