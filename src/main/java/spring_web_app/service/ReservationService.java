package spring_web_app.service;

import java.util.List;

import spring_web_app.model.Reservation;

public interface ReservationService {
	public void addReservation(Reservation r);

	public void updateReservation(Reservation r);
	
	public List<Reservation> listReservations();

	public Reservation getReservationById(int id);

	public void removeReservation(int id);
}
