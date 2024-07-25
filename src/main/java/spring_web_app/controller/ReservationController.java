package spring_web_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring_web_app.model.Reservation;
import spring_web_app.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    @Qualifier("reservationService")
    private ReservationService reservationService;

    @RequestMapping("/bookingForm")
    public String bookingForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservation-page";
    }

    @RequestMapping("/submitForm")
    public String submitForm(@ModelAttribute("reservation") Reservation res) {
        reservationService.addReservation(res);
        return "confirmation-page";
    }

    @RequestMapping("/editForm")
    public String showEditForm(@RequestParam("id") int id, Model model) {
        Reservation reservation = reservationService.getReservationById(id);
		/*
		 * if (reservation == null) { return "redirect:/reservation/errorPage"; }
		 */
        model.addAttribute("reservation", reservation);
        return "editForm";
    }

    @RequestMapping("/update")
    public String updateReservation(@ModelAttribute("reservation") Reservation reservation, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("reservation", reservation);
            return "editForm"; // Return to the form if there are errors
        }
        reservationService.updateReservation(reservation); // Make sure to update the reservation
        return "redirect:/reservation/list"; // Redirect to the list after update
    }

    @RequestMapping("/errorPage")
    public String showErrorPage() {
        return "errorPage"; // Return the name of the error view
    }

    @RequestMapping("/list")
    public String listReservations(Model model) {
        List<Reservation> reservations = reservationService.listReservations();
        model.addAttribute("reservations", reservations); // Make sure the attribute name matches in the JSP
        return "reservation-list";
    }
    
    @RequestMapping("/delete")
    public String deleteReservation(@RequestParam("id") int id) {
        // Call the service to delete the reservation by ID
        reservationService.removeReservation(id);
        
        // Redirect to the list of reservations or another appropriate page
        return "redirect:/reservation/list";
    }
}
