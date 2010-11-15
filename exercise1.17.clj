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
    
; user=> (mult 2 3)
; 2 3
; 2 2
; 2 1
; 2 0
; 6
        
(defn fast-mult [a b]
  (defn dbl [x]
    (bit-shift-left x 1))
  (defn hlv [x]
    (bit-shift-right x 1))
  (println a b)
  (if (zero? b)
    0
    (if (zero? (mod b 2))
      ; even
      (fast-mult (dbl a) (hlv b))
      ; odd
      (+ a (fast-mult a (dec b))))))
        
; user=> (fast-mult 2 3)
; 2 3
; 2 2
; 4 1
; 4 0
; 6
; 
; (mult 12 12) -> 13 iterations
; (fast-mult 12 12) -> 6 iterations