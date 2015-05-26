(ns fp-clj.curry)

(defn my-great-sum [a b]
  (+ a b))

(defn unroll-1 [a]
  (fn [b] (my-great-sum a b)))

(defn unroll-2 []
  (fn [a] (fn [b] (my-great-sum a b))))

(defn partial-unroll-1 [a]
  (partial my-great-sum a))

(defn partial-unroll-2 []
  (partial my-great-sum))
