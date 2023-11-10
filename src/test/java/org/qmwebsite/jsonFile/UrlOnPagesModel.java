package org.qmwebsite.jsonFile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlOnPagesModel {
    @JsonProperty("name")
    private String name;

    @JsonProperty("pageAddress")
    private String pageAddress;

    @JsonProperty("xpath")
    private String xpath;

    @JsonProperty("tabName")
    private String tabName;

    @JsonProperty("PageOpenInNewTab")
    private Boolean PageOpenInNewTab;

}
