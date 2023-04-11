package model;

import java.util.List;

public class Alert {
    private int id;
    private List<Property> properties;
    private Type type;
    public Alert(int id, List<Property> properties,Type type) {
        super();
        this.id = id;
        this.properties = properties;
        this.type=type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
