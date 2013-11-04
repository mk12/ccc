;;; Copyright 2013 Mitchell Kember. Subject to the MIT License.
;;; 2010 Canadian Computing Competition: Junior Division
;;; Problem J1: What is n, Daddy?

(ns ccc.y2010.j1)

(defn main
  "Calculates the number of ways to represent n using two hands."
  [n]
  ([1 2 3 3 2 1] (quot n 2)))
