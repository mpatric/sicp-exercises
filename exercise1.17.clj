; Exercise 1.17
;
; Simple:
; a*b = 0 if b is zero
; a*b = a + (a*(b-1))
;
; Using double and halve:
; a*b = double(a)*halve(b) if b is even
; a*b = a + (a*(b-1)) if b is odd
;
; Note: these currently only work for a and b >= 0

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
  (defn dbl [x]
    (bit-shift-left x 1))
  (defn hlv [x]
    (bit-shift-right x 1))
  (loop [al a bl b sum 0]
    (println al bl sum)
    (if (zero? bl)
      sum
      (if (zero? (mod bl 2))
        ; even
        (recur (dbl al) (hlv bl) sum)
        ; odd
        (recur al (dec bl) (+ sum al))))))
        
; (fast-mult 2 3)
; (loop 2 3 0)
; (loop 2 2 2)
; (loop 4 1 2)
; (loop 4 0 6)
; 6

; (mult 12 12) -> 13 iterations
; (fast-mult 12 12) -> 6 iterations