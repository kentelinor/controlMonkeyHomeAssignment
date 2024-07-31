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
}
