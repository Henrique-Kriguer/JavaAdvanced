package application;

import model.entities.Contract;
import model.entities.Instalment;
import model.services.ContractService;
import model.services.PayPallService;
import model.services.PaymentService;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        System.out.println("Entre com os dados do contrato:");
        System.out.print("Numero: ");
        Integer number = sc.nextInt();
        System.out.print("Data (dd/MM/YYYY): ");
        LocalDate contractDate = LocalDate.parse(sc.next(),dtf);
        System.out.print("Valor do contrato: ");
        Double contractValue = sc.nextDouble();

        Contract contract = new Contract(number,contractDate,contractValue);

        System.out.print("Entre com o número de parcelas: ");
        int n = sc.nextInt();
        System.out.println("Parcelas:");

        ContractService contractService = new ContractService(new PayPallService());

        contractService.processContract(contract, n);

        for(Instalment instalment : contract.getInstalments()){
            System.out.println(instalment);
        }



        sc.close();
    }
}