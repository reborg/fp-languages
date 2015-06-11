package fp;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HighOrder {

    static final List<String> tickets = Arrays.asList("QA123A3", "ZR2345Z", "GT4535A");

    private static
    HashMap<String, Integer> zipmap
            (List<String> tickets, int[] prizes) {
        HashMap<String, Integer> results = new HashMap();
        for (int i = 0; i < prizes.length; i++) {
            results.put(tickets.get(i), prizes[i]);
        }
        return results;
    }

    private static
    Function<List<String>, HashMap<String, Integer>> lotteryStrategy
            (int totalPrize) {
        Function<List<String>, HashMap<String, Integer>> result;
        if (totalPrize > 100) {
            result = (tickets) -> zipmap(tickets, new int[]{20, 30, 50});
        } else {
            result = (tickets) -> zipmap(tickets, new int[]{10, 10, 10});
        }
        return result;
    }

    private static
    HashMap<String, Integer> draw
            (Function<List<String>, HashMap<String, Integer>> algorithm, List<String> tickets) {
        List<String> take3 = tickets.stream().limit(3).collect(Collectors.toList());
        return algorithm.apply(take3);
    }

    private static
    List<String> display
            (HashMap<String, Integer> winners) {
        List<String> results = new ArrayList();
        final int[] i = {0}; // trick to have an increasing index in the lambda.
        Stream<Map.Entry<String, Integer>> st = winners.entrySet().stream();
        Comparator<Map.Entry<String, Integer>> cmp = Collections.reverseOrder(Comparator.comparing(e -> e.getValue()));
        st.sorted(cmp).forEach((e) -> results.add(
                String.format("winner %s: [\"%s\" %s]\n", ++i[0], e.getKey(), e.getValue())));
        return results;
    }

    public static List<String> results
            (List<String> tickets, int totalPrize) {
        HashMap<String, Integer> winners = draw(lotteryStrategy(totalPrize), tickets);
        return display(winners);
    }
}
