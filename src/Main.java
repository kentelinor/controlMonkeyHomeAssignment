import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Directory root = new Directory();
        root.setName("root");
        root.setCreationDate(new Date());

        root.addDir("root", "subdir1");
        root.addFile("subdir1", "file1.txt", 100);

        for (Object content : root.getContents()) {
            if (content instanceof File) {
                File file = (File) content;
                System.out.println("File Name: " + file.getName());
                System.out.println("File Size: " + file.getSize());
                System.out.println("Creation Date: " + file.getCreationDate());
            }
        }
    }
}
