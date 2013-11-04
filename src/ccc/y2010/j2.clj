;;; Copyright 2013 Mitchell Kember. Subject to the MIT License.
;;; 2010 Canadian Computing Competition: Junior Division
;;; Problem J2: Up and Down

(ns ccc.y2010.j2
  (:import java.lang.Math))

(defn displacement
  "Calculates the displacement after going forward x steps and backward y steps
  repeatedly for a total of s steps."
  [x y s]
  (let [div (/ (+ x y))]
    (int (- (Math/ceil (* x div s))
            (Math/floor (* y div s))))))

(defn main
  "Returns the name of the person who has gone furthest after s steps."
  [a b c d s]
  (if (> (displacement a b s) (displacement c d s))
    "Nikki"
    "Byron"))
