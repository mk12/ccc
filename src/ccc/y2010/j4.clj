;;; Copyright 2013 Mitchell Kember. Subject to the MIT License.
;;; 2010 Canadian Computing Competition: Junior Division
;;; Problem J4: Global Warming

(ns ccc.y2010.j4)

(defn first-differences
  "Calculates the first differences of a collection of numbers. The returned
  collection's length will be one fewer than the passed collection."
  [coll]
  (map - (rest coll) coll))

(defn cycle-length
  "Uses a simplified version of Floyd's cycle-finding algorithm (tortoise and
  the hare) to find the length of the shortest cycle in the collection."
  [coll]
  (let [values (vec coll)]
    (loop [t 0 h 1]
      (let [tortoise (get values t)
            hare (get values h)]
        (cond
          (nil? hare) (count values)
          (= tortoise hare) (- h t)
          :else (recur (inc t) (+ 2 h)))))))

(def main
  "Calculates the length of the shortest cycle in the collection."
  (comp cycle-length first-differences))
