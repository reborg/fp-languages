package fp;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static fp.InfiniteStream.ticketGen;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class InfiniteStreamTest {

    @Test
    public void itCanPrintAsManyAsYouLike() {
        int n = 1000;
        List<String> all = ticketGen().limit(n).collect(Collectors.toList());
        assertThat(all.size(), is(n));
    }

    @Test
    public void itComesInANiceFormat() {
        String s = ticketGen().limit(1).collect(Collectors.toList()).get(0);
        assertTrue(Integer.valueOf(s.substring(0, 3)) < 999);
    }

}
