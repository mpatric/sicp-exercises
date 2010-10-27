; Exercise 1.14

(defn first-denomination [kinds-of-coins]
  (cond
    (= kinds-of-coins 1) 1
    (= kinds-of-coins 2) 5
    (= kinds-of-coins 3) 10
    (= kinds-of-coins 4) 25
    (= kinds-of-coins 5) 50))

(defn cc [amount kinds-of-coins]
  (cond
    (= amount 0) 1
    (or (< amount 0) (= kinds-of-coins 0)) 0
    true (+ (cc amount (- kinds-of-coins 1)) (cc (- amount (first-denomination kinds-of-coins)) kinds-of-coins))))

(defn count-change [amount]
  (cc amount 5))

; user=> (count-change 100)
; 292

; n = amount
; k = kinds of coins
; c = number of types of coints
; Computational complexity is O(n^c)
;   The computational complexity relates to the number of nodes
; Space growth is O(k)
;   The space required relates to the maximum depth of the tree
