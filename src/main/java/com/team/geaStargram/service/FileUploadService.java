package com.team.geaStargram.service;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadService {

    public String getFilePath(File file, String email) throws IOException {
        String rootPath = new File("").getCanonicalPath();
        String savedPath = rootPath + "/profileImg/" + email + ".jpg";
        File moveTo = new File(savedPath);
        FileUtils.moveDirectoryToDirectory(file, moveTo, true);
        return savedPath;
    }
}
