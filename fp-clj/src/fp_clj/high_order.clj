(ns fp-clj.high-order)

(def tickets ["QA123A3" "ZR2345Z" "GT4535A"])

(defn lottery-strategy [total-prize]
  (if (> total-prize 100)
    #(zipmap % [20 30 50])
    #(zipmap % [10 10 10])))

(defn display [winners]
  (map-indexed #(str "winner " (inc %1) ": " %2 "\n") winners))

(defn draw [lottery tickets]
  (lottery (take 3 tickets)))

(defn results [tickets total-prize]
  (display (draw (lottery-strategy total-prize) tickets)))

; (results tickets 200)
; winner 1: ["GT4535A" 50] winner 2: ["ZR2345Z" 30]" winner 3: ["QA123A3" 20]
