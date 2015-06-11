(ns fp-clj.high-order-test
  (:require [midje.sweet :refer :all]
            [fp-clj.high-order :refer :all]))

(facts "winners at the lottery"
       (fact "a small prize is always given"
             (results tickets 0) => '("winner 1: [\"GT4535A\" 10]\n" "winner 2: [\"ZR2345Z\" 10]\n" "winner 3: [\"QA123A3\" 10]\n"))
       (fact "not more than a total of 100 is ditributed for larger prizes"
             (results tickets 200) => '("winner 1: [\"GT4535A\" 50]\n" "winner 2: [\"ZR2345Z\" 30]\n" "winner 3: [\"QA123A3\" 20]\n"))
       (fact "only three winners always"
             (count (results (conj tickets "AAAAAAA") 300)) => 3))
