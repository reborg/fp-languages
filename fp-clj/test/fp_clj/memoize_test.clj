(ns fp-clj.memoize-test
  (:require [midje.sweet :refer :all]
            [fp-clj.memoize :refer :all]))

(facts "caching functions is called memoize"
       (fact "it should take way less the second time"
             (time (big-reduce 10000000)) => 49999995000000
             (time (big-reduce 10000000)) => 49999995000000))
