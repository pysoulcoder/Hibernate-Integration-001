package spring_web_app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring_web_app.model.Reservation;

@Repository
@Primary
public class ReservationDAOImpl implements ReservationDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void addReservation(Reservation r) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(r);
        System.out.println("Reservation saved successfully");
    }

    @SuppressWarnings("deprecation")
	@Override
    @Transactional
    public void updateReservation(Reservation r) {
        Session session = sessionFactory.getCurrentSession();
        session.update(r);
        System.out.println("Reservation updated successfully");
    }

    @Override
    @Transactional
    public List<Reservation> listReservations() {
        Session session = sessionFactory.getCurrentSession();
        
        return session.createQuery("from Reservation", Reservation.class).getResultList();
    }
    @Override
    @Transactional
    public Reservation getReservationById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Reservation reservation = session.get(Reservation.class, id);
        return reservation;
    }

    @SuppressWarnings("deprecation")
	@Override
    @Transactional
    public void removeReservation(int id) {
        Session session = sessionFactory.getCurrentSession();
        Reservation reservation = session.get(Reservation.class, id);
        if (reservation != null) {
            session.delete(reservation);
            System.out.println("Reservation removed successfully");
        } else {
            System.out.println("No reservation found with ID: " + id);
        }
    }
}
