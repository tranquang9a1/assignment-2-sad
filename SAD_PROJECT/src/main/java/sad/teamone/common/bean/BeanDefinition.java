package sad.teamone.common.bean;

/**
 * Created by Tuyen on 10/19/2014.
 */
public class BeanDefinition {
    // Fields
    private String name;
    private Object reference;

    // Constructors
    public BeanDefinition() {

    }

    public BeanDefinition(String name, Object reference) {
        this.name = name;
        this.reference = reference;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getReference() {
        return reference;
    }

    public void setReference(Object reference) {
        this.reference = reference;
    }
}
