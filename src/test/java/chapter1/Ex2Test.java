package chapter1;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class Ex2Test {

    private static final String TESTFOLDER = System.getProperty("user.home") + "/tmpJavaExercises";
    private static final String FOLDER1 = TESTFOLDER + "/folder1";
    private static final String FOLDER2 = TESTFOLDER + "/folder2";

    @Before
    public void setUp() throws IOException {
        new File(TESTFOLDER).mkdir();
        new File(FOLDER1).mkdir();
        new File(FOLDER2).mkdir();
        new File(TESTFOLDER +"/bestand1.txt").createNewFile();
    }

    @Test
    public void testListFilesWithLamba() {
        File[] files = new Ex2().listFilesWithLamba();
        assertThat(files).containsOnly(new File(FOLDER1), new File(FOLDER2));
    }

    @Test
    public void testListFilesWithMethodReference() {
        File[] files = new Ex2().listFilesWithMethodReference();
        assertThat(files).containsOnly(new File(FOLDER1), new File(FOLDER2));
    }

    @After
    public void cleanUp() throws IOException {
        FileUtils.deleteDirectory(new File(TESTFOLDER));
    }

}