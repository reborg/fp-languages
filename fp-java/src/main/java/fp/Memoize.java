package fp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Memoize {

    private static <T, U> Function<T, U> doMemoize(final Function<T, U> function) {
        Map<T, U> cache = new ConcurrentHashMap<>();
        return input -> cache.computeIfAbsent(input, function::apply);
    }

    public static int bigSum(int n) {
        return IntStream.rangeClosed(0, n).reduce(0, (x, y) -> x + y);
    }

    public static void main(String[] args) {
        Function<Integer, Integer> memoBigSum = doMemoize(Memoize::bigSum);
        System.out.println("memoBigSum 1 " + memoBigSum.apply(100));
        System.out.println("memoBigSum 2 " + memoBigSum.apply(100));
    }
}
