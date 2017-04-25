package com.sye.kupps.calendarapp.containers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MockDataMaker {

    private static final String FakeUsername = "Harry Potter";

    private static String[] friends = {
            "Hermoine Granger",
            "Ron Weasley",
            "Severus Snape",
            "Draco Malfoy",
            "Dobby",
            "Ginny Weasley",
            "Sirius Black",
            "Rubeus Hagrid",
            "Albus Dumbledore",
            "Cedric Diggory",
            "Neville Longbottom",
            "Luna Lovegood",
            "Alastor Moody",
            "James Potter",
            "Lily Potter",
            "Fred Weasley",
            "George Weasley",
            "Oliver Wood"
    };

    private static String[] descriptions = {
            "Fusce dui nisl, imperdiet vitae gravida ut, maximus a eros. Cras suscipit nisi in aliquam auctor. Vivamus semper, mauris sit amet vehicula posuere, ex enim laoreet quam, et luctus diam erat at nibh. Maecenas mi augue, elementum et iaculis rutrum, dapibus at arcu. Aenean venenatis in lectus ac auctor. Ut efficitur tempor urna, pulvinar maximus magna consectetur et. Nunc ultrices est sit amet odio egestas, eu ornare nisl lobortis. Aenean convallis urna vitae justo ultricies imperdiet. Quisque efficitur dolor odio, non gravida nisl rutrum in. Fusce dignissim malesuada velit nec auctor. Nullam ligula purus, blandit vitae condimentum non, ullamcorper sit amet felis. Aenean fermentum gravida arcu, a imperdiet sapien mattis ac. Nam vitae metus ipsum. Morbi non lorem at sem sollicitudin congue sit amet sit amet tortor. Pellentesque tincidunt quis urna ac commodo.",
            "Nulla nec molestie est, eget dictum tellus. Vivamus elementum vel dui a mattis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Cras blandit eros leo, in convallis neque congue a. Maecenas sit amet purus elit. In hac habitasse platea dictumst. Mauris sollicitudin, ex in mollis gravida, orci nulla hendrerit nisi, at cursus odio erat vitae tortor. Sed varius nulla vitae luctus tempor. Ut nisi tortor, faucibus id sagittis a, pharetra id augue. Maecenas feugiat cursus ullamcorper. Mauris lobortis lorem sit amet tortor auctor tempus. Vivamus vel massa feugiat, cursus nulla ac, consectetur ante. Nullam in lorem a leo aliquet condimentum ac non metus.",
            "Nullam nec aliquam erat, et suscipit massa. Mauris a eleifend tortor. Phasellus accumsan nibh risus, id tempus erat euismod id. Integer imperdiet erat vitae sem facilisis fringilla ut sit amet augue. In vitae libero nec nibh consequat finibus. Vestibulum mattis tincidunt purus vel malesuada. Duis tincidunt leo nec ligula volutpat, ut mollis felis eleifend. Donec a felis non nulla auctor feugiat quis accumsan sapien. Integer sodales, eros vel porttitor malesuada, orci ligula fringilla eros, eget volutpat magna orci non tellus. Quisque at risus non arcu sodales elementum.",
            "Vivamus a scelerisque neque. Pellentesque non urna sem. Morbi semper ornare turpis vitae bibendum. Quisque vestibulum fringilla felis egestas molestie. Quisque suscipit id diam id laoreet. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In hac habitasse platea dictumst. Nam vulputate magna sit amet sapien elementum, sed ultrices dolor vestibulum. Nunc tristique nisl nunc, in maximus augue faucibus sed. Aliquam porttitor volutpat ex, non scelerisque nunc varius vel. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec suscipit nisi enim, tempus mollis ante mollis quis.",
            "Fusce tincidunt consequat erat vel euismod. Aenean sit amet massa magna. Donec sit amet urna a augue eleifend vestibulum. Sed quis odio iaculis, varius justo in, volutpat leo. Sed aliquam gravida volutpat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus accumsan ullamcorper sapien eu dapibus. Phasellus tristique maximus justo id interdum. Aliquam quis ligula suscipit, rutrum nisi nec, rutrum lectus.",
            "Duis ornare aliquet nisl non ornare. Vivamus est elit, pharetra sit amet tincidunt non, convallis id enim. Maecenas nec leo et leo suscipit pulvinar id vel nulla. Nullam pretium arcu vel justo suscipit scelerisque. Etiam eget eros pharetra, efficitur dolor vel, scelerisque orci. Proin sodales lobortis tincidunt. Quisque sagittis euismod consequat. Aenean scelerisque porta velit. Aenean tempus rutrum purus vel luctus.",
            "In condimentum vitae sapien ac tristique. Fusce vel magna vitae lacus venenatis dapibus ac id lacus. Vivamus pharetra, tortor non porta placerat, nibh neque hendrerit justo, et viverra purus massa viverra elit. Morbi facilisis orci sit amet tortor ultricies, a imperdiet ante scelerisque. Cras lobortis sodales neque et egestas. Proin volutpat laoreet nisi, at pulvinar orci suscipit tempor. Duis egestas orci nec blandit tincidunt. Pellentesque id augue ut augue condimentum tristique. Aenean varius tortor et nibh ullamcorper, sit amet auctor odio consectetur. Quisque libero lacus, ultrices non vehicula ut, maximus ac orci. Mauris ac porttitor orci.",
            "Nunc ornare est vel magna luctus rhoncus. Donec mauris neque, pellentesque vel dignissim a, volutpat malesuada dolor. Vivamus vestibulum ex augue, sed aliquet nulla faucibus in. Nullam at euismod nisl. Sed ullamcorper sagittis iaculis. Integer ac lacinia felis. Quisque in nibh id metus sagittis sollicitudin. Donec tincidunt velit ut risus laoreet congue.",
            "Aenean sit amet auctor erat. Ut at consequat nisl, congue vulputate mauris. Proin sem libero, viverra sit amet vulputate quis, tristique nec tellus. Nunc vitae aliquet erat. Praesent commodo elit et velit scelerisque lobortis. Nunc non bibendum turpis. Suspendisse et ex quam. Duis faucibus odio consectetur pretium ornare. Nulla convallis sit amet nunc vel tempu",
            "Curabitur tincidunt pharetra massa, eu aliquam augue bibendum ac. Fusce sollicitudin rutrum porttitor. Pellentesque consectetur neque lorem, et faucibus odio egestas quis. Duis eu aliquet nunc. Nullam non commodo leo, a tincidunt nulla. Nam et metus vel enim volutpat ullamcorper eu ut libero. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. In hac habitasse platea dictumst."
    };

    private static long[][] times;

    public static User createUser() {
        User user = new User();
        user.events = createEvents();
        user.friends = new ArrayList<>();
        Collections.addAll(user.friends, friends);
        user.username = FakeUsername;
        user.bio = "Quidditch is life. Started from a muggle now we here.";
        return user;
    }

    private static LinkedList<Event> createEvents() {
        LinkedList<Event> events = new LinkedList<>();

        initTimes();
        shuffle(descriptions);
        shuffle(times);

        events.add(createEvent("Ron Weasley", "Tailgate", times[0][0], times[0][1], times[0][2], descriptions[0]));
        events.add(createEvent("Hermoine Granger", "Study Session", times[1][0], times[1][1], times[1][2], descriptions[1]));
        events.get(1).attendees.put(FakeUsername, Event.ATTENDANCE.Invited);
        events.add(createEvent("Draco Malfoy", "Hood Rat Stuff With My Frands", times[2][0], times[2][1], times[2][2], descriptions[2]));
        events.add(createEvent("Rubeus Hagrid", "Hike Through the Woods", times[3][0], times[3][1], times[3][2], descriptions[3]));
        events.add(createEvent("Severus Snape", "Sitting Quietly in a Room", times[4][0], times[4][1], times[4][2], descriptions[4]));
        events.add(createEvent("Harry Potter", "Quidditch Pickup Game", times[5][0], times[5][1], times[5][2], descriptions[5]));
        events.add(createEvent("Dobby", "Sock Shopping", times[6][0], times[6][1], times[6][2], descriptions[6]));
        events.get(6).attendees.put(FakeUsername, Event.ATTENDANCE.Maybe);
        events.add(createEvent("Fred Weasley", "Various Practical Jokes", times[7][0], times[7][1], times[7][2], descriptions[7]));
        events.add(createEvent("Albus Dumbledore", "Award Ceremony", times[8][0], times[8][1], times[8][2], descriptions[8]));
        events.get(8).attendees.put(FakeUsername, Event.ATTENDANCE.Going);
        events.add(createEvent("Sirius Black", "Prison Breakout", times[9][0], times[9][1], times[9][2], descriptions[9]));

        Collections.sort(events);
        return events;
    }

    private static Event createEvent(String creator, String title, long start, long end, long createdTime, String description) {
        Event.ATTENDANCE[] statuses = Event.ATTENDANCE.values();
        Random r = new Random();

        Event tailgate = new Event();
        tailgate.creatorUsername = creator;
        tailgate.title = title;
        tailgate.startDateTime = start;
        tailgate.endDateTime = end;
        tailgate.description = description;
        tailgate.createdTime = createdTime;

        tailgate.attendees = new HashMap<>();
        tailgate.attendees.put(creator, Event.ATTENDANCE.Going);

        shuffle(friends);
        for (int i = 0; i < 10; i++) {
            tailgate.attendees.put(friends[i], statuses[r.nextInt(statuses.length)]);
        }

        return tailgate;
    }

    private static void shuffle(String[] array) {
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            int rand = r.nextInt(array.length);
            String temp = array[rand];
            array[rand] = array[i];
            array[i] = temp;
        }
    }

    private static void shuffle(long[][] array) {
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            int rand = r.nextInt(array.length);
            long[] temp = array[rand];
            array[rand] = array[i];
            array[i] = temp;
        }
    }

    private static void initTimes() {
        times = new long[10][3];
        long range = 1492981972037L;
        for (long[] t : times) {
            long time = ThreadLocalRandom.current().nextLong(range, range + 1000000000L);
            t[2] = time;
            t[0] = t[2] + (1000 * 60 * 60);
            t[1] = t[0] + (1000 * 60 * 60 * 3);
        }
    }

}
