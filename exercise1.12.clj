; Exercise 1.12.
;
; The following pattern of numbers is called Pascal's triangle.
;      1
;     1 1
;    1 2 1
;   1 3 3 1
;  1 4 6 4 1
; The numbers at the edge of the triangle are all 1, and each number inside the triangle is the sum of the two
; numbers above it. Write a procedure that computes elements of Pascal's triangle by means of a recursive process.

(defn pascal[n]
  (defn pinner[l]
    (pr l)
    (loop [cnt 0 newlist '()]
      (if (>= cnt (dec (count l)))
        newlist
        (recur
          (inc cnt)
          (concat newlist (list (+ (nth l cnt) (nth l (inc cnt)))))))))
  (if (= n 1)
    '(1)
    (concat
      '(1)
      (pinner (pascal (dec n)))
      '(1))))

; user=> (pascal 10)
; (1)(1 1)(1 2 1)(1 3 3 1)(1 4 6 4 1)(1 5 10 10 5 1)(1 6 15 20 15 6 1)(1 7 21 35 35 21 7 1)(1 8 28 56 70 56 28 8 1)(1 9 36 84 126 126 84 36 9 1)
