
package com.au615584.urineanalyzerapp.Model.ObservationResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Observation {

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("contained")
    @Expose
    private List<Contained> contained = null;
    @SerializedName("extension")
    @Expose
    private List<Extension> extension = null;
    @SerializedName("identifier")
    @Expose
    private Identifier__2 identifier;
    @SerializedName("basedOn")
    @Expose
    private BasedOn basedOn;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("code")
    @Expose
    private Code__1 code;
    @SerializedName("subject")
    @Expose
    private Subject subject;
    @SerializedName("context")
    @Expose
    private Context context;
    @SerializedName("performer")
    @Expose
    private Performer performer;
    @SerializedName("component")
    @Expose
    private List<Component> component = null;

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

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Contained> getContained() {
        return contained;
    }

    public void setContained(List<Contained> contained) {
        this.contained = contained;
    }

    public List<Extension> getExtension() {
        return extension;
    }

    public void setExtension(List<Extension> extension) {
        this.extension = extension;
    }

    public Identifier__2 getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier__2 identifier) {
        this.identifier = identifier;
    }

    public BasedOn getBasedOn() {
        return basedOn;
    }

    public void setBasedOn(BasedOn basedOn) {
        this.basedOn = basedOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Code__1 getCode() {
        return code;
    }

    public void setCode(Code__1 code) {
        this.code = code;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Performer getPerformer() {
        return performer;
    }

    public void setPerformer(Performer performer) {
        this.performer = performer;
    }

    public List<Component> getComponent() {
        return component;
    }

    public void setComponent(List<Component> component) {
        this.component = component;
    }

}
