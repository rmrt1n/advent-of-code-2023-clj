(ns aoc.day07
  (:require [clojure.string :as str]))

(def lookup
  {\2 2, \3 3,  \4 4,  \5 5,  \6 6,  \7 7, \8 8,
   \9 9, \T 10, \J 11, \Q 12, \K 13, \A 14})

(defn score-vector [freqs s lookup]
  (let [power (transduce
               (comp (map lookup)
                     (map-indexed (fn [i x] (* x (int (Math/pow 10 (* 2 (- 4 i))))))))
               +
               s)]
    (case (count freqs)
      5 (vector 1 power)      ;; high card
      4 (vector 2 power)      ;; 1 pair
      3 (if (some #{2} freqs)
          (vector 3 power)    ;; 2 pair
          (vector 4 power))   ;; 3 of a kind
      2 (if (some #{2} freqs)
          (vector 5 power)    ;; fullhouse
          (vector 6 power))   ;; 4 of a kind
      (vector 7 power))))     ;; 5 of a kind

(defn unjokerize [s]
  (let [freqs (frequencies s)
        no-joker (dissoc freqs \J)
        sorted (sort (mapv (fn [[k v]] (vector v (lookup k) k)) no-joker))
        joker (last (last sorted))]
    (str/replace s #"J" (str joker))))

(defn scores
  ([s lookup]
   (let [freqs (vals (frequencies s))]
     (score-vector freqs s lookup)))
  ([s lookup _joker]
   (let [freqs (vals (frequencies (unjokerize s)))]
     (score-vector freqs s lookup))))

(defn part1 [inp]
  (->> inp
       str/split-lines
       (mapv #(str/split % #" "))
       (mapv #(vector (scores (first %) lookup)
                      (parse-long (last %))))
       sort
       (transduce
        (map-indexed #(* (last %2) (inc %1)))
        +)))

(defn part2 [inp]
  (->> inp
       str/split-lines
       (mapv #(str/split % #" "))
       (mapv #(vector (scores (first %) (assoc lookup \J 1) :joker)
                      (parse-long (last %))))
       sort
       (transduce
        (map-indexed #(* (last %2) (inc %1)))
        +)))

#_(part1 (slurp (clojure.java.io/resource "day07.txt")))
#_(part2 (slurp (clojure.java.io/resource "day07.txt")))
