package chapter1;

import java.io.File;

public class Ex2 {

    public File[] listFilesWithLamba() {
        return getTestFolder().listFiles(file -> file.isDirectory());
    }

    public File[] listFilesWithMethodReference() {
        return getTestFolder().listFiles(File::isDirectory);
    }

    private File getTestFolder() {
        return new File(System.getProperty("user.home") + "/tmpJavaExercises");
    }
}
