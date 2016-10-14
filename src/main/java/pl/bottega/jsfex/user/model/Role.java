package pl.bottega.jsfex.user.model;

/**
 * Created by maciuch on 07.10.16.
 */
public class Role {

    private Long id;

    private String name;
    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role() {
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
