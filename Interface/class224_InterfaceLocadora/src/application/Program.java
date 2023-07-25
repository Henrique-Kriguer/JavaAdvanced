package application;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo do carro:");
        String vehicle = sc.nextLine();
        System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(),fmt);
        System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(),fmt);
        CarRental rental = new CarRental(start,finish,new Vehicle(vehicle));
        System.out.print("entre com o preço por hora: ");
        double precoPorHora = sc.nextDouble();
        System.out.print("Entre com o preço por dia: ");
        double precoPorDia = sc.nextDouble();
        RentalService rentalService = new RentalService(precoPorDia,precoPorHora, new BrazilTaxService());
        rentalService.processInvoice(rental);
        System.out.println("FATURA");
        System.out.println("Pagamento básico: "+ String.format("%.2f",rental.getInvoice().getBasicPayment()));
        System.out.println("Imposto: " + String.format("%.2f",rental.getInvoice().getTax()));
        System.out.println("Pagamento total: " + String.format("%.2f", rental.getInvoice().getTotalPayment()));
        sc.close();
    }
}