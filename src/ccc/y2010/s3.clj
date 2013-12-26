;;; Copyright 2013 Mitchell Kember. Subject to the MIT License.
;;; 2010 Canadian Computing Competition: Senior Division
;;; Problem S3: Firehose

(ns ccc.y2010.s3)

;;; A "house" is a number between 0 and circ.
;;; A "group" is a collection of houses.
;;; A "grouping" is a collection of partition lengths that describe how to
;;; divide a group into subgroups. The count of a grouping is equal to the
;;; number of subgroups it describes. For example, the grouping (1 3 2) means
;;; that the first subgroup consumes one element, the second consumes three, the
;;; the third consumes two, and whatever remains is prepended to the first.

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

(defn concat-first
  "Concatenates the elements of from-coll on the first element of to-coll
  (to-coll is assumed to have a nested collection)."
  [to from]
  (conj (rest to)
        (concat from (first to))))

(defn split-n
  "Splits the next n elements off coll and adds them to groups as a new
  collection. Returns a new vector of the form [groups coll]."
  [[groups coll] n]
  [(conj groups (take n coll))
   (drop n coll)])

(defn subgroups
  "Partitions houses into subgroups according to the grouping."
  [grouping houses]
  (->> grouping
       (reduce split-n [[] houses])
       (apply concat-first)))

(defn all-groupings
  "Calculates all possible groupings of k elements into n subgroups while
  preserving their original order. Returns a collection of groupings."
  [n k]
  (cond
   (> n k) (list (repeat k 1))
   (= n 1) (map list (range 1 (inc k)))
   :else
   (let [takes (range 1 (+ (- n) k 2))]
     (->> (map #(all-groupings (dec n) (- k %)) takes)
          (map (fn [t group] (map #(conj % t) group)) takes)
          (apply concat)))))

(defn groupings->lengths
  "Given a collection of houses, converts a collection of groupings to a
  collection of lengths, which represent the longest for each grouping."
  [houses groupings]
  (map #(->> (subgroups % houses) (map length) (apply max))
       groupings))

(defn main
  "Calculates the length of hose required to connect each house to a fire
  hydrant when n hydrants are placed such that this length is a minium."
  [n houses]
  {:pre [(pos? n) (seq houses)]}
  (-> (all-groupings n (count houses))
      (->> (groupings->lengths (sort houses)))
      (->> (apply min))
      (/ 2)))
