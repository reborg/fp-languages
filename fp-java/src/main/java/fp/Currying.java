package fp;

import java.util.function.*;

public class Currying {

    public static void main(String[] args) {

        Function<Integer, Function<Integer, Function<Integer, Integer>>> calculation = x -> y -> z -> x + y * z;
        Function<Function<Integer, Function<Integer, Function<Integer, Integer>>>> calculation1 = () -> x -> y -> z -> x + y * z;

        IntBinaryOperator myGreatSum = (a, b) -> a + b;
        IntFunction<IntUnaryOperator> unroll1 = a -> b -> myGreatSum.applyAsInt(a, b);
        IntFunction<IntFunction<IntUnaryOperator>> unroll2 = () -> a -> b -> myGreatSum.applyAsInt(a, b);
//        () -> a -> b -> a + b;

        myGreatSum.applyAsInt(4, 5);
        unroll1.apply(4).applyAsInt(5);


    }

}
