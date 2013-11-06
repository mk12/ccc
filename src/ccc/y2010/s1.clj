;;; Copyright 2013 Mitchell Kember. Subject to the MIT License.
;;; 2010 Canadian Computing Competition: Senior Division
;;; Problem S1: Computer Purchase

(ns ccc.y2010.s1)

;;; A "computer" is a collection consisting of the computer name as a string and
;;; three integers: RAM (GB), clock rate (MHz), and disk space (GB).

(defn worth
  "Calculates how much a computer is worth."
  [[_ ram freq disk]]
  (+ (* 2 ram) (* 3 freq) disk))

(defn main
  "Returns the names of the two best computers."
  [computers]
  (->> (sort-by worth > computers)
       (take 2)
       (map first)))
