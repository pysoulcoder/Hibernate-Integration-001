package spring_web_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring_web_app.dao.ReservationDAO;
import spring_web_app.model.Reservation;

@Service
@Transactional  // Apply transactional behavior to all methods in this class
public class ReservationServiceImpl implements ReservationService {

    private ReservationDAO reservationDAO;
    @Autowired
    @Qualifier("reservationDAOImpl") 
    public void setReservationDAO(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }

    @Override
    public void addReservation(Reservation r) {
        reservationDAO.addReservation(r);
    }

    @Override
    public void updateReservation(Reservation r) {
        reservationDAO.updateReservation(r);
    }

    @Override
    public List<Reservation> listReservations() {
        return reservationDAO.listReservations();
    }

    @Override
    public Reservation getReservationById(int id) {
        return reservationDAO.getReservationById(id);
    }

    @Override
    public void removeReservation(int id) {
        reservationDAO.removeReservation(id);
    }
}
