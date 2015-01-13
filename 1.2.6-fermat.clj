(defn expmod [base exp m]
  (defn square [x] (* x x))
  (cond
    (= exp 0)
      1
    (even? exp)
      (mod (square (expmod base (/ exp 2) m)) m)
    true
      (mod (* base (expmod base (- exp 1) m)) m)))
      
(defn fermat-test [n]
  (defn random [n] (int (* n (rand))))
  (defn try-it [a]
    (= (expmod a n n) a))
  (try-it (+ 1 (random (- n 1)))))
  
(defn fast-prime? [n times]
  (cond
    (= times 0)
      true
    (fermat-test n)
      (fast-prime? n (- times 1))
    true
      false))