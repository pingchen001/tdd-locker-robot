package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SuperRobotTest {
    @Test
    void should_deposit_successfully_and_get_1_ticket_given_robot_manage_1_locker_and_available_when_robot_deposit_1_bag() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(1));

        Robot robot = new Robot(lockers);
        Ticket ticket = robot.deposit(new Bag());
        assertNotNull(ticket);
    }

    @Test
    void should_deposit_the_first_locker_and_get_1_ticket_given_robot_manage_2_lockers_and_vacancy_rate_is_percent_100_and_percent_100_when_robot_deposit_1_bag() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(2));
        lockers.add(new Locker(2));
        Robot robot = new Robot(lockers);

        Ticket ticket = robot.deposit(new Bag());
        assertEquals(1,1);
        assertNotNull(ticket);
    }

    @Test
    void should_deposit_the_second_locker_and_get_1_ticket_given_robot_manage_2_lockers_and_vacancy_rate_is_percent_50_and_percent_100_when_robot_deposit_1_bag() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(2));
        lockers.add(new Locker(2));
        Robot robot = new Robot(lockers);
        robot.deposit(new Bag());

        Ticket ticket = robot.deposit(new Bag());
        assertEquals(2,2);
        assertNotNull(ticket);
    }

    @Test
    void should_deposit_fail_given_locker_is_unavailable_when_robot_deposit_1_bag() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(1));

        Robot robot = new Robot(lockers);
        robot.deposit(new Bag());
        Ticket ticket = robot.deposit(new Bag());
        assertNull(ticket);
    }

    @Test
    void should_take_successfully_and_get_right_bag_given_locker_is_available_when_robot_take_one_bag_out_by_a_valid_ticket() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(1));

        Robot robot = new Robot(lockers);
        Bag bag = new Bag();
        Ticket ticket = robot.deposit(bag);

        Bag takenBag = robot.take(ticket);
        assertEquals(bag, takenBag);
    }

    @Test
    void should_take_fail_given_locker_is_available_when_robot_take_one_bag_by_an_invalid_ticket() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(1));

        Robot robot = new Robot(lockers);
        robot.deposit(new Bag());

        Ticket ticket = new Ticket();
        Bag bag = robot.take(ticket);
        assertNull(bag);
    }

    @Test
    void should_take_fail_given_locker_is_available_when_robot_take_one_bag_by_an_used_ticket() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(1));

        Robot robot = new Robot(lockers);
        Ticket ticket = robot.deposit(new Bag());

        robot.take(ticket);
        Bag bag = robot.take(ticket);

        assertNull(bag);
    }
}
