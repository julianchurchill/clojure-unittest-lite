(ns unittest-lite)


(defn result-message [result a b]
  (if result
    (str "check-equals success: '" a "' equals '" b "'")
    (str "check-equals failed: '" a "' does not equal '" b "'")))

(defn check-equals [a b]
  (let [result (= a b)]
    {:success result,
     :message (result-message result a b)}))


