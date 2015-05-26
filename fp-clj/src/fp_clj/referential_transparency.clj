(ns fp-clj.referential-transparency)

(defn winner
  "Uses lottery rules on tickets and prizes to stablish winner"
  [lottery tickets prizes]
  (lottery tickets prizes))

(defn lottery
  "A function of tickets and prizes to estabilish a winner."
  [tickets prizes]
  (map #(str %1 "-" %2) (sort tickets) (sort prizes)))
