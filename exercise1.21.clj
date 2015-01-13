; Exercise 1.21

(defn smallest-divisor [n]
  (find-divisor n 2))
(defn find-divisor [n test-divisor]
  (cond
    (> (square test-divisor) n)
      n
    (divides? test-divisor n)
      test-divisor
    true
      (find-divisor n (+ test-divisor 1))))
(defn divides? [a b]
  (zero? (mod b a)))

; user=> (smallest-divisor 199)
; 199
; user=> (smallest-divisor 1999)
; 1999
; user=> (smallest-divisor 19999)
; 7

The first two numbers are prime