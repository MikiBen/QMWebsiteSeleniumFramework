package org.selenium.pom.jsonFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.IOException;

@Getter
public class JsonFile {
    private Page pages;

    public void readFile() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        pages = objectMapper.readValue(new java.io.File("src/test/resources/urlPages.json"), Page.class);
    }
}
