package chapter1;

import java.io.File;

public class Ex2 {

    public File[] listSubdirectoriesWithLamba(File directory) {
        return directory.listFiles(file -> file.isDirectory());
    }

    public File[] listSubdirectoriesWithMethodReference(File directory) {
        return directory.listFiles(File::isDirectory);
    }

}
