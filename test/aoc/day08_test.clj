(ns aoc.day08-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.java.io :as io]
            [aoc.day08 :as day08]
            [clojure.string :as str]))

(deftest day08
  (testing "day 8 - part 1"
    (is (= 2
           (day08/part1 (str/join "\n"
                                  ["RL"
                                   ""
                                   "AAA = (BBB, CCC)"
                                   "BBB = (DDD, EEE)"
                                   "CCC = (ZZZ, GGG)"
                                   "DDD = (DDD, DDD)"
                                   "EEE = (EEE, EEE)"
                                   "GGG = (GGG, GGG)"
                                   "ZZZ = (ZZZ, ZZZ)"]))))
    (is (= 6
           (day08/part1 (str/join "\n"
                                  ["LLR"
                                   ""
                                   "AAA = (BBB, BBB)"
                                   "BBB = (AAA, ZZZ)"
                                   "ZZZ = (ZZZ, ZZZ)"]))))
    (is (= 12599
           (day08/part1 (slurp (io/resource "day08.txt"))))))
  (testing "day 8 - part 2"
    (is (= 6
           (day08/part2 (str/join "\n"
                                  ["LR"
                                   ""
                                   "LLA = (LLB, XXX)"
                                   "LLB = (XXX, LLZ)"
                                   "LLZ = (LLB, XXX)"
                                   "GGA = (GGB, XXX)"
                                   "GGB = (GGC, GGC)"
                                   "GGC = (GGZ, GGZ)"
                                   "GGZ = (GGB, GGB)"
                                   "XXX = (XXX, XXX)"]))))
    (is (= 8245452805243
           (day08/part2 (slurp (io/resource "day08.txt")))))))
