package objetsMetier.zonePortes;

import objetsMetier.Zone;
import objetsMetier.exceptions.ListTooLargeException;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by igloo on 28/05/2016.
 */
public class ZonesPorteList<Zone> extends ArrayList<Zone> {

    @Override
    public boolean add(Zone zone) {
        if (this.size() > 2) try {
            throw new ListTooLargeException();
        } catch (ListTooLargeException e) {
            e.printStackTrace();
        }
        return super.add(zone);
    }
}
