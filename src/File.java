import java.util.Date;

public class File {
    private String name;

    private long size;

    private Date creationDate;

    public void setName(String name) {
        if (name.length() > 32) {
            throw new IllegalArgumentException("Name cannot be longer than 32 characters");
        }
        this.name = name;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setSize(long size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be a positive long integer");
        }
        this.size = size;
    }

    public long getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
}
