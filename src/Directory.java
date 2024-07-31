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
public long getFileSize(String fileName) {
    for (Object content : contents) {
        if (content instanceof File) {
            File file = (File) content;
            if (file.getName().equals(fileName)) {
                return file.getSize();
            }
        } else if (content instanceof Directory) {
            Directory dir = (Directory) content;
            long size = dir.getFileSize(fileName);
            if (size != -1) {
                return size;
            }
        }
    }
    return -1; // File not found
}
public void showFileSystem() {
    showFileSystemHelper(this, 0);
}

private void showFileSystemHelper(Directory dir, int level) {
    printIndent(level);
    System.out.println("Directory: " + dir.getName() + ", Created on: " + dir.getCreationDate());
    for (Object content : dir.getContents()) {
        if (content instanceof File) {
            File file = (File) content;
            printIndent(level + 1);
            System.out.println("File: " + file.getName() + ", Size: " + file.getSize() + ", Created on: " + file.getCreationDate());
        } else if (content instanceof Directory) {
            showFileSystemHelper((Directory) content, level + 1);
        }
    }
}

private void printIndent(int level) {
    for (int i = 0; i < level; i++) {
        System.out.print("  ");
    }
}
    showFileSystemHelper(this, 0);
}

private void showFileSystemHelper(Directory dir, int level) {
    printIndent(level);
    System.out.println("Directory: " + dir.getName() + ", Created on: " + dir.getCreationDate());
    for (Object content : dir.getContents()) {
        if (content instanceof File) {
            File file = (File) content;
            printIndent(level + 1);
            System.out.println("File: " + file.getName() + ", Size: " + file.getSize() + ", Created on: " + file.getCreationDate());
        } else if (content instanceof Directory) {
            showFileSystemHelper((Directory) content, level + 1);
        }
    }
}

private void printIndent(int level) {
    for (int i = 0; i < level; i++) {
        System.out.print("  ");
    }
}
}

private void showFileSystemHelper(Directory dir, int level) {
    printIndent(level);
    System.out.println("Directory: " + dir.getName() + ", Created on: " + dir.getCreationDate());
    for (Object content : dir.getContents()) {
        if (content instanceof File) {
            File file = (File) content;
            printIndent(level + 1);
            System.out.println("File: " + file.getName() + ", Size: " + file.getSize() + ", Created on: " + file.getCreationDate());
        } else if (content instanceof Directory) {
            showFileSystemHelper((Directory) content, level + 1);
        }
    }
}

private void printIndent(int level) {
    for (int i = 0; i < level; i++) {
        System.out.print("  ");
    }
}
}

private void showFileSystemHelper(Directory dir, int level) {
    printIndent(level);
    System.out.println("Directory: " + dir.getName() + ", Created on: " + dir.getCreationDate());
    for (Object content : dir.getContents()) {
        if (content instanceof File) {
            File file = (File) content;
            printIndent(level + 1);
            System.out.println("File: " + file.getName() + ", Size: " + file.getSize() + ", Created on: " + file.getCreationDate());
        } else if (content instanceof Directory) {
            showFileSystemHelper((Directory) content, level + 1);
        }
    }
}

private void printIndent(int level) {
    for (int i = 0; i < level; i++) {
        System.out.print("  ");
    }
}
public String getBiggestFile() {
    String biggestFileName = null;
    long maxSize = -1;

    for (Object content : contents) {
        if (content instanceof File) {
            File file = (File) content;
            if (file.getSize() > maxSize) {
                maxSize = file.getSize();
                biggestFileName = file.getName();
            }
        } else if (content instanceof Directory) {
            Directory dir = (Directory) content;
            String biggestInDir = dir.getBiggestFile();
            long sizeInDir = dir.getFileSize(biggestInDir);
            if (sizeInDir > maxSize) {
                maxSize = sizeInDir;
                biggestFileName = biggestInDir;
            }
        }
    }
    return biggestFileName;
}
}
