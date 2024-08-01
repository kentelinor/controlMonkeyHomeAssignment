import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory();
        System.out.println("******** Setting name of root directory");
        root.setName("root");
        System.out.println("******** Setting creation date of root directory");
        root.setCreationDate(new Date());

        System.out.println("******** Adding subdir1 to root directory");
        root.addDir("root", "subdir1");
        System.out.println("******** Adding file1.txt to subdir1");
        root.addFile("subdir1", "file1.txt", 100);

        System.out.println("******** Adding subdir2 to root directory");
        root.addDir("root", "subdir2");
        System.out.println("******** Adding file2.txt to subdir2");
        root.addFile("subdir2", "file2.txt", 200);

        System.out.println("******** Adding subdir3 to subdir1");
        root.addDir("subdir1", "subdir3");
        System.out.println("******** Adding file3.txt to subdir3");
        root.addFile("subdir3", "file3.txt", 300);

        System.out.println("******** Adding subdir4 to subdir3");
        root.addDir("subdir3", "subdir4");
        System.out.println("******** Adding file4.txt to subdir4");
        root.addFile("subdir4", "file4.txt", 400);

        System.out.println("******** Adding subdir5 to subdir2");
        root.addDir("subdir2", "subdir5");
        System.out.println("******** Adding file5.txt to subdir5");
        root.addFile("subdir5", "file5.txt", 500);
        System.out.println("******** Listing contents of the root directory");
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
        System.out.println("******** Getting size of file1.txt");
        long fileSize = root.getFileSize("file1.txt");
        System.out.println("Size of file1.txt: " + fileSize);

        // Delete a file
        System.out.println("******** Deleting file1.txt");
        boolean isDeleted = root.delete("file1.txt");
        System.out.println("file1.txt deleted: " + isDeleted);

        // Show file system structure
        System.out.println("******** Showing file system structure");
        root.showFileSystem();

        // Get the biggest file
        System.out.println("******** Getting the biggest file");
        String biggestFile = root.getBiggestFile();
        System.out.println("Biggest File: " + biggestFile);
    }
}
