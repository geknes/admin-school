package com.service.school.web.gestion.utilitarios;

import java.io.File;

public class FileUtil {
	
	public static File fileExists(String rootPath) {
        File dir = new File(rootPath);                
        if (!dir.exists()){
            dir.mkdirs();
        }                
        return dir;
	}
}
