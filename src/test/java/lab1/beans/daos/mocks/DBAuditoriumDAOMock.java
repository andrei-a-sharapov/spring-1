package lab1.beans.daos.mocks;

import lab1.beans.daos.db.AuditoriumDAOImpl;
import lab1.beans.models.Auditorium;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 06/2/16
 * Time: 1:27 PM
 */
public class DBAuditoriumDAOMock extends AuditoriumDAOImpl {

    private final List<Auditorium> auditoriums;

    public DBAuditoriumDAOMock(List<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    public void init() {
        cleanup();
        auditoriums.forEach(this :: add);
    }

    public void cleanup() {
        getAll().forEach(this :: delete);
    }
}
