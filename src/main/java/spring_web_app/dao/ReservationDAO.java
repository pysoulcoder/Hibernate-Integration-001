package spring_web_app.dao;

import java.util.List;

import spring_web_app.model.Reservation;

public interface ReservationDAO {
	public void addReservation(Reservation r);

	public void updateReservation(Reservation r);
	

	public List<Reservation> listReservations();

	public Reservation getReservationById(int id);

	public void removeReservation(int id);
}
