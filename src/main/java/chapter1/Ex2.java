package chapter1;

import java.io.File;

public class Ex2 {

    public File[] listSubdirectoriesWithLamba() {
        return getTestFolder().listFiles(file -> file.isDirectory());
    }

    public File[] listSubdirectoriesWithMethodReference() {
        return getTestFolder().listFiles(File::isDirectory);
    }

    private File getTestFolder() {
        return new File(System.getProperty("user.home") + "/tmpJavaExercises");
    }
}
