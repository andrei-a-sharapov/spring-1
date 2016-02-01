package lab1.beans.daos.mocks;

import lab1.beans.daos.inmemory.InMemoryAuditoriumDAO;
import lab1.beans.models.Auditorium;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 06/2/16
 * Time: 1:27 PM
 */
public class InMemoryAuditoriumDAOMock extends InMemoryAuditoriumDAO {

    public InMemoryAuditoriumDAOMock(List<Auditorium> auditoriums) {
        super(auditoriums);
    }
}
