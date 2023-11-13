package org.qmwebsite.jsonFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.IOException;

@Getter
public class JsonFile {
    private Page pages;
    private Url urls;


    private final ObjectMapper objectMapper = new ObjectMapper();
    public void readFile() throws IOException {

        pages = objectMapper.readValue(new java.io.File("src/test/resources/urlPages.json"), Page.class);
    }
    public void readFileWithUrlOnPages() throws IOException {

        urls = objectMapper.readValue(new java.io.File("src/test/resources/urlOnPages.json"), Url.class);
    }
}
