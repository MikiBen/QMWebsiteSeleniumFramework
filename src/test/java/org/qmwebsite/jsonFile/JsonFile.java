package org.qmwebsite.jsonFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.IOException;

@Getter
public class JsonFile {
    private Page pages;
    private Url urls;
    private Url urlOnBlogsQualityHeroesDE;


    private final ObjectMapper objectMapper = new ObjectMapper();
    public void readFileWithAllUrlPagesAddressDE() throws IOException {

        pages = objectMapper.readValue(new java.io.File("src/test/resources/urlPagesAddressDE.json"), Page.class);
    }
    public void readFileWithLinkOnArticlesDE() throws IOException {

        urls = objectMapper.readValue(new java.io.File("src/test/resources/linkOnArticlesDE.json"), Url.class);
    }
    public void readFileWithLinkOnBlogQualityHeroesDE() throws IOException {

        urls = objectMapper.readValue(new java.io.File("src/test/resources/linkOnBlogQualityHeroesDE.json"), Url.class);
    }
}
