package ua.lviv.iot.work.business;

import org.springframework.stereotype.Service;
import ua.lviv.iot.work.model.Stadium;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StadiumService {
    private Map<Integer, Stadium> stadiums = new HashMap<>();
    private AtomicInteger idCounter = new AtomicInteger();

    public Stadium createStadium(final Stadium stadium) {
        stadium.setId(idCounter.incrementAndGet());
        stadiums.put(stadium.getId(), stadium);
        return stadium;
    }

    public Stadium destroyStadium(final int id) {
        return stadiums.remove(id);
    }

    public Collection<Stadium> allStadiums() {
        return stadiums.values();
    }

    public Stadium stadiumId(final int id) {
        return stadiums.get(id);
    }

    public void replaceStadium(final Stadium stadium, final Integer id) {
        stadiums.remove(id);
        stadium.setId(id);
        stadiums.put(id, stadium);
    }
}
