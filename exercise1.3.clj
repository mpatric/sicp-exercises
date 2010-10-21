; Exercise 1.3

(defn foo[a b c]
  (-
    (+ (* a a) (* b b) (* c c))
    (* (min a b c) (min a b c))))
