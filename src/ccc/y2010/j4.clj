;;; Copyright 2013 Mitchell Kember. Subject to the MIT License.
;;; 2010 Canadian Computing Competition: Junior Division
;;; Problem J4: Global Warming

(ns ccc.y2010.j4)

(defn first-differences
  "Calculates the first differences of a collection of numbers. The returned
  collection's length will be one fewer than the passed collection."
  [coll]
  (map - (rest coll) coll))

(defn scan-val
  "Scans the value x and returns a new [acc n] where acc is a collection of
  values representing the shortest cycle so far and n represents the number of
  repeating values after the end of the first cycle that have been scanned."
  [[acc n] x]
  (if (= (get acc n) x)
    [acc (inc n)]
    (let [repeats (take n (cycle acc))]
      [(conj (into acc repeats) x) 0])))

(defn main
  "Finds the length of the shortest cycle in the first differences of coll."
  [coll]
  (->> (first-differences coll)
       (reduce scan-val [[] 0])
       (first)
       (count)))
