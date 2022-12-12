package app.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@NamedQuery(name="find_all_rentals", query = "select r from Rental r")
@NamedQuery(name="Rental_find_by_cabinId_and_period", query = "SELECT r FROM Rental r WHERE r.cabin.id = :id AND r.startDate BETWEEN ?1 AND ?2")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    private double cost;
    @ManyToOne
    @JsonBackReference
    private Cabin cabin;

    enum Status {
        REQUESTED,
        APPROVED,
        DECLINED,
        PAID,
        FULFILLED,
        CANCELLED,
        BLOCKED
    }

    public Rental() {
    }

    public Rental(int id ,LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;

        int statusSelector = getRandomInt(6);
        switch (statusSelector){
            case 0 -> this.status = Status.REQUESTED;
            case 1 -> this.status = Status.APPROVED;
            case 2 -> this.status = Status.DECLINED;
            case 3 -> this.status = Status.PAID;
            case 4 -> this.status = Status.FULFILLED;
            case 5 -> this.status = Status.CANCELLED;
            case 6 -> this.status = Status.BLOCKED;
        }

        this.cost = getRandomInt(1000);
    }

    public static int getRandomInt(int max){
        return (int) Math.floor(Math.random() * max);
    }

    public Rental(LocalDate startDate, LocalDate endDate, Status status, double cost) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.cost = cost;
    }



    public boolean associateCabin(Cabin cabin){
//        if (cabin == null){
//            this.cabin = null;
//            return false;
//        }
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

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
