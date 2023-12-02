(ns aoc.day01-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.java.io :as io]
            [aoc.day01 :as day01]
            [clojure.string :as str]))

(deftest day01
  (testing "day 1 - part 1"
    (is (= 142
           (day01/part1 (str/join "\n"
                                  ["1abc2"
                                   "pqr3stu8vwx"
                                   "a1b2c3d4e5f"
                                   "treb7uchet"]))))
    (is (= 55090
           (day01/part1 (slurp (io/resource "day01.txt"))))))

  (testing "day 1 - part 2"
    (is (= 281
           (day01/part2 (str/join "\n"
                                  ["two1nine"
                                   "eightwothree"
                                   "abcone2threexyz"
                                   "xtwone3four"
                                   "4nineeightseven2"
                                   "zoneight234"
                                   "7pqrstsixteen"]))))
    (is (= 54845
           (day01/part2 (slurp (io/resource "day01.txt")))))))
