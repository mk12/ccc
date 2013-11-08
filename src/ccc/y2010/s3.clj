;;; Copyright 2013 Mitchell Kember. Subject to the MIT License.
;;; 2010 Canadian Computing Competition: Senior Division
;;; Problem S3: Firehose

(ns ccc.y2010.s3)

(def circ 1000000)

(defn distance
  "Returnst the shortest distance between two houses along the circle."
  [a b]
  (let [[small big] (sort [a b])]
    (min (- big small)
         (+ small (- circ big)))))

(defn length
  "Returns the distance between the two most distant houses."
  [houses]
  (->> (concat (rest houses) [(first houses)])
       (map distance houses)
       (apply max)
       (- circ)))

(defn group-houses
  "Returns houses partitioned into n subcollections such that the sum of their
  lengths (maximum distance between any two houses in the group) is a minimum."
  [n houses]
  nil)

(defn main
  "Calculates the length of hose required to connect each house to a fire
  hydrant when n hydrants are placed such that this length is a minium."
  [n houses]
  ; TODO: sort first!
  nil)
