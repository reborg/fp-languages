(ns fp-clj.infinite-stream-test
  (:require [midje.sweet :refer :all]
            [fp-clj.infinite-stream :refer :all]))

(facts "lottery tickets generator"
       (fact "it can print as many as you like"
             (let [n 1000]
               (count (take n (ticket-gen))) => n))
       (fact "nice formatted ticket number"
             (let [t (first (take 1 (ticket-gen)))
                   d3 (read-string (subs t 0 3))
                   l2 (read-string (subs t 3 5))
                   d6 (read-string (subs t 6))]
              (number? d3) => true
              (symbol? l2) => true
              (number? d6) => true)))
