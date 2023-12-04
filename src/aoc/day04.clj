(ns aoc.day04
  (:require [clojure.string :as str]
            [clojure.set :as set]))

(defn count-winning [s]
  (let [[winning owned] (transduce
                         (comp (map #(re-seq #"\d+" %))
                               (map #(mapv parse-long %))
                               (map set))
                         conj
                         (rest (re-find #"(?<=: )(.*)\|(.*)" s)))]
    (count (set/intersection winning owned))))

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
              (filter #(not (zero? %)))
              (map #(int (Math/pow 2 (dec %)))))
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
