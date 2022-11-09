package com.au615584.urineanalyzerapp.Model;
import com.google.gson.annotations.SerializedName;

public class Observation {
    @SerializedName("subject")
    private String subject;

    @SerializedName("context")
    private String context;

    @SerializedName("datetime")
    private String datetime;

    @SerializedName("performer")
    private String performer;

    @SerializedName("result")
    private String result;

    public Observation(String subject, String context, String datetime, String performer, String result){
        this.subject=subject;
        this.context=context;
        this.datetime=datetime;
        this.performer=performer;
        this.result=result;
    }

    public String getSubject(){return subject;}
    public String getContext(){return context;}
    public String getDatetime(){return datetime;}
    public String getPerformer(){return performer;}
    public String getResult(){return result;}


}
