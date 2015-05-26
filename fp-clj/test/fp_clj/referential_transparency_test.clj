(ns fp-clj.referential-transparency-test
  (:require [midje.sweet :refer :all]
            [fp-clj.referential-transparency :refer :all]))

(facts "winners at the lottery"
       (fact "there are always winners if there are prizes"
             (first (winner #'lottery ["QA123A3" "ZR2345Z" "GT4535A"] [20 10 30])) => "GT4535A-10"))
