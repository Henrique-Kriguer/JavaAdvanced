package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {

    private Integer number;
    private LocalDate contractDate;
    private Double contractValue;

    private List<Instalment> instalments = new ArrayList<>();

    public Contract(){

    }
    public Contract(Integer number, LocalDate contractDate, Double contractValue) {
        this.number = number;
        this.contractDate = contractDate;
        this.contractValue = contractValue;

    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    public Double getContractValue() {
        return contractValue;
    }

    public void setContractValue(Double contractValue) {
        this.contractValue = contractValue;
    }

    public List<Instalment> getInstalments() {
        return instalments;
    }
}
