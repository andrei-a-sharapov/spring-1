package lab1.beans.services;

import lab1.beans.models.Event;
import lab1.beans.models.User;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 2/4/2016
 * Time: 11:17 AM
 */
public interface DiscountService {

    double getDiscount(User user, Event event);
}
