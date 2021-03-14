package java_project.entity;

public abstract class AbstractId {
    private Long id;

    public static Long generateId = 1L;

    public AbstractId() {
        this.id = generateId;
        generateId++;
    }

    public Long getId() {
        return id;
    }
}
