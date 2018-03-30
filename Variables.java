/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 *
 * @author root
 */
public class Variables {

    public static String prjName = "Elective Subject Selection";

    public static String identifyFileTypeUsingFilesProbeContentType(final String fileName) {
        String fileType = "Undetermined";
        final File file = new File(fileName);
        try {
            fileType = Files.probeContentType(file.toPath());
        } catch (IOException ioException) {
            System.out.println(
                    "ERROR: Unable to determine file type for " + fileName
                    + " due to exception " + ioException);
        }
        return fileType;
    }
}
