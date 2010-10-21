; Exercise 1.7 - improved square root

(defn abs[x] (if (< x 0.0) (- 0 x) x))
(defn average [x y] (/ (+ x y) 2))

(defn sqrt [x]
  (defn improve [guess x] (average guess (/ x guess)))
  (defn good-enough? [prevguess guess]
    (< (abs (/ (- prevguess guess) guess)) 0.001))
  (loop [prevguess 0.0 guess 1.0]
    (if (good-enough? prevguess guess)
      guess
      (recur guess (improve guess x)))))
