(ns fp-clj.eval)

(defn fun1 [f] (println "fun1") (fn [x y] (f x y)))
(defn fun2 [x] (println "fun2") x)
(defn fun3 [y] (println "fun3") y)

; ((fun1 #'+) (fun2 1) (fun3 1))
