;;; Copyright 2013 Mitchell Kember. Subject to the MIT License.
;;; 2010 Canadian Computing Competition: Junior Division
;;; Problem J4: Global Warming

(ns ccc.y2010.j4)

(defn first-differences
  "Calculates the first differences of a collection of numbers. The returned
  collection's length will be one fewer than the passed collection."
  [coll]
  (map - (rest coll) coll))

(defn helper
  [cyc n]
  nil)

(defn cycle-length
  "Finds the length of the shortest cycle in coll."
  [coll]
  (-> (reduce #() [[] 0] coll)
      (first)
      (count)))

(def main
  "Finds the length of the shortest cycle in the first differences of coll."
  [coll]
  (cycle-length (first-differences coll)))
