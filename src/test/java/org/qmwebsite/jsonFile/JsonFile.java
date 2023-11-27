package org.qmwebsite.jsonFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.IOException;

@Getter
public class JsonFile {
    private Page pages;
    private Url links;
    private Url urls;
    private Url urlOnBlogsQualityHeroesDE;
    private Url urlOnBlogsIWantChangeDE;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void readFileWithAllUrl(String path) throws IOException {

        pages = objectMapper.readValue(new java.io.File(path), Page.class);
    }

    public void readFileWithAllLinksOnPages(String path) throws IOException {

        links = objectMapper.readValue(new java.io.File(path), Url.class);
    }
}
