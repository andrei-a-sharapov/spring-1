package lab1.beans.daos.mocks;

import lab1.beans.daos.BookingDAO;
import lab1.beans.models.Event;
import lab1.beans.models.Ticket;
import lab1.beans.models.User;

import java.util.List;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 06/2/16
 * Time: 3:08 AM
 */
public class BookingDAODiscountMock implements BookingDAO {

    public final String userThatBookedTickets;
    public final int    ticketsBought;

    public BookingDAODiscountMock(String userThatBookedTickets, int ticketsBought) {
        this.userThatBookedTickets = userThatBookedTickets;
        this.ticketsBought = ticketsBought;
    }

    @Override
    public Ticket create(User user, Ticket ticket) {
        return null;
    }

    @Override
    public void delete(User user, Ticket booking) {

    }

    @Override
    public List<Ticket> getTickets(Event event) {
        return null;
    }

    @Override
    public List<Ticket> getTickets(User user) {
        return null;
    }

    @Override
    public long countTickets(User user) {
        return Objects.equals(user.getName(), userThatBookedTickets) ? ticketsBought : 0;
    }

    @Override
    public List<Ticket> getAllTickets() {
        return null;
    }
}
