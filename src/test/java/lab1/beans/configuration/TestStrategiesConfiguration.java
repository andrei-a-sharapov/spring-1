package lab1.beans.configuration;

import lab1.beans.daos.BookingDAO;
import lab1.beans.daos.mocks.BookingDAODiscountMock;
import lab1.beans.services.DiscountService;
import lab1.beans.services.DiscountServiceImpl;
import lab1.beans.services.discount.BirthdayStrategy;
import lab1.beans.services.discount.TicketsStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 13/2/16
 * Time: 3:36 PM
 */
@Configuration
public class TestStrategiesConfiguration {

    @Bean
    public BirthdayStrategy birthdayStrategy() {
        return new BirthdayStrategy(1.0, 0);
    }

    @Bean
    public TicketsStrategy ticketsStrategy() {
        return new TicketsStrategy(bookingDiscountDAO(), 0.5, 2, 0);
    }

    @Bean
    public BookingDAO bookingDiscountDAO() {
        return new BookingDAODiscountMock("Test User", 1);
    }

    @Bean
    public DiscountService discountServiceImpl() {
        return new DiscountServiceImpl(Arrays.asList(birthdayStrategy(), ticketsStrategy()));
    }
}
