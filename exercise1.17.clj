; Exercise 1.17
;
; 

(defn mult [a b]
  (if (= b 0)
    0
    (+ a (* a (- b 1)))))
    
(defn fast-mul [ab]
  ; TODO
)