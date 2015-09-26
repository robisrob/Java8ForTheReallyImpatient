package chapter1;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class Ex4Test {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    private Ex4 ex4;

    private File theFile;
    private File aFile;
    private File aFileInSubFolder;
    private File theFolder;
    private File aFolder;
    private File aFolderInSubFolder;

    @Before
    public void setUp() throws IOException {
        theFolder = temporaryFolder.newFolder("theFolder");
        aFolder = temporaryFolder.newFolder("aFolder");
        aFolderInSubFolder = temporaryFolder.newFolder("theFolder/aFolder");
        theFile = temporaryFolder.newFile("theFile");
        aFile = temporaryFolder.newFile("aFile");
        aFileInSubFolder = temporaryFolder.newFile("theFolder/aFile");


        ex4 = new Ex4();
    }

    @Test
    public void testSortFiles_DirectoriesBeforeFiles_ThenSortOnPathName() {
        File[] result = ex4.sortFilesFirstDirectoriesThenOnPathName(theFile, aFile, aFileInSubFolder, theFolder, aFolder, aFolderInSubFolder);

        assertThat(result).containsExactly(aFolder, theFolder, aFolderInSubFolder, aFile, theFile, aFileInSubFolder);
    }
}
