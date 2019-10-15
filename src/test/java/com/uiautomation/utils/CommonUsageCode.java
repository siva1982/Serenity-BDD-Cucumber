package com.uiautomation.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Utility Class to convert Json file to String, which is a payload
 */

public class CommonUsageCode {

    public String generateStringFromResource(String path) throws IOException {

        return new String(Files.readAllBytes(Paths.get(path)));

    }
}
