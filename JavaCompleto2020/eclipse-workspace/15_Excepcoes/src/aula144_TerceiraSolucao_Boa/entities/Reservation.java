package aula144_TerceiraSolucao_Boa.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import aula144_TerceiraSolucao_Boa.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //static - para que nao seja instanciado um SimpleDateFormat para cada objeto
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException { //podera ser lançado o DomainException
		if (checkOut.before(checkIn)) { //se checkin/checkout for inferior a data atual
			throw new DomainException("Check-out date must be after check-in date"); //lança DomainException - é necessário trata-la colocando o throws em cima
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); //subtrai ao duas datas em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //converte para dias
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainException { //podera ser lançado o DomainException
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) { //se checkin/checkout for inferior a data atual
			throw new DomainException("Reservation dates for update must be future dates"); //lança DomainException - é necessário trata-la colocando o throws a seguir ao nome deste metodo
		}
		if (!checkOut.after(checkIn)) { //se checkout nao for depois de checkin
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
	}
	
}
