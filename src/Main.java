import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory();
        System.out.println("Setting name of root directory");
        root.setName("root");
        System.out.println("Setting creation date of root directory");
        root.setCreationDate(new Date());

        System.out.println("Adding subdir1 to root directory");
        root.addDir("root", "subdir1");
        System.out.println("Adding file1.txt to subdir1");
        root.addFile("subdir1", "file1.txt", 100);

        // List contents of the root directory
        System.out.println("Listing contents of the root directory");
        for (Object content : root.getContents()) {
            if (content instanceof Directory) {
                Directory dir = (Directory) content;
                System.out.println("Directory Name: " + dir.getName());
                System.out.println("Creation Date: " + dir.getCreationDate());
            } else if (content instanceof File) {
                File file = (File) content;
                System.out.println("File Name: " + file.getName());
                System.out.println("File Size: " + file.getSize());
                System.out.println("Creation Date: " + file.getCreationDate());
            }
        }

        // Get file size
        System.out.println("Getting size of file1.txt");
        long fileSize = root.getFileSize("file1.txt");
        System.out.println("Size of file1.txt: " + fileSize);

        // Delete a file
        System.out.println("Deleting file1.txt");
        boolean isDeleted = root.delete("file1.txt");
        System.out.println("file1.txt deleted: " + isDeleted);

        // Show file system structure
        System.out.println("Showing file system structure");
        root.showFileSystem();

        // Get the biggest file
        System.out.println("Getting the biggest file");
        String biggestFile = root.getBiggestFile();
        System.out.println("Biggest File: " + biggestFile);
    }
}
