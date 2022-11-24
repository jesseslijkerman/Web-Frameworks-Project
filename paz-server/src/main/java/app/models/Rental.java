package app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import java.time.LocalDate;

enum Status {
    REQUESTED,
    APPROVED,
    DECLINED,
    PAID,
    FULFILLED,
    CANCELLED,
    BLOCKED
}
@Entity
@NamedQuery(name="find_all_rentals", query = "select r from Rental r")
public class Rental {
    @Id
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;
    private double cost;
    @ManyToOne
    private Cabin cabin;

    public Rental() {
    }

    public boolean associateCabin(Cabin cabin){
        if (cabin == null){
            this.cabin = null;
            return false;
        }
        this.cabin = cabin;
        return true;
    }

    public long getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Status getStatus() {
        return status;
    }

    public double getCost() {
        return cost;
    }

    public Cabin getCabin() {
        return cabin;
    }
}
