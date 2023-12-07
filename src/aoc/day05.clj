(ns aoc.day05
  (:require
   [clojure.string :as str]))

(defn parse-inp [[seeds & maps]]
  (let [seeds (mapv parse-long (re-seq #"\d+" seeds))
        maps  (->> maps
                   (map #(str/split % #":\s"))
                   (map #(mapv (fn [s] (mapv parse-long (str/split s #" ")))
                               (str/split (second %) #"\n"))))]
    (loop [[step & rest'] maps
           acc seeds]
      (if-not step
        (apply min acc)
        (recur rest' (mapv abs (reduce (fn [coll [dst src len]]
                                         (map #(if (and (pos? %)
                                                        (<= src % (+ src len -1)))
                                                 (- (+ dst (- % src)))
                                                 %)
                                              coll))
                                       acc
                                       step)))))))

(defn part1 [inp]
  (->> (str/split inp #"\n\n")
       parse-inp))

;; out of memory error (java heap)
(defn part2 [inp]
  (let [[seeds & maps]  (str/split inp #"\n\n")
        seeds (->> seeds
                   (re-seq #"\d+")
                   (map parse-long)
                   (partition 2)
                   (mapcat #(range (first %) (+ (first %) (last %))))
                   set)
        maps  (->> maps
                   (transduce
                    (comp (map #(str/split % #":\s"))
                          (map #(mapv (fn [s]
                                        (mapv parse-long (str/split s #" ")))
                                      (str/split (second %) #"\n"))))
                    conj))]

    (loop [[step & rest'] maps
           acc seeds]
      (if-not step
        (apply min acc)
        (recur rest' (mapv abs (reduce (fn [coll [dst src len]]
                                         (map #(if (and (pos? %)
                                                        (<= src % (+ src len -1)))
                                                 (- (+ dst (- % src)))
                                                 %)
                                              coll))
                                       acc
                                       step)))))))

#_(part1 (slurp (clojure.java.io/resource "day05.txt")))
#_(part2 (slurp (clojure.java.io/resource "day05.txt")))
