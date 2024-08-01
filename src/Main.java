import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory();
        root.setName("root");
        root.setCreationDate(new Date());

        root.addDir("root", "subdir1");
        root.addFile("subdir1", "file1.txt", 100);

        // List contents of the root directory
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
        long fileSize = root.getFileSize("file1.txt");
        System.out.println("Size of file1.txt: " + fileSize);

        // Delete a file
        boolean isDeleted = root.delete("file1.txt");
        System.out.println("file1.txt deleted: " + isDeleted);

        // Show file system structure
        root.showFileSystem();

        // Get the biggest file
        String biggestFile = root.getBiggestFile();
        System.out.println("Biggest File: " + biggestFile);
    }
}
