package lab1.controllers;

import static java.time.LocalDateTime.now;
import static lombok.AccessLevel.PRIVATE;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;

import java.time.LocalDateTime;
import java.util.List;
import lab1.beans.models.Event;
import lab1.beans.models.Ticket;
import lab1.beans.models.User;
import lab1.beans.services.AuditoriumService;
import lab1.beans.services.BookingService;
import lab1.beans.services.EventService;
import lab1.beans.services.UserService;
import lab1.controllers.dto.BookingRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("booking")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@FieldDefaults(level = PRIVATE, makeFinal = true) @Getter
@Slf4j
public class BookingController {

  BookingService bookingService;
  UserService userService;
  EventService eventService;
  AuditoriumService auditoriumService;

  @GetMapping(path = "price")
  public Double getTicketPrice(

      @RequestParam String event,
      @RequestParam String auditorium,

      @RequestParam(name = "date_time") @DateTimeFormat(iso = DATE_TIME)
          LocalDateTime eventDateTime,

      @RequestParam List<Integer> seats,
      @RequestParam("user_email") String userMail) {

    log.info("Calculating the booking price for: "
            + "event: {}, auditorium: {}, date: {}, seats: {}, user e-mail: {}",
        event, auditorium, eventDateTime, seats, userMail);

    return getTicketPrice(event, auditorium, eventDateTime, seats, getUserByEmail(userMail));
  }

  @PostMapping
  public Ticket bookTicket(@RequestBody BookingRequest request) {

    log.info("Trying to book a ticket according to the request: {}", request);

    String eventName = request.getEventName();
    String auditoriumName = request.getAuditoriumName();
    LocalDateTime eventDateTime = request.getEventDateTime();
    List<Integer> seats = request.getSeats();

    User user = getUserByEmail(request.getUserMail());
    Event event = eventService.getEvent(
        eventName, auditoriumService.getByName(auditoriumName), eventDateTime);

    log.info("The ticket for the event {}, seats: {} will be booked for the user {}",
        eventName, seats, user.getEmail());

    bookingService.bookTicket(user, ticket(event, seats, user));
    return _getTicketsForEvent(eventName, auditoriumName, eventDateTime).stream()
        .filter(t -> t.getUser().equals(user) && t.getSeatsList().equals(seats))
        .findAny().get();
  }

  @GetMapping
  public List<Ticket> getTicketsForEvent(
      @RequestParam String event,
      @RequestParam String auditorium,
      @RequestParam(name = "date_time") @DateTimeFormat(iso = DATE_TIME)
          LocalDateTime eventDateTime) {

    return _getTicketsForEvent(event, auditorium, eventDateTime);
  }

  private List<Ticket> _getTicketsForEvent(String eventName, String auditoriumName,
      LocalDateTime eventDateTime) {
    return bookingService.getTicketsForEvent(eventName, auditoriumName, eventDateTime);
  }

  private Ticket ticket(Event event, List<Integer> seats, User user) {

    double ticketPrice = getTicketPrice(
        event.getName(), event.getAuditorium().getName(), event.getDateTime(), seats, user);

    return new Ticket(event, now(), seats, user, ticketPrice);
  }

  private User getUserByEmail(String userMail) {

    return userService.getUserByEmail(userMail);
  }

  private double getTicketPrice(String eventName, String auditoriumName,
      LocalDateTime eventDateTime, List<Integer> seats, User user) {

    return bookingService.getTicketPrice(eventName, auditoriumName, eventDateTime, seats, user);
  }

}