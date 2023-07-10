package model.services;

import model.entities.Contract;
import model.entities.Instalment;

import java.time.LocalDate;

public class ContractService {

    private PaymentService paymentService;

    public ContractService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract,int months ){
        contract.getInstalments().add(new Instalment(LocalDate.of(2018, 7, 25), 206.04));

        contract.getInstalments().add(new Instalment(LocalDate.of(2018, 8, 25), 208.08));
    }
}
