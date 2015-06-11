(ns fp-clj.infinite-stream)

(def letters (map char (range 65 91)))

(defn rand-string [n]
  (apply str (take n (shuffle letters))))

(defn next-ticket []
  (format "%03d%s%06d" (rand-int 999) (rand-string 2) (rand-int 999999)))

(defn ticket-gen []
  (cons (next-ticket) (lazy-seq (ticket-gen))))
