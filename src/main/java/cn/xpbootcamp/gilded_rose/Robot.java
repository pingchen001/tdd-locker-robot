package cn.xpbootcamp.gilded_rose;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private List<Locker> _lockers = new ArrayList<>();

    public Robot(List<Locker> lockers) {        
        _lockers = lockers;        
    }

    public Ticket deposit(Bag bag) {
        Locker max_locker = null;
        float max_available_rate = 0.0f;

        for (Locker locker : _lockers) {
            float availableRate = locker.availableRate();
            if (availableRate > max_available_rate) {
                max_available_rate = availableRate;
                max_locker = locker;
            }
        }

        if (max_locker == null)
            return null;

        return max_locker.deposit(bag);
    }

    public Bag take(Ticket ticket) {
        for (Locker locker : _lockers) {
            Bag bag = locker.take(ticket);
            if (bag != null) {
                return bag;
            }
        }
        return null;
    }
}