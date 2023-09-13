package org.qmwebsite.jsonFile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class Page {
    private @JsonProperty("pages") List<UrlModel> urlModelList;

    public Page (List<UrlModel> urlModelList){
        this.urlModelList = urlModelList;
    }

    public Page(){}
}
