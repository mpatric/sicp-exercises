; Exercise 1.15

(defn cube [x]
  (* x x x))

(defn abs[x]
  (if (< x 0)
    (- 0 x)
    x))

(defn p [x]
  (println "CALL")
  (- (* 3 x) (* 4 (cube x))))

(defn sine [angle]
  (if (not (> (abs angle) 0.1))
    angle
    (p (sine (/ angle 3.0)))))

; a. When calling (sine 12.15), p is called 5 times
; b. The order of growth of computation and space as a function of a for (sine a) both looks logarithmic:
;     O(log(a))
;    Note: as we're dividing a by 3 on each iteration, the order is log3(a), so O(log(a)) is correct :)
