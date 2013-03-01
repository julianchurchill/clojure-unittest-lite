(ns unittest-lite
  (:gen-class)
  (:require [unittest-lite.bootstrap_tests]))

(defn all-tests-passed []
  (print "The bootstrap tests passed!\n"))

(defn format-failure-message [message]
  (str "*** '" message "' failed\n"))

(defn tests-failed [failed-tests]
  (println (map #(format-failure-message (:message %)) failed-tests))
  (map #(println (format-failure-message (:message %))) failed-tests)
  (print (count failed-tests) "tests failed\n")
  (print "The bootstrap tests failed!\n"))

(defn -main
  "Application entry point"
  [& args]
  (print "Running the bootstrap tests...\n")
  (let [test-results (run-bootstrap-tests)]
  	(if (:overall-result test-results)
      (all-tests-passed)
      (tests-failed (:failed-tests test-results)))))
