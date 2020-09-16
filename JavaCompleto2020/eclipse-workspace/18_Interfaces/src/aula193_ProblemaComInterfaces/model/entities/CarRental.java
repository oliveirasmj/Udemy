package aula193_ProblemaComInterfaces.model.entities;

import java.util.Date;

public class CarRental {
	
	private Date start;
	private Date finish;
	private Vehicle vehicle; //tem um Veiculo
	private Invoice invoice; //pode ter 0 ou 1 Invoice(fatura)
	
	public CarRental() {
		
	}

	public CarRental(Date start, Date finish, Vehicle vehicle) {
		this.start = start;
		this.finish = finish;
		this.vehicle = vehicle;
		//Invoice NAO porque pode ser 0 ou 1
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
}
