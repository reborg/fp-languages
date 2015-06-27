(ns fp-clj.immutable-test
  (:require [midje.sweet :refer :all]
            [fp-clj.immutable :refer :all]))

#_(facts "ops"
       (fact "not persistent but immutable"
             (copy (original [1 2 3 4])) => (original [1 2 3 4])))
