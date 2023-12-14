(ns aoc.day09-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.java.io :as io]
            [aoc.day09 :as day09]
            [clojure.string :as str]))

(def example-inp
  ["0 3 6 9 12 15"
   "1 3 6 10 15 21"
   "10 13 16 21 30 45"])

(deftest day09
  (testing "day 9 - part 1"
    (is (= 114
           (day09/part1 (str/join "\n" example-inp))))
    (is (= 2101499000
           (day09/part1 (slurp (io/resource "day09.txt"))))))
  (testing "day 9 - part 2"
    (is (= 2
           (day09/part2 (str/join "\n" example-inp))))
    (is (= 1089
           (day09/part2 (slurp (io/resource "day09.txt")))))))
