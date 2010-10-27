; Exercise 1.11
; A function f is defined by the rule that f(n) = n if n<3 and f(n) = f(n - 1) + 2f(n - 2) + 3f(n - 3) if n>=3.
; Write a procedure that computes f by means of a recursive process.
; Write a procedure that computes f by means of an iterative process.

; recursive:

(defn frec[n]
  (if (< n 3)
    n
    (+ (frec (dec n)) (* 2 (frec (- n 2))) (* 3 (frec (- n 3))))))

; iterative:

(defn fiter[n]
  (defn tot[n1 n2 n3]
    (+ n1 (* 2 n2) (* 3 n3)))
  (if (< n 3)
    n
    (loop [count 3 n1 2 n2 1 n3 0 acc (tot 2 1 0)]
      (if (= count n)
        acc
        (recur (inc count) acc n1 n2 (tot acc n1 n2))))))

; user=> (frec 1)
; 1
; user=> (frec 4)
; 11
; user=> (frec 10)
; 1892
; user=> (frec 25)
; 812934961
;
; user=> (fiter 1)
; 1
; user=> (fiter 4)
; 11
; user=> (fiter 10)
; 1892
; user=> (fiter 25)
; 812934961
;
; Times:
;
; user=> (time(frec 25))
; "Elapsed time: 235.688 msecs"
; user=> (time(fiter 25))
; "Elapsed time: 0.105 msecs"
;
; So, the iterative procedure is much FASTER
