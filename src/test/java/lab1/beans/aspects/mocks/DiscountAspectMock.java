package lab1.beans.aspects.mocks;

import lab1.beans.aspects.DiscountAspect;
import lab1.beans.services.discount.BirthdayStrategy;
import lab1.beans.services.discount.TicketsStrategy;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 13/2/16
 * Time: 8:38 PM
 */
public class DiscountAspectMock extends DiscountAspect {
    public static void cleanup() {
        discountPerUserCounter.put(BirthdayStrategy.class.getSimpleName(), new HashMap<>());
        discountPerUserCounter.put(TicketsStrategy.class.getSimpleName(), new HashMap<>());
    }
}
