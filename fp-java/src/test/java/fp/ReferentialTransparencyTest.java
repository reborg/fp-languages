package fp;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReferentialTransparencyTest {

    private <T> List<T> freeze(T... stuff) {
        return Collections.unmodifiableList(Arrays.asList(stuff));
    }

    @Test
    public void justTheSameThing() {

        // Pay attention: remember to call freeze on mutable collections.
        List<String> tickets = freeze("QA123A3", "ZR2345Z", "GT4535A");
        List<Integer> prizes = freeze(20, 10, 30);

        String msg = "The function or its replacement returns the same result";

        List<String> results = ReferentialTransparency.winner.apply(
                ReferentialTransparency.lottery,
                tickets,
                prizes).collect(Collectors.toList());

        assertThat(msg, results.get(0), is("GT4535A-10"));
    }

}