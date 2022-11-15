
package com.au615584.urineanalyzerapp.Model.ObservationResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProcedureRequest {

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("meta")
    @Expose
    private Meta__2 meta;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("intent")
    @Expose
    private String intent;
    @SerializedName("code")
    @Expose
    private Code code;

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

    public Meta__2 getMeta() {
        return meta;
    }

    public void setMeta(Meta__2 meta) {
        this.meta = meta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

}
