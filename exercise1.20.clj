; Exercise 1.20

(defn gcd [a b]
  (if (= b 0)
    a
    (recur b (mod a b))))

