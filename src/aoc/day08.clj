(ns aoc.day08
  (:require [clojure.string :as str]))

(defn count-steps [start instr nodes]
  (loop [i 0
         cur start]
    (if (or (= "ZZZ" cur) (= \Z (nth cur 2)))
      i
      (recur (inc i) ((nodes cur) (nth instr (mod i (count instr))))))))

(defn lcm [x y]
  (loop [n x]
    (if (zero? (mod n y))
      n
      (recur (+ n x)))))

(defn part1 [inp]
  (let [[instr _ & nodes] (str/split-lines inp)
        instr (map #(if (= \L %) 0 1) instr)
        nodes (transduce
               (comp (map #(str/split % #" = "))
                     (map (fn [[k v]]
                            (hash-map k (mapv str (read-string v))))))
               into
               {}
               nodes)]
    (count-steps "AAA" instr nodes)))

(defn part2 [inp]
  (let [[instr _ & nodes] (str/split-lines inp)
        instr (map #(if (= \L %) 0 1) instr)
        nodes (transduce
               (comp (map #(str/split % #" = "))
                     (map (fn [[k v]]
                            (hash-map k (mapv str (read-string v))))))
               into
               {}
               nodes)]
    (->> nodes
         (keep (fn [[k _]]
                 (when (= \A (nth k 2))
                   (count-steps k instr nodes))))
         (reduce lcm))))

#_(part1 (slurp (clojure.java.io/resource "day08.txt")))
#_(part2 (slurp (clojure.java.io/resource "day08.txt")))
