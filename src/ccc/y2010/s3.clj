;;; Copyright 2013 Mitchell Kember. Subject to the MIT License.
;;; 2010 Canadian Computing Competition: Senior Division
;;; Problem S3: Firehose

(ns ccc.y2010.s3)

;;; A "house" is a number between 0 and circ.
;;; A "group" is a collection of houses.
;;; A "grouping" is a collection of partition lengths that describe how to
;;; divide a group into subgroups. The count of a grouping is one less than the
;;; number of subgroups it describes. For example, the grouping (1 3) means that
;;; the first subgroup consumes one element, the second consumes three, and the
;;; third consumes whatever is left.

(def circ 1000000)

(defn cw-distance
  "Returnst the clockwise distance between two houses along the circle."
  [a b]
  (if (< a b)
    (- b a)
    (+ b (- circ a))))

(defn length
  "Returns the distance between the two most distant houses in a group."
  [houses]
  (->> (concat (rest houses) [(first houses)])
       (map cw-distance houses)
       (apply max)
       (- circ)))

(defn subgroups
  "Partitions houses into subgroups according to the grouping."
  [grouping houses]
  (->> grouping
       (reduce
         (fn [[groups more] len]
           [(conj groups (take len more))
            (drop len more)])
         [[] houses])
       (apply conj)))

(defn all-groupings
  "Calculates all possible groupings of k elements into n subgroups while
  preserving their original order. Returns a collection of groupings."
  [n k]
  (cond
    (= n 1) '(())
    (>= n k) (list (repeat (- k 1) 1))
    :else
    (let [takes (range 1 (+ (- n) k 2))]
      (->> (map #(all-groupings (dec n) (- k %)) takes)
           (map (fn [t group] (map #(conj % t) group)) takes)
           (apply concat)))))

(defn group-lengths
  "Partitions houses into n subcollections such that the sum of their lengths is
  a minium. Returns the collection of optimal group lengths."
  [n houses]
  (->> (count houses)
       (all-groupings n)
       (map #(->> (subgroups % houses) (map length)))
       (apply min-key #(apply + %))))

(defn main
  "Calculates the length of hose required to connect each house to a fire
  hydrant when n hydrants are placed such that this length is a minium."
  [n houses]
  {:pre [(pos? n) (seq houses)]}
  (->> (group-lengths n (sort houses))
       (apply max)
       (* 0.5)))
