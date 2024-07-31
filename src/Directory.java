import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Directory {
    private String name;
    private Date creationDate;
    private List<Object> contents; // Can contain both Directory and File objects

    public Directory() {
        contents = new ArrayList<>();
    }

    public void setName(String name) {
        if (name.length() > 32) {
            throw new IllegalArgumentException("Name cannot be longer than 32 characters");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void addContent(Object content) {
        if (content instanceof Directory || content instanceof File) {
            contents.add(content);
        } else {
            throw new IllegalArgumentException("Content must be a Directory or File");
        }
    }

    public List<Object> getContents() {
        return contents;
    }
    public void addFile(String parentDirName, String fileName, long fileSize) {
        Directory parentDir = findDirectory(parentDirName);
        if (parentDir == null) {
            throw new IllegalArgumentException("Parent directory not found");
        }
        File newFile = new File();
        newFile.setName(fileName);
        newFile.setSize(fileSize);
        newFile.setCreationDate(new Date());
        parentDir.addContent(newFile);
    }

    public void addDir(String parentDirName, String dirName) {
        Directory parentDir = findDirectory(parentDirName);
        if (parentDir == null) {
            throw new IllegalArgumentException("Parent directory not found");
        }
        Directory newDir = new Directory();
        newDir.setName(dirName);
        newDir.setCreationDate(new Date());
        parentDir.addContent(newDir);
    }

    private Directory findDirectory(String dirName) {
        if (this.name.equals(dirName)) {
            return this;
        }
        for (Object content : contents) {
            if (content instanceof Directory) {
                Directory found = ((Directory) content).findDirectory(dirName);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }
}
