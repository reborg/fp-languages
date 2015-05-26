(ns fp-clj.memoize)

(defn the-reduce [n]
  (reduce + (range n)))

(def big-reduce (memoize the-reduce))
