(ns aoc.day06-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.java.io :as io]
            [aoc.day06 :as day06]
            [clojure.string :as str]))

(def example-inp
  ["Time:      7  15   30"
   "Distance:  9  40  200"])

(deftest day06
  (testing "day 6 - part 1"
    (is (= 288
           (day06/part1 (str/join "\n" example-inp))))
    (is (= 503424
           (day06/part1 (slurp (io/resource "day06.txt"))))))
  (testing "day 6 - part 2"
    (is (= 71503
           (day06/part2 (str/join "\n" example-inp))))
    (is (= 32607562
           (day06/part2 (slurp (io/resource "day06.txt")))))))
