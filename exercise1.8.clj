; Exercise 1.8 - cube root

(defn square[x] (* x x))
(defn abs[x] (if (< x 0.0) (- 0 x) x))
(defn average [x y] (/ (+ x y) 2))

(defn cuberoot[x]
  (defn improve [guess x]
    (/ (+ (/ x (* guess guess)) (* 2 guess)) 3))
  (defn good-enough? [prevguess guess]
    (< (abs (/ (- prevguess guess) guess)) 0.001))
  (loop [prevguess 0.0 guess 1.0]
    (if (good-enough? prevguess guess)
      guess
      (recur guess (improve guess x)))))
