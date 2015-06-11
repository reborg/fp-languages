package fp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static fp.HighOrder.results;
import static fp.HighOrder.tickets;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HighOrderTest {

    @Test
    public void aSmallPrizeIsAlwaysGiven() {
        List<String> actual = results(tickets, 0);
        List<String> expected = Arrays.asList("winner 1: [\"ZR2345Z\" 10]\n", "winner 2: [\"GT4535A\" 10]\n", "winner 3: [\"QA123A3\" 10]\n");
        assertThat(actual, is(expected));
    }

    @Test
    public void notMoreThanATotalOf100IsDistributedForLargerPrizes() {
        List<String> actual = results(tickets, 200);
        List<String> expected = Arrays.asList("winner 1: [\"GT4535A\" 50]\n", "winner 2: [\"ZR2345Z\" 30]\n", "winner 3: [\"QA123A3\" 20]\n");
        assertThat(actual, is(expected));
    }

    @Test
    public void only3WinnersAlways() {
        List<String> tickets = new ArrayList();
        tickets.addAll(HighOrder.tickets);
        tickets.add("ASDFASDF");
        assertThat(results(tickets, 300).size(), is(3));
    }

}
