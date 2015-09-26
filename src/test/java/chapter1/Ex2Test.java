package chapter1;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class Ex2Test {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    private static final String FOLDER1 = "folder1";
    private static final String FOLDER2 =  "folder2";
    private File folder1;
    private File folder2;

    private Ex2 ex2;

    @Before
    public void setUp() throws IOException {
        folder1 = temporaryFolder.newFolder(FOLDER1);
        folder2 = temporaryFolder.newFolder(FOLDER2);
        temporaryFolder.newFile("bestand.txt");

        ex2 = new Ex2();
    }

    @Test
    public void testListSubdirectoriesWithLamba() {
        File[] files = ex2.listSubdirectoriesWithLamba(temporaryFolder.getRoot());
        assertThat(files).containsOnly(folder1, folder2);
    }

    @Test
    public void testListSubdirectoriesWithMethodReference() {
        File[] files = ex2.listSubdirectoriesWithMethodReference(temporaryFolder.getRoot());
        assertThat(files).containsOnly(folder1, folder2);
    }

}