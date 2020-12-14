import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Region {
    private Long id;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public Region(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + ". " + name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
