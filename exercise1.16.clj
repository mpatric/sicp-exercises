; Exercise 1.16
;
; b^n = (b^(n/2))^2 = (b^2)^(n/2) if n is even
; b^n = b*(b^(n-1)) if n is odd
;
;  

(defn expt [b n]
  (if (< n 0)
    (/ 1 (expt b (- 0 n)))
    (loop [counter n product 1]
      (if (zero? counter)
        product
        (recur (dec counter) (* product b))))))

(defn fast-expt [b n]
  (if (< n 0)
    (/ 1 (fast-expt b (- 0 n)))
    (loop [bl b nl n product 1]
      (if (zero? nl)
        product
        (if (zero? (mod nl 2))
          ; even
          (recur (* bl bl) (/ nl 2) product)
          ; odd
          (recur bl (dec nl) (* product bl)))))))
