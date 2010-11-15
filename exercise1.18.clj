; Exercise 1.18
;
; a * b = 0 if b = 0
; a * b = a + (a * (b - 1)) if b is odd
; a * b = (a*2) * (b/2) = (a<<1) * (b>>1)  if b is even

(defn iterative-fast-mult [a b]
  (defn dbl [x]
    (bit-shift-left x 1))
  (defn hlf [x]
    (bit-shift-right x 1))
  (loop [al a bl b sum 0]
    (println al bl sum)
    (if (zero? bl)
      sum
      (if (zero? (mod bl 2))
        ; even
        (recur (dbl al) (hlf bl) sum)
        ; odd
        (recur al (dec bl) (+ sum al))))))
        
; user=> user=> (iterative-fast-mult 2 3)
; 2 3 0
; 2 2 2
; 4 1 2
; 4 0 6
; 6
