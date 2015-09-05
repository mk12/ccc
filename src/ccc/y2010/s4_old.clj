;;; Copyright 2013 Mitchell Kember. Subject to the MIT License.
;;; 2010 Canadian Computing Competition: Senior Division
;;; Problem S4: Animal Farm

(ns ccc.y2010.s4-old
  (:require [clojure.set :as s]))

;;; A "node" is an integer representing a point on an undirected graph.
;;; An "edge" is a collection of exactly two nodes, in increasing order.
;;; A "polygon" is a set of edges forming a closed polygon.
;;; The "outside" is a special polygon represented by the empty set #{}. All
;;; otherwise unshared edges of other polygons are shared with the outside.
;;; A "mesh" is a set of polygons.
;;; A "pen" is a collection of nodes that represent a polygon.
;;; (The pen [1 2 3] and the polygon #{[1 2] [2 3] [3 1]} are equivalent.)
;;; A "farm" is a collection of pens.
;;; A "receipt" is a map from edges to integers that represent the cost of
;;; trampling (destroying) that edge.

(defn sort-edge
  "Sorts an edge so that the smaller node comes first."
  [[a b]]
  (if (< a b) [a b] [b a]))

(defn pen->polygon
  "Converts a pen (collection of nodes) to a polygon (set of edges)."
  [pen]
  (let [rotated (take (count pen) (rest (cycle pen)))]
    (set (map (comp sort-edge vector) pen rotated))))

(defn farm->mesh
  "Converts a farm (collection of pens) to a mesh (set of polygons)."
  [farm]
  (set (map pen->polygon farm)))

(defn simplify-mesh
  "Simplifies a mesh by removing all edges except the least expensive edge
  wherever two polygons share multiple edges. If the mesh does not contain the
  outside, all unshared edges will be removed."
  [mesh receipt]
  nil)

(defn sym-difference
  "Returns a set of the elements that the sets do not share in common."
  [sets]
  (s/difference (apply s/union sets)
                (apply s/intersection sets)))

(defn trample
  "Removes an edge from a mesh. If the edge is shared between multiple polygons
  (including the outside, if present), they will be combined into a single
  polygon. The returned mesh will always have at least one fewer polygons."
  [mesh edge]
  (let [border? #(contains? % edge)
        sharing (filter border? mesh)
        others (remove border? mesh)
        combined (sym-difference sharing)]
    (conj others combined)))

(defn best-polygon
  "Returns the polygon in the mesh that has the most connections to other
  polygons. A polygon has a single connection with another if they share one or
  more edges. An unshared edge is actually shared with the outside, #{}."
  [mesh]
  nil)

(defn main
  "Determines the minimal cost that will allow all animals to gather in one pen
  or outside all the pens given a farm and its receipt."
  [farm receipt]
  nil)

; no sharer -> remove whole pen
; combines with the outisde -> gone
; done when #pens <= 1
