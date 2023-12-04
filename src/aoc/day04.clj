(ns aoc.day04
  (:require [clojure.string :as str]))

(defn count-winning [s]
  (let [[winning owned] (map #(re-seq #"\d+" %) (str/split s #"\|"))
        winning (rest (map parse-long winning))
        owned   (map parse-long owned)]
    (->> owned
         (filter #(some (hash-set %) winning))
         count)))

(defn rec-count [coll]
  (loop [[first' & rest'] coll
         freq (frequencies (range 1 (inc (count coll))))]
    (if-not first'
      (apply + (vals freq))
      (if (= 1 (count first'))
        (recur rest' freq)
        (let [[i & nums] first']
          (recur rest' (assoc freq i (reduce #(+ %1 (freq %2)) 1 nums))))))))

(defn part1 [inp]
  (->> inp
       str/split-lines
       (transduce
        (comp (map count-winning)
              (map dec)
              (filter #(not (neg? %)))
              (map #(int (Math/pow 2 %))))
        +)))

(defn part2 [inp]
  (->> inp
       str/split-lines
       (transduce
        (comp (map count-winning)
              (map-indexed #(range (inc %1) (+ 2 %1 %2))))
        conj)
       reverse
       rec-count))

#_(part1 (slurp (clojure.java.io/resource "day04.txt")))
#_(part2 (slurp (clojure.java.io/resource "day04.txt")))
