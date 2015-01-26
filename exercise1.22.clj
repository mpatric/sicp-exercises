; Exercise 1.22

(defn timed-prime-test [n]
  (newline)
  (println n)
  (time (prime-test n)))
(defn prime-test [n]
  (if (fast-prime? n 5)
    (report-prime)))
(defn (report-prime)
  (println " *** "))

; incomplete..