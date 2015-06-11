package fp;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

public class InfiniteStream {

    private static final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static List<String> shuffle(String s) {
        List<String> letters = asList(s.split(""));
        Collections.shuffle(letters);
        return letters;
    }

    private static String randString(int l) {
        return shuffle(alpha).stream().limit(l).collect(joining());
    }

    public static int randInt(int max) {
        return new Random().nextInt(max + 1);
    }

    private static String nextTicket() {
        String t = "%03d%s%06d";
        return String.format(t, randInt(999), randString(2), randInt(999999));
    }

    public static Stream<String> ticketGen() {
        return Stream.generate(() -> nextTicket());
    }
}
