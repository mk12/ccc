;;; Copyright 2013 Mitchell Kember. Subject to the MIT License.
;;; 2010 Canadian Computing Competition: Junior Division
;;; Problem J3: Punchy

(ns ccc.y2010.j3)

;;; An "instruction" is a collection of one, two, or three elements as described
;;; in the problem description. Each element is either an integer, :a, or :b.

;;; The "state" is a map consisting of the keys :a and :b for the values of
;;; those variables, and the key :out to represent the program's output so far,
;;; stored as a collection of integers.

(defn evaluate
  "Evaluates an operand in a program instruction. If it is a variable, returns
  the variable's value. If it is a number, returns the number unchanged."
  [state x]
  (or (state x) x))

(defn execute
  "Executes a punchcard instruction and returns the new state."
  [state [opcode x y]]
  (let [ex (evaluate state x)
        ey (evaluate state y)]
    (case opcode
      1 (assoc state x ey)
      2 (assoc state :out (conj (:out state) ex))
      3 (assoc state x (+ ex ey))
      4 (assoc state x (* ex ey))
      5 (assoc state x (- ex ey))
      6 (assoc state x (quot ex ey))
      state)))

(defn main
  "Runs the program described by the collection of punchcard instructions and
  returns its output as a collection of integers with one integer for each
  output command (2)."
  [instructions]
  (reduce execute {:a 0 :b 0 :out []} instructions))
