package org.qmwebsite.jsonFile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class Url {
    private @JsonProperty("pages") List<UrlOnPagesModel> urlOnPagesModelList;

    public Url (List<UrlOnPagesModel> urlOnPagesModelList){

        this.urlOnPagesModelList = urlOnPagesModelList;
    }


    public Url(){}
}

