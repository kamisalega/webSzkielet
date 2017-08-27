package pl.salega.webszkielet.backend.persistence.domain.backend;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Plan implements Serializable {

    /**
     * The Serial Version UID for Serializable classes.
     */
    private static final long serialVersionUID = 1l;

    @Id
    private int id;

    private String name;

    /**
     * Pusty konstruktor.
     */

    public Plan() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plan plan = (Plan) o;

        return id == plan.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
