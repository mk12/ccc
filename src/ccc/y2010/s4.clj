;;; Copyright 2013 Mitchell Kember. Subject to the MIT License.
;;; 2010 Canadian Computing Competition: Senior Division
;;; Problem S4: Animal Farm

(ns ccc.y2010.s4)

;;; A "node" is an integer representing a point in an undirected graph.
;;; An "edge" is a collection of exactly two nodes.
;;; A "pen" is a collection of nodes that are conneced to form edges. For
;;; example, the pen [1 2 3] represents three edges connecting 1 and 2, 2 and 3,
;;; and 3 and 1, forming a triangle.
;;; A "farm" is a collection of pens.
;;; A "receipt" is a map from edges to integers representing the cost of
;;; trampling that edge.

;; change definitions... convert all to edge lists at the beginning
;; and then work from that. (farm definition?)

(defn sort-edge
  "Sorts an edge so that the smaller node comes first."
  [[a b]]
  (if (< a b) [a b] [b a]))

(defn pen->edges
  "Converts a pen to a collection of edges."
  [pen]
  (let [rotated (take (count pen) (rest (cycle pen)))]
    (map (comp sort-edge vector) pen rotated)))

;; (defn has-edge
;;   "Returns true if the pen has the given edge."
;;   [pen [a b]]
;;   nil)

(defn trample
  "Removes an edge from a farm. If the edge is shared, the two pens will be
  combined and the farm's length will decrease by one."
  [farm [a b]]
  (let [[pen1 pen2] []]
  nil))
