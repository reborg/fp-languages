package fp;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@FunctionalInterface
interface TriFunction<A, B, C, R> {

    R apply(A a, B b, C c);

}

public class ReferentialTransparency {

    public static TriFunction<
            BiFunction<List<String>, List<Integer>, Stream<String>>,
            List<String>,
            List<Integer>,
            Stream<String>> winner;

    public static BiFunction<
            List<String>,
            List<Integer>,
            Stream<String>> lottery;

    public static BiFunction<
            String,
            Integer,
            String> zipper;

    public static <T> List<T> sortedCopy(List<T> list) {
        List newList = new ArrayList(list);
        Collections.sort(newList);
        return newList;
    }

    static {

        zipper = (ticket, prize) -> ticket + "-" + prize;

        // Pay attention: I need to create a copy of the list to sort it.
        lottery = (tickets, prizes) -> zip(sortedCopy(tickets).stream(), sortedCopy(prizes).stream(), zipper);

        winner = (lottery, tickets, prizes) -> lottery.apply(tickets, prizes);

    }

    /**
     * Kindly sponsored by StackOverflow.
     */
    public static <A, B, C> Stream<C> zip(Stream<? extends A> a,
                                          Stream<? extends B> b,
                                          BiFunction<? super A, ? super B, ? extends C> zipper) {

        @SuppressWarnings("unchecked")
        Spliterator<A> aSpliterator = (Spliterator<A>) a.spliterator();

        @SuppressWarnings("unchecked")
        Spliterator<B> bSpliterator = (Spliterator<B>) b.spliterator();

        int characteristics = aSpliterator.characteristics() &
                bSpliterator.characteristics() &
                ~(Spliterator.DISTINCT | Spliterator.SORTED);

        long zipSize = ((characteristics & Spliterator.SIZED) != 0)
                ? Math.min(aSpliterator.getExactSizeIfKnown(),
                bSpliterator.getExactSizeIfKnown())
                : -1;

        Iterator<A> aIterator = Spliterators.iterator(aSpliterator);
        Iterator<B> bIterator = Spliterators.iterator(bSpliterator);
        Iterator<C> cIterator = new Iterator<C>() {
            @Override
            public boolean hasNext() {
                return aIterator.hasNext() && bIterator.hasNext();
            }

            @Override
            public C next() {
                return zipper.apply(aIterator.next(), bIterator.next());
            }
        };

        Spliterator<C> split = Spliterators.spliterator(cIterator, zipSize, characteristics);
        return (a.isParallel() || b.isParallel())
                ? StreamSupport.stream(split, true)
                : StreamSupport.stream(split, false);
    }
}
