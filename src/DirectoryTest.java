import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class DirectoryTest {

    @Test
    public void testAddFile() {
        Directory root = new Directory();
        root.setName("root");
        root.setCreationDate(new Date());

        root.addFile("root", "file1.txt", 100);

        boolean fileFound = false;
        for (Object content : root.getContents()) {
            if (content instanceof File) {
                File file = (File) content;
                if (file.getName().equals("file1.txt") && file.getSize() == 100) {
                    fileFound = true;
                    break;
                }
            }
        }
        assertTrue(fileFound, "File should be added to the root directory");
    }

    @Test
    public void testAddDir() {
        Directory root = new Directory();
        root.setName("root");
        root.setCreationDate(new Date());

        root.addDir("root", "subdir1");

        boolean dirFound = false;
        for (Object content : root.getContents()) {
            if (content instanceof Directory) {
                Directory dir = (Directory) content;
                if (dir.getName().equals("subdir1")) {
                    dirFound = true;
                    break;
                }
            }
        }
        assertTrue(dirFound, "Directory should be added to the root directory");
    }
}
