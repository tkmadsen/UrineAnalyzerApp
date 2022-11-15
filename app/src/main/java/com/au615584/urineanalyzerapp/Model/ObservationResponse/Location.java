
package com.au615584.urineanalyzerapp.Model.ObservationResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("meta")
    @Expose
    private Meta__1 meta;
    @SerializedName("identifier")
    @Expose
    private List<Identifier> identifier = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private Type type;

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

    public Meta__1 getMeta() {
        return meta;
    }

    public void setMeta(Meta__1 meta) {
        this.meta = meta;
    }

    public List<Identifier> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(List<Identifier> identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
