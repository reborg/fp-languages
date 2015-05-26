(ns fp-clj.curry-test
  (:require [midje.sweet :refer :all]
            [fp-clj.curry :refer :all]))

(facts "equivalent formulations for a sum"
       (fact "2 arguments call"
             (my-great-sum 2 3) => 5)
       (fact "1 argument formulation"
             ((unroll-1 2) 3) => 5)
       (fact "0 arguments formulation"
             (((unroll-2) 2) 3) => 5))

(facts "equivalent function applications with partials"
       (fact "1 argument formulation"
             ((partial-unroll-1 2) 3) => 5)
       (fact "0 arguments formulation"
             ((partial-unroll-2) 2 3) => 5))
