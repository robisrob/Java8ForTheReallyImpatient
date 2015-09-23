package chapter1;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class Ex3Test {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    private File txtFile1;
    private File txtFile2;
    private File csvFile;

    @Before
    public void setUp() throws IOException {
        temporaryFolder.newFolder("folder");
        txtFile1 = temporaryFolder.newFile("bestand.txt");
        txtFile2 = temporaryFolder.newFile("anderBestand.txt");
        csvFile = temporaryFolder.newFile("csvFile.csv");

    }

    @Test
    public void testListFilesWithExtension_txt(){
        File[] result = new Ex3().listFilesWithExtension(temporaryFolder.getRoot(), "txt");

        assertThat(result).containsOnly(txtFile1, txtFile2);
    }

    @Test
    public void testListFilesWithExtension_csv(){
        File[] result = new Ex3().listFilesWithExtension(temporaryFolder.getRoot(), "csv");

        assertThat(result).containsOnly(csvFile);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListFilesWithExtension_null(){
        new Ex3().listFilesWithExtension(temporaryFolder.getRoot(), null);
    }

    @Test
    public void testListFilesWithExtension_emptyExtention(){
        File[] result = new Ex3().listFilesWithExtension(temporaryFolder.getRoot(), "");

        assertThat(result).isEmpty();
    }
}