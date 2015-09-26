package chapter1;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class Ex4 {

    public File[] sortFilesFirstDirectoriesThenOnPathNameWithLamba(File... files) {
        File[] gesorteerdeLijst = Arrays.copyOf(files, files.length);
        Arrays.sort(gesorteerdeLijst, ((Comparator<File>) (File file1, File file2) ->
                Boolean.valueOf(file2.isDirectory()).compareTo(file1.isDirectory()))
                .thenComparing((File file1, File file2) -> file1.getPath().compareTo(file2.getPath())));
        return gesorteerdeLijst;
    }

    public File[] sortFilesFirstDirectoriesThenOnPathNameWithMethodReference(File... files) {
        File[] gesorteerdeLijst = Arrays.copyOf(files, files.length);
        Arrays.sort(gesorteerdeLijst, (Comparator.comparing(File::isDirectory))
                .reversed()
                .thenComparing(File::getPath));
        return gesorteerdeLijst;
    }
}
