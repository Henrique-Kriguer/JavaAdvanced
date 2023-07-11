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
        Double basicQuota = contract.getContractValue() / months;


        for( int i=1; i <= months; i++){
            LocalDate dueDate = contract.getContractDate().plusMonths(i);

            double interest = paymentService.interest(basicQuota,i);
            double fee = paymentService.paymentFee(basicQuota + interest);
            double quota = basicQuota + interest + fee;

            contract.getInstalments().add(new Instalment(dueDate, quota));
        }
    }
}
