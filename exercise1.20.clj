; Exercise 1.20

(defn gcd [a b]
  (if (= b 0)
    a
    (recur b (mod a b))))

Applicative order:

(gcd 206 40)
(gcd 40 (mod 206 40))
(gcd 40 6)
(gcd 6 (mod 40 6))
(gcd 6 4)
(gcd 4 (mod 6 4))
(gcd 4 2)
(gcd 2 (mod 4 2))
(gcd 2 0)
2

  4 mod operations are performed

Normal order:

(gcd 206 40)
(gcd 40 (mod 206 40))
(gcd (mod 206 40) (mod 40 (mod 206 40)))
(gcd (mod 40 (mod 206 40)) (mod (mod 206 40) (mod 40 (mod 206 40))))
(gcd (mod (mod 206 40) (mod 40 (mod 206 40))) (mod (mod 40 (mod 206 40)) (mod (mod 206 40) (mod 40 (mod 206 40)))))
(mod (mod 206 40) (mod 40 (mod 206 40)))
(mod (mod 206 40) (mod 40 6))
(mod (mod 206 40) 4)
(mod 6 4)
2

  Mod operations are performed: when evaluating the (if (=b 0)) statement and when reducing the expression.
  There are 4 in the reduction and 14 in the if blocks, giving a total of 18 mod operations
