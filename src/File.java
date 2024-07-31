public class File {
    private String name;

    public void setName(String name) {
        if (name.length() > 32) {
            throw new IllegalArgumentException("Name cannot be longer than 32 characters");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
