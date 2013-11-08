;;; Copyright 2013 Mitchell Kember. Subject to the MIT License.
;;; 2010 Canadian Computing Competition: Junior Division
;;; Problem J5: Knight Hop

(ns ccc.y2010.j5)

(def moves
  [[0 3 2 3 2 3 4 5]
   [3 2 1 2 3 4 3 4]
   [2 1 4 3 2 3 4 5]
   [3 2 3 2 3 4 3 4]
   [2 3 2 3 4 3 4 5]
   [3 4 3 4 3 4 5 4]
   [4 3 4 3 4 5 4 5]
   [5 4 5 4 5 4 5 6]])

(defn main
  "Calculates the minimum number of moves required to move a knight on a chess
  board from (x1,y1) to (x2,y2) without leaving the 8x8 board."
  [[x1 y1] [x2 y2]]
  ((moves (- x2 x1)) (- y2 y1)))
