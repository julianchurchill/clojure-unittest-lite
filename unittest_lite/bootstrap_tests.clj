(ns unittest-lite
  (:require [unittest-lite.unittest]))

(defn check-equals-returns-true-for-two-equal-things []
  {:result (= true (:success (check-equals 1 1))),
   :message "check-equals-returns-true-for-two-equal-things"})

(defn check-equals-returns-success-message-for-two-equal-things []
  {:result (= "check-equals success: '1' equals '1'" (:message (check-equals 1 1))),
   :message "check-equals-returns-success-message-for-two-equal-things" })

(defn check-equals-returns-false-for-two-unequal-things []
  {:result (= false (:success (check-equals 1 2))),
   :message "check-equals-returns-false-for-two-unequal-things" })

(defn check-equals-returns-failure-message-for-two-unequal-things []
  {:result (= "check-equals failed: '1' does not equal '2'" (:message (check-equals 1 2))),
   :message "check-equals-returns-failure-message-for-two-unequal-things" })

(defn failing-on-purpose []
  {:result false
   :message "failing-on-purpose"})

(defn run-bootstrap-tests [] 
  (let [results  			
        [(check-equals-returns-true-for-two-equal-things)
         (failing-on-purpose)
				 (check-equals-returns-success-message-for-two-equal-things)
	 	  	 (check-equals-returns-false-for-two-unequal-things)
  		   (check-equals-returns-failure-message-for-two-unequal-things)]]
    (let [failed (filter #(= false (:result %)) results)]
  	  (if (> (count failed) 0)
        {:overall-result false, :failed-tests failed}
        {:overall-result true}))))
