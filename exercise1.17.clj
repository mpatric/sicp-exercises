; Exercise 1.17

(defn mult [a b]
  (println a b)
  (if (zero? b)
    0
    (+ a (mult a (dec b)))))
    
; (mult 2 3)
; (+ 2 (mult 2 2))
; (+ 2 (+ 2 (mult 2 1)))
; (+ 2 (+ 2 (+ 2 (mult 2 0))))
; (+ 2 (+ 2 (+ 2 0)))
; (+ 2 (+ 2 2))
; (+ 2 4)
; 6
    
(defn fast-mult [a b]
  (loop [bl b sum 0]
    (println a bl)
    (if (zero? bl)
      sum
      (recur (dec bl) (+ sum a)))))
